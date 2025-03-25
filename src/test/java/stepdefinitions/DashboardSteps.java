package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.LoginPage;
import io.cucumber.datatable.DataTable;
//import org.testng.Assert;

// import java.time.Duration;
import java.util.List;

import org.junit.Assert;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import org.junit.Assert;

// import static org.junit.Assert.assertEquals;

import factory.DriverFactory;

public class DashboardSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage;

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application(DataTable credentials) {
        // Extract username and password from the data table
        List<List<String>> data = credentials.asLists(String.class);
        String username = data.get(1).get(0); // "mallik.yc@gmail.com"
        String password = data.get(1).get(1); // "443150"

        System.out.println("Logging in with username: " + username + " and password: " + password);
        
        // open the url
        DriverFactory.getDriver().get("https://app.phptravels.com/login");                                        
        
        

        // login to the app
        dashboardPage = loginPage.doLogin(username, password);
    }

    @Given("user is on dashboard page")
    public void user_is_on_dashboard_page() {
        System.out.println("User is on the dashboard page.");
        // Add logic to verify the user is on the dashboard page - verify the title
        String dashBoardTitle = dashboardPage.getPageTitle();
        System.out.println("Dashboard title is: " + dashBoardTitle);
        //Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

   @Then("the page should have the following links")
    public void the_page_should_have_the_following_links(DataTable links) throws InterruptedException {
        // Extract the expected links from the data table
        List<String> expectedLinks = links.asList();
        System.out.println("Expected links: " + expectedLinks);
        Thread.sleep(5000);
        // WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLinks));
        // Add logic to verify the links on the page
        List<String> actualLinks = dashboardPage.getAllLinks();
        // Trim the actual links to remove leading/trailing spaces
        List<String> trimmedActualLinks = actualLinks.stream()
        .map(String::trim)
        .toList();

        System.out.println("Actual links: " + actualLinks);

        Assert.assertTrue(trimmedActualLinks.containsAll(expectedLinks));
    }

    @Then("the count should be {int}")
    public void the_count_should_be(Integer expectedCount) {
        System.out.println("Verifying link count: " + expectedCount);
        // Add logic to verify the count of links
        int actualCount = dashboardPage.getLinkCount();
        Assert.assertTrue(actualCount == expectedCount+1);
        
    }
}