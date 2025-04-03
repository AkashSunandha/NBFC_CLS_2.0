package com.Page_Admin;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Bond_BondConfiguration;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Bond_BondConfiguration extends Base_Class{

	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_Bond_BondConfiguration bondRepo = new PageRepositary_Bond_BondConfiguration();
	
	
	public void adminLogin() throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Basic Login Functionality");
		Log.info("Basic Login Functionality");
			
			
					String UserName = configloader().getProperty("AdminUserName");
					input(custSearch.loginUserName,UserName );
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
					Log.info("Step:01 - Enetered valid Admin User Name");
					
					String Password = configloader().getProperty("AdminPassword");
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
					input(custSearch.loginPasswrd, Password);
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
					Log.info("Step:02 - Enetered valid Admin Password");
					
					click(custSearch.loginButton);
					ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
					Log.info("Step:03 - Click on Login Button");
					
					try {
					ElementDisplayed(bondRepo.continueBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
					Log.info("Expected Result: User is logged in successfully and dashboard visible");
					}
					catch(Exception e) {
						ElementDisplayed(custSearch.loginWarningOkBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
						Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

						click(custSearch.loginWarningOkBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
						Log.info("Step:01 - Click on OK button");
						
						input(custSearch.loginUserName, UserName);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
						Log.info("Step:02 - Enetered valid Admin User Name");
						
						input(custSearch.loginPasswrd, Password);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
						Log.info("Step:03 - Entered valid Admin Password");
						
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
						Log.info("Step:04 - Click on Login Button");
						
									ElementDisplayed(bondRepo.continueBtn);
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
									Log.info("Expected Result: User is logged in successfully and dashboard visible");	
							}
					
		ExtentTestManager.endTest();

	}//end
	
	
	public void navigateToBondConfiguration() throws InterruptedException {
		
		//Expand Module for Collection Importing
		ExtentTestManager.startTest("Open Bond Configuration");
		Log.info("Open Bond Configuration");
		
		click(bondRepo.continueBtn);
		
		click(bondRepo.bondTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to 'Bond' section");
		Log.info("1. Navigate to 'Bond' section");

		click(bondRepo.bondConfigTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Click on Bond Configuration.");
		Log.info("2. Click on Bond Configuration.");
		
		if(ElementDisplayed(bondRepo.bdProductNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Bond configuration window is opened.");
			Log.info("Expected Result: Bond configuration window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
	}//end
	
}
