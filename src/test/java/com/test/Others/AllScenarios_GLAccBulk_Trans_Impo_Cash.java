package com.test.Others;

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

public class AllScenarios_GLAccBulk_Trans_Impo_Cash {
	public String TransactionId;
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_Others.GLAccBulkTransactionImportCash GLBlkTrnImpCash = new com.Page_Others.GLAccBulkTransactionImportCash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
//	LoanOpening_DepositOpn_DepositLoan bondCumulativeMthds = new LoanOpening_DepositOpn_DepositLoan();
//	LoanOpening_LoanAndAdvances_PersonalLoanWeekly personl = new LoanOpening_LoanAndAdvances_PersonalLoanWeekly();
//	GeneralOpening_SuspenseAsset generalOpnMthds = new GeneralOpening_SuspenseAsset();
//Silpa
	
	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("GLaccBulkTransImport");
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
				ExtentTestManager.startTest("TC003 - Navigate to GL A/C Bulk Transaction import");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean AccessGLAccBlkTransImp = true;
				try {
					AccessGLAccBlkTransImp = GLBlkTrnImpCash.AccessGLAccBlkTransImp();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to GL A/C Bulk Transaction Import" + AccessGLAccBlkTransImp);
				ExtentTestManager.getTest().log(Status.PASS,"User is navigated to GL A/C Bulk Transaction Import page successfully" + AccessGLAccBlkTransImp);
				ExtentTestManager.endTest();
				
				
				//TC004
				ExtentTestManager.startTest("TC004 - Download Sample File");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean DownloadSampleFile = true;
				try {
					DownloadSampleFile = GLBlkTrnImpCash.DownloadSampleFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Downloading Sample File" + DownloadSampleFile);
				ExtentTestManager.getTest().log(Status.PASS,"Sample File is downloaded" + DownloadSampleFile);
				ExtentTestManager.endTest();
				
				
				//TC005
				ExtentTestManager.startTest("TC005 :Browse Sample File");
				//boolean Login =  MeansOfFinance_Module.login();
				boolean SelectSampleFile = GLBlkTrnImpCash.SelectSampleFile();
				ExtentTestManager.getTest().log(Status.PASS , "Browse File" + SelectSampleFile);
				ExtentTestManager.endTest();
				
				
				//TC006
				ExtentTestManager.startTest("TC006 - Upload File");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean UploadFile = true;
				try {
					UploadFile = GLBlkTrnImpCash.UploadFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Uploading File" + UploadFile);
				ExtentTestManager.getTest().log(Status.PASS,"File is uploaded" + UploadFile);
				ExtentTestManager.endTest();
				
				
				//TC007
				ExtentTestManager.startTest("TC007 - Submit transaction");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SelectTransactionmode = true;
				try {
					SelectTransactionmode = GLBlkTrnImpCash.SelectTransactionmode();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Summary is generated for authorization." + SelectTransactionmode);
				ExtentTestManager.getTest().log(Status.PASS,"Summary is generated for authorization." + SelectTransactionmode);
				ExtentTestManager.endTest();
				
				//TC008
				GLBlkTrnImpCash.Signout(testdata, context);
				
				//TC009
				GLBlkTrnImpCash.signinforauthorisation(testdata, context);
				
				//TC010
				ExtentTestManager.startTest("TC010 - Navigate to Cashier authorisation");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean CashierAuthorisation = true;
				try {
					CashierAuthorisation = GLBlkTrnImpCash.CashierAuthorisation();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to cashier authorisation" + CashierAuthorisation);
				ExtentTestManager.getTest().log(Status.PASS,"User is navigated to cashier authorisation" + CashierAuthorisation);
				ExtentTestManager.endTest();
				
				
				
				//TC011
				ExtentTestManager.startTest("TC011 - Refresh the page");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Refresh = true;
				try {
					Refresh = GLBlkTrnImpCash.Refresh();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to refresh the page" + Refresh);
				ExtentTestManager.getTest().log(Status.PASS,"The page is refreshed" + Refresh);
				ExtentTestManager.endTest();
				
				
				//TC012
				 ExtentTestManager.startTest("TC012 - Select checkbox of the transaction Id");
					boolean Selectuploadedfile = GLBlkTrnImpCash.Selectuploadedfile(TransactionId);
					ExtentTestManager.getTest().log(Status.PASS,"Enter Transaction Id and serach" + Selectuploadedfile);
					ExtentTestManager.getTest().log(Status.PASS,"Select checkbox of the transaction Id" +Selectuploadedfile );
					ExtentTestManager.endTest();
				
					
					
					
				//TC013
					ExtentTestManager.startTest("TC013 - Click on the authorize");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean Authorize = true;
					try {
						Authorize = GLBlkTrnImpCash.Authorize();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Authorize the summary" + Authorize);
					ExtentTestManager.getTest().log(Status.PASS,"Excel bulk import entry is authorised" + Authorize);
					ExtentTestManager.endTest();
					
					
					
					//TC014
					ExtentTestManager.startTest("TC014 - Navigate to Manager authorisation");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean ManagerAuthorisation = true;
					try {
						ManagerAuthorisation = GLBlkTrnImpCash.ManagerAuthorisation();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to manager authorisation" + ManagerAuthorisation);
					ExtentTestManager.getTest().log(Status.PASS,"User is navigated to manager authorisation" + ManagerAuthorisation);
					ExtentTestManager.endTest();
					
					
					//TC015
					ExtentTestManager.startTest("TC015 - Click on the cash");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean Cashtab = true;
					try {
						Cashtab = GLBlkTrnImpCash.Cashtab();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Cash tab will be display" + Cashtab);
					ExtentTestManager.getTest().log(Status.PASS,"Cash tab displayed " + Cashtab);
					ExtentTestManager.endTest();
					
					
					
					
					//TC016
					ExtentTestManager.startTest("TC016 - Click on the refresh");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean Refresh2 = true;
					try {
						Refresh2 = GLBlkTrnImpCash.Refresh2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Attempt to refresh the pagey" + Refresh2);
					ExtentTestManager.getTest().log(Status.PASS,"The page is refreshed " + Refresh2);
					ExtentTestManager.endTest();
					
					
					
					//TC017
					ExtentTestManager.startTest("TC017 - Select checkbox of the transaction Id");
					boolean Selectuploadedfile2 = GLBlkTrnImpCash.Selectuploadedfile2(TransactionId);
					ExtentTestManager.getTest().log(Status.PASS,"Enter Transaction Id and serach" + Selectuploadedfile2);
					ExtentTestManager.getTest().log(Status.PASS,"Select checkbox of the transaction Id" +Selectuploadedfile2 );
					ExtentTestManager.endTest();
				
					//TC018
					ExtentTestManager.startTest("TC018 - Click on the authorize");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean Authorize2 = true;
					try {
						Authorize2 = GLBlkTrnImpCash.Authorize2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Attempt to authorize the summary" + Authorize2);
					ExtentTestManager.getTest().log(Status.PASS,"The summary is authorized " + Authorize2);
					ExtentTestManager.endTest();
					
				
				
				
				
				
				//TC019
					ExtentTestManager.startTest("TC019 - Signout the application");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean SignOut2 = true;
					try {
						SignOut2 = GLBlkTrnImpCash.SignOut2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Attempt to signout" + SignOut2);
					ExtentTestManager.getTest().log(Status.PASS,"The user is signed out" + SignOut2);
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

			
		
		
		
	
			
	
			