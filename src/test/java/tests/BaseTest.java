package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected CheckOutCompletePage checkOutCompletePage;
    protected CheckOutOverviewPage checkOutOverviewPage;
    protected CheckOutUsersInfoPage checkOutUsersInfoPage;
    protected CartPage cartPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutUsersInfoPage = new CheckOutUsersInfoPage(driver);
        cartPage = new CartPage(driver);
    }

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


