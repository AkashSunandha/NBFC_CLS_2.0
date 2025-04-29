package com.Page_InvestmentTransactionCash_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
//import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class InvestmentTransaction_Cash_Transfer extends Base_Class{

	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_InvestmentTransaction_Cash_Transfer InvestmentTransaction = new PageRepositary_InvestmentTransaction_Cash_Transfer();
	public String spAccNum = "exec GetJewelloanAccountnumber;";
	public String clmnNam = "Acno";

	String transId;
	String lastValue;
	public String sp = "GetJewelloanAccountnumber";
	public String columnName = "Acno";


	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	public void ClickonTransaction() throws InterruptedException {

		click(InvestmentTransaction.transactionTab);
		ExtentTestManager.startTest("Open Transaction Module");
		Log.info("Open Transaction Module");
	}
	public void ClickonAuthorize_And_Cancel_Tab() throws InterruptedException {

		click(InvestmentTransaction.Authorize_And_Cancel_Tab);
		ExtentTestManager.startTest("Open Authorize_And_Cancel_Tab Module");
		Log.info("Open Authorize_And_Cancel_Tab Module");
	}

	public void ClickonInvstTransaction() throws InterruptedException {
		click(InvestmentTransaction.InvsttransactionsTab);
		ExtentSuccessMessage( "Step:02 -   Click on Inv. Transactions.");
		Log.info("Click on Inv. Transactions.");
		ExtentTestManager.endTest();

	}
	public void ClickonCashierAuthorisation() throws InterruptedException {
		click(InvestmentTransaction.CashierAuthorisation);
		ExtentSuccessMessage( "Step:02 -   Click on Cashier Authorisation.");
		Log.info("Click on Cashier Authorisation");
		ExtentTestManager.endTest();

	}

	public void NavigatetoCashierAuthorisation() throws InterruptedException {
		ClickonAuthorize_And_Cancel_Tab();
		ClickonCashierAuthorisation();
	}

	public void SelectProductGroup() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Group");
		Log.info("Select Product Group");
		select("Demand Investment",InvestmentTransaction.ProductGroupDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'Demand Investment' for product group.");
		Log.info("Step:01 -  Choose 'Demand Investment' for product group.");
		ExtentTestManager.endTest();	
	}
	public void NavigateToInvstTransaction() throws InterruptedException {
		ClickonTransaction();
		ClickonInvstTransaction();
	}

	public void SelectProductName() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Select Product Group");
		select("INV-DEMAND-CA",InvestmentTransaction.ProductNameDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'INV-DEMAND-CA' for product Name.");
		Log.info("Step:01 -  Choose 'INV-DEMAND-CA' for product Name.");
		ExtentTestManager.endTest();
	}


	public void SelectBankDD() throws InterruptedException {
		ExtentTestManager.startTest("Select Bank");
		Log.info("Select Bank");
		select("HDFC BANK - HDFC",InvestmentTransaction.SelectBankDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'HDFC BANK - HDFC' for Select Bank.");
		Log.info("Step:01 -  Choose 'HDFC BANK - HDFC' for Select Bank");
		ExtentTestManager.endTest();
		//		Thread.sleep(3000);
	}
	public void SelectBranchDD() throws InterruptedException {
		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");
		//		Thread.sleep(5000);
		click(InvestmentTransaction.ProductName);
		click(InvestmentTransaction.SelectBranchDDValue);
		ExtentSuccessMessage( "Step:01 -  Choose 'Cherpulassery' for Select Branch.");
		Log.info("Step:01 -  Choose 'Cherpulassery' for Select Branch");
		ExtentTestManager.endTest();
	}
	public void ClickonFirstTransactionfromgrid() throws InterruptedException {
		ExtentTestManager.startTest("Check an account from the accounts list.");
		click(InvestmentTransaction.SelectGridFirstrow);
		ExtentSuccessMessage( "Step:01 -  Click on First Transaction from grid");
		Log.info("Step:01 -  Click on First Transaction from grid");
		ExtentTestManager.endTest();
	}
	public void SelectTransactionTypeDD() throws InterruptedException {
		ExtentTestManager.startTest("Select Transaction Type");
		Log.info("Select Transaction Type");
		select("Credit",InvestmentTransaction.SelectTransactionTypeDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'Credit' for Select Transaction Type.");
		Log.info("Step:01 -  Choose 'Credit' for Select Transaction Type");
		ExtentTestManager.endTest();
	}
	public void SelectTransactionModeDD(String Value) throws InterruptedException {
		//		Thread.sleep(3000);
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");
		select(Value,InvestmentTransaction.TransactionModeDD);
		ExtentSuccessMessage( "Step:01 -  Choose '"+Value+"' for Select Transaction Mode.");
		Log.info("Step:01 -  Choose '"+Value+"' for Select Transaction Mode");
		ExtentTestManager.endTest();
	}

	public void ClickonGoButton() throws InterruptedException {
		ExtentTestManager.startTest("Go Button");
		click(InvestmentTransaction.GoButton);
		ExtentSuccessMessage( "Step:01 -  Click on Go Button");
		Log.info("Step:01 -  Click on Go Button");
		ExtentTestManager.endTest();
	}
	public void ClickonSubmit_TransactionButton() throws InterruptedException {
		ExtentTestManager.startTest("Submit Transaction Button");
		click(InvestmentTransaction.SubmitTrans);
		ExtentSuccessMessage( "Step:01 -  Click on Submit Transaction Button");
		Log.info("Step:01 -  Click on Submit Transaction Button");
		ExtentTestManager.endTest();

	}
	public String FetchTranscationIDFromINvoice() throws InterruptedException {
		String TransactionID=GetElementText(InvestmentTransaction.FetchTransid);
		return TransactionID;

	}
	public void EnterTransactionAmount (Map<Object, Object> testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Enter Transaction Amount");

		String transAmt = testdata.get("amount").toString();
		clear(InvestmentTransaction.Transaction_Amount);
		click(InvestmentTransaction.Transaction_Amount);
		input(InvestmentTransaction.Transaction_Amount, transAmt);
		ExtentSuccessMessage( "Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}
	public void ClickonRefresh() throws InterruptedException {
		click(InvestmentTransaction.Refresh);
		ExtentTestManager.startTest("Open Refresh Grid");
		Log.info("Open Refresh Grid");
	}

	public void EnterTransID (String Value) throws InterruptedException {
		//Enter Transaction ID
		ExtentTestManager.startTest("Enter Trans ID");
		Log.info("Enter Trans ID");
		input(InvestmentTransaction.EnterTransID, Value);
		ExtentSuccessMessage( "Step:01 - Enter a valid Trans ID  in the input field.");
		Log.info("Step:01 - Enter a valid Trans ID  in the input field.");
		ExtentTestManager.endTest();
	}

	public boolean AuthuserLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Valid Login");
		Log.info("Valid Login");


		String UserName = configloader().getProperty("UserName2");
		//					String loginUserName = testdata.get("loginUserName").toString();
		input(custSearch.loginUserName,UserName );
		ExtentSuccessMessage( "Step:01 - Eneter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		String Password = configloader().getProperty("Password2");
		//					String loginValidPassword = testdata.get("loginValidPassword").toString();
		input(custSearch.loginPasswrd, Password);
		ExtentSuccessMessage( "Step:02 - Eneter valid Password");
		Log.info("Step:02 - Enetered valid Password");

		click(custSearch.loginButton);
		ExtentSuccessMessage( "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");

		try {
			ElementDisplayed(custSearch.home);
			ExtentSuccessMessage( "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}
		catch(Exception e) {
			ElementDisplayed(custSearch.loginWarningOkBtn);
			ExtentSuccessMessage( "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(custSearch.loginWarningOkBtn);
			ExtentSuccessMessage( "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			//					String loginUserName = testdata.get("loginUserName").toString();
			input(custSearch.loginUserName, UserName);
			ExtentSuccessMessage( "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			//					String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(custSearch.loginPasswrd, Password);
			ExtentSuccessMessage( "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(custSearch.loginButton);
			ExtentSuccessMessage( "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(custSearch.home);
			ExtentSuccessMessage( "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");	
		}

		//					ElementDisplayed(custSearch.home);
		//					ExtentSuccessMessage( "Expected Result: User is logged in successfully and dashboard visible");
		//					Log.info("Expected Result: User is logged in successfully and dashboard visible");

		ExtentTestManager.endTest();

		return true;
	}

	public boolean logout() throws InterruptedException {
		ExtentTestManager.startTest("Logout");
		Log.info("Logout");

		Thread.sleep(4000);

		click(custSearch.custSignOut);
		ExtentSuccessMessage( "Step:01 -  Click on 'Signout'");
		Log.info("Step:01 -  Click on 'Signout'");
		if(ElementDisplayed(custSearch.loginButton)) {
			ExtentSuccessMessage( "Expected Result: User is logged out successfully, login screen is displayed.");
			Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		}
		//		driver.close();
		ExtentTestManager.endTest();
		return true;
	}
	public void ClickonTransactionCheckboxfromgrid() throws InterruptedException {
		ExtentTestManager.startTest("Transaction Check Box");
		click(InvestmentTransaction.Transcheckbox);
		ExtentSuccessMessage( "Step:01 -  Click on Transaction check box from grid");
		Log.info("Step:01 -  Click on Transaction check box from grid");
		ExtentTestManager.endTest();
	}
	public void ClickonAuthorizeButton() throws InterruptedException {
		ExtentTestManager.startTest("Authorize Button");
		click(InvestmentTransaction.AuthorizeButton);
		ExtentSuccessMessage("Step:01 -  Click on Authorize Button");
		Log.info("Step:01 -  Click on Authorize Button");
		VerifySuccessMessage();
		ExtentTestManager.endTest();
	}

	public void VerifySuccessMessage() throws InterruptedException {
		String SuccessMessage =GetElementText(InvestmentTransaction.SuccessMessage);
		Assert.assertEquals("Successfully updated", SuccessMessage);
		ExtentSuccessMessage("User Verifed Success message successfully");

	}
	public void NavigateManagerAuthorisation() throws InterruptedException {
		ClickonAuthorize_And_Cancel_Tab();
		ClickONManagerAuthorisation();
	}

	public void ClickONManagerAuthorisation() throws InterruptedException {
		//		ExtentTestManager.startTest("Navigate Manager Authorisation ");
		click(InvestmentTransaction.ManagerAuthorisation);
		ExtentSuccessMessage("Step:01 -  Click on Manager Authorize ");
		Log.info("Step:01 -  Click on Manager Authorize ");
		ExtentTestManager.endTest();
	}


	public void ClickonPostDebitButton() throws InterruptedException {
		ExtentTestManager.startTest("POstDebit Button");
		click(InvestmentTransaction.POstDebit);
		ExtentSuccessMessage( "Step:01 -  Click on POst Debit Button");
		Log.info("Step:01 -  Click on POst Debit Button");
		ExtentTestManager.endTest();
	}	

	public void CheckPostDebitButton() throws InterruptedException {
		if(ElementDisplayed(InvestmentTransaction.POstDebit)) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
			Log.info("Expected Result: Popup window will be closed");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	}	

	public void ClickonAddButton() throws InterruptedException {
		ExtentTestManager.startTest("Add Button");
		click(InvestmentTransaction.AddButton);
		ExtentSuccessMessage( "Step:01 -  Click on Add Button");
		Log.info("Step:01 -  Click on Add Button");
		ExtentTestManager.endTest();
	}	

	public void SelectGL_NAMEDropdown() throws InterruptedException {
		ExtentTestManager.startTest("Select GL_NAME Dropdown");
		Log.info("Select Transaction Based Dropdown");
		click(InvestmentTransaction.GL_NAME);
		Thread.sleep(2000);
		click(InvestmentTransaction.GL_NAMEVValue);
		ExtentSuccessMessage( "Step:01 -  Choose 'ADVANCE FOR LAND' for Transaction Based DD");
		Log.info("Step:01 -  Choose 'ADVANCE FOR LAND' for Transaction Based DD");
		ExtentTestManager.endTest();	
	}
	public void SelectTransactionBasedDropdown() throws InterruptedException {
		ExtentTestManager.startTest("Select Transaction Based Dropdown");
		Log.info("Select Transaction Based Dropdown");
		select("GL Code",InvestmentTransaction.TransactionBasedDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'GL Code' for Transaction Based DD");
		Log.info("Step:01 -  Choose 'GL Code' for Transaction Based DD");
		ExtentTestManager.endTest();	
	}

	public void EnterAmount (Map<Object, Object> testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Amount");
		Log.info("Enter Amount");

		String transAmt = testdata.get("amount").toString();
		clear(InvestmentTransaction.Amount);
		click(InvestmentTransaction.Amount);
		input(InvestmentTransaction.Amount, transAmt);
		ExtentSuccessMessage( "Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}
	public void postCreditPopUpEntry(Map<Object, Object> testdata) throws InterruptedException {
		ExtentTestManager.startTest("Post credit button functionality");
		//Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;


				if(ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
					ExtentSuccessMessage("Expected Result: Auto posting popup window will be opened.");
					Log.info("Expected Result: Auto posting popup window will be opened.");
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.endTest();

			}
		}

		SelectTransactionBasedDropdown();
		SelectGL_NAMEDropdown();
		EnterAmount(testdata);
		ClickonAddButton();
		ClickonSubmit_TransactionButton();


		driver.switchTo().window(mainWindowHandle);
	}

	public void ClickonTransferTab() throws InterruptedException {
		ExtentTestManager.startTest("Transfer Tab");
		click(InvestmentTransaction.TransferTab);
		ExtentSuccessMessage( "Step:01 -  Click on Transfer Tab");
		Log.info("Step:01 -  Click on Transfer Tab");
		ExtentTestManager.endTest();
	}	


	////////////////////////////////////////////////////////////////////




}
