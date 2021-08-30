package com.OrnageHRM.basepage;


import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.hrm.constants.HRMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	public WebDriver driver;
	public ExtentTest test;
	
	
	public String verifyTile(String expTitle){
		test.log(LogStatus.INFO, "Verifying the Title "+expTitle);
		return "";
		
		
	}
	public String verifyText(String locator,String expText){
		return "";
	}
	
		public boolean isElementpresent(String locator){
			test.log(LogStatus.INFO, "Trying to find element-> "+locator);
			WebElement XpthLocator=driver.findElement(By.xpath(locator));
			if(XpthLocator.isDisplayed()){
				test.log(LogStatus.INFO, "Element found");
				return true;
			
			}else{
					test.log(LogStatus.INFO, "Element not found ");
					return false;
				}
		}

			


}
