
package com.Page_Others;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Others_DataSharing_CollectionImporting;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class DataSharing_CollectionImporting extends Base_Class{

	public String spAccNum = "EXEC GetOtherLoanAccountNumberForTransaction";
	public String clmnNam = "Acno";
	public String last4DigitsOfAccNum;
	public String actualUserName;
	String transId;
	
	
	PageRepositary_Others_DataSharing_CollectionImporting collImportRepo = new PageRepositary_Others_DataSharing_CollectionImporting();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();

	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
	
	public void navigateToCollectionImporting() throws InterruptedException {

		//Expand Module for Collection Importing
		ExtentTestManager.startTest("Expand Module for Collection Importing");
		Log.info("Expand Module for Collection Importing");
		
		click(collImportRepo.othersTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to 'others' module.");
		Log.info("1. Navigate to 'others' module.");

		click(collImportRepo.dataSharingTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Expand 'data sharing'.");
		Log.info("2. Expand 'data sharing'.");

		click(collImportRepo.collectionImportingTab);
		ExtentTestManager.getTest().log(Status.PASS, "3. Click on 'collection importing'.");
		Log.info("3. Click on 'collection importing'.");
		
		if(ElementDisplayed(collImportRepo.adAgentCodeTextBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Collection importing window is opened.");
			Log.info("Expected Result: Collection importing window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void agentDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		

		//Verify Auto-load of Agent Code
		ExtentTestManager.startTest("Verify Auto-load of Agent Code");
		Log.info("Verify Auto-load of Agent Code");

		click(collImportRepo.adAgentNameDropdown);
		click(collImportRepo.adAgentNameOption);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select an agent name from the dropdown.");
		Log.info("1. Select an agent name from the dropdown.");
		
		String agentCodeValue = driver.findElement(collImportRepo.adAgentCodeTextBox).getAttribute("value");
		
		if(!agentCodeValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent code is auto-loaded corresponding to the selected agent name.");
			Log.info("Expected Result: Agent code is auto-loaded corresponding to the selected agent name.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Select Main Branch from Dropdown
		ExtentTestManager.startTest("Select Main Branch from Dropdown");
		Log.info("Select Main Branch from Dropdown");
		
		select("TRIVANDRUM",collImportRepo.adBranchDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select the main branch from the dropdown.");
		Log.info("1. Select the main branch from the dropdown.");
		
		if(dropdownSelectionValidation("TRIVANDRUM",collImportRepo.adBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Main branch is correctly selected without errors.");
			Log.info("Expected Result: Main branch is correctly selected without errors.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Select Product Group and Name
		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");
		
		select("OTHER LOANS",collImportRepo.adProductGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select a product group from the dropdown.");
		Log.info("1. Select a product group from the dropdown.");
		
//		waitUntilElementDisappear(collImportRepo.loader);

		select("PERSONAL LOAN WEEKLY",collImportRepo.adProductTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "2. Select a product name from the dropdown.");
		Log.info("2. Select a product name from the dropdown.");
		
		if(dropdownSelectionValidation("OTHER LOANS",collImportRepo.adProductGroupDropdown) && dropdownSelectionValidation("PERSONAL LOAN WEEKLY",collImportRepo.adProductTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product group and name are selected without errors.");
			Log.info("Expected Result: Product group and name are selected without errors.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Verify Auto-load of Account Details
		ExtentTestManager.startTest("Verify Auto-load of Account Details");
		Log.info("Verify Auto-load of Account Details");

//		String accNum = transJewelMthds.generateUniqueId(spAccNum, clmnNam);
//		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);
		String last4DigitsOfAccNum = testdata.get("last4DigitsOfAccNum").toString();
//		last4DigitsOfAccNum = "3203";


		input(collImportRepo.adAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid  account number.");
		Log.info("1. Enter a valid  account number.");
		
		click(collImportRepo.adRandomTxt);
		
		String adTotalDurationValue = driver.findElement(collImportRepo.adTotalDurationTxtBox).getAttribute("value");
		String adTotalDueTxtBoxValue = driver.findElement(collImportRepo.adTotalDueTxtBox).getAttribute("value");
		String adStatrtDateValue = driver.findElement(collImportRepo.adStatrtDate).getAttribute("value");
		String adDueDateValue = driver.findElement(collImportRepo.adDueDate).getAttribute("value");
		String adBillNumTxtBoxValue = driver.findElement(collImportRepo.adBillNumTxtBox).getAttribute("value");
		String adFineTxtBoxValue = driver.findElement(collImportRepo.adFineTxtBox).getAttribute("value");
		String adInstallmentAmtTxtBoxValue = driver.findElement(collImportRepo.adInstallmentAmtTxtBox).getAttribute("value");

		double fineValue = Double.parseDouble(adFineTxtBoxValue);
		System.out.println("fineValue: "+fineValue);
		double installmentAmtValue = Double.parseDouble(adInstallmentAmtTxtBoxValue);
		System.out.println("installmentAmtValue: "+installmentAmtValue);

		double amt = fineValue+installmentAmtValue;
		System.out.println("amt: "+amt);

		String amount = Double.toString(amt);
		System.out.println("amount: "+amount);

		if(!adTotalDurationValue.isBlank() && !adTotalDueTxtBoxValue.isBlank() && !adStatrtDateValue.isBlank() && !adDueDateValue.isBlank()  && !adBillNumTxtBoxValue.isBlank() && !adFineTxtBoxValue.isBlank() && !adInstallmentAmtTxtBoxValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Total Duration, Total Due, Start Date, Due Date, Cust. Spl. Inst, Bill No, Ac. Spl. Inst, Amount, and Fine are auto-loaded.");
			Log.info("Expected Result: Total Duration, Total Due, Start Date, Due Date, Cust. Spl. Inst, Bill No, Ac. Spl. Inst, Amount, and Fine are auto-loaded.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Enter Amount for Transfer
		ExtentTestManager.startTest("Enter Amount for Transfer");
		Log.info("Enter Amount for Transfer");
		
		input(collImportRepo.adAmountTxtBox, amount);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter the amount for transfer.");
		Log.info("1. Enter the amount for transfer.");
		
		if(inputValidation(collImportRepo.adAmountTxtBox, amount)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entered amount is accepted without errors.");
			Log.info("Expected Result: Entered amount is accepted without errors.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Add Transfer Details to Grid
		ExtentTestManager.startTest("Add Transfer Details to Grid");
		Log.info("Add Transfer Details to Grid");

		click(collImportRepo.adAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Add'.");
		Log.info("1. Click 'Add'.");
		
		if(ElementDisplayed(collImportRepo.adAgentDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are added to the grid of import details.");
			Log.info("Expected Result: Details are added to the grid of import details.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
	}//end
	
	
	
	public void selectTransModeCashAndSubmit(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		

		//Error Guessing - Empty Mandatory Fields
		ExtentTestManager.startTest("Error Guessing - Empty Mandatory Fields");
		Log.info("Error Guessing - Empty Mandatory Fields");
		
		ScrollUntilElementVisible(collImportRepo.adSubmitBtn);
		
		click(collImportRepo.adSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Submit' without entering mandatory fields.");
		Log.info("1. Click 'Submit' without entering mandatory fields.");
		
		if(ElementDisplayed(collImportRepo.requiredErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message prompts: 'Please fill in all mandatory fields'");
			Log.info("Expected Result: Error message prompts: 'Please fill in all mandatory fields'");
			
			click(collImportRepo.errorPopUpClose);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Verify Cash Collection Importing
		ExtentTestManager.startTest("Verify Cash Collection Importing");
		Log.info("Verify Cash Collection Importing");
		
		select("CASH",collImportRepo.adTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Attempt to do collection importing using 'cash'.");
		Log.info("1. Attempt to do collection importing using 'cash'.");
		
		waitUntilElementDisappear(collImportRepo.loader);
		
		if(dropdownSelectionValidation("CASH",collImportRepo.adTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Collection importing using 'cash' is possible and proceeds without error.");
			Log.info("Expected Result: Collection importing using 'cash' is possible and proceeds without error.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Enter Remark Details
		ExtentTestManager.startTest("Enter Remark Details");
		Log.info("Enter Remark Details");
		
		String remarks = testdata.get("remarks").toString();
		input(collImportRepo.adRemarksTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter remarks in the provided field.");
		Log.info("1. Enter remarks in the provided field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks are accepted without errors.");
		Log.info("Expected Result: Remarks are accepted without errors.");
		
		ExtentTestManager.endTest();
		

		
		//Verify Operation Summary on Submission
		ExtentTestManager.startTest("Verify Operation Summary on Submission");
		Log.info("Verify Operation Summary on Submission");

		click(collImportRepo.adSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Submit'.");
		Log.info("1. Click 'Submit'.");
		
		if(ElementDisplayed(collImportRepo.summaryTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary of operation is displayed correctly.");
			Log.info("Expected Result: Summary of operation is displayed correctly.");
			
			transId = driver.findElement(collImportRepo.summaryTransId).getText();
			System.out.println("transId: "+transId);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
public void selectTransModeTransferAndSubmit(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		
		//Verify Cash Collection Importing
		ExtentTestManager.startTest("Verify TRANSFER Collection Importing");
		Log.info("Verify TRANSFER Collection Importing");
		
		select("TRANSFER",collImportRepo.adTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Attempt to do collection importing using 'TRANSFER'.");
		Log.info("1. Attempt to do collection importing using 'TRANSFER'.");
		
		waitUntilElementDisappear(collImportRepo.loader);

		if(dropdownSelectionValidation("TRANSFER",collImportRepo.adTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Collection importing using 'TRANSFER' is possible and proceeds without error.");
			Log.info("Expected Result: Collection importing using 'TRANSFER' is possible and proceeds without error.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Enter Remark Details
		ExtentTestManager.startTest("Enter Remark Details");
		Log.info("Enter Remark Details");
		
		String remarks = testdata.get("remarks").toString();
		input(collImportRepo.adRemarksTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter remarks in the provided field.");
		Log.info("1. Enter remarks in the provided field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks are accepted without errors.");
		Log.info("Expected Result: Remarks are accepted without errors.");
		
		ExtentTestManager.endTest();
		

		postCreditPopUpEntry();
		
		//Verify Operation Summary on Submission
		ExtentTestManager.startTest("Verify Operation Summary on Submission");
		Log.info("Verify Operation Summary on Submission");

		click(collImportRepo.adSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Submit'.");
		Log.info("1. Click 'Submit'.");
		
		if(ElementDisplayed(collImportRepo.summaryTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary of operation is displayed correctly.");
			Log.info("Expected Result: Summary of operation is displayed correctly.");
			
			transId = driver.findElement(collImportRepo.summaryTransId).getText();
			System.out.println("transId: "+transId);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end

	
	
	
	
	public void authorizeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

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
		
		ExtentTestManager.endTest();
		
		
		
		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.cashierAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(goaldLoanRepo.cashierRefreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		fetchWithTransId(transId);
		
		click(goaldLoanRepo.cashierCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(goaldLoanRepo.cashierAuthorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");
		
		if(ElementDisplayed(goaldLoanRepo.refreshBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab loads");
		Log.info("Expected Result: Cash tab load");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBox)) {
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
		
		
		click(goaldLoanRepo.approveCheckBox);
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
	
	public void postCreditPopUpEntry() throws InterruptedException {
		//Post credit button functionality
				ExtentTestManager.startTest("Post credit button functionality");
				Log.info("Post credit button functionality");
				
				click(collImportRepo.adPostDebitBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Post Debit button.");
				Log.info("Step:01 - Select Post Debit button.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			         
			    		
			            if(ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Auto posting popup window will be opened.");
							Log.info("Expected Result: Auto posting popup window will be opened.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			            
						ExtentTestManager.endTest();


						
						//Transaction based selection.
						ExtentTestManager.startTest("Transaction based selection.");
						Log.info("Transaction based selection.");
						
						select("GL Code",depositLoanRepo.oiTransBasedDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as GL Code.");
						Log.info("Step:01 - Select transaction based as GL Code.");
						
			            if(ElementDisplayed(depositLoanRepo.oiGLNameTxtBox) && ElementDisplayed(depositLoanRepo.oiGLAccCodeTxtBox)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code related field will be display (GL name,GL code).");
						Log.info("Expected Result: GL code related field will be display (GL name,GL code)");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			            
						ExtentTestManager.endTest();
						
						
						
						//GL Name selection.
						ExtentTestManager.startTest("GL Name selection.");
						Log.info("GL Name selection.");
						
						click(depositLoanRepo.oiGLNameTxtBox);
						click(depositLoanRepo.oiGLNameOption);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the \"GL Name\" from the drop down");
						Log.info("Step:01 - Select the \"GL Name\" from the drop down");
			            
						String GLAccCodeValue = driver.findElement(depositLoanRepo.oiGLAccCodeTxtBox).getAttribute("value");
						
			    		if(!GLAccCodeValue.isBlank()) {
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code will be autoloads while selecting the GL Name.");
									Log.info("Expected Result: GL code will be autoloads while selecting the GL Name.");
					    		}else {
					    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					    			Log.info("ERROR");
					    		}
					    		
					    ExtentTestManager.endTest();
					    

						
						//Add button functionality
						ExtentTestManager.startTest("Add button functionality");
						Log.info("Add button functionality");
						
						String amntValue = driver.findElement(depositLoanRepo.oiBalanceAmtTxtBox).getAttribute("value");
						String amntValue1 = amntValue.split("\\.")[0];
						
						clear(depositLoanRepo.oiAmntTxtBox);
						click(depositLoanRepo.oiAmntTxtBox);
						input(depositLoanRepo.oiAmntTxtBox, amntValue1);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the amount in \"Amount\" field");
						Log.info("Step:01 - Give the amount in \"Amount\" field.");

						click(depositLoanRepo.oiAddBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click add button");
						Log.info("Step:02 - Click add button.");
						
			            if(ElementDisplayed(depositLoanRepo.oiAutoPostingGrid)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
						Log.info("Expected Result: Given details will be displays in the grid");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}

						ExtentTestManager.endTest();
						
						
						
						//Submit button functionality
						ExtentTestManager.startTest("Submit button functionality");
						Log.info("Submit button functionality");
						
						click(depositLoanRepo.oiSubmitBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
						Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

			    		driver.switchTo().window(mainWindowHandle);
			    		
			            if(ElementDisplayed(collImportRepo.adPostDebitBtn)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
						Log.info("Expected Result: Popup window will be closed");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
	}
	
	
}