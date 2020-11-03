package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BankManagerLoginPage;
import pages.CustomerLoginPage;

public class ManterContaStep {

    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    @Quando("preencho o campo de {string} com o cliente {string}")//usado
    public void preencho_o_campo_de_com_o_cliente(String customer, String fistName) {
        bankManagerLoginPage.escreverCustomer(fistName);
    }

    @Quando("eu seleciono {string} como forma de pagamento em Currency")//usado
    public void eu_seleciono_como_forma_de_pagamento_em_currency(String string) {
        bankManagerLoginPage.escreverCurrency();
    }

    @Então("a conta do cliente deve ser criada com sucesso.")//usado
    public void a_conta_do_cliente_deve_ser_criada_com_sucesso() {
       Assert.assertEquals("Account created successfully with account Number :1016", bankManagerLoginPage.cadastrado());
       bankManagerLoginPage.fecharAlerta();
       bankManagerLoginPage.clicarPorTexto("Customers");
       bankManagerLoginPage.searchCustomer("marlo");
      Assert.assertEquals("1016", bankManagerLoginPage.searchCustomerResult("1016"));
    }

    @Então("devo ver minhas informações bancarias")//usado
    public void devo_ver_minhas_informações_bancarias() {
        Assert.assertTrue(customerLoginPage.informacoesBancarias("1016 "));
        Assert.assertTrue(customerLoginPage.informacoesBancarias("Dollar"));
    }

    @Quando("eu clico em {string} para depositar")//usado
    public void eu_clico_em_para_depositar(String texto) {
       customerLoginPage.clicarPorTexto(texto);
    }
    @Quando("insiro o valor {string} no campo deposito")//usado
    public void insiro_o_valor_no_campo_deposito(String valor) {
        customerLoginPage.inserirValorDeposito(valor);
    }

    @Quando("clico em depositar")//usado
    public void clico_em_depositar() {
        customerLoginPage.botaoForm();
    }

    @Então("deve ser exibido a mensagem deposito com sucesso {string} {string}")//usado
    public void deve_ser_exibido_a_mensagem_deposito_com_sucesso(String string, String dinheiro) {
        Assert.assertTrue(customerLoginPage.depositoSucesso());
        Assert.assertTrue(customerLoginPage.informacoesBancarias(dinheiro));

    }

    @Então("a transação de deposito deve ser registrada {string}")//usado
    public void a_transação_de_deposito_deve_ser_registrada(String dinheiro) throws InterruptedException {
        new Thread().sleep(500);
        customerLoginPage.botoesCustomerLogin("Transactions");
        Assert.assertEquals(dinheiro,customerLoginPage.valorTransacao());
        Assert.assertEquals("Credit", customerLoginPage.tipoTransacao());
    }

    @Quando("eu clico em {string} para retirar")//usado
    public void eu_clico_em_para_retirar(String texto) throws InterruptedException {
        new Thread().sleep(500);
        customerLoginPage.clicarPorTexto(texto);
    }

    @Quando("insiro o valor {string} no campo retirada")//usado
    public void insiro_o_valor_no_campo_retirada(String valor) throws InterruptedException {
        new Thread().sleep(500);
        customerLoginPage.inserirValorRetirada(valor);
    }

    @Quando("clico no botao retirada")//usado
    public void clico_no_botao_retirada(){
        customerLoginPage.botaoForm();
    }

    @Então("deve ser exibida a mensagem retidada com sucesso {string}")//usado
    public void deve_ser_exibida_a_mensagem_retidada_com_sucesso(String string){
        Assert.assertTrue(customerLoginPage.transationSucesso());
    }

    @Então("o saldo disponivel deve ser {string}")//usado
    public void o_saldo_disponivel_deve_ser(String valor) {
        Assert.assertTrue(customerLoginPage.informacoesBancarias(valor));
    }

    @Então("a transação de retirada deve ser registrada {string}")//usado
    public void a_transação_de_retirada_deve_ser_registrada(String valor) throws InterruptedException {
        new Thread().sleep(500);
        customerLoginPage.botoesCustomerLogin("Transactions");
        Assert.assertEquals(valor,customerLoginPage.valorTransacao());
        Assert.assertEquals("Debit", customerLoginPage.tipoTransacao());
    }

    @Então("deve ser exibida a mensagem retidada com falha {string}")//usado
    public void deve_ser_exibida_a_mensagem_retidada_com_falha(String string) throws InterruptedException {
        new Thread().sleep(500);
        Assert.assertTrue(customerLoginPage.transationFalha());
    }

    @Então("o valor do saldo disponivel deve continuar sendo {string}")//usado
    public void o_valor_do_saldo_disponivel_deve_continuar_sendo(String valor) {
        Assert.assertTrue(customerLoginPage.informacoesBancarias(valor));
    }



}
