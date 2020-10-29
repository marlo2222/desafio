package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        tags = {"~@ignore"},
        plugin = {"pretty", "html:target/HtmlReport", "json:target/JsonReport/json.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class TestRunner {
}
