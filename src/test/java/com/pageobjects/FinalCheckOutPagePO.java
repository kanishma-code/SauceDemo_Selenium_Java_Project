package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalCheckOutPagePO {

    private WebDriver driver;

    // Constructor
    public FinalCheckOutPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the elements on the final checkout page
    private By title = By.cssSelector(".title");
    private By itemTitle = By.id("item_0_title_link");
    private By itemDesc = By.cssSelector(".inventory_item_desc");
    private By finishButton = By.id("finish");
    private By cancelButton = By.id("cancel");

    // Getters for the elements
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getItemTitle() {
        return driver.findElement(itemTitle);
    }

    public WebElement getItemDesc() {
        return driver.findElement(itemDesc);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }
}
