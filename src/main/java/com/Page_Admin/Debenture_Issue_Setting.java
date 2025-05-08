package com.Page_Admin;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Admin_Debenture_Issue_Setting;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Debenture_Issue_Setting extends Base_Class {
	// Navigate to Debenture  Issue setting module

		PageRepositary_Admin_Debenture_Issue_Setting Debenture  = new PageRepositary_Admin_Debenture_Issue_Setting();
		PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
		com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	   
	    public String spAadhaar = "EXEC GenerateNextAadharNumber";
	    public String clmnNamAadhaar = "generated_aadhar_number";
	    
	    public String spMobileNum = "EXEC GenerateNextMobileNumber";
	    public String clmnNamMobileNum = "generated_mobile_number";
		//private Map<Object, Object> testdata;
	    
	    
	    public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
	           // Method that returns the first customer ID (String) from the database
	            // Database connection details
	    // Database connection details
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	           String UserName = "sqa";
	           String Password = "SPQA@sql2019" ;
	           String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

	           
	            String value = null; // Declare and initialize the return variable

	            // Establish the connection to the database
	            try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	                 Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {
	                 
	                 if (resultSet.next()) {
	                        value = resultSet.getString(columnName); // DB column name
	                    System.out.println("Generated Unique ID: " + value);
	                } else {
	                    System.out.println("Unique ID not generated.");
	                }

	            } catch (SQLException e) {
	                System.out.println("Error executing the SQL query or processing the result set.");
	                e.printStackTrace();
	            }

	            return value; // Return the firstCustId
	        }
	    
	    public void userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
			ExtentTestManager.startTest("Valid Login");
			Log.info("Valid Login");
				
			
//						String loginUserName = testdata.get("loginUserName").toString();
						String loginUserName = configloader().getProperty("UserName2");
						input(custSearch.loginUserName, loginUserName);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
						Log.info("Step:01 - Entered valid User Name");
						
						String loginValidPassword = configloader().getProperty("Password2");
//						String loginValidPassword = testdata.get("loginValidPassword").toString();
						input(custSearch.loginPasswrd, loginValidPassword);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
						Log.info("Step:02 - Entered valid Password");
						
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
						Log.info("Step:03 - Click on Login Button");
						
						try {
						ElementDisplayed(Debenture.Continuebtn);
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
							
		//					String loginUserName = testdata.get("loginUserName").toString();
							input(custSearch.loginUserName, loginUserName);
							ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
							Log.info("Step:02 - Enetered valid User Name");
							
		//					String loginValidPassword = testdata.get("loginValidPassword").toString();
							input(custSearch.loginPasswrd, loginValidPassword);
							ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
							Log.info("Step:03 - Entered valid Password");
							
							click(custSearch.loginButton);
							ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
							Log.info("Step:04 - Click on Login Button");
							
										ElementDisplayed(Debenture.Continuebtn);
										ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
										Log.info("Expected Result: User is logged in successfully and dashboard visible");	
								}
						
						ElementDisplayed(Debenture.Continuebtn);
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
					Log.info("Expected Result: User is logged in successfully and dashboard visible");
						
			ExtentTestManager.endTest();

						
		}
	    
	  public void Clickcontinue()throws InterruptedException {
		  ExtentTestManager.startTest("Tc:04 Click continue Button");
		  
		   click(Debenture.Continuebtn);
		   ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the OK button in the Continue popup");
			Log.info("Step:01 Click on the OK button in the Continue popup");
			
			//click(Debenture.save);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Home page is accessed");
			Log.info("Expected Result: Home page is accessed");
	  }
		
