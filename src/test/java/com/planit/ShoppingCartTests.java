// Contains TestNG test scripts for validating Shop and Cart page functions.
// Covers test case 3 as specified in the technical assessment.

package com.planit;

import com.planit.pages.CartPage;
import com.planit.pages.HomePage;
import com.planit.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {
    private HomePage homePage;
    private ShopPage shopPage;
    private CartPage cartPage;

    private double shopPriceStuffedFrog;
    private double shopPriceFluffyBunny;
    private double shopPriceValentineBear;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
    }

    // Test Case 3: Verify shopping cart calculations and price consistency
    @Test
    public void testShoppingCartCalculations() {
        // Navigate to Shop page from Home
        homePage.navigateToShopPage();

        // Extract prices and add items to cart
        shopPriceStuffedFrog = shopPage.getPriceForItem("Stuffed Frog");
        shopPage.addItemToCart("Stuffed Frog", 2);

        shopPriceFluffyBunny = shopPage.getPriceForItem("Fluffy Bunny");
        shopPage.addItemToCart("Fluffy Bunny", 5);

        shopPriceValentineBear = shopPage.getPriceForItem("Valentine Bear");
        shopPage.addItemToCart("Valentine Bear", 3);

        // Navigate to Cart page
        shopPage.navigateToCart();

        // Verify each line item: price consistency and correct subtotal calculation
        Assert.assertTrue(cartPage.verifyLineItem("Stuffed Frog", shopPriceStuffedFrog), "Stuffed Frog line item verification failed");
        Assert.assertTrue(cartPage.verifyLineItem("Fluffy Bunny", shopPriceFluffyBunny), "Fluffy Bunny line item verification failed");
        Assert.assertTrue(cartPage.verifyLineItem("Valentine Bear", shopPriceValentineBear), "Valentine Bear line item verification failed");

        // Verify total value in cart
        Assert.assertTrue(cartPage.verifyTotal(), "Cart total calculation is incorrect");
    }
}
