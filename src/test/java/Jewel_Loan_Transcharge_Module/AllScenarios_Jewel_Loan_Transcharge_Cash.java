package Jewel_Loan_Transcharge_Module;

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
import com.Pages_Jewel_Loan_Transcharge_Module.Jewel_Loan_Transcharge_Cash;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Jewel_Loan_Transcharge_Cash extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash GoldLoanRenewalCash = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash();
	Jewel_Loan_Transcharge_Cash loantranscharge = new Jewel_Loan_Transcharge_Cash();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Jewel_Loan_Transcharge_Cash");
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
				loantranscharge.userLoginValidPaswrd(testdata, context);

				// TC_02 ---> ChargePostingWindowAccess
				loantranscharge.ChargePostingWindowAccess();
				
				//TC_03 ---> BranchAutoloadinChargePosting
				loantranscharge.BranchAutoloadinChargePosting();
				
				//TC_04 ---> TransactionandPostingDatesVerification
				loantranscharge.TransactionandPostingDatesVerification();
				
				//TC_05 ---> SelectJewelLoanGroup
				loantranscharge.SelectJewelLoanGroup();
				
				//Tc_06 ---> SelectGoldLoanProduct
				loantranscharge.SelectGoldLoanProduct();
				
				//TC_07 ---> AccountNumberEntryandAutoloadVerification
				loantranscharge.AccountNumberEntryandAutoloadVerification();
				
				//TC_08 ---> SelectMiscChargeType
				loantranscharge.SelectMiscChargeType();
				
				//Tc_09 ---> EnterChargeAmount
				loantranscharge.EnterChargeAmount(testdata, context);
				
				//TC_10 ---> AddChargeandVerifyinGrid
				loantranscharge.AddChargeandVerifyinGrid();
				
				//TC_11 ---> SaveChargeandSuccessfulMessageDisplay
				loantranscharge.SaveChargeandSuccessfulMessageDisplay();
				
				//TC_12 ---> TransactionModuleAccess
				loantranscharge.TransactionModuleAccess();
				
				//TC_13 --->BranchAutoloadinTransactionModule
				loantranscharge.BranchAutoloadinTransactionModule();
				
				//TC_14 ---> SelectJewelLoanGroupinTransaction
				loantranscharge.SelectJewelLoanGroupinTransaction();
				
				//TC_15 ---> SelectGoldLoanProductinTransaction
				loantranscharge.SelectGoldLoanProductinTransaction();
				
				//TC_16 ---> EnterAccountNumberinTransaction
				loantranscharge.EnterAccountNumberinTransaction();
				
				//TC_17 ---> SelectTransactionTypeCredit
				loantranscharge.SelectTransactionTypeCredit();
				
				//TC_18 ---> OpenAccountTransactions
				loantranscharge.OpenAccountTransactions();
				
				//TC_19 ---> VerifyMiscChargeinTransaction
				loantranscharge.VerifyMiscChargeinTransaction();
				
				//TC_20 ---> EnterTransactionAmount
				loantranscharge.EnterTransactionAmount(testdata, context);
				
				//Tc_21 ---> SelectTransactionModeCash
				loantranscharge.SelectTransactionModeCash(testdata, context);
				
				//TC_22 ---> EnterRemarkforTransaction
				loantranscharge.EnterRemarkforTransaction(testdata, context);
				
				//TC_23 ---> SubmitTransactionandVerifySummary
				loantranscharge.SubmitTransactionandVerifySummary();
				
				//TC_24 ---> LogintoNBFcApplicationinadifferentuser
				loantranscharge.LogintoNBFcApplicationinadifferentuser();
				
				//TC_25 ---> LogintoNBFcApplicationinadifferentuserAuthorizeandcancel
				loantranscharge.LogintoNBFcApplicationinadifferentuserAuthorizeandcancel();
				
				//TC_26 ---> CashierAuthorisationRefresh
				loantranscharge.CashierAuthorisationRefresh();
				
				//TC_27 ---> SelectCashierCashTransaction
				loantranscharge.SelectCashierCashTransaction();
				
				//TC_28 ---> CashierCashAuthorization
				loantranscharge.CashierCashAuthorization();
				
				//TC_29 ---> ManagerCashAuthorisation
				loantranscharge.ManagerCashAuthorisation();
				
				//TC_30 ---> CashAuthorizationRefresh
				loantranscharge.CashAuthorizationRefresh();
				
				//TC_31 ---> SelectCashTransactionManagerAuthorisation
				loantranscharge.SelectCashTransactionManagerAuthorisation();
				
				//TC_32 ---> CashManagerAuthorization
				loantranscharge.CashManagerAuthorization();
				
				
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
