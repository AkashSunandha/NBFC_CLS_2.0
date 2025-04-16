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
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Transfer >> Observe the Branch field");
	
	waitTillLoaderDisappear(transfer_repo.loader);
	
	ExtentTestManager.endTest();
	
	//Verify Debenture Issue Based on Type
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Deb_branch,"HEAD OFFICE");
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Transfer >> Observe the Branch field");
		
	waitTillLoaderDisappear(transfer_repo.loader);
		
	ExtentTestManager.endTest();
	
	
	//Verify Debenture Type Based on Type
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Deb_Type,"DEBENTURE-NRI");
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Transfer >> Observe the Branch field");
			
	waitTillLoaderDisappear(transfer_repo.loader);
		
	ExtentTestManager.endTest();

	
	//Verify Debenture Type Based on Type
	ExtentTestManager.startTest("Verify Debenture Type Selection");
	Log.info("Verify Debenture Type Selection");

	input(transfer_repo.Deb_Type,"DEBENTURE-NRI");
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Transfer >> Observe the Branch field");
				
	waitTillLoaderDisappear(transfer_repo.loader);
			
	ExtentTestManager.endTest();
	
}
}