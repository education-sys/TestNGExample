package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected CheckOutCompletePage checkOutCompletePage;
    protected CheckOutOverviewPage checkOutOverviewPage;
    protected CheckOutUsersInfoPage checkOutUsersInfoPage;
    protected CartPage cartPage;
    private Path tmpProfileDir;

    @BeforeClass
    public void beforeClass() throws IOException {
        // Jedinstveni, čisti Chrome profil za ovaj test class
        tmpProfileDir = Files.createTempDirectory("wd-profile-");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + tmpProfileDir.toAbsolutePath());
        options.addArguments("--no-first-run", "--no-default-browser-check");
        // (po želji za CI/Linux) options.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutUsersInfoPage = new CheckOutUsersInfoPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        // Zatvori driver
        if (driver != null) {
            try { driver.quit(); } catch (Exception ignored) {}
        }
        // Očisti privremeni profil (uklanja eventualni lock)
        if (tmpProfileDir != null) {
            try {
                Files.walk(tmpProfileDir)
                        .sorted((a, b) -> b.compareTo(a))
                        .forEach(p -> { try { Files.deleteIfExists(p); } catch (Exception ignored) {} });
            } catch (Exception ignored) {}
        }
    }
}


