#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  Cenário: 0001 envio as informações com sucesso
    Dado que estou na página de demonstração
    Quando eu insiro o nome do usuário "Dmitr Vladmir"
    E insiro o sobrenome "Markolv"
    E insiro o e-mail "automation.dvmrkolv@gmail.com"
    E insiro o nome de sua empresa "KGB"
    E soluciono o enigma
    E clico em submeter
    Então As informações foram enviadas com sucesso!
