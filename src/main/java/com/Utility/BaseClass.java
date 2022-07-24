package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	@BeforeSuite
	public static void openBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Base");
	}
	@AfterSuite
	public static void closeBrowser()
	{
	
		driver.close();
		
	}

}
