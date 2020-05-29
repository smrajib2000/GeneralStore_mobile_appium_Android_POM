package com.qa.appium.generalStore.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Properties;

import org.aspectj.apache.bcel.classfile.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.commons.Constants;
import com.qa.appium.generalStore.pages.LetsShopPage;
import com.qa.appium.generalStore.pages.cartPage;
import com.qa.appium.generalStore.pages.productsPage;

public class cartPageTest {
	BasePage basePage;
	Properties prop;
	LetsShopPage letsShopPage;
	productsPage ProductsPage;
	cartPage CartPage;
	AndroidDriver<AndroidElement> driver;
	
		
	@BeforeTest
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop,prop.getProperty("url"));
		
		letsShopPage = new LetsShopPage(driver);
		
		ProductsPage = letsShopPage.generalStorePage(prop.getProperty("name"),prop.getProperty("countryname"),prop.getProperty("gender"));
		//CartPage = ProductsPage.productsAddInTheCart(productName1);
	}
	@Test(priority=1)
	public void verifyPageTitleTest(){
		String title= CartPage.verifyPageTitle();
		System.out.println("Cart Page title is: "+title);
		Assert.assertEquals(title, Constants.CART_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyProductsAddedInTheCartTest(){
		int count=CartPage.verifyProductsAddedInTheCart();
		Assert.assertEquals(count, "4");
	}
	
	@Test(priority=3)
	public void verifyTotalPriceInTheCartTest(){
		for(int i=0;i<4;i++)
		System.out.println(CartPage.verifyTotalPriceInTheCart(i));
	}

}
