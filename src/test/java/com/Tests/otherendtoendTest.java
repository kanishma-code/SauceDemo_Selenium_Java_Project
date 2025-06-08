package com.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Baseclass.Library;
import com.pageobjects.InventoryPagePO;
import com.pageobjects.LoginPagePO;
import com.pageobjects.BackToHomePagePO;
import com.pageobjects.BikeLightInfoPagePO;  // Add this import
import com.pageobjects.CartPagePO;
import com.pageobjects.FinalCheckOutPagePO;
import com.pageobjects.InformationPagePO;

public class otherendtoendTest {

    WebDriver driver;
    Library library;
    LoginPagePO loginPage;
    InventoryPagePO inventoryPage;
    BikeLightInfoPagePO bikeLightInfoPage; // Declare BikeLightInfoPagePO
    CartPagePO cartPage;
    InformationPagePO infoPage;
    BackToHomePagePO backToHomePage;

    @BeforeClass
    public void setUp() {
        library = new Library();
        library.launchApplication();
        driver = Library.driver;

        loginPage = new LoginPagePO(driver);
        inventoryPage = new InventoryPagePO(driver);
        bikeLightInfoPage = new BikeLightInfoPagePO(driver); // Initialize BikeLightInfoPagePO
        cartPage = new CartPagePO(driver);
        infoPage = new InformationPagePO(driver);
        backToHomePage = new BackToHomePagePO(driver);
    }

    @Test(priority = 1)
    public void userNavigatesToInventoryPageWithCorrectCredentials() {
        loginPage.login("standard_user", "secret_sauce");

        // Verify the inventory page loaded correctly
        Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed(),
                "Inventory page didn't load correctly");
    }

    @Test(priority = 2)
    public void userAddsBikeLightToCartAndVerifiesRemoveButtonAppears() {
        // Add the bike light to the cart
        inventoryPage.getAddBikeLightToCartButton().click();

        // Verify the remove button for bike light is displayed, meaning it's added to the cart
        Assert.assertTrue(inventoryPage.getRemoveButtonBikeLight().isDisplayed(),
                "Remove button did not appear, item might not have been added");
    }

    @Test(priority = 3)
    public void userClicksBikeLightLabelAndNavigatesToItemDescriptionPage() {
        // Click the bike light label to navigate to the item description page
        inventoryPage.getBikeLightLabel().click();

        // Verify that the bike light description page loaded
        Assert.assertTrue(bikeLightInfoPage.getBikeLightTitle().isDisplayed(),
                "Item description page didn't load correctly");
        Assert.assertTrue(bikeLightInfoPage.getBikeLightDescription().isDisplayed(),
                "Bike light description is not displayed");
    }
    
    @Test(priority = 4)
    public void userReturnsToInventoryPage() {
        // Click the "Back to Products" button using the BikeLightInfoPagePO
        bikeLightInfoPage.getBackToProductsArrow().click();

        // Verify that the inventory page is displayed using InventoryPagePO
        Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed(),
                "Failed to return to inventory page");
    }
    
    @Test(priority = 5)
    public void userNavigatesToCartPage() {
        // Click the cart button using InventoryPagePO
        inventoryPage.getCartButton().click();

        Assert.assertTrue(cartPage.getBikeLightPrice().isDisplayed(), "Price doesn't match");
    }
    
    @Test(priority = 6)
    public void userNavigatesToInformationPageAndEntersData() {
        // Click the checkout button using CartPagePO
        cartPage.getCheckOutButton().click();

        // Use InformationPagePO to fill in the form and continue
        infoPage.getFirstName().sendKeys("John");
        infoPage.getLastName().sendKeys("Doe");
        infoPage.getPostalCode().sendKeys("12345");
        infoPage.getContinueButton().click();

        // Verify the title of the overview page
        Assert.assertTrue(infoPage.getTitle().getText().contains("Checkout: Overview"),
                "Page title is missing or incorrect");
    }
    
    @Test(priority = 7)
    public void userNavigatesToCartOverviewPageAndFinishesCheckout() {
        FinalCheckOutPagePO finalCheckoutPage = new FinalCheckOutPagePO(driver);
        BackToHomePagePO backToHomePage = new BackToHomePagePO(driver);

        // Verify item title and description
        Assert.assertTrue(finalCheckoutPage.getItemTitle().getText().contains("Sauce Labs Bike Light"),
                "Bike light title is missing or incorrect");

        Assert.assertTrue(finalCheckoutPage.getItemDesc().getText().contains("A red light isn't the desired state"),
                "Bike light description is missing or incorrect");

        // Finish checkout
        finalCheckoutPage.getFinishButton().click();

        // Verify "Thank You" page is shown
        Assert.assertTrue(backToHomePage.getFullPage().isDisplayed(),
                "Thank you page was not displayed");

    }
    
    @Test(priority = 8)
    public void userNavigatesBackToHomePage() {
        // Click the "Back to Products" button using the BackToHomePagePO
        backToHomePage.getBackToHomeButton().click();

        // Verify the inventory page is displayed again
        Assert.assertTrue(inventoryPage.getInventoryContainer().isDisplayed(), "Failed to navigate back to inventory page");
    }
    
    @AfterClass
    public void tearDown() {
        library.teardown();
    }
}
