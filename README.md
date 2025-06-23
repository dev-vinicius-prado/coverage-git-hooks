# 🚦 coverage-git-hooks

> 🦸‍♂️ Proteja a qualidade do seu código como um verdadeiro Guardião do Repositório!

## ✨ O que é?

O **coverage-git-hooks** é um conjunto de hooks Git para projetos Java/Maven que impede quedas drásticas na cobertura de testes automatizados. Antes de cada commit, o hook verifica a cobertura com o JaCoCo e só deixa passar se você não estiver deixando bugs escaparem pelo multiverso! 🕸️

## 🚀 Como funciona?

1. **Pré-commit** executa os testes e gera o relatório JaCoCo.
2. Compara a cobertura atual com o baseline salvo.
3. Se a cobertura cair mais de 3%, o commit é bloqueado! 🛡️
4. Se melhorar ou se manter, o baseline é atualizado.  
5. Mensagens motivacionais e feedbacks em tempo real no terminal! 🖖

## 🛠️ Instalação

Clone o repositório e no terminal, execute:

```bash
sh ./scripts/install-hooks.sh
```

Certifique-se de ter o Maven instalado e o JaCoCo configurado no seu pom.xml.


🧙‍♂️ Por que usar?

* Evite que a cobertura caia sem perceber (como um bug sorrateiro do Loki 🦹‍♂️).
* Incentive o time a manter o padrão Jedi de qualidade! ✨
* Automatize a cobrança de qualidade sem virar o vilão do time. 😅

🤝 Contribua!

Curtiu?

Abra uma issue, envie um PR ou compartilhe ideias!
Vamos juntos tornar o universo Java mais seguro, um commit por vez! 🚀

<img src="https://img.shields.io/github/stars/dev-vinicius-prado/coverage-git-hooks?style=social" alt="GitHub stars"></img>


“Com grandes commits vêm grandes responsabilidades.” 🕷️


📜 Licença MIT - Feito com 💚 por Vinicius Prado