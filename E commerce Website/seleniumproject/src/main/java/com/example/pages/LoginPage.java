package com.example.pages;

import org.openqa.selenium.*;
import com.example.base.WaitUtils;

public class LoginPage {
    private WebDriver driver;
    private WaitUtils wait;

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void enterUsername(String user) {
        wait.waitForVisible(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(user);
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMsg).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
