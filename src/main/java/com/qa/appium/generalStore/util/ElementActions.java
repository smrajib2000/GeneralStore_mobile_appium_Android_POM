package com.qa.appium.generalStore.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.commons.Constants;


public class ElementActions extends BasePage{

	AndroidDriver<AndroidElement> driver;
	
	public ElementActions(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		
	}
	
	public MobileElement getElement(By selector){
		MobileElement element = null;
		try{
			WebDriverWait wait =new WebDriverWait(driver,Constants.DEFAULT_EXPLICIt_WAIT);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		
			element = driver.findElement(selector);
		}catch(Exception e){
			System.out.println("Element could not be created");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return element;
	
	}
	
	
	public void findElementByAndroidUIAutomatorclick(String exactCountry){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+exactCountry+"\"));").click();;
	}
	public void sendKeysElement(By selector, String value){
		getElement(selector).sendKeys(value);
	}
	
	public void clickOnElement(By selector){
		getElement(selector).click();
	}
	
	public String getTextElement(By selector){
		return getElement(selector).getText();
		
	}
	public  List<AndroidElement> lisOfElements(By selector){
		return driver.findElements(selector);
	}

	
	
}
