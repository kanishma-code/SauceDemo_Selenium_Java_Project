package com.expectations;
import org.testng.Assert;

import com.pageobjects.InformationPagePO;

public class InfoPageExpectations {

    private final InformationPagePO infoPage;

    public InfoPageExpectations(InformationPagePO infoPage) {
        this.infoPage = infoPage;
    }

    public void infoPageTitleMatches() {
        String actualTitle = infoPage.getTitle().getText();
        Assert.assertTrue(
            actualTitle.contains("Checkout: Your Information"),
            "Expected page title to contain 'Checkout: Your Information', but was: " + actualTitle
        );
    }
}
