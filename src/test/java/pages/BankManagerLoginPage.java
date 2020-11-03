package pages;

import config.DSL;
import config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BankManagerLoginPage extends DSL {

    private WebDriver driver;


    public BankManagerLoginPage() {
        driver = DriverFactory.ObterDriver();
        PageFactory.initElements(driver, this);
    }

    public void acessarSistema(String url) {
        driver.navigate().to(url);
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
    public void escreverCustomer(String fistName){
        select(By.xpath("//select[@id='userSelect']"), "marlo henrique");
    }
    public void escreverCurrency(){
        select(By.xpath("//select[@id='currency']"), "Dollar");
    }
    public void searchCustomer(String name){
        escrever(By.xpath("//input[@type='text']"), name);
    }
    public String searchCustomerResult(String texto){
        return obterTexto(By.xpath("//td[contains(.,'"+texto+"')]"));
    }

    public boolean searchCustomerResultExist(String texto){
        return existeElementoPorTexto(By.xpath("//td[contains(.,'"+texto+"')]"));
    }

    public void clicarSalvar(){
        clicarPorTexto(By.xpath("//button[@value='']"));
    }

    public String cadastrado(){
        return textoAlerta();
    }

    public void fecharAlerta(){
        fechar();
    }






}
