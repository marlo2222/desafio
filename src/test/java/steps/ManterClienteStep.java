package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BankManagerLoginPage;
import pages.CustomerLoginPage;
import pages.HomePage;


public class ManterClienteStep {

    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    HomePage homePage = new HomePage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    @Dado("que acesso o link {string}")//usado
    public void que_acesso_o_link(String url) {
        bankManagerLoginPage.acessarSistema(url);
    }

    @Quando("visualizo as opções {string} e {string}")//usado
    public void visualizo_as_opções_e(String texto1, String texto2) {
        Assert.assertTrue(homePage.existeElementoTexto(texto1));
        Assert.assertTrue(homePage.existeElementoTexto(texto2));
    }

    @Então("eu clico em {string}")//home, Bank Manager Login, Add Customer
    public void eu_clico_em(String texto) {
        homePage.clicarPorTexto(texto);
    }

    @Quando("preencho os campos {string}, {string} e {string}")//login
    public void preencho_os_campos_fist_name_last_name_e_post_code(String fist, String last, String code) {
        bankManagerLoginPage.escreverFistName(fist);
        bankManagerLoginPage.escreverLastName(last);
        bankManagerLoginPage.escreverPostCode(code);
    }

    @Quando("clico no botão {string} para salvar")//salvar usuario
    public void clico_no_botão_salvar(String string) {
        bankManagerLoginPage.clicarSalvar();
    }

    @Então("um novo usuario deve ser cadastrado com sucesso")//usado
    public void um_novo_usuario_deve_ser_cadastrado_com_sucesso() {
        Assert.assertEquals("Customer added successfully with customer id :6", bankManagerLoginPage.cadastrado());
        bankManagerLoginPage.fecharAlerta();
    }

    @Então("o usuario não deve ser cadastrado")
    public void o_usuario_não_deve_ser_cadastrado() {

    }

    @Então("um alerta com o seguinte texto é exibido {string}")//usado
    public void um_alerta_com_o_seguinte_texto_é_exibido(String texto) {
        Assert.assertEquals(texto, bankManagerLoginPage.cadastrado());
        bankManagerLoginPage.fecharAlerta();
    }

    @Quando("pesquiso pelo cliente {string} no campo search customer.")//usado
    public void pesquiso_pelo_cliente_no_campo_search_customer(String nome) {
        bankManagerLoginPage.searchCustomer(nome);
        Assert.assertEquals(nome, bankManagerLoginPage.searchCustomerResult(nome));
    }

    @Então("o cliente {string} deve ser removido com sucesso")
    public void o_cliente_deve_ser_removido_com_sucesso(String texto) {
       Assert.assertFalse(!bankManagerLoginPage.searchCustomerResultExist(texto));
    }


    @Quando("escolho o usuario {string} no campo Your Name")//usado
    public void escolho_o_usuario_no_campo_your_name(String nome) {
        Assert.assertTrue(customerLoginPage.yourNameSelect(nome));
    }


    @Então("o botão {string} deve ser habilitado")//usado
    public void o_botão_deve_ser_habilitado(String texto) {
        Assert.assertTrue(homePage.existeElementoTexto(texto));
    }
    @Então("deve ser ser exibido a mensagem de boas vindas")//usado
    public void deve_ser_ser_exibido_a_mensagem_de_boas_vindas_para() {
        Assert.assertTrue(customerLoginPage.welcome());
    }


    @Então("o botão {string} deve estar desabilitado")//usado
    public void o_botão_deve_estar_desabilitado(String texto) {
        Assert.assertEquals(true, homePage.existeElementoTexto(texto));
    }

    @Então("devo ser sair do sistema")//usado
    public void devo_ser_sair_do_sistema() {
        Assert.assertTrue(customerLoginPage.login());
    }


}
