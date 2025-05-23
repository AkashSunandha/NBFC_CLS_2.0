package com.test.Transaction;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_InvestmentTransactionCash_Transfer.InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_InvestmentTransaction_Cash extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();
	InvestmentTransaction_Cash_Transfer InvstTransaction =new InvestmentTransaction_Cash_Transfer();
	Transaction_Transactions_Jewel transJewel = new Transaction_Transactions_Jewel();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("InvestmentTransaction");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	@Test(dataProvider = "TestData")
	public void customerRegister(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest("Investment_Transaction-Cash").assignCategory("Investment Transction -Cash");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();
				
				
				//Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				


				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
				
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				//TC No. - 01 --> Customer Register Window
			
				InvstTransaction.NavigateToInvstTransaction();
				InvstTransaction.SelectProductGroup();
				InvstTransaction.SelectProductName();
				InvstTransaction.SelectBankDD();
				InvstTransaction.SelectBranchDD();
				InvstTransaction.ClickonFirstTransactionfromgrid();
				InvstTransaction.SelectTransactionTypeDD();
				InvstTransaction.ClickonGoButton();
				InvstTransaction.EnterTransactionAmount(testdata);
				InvstTransaction.SelectTransactionModeDD("CASH");
				InvstTransaction.ClickonSubmit_TransactionButton();
				String TransactionID= InvstTransaction.FetchTranscationIDFromINvoice();
						
				Thread.sleep(3000);
				InvstTransaction.logout();
				InvstTransaction.AuthuserLoginValidPaswrd(testdata, context);
				InvstTransaction.NavigatetoCashierAuthorisation();
				InvstTransaction.ClickonRefresh();
				InvstTransaction.EnterTransID(TransactionID);
				InvstTransaction.ClickonGoButton();
				InvstTransaction.ClickonTransactionCheckboxfromgrid();
				InvstTransaction.ClickonAuthorizeButton();
				InvstTransaction.ClickONManagerAuthorisation();
				InvstTransaction.ClickonRefresh();
				InvstTransaction.EnterTransID(TransactionID);
				InvstTransaction.ClickonGoButton();
				InvstTransaction.ClickonTransactionCheckboxfromgrid();
				InvstTransaction.ClickonAuthorizeButton();
				
				//Sign out
				Thread.sleep(3000);
				custSrchMthds.logout();
				
				
				// EndTest
//				ExtentTestManager.endTest();
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

