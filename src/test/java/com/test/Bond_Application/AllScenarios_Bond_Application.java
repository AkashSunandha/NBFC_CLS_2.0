package com.test.Bond_Application;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.JewelLoan_Closure.JewelLoan_Closure_Cash_Transfer;
import com.Page_Customer.Customer_NewCustomer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.bondApplication.Bond_Application;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Bond_Application {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	JewelLoan_Closure_Cash_Transfer JLoanClosure = new JewelLoan_Closure_Cash_Transfer();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	Bond_Application bonapp = new Bond_Application();

	@BeforeClass
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("BondApp");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void newCustomer(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("BondApplication");
				Log.info(" Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				// TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				custSrchMthds.pcRegistration(testdata, context);

				custSrchMthds.userLoginValidPaswrd(testdata, context);

				bonapp.BondApplicationWindowNavigation();
				bonapp.Verifyproductselection();

				bonapp.NatureFieldDropdownselection();

				bonapp.CustomerSearchPopupVerification(testdata, context);

				bonapp.AddCustomerDetailstoGrid();

				bonapp.NoofUnitFieldValidation(testdata, context);

				bonapp.DurationFieldAutoloadVerification();

				bonapp.GetValueButtonFunctionality();

				// bonapp.AddButtonFunctionalitywithCompleteData();

				bonapp.FillNomineeDetailsTab();

				bonapp.FillNomineeDetailsTab2();

				bonapp.FillNomineeDetailsTab3(testdata, context);

				bonapp.FillNomineeDetailsTab33();

				bonapp.FillNomineeDetailsTab5();

				bonapp.NavigatetoInterestTransferTab();

				bonapp.Fillinteresttransferdetails(testdata, context);

				bonapp.PaymentModeSelection();

				bonapp.SaveAllButtonFunctionalitywithPaymentMode();
				
				bonapp.logoutApplication1();
				
				bonapp.ManagerLoginforAuthorization();
				
				bonapp.ManagerAuthorizationRefresh();
				
				//bonapp.AuthorizeapplicationEntry(testdata, context);

				bonapp.logoutApplication2();
				

				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
			Log.info("Exception " + e);
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