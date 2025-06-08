package com.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Baseclass.Library; // Import the Library class

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class endtoendTest {

    WebDriver driver;
    Library library;

    @BeforeClass
    public void setUp() {
        // Initialize the library and launch the application
        library = new Library();
        library.launchApplication();  
        driver = Library.driver;  // Get the driver from the Library class
    }

    @Test(priority = 1)
    public void userNavigatesToInventoryPageWithCorrectCredentials() {
        // Log in with valid credentials
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Verify the inventory page is displayed
        WebElement inventoryPage = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryPage.isDisplayed(), "Inventory page didn't load correctly");
    }

    @Test(priority = 2)
    public void userCanReadBikeLightInfoFromInventoryPage() {
        WebElement bikeLightInfo = driver.findElement(By.cssSelector("[data-test='item-0-title-link']"));
        Assert.assertTrue(bikeLightInfo.isDisplayed(),"Bike light info is not displayed correctly");
    }

    @Test(priority = 3)
    public void userAddsItemToCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCartButton.click();

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        Assert.assertTrue(removeButton.isDisplayed(), "Item not added to cart correctly");
    }

    @Test(priority = 4)
    public void userClicksBikeLightLabelAndNavigatesToItemDescriptionPage() {
        WebElement bikeLightLabel = driver.findElement(By.cssSelector("[data-test='item-0-title-link']"));
        bikeLightLabel.click();

        WebElement bikeLightDescriptionPage = driver.findElement(By.className("inventory_details_desc"));
        Assert.assertTrue(bikeLightDescriptionPage.isDisplayed(), "Item description page didn't load correctly");
    }

    @Test(priority = 5)
    public void userReturnsToInventoryPage() {
        WebElement backToInventoryButton = driver.findElement(By.id("back-to-products"));
        backToInventoryButton.click();

        WebElement inventoryPage = driver.findElement(By.className("inventory_container"));
        Assert.assertTrue(inventoryPage.isDisplayed(), "Failed to return to inventory page");
    }

    @Test(priority = 6)
    public void userNavigatesToCartPage() {
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        WebElement cartPage = driver.findElement(By.className("cart_list"));
        Assert.assertTrue(cartPage.isDisplayed(), "Cart page didn't load correctly");

        WebElement price = driver.findElement(By.className("inventory_item_price"));
        Assert.assertTrue(price.isDisplayed(), "Price doesn't match");
    }

    @Test(priority = 7)
    public void userNavigatesToInformationPageAndEntersData() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement zipCodeField = driver.findElement(By.id("postal-code"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        zipCodeField.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement infoPageTitle = driver.findElement(By.className("title"));
        assertThat("Page title is missing or incorrect", infoPageTitle.getText(), containsString("Checkout: Overview"));
    }
    
    @Test(priority = 8)
    public void userNavigatesToCartOverviewPageAndFinishesCheckout() {
        WebElement bikeLightTitle = driver.findElement(By.className("cart_item_label"));
        assertThat("bikeLightTitle is missing or incorrect", bikeLightTitle.getText(), containsString("Sauce Labs Bike Light"));

        WebElement bikeLightDesc = driver.findElement(By.className("inventory_item_desc"));
        assertThat("bikeLightDesc is missing or incorrect", bikeLightDesc.getText(), containsString("A red light isn't the desired state"));

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement thankYouNote = driver.findElement(By.className("complete-header"));
        assertThat("Thank you note is missing or incorrect", thankYouNote.getText(), containsString("Thank you for your order!"));
    }

    @Test(priority = 9)
    public void userNavigatesBackToHomePage() {
        WebElement backToHomeButton = driver.findElement(By.id("back-to-products"));
        backToHomeButton.click();

        WebElement inventoryPage = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryPage.isDisplayed(), "Failed to navigate back to inventory page");
    }

    @AfterClass
    public void tearDown() {
        library.teardown();  // Use the library's teardown method to close the browser
    }
}
