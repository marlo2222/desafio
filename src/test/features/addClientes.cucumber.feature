#language: pt
#Author: Marlo Henrique

@AdicionarClientes
Funcionalidade: Adicionar clientes ao sistema.
  Como um usuario
  Eu quero poder me cadastrar no sistema.
  Para poder abrir uma conta

  Contexto: Adicionar usuario
    Dado que acesso o link "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    Quando visualizo as opções "Customer Login" e "Bank Manager Login"
    Então eu clico em "Bank Manager Login"


    Cenario: Devo cadastrar um novo usuario com sucesso
      Dado que estou acessando a opção Bank Manager Login
      Quando seleciono a opção "Add Customer"
      E preencho os campos <fistname>, <lastname> e <postcode>
      E clico no botão "Add Customer" para salvar
      Então um novo usuario deve ser cadastrado com sucesso

      Exemplos:
        | fistname | lastname | postcode |
        | "Marlo"  |"Henrique"|"62900000"|


    Cenario: Não deve cadastrar um usuario com informações ja existentes
      Dado que estou acessando a opção Bank Manager Login
      Quando seleciono a opção "Add Customer"
      E preencho os campos <fistname>, <lastname> e <postcode>
      E clico no botão "Add Customer" para salvar
      Então um novo usuario deve ser cadastrado com sucesso
      Quando preencho os campos <fistname>, <lastname> e <postcode>
      E clico no botão "Add Customer" para salvar
      Então o usuario não deve ser cadastrado
      E um alerta com o seguinte texto é exibido "Please check the details. Customer may be duplicate."

      Exemplos:
        | fistname | lastname | postcode |
        | "Marlo"  |"Henrique"|"62900000"|

