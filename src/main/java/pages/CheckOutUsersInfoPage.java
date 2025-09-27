package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutUsersInfoPage extends BasePage {

    private By firstNameInputField = By.id("first-name");

    private By lastNameInputField = By.id("last-name");

    private By zipCodeInputField = By.id("postal-code");

    private By continueButton = By.id("continue");

    Faker faker = new Faker();

    public CheckOutUsersInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsersInfoAndContinue(){
        driver.findElement(firstNameInputField).sendKeys(faker.name().firstName());
        driver.findElement(lastNameInputField).sendKeys(faker.name().lastName());
        driver.findElement(zipCodeInputField).sendKeys("11080");
        driver.findElement(continueButton).click();
    }

}
