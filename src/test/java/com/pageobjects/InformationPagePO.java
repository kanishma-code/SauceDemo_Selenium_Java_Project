package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationPagePO {

    private WebDriver driver;

    public InformationPagePO(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By title = By.cssSelector(".title");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");

    // Getters
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public WebElement getPostalCode() {
        return driver.findElement(postalCode);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }
}
