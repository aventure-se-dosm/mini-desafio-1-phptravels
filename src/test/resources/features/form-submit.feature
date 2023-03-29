#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  Esquema do Cenário: enviar as informações inseridas
    Dado que estou na página de demonstração
    E eu insiro o nome do usuário <nome>
    E insiro o sobrenome <sobrenome>
    E insiro o e-mail <email>
    E insiro o nome de sua empresa <empresa>

    Exemplos: 
      | <nome>        | <sobrenome> | <email>                       | <empresa> |
      | Dmitr Vladmir | Markolv     | automation.dvmrkolv@gmail.com | KGB       |

  Cenário: envio as informações com sucesso
    Quando soluciono o enigma
    E clico em submeter
    Então As informações foram enviadas com sucesso!
    
# E o título da página é ...
# E a mensagem ... é exibida
# E o elemento ... da página é visível
# E o elemento ... da página está presente





#
     #Cenário: falho na solução do enigma
    #Quando não soluciono o enigma
    #E clico em submeter
    #Então nada acontece 
# E a mensagem ... é exibida