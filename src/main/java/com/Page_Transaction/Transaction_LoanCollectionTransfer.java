package com.Page_Transaction;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Transaction_LoanCollectionTransfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_LoanCollectionTransfer extends Base_Class{

	String transId;
	
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_Transaction_LoanCollectionTransfer loanCollTransRepo = new PageRepositary_Transaction_LoanCollectionTransfer();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();

	
public void navigateToLoanCollectionTransfer() throws InterruptedException {
		
		//Open Loan Collection Transfer Window
		ExtentTestManager.startTest("Open Loan Collection Transfer Window");
		Log.info("Open Loan Collection Transfer Window");
		
		click(loanCollTransRepo.transactionTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Expand transaction module");
		Log.info("1. Expand transaction module");

		click(loanCollTransRepo.loanCollectionTransfer);
		ExtentTestManager.getTest().log(Status.PASS, " 2. Click on loan collection transfer");
		Log.info(" 2. Click on loan collection transfer");

		if(ElementDisplayed(loanCollTransRepo.lcdAgentNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan collection transfer window opens successfully.");
			Log.info("Expected Result: Loan collection transfer window opens successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end


public void LoanCollectionDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException {

	
	//Agent Name Selection
	ExtentTestManager.startTest("Agent Name Selection");
	Log.info("Agent Name Selection");
	
	click(loanCollTransRepo.lcdAgentNameDropdown);
	click(loanCollTransRepo.lcdAgentNameOption);
	ExtentTestManager.getTest().log(Status.PASS, "1. Select agent name from the dropdown");
	Log.info("1. Select agent name from the dropdown");
	
	String agentCodeValue = driver.findElement(loanCollTransRepo.lcdAgentCodeTxtBox).getAttribute("value");
	
	if(!agentCodeValue.isBlank()) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent code is auto-loaded corresponding to the selected agent name.");
		Log.info("Expected Result: Agent code is auto-loaded corresponding to the selected agent name.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	

	
	//Verify Transaction Date Display
	ExtentTestManager.startTest("Verify Transaction Date Display");
	Log.info("Verify Transaction Date Display");
	
	String currentTransDateValue = driver.findElement(loanCollTransRepo.lcdcurrentTransDate).getText();
	System.out.println("currentTransDateValue: "+currentTransDateValue);
	
	String currentTransDate = dateConversion(currentTransDateValue);
	System.out.println("currentTransDate: " +currentTransDate);
	
	String lcdTransDate = driver.findElement(loanCollTransRepo.lcdTransDate).getAttribute("value");
	System.out.println("lcdTransDate: "+lcdTransDate);

	if(currentTransDate.equals(lcdTransDate)) {
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify transaction date and posting date");
		Log.info("Step:01 - Verify transaction date and posting date");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction date matches the current application date.");
		Log.info("Expected Result: Transaction date matches the current application date.");
	}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	

	
	//Product Selection by Checkbox
	ExtentTestManager.startTest("Product Selection by Checkbox");
	Log.info("Product Selection by Checkbox");
	
	ScrollUntilElementVisible(loanCollTransRepo.lcdPersonalWeeklyOption);
	click(loanCollTransRepo.lcdPersonalWeeklyOption);
	ExtentTestManager.getTest().log(Status.PASS, "1. Select a product by clicking the checkbox");
	Log.info("1. Select a product by clicking the checkbox");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product is selected successfully.");
	Log.info("Expected Result: Product is selected successfully.");
	
	ExtentTestManager.endTest();

	
	
	
//	//Error Guessing - Invalid Date Selection
//	ExtentTestManager.startTest("Validate Collection Upto Date Selection");
//	Log.info("Validate Collection Upto Date Selection");
//	
//	clear(loanCollTransRepo.lcdCollectionUpTo);
//	
//	String date = testdata.get("date").toString();
//	input(loanCollTransRepo.lcdCollectionUpTo,date);
//	
//	click(loanCollTransRepo.lcdProcessBtn);
//	ExtentTestManager.getTest().log(Status.PASS, "1. Try selecting a collection date greater than transaction date");
//	Log.info("1. Try selecting a collection date greater than transaction date");
//	
//	if(ElementDisplayed(loanCollTransRepo.lcdErrorPopUpMsgOkBtn)) {
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: System restricts and shows an error for invalid date selection.");
//		Log.info("Expected Result: System restricts and shows an error for invalid date selection.");
//		
//		click(loanCollTransRepo.lcdErrorPopUpMsgOkBtn);
//	}
//	else {
//		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//		Log.info("ERROR");
//	}
//	
//	clear(loanCollTransRepo.lcdCollectionUpTo);
//	input(loanCollTransRepo.lcdCollectionUpTo,currentTransDate);
//	
//	ExtentTestManager.endTest();
	

	
	//Process Loan Collection Transfer
	ExtentTestManager.startTest("Process Loan Collection Transfer");
	Log.info("Process Loan Collection Transfer");
	
	click(loanCollTransRepo.lcdProcessBtn);
	ExtentTestManager.getTest().log(Status.PASS, "1. Click process");
	Log.info("1. Click process");

	waitUntilElementDisappear(loanCollTransRepo.loader);
	
	if(ElementDisplayed(loanCollTransRepo.lcdProcessDetailsGrid)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Processed details are displayed in the grid");
	Log.info("Expected Result: Processed details are displayed in the grid");
	}else {
	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	Log.info("ERROR");
	}

	
	ExtentTestManager.endTest();
	

	
	//Verify Default Transaction Mode
	ExtentTestManager.startTest("Verify Default Transaction Mode");
	Log.info("Verify Default Transaction Mode");
	
	String transModeDropdownOptionValue = driver.findElement(loanCollTransRepo.lcdTransModeDropdownOption).getText();
	System.out.println("transModeDropdownOptionValue: "+transModeDropdownOptionValue);
	
	
	if(transModeDropdownOptionValue.equals("TRANSFER")) {
		
		ExtentTestManager.getTest().log(Status.PASS, "1. Observe Transaction Mode field");
		Log.info("1. Observe Transaction Mode field");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction mode is set to 'Transfer' by default");
		Log.info("Expected Result: Transaction mode is set to 'Transfer' by default");
		}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();

	
	
	
	//Error Guessing - Empty Remark Submission
	ExtentTestManager.startTest("Error Guessing - Empty Remark Submission");
	Log.info("Error Guessing - Empty Remark Submission");
		
	clear(loanCollTransRepo.lcdRemarksTxtBox);
	ExtentTestManager.getTest().log(Status.PASS, "1. Leave remark field empty");
	Log.info("1. Leave remark field empty");
	
	click(loanCollTransRepo.lcdSubmitBtn);
	ExtentTestManager.getTest().log(Status.PASS, "2. Click submit");
	Log.info("2. Click submit");
	
	if(ElementDisplayed(loanCollTransRepo.lcdRemarksRequiredCloseBtn)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: System prompts an error indicating the remark field is required");
	Log.info("Expected Result: System prompts an error indicating the remark field is required");
	
	click(loanCollTransRepo.lcdRemarksRequiredCloseBtn);

	}else {
	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();

	
	
	
	//Enter Remark
	ExtentTestManager.startTest("Enter Remark");
	Log.info("Enter Remark");
		
	String remark = testdata.get("remark").toString();
	input(loanCollTransRepo.lcdRemarksTxtBox,remark);
	ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid remark");
	Log.info("1. Enter a valid remark");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark is entered successfully");
	Log.info("Expected Result: Remark is entered successfully");
	
	ExtentTestManager.endTest();
	

	
	//Submit Loan Collection Transfer
	ExtentTestManager.startTest("Submit Loan Collection Transfer");
	Log.info("Submit Loan Collection Transfer");
	
	click(loanCollTransRepo.lcdSubmitBtn);
	ExtentTestManager.getTest().log(Status.PASS, "1. Click submit");
	Log.info("1. Click submit");

	waitUntilElementDisappear(loanCollTransRepo.loader);
	
	if(ElementDisplayed(loanCollTransRepo.lcdSummaryPageTransId)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Successful submission of loan collection transfer");
	Log.info("Expected Result: Successful submission of loan collection transfer");
	
	transId = driver.findElement(loanCollTransRepo.lcdSummaryPageTransId).getText();
	}else {
	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
}//end



public void authorizeTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

	//Login with Another User
	ExtentTestManager.startTest("Login with Another User");
	Log.info("Login with Another User");
	
	click(custSearch.custSignOut); 
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
	Log.info("Step:01 - Log out");
	
	String UserName = configloader().getProperty("UserName2");
	input(custSearch.loginUserName,UserName );
	String Password = configloader().getProperty("Password2");
	input(custSearch.loginPasswrd, Password);
	click(custSearch.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
	Log.info("Step:02 - Log in with another user for authorization");

	String authorizeUserName = driver.findElement(goaldLoanRepo.userName).getText();
	System.out.println(authorizeUserName);
	
	
	if(!authorizeUserName.equalsIgnoreCase(custSrchMtds.actualUserName)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
		Log.info("Expected Result: Logging successfull with another user");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	

	//Manager Authorization - Transfer Tab
	ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
	Log.info("Manager Authorization - Transfer Tab");
	
	click(goaldLoanRepo.autorizeAndCancelTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
	Log.info("Step:01 - Click \"Authorize & Cancel\"");
	
	click(goaldLoanRepo.managerAuthoTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
	Log.info("Step:02 - Select \"Manager Authorization\"");
	
	click(goaldLoanRepo.sTransferTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Transfer\" tab");
	Log.info("Step:03 - Click \"Transfer\" tab");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab load");
	Log.info("Expected Result: Transfer tab load");
	
	ExtentTestManager.endTest();
	
	
	

	//Refresh Loan Opening Entry
	ExtentTestManager.startTest("Refresh Loan Opening Entry");
	Log.info("Refresh Loan Opening Entry");
	
	click(goaldLoanRepo.refreshBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
	Log.info("Step:01 - Click Refresh Button");
	
	System.out.println("transIdTransferPersonal "+transId);
	transJewelMthds.fetchWithTransId(transId);
	
	if(ElementDisplayed(goaldLoanRepo.approveCheckBoxTransfer)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
	Log.info("Expected Result: Loan opening entry displayed");
}else {
	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	Log.info("ERROR");
}
	ExtentTestManager.endTest();
	
	
	

	//Authorize Loan Entry as Manager
	ExtentTestManager.startTest("Authorize Loan Entry as Manager");
	Log.info("Authorize Loan Entry as Manager");
	
	click(goaldLoanRepo.approveCheckBoxTransfer);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
	Log.info("Step:01 - Select loan entry checkbox");
	
	click(goaldLoanRepo.authorizeBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
	Log.info("Step:02 - Click Authorize Button");		
	
	if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");
	click(goaldLoanRepo.confirmationPopUp);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}

	ExtentTestManager.endTest();

}//end



}
