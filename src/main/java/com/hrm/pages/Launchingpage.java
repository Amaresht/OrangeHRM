package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.OrnageHRM.basepage.BasePage;
import com.hrm.constants.HRMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Launchingpage extends BasePage{
	public ExtentTest test;
	
	
	public Launchingpage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
		
	}
	public LoginPage openApplication() {
		test.log(LogStatus.INFO	, HRMConstants.URL +" is going to open");		
		driver.get(HRMConstants.URL);
		test.log(LogStatus.INFO	, HRMConstants.URL +" is opened");
		LoginPage loginpage=new LoginPage(driver, test);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
	}
}
