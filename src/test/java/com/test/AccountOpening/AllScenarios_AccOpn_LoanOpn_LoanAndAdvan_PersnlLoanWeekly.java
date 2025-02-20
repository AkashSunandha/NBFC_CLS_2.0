package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.LoanOpening_JewelLoan_GoldLoan;
import com.Page_AccountOpening.LoanOpening_LoanAndAdvances_PersonalLoanWeekly;
import com.Page_Customer.Customer_NewCustomer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly extends Base_Class{


	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	LoanOpening_JewelLoan_GoldLoan goldLoanMths = new LoanOpening_JewelLoan_GoldLoan();
	LoanOpening_LoanAndAdvances_PersonalLoanWeekly prsnlLoanWeeklyMthds = new LoanOpening_LoanAndAdvances_PersonalLoanWeekly();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("AccOpn_LoanAdva_PersnlLoanWeek");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	
	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
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
				
				
				
				//Tran.Mode - CASH
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				prsnlLoanWeeklyMthds.openPersonalLoanWindow();
				
				prsnlLoanWeeklyMthds.accInfo(testdata, context);

				prsnlLoanWeeklyMthds.personalSureties(testdata, context);
				
				prsnlLoanWeeklyMthds.nominee(testdata, context);
				
				prsnlLoanWeeklyMthds.loanDetailsCash(testdata, context);

				prsnlLoanWeeklyMthds.authorizeCash(testdata, context);			
				
				custSrchMthds.logout();

				
				//Tran.Mode - TRANSFER
				Base_Class.SetUp();
				
				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				prsnlLoanWeeklyMthds.openPersonalLoanWindow();
				
				prsnlLoanWeeklyMthds.accInfo(testdata, context);

				prsnlLoanWeeklyMthds.personalSureties(testdata, context);
				
				prsnlLoanWeeklyMthds.nominee(testdata, context);
				
				prsnlLoanWeeklyMthds.loanDetailsTransfer(testdata, context);

				prsnlLoanWeeklyMthds.authorizeTransfer(testdata, context);
				
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
