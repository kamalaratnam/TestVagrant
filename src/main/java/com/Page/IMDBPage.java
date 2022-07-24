package com.Page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BaseClass;
import com.Utility.ReusableFunctions;

public class IMDBPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='suggestion-search']")
	WebElement SearchBox;
	
	@FindBy(xpath="//ul[@role='listbox']//li/descendant::a")
	List<WebElement> SearchResults;
	
	@FindBy(xpath="//div[@data-testid='title-details-section']//a[text()='Release date']/..//div")
	WebElement ReleaseDate;
	
	@FindBy(xpath="//div[@data-testid='title-details-section']//span[contains(text(),'Country of origin')]/..//div")
	WebElement Country;
	
	public IMDBPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void sendkeysonIMDBsearchBox(String movieName)
	{
		SearchBox.sendKeys(movieName);
	}
	public void ClickonIMDBsearchResults() throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println(SearchResults.size());
		SearchResults.get(0).click();
	}
	public void scroltoElementIMDB()
	{
		ReusableFunctions.javascriptexecutorScrolltoelement(ReleaseDate);
	}
	public String GetIMDBReleaseDate()
	{
		return ReleaseDate.getText();
	}
	public String GetIMDBCountry()
	{
		return Country.getText();
	}
	public void launchIMDBURL(String IMDBUrl)
	{
		driver.get(IMDBUrl);
	}
	public Date IMDBDateParse(String Date) throws ParseException
	{
		String[] dateIMDB=Date.split("\\(");		
		SimpleDateFormat formatter1=new SimpleDateFormat("MMMM DD, yyyy");  
		Date date1=formatter1.parse(dateIMDB[0]);  
		return date1;
	}
	
		

		

}
