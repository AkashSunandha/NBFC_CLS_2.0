package com.Page_Others;

import java.io.IOException;
import java.util.Map;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_GL_AccBulkTran_Imp_Cash;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


//TC001
public class GLAccBulkTransactionImportCash extends Base_Class {
	public String actualUserName;
	public String TransactionId;
	
	PageRepositary_GL_AccBulkTran_Imp_Cash GLAccBulkTranImp = new PageRepositary_GL_AccBulkTran_Imp_Cash();
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
		ScrollUntilElementVisible(GLAccBulkTranImp.Transaction);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Others);
		Thread.sleep(1000);
		ScrollUntilElementVisible(GLAccBulkTranImp.Others);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.DataSharing);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.GLAccBulkTranImp);
		Thread.sleep(1000);
		return false;
		
	}
	
	
	//TC004
	public boolean DownloadSampleFile() throws InterruptedException {
		click(GLAccBulkTranImp.DownloadArrow);
		Thread.sleep(1000);
		return false;
		
	
		
	}

	
	
	//TC005
	public  boolean SelectSampleFile() throws InterruptedException, IOException {
	    UploadFile(GLAccBulkTranImp.BrowseButton,".\\src\\test\\resources\\GlacExcelImport_SampleTemplate.xls");
		Thread.sleep(7000);
		System.out.println("Uploaded");

		return true;
		
		
	}
	
	//TC006
	public boolean UploadFile() throws InterruptedException {
		click(GLAccBulkTranImp.Get);
		Thread.sleep(1000);
		return false;
		
	
		
	}

	//TC007
	public boolean SelectTransactionmode() throws InterruptedException {
		click(GLAccBulkTranImp.TransactionMode);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Cashmode);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Submit);
		Thread.sleep(1000);
		TransactionId = driver.findElement(GLAccBulkTranImp.TransactionId).getText();
		return false;
		
	
		
	}
	

	//TC008
	public void Signout(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		
		
		//Login with Another User
		ExtentTestManager.startTest("Logout");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		ExtentTestManager.endTest();
	}
		
		//TC009
		public boolean signinforauthorisation(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("Login with Another User");
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String authorizeUserName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(authorizeUserName);
		
		
		
		if(!authorizeUserName.equalsIgnoreCase(actualUserName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		ExtentTestManager.endTest();
		return false;
		

	}
	
	
	//TC010
	
	public boolean CashierAuthorisation() throws InterruptedException {
		click(GLAccBulkTranImp.AuthorizeandCancel);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.CashierAuthorisation);
		Thread.sleep(1000);
		
        return false;
		
	
		
	}
	
	
	//TC011
	public boolean Refresh() throws InterruptedException {
		click(GLAccBulkTranImp.Refresh);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	//TC0012
	public boolean Selectuploadedfile(String transactionId) throws InterruptedException {
	input(GLAccBulkTranImp.TransactionIdsearch , TransactionId);
	Thread.sleep(1000);
	click(GLAccBulkTranImp.Go);
	Thread.sleep(1000);
	click(GLAccBulkTranImp.CheckBox);
	Thread.sleep(1000);
	return false;
	
	
	
}
	
	
	//TC013
	public boolean Authorize() throws InterruptedException {
		click(GLAccBulkTranImp.Authorize);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	
	//TC014
	public boolean ManagerAuthorisation() throws InterruptedException {
		//click(GLAccBulkTranImp.AuthorizeandCancel);
		//Thread.sleep(1000);
		click(GLAccBulkTranImp.ManagerAuthorisation);
		Thread.sleep(1000);
		
        return false;
		
	
		
	}
	
	
	//Tc015
	public boolean Cashtab() throws InterruptedException {
		click(GLAccBulkTranImp.Cashtab);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	
	//Tc016
	public boolean Refresh2() throws InterruptedException {
		click(GLAccBulkTranImp.Refresh2);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	
	
	//Tc017
	public boolean Selectuploadedfile2(String transactionId) throws InterruptedException {
		input(GLAccBulkTranImp.TransactionId2 , TransactionId);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Go2);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Checkbox2);
		Thread.sleep(1000);
		return false;
		
		
		
	}
	
	
	//TC018
	public boolean Authorize2() throws InterruptedException {
		click(GLAccBulkTranImp.Authorize2);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	
	//TC019
	public boolean SignOut2() throws InterruptedException {
		click(GLAccBulkTranImp.Closetop);
		Thread.sleep(1000);
		click(GLAccBulkTranImp.Signout);
		Thread.sleep(1000);
        return false;
		
	
		
	}
	
	
	
	
	
	
}
