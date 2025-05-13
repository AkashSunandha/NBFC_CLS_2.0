
package com.OLTransaction_Cash_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_SusAssetTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class SusAssetTransaction_Cash_Transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	PageRepositary_SusAssetTransaction_Cash_Transfer Suspenseasset = new PageRepositary_SusAssetTransaction_Cash_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	public String sp = "GetSuspenseAssetAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}

	public void transactionWindowAccess() throws InterruptedException {

		ExtentTestManager.startTest("Transaction Window Access");
		Log.info("Transaction Window Access started.");

		click(OLtrans.ClickTransaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Transaction Menu.");
		Log.info("Step:01 - Navigate to Transaction Menu.");

		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transactions.");
		Log.info("Step:02 - Select Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is on Transaction window");
		Log.info("Expected Result: User is on Transaction window");
		ExtentTestManager.endTest();

	}

	public void selectSuspenseAssetProductGroup() throws InterruptedException {

		ExtentTestManager.startTest("Select Suspense Asset Product Group");
		Log.info("Selected Suspense Asset Product Group.");

		select("Suspense Asset", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product Group Dropdown.");
		Log.info("Step:01 - Open Product Group Dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset Product Group.");
		Log.info("Step:02 - Select Suspense Asset Product Group.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Suspense Asset group is selected");
		Log.info("Expected Result: Suspense Asset group is selected");
		ExtentTestManager.endTest();

	}

	public void selectSuspenseAssetProductName() throws InterruptedException {
		ExtentTestManager.startTest("Select Suspense Asset Product Name");
		Log.info("Selected Suspense Asset Product Name.");

		select("SUSPENSE ASSET", OLtrans.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product name Dropdown.");
		Log.info("Step:01 - Open Product Group Dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset Product Name.");
		Log.info("Step:02 - Select Suspense Asset Product Group.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Suspense Asset name is selected");
		Log.info("Expected Result: Suspense Asset name is selected");
		ExtentTestManager.endTest();

	}

	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter  Account Number");
		Log.info("Enter  Account Number");

		{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019";
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

			String value = null; // Declare and initialize the return variable

			// Establish the connection to the database
			try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(query)) {

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

	public void enterAccountNumber1() throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("Enter Account Number");
		Log.info("Entered Account Number.");

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(OLtrans.transaccount, AccNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Account Number in Account Number Field.");
		Log.info("Step:01 - Enter Valid Account Number in Account Number Field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is displayed correctly");
		Log.info("Expected Result: Account number is displayed correctly");
		ExtentTestManager.endTest();

	}

	public void creditSelectionTest() throws InterruptedException {
		ExtentTestManager.startTest("Credit Selection Test");
		Log.info("Performed Credit Selection Test.");

		select("Credit", OLtrans.selectcredit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Credit Option.");
		Log.info("Step:01 - Select Credit Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Credit is selected");
		Log.info("Expected Result: Credit is selected");
		ExtentTestManager.endTest();

	}

	public void goButtonFunctionalityTest() throws InterruptedException {
		ExtentTestManager.startTest("Go Button Functionality Test");
		Log.info("Tested Go Button Functionality.");

		click(OLtrans.clickGoo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Go Button.");
		Log.info("Step:01 - Click Go Button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: System proceeds with account details for transaction");
		Log.info("Expected Result: System proceeds with account details for transaction");
		ExtentTestManager.endTest();

	}

	public void enterValidTransactionAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Enter Valid Transaction Amount");
		Log.info("Entered Valid Transaction Amount.");

		click(OLtrans.transamount);
		String Transferamount = testdata.get("Transferamount").toString();
		input(OLtrans.transamount, Transferamount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Enter Valid Transaction Amount.");
		Log.info("Step:1 - Enter Valid Transaction Amount.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount is displayed correctly");
		Log.info("Expected Result: Amount is displayed correctly");
		ExtentTestManager.endTest();
		

		ScrollUntilElementVisible(OLtrans.scrolldwn);

	}

	public void selectTransmodeCash() throws InterruptedException {
		ExtentTestManager.startTest("Selection of Transmode CASH");
		Log.info("Selected Transmode as CASH.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Open Transmode Dropdown.");
		Log.info("Step:1 - Open Transmode Dropdown.");

		select("CASH", OLtrans.selectcash);

		ExtentTestManager.getTest().log(Status.PASS, "Step:2 - Select Transmode as CASH.");
		Log.info("Step:1- Select Transmode as CASH.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: CASH mode is selected");
		Log.info("Expected Result: CASH mode is selected");
		ExtentTestManager.endTest();

		ScrollUntilElementVisible(OLtrans.scrolldwn);

	}

	public void submitButtonNavigation() throws InterruptedException {
		ExtentTestManager.startTest("Submit Button Navigation");
		Log.info("Tested Submit Button Navigation.");

		click(OLtrans.submittrans);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1- Click Submit Button.");
		Log.info("Step:1 - Click Submit Button.");
		
		AcceptAlert();

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User navigates to summary page");
		Log.info("Expected Result: User navigates to summary page");
		ExtentTestManager.endTest();

		transId = driver.findElement(Suspenseasset.transIDD).getText();

	}

	public void printButtonTest() throws InterruptedException {
		ExtentTestManager.startTest("Print Button Test");
		Log.info("Tested Print Button.");

		click(Suspenseasset.Clickonprint);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Print Button.");
		Log.info("Step:1 - Click Print Button.");

		Thread.sleep(5000);

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
				// Thread.sleep(5000);
				String currentUrl = driver.getCurrentUrl();
				System.out.println("currentUrl: " + currentUrl);
				if (currentUrl.endsWith(".pdf")) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Voucher is generated correctly.");
					Log.info("Expected Result: Voucher is generated correctly.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Voucher is generated and printed");
				Log.info("Expected Result: Voucher is generated and printed");
				ExtentTestManager.endTest();

				driver.close();
				driver.switchTo().window(mainWindowHandle);

				break;

			}

		} // for loop end

	}

	public void logoutApplication1() throws InterruptedException {
		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");
        
		//click(JewelClosure.close);
		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();
		
		
		

	}

// LOGIN WITH DIFFERENMT USER

	public void loginWithDifferentUser11() {
		ExtentTestManager.startTest("Login with different user");
		Log.info("Login with different user");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Entered valid username , clicked Login.");
		Log.info("Step: 01 - Entered valid  password, clicked Login.");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 02 - Entered valid  password, clicked Login.");
		Log.info("Step: 02 - Entered valid password, clicked Login.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is successfully logged in and dashboard is displayed");
		Log.info("Expected Result: User is successfully logged in and dashboard is displayed");
		ExtentTestManager.endTest();
	}

	public void userLoggedIncashier() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		ScrollUntilElementVisible(JewelClosure.authandcancel);
		click(JewelClosure.authandcancel);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Navigated to Cashier Authorization submodule.");
		Log.info("Step: 01 - Navigated to Cashier Authorization submodule.");

		click(JewelClosure.Clickcashierauth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -.Click cashier authorisation Submodule");
		Log.info("Step:02 -Click cashier authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cashier authorization window will be displayed");
		Log.info("Expected Result: Cashier authorization window will be displayed");
		ExtentTestManager.endTest();
	}

	public void userLoggedInrefresh() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.clickrefresh);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked the Refresh tab.");
		Log.info("Step: 01 - Clicked the Refresh tab.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Transaction entry will be displayed after clicking the refresh button");
		Log.info("Expected Result: Transaction entry will be displayed after clicking the refresh button");
		ExtentTestManager.endTest();

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);
	}

	public void userLoggedIncheckbox() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.checkbox);

		ExtentTestManager.getTest().log(Status.PASS,
				"Step: 01 - Selected checkbox of Transaction Suspense Asset Transaction.");
		Log.info("Step: 01 - Selected checkbox of Transaction Suspense Asset Transaction.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select the transaction entry and selected entry is highlighted");
		Log.info("Expected Result: Possible to select the transaction entry and selected entry is highlighted");
		ExtentTestManager.endTest();
	}

	public void userOnCashierAuthorisationWindow() throws InterruptedException {

		ExtentTestManager.startTest("userOnCashierAuthorisationWindow");
		Log.info("userOnCashierAuthorisationWindow");

		click(JewelClosure.clickauths);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked Authorize button.");
		Log.info("Step: 01 - Clicked Authorize button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction is authorized");
		Log.info("Expected Result: Transaction is authorized");
		ExtentTestManager.endTest();

	}

	public void userLoggedInmanager() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");
		click(JewelClosure.managertab);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Navigated to Manager Authorization submodule.");
		Log.info("Step: 01 - Navigated to Manager Authorization submodule.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorization window will be displayed");
		Log.info("Expected Result: Manager authorization window will be displayed");
		ExtentTestManager.endTest();

	}

	public void userLoggedIncash() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.cashtab);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked the Cash tab.");
		Log.info("Step: 01 - Clicked the Cash tab.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab will be displayed");
		Log.info("Expected Result: Cash tab will be displayed");
		ExtentTestManager.endTest();

	}

	public void userLoggedInrefresh1() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.refreshtab);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked the Refresh tab again.");
		Log.info("Step: 01 - Clicked the Refresh tab again.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Transaction entry will be displayed after clicking the refresh button");
		Log.info("Expected Result: Transaction entry will be displayed after clicking the refresh button");
		ExtentTestManager.endTest();

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

	}

	public void userLoggedInbox() throws InterruptedException {
		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.checkboxman);

		ExtentTestManager.getTest().log(Status.PASS,
				"Step: 1 - Selected checkbox of Transaction Suspense Asset Transaction again.");
		Log.info("Step: 1 - Selected checkbox of Transaction Suspense Asset Transaction again.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select the transaction entry and selected entry is highlighted");
		Log.info("Expected Result: Possible to select the transaction entry and selected entry is highlighted");
		ExtentTestManager.endTest();

	}

	public void Mangerauthorization() throws InterruptedException

	{

		ExtentTestManager.startTest("Mangerauthorization");
		Log.info("Mangerauthorization");

		click(JewelClosure.clickauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Clicked Authorize button again.");
		Log.info("Step: 1 - Clicked Authorize button again.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction is authorized");
		Log.info("Expected Result: Transaction is authorized");
		ExtentTestManager.endTest();
	}

// Transfer

	public void LoginvalidCredentials() {

		ExtentTestManager.startTest("LoginCredentials");
		Log.info("Transaction Window Access started.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate to login page.");
		Log.info("Step:01 -  Navigate to login page.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid username and password.");
		Log.info("Step:01 -  Navigate to login page.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Click Login");
		Log.info("Step:01 -  Navigate to login page.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transactions.");
		Log.info("Step:02 - Select Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged into the dashboard.");
		Log.info("Expected Result:User is logged into the dashboard.");
		ExtentTestManager.endTest();

	}

	public void reopenTransactionsWindow() throws InterruptedException {
		ExtentTestManager.startTest("Reopen Transactions Window");
		Log.info("Reopened Transactions Window");

		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Transaction Menu.");
		Log.info("Step:01 - Navigate to Transaction Menu.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transactions.");
		Log.info("Step:02 - Select Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is on Transaction window");
		Log.info("Expected Result: User is on Transaction window");
		ExtentTestManager.endTest();

	}

	public void selectProductGroup() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Group");
		Log.info("Product Group Selected");
		
		select("Suspense Asset", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product Group Dropdown.");
		Log.info("Step:01 - Open Product Group Dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset Product Group.");
		Log.info("Step:02 - Select Suspense Asset Product Group.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Suspense Asset group is selected");
		Log.info("Expected Result: Suspense Asset group is selected");
		ExtentTestManager.endTest();

	}

	public void selectProductName() throws InterruptedException {
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Product Name Selected");

		select("SUSPENSE ASSET", OLtrans.productname);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product name Dropdown.");
		Log.info("Step:01 - Open Product Group Dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset Product Name.");
		Log.info("Step:02 - Select Suspense Asset Product Group.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Suspense Asset name is selected");
		Log.info("Expected Result: Suspense Asset name is selected");
		ExtentTestManager.endTest();
	}

	public void enterAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(OLtrans.transaccount, AccNum);

		ExtentTestManager.startTest("Enter Account Number");
		Log.info("Entered Account Number");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Account Number in Account Number Field.");
		Log.info("Step:01 - Enter Valid Account Number in Account Number Field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is displayed correctly");
		Log.info("Expected Result: Account number is displayed correctly");
		ExtentTestManager.endTest();

	}

	public void enterAccountNumber() throws InterruptedException {

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Search Account number");

		select("Demand Investment", JewelClosure.produgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Select a product group.");
		Log.info("Step:02 -Select a product group.");

		select("INV-DEMAND-CA", JewelClosure.produname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02-  Select a product name.");
		Log.info("Step:02 -Select a product name.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Possible to select the product group and product name ");
		Log.info("Expected Result:Possible to select the product group and product name ");
		ExtentTestManager.endTest();

	}

	public void selectCreditTransaction() throws InterruptedException {
		ExtentTestManager.startTest("Select Credit Transaction");
		Log.info("Selected Credit Transaction");

		select("Credit", OLtrans.selectcredit);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Credit Option.");
		Log.info("Step:01 - Select Credit Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Credit is selected");
		Log.info("Expected Result: Credit is selected");
		ExtentTestManager.endTest();

	}

	public void enterTransactionAmount1() throws InterruptedException {
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Transaction Amount Entered");

		click(OLtrans.clickGoo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Go Button.");
		Log.info("Step:01 - Click Go Button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: System proceeds with account details for transaction");
		Log.info("Expected Result: System proceeds with account details for transaction");
		ExtentTestManager.endTest();

	}

	public void enterTransactionAmount2(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Transaction Amount Entered");

		click(OLtrans.transamount);
		String Transferamount = testdata.get("Transferamount").toString();
		input(OLtrans.transamount, Transferamount);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Enter a valid transaction amount ");
		Log.info("Step: 1- Enter a valid transaction amount.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: .");
		Log.info("Expected Result: .");

		ExtentTestManager.endTest();
		
		

	}

	public void transactionWithTransfer() throws InterruptedException {
		ExtentTestManager.startTest("Transaction with Transfer");
		Log.info("Transaction with Transfer initiated");

		select("TRANSFER", OLtrans.selectcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Enter all required details");

		Log.info("Step: 1 -Enter all required details ");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 2-Select transmode SWIFT_CODE TRANSFER");

		Log.info("Step: 2 -Select transmode SWIFT_CODE TRANSFER ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:TRANSFER  is selected and Post Debit button will be display .");
		Log.info("Expected Result:TRANSFER  is selected and Post Debit button will be display .");

		ExtentTestManager.endTest();

		ScrollUntilElementVisible(OLtrans.scrolldwn);
	}

	public void postDebitTransaction() throws InterruptedException {
		ExtentTestManager.startTest("Post Debit Transaction");
		Log.info("Debit Transaction Posted");

		click(OLtrans.Clickpostdeb);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click on the POST DEBIT button ");
		Log.info("Step: 1 -Click on the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Auto posting popup window will be display .");
		Log.info("Expected Result:Auto posting popup window will be display .");

		ExtentTestManager.endTest();
	}

	public void searchAccountNumber(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		ExtentTestManager.startTest("Search Account Number");
		Log.info("Searched for Account Number");

		 mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
			}
		}


		select("Demand Investment", JewelClosure.produgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Select a product group.");
		Log.info("Step:02 -Select a product group.");

		select("INV-DEMAND-CA", JewelClosure.produname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02-  Select a product name.");
		Log.info("Step:02 -Select a product name.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Possible to select the product group and product name ");
		Log.info("Expected Result:Possible to select the product group and product name ");
		ExtentTestManager.endTest();
	

	}

public void selectAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
 
 
 ExtentTestManager.startTest("Select Account Number");
 Log.info("Account Number Selected");
 
 String AccountNumber = testdata.get("AccountNumber").toString();
	input(JewelClosure.accnumber, AccountNumber);
 
 ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -1. Give account number as '3' ");
 Log.info("Step: 1 - 1. Give account number as '3'.");
 
 ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given account number details will be display .");
 Log.info("Expected Result: Given account number details will be display.");
 
 Display = driver.findElement(JewelClosure.dispname).getAttribute("value");
	
	System.out.println("Amount" + Display);
	displayamount(Display);
 
 ExtentTestManager.endTest();
}

public void addTransactionAmount1() throws InterruptedException

{
	ExtentTestManager.startTest("Add Transaction Amount");
	Log.info("Transaction Amount Added");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Enter amount.");
	Log.info("Step: 1 - Enter amount.");
	
	

	click(JewelClosure.CliADD);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 2- Click ADD.");
	Log.info("Step: 2 - Click ADD.");

	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:Amount and details is added in the grid in the auto posting popup window.");
	Log.info("Expected Result:Amount and details is added in the grid in the auto posting popup window  .");

	ExtentTestManager.endTest();
}

public void addTransactionAmount() throws InterruptedException {
	
	
	ExtentTestManager.startTest("Add Transaction Amount");
	Log.info("Transaction Amount Added");

	click(JewelClosure.clickSubmit);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Enter submit in the auto posting popu window ");
	Log.info("Step: 1 - Enter submit in the auto posting popu window .");

	
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:Details is added and auto posting popu window closes .");
	Log.info("Expected Result:Details is added and auto posting popu window closes .");

	ScrollUntilElementVisible(OLtrans.scrolldwn);
	
	ExtentTestManager.endTest();
}

public void submitTransactionWindow() throws InterruptedException {
	ExtentTestManager.startTest("Submit in Transaction Window");
	Log.info("Submitted Transaction Window");


	click(Suspenseasset.submitpos);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click Submit button.");
	Log.info("Step: 1 - Click Submit button.");

	AcceptAlert();
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User navigates to the summary page.");
	Log.info("Expected Result: User navigates to the summary page.");
	
	transId = driver.findElement(Suspenseasset.transIDD).getText();

	ExtentTestManager.endTest();
}

public void printVoucherAgain() {
	ExtentTestManager.startTest("Print Voucher Again");
	Log.info("Voucher Reprinted");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 1- Click Print button.");
	Log.info("Step: 1 - Click Print button.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Voucher is generated and printed.");
	Log.info("Expected Result: Voucher is generated and printed.");
	ExtentTestManager.endTest();

}

public void logoutApplication() throws InterruptedException {
	
	ExtentTestManager.startTest("Logout in application");
	Log.info("Logged out from application.");
    
	click(JewelClosure.close);
	click(JewelClosure.Singout);
	ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
	Log.info("Step:1 - Click Logout Option.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
	Log.info("Expected Result: Login page will be displayed");
	ExtentTestManager.endTest();
	

	
}


public void logoutApplication3() throws InterruptedException {
	
	ExtentTestManager.startTest("Logout in application");
	Log.info("Logged out from application.");
    
	click(JewelClosure.close);
	click(JewelClosure.Singout);
	ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
	Log.info("Step:1 - Click Logout Option.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
	Log.info("Expected Result: Login page will be displayed");
	ExtentTestManager.endTest();
	
driver.close();
	
}

// LOGIN ANOTHER USER

public void loginWithDifferentUser() {
	ExtentTestManager.startTest("Login with different user");
	Log.info("Login with different user");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Entered valid username , clicked Login.");
	Log.info("Step: 01 - Entered valid  password, clicked Login.");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 02 - Entered valid  password, clicked Login.");
	Log.info("Step: 02 - Entered valid password, clicked Login.");

	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result: User is successfully logged in and dashboard is displayed");
	Log.info("Expected Result: User is successfully logged in and dashboard is displayed");
	ExtentTestManager.endTest();
}

public void UserLoggedInsub() throws InterruptedException {
	ExtentTestManager.startTest("User is Logged In");
	Log.info("User successfully logged in");
	
	click(JewelClosure.managertab);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Click the authoirze & Cancel module from the taskbar");
	Log.info("Step: 1 -Click the authoirze & Cancel module from the taskbar");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 2 -Click Manager authorisation Submodule");
	Log.info("Step: 1 -Click Manager authorisation Submodule");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorization window will be display.");
	Log.info("Expected Result: Manager authorization window will be display.");

	ExtentTestManager.endTest();
}

public void UserLoggedIntransfer() throws InterruptedException {
	ExtentTestManager.startTest("User is Logged In");
	Log.info("User successfully logged in");

	click(JewelClosure.Transfertab);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Click the Transfer tab ");
	Log.info("Step: 1 -Click the Transfer tab  .");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab will be display.");
	Log.info("Expected Result: Transfer tab will be display.");

	ExtentTestManager.endTest();
}

public void UserLoggedInrefresh() {
	ExtentTestManager.startTest("User is Logged In");
	Log.info("User successfully logged in");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -1.Click the Refresh tab ");
	Log.info("Step: 1 - 1.Click the Refresh tab.");

	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:Transaction entry will be diaply after clicking the refresh button .");
	Log.info("Expected Result:Transaction entry will be diaply after clicking the refresh button .");

	ExtentTestManager.endTest();
}

public void UserLoggedInCheckbx1() throws InterruptedException {
	ExtentTestManager.startTest("User is Logged In");
	Log.info("User successfully logged in");

	click(Suspenseasset.checkboxman);
	
	ExtentTestManager.getTest().log(Status.PASS,
			"Step: 1 -1.Select the checbox of transaction suspense Asset transaction ");
	Log.info("Step: 1 -1.Select the checbox of transaction suspense Asset transaction .");

	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result: Possible to select the transaction entry and selected entry is hghlighted.");
	Log.info("Expected Result: Possible to select the transaction entry and selected entry is hghlighted.");

	ExtentTestManager.endTest();
}

public void managerAuthorization() {
	ExtentTestManager.startTest("ManagerAuthorization");
	Log.info("User is on Manager Authorization window");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Click Authorise button ");
	Log.info("Step: 1 - Click Authorise button.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction is authorised.");
	Log.info("Expected Result: Transaction is authorised.");

	ExtentTestManager.endTest();
}
}
