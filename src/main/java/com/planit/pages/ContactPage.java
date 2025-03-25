// Page object representing the Contact page of the website, located at /contact

package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {
    // Locators
    private By submitButton = By.xpath("//a[text()='Submit']");
    private By forenameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By forenameFieldError = By.id("forename-err");
    private By emailFieldError = By.id("email-err");
    private By messageFieldError = By.id("message-err");
    private By headerErrorMessage = By.xpath("//div[@id='header-message']/div");
    private By successMessage = By.cssSelector("div.alert-success");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitButton() {
        clickElement(driver.findElement(submitButton));
    }

    public boolean isHeaderErrorMessageDisplayed() {
        return doesElementExist(headerErrorMessage);
    }

    public boolean areMandatoryFieldErrorsDisplayed() {
        return doAllElementsExist(forenameFieldError, emailFieldError, messageFieldError);
    }

    public void fillMandatoryFields(String forename, String email, String message) {
        enterText(driver.findElement(forenameField), forename);
        enterText(driver.findElement(emailField), email);
        enterText(driver.findElement(messageField), message);
    }

    public boolean isSubmissionSuccessful() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait.until(d -> driver.findElement(successMessage).isDisplayed());
        return true;
    }
}
