#!/bin/bash

echo ":gear: INSTALANDO GIT HOOKS PARA MONITORAMENTO DE CÓDIGO"
echo "========================================================"

# Verifica se está na raiz do projeto
if [ ! -f "pom.xml" ]; then
  echo ":x: Execute o script na raiz do projeto (onde está o pom.xml)."
  exit 1
fi

# Cria o diretório de hooks se não existir
mkdir -p .git/hooks

# Lista os hooks que serão instalados
HOOKS=("pre-commit" "post-merge" "pre-push" "commit-msg")

echo "Instalando os hooks:"
for hook in "${HOOKS[@]}"; do
  if [ -f "hooks/$hook" ]; then
    cp "hooks/$hook" ".git/hooks/$hook"
    chmod +x ".git/hooks/$hook"
    echo ":checkered_flag: $hook instalado com sucesso!"
  else
    echo ":warning: Hook $hook não encontrado em hooks/"
  fi
done

# Torna o script executável
echo ""
echo ":memo: Configurando scripts de apoio..."
chmod +x scripts/*.sh
echo ":white_check_mark: Scripts configurados com sucesso!"

# Executa a primeira verificação
echo ""
echo ":mag: Executando verificação inicial de código..."
mvn clean test jacoco:report -q

if [ $? -eq 0 ]; then
    # Cria baseline inicial
    INITIAL_COVERAGE=$(grep -o "Total.*[0-9]\+\.[0-9]\+%" target/site/jacoco/index.html | grep -o "[0-9]\+" | head -1)
    echo "$INITIAL_COVERAGE" > .coverage-baseline
    echo ":tada: Baseline de cobertura criada ${INITIAL_COVERAGE} com sucesso!"

    else
      echo ":x: Falha ao executar a verificação inicial de código. Verifique os erros acima."
fi

echo ""
echo ":rocket: Instalação de hooks concluída com sucesso!"
echo "==================================================="
