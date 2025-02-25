package com.Page_Closure_and_Renewals;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Loan_Closure_Cash extends Base_Class {
	//Pages_Multi_FD_Module multifd = new Pages_Multi_FD_Module();
	com.Page_Closure_and_Renewals.Loan_Closure_Cash LoanClosureCash = new com.Page_Closure_and_Renewals.Loan_Closure_Cash();
	Pages_Closure_and_Renewals_Module LoanClosure = new Pages_Closure_and_Renewals_Module();
	
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdCashLoan;
    String transIdTransferLoan;

	
	public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(LoanClosure.TransactionIDField,transID);
		click(LoanClosure.GoBTN);
		
		ExtentTestManager.endTest();
		return true;
		
	}
	public boolean pcRegistration__Loan_Closure_Cash(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("PC Registration");
		Log.info("PC Registration");
		
		String pcRegFormName = testdata.get("pcRegFormName").toString();
		input(LoanClosure.formName, pcRegFormName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
		Log.info("Step:01 - Enter User Name in Name field.");
		
		select("TRIVANDRUM",LoanClosure.formBranchName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
		Log.info("Step:02 - Select a Branch Name from the Dropdown.");
		
		String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
		input(LoanClosure.formComputerName, pcRegFormPcName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
		Log.info("Step:03 - Enter PC Name in Name field.");
		
		click(LoanClosure.formSubmitBtn);
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


	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:01 - Login to NBFC Application");
		Log.info("TC_01 - Login to NBFC Application");

		// String loginUserName = testdata.get("loginUserName").toString();
		String UserName = configloader().getProperty("UserName");
		input(LoanClosure.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		// String loginValidPassword = testdata.get("loginValidPassword").toString();
		String Password = configloader().getProperty("Password");
		input(LoanClosure.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
		Log.info("Step:02 - Enetered valid Password");

		click(LoanClosure.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");

		try {
			ElementDisplayed(LoanClosure.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		} catch (Exception e) {
			ElementDisplayed(LoanClosure.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS,
					"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(LoanClosure.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			// String loginUserName = testdata.get("loginUserName").toString();
			input(LoanClosure.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			// String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(LoanClosure.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(LoanClosure.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(LoanClosure.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}

		ElementDisplayed(LoanClosure.home);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
		ExtentTestManager.endTest();

		return true;
	}

	public boolean DepositOpeningWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Access to Deposit Opening Window");
		Log.info("TC:02 - Access to Deposit Opening Window");

		try {

			click(LoanClosure.AccOpening);
			click(LoanClosure.DepositOpening);
			click(LoanClosure.FixedDeposit);
			click(LoanClosure.FixedType2Years);

			ExtentTestManager.getTest().log(Status.PASS,
					"Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");
			Log.info("Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");

			boolean isDashboardVisible = ElementDisplayed(LoanClosure.FixedType2Years);

			Assert.assertTrue(isDashboardVisible, "Validation Failed: Deposit opening window is NOT displayed.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit opening window is displayed");
			Log.info("Expected Result: Deposit opening window is displayed");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred while accessing Deposit Opening Window: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;

	}

	
		
	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
