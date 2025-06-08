package com.Tests;

import com.Baseclass.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    Library library;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize the Library class to launch the application
        library = new Library();
        library.launchApplication();  // Launch the application
        
        // Wait setup
        wait = new WebDriverWait(Library.driver, Duration.ofSeconds(10));  // Setting timeout for waiting for elements
    }

    @Test(priority = 1)
    public void it_should_navigate_to_the_home_page() {
        // Navigate to home page (Login screen already open)
        WebElement usernameField = Library.driver.findElement(By.id("user-name"));
        WebElement passwordField = Library.driver.findElement(By.id("password"));
        WebElement loginButton = Library.driver.findElement(By.id("login-button"));

        // Fill in login details
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
        
        // Wait for the inventory page to load
        WebElement inventoryPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_container")));
        
        // Verify we are on the inventory page
        Assert.assertTrue(inventoryPage.isDisplayed(), "Inventory Page not loaded");
    }

    @Test(priority = 2)
    public void it_should_navigate_to_the_search_result_page_and_display_relevant_details() {
        // Example of verifying results on the inventory page after login
        WebElement inventoryPage = Library.driver.findElement(By.cssSelector(".inventory_container"));
        Assert.assertTrue(inventoryPage.isDisplayed(), "Inventory Page not displayed");
    }

    @AfterClass
    public void tearDown() {
        library.teardown();  // Close the browser after the tests
    }
}
