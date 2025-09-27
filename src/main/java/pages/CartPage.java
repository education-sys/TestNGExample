package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By finishButton = By.id("finish");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFinishButton(){
        driver.findElement(finishButton).click();
    }









}
