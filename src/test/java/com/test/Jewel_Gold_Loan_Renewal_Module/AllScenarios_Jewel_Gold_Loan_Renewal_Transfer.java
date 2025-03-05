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

public class AllScenarios_Jewel_Gold_Loan_Renewal_Transfer extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Transfer GoldLoanRenewalTransfer = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Transfer();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash GoldLoanRenewalCash = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Jewel_GoldLoan_Renewal_Transfer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void Loan_Closure_Transfer(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch for Loan Closure Cash");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> Login to NBFC Application
				GoldLoanRenewalTransfer.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Open Account Closure Window
				GoldLoanRenewalTransfer.OpenAccountClosureWindow();
				
				//TC_03 ---> Select Jewel Loan Product Group
				GoldLoanRenewalTransfer.SelectJewelLoanProductGroup();
				
				//TC_04 ---> Select Product Name from Dropdown
				GoldLoanRenewalTransfer.SelectProductNamefromDropdown();
				
				//TC_05 ---> EnterLoanAccountNumber
				GoldLoanRenewalTransfer.EnterLoanAccountNumber();
				
				//TC_06 ---> Display Loan Account Details
				GoldLoanRenewalTransfer.DisplayLoanAccountDetails();
				
				//TC_07 ---> ExpandRenewalSection
				GoldLoanRenewalTransfer.ExpandRenewalSection();
				
				//TC_08 ---> OpenSecurityDetailsPopup
				GoldLoanRenewalTransfer.OpenSecurityDetailsPopup();
				
				//TC_09 ---> Add Security Details
				GoldLoanRenewalTransfer.AddSecurityDetails();
				
				//TC_10 ---> Add Security Details Item Name
				//GoldLoanRenewalTransfer.AddSecurityDetailsItemName();
				
				//TC_11 ---> AddSecurityDetailsItemDescription
				//GoldLoanRenewalTransfer.AddSecurityDetailsItemDescription(testdata, context);
				
				//TC_12 ---> AddSecurityDetailsItemQuantity
				//GoldLoanRenewalTransfer.AddSecurityDetailsItemQuantity(testdata, context);
				
				//TC_13 ---> AddSecurityDetailsStoneWeight
				//GoldLoanRenewalTransfer.AddSecurityDetailsStoneWeight(testdata, context);
				
				//TC_14 ---> AddSecurityDetailsTickPurityCheckbox
				//GoldLoanRenewalTransfer.AddSecurityDetailsTickPurityCheckbox(testdata, context);
				
				//TC_15 ---> AddSecurityDetailsItemWeight
				//GoldLoanRenewalTransfer.AddSecurityDetailsItemWeight(testdata, context);
				
				//TC_16 ---> AddSecurityDetailsDirtWeight
				//GoldLoanRenewalTransfer.AddSecurityDetailsDirtWeight(testdata, context);
				
				//TC_17 ---> AddSecurityDetailsEnterPurity
				//GoldLoanRenewalTransfer.AddSecurityDetailsEnterPurity(testdata, context);
				
				//TC_18 ---> AddSecurityDetailsAdd
				//GoldLoanRenewalTransfer.AddSecurityDetailsAdd(testdata, context);
				
				//TC_19 ---> CloseSecurityDetailsPopup
				//GoldLoanRenewalTransfer.CloseSecurityDetailsPopup(testdata, context);
				
				//TC_20 ---> CloseSecurityDetailsPopupSubmit
				GoldLoanRenewalTransfer.CloseSecurityDetailsPopupSubmit(testdata, context);
				
				//TC_21 ---> EnterSanctionedAmount
				GoldLoanRenewalTransfer.EnterSanctionedAmount(testdata, context);
				
				//TC_22 ---> GetValuewithCashTransactionMode
				GoldLoanRenewalTransfer.GetValuewithCashTransactionMode();
				
				//TC_23 ---> GetValuewithCashTransactionMode
				GoldLoanRenewalTransfer.GetValuewithCashTransactionMode(testdata, context);
				
				//TC_24 ---> EnterRemarksandSelectClosureType
				GoldLoanRenewalTransfer.EnterRemarksandSelectClosureType(testdata, context);
				
				//TC_25 ---> POSTDEBITpopupispresent
				GoldLoanRenewalTransfer.POSTDEBITpopupispresent(testdata, context);
				
				//TC_26 ---> PostDebitpopupispresent
				//GoldLoanRenewalTransfer.PostDebitpopupispresent(testdata, context);
				
				//TC_27 ---> PostDebitPopUpProductGroupDropdown
				//GoldLoanRenewalTransfer.PostDebitPopUpProductGroupDropdown(testdata, context);
				
				//TC_28 ---> PostDebitPopUpProductNameDropdown
				//GoldLoanRenewalTransfer.PostDebitPopUpProductNameDropdown(testdata, context);
				
				//TC_29 ---> PostDebitPopUpBranchDropdown
				//GoldLoanRenewalTransfer.PostDebitPopUpBranchDropdown(testdata, context);
				
				//TC_30 ---> PostDebitPopUpAccountNumber
				//GoldLoanRenewalTransfer.PostDebitPopUpAccountNumber(testdata, context);
				
				//TC_31 ---> PostDebitPopUpEnterAmount
				//GoldLoanRenewalTransfer.PostDebitPopUpEnterAmount(testdata, context);
				
				//TC_32 ---> PostDebitPopUpAddDetails
				//GoldLoanRenewalTransfer.PostDebitPopUpAddDetails(testdata, context);
				
				//TC_33 ---> PostDebitPopUpSubmitDetails
				GoldLoanRenewalTransfer.PostDebitPopUpSubmitDetails(testdata, context);
				
				//TC_34 ---> PostDebitSubmitAccountClosure
				GoldLoanRenewalTransfer.PostDebitSubmitAccountClosure();
				
				//TC_35 ---> LogintoNBFcApplicationinadifferentuser
				GoldLoanRenewalTransfer.LogintoNBFcApplicationinadifferentuser();
				
				//TC_36 ---> LogintoNBFcApplicationinadifferentuserAuthorizecancel
				GoldLoanRenewalTransfer.LogintoNBFcApplicationinadifferentuserAuthorizeandcancel();
				
				//TC_37 ---> ManagerAuthorisationTransfer
				GoldLoanRenewalTransfer.ManagerAuthorisationTransfer();
				
				//TC_38 ---> ManagerAuthorisationRefresh
				GoldLoanRenewalTransfer.ManagerAuthorisationRefresh();
				
				//TC_39 ---> SelectManagerTransferTransaction
				GoldLoanRenewalTransfer.SelectManagerTransferTransaction();
				
				//TC_40 ---> ManagerTransferAuthorization
				GoldLoanRenewalTransfer.ManagerTransferAuthorization();
				
				//TC_31 ---> LogintoNBFcApplicationinadifferentuserManagerAuthorisation
				//GoldLoanRenewalTransfer.CashierAuthorisation();
				
				//TC_32 ---> ManagerAuthorizationRefresh
				//GoldLoanRenewalTransfer.CashAuthorizationRefresh();
				
				//TC_33 --> SelectCashTransactionManagerAuthorisation
				//GoldLoanRenewalTransfer.SelectCashTransactionCashierAuthorisation();
				
				//TC_34 ---> ManagerAuthorization
				//GoldLoanRenewalTransfer.CashAuthorization();
				
								
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
