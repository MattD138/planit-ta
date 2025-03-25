// Page object representing the Home page of the website

package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By contactPageLink = By.linkText("Contact");
    private By shopPageLink = By.linkText("Shop");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToContactPage() {
        clickElement(driver.findElement(contactPageLink));
    }

    public void navigateToShopPage() {
        clickElement(driver.findElement(shopPageLink));
    }
}
