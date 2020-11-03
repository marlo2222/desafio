package config;





import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class DriverFactory {

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

   /* @After(order = 1)
    public void screenshot(Scenario cenario){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File("target/sreenshot"+cenario.getId()+".jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    @After()
    public void FecharJanela(Scenario cenario) {
        //scenario.write("Finished scenario");
        // if (scenario.isFailed())
        // scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");


            // Faça uma captura de tela ...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // incorpore no relatório.
            //cenario.(screenshot, "imagem / png");


        driver.quit();
        System.out.println("Fim de teste");
    }

}
