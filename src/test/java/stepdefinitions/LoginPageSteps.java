package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import pages.LoginPage; // Ensure this matches the actual package of LoginPage
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

        private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        static String loginPagetitle;

        @Given("user is on login page")
        public void user_is_on_login_page() {
            //DriverFactory.getDriver().get("https://app.phptravels.com/login");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        @When("user enters username {string}")
        public void user_enters_username(String userName) {
            loginPage.enterUsername(userName);
            
        }
        @When("user enters password {string}")
        public void user_enters_password(String password) {
            loginPage.enterPassword(password);
            
        }
        @When("user clicks on Login button")
        public void user_clicks_on_login_button() {
            loginPage.clickLogin();
            
        }
        @Then("user gets the title of the page")
        public void user_gets_the_title_of_the_page() {
            loginPagetitle = loginPage.getLoginPageTitle();
            
        }
        @Then("page title should be {string}")
        public void page_title_should_be(String expectedTitle) {
           Assert.assertTrue(loginPagetitle.contains(expectedTitle));
        }

        @Then("forgot password link should be displayed")
        public void forgot_password_link_should_be_displayed() {
            
            Assert.assertTrue(loginPage.isForgotPwdLinkExist());
            
            
        }

        


}