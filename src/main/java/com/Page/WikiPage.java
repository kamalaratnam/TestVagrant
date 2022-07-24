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

public class WikiPage  extends BaseClass{
	
	@FindBy(className = "vector-search-box-input")
	WebElement WikiSearchBox;
	@FindBy(xpath = "//a[@class='mw-searchSuggest-link']")
	List<WebElement> WikiSearchResults;
	
	@FindBy(xpath = "//div[contains(text(),'Release date')]/../..//td")
	WebElement WikiReleaseDate;
	@FindBy(xpath = "//th[text()='Country']//following-sibling::td")
	WebElement WikiCountry;
	
	public WikiPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void sendkeysonWikisearchBox(String movieName)
	{
		WikiSearchBox.sendKeys(movieName);
	}
	public void ClickonWikisearchResults() throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println(WikiSearchResults.size());
		WikiSearchResults.get(0).click();
	}
	public void scroltoElement()
	{
		ReusableFunctions.javascriptexecutorScrolltoelement(WikiReleaseDate);
	}
	public String GetWikiReleaseDate()
	{
		return WikiReleaseDate.getText();
	}
	public String GetWikiCountry()
	{
		return WikiCountry.getText();
	}
	public void launchWikiURL(String WikiUrl)
	{
		driver.get(WikiUrl);
	}
	public Date DateParseWiki(String WikiDate) throws ParseException
	{
		SimpleDateFormat formatter2=new SimpleDateFormat("dd MMMM yyyy");  
		String[] dateWiki=WikiDate.split("\\(");	
		Date date2=formatter2.parse(dateWiki[0]); 
		return date2;
	
	}
	
	
}
