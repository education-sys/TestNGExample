package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage extends BasePage {

    private By checkoutGreenButton = By.id("checkout");

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckoutGreenButton(){
        driver.findElement(checkoutGreenButton).click();
    }








}
