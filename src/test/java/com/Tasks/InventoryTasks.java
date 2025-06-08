package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.InventoryPagePO;
import com.pageobjects.LoginPagePO;

public class InventoryTasks {
    private final InventoryPagePO inventoryPagePO;
    private final LoginPagePO loginPagePO;
    private final WebDriver driver;

    public InventoryTasks(WebDriver driver) {
        this.driver = driver;
        this.inventoryPagePO = new InventoryPagePO(driver);
        this.loginPagePO = new LoginPagePO(driver);
    }

    public void openWebPage() {
        driver.get("https://www.saucedemo.com");
    }

    public void loginUsingData(String username, String password) throws InterruptedException {
        loginPagePO.getUsernameField().sendKeys(username);
        loginPagePO.getPasswordField().sendKeys(password);
        Thread.sleep(500);
        loginPagePO.getLoginButton().click();
        Thread.sleep(500);
    }

    public void closeErrorButton() throws InterruptedException {
        Thread.sleep(500);
        loginPagePO.getErrorMessageButton().click();
        Thread.sleep(500);
    }

    public void addItemToCart() throws InterruptedException {
        inventoryPagePO.getAddBikeLightToCartButton().click();
        Thread.sleep(500);
    }

    public void clickItemForInfo() throws InterruptedException {
        inventoryPagePO.getBikeLightLabel().click();
        Thread.sleep(500);
    }

    public void clickCartButton() throws InterruptedException {
        inventoryPagePO.getCartButton().click();
        Thread.sleep(500);
    }
}
