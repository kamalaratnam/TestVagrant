package com.testScripts;

import java.text.ParseException;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Page.IMDBPage;
import com.Page.WikiPage;
import com.Utility.BaseClass;



public class MovieInformation extends BaseClass {
	
	IMDBPage IP;
	WikiPage WP;
	public MovieInformation()
	{
		super();
		
	}	
	@Test(priority=1)
	@Parameters({"IMDBUrl","WikiUrl","MovieName"})
	public void VerifyDateandCountryFromImDBWiki(String IMDBUrl,String WikiUrl,String MovieName) throws InterruptedException, ParseException
	{
		
		IP=new IMDBPage();	
		WP=new WikiPage();	
		
		IP.launchIMDBURL(IMDBUrl);
		IP.sendkeysonIMDBsearchBox(MovieName);
		IP.ClickonIMDBsearchResults();
		String IMDBDate=IP.GetIMDBReleaseDate();
		Date FormattedIMDBDate=IP.IMDBDateParse(IMDBDate);
		System.out.println(FormattedIMDBDate);
		
		String IMDBCountry=IP.GetIMDBCountry();
		System.out.println(IMDBCountry);		
		WP.launchWikiURL(WikiUrl);
		WP.sendkeysonWikisearchBox(MovieName);
		WP.ClickonWikisearchResults();
		String WikiDate=WP.GetWikiReleaseDate();	
		Date formattedWikiDate=WP.DateParseWiki(WikiDate);	
		String WikiCountry=WP.GetWikiCountry();
		System.out.println(WikiCountry);			
		Assert.assertEquals(IMDBCountry, WikiCountry);			
							
		System.out.println(FormattedIMDBDate);
		System.out.println(formattedWikiDate);			
		Assert.assertEquals(FormattedIMDBDate, formattedWikiDate);

	
	}

 }
 