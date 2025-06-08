package com.expectations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.CartPagePO;

public class CartPageExpectations {

    private WebDriver driver;
    private CartPagePO cartPagePO;

    // Constructor
    public CartPageExpectations(WebDriver driver) {
        this.driver = driver;
        this.cartPagePO = new CartPagePO(driver);  // Initialize Page Object
    }

    // Expectation to verify the Bike Light Price
    public void expectBikeLightPriceMatches() {
        WebElement bikeLightPriceElement = cartPagePO.getBikeLightPrice();  // Get the Bike Light price element
        String bikeLightPriceText = bikeLightPriceElement.getText();

        // Assert that the price contains '9.99'
        Assert.assertTrue(
            bikeLightPriceText.contains("9.99"),
            "Expected Bike Light Price to be '9.99', but got: " + bikeLightPriceText
        );
    }
}
