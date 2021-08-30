package com.hrm.testcases;


import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.hrm.basetest.BaseTest;
import com.hrm.constants.HRMConstants;
import com.hrm.constants.TestDatafromExcel;
import com.hrm.pages.Launchingpage;
import com.hrm.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{	
	static String testName="LoginTest";
	@Test(dataProvider="getdata",dataProviderClass = TestDatafromExcel.class)
	public void doLogin(Hashtable<String, String> data) throws Exception{
		test=ext.startTest("LoginTest");
		System.out.println(data.get("Runmode")+"--"+data.get("Browser")+"--"+data.get("Username")+"--"+data.get("Password")+"--"+data.get("ExpectedResult"));
		if(data.get(HRMConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		test=ext.startTest("LoginTest");
		test.log(LogStatus.INFO, "Login Test is Start");
		test.log(LogStatus.INFO, "Open Browser");
		init("Chrome");
		Launchingpage lanchingpage=new Launchingpage(driver, test);
		PageFactory.initElements(driver, lanchingpage);
		LoginPage loginpage=lanchingpage.openApplication();		
		PageFactory.initElements(driver, loginpage);
		loginpage.doLogin(data.get("Username"), data.get("Password"));		
		takeScreenshot();
		driver.close();		
	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		 if(result.getStatus() == ITestResult.FAILURE){
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
		                        String screenshotPath = getScreenhot(driver, result.getName());
		 //To add it in the extent report 
		 test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }else if(result.getStatus() == ITestResult.SKIP){
		 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 
		 ext.endTest(test);
		 }
	@AfterSuite
	public void quit(){
if(ext!=null){
		//ext.endTest(test);
	     ext.flush();
	}
	}

}
