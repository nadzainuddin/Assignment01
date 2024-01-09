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
    @FindBy(xpath = "//span[text() = 'Checkout: Your Information']")
    WebElement checkoutYourInformationTitle;
    @FindBy(xpath = "//span[text() = 'Checkout: Overview']")
    WebElement checkoutOverviewTitle;
    @FindBy(xpath = "//span[text() = 'Checkout: Complete!']")
    WebElement checkoutCompleteTitle;
    @FindBy(xpath = "//h2[text() = 'Thank you for your order!']")
    WebElement thankYouLbl;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> productsName;
    @FindBy(css = ".inventory_item_price")
    List<WebElement> productsPrice;
    @FindBy(xpath = "//button[text() = 'Remove']")
    List<WebElement> removeProductBtn;
    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingBtn;
    @FindBy(css = "#checkout")
    WebElement checkoutBtn;
    @FindBy(css = "#cancel")
    WebElement cancelBtn;
    @FindBy(css = "#first-name")
    WebElement firstNameInput;
    @FindBy(css = "#last-name")
    WebElement lastNameInput;
    @FindBy(css = "#postal-code")
    WebElement postalCodeInput;
    @FindBy(css = "#continue")
    WebElement continueBtn;
    @FindBy(css = ".summary_subtotal_label")
    WebElement summarySubTotalLbl;
    @FindBy(css = ".summary_tax_label")
    WebElement summaryTaxLbl;
    @FindBy(css = ".summary_total_label")
    WebElement summaryTotalLbl;
    @FindBy(css = "#finish")
    WebElement finishBtn;
    @FindBy(xpath = "//h3[text() = 'Error: First Name is required']")
    WebElement firstNameRequiredErrMsg;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkoutPageDisplayed() {
        yourCartTitle.isDisplayed();
    }

    public void checkoutInformationPageDisplayed() { checkoutYourInformationTitle.isDisplayed();}
    public void checkoutOverviewPageDisplayed() { checkoutOverviewTitle.isDisplayed(); }

    public void checkoutCompletePageDisplayed() {
        checkoutCompleteTitle.isDisplayed();
        thankYouLbl.isDisplayed();
    }

    public List<String> getProductsName() {
        List<String> names = new ArrayList<>();
        for (WebElement element : productsName) {
            names.add(element.getText());
        }
        return names;
    }

    public List<String> getProductsPrice() {
        List<String> prices = new ArrayList<>();
        for (WebElement element : productsPrice) {
            prices.add(element.getText());
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

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void enterCheckoutDetails(String fname, String lname, String postcode) {
        checkoutInformationPageDisplayed();
        firstNameInput.sendKeys(fname);
        lastNameInput.sendKeys(lname);
        postalCodeInput.sendKeys(postcode);
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public double getTaxValue() {
        return Double.parseDouble(summaryTaxLbl.getText().replaceAll("Tax: \\$", ""));
    }

    public double getSubTotalValue() {
        return Double.parseDouble(summarySubTotalLbl.getText().replaceAll("Item total: \\$", ""));
    }

    public double getTotalValue() {
        return Double.parseDouble(summaryTotalLbl.getText().replaceAll("Total: \\$", ""));
    }

    public void firstNameRequireMsgDisplayed() {
        firstNameRequiredErrMsg.isDisplayed();
    }
}
