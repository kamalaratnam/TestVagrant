package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class ReusableFunctions extends BaseClass{
	
	
	public static void javascriptexecutorScrolltoelement(WebElement elm)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", elm);
	}
	
}
