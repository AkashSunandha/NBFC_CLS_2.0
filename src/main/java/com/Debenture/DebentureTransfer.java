package com.Debenture;

import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_Tranfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class DebentureTransfer extends Base_Class {
	
	PageRepositary_Debenture_Tranfer transfer_repo = new PageRepositary_Debenture_Tranfer();
	String transId;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
//	private Object tranfer_repo;	
	
	
public void load_Debenture_Transfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	
	//load_Debenture_Transfer
	ExtentTestManager.startTest("load_Debenture_Transfer");
	Log.info("load_Debenture_Transfer");

	click(transfer_repo.debentureTab);
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Transfer >> Observe the Branch field");
	
	waitTillLoaderDisappear(transfer_repo.loader);
	
	ExtentTestManager.endTest();
	
	
	//Verify Debenture Type Selection
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	click(transfer_repo.Deb_TranferTab);
	ExtentTestManager.getTest().log(Status.PASS, "Able to select any valid option");
	
	waitTillLoaderDisappear(transfer_repo.loader);
	
	ExtentTestManager.endTest();
	
	//Verify Debenture Issue Based on Type
	ExtentTestManager.startTest("Verify Debenture type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Deb_branch,"HEAD OFFICE");
	ExtentTestManager.getTest().log(Status.PASS, "Able to select any valid option");
		
	waitTillLoaderDisappear(transfer_repo.loader);
		
	ExtentTestManager.endTest();
	
	
	//Verify Debenture Type Based on Type
	ExtentTestManager.startTest("Verify Debenture Issue Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Deb_Type,"DEBENTURE2");
	ExtentTestManager.getTest().log(Status.PASS, "Able to select any valid option");
			
	waitTillLoaderDisappear(transfer_repo.loader);
		
	ExtentTestManager.endTest();

	
	//Verify Debenture Type Based on Type
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Issue_Type,"ISSUE-DEBENTURE2-2");
	ExtentTestManager.getTest().log(Status.PASS, "Able to select any valid option");
				
	waitTillLoaderDisappear(transfer_repo.loader);
			
	ExtentTestManager.endTest();
	
	//Verify Series Based on Type
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Series_1,"ISSUE-DEBENTURE-TYPE1-49");
	ExtentTestManager.getTest().log(Status.PASS, "Able to select any valid option");
					
	waitTillLoaderDisappear(transfer_repo.loader);
				
	ExtentTestManager.endTest();
	
	//Verify Account Number Entry
	ExtentTestManager.startTest("Verify Account Number Entry");
	Log.info("Verify Account Number Entry");

	input(transfer_repo.ACC_No,"1");
	ExtentTestManager.getTest().log(Status.PASS, "Navigates to the Transfer window of the specified account");
						
	waitTillLoaderDisappear(transfer_repo.loader);
					
	ExtentTestManager.endTest();
	
	//Verify Customer Checkbox Functionality
	ExtentTestManager.startTest("Verify Customer Checkbox Functionality");
	Log.info("Verify Customer Checkbox Functionality");

	click(transfer_repo.gO);
	ExtentTestManager.getTest().log(Status.PASS, "Navigates to the Transfer window of the specified account");
							
	waitTillLoaderDisappear(transfer_repo.loader);
						
	ExtentTestManager.endTest();
}
}