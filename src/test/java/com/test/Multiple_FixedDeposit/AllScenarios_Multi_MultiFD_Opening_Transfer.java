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

public class AllScenarios_Multi_MultiFD_Opening_Transfer extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;

	Customer_MultipleFD_Opening_Cash multifd = new Customer_MultipleFD_Opening_Cash();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Multiple_FD_Transfer");
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
				multifd.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Access Deposit Opening Window
				multifd.DepositOpeningWindow();

				// TC_03 -----> Customer Search and Selection
				multifd.customerSearchandSelectionWindow(testdata, context);
				
				//TC_04 ----> Enter Amount
				multifd.EnterAmount(testdata, context);

				// TC_05 ----> Enter Valid Duration
				multifd.EnterValidDuration(testdata, context);

				// TC_06 ----> Select Referral
				multifd.SelectReferral();
				
				//TC_07 ----> ROI and Due Date Calculation
				multifd.ROIandDueDateCalculation();
				
				//TC_08 ----> Ledger & Folio Number Entry
				multifd.LedgerandFolioNo(testdata, context);
				
				//TC_09 ----> Remark Field Entry
				multifd.Remark(testdata, context);
				
				//TC_10 ---->  Lien Mark Interaction(Checkbox)
				multifd.clickLienMarkCheckbox();
				
				//TC_11 ----> Lien Mark Interaction (Amount Field)
				multifd.EnterLienAmount(testdata, context);
				
				//TC_12 ---> Lien Mark Interaction (Lien Remark)
				multifd.EnterLienRemark(testdata, context);
				
				//TC_13 ---> Next Button Navigation
				multifd.NextButtonNavigation();
				
				//TC_14 ----> Nominee Tab Display
				multifd.NomineeCheckbox();
				
				//TC_15 ----> Enter customer ID in customer 
				multifd.EnterCustomerID();
				
				//TC_16 ---> Enter customer ID in customer Search Customer ID
				multifd.CustomerID(testdata, context);
				
				//TC_17 ---> Customer Nominee Search
				multifd.CustomerNomineeSearch(testdata, context);
				
				//TC_18 ---> Mandatory 'Name' Field Validation in Nominee
				multifd.MandatoryNameField(testdata, context);
				
				//TC_19 ----> Relation Dropdown List Validation
				multifd.RelationDropDown();
				
				//TC_20 ----> Mobile No Auto-fill in Nominee
				multifd.MobileNumberAutoFilled();
				
				//TC_21 ---> All Address Auto-fill in Nominee
				multifd.AddressAutofilled();
				
				//TC_22 ---> Date of Birth Details in Nominee
				multifd.DOBandAgeField();
				
				//TC_23 ---> Add Nominee Details
				multifd.AddNomineeBtn();
				
				//TC_24 ---> Operator Tab Navigation
				multifd.OperatorTabNavigation();
				
				//TC_25 ---> Operator Search and Selection
				multifd.OperatorCustomerID();
				
				//TC_26 ---> Enter customer ID in customer 
				multifd.OperatorCustomerIDSearch(testdata, context);
				
				//TC_27 ---> Operator Customer Search and Selection
				multifd.OperatorCustomerIDSelection(testdata, context);
				
				//TC_28 ---> Operator Relation Entry
				multifd.OperatorRelationDesig(testdata, context);
				
				//TC_29 ---> Operator Remark Entry
				multifd.OperatorRemarkEntry(testdata, context);
				
				//TC_30 ---> Operator Details Addition
				multifd.AddOperatorBtn();
				
				//TC_31 ---> Interest Transfer Tab Presence
				multifd.InterestTransferTabPresence();
				
				//TC_32 ---> Interest Transfer Requirements
				multifd.InterestTransferRequiredCheckbox();
				
				//TC_33 ----> Interest Transfer Data Entry
				multifd.ProductDropdown(testdata, context);
				
				//TC_34 ---> Interest Transfer Data Entry
				multifd.EnterFrequency(testdata, context);
				
				//TC_35 ---> On Maturity Tab Navigation
				multifd.OnMaturityTabNavigation();
				
				//TC_36 ----> Maturity Action Selection
				multifd.MaturityActionSelection();
				
				//TC_37 ---> Multiple Account Checkbox
				multifd.MultipleAccountCheckbox();
				
				//TC_38 ----> Multiple Account Checkbox
				multifd.IsMultipleAccount(testdata, context);
				
				//TC_39 ---> Final Deposit Configuration
				multifd.FinalDepositConfiguration(testdata, context);
				
				//TC_40 ---> Cashier Authorization
				multifd.CashierAuthorization(testdata, context);
				
				//TC_41 ---> Cashier Authorization
				multifd.CashierAuthorizationRefresh();
				
				//TC_42 ---> Cashier Authorization
				multifd.CashierAuthorizationSelectCheckBox();
				
				//TC_43 ---> Cashier Authorization
				multifd.CashierAuthorizationAuthorize();
				
				//TC_44 ---> Manager Authorization
				multifd.ManagerAuthorization();
				
				//TC_45 ---> Manager Authorization
				multifd.ManagerAuthorizationRefresh();
				
				//TC_46 ---> Manager Authorization
				multifd.ManagerAuthorizationSelectCheckBox();
				
				//TC_47 ---> Manager Authorization
				multifd.ManagerAuthorizationAuthorize();
				
				
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
