#language: pt
#Author: Marlo Henrique

@AdicionarClientes
Funcionalidade: Adicionar clientes ao sistema.
  Como um usuario
  Eu quero poder me cadastrar no sistema.
  Para poder abrir uma conta

  Contexto: Acessa Aplicação
    Dado que acesso o link "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    Quando visualizo as opções "Customer Login" e "Bank Manager Login"
    Então eu clico em "Customer Login"


    Cenario: Devo cadastrar um novo usuario com sucesso
      Quando eu clico em "Home"
      E eu clico em "Bank Manager Login"
      E seleciono a opção "Add Customer"
      E preencho os campos <fistname>, <lastname> e <postcode>
      E clico no botão "Add Customer" para salvar
      Então um novo usuario deve ser cadastrado com sucesso

      Exemplos:
        | fistname | lastname | postcode |
        | "marlo"  |"menrique"|"62900000"|


     Cenario: devo poder realizar login no sistema:
       Quando eu clico em "Home"
       E eu clico em "Bank Manager Login"
       E seleciono a opção "Add Customer"
       E preencho os campos <fistname>, <lastname> e <postcode>
       E clico no botão "Add Customer" para salvar
       Então um novo usuario deve ser cadastrado com sucesso
       Quando eu clico em "Home"
       E eu clico em "Customer Login"
       E escolho o usuario "marlo henrique" no campo Your Name
       Então o botão "Login" deve ser habilitado
       Quando eu clico em "Login"
       Então deve ser ser exibido a mensagem de boas vindas

        Exemplos:
         | fistname | lastname | postcode |
         | "marlo"  |"henrique"|"62900000"|

      Cenario: devo poder realizar logout no sistema:
        Quando eu clico em "Home"
        E eu clico em "Bank Manager Login"
        E seleciono a opção "Add Customer"
        E preencho os campos <fistname>, <lastname> e <postcode>
        E clico no botão "Add Customer" para salvar
        Então um novo usuario deve ser cadastrado com sucesso
        Quando eu clico em "Home"
        E eu clico em "Customer Login"
        E escolho o usuario <fistname>, <lastname> no campo Your Name
        Então o botão "Login" deve ser habilitado
        Quando eu clico em "Login"
        Então deve ser ser exibido a mensagem de boas vindas
        Quando eu clico no botão "Logout"
        Então o botão "Login" deve estar desabilitado
        E devo ser sair do sistema


       Exemplos:
         | fistname | lastname | postcode |
         | "marlo"  |"henrique"|"62900000"|

      Cenario: devo remover um cliente cadastrado no sistema:
        Quando eu clico em "Home"
        E eu clico em "Bank Manager Login"
        Quando seleciono a opção "Add Customer"
        E preencho os campos <fistname>, <lastname> e <postcode>
        E clico no botão "Add Customer" para salvar
        Então um novo usuario deve ser cadastrado com sucesso
        Quando seleciono a opção "Customers"
        E pesquiso pelo cliente <fistname> no campo search customer.
        E clico no botão "Delete" para remover o cliente
        Então o cliente <fistname> deve ser removido com sucesso

         Exemplos:
           | fistname | lastname | postcode |
           | "marlo"  |"henrique"|"62900000"|


      Cenario: Não deve cadastrar um usuario com informações ja existentes
         Quando eu clico em "Home"
         E eu clico em "Bank Manager Login"
         E seleciono a opção "Add Customer"
         E preencho os campos <fistname>, <lastname> e <postcode>
         E clico no botão "Add Customer" para salvar
         Então um novo usuario deve ser cadastrado com sucesso
         Quando preencho os campos <fistname>, <lastname> e <postcode>
         E clico no botão "Add Customer" para salvar
         Então o usuario não deve ser cadastrado
         E um alerta com o seguinte texto é exibido "Please check the details. Customer may be duplicate."

        Exemplos:
          | fistname | lastname | postcode |
          | "marlo"  |"henrique"|"62900000"|



