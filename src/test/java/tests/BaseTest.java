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
    protected WebDriver driver;
    protected LogInPage logInPage;
    protected HomePage homePage;

    @Parameters({"headless"})
    @BeforeClass(alwaysRun = true)
    public void beforeAll(@Optional("true") String headless) {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(headless)) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    @Parameters({"baseUrl"})
    @BeforeMethod(alwaysRun = true)
    public void openAndWire(String baseUrl) {
        driver.get(baseUrl);
        logInPage = new LogInPage(driver);
        homePage  = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterAll() {
            driver.quit();
    }
}


