package com.qa.appium.generalStore.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Properties;

import org.openqa.selenium.By;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.util.ElementActions;

public class cartPage extends BasePage{
	
	AndroidDriver<AndroidElement> driver;
	ElementActions elementActions;
	Properties prop;
	
	By title= By.id("com.androidsample.generalstore:id/toolbar_title");
	By cartContainer= By.id("com.androidsample.generalstore:id/rvCartProductList");
	By itemsIntheCart= By.id("com.androidsample.generalstore:id/productPrice");
	By totalPurchaseAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");
	
	public cartPage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
		
	}
	
	public String verifyPageTitle(){
		return elementActions.getTextElement(title);
	}
	
	public int verifyProductsAddedInTheCart(){
		return elementActions.lisOfElements(itemsIntheCart).size();
		
	}

	public String verifyTotalPriceInTheCart(int index){
		
		elementActions.lisOfElements(cartContainer).get(0);
		
			return elementActions.lisOfElements(itemsIntheCart).get(index).getText().replaceAll("[^.0-9]", "");
			
	
	}
}
