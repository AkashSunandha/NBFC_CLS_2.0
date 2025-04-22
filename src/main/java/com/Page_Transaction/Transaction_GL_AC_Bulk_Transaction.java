package com.Page_Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
//import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.BasePackage.Base_Class;
import com.Page_InvestmentTransactionCash_Transfer.InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Transaction_GL_AC_Bulk_Transaction;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Last_Entry_Cancellation;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Suspense_Liability;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_GL_AC_Bulk_Transaction extends Base_Class {

	InvestmentTransaction_Cash_Transfer InvestmentTransaction = new InvestmentTransaction_Cash_Transfer();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Transaction_GL_AC_Bulk_Transaction transaction_GL_AC_BulkRepo  =new PageRepositary_Transaction_GL_AC_Bulk_Transaction();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Transaction_Transactions_Last_Entry_Cancellation Transactions_Last_Entry_CancellationRepo =new PageRepositary_Transaction_Transactions_Last_Entry_Cancellation();
	PageRepositary_Transaction_Transactions_Suspense_Liability Transactions_SusLiabilityRepo = new PageRepositary_Transaction_Transactions_Suspense_Liability();
	Transaction_Transactions_Jewel Transactions_Jewel = new Transaction_Transactions_Jewel();
	public String spAccNum = "exec GetJewelloanAccountnumber;";
	public String clmnNam = "Acno";

	String transId;
	String lastValue;
	String Acc_No;
	String formattedDate;
	public String sp = "GetSuspenseLiabilityAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(Transactions_SusLiabilityRepo.transIdTxtBox, transId);
		click(Transactions_SusLiabilityRepo.goBtn);
	}


	public void AddButton() throws InterruptedException {
		Thread.sleep(2000);
		click(transaction_GL_AC_BulkRepo.AddButton);
		ExtentSuccessMessage("Step:02 - Click on the Add Button.");
		Log.info("Step:02 - Click on the Add Button.");
	}

	public void Navigate_GL_AC_Bulk_Transaction() throws InterruptedException {

		//Open Transaction Module
		ExtentTestManager.startTest("Navigate to Transactions >> GL A/c Bulk Transaction.");
		Log.info("Navigate to Transactions >> GL A/c Bulk Transaction.");

		click(transaction_GL_AC_BulkRepo.transactionTab);
		ExtentSuccessMessage("Step:01 - Navigate to the transaction module in the menu.");
		Log.info("Step:01 - Navigate to the transaction module in the menu.");

		click(transaction_GL_AC_BulkRepo.GL_AC_Bulk_Transaction);
		ExtentSuccessMessage("Step:02 - Click on the GL_AC_Bulk_Transaction module.");
		Log.info("Step:02 - Click on the GL_AC_Bulk_Transaction module.");

		if (ElementDisplayed(transaction_GL_AC_BulkRepo.VerifyGL_AC_Bulk_transaction)) {
			ExtentSuccessMessage("Expected Result: GL_AC_Bulk_Transaction module opens successfully.");
			Log.info("Expected Result: GL_AC_Bulk_Transaction module opens successfully.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	}

	public void EnterTransactionAmount(Map < Object, Object > testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Enter Transaction Amount");

		String transAmt = testdata.get("amount").toString();
		clear(transaction_GL_AC_BulkRepo.TransAmount);
		click(transaction_GL_AC_BulkRepo.TransAmount);
		input(transaction_GL_AC_BulkRepo.TransAmount, transAmt);
		ExtentSuccessMessage("Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}

	public void GLccountinfo(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		//Select Branch
		//		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");

		select("TRIVANDRUM", transaction_GL_AC_BulkRepo.aiBranchDropdown);
		ExtentSuccessMessage("Step:01 -  Select a branch from the dropdown.");
		Log.info("Step:01 -  Select a branch from the dropdown.");

		ExtentSuccessMessage("Expected Result: Correct branch  selected.");
		Log.info("Expected Result: Correct branch  selected.");

		ExtentTestManager.endTest();

		SelectTranscationType("Credit");

		//		ExtentTestManager.endTest();

		//		ExtentTestManager.startTest("Select Account Type");
		Log.info("Select Account Type");

		select("Accounts", transaction_GL_AC_BulkRepo.aiAccountTypeDropdown);
		ExtentSuccessMessage("Step:01 -  Choose 'Accounts' for Transaction Type.");
		Log.info("Step:01 -  Choose 'Accounts' for Transaction Type.");

		ExtentSuccessMessage("Expected Result: Correct Account Type  selected.");
		Log.info("Expected Result: Correct Account Type  selected.");

		//		ExtentTestManager.endTest();
		SearchAccountpopup();

		EnterTransactionAmount(testdata);
		AddButton();
		AddButton();

		//		transModeCash();

	}
	public void GLccountinfoDebit(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		//Select Branch
		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");

		select("TRIVANDRUM", transaction_GL_AC_BulkRepo.aiBranchDropdown);
		ExtentSuccessMessage("Step:01 -  Select a branch from the dropdown.");
		Log.info("Step:01 -  Select a branch from the dropdown.");

		ExtentSuccessMessage("Expected Result: Correct branch  selected.");
		Log.info("Expected Result: Correct branch  selected.");

		ExtentTestManager.endTest();

		SelectTranscationType("Debit");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Account Type");
		Log.info("Select Account Type");

		select("Accounts", transaction_GL_AC_BulkRepo.aiAccountTypeDropdown);
		ExtentSuccessMessage("Step:01 -  Choose 'Accounts' for Transaction Type.");
		Log.info("Step:01 -  Choose 'Accounts' for Transaction Type.");

		ExtentSuccessMessage("Expected Result: Correct Account Type  selected.");
		Log.info("Expected Result: Correct Account Type  selected.");

		ExtentTestManager.endTest();
		SearchAccountpopup();

		EnterTransactionAmount(testdata);
		AddButton();
		AddButton();

		//		transModSeCash();

	}

	public void SelectTranscationType(String Value) throws InterruptedException {
		//Select Transaction Type
		//		ExtentTestManager.startTest("Select Transaction Type");
		Log.info("Select Transaction Type");

		select(Value, transaction_GL_AC_BulkRepo.aiTransactionTypeDropdown);

		ExtentSuccessMessage("Step:01 -  Choose '"+Value+"' for Transaction Type.");
		Log.info("Step:01 -  Choose '"+Value+"' for Transaction Type.");

		ExtentSuccessMessage("Expected Result: Correct Transaction Type selected.");
		Log.info("Expected Result: Correct Transaction Type selected.");
		//		ExtentTestManager.endTest();
	}
	public void SearchAccountpopup() throws InterruptedException {
		//		Accountpopup
		ExtentTestManager.startTest("Search Account popup");
		Log.info("Search Account popup");

		click(transaction_GL_AC_BulkRepo.Accountpopup);
		ExtentSuccessMessage("Step:01 - Click on the Search Account popup.");
		Log.info("Step:01 - Click on the Search Account popup.");

		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				if (ElementDisplayed(transaction_GL_AC_BulkRepo.AccountsearchGroupNameDropdown)) {
					ExtentSuccessMessage("Expected Result: Accoount Search popup window will be opened.");
					Log.info("Expected Result: Accoount Search popup window will be opened.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}	
			}
		}

		SelectGroupName();
		SelectProductName();
		SelectBranch();

		click(transaction_GL_AC_BulkRepo.SearchButton);
		ExtentSuccessMessage("Step:03 - Click on the Search Button.");
		Log.info("Step:03 - Click on the Search Button.");

		click(transaction_GL_AC_BulkRepo.SelectAccountFromList);
		ExtentSuccessMessage("Step:01 - Click on the Search Button from the list.");
		Log.info("Step:01 - Click on the Search Button from the list.");
		driver.switchTo().window(mainWindowHandle);
		if(ElementDisplayed(transaction_GL_AC_BulkRepo.aiAccNoField)) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
			Log.info("Expected Result: Popup window will be closed");

			WebElement element = driver.findElement(transaction_GL_AC_BulkRepo.aiAccNoField);
			Acc_No=element.getAttribute("value");
			Log.info("Acc_No:-"+Acc_No);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}		
	}


	public void SelectGroupName() throws InterruptedException {

		ExtentTestManager.startTest("Select Transaction Type");
		Log.info("Select Transaction Type");

		select("Suspense Asset", transaction_GL_AC_BulkRepo.AccountsearchGroupNameDropdown);

		ExtentSuccessMessage("Step:01 -  Choose 'Suspense Asset' for Group Name.");
		Log.info("Step:01 -  Choose 'Suspense Asset' for Group Name.");

		ExtentSuccessMessage("Expected Result: Correct Group Name selected.");
		Log.info("Expected Result: Correct Group Name selected.");

		ExtentTestManager.endTest();
	}

	public void SelectProductName() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Select Product Name");

		select("SUSPENSE ASSET", transaction_GL_AC_BulkRepo.AccountsearchProductNameDropdown);

		ExtentSuccessMessage("Step:01 -  Choose 'SUSPENSE ASSET' for Product Name.");
		Log.info("Step:01 -  Choose 'SUSPENSE ASSET' for Product Name.");

		ExtentSuccessMessage("Expected Result: Correct Product Name selected.");
		Log.info("Expected Result: Correct Product Name selected.");

		ExtentTestManager.endTest();
	}

	public void SelectBranch() throws InterruptedException {
		//		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");

		select("TRIVANDRUM", transaction_GL_AC_BulkRepo.AccountsearchBranchDropdown);

		ExtentSuccessMessage("Step:02 -  Choose 'TRIVANDRUM' for Branch.");
		Log.info("Step:02 -  Choose 'TRIVANDRUM' for Branch.");

		ExtentSuccessMessage("Expected Result: Correct Branch selected.");
		Log.info("Expected Result: Correct Branch selected.");

		//		ExtentTestManager.endTest();
	}

	public void ClickOnCashier_Authorization() throws InterruptedException {
		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
	}
	
	public void ClickOnTransactionCancellations() throws InterruptedException {
		click(Transactions_SusLiabilityRepo.TransactionCancellations);
		ExtentSuccessMessage("Step:02 - Click on Transaction Cancellations");
		Log.info("Step:02 - Click on Transaction Cancellations");
	}
	public void ClickOnLastEntryCancellation()throws InterruptedException {
		click(Transactions_SusLiabilityRepo.LastEntryCancellation);
		ExtentSuccessMessage("Step:03 - Click on Last Entry Cancellation");
		Log.info("Step:03 - Click on Last Entry Cancellation");
	}
	
	public void NavigateToLastEntryCancellation()throws InterruptedException {
		click(Transactions_Last_Entry_CancellationRepo.CollapseAll);
		ClickOnCashier_Authorization();
		ClickOnTransactionCancellations();	
		ExtentTestManager.endTest();
	}
	

	public void CovertDateFormate(String dateString) {	 

        // Define the input date format
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEEE, MMMM dd yyyy");

        // Define the output date format
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parse the input string into a Date object
            Date date = inputFormat.parse(dateString);

            // Format the Date object into the desired output format
            formattedDate = outputFormat.format(date);

            // Output the formatted date
            System.out.println("Formatted Date: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
	}
	public void VerifyTrnDate() throws InterruptedException {
		System.out.println("transId:-"+transId);
		fetchWithTransId(transId);
		String HeaderDate=GetElementText(Transactions_SusLiabilityRepo.HeaderDate);
		CovertDateFormate(HeaderDate);
		String TransactionDate =GetElementAttribute(Transactions_SusLiabilityRepo.TransactionDate,"value");
		Assert.assertEquals(TransactionDate, formattedDate);
		ExtentSuccessMessage("Successfully Verified the TransactionDate");
		Log.info("Successfully Verified the TransactionDate");

	}

	public void authorizeCash(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(Transactions_SusLiabilityRepo.userName).getText();
		System.out.println(userName);

		ExtentTestManager.endTest();
		click(Transactions_Last_Entry_CancellationRepo.CollapseAll);
		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");



		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");

		click(Transactions_SusLiabilityRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(Transactions_Last_Entry_CancellationRepo.sOthersTab);
		ExtentSuccessMessage("Step:03 - Click \"Others\" tab");
		Log.info("Step:03 - Click \"Others\" tab");

		ExtentSuccessMessage("Expected Result: Others tab load");
		Log.info("Expected Result: Others tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_SusLiabilityRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(Transactions_SusLiabilityRepo.ApproveCheckBoxOthers)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(Transactions_SusLiabilityRepo.ApproveCheckBoxOthers);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(Transactions_SusLiabilityRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(Transactions_SusLiabilityRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		click(Transactions_SusLiabilityRepo.cashierAuthoTab);
		ExtentSuccessMessage("Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(Transactions_SusLiabilityRepo.cashierRefreshBtn);
		ExtentSuccessMessage("Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(Transactions_SusLiabilityRepo.cashierCheckBox);
		ExtentSuccessMessage("Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(Transactions_SusLiabilityRepo.cashierAuthorizeBtn);
		ExtentSuccessMessage("Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(Transactions_SusLiabilityRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end

	public void authorizeTransfer(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(Transactions_SusLiabilityRepo.userName).getText();
		System.out.println(userName);
		if(ElementDisplayed(Transactions_Last_Entry_CancellationRepo.CollapseAll)) {
			click(Transactions_Last_Entry_CancellationRepo.CollapseAll);
		}
		

		ExtentTestManager.endTest();

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(Transactions_SusLiabilityRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(Transactions_SusLiabilityRepo.sTransferTab);
		ExtentSuccessMessage("Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");

		ExtentSuccessMessage("Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_SusLiabilityRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transId);
		fetchWithTransId(transId);

		if (ElementDisplayed(Transactions_SusLiabilityRepo.approveCheckBoxTransfer)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(Transactions_SusLiabilityRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(Transactions_SusLiabilityRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(Transactions_SusLiabilityRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public void transModeCash() throws InterruptedException {

		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("CASH", transaction_GL_AC_BulkRepo.TransactionModeDD);
		ExtentSuccessMessage("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'Cash' is selected.");
		Log.info("Expected Result: Transaction mode 'Cash' is selected.");

		//		ExtentTestManager.endTest();

		//Enter Part Name
		//		ExtentTestManager.startTest("Enter Part Name");
		Log.info("Enter Part Name");

		String PartyName = "Automationtest";
		click(transaction_GL_AC_BulkRepo.PartyName);
		input(transaction_GL_AC_BulkRepo.PartyName, PartyName);
		ExtentSuccessMessage("Step:02 - Enter a valid Party Name in the input field.");
		Log.info("Step:02 - Enter a valid Party Name in the input field.");
		//		ExtentTestManager.endTest();


		//Enter Part Name
		//		ExtentTestManager.startTest("Enter Remarks");
		Log.info("Enter Remarks");

		String Remarks = "Automation_Remarks";
		click(transaction_GL_AC_BulkRepo.Remarks);
		input(transaction_GL_AC_BulkRepo.Remarks, Remarks);
		ExtentSuccessMessage("Step:03 - Enter a valid Remarks in the input field.");
		Log.info("Step:03 - Enter a valid Remarks in the input field.");
		ExtentTestManager.endTest();



		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");

		click(transaction_GL_AC_BulkRepo.SubmitTrans);
		ExtentSuccessMessage("Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");

		if (ElementDisplayed(transaction_GL_AC_BulkRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(transaction_GL_AC_BulkRepo.summaryTransId).getText();
			System.out.println("transId:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public void transModeTransfer() throws InterruptedException {
		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("TRANSFER", transaction_GL_AC_BulkRepo.TransactionModeDD);
		ExtentSuccessMessage("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'Cash' is selected.");
		Log.info("Expected Result: Transaction mode 'Cash' is selected.");

		ExtentTestManager.endTest();

		//Enter Part Name
		ExtentTestManager.startTest("Enter Part Name");
		Log.info("Enter Part Name");

		String PartyName = "Automationtest";
		click(transaction_GL_AC_BulkRepo.PartyName);
		input(transaction_GL_AC_BulkRepo.PartyName, PartyName);
		ExtentSuccessMessage("Step:01 - Enter a valid Party Name in the input field.");
		Log.info("Step:01 - Enter a valid Party Name in the input field.");
		ExtentTestManager.endTest();


		//Enter Part Name
		ExtentTestManager.startTest("Enter Remarks");
		Log.info("Enter Remarks");

		String Remarks = "Automation_Remarks";
		click(transaction_GL_AC_BulkRepo.Remarks);
		input(transaction_GL_AC_BulkRepo.Remarks, Remarks);
		ExtentSuccessMessage("Step:01 - Enter a valid Remarks in the input field.");
		Log.info("Step:01 - Enter a valid Remarks in the input field.");
		ExtentTestManager.endTest();



		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");

		click(transaction_GL_AC_BulkRepo.SubmitTrans);
		ExtentSuccessMessage("Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");

		if (ElementDisplayed(transaction_GL_AC_BulkRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(transaction_GL_AC_BulkRepo.summaryTransId).getText();
			System.out.println("transId:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();


	} //end

	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");

		{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019";
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

			String value = null; // Declare and initialize the return variable

			// Establish the connection to the database
			try (Connection connection = DriverManager.getConnection(Url, UserName, Password); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

				if (resultSet.next()) {
					value = resultSet.getString(columnName); // DB column name
					System.out.println("Generated Unique ID: " + value);
				} else {
					System.out.println("Unique ID not generated.");
				}

			} catch (SQLException e) {
				System.out.println("Error executing the SQL query or processing the result set.");
				e.printStackTrace();
			}

			return value; // Return the firstCustId
		}

	}

	public void Accountnumber(Map < Object, Object > testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);

		input(Transactions_SusLiabilityRepo.StoreAccun, AccNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -");
		Log.info("Step:01 -");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Loan number can be entered Account details are displayed ");
		Log.info("Expected Result: Loan number can be entered Account details are displayed");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");

		click(Transactions_SusLiabilityRepo.clickGo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Go button");
		Log.info("Step:01 -Click on Go button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are displayed");
		Log.info("Expected Result: Account details are displayed");

		ExtentTestManager.endTest();

		try {

			ExtentTestManager.startTest("Warning Validation Popup window");
			Log.info("Warning Validation Popup window");

			click(Transactions_SusLiabilityRepo.ClickNo);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter No in the warning validation popup window");
			Log.info("Step:01 -Enter No in the warning validation popup window");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Loan details are fetched and displayed correctly.");
			Log.info("Expected Result: Loan details are fetched and displayed correctly.");

			ExtentTestManager.endTest();

		} catch (Exception e) {

		}

		ExtentTestManager.startTest("Verify Closure Amount Display");
		Log.info("Verify Closure Amount Display");

		ScrollUntilElementVisible(Transactions_SusLiabilityRepo.scrolldown);

		if (ElementDisplayed(Transactions_SusLiabilityRepo.Totalamount)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Verify Closure Amount Display.");
			Log.info("Expected Result: Verify Closure Amount Display.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Closure amount is accurately displayed");
		Log.info("Expected Result: Closure amount is accurately displayed.");

		ExtentTestManager.endTest();
	}

	public void postCreditPopUpEntry(Map < Object, Object > testdata) throws InterruptedException {
		InvestmentTransaction.ClickonPostDebitButton();
		ExtentTestManager.startTest("Post credit button functionality");
		//Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				if (ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
					ExtentSuccessMessage("Expected Result: Auto posting popup window will be opened.");
					Log.info("Expected Result: Auto posting popup window will be opened.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.endTest();

			}
		}

		InvestmentTransaction.SelectTransactionBasedDropdown();
		InvestmentTransaction.SelectGL_NAMEDropdown();
		InvestmentTransaction.EnterAmount(testdata);
		InvestmentTransaction.ClickonAddButton();
		InvestmentTransaction.ClickonSubmit_TransactionButton();
		driver.switchTo().window(mainWindowHandle);
		InvestmentTransaction.CheckPostDebitButton();
	}
	
	public void authorizeOthers(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(Transactions_Last_Entry_CancellationRepo.userName).getText();
		System.out.println(userName);

		ExtentTestManager.endTest();
		click(Transactions_Last_Entry_CancellationRepo.CollapseAll);

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(Transactions_Last_Entry_CancellationRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(Transactions_Last_Entry_CancellationRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(Transactions_Last_Entry_CancellationRepo.sOthersTab);
		ExtentSuccessMessage("Step:03 - Click \"Others\" tab");
		Log.info("Step:03 - Click \"Others\" tab");

		ExtentSuccessMessage("Expected Result: Others tab load");
		Log.info("Expected Result: Others tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_Last_Entry_CancellationRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transId);
		fetchWithTransId(transId);

		if (ElementDisplayed(Transactions_Last_Entry_CancellationRepo.approveCheckBoxTransfer)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(Transactions_Last_Entry_CancellationRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(Transactions_Last_Entry_CancellationRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(Transactions_Last_Entry_CancellationRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(Transactions_Last_Entry_CancellationRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public void authorizeCash1(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(Transactions_SusLiabilityRepo.userName).getText();
		System.out.println(userName);

		ExtentTestManager.endTest();
		click(Transactions_Last_Entry_CancellationRepo.CollapseAll);
		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");



		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");

		click(Transactions_SusLiabilityRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(Transactions_Last_Entry_CancellationRepo.sOthersTab);
		ExtentSuccessMessage("Step:03 - Click \"Others\" tab");
		Log.info("Step:03 - Click \"Others\" tab");

		ExtentSuccessMessage("Expected Result: Others tab load");
		Log.info("Expected Result: Others tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_SusLiabilityRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(Transactions_SusLiabilityRepo.ApproveCheckBoxOthers)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(Transactions_SusLiabilityRepo.ApproveCheckBoxOthers);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(Transactions_SusLiabilityRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(Transactions_SusLiabilityRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		//		click(Transactions_SusLiabilityRepo.cashierAuthoTab);
		//		ExtentSuccessMessage("Step:01 - Navigate to Cashier Authorization");
		//		Log.info("Step:01 - Navigate to Cashier Authorization");
		//
		//		click(Transactions_SusLiabilityRepo.cashierRefreshBtn);
		//		ExtentSuccessMessage("Step:02 - Click Refresh Button");
		//		Log.info("Step:02 - Click Refresh Button");
		//
		//		System.out.println("transIdCashPersonal " + transId);
		//		fetchWithTransId(transId);
		//
		//		click(Transactions_SusLiabilityRepo.cashierCheckBox);
		//		ExtentSuccessMessage("Step:03 - Select checkbox");
		//		Log.info("Step:03 - Select checkbox");
		//
		//		click(Transactions_SusLiabilityRepo.cashierAuthorizeBtn);
		//		ExtentSuccessMessage("Step:04 - Click Authorize Button");
		//		Log.info("Step:04 - Click Authorize Button");
		//
		//		if (ElementDisplayed(Transactions_SusLiabilityRepo.confirmationPopUp)) {
		//			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
		//			Log.info("Expected Result: Transaction gets authorised");
		//			click(Transactions_SusLiabilityRepo.confirmationPopUp);
		//		} else {
		//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		//			Log.info("ERROR");
		//		}
		//
		//		ExtentTestManager.endTest();
		//
		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end

}