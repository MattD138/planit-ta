// Page object representing the Cart page of the website, located at /cart

package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {
    // Locators for cart rows and total value
    private By cartRows = By.cssSelector("table.cart tbody tr");
    private By totalLocator = By.id("total");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Verify that a specific line item has the correct price and subtotal calculation
    public boolean verifyLineItem(String itemName, double expectedPrice) {
        By rowLocator = By.xpath("//table[contains(@class, 'cart')]//tr[td[contains(text(), '" + itemName + "')]]");
        WebElement row = driver.findElement(rowLocator);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        // Assuming columns: [Item Name, Price, Quantity, Subtotal]
        double price = Double.parseDouble(cells.get(1).getText().replace("$", "").trim());
        int quantity = Integer.parseInt(cells.get(2).getText().trim());
        double subtotal = Double.parseDouble(cells.get(3).getText().replace("$", "").trim());
        return price == expectedPrice && subtotal == price * quantity;
    }

    // Verify that the total value equals the sum of all subtotals
    public boolean verifyTotal() {
        List<WebElement> rows = driver.findElements(cartRows);
        double sum = 0.0;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            double subtotal = Double.parseDouble(cells.get(3).getText().replace("$", "").trim());
            sum += subtotal;
        }
        double displayedTotal = Double.parseDouble(driver.findElement(totalLocator).getText().replace("$", "").trim());
        return sum == displayedTotal;
    }
}
