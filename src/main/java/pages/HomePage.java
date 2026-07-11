package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By addToCartButton = By.name("add-to-cart-sauce-labs-backpack");
    private By shopingCartIcon = By.id("shopping_cart_container");
    private By locator = By.id("locator");
    private By locatorNumberTwo = By.id("something");
    private By locatorx = By.id("locator");
    private By locatorNumberTwoxx = By.id("something");
    private By locatortt = By.id("locator");
    private By locatorNumberTwoxq = By.id("something");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addToCartAction(){
        driver.findElement(addToCartButton).click();
        driver.findElement(shopingCartIcon).click();
    }

    public boolean homePageDisplayed(){
        return driver.findElement(addToCartButton).isDisplayed();
    }






}
