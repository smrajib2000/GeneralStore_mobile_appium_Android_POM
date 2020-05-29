package com.qa.appium.generalStore.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.commons.Constants;
import com.qa.appium.generalStore.pages.LetsShopPage;
import com.qa.appium.generalStore.pages.productsPage;
import com.qa.appium.generalStore.util.CommonUtil;
import com.qa.appium.generalStore.util.ExcellUtil;

public class productPageTest {
	BasePage basePage;
	Properties prop;
	LetsShopPage letsShopPage;
	productsPage ProductsPage;
	
	AndroidDriver<AndroidElement> driver;
	
		
	@BeforeTest
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop,prop.getProperty("url"));
		
		letsShopPage = new LetsShopPage(driver);
		
		ProductsPage = letsShopPage.generalStorePage(prop.getProperty("name"),prop.getProperty("countryname"),prop.getProperty("gender"));
		
	}
	
	@Test(priority=1)
	public void verifyProductPageTitleTest(){
		
		String ProductPageTitle = ProductsPage.verifyPageTitle();
		
		System.out.println("Product Page Title is :"+ProductPageTitle);
		Assert.assertEquals(ProductPageTitle, Constants.PRODUCTPAGE_TITLE);
		
	
	}
	
	@DataProvider(name = "getAddCartData")
	public Object[][] getAddTocartTestData(){
		Object addToCartData[][]=ExcellUtil.getTestData("Products");
		return addToCartData;
	}
	
	
	@Test(dataProvider = "getAddCartData",priority=2)
	public void productsAddIntheCartTest(String productName1){
		
		ProductsPage.productsAddInTheCart(productName1);
		
	}
	@Test(priority=3)
	public void productsAddInTheCartTest(){
		String TotalProductInCart=ProductsPage.productCountInTheCart();
		//int count=ProductsPage.verifyProductsAddedInTheCart();
		System.out.println("Total products added in the cart: "+TotalProductInCart);
		Assert.assertEquals(TotalProductInCart, "4");
		}
	@Test(priority=4)
	public void gotToTheCartTest(){
		ProductsPage.gotToTheCartPage();
		
	}
	@Test(priority=5)
	public void verifycartPageTitleTest(){
		
		String title= ProductsPage.verifyPageTitlecart();
		System.out.println("Cart Page title is: "+title);
		Assert.assertEquals(title, Constants.CART_PAGE_TITLE);
	}
	@Test(priority=6)
	public void verifyProductsAddedInTheCartTest(){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(className(\"android.widget.FrameLayout\"));");
		int count=ProductsPage.verifyProductsAddedInTheCart();
		System.out.println("total items added in the cart :"+count);
		double totalPrice=0;
		for(int i=0;i<count;i++){
		double p=ProductsPage.verifyTotalPriceInTheCart(i);
		//double itemPrice = Double.parseDouble(p); 
		 totalPrice =totalPrice+p;
		
		}
		System.out.println("Total Price: $"+totalPrice);
		double productPriceCart=ProductsPage.verifyTotalPrice();
		System.out.println("Total Price in the Cart: $"+productPriceCart);
		Assert.assertEquals(productPriceCart, totalPrice);
		
	}
	
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
	}

}
