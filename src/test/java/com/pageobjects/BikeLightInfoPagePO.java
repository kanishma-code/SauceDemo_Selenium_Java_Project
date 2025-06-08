package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BikeLightInfoPagePO {

    private WebDriver driver;

    public BikeLightInfoPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the elements on the Bike Light Info Page
    private By inventoryItemInfoPage = By.id("inventory_item_container");
    private By bikeLightTitle = By.cssSelector("[data-test='inventory-item-name']");
    private By bikeLightDescription = By.cssSelector("[data-test='inventory-item-desc']");
    private By addToCartButton = By.id("add-to-cart");
    private By backToProductsArrow = By.id("back-to-products");

    // Getters for the elements
    public WebElement getInventoryItemInfoPage() {
        return driver.findElement(inventoryItemInfoPage);
    }

    public WebElement getBikeLightTitle() {
        return driver.findElement(bikeLightTitle);
    }

    public WebElement getBikeLightDescription() {
        return driver.findElement(bikeLightDescription);
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButton);
    }

    public WebElement getBackToProductsArrow() {
        return driver.findElement(backToProductsArrow);
    }
}
