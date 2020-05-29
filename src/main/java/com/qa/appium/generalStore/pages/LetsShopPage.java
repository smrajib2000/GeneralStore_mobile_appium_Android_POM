package com.qa.appium.generalStore.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.util.ElementActions;

public class LetsShopPage extends BasePage{
	
	AndroidDriver<AndroidElement> driver;
	ElementActions elementActions;
	Properties prop;
	
	By tapcountry = By.id("com.androidsample.generalstore:id/spinnerCountry");
	By appTitle = By.xpath("//android.widget.TextView[@text='General Store']");
	By username = By.id("com.androidsample.generalstore:id/nameField");
	By male = By.id("com.androidsample.generalstore:id/radioMale");
	By female = By.id("com.androidsample.generalstore:id/radioFemale");
	By button = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	public LetsShopPage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
		
	}
	
	public String getPageTitle(){
		return elementActions.getTextElement(appTitle);
	}
	
	public productsPage generalStorePage(String name,String countryName,String Gender){
		elementActions.clickOnElement(tapcountry);
		elementActions.findElementByAndroidUIAutomatorclick(countryName);
		
		elementActions.sendKeysElement(username, name);
		if(Gender.equals("female")){
		elementActions.clickOnElement(female);
		}else if(Gender.equals("male")){
			elementActions.clickOnElement(male);
		}else{
			System.out.println("Element not found");
		}
		//elementActions.clickOnElement(selectGenderFemale);
		elementActions.clickOnElement(button);
		
		return new productsPage(driver);
	}
	

}
