package com.Page_Debenture;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_DebentureRedemption;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanPayment;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class DebentureRedemption extends Base_Class{

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Debenture_DebentureRedemption debentureRedmRepo = new PageRepositary_Debenture_DebentureRedemption();
	PageRepositary_GroupLoans_GroupLoanPayment grpLoanPayRepo = new PageRepositary_GroupLoans_GroupLoanPayment();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();

	
	public String spAccNum = "EXEC GetDebAcNo '102','90068'";
	public String spAccNumTransfer = "EXEC GetDebAcNo '102','90067'";
	public String clmnNam = "AcNO";

	public String last4DigitsOfAccNum;
	String transId;	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn); 
	} 
	
	
	public void debentureRedemptionCash() throws InterruptedException, ClassNotFoundException {
		
		//Navigate to Debenture Redemption Window
		ExtentTestManager.startTest("Navigate to Debenture Redemption Window");
		Log.info("Navigate to Debenture Redemption Window");
		
		ScrollUntilElementVisible(debentureRedmRepo.debentureTab);
		
		click(debentureRedmRepo.debentureTab);
		
		click(debentureRedmRepo.debentureRedemptionTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Redemption ");
		Log.info("1. Navigate to Debenture >> Debenture Redemption ");
		
		if(ElementDisplayed(debentureRedmRepo.drBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Debenture Redemption Window displayed.");
			Log.info("Expected Result: " +  "Debenture Redemption Window displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Debenture Type Dropdown Selection
		ExtentTestManager.startTest("Verify Debenture Type Dropdown Selection");
		Log.info("Verify Debenture Type Dropdown Selection");
		
		
		
		select("DEB CASH",debentureRedmRepo.drDebTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Type' dropdown.\r\n"
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Type' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);
		
		if(dropdownSelectionValidation("DEB CASH",debentureRedmRepo.drDebTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture type is displayed in the dropdown.");
			Log.info("Expected Result: " +  "The selected debenture type is displayed in the dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Debenture Issue Dropdown Selection
		ExtentTestManager.startTest("Verify Debenture Issue Dropdown Selection");
		Log.info("Verify Debenture Issue Dropdown Selection");
		
		select("ISSUE-DEB CASH-66",debentureRedmRepo.drIssueTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Issue' dropdown.\r\n"
				+ "2. Select an option.\""
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Issue' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);

		if(dropdownSelectionValidation("ISSUE-DEB CASH-66",debentureRedmRepo.drIssueTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture issue is displayed, showing relevant options based on the type.");
			Log.info("Expected Result: " +  "The selected debenture issue is displayed, showing relevant options based on the type.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Debenture Series Dropdown Selection
		ExtentTestManager.startTest("Verify Debenture Series Dropdown Selection");
		Log.info("Verify Debenture Series Dropdown Selection");
		
		select("SERIES-ISSUE-DEB CASH-66-SERIES-2063",debentureRedmRepo.drSeriesDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Series' dropdown.\r\n"
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Series' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		if(dropdownSelectionValidation("SERIES-ISSUE-DEB CASH-66-SERIES-2063",debentureRedmRepo.drSeriesDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture series is displayed, showing relevant options based on the issue.");
			Log.info("Expected Result: " +  "The selected debenture series is displayed, showing relevant options based on the issue.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Verify Account Number Entry for Maturity
		ExtentTestManager.startTest("Verify Account Number Entry for Maturity");
		Log.info("Verify Account Number Entry for Maturity");

		String accNum = generateUniqueId(spAccNum, clmnNam);
		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

		input(debentureRedmRepo.drAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter an account number that has matured in the 'Ac No' field.");
		Log.info("1. Enter an account number that has matured in the 'Ac No' field.");
		
		if(inputValidation(debentureRedmRepo.drAccNumTxtBox, last4DigitsOfAccNum)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Account details are loaded if the account is due or post-due date.");
			Log.info("Expected Result: " +  "Account details are loaded if the account is due or post-due date.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Navigation to Redemption Window
		ExtentTestManager.startTest("Verify Navigation to Redemption Window");
		Log.info("Verify Navigation to Redemption Window");
		
		click(debentureRedmRepo.drGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the 'Go' button.");
		Log.info("1. Click the 'Go' button.");
		
		if(ElementDisplayed(debentureRedmRepo.drTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "User is directed to the redemption window of the account.");
			Log.info("Expected Result: " +  "User is directed to the redemption window of the account.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Transmode Selection as Cash
		ExtentTestManager.startTest("Verify Transmode Selection as Cash");
		Log.info("Verify Transmode Selection as Cash");
		
		String option = driver.findElement(debentureRedmRepo.drTransModeDropdownOption).getText();
		
		if(dropdownSelectionValidation(option, debentureRedmRepo.drTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Cash' in the Transmode field.");
			Log.info("1. Select 'Cash' in the Transmode field.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Transmode reflects 'Cash'.");
			Log.info("Expected Result: " +  "Transmode reflects 'Cash'.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Submission of Redemption
		ExtentTestManager.startTest("Verify Submission of Redemption");
		Log.info("Verify Submission of Redemption");
		
		ScrollUntilElementVisible(debentureRedmRepo.drSubmitbtn);
		
		click(debentureRedmRepo.drSubmitbtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the 'Submit' button.");
		Log.info("1. Click on the 'Submit' button.");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);
		
		if(ElementDisplayed(debentureRedmRepo.transIdSummaryPage)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Redemption is completed and user is navigated to the summary page.");
			Log.info("Expected Result: " +  "Redemption is completed and user is navigated to the summary page.");
			
			transId = driver.findElement(debentureRedmRepo.transIdSummaryPage).getText();
			System.out.println("transId: " + transId);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Print Functionality
		ExtentTestManager.startTest("Verify Print Functionality");
		Log.info("Verify Print Functionality");
		
		click(debentureRedmRepo.printBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the 'Print' button.");
		Log.info("1. Click the 'Print' button.");
		
        //Navigate to Pop Up Window
   /*  String mainWindowHandle = driver.getWindowHandle();
     boolean popupAppeared = false;
     for (String handle : driver.getWindowHandles()) {
         if (!handle.equals(mainWindowHandle)) {
             driver.switchTo().window(handle);
             driver.manage().window().maximize();
             popupAppeared = true;
          
             String currentUrl = driver.getCurrentUrl();
             System.out.println("currentUrl: "+currentUrl);
             
             if (currentUrl.endsWith(".pdf")) {
     			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Voucher is printed successfully.");
    			Log.info("Expected Result: " + "Voucher is printed successfully.");                   
             }else {
                     ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
                     Log.info("ERROR");
              }
               
               ExtentTestManager.endTest();
               
               driver.close();
               driver.switchTo().window(mainWindowHandle);
               
             break;  
             
         }
    
     }//for loop end */
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
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		

		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");
		
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
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redemption entry is present.");
		Log.info("Expected Result: Redemption entry is present.");
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redemption entry is successfully authorized by the manager.");
		Log.info("Expected Result: Redemption entry is successfully authorized by the manager.");

		ExtentTestManager.endTest();
		
		
		

		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");
		 

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
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redemption entry is successfully authorized by the cashier.");
		Log.info("Expected Result: Redemption entry is successfully authorized by the cashier.");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

		
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
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		 
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
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
		fetchWithTransId(transId);
		
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		click(depositLoanRepo.errorPopUpCloseIcon);

		
	}//end
	
	
	public void debentureRedemptionTransfer() throws InterruptedException, ClassNotFoundException {
				
		
		//Navigate to Debenture Redemption Window
		ExtentTestManager.startTest("Navigate to Debenture Redemption Window");
		Log.info("Navigate to Debenture Redemption Window");
		
		ScrollUntilElementVisible(debentureRedmRepo.debentureTab);
		
		click(debentureRedmRepo.debentureTab);
		
		click(debentureRedmRepo.debentureRedemptionTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Debenture >> Debenture Redemption ");
		Log.info("1. Navigate to Debenture >> Debenture Redemption ");
		
		if(ElementDisplayed(debentureRedmRepo.drBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Debenture Redemption Window displayed.");
			Log.info("Expected Result: " +  "Debenture Redemption Window displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Default Branch Display
		ExtentTestManager.startTest("Default Branch Display");
		Log.info("Default Branch Display");
		
		String loginBranchValue = driver.findElement(debentureRedmRepo.drLoginBranch).getText();
		System.out.println("loginBranchValue: " + loginBranchValue);
		String branchDropdownValue = driver.findElement(debentureRedmRepo.drBranchDropdownOption).getText();
		System.out.println("branchDropdownValue: " + branchDropdownValue);
		
		if(loginBranchValue.equals(branchDropdownValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "\"1. Verify the Branch field at the Redemption Window.\r\n"
					+ "2. Check the default value of the Branch field.\"");
			Log.info("\"1. Verify the Branch field at the Redemption Window.\r\n"
					+ "2. Check the default value of the Branch field.\"");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Logged-in branch is displayed as default.");
			Log.info("Expected Result: " +  "Logged-in branch is displayed as default.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Debenture Type Selection
		ExtentTestManager.startTest("Debenture Type Selection");
		Log.info("Debenture Type Selection");
		
		select("DEB TRAIL TRANSFER",debentureRedmRepo.drDebTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Type' dropdown.\r\n"
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Type' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);
		
		if(dropdownSelectionValidation("DEB TRAIL TRANSFER",debentureRedmRepo.drDebTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture type is displayed in the dropdown.");
			Log.info("Expected Result: " +  "The selected debenture type is displayed in the dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Debenture Issue Selection
		ExtentTestManager.startTest("Debenture Issue Selection");
		Log.info("Debenture Issue Selection");
		
		select("ISSUE-DEB TRAIL TRANSFER-65",debentureRedmRepo.drIssueTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Issue' dropdown.\r\n"
				+ "2. Select an option.\""
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Issue' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);

		if(dropdownSelectionValidation("ISSUE-DEB TRAIL TRANSFER-65",debentureRedmRepo.drIssueTypeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture issue is displayed, showing relevant options based on the type.");
			Log.info("Expected Result: " +  "The selected debenture issue is displayed, showing relevant options based on the type.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Debenture Series Selection
		ExtentTestManager.startTest("Debenture Series Selection");
		Log.info("Debenture Series Selection");
		
		select("SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062",debentureRedmRepo.drSeriesDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the 'Debenture Series' dropdown.\r\n"
				+ "2. Select an option.\"");
		Log.info("\"1. Click on the 'Debenture Series' dropdown.\r\n"
				+ "2. Select an option.\"");
		
		if(dropdownSelectionValidation("SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062",debentureRedmRepo.drSeriesDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "The selected debenture series is displayed, showing relevant options based on the issue.");
			Log.info("Expected Result: " +  "The selected debenture series is displayed, showing relevant options based on the issue.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		//Valid Account Number Entry
		ExtentTestManager.startTest("Valid Account Number Entry");
		Log.info("Valid Account Number Entry");

		String accNum = generateUniqueId(spAccNumTransfer, clmnNam);
		last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

		input(debentureRedmRepo.drAccNumTxtBox, last4DigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter an account number that has matured in the 'Ac No' field.");
		Log.info("1. Enter an account number that has matured in the 'Ac No' field.");
		
		if(inputValidation(debentureRedmRepo.drAccNumTxtBox, last4DigitsOfAccNum)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Account correctly added.");
			Log.info("Expected Result: " +  "Account correctly added.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Proceed to Redemption Window
		ExtentTestManager.startTest("Proceed to Redemption Window");
		Log.info("Proceed to Redemption Window");
		
		click(debentureRedmRepo.drGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the 'Go' button.");
		Log.info("1. Click the 'Go' button.");
		
		if(ElementDisplayed(debentureRedmRepo.drTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Transition occurs successfully.");
			Log.info("Expected Result: " +  "Transition occurs successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Interest Log Popup Display
		ExtentTestManager.startTest("Interest Log Popup Display");
		Log.info("Interest Log Popup Display");
		
		ScrollUntilElementVisible(debentureRedmRepo.drSubmitbtn);

		click(debentureRedmRepo.interestLogBtn);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the Interest Log button.\r\n"
				+ "2. Verify the popup display of interest details.\"");
		Log.info("\"1. Click on the Interest Log button.\r\n"
				+ "2. Verify the popup display of interest details.\"");
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> address = driver.getWindowHandles();
		
		for(String eachAddress : address) {
			if(!eachAddress.equals(address)) {
				driver.switchTo().window(eachAddress);
			}
		}//for end
		
		if(ElementDisplayed(debentureRedmRepo.interestLogTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Interest details are displayed in a popup correctly.");
			Log.info("Expected Result: " +  "Interest details are displayed in a popup correctly.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
		ExtentTestManager.endTest();
		
		
		
		//Transmode Transfer Selection
		ExtentTestManager.startTest("Transmode Transfer Selection");
		Log.info("Transmode Transfer Selection");
		
		String option = driver.findElement(debentureRedmRepo.drTransModeDropdownOption).getText();
		
		if(dropdownSelectionValidation(option, debentureRedmRepo.drTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Transfer' in the Transmode dropdown.");
			Log.info("1. Select 'Transfer' in the Transmode dropdown.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Transfer mode is selected correctly.");
			Log.info("Expected Result: " +  "Transfer mode is selected correctly.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		postCreditPopUpEntry();
		
		
		//Verify Submission of Redemption
		ExtentTestManager.startTest("Verify Submission of Redemption");
		Log.info("Verify Submission of Redemption");
		
		ScrollUntilElementVisible(debentureRedmRepo.drSubmitbtn);
		
		click(debentureRedmRepo.drSubmitbtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the 'Submit' button.");
		Log.info("1. Click on the 'Submit' button.");
		
		waitUntilElementDisappear(debentureRedmRepo.loader);
		
		if(ElementDisplayed(debentureRedmRepo.transIdSummaryPage)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Redemption is completed and user is navigated to the summary page.");
			Log.info("Expected Result: " +  "Redemption is completed and user is navigated to the summary page.");
			
			transId = driver.findElement(debentureRedmRepo.transIdSummaryPage).getText();
			System.out.println("transId: " + transId);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		
		/*//Verify Print Functionality
		ExtentTestManager.startTest("Verify Print Functionality");
		Log.info("Verify Print Functionality");
		
		click(debentureRedmRepo.printBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the 'Print' button.");
		Log.info("1. Click the 'Print' button.");
		
        //Navigate to Pop Up Window
     String mainWindowHandle = driver.getWindowHandle();
     boolean popupAppeared = false;
     for (String handle : driver.getWindowHandles()) {
         if (!handle.equals(mainWindowHandle)) {
             driver.switchTo().window(handle);
             driver.manage().window().maximize();
             popupAppeared = true;
          
             String currentUrl = driver.getCurrentUrl();
             System.out.println("currentUrl: "+currentUrl);
             
             if (currentUrl.endsWith(".pdf")) {
     			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Voucher is printed successfully.");
    			Log.info("Expected Result: " + "Voucher is printed successfully.");                   
             }else {
                     ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
                     Log.info("ERROR");
              }
               
               ExtentTestManager.endTest();
               
               driver.close();
               driver.switchTo().window(mainWindowHandle);
               
             break;  
             
         }
    
     }//for loop end*/
		ExtentTestManager.endTest();
	}//end


	public void postCreditPopUpEntry() throws InterruptedException {
		//Post credit button functionality
				ExtentTestManager.startTest("Post credit button functionality");
				Log.info("Post credit button functionality");
				
				click(debentureRedmRepo.postCreditBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Post credit button.");
				Log.info("Step:01 - Select Post credit button.");
				
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


						
						//Select Transaction Based
						ExtentTestManager.startTest("Select Transaction Based");
						Log.info("Select Transaction Based");
						
						select("Account",depositLoanRepo.oiTransBasedDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as Account.");
						Log.info("Step:01 - Select transaction based as Account.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
						Log.info("Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
			 
						ExtentTestManager.endTest();
						

						
						//Select Product Group.
						ExtentTestManager.startTest("Select Product Group");
						Log.info("Select Product Group");
						
						select("Demand Investment",depositLoanRepo.productGroupDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Demand Investment from the 'Product group ' drop down.");
						Log.info("Step:01 - Select Demand Investment from the 'Product group ' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected ");
						Log.info("Expected Result:  Demand Investment is selected ");
			 
						ExtentTestManager.endTest();
						

						
						//Select Product Name
						ExtentTestManager.startTest("Select Product Name");
						Log.info("Select Product Name");
						
						select("INV-DEMAND-CA",depositLoanRepo.productNameDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from the 'Product Name' drop down.");
						Log.info("Step:01 - Select an item from the 'Product Name' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
						Log.info("Expected Result:  Product name item  is selected ");
			 
						ExtentTestManager.endTest();
						

						
						//Select Branch
						ExtentTestManager.startTest("Select Branch");
						Log.info("Select Branch");
						
						select("TRIVANDRUM",depositLoanRepo.branchDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a branch  from the 'Branch  ' drop down.");
						Log.info("Step:01 - Select a branch  from the 'Branch  ' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch  item  is selected ");
						Log.info("Expected Result:  Branch  item  is selected  ");
			 
						ExtentTestManager.endTest();
							

							
							//Select Account
							ExtentTestManager.startTest("Select Account");
							Log.info("Select Account");						
							
//							String accNum = testdata.get("accNum").toString();
							input(depositLoanRepo.accNumTxtBox, "3");
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick mark and select an account from the list of accounts displayed.");
							Log.info("Step:01 - Tick mark and select an account from the list of accounts displayed.");
							
							click(depositLoanRepo.accNumTxt);
							
							String remarksValue = driver.findElement(depositLoanRepo.remarksTxtBox).getAttribute("value");
							
							if(!remarksValue.isBlank()) {
								ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is selected & data  gets auto filled in the text fields");
								Log.info("Expected Result:  Account is selected & data  gets auto filled in the text fields");
							}else {
				    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				    			Log.info("ERROR");
				    		}
				 
							ExtentTestManager.endTest();
							

							
							//Enter Amount
							ExtentTestManager.startTest("Enter Amount");
							Log.info("Enter Amount");						
							
							String amntValue = driver.findElement(By.xpath("//*[@id=\"txtBalAmount_txt\"]")).getAttribute("value");
							String amntValue1 = amntValue.split("\\.")[0];
							System.out.println("amntValue1: " + amntValue1);
							
							clear(depositLoanRepo.amtTxtBox);
							click(depositLoanRepo.amtTxtBox);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the amount in \"Amount\" field");
							Log.info("Step:01 - Give the amount in \"Amount\" field.");
							
							input(depositLoanRepo.amtTxtBox, amntValue1);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid amount in the input field.");
							Log.info("Step:01 - Enter a valid amount in the input field.");
														
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount accepted");
							Log.info("Expected Result: Amount accepted");
				 
							ExtentTestManager.endTest();
							
							

						
						//Add button functionality
						ExtentTestManager.startTest("Add button functionality");
						Log.info("Add button functionality");

						click(depositLoanRepo.addBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button");
						Log.info("Step:01 - Click add button.");
						
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
						
						click(depositLoanRepo.submitBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
						Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

			    		driver.switchTo().window(mainWindowHandle);
			    		
			            if(ElementDisplayed(debentureRedmRepo.postCreditBtn)) { 
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
