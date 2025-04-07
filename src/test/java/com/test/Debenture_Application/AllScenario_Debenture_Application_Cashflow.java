package com.test.Debenture_Application;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_DebentureApplication.Debenture_Application_Cashflow;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.github.dockerjava.api.model.Driver;
import com.listeners.TestListener;

public class AllScenario_Debenture_Application_Cashflow {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	Debenture_Application_Cashflow DebApp = new Debenture_Application_Cashflow();
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Debenture_Application");
		
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
				
				 //TC 01
				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
			
			    //TC 02
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				//TC 11
				DebApp.Select_Debenture_Type();
				
				//TC 12
				DebApp.Select_Debenture_Issue();
				
				//TC 13
				DebApp.Select_Series_Type();
				
				//TC 14
				 
				//TC 15
				DebApp.Se
				
				//TC 03
				DebApp.AddcustomerviacustID(testdata, context);
				
				/* //Sign out
				custSrchMthds.logout(); */
				
				
				// EndTest
			ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
            Log.info("Exception "+e);
            ExtentTestManager.endTest();
            
         // Logout
         			context.setAttribute("fileName", "Logout");
         			Driver driver = new Driver();
					driver.wait();
         			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
         			Log.info("Logout is done");

         			// EndTest
         			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
         			ExtentTestManager.endTest();
         			ExtentManager.getInstance().flush();
         			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
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

