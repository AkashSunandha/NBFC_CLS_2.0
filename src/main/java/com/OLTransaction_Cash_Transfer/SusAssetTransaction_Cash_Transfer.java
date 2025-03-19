package com.OLTransaction_Cash_Transfer;

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
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer ();
	PageRepositary_SusAssetTransaction_Cash_Transfer Suspenseasset = new PageRepositary_SusAssetTransaction_Cash_Transfer();
	
	String transId;
	String transIdTransfer;

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

	public void Transactionwindow() throws InterruptedException {

		ExtentTestManager.startTest("Transaction Window Access");
		Log.info("Transaction Window Access");

		click(OLtrans.ClickTransaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Navigate to Transaction");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");
		
		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02-Select Transactions");
		Log.info("Step:02-Select Transactions.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is on Transaction window.");
		Log.info("Expected Result:User is on Transaction window.");
		ExtentTestManager.endTest();


		ExtentTestManager.startTest("Select Suspense Asset Product Group");
		Log.info("Select Suspense Asset Product Group");

		select("Suspense Asset", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Other Loan from Product Group..");
		Log.info("Step:01 - Select Other Loan from Product Group..");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset.");
		Log.info("Step:02 - Select Suspense Asset.");

		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Suspense Asset group is selected.");
		Log.info("Expected Result:Suspense Asset group is selected..");
		ExtentTestManager.endTest();
		
		ExtentTestManager.startTest("Select Suspense Asset Product Name");
		Log.info("Select Suspense Asset Product Name");

		select("SUSPENSE ASSET", OLtrans.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- Select product name..");
		Log.info("Step:02- Select any product name..");


		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Suspense Asset.");
		Log.info("Step:02 - Select Suspense Asset.");

		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Suspense Asset name is selected.");
		Log.info("Expected Result:Suspense Asset name is selected..");
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
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(OLtrans.transaccount, AccNum);

		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");

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

		ExtentTestManager.startTest("Enter Valid Transaction Amount");
		Log.info("Enter Valid Transaction Amount");

		click(OLtrans.transamount);
		String Transferamount = testdata.get("Transferamount").toString();
		input(OLtrans.transamount, Transferamount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-Enter an amount figure in the Trans. amount field.");
		Log.info("Step:01-Enter an amount figure in the Trans. amount field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Amount is Displayed coreectly..");
		Log.info("Expected Result:Amount is Displayed coreectly...");
		ExtentTestManager.endTest();

	}

	public void SelectCASH() throws InterruptedException {

		ExtentTestManager.startTest("Select Transmode CASH");
		Log.info("Select Transmode CASH");

		select("CASH", OLtrans.selectcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash' dropdown");
		Log.info("Step:01 - Select Trans. Mode 'Cash' dropdown");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'Cash'");
		Log.info("Step:01 - Select  'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transmode 'CASH' is selected..");
		Log.info("Expected Result:Transmode 'CASH' is selected..");
		ExtentTestManager.endTest();

		ScrollUntilElementVisible(OLtrans.scrolldwn);

		ExtentTestManager.startTest("Submit Button Navigation ");
		Log.info("Submit Button Navigation");

		click(OLtrans.submittrans);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Click submit button.");
		Log.info("Step:01 - Redirects to summary page.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User navigates to summary page.");
		Log.info("Expected Result:User navigates to summary page");
		ExtentTestManager.endTest();

		

		AcceptAlert();
		
		

		transId = driver.findElement(OLtrans.TransIID).getText();
	}


}
