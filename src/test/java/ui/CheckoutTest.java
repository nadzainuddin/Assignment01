package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductPage;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    ProductPage productPage = new ProductPage(getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(getDriver());

    @BeforeEach
    public void init() {
        loginPage.navigateTo("https://www.saucedemo.com/");
        loginPage.submitUserCreds("standard_user", "secret_sauce");
    }

    @Test
    public void verify_on_cancelling_from_checkout() {
        productPage.clickRandAddToCartBtn();
        productPage.clickShopingCartIcon();
        checkoutPage.clickCheckoutBtn();
        checkoutPage.enterCheckoutDetails("Mika", "Yosi", "50000");
        checkoutPage.clickContinueBtn();
        checkoutPage.checkoutOverviewPageDisplayed();
        double expTotal = checkoutPage.getTaxValue() + checkoutPage.getSubTotalValue();
        assertEquals(String.format("%.2f", expTotal), String.valueOf(checkoutPage.getTotalValue()));

        checkoutPage.clickFinishBtn();
        checkoutPage.checkoutCompletePageDisplayed();
    }

    @Test
    public void verify_on_cancel_from_checkout() {
        productPage.clickRandAddToCartBtn();
        productPage.clickShopingCartIcon();
        checkoutPage.clickCheckoutBtn();
        checkoutPage.enterCheckoutDetails("Mika", "Yosi", "50000");
        checkoutPage.clickContinueBtn();
        checkoutPage.checkoutOverviewPageDisplayed();
        checkoutPage.clickCancelBtn();
        productPage.productsPageDisplayed();
    }

    @Test
    public void verify_on_submitting_incomplete_checkout_details() {
        productPage.clickRandAddToCartBtn();
        productPage.clickShopingCartIcon();
        checkoutPage.clickCheckoutBtn();
        checkoutPage.enterCheckoutDetails("", "Yosi", "50000");
        checkoutPage.clickContinueBtn();
        checkoutPage.firstNameRequireMsgDisplayed();
    }
}
