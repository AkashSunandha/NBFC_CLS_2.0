package com.test.JewelLoanClosure;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.GeneralOpening.General_Opening_cash_transfer;
import com.JewelLoan_Closure.JewelLoan_Closure_Cash_Transfer;
import com.Page_Customer.Customer_NewCustomer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenario_JewelLoan_Closure_Cash_Transfer {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	public String sp = "GetJewelloanAccountnumber";
	public String columnName = "Acno";

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	General_Opening_cash_transfer generalOpening = new General_Opening_cash_transfer();
	JewelLoan_Closure_Cash_Transfer JLoanClosure = new JewelLoan_Closure_Cash_Transfer();
	

	@BeforeClass
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("JewelClosure");
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
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("GoldLoanClosure-Cash&Transfer");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);

				JLoanClosure.Closurerenewal();

				JLoanClosure.Accountnumber(testdata, context);
				
				JLoanClosure.Cash(testdata, context);

				JLoanClosure.Signout();

				JLoanClosure.AnotherUSer(testdata, context);

				JLoanClosure.Cashier();

				JLoanClosure.Manager();

				JLoanClosure.Signout();

				custSrchMthds.userLoginValidPaswrd(testdata, context);

				JLoanClosure.ClosurerenewalTrasnfer();

				JLoanClosure.Accountnumber(testdata, context);

				JLoanClosure.Transfer(testdata, context);

				JLoanClosure.Accountnumber2(testdata, context);

				JLoanClosure.Signout();

				JLoanClosure.AnotherUSer(testdata, context);

				JLoanClosure.ManagerAuth();

				JLoanClosure.Signout();

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