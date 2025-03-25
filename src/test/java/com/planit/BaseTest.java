// Abstract test class, provides common setup and teardowns for all tests.
// Centralises driver initialisation using WebDriverFactory

package com.planit;

import com.planit.utils.WebDriverFactory;
import com.planit.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = ConfigReader.getProperty("base.url");

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
