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

public class AllScenarios_GLAccBulk_Trans_Imp_Transfer {
	public String TransactionId;
	public String NetAmount;
	public String VoucherId;
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	com.Page_Others.GLAccBulkTransactionImportTransfer GLBlkTrnImpTransfer = new com.Page_Others.GLAccBulkTransactionImportTransfer();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
//	LoanOpening_DepositOpn_DepositLoan bondCumulativeMthds = new LoanOpening_DepositOpn_DepositLoan();
//	LoanOpening_LoanAndAdvances_PersonalLoanWeekly personl = new LoanOpening_LoanAndAdvances_PersonalLoanWeekly();
//	GeneralOpening_SuspenseAsset generalOpnMthds = new GeneralOpening_SuspenseAsset();
//	
	
	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("GLaccBulkTransImportTransfer");
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
					AccessGLAccBlkTransImp = GLBlkTrnImpTransfer.AccessGLAccBlkTransImp();
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
					DownloadSampleFile = GLBlkTrnImpTransfer.DownloadSampleFile();
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
				boolean SelectSampleFile = GLBlkTrnImpTransfer.SelectSampleFile();
				ExtentTestManager.getTest().log(Status.PASS , "Browse File" + SelectSampleFile);
				ExtentTestManager.endTest();
				
				
				//TC006
				ExtentTestManager.startTest("TC006 - Upload File");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean UploadFile = true;
				try {
					UploadFile = GLBlkTrnImpTransfer.UploadFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Uploading File" + UploadFile);
				ExtentTestManager.getTest().log(Status.PASS,"File is uploaded" + UploadFile);
				ExtentTestManager.endTest();
				
				
				//TC007
				ExtentTestManager.startTest("TC007 - Select Transaction mode");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SelectTransactionmode = true;
				try {
					SelectTransactionmode = GLBlkTrnImpTransfer.SelectTransactionmode();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select transaction mode." + SelectTransactionmode);
				ExtentTestManager.getTest().log(Status.PASS,"Selected transfer mode." + SelectTransactionmode);
				ExtentTestManager.endTest();
				
				
				//TC008
				ExtentTestManager.startTest("TC008 - Select Post Debit");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean PostDebit = true;
				try {
					PostDebit = GLBlkTrnImpTransfer.PostDebit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the Post debit." + PostDebit);
				ExtentTestManager.getTest().log(Status.PASS,"Auto posting popup window will be opened" + PostDebit);
				ExtentTestManager.endTest();
				
				
				//TC009
				ExtentTestManager.startTest("TC009 - Select transaction based as GL Code");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean GLCode = true;
				try {
					GLCode = GLBlkTrnImpTransfer.GLCode();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select transaction based as GL Code." + GLCode);
				ExtentTestManager.getTest().log(Status.PASS,"GL code related field will be display" + GLCode);
				ExtentTestManager.endTest();
				
				
				//TC010
				ExtentTestManager.startTest("TC010 - Select GL Name");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean GLName = true;
				try {
					GLName = GLBlkTrnImpTransfer.GLName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Select GL name" + GLName);
				ExtentTestManager.getTest().log(Status.PASS,"GL code will be autoloads while selecting the GL Name" + GLName);
				ExtentTestManager.endTest();
				
				
				
				//TC011
				ExtentTestManager.startTest("TC011 - Enter amount");
				boolean EnterAmount = GLBlkTrnImpTransfer.EnterAmount();
				ExtentTestManager.getTest().log(Status.PASS,"Enter Transaction Id and serach" + EnterAmount);
				ExtentTestManager.getTest().log(Status.PASS,"Select checkbox of the transaction Id" +EnterAmount );
				ExtentTestManager.endTest();
			
				
				
				//TC012
				ExtentTestManager.startTest("TC012 - Add post debit");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean AddPostDebitAmount = true;
				try {
					AddPostDebitAmount = GLBlkTrnImpTransfer.AddPostDebitAmount();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Add Amount" + AddPostDebitAmount);
				ExtentTestManager.getTest().log(Status.PASS,"Th amount is accepted" + AddPostDebitAmount);
				ExtentTestManager.endTest();
				
				
				
				//TC013
				ExtentTestManager.startTest("TC013 - Submit post debit");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SubmitPostDebit = true;
				try {
					SubmitPostDebit = GLBlkTrnImpTransfer.SubmitPostDebit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Submit post debit" + SubmitPostDebit);
				ExtentTestManager.getTest().log(Status.PASS,"Popup window will be closed" + SubmitPostDebit);
				ExtentTestManager.endTest();
				
				
				
				//TC014
				ExtentTestManager.startTest("TC014 - Submit Summary");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean SubmitSummary = true;
				try {
					SubmitSummary = GLBlkTrnImpTransfer.SubmitSummary();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Click on the submit" + SubmitSummary);
				ExtentTestManager.getTest().log(Status.PASS,"Summary is generated for authorization." + SubmitSummary);
				ExtentTestManager.endTest();
				
				
				//TC015
				GLBlkTrnImpTransfer.Signout(testdata, context);
				
				//TC016
				GLBlkTrnImpTransfer.signinforauthorisation(testdata, context);
				
				
				//TC017
				ExtentTestManager.startTest("TC017 - Navigate to Manager authorisation");
				boolean ManagerAuthorisation = true;
				try {
					ManagerAuthorisation = GLBlkTrnImpTransfer.ManagerAuthorisation();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to navigate to manager authorisation" + ManagerAuthorisation);
				ExtentTestManager.getTest().log(Status.PASS,"User is navigated to manager authorisation" + ManagerAuthorisation);
				ExtentTestManager.endTest();
				
				
				//TC018
				ExtentTestManager.startTest("TC018 - Click on the transfer");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Transfertab = true;
				try {
					Transfertab = GLBlkTrnImpTransfer.Transfertab();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Transsfer tab will be display" + Transfertab);
				ExtentTestManager.getTest().log(Status.PASS,"Transfer tab displayed " + Transfertab);
				ExtentTestManager.endTest();
				
				
				//TC019
				ExtentTestManager.startTest("TC019 - Click on the refresh");
				//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
				boolean Refresh = true;
				try {
					Refresh = GLBlkTrnImpTransfer.Refresh();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentTestManager.getTest().log(Status.PASS,"Attempt to refresh the pagey" + Refresh);
				ExtentTestManager.getTest().log(Status.PASS,"The page is refreshed " + Refresh);
				ExtentTestManager.endTest();
				
				
				//TC020
				 ExtentTestManager.startTest("TC020 - Authorize the transaction");
					boolean Selectuploadedfile = GLBlkTrnImpTransfer.Selectuploadedfile(); 
					ExtentTestManager.getTest().log(Status.PASS,"Autherize the transaction" + Selectuploadedfile);
					ExtentTestManager.getTest().log(Status.PASS,"Transaction is authorised" +Selectuploadedfile );
					ExtentTestManager.endTest();
					
					
				//TC021	
					ExtentTestManager.startTest("TC019 - Signout the application");
					//boolean MeansOfFinance = MeansOfFinance_Module.Navigatetomeansoffinance();
					boolean SignOut = true;
					try {
						SignOut = GLBlkTrnImpTransfer.SignOut();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExtentTestManager.getTest().log(Status.PASS,"Attempt to signout" + SignOut);
					ExtentTestManager.getTest().log(Status.PASS,"The user is signed out" + SignOut);
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

			