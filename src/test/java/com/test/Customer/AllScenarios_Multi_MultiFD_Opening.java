package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_Customer.Customer_MultipleFD_Opening;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Multi_FD_Module;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Multi_MultiFD_Opening extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	// PageRepositary_Cust_CustRegister custRgstr = new
	// PageRepositary_Cust_CustRegister();

	Customer_MultipleFD_Opening multifd = new Customer_MultipleFD_Opening();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	// Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Multiple_FD");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void Multi_MultiFD_Opening(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> User Login
				multifd.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Deposit Opening Window
				multifd.DepositOpeningWindow();

				// TC_03 -----> Customer Search and Selection
				multifd.customerSearchandSelectionWindow(testdata, context);
				
				//TC_04 ----> EnterAmount
				multifd.EnterAmount(testdata, context);

				// TC_05 ----> EnterValidDuration
				multifd.EnterValidDuration(testdata, context);

				// TC_06 ----> SelectReferral
				multifd.SelectReferral();

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
