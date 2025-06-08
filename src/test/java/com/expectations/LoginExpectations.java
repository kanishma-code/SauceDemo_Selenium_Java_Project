package com.expectations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pageobjects.LoginPagePO;

public class LoginExpectations {

    private final LoginPagePO loginPage;
    private final WebDriver driver;

    public LoginExpectations(WebDriver driver, LoginPagePO loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public void expectLoginErrorExists() {
        boolean isErrorDisplayed = loginPage.getErrorMessageButton().isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Expected login error message to be displayed.");
    }

    public void expectLoginSuccess() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Expected successful login to inventory page.");
    }
}
