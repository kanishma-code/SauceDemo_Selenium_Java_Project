package com.expectations;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pageobjects.InventoryPagePO;

public class InventoryPageExpectations {

    private final WebDriver driver;
    private final InventoryPagePO inventoryPage;

    public InventoryPageExpectations(WebDriver driver, InventoryPagePO inventoryPage) {
        this.driver = driver;
        this.inventoryPage = inventoryPage;
    }

    public void expectBikeLightInfoMatches() {
        String label = inventoryPage.getBikeLightLabel().getText();
        Assert.assertTrue(label.contains("Sauce Labs Bike Light"), "Bike light label did not match expected.");
    }

    public void expectLoginSuccess() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    public void expectInventoryPageExists() {
        Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed(), "Inventory container is not displayed.");
    }

    public void expectRemoveButton_BikeLightExists() {
        Assert.assertTrue(inventoryPage.getRemoveButtonBikeLight().isDisplayed(), "Remove button for bike light is not displayed.");
    }
}
