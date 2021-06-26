package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "resources/features"
	,glue={"stepDefinitions"},plugin= { "json:target/cucumber.json", "pretty",
	"html:target/cucumber-reports" }
	)

public class TestRunner {
    


}
