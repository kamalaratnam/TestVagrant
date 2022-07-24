package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListner implements ITestListener 
{
	 private WebDriver driver;
	
	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) 					
    {	
		this.driver = BaseClass.driver;
		System.out.println("The name of the testcase failed is :"+Result.getName());	
		if (!Result.isSuccess()) {
			 File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = Result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
			                + ".png";
			        File failureImageFile = new File(System.getProperty("user.dir")+"\\target\\"+failureImageFileName);
			 try {
				FileUtils.copyFile(imageFile, failureImageFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    }
    
    
	
		System.out.println("*******Screenshot captured********");
    }	
	// When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		
 // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");					
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		
	

}
