package GL_Account_Transaction_Module;

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

import Pages_GL_Account_Transaction_Module.GL_Account_Transaction_Cash;
import Pages_GL_Account_Transaction_Module.GL_Account_Transaction_Transfer;

public class AllScenarios_GL_Account_Transaction_Transfer extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash GoldLoanRenewalCash = new com.Pages_Jewel_Gold_Loan_Renewal_Module.Jewel_Gold_Loan_Renewal_Cash();
	Jewel_Loan_Transcharge_Cash loantranscharge = new Jewel_Loan_Transcharge_Cash();
	GL_Account_Transaction_Transfer GLTransaction = new GL_Account_Transaction_Transfer();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("GL_Acc_Trans_Transfer");
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
				GLTransaction.userLoginValidPaswrd(testdata, context);
				
				//TC_02 ---> LaunchGLAccountTransactionModule
				GLTransaction.LaunchGLAccountTransactionModule();
				
				//TC_03 ---> DefaultDateCheck
				GLTransaction.DefaultDateCheck();
				
				//TC_04 ---> DefaultBranchCheck
				GLTransaction.DefaultBranchCheck();
				
				//TC_05 ---> GLAccNameDropdownOptions
				GLTransaction.GLAccNameDropdownOptions();
				
				//TC_06 ---> GLAccNametoCodeMapping
				GLTransaction.GLAccNametoCodeMapping();
				
				//TC_07 ---> TransTypeDropdownOptions
				GLTransaction.TransTypeDropdownOptions();
				
				//TC_08 ---> GoButtonActionwithValidGLAccCode
				GLTransaction.GoButtonActionwithValidGLAccCode();
				
				//TC_09 ---> DisplayEntryonCheckboxClick
				GLTransaction.DisplayEntryonCheckboxClick();
				
				//TC_10 ---> NetPayableandRecoveryCalculation
				GLTransaction.NetPayableandRecoveryCalculation(testdata, context);
				
				//TC_11 ---> FieldPresenceBelowNetPayable
				GLTransaction.FieldPresenceBelowNetPayable();
				
				//TC_12 ---> TrnsmodeDropdownValidation
				GLTransaction.TrnsmodeDropdownValidation();
				
				//TC_13 ---> GLTransactionCreditandCash
				GLTransaction.GLTransactionCreditandCash();
				
				//TC_14 ---> EnterPartyNameforTransaction
				GLTransaction.EnterPartyNameforTransaction(testdata, context);
				
				//TC_15 ---> EnterParticularsforTransaction
				GLTransaction.EnterParticularsforTransaction(testdata, context);
				
				//TC_16 ---> GLTransactionsCreditandCash
				GLTransaction.GLTransactionsCreditandCash();
				
				//TC_17 ---> TransactionSummaryValidation
				GLTransaction.TransactionSummaryValidation();
				
				//TC_18 ---> LogintoNBFcApplicationinadifferentuser
				GLTransaction.LogintoNBFcApplicationinadifferentuser();
				
				//TC_19 ---> LogintoNBFcApplicationinadifferentuserlogin
				GLTransaction.LogintoNBFcApplicationinadifferentuserlogin();
				
				//TC_20 ---> LogintoNBFcApplicationinadifferentuserAuthorizeandcancel
				GLTransaction.LogintoNBFcApplicationinadifferentuserAuthorizeandcancel();
				
				//TC_21 ---> CashierAuthorisationRefresh
				GLTransaction.CashierAuthorisationRefresh();
				
				//TC_22 ---> SelectCashierCashTransaction
				GLTransaction.SelectCashierCashTransaction();
				
				//TC_23 ---> CashierCashAuthorization
				GLTransaction.CashierCashAuthorization();
				
				//TC_24 ---> ManagerCashAuthorisation
				GLTransaction.ManagerCashAuthorisation();
				
				//TC_25 ---> CashAuthorizationRefresh
				GLTransaction.CashAuthorizationRefresh();
				
				//TC_26 ---> SelectCashTransactionManagerAuthorisation
				GLTransaction.SelectCashTransactionManagerAuthorisation();
				
				//TC_27 ---> CashManagerAuthorization
				GLTransaction.CashManagerAuthorization();
				
			

				
				
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
