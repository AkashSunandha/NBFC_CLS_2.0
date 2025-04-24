package com.test.Admin;



import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Admin.Debenture_Issue_Setting;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.github.dockerjava.api.model.Driver;


public class AllScenario_Admin_Debenture_Issue_Setting {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	Debenture_Issue_Setting Debenture = new Debenture_Issue_Setting();
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Debenture_Issue_setting");
		
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
				Debenture.userLoginValidPaswrd(testdata, context);
				
				 //TC 03
				Debenture.Clickcontinue();
				
				//TC 04 (invalid)
				
				//TC 05
				Debenture.Navigate_to_debenture_issue_settings();
				
				//TC 06
				Debenture.Select_Debenture_Type_From_Dropdown();
				
				//TC 07 
				
				Debenture.Verify_Issue_Name();
				
				//TC 08
				Debenture.Enter_Issue_From_Date(testdata, context);
				
				//Tc 09
				Debenture.Verify_Issue_To_Date(testdata, context);
				
				//TC 10
				Debenture.Enter_Unit_Value(testdata, context);
				
				//TC 11
				Debenture.Enter_Return_ROI(testdata, context);
				
				//TC 12
				Debenture.Verify_IsActive_Checkbox();
				
				//Tc 13
				Debenture.Enter_Call_Date(testdata, context);
				
				//TC 14
				Debenture.Enter_Put_Date(testdata, context);
				
				//TC 15
				Debenture.Enter_CallDate_Premature_ROI(testdata, context);
				
				//TC 16
				Debenture.Enter_PutDate_Premature_ROI(testdata, context);
				
				//TC 17
				Debenture.Add_Call_and_Put_Details();
				
				//TC 18
				
				Debenture.Submit_Issue_Details();
				
				 //Sign out
				custSrchMthds.logout(); 
			
			
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

		
		
			

