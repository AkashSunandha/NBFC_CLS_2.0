package com.Page_AccountOperations;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpr_NomineeManagement;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class NomineeManagement extends Base_Class{

	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_AccOpr_NomineeManagement nomineeRepo = new PageRepositary_AccOpr_NomineeManagement();
	
	public void navigateToMemberManagementLoan() throws InterruptedException {

	//Open Member Management Loan Window
	ExtentTestManager.startTest("Open Member Management Loan Window");
	Log.info("Open Member Management Loan Window");
	
	click(nomineeRepo.accountOperationsTab);
	ExtentTestManager.getTest().log(Status.PASS, "1. Expand account operation.");
	Log.info("1. Expand account operation.");

	click(nomineeRepo.nomineeManagementTab);
	ExtentTestManager.getTest().log(Status.PASS, "2. Expand member management.");
	Log.info("2. Expand member management.");
	


	if(ElementDisplayed(null)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Member management loan window is opened.");
		Log.info("Expected Result: Member management loan window is opened.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
}//end

}
