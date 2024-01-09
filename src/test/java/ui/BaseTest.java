package ui;

import config.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.TimeUnit;

import static config.DriverHolder.getDriver;
import static config.DriverHolder.setDriver;

public class BaseTest {
    @BeforeAll
    public static void before() {
        setDriver(DriverFactory.getNewDriverInstance("chrome"));
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void after() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
