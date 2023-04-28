#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  Fundo: 
    Dado que estou na página de demonstração
    Quando eu insiro as informações do usuário

  @ID_0001
  Cenário: 0001 formulário enviado com sucesso
    E soluciono o enigma
    E clico em submeter
    Então As informações foram enviadas com sucesso!

  @ID_0002
  Cenário: 0002 erro do campo para a solução do enigma estar vazio
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please input result number"
