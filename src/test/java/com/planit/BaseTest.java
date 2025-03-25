// Abstract test class, provides common setup and teardowns for all tests.
// Centralises driver initialisation using WebDriverFactory

package com.planit;

import com.planit.utils.WebDriverFactory;
import com.planit.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = ConfigReader.getProperty("base.url");

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        driver.get(BASE_URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
