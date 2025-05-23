package com.Page_AccountOperations;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_AccOpr_MembMang_MembMang_Loan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class MemberManagement_MemberManagementLoan extends Base_Class{

	public String spAccNum = "exec SPGetmemberLoan 23001";
	public String clmnNam = "AcNO";
	public String last4DigitsOfAccNum;
	public String actualUserName;

	PageRepositary_AccOpr_MembMang_MembMang_Loan loanRepo = new PageRepositary_AccOpr_MembMang_MembMang_Loan();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting loanChargPostingrepo = new PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	
	public void navigateToMemberManagementLoan() throws InterruptedException {
		
//		actualUserName = custSrchMtds
		
		//Open Member Management Loan Window
		ExtentTestManager.startTest("Open Member Management Loan Window").assignCategory("Account operation-Member management_Loan");
		Log.info("Open Member Management Loan Window");
		
		click(loanRepo.accountOPerationsTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Expand account operation.");
		Log.info("1. Expand account operation.");

		click(loanRepo.memberManagementTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Expand member management.");
		Log.info("2. Expand member management.");
		
		click(loanRepo.memberManagementLoanTab);
		ExtentTestManager.getTest().log(Status.PASS, "3. Select member management loan.");
		Log.info("3. Select member management loan.");

		/*if(ElementDisplayed(loanRepo.aiBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Member management loan window is opened.");
			Log.info("Expected Result: Member management loan window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}*/
		
		ExtentTestManager.endTest();
		
	}//end

	
	
	
	public void accountInfo() throws InterruptedException, ClassNotFoundException {

		
		//Select Product Group - Positive Scenario
		ExtentTestManager.startTest("Select Product Group - Positive Scenario").assignCategory("Account operation-Member management_Loan");
		Log.info("Select Product Group - Positive Scenario");
		
		select("OTHER LOANS",loanRepo.aiProductGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'OTHER LOANS' from the product group dropdown.");
		Log.info("1. Select 'OTHER LOANS' from the product group dropdown.");
		
		waitUntilElementDisappear(loanRepo.loader);
		
		if(dropdownSelectionValidation("OTHER LOANS",loanRepo.aiProductGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'OTHER LOANS' is selected in the product group dropdown.");
			Log.info("Expected Result: 'OTHER LOANS' is selected in the product group dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Select Product Name - Positive Scenario
		ExtentTestManager.startTest("Select Product Name - Positive Scenario").assignCategory("Account operation-Member management_Loan");
		Log.info("Select Product Name - Positive Scenario");
		
		select("PERSONAL LOAN WEEKLY",loanRepo.aiProductDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select a valid product name from the product dropdown.");
		Log.info("1. Select a valid product name from the product dropdown.");
		
		if(dropdownSelectionValidation("PERSONAL LOAN WEEKLY",loanRepo.aiProductDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The selected product name is displayed.");
			Log.info("Expected Result: The selected product name is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Enter Account Number - Positive Scenario
		ExtentTestManager.startTest("Enter Account Number - Positive Scenario").assignCategory("Account operation-Member management_Loan");
		Log.info("Enter Account Number - Positive Scenario");

		String accNum = transJewelMthds.generateUniqueId(spAccNum, clmnNam);
		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

		input(loanRepo.aiAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid  account number.");
		Log.info("1. Enter a valid  account number.");
		
		if(inputValidation(loanRepo.aiAccNumTxtBox,last4DigitsOfAccNum)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The  account number is displayed in the input field.");
			Log.info("Expected Result: The  account number is displayed in the input field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Go Button Functionality
		ExtentTestManager.startTest("Go Button Functionality").assignCategory("Account operation-Member management_Loan");
		Log.info("Go Button Functionality");
		
		click(loanRepo.aiGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the Go button.");
		Log.info("1. Click the Go button.");
		
		if(ElementDisplayed(loanRepo.aiAccDetailsGrid)) {
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
		ExtentTestManager.startTest("Search Customer by Name").assignCategory("Account operation-Member management_Loan");
		Log.info("Search Customer by Name");
		
		String parentWindow = driver.getWindowHandle();

		click(loanRepo.anmCustSrchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on 'Select Customer' popup button");
		Log.info("1. Click on 'Select Customer' popup button");
		
		Set<String> address = driver.getWindowHandles();
		
		for(String c : address) {
			
			if(!c.equals(parentWindow)) {
				driver.switchTo().window(c);

			}
			
		}//for end
		
		String name = testdata.get("name").toString();
		input(loanRepo.popUpNameTxtBox, name);
		ExtentTestManager.getTest().log(Status.PASS, "2. Enter alphabets in 'Name' field");
		Log.info("2. Enter alphabets in 'Name' field");

		click(loanRepo.popUpSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "3. Click 'Search' button");
		Log.info("3. Click 'Search' button");
		
		if(ElementDisplayed(loanRepo.popUpSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search results display based on name input");
			Log.info("Expected Result: Customer search results display based on name input");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		
		
		//Select and Add Customer
		ExtentTestManager.startTest("Select and Add Customer").assignCategory("Account operation-Member management_Loan");
		Log.info("Select and Add Customer");

		click(loanRepo.popUpSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Click on a listed customer in the results\r\n"
				+ "2. Click 'Select'");
		Log.info("Click on a listed customer in the results\r\n"
				+ "2. Click 'Select'");
		
		driver.switchTo().window(parentWindow);
		
		String anmCustIdTxtBoxValue = driver.findElement(loanRepo.anmCustIdTxtBox).getAttribute("value");
		System.out.println("anmCustIdTxtBoxValue: " + anmCustIdTxtBoxValue);
		
		String anmAccNameTxtBoxValue = driver.findElement(loanRepo.anmAccNameTxtBox).getAttribute("value");
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
		ExtentTestManager.startTest("Select Loanee Type - Positive Scenario").assignCategory("Account operation-Member management_Loan");
		Log.info("Select Loanee Type - Positive Scenario");
		
		select("Co-Applicant",loanRepo.anmLoaneeTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select a valid loanee type from the dropdown.");
		Log.info("1. Select a valid loanee type from the dropdown.");
		
		if(dropdownSelectionValidation("Co-Applicant",loanRepo.anmLoaneeTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "\"Expected Result: The selected loanee type is displayed.\"");
			Log.info("Expected Result: The selected loanee type is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Add Customer
		ExtentTestManager.startTest("Add Customer").assignCategory("Account operation-Member management_Loan");
		Log.info("Add Customer");
		
		click(loanRepo.anmAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the Add button.");
		Log.info("1. Click the Add button.");
		
		if(ElementDisplayed(loanRepo.anmCustDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added for the loan.");
			Log.info("Expected Result: Customer is added for the loan.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Enter Remark - Positive Scenario
		ExtentTestManager.startTest("Enter Remark - Positive Scenario").assignCategory("Account operation-Member management_Loan");
		Log.info("Enter Remark - Positive Scenario");
		
		String remark = testdata.get("remark").toString();
		input(loanRepo.anmRemarkTxtBox, remark);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter a valid remark.");
		Log.info("1. Enter a valid remark.");
		
		if(inputValidation(loanRepo.anmRemarkTxtBox,remark)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The remark is displayed in the input field.");
			Log.info("Expected Result: The remark is displayed in the input field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Submit transaction
		ExtentTestManager.startTest("Submit transaction").assignCategory("Account operation-Member management_Loan");
		Log.info("Submit transaction");
		
		click(loanRepo.submitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the Submit button.");
		Log.info("1. Click the Submit button.");
		
		if(ElementDisplayed(loanRepo.errorPopUpCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction Submitted.");
			Log.info("Expected Result: Transaction Submitted.");
			
			click(loanRepo.errorPopUpCloseBtn);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		actualUserName = custSrchMtds.getActualUserName(loanRepo.actualUserName);
		
	}//end
	
	
	public void authorizeOther(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		
		
		//Login with Another User
		ExtentTestManager.startTest("Login with Another User").assignCategory("Account operation-Member management_Loan");
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
		ExtentTestManager.startTest("Manager Authorization").assignCategory("Account operation-Member management_Loan");
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
		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("Account operation-Member management_Loan");
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
		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("Account operation-Member management_Loan");
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
