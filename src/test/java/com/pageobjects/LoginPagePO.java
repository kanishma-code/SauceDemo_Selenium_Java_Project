package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {

    private WebDriver driver;

    public LoginPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageContainer = By.cssSelector(".error-message-container.error");
    private By errorMessageButton = By.cssSelector(".error-button");

    // Element Getters
    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getErrorMessageContainer() {
        return driver.findElement(errorMessageContainer);
    }

    public WebElement getErrorMessageButton() {
        return driver.findElement(errorMessageButton);
    }

    // Login Action
    public void login(String username, String password) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}

