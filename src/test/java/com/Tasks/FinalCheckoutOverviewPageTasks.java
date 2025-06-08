package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.FinalCheckOutPagePO;

public class FinalCheckoutOverviewPageTasks {
    private final FinalCheckOutPagePO overviewPO;

    public FinalCheckoutOverviewPageTasks(WebDriver driver) {
        this.overviewPO = new FinalCheckOutPagePO(driver);
    }

    public void clickFinishButton() throws InterruptedException {
        Thread.sleep(500); // Replace with WebDriverWait ideally
        overviewPO.getFinishButton().click();
        Thread.sleep(500);
    }

    public void clickCancelButton() throws InterruptedException {
        Thread.sleep(500);
        overviewPO.getCancelButton().click();
        Thread.sleep(500);
    }
}
