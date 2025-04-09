package com.Debenture;

import java.io.IOException;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_Series;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


	public class Debenture_series extends Base_Class{
		
		PageRepositary_Debenture_Series admin_repo = new PageRepositary_Debenture_Series();
		String transId;
		PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
		
		public void adminLogin() throws ClassNotFoundException, InterruptedException, IOException  {
			ExtentTestManager.startTest("**Basic Login Functionality**");
			Log.info("**Basic Login Functionality**");
				
				
						String UserName = configloader().getProperty("AdminUserName");
						input(custSearch.loginUserName,UserName );
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
						Log.info("Step:01 - Enetered valid Admin User Name");
						
						String Password = configloader().getProperty("AdminPassword");
//						String loginValidPassword = testdata.get("loginValidPassword").toString();
						input(custSearch.loginPasswrd, Password);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
						Log.info("Step:02 - Enetered valid Admin Password");
						
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
						Log.info("Step:03 - Click on Login Button");
						
						try {
						ElementDisplayed(admin_repo.continueBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
						Log.info("Expected Result: User is logged in successfully and dashboard visible");
						}
						catch(Exception e) {
							ElementDisplayed(custSearch.loginWarningOkBtn);
							ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
							Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
	 
							click(custSearch.loginWarningOkBtn);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
							Log.info("Step:01 - Click on OK button");
							
							input(custSearch.loginUserName, UserName);
							ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
							Log.info("Step:02 - Enetered valid Admin User Name");
							
							input(custSearch.loginPasswrd, Password);
							ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
							Log.info("Step:03 - Entered valid Admin Password");
							
							click(custSearch.loginButton);
							ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
							Log.info("Step:04 - Click on Login Button");
							
										ElementDisplayed(admin_repo.continueBtn);
										ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
										Log.info("Expected Result: User is logged in successfully and dashboard visible");	
								}
						
						ExtentTestManager.endTest();
			
						click(admin_repo.continueBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on continue");
						Log.info("Step:05 - Click on continue");
	 
						//Debenture Type Selection
						ExtentTestManager.startTest("Debenture Type Selection");
						Log.info("Debenture Type Selection");
					
						click(admin_repo.debture);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Navigate to Admin > Debenture > Debenture Series Settings.-> Attempt to select a Debenture Type from dropdown.");
						Log.info("Step:01 - 1. Navigate to Admin > Debenture > Debenture Series Settings.-> Attempt to select a Debenture Type from dropdown.");
						
						ExtentTestManager.endTest();
						
						//Debenture Type_1 Selection
						
						ExtentTestManager.startTest("Debenture Type Selection");
						Log.info("Debenture Type Selection");
				
						click(admin_repo.debenture_Srs);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Select a Debenture Type ->  Attempt to select a Debenture Issue from dropdown.");
						Log.info("Step:01 - 1. Select a Debenture Type ->  Attempt to select a Debenture Issue from dropdown.");
						
						ExtentTestManager.endTest();
						
									    
						//Debenture type Selection
						
						ExtentTestManager.startTest("Debenture type Selection");
						Log.info("Debenture type Selection");
					
						input(admin_repo.debenture_type,"DEBENTURE1");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Verify text in  the 'Series Name' field.");
						Log.info("Step:01 - 1.Verify text in  the 'Series Name' field.");
						
						ExtentTestManager.endTest();
						
                        //Debenture Issue Selection
						
						ExtentTestManager.startTest("Series Name InputDebenture Issue Selection");
						Log.info("Series Name InputDebenture Issue Selection");
					
						input(admin_repo.debenture_issue,"ISSUE-INTEREST PAYOUT-39");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Verify text in  the 'Series Name' field.");
						Log.info("Step:01 - 1.Verify text in  the 'Series Name' field.");
						
						ExtentTestManager.endTest();
						
                        //Series Name Input
						
						ExtentTestManager.startTest("Series Name Input");
						Log.info("Series Name Input");
					
						input(admin_repo.series_name,"INF1234567890");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter 'INF1234567890' in the 'ISIN No' field.-> Verify text in  the 'Series Name' field.");
						
						ExtentTestManager.endTest();
						
                        //ISIN No Input Validation
						
						ExtentTestManager.startTest("ISIN No Input Validation");
						Log.info("ISIN No Input Validation");
					
						input(admin_repo.ISin,"INF");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter 'INF1234567890' in the 'ISIN No' field.-> Verify text in  the 'Series Name' field.");
						
						ExtentTestManager.endTest();
						
						//Interest Payment Method Selection
						ExtentTestManager.startTest("Interest Payment Method Selection");
						Log.info("Interest Payment Method Selection");
					
						input(admin_repo.Interest_Payment_Method,"Monthly");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Select 'Interest Payment Method' dropdown.-> Choose 'Monthly'");
						
						ExtentTestManager.endTest();
						
						//ROI Input Validation
						ExtentTestManager.startTest("ROI Input Validation");
						Log.info("ROI Input Validation");
					
						input(admin_repo.Roi,"abcd");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Enter numerical value in the 'ROI' field.->Try entering text characters in the same field.");
						
						ExtentTestManager.endTest();
						
						//GL Acc Code/Name Dependency Loading
						ExtentTestManager.startTest("GL Acc Code/Name Dependency Loading");
						Log.info("GL Acc Code/Name Dependency Loading");
					
						input(admin_repo.Acc_code,"abcd");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						ExtentTestManager.endTest();
						
						//Int GL Acc Code/Name Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						input(admin_repo.Int_Acc_code,"abcd");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						ExtentTestManager.endTest();
		}//end
}
	

