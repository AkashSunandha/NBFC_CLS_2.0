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
import com.Page_Multiple_FixedDeposit.Customer_MultipleFD_Opening_Transfer;
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

	//Customer_MultipleFD_Opening_Cash multifdCash = new Customer_MultipleFD_Opening_Cash();
	Customer_MultipleFD_Opening_Transfer multifdTransfer = new Customer_MultipleFD_Opening_Transfer();
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
	public void Multi_MultiFD_Opening_Transfer(Map<Object, Object> testdata, ITestContext context)
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
				multifdTransfer.userLoginValidPaswrd(testdata, context);

				// TC_02 ----> Access Deposit Opening Window
				multifdTransfer.DepositOpeningWindow();

				// TC_03 -----> Customer Search and Selection
				multifdTransfer.customerSearchandSelectionWindow(testdata, context);
				
				//TC_04 ----> Enter Amount
				multifdTransfer.EnterAmount(testdata, context);

				// TC_05 ----> Enter Valid Duration
				multifdTransfer.EnterValidDuration(testdata, context);

				// TC_06 ----> Select Referral
				multifdTransfer.SelectReferral();
				
				//TC_07 ----> ROI and Due Date Calculation
				multifdTransfer.ROIandDueDateCalculation();
				
				//TC_08 ----> Ledger & Folio Number Entry
				multifdTransfer.LedgerandFolioNo(testdata, context);
				
				//TC_09 ----> Remark Field Entry
				multifdTransfer.Remark(testdata, context);
				
				//TC_10 ---->  Lien Mark Interaction(Checkbox)
				multifdTransfer.clickLienMarkCheckbox();
				
				//TC_11 ----> Lien Mark Interaction (Amount Field)
				multifdTransfer.EnterLienAmount(testdata, context);
				
				//TC_12 ---> Lien Mark Interaction (Lien Remark)
				multifdTransfer.EnterLienRemark(testdata, context);
				
				//TC_13 ---> Next Button Navigation
				multifdTransfer.NextButtonNavigation();
				
				//TC_14 ----> Nominee Tab Display
				multifdTransfer.NomineeCheckbox();
				
				//TC_15 ----> Enter customer ID in customer 
				multifdTransfer.EnterCustomerID();
				
				//TC_16 ---> Enter customer ID in customer Search Customer ID
				multifdTransfer.CustomerID(testdata, context);
				
				//TC_17 ---> Customer Nominee Search
				multifdTransfer.CustomerNomineeSearch(testdata, context);
				
				//TC_18 ---> Mandatory 'Name' Field Validation in Nominee
				multifdTransfer.MandatoryNameField(testdata, context);
				
				//TC_19 ----> Relation Dropdown List Validation
				multifdTransfer.RelationDropDown();
				
				//TC_20 ----> Mobile No Auto-fill in Nominee
				multifdTransfer.MobileNumberAutoFilled();
				
				//TC_21 ---> All Address Auto-fill in Nominee
				multifdTransfer.AddressAutofilled();
				
				//TC_22 ---> Date of Birth Details in Nominee
				multifdTransfer.DOBandAgeField();
				
				//TC_23 ---> Add Nominee Details
				multifdTransfer.AddNomineeBtn();
				
				//TC_24 ---> Operator Tab Navigation
				multifdTransfer.OperatorTabNavigation();
				
				//TC_25 ---> Operator Search and Selection
				multifdTransfer.OperatorCustomerID();
				
				//TC_26 ---> Enter customer ID in customer 
				multifdTransfer.OperatorCustomerIDSearch(testdata, context);
				
				//TC_27 ---> Operator Customer Search and Selection
				multifdTransfer.OperatorCustomerIDSelection(testdata, context);
				
				//TC_28 ---> Operator Relation Entry
				multifdTransfer.OperatorRelationDesig(testdata, context);
				
				//TC_29 ---> Operator Remark Entry
				multifdTransfer.OperatorRemarkEntry(testdata, context);
				
				//TC_30 ---> Operator Details Addition
				multifdTransfer.AddOperatorBtn();
				
				//TC_31 ---> Interest Transfer Tab Presence
				multifdTransfer.InterestTransferTabPresence();
				
				//TC_32 ---> Interest Transfer Requirements
				multifdTransfer.InterestTransferRequiredCheckbox();
				
				//TC_33 ----> Interest Transfer Data Entry
				multifdTransfer.ProductDropdown(testdata, context);
				
				//TC_34 ---> Interest Transfer Data Entry
				multifdTransfer.EnterFrequency(testdata, context);
				
				//TC_35 ---> On Maturity Tab Navigation
				multifdTransfer.OnMaturityTabNavigation();
				
				//TC_36 ----> Maturity Action Selection
				multifdTransfer.MaturityActionSelection();
				
				//TC_37 ---> Multiple Account Checkbox
				multifdTransfer.MultipleAccountCheckbox();
				
				//TC_38 ----> Multiple Account Checkbox
				multifdTransfer.IsMultipleAccount(testdata, context);
				
				//TC_39 ---> Final Deposit Configuration
				multifdTransfer.FinalDepositConfiguration(testdata, context);
				
				//TC_40 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionTransfer(testdata, context);
				
				//TC_41 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionTransactionBased(testdata, context);
				
				//TC_42 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionGLNameDropdown(testdata, context);
				
				//TC_43 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionAmount(testdata, context);
				
				//TC_44 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionSubmitButton(testdata, context);
				
				//TC_45 ---> Deposit Submission Transfer
				multifdTransfer.DepositSubmissionSaveButton(testdata, context);
				
				//TC_46 ---> Manager authorization
				multifdTransfer.ManagerAuthorization(testdata, context);
				
				//TC_47 ----> Manager authorization
				multifdTransfer.ManagerAuthorizationTransfer();
				
				//TC_48 ---> Manager authorization
				multifdTransfer.ManagerAuthorizationRefresh();
				
				//TC_49 ---> Manager authorization
				multifdTransfer.ManagerAuthorizationSelectCheckBox();
				
				//TC_50 ----> Manager authorization
				multifdTransfer.ManagerAuthorizationAuthorize();
				
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
