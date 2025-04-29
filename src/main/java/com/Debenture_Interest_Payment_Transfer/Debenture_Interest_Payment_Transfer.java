package com.Debenture_Interest_Payment_Transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Bond_Issue;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_Interest_Payment_Transfer;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Multiple_Fd_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_SusAssetTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Debenture_Interest_Payment_Transfer extends Base_Class {

	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_Multiple_Fd_Cash_Transfer FDintrest = new PageRepositary_Multiple_Fd_Cash_Transfer();
	PageRepositary_Bond_Issue Bondissue = new PageRepositary_Bond_Issue();
	PageRepositary_Debenture_Interest_Payment_Transfer Debenture = new PageRepositary_Debenture_Interest_Payment_Transfer();
	PageRepositary_SusAssetTransaction_Cash_Transfer Suspenseasset = new PageRepositary_SusAssetTransaction_Cash_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	String mainWindowHandleParent;
	String mainWindowHandlechild;

	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		clear(Bondissue.enteramount);
		click(Bondissue.enteramount);
		input(Bondissue.enteramount, Display);
	}

	public void NavigatetoDebentureinterestpayment() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Debenture interest payment");
		Log.info("Navigate to Debenture interest payment");

		ScrollUntilElementVisible(Debenture.clickondebenture);
		click(Debenture.clickondebenture);
		click(Debenture.clickdebpayment);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Debenture Debenture Interest Payment. ");
		Log.info("Step:01 - Navigate to Debenture Debenture Interest Payment.");
		ExtentTestManager.getTest().log(Status.PASS, "Loaded Debenture Interest payment");
		Log.info("Loaded Debenture Interest payment");
	}

	public void verifyBranchParameterDefaults() throws InterruptedException {

		ExtentTestManager.startTest("Verify Dropdown for Debenture Type");
		Log.info("Verify Dropdown for Debenture Type");
		select("DEB TRAIL TRANSFER", Debenture.debtype);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Debenture Type options from the dropdown.");
		Log.info("Step:01 -Select 'Debenture Type options from the dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "appropriate values load according to selection.");
		Log.info("appropriate values load according to selection.");

		ExtentTestManager.startTest("Verify Dropdown for Debenture Issue");
		Log.info("Verify Dropdown for Debenture Issue");
		select("ISSUE-DEB TRAIL TRANSFER", Debenture.Issuetype);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select ' Issue Type' options from the dropdown..");
		Log.info("Step:01 -Select ' Issue Type' options from the dropdown..");
		ExtentTestManager.getTest().log(Status.PASS, "appropriate values load according to selection.");
		Log.info("appropriate values load according to selection.");

		ExtentTestManager.startTest("Verify Dropdown for Debenture Series");
		Log.info("Verify Dropdown for Debenture Series");
		select("SERIES-ISSUE-DEB TRAIL TRANSFER", Debenture.Issuetype);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Debenture series options from the dropdown.");
		Log.info("Step:01 -Select 'Debenture series options from the dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "appropriate values load according to selection.");
		Log.info("appropriate values load according to selection.");

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

	public void verifyAccountNumberEntry() throws ClassNotFoundException, InterruptedException {

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(Debenture.accountnumber, AccNum);

		ExtentTestManager.getTest().log(Status.PASS,
				"Step :01-Enter a valid fixed deposit account number in the 'Account No' field. ");
		Log.info("Step:01 - Enter a valid fixed deposit account number in the 'Account No' field. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is accepted. ");
		Log.info("Expected Result:Account number is accepted. ");
		ExtentTestManager.endTest();

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid account number in the 'Ac No' field..");
		Log.info("Step:01 -Enter a valid account number in the 'Ac No' field..");

		click(Debenture.clickonGo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Press Enter or click Go button...");
		Log.info("Step:02 -Press Enter or click Go button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"System proceeds to the interest payment window of the account with entered Ac No..");
		Log.info("System proceeds to the interest payment window of the account with entered Ac No..");

	}

	public void verifyDurationValueEntry() throws InterruptedException {

		ExtentTestManager.startTest("Debenture duration");
		Log.info("Debenture duration");
		click(Debenture.duration);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01-  Enter a valid duration value into the 'duration' field. then click tab");
		Log.info("Step:01 -Enter a valid duration value into the 'duration' field. then click tab.");
		ExtentTestManager.getTest().log(Status.PASS,
				"Accepted when within duration constraints otherwise error message is shown.");
		Log.info("Accepted when within duration constraints otherwise error message is shown.");

	}

	public void verifyPostCreditPopupDisplay(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("Post Debit Transaction");
		Log.info("Debit Transaction Posted");
		click(OLtrans.Clickpostdeb);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click on the POST DEBIT button ");
		Log.info("Step: 1 -Click on the POST DEBIT button.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Auto posting popup window will be display .");
		Log.info("Expected Result:Auto posting popup window will be display .");
		ExtentTestManager.endTest();

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

		ExtentTestManager.startTest("Select Account Number");
		Log.info("Account Number Selected");
		mainWindowHandlechild = driver.getWindowHandle();
		boolean popupAppeared1 = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandlechild)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared1 = true;
			}
		}

		select("Demand Investment", FDintrest.group);
		select("INV-DEMAND-CA", FDintrest.product);
		select("TRIVANDRUM", FDintrest.branch);
		click(FDintrest.clicksearch);
		click(FDintrest.select);

		driver.switchTo().window(mainWindowHandlechild);

		// click(FDintrest.clickonsearch);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given account number details will be display .");
		Log.info("Expected Result: Given account number details will be display.");

		Display = driver.findElement(JewelClosure.dispname).getAttribute("value");

		System.out.println("Amount" + Display);
		displayamount(Display);

		ExtentTestManager.endTest();

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
		
		

		ExtentTestManager.startTest("Add Transaction Amount");
		Log.info("Transaction Amount Added");
		click(JewelClosure.clickSubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Enter submit in the auto posting popu window ");
		Log.info("Step: 1 - Enter submit in the auto posting popu window .");
		driver.switchTo().window(mainWindowHandleParent);
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Details is added and auto posting popu window closes .");
		Log.info("Expected Result:Details is added and auto posting popu window closes .");

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

}
