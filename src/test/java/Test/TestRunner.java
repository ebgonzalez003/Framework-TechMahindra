package Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Resources/features",
        glue = "your.package.name.steps",
        plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json" },
        tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}