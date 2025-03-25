package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/LoginPage.feature",
    glue = {"stepdefinitions", "AppHooks"},
    plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    //plugin = {"pretty"},
    monochrome = true
)
public class CucumberRunnerTest {
}