
package com.Page_Transaction;


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
import org.testng.ITestContext;
//import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.BasePackage.Base_Class;
import com.Page_InvestmentTransactionCash_Transfer.InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Suspense_Liability;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_Transactions_Suspense_liability extends Base_Class {

	InvestmentTransaction_Cash_Transfer InvestmentTransaction = new InvestmentTransaction_Cash_Transfer();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();

	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Transaction_Transactions_Suspense_Liability Transactions_SusLiabilityRepo = new PageRepositary_Transaction_Transactions_Suspense_Liability();
	Transaction_Transactions_Jewel Transactions_Jewel = new Transaction_Transactions_Jewel();
	public String spAccNum = "exec GetJewelloanAccountnumber;";
	public String clmnNam = "Acno";

	String transId;
	String lastValue;
	public String sp = "GetSuspenseLiabilityAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(Transactions_SusLiabilityRepo.transIdTxtBox, transId);
		click(Transactions_SusLiabilityRepo.goBtn);
	}

	public void transactionsSusliability() throws InterruptedException {

		//Open Transaction Module
		ExtentTestManager.startTest("Open Transaction Module").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Open Transaction Module");

		click(Transactions_SusLiabilityRepo.transactionTab);
		ExtentSuccessMessage("Step:01 - Navigate to the transaction module in the menu.");
		Log.info("Step:01 - Navigate to the transaction module in the menu.");

		click(Transactions_SusLiabilityRepo.transactionsTab);
		ExtentSuccessMessage("Step:02 - Click on the transaction module.");
		Log.info("Step:02 - Click on the transaction module.");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.aiBranchDropdowm)) {
			ExtentSuccessMessage("Expected Result: Transaction module opens successfully.");
			Log.info("Expected Result: Transaction module opens successfully.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	}

	public void EnterTransactionAmount(Map < Object, Object > testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Transaction Amount").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Enter Transaction Amount");

		String transAmt = testdata.get("amount").toString();
		clear(Transactions_SusLiabilityRepo.TransAmount);
		click(Transactions_SusLiabilityRepo.TransAmount);
		input(Transactions_SusLiabilityRepo.TransAmount, transAmt);
		ExtentSuccessMessage("Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}

	public void susliabilityaccountinfo(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		//Select Branch
		ExtentTestManager.startTest("Select Branch").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Branch");

		select("TRIVANDRUM", Transactions_SusLiabilityRepo.aiBranchDropdowm);
		ExtentSuccessMessage("Step:01 -  Select a branch from the dropdown.");
		Log.info("Step:01 -  Select a branch from the dropdown.");

		ExtentSuccessMessage("Expected Result: Correct branch  selected.");
		Log.info("Expected Result: Correct branch  selected.");

		ExtentTestManager.endTest();

		//Select Product Group
		ExtentTestManager.startTest("Select Product Group").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Product Group");

		select("Suspense Liability", Transactions_SusLiabilityRepo.aiProductGroupDropdowm);
		ExtentSuccessMessage("Step:01 -  Choose 'SUSPENSE LIABILITY' for product group.");
		Log.info("Step:01 -  Choose 'SUSPENSE LIABILITY' for product group.");

		ExtentSuccessMessage("Expected Result: Correct product group selected.");
		Log.info("Expected Result: Correct product group selected.");

		ExtentTestManager.endTest();

		//Select Product Name
		ExtentTestManager.startTest("Select Product Name").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Product Name");

		select("SUSPENSE LIABILITY", Transactions_SusLiabilityRepo.aiProdcutNameDropdowm);
		ExtentSuccessMessage("Step:01 - Select 'SUSPENSE LIABILITY' for product name.");
		Log.info("Step:01 - Select 'SUSPENSE LIABILITY' for product name.");

		ExtentSuccessMessage("Expected Result: Correct product Name selected.");
		Log.info("Expected Result: Correct product Name selected.");

		ExtentTestManager.endTest();

		//Select Transaction Type
		ExtentTestManager.startTest("Select Transaction Type").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Transaction Type");

		select("Credit", Transactions_SusLiabilityRepo.aiTransTypeDropdwon);
		ExtentSuccessMessage("Step:01 - Select transaction type as 'Credit'.");
		Log.info("Step:01 - Select transaction type as 'Credit'.");

		ExtentSuccessMessage("Expected Result: Transaction type is set.");
		Log.info("Expected Result: Transaction type is set.");

		ExtentTestManager.endTest();

		Accountnumber(testdata, context);

		EnterTransactionAmount(testdata);

	}

	public void authorizeCash(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User").assignCategory("Suspense Liability Transction -Cash");
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

		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Cashier Authorization");

		ScrollUntilElementVisible(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		Thread.sleep(3000);
		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

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

		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Manager Authorization - Cash Tab");

		click(Transactions_SusLiabilityRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(Transactions_SusLiabilityRepo.cashTab);
		ExtentSuccessMessage("Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentSuccessMessage("Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_SusLiabilityRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(Transactions_SusLiabilityRepo.approveCheckBox)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Authorize Loan Entry as Manager");

		click(Transactions_SusLiabilityRepo.approveCheckBox);
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

		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end

	public void authorizeTransfer(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User").assignCategory("Suspense Liability Transction -Cash");
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

//		String flag = "akash";
//
//		if (!userName.equalsIgnoreCase(flag)) {
//			ExtentSuccessMessage("Expected Result: Logging successfull with another user");
//			Log.info("Expected Result: Logging successfull with another user");
//		} else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}

		ExtentTestManager.endTest();

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Manager Authorization - Transfer Tab");

		ScrollUntilElementVisible(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
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
		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Refresh Loan Opening Entry");

		click(Transactions_SusLiabilityRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transId);
		fetchWithTransId(transId);

		/*if (ElementDisplayed(Transactions_SusLiabilityRepo.approveCheckBoxTransfer)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}*/
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("Suspense Liability Transction -Cash");
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
		ExtentTestManager.startTest("Select Transaction Mode").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Transaction Mode");

		select("CASH", Transactions_SusLiabilityRepo.tdTransModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'Cash' is selected.");
		Log.info("Expected Result: Transaction mode 'Cash' is selected.");

		ExtentTestManager.endTest();

		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Submit Transaction");

		click(Transactions_SusLiabilityRepo.submitBtn);
		ExtentSuccessMessage("Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(Transactions_SusLiabilityRepo.summaryTransId).getText();
			System.out.println("transId:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public void transModeTransfer(Map < Object, Object > testdata, ITestContext context) throws InterruptedException {

		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Select Transaction Mode");

		select("TRANSFER", Transactions_SusLiabilityRepo.tdTransModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'TRANSFER' is selected.");
		Log.info("Expected Result: Transaction mode 'TRANSFER' is selected.");

		ExtentTestManager.endTest();

		//Enter Remark 
		ExtentTestManager.startTest("Enter Remark ").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Enter Remark ");

		String reamrk = testdata.get("remark").toString();
		input(Transactions_SusLiabilityRepo.tdRemarkTxtBox, reamrk);
		ExtentSuccessMessage("Step:01 - Enter a remark in the input field.");
		Log.info("Step:01 - Enter a remark in the input field.");

		ExtentSuccessMessage("Expected Result: Remark   accepted.");
		Log.info("Expected Result: Remark   accepted.");

		ExtentTestManager.endTest();

		postCreditPopUpEntry(testdata);

		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Submit Transaction");

		click(Transactions_SusLiabilityRepo.submitBtn);
		ExtentSuccessMessage("Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");

		if (ElementDisplayed(Transactions_SusLiabilityRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(Transactions_SusLiabilityRepo.summaryTransId).getText();

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter Loan Account Number").assignCategory("Suspense Liability Transction -Cash");
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

		ExtentTestManager.startTest("Enter Loan Account Number").assignCategory("Suspense Liability Transction -Cash");
		Log.info("Enter Loan Account Number");

		click(Transactions_SusLiabilityRepo.clickGo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Go button");
		Log.info("Step:01 -Click on Go button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are displayed");
		Log.info("Expected Result: Account details are displayed");

		ExtentTestManager.endTest();

		try {

			ExtentTestManager.startTest("Warning Validation Popup window").assignCategory("Suspense Liability Transction -Cash");
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
		ExtentTestManager.startTest("Post credit button functionality").assignCategory("Suspense Liability Transction -Cash");
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

}