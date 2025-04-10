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
				ExtentTestManager.getTest().log(Status.PASS,"GL code related field will be display (GL name,GL code)" + GLCode);
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

			