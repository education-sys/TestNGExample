package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    // ---- Constructors ----
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}

