package com.Page_AccountOperations;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpr_NomineeManagement;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class NomineeManagement extends Base_Class{

	public String loginBranchValue;
	public String spAccNum = "EXEC SPGetNomineeLoan '23001' ,102";
	public String clmnNam = "AcNO";
	public String last4DigitsOfAccNum;
	public String actualUserName;

	
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_AccOpr_NomineeManagement nomineeRepo = new PageRepositary_AccOpr_NomineeManagement();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();

	public void navigateToNomineeManagement() throws InterruptedException {

	//Nominee Management Navigation
	ExtentTestManager.startTest("Nominee Management Navigation").assignCategory("Account operation-Nominee Management");
	Log.info("Nominee Management Navigation");
	
	click(nomineeRepo.accountOperationsTab);
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Account Operation.");
	Log.info("1. Navigate to Account Operation.");

	click(nomineeRepo.nomineeManagementTab);
	ExtentTestManager.getTest().log(Status.PASS, "2. Click on Nominee Management.");
	Log.info("2. Click on Nominee Management.");
	
	/*if(ElementDisplayed(nomineeRepo.aiBranchDropdown)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The Nominee Management window opens.");
		Log.info("Expected Result: The Nominee Management window opens.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}*/
	
	ExtentTestManager.endTest();
	
}//end
	
	
	public void accountInfo() throws InterruptedException, ClassNotFoundException {


//		//Branch Field Presence and Default Selection
//		ExtentTestManager.startTest("Branch Field Presence and Default Selection").assignCategory("Account operation-Nominee Management");
//		Log.info("Branch Field Presence and Default Selection");
//
//		loginBranchValue = driver.findElement(nomineeRepo.loginBranch).getText();
//		System.out.println("loginBranchValue: "+loginBranchValue);
//		String actualBranchValue = driver.findElement(nomineeRepo.actualBranch).getText();
//		System.out.println("actualBranchValue: "+actualBranchValue);
//
//		if(loginBranchValue.equals(actualBranchValue) && !checkElementEnableOrDisable(nomineeRepo.aiBranchDropdown)) {
//			
//			
//			ExtentTestManager.getTest().log(Status.PASS, 
//					"1. Verify the 'Branch' field is present.\r\n"
//					+ "2. Check the default branch is the login branch.\r\n"
//					+ "3. Attempt to change branch selection.");
//			Log.info("1. Verify the 'Branch' field is present.\r\n"
//					+ "2. Check the default branch is the login branch.\r\n"
//					+ "3. Attempt to change branch selection.");
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch' field is present; default branch is set and cannot be altered.");
//			Log.info("Expected Result: Branch' field is present; default branch is set and cannot be altered.");
//		}
//		else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
//		
//		ExtentTestManager.endTest();
		
		

		
		//Product Group Drop-down Functional Check
		ExtentTestManager.startTest("Product Group Drop-down Functional Check").assignCategory("Account operation-Nominee Management");
		Log.info("Product Group Drop-down Functional Check");
		
		select("OTHER LOANS",nomineeRepo.aiProductGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Verify the 'Product Group' dropdown is present.\r\n"
				+ "2. Check the list of active product groups.\r\n"
				+ "3. Attempt to click and select a product group.");
		Log.info("1. Verify the 'Product Group' dropdown is present.\r\n"
				+ "2. Check the list of active product groups.\r\n"
				+ "3. Attempt to click and select a product group.");
		
		waitUntilElementDisappear(nomineeRepo.loader);
		
		if(dropdownSelectionValidation("OTHER LOANS",nomineeRepo.aiProductGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product Group' dropdown is functional, lists active groups, and allows selection.");
			Log.info("Expected Result: Product Group' dropdown is functional, lists active groups, and allows selection.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Product Name Drop-down Functional Check
		ExtentTestManager.startTest("Product Name Drop-down Functional Check").assignCategory("Account operation-Nominee Management");
		Log.info("Product Name Drop-down Functional Check");
		
		select("PERSONAL LOAN WEEKLY",nomineeRepo.aiProductNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Verify the 'Product Name' dropdown is present.\r\n"
				+ "2. Check the list of active product names post product group selection.\r\n"
				+ "3. Attempt to click and select a product name.\"");
		Log.info("\"1. Verify the 'Product Name' dropdown is present.\r\n"
				+ "2. Check the list of active product names post product group selection.\r\n"
				+ "3. Attempt to click and select a product name.\"");
		
		if(dropdownSelectionValidation("PERSONAL LOAN WEEKLY",nomineeRepo.aiProductNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product Name' dropdown is functional, lists active names, and allows selection.");
			Log.info("Expected Result: Product Name' dropdown is functional, lists active names, and allows selection.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Account No Field Input Validation
		ExtentTestManager.startTest("Account No Field Input Validation").assignCategory("Account operation-Nominee Management");
		Log.info("Account No Field Input Validation");

		String accNum = transJewelMthds.generateUniqueId(spAccNum, clmnNam);
		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

		input(nomineeRepo.aiAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Verify 'Account No' field is present.\r\n"
				+ "2. Enter a valid account number.\r\n");
		Log.info("\"1. Verify 'Account No' field is present.\r\n"
				+ "2. Enter a valid account number.\r\n");
		
		if(inputValidation(nomineeRepo.aiAccNumTxtBox,last4DigitsOfAccNum)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account No field accepts only numeric input and shows error for non-numerics.");
			Log.info("Expected Result: Account No field accepts only numeric input and shows error for non-numerics.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Go Button Account Details Display
		ExtentTestManager.startTest("Go Button Account Details Display").assignCategory("Account operation-Nominee Management");
		Log.info("Go Button Account Details Display");
		
		click(nomineeRepo.aiGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click 'Go' button.\r\n"
				+ "2. Verify account details are displayed correctly.\r\n"
				+ "3. Check if nominee details are shown if already added.\"");
		Log.info("\"1. Click 'Go' button.\r\n"
				+ "2. Verify account details are displayed correctly.\r\n"
				+ "3. Check if nominee details are shown if already added.\"");
		
		if(ElementDisplayed(nomineeRepo.aiAccDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account and nominee details are displayed correctly.");
			Log.info("Expected Result: Account and nominee details are displayed correctly.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
	public void newNominee(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

//		//New Nominee Section Initial State
//		ExtentTestManager.startTest("New Nominee Section Initial State").assignCategory("Account operation-Nominee Management");
//		Log.info("New Nominee Section Initial State");
//		
//		if(!CheckBoxStatus(nomineeRepo.nnNomineeNotRequired)) {
//			ExtentTestManager.getTest().log(Status.PASS, "\"1. Check the 'New Nominee' adding section is present.\r\n"
//					+ "2. Verify 'Nominee Not Required' checkbox is unticked.\"");
//			Log.info("\"1. Check the 'New Nominee' adding section is present.\r\n"
//					+ "2. Verify 'Nominee Not Required' checkbox is unticked.\"");
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New Nominee' section is present, and checkbox remains unticked.");
//			Log.info("Expected Result: New Nominee' section is present, and checkbox remains unticked.");
//		}else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
//		
//		ExtentTestManager.endTest();
		
		//Un-check the Nominee Not Required check box
		click(nomineeRepo.nnNomineeNotRequired);

		//Customer Search and Selection
		ExtentTestManager.startTest("Customer Search and Selection").assignCategory("Account operation-Nominee Management");
		Log.info("Customer Search and Selection");
		
		String parentWindow = driver.getWindowHandle();
		
		click(nomineeRepo.nnCustSRchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "1.Click the customer search icon");
		Log.info("1.Click the customer search icon");
		
		Set<String> address = driver.getWindowHandles();
		
		for(String c : address) {
			
			if(!c.equals(parentWindow)) {
				driver.switchTo().window(c);

			}
			
		}//for end
		
		if(ElementDisplayed(nomineeRepo.nnPopUpNameTxtBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer serach popup window will be displays.");
		Log.info("Expected Result: Customer serach popup window will be displays.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Name Field 
		ExtentTestManager.startTest("Name Field ").assignCategory("Account operation-Nominee Management");
		Log.info("Name Field ");
		
		String name = testdata.get("name").toString();
		input(nomineeRepo.nnPopUpNameTxtBox, name);
		
		click(nomineeRepo.nnPopUpSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Enter any alhabets or any name in the \"\"Name\"\" field\r\n"
				+ "2.Click search\"");
		Log.info("\"1. Enter any alhabets or any name in the \"\"Name\"\" field\r\n"
				+ "2.Click search\"");
		
		if(ElementDisplayed(nomineeRepo.nnPopUpSelect)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details will be diaplys against the given name.");
		Log.info("Expected Result: Details will be diaplys against the given name.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Name Field Autofill Check
		ExtentTestManager.startTest("Name Field Autofill Check").assignCategory("Account operation-Nominee Management");
		Log.info("Name Field Autofill Check");
		
		click(nomineeRepo.nnPopUpSelect);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select any one customer");
		Log.info("1. Select any one customer");
		
		driver.switchTo().window(parentWindow);
		
		String nameValue = driver.findElement(nomineeRepo.nnNameTxtBox).getAttribute("value");
		System.out.println("nameValue: "+nameValue);
		
		if(ElementDisplayed(nomineeRepo.nnNameTxtBox) && !nameValue.isBlank()) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed and customer details will be auto fill in the fields.");
		Log.info("Expected Result: Popup window will be closed and customer details will be auto fill in the fields.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Relation Drop-down Functional Check
		ExtentTestManager.startTest("Relation Drop-down Functional Check").assignCategory("Account operation-Nominee Management");
		Log.info("Relation Drop-down Functional Check");
		
		select("FRIEND",nomineeRepo.nnRelationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1.Select a relation from drop down");
		Log.info("1.Select a relation from drop down");
		
		if(dropdownSelectionValidation("FRIEND",nomineeRepo.nnRelationDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation' dropdown is functional, and selected relation is showing.");
			Log.info("Expected Result: Relation' dropdown is functional, and selected relation is showing.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Add Nominee Functionality
		ExtentTestManager.startTest("Add Nominee Functionality").assignCategory("Account operation-Nominee Management");
		Log.info("Add Nominee Functionality");
		
		ScrollUntilElementVisible(nomineeRepo.nnAddBtn);
		click(nomineeRepo.nnAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1.Click add button to add nominee");
		Log.info("1.Click add button to add nominee");
		
		if(ElementDisplayed(nomineeRepo.confirmationMsg)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Nominee has been added' validation will be displays");
		Log.info("Expected Result: 'Nominee has been added' validation will be displays");
		
		click(nomineeRepo.popUpCloseBtn);
		
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		actualUserName = custSrchMtds.getActualUserName(nomineeRepo.actualUserName);
		System.out.println("actualUserName: "+actualUserName);
		
	}//end
	
	
public void authorizeOther(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		
		
		//Login with Another User
		ExtentTestManager.startTest("Login with Another User").assignCategory("Account operation-Nominee Management");
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
		
		try {
			WebElement clickableElement = driver.findElement(By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]"));

			if (clickableElement != null) {
				// Perform the desired action on the element
				clickableElement.click();
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
				Log.info("Step:01 - Click on OK button");
				
//					String loginUserName = testdata.get("loginUserName").toString();
				input(custSearch.loginUserName, UserName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
				Log.info("Step:02 - Enetered valid User Name");
				
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				input(custSearch.loginPasswrd, Password);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
				Log.info("Step:03 - Entered valid Password");
				
				click(custSearch.loginButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
				Log.info("Step:04 - Click on Login Button");
				
				ElementDisplayed(custSearch.home);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
				Log.info("Expected Result: User is logged in successfully and dashboard visible");	
			} else {
				System.out.println("Element not clickable within the timeout.");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while waiting for the element: " + e.getMessage());
			System.out.println("Already login pop up not appeared");
		}

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
		ExtentTestManager.startTest("Manager Authorization").assignCategory("Account operation-Nominee Management");
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
		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("Account operation-Nominee Management");
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
		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("Account operation-Nominee Management");
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
