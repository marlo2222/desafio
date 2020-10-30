package pages;

import config.DSL;
import config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends DSL {

    private WebDriver driver;

    public CustomerLoginPage() {
        driver = DriverFactory.ObterDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean yourNameSelect(String usuario){
         return select(By.xpath("//select[@id='userSelect']"), usuario);
    }
    public void loginClick(){
        clicarPorTexto(By.xpath("//button[contains(.,'Login')]"));
    }
    public boolean welcome(){
        return existeElementoPorTexto(By.xpath("//strong[contains(.,'Welcome marlo henrique !!')]"));
    }
    public boolean informacoesBancarias(String texto){
        return existeElementoPorTexto(By.xpath("//strong[contains(.,'"+texto+"')]"));
    }
    public void clicarPorTexto(String texto){
        clicarPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }

    public void inserirAmount(String valor){
        escrever(By.xpath("//input[@type='number']"), valor);
    }
    public void clicarDeposit(){
        clicarPorTexto(By.xpath("//form/button"));
    }
    public boolean mensagemSucesso(){
        return existeElementoPorTexto(By.xpath("//span[contains(.,'Deposit Successful')]"));
    }
    public boolean transationSucesso(){
        return existeElementoPorTexto(By.xpath("//span[contains(.,'Transaction successful')]"));
    }




}
