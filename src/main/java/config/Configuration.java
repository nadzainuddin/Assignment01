package config;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

public class Configuration {
    static WebDriver driver;

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
