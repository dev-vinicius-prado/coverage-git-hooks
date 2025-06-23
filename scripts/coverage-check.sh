#!/bin/bash

echo ":passport_control: VERIFICANDO COBERTURA DETALHADA DO CÓDIGO"
echo "============================================================"

# Função para obter a cobertura atual
get_coverage() {
  mvn clean test jacoco:report -q > /dev/null 2>&1
  if [ -f "target/site/jacoco/index.html" ]; then
      grep -A1 '<td>Total</td>' target/site/jacoco/index.html | \
         grep -o '[0-9]\+%' | head -1 | tr -d '%'
  else
      echo 0
  fi
}

# Função para obter a cobertura de uma branch
get_branch_coverage() {
  local branch=$1
  echo ":mag: Verificando cobertura da branch $branch..."

  # Salva o estado atual
  git stash push -m "temp-coverage-check" > /dev/null 2>&1

  # Faz checkout na branch
  git checkout $branch > /dev/null 2>&1

  local coverage=0
  if [ $? -eq 0 ]; then
      coverage=$(get_coverage)
      echo ":bar_chart: Cobertura da branch $branch: ${coverage}%"
      else
      echo ":x: Falha ao fazer checkout na branch $branch. Verifique se ela existe."
  fi

  # Volta ao estado anterior
  git checkout - > /dev/null 2>&1
  # Só faz pop se houver stash
  git stash list | grep -q "temp-coverage-check" && git stash pop > /dev/null 2>&1
  echo "Cobertura obtida: ${coverage}%"
}

# Informação gerais
echo ":information_source: Informações do projeto: "
echo "  - Projeto: $(basename $(pwd))"
echo "  - Branch atual: $(git rev-parse --abbrev-ref HEAD)"
echo "  - Último commit: $(git log -1 --pretty=format:'%h - %s')"
echo "  - Autor do último commit: $(git log -1 --pretty=format:'%an')"
echo "============================================================="


# Verifica a cobertura da branch atual
echo ":dart: Verificando cobertura da branch atual..."

CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
CURRENT_COVERAGE=$(get_coverage)

echo " Branch: $CURRENT_BRANCH"
echo " Cobertura atual: ${CURRENT_COVERAGE}%"

# Análise da branch develop
if git rev-parse --verify develop > /dev/null 2>&1; then
    echo ":dart: Verificando cobertura da branch develop..."

    DEVELOP_COVERAGE=$(get_branch_coverage "develop")

    # Compara a cobertura atual com a da branch develop
    DIFF=$((CURRENT_COVERAGE - DEVELOP_COVERAGE))
    echo ""
    echo " :bar_chart: COMPARAÇÃO DE COBERTURA:"
    echo "  - Cobertura da branch develop: ${DEVELOP_COVERAGE}%"
    echo "  - Cobertura atual: ${CURRENT_COVERAGE}%"
    echo "  - Diferença: ${DIFF}%"

    if [ $DIFF -gt 0 ]; then
        echo " :tada: A cobertura atual!"
    elif [ $DIFF -eq 0 ]; then
        echo " :warning: A cobertura atual foi mantida."
    else
        echo " :x: A cobertura atual diminuiu em $((-DIFF))% em relação à branch develop."
    fi
fi

























