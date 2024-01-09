package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Products']")
    WebElement productsTitle;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> productsName;
    @FindBy(css = ".inventory_item_price")
    List<WebElement> productsPrice;
    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtn;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;
    @FindBy(css = ".shopping_cart_badge")
    List<WebElement> shoppingCartBadge;
    @FindBy(xpath = "//button[text() = 'Remove']")
    List<WebElement> removeProductBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void productsPageDisplayed() {
        productsTitle.isDisplayed();
    }

    public List<String> getProductsName() {
        List<String> names = new ArrayList<>();
        for(int i = 0; i<productsName.size(); i++) {
            names.add(productsName.get(i).getText());
        }
        return names;
    }

    public List<Double> getProductsPrice() {
        List<Double> prices = new ArrayList<>();
        for(int i = 0; i<productsPrice.size(); i++) {
            prices.add(Double.parseDouble(productsPrice.get(i).getText().replace("$","")));
        }
        return prices;
    }

    public void clickSortBy(String opt) {
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText(opt);
    }

    public Map<String, String> clickRandAddToCartBtn() {
        Random rand = new Random();
        int randIdx = rand.nextInt(0, productsName.size()-1);
        addToCartBtn.get(randIdx).click();

        Map<String, String> map = new HashMap<>();
        map.put(productsName.get(randIdx).getText(), productsPrice.get(randIdx).getText());
        return map;
    }

    public Map<String, String> clickAllAddToCartBtn() {
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i<productsName.size(); i++) {
            map.put(productsName.get(i).getText(), productsPrice.get(i).getText());
        }
        while(addToCartBtn.size() > 0) addToCartBtn.get(0).click();
        return map;
    }

    public void clickShopingCartIcon() {
        shoppingCartLink.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutPageDisplayed();
    }

    public void removeItems() {
            while(removeProductBtn.size() > 0) removeProductBtn.get(0).click();
    }
}
