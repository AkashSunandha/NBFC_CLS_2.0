package com.Page_AccountOperations;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_AccOpr_MembMang_MembMang_Deposit;
import com.Page_Repositary.PageRepositary_AccOpr_MembMang_MembMang_Loan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class MemberManagement_MemberManagementDeposit extends Base_Class{

	public String spAccNum = "EXEC SPGetNotPledgeddepositdetailsTEST  '102' , '14003'";
	public String clmnNam = "AcNO";
	
	public String last4DigitsOfAccNum;
	public String actualUserName;

	PageRepositary_AccOpr_MembMang_MembMang_Deposit depositRepo = new PageRepositary_AccOpr_MembMang_MembMang_Deposit();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting loanChargPostingrepo = new PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	
	public void navigateToMemberManagementDeposit() throws InterruptedException {
		
//		actualUserName = custSrchMtds
		
		//Open Member Management Loan Window
		ExtentTestManager.startTest("Open Member Management Loan Window");
		Log.info("Open Member Management Loan Window");
		
		click(depositRepo.accountOPerationsTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Expand account operation.");
		Log.info("1. Expand account operation.");

		click(depositRepo.memberManagementTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Expand member management.");
		Log.info("2. Expand member management.");
		
		click(depositRepo.memberManagementDepositTab);
		ExtentTestManager.getTest().log(Status.PASS, "3. Select member management loan.");
		Log.info("3. Select member management loan.");

		if(ElementDisplayed(depositRepo.aiBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Member management loan window is opened.");
			Log.info("Expected Result: Member management loan window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
public void accountInfo() throws InterruptedException, ClassNotFoundException {

		
		//Select Product Group - Positive Scenario
		ExtentTestManager.startTest("Select Product Group - Positive Scenario");
		Log.info("Select Product Group - Positive Scenario");
		
		select("Fixed Deposit",depositRepo.aiProductGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Fixed Deposit' from the product group dropdown.");
		Log.info("1. Select 'Fixed Deposit' from the product group dropdown.");
		
		waitUntilElementDisappear(depositRepo.loader);
		
		if(dropdownSelectionValidation("Fixed Deposit",depositRepo.aiProductGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Fixed Deposit' is selected in the product group dropdown.");
			Log.info("Expected Result: 'Fixed Deposit' is selected in the product group dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Select Product Name - Positive Scenario
		ExtentTestManager.startTest("Select Product Name - Positive Scenario");
		Log.info("Select Product Name - Positive Scenario");
		
		select("DEBUNTURE FIXED TYPE 2 YRS",depositRepo.aiProductDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select a valid product name from the product dropdown.");
		Log.info("1. Select a valid product name from the product dropdown.");
		
		if(dropdownSelectionValidation("DEBUNTURE FIXED TYPE 2 YRS",depositRepo.aiProductDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The selected product name is displayed.");
			Log.info("Expected Result: The selected product name is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Enter Account Number - Positive Scenario
		ExtentTestManager.startTest("Enter Account Number - Positive Scenario");
		Log.info("Enter Account Number - Positive Scenario");

		String accNum = transJewelMthds.generateUniqueId(spAccNum, clmnNam);
		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

		input(depositRepo.aiAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid  account number.");
		Log.info("1. Enter a valid  account number.");
		
		if(inputValidation(last4DigitsOfAccNum,depositRepo.aiAccNumTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The  account number is displayed in the input field.");
			Log.info("Expected Result: The  account number is displayed in the input field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Go Button Functionality
		ExtentTestManager.startTest("Go Button Functionality");
		Log.info("Go Button Functionality");
		
		click(depositRepo.aiGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the Go button.");
		Log.info("1. Click the Go button.");
		
		if(ElementDisplayed(depositRepo.aiAccDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details related to the account number are displayed.");
			Log.info("Expected Result: Account details related to the account number are displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
	}//end


public void addNewMember(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
	
	//Search Customer by Name
	ExtentTestManager.startTest("Search Customer by Name");
	Log.info("Search Customer by Name");
	
	String parentWindow = driver.getWindowHandle();

	click(depositRepo.anmCustSrchIcon);
	ExtentTestManager.getTest().log(Status.PASS, "1. Click on 'Select Customer' popup button");
	Log.info("1. Click on 'Select Customer' popup button");
	
	Set<String> address = driver.getWindowHandles();
	
	for(String c : address) {
		
		if(!c.equals(parentWindow)) {
			driver.switchTo().window(c);

		}
		
	}//for end
	
	String name = testdata.get("name").toString();
	input(depositRepo.popUpNameTxtBox, name);
	ExtentTestManager.getTest().log(Status.PASS, "2. Enter alphabets in 'Name' field");
	Log.info("2. Enter alphabets in 'Name' field");

	click(depositRepo.popUpSrchBtn);
	ExtentTestManager.getTest().log(Status.PASS, "3. Click 'Search' button");
	Log.info("3. Click 'Search' button");
	
	if(ElementDisplayed(depositRepo.popUpSelect)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search results display based on name input");
		Log.info("Expected Result: Customer search results display based on name input");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	

	
	
	//Select and Add Customer
	ExtentTestManager.startTest("Select and Add Customer");
	Log.info("Select and Add Customer");

	click(depositRepo.popUpSelect);
	ExtentTestManager.getTest().log(Status.PASS, "Click on a listed customer in the results\r\n"
			+ "2. Click 'Select'");
	Log.info("Click on a listed customer in the results\r\n"
			+ "2. Click 'Select'");
	
	driver.switchTo().window(parentWindow);
	
	String anmCustIdTxtBoxValue = driver.findElement(depositRepo.anmCustIdTxtBox).getAttribute("value");
	System.out.println("anmCustIdTxtBoxValue: " + anmCustIdTxtBoxValue);
	
	String anmAccNameTxtBoxValue = driver.findElement(depositRepo.anmAccNameTxtBox).getAttribute("value");
	System.out.println("anmAccNameTxtBoxValue: " + anmAccNameTxtBoxValue);
	
	if(!anmCustIdTxtBoxValue.isBlank() && !anmAccNameTxtBoxValue.isBlank()) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search results display based on name input");
		Log.info("Expected Result: Customer search results display based on name input");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();

	
	
	//Select Loanee Type - Positive Scenario
	ExtentTestManager.startTest("Select Loanee Type - Positive Scenario");
	Log.info("Select Loanee Type - Positive Scenario");
	
	select("JOINT",depositRepo.anmLoaneeTypeDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "1. Select a valid loanee type from the dropdown.");
	Log.info("1. Select a valid loanee type from the dropdown.");
	
	if(dropdownSelectionValidation("JOINT",depositRepo.anmLoaneeTypeDropdown)) {
		ExtentTestManager.getTest().log(Status.PASS, "\"Expected Result: The selected loanee type is displayed.\"");
		Log.info("Expected Result: The selected loanee type is displayed.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();

	
	
	//Add Customer
	ExtentTestManager.startTest("Add Customer");
	Log.info("Add Customer");
	
	click(depositRepo.anmAddBtn);
	ExtentTestManager.getTest().log(Status.PASS, "1. Click the Add button.");
	Log.info("1. Click the Add button.");
	
	if(ElementDisplayed(depositRepo.anmCustDetailsGrid)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added for the Deposit.");
		Log.info("Expected Result: Customer is added for the Deposit.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();

	
	
	//Enter Remark - Positive Scenario
	ExtentTestManager.startTest("Enter Remark - Positive Scenario");
	Log.info("Enter Remark - Positive Scenario");
	
	String remark = testdata.get("remark").toString();
	input(depositRepo.anmRemarkTxtBox, remark);
	ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid remark.");
	Log.info("1. Enter a valid remark.");
	
	if(inputValidation(remark,depositRepo.anmRemarkTxtBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The remark is displayed in the input field.");
		Log.info("Expected Result: The remark is displayed in the input field.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();

	
	
	//Submit transaction
	ExtentTestManager.startTest("Submit transaction");
	Log.info("Submit transaction");
	
	click(depositRepo.submitBtn);
	ExtentTestManager.getTest().log(Status.PASS, "1. Click the Submit button.");
	Log.info("1. Click the Submit button.");
	
	if(ElementDisplayed(depositRepo.errorPopUpCloseBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction Submitted.");
		Log.info("Expected Result: Transaction Submitted.");
		
		click(depositRepo.errorPopUpCloseBtn);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	actualUserName = custSrchMtds.getActualUserName(depositRepo.actualUserName);
//	System.out.println("actualUserName: "+actualUserName);
}//end



public void authorizeOther(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
	
	
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
	
	
	
	if(!authorizeUserName.equalsIgnoreCase(actualUserName)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
		Log.info("Expected Result: Logging successfull with another user");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	
	//Manager Authorization - Cash Tab
	ExtentTestManager.startTest("Manager Authorization");
	Log.info("Manager Authorization");
	
	click(goaldLoanRepo.autorizeAndCancelTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
	Log.info("Step:01 - Click \"Authorize & Cancel\"");
	
	click(goaldLoanRepo.managerAuthoTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
	Log.info("Step:02 - Select \"Manager Authorization\"");
	
	click(goaldLoanRepo.othersTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Others\" tab");
	Log.info("Step:03 - Click \"Others\" tab");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Others tab load");
	Log.info("Expected Result: Others tab load");
	
	ExtentTestManager.endTest();
	
	
	

	//Refresh Loan Opening Entry
	ExtentTestManager.startTest("Refresh Loan Opening Entry");
	Log.info("Refresh Loan Opening Entry");
	
	click(goaldLoanRepo.refreshBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
	Log.info("Step:01 - Click Refresh Button");
					
	
	if(ElementDisplayed(goaldLoanRepo.otherCheckBox)) {
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
	
	input(goaldLoanRepo.makerIdTxtBox,actualUserName);
	Log.info("entered maker ID");
	
	click(goaldLoanRepo.goBtn);
	
	click(goaldLoanRepo.otherCheckBox);
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
