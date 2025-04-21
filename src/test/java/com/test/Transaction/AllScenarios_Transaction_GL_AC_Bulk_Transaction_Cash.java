package com.test.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_ClosureAndRenewals.ClosureAndRenewals_FD_Closure;
import com.Page_Transaction.Transaction_GL_AC_Bulk_Transaction;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Suspense_liability;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Transaction_GL_AC_Bulk_Transaction_Cash extends Base_Class {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Transaction_Transactions_Suspense_liability transSusliability = new Transaction_Transactions_Suspense_liability();
	Transaction_GL_AC_Bulk_Transaction transGL_AC_Bulk =new Transaction_GL_AC_Bulk_Transaction();
	ClosureAndRenewals_FD_Closure FD_Closure =new ClosureAndRenewals_FD_Closure();

	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("GL_AC_Bulk_Transaction");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}


	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()+"-Cash");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				transGL_AC_Bulk.Navigate_GL_AC_Bulk_Transaction();

				transGL_AC_Bulk.GLccountinfo(testdata, context);

				transGL_AC_Bulk.GLccountinfoDebit(testdata, context);

				transGL_AC_Bulk.transModeCash();

				transGL_AC_Bulk.authorizeCash(testdata, context);

				custSrchMthds.logout();


				// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");
			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentErrorMessage("Test Failed");
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentErrorMessage("Test Failed");
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();
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
