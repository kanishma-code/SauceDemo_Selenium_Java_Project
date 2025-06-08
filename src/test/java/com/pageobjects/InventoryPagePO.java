package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPagePO {

    private WebDriver driver;

    public InventoryPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By inventoryContainer = By.className("inventory_container");
    private By bikeLightLabel = By.cssSelector("[data-test='item-0-title-link']");
    private By addBikeLightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.className("shopping_cart_link");
    private By removeButtonBikeLight = By.id("remove-sauce-labs-bike-light"); 
    private By removeButtonBackpack = By.id("remove-sauce-labs-backpack");

    // Element Getters
    public WebElement getInventoryContainer() {
        return driver.findElement(inventoryContainer);
    }

    public WebElement getBikeLightLabel() {
        return driver.findElement(bikeLightLabel);
    }

    public WebElement getAddBikeLightToCartButton() {
        return driver.findElement(addBikeLightToCartButton);
    }

    public WebElement getCartButton() {
        return driver.findElement(cartButton);
    }

    public WebElement getRemoveButtonBikeLight() {
        return driver.findElement(removeButtonBikeLight);
    }

    public WebElement getRemoveButtonBackpack() {
        return driver.findElement(removeButtonBackpack);
    }
}
