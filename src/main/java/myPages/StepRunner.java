package myPages;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/main/java/myPages",
 glue= {"myTestcases"},
 plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" }
 )
public class StepRunner {

}
