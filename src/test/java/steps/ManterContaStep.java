package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BankManagerLoginPage;
import pages.CustomerLoginPage;

public class ManterContaStep {

    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    @Quando("eu clico na opção {string}")
    public void eu_clico_na_opção(String openAcont) {
        bankManagerLoginPage.clicarPorTexto(openAcont);
    }

    @Quando("preencho o campo de {string} com o cliente {string}")
    public void preencho_o_campo_de_com_o_cliente(String customer, String fistName) {
        bankManagerLoginPage.escreverCustomer(fistName);
    }

    @Quando("eu seleciono {string} como forma de pagamento em Currency")
    public void eu_seleciono_como_forma_de_pagamento_em_currency(String string) {
        bankManagerLoginPage.escreverCurrency();
    }

    @Quando("toco no botão {string}")
    public void toco_no_botão(String process) {
        bankManagerLoginPage.clicarPorTexto(process);
    }

    @Então("a conta do cliente deve ser criada com sucesso.")
    public void a_conta_do_cliente_deve_ser_criada_com_sucesso() {
       Assert.assertEquals("Account created successfully with account Number :1016", bankManagerLoginPage.cadastrado());
       bankManagerLoginPage.fecharAlerta();
       bankManagerLoginPage.clicarPorTexto("Customers");
       bankManagerLoginPage.searchCustomer("marlo");
      Assert.assertEquals("1016", bankManagerLoginPage.searchCustomerResult("1016"));
    }

    @Então("devo ver minhas informações bancarias")
    public void devo_ver_minhas_informações_bancarias() {
        Assert.assertTrue(customerLoginPage.informacoesBancarias("1016 "));
        Assert.assertTrue(customerLoginPage.informacoesBancarias("Dollar"));
    }

    @Quando("insiro o valor {string} no campo amount")
    public void insiro_o_valor_no_campo_amount(String valor) {
        customerLoginPage.inserirAmount(valor);
    }

    @Quando("clico no botao {string}")
    public void clico_no_botao(String string) {
        customerLoginPage.clicarDeposit();
    }

    @Então("deve ser exibido a mensagem {string}")
    public void deve_ser_exibido_a_mensagem(String string) {
        Assert.assertTrue(customerLoginPage.mensagemSucesso());
    }

    @Então("deve ser exibida a mensagem {string}")
    public void deve_ser_exibida_a_mensagem(String string) {
        Assert.assertTrue(customerLoginPage.transationSucesso());
    }


}
