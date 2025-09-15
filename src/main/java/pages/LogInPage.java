package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {

    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void validLogInAction(){
        driver.findElement(usernameInputField).sendKeys("standard_user");
        driver.findElement(passwordInputField).sendKeys("secret_sauce");
        driver.findElement(loginBtn).click();
    }

    public void logInAction(String userName, String password){
        driver.findElement(usernameInputField).sendKeys(userName);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean errorMessageDisplayed(){
        return driver.findElement(errorMsg).isDisplayed();
    }




}
