package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CheckoutPage;
import page.LoginPage;

import static config.DriverHolder.getDriver;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(getDriver());

    @BeforeEach
    public void init() {
        loginPage.navigateTo("https://www.saucedemo.com/");
        loginPage.submitUserCreds("standard_user", "secret_sauce");
    }

    @Test
    public void verify_on_cancelling_from_checkout() {

    }

    @Test
    public void verify_on_submitting_incomplete_checkout_details() {
        
    }
}
