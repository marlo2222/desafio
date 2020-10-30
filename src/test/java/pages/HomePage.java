package pages;

import config.DSL;
import config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DSL {

    private WebDriver driver;

    public HomePage() {
        driver = DriverFactory.ObterDriver();
        PageFactory.initElements(driver, this);
    }
    public void botaoHome(){
        clicarPorTexto(By.xpath("//div[2]/div/div[2]/div/div"));
    }

    public boolean existeElementoTexto(String texto){
        return existeElementoPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }

    public void clicarPorTexto(String texto){
        clicarPorTexto(By.xpath("//button[contains(.,'"+texto+"')]"));
    }
}
