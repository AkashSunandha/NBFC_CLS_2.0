package com.Page_ClosureAndRenewals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ClosureAndRenewals_FD_Closure;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ClosureAndRenewals_FD_Closure extends Base_Class {

	PageRepositary_ClosureAndRenewals_FD_Closure FD_ClosureRepo =new PageRepositary_ClosureAndRenewals_FD_Closure();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();

	public String spAccNum = "SPGetNotPledgeddepositdetailsTEST '102','14003'";
	public String clmnNam = "Acno";
	String transId;
	String PrincipalBalance;

	/////////////////////////////////////////////

	public void Navigate_GL_AC_Bulk_Transaction() throws InterruptedException {

		//Open Transaction Module
		ExtentTestManager.startTest("Navigate to Closure And Renewals Tab >> Term Deposit Closure.");
		Log.info("Navigate to Closure And Renewals Tab >> Term Deposit Closure.");

		click(FD_ClosureRepo.ClosureAndRenewalsTab);
		ExtentSuccessMessage("Step:01 - Navigate to the Closure And Renewals module in the menu.");
		Log.info("Step:01 - Navigate to the Closure And Renewals module in the menu.");

		click(FD_ClosureRepo.Term_Deposit_ClosureTab);
		ExtentSuccessMessage("Step:02 - Click on the Term_Deposit_Closure module.");
		Log.info("Step:02 - Click on the Term_Deposit_Closure module.");

		if (ElementDisplayed(FD_ClosureRepo.VerifyTerm_Deposit_ClosureTab)) {
			ExtentSuccessMessage("Expected Result: Term_Deposit_Closure module opens successfully.");
			Log.info("Expected Result: Term_Deposit_Closure module opens successfully.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.error("ERROR");
		}
		ExtentTestManager.endTest();

	}

	public void SelectBranch() throws InterruptedException {
		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");
		select("TRIVANDRUM",FD_ClosureRepo.acBranchDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'TRIVANDRUM' for Branch.");
		Log.info("Step:01 -  Choose 'TRIVANDRUM' for Branch.");
		ExtentTestManager.endTest();	
	}
	public void SelectProductGroup() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Group");
		Log.info("Select Product Group");
		select("Fixed Deposit",FD_ClosureRepo.acGroupNameDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'Fixed Deposit' for product group.");
		Log.info("Step:01 -  Choose 'Fixed Deposit' for product group.");
		ExtentTestManager.endTest();	
	}

	public void SelectProductName() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Select Product Name");
		select("DEBUNTURE FIXED TYPE 2 YRS",FD_ClosureRepo.acProductNameDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'DEBUNTURE FIXED TYPE 2 YRS' for Product Name.");
		Log.info("Step:01 -  Choose 'DEBUNTURE FIXED TYPE 2 YRS' for Product Name.");
		ExtentTestManager.endTest();	
	}
	public void SelectTransactionModeCASH() throws InterruptedException {
		ExtentTestManager.startTest("Select TransactionMode");
		Log.info("Select TransactionMode");
		select("CASH",FD_ClosureRepo.acTransactionModeDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'CASH' for TransactionMode.");
		Log.info("Step:01 -  Choose 'CASH' for TransactionMode.");
		ExtentTestManager.endTest();	
	}


	public void ClickonSubmit_TransactionButton() throws InterruptedException {
		ExtentTestManager.startTest("Submit Transaction Button");
		click(FD_ClosureRepo.SubmitTrans);
		ExtentSuccessMessage( "Step:01 -  Click on Submit Transaction Button");
		Log.info("Step:01 -  Click on Submit Transaction Button");

		if (ElementDisplayed(FD_ClosureRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(FD_ClosureRepo.summaryTransId).getText();
			System.out.println("transId:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	}
	public void ClickonSubmit_TransactionButtons() throws InterruptedException {
		ExtentTestManager.startTest("Submit Transaction Button");
		click(FD_ClosureRepo.SubmitButton);
		ExtentSuccessMessage( "Step:01 -  Click on Submit Transaction Button");
		Log.info("Step:01 -  Click on Submit Transaction Button");
		ExtentTestManager.endTest();
	}

	public void EnterAccountNumber() throws ClassNotFoundException, InterruptedException {
		//Enter account number
		ExtentTestManager.startTest("Enter account number");
		Log.info("Enter account number");

		String accNum = generateUniqueId(spAccNum, clmnNam);
		String lastThreeDigitsOfAccNum = accNum.substring(accNum.length() - 3);

		input(FD_ClosureRepo.acAccNumTxtBox, lastThreeDigitsOfAccNum);
		ExtentSuccessMessage("Step:01 - Enter a valid account number in the input field.");
		Log.info("Step:01 - Enter a valid account number in the input field.");

		ExtentSuccessMessage("Expected Result: Account number is accepted.");
		Log.info("Expected Result: Account number is accepted.");

		ExtentTestManager.endTest();

	}

	public void EnterDuration() throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("Enter_Duration");
		Log.info("Enter_Duration");
		String Duration="12";
		input(FD_ClosureRepo.Enter_Duration, Duration);
		ExtentSuccessMessage("Step:01 - Enter a valid Duration in the input field.");
		Log.info("Step:01 - Enter a valid Duration in the input field.");

		ExtentSuccessMessage("Expected Result: Duration is accepted.");
		Log.info("Expected Result: Duration is accepted.");

		ExtentTestManager.endTest();

	}


	public void ClickOnGoButton() throws InterruptedException {
		ExtentTestManager.startTest("Click the 'Go' button.");
		Log.info("Click the 'Go' button.");
		click(FD_ClosureRepo.acGOButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button.");
		Log.info("Step:01 - Click the 'Go' button.");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		ExtentTestManager.endTest();
	}

	public void CLickOnRe_Depositing_Check_Box() throws InterruptedException {
		ExtentTestManager.startTest("Click the Re_Depositing_Check_Box.");
		Log.info("Click the Re_Depositing_Check_Box.");
		click(FD_ClosureRepo.Re_Depositing_Check_Box);
		ExtentTestManager.getTest().log(Status.PASS, "Click the Re_Depositing_Check_Box.");
		Log.info("Click the Re_Depositing_Check_Box.");
		Thread.sleep(2000);
		ExtentTestManager.endTest();
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
		try {
			ElementDisplayed(custSearch.home);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}
		catch(Exception e) {
			ElementDisplayed(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(custSearch.loginWarningOkBtn);
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
		}
		ExtentTestManager.endTest();
		String userName = driver.findElement(FD_ClosureRepo.userName).getText();
		System.out.println(userName);

//		ExtentTestManager.endTest();

		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(FD_ClosureRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");



		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");

		click(FD_ClosureRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(FD_ClosureRepo.cashTab);
		ExtentSuccessMessage("Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentSuccessMessage("Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(FD_ClosureRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(FD_ClosureRepo.approveCheckBox)) {
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

		click(FD_ClosureRepo.approveCheckBox);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(FD_ClosureRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(FD_ClosureRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(FD_ClosureRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		click(FD_ClosureRepo.cashierAuthoTab);
		ExtentSuccessMessage("Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(FD_ClosureRepo.cashierRefreshBtn);
		ExtentSuccessMessage("Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(FD_ClosureRepo.cashierCheckBox);
		ExtentSuccessMessage("Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(FD_ClosureRepo.cashierAuthorizeBtn);
		ExtentSuccessMessage("Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");

		if (ElementDisplayed(FD_ClosureRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(FD_ClosureRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end

	public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
		// Method that returns the first customer ID (String) from the database
		// Database connection details
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";


		String value = null; // Declare and initialize the return variable

		// Establish the connection to the database
		try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			if (resultSet.next()) {
				value = resultSet.getString(columnName); // Get the first Cust_ID
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
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(FD_ClosureRepo.transIdTxtBox, transId);
		click(FD_ClosureRepo.goBtn);
	}

	public void Transmode(Map < Object, Object > testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("TRANSFER", FD_ClosureRepo.acTransactionModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'TRANSFER' is selected.");
		Log.info("Expected Result: Transaction mode 'TRANSFER' is selected.");

		ExtentTestManager.endTest();

		//Enter Remark 
		ExtentTestManager.startTest("Enter Remark ");
		Log.info("Enter Remark ");

		String reamrk = testdata.get("remark").toString();
		input(FD_ClosureRepo.Remarks, reamrk);
		ExtentSuccessMessage("Step:01 - Enter a remark in the input field.");
		Log.info("Step:01 - Enter a remark in the input field.");

		ExtentSuccessMessage("Expected Result: Remark   accepted.");
		Log.info("Expected Result: Remark   accepted.");

		ExtentTestManager.endTest();
	}
	public void transModeTransfer(Map < Object, Object > testdata, ITestContext context) throws InterruptedException {

		String	prncsblnce =driver.findElement(FD_ClosureRepo.PrincipalBalance).getAttribute("value");

		String BalanceAmount[] =prncsblnce.split(".00 Cr");
		PrincipalBalance=BalanceAmount[0];
		System.out.println("PrincipalBalance:-"+PrincipalBalance);
		//		PrincipalBalance
		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");

		select("TRANSFER", FD_ClosureRepo.acTransactionModeDropdown);
		ExtentSuccessMessage("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");

		ExtentSuccessMessage("Expected Result: Transaction mode 'TRANSFER' is selected.");
		Log.info("Expected Result: Transaction mode 'TRANSFER' is selected.");

		ExtentTestManager.endTest();

		//Enter Remark 
		ExtentTestManager.startTest("Enter Remark ");
		Log.info("Enter Remark ");

		String reamrk = testdata.get("remark").toString();
		input(FD_ClosureRepo.Remarks, reamrk);
		ExtentSuccessMessage("Step:01 - Enter a remark in the input field.");
		Log.info("Step:01 - Enter a remark in the input field.");

		ExtentSuccessMessage("Expected Result: Remark   accepted.");
		Log.info("Expected Result: Remark   accepted.");

		ExtentTestManager.endTest();

		postCreditPopUpEntry(testdata);

		//Submit Transaction
		//		ExtentTestManager.startTest("Submit Transaction");
		//		Log.info("Submit Transaction");
		//		ScrollUntilElementVisible(FD_ClosureRepo.SubmitButton);
		//		click(FD_ClosureRepo.SubmitButton);
		//		ExtentSuccessMessage("Step:01 - Click the 'Submit' button.");
		//		Log.info("Step:01 - Click the 'Submit' button.");
		//
		//		if (ElementDisplayed(FD_ClosureRepo.summaryTransId)) {
		//			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
		//			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
		//
		//			transId = driver.findElement(FD_ClosureRepo.summaryTransId).getText();
		//
		//		} else {
		//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		//			Log.info("ERROR");
		//		}
		//
		//		ExtentTestManager.endTest();

	} //end



	public void SelectDurationMode() throws InterruptedException {
		ExtentTestManager.startTest("Select Duration Mode");
		Log.info("Select Duration Mode");

		select("MONTHS", FD_ClosureRepo.SelectDurationMode);
		ExtentSuccessMessage("Step:01 - Choose 'MONTHS' from the Duration mode dropdown.");
		Log.info("Step:01 - Choose 'MONTHS' from the Duration mode dropdown.");

		ExtentSuccessMessage("Expected Result: Duration mode 'MONTHS' is selected.");
		Log.info("Expected Result: Duration mode 'MONTHS' is selected.");

		ExtentTestManager.endTest();

	}
	public void ClickonPostDebitButton() throws InterruptedException {
		ExtentTestManager.startTest("POstDebit Button");
		click(FD_ClosureRepo.POstDebit);
		ExtentSuccessMessage( "Step:01 -  Click on POst Debit Button");
		Log.info("Step:01 -  Click on POst Debit Button");
		ExtentTestManager.endTest();
	}	

	public void CheckPostDebitButton() throws InterruptedException {
		if(ElementDisplayed(FD_ClosureRepo.POstDebit)) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
			Log.info("Expected Result: Popup window will be closed");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	}	

	public void ClickonAddButton() throws InterruptedException {
		ExtentTestManager.startTest("Add Button");
		click(FD_ClosureRepo.AddButton);
		ExtentSuccessMessage( "Step:01 -  Click on Add Button");
		Log.info("Step:01 -  Click on Add Button");
		ExtentTestManager.endTest();
	}	

	public void SelectGL_NAMEDropdown() throws InterruptedException {
		ExtentTestManager.startTest("Select GL_NAME Dropdown");
		Log.info("Select Transaction Based Dropdown");
		click(FD_ClosureRepo.GL_NAME);
		Thread.sleep(2000);
		click(FD_ClosureRepo.GL_NAMEVValue);
		ExtentSuccessMessage( "Step:01 -  Choose 'ADVANCE FOR LAND' for Transaction Based DD");
		Log.info("Step:01 -  Choose 'ADVANCE FOR LAND' for Transaction Based DD");
		ExtentTestManager.endTest();	
	}
	public void postCreditPopUpEntry(Map < Object, Object > testdata) throws InterruptedException {
		ClickonPostDebitButton();
		ExtentTestManager.startTest("Post credit button functionality");
		//Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				if (ElementDisplayed(FD_ClosureRepo.TransactionBasedDD)) {
					ExtentSuccessMessage("Expected Result: Auto posting popup window will be opened.");
					Log.info("Expected Result: Auto posting popup window will be opened.");
				} else {
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
		ClickonSubmit_TransactionButtons();
		driver.switchTo().window(mainWindowHandle);
		CheckPostDebitButton();
	}

	public void SelectTransactionBasedDropdown() throws InterruptedException {
		ExtentTestManager.startTest("Select Transaction Based Dropdown");
		Log.info("Select Transaction Based Dropdown");
		select("GL Code",FD_ClosureRepo.TransactionBasedDD);
		ExtentSuccessMessage( "Step:01 -  Choose 'GL Code' for Transaction Based DD");
		Log.info("Step:01 -  Choose 'GL Code' for Transaction Based DD");
		ExtentTestManager.endTest();	
	}
	public void EnterAmount (Map<Object, Object> testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Amount");
		Log.info("Enter Amount");

		String transAmt = PrincipalBalance;
		clear(FD_ClosureRepo.Amount);
		click(FD_ClosureRepo.Amount);
		input(FD_ClosureRepo.Amount, transAmt);
		ExtentSuccessMessage( "Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}

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
		try {
			ElementDisplayed(custSearch.home);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}
		catch(Exception e) {
			ElementDisplayed(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(custSearch.loginWarningOkBtn);
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
		}
		ExtentTestManager.endTest();
		String userName = driver.findElement(FD_ClosureRepo.userName).getText();
		System.out.println(userName);


//		ExtentTestManager.endTest();

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(FD_ClosureRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(FD_ClosureRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(FD_ClosureRepo.sTransferTab);
		ExtentSuccessMessage("Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");

		ExtentSuccessMessage("Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(FD_ClosureRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transId);
		fetchWithTransId(transId);

		if (ElementDisplayed(FD_ClosureRepo.approveCheckBoxTransfer)) {
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

		click(FD_ClosureRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(FD_ClosureRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(FD_ClosureRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(FD_ClosureRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

}
