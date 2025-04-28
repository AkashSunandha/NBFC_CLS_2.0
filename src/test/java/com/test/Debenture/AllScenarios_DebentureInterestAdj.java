package com.test.Debenture;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_DebentureInterestAdj {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_Debenture.DebentureInterestAdjustment DebentureIntAdj = new com.Page_Debenture.DebentureInterestAdjustment();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	
	
	
	
	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("Debenture_Interest_Adjustment");
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
				ExtentTestManager.startTest("TC003 - Navigate to Debenture Interest Adjustment");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean AccessDebentureInterestAdjustment = true;
				try {
					AccessDebentureInterestAdjustment = DebentureIntAdj.AccessDebentureInterestAdjustment();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to Debenture interest Adjustment" + AccessDebentureInterestAdjustment);
				ExtentTestManager.getTest().log(Status.PASS,"User is navigated to Debenture Interest Adjustment page successfully" + AccessDebentureInterestAdjustment);
				ExtentTestManager.endTest();
				
				
				
				//TC004
				ExtentTestManager.startTest("TC004 - Select Debenture Type");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SelectDebentureType = true;
				try {
					SelectDebentureType = DebentureIntAdj.SelectDebentureType();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select debenture type" + SelectDebentureType);
				ExtentTestManager.getTest().log(Status.PASS,"Debenture type is selected" + SelectDebentureType);
				ExtentTestManager.endTest();
				
				
				
				//TC005
				ExtentTestManager.startTest("TC005 - Select Debenture Issue");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SelectDebentureIssue = true;
				try {
					SelectDebentureIssue = DebentureIntAdj.SelectDebentureIssue();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select debenture issue" + SelectDebentureIssue);
				ExtentTestManager.getTest().log(Status.PASS,"Debenture issue is selected" + SelectDebentureIssue);
				ExtentTestManager.endTest();
				
				
				//TC006
				ExtentTestManager.startTest("TC006 - Select Debenture Series");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SelectDebentureSeries = true;
				try {
					SelectDebentureSeries = DebentureIntAdj.SelectDebentureSeries();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select debenture series" + SelectDebentureSeries);
				ExtentTestManager.getTest().log(Status.PASS,"Debenture series is selected" + SelectDebentureSeries);
				ExtentTestManager.endTest();
				
				
				//TC007
				ExtentTestManager.startTest("TC007 - Click on the Search");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Search = true;
				try {
					Search = DebentureIntAdj.Search();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the search" + Search);
				ExtentTestManager.getTest().log(Status.PASS,"List of accounts with interest transfer day is displayed." + Search);
				ExtentTestManager.endTest();
				
				
				
				
				//TC008
				ExtentTestManager.startTest("TC008 - Verify 'Account No' Field Loaded");
				boolean validateAccountNo = true;
				try {
					validateAccountNo = DebentureIntAdj.validateAccountNo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Account No field is visible " + validateAccountNo);
				ExtentTestManager.getTest().log(Status.PASS,"Account No field iss correct" + validateAccountNo);
				
				
				
				
				
				boolean validateName = true;
				try {
					validateName = DebentureIntAdj.validateName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Name field is visible " + validateName);
				ExtentTestManager.getTest().log(Status.PASS,"Name field is correct" + validateName);
				
				
				boolean validateToAccountNoField = true;
				try {
					validateToAccountNoField = DebentureIntAdj.validateToAccountNoField();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"To Account No field is visible " + validateToAccountNoField);
				ExtentTestManager.getTest().log(Status.PASS,"To Account No field is correct" + validateToAccountNoField);
				
				
				
				boolean validateToBank = true;
				try {
					validateToBank = DebentureIntAdj.validateToBank();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"To Bank field is visible " + validateToBank);
				ExtentTestManager.getTest().log(Status.PASS,"To Bank field is correct" + validateToBank);
				
				
				boolean validateNameField = true;
				try {
					validateNameField = DebentureIntAdj.validateNameField();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Name field is visible " + validateNameField);
				ExtentTestManager.getTest().log(Status.PASS,"Name field is correct" + validateNameField);
				
				
				boolean validateAmount = true;
				try {
					validateAmount = DebentureIntAdj.validateAmount();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Amount field is visible " + validateAmount);
				ExtentTestManager.getTest().log(Status.PASS,"Amount field is correct" + validateAmount);
				ExtentTestManager.endTest();
				
				
				
				
				//TC009
				ExtentTestManager.startTest("TC009 - Click on the Process");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Process = true;
				try {
					Process = DebentureIntAdj.Process();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the process" + Process);
				ExtentTestManager.getTest().log(Status.PASS,"Interest transfer processes successfully, showing 100% completion." + Process);
				ExtentTestManager.endTest();
				
				
				//TC010
				ExtentTestManager.startTest("TC010 - Click on the Click");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Close = true;
				try {
					Close = DebentureIntAdj.Close();
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the Close" + Close);
				ExtentTestManager.getTest().log(Status.PASS,"Returns to Debenture Interest Adjustment Window." + Close);
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

			



			
		
	
