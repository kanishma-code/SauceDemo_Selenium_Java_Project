package com.expectations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.BikeLightInfoPagePO;

public class BikeLightInfoPageExpectations {

    private WebDriver driver;
    private BikeLightInfoPagePO bikeLightInfoPage;

    // Constructor
    public BikeLightInfoPageExpectations(WebDriver driver) {
        this.driver = driver;
        this.bikeLightInfoPage = new BikeLightInfoPagePO(driver);  // Initialize the page object
    }

    // Expectation method to verify the Bike Light Info page
    public void expectBikeLightInformationPage() {
        WebElement bikeLightTitleElement = bikeLightInfoPage.getBikeLightTitle();
        WebElement bikeLightDescriptionElement = bikeLightInfoPage.getBikeLightDescription();

        // Assert that the title contains "Sauce Labs Bike Light"
        String bikeLightTitleText = bikeLightTitleElement.getText();
        Assert.assertTrue(bikeLightTitleText.contains("Sauce Labs Bike Light"),
                "Expected Bike Light Title to contain 'Sauce Labs Bike Light', but got: " + bikeLightTitleText);

        // Assert that the description contains "1 AAA battery included."
        String bikeLightDescriptionText = bikeLightDescriptionElement.getText();
        Assert.assertTrue(bikeLightDescriptionText.contains("1 AAA battery included."),
                "Expected Bike Light Description to contain '1 AAA battery included.', but got: " + bikeLightDescriptionText);
    }
}
