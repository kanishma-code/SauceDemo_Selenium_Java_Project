package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackToHomePagePO {

    private WebDriver driver;

    public BackToHomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Thank You" page (checkout_complete_container class)
    private By fullPageLocator = By.className("checkout_complete_container");

    // Locator for the "Back to Products" button
    private By backToHomeButtonLocator = By.id("back-to-products");

    // Method to get the "Thank You" page element
    public WebElement getFullPage() {
        return driver.findElement(fullPageLocator);  // Correctly using `By` locator
    }

    // Method to get the "Back to Products" button
    public WebElement getBackToHomeButton() {
        return driver.findElement(backToHomeButtonLocator);  // Correctly using `By` locator
    }
}
