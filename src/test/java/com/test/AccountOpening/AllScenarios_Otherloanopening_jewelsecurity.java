package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.AccountOpening_Otherloanopening_jewelsecurity;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Otherloanopening_jewelsecurity {

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


		AccountOpening_Otherloanopening_jewelsecurity personalLoan = new AccountOpening_Otherloanopening_jewelsecurity();

		@BeforeClass
		public void reference() {
			ExcelReader = new com.Utility.ExcelReader("Otherloanopeningjewelsecurity-C");
			log = new Log();
			TestListener = new TestListener();
			screenShot = new com.Utility.ScreenShot(null);
			Base_Class = new Base_Class();
		}


		@Test(dataProvider = "TestData")
		public void loanOpeningModule(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
			try {
				if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
					ExtentTestManager.startTest(testdata.get("TestScenario").toString()).assignCategory("Other Loan Opening Cash -Jewel Security");
					Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
					context.setAttribute("fileName", "Login");

					//Application launch
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
					custSrchMthds.userLoginValidPaswrd(testdata, context);
					
					//TC-03
					personalLoan.testSelectActiveLoanProduct();
					
					
					//TC-04
					personalLoan.testAddCustomer(testdata, context);
					
					//TC-05
					personalLoan.testResolutionNoField(testdata, context);
					
					
					//TC-06
					personalLoan.testResolutionDateField(testdata, context);
					
					
					//TC-08
					personalLoan.testEquiMortRegNoField(testdata, context);
					
					//TC-09
					personalLoan.testSelectEMRDate(testdata, context);
					
					//TC-10
					personalLoan.testAgentCode(testdata, context);
					
					//TC-11
					personalLoan.testDSACode(testdata, context);
					
					//TC-12
					//personalLoan.testAreaField(testdata, context);
					
					//TC-13
					personalLoan.testRemarksField(testdata, context);
					
					//TC-14
					personalLoan.testNextBtnFunctionality1();
					
					
					//TC-16
					personalLoan.testItemQtyField(testdata, context);
					
					//TC-17
					personalLoan.testIemWeight(testdata, context);
					
					//TC-18
					personalLoan.testEnterPurity(testdata, context);
					
					//TC-19
					personalLoan.testAddBtnFunctionality();
					
					//TC-20
					personalLoan.testNextBtnFunctionality2();
					
					//TC-21
					personalLoan.testCheckboxFunctioanlity();
					
					
					//personalLoan.testAddCustomer1(testdata, context);
					
					//TC-22
					personalLoan.testAadharNo();
					
					//TC-23
					personalLoan.testNameInNominee(testdata, context);
					
					
					//TC-24
					personalLoan.testSelectRelation();
					
					//TC-25
					personalLoan.testDistrictDropdown();
					
					//TC-26
					personalLoan.testPostDropdown();
					
					//TC-28
					personalLoan.testDOBField(testdata, context);
				
					
					//TC-29
					personalLoan.testAddBtnFunctionality2();
					
					//TC-30
					personalLoan.testNextBtnFunctionality3();
					
					//TC-31
					personalLoan.testSanctionAmount(testdata, context);
					
					//TC-32
					personalLoan.testGetValueBtn();
					
					//TC-33
					personalLoan.testSelectTransactionMode();
					
					//TC-34
					Thread.sleep(5000);
					personalLoan.signOut();

					//TC-35
					personalLoan.userLogin1(testdata, context);
					
					//TC-36
					personalLoan.testManagerAuthorization(testdata, context);
					
					//TC-37
					//personalLoan.testRefreshBtn();
					
					//TC-38
					personalLoan.testSelectAndAuthorize();
					
					//TC-40
					personalLoan.testCashierAuthorization();
					
					//TC-41
					personalLoan.testSelectAndAuthorizeInCashier(testdata, context);
					
					
					Thread.sleep(5000);
					personalLoan.signOut();
					
					personalLoan.windowclose();

					
					// EndTest
					ExtentTestManager.endTest();
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

