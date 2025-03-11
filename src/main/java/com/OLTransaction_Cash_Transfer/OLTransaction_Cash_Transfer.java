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

	public String sp = "GetJewelloanAccountnumber";
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

		click(OLtrans.clickTranswindow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate through Path: Transaction: Transactions.");
		Log.info("Step:01 -  Navigate through Path: Transaction: Transactions.");

		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");

		select("OTHER LOANS", OLtrans.productgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Other Loan from Product Group..");
		Log.info("Step:01 - Select Other Loan from Product Group..");

		select("AUTO LOAN", OLtrans.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02- Select any product name..");
		Log.info("Step:02- Select any product name..");
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

		ExtentTestManager.startTest("Select Transaction Type CREDIT");
		Log.info("Select Transaction Type CREDIT");

		select("Credit", OLtrans.selectcredit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- Select transtype 'CREDIT'.");
		Log.info("Step:1-Select transtype 'CREDIT'.");

		ExtentTestManager.startTest("GO Button Interaction");
		Log.info("GO Button Interaction");
		
		click(OLtrans.clickGoo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Go button");
		Log.info("Step:01 -Click on Go button");

		ExtentTestManager.startTest("Warning Validation Popup window");
		Log.info("Warning Validation Popup window");

		click(JewelClosure.ClickNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter No in the warning validation popup window");
		Log.info("Step:01 -Enter No in the warning validation popup window");

	}
}