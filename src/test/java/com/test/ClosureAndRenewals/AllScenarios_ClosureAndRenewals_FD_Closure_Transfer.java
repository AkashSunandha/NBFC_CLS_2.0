package com.test.ClosureAndRenewals;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_ClosureAndRenewals.ClosureAndRenewals_FD_Closure;
import com.Page_Transaction.Transaction_GL_AC_Bulk_Transaction;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Suspense_liability;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_ClosureAndRenewals_FD_Closure_Transfer {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	ClosureAndRenewals_FD_Closure FD_Closure =new ClosureAndRenewals_FD_Closure();

	@BeforeClass
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("FD_Closure");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}


	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()+"-Transfer").assignCategory("FD Closure -Transfer");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				FD_Closure.Navigate_GL_AC_Bulk_Transaction();
				
				FD_Closure.SelectBranch();
				
				FD_Closure.SelectProductGroup();
				
				FD_Closure.SelectProductName();
				
				FD_Closure.EnterAccountNumber();
				
				FD_Closure.	ClickOnGoButton();
				
				FD_Closure.transModeTransfer(testdata, context);
				
				FD_Closure.ClickonSubmit_TransactionButton();
				
				FD_Closure.authorizeTransfer(testdata, context);

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
