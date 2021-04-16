package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/featureFiles/FlipkartSearch.feature",glue= {"StepDefinitions"},
	plugin = {  "pretty",
				"html:target/reports/cucumber-html-report.html",
				"json:target/reports/cucumber_json_report.json",
				"junit:target/reports/cucumber_xml_report.xml"
			},
	monochrome = true)
public class TestRunner {

}
