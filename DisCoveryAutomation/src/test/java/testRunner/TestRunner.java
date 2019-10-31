package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/FeaturesFiles/discovery.feature", glue = "stepDefination", monochrome = true, dryRun = false, strict = false, plugin = {
		"pretty", "html:target/cucumber", "json:target/cucumber.json", })

public class TestRunner {

}
