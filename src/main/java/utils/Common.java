package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Common {
    public WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickBtnOnFrame(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(0);
        element.click();
        driver.switchTo().defaultContent();
    }

    public void clickBtnOnFrame(WebElement element) {
        driver.switchTo().frame(0);
        element.click();
        driver.switchTo().defaultContent();
    }

    public void sendKeys(WebElement element, String input) {
        element.sendKeys(input);
    }

    public void isDisplayed(WebElement element) {
        element.isDisplayed();
    }

    public void isDisplayed(String locator, String text) {
        WebElement element = driver.findElement(By.xpath(String.format(locator, text)));
        element.isDisplayed();
    }

    public String getCurrURL() {
        return driver.getCurrentUrl();
    }
}
