package com.Page_GroupLoans;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanCollection;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanCollection extends Base_Class{

	PageRepositary_GroupLoans_GroupLoanCollection grpLoanCollRepo = new PageRepositary_GroupLoans_GroupLoanCollection();
	public void groupLoanCollection() throws InterruptedException {
		
		//Navigation to Group Loan collection page.
		ExtentTestManager.startTest("Navigation to Group Loan collection page.");
		Log.info("Navigation to Group Loan collection page.");
		
		click(grpLoanCollRepo.groupLoansTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Group Loans section.");
		Log.info("1. Navigate to Group Loans section.");
		
		click(grpLoanCollRepo.groupLoanCollectionTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Open Group Loan collection page.");
		Log.info("2. Open Group Loan collection page.");
		
		if(ElementDisplayed(grpLoanCollRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Group Loan collection page opened");
			Log.info("Expected Result: " +  "Group Loan collection page opened");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupInfo() throws InterruptedException {

		//Center Dropdown Selections - Basic Functionality
		ExtentTestManager.startTest("Center Dropdown Selections - Basic Functionality");
		Log.info("Center Dropdown Selections - Basic Functionality");
			
		select("14 - GUARANTOR",grpLoanCollRepo.giCentreDropdown);
		ExtentTestManager.getTest().log(Status.PASS, " Select a Center from Center dropdown");
		Log.info(" Select a Center from Center dropdown");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanCollRepo.giCentreDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Centre is selected from dropdown ");
			Log.info("Expected Result: " + "Centre is selected from dropdown ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
		

		//Group Dropdown Selections - Basic Functionality
		ExtentTestManager.startTest("Group Dropdown Selections - Basic Functionality");
		Log.info("Group Dropdown Selections - Basic Functionality");
			
		select("25 - GUARANTOR 3",grpLoanCollRepo.giGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS,"Select a Group from Group dropdown.");
		Log.info("Select a Group from Group dropdown.");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("25 - GUARANTOR 3",grpLoanCollRepo.giGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group is selected from dropdown ");
			Log.info("Expected Result: " + "Group is selected from dropdown ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
		
		
//		GO Button Functionality
		ExtentTestManager.startTest("GO Button Functionality");
		Log.info("GO Button Functionality");
					
		click(grpLoanCollRepo.giGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);

		if(ElementDisplayed(grpLoanCollRepo.giSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Applications are listed in a grid");
			Log.info("Expected Result: " + "Applications are listed in a grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
	}//end
	
}
