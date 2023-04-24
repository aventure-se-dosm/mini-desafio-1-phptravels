#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  Esquema do Cenário: formulário enviado com sucesso
    Dado o usuário escolhido é de índice <indice>
    E que estou na página de demonstração
    Quando eu insiro o nome do usuário
    E insiro o sobrenome
    E insiro o e-mail
    E insiro o nome de sua empresa

    Exemplos: 
      | indice |
      | 1      |

  #| 2      |
  #| 3      |
  #| 4      |
  #| 5      |
  #| 6      |
  #| 7      |
  Cenário: 0001 as informações do usuario foram enviadas com sucesso
    E clico em submeter
    Então As informações foram enviadas com sucesso!
