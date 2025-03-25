package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardLinks = By.xpath("//ul[@class='nav nav-pills flex-column mb-auto p-0 mt-2']/li/button");
    
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getAllLinks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLinks));
        List<WebElement> links = driver.findElements(dashboardLinks);
        List<String> linkTexts = new ArrayList<>();
        for (WebElement link : links) {

            String fullText = link.getText();

            // Extract only the part before the first space
            String textBeforeSpace = fullText.split(" ")[0];

            // Add the extracted text to the list
            linkTexts.add(textBeforeSpace);

            linkTexts.add(link.getText());
            // System.out.println();
            // System.out.println();
            // System.out.println();

            //System.out.println("the actual link:    "+link.getText());
            // System.out.println();
            // System.out.println();
            // System.out.println();
        }
        return linkTexts;
    }   

    public int getLinkCount() {
        return driver.findElements(dashboardLinks).size();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
