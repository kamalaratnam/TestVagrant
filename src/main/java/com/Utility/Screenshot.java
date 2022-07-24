package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import freemarker.template.SimpleDate;

public class Screenshot extends BaseClass {
	
	public static String Screenshots() throws IOException
	{
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot shot=((TakesScreenshot)driver);
		String ScreentShotNAme="Movieinfo";
		File src=shot.getScreenshotAs(OutputType.FILE);
		String dst=System.getProperty("user.dir")+"\\target"+ScreentShotNAme+date;
		File dstFile=new File(dst);
		FileUtils.copyFile(src, dstFile);
		return dst;
				
	}

}
