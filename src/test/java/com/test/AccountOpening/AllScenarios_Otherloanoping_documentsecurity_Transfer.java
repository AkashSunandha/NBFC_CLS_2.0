package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.AccountOpening_Otherloanopening_documentsecurity_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Otherloanoping_documentsecurity_Transfer {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	//PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	//Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();

	//Admin_UserCreation userCreate = new Admin_UserCreation();
	//Customer_InstitutionalCust instituCust = new Customer_InstitutionalCust();
	//PageRepository_Cust_InstitutionalCust institutionalCust = new PageRepository_Cust_InstitutionalCust();


	AccountOpening_Otherloanopening_documentsecurity_Transfer personalLoan = new AccountOpening_Otherloanopening_documentsecurity_Transfer();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Otherloanoping_documentsecurity");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}


	@Test(dataProvider = "TestData")
	public void loanOpeningModule(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//Application launch (1)
				ExtentTestManager.startTest("TC No. - 01 --> Launch NBFC Application");
				ExtentTestManager.getTest().log(Status.PASS, "Step-1: Launch NBFC application.");
				Log.info("Step-1: Launch NBFC application.");
				
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				//					String pcRegFormName = testdata.get("pcRegFormName").toString();
				//					String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();
				//					String loginUserName = testdata.get("loginUserName").toString();
				//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				//					String validCustId = testdata.get("validCustId").toString();

				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				//TC-02
				personalLoan.userLogin(testdata, context);

				//TC-03
				personalLoan.testSelectActiveLoanProduct();


				//TC-04,05
				personalLoan.testAddCustomer(testdata, context);

				//TC-06
				personalLoan.testResolutionNoField(testdata, context);


				//TC-07
				personalLoan.testResolutionDateField(testdata, context);


				//TC-09
				personalLoan.testEquiMortRegNoField(testdata, context);

				//TC-10
				personalLoan.testSelectEMRDate(testdata, context);

				//TC-11
				personalLoan.testAgentCode(testdata, context);

				//TC-12
				personalLoan.testDSACode(testdata, context);

				
				//personalLoan.testAreaField(testdata, context);

				//TC-13
				personalLoan.testRemarksField(testdata, context);

				//TC-14
				personalLoan.testNextBtnFunctionality1();


				//TC-15
				personalLoan.testDocumentTab();
				
				personalLoan.testAddBtn();

				//TC-16
				personalLoan.testSROfficeField();

				//TC-17
				personalLoan.testRegYear(testdata, context);

				//TC-18
				personalLoan.testDocNo(testdata, context);

				//TC-20
				personalLoan.testRegDate(testdata, context);


				//TC-19
				personalLoan.testSurveyNo(testdata, context);


				//TC-21
				personalLoan.testWorth(testdata, context);

				//TC-22
				personalLoan.testMarketGahanVal(testdata, context);

				//TC-23
				personalLoan.testAddBtnInDocSection();

				//TC-24
				personalLoan.testNextBtnFunc();


				//TC-25
				personalLoan.testCheckboxFunctioanlity();


				//	personalLoan.testAddCustomer1(testdata, context);


				//TC-26
				personalLoan.testAadharNo();

				//TC-27
				personalLoan.testNameInNominee(testdata, context);
				
				//TC-28
				personalLoan.testSelectRelation();

				//TC-29
				personalLoan.testDistrictDropdown();

				//TC-30
				personalLoan.testPostDropdown();

				//TC-32
				personalLoan.testDOBField(testdata, context);


				//TC-33
				personalLoan.testAddBtnFunctionality2();

				//TC-34
				personalLoan.testNextBtnFunctionality3();

				//TC-35
				personalLoan.testSanctionAmount(testdata, context);

				//TC-36
				personalLoan.testGetValueBtn();

				//TC-37
				personalLoan.testSelectTransactionMode1();

				//TC-38
				personalLoan.testPostCredit();
				
				//TC-39
				personalLoan.testTransactionBased(testdata, context);
				
				//TC-40
				personalLoan.testGLName(testdata, context);
				
				//TC-41
				personalLoan.testAmount(testdata, context);
				
				//TC-42
				personalLoan.testSubmit();

				//TC-43
				personalLoan.testSaveBtnFunc();

				
				Thread.sleep(5000);
				personalLoan.signOut();

				//TC-44
				personalLoan.userLogin1(testdata, context);

				//TC-45
				personalLoan.testManagerAuthorizationInTransfer(testdata, context);

				//TC-46
				//personalLoan.testRefreshBtn();

				//TC-47
				personalLoan.testSelectAndAuthorize();
                
				
				personalLoan.testCloseMessagePopup();
				//TC-54
				Thread.sleep(5000);
				personalLoan.signOut();
				
				
				// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				
			}		
		}catch(Exception e) {
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
