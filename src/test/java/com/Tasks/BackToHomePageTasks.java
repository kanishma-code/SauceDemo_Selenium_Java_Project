package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.BackToHomePagePO;

public class BackToHomePageTasks {
    private final WebDriver driver;
    private final BackToHomePagePO backToHomePagePO;

    public BackToHomePageTasks(WebDriver driver) {
        this.driver = driver;
        this.backToHomePagePO = new BackToHomePagePO(driver);
    }

    public void clickBackToHomeButton() throws InterruptedException {
        Thread.sleep(500); // Replace with WebDriverWait in real tests
        backToHomePagePO.getBackToHomeButton().click();
        Thread.sleep(500);
    }
}
