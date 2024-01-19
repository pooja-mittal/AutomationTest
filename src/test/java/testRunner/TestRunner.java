package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "/src/test/resources/Features/CountProductsInCart.feature",
		glue = {"stepdef"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary","rerun:target/failedrerun.txt"}

		
		)

public class TestRunner {

}
