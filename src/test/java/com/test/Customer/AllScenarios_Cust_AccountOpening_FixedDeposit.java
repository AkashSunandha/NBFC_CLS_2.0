package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_AccountOpening_FixedDeposit;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Cust_AccountOpening_FixedDeposit {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_AccountOpening_FixedDeposit fixeddeposit= new Customer_AccountOpening_FixedDeposit();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("AccountOpening_FixedDeposit");
		
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	@Test(dataProvider = "TestData")
	public void customerRegister( Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();
				
				
				//Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				


				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
			
			    //TC 01
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				//TC 02
				fixeddeposit.DepositOpeningWindow();
				
				//TC 03
				fixeddeposit.customerSearchFunctionality(testdata, context);
				
				//TC04
				fixeddeposit.EnterAmount(testdata, context);
				
				//TC05
				fixeddeposit.DurationEntry(testdata, context);
				
				//TC06
				fixeddeposit.SelectReferredbyOption(testdata, context);
				
				//TC07
				fixeddeposit.ROIvalidation();
				
				//TC08
				fixeddeposit.ModeofOperation();
				
				//TC09
				//fixeddeposit.Selectnature();
				
				
				//TC11
				fixeddeposit.LedgerandFolioNumberEntry(testdata, context);
				
				//TC12
				fixeddeposit.RemarkFieldEntry(testdata, context);
				
				//TC13
				fixeddeposit.LienMarkFunctionality(testdata);
				
				//TC14
				fixeddeposit.NavigateThroughTabs();
				
				//TC15
				fixeddeposit.AddNomineeandValidateAutofill(testdata);
				
				//TC16
				fixeddeposit.AddOperatorandValidate(testdata);
				
				//TC17
				fixeddeposit.Interest_Transfer_Requirements(testdata);
				
				//TC18
				fixeddeposit.next_button_functioanlity();
				
				//TC19
				fixeddeposit.On_Maturity_Settings(); 
				
			//TC21
				fixeddeposit.Login_with_Another_User(testdata, context);
				
				//TC22
				fixeddeposit.Cashier_Authorization();
				
				//TC23
				fixeddeposit.Manager_Authorization_Cash_Tab();
				
				
				//TC25
				fixeddeposit.Refresh_Loan_Opening_Entry();
				
				
				//TC26
				fixeddeposit.Authorize_Loan_Entry_as_Manager();
				
				 
				
			 
				//TC20
				fixeddeposit.Deposit_opening_Transfer(testdata, context);
				
				//==============================++++++++++++++++++++++++++++++++++============================
				//TC21
				// fixeddeposit.Transaction_Based (testdata, context);
				
			     // TC22
				// fixeddeposit.GL_Name (testdata, context);
				
				 // TC23
				 //fixeddeposit.AutopostingAmount(testdata, context);
				
				// TC24
				 //fixeddeposit.Add();
				 
		        // TC25
				 //fixeddeposit.submit();
				 //==============================++++++++++++++++++++++++++++++++++============================

				 
				 
				 
				 // TC26 
				 fixeddeposit.save(); 
				 
			    //TC27
				fixeddeposit.Login_with_Another_User_transferauthorize(testdata, context);
				
			
		        //TC28
				fixeddeposit.Manager_Authorization_Transfer_Tab(); 
				
				//TC 29
				fixeddeposit.Transfertab(); 
				
				//TC30
				fixeddeposit.RefreshLoan_Opening_TransferEntry(); 
				
				
				//TC31
				fixeddeposit.AuthorizeLoan_Entry_as_ManagerTransfertab(); 
			
				
				//Sign out
				custSrchMthds.logout(); 		
				
				
				// EndTest
//				ExtentTestManager.endTest();
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
