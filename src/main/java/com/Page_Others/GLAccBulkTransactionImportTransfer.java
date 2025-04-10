package com.Page_Others;

import java.io.IOException;
import java.util.Map;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_GL_AccBulkTran_Imp_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


//TC001
public class GLAccBulkTransactionImportTransfer extends Base_Class {
	public String actualUserName;
	public String TransactionId;
	public String NetAmount;
	
	PageRepositary_GL_AccBulkTran_Imp_Transfer GLAccBulkTranImpTran = new PageRepositary_GL_AccBulkTran_Imp_Transfer();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	
	
//TC002	
	
	public boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("PC Registration");
		Log.info("PC Registration");
		
		String pcRegFormName = testdata.get("pcRegFormName").toString();
		input(custSearch.formName, pcRegFormName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
		Log.info("Step:01 - Enter User Name in Name field.");
		
		select("TRIVANDRUM",custSearch.formBranchName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
		Log.info("Step:02 - Select a Branch Name from the Dropdown.");
		
		String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
		input(custSearch.formComputerName, pcRegFormPcName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
		Log.info("Step:03 - Enter PC Name in Name field.");
		
		click(custSearch.formSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit Button.");
		Log.info("Step:04 - Click on Submit Button.");
		
		//DB Connection
			com.BasePackage.Base_Class.DatabaseConnector();
			driver.navigate().refresh();
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PC Registered Successfully!");
			Log.info("Expected Result: PC Registered Successfully!");
			ExtentTestManager.endTest();
			
		return true;
	}
	
	
	//TC003
	public boolean AccessGLAccBlkTransImp() throws InterruptedException {
		Thread.sleep(5000);
		ScrollUntilElementVisible(GLAccBulkTranImpTran.Transaction);
		Thread.sleep(1000);
		click(GLAccBulkTranImpTran.Others);
		Thread.sleep(1000);
		ScrollUntilElementVisible(GLAccBulkTranImpTran.Others);
		Thread.sleep(1000);
		click(GLAccBulkTranImpTran.DataSharing);
		Thread.sleep(1000);
		click(GLAccBulkTranImpTran.GLAccBulkTranImp);
		Thread.sleep(1000);
		return false;
		
	}
	
	
	//TC004
	public boolean DownloadSampleFile() throws InterruptedException {
		click(GLAccBulkTranImpTran.DownloadArrow);
		Thread.sleep(1000);
		return false;
		
	
		
	}

	
	
	//TC005
	public  boolean SelectSampleFile() throws InterruptedException, IOException {
	    UploadFile(GLAccBulkTranImpTran.BrowseButton,".\\src\\test\\resources\\GlacExcelImport_SampleTemplate.xls");
		Thread.sleep(7000);
		System.out.println("Uploaded");

		return true;
		
		
	}
	
	//TC006
	public boolean UploadFile() throws InterruptedException {
		click(GLAccBulkTranImpTran.Get);
		Thread.sleep(1000);
		return false;
		
	
		
	}

	//TC007
	public boolean SelectTransactionmode() throws InterruptedException {
		click(GLAccBulkTranImpTran.TransactionMode);
		Thread.sleep(1000);
		click(GLAccBulkTranImpTran.Tranfermode);
		Thread.sleep(1000);
		TransactionId = driver.findElement(GLAccBulkTranImpTran.TransactionId).getText();
		NetAmount = driver.findElement(GLAccBulkTranImpTran.NetAmount).getText();
		return false;
		
	}
		
		
		
  //TC008
		public boolean PostDebit() throws InterruptedException {
		click(GLAccBulkTranImpTran.Postdebit);
		Thread.sleep(1000);
		return false;
		
		
		
		}
		
		//TC009
		public boolean GLCode() throws InterruptedException {
		click(GLAccBulkTranImpTran.GLCode);
		Thread.sleep(1000);
		return false;
		
		
		
	}
	
}
