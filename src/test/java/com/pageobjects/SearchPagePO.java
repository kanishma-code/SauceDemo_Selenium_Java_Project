package com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Baseclass.Library;

import com.Tasks.Tasks;

public class SearchPagePO extends Library {
    
    WebDriver driver;
    Tasks username;
    WebDriver driver1;
    Tasks password;

    // Constructor
    public SearchPagePO(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");  // Check if driver is null
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameTextbox;

    @FindBy(id = "password")
    private WebElement passwordTextbox;

    @FindBy(id = "login-button")
    private WebElement loginbuttonElement;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessageContainer;

    @FindBy(css = ".error-button")
    private WebElement errorMessageButton;

    @FindBy(className = "login_container")
    private WebElement Homepage;
    
    @FindBy(className = "login_logo")
    private WebElement Logo;

    @FindBy(id = "inventory_container")
    private WebElement AfterLoginScreen;

    public void Username(String Text) {
        username = new Tasks(driver);
        username.EnterValue(usernameTextbox, Text);
        usernameTextbox.sendKeys(Keys.TAB);  // Move to password field
    }

    public void Password(String Text) {
        password = new Tasks(driver);
        password.EnterValue(passwordTextbox, Text);
        passwordTextbox.sendKeys(Keys.ENTER);  // Press Enter to submit
    }

    public void ClickTab() {
        usernameTextbox.sendKeys(Keys.TAB);
    }

    public void Homescreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Homepage));
        System.out.println(Homepage.isEnabled());
    }

    public void AfterLoginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(AfterLoginScreen));
        System.out.println(AfterLoginScreen.isEnabled());
    }
    
    public void Logo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Homepage));
        System.out.println(Logo.isDisplayed());
    }
}
