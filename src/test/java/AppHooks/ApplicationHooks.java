package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.ConfigReader;

public class ApplicationHooks {
    private DriverFactory driverfactory = new DriverFactory();
    //private DriverFactory driverfactory
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driver = driverfactory.init_driver(browserName);
    }

    @Before(order = 2)
    public void launchURL() {
        String url = prop.getProperty("url");
        driver.get(url);
    }


    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }

    }
    
}
