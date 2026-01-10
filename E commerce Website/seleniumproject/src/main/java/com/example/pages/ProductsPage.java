package com.example.pages;

import org.openqa.selenium.*;
import com.example.base.WaitUtils;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private WaitUtils wait;

    private By productList = By.cssSelector(".inventory_item");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By cartLink = By.cssSelector(".shopping_cart_link");
    private By searchBox = By.cssSelector("input[placeholder='Search']"); // if demo supports search

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public int getProductCount() {
        return driver.findElements(productList).size();
    }

    public void addProductToCartByIndex(int index) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(index).click();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public String getCartBadgeCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (NoSuchElementException e) {
            return "0";
        }
    }
}
