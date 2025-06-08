package com.expectations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.BackToHomePagePO;

public class BackToHomePageExpectations {

    private WebDriver driver;
    private BackToHomePagePO backToHomePage;

    public BackToHomePageExpectations(WebDriver driver) {
        this.driver = driver;
        this.backToHomePage = new BackToHomePagePO(driver);  // Create a new instance of the Page Object
    }

    public void expectThankYouNoteExists() {
        WebElement fullPageElement = backToHomePage.getFullPage();  // Get the element using the Page Object
        String thankYouText = fullPageElement.getText();
        
        // Assert that the 'Thank You' message exists on the page
        Assert.assertTrue(
            thankYouText.contains("Thank You"),
            "Expected the page to contain 'Thank You', but got: " + thankYouText
        );
    }
}
