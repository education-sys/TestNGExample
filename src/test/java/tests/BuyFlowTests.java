package tests;

import org.testng.annotations.Test;
import pages.*;

public class BuyFlowTests extends BaseTest {

    LogInPage logInPage = new LogInPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(driver);
    CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(driver);
    CheckOutUsersInfoPage checkOutUsersInfoPage = new CheckOutUsersInfoPage(driver);
    CartPage cartPage = new CartPage(driver);


    @org.testng.annotations.Test
    public void buyflow() {
        logInPage.validLogInAction();
        homePage.addToCartAction();
        checkOutOverviewPage.clickOnCheckoutGreenButton();
        checkOutUsersInfoPage.fillUsersInfoAndContinue();
        cartPage.clickOnFinishButton();
    }


}
