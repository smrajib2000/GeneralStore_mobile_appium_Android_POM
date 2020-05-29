package com.qa.appium.generalStore.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.appium.generalStore.Base.BasePage;
import com.qa.appium.generalStore.commons.Constants;
import com.qa.appium.generalStore.pages.LetsShopPage;
import com.qa.appium.generalStore.util.CommonUtil;

public class LetsShopPageTest {
	BasePage basePage;
	Properties prop;
	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities caps;
	LetsShopPage letsShopPage;
	
	@BeforeTest
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		
		driver = basePage.initialize_driver(prop,prop.getProperty("url"));
		letsShopPage = new LetsShopPage(driver);
	}
	
	
	@Test(priority=1)
	public void verifyPageTitleTest(){
		String title = letsShopPage.getPageTitle();
		System.out.println("Page Title is: "+title);
		Assert.assertEquals(title, Constants.APPPAGE_TITLE);
	
	}
	
	@Test(priority=2)
	public void generalStorePageTest(){
		
		letsShopPage.generalStorePage(prop.getProperty("name"),prop.getProperty("countryname"),prop.getProperty("gender"));
	
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}


