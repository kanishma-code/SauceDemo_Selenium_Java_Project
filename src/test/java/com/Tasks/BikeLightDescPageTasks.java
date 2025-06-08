package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.BikeLightInfoPagePO;

public class BikeLightDescPageTasks {
    private final WebDriver driver;
    private final BikeLightInfoPagePO bikeLightInfoPagePO;

    public BikeLightDescPageTasks(WebDriver driver) {
        this.driver = driver;
        this.bikeLightInfoPagePO = new BikeLightInfoPagePO(driver);
    }

    public void returnToDescPage() throws InterruptedException {
        Thread.sleep(500);
        bikeLightInfoPagePO.getBackToProductsArrow().click();
        Thread.sleep(500);
    }
}
