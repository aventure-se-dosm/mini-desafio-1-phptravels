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
    E soluciono o enigma
    E clico em submeter
    Então As informações foram enviadas com sucesso!

    Exemplos: 
      | indice |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
      | 6      |
      | 7      |

  @EmptyEnigmaField
  Esquema do Cenário: erro do campo para a solução do enigma estar vazio
    Dado o usuário escolhido é de índice <indices>
    E que estou na página de demonstração
    Quando eu insiro o nome do usuário
    E insiro o sobrenome
    E insiro o e-mail
    E insiro o nome de sua empresa
    E clico em submeter
    Então Um alerta é exibido com a mensagem "Please input result number"

    @EmptyEnigmaField
    Exemplos: 
      | indices |
      | 8       |