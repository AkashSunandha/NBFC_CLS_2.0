package com.test.Multiple_FixedDeposit;

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

public class AllScenarios_Multi_MultiFD_Opening_Cash extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	//Customer_MultipleFD_Opening_Cash multifd = new Customer_MultipleFD_Opening_Cash();
	Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Multiple_FD_Cash");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void Multi_MultiFD_Opening(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		try {
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();

				// Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();

				// PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				// TC_01 ---> Login to NBFC Application
				multifdCash.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Access Deposit Opening Window
				multifdCash.DepositOpeningWindow();

				// TC_03 -----> Customer Search and Selection
				multifdCash.customerSearchandSelectionWindow(testdata, context);
				
				//TC_04 ----> Enter Amount
				multifdCash.EnterAmount(testdata, context);

				// TC_05 ----> Enter Valid Duration
				multifdCash.EnterValidDuration(testdata, context);

				// TC_06 ----> Select Referral
				multifdCash.SelectReferral();
				
				//TC_07 ----> ROI and Due Date Calculation
				multifdCash.ROIandDueDateCalculation();
				
				//TC_08 ----> Ledger & Folio Number Entry
				multifdCash.LedgerandFolioNo(testdata, context);
				
				//TC_09 ----> Remark Field Entry
				multifdCash.Remark(testdata, context);
				
				//TC_10 ---->  Lien Mark Interaction(Checkbox)
				multifdCash.clickLienMarkCheckbox();
				
				//TC_11 ----> Lien Mark Interaction (Amount Field)
				multifdCash.EnterLienAmount(testdata, context);
				
				//TC_12 ---> Lien Mark Interaction (Lien Remark)
				multifdCash.EnterLienRemark(testdata, context);
				
				//TC_13 ---> Next Button Navigation
				multifdCash.NextButtonNavigation();
				
				//TC_14 ----> Nominee Tab Display
				multifdCash.NomineeCheckbox();
				
				//TC_15 ----> Enter customer ID in customer 
				multifdCash.EnterCustomerID();
				
				//TC_16 ---> Enter customer ID in customer Search Customer ID
				multifdCash.CustomerID(testdata, context);
				
				//TC_17 ---> Customer Nominee Search
				multifdCash.CustomerNomineeSearch(testdata, context);
				
				//TC_18 ---> Mandatory 'Name' Field Validation in Nominee
				multifdCash.MandatoryNameField(testdata, context);
				
				//TC_19 ----> Relation Dropdown List Validation
				multifdCash.RelationDropDown();
				
				//TC_20 ----> Mobile No Auto-fill in Nominee
				multifdCash.MobileNumberAutoFilled();
				
				//TC_21 ---> All Address Auto-fill in Nominee
				multifdCash.AddressAutofilled();
				
				//TC_22 ---> Date of Birth Details in Nominee
				multifdCash.DOBandAgeField();
				
				//TC_23 ---> Add Nominee Details
				multifdCash.AddNomineeBtn();
				
				//TC_24 ---> Operator Tab Navigation
				multifdCash.OperatorTabNavigation();
				
				//TC_25 ---> Operator Search and Selection
				multifdCash.OperatorCustomerID();
				
				//TC_26 ---> Enter customer ID in customer 
				multifdCash.OperatorCustomerIDSearch(testdata, context);
				
				//TC_27 ---> Operator Customer Search and Selection
				multifdCash.OperatorCustomerIDSelection(testdata, context);
				
				//TC_28 ---> Operator Relation Entry
				multifdCash.OperatorRelationDesig(testdata, context);
				
				//TC_29 ---> Operator Remark Entry
				multifdCash.OperatorRemarkEntry(testdata, context);
				
				//TC_30 ---> Operator Details Addition
				multifdCash.AddOperatorBtn();
				
				//TC_31 ---> Interest Transfer Tab Presence
				multifdCash.InterestTransferTabPresence();
				
				//TC_32 ---> Interest Transfer Requirements
				multifdCash.InterestTransferRequiredCheckbox();
				
				//TC_33 ----> Interest Transfer Data Entry
				multifdCash.ProductDropdown(testdata, context);
				
				//TC_34 ---> Interest Transfer Data Entry
				multifdCash.EnterFrequency(testdata, context);
				
				//TC_35 ---> On Maturity Tab Navigation
				multifdCash.OnMaturityTabNavigation();
				
				//TC_36 ----> Maturity Action Selection
				multifdCash.MaturityActionSelection();
				
				//TC_37 ---> Multiple Account Checkbox
				multifdCash.MultipleAccountCheckbox();
				
				//TC_38 ----> Multiple Account Checkbox
				multifdCash.IsMultipleAccount(testdata, context);
				
				//TC_39 ---> Final Deposit Configuration
				multifdCash.FinalDepositConfiguration(testdata, context);
				
				//TC_40 ---> Cashier Authorization
				multifdCash.CashierAuthorization(testdata, context);
				
				//TC_41 ---> Cashier Authorization
				multifdCash.CashierAuthorizationRefresh();
				
				//TC_42 ---> Cashier Authorization
				multifdCash.CashierAuthorizationSelectCheckBox(testdata, context);
				
				//TC_43 ---> Cashier Authorization
				multifdCash.CashierAuthorizationAuthorize();
				
				//TC_44 ---> Manager Authorization
				multifdCash.ManagerAuthorization();
				
				//TC_45 ---> Manager Authorization
				multifdCash.ManagerAuthorizationRefresh();
				
				//TC_46 ---> Manager Authorization
				multifdCash.ManagerAuthorizationSelectCheckBox();
				
				//TC_47 ---> Manager Authorization
				multifdCash.ManagerAuthorizationAuthorize();
				
				
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
