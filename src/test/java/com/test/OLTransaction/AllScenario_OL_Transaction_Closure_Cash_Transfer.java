package com.test.OLTransaction;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.Closure;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.GeneralOpening.General_Opening_cash_transfer;
import com.JewelLoan_Closure.JewelLoan_Closure_Cash_Transfer;
import com.OLTransaction_Cash_Transfer.OLTransaction_Cash_Transfer;
import com.OLTransaction_Cash_Transfer.OL_Transaction_Closure_Cash_Transfer;
import com.Page_Customer.Customer_NewCustomer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenario_OL_Transaction_Closure_Cash_Transfer {
	
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	public String sp = "GetOtherloanAccountnumberForTransaction";
	public String columnName = "Acno";

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	General_Opening_cash_transfer generalOpening = new General_Opening_cash_transfer();
	JewelLoan_Closure_Cash_Transfer JLoanClosure = new JewelLoan_Closure_Cash_Transfer();
	OLTransaction_Cash_Transfer Transaction = new OLTransaction_Cash_Transfer();
	OL_Transaction_Closure_Cash_Transfer Closuretrans = new OL_Transaction_Closure_Cash_Transfer();
	
	@BeforeClass
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("TransactionClosure");
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
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("OtherLoanClosure-Cash&Transfer");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				Closuretrans.Closure();
				
				Closuretrans.Accountnumber(testdata, context);
				
				Closuretrans.Cash(testdata, context);
				
				Closuretrans.Signout();
				
				Closuretrans.AnotherUSer(testdata, context);
				
				Closuretrans.Cashier();
				
				Closuretrans.Manager();
				
				Closuretrans.Signout2();
				
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				Closuretrans.ClosurerenewalTrasnfer1();
				
				Closuretrans.Accountnumber(testdata, context);
				
				Closuretrans.Transfer1(testdata, context);
				
				Closuretrans.Accountnumbers(testdata, context);
				
				Closuretrans.Signout();
				
				Closuretrans.AnotherUSer(testdata, context);
				
				Closuretrans.ManagerAuth();
				
				Closuretrans.Signout1();
				
				
				
				
				
				
				

			

				
				
				
				
				

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
