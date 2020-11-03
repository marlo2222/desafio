package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports"},
        glue = {""},
        monochrome = false
)
public class TestRunner {
}
