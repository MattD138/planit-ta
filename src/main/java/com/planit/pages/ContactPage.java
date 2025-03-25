//Page object representing the Contact page of the website, located at /contact

package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    // Locators
    private By submitButton = By.xpath("//a[text()='Submit']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitButton() {
        clickElement(driver.findElement(submitButton));
    }
}
