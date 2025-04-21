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
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.BasePackage.Base_Class;
import com.Page_InvestmentTransactionCash_Transfer.InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Last_Entry_Cancellation;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Suspense_Liability;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_Transactions_Cancellations extends Base_Class {

	InvestmentTransaction_Cash_Transfer InvestmentTransaction = new InvestmentTransaction_Cash_Transfer();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Transaction_Transactions_Last_Entry_Cancellation Transactions_Last_Entry_CancellationRepo =new PageRepositary_Transaction_Transactions_Last_Entry_Cancellation();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Transaction_Transactions_Suspense_Liability Transactions_SusLiabilityRepo = new PageRepositary_Transaction_Transactions_Suspense_Liability();
	Transaction_Transactions_Jewel Transactions_Jewel = new Transaction_Transactions_Jewel();
	Transaction_GL_AC_Bulk_Transaction GL_AC_Bulk_Transaction =new Transaction_GL_AC_Bulk_Transaction();

	public String spAccNum = "exec GetJewelloanAccountnumber;";
	public String clmnNam = "Acno";

	String transId;
	String lastValue;
	String formattedDate;
	public String sp = "GetSuspenseLiabilityAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(Transactions_Last_Entry_CancellationRepo.transIdTxtBox, transId);
		click(Transactions_Last_Entry_CancellationRepo.goBtn);
	}


	public void EnterTransactionAmount(Map < Object, Object > testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Enter Transaction Amount");

		String transAmt = testdata.get("amount").toString();
		clear(Transactions_SusLiabilityRepo.TransAmount);
		click(Transactions_SusLiabilityRepo.TransAmount);
		input(Transactions_SusLiabilityRepo.TransAmount, transAmt);
		ExtentSuccessMessage("Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}

	//	Transactions_Last_Entry_CancellationRepo
	//	
	//	ProductOperation

	public void SelectProductOperation () throws InterruptedException {
		select("GL Direct Transaction", Transactions_Last_Entry_CancellationRepo.ProductOperation);
		ExtentSuccessMessage("Step:01 - Choose 'GL Direct Transaction' from the Product Operation dropdown.");
		Log.info("Step:01 - Choose 'GL Direct Transaction' from the Product Operation dropdown.");

		ExtentSuccessMessage("Expected Result: Product Operation 'GL Direct Transaction' is selected.");
		Log.info("Expected Result: Product Operation 'GL Direct Transaction' is selected.");

	}


	public void ClickonCancelBtn() throws InterruptedException {
		ExtentTestManager.startTest("Cancel Button");
		click(Transactions_Last_Entry_CancellationRepo.Cancel);
		ExtentSuccessMessage( "Step:01 -  Click on Cancel Button");
		Log.info("Step:01 -  Click on Cancel Button");
		ExtentTestManager.endTest();
		PageRefresh();
	}




	public void EnterRemarkCancelBtn() throws InterruptedException {
		ExtentTestManager.startTest("Enter Cancel Remark");
		click(Transactions_Last_Entry_CancellationRepo.CancelRemark);
		input(Transactions_Last_Entry_CancellationRepo.CancelRemark, "Automation Testing");
		ExtentSuccessMessage( "Step:01 -  Enter Cancel Remark");
		Log.info("Step:01 -  Enter Cancel Remark");
		ExtentTestManager.endTest();
	}

	//	cashierCheckBox
	public void ClickongoBtn() throws InterruptedException {
		ExtentTestManager.startTest("Go Button");
		click(Transactions_Last_Entry_CancellationRepo.goBtn);
		ExtentSuccessMessage( "Step:01 -  Click on Go Button");
		Log.info("Step:01 -  Click on Go Button");
		ExtentTestManager.endTest();
	}
	public void ClickOnCheckBox() throws InterruptedException {
		ExtentTestManager.startTest("Click on Check Box");
		click(Transactions_Last_Entry_CancellationRepo.cashierCheckBox);
		ExtentSuccessMessage("Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");
		ExtentTestManager.endTest();
	}
	public void VerifyTrnDate() throws InterruptedException {
		System.out.println("transId:-"+transId);
		fetchWithTransId(transId);
		String HeaderDate=GetElementText(Transactions_Last_Entry_CancellationRepo.HeaderDate);
		CovertDateFormate(HeaderDate);
		String TransactionDate =GetElementAttribute(Transactions_Last_Entry_CancellationRepo.TransactionDate,"value");
		Assert.assertEquals(TransactionDate, formattedDate);
		ExtentSuccessMessage("Successfully Verified the TransactionDate");
		Log.info("Successfully Verified the TransactionDate");

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



	//	public void authorizeCash(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {
	//
	//		//Login with Another User
	//		ExtentTestManager.startTest("Login with Another User");
	//		Log.info("Login with Another User");
	//
	//		click(custSearch.custSignOut);
	//		ExtentSuccessMessage("Step:01 - Log out");
	//		Log.info("Step:01 - Log out");
	//
	//		String UserName = configloader().getProperty("UserName2");
	//		input(custSearch.loginUserName, UserName);
	//		String Password = configloader().getProperty("Password2");
	//		input(custSearch.loginPasswrd, Password);
	//		click(custSearch.loginButton);
	//		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
	//		Log.info("Step:02 - Log in with another user for authorization");
	//
	//		String userName = driver.findElement(Transactions_SusLiabilityRepo.userName).getText();
	//		System.out.println(userName);
	//
	//		ExtentTestManager.endTest();
	//
	//		//Cashier Authorization
	//		ExtentTestManager.startTest("Cashier Authorization");
	//		Log.info("Cashier Authorization");
	//
	//		click(Transactions_SusLiabilityRepo.autorizeAndCancelTab);
	//		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
	//		Log.info("Step:01 - Click \"Authorize & Cancel\"");
	//
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
	//		//Manager Authorization - Cash Tab
	//		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
	//		Log.info("Manager Authorization - Cash Tab");
	//
	//		click(Transactions_SusLiabilityRepo.managerAuthoTab);
	//		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
	//		Log.info("Step:02 - Select \"Manager Authorization\"");
	//
	//		click(Transactions_SusLiabilityRepo.cashTab);
	//		ExtentSuccessMessage("Step:03 - Click \"Cash\" tab");
	//		Log.info("Step:03 - Click \"Cash\" tab");
	//
	//		ExtentSuccessMessage("Expected Result: Cash tab load");
	//		Log.info("Expected Result: Cash tab load");
	//
	//		ExtentTestManager.endTest();
	//
	//		//Refresh Loan Opening Entry
	//		ExtentTestManager.startTest("Refresh Loan Opening Entry");
	//		Log.info("Refresh Loan Opening Entry");
	//
	//		click(Transactions_SusLiabilityRepo.refreshBtn);
	//		ExtentSuccessMessage("Step:01 - Click Refresh Button");
	//		Log.info("Step:01 - Click Refresh Button");
	//
	//		System.out.println("transIdCashPersonal " + transId);
	//
	//		fetchWithTransId(transId);
	//
	//		if (ElementDisplayed(Transactions_SusLiabilityRepo.approveCheckBox)) {
	//			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
	//			Log.info("Expected Result: Loan opening entry displayed");
	//		} else {
	//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	//			Log.info("ERROR");
	//		}
	//		ExtentTestManager.endTest();
	//
	//		//Authorize Loan Entry as Manager
	//		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
	//		Log.info("Authorize Loan Entry as Manager");
	//
	//		click(Transactions_SusLiabilityRepo.approveCheckBox);
	//		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
	//		Log.info("Step:01 - Select loan entry checkbox");
	//
	//		click(Transactions_SusLiabilityRepo.authorizeBtn);
	//		ExtentSuccessMessage("Step:02 - Click Authorize Button");
	//		Log.info("Step:02 - Click Authorize Button");
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
	//		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);
	//
	//	} //end
	//	
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

		String transId=GL_AC_Bulk_Transaction.transId;
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

	public void transModeCash() throws InterruptedException {

		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("CASH", Transactions_SusLiabilityRepo.tdTransModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'Cash' is selected.");
		Log.info("Expected Result: Transaction mode 'Cash' is selected.");

		ExtentTestManager.endTest();

		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction");
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
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("TRANSFER", Transactions_SusLiabilityRepo.tdTransModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'TRANSFER' is selected.");
		Log.info("Expected Result: Transaction mode 'TRANSFER' is selected.");

		ExtentTestManager.endTest();

		//Enter Remark 
		ExtentTestManager.startTest("Enter Remark ");
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
		ExtentTestManager.startTest("Submit Transaction");
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