package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        plugin = {"pretty", "html:target/HtmlReport", "json:target/JsonReport/json.json"},
        glue = {""}
)
public class TestRunner {
}
