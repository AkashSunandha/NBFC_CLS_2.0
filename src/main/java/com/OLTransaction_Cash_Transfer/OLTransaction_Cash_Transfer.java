package com.OLTransaction_Cash_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class OLTransaction_Cash_Transfer extends Base_Class {
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	String transId;
	String transIdTransfer;

	String Display;

	public String sp = "GetOtherloanAccountnumberForTransaction";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}

	public void Transactionwindow() throws InterruptedException {

		ExtentTestManager.startTest("Transactions Window Navigation");
		Log.info("Transactions Window Navigation");

		click(OLtrans.ClickTransaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate through Path: Transaction: Transactions.");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transactions window is displayed.");
		Log.info("Expected Result:Transactions window is displayed.");
		ExtentTestManager.endTest();

		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate through Path: Transaction: Transactions.");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("OTHER LOANS", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Other Loan from Product Group..");
		Log.info("Step:01 - Select Other Loan from Product Group..");

		select("PERSONAL LOAN WEEKLY", OLtrans.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02- Select any product name..");
		Log.info("Step:02- Select any product name..");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Product Group and Name are selected successfully.");
		Log.info("Expected Result:Product Group and Name are selected successfully..");
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

	public void Accountnumber(Map<Object, Object> testdata, ITestContext context)

			throws ClassNotFoundException, InterruptedException {
		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 4);
		input(OLtrans.transaccount, AccNum);

	

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Account number is entered correctly..");
		Log.info("Expected Result:Account number is entered correctly...");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Transaction Type CREDIT");
		Log.info("Select Transaction Type CREDIT");

		select("Credit", OLtrans.selectcredit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- Select transtype 'CREDIT'.");
		Log.info("Step:1-Select transtype 'CREDIT'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:'CREDIT' transaction type is selected...");
		Log.info("Expected Result:'CREDIT' transaction type is selected...");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("GO Button Interaction");
		Log.info("GO Button Interaction");

		click(OLtrans.clickGoo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Go button");
		Log.info("Step:01 -Click on Go button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Transaction details are loaded successfully.");
		Log.info("Expected Result:Transaction details are loaded successfully.");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Enter Transaction Amount");

		click(OLtrans.transamount);
		String Transferamount = testdata.get("Transferamount").toString();
		input(OLtrans.transamount, Transferamount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-Enter an amount figure in the Trans. amount field.");
		Log.info("Step:01-Enter an amount figure in the Trans. amount field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Amount is entered successfully without errors..");
		Log.info("Expected Result:Amount is entered successfully without errors..");
		ExtentTestManager.endTest();

	}

	public void SelectCASH() throws InterruptedException {

		ExtentTestManager.startTest("Select Transmode CASH");
		Log.info("Select Transmode CASH");

		select("CASH", OLtrans.selectcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'");
		Log.info("Step:01 - Select Trans. Mode 'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transmode 'CASH' is selected..");
		Log.info("Expected Result:Transmode 'CASH' is selected..");
		ExtentTestManager.endTest();

		ScrollUntilElementVisible(OLtrans.scrolldwn);


		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");
		
		click(OLtrans.submittrans);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Click submit button.");
		Log.info("Step:01 - Redirects to summary page.");

		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent collection exists for this account  popup comes.");
		Log.info("Expected Result:Agent collection exists for this account popup comes");
		ExtentTestManager.endTest();


		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");

		AcceptAlert();
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01- Click OK button on the Agent collection exists for this account popup");
		Log.info("Step:01 - Click OK button on the Agent collection exists for this account popup");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction saved successfully.");
		Log.info("Expected Result:Transaction saved successfully");
		ExtentTestManager.endTest();

		transId = driver.findElement(OLtrans.TransIID).getText();
	}

	public void print() throws InterruptedException {
		ExtentTestManager.startTest("Print Voucher");
		Log.info("Print Voucher");

		click(OLtrans.clickprint);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Click on the PRINT button..");
		Log.info("Step:01 - Click on the PRINT button..");

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

				ExtentTestManager.endTest();

				driver.close();
				driver.switchTo().window(mainWindowHandle);

				break;

			}

		} // for loop end

	}

	public void AnotherUSer(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		String UserName = configloader().getProperty("UserName1");
		input(custSearch.loginUserName, UserName);

		String Password = configloader().getProperty("Password1");
		input(custSearch.loginPasswrd, Password);

		click(custSearch.loginButton);

		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);

		String flag = "vinusha";

		if (!userName.equalsIgnoreCase(flag)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();
	}

	public void Cashier() throws InterruptedException {
		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(JewelClosure.authandcancel);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -.Click the authoirze & Cancel module from the taskbar");
		Log.info("Step:01 -.Click the authoirze & Cancel module from the taskbar");

		click(JewelClosure.Clickcashierauth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -.Click cashier authorisation Submodule");
		Log.info("Step:02 -Click cashier authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Cashier authorization window will be display.");
		Log.info("Expected Result: Cashier authorization window will be display");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(JewelClosure.clickrefresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the Refresh tab");
		Log.info("Step:01 -Click the Refresh tab");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:  Transaction entry will be diaply after clicking the refresh button.");
		Log.info("Expected Result:Transaction entry will be diaply after clicking the refresh button");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(JewelClosure.checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select the checbox of jewel loan closure ");
		Log.info("Step:01 -Select the checbox of jewel loan closure ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select the closure entry and selected entry is hghlighted");
		Log.info("Expected Result:Possible to select the closure entry and selected entry is hghlighted");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is on Cashier authorisation window");
		Log.info("User is on Cashier authorisation window");

		click(JewelClosure.clickauths);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -1.Click Authorise button");
		Log.info("Step:01 -1.Click Authorise button");
		click(JewelClosure.close);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction entry is authorised");
		Log.info("Expected Result:Transaction entry is authorised");

		ExtentTestManager.endTest();

	}

	public void Manager() throws InterruptedException {

		ExtentTestManager.startTest("Manager authorization");
		Log.info("Manager authorization");

		// ScrollUntilElementVisible(JewelClosure.scrolldownside);

		click(JewelClosure.managertab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule");
		Log.info("Step:02 -Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, " Expected Result: Manager authorization window will be display");
		Log.info("Expected Result: Manager authorization window will be display");

		ExtentTestManager.endTest();

		

		click(JewelClosure.cashtab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the cash tab");
		Log.info("Step:01 -Click the cash tab");

		

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.refreshtab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Refresh tab ");
		Log.info("Step:01 -Refresh tab ");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Closure entry will be diaply after clicking the refresh button");
		Log.info("Expected Result: Closure entry will be diaply after clicking the refresh button");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.checkboxman);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select the checbox of jewel loan closure ");
		Log.info("Step:01 -Select the checbox of jewel loan closure ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select the closure entry and selected entry is hghlighted");
		Log.info("Expected Result: Possible to select the closure entry and selected entry is hghlighted");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.clickauth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click Authorise button");
		Log.info("Step:01 -Click Authorise button");

		click(JewelClosure.close);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Closure entry is authorised");
		Log.info("Expected Result: Closure entry is authorised");

		ExtentTestManager.endTest();

	}

	public void Signout() throws InterruptedException {

		ExtentTestManager.startTest("Logout in application");
		Log.info("Logout in application");

		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Login page will be dispays.");
		Log.info("Expected Result:Login page will be dispays.");

		ExtentTestManager.endTest();
	}
	
	public void Signout1() throws InterruptedException {

		ExtentTestManager.startTest("Logout in application");
		Log.info("Logout in application");

		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Login page will be dispays.");
		Log.info("Expected Result:Login page will be dispays.");

		ExtentTestManager.endTest();
		
		
		driver.close();
	}

	// Transfer

	public void SelectTransfer() throws InterruptedException {

		ExtentTestManager.startTest("Select Transmode Transfer");
		Log.info("Select Transmode Transfer");

		select("TRANSFER", OLtrans.selectcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select transmode 'Transfer'.");
		Log.info("Step:01 - Select transmode 'Transfer'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Transmode 'Transfer' is selected..");
		Log.info("Expected Result:Transmode 'Transfer' is selected.");

		ExtentTestManager.endTest();

		ScrollUntilElementVisible(OLtrans.scrolldwn);

		ExtentTestManager.startTest("POST DEBIT Interaction");
		Log.info("POST DEBIT Interaction");

		click(OLtrans.Clickpostdeb);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Click on the POST DEBIT button..");
		Log.info("Step:01. Click on the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:‘Auto Posting’ popup is generated.");
		Log.info("Expected Result:‘Auto Posting’ popup is generated..");

		ExtentTestManager.endTest();

	}

	public void Accountnumber2(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {

		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
			}
		}

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

		ExtentTestManager.startTest("Select Account Number");
		Log.info("Search Account Number");

		String AccountNumber = testdata.get("AccountNumber").toString();
		input(JewelClosure.accnumber, AccountNumber);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Give account number as '3'.");
		Log.info("Step:01-Give account number as '3'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given account number details will be display ");
		Log.info("Expected Result:Given account number details will be display ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Add Transaction Amount");
		Log.info("Add Transaction Amount");

		Display = driver.findElement(JewelClosure.dispname).getAttribute("value");

		System.out.println("Amount" + Display);
		displayamount(Display);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Enter amount.");
		Log.info("Step:01-Enter amount.");

		click(JewelClosure.CliADD);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02- Click ADD.");
		Log.info("Step:02-Click ADD");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Amount and details is added in the grid in the auto posting popup window ");
		Log.info("Expected Result: Amount and details is added in the grid in the auto posting popup window");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Submit POST DEBIT Action");
		Log.info("Submit POST DEBIT Action");

		click(JewelClosure.clickSubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Click the SUBMIT button for POST DEBIT..");
		Log.info("Step:01-Enter amount.");

		driver.switchTo().window(mainWindowHandle);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Auto posting popu window will be close ");
		Log.info("Expected Result: Auto posting popu window will be close");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Navigate to Summary Page - SWIFT_CODE");
		Log.info("Navigate to Summary Page - SWIFT_CODE");

		click(JewelClosure.submitpostD);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Enter amount.");
		Log.info("Step:01-Enter amount.");

		AcceptAlert();

		transId = driver.findElement(JewelClosure.ttransid).getText();

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is navigated to the summary page");
		Log.info("Expected Result:User is navigated to the summary page ");
		ExtentTestManager.endTest();

	}

	public void ManagerAuth() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		// ScrollUntilElementVisible(JewelClosure.scrolldownside);

		click(JewelClosure.managertab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule");
		Log.info("Step:02 -Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Manager authorization window will be display ");
		Log.info("Expected Result:Manager authorization window will be display ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.Transfertab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the Transfer tab");
		Log.info("Step:01 -Click the cash tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Transfer tab will be display ");
		Log.info("Expected Result: Transfer tab will be display");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.refreshtab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Refresh tab ");
		Log.info("Step:01 -Refresh tab ");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Closure entry will be diaply after clicking the refresh button ");
		Log.info("Expected Result:Closure entry will be diaply after clicking the refresh button ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.checkboxtrue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select the checbox of jewel loan closure ");
		Log.info("Step:01 -Select the checbox of jewel loan closure ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Possible to select the closure entry and selected entry is hghlighted ");
		Log.info("Expected Result:Possible to select the closure entry and selected entry is hghlighted ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is on Manager authorisation window");
		Log.info("User is on Manager authorisation window");

		click(JewelClosure.clickauth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click Authorise button");
		Log.info("Step:01 -Click Authorise button");

		click(JewelClosure.close);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Closure entry is authorised");
		Log.info("Expected Result:Closure entry is authorised ");
		ExtentTestManager.endTest();

	}

	public void Transactionwindow2() throws InterruptedException {

		ExtentTestManager.startTest("Transactions Window Navigation");
		Log.info("Transactions Window Navigation");

		// click(OLtrans.ClickTransaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate through Path: Transaction: Transactions.");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transactions window is displayed.");
		Log.info("Expected Result:Transactions window is displayed.");
		ExtentTestManager.endTest();

		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate through Path: Transaction: Transactions.");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("OTHER LOANS", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Other Loan from Product Group..");
		Log.info("Step:01 - Select Other Loan from Product Group..");

		select("PERSONAL LOAN WEEKLY", OLtrans.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02- Select any product name..");
		Log.info("Step:02- Select any product name..");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Product Group and Name are selected successfully.");
		Log.info("Expected Result:Product Group and Name are selected successfully..");
		ExtentTestManager.endTest();
	}
	public void Signout2() throws InterruptedException {

		ExtentTestManager.startTest("Logout in application");
		Log.info("Logout in application");

		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Login page will be dispays.");
		Log.info("Expected Result:Login page will be dispays.");

		ExtentTestManager.endTest();
	}
}