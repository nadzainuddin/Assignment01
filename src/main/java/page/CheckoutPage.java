package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Your Cart']")
    WebElement yourCartTitle;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> productsName;
    @FindBy(css = ".inventory_item_price")
    List<WebElement> productsPrice;
    @FindBy(xpath = "//button[text() = 'Remove']")
    List<WebElement> removeProductBtn;
    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingBtn;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkoutPageDisplayed() {
        yourCartTitle.isDisplayed();
    }

    public List<String> getProductsName() {
        List<String> names = new ArrayList<>();
        for(int i = 0; i<productsName.size(); i++) {
            names.add(productsName.get(i).getText());
        }
        return names;
    }

    public List<String> getProductsPrice() {
        List<String> prices = new ArrayList<>();
        for(int i = 0; i<productsPrice.size(); i++) {
            prices.add(productsPrice.get(i).getText());
        }
        return prices;
    }

    public void removeAllItems() {
        while(removeProductBtn.size() > 0) {
            System.out.println("Removing item... ");
            removeProductBtn.get(1).click();
        }
    }

    public void clickContShoppingBtn() {
        continueShoppingBtn.click();
    }
}