//Navigate to Debenture Issue Settings
	  
	  public void Navigate_to_debenture_issue_settings() throws InterruptedException {
			ExtentTestManager.startTest("Tc:05 Navigate to Debenture Issue Setting");
			  
			click(Debenture.Debenturesettings);  
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Go to Debenture issue setting window");
			Log.info("Step:01 Go to the Debenture issue Setting window");
			
			click(Debenture.DebentureIssuesetting);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 Verify that the window is accessible");
			Log.info("Step:02 Verify that the window is accessible");
			
			if (ElementDisplayed(Debenture.Debentureissuewindow)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Debenture issue Settings window is displayed");
				Log.info("Expected result: Debenture issue Settings window is displayed");
			} else {
				ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Debenture issue setting window is not displayed");
				Log.info("Expected result:Debenture issue setting window is not displayed");
			}
			ExtentTestManager.endTest();
	 
	  }
	  public void Select_Debenture_Type_From_Dropdown() throws InterruptedException {
			ExtentTestManager.startTest("Tc:06 Select Debenture Type from Dropdown");
			  
			 // click(Debenture.DebentureType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the Debenture Type dropdown");
			Log.info("Step:01 Click on the Debenture Type Dropdown");
			
			select("DEBENTURE-TYPE1",Debenture.DebentureType);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select a Debenture Type from the list");
			Log.info("Step:01 Select a Debenture Type from the list");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Type is selected");
			Log.info("Expected result:Debenture Type is selected");
			
			ExtentTestManager.endTest();

		}
	  public void Verify_Issue_Name() throws InterruptedException {
		  ExtentTestManager.startTest("Tc:07 Verify Issue Name field");
			
			String DebIssueName = driver.findElement(Debenture.IssueName).getAttribute("value");
			System.out.println("DebIssueName1: " + DebIssueName);

			if (DebIssueName.isBlank()) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue name is auto loaded");
				Log.info("Expected result: Issue name is auto loaded");
			
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue name is not auto loaded");
				Log.info("Expected result: Issue name is not auto loaded");
			}

			ExtentTestManager.endTest();

		}
			
	  
	  public void Enter_Issue_From_Date(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:08 Enter Issue From Date");
			 
			  click (Debenture.IssueFromDate1);
				String FromDate = testdata.get("IssueFromDate").toString();
				input(Debenture.IssueFromDate1, FromDate);
				click (Debenture.IssueToDate1);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select a date using the calendar");
			Log.info("Step:01 Select a date using the calendar");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Issue From Date' is set correctly");
				Log.info("Expected result:The 'Issue From Date' is set correctly");
			
			ExtentTestManager.endTest();

		}
	  
	  public void Verify_Issue_To_Date(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:09 Verify Issue To Date");
			 
			String DebIssueToDate = driver.findElement(Debenture.IssueToDate1).getAttribute("value");
			System.out.println("DebIssueToDate1: " + DebIssueToDate);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Verify Issue To Date");
			Log.info("Step:01 Verify Issue To Date");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Issue To Date' is auto loaded");
				Log.info("Expected result:The 'Issue To Date' is auto loaded");
			
			ExtentTestManager.endTest();

		}
	  
	  public void Enter_Unit_Value(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:10 Enter Unit Value");
			 
			  click (Debenture.UnitValue1);
				String Unit = testdata.get("UnitValue").toString();
				input(Debenture.UnitValue1, Unit);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter a numeric value in the 'Unit value' field");
			Log.info("Step:01 Enter a numeric value in the 'Unit value' field");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Unit value is entered successfully");
				Log.info("Expected result:Unit value is entered successfully");
			
			ExtentTestManager.endTest();

		}
	  
	  
	  public void Enter_Return_ROI(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:11 Enter Return ROI");
			 
			  click (Debenture.ReturnROI1);
				String ROI = testdata.get("ReturnROI").toString();
				input(Debenture.ReturnROI1, ROI);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter a value in the 'Return ROI' field");
			Log.info("Step:01 Enter a value in the 'Return ROI' field");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Return ROI is entered successfully");
				Log.info("Expected result:Return ROI is entered successfully");
			
			ExtentTestManager.endTest();

		}
	  
	  public void Verify_IsActive_Checkbox() throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:12 Verify IS Active Checkbox");
			 
			if(CheckBoxStatus(Debenture.ISActive)) {
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the Is Active Checkbox");
				Log.info("Step:01 Observe the Is Active Checkbox");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Is Active checkbox is checked by default");
				Log.info("Expected result:Is Active checkbox is checked by default");
				
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			  
			ExtentTestManager.endTest();

		}
	  
	  public void Enter_Call_Date(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:13 Enter Call Date");
			 
			  click (Debenture.CallDate1);
				String calDate = testdata.get("CallDate").toString();
				input(Debenture.CallDate1, calDate);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select a date using the calendar");
			Log.info("Step:01 Select a date using the calendar");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Call Date' is set correctly");
				Log.info("Expected result:The Call Date' is set correctly");
			
			ExtentTestManager.endTest();
}
	  
	  public void Enter_Put_Date(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:14 Enter Put Date");
			 
			  click (Debenture.PutDate1);
				String PutDates = testdata.get("PutDate").toString();
				input(Debenture.PutDate1, PutDates);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select a date using the calendar");
			Log.info("Step:01 Select a date using the calendar");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Put Date' is set correctly");
				Log.info("Expected result:The Put Date' is set correctly");
			
			ExtentTestManager.endTest();
}
	  public void Enter_CallDate_Premature_ROI(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:15 Enter Call Date Premature ROI");
			 
			  click (Debenture.CallDateROI);
				String CallDateROI = testdata.get("CallDatePrematureROI").toString();
				input(Debenture.CallDateROI, CallDateROI);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter a value in the 'Call Date Premature ROI' field");
			Log.info("Step:01 Enter a value in the 'Call Date Premature ROI' field");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Call Date Premature ROI is entered successfully");
				Log.info("Expected result:Call Date Premature ROI is entered successfully");
			
			ExtentTestManager.endTest();
}
	  public void Enter_PutDate_Premature_ROI(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:16 Enter Put Date Premature ROI");
			 
			  click (Debenture.PutDateROI);
				String PutDateROI = testdata.get("PutDatePrematureROI").toString();
				input(Debenture.PutDateROI, PutDateROI);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter a value in the 'Put Date Premature ROI' field");
			Log.info("Step:01 Enter a value in the 'Put Date Premature ROI' field");
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Put Date Premature ROI is entered successfully");
				Log.info("Expected result:Put Date Premature ROI is entered successfully");
			
			ExtentTestManager.endTest();
}
	  
	  
	  public void Add_Call_and_Put_Details() throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:17 Add Call and Put Details");
			 
			  click (Debenture.AddButton);
			  INclick(Debenture.loader);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the 'Add' button");
			Log.info("Step:01  Click on the 'Add' button");
			
			if (ElementDisplayed(Debenture.Addgrid)) {
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Call and Put details are listed in the grid");
				Log.info("Expected result:Call and Put details are listed in the grid");
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Call and Put details are not listed in the grid");
				Log.info("Expected result:Call and Put details are not listed in the grid");
			}
			
			ExtentTestManager.endTest();
}
	  
	  public void Submit_Issue_Details() throws InterruptedException, ClassNotFoundException {
			ExtentTestManager.startTest("Tc:18 Submit Issue Details");
			 
			  click (Debenture.Save);	
			  INclick(Debenture.loader);
			  
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the 'Save' button");
			Log.info("Step:01  Click on the 'Save' button");
			
			if (ElementDisplayed(Debenture.Savegrid)) {
			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue details are listed in the grid");
				Log.info("Expected result:Issue Details are listed in the grid");
				
			} else {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue details are not listed in the grid");
				Log.info("Expected result: Issue details are not listed in the grid");
			}
			click(Debenture.CancelPopup);
			//click (Debenture.Signout);
			
			ExtentTestManager.endTest();
}
}
