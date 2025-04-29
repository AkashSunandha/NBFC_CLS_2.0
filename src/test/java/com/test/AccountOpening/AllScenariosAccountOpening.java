package com.test.AccountOpening;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.AccountSearchEditbutton;
import com.Page_AccountOpening.GeneralOpening_SuspenseAsset;
import com.Page_AccountOpening.LoanOpening_DepositOpn_DepositLoan;
import com.Page_AccountOpening.LoanOpening_LoanAndAdvances_PersonalLoanWeekly;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.sun.mail.smtp.SMTPSendFailedException;

import Common.TriggerEmail;

public class AllScenariosAccountOpening extends Base_Class {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	AccountSearchEditbutton AccountSearchMethods = new AccountSearchEditbutton();
	AllScenarios_AccOpn_LoanOpn_JewelLoan_GoldLoan AllScenarios_AccOpn_LoanOpn_JewelLoan_GoldLoan=new AllScenarios_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	AllScenarios_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly AllScenarios_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly=new AllScenarios_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly();
	AllScenarios_AccOpn_Account_Search_Edit_button AllScenarios_AccOpn_Account_Search_Edit_button =new AllScenarios_AccOpn_Account_Search_Edit_button();
	AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_CASH AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_CASH =new AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_CASH();
	AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_TRANSFER AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_TRANSFER=new AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_TRANSFER();
	AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_CASH AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_CASH =new AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_CASH();
	AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_TRANSFER AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_TRANSFER =new AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_TRANSFER();
	
	@BeforeSuite
	public void reference() { 
		ExcelReader = new com.Utility.ExcelReader("Account_Search");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	public boolean logout() throws InterruptedException {
		ExtentSuccessMessage("Logout");
		Log.info("Logout");
		
		Thread.sleep(4000);
		PageRefresh();
		click(custSearch.custSignOut);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
//		Log.info("Step:01 -  Click on 'Signout'");
//		if(ElementDisplayed(custSearch.loginButton)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
//			Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
//		}
		driver.close();
//		driver.quit();
		ExtentTestManager.endTest();
		return true;
	}


	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws SMTPSendFailedException, Exception{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
				
				switch (testdata.get("TestScenario").toString()) {

				///////////////////////////////////////////

				case "Gold Loan":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_LoanOpn_JewelLoan_GoldLoan.newCustomer(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;
					
				case "Personal Loan Weekly":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly.newCustomer(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;

				case "AccountSearchEditbutton":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_Account_Search_Edit_button.Account_Search_Edit_button(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;

				case "Suspense Asset Cash":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_CASH.SuspenseAsset_CASH(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;

				case "Suspense Asset Transfer":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_TRANSFER.SuspenseAsset_TRANSFER(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;

				case "Deposit Loan Cash":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_CASH.DepoLoan_CASH(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;


				case "Deposit Loan Transfer":
					context.setAttribute("fileName", "Login");
					AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_TRANSFER.newCustomer(testdata, context);
					context.setAttribute("fileName", "Logout");
					break;
					
					
					

				default:
					break;


				}	
				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");


			}
		}catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");
			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentErrorMessage("Test Failed");
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			logout();
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			logout();
			ExtentErrorMessage("Test Failed");
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if(configloader().getProperty("EmailTrigger").contains("Yes")) {
				TriggerEmail.sendReport();
			}			
			if (driver != null)
				driver.quit();
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
