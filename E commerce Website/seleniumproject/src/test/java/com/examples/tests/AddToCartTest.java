package com.examples.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import com.example.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addAndRemoveCartFlow() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        ProductsPage products = new ProductsPage(driver);
        int before = products.getProductCount();
        Assert.assertTrue(before > 0, "No products found");

        products.addProductToCartByIndex(0);
        Assert.assertEquals(products.getCartBadgeCount(), "1");

        products.openCart();
        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.itemsInCart(), 1);

        cart.removeItemByIndex(0);
        Assert.assertEquals(cart.itemsInCart(), 0);
    }
}
