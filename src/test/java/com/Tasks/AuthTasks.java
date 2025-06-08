package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.LoginPagePO;

public class AuthTasks {
    private final WebDriver driver;
    private final LoginPagePO loginPagePO;

    public AuthTasks(WebDriver driver) {
        this.driver = driver;
        this.loginPagePO = new LoginPagePO(driver);
    }

    public void openWebPage() {
        driver.get("https://www.saucedemo.com");
    }

    public void loginUsingData(String username, String password) throws InterruptedException {
        loginPagePO.getUsernameField().sendKeys(username);
        loginPagePO.getPasswordField().sendKeys(password);
        Thread.sleep(500);
        loginPagePO.getLoginButton().click();
        Thread.sleep(500);
    }

    public void closeErrorButton() throws InterruptedException {
        Thread.sleep(500);
        loginPagePO.getErrorMessageButton().click();
        Thread.sleep(500);
    }
}
