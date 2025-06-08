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

public class InvalidLoginTest {

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

    @Test
    public void testLoginWithInvalidCredentials() {
        // Perform login with invalid credentials
        WebElement usernameField = Library.driver.findElement(By.id("user-name"));
        WebElement passwordField = Library.driver.findElement(By.id("password"));
        WebElement loginButton = Library.driver.findElement(By.id("login-button"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Wait for the error message to appear
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container.error")));

        // Assert that the error message is visible
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        // Optionally, close the error message (assuming there's a button for this)
        WebElement errorMessageButton = Library.driver.findElement(By.cssSelector(".error-button"));
        errorMessageButton.click();
    }

    @AfterClass
    public void tearDown() {
        library.teardown();  // Close the browser after the tests
    }
}
