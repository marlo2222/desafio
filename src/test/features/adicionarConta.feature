#language: pt
#Author: Marlo Henrique

Funcionalidade: abrir uma conta.
  Como um usuario
  Eu quero poder abrir uma conta.
  Para poder realizar operações financeiras.

  Contexto: Acessa Aplicação
    Dado que acesso o link "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    Quando visualizo as opções "Customer Login" e "Bank Manager Login"
    Então eu clico em "Customer Login"



     Cenario: abrir uma conta para um novo cliente
       Quando eu clico em "Home"
       E eu clico em "Bank Manager Login"
       E seleciono a opção "Add Customer"
       E preencho os campos <fistname>, <lastname> e <postcode>
       E clico no botão "Add Customer" para salvar
       Então um novo usuario deve ser cadastrado com sucesso
       Quando eu clico na opção "Open Account"
       E preencho o campo de "Customer" com o cliente <fistname>
       E eu seleciono "Dollar" como forma de pagamento em Currency
       E toco no botão "Process"
       Então a conta do cliente deve ser criada com sucesso.
       Exemplos:
         | fistname | lastname | postcode |
         | "marlo"  |"henrique"|"62900000"|

     Cenario: Realizar deposito para a conta de um cliente
       Quando eu clico em "Home"
       E eu clico em "Bank Manager Login"
       E seleciono a opção "Add Customer"
       E preencho os campos <fistname>, <lastname> e <postcode>
       E clico no botão "Add Customer" para salvar
       Então um novo usuario deve ser cadastrado com sucesso
       Quando eu clico na opção "Open Account"
       E preencho o campo de "Customer" com o cliente <fistname>
       E eu seleciono "Dollar" como forma de pagamento em Currency
       E toco no botão "Process"
       Então a conta do cliente deve ser criada com sucesso.
       Quando eu clico em "Home"
       E eu clico em "Customer Login"
       E escolho o usuario "marlo henrique" no campo Your Name
       Então o botão "Login" deve ser habilitado
       Quando eu clico em "Login"
       Então deve ser ser exibido a mensagem de boas vindas
       E devo ver minhas informações bancarias
       Quando eu clico em "Deposit"
       E insiro o valor <dinheiro> no campo amount
       E clico no botao "Deposit"
       Então deve ser exibido a mensagem "Deposit Successful"

    Exemplos:
      | fistname | lastname | postcode | dinheiro|
      | "marlo"  |"henrique"|"62900000"|   "100" |

  Cenario: Realiza saque na conta de um cliente:
    Quando eu clico em "Home"
    E eu clico em "Bank Manager Login"
    E seleciono a opção "Add Customer"
    E preencho os campos <fistname>, <lastname> e <postcode>
    E clico no botão "Add Customer" para salvar
    Então um novo usuario deve ser cadastrado com sucesso
    Quando eu clico na opção "Open Account"
    E preencho o campo de "Customer" com o cliente <fistname>
    E eu seleciono "Dollar" como forma de pagamento em Currency
    E toco no botão "Process"
    Então a conta do cliente deve ser criada com sucesso.
    Quando eu clico em "Home"
    E eu clico em "Customer Login"
    E escolho o usuario "marlo henrique" no campo Your Name
    Então o botão "Login" deve ser habilitado
    Quando eu clico em "Login"
    Então deve ser ser exibido a mensagem de boas vindas
    E devo ver minhas informações bancarias
    Quando eu clico em "Deposit"
    E insiro o valor <dinheiro> no campo amount
    E clico no botao "Deposit"
    Então deve ser exibido a mensagem "Deposit Successful"
    Quando eu clico em "Withdrawl"
    E insiro o valor <dinheiroSaque> no campo amount
    E clico no botao "Withdraw"
    Então deve ser exibida a mensagem "Transaction successful"

    Exemplos:
      | fistname | lastname | postcode | dinheiro| dinheiroSaque |
      | "marlo"  |"henrique"|"62900000"|   "100" |    "50"       |