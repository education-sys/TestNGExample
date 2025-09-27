package tests;

import org.testng.annotations.Test;
import pages.*;

public class LogInTests extends BaseTest {

//    @Test
//    public void validLogInCredentials() {
//        logInPage.validLogInAction();
//        homePage.homePageDisplayed();
//    }

    @Test
    public void invalidUserNameValidPassword() {
        logInPage.logInAction("fklsajkl", "secret_sauce");
        assert logInPage.errorMessageDisplayed();
    }

    @Test
    public void validUserNameInvalidPassword() {
        logInPage.logInAction("standard_user", "jklfsja");
        assert logInPage.errorMessageDisplayed();
    }

    @Test
    public void bothCredentialsInvalid() {
        logInPage.logInAction("safj", "jsklajf");
        assert logInPage.errorMessageDisplayed();
    }

    @Test
    public void bothCredentialsBlank() {
        logInPage.logInAction("", "");
        assert logInPage.errorMessageDisplayed();
    }

    @Test
    public void OneCredentialBlank() {
        logInPage.logInAction("gsdgsgdsg", "");
        assert logInPage.errorMessageDisplayed();
    }

    @Test
    public void OneCredentialBlankAnotherOK() {
        logInPage.logInAction("", "tete");
        assert logInPage.errorMessageDisplayed();
    }
}

