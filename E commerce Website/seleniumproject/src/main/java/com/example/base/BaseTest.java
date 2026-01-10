package com.example.base;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://www.saucedemo.com/"); // or OpenCart demo URL
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

