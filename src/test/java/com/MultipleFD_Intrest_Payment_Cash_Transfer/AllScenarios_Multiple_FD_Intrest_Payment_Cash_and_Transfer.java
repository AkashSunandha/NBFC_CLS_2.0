package com.MultipleFD_Intrest_Payment_Cash_Transfer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Agent_Transfer.Agent_Transfer;
import com.BasePackage.Base_Class;
import com.JewelLoan_Closure.JewelLoan_Closure_Cash_Transfer;
import com.OLTransaction_Cash_Transfer.Multiple_FD_Intrest_Payment_Cash_and_Transfer;
import com.OLTransaction_Cash_Transfer.OLTransaction_Cash_Transfer;
import com.OLTransaction_Cash_Transfer.OL_Transaction_Closure_Cash_Transfer;
import com.OLTransaction_Cash_Transfer.SusAssetTransaction_Cash_Transfer;
import com.Page_Customer.Customer_NewCustomer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Multiple_FD_Intrest_Payment_Cash_and_Transfer {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	JewelLoan_Closure_Cash_Transfer JLoanClosure = new JewelLoan_Closure_Cash_Transfer();
	OLTransaction_Cash_Transfer Transaction = new OLTransaction_Cash_Transfer();
	OL_Transaction_Closure_Cash_Transfer Closuretrans = new OL_Transaction_Closure_Cash_Transfer();
	SusAssetTransaction_Cash_Transfer suspense = new SusAssetTransaction_Cash_Transfer();
	Multiple_FD_Intrest_Payment_Cash_and_Transfer FD = new Multiple_FD_Intrest_Payment_Cash_and_Transfer();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("MultipleFD");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info(" Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);

				FD.NavigatetoMultipleFDInterestPayment();

				FD.selectProductGroup();

				FD.selectProductName();

				FD.enterAccountNumber();

				FD.checkDisplayAllAccounts1();

				FD.checkDisplayAllAccounts();

				FD.checkInterestPaymentDetailsGrid(testdata, context);
               
				//FD.enterAccountNumber();
				
				FD.enterAccountNumberr();

				FD.checkDisplayAllAccounts();

				FD.selectAnotherAccountForInterestPayment(testdata, context);

				FD.submitPaymentCashMode();

				FD.verifySubmissionSummary();

				suspense.logoutApplication1();

				Closuretrans.AnotherUSer(testdata, context);

				FD.managerauthorisation();

				FD.UserloggedManagerauthorization();

				FD.UserloggedManagerauthorization2();

				FD.UseronManagerauthorisationwindow();

				FD.cashierauthorization();

				FD.cashierauthorization1();

				FD.cashierauthorization2();

				FD.UserisonCashierauthorisationwindow();

				FD.logoutApplication4();

				// Transfer

				custSrchMthds.userLoginValidPaswrd(testdata, context);

				FD.NavigatetoMultipleFDInterestPayment1();

				FD.selectProductGroup();

				FD.selectProductName();

				FD.enterAccountNumber();

				FD.checkDisplayAllAccounts1();

				FD.checkDisplayAllAccounts();

				FD.checkInterestPaymentDetailsGrid(testdata, context);

				FD.enterAccountNumberr();

				FD.checkDisplayAllAccounts();

				FD.selectAnotherAccountForInterestPayment1(testdata, context);

				FD.submitPaymenttransferMode();

				FD.postDebitTransaction();

				FD.searchAccountNumber(testdata, context);

				FD.selectAccountNumber(testdata, context);

				FD.addTransactionAmount1();

				FD.addTransactionAmount();

				FD.submitTransactionWindow();

				suspense.logoutApplication1();

				Closuretrans.AnotherUSer(testdata, context);

				FD.managerauthorisation1();

				FD.UserLoggedIntransfer();

				FD.UserloggedManagerauthorization();

				FD.UserLoggedInCheckbx1();

				FD.UseronManagerauthorisationwindow();

				FD.logoutApplication5();

				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
			Log.info("Exception " + e);
			ExtentTestManager.endTest();
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}

}