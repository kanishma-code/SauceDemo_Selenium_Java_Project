package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.CartPagePO;

public class CartPageTasks {
    private final WebDriver driver;
    private final CartPagePO cartPage;

    public CartPageTasks(WebDriver driver) {
        this.driver = driver;
        this.cartPage = new CartPagePO(driver);
    }

    public void clickCheckOutButton() throws InterruptedException {
        Thread.sleep(500);
        cartPage.getCheckOutButton().click();
        Thread.sleep(500);
    }

    public void clickContinueShoppingButton() throws InterruptedException {
        Thread.sleep(500);
        cartPage.getContinueShoppingButton().click();
        Thread.sleep(500);
    }

    public void clickRemoveBikeLightButton() throws InterruptedException {
        Thread.sleep(500);
        cartPage.getRemoveBikeLightButton().click();
        Thread.sleep(500);
    }
}
