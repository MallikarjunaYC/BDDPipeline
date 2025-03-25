package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        
        // if (browser == null || browser.isEmpty()) {
        //     browser = "chrome"; // Default to Chrome if no browser is specified
        // }
        System.out.println("browser value is: " + browser);
        
        
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }
        return tlDriver.get();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}