package com.test.ProcessingAndPosting;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
//import Others.GLAccBulkTransactionImportCash;
//import com.Page_AccountOpening.LoanOpening_DepositOpn_DepositLoan;
//import com.Page_AccountOpening.LoanOpening_LoanAndAdvances_PersonalLoanWeekly;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_DayEnd {
	
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_ProcessingandPosting.DayEnd DayEnd = new com.Page_ProcessingandPosting.DayEnd();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
//	LoanOpening_DepositOpn_DepositLoan bondCumulativeMthds = new LoanOpening_DepositOpn_DepositLoan();
//	LoanOpening_LoanAndAdvances_PersonalLoanWeekly personl = new LoanOpening_LoanAndAdvances_PersonalLoanWeekly();
//	GeneralOpening_SuspenseAsset generalOpnMthds = new GeneralOpening_SuspenseAsset();
//	
	
	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("DayEnd");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	
	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest("AccountOpening_GeneralOpening_SuspenseAsset_CASH");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
//				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);
				
				custSrchMthds.pcRegistration(testdata, context);
				
				//TC002
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				
				
				
			//TC003
				ExtentTestManager.startTest("TC003 - Navigate to Branch Day Closing");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean AccessBranchDayClosing = true;
				try {
					AccessBranchDayClosing = DayEnd.AccessBranchDayClosing();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to Branch Day Closing Page" + AccessBranchDayClosing);
				ExtentTestManager.getTest().log(Status.PASS,"User is navigated to Branch Day Closing Page successfully" + AccessBranchDayClosing);
				ExtentTestManager.endTest();
				
				
				
				//TC004
				ExtentTestManager.startTest("TC004 - Start Processing");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean StartProcessing = true;
				try {
					StartProcessing = DayEnd.StartProcessing();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the Start Processing" + StartProcessing);
				ExtentTestManager.getTest().log(Status.PASS,"Pop-up for 'Start Day End?' appears" + StartProcessing);
				ExtentTestManager.endTest();
				
				
				
				
			//TC005
				com.BasePackage.Base_Class.AcceptAlert();
				ExtentTestManager.endTest();
				Thread.sleep(2000);
				
				
				
				//TC006
				ExtentTestManager.startTest("TC006 - Verify yellow icons");
				boolean YellowIcon = true;
				try {
					YellowIcon = DayEnd.YellowIcon();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Yellow icon visible " + YellowIcon);
				ExtentTestManager.getTest().log(Status.PASS,"Day end can proceed" + YellowIcon);
				Thread.sleep(2000);
				ExtentTestManager.endTest();
				
				
				
				//TC007
				Thread.sleep(9000);
				com.BasePackage.Base_Class.AcceptAlert();
				ExtentTestManager.endTest();
				Thread.sleep(2000);
				
			
				
				
				
				//TC008
				ExtentTestManager.startTest("TC008- Click on the Submit");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Submit = true;
				try {
					Submit = DayEnd.Submit();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the Submit" + Submit);
				ExtentTestManager.getTest().log(Status.PASS,"Success message: 'Day End Process at MAIN BRANCH Branch Successfully Completed!'" + Submit);
				ExtentTestManager.endTest();
				
				
			
				
				
				
				
				
				
				
				
				
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

			


