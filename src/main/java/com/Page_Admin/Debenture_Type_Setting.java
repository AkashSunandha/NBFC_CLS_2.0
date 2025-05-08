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
import com.Page_Repositary.PageRepositary_Admin_Debenture_Type_Setting;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Debenture_Type_Setting extends Base_Class {
	// Navigate to Debenture Type setting module

	PageRepositary_Admin_Debenture_Type_Setting Debenture  = new PageRepositary_Admin_Debenture_Type_Setting();
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
			
		
//					String loginUserName = testdata.get("loginUserName").toString();
					String loginUserName = configloader().getProperty("UserName2");
					input(custSearch.loginUserName, loginUserName);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
					Log.info("Step:01 - Entered valid User Name");
					
					String loginValidPassword = configloader().getProperty("Password2");
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
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
	   click(Debenture.Continuebtn);
	   ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the OK button in the Continue popup");
		Log.info("Step:01 Click on the OK button in the Continue popup");
		
		//click(Debenture.save);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Home page is accessed");
		Log.info("Expected Result: Home page is accessed");
  }
	
	
public void Submit_Without_Filling_Mandatory_Fields() throws InterruptedException {
	ExtentTestManager.startTest("Tc:04 Submit without filling mandatory fields");
	  
	click(Debenture.Debenturesettings);  
	click(Debenture.DebentureTypeSetting);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Go to Debenture Settings Path>>Debenture>>Debenture Type Settings");
	Log.info("Step:01 Go to Debenture Settings Path>>Debenture>>Debenture Type Settings");
	
	click(Debenture.save);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click Submit without filling any fields");
	Log.info("Step:02 Click Submit without filling any fields");

	if (ElementDisplayed(Debenture.DebentureTypeWindow)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Debenture Settings window should be opened and An error message should indicate that all mandatory fields must be filled");
		Log.info("Expected result: Debenture Settings window should be opened and An error message should indicate that all mandatory fields must be filled");
	} else {
		ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Debenture Settings window should not be opened and An error message should not be indicate that all mandatory fields must be filled");
		Log.info("Expected result:Debenture Settings window should not be opened and An error message should not be indicate that all mandatory fields must be filled");
	}
	ExtentTestManager.endTest();

}
	
public void Submit_with_Valid_Input_Data() throws InterruptedException {
	ExtentTestManager.startTest("Tc:06 Submit with valid Input Data product group");
	  select("Debenture",Debenture.Productgroup);
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Select 'Debenture' from Product Group.");
	Log.info("Step:01  Select 'Debenture' from Product Group. ");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture is  selected from Product Group.");
		Log.info("Expected result:Debenture is  selected from Product Group.");
	
	ExtentTestManager.endTest();

}
public void Submit_with_Valid_Input_Data_TypeName(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
	ExtentTestManager.startTest("Tc:07 Submit with valid Input Data Type Name");
	  click(Debenture.TypeName);
	  //String ValName = testdata.get("Name").toString();
			//input(Debenture.TypeName,ValName);
	  
	  String ValName = generateUniqueId(spMobileNum,clmnNamMobileNum);
		String last3DigitsOfAccNum = ValName.substring(ValName.length() -3);
		input(Debenture.TypeName,"Debe" + last3DigitsOfAccNum );
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter valid 'Type Name'");
	Log.info("Step:01 Enter valid 'Type Name' ");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Type name is entered");
		Log.info("Expected result:Type name is entered");
	
	ExtentTestManager.endTest();

}
public void Submit_with_Valid_Input_Data_valid_Amount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	ExtentTestManager.startTest("Tc:08 Submit with valid Input Data valid amount");
	  click(Debenture.Amount);
	  String ValAmount = testdata.get("validAmount").toString();
		input(Debenture.Amount,ValAmount);
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter valid amount");
	Log.info("Step:01 Enter valid amount ");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount displayed in the field");
		Log.info("Expected result:Amount displayed in the field");
	
	ExtentTestManager.endTest();

}

public void Submit_with_Valid_Input_Data_valid_Duration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	ExtentTestManager.startTest("Tc:09 Submit with valid Input Data valid Duration");
	click(Debenture.Durationbox);
	String DebDuration = testdata.get("Duration").toString();
	input(Debenture.Durationbox, DebDuration);
	
	select("MONTHS",Debenture.SelectDuration);
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter valid Duration and select type");
	Log.info("Step:01 Enter valid Duration and select type");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Duration and type displays");
		Log.info("Expected result:Duration and type displays");
	
	ExtentTestManager.endTest();

}

public void Submit_with_Valid_Input_Data_MinMax_units(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	ExtentTestManager.startTest("Tc:10 Submit with valid Input Data Min and Max number of units");
	click(Debenture.Minimumunits);
	String minunit = testdata.get("minimum").toString();
	input(Debenture.Minimumunits,minunit);
	
	click(Debenture.Maximumunits);
	String maxunit = testdata.get("maximum").toString();
	input(Debenture.Maximumunits,maxunit);
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Enter valid 'Min No of Units' and 'Max No of Units'");
	Log.info("Step:01 Enter valid 'Min No of Units' and Max No of Units");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Min No of Units' and 'Max No of Units' entered");
		Log.info("Expected result:'Min No of Units' and 'Max No of Units' entered");
	
	ExtentTestManager.endTest();

}
public void Submit_with_Valid_Input_Data_Transmode_option() throws InterruptedException {
	ExtentTestManager.startTest("Tc:11 Submit with valid Input Data Transmode option");
	
	select("CASH",Debenture.Transmodecash);
	
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Select valid Transmode option");
	Log.info("Step:01 Select valid Transmode option");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Transmode selected");
		Log.info("Expected result:'Transmode selected");
	
	ExtentTestManager.endTest();

}
public void Submit_with_Valid_Input_Data_Interestcalculation() throws InterruptedException {
	ExtentTestManager.startTest("Tc:12 Submit with valid Input Data for interest calculation method");
	
	select("Normal",Debenture.InterestCalculationMethod);
	
	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select valid 'Interest Calc method'");
	Log.info("Step:01  Select valid 'Interest Calc method' ");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: possible to enter'Interest Calculation Method'");
		Log.info("Expected result:'possible to enter 'Interest Calculation Method'");
	
	ExtentTestManager.endTest();

}

public void Submit_with_Valid_Input_Data_save(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	ExtentTestManager.startTest("Tc:13 Submit with valid Input Data -save");
	
	click(Debenture.save);

	  
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Save");
	Log.info("Step:01 Click Save");
	
	if (ElementDisplayed(Debenture.Addgrid)) {
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture type should be created and displayed in the grid");
		Log.info("Expected result:Debenture type should be created and displayed in the grid");
	
	} else {
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Debenture type should not be created and not displayed in the grid");
		Log.info("Expected Result: Debenture type should not be created and not displayed in the grid");
	}
	click (Debenture.cancelpopup);
	//click (Debenture.Signout);
	ExtentTestManager.endTest();

}

}

