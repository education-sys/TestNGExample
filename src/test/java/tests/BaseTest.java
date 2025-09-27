package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        max time to wait for a page load
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
//        max time for asynchronous JS run
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


