package ui;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.ProductPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    ProductPage productPage = new ProductPage(getDriver());

    @BeforeEach
    public void init(){
        loginPage.navigateTo("https://www.saucedemo.com/"); // set BASE URL in env
    }

    @Test
    public void verify_on_successful_login() {
        loginPage.submitUserCreds("standard_user", "secret_sauce");
        productPage.productsPageDisplayed();
    }

    @Test
    public void verify_on_submit_without_username() {
        loginPage.submitUserCreds("", "secret_sauce");
        assertTrue(loginPage.requiredErrMsgDisplayed("Username"));
    }

    @Test
    public void verify_on_submit_without_password() {
        loginPage.submitUserCreds("standard_user", "");
        assertTrue(loginPage.requiredErrMsgDisplayed("Password"));
    }

    @Test
    public void verify_on_submit_incorrect_username() {
        loginPage.submitUserCreds("standard_user1", "secret_sauce");
        assertTrue(loginPage.noUserMatchErrMsgDisplayed());
    }

    @Test
    public void verify_on_submit_incorrect_password() {
        loginPage.submitUserCreds("standard_user", "secret_sauce1");
        assertTrue(loginPage.noUserMatchErrMsgDisplayed());
    }

    @Test
    public void verify_login_as_locked_user() {
        loginPage.submitUserCreds("locked_out_user", "secret_sauce");
        assertTrue(loginPage.lockedUserErrMsgDisplayed());
    }
}
