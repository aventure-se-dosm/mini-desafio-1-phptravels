#language:pt
Funcionalidade: Enviar formulário
  Como um usuário
  Eu desejo preencher o formuário da página
  Para enviar as informações com sucesso

  Fundo: obtem as informações do usuario

  Esquema do Cenário: formulário enviado com sucesso
    * o usuário escolhido é de índice <indice>
    * que estou na página de demonstração
    * eu insiro o nome do usuário
    * insiro o sobrenome
    * insiro o e-mail
    * insiro o nome de sua empresa
    * soluciono o enigma
    * clico em submeter
    * As informações foram enviadas com sucesso!

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
    * o usuário escolhido é de índice <indices>
    * que estou na página de demonstração
    * eu insiro o nome do usuário
    * insiro o sobrenome
    * insiro o e-mail
    * insiro o nome de sua empresa
    * clico em submeter
    * Um alerta é exibido com a mensagem "Please input result number"

    @EmptyEnigmaField
    Exemplos: 
      | indices |
      | 8       |
