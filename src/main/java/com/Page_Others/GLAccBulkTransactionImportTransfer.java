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
	public String VoucherId;
	public String NetAmount;
	 public String removeCrFromAmount(String NetAmount) {
	        if (NetAmount != null) {
	            return NetAmount.replace("Cr", "").trim();
	        }
	        return "";
	    }
    String mainWindowHandle;
   
	
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
	//	TransactionId = driver.findElement(GLAccBulkTranImpTran.TransactionId).getText();
		NetAmount = driver.findElement(GLAccBulkTranImpTran.NetAmount).getText();
		 NetAmount = removeCrFromAmount(NetAmount);
		return false;
		
	}
	
		
		
		
  //TC008
		public boolean PostDebit() throws InterruptedException {
			
	waitUntilElementDisappear(GLAccBulkTranImpTran.loader);

		click(GLAccBulkTranImpTran.Postdebit);
		Thread.sleep(1000);
		
		//Navigate to Pop Up Window
		mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;

//driver.switchTo().window(mainWindowHandle);

	        }
}
	    
	
	    return false;	
		}
		
		
	
	    
		
		
		
		
		//TC009
		public boolean GLCode() throws InterruptedException {
		click(GLAccBulkTranImpTran.TransactionBased);
		Thread.sleep(1000);
		click(GLAccBulkTranImpTran.GLCode);
		Thread.sleep(1000);
		return false;
		
		
		
	}
		
		
		//TC010
		public boolean GLName() throws InterruptedException {
			click(GLAccBulkTranImpTran.DropdownofGLname);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.GLName);
			Thread.sleep(1000);
			return false;
			
			
			
		}
		
		
		//TC011
		
		public boolean EnterAmount() throws InterruptedException {
			driver.findElement(GLAccBulkTranImpTran.Amount).clear();
			input(GLAccBulkTranImpTran.Amount , NetAmount);
			Thread.sleep(1000);
			
			return false;
			
			
			
		}
		
		
		
		//TC012
		public boolean AddPostDebitAmount() throws InterruptedException {
			click(GLAccBulkTranImpTran.Add);
			Thread.sleep(1000);
			return false;
			
		
			
		}
		
		
		
		//TC013
		public boolean SubmitPostDebit() throws InterruptedException {
			click(GLAccBulkTranImpTran.SubmitPostDebit);
			Thread.sleep(1000);
			return false;
			
		
			
		}
	
		
		//TC0014
		public boolean SubmitSummary() throws InterruptedException {
			driver.switchTo().window(mainWindowHandle);
			click(GLAccBulkTranImpTran.Submit);
			Thread.sleep(1000);
			TransactionId = driver.findElement(GLAccBulkTranImpTran.TransactionId).getText();
			VoucherId = driver.findElement(GLAccBulkTranImpTran.VoucherId).getText();
			return false;
			
		
			
		}
		
		
		
		//TC015
		public void Signout(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
			
			
			//Login with Another User
			ExtentTestManager.startTest("Logout");
			Log.info("Login with Another User");
			
			click(custSearch.custSignOut);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
			Log.info("Step:01 - Log out");
			ExtentTestManager.endTest();
		}
		
		//TC016
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
		
		//TC017
		public boolean ManagerAuthorisation() throws InterruptedException {
			click(GLAccBulkTranImpTran.AuthorizeandCancel);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.ManagerAuthorisation);
			Thread.sleep(1000);
			
	        return false;
			
		
			
		}
		
		//TC018
		public boolean Transfertab() throws InterruptedException {
			click(GLAccBulkTranImpTran.Transfertab);
			Thread.sleep(1000);
	        return false;
			
		
			
		}
		
		
		//TC019
		public boolean Refresh() throws InterruptedException {
			click(GLAccBulkTranImpTran.Refresh);
			Thread.sleep(1000);
	        return false;
			
		
			
		}
		
		//TC020
		public boolean Selectuploadedfile() throws InterruptedException {
			input(GLAccBulkTranImpTran.TransactionIdSearch , TransactionId);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.Go);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.Checkbox);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.Authorize);
			Thread.sleep(1000);
			return false;
			
			
			
		}
		
		
		//TC021
		public boolean SignOut() throws InterruptedException {
			click(GLAccBulkTranImpTran.Closetop);
			Thread.sleep(1000);
			click(GLAccBulkTranImpTran.Signout);
			Thread.sleep(1000);
	        return false;
			
		
			
		}
		
		
		
		
		
			
		
		
		
		
	
}
