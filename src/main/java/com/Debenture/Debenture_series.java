package com.Debenture;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_Series;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


	public class Debenture_series extends Base_Class{
		
		// changes
		PageRepositary_Debenture_Series admin_repo = new PageRepositary_Debenture_Series();
		String transId;
		PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
		
		public void adminLogin(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
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
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Debenture Type_1 Selection
						
						ExtentTestManager.startTest("Debenture Type Selection");
						Log.info("Debenture Type Selection");
				
						click(admin_repo.debenture_Srs);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Select a Debenture Type ->  Attempt to select a Debenture Issue from dropdown.");
						Log.info("Step:01 - 1. Select a Debenture Type ->  Attempt to select a Debenture Issue from dropdown.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
									    
						//Debenture type Selection
						
						ExtentTestManager.startTest("Debenture type Selection");
						Log.info("Debenture type Selection");
					
						input(admin_repo.debenture_type,"DEBENTURE1");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Verify text in  the 'Series Name' field.");
						Log.info("Step:01 - 1.Verify text in  the 'Series Name' field.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
                        //Debenture Issue Selection
						
						ExtentTestManager.startTest("Series Name InputDebenture Issue Selection");
						Log.info("Series Name InputDebenture Issue Selection");
					
						input(admin_repo.debenture_issue,"ISSUE-INTEREST PAYOUT-39");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Verify text in  the 'Series Name' field.");
						Log.info("Step:01 - 1.Verify text in  the 'Series Name' field.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
                        //Series Name Input
						
						ExtentTestManager.startTest("Series Name Input");
						Log.info("Series Name Input");
					
						input(admin_repo.series_name,"INF1234567890");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter 'INF1234567890' in the 'ISIN No' field.-> Verify text in  the 'Series Name' field.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
                        //ISIN No Input Validation
						
						ExtentTestManager.startTest("ISIN No Input Validation");
						Log.info("ISIN No Input Validation");
					
						String ISIN = testdata.get("ISIN").toString();
						input(admin_repo.ISin,ISIN);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter 'INF1234567890' in the 'ISIN No' field.-> Verify text in  the 'Series Name' field.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Interest Payment Method Selection
						ExtentTestManager.startTest("Interest Payment Method Selection");
						Log.info("Interest Payment Method Selection");
					
						input(admin_repo.Interest_Payment_Method,"Monthly");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Select 'Interest Payment Method' dropdown.-> Choose 'Monthly'");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//ROI Input Validation
						ExtentTestManager.startTest("ROI Input Validation");
						Log.info("ROI Input Validation");
					
						String RoI = testdata.get("RoI").toString();
						input(admin_repo.Roi,RoI);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Enter numerical value in the 'ROI' field.->Try entering text characters in the same field.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//GL Acc Code Dependency Loading
						ExtentTestManager.startTest("GL Acc Code/Name Dependency Loading");
						Log.info("GL Acc Code/Name Dependency Loading");
					
						String Acc_Code = testdata.get("Acc_Code").toString();
						input(admin_repo.Acc_code,Acc_Code);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Int GL Acc Code Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						String Int_Acc_Code = testdata.get("Int_Acc_Code").toString();
						input(admin_repo.Int_Acc_code,Int_Acc_Code);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//GL Acc Name Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						input(admin_repo.Int_Acc_code,"AIR TICKET BOOKING AKBAR ONLINE BOOKING CO PVT LTD");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Int Acc Name Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						input(admin_repo.Int_Acc_code,"ALLOWANCE");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Print GL_Acc_Code Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						String Print_GL_Acc_Code=testdata.get("Print_GL_Acc_Code").toString();
						input(admin_repo.Print_GL_Acc_Cde,Print_GL_Acc_Code);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//Print_GL_CODE_Name Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						
						input(admin_repo.Int_Acc_Name1,"AIR CONDITIONER");
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
						//TempROI Dependency Loading
						ExtentTestManager.startTest("Int GL Acc Code/Name Dependency Loading");
						Log.info("Int GL Acc Code/Name Dependency Loading");
					
						String TempROI=testdata.get("TempROI").toString();
						input(admin_repo.Print_Temp_Roi,TempROI);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Enter value in or select from 'GL Acc code/name'.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						ExtentTestManager.endTest();
						
					//Enter Normal days
//						ExtentTestManager.startTest("Post Office Field Enabled and Selectable");
//						Log.info("Post Office Field Enabled and Selectable");
//						
//						String Lacks_0= testdata.get("Lacks_0").toString();
//						input(admin_repo.Lacks_0,Lacks_0);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Enter 10 in Hours text field ");
//						Log.info("Step:01 - 1.Enter 10 in Hours text field ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//						
//						String Lacks_1= testdata.get("Lacks_1").toString();
//						input(admin_repo.Lacks_1,Lacks_1);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:02 - 1.Enter 30 in Minutes text field");
//						Log.info("Step:01 - 1.Enter 30 in Minutes text field ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//						
//						String Lacks_2= testdata.get("Lacks_2").toString();
//						input(admin_repo.Lacks_2,Lacks_2);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//						
//						String Lacks_3= testdata.get("Lacks_3").toString();
//						input(admin_repo.Lacks_3,Lacks_3);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//						
//						String Lacks_4= testdata.get("Lacks_4").toString();
//						input(admin_repo.Lacks_4,Lacks_4);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_5= testdata.get("Lacks_5").toString();
//						input(admin_repo.Lacks_5,Lacks_5);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_6= testdata.get("Lacks_6").toString();
//						input(admin_repo.Lacks_6,Lacks_6);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_7= testdata.get("Lacks_7").toString();
//						input(admin_repo.Lacks_7,Lacks_7);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_8= testdata.get("Lacks_8").toString();
//						input(admin_repo.Lacks_8,Lacks_8);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_9= testdata.get("Lacks_9").toString();
//						input(admin_repo.Lacks_9,Lacks_9);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_10= testdata.get("Lacks_10").toString();
//						input(admin_repo.Lacks_10,Lacks_10);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_11= testdata.get("Lacks11").toString();
//						input(admin_repo.Lacks_11,Lacks_11);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_12= testdata.get("Lacks_12").toString();
//						input(admin_repo.Lacks_12,Lacks_12);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_13= testdata.get("Lacks_13").toString();
//						input(admin_repo.Lacks_13,Lacks_13);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
//						Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
						
						
						//ROI Effect From Date Selection
						ExtentTestManager.startTest("ROI Effect From Date Selection");
						Log.info("ROI Effect From Date Selection");
						
						String ROI_Effect_From_Date_Selection= testdata.get("ROI_Effect_From_Date_Selection").toString();
						click(admin_repo.Roi_Date_From);
						input(admin_repo.Roi_Date_From,ROI_Effect_From_Date_Selection);
						ExtentTestManager.getTest().log(Status.PASS,"1. Use calendar to select 'ROI Effect From' date -> Enter date manually as 'DD-MM-YYYY'.");
						Log.info("Step:01 - 1. Use calendar to select 'ROI Effect From' date -> Enter date manually as 'DD-MM-YYYY'");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						//ROI Effect To Date Selection
						ExtentTestManager.startTest("ROI Effect From Date Selection");
						Log.info("ROI Effect From Date Selection");
						
						String ROI_Effect_To_Date_Selection= testdata.get("ROI_Effect_To_Date_Selection").toString();
						click(admin_repo.Roi_Date_To);
						input(admin_repo.Roi_Date_To,ROI_Effect_To_Date_Selection);

						ExtentTestManager.getTest().log(Status.PASS,"1. Use calendar to select 'ROI Effect to' date -> Enter date manually as 'DD-MM-YYYY'.");
						Log.info("Step:01 - 1. Use calendar to select 'ROI Effect To' date -> Enter date manually as 'DD-MM-YYYY'");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
//						//Normal_1
//						ExtentTestManager.startTest("Lacks");
//						Log.info("Lacks");
//						
//						String Lacks_15= testdata.get("Lacks_15").toString();
//						input(admin_repo.Lacks_15,Lacks_15);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_16= testdata.get("Lacks_16").toString();
//						input(admin_repo.Lacks_16,Lacks_16);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_17= testdata.get("Lacks_17").toString();
//						input(admin_repo.Lacks_17,Lacks_17);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_18= testdata.get("Lacks_18").toString();
//						input(admin_repo.Lacks_18,Lacks_18);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_19= testdata.get("Lacks_19").toString();
//						input(admin_repo.Lacks_19,Lacks_19);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_20= testdata.get("Lacks_20").toString();
//						input(admin_repo.Lacks_20,Lacks_20);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_21= testdata.get("Lacks_21").toString();
//						input(admin_repo.Lacks_21,Lacks_21);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_22= testdata.get("Lacks_22").toString();
//						input(admin_repo.Lacks_22,Lacks_22);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_23= testdata.get("Lacks_23").toString();
//						input(admin_repo.Lacks_23,Lacks_23);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_24= testdata.get("Lacks_24").toString();
//						input(admin_repo.Lacks_24,Lacks_24);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_25= testdata.get("Lacks_25").toString();
//						input(admin_repo.Lacks_25,Lacks_25);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_26= testdata.get("Lacks_26").toString();
//						input(admin_repo.Lacks_26,Lacks_26);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_27= testdata.get("Lacks_27").toString();
//						input(admin_repo.Lacks_27,Lacks_27);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_28= testdata.get("Lacks_28").toString();
//						input(admin_repo.Lacks_28,Lacks_28);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_29= testdata.get("Lacks_29").toString();
//						input(admin_repo.Lacks_29,Lacks_29);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_30= testdata.get("Lacks_30").toString();
//						input(admin_repo.Lacks_30,Lacks_30);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_31= testdata.get("Lacks_31").toString();
//						input(admin_repo.Lacks_31,Lacks_31);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_32= testdata.get("Lacks_32").toString();
//						input(admin_repo.Lacks_32,Lacks_32);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_33= testdata.get("Lacks_33").toString();
//						input(admin_repo.Lacks_33,Lacks_33);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_34= testdata.get("Lacks_34").toString();
//						input(admin_repo.Lacks_34,Lacks_34);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_35= testdata.get("Lacks_35").toString();
//						input(admin_repo.Lacks_35,Lacks_35);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
//						String Lacks_36= testdata.get("Lacks_36").toString();
//						input(admin_repo.Lacks_32,Lacks_36);
//						ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Is Active ");
//						Log.info("Step:01 - 1.Is Active  ");
//						
//						waitTillLoaderDisappear(admin_repo.loader);
//												
//						ExtentTestManager.endTest();
//						
											
						//Save
						ExtentTestManager.startTest("Save this");
						Log.info("Save this");
						
					
						click(admin_repo.save);
						ExtentTestManager.getTest().log(Status.PASS,"1. Click 'Save' button.");
						Log.info("1. Click 'Save' button.");
						
						waitTillLoaderDisappear(admin_repo.loader);
						
						//Updated
						click(admin_repo.Updated);
						
		}//end

		
			
		
}
	

