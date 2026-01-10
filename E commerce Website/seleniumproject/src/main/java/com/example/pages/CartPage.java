package com.example.pages;

import org.openqa.selenium.*;
import com.example.base.WaitUtils;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WaitUtils wait;
    private By cartItems = By.cssSelector(".cart_item");
    private By removeButtons = By.cssSelector("button.cart_button"); // adjust selector
    private By checkoutBtn = By.cssSelector("button.checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public int itemsInCart() {
        return driver.findElements(cartItems).size();
    }

    public void removeItemByIndex(int idx) {
        List<WebElement> removes = driver.findElements(removeButtons);
        removes.get(idx).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
