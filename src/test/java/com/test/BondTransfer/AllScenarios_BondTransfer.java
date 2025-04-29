package com.test.BondTransfer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_BondTransfer.BondTransfer_mainpage;
import com.Page_Customer.Customer_QuickCustomer;
import com.Page_Repositary.PageRepositary_BondTransfer;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_BondTransfer extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	
	//PageRepositary_BondTransfer bondtr = new PageRepositary_BondTransfer();
	
	BondTransfer_mainpage bondtrMthds = new BondTransfer_mainpage();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	@BeforeSuite
	public void reference() 
	{
		ExcelReader = new com.Utility.ExcelReader("BondTransfer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	@Test(dataProvider = "TestData")
	
	public void bondtransfer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException
	{
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

				//	TC No. - 01 --> Bond transfer Window
				bondtrMthds.bondtransferWindow();
				
				//TC No. - 02 --> Select a branch from Dropdown
				bondtrMthds.selectbranch();
				
				//TC No. - 04 --> Select a product from Dropdown
				bondtrMthds.selectproduct();
				
				//TC No. - 05 --> Enter account  number
				bondtrMthds.accno(testdata, context);
				
				//TC Navigating to customer search window
				bondtrMthds.searchcust();
				
				//TC No. 06 --> Passing Customer search window datas
				bondtrMthds.searchcustdatas(testdata, context);
				
				//Authorisation
				bondtrMthds.authorizeCash(testdata, context);
				
				
				
				//Sign out
				Thread.sleep(3000);
				bondtrMthds.logout();   
				
				ExtentManager.getInstance().flush();
			}		
		}
		catch(Exception e) {
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
