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

    public boolean welcome(){
        return existeElementoPorTexto(By.xpath("//strong[contains(.,'Welcome marlo henrique !!')]"));
    }
    public boolean login(){
        return existeElementoPorTexto(By.xpath("//label[contains(.,'Your Name :')]"));
    }
    public boolean informacoesBancarias(String texto){
        return existeElementoPorTexto(By.xpath("//strong[contains(.,'"+texto+"')]"));
    }
    public void clicarPorTexto(String texto){
        clicarPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }

    public void inserirValorDeposito(String valor){
        escrever(By.xpath("//input[@type='number']"), valor);
    }

    public void inserirValorRetirada(String valor){
        escrever(By.xpath("//input[@type='number']"), valor);
    }

    public void botoesCustomerLogin(String botao){
        clicarPorTexto(By.xpath("//button[contains(.,'"+botao+"')]"));
    }
    public boolean depositoSucesso(){
        return existeElementoPorTexto(By.xpath("//span[contains(.,'Deposit Successful')]"));
    }
    public boolean transationSucesso(){
        return existeElementoPorTexto(By.xpath("//span[contains(.,'Transaction successful')]"));
    }
    public boolean transationFalha(){
        return existeElementoPorTexto(By.xpath("//span[contains(.,'Transaction Failed. You can not withdraw amount more than the balance.')]"));
    }
    public void botaoForm(){
        clicarPorTexto(By.xpath("//form/button"));
    }
    public String valorTransacao(){
        return obterTexto(By.xpath("//tr[@id='anchor0']/td[2]"));
    }
    public String tipoTransacao(){
        return obterTexto(By.xpath("//tr[@id='anchor0']/td[3]"));
    }




}
