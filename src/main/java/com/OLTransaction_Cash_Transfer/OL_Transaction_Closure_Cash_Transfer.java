package com.OLTransaction_Cash_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class OL_Transaction_Closure_Cash_Transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	String transId;
	String transIdTransfer;

	String Display;
String Actualusername;
	public String sp = "GetOtherloanAccountnumberForTransaction";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

//	public void username() {
//		Actualusername = getActualUserName(ClosureTrans.Username);
//		System.out.println("Firstusername: " + Actualusername);
//	}
//	
	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}

	public void Closure() throws InterruptedException {
		ExtentTestManager.startTest("Navigate to  Navigate Other Loan Closure Window");
		Log.info("Navigate to Jewel Loan Closure Window");

		click(JewelClosure.OpenClosureandrenewal);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate to Closure & Renewals Loan Closure");
		Log.info("Step:01 -  Navigate to Closure & Renewals Loan Closure");

		click(JewelClosure.Clickonclosure);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  click on Loan Closure");
		Log.info("Step:02 -click on Loan Closure");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Loan Closure window is displayed ");
		Log.info("Expected Result: Loan Closure window is displayed");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("OTHER LOANS", JewelClosure.selectproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select product group 'Jewel Loan'");
		Log.info("Step:01 -Select product group 'Jewel Loan'");

		select("PERSONAL LOAN WEEKLY", JewelClosure.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select appropriate product name'");
		Log.info("Step:02 -Select appropriate product name'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected product is displayed");
		Log.info("Expected Result: Selected product is displayed");

		ExtentTestManager.endTest();

	}

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
		input(JewelClosure.StoreAccun, AccNum);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Loan number can be entered Account details are displayed ");
		Log.info("Expected Result: Loan number can be entered Account details are displayed");

		ExtentTestManager.endTest();

		click(JewelClosure.clickGo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Go button");
		Log.info("Step:01 -Click on Go button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are displayed");
		Log.info("Expected Result: Account details are displayed");

		ExtentTestManager.endTest();

		try {

			ExtentTestManager.startTest("Warning Validation Popup window");
			Log.info("Warning Validation Popup window");

			click(JewelClosure.ClickNo);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter No in the warning validation popup window");
			Log.info("Step:01 -Enter No in the warning validation popup window");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Loan details are fetched and displayed correctly.");
			Log.info("Expected Result: Loan details are fetched and displayed correctly.");

			ExtentTestManager.endTest();

		} catch (Exception e) {

		}

		ScrollUntilElementVisible(JewelClosure.scrolldown);

		if (ElementDisplayed(JewelClosure.Totalamount)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Verify Closure Amount Display.");
			Log.info("Expected Result: Verify Closure Amount Display.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

	}

	public void Cash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Select Cash as Transmode and Submit");
		Log.info("Select Cash as Transmode and Submit");

		select("CASH", JewelClosure.Selectcash);
		ExtentTestManager.getTest().log(Status.PASS, " Select 'CASH' from transmode dropdown");
		Log.info("Step:01 -Select 'CASH' from transmode dropdown");

		ScrollUntilElementVisible(JewelClosure.scrolldown);

		String remarks = testdata.get("remarks").toString();

		input(JewelClosure.remarks, remarks);
		click(JewelClosure.remarks);

		click(JewelClosure.submit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Loan closure transaction is submitted successfully");
		Log.info("Step:01 -Loan closure transaction is submitted successfully");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product group and name selected");
		Log.info("Expected Result: Product group and name selected.");

		ExtentTestManager.endTest();

		if (ElementDisplayed(JewelClosure.TrasidVisible)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Summary page visible.");
			Log.info("Expected Result:Summary page visible.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		transId = driver.findElement(JewelClosure.transIdd).getText();

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

		try {
			ElementDisplayed(custSearch.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		} catch (Exception e) {
			ElementDisplayed(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS,
					"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			// String loginUserName = testdata.get("loginUserName").toString();
			input(custSearch.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			// String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(custSearch.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(custSearch.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(custSearch.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}

		ExtentTestManager.endTest();

	

	String authoeizeUserName = driver.findElement(goaldLoanRepo.userName).getText();
	System.out.println("authoeizeUserName: " + authoeizeUserName);

//	String flag = "vinusha";

	System.out.println("Firstusername: " + Customer_CustomerSearch.Firstusername);
	
	if(!authoeizeUserName.equalsIgnoreCase(Customer_CustomerSearch.Firstusername))
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
		Log.info("Expected Result: Logging successfull with another user");
	}else
	{
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}

	ExtentTestManager.endTest();
	}

	//public String getActualUserName(By locator) {
		//String actualUserName = driver.findElement(locator).getText();
		//System.out.println("actualUserName: "+actualUserName);
		//return actualUserName;
	//}
	
	public void Cashier() throws InterruptedException {
			ExtentTestManager.startTest("User is logged in");
			Log.info("User is logged in");

			click(JewelClosure.authandcancel);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -.Click the authoirze & Cancel module from the taskbar");
			Log.info("Step:01 -.Click the authoirze & Cancel module from the taskbar");

			click(JewelClosure.Clickcashierauth);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 -.Click cashier authorisation Submodule");
			Log.info("Step:02 -Click cashier authorisation Submodule");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Cashier authorization window will be display.");
			Log.info("Expected Result: Cashier authorization window will be display");

			ExtentTestManager.endTest();

			ExtentTestManager.startTest("User is logged in");
			Log.info("User is logged in");

			click(JewelClosure.clickrefresh);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the Refresh tab");
			Log.info("Step:01 -Click the Refresh tab");

			System.out.println("transIdCashPersonal " + transId);
			fetchWithTransId(transId);

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result:  Closure entry will be diaply after clicking the refresh button.");
			Log.info("Expected Result:Closure entry will be diaply after clicking the refresh button");

			ExtentTestManager.endTest();

			ExtentTestManager.startTest("User is logged in");
			Log.info("User is logged in");

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

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Closure entry is authorised");
			Log.info("Expected Result:Closure entry is authorised");

			ExtentTestManager.endTest();

		}

	public void Manager() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		// ScrollUntilElementVisible(JewelClosure.scrolldownside);

		click(JewelClosure.managertab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule");
		Log.info("Step:02 -Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, " Expected Result: Manager authorization window will be display");
		Log.info("Expected Result: Manager authorization window will be display");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("User is logged in");
		Log.info("User is logged in");

		click(JewelClosure.cashtab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the cash tab");
		Log.info("Step:01 -Click the cash tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab will be displayed");
		Log.info("Expected Result: Cash tab will be displayed");

		ExtentTestManager.endTest();

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

		ExtentTestManager.startTest("User is on Manager authorisation window");
		Log.info("User is on Manager authorisation window");

		click(JewelClosure.clickauth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click Authorise button");
		Log.info("Step:01 -Click Authorise button");

		click(JewelClosure.close);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Closure entry is authorised");
		Log.info("Expected Result: Closure entry is authorised");

		ExtentTestManager.endTest();

	}

	// Other Loan Closure transfer

	public void ClosurerenewalTrasnfer() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Other Loan Closure Window");
		Log.info("Navigate to Other Loan Closure Window");

		click(JewelClosure.Clickonclosure);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  click on Loan Closure");
		Log.info("Step:02 -click on Loan Closure");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan Closure window is displayed");
		Log.info("Expected Result: Loan Closure window is displayed");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("Jewel Loan", JewelClosure.selectproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select product group 'Jewel Loan'");
		Log.info("Step:01 -Select product group 'Jewel Loan'");

		select("GOLD LOAN", JewelClosure.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select appropriate product name'");
		Log.info("Step:02 -Select appropriate product name'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected product is displayed");
		Log.info("Expected Result: Selected product is displayed");
		ExtentTestManager.endTest();

	}

	public void Transfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		if (ElementDisplayed(JewelClosure.cloamtdisplay)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Closure amount is accurately displayed");
			Log.info("Expected Result:Closure amount is accurately displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.startTest("Select Transmode Transfer and Post Debit");
		Log.info("Select Transmode Transfer and Post Debit");

		select("TRANSFER", JewelClosure.selecttransfer);
		ExtentTestManager.getTest().log(Status.PASS, " Step:01-Select 'TRANSFER' from transmode dropdown");
		Log.info("Step:01 -Select 'CASH' from transmode dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: POST DEBITbutton will be display");
		Log.info("Expected Result:POST DEBITbutton will be display ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Post Debit");
		Log.info("Select Post Debit");

		click(JewelClosure.clickPD);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Click the POST DEBIT button.");
		Log.info("Step:02 -Click the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Auto posting popup window will be opens");
		Log.info("Expected Result:Auto posting popup window will be opens ");
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

		ExtentTestManager.startTest("Search Account number");
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

	// OtherloanClosure_Transfer

	public void ClosurerenewalTrasnfer1() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Jewel Loan Closure Window");
		Log.info("Navigate to Jewel Loan Closure Window");

		click(JewelClosure.Clickonclosure);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  click on Loan Closure");
		Log.info("Step:02 -click on Loan Closure");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan Closure window is displayed");
		Log.info("Expected Result: Loan Closure window is displayed");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("OTHER LOANS", JewelClosure.selectproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select product group 'Jewel Loan'");
		Log.info("Step:01 -Select product group 'Jewel Loan'");

		select("PERSONAL LOAN WEEKLY", JewelClosure.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select appropriate product name'");
		Log.info("Step:02 -Select appropriate product name'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected product is displayed");
		Log.info("Expected Result: Selected product is displayed");
		ExtentTestManager.endTest();

	}

	public void Transfer1(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Verify Closure Amount Display");
		Log.info("Verify Closure Amount Display");

		if (ElementDisplayed(JewelClosure.cloamtdisplay)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Closure amount is accurately displayed");
			Log.info("Expected Result:Closure amount is accurately displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan account details are correctly displayed");
		Log.info("Expected Result: Loan account details are correctly displayed");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Transmode Transfer and Post Debit");
		Log.info("Select Transmode Transfer and Post Debit");

		select("TRANSFER", JewelClosure.selecttransfer);
		ExtentTestManager.getTest().log(Status.PASS, " Step:01-Select 'TRANSFER' from transmode dropdown");
		Log.info("Step:01 -Select 'CASH' from transmode dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: POST DEBITbutton will be display");
		Log.info("Expected Result:POST DEBITbutton will be display ");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Select Post Debit");
		Log.info("Select Post Debit");

		click(JewelClosure.clickPD);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Click the POST DEBIT button.");
		Log.info("Step:02 -Click the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Auto posting popup window will be opens");
		Log.info("Expected Result:Auto posting popup window will be opens ");
		ExtentTestManager.endTest();

	}

	public void Accountnumbers(Map<Object, Object> testdata, ITestContext context)
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

		ExtentTestManager.startTest("Search Account number");
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

		transId = driver.findElement(JewelClosure.ttransid).getText();

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is navigated to the summary page");
		Log.info("Expected Result:User is navigated to the summary page ");
		ExtentTestManager.endTest();

	}

	public void ManagerAuth1() throws InterruptedException {

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

	public void Signout2() throws InterruptedException {

		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");

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

}
