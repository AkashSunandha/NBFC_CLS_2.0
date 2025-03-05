package com.test.Jewel_Gold_Loan_Renewal_Module;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
//import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening;
import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening_Cash;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Jewel_Gold_Loan_Renewal_Cash extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash GoldLoanRenewalCash = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Jewel_Gold_Loan_Renewal_Cash");
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
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> Login to NBFC Application
				GoldLoanRenewalCash.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Open Account Closure Window
				GoldLoanRenewalCash.OpenAccountClosureWindow();
				
				//TC_03 ---> Select Jewel Loan Product Group
				GoldLoanRenewalCash.SelectJewelLoanProductGroup();
				
				//TC_04 ---> Select Product Name from Dropdown
				GoldLoanRenewalCash.SelectProductNamefromDropdown();
				
				//TC_05 ---> EnterLoanAccountNumber
				GoldLoanRenewalCash.EnterLoanAccountNumber();
				
				//TC_06 ---> Display Loan Account Details
				GoldLoanRenewalCash.DisplayLoanAccountDetails();
				
				//TC_07 ---> ExpandRenewalSection
				GoldLoanRenewalCash.ExpandRenewalSection();
				
				//TC_08 ---> OpenSecurityDetailsPopup
				GoldLoanRenewalCash.OpenSecurityDetailsPopup();
				
				//TC_09 ---> Add Security Details
				GoldLoanRenewalCash.AddSecurityDetails();
				
				//TC_10 ---> Add Security Details Item Name
				GoldLoanRenewalCash.AddSecurityDetailsItemName();
				
				//TC_11 ---> AddSecurityDetailsItemDescription
				GoldLoanRenewalCash.AddSecurityDetailsItemDescription(testdata, context);
				
				//TC_12 ---> AddSecurityDetailsItemQuantity
				GoldLoanRenewalCash.AddSecurityDetailsItemQuantity(testdata, context);
				
				//TC_13 ---> AddSecurityDetailsStoneWeight
				GoldLoanRenewalCash.AddSecurityDetailsStoneWeight(testdata, context);
				
				//TC_14 ---> AddSecurityDetailsTickPurityCheckbox
				GoldLoanRenewalCash.AddSecurityDetailsTickPurityCheckbox(testdata, context);
				
				//TC_15 ---> AddSecurityDetailsItemWeight
				GoldLoanRenewalCash.AddSecurityDetailsItemWeight(testdata, context);
				
				//TC_16 ---> AddSecurityDetailsDirtWeight
				GoldLoanRenewalCash.AddSecurityDetailsDirtWeight(testdata, context);
				
				//TC_17 ---> AddSecurityDetailsEnterPurity
				GoldLoanRenewalCash.AddSecurityDetailsEnterPurity(testdata, context);
				
				//TC_18 ---> AddSecurityDetailsAdd
				GoldLoanRenewalCash.AddSecurityDetailsAdd(testdata, context);
				
				//TC_19 ---> CloseSecurityDetailsPopup
				GoldLoanRenewalCash.CloseSecurityDetailsPopup(testdata, context);
				
				//TC_20 ---> CloseSecurityDetailsPopupSubmit
				GoldLoanRenewalCash.CloseSecurityDetailsPopupSubmit(testdata, context);
				
				//TC_21 ---> EnterSanctionedAmount
				GoldLoanRenewalCash.EnterSanctionedAmount(testdata, context);
				
				//TC_22 ---> GetValuewithCashTransactionMode
				GoldLoanRenewalCash.GetValuewithCashTransactionMode();
				
				//TC_23 ---> GetValuewithCashTransactionMode
				GoldLoanRenewalCash.GetValuewithCashTransactionMode(testdata, context);
				
				//TC_24 ---> EnterRemarksandSelectClosureType
				GoldLoanRenewalCash.EnterRemarksandSelectClosureType(testdata, context);
				
				//TC_25 ---> SubmitAccountClosure
				GoldLoanRenewalCash.SubmitAccountClosure();
				
				//TC_26 ---> LogintoNBFcApplicationinadifferentuser
				GoldLoanRenewalCash.LogintoNBFcApplicationinadifferentuser();
				
				//TC_27 ---> LogintoNBFcApplicationinadifferentuserAuthorizecancel
				GoldLoanRenewalCash.LogintoNBFcApplicationinadifferentuserAuthorizeandcancel();
				
				//TC_28 ---> LogintoNBFcApplicationinadifferentuserRefresh
				GoldLoanRenewalCash.ManagerAuthorisationRefresh();
				
				//TC_29 ---> LogintoNBFcApplicationinadifferentuserSelectTransaction
				GoldLoanRenewalCash.SelectManagerCashTransaction();
				
				//TC_30 ---> LogintoNBFcApplicationinadifferentuserAuthorization
				GoldLoanRenewalCash.ManagerCashAuthorization();
				
				//TC_31 ---> LogintoNBFcApplicationinadifferentuserManagerAuthorisation
				GoldLoanRenewalCash.CashierAuthorisation();
				
				//TC_32 ---> ManagerAuthorizationRefresh
				GoldLoanRenewalCash.CashAuthorizationRefresh();
				
				//TC_33 --> SelectCashTransactionManagerAuthorisation
				GoldLoanRenewalCash.SelectCashTransactionCashierAuthorisation();
				
				//TC_34 ---> ManagerAuthorization
				GoldLoanRenewalCash.CashAuthorization();
				
								
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
