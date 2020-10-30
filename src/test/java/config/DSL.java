package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DSL {

    public void escrever(){

    }

    public String obterTexto(By element){
        return DriverFactory.ObterDriver().findElement(element).getText();
    }
    public Boolean existeElementoPorTexto(By by){
        List<?> elemento = DriverFactory.ObterDriver().findElements(by);
        return elemento.size() > 0;
    }

    public void inferno(){
        DriverFactory.ObterDriver().findElement(By.xpath("//button[contains(.,'Customer Login')]")).click();
    }

    public void clicarPorTexto(By by){
        DriverFactory.ObterDriver().findElement(by).click();
    }
    public boolean select(By by, String name){
        Select se = new Select(DriverFactory.ObterDriver().findElement(by));

        List<WebElement> Options = se.getOptions();
        for(WebElement option:Options){
            if(option.getText().equals(name)) {
                option.click();
                return true;
            }
        }
        return false;
    }

    public void escrever(By by, String texto){
        DriverFactory.ObterDriver().findElement(by).sendKeys(texto);
    }
    public String textoAlerta(){
        return DriverFactory.ObterDriver().switchTo().alert().getText();
    }
    public void fechar(){
        DriverFactory.ObterDriver().switchTo().alert().dismiss();
    }


}
