package com.examples.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login should land on products page")
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        // validate product list visible
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Not on products page");
    }

    @Test(description = "Invalid login shows error")
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("invalid");
        login.enterPassword("wrong");
        login.clickLogin();
        Assert.assertTrue(login.isErrorDisplayed(), "Error message not shown");
    }
}

