package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_NewCustomer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Cust_NewCustomer extends Base_Class{

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	@BeforeClass
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_NewCustomer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	
	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("NewCustomer");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch").assignCategory("NewCustomer");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);
				
				
				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				newCustMths.openNewCustomerWindow();
				
				newCustMths.alphabeticAndNumericFieldRestrictionCheck(testdata, context);

				newCustMths.personal(testdata, context);

				newCustMths.address(testdata, context);

				newCustMths.introducer(testdata, context);
				
				newCustMths.identityAndArea(testdata, context);

				newCustMths.family(testdata, context);

				newCustMths.bankAccDetails(testdata, context);

				newCustMths.visits(testdata, context);

				newCustMths.riskAndOtherDetails(testdata, context);

				newCustMths.photoSign(testdata, context);
				
				newCustMths.authorize();				
				
				custSrchMthds.logout();
				
				

				


				
			// EndTest
				ExtentTestManager.endTest();
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
