package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductPage;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static config.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    ProductPage productPage = new ProductPage(getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(getDriver());

    @BeforeEach
    public void init() {
        loginPage.navigateTo("https://www.saucedemo.com/");
        loginPage.submitUserCreds("standard_user", "secret_sauce");
    }

    @Test
    public void verify_on_sorting_products_name_asc() {
        List<String> expNames = productPage.getProductsName().stream()
                .sorted()
                .collect(Collectors.toList());
        productPage.clickSortBy("Name (A to Z)");
        List<String> actNames = productPage.getProductsName();
        assertEquals(expNames, actNames);
    }

    @Test
    public void verify_on_sorting_products_name_desc() {
        List<String> expNames = productPage.getProductsName().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        productPage.clickSortBy("Name (Z to A)");
        List<String> actNames = productPage.getProductsName();
        assertEquals(expNames, actNames);
    }

    @Test
    public void verify_on_sorting_products_price_asc() {
        List<Double> expPrices = productPage.getProductsPrice().stream()
                .sorted()
                .collect(Collectors.toList());
        productPage.clickSortBy("Price (low to high)");
        List<Double> actPrices = productPage.getProductsPrice();
        assertEquals(expPrices, actPrices);
    }

    @Test
    public void verify_on_sorting_products_price_desc() {
        List<Double> expPrices = productPage.getProductsPrice().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        productPage.clickSortBy("Price (high to low)");
        List<Double> actPrices = productPage.getProductsPrice();
        assertEquals(expPrices, actPrices);
    }

    @Test
    public void verify_able_to_add_products() {
        Map<String, String> map = productPage.clickRandAddToCartBtn();
        productPage.clickShopingCartIcon();
        assertEquals(map.keySet().stream().toList(), checkoutPage.getProductsName());
        assertEquals(map.values().stream().toList(), checkoutPage.getProductsPrice());
    }

    @Test
    public void verify_able_to_add_all_products() {
        productPage.removeItems();
        Map<String, String> map = productPage.clickAllAddToCartBtn();
        productPage.clickShopingCartIcon();
        assertEquals(map.keySet().stream().sorted().toList(), checkoutPage.getProductsName().stream().sorted().toList());
        assertEquals(map.values().stream().sorted().toList(), checkoutPage.getProductsPrice().stream().sorted().toList());
    }

    @Test
    public void verify_able_to_remove_products() {
        productPage.removeItems();
        productPage.clickRandAddToCartBtn();
        productPage.removeItems();
        productPage.clickShopingCartIcon();
        assertEquals(0, checkoutPage.getProductsName().size());
    }
}
