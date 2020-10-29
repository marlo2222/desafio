package pages;

import config.BasePage;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AdicionarUsuarioPage extends BasePage {

    private WebDriver driver;
    private String custumerLogin = "//button[contains(.,'Custumer Login')]";
    private String bankManagerLogin = "//button[contains(.,'Bank Manager Login')]";

    public AdicionarUsuarioPage() {
        driver = Config.ObterDriver();
        PageFactory.initElements(driver, this);
    }

    public void acessarSistema(String url) {
        driver.navigate().to(url);
    }

    public boolean existeElementoTexto(String texto){
        return existeElementoPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }
    public void clicarPorTexto(String texto){
        clicarPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }

    public void escreverFistName(String fistName){
        escrever(By.xpath("//input[@type='text']"), fistName);
    }
    public void escreverLastName(String lastName){
        escrever(By.xpath("(//input[@type='text'])[2]"), lastName);
    }
    public void escreverPostCode(String postCode){
        escrever(By.xpath("(//input[@type='text'])[3]"), postCode);
    }

    public void clicarSalvar(){
        clicarPorTexto(By.xpath("//button[@value='']"));
    }

    public String cadastrado(){
        return textoAlerta();
    }






}
