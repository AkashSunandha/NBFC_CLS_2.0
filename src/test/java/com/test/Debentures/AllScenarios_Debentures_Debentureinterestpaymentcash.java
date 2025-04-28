package com.test.Debentures;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Debenture.Debenture_DebentureAllotment;
import com.Page_Debenture.Debenture_DebentureInterestPaymentTransferCash;
import com.Page_Repositary.PageRepositary_Debenture_DebentureAllotment;
import com.Page_Repositary.PageRepositary_Debenture_DebentureInterestPaymentCash;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


//public class AllScenarios_Debentures_Debentureinterestpaymentcash {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		public class AllScenarios_Debentures_Debentureinterestpaymentcash extends Base_Class {
			
			com.Utility.ExcelReader ExcelReader;
			
			Base_Class Base_Class;
			
			Log log;
			
			TestListener TestListener; 
			
			com.Utility.ScreenShot screenShot;
			
			
			
			PageRepositary_Debenture_DebentureInterestPaymentCash IntCash = new PageRepositary_Debenture_DebentureInterestPaymentCash();
			
			com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
			

			Debenture_DebentureInterestPaymentTransferCash IntPaymentCashMthds = new Debenture_DebentureInterestPaymentTransferCash();
			
			
			@BeforeSuite
			public void reference() {
				ExcelReader = new com.Utility.ExcelReader("DebtIntpaymentcash");
				log = new Log();
				TestListener = new TestListener();
				screenShot = new com.Utility.ScreenShot(null);
				Base_Class = new Base_Class();
			
			}
		
			@Test(dataProvider = "TestData")
			public void Debenture(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
				try {
					if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
						ExtentTestManager.startTest(testdata.get("TestScenario").toString());
						Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
						context.setAttribute("fileName", "Login");
//						ExtentTestManager.endTest();
						
						
						//Application launch
						ExtentTestManager.startTest("Firefox Driver & Application Launch");
						Base_Class.SetUp();
						ExtentTestManager.endTest();
						Thread.sleep(2000);
						
					}

						//PC Registration
						custSrchMthds.pcRegistration(testdata, context);
					
					
						//TC No. 2 User Login
						custSrchMthds.userLoginValidPaswrd(testdata, context);
						
					
						//TC No. 03 --> Debenture Window
						
						IntPaymentCashMthds.navigateToDebenture();
						
						//IntPaymentCashMthds.branchdropdown();
						
						//TC No. 04 - Debenture type drop down
						
						IntPaymentCashMthds.debenturetypedropdown();
						
						//TC No. 05 -- issue type drop down
						
						IntPaymentCashMthds.issuetypedropdown();
						
						//TC No. 06 -- series type drop down
						
						IntPaymentCashMthds.seriesdropdown();
						
						//TC No. 07 -Account number field
						
						IntPaymentCashMthds.accnumber(testdata,context);
						
						//TC No. 12 - Duration field.
						
						IntPaymentCashMthds.durationclass(testdata,context);
						
						
						
						//TC No. 16 - submit button
											
						IntPaymentCashMthds.submitbutton();
						
						
						//TC No.18 -print button
						
						 IntPaymentCashMthds .printbutton();
						 
						 
						
						//TC No.19,20,21,22,23,24 -logout & authorize
						
						
						 IntPaymentCashMthds.logout_authorize(testdata,context);
						
						
						
					
						
						
						ExtentManager.getInstance().flush();
					
			
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

			
	
	
		
	
	
					
	
	
	
	
	
	
	
	
	


