package com.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Library {

    public static WebDriver driver;

    public void launchApplication() {
        // Set the URL to the desired website
        String url = "https://www.saucedemo.com/"; // This is your desired URL

        try {
            // Launch Chrome browser
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);

            // Configure driver
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Open the URL
            driver.get(url);
            
            // Refresh the page if needed
            driver.navigate().refresh(); // Refreshes the page after loading

        } catch (Exception e) {
            System.out.println("An error occurred while launching the browser.");
            e.printStackTrace();
        }
    }

    // Teardown method to close the browser
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Use quit to properly close the browser and associated processes
        }
    }
}