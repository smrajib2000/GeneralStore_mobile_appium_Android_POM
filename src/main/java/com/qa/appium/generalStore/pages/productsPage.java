package com.qa.appium.generalStore.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Properties;

import org.openqa.selenium.By;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.util.ElementActions;

public class productsPage extends BasePage{
	
	AndroidDriver<AndroidElement> driver;
	ElementActions elementActions;
	Properties prop;
	
	By titleProduct = By.xpath("//android.widget.TextView[@text='Products']");
	//By productName1 = By.id("com.androidsample.generalstore:id/productName");
	By tabAddToCart = By.id("com.androidsample.generalstore:id/productAddCart");
	By countOfTotalItemsInCart= By.id("com.androidsample.generalstore:id/counterText");
	By CartButton= By.id("com.androidsample.generalstore:id/appbar_btn_cart");
	By titleCart= By.id("com.androidsample.generalstore:id/toolbar_title");
	By cartContainer= By.id("com.androidsample.generalstore:id/rvCartProductList");
	By itemsIntheCart= By.id("com.androidsample.generalstore:id/productPrice");
	By totalPurchaseAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");
	By totalPriceOfCart=By.id("com.androidsample.generalstore:id/totalAmountLbl");
	
	public productsPage(AndroidDriver<AndroidElement> driver){
		
		this.driver = driver;
		elementActions = new ElementActions(driver);
		
	}
	public String verifyPageTitle(){
		return elementActions.getTextElement(titleProduct);
	}
	
	
	public void productsAddInTheCart(String productNameVal1){
		
		elementActions.findElementByAndroidUIAutomatorclick(productNameVal1);
		elementActions.clickOnElement(tabAddToCart);
		
		
	}
	
	public String productCountInTheCart(){
		return elementActions.getTextElement(countOfTotalItemsInCart);
	}
	
	public void gotToTheCartPage() {
		elementActions.clickOnElement(CartButton);
		
	}
	public String verifyPageTitlecart(){
		
		return elementActions.getTextElement(titleCart);
	}
	public int verifyProductsAddedInTheCart(){
		return elementActions.lisOfElements(itemsIntheCart).size();
		
	}
public double verifyTotalPriceInTheCart(int index){
	
		elementActions.lisOfElements(cartContainer).get(0);
		
		double cartPrice1=Double.parseDouble(elementActions.lisOfElements(itemsIntheCart).get(index).getText().replaceAll("[^.0-9]", ""));
			return cartPrice1;
	
	}
public double verifyTotalPrice(){
	 double cartPrice2=Double.parseDouble(elementActions.getTextElement(totalPriceOfCart).replaceAll("[^.0-9]", ""));
	 return cartPrice2;
}

}
