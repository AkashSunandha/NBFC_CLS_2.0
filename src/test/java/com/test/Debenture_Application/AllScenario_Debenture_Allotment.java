package com.test.Debenture_Application;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_DebentureApplication.Debenture_Allotment;
import com.Pages_DebentureApplication.Debenture_Application_Cashflow;
import com.Pages_DebentureApplication.Debenture_Application_Transferflow;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.github.dockerjava.api.model.Driver;
import com.listeners.TestListener;

public class AllScenario_Debenture_Allotment extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Debenture_Application_Transferflow DebApp = new Debenture_Application_Transferflow();
	Debenture_Allotment DebeAllot = new Debenture_Allotment();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Debenture_Allotment");

		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void customerRegister( Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				//				ExtentTestManager.endTest();


				//Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();


				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);


				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				//Precondition 
				DebeAllot.Precondition(testdata, context);


				DebeAllot.NavigateToDebenture_Allotment();


				DebeAllot.SelectAllotmentBranch();


				DebeAllot.SelectDebentureType();


				DebeAllot.SelectIssueType();


				DebeAllot.SelectDebentureSeries();


				DebeAllot.SelectAllotmentStatus();


				DebeAllot.ClickOnAllotmentSearch();



				DebeAllot.ClickOnAllotmentProcess();


				DebeAllot.Verify_Debenture_Allotment_Process_Completion();

				DebeAllot.authorizeTransfer(testdata, context);

				DebeAllot.Signout();

				DebeAllot.Signin();
				/////////////////

				DebeAllot.PreconditionCash(testdata, context);


				DebeAllot.NavigateToDebenture_Allotment();


				DebeAllot.SelectAllotmentBranch();


				DebeAllot.SelectDebentureTypeCash();


				DebeAllot.SelectIssueTypeCash();


				DebeAllot.SelectDebentureSeriesCash();


				DebeAllot.SelectAllotmentStatus();


				DebeAllot.ClickOnAllotmentSearch();				


				DebeAllot.ClickOnAllotmentReturn();

				DebeAllot.ClickOnAllotmentReturnSubmit();

				DebeAllot.authorizeCash1(testdata, context);

				//Sign out
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

