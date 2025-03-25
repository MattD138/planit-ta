// Contains TestNG test scripts for validating Contact page functions.
// Covers test cases 1 and 2 as specified in the technical assessment.

package com.planit;

import com.planit.pages.ContactPage;
import com.planit.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTests extends BaseTest {
    private HomePage homePage;
    private ContactPage contactPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    // Test Case 1: Validate error messages and clear them after populating mandatory fields
    @Test
    public void testContactFormValidation() {
        homePage.navigateToContactPage();
        contactPage.clickSubmitButton();

        // Verify header error message exists
        boolean headerError = contactPage.isHeaderErrorMessageDisplayed();
        Assert.assertTrue(headerError, "Header error message should be displayed");

        // Verify that mandatory fields show error messages when not populated
        Assert.assertTrue(contactPage.areMandatoryFieldErrorsDisplayed(), "Mandatory field error messages should be displayed");

        // Populate mandatory fields with dummy data
        contactPage.fillMandatoryFields("John Doe", "john.doe@example.com", "Test message");

        // Validate that error messages are cleared
        Assert.assertFalse(contactPage.areMandatoryFieldErrorsDisplayed(), "Error messages should be gone after filling mandatory fields");
    }

    // Test Case 2: Successful form submission
    // Run 5 times to ensure 100% pass rate
    @Test(invocationCount = 5)
    public void testSuccessfulContactFormSubmission() {
        homePage.navigateToContactPage();
        contactPage.fillMandatoryFields("Jane Doe", "jane.doe@example.com", "Another test message");
        contactPage.clickSubmitButton();

        // Validate that a successful submission message is displayed
        Assert.assertTrue(contactPage.isSubmissionSuccessful(), "Successful submission message should be displayed");
    }
}
