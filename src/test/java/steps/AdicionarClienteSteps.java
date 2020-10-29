package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.AdicionarUsuarioPage;

public class AdicionarClienteSteps {

    AdicionarUsuarioPage adUsuarioPage = new AdicionarUsuarioPage();

    @Dado("que acesso o link {string}")
    public void que_acesso_o_link(String url) {
        adUsuarioPage.acessarSistema(url);
    }

    @Quando("visualizo as opções {string} e {string}")
    public void visualizo_as_opções_e(String texto1, String texto2) {
        Assert.assertTrue(adUsuarioPage.existeElementoTexto(texto1));
        Assert.assertTrue(adUsuarioPage.existeElementoTexto(texto2));
    }

    @Então("eu clico em {string}")
    public void eu_clico_em(String texto) {
        adUsuarioPage.clicarPorTexto(texto);
    }

    @Dado("que estou acessando a opção Bank Manager Login")
    public void que_estou_acessando_a_opção() {

    }

    @Quando("seleciono a opção {string}")
    public void seleciono_a_opção(String texto) {
        adUsuarioPage.clicarPorTexto(texto);
    }

    @Quando("preencho os campos {string}, {string} e {string}")
    public void preencho_os_campos_fist_name_last_name_e_post_code(String fist, String last, String code) {
        adUsuarioPage.escreverFistName(fist);
        adUsuarioPage.escreverLastName(last);
        adUsuarioPage.escreverPostCode(code);
    }

    @Quando("clico no botão {string} para salvar")
    public void clico_no_botão(String string) {
        adUsuarioPage.clicarSalvar();
    }

    @Então("um novo usuario deve ser cadastrado com sucesso")
    public void um_novo_usuario_deve_ser_cadastrado_com_sucesso() {
        Assert.assertEquals("Customer added successfully with customer id :6",adUsuarioPage.cadastrado());
    }
}
