package com.test.Day_Begin_Module;

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
import com.Pages_Day_Begin.Day_Begin_Module;
import com.Pages_Jewel_Loan_Transcharge_Module.Jewel_Loan_Transcharge_Cash;
import com.Pages_Share_Transfer.Share_Transfer_Module;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

import Pages_GL_Account_Transaction_Module.GL_Account_Transaction_Cash;

public class AllScenarios_Day_Begin extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Day_Begin_Module dayBegin = new Day_Begin_Module();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Day_Begin");
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
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> Login to NBFC Application
				dayBegin.AdminLogin();
				
				//TC_02 ---> OpenDayBeginWindow
				dayBegin.OpenDayBeginWindow();
				
				//TC_03 ---> StartDayBeginProcess
				dayBegin.StartDayBeginProcess();
				
				//TC_04 ---> ConfirmStartDayBeginProcess
				dayBegin.ConfirmStartDayBeginProcess();
				
				//TC_05 ---> CompleteDayBeginProcess
				dayBegin.CompleteDayBeginProcess();
				
				//TC_06 ---> UserLogin
				dayBegin.UserLogin();
				
				//TC_07 ---> OpenDayBeginWindowasUser
				dayBegin.OpenDayBeginWindowasUser();
				
				//TC_08 ---> StartDayBeginasUser
				dayBegin.StartDayBeginasUser();
				
				//TC_09 ---> ConfirmStartDayBeginasUser
				dayBegin.ConfirmStartDayBeginasUser();
				
				//TC_10 ---> CompleteUserDayBegin
				dayBegin.CompleteUserDayBegin();
				
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
