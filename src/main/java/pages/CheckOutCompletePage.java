package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePage {

    private By orderCompletedSection = By.id("checkout_complete_container");

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean orderCompletedSectionPresent(){
        return driver.findElement(orderCompletedSection).isDisplayed();
    }






}
