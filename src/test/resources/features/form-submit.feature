#language:pt
Funcionalidade: 
  
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
