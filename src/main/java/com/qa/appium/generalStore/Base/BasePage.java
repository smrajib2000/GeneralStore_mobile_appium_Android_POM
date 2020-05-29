package com.qa.appium.generalStore.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.appium.generalStore.commons.Constants;

public class BasePage {
	Properties prop;
	AndroidDriver<AndroidElement> driver;
	public static ThreadLocal<AndroidDriver> tldriver = new ThreadLocal<AndroidDriver>();
	
	
	public AndroidDriver<AndroidElement> initialize_driver(Properties prop,String url){
		
		try{
			// Invoke .apk file
			File file = new File("src\\test\\resources\\apps");		//ipa for ios  and 
			File app = new File(file, "General-Store.apk");
	//Set desiredCapabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
	caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
	caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
	caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// Initialize mobile_driver
				
			//URL url = new URL("http://127.0.0.1:4723/wd/hub");
				
				tldriver.set(new AndroidDriver<AndroidElement>(new URL(url), caps));
				getDriver().manage().timeouts().implicitlyWait(Constants.DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);
				System.out.println("Application Started ...");
				
				} catch (MalformedURLException e) {
					System.out.println("Cause is "+e.getCause());
					System.out.println("Message is "+e.getMessage());
					e.printStackTrace();
				}
		return getDriver();
	}
	
	@SuppressWarnings("unchecked")
	public static synchronized AndroidDriver<AndroidElement> getDriver() {
		return tldriver.get();
	}
	
	public Properties initialize_properties(){
		prop = new Properties();
		
			FileInputStream ip;
			try {
				ip = new FileInputStream("D:\\QA\\selenium practice\\Eclipse Luna\\Code Practice\\AppiumFrameWork\\"
						+ "src\\main\\java\\com\\qa\\appium\\generalStore\\configuration\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	
		return prop;
		
	}
	

	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
			
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	

	
}
