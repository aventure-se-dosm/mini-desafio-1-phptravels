#language: pt
Funcionalidade: Requisitar denonstração do site
  Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da págin
  Para enviar as informações com sucesso

  @ID_0001
  Cenário: envio as informações com sucesso
    Dado que estou na página 'demo'
    E insiro o nome do usuário no campo 'First Name'
    E insiro o sobrenome do usuário no campo 'Last Name'
    E insiro o nome da empresa do usuário no campo 'Business Name'
    E insiro o e-mail do usuário no campo 'Email'
    E soluciono o enigma
    E clico no botão 'Submit'
    Então As informações foram enviadas com sucesso!

  @ID_0002
  Cenário: falha: enigma não-solucionado
    Dado que estou na página 'demo'
    E preencho todo o formulário
    E clico no botão 'Submit'
    Então Um alerta é exibido com a mensagem "Please input result number"

  @ID_0003
  Cenário: falha: txtFirstNameInput não preenchido
    Dado que estou na página 'demo'
    E insiro o sobrenome do usuário no campo 'Last Name'
    E insiro o nome da empresa do usuário no campo 'Business Name'
    E insiro o e-mail do usuário no campo 'Email'
    E clico no botão 'Submit'
    Então Um alerta é exibido com a mensagem "Please type your first name"

  @ID_0004
  Cenário: falha: txtLastNameInput não-preenchido
    Dado que estou na página 'demo'
    E insiro o nome do usuário no campo 'First Name'
    E insiro o nome da empresa do usuário no campo 'Business Name'
    E insiro o e-mail do usuário no campo 'Email'
    E clico no botão 'Submit'
    Então Um alerta é exibido com a mensagem "Please type your last name"

  @ID_0005
  Cenário: falha: txtBusinessNameInput não-preenchido
    Dado que estou na página 'demo'
    E insiro o nome do usuário no campo 'First Name'
    E insiro o sobrenome do usuário no campo 'Last Name'
    E insiro o e-mail do usuário no campo 'Email'
    E clico no botão 'Submit'
    Então Um alerta é exibido com a mensagem "Please type your business name"

  @ID_0006
  Cenário: falha: txtEmailAddressInput não-preenchido
    Dado que estou na página 'demo'
    E insiro o nome do usuário no campo 'First Name'
    E insiro o sobrenome do usuário no campo 'Last Name'
    E insiro o nome da empresa do usuário no campo 'Business Name'
    E clico no botão 'Submit'
    Então Um alerta é exibido com a mensagem "Please type your email name"
