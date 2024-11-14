 package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenhot {
	public static void ScreenShot(WebDriver driver) {
		 
		  String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir")+"//ScreenShots//OrangeHrm_Login"+timestamp+".png");
		  
		  try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
