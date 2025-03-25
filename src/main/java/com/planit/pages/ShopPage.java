// Page object representing the Shop page of the website, located at /shop

package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    // Add an item to cart by clicking the 'Buy' button multiple times
    public void addItemToCart(String itemName, int quantity) {
        By itemContainer = By.xpath("//h4[contains(text(), '" + itemName + "')]/ancestor::div[contains(@class, 'product')]");
        WebElement container = driver.findElement(itemContainer);
        WebElement buyButton = container.findElement(By.xpath(".//a[text()='Buy']"));
        for (int i = 0; i < quantity; i++) {
            clickElement(buyButton);
        }
    }

    // Extract the price displayed for the given item
    public double getPriceForItem(String itemName) {
        By priceLocator = By.xpath("//h4[contains(text(), '" + itemName + "')]/following-sibling::p[@class='price']");
        String priceText = driver.findElement(priceLocator).getText();
        priceText = priceText.replaceAll("[^\\.\\d]", ""); // Remove non-numeric characters except decimal
        return Double.parseDouble(priceText);
    }

    // Navigate to the Cart page via the navbar
    public void navigateToCart() {
        clickElement(driver.findElement(By.linkText("Cart")));
    }
}
