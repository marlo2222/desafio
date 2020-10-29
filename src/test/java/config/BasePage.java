package config;

import org.openqa.selenium.By;

import java.util.List;

public class BasePage {

    public void escrever(){

    }

    public String obterTexto(By element){
        return Config.ObterDriver().findElement(element).getText();
    }
    public Boolean existeElementoPorTexto(By by){
        List<?> elemento = Config.ObterDriver().findElements(by);
        System.out.println(elemento.size());
        return elemento.size() > 0;
    }

    public void clicarPorTexto(By by){
        Config.ObterDriver().findElement(by).click();
    }

    public void escrever(By by, String texto){
        Config.ObterDriver().findElement(by).sendKeys(texto);
    }
    public String textoAlerta(){
        return Config.ObterDriver().switchTo().alert().getText();
    }
    public void fechar(){
        Config.ObterDriver().switchTo().alert().dismiss();
    }


}
