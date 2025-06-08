package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPagePO {

    private WebDriver driver;

    // Constructor
    public CartPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the Cart Page elements
    private By checkOutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");
    private By bikeLightPrice = By.cssSelector(".inventory_item_price");

    // Getters for the Cart Page elements
    public WebElement getCheckOutButton() {
        return driver.findElement(checkOutButton);
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButton);
    }

    public WebElement getRemoveBikeLightButton() {
        return driver.findElement(removeBikeLightButton);
    }

    public WebElement getBikeLightPrice() {
        return driver.findElement(bikeLightPrice);
    }
}
