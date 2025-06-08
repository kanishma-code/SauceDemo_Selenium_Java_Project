package com.expectations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.FinalCheckOutPagePO;

public class CheckoutFinalOverviewPageExpectations {

    private WebDriver driver;
    private FinalCheckOutPagePO finalCheckOutPagePO;

    // Constructor
    public CheckoutFinalOverviewPageExpectations(WebDriver driver) {
        this.driver = driver;
        this.finalCheckOutPagePO = new FinalCheckOutPagePO(driver);  // Initialize Page Object
    }

    // Expectation for the page title
    public void infoPageTitleMatches() {
        WebElement titleElement = finalCheckOutPagePO.getTitle();
        String titleText = titleElement.getText();
        
        // Assert that the title contains "Checkout: Overview"
        Assert.assertTrue(
            titleText.contains("Checkout: Overview"),
            "Expected page title to contain 'Checkout: Overview', but got: " + titleText
        );
    }

    // Expectation for the bike light item title
    public void bikeLightTitleMatches() {
        WebElement itemTitleElement = finalCheckOutPagePO.getItemTitle();
        String itemTitleText = itemTitleElement.getText();
        
        // Assert that the item title contains "Sauce Labs Bike Light"
        Assert.assertTrue(
            itemTitleText.contains("Sauce Labs Bike Light"),
            "Expected item title to contain 'Sauce Labs Bike Light', but got: " + itemTitleText
        );
    }

    // Expectation for the bike light item description
    public void bikeLightDescMatches() {
        WebElement itemDescElement = finalCheckOutPagePO.getItemDesc();
        String itemDescText = itemDescElement.getText();
        
        // Assert that the item description contains the expected description
        Assert.assertTrue(
            itemDescText.contains("Water-resistant with 3 lighting modes, 1 AAA battery included."),
            "Expected item description to contain 'Water-resistant with 3 lighting modes, 1 AAA battery included.', but got: " + itemDescText
        );
    }
}
