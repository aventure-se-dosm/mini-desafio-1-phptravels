#language:pt
Funcionalidade: Requisitar demonstração do site
  Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  @ID_0001
  Cenário: envio as informações com sucesso
    Dado que estou na página de demonstração
    E preencho todo o formulário
    E soluciono o enigma
    E clico em submeter
    Então As informações foram enviadas com sucesso!

  @ID_0002
  Cenário: falha: enigma não-solucionado
    Dado que estou na página de demonstração
    E preencho todo o formulário
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please input result number"

  @ID_0003
  Cenário: falha: txtFirstNameInput não preenchido
    Dado que estou na página de demonstração
    E insiro o sobrenome do usuário
    E insiro o nome da empresa do usuário
    E insiro o e-mail do usuário
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please type your first name"

  @ID_0004
  Cenário: falha: txtLastNameInput não-preenchido
    Dado que estou na página de demonstração
    E insiro o nome do usuário
    E insiro o nome da empresa do usuário
    E insiro o e-mail do usuário
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please type your last name"

  @ID_0005
  Cenário: falha: txtBusinessNameInput não-preenchido
    Dado que estou na página de demonstração
    E insiro o nome do usuário
    E insiro o sobrenome do usuário
    E insiro o e-mail do usuário
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please type your business name"

  @ID_0006
  Cenário: falha: txtEmailAddressInput não-preenchido
    Dado que estou na página de demonstração
    E insiro o nome do usuário
    E insiro o sobrenome do usuário
    E insiro o nome da empresa do usuário
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please type your email name"
