package com.Tasks;

import org.openqa.selenium.WebDriver;

import com.pageobjects.InformationPagePO;

public class InformationPageTasks {
    private final InformationPagePO informationPagePO;

    public InformationPageTasks(WebDriver driver) {
        this.informationPagePO = new InformationPagePO(driver);
    }

    public void enterData(String firstName, String lastName, String postalCode) {
        informationPagePO.getFirstName().sendKeys(firstName);
        informationPagePO.getLastName().sendKeys(lastName);
        informationPagePO.getPostalCode().sendKeys(postalCode);
    }

    public void clickContinueButton() throws InterruptedException {
        Thread.sleep(500);
        informationPagePO.getContinueButton().click();
        Thread.sleep(500);
    }

    public void clickCancelButton() throws InterruptedException {
        Thread.sleep(500);
        informationPagePO.getCancelButton().click();
        Thread.sleep(500);
    }
}
