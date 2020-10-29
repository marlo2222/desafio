package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Config {

    public static WebDriver driver;

    public static WebDriver ObterDriver() {
        return driver;
    }

    @Before
    public void ConfiguracaoInicial() {

        System.out.println("inicio do teste");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void FecharJanela() {
      //  driver.quit();
        System.out.println("Fim de teste");

    }
}
