package com.test.Closure_and_Renewals;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
//import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening;
import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening_Cash;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Loan_Closure_Cash extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	//Customer_MultipleFD_Opening_Cash multifd = new Customer_MultipleFD_Opening_Cash();
	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Page_Closure_and_Renewals.Loan_Closure_Cash LoanClosureCash = new com.Page_Closure_and_Renewals.Loan_Closure_Cash();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Closure_and_Renewals_Cash");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void Loan_Closure_Cash(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch for Loan Closure Cash");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				LoanClosureCash.pcRegistration__Loan_Closure_Cash(testdata, context);

				// TC_01 ---> Login to NBFC Application
				multifdCash.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Access Deposit Opening Window
				multifdCash.DepositOpeningWindow();

				// TC_03 -----> Customer Search and Selection
				multifdCash.customerSearchandSelectionWindow(testdata, context);
				
								
				// Sign out
				Thread.sleep(3000);
				custSrchMthds.logout();

				// EndTest
				// ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();

			}
		} catch (Exception e) {
			System.out.println(e);
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
