package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
    private WebDriver driver;
    private By emailID = By.id("email");
    private By passwordID = By.id("password");
    private By loginButtonID = By.id("submit");
    private By forgotPwd = By.xpath("//a[contains(text(), 'Forgot Password')]");
    

    // constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void enterUsername(String username){
        driver.findElement(emailID).sendKeys(username);
    }

    public void enterPassword(String password){
        
        driver.findElement(passwordID).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButtonID).click();
    }
    public boolean isForgotPwdLinkExist(){
        return driver.findElement(forgotPwd).isDisplayed();
    }

    public DashboardPage doLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new DashboardPage(driver);
    }

}