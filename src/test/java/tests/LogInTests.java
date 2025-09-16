package tests;

import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

    @Test(groups = {"LogIn"})
    public void validLogInCredentials() {
        logInPage.validLogInAction();
        homePage.homePageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void invalidUserNameValidPassword() {
        logInPage.logInAction("fklsajkl", "secret_sauce");
        assert logInPage.errorMessageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void validUserNameInvalidPassword() {
        logInPage.logInAction("standard_user", "jklfsja");
        assert logInPage.errorMessageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void bothCredentialsInvalid() {
        logInPage.logInAction("safj", "jsklajf");
        assert logInPage.errorMessageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void bothCredentialsBlank() {
        logInPage.logInAction("", "");
        assert logInPage.errorMessageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void OneCredentialBlank() {
        logInPage.logInAction("gsdgsgdsg", "");
        assert logInPage.errorMessageDisplayed();
    }

    @Test(groups = {"LogIn"})
    public void OneCredentialBlankAnotherOK() {
        logInPage.logInAction("", "tete");
        assert logInPage.errorMessageDisplayed();
    }
}

