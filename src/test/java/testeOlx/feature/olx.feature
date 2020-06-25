#language:pt
@olx
Funcionalidade: Teste site olx


  Esquema do Cenario: Realizar login com ERRO
    Quando usuario acessa o site da olx
    E clica no botão entrar
    E preenche o campo email <email>
    E preenche o campo senha <senha>
    E clica em entrar para logar
    Então verifica se o login foi rejeitado com uma mensagem de alerta <mensagem>

    Exemplos: Parametros utilizados
      | email             | senha | mensagem                              |
      | xxxx@gmail.com.br | xxxx  | Não existe uma conta com este e-mail. |


  Esquema do Cenario: Realizar login com SUCESSO
    Quando usuario acessa o site da olx
    E clica no botão entrar
    E preenche o campo email <email>
    E preenche o campo senha <senha>
    E clica em entrar para logar
    Então verifica se o login foi realizado verificando usuario logado <user>
    E realiza o logoff

    Exemplos: Parametros utilizados
      | email                         | senha         | user           |
      | testequalidadetotvs@gmail.com | Qualidade@123 | testequalidade |

  Esquema do Cenario: Realizar a busca de um item e favoritar

    Quando usuario acessa o site da olx
    E clica no botão entrar
    E preenche o campo email <email>
    E preenche o campo senha <senha>
    E clica em entrar para logar
    E clica no botão Buscar
    E selecionar o estado <estado>
    E Validadar se o estado selecionado <estado>
    E Para realizar a busca no estado selecionado <abreviaturaEstado> preencho o campo buscar com a palavra chave <palavrachave>
    E verificar se a busca retornou o esperado <palavrachave>
    E clicar no primeiro item do retono da busca
    E validar o item e guardar um print
    E marcar o item como favorito
    E fechar a aba aberta
    Então realiza o logoff

    Exemplos: Parametros utilizados
      | email                         | senha         | estado    | abreviaturaEstado | palavrachave |
      | testequalidadetotvs@gmail.com | Qualidade@123 | São Paulo | sp                | camisa       |

  Esquema do Cenario: desfavoritar o item

    Quando usuario acessa o site da olx
    E clica no botão entrar
    E preenche o campo email <email>
    E preenche o campo senha <senha>
    E clica em entrar para logar
    E clica no botão favoritos
    E excluir o item favoritos
    Então realiza o logoff

    Exemplos: Parametros utilizados
      | email                         | senha         |
      | testequalidadetotvs@gmail.com | Qualidade@123 |