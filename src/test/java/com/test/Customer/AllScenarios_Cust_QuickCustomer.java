package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_QuickCustomer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Cust_QuickCustomer extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	Customer_QuickCustomer quickCustomerAllMthds = new Customer_QuickCustomer();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_QuickCustomer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	@Test(dataProvider = "TestData")
	public void quickCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);
				
				
				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				quickCustomerAllMthds.openQuickCustomerWindow();
				
				quickCustomerAllMthds.emptyCheckAvailabilityPopup();

				quickCustomerAllMthds.referredBy();
				
				quickCustomerAllMthds.quickAccDetails(testdata, context);
				
				quickCustomerAllMthds.presentAddress(testdata, context);
				
				quickCustomerAllMthds.permanentAddress();
				
				quickCustomerAllMthds.introducer(testdata, context);

				quickCustomerAllMthds.introducerSelectCust(testdata, context);
				
				quickCustomerAllMthds.identityAndArea(testdata, context);

				quickCustomerAllMthds.photoAndSign(testdata, context);
				
				quickCustomerAllMthds.photoAndSignEntryPersistence();
				
				quickCustomerAllMthds.bankAccounts(testdata, context);

				quickCustomerAllMthds.riskDetails(testdata, context);

				quickCustomerAllMthds.riskDetailsEmptyRemarksField(testdata, context);

				quickCustomerAllMthds.checkAvailability();

				quickCustomerAllMthds.authorize();

				

				Thread.sleep(4000);
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
