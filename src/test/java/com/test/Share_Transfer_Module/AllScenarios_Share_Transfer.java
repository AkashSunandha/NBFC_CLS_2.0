package com.test.Share_Transfer_Module;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
//import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening;
import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening_Cash;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Pages_Jewel_Loan_Transcharge_Module.Jewel_Loan_Transcharge_Cash;
import com.Pages_Share_Transfer.Share_Transfer_Module;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

import Pages_GL_Account_Transaction_Module.GL_Account_Transaction_Cash;

public class AllScenarios_Share_Transfer extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash GoldLoanRenewalCash = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash();
	Jewel_Loan_Transcharge_Cash loantranscharge = new Jewel_Loan_Transcharge_Cash();
	GL_Account_Transaction_Cash GLTransaction = new GL_Account_Transaction_Cash();
	Share_Transfer_Module sharetransfer = new Share_Transfer_Module();
	
	@BeforeClass
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Share_Transfer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void Loan_Closure_Cash(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("ShareTransfer");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> Login to NBFC Application
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				//TC_02 ---> AccessShareTransferWindow
				sharetransfer.AccessShareTransferWindow();
				
				//TC_03 ---> Selectionbranchfromdropdown
				sharetransfer.Selectionbranchfromdropdown();
				
				//TC_04 ---> Productgroupselection
				sharetransfer.Productgroupselection();
				
				//TC_05 ---> ProductNameselection
				sharetransfer.ProductNameselection();
				
				//TC_06 ---> VerifyClickonGOAfterEnteringAccountNo
				sharetransfer.VerifyClickonGOAfterEnteringAccountNo(testdata, context);
				
				//TC_07 ---> VerifyClickonGOAfterEnteringAccountNoinTransferTo
				sharetransfer.VerifyClickonGOAfterEnteringAccountNoinTransferTo(testdata, context);
				
				//TC_08 ---> VerifyShareValueAutoload
				sharetransfer.VerifyShareValueAutoload();
				
				//TC_09 ---> VerifyShareAmountAutoloadonNoofSharesEntry
				sharetransfer.VerifyShareAmountAutoloadonNoofSharesEntry(testdata, context);
				
				//TC_10 ---> VerifyTransactionSuccessonSubmit
				sharetransfer.VerifyTransactionSuccessonSubmit();
				
				//TC_11 ---> Logout
				sharetransfer.Logout();
				
				//TC_12 ---> ManagerLoginforAuthorization
				sharetransfer.ManagerLoginforAuthorization();
				
				//TC_13 ---> ManagerAuthorizationRefresh
				sharetransfer.ManagerAuthorizationRefresh();
				
				//TC_14 ---> AuthorizeShareEntry
				sharetransfer.AuthorizeShareEntry();
				
				// Sign out
				Thread.sleep(3000);
				custSrchMthds.logout();

				// EndTest
				// ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();

			}
		} catch (Exception e) {
			System.out.println(e);
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
