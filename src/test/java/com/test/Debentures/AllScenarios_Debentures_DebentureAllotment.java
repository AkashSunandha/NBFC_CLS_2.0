package com.test.Debentures;
import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_Debenture .Debenture_DebentureAllotment;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.Page_Debenture .Debenture_DebentureAllotment;
import com.Page_Debenture.Debenture_DebentureAllotment;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Debenture_DebentureAllotment;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;

public class AllScenarios_Debentures_DebentureAllotment extends Base_Class {
		
	com.Utility.ExcelReader ExcelReader;
	
	Base_Class Base_Class;
	
	Log log;
	
	TestListener TestListener; 
	
	com.Utility.ScreenShot screenShot;
	
	//PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	//com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	//Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();
	
	PageRepositary_Debenture_DebentureAllotment DebtAllot = new PageRepositary_Debenture_DebentureAllotment();
	
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	//com.Page_Debenture.Debenture_DebentureAllotment debtallotMthds = new com.Page_Debenture .Debenture_DebentureAllotment();
	
	Debenture_DebentureAllotment debtallotMthds  = new Debenture_DebentureAllotment ();


	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("DebentureAllotment");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	
	}
	@Test(dataProvider = "TestData")
	public void Debenture(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
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
				Thread.sleep(2000);
				
			

				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
				
			
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				//TC No. - 03 --> Debenture Window
				
				debtallotMthds.navigateToDebenture();
				
				debtallotMthds.branchdropdown();
				
				debtallotMthds.debenturetypedropdown();
				
			
				
				
				
				
				
				
				
				
				// EndTest
//				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}	
		
		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
        	Log.info("Exception "+e);
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
