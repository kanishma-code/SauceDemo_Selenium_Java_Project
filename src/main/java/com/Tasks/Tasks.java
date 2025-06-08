package com.Tasks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Baseclass.Library;

public class Tasks extends Library{
	
	public Tasks(WebDriver driver) {
		Library.driver = driver;
	}
	
	public void EnterValue(WebElement element, String Text) {
		try {
			element.sendKeys(Text);
		}
		catch(Exception e) {
			System.out.println("No such elemenet exception");
		}
	}
	
	public void click(WebElement element) {
		try {
			element.click();;
		}
		catch(Exception e) {
			System.out.println("No such elemenet exception");
		}
	}
	
	public void GetTitle() {
		try {
			System.out.println(driver.getTitle());
		}
		catch(Exception e) {
			System.out.println("No such title");
		}
	}
	
	public void screenshot(String path) {
		
		TakesScreenshot TS = (TakesScreenshot)driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File(path));
		}
		catch(Exception e) {
			System.out.println("Screenshot not found");
		}
	}
}
