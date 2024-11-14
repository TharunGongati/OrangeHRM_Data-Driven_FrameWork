package com.Login;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Utility.CaptureScreenhot;
import com.Utility.Excel_Reader;



public class LoginPage {
	
  @Test(dataProvider = "exceldata",dataProviderClass = Excel_Reader.class)
  public void Login_Function(String un, String Psw) {
	  
	  //create a driver session 
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.name("username")).sendKeys(un);
	  
	  driver.findElement(By.name("password")).sendKeys(Psw);
	  
	  driver.findElement(By.xpath("//button")).click();
	  
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  CaptureScreenhot.ScreenShot(driver);
	  	Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Fail");
	  System.out.println("Login Successful");
	  
	  if(driver.getCurrentUrl().contains("dashboard")) {
		  //arrow
		  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		  driver.findElement(By.partialLinkText("Logout"));
	  }
  
  }
}
