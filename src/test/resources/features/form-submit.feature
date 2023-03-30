#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  #Esquema de Cenário: enviar as informações inseridas com sucesso
  #Dado que estou na página de demonstração
  #Quando eu insiro o nome do usuário <nome>
  #E insiro o sobrenome <sobrenome>
  #E insiro o e-mail <email>
  #E insiro o nome de sua empresa <empresa>
  #]
  #
  #Exemplos:
  #| nome            | sobrenome | email                           | empresa           |
  #| "Dmitr Vladmir" | "Markolv" | "automation.dvmrkolv@gmail.com" | "KGB"             |
  Cenário: envio as informações com sucesso
    Dado que estou na página de demonstração
    E eu insiro o nome do usuário "Dmitr Vladmir"
    E insiro o sobrenome "Markolv"
    E insiro o e-mail "automation.dvmrkolv@gmail.com"
    E insiro o nome de sua empresa "KGB"
    E soluciono o enigma
    Quando clico em submeter
    Então As informações foram enviadas com sucesso!
