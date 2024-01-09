package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void submitUserCreds(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public boolean requiredErrMsgDisplayed(String fieldname) {
        return driver.findElement(By.xpath
                (String.format("//h3[text() = '%s']", "Epic sadface: " + fieldname + " is required")))
                .isDisplayed();
    }

    public boolean noUserMatchErrMsgDisplayed() {
        return driver.findElement(
                By.xpath("//h3[text() = 'Epic sadface: Username and password " +
                        "do not match any user in this service']"))
                .isDisplayed();
    }

    public boolean lockedUserErrMsgDisplayed() {
        return driver.findElement(
                By.xpath("//h3[text() = 'Epic sadface: Sorry, this user has " +
                        "been locked out.']"))
                .isDisplayed();
    }

}
