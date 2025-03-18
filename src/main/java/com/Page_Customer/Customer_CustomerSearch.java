package com.Page_Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class Customer_CustomerSearch extends Base_Class{
	Log log= new Log();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("Customer_CustSearch");
	Base_Class Base_Class= new Base_Class();
	Customer_QuickCustomer quickCust = new Customer_QuickCustomer(); 
	
	
	
	public static  String generateCustId() throws ClassNotFoundException {
		 // Method that returns the first customer ID (String) from the database
	        // Database connection details
        // Database connection details
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		String query = "exec getcustomer 102;";
	        String custID = null; // Declare and initialize the return variable

	        
	        // Establish the connection to the database
	        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	        	
	        	if (resultSet.next()) {
	        		custID = resultSet.getString("CustomerID"); // Column name
	                System.out.println("Cust_ID of customer: " + custID);
	            } else {
	                System.out.println("No new customers found.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error executing the SQL query or processing the result set.");
	            e.printStackTrace();
	        }

	        return custID; // Return the firstCustId
	        
	    }
	
	
	
	public static  void deleteDuplicates() throws ClassNotFoundException {
		
		String custId = generateCustId();
		
        // Database connection details
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		
		String query = "select * from custaddressdetails where  cust_id = " + custId;

	        String addressID = null; // Declare and initialize the return variable

	        // Establish the connection to the database
	        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	        	
	        	if (resultSet.next()) {
	        		addressID = resultSet.getString("Address_ID"); // Column name
	                System.out.println("Address_ID of customer: " + addressID);
	                
	        		String query1 = "delete from custaddressdetails where Address_ID = " + addressID + "and Type_ID = 2";

	        		//To delete the duplicate data from custaddressdetails table
	                DriverManager.getConnection(Url, UserName, Password);
		            connection.createStatement();
		            statement.executeQuery(query1);
		             
	            } else {
	                System.out.println("No Duplicate found.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error executing the SQL query or processing the result set.");
//	            e.printStackTrace();
	        }
	        
	    System.out.println("Deleted Duplicate.");    
	}
	public boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("PC Registration");
		Log.info("PC Registration");
		
		String pcRegFormName = testdata.get("pcRegFormName").toString();
		input(custSearch.formName, pcRegFormName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
		Log.info("Step:01 - Enter User Name in Name field.");
		
		select("TRIVANDRUM",custSearch.formBranchName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
		Log.info("Step:02 - Select a Branch Name from the Dropdown.");
		
		String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
		input(custSearch.formComputerName, pcRegFormPcName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
		Log.info("Step:03 - Enter PC Name in Name field.");
		
		click(custSearch.formSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit Button.");
		Log.info("Step:04 - Click on Submit Button.");
		
		//DB Connection
			com.BasePackage.Base_Class.DatabaseConnector();
			driver.navigate().refresh();
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PC Registered Successfully!");
			Log.info("Expected Result: PC Registered Successfully!");
			ExtentTestManager.endTest();
			
		return true;
	}
	
	public boolean userLoginInValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Login with Invalid Credentials");
		Log.info("Login with Invalid Credentials");
		
		String loginInValidUsername = testdata.get("loginInValidUsername").toString();
		input(custSearch.loginUserName, loginInValidUsername);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
		Log.info("Step:01 - Enetered Valid User Name");
		
		String loginInValidPassword = testdata.get("loginInValidPassword").toString();
		input(custSearch.loginPasswrd, loginInValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
		Log.info("Step:02 - Enetered Invalid Password");
		
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		
		if(ElementDisplayed(custSearch.invalidPaswrdErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed for invalid credentials.");
			Log.info("Expect Result: Error message displayed for invalid credentials.");
		}
		clear(custSearch.loginUserName);
		ExtentTestManager.endTest();
		
		
		
		ExtentTestManager.startTest("Invalid Login - Incorrect Password");
		Log.info("Invalid Login - Incorrect Password");
		
		String loginUserName = testdata.get("loginUserName").toString();
		input(custSearch.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
		Log.info("Step:01 - Enetered Valid User Name");
		
		input(custSearch.loginPasswrd, loginInValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
		Log.info("Step:02 - Enetered Invalid Password");
		
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		
		if(ElementDisplayed(custSearch.invalidPaswrdErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed indicating incorrect password.");
			Log.info("Expect Result: Error message displayed indicating incorrect password.");
		}
		clear(custSearch.loginUserName);
		ExtentTestManager.endTest();
		
		return true;
	}
	
	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Valid Login");
		Log.info("Valid Login");
			
			
					String UserName = configloader().getProperty("UserName");
//					String loginUserName = testdata.get("loginUserName").toString();
					input(custSearch.loginUserName,UserName );
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
					Log.info("Step:01 - Enetered valid User Name");
					
					String Password = configloader().getProperty("Password");
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
					input(custSearch.loginPasswrd, Password);
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
					Log.info("Step:02 - Enetered valid Password");
					
					click(custSearch.loginButton);
					ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
					Log.info("Step:03 - Click on Login Button");
					
					try {
					ElementDisplayed(custSearch.home);
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
						input(custSearch.loginUserName, UserName);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
						Log.info("Step:02 - Enetered valid User Name");
						
	//					String loginValidPassword = testdata.get("loginValidPassword").toString();
						input(custSearch.loginPasswrd, Password);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
						Log.info("Step:03 - Entered valid Password");
						
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
						Log.info("Step:04 - Click on Login Button");
						
									ElementDisplayed(custSearch.home);
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
									Log.info("Expected Result: User is logged in successfully and dashboard visible");	
							}
					
//					ElementDisplayed(custSearch.home);
//					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
//					Log.info("Expected Result: User is logged in successfully and dashboard visible");
					
		ExtentTestManager.endTest();

		return true;
	}
	
	public boolean customerSearchWindow() throws InterruptedException {
		ExtentTestManager.startTest("Navigate to Customer Search");
		Log.info("Navigate to Customer Search");
		
		click(custSearch.cust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Customer module in the left menu bar.");
		Log.info("Step:01 - Expand the Customer module in the left menu bar.");
		
		click(custSearch.custSrch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Customer Search.");
		Log.info("Step:02 - Select Customer Search.");
		
		if(ElementDisplayed(custSearch.custSrchTxt)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Search Window loaded Successfully!");
			Log.info("Expected Result: Customer Search Window loaded Successfully!");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean mobileFieldBVA(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		
		ExtentTestManager.startTest("Mobile Field - BVA Validations");
		Log.info("Mobile Field - BVA Validations");
		
				//Min-1 & Max-1 (<10 digits)
				String invalidMobileNum1 = testdata.get("invalidMobileNum1").toString();
				input(custSearch.custMobile, invalidMobileNum1);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invlalid Mobile num in moblie field(<10 Digits)");
				Log.info("Step:01 - Enter Invlalid Mobile num in moblie field(<10 Digits)");
		
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
				Log.info("Step:02 - Click on the Search button.");
				
				
				if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Mobile NO.(< 10 digits)" );
					 Log.info("Expected Result: Error message displayed for incorrect Mobile NO.(< 10 digits)");
				}					
				
				click(custSearch.custClearBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
				Log.info("Step:03 - Click on the Clear Data");
				
		//Min+1 & Max+1 (>10 digits)
				
				String invalidMobileNum2 = testdata.get("invalidMobileNum2").toString();
				input(custSearch.custMobile, invalidMobileNum2);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Invlalid Mobile num in moblie field(>10 Digits)");
				Log.info("Step:04 - Enter Invlalid Mobile num in moblie field(>10 Digits)");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
				Log.info("Step:05 - Click on the Search button.");
				
				
				if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Mobile NO.(> 10 digits)" );
					 Log.info("Expected Result: Error message displayed for incorrect Mobile NO.(> 10 digits)");
				}	
				
				click(custSearch.custClearBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Clear Data");
				Log.info("Step:06 - Click on the Clear Data");
				
		//Min & Max (=10 digits)
				String validMobileNum = testdata.get("validMobileNum").toString();
				input(custSearch.custMobile, validMobileNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Enter Valid Mobile num in moblie field");
				Log.info("Step:07 - Enter Valid Mobile num in moblie field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on the Search button.");
				Log.info("Step:08 - Click on the Search button.");
						
				
				if(ElementDisplayed(custSearch.custGridItem)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fetched Customer with Valid Mobile No., Successfully!");
						Log.info("Expected Result: Fetched Customer with Valid Mobile No., Successfully!");
					}
					click(custSearch.custClearBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on the Clear Data");
					Log.info("Step:09 - Click on the Clear Data");
					
					ExtentTestManager.endTest();						
		return true;
		}
	
	public boolean nameFieldECP(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("Name Field - ECP Validations");
		Log.info("Name Field - ECP Validations");
		
		
		//Search By Name --> Numeric Input
		String nameNumeric = testdata.get("nameNumeric").toString();
		input(custSearch.custName, nameNumeric);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invlalid Name in Name field(Numeric Input)");
		Log.info("Step:01 - Enter Invlalid Name in Name field(Numeric Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
		Log.info("Step:02 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Name (Numeric Input)");
			 Log.info("Expected Result: Error message displayed for incorrect Name (Numeric Input)");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		
		//Search By Name --> Alphanumeric Input
		String nameAlphanumeric = testdata.get("nameAlphanumeric").toString();
		input(custSearch.custName, nameAlphanumeric);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Invlalid Name in Name field(Alphanumeric Input)");
		Log.info("Step:04 - Enter Invlalid Name in Name field(Alphanumeric Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
		Log.info("Step:05 - Click on the Search button.");
		
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Name (Alphanumeric)");
			 Log.info("Expected Result: Error message displayed for incorrect Name (Alphanumeric)");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Clear Data");
		Log.info("Step:06 - Click on the Clear Data");
		
		
		//Search By Name --> Alphabet Input
		String validName = testdata.get("validName").toString();				
		input(custSearch.custName, validName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Enter Valid Name in Name field(Alphabet Input)");
		Log.info("Step:07 - Enter Valid Name in Name field(Alphabet Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on the Search button.");
		Log.info("Step:08 - Click on the Search button.");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched Using Name, Successfully");
			Log.info("Expected Result: Fetched Customer with Valid Name, Successfully!");
		}	
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on the Clear Data");
		Log.info("Step:09 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		
		
		
		//Customer Search by Non-Existent Name
		ExtentTestManager.startTest("Customer Search - Invalid Name");
		Log.info("Customer Search - Invalid Name");
		
		String invalidName = testdata.get("invalidName").toString();				
		input(custSearch.custName, invalidName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Non-Existing Name in Name field");
		Log.info("Step:01 - Enter Vlalid Name in Name field(Alphabet Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
		Log.info("Step:02 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: No results found and appropriate message displayed.");
			Log.info("Expected Result: No results found and appropriate message displayed.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Error Guessing - Special Characters in Name Field
		ExtentTestManager.startTest("Error Guessing - Special Characters in Name Field");
		Log.info("Error Guessing - Special Characters in Name Field");
		
		String nameSpecialChar = testdata.get("nameSpecialChar").toString();				
		input(custSearch.custName, nameSpecialChar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:13 - Enter Special Characters Name in Name field");
		Log.info("Step:13 - Enter Special Characters Name in Name field");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:14 - Click on the Search button.");
		Log.info("Step:14 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: No results found and appropriate message displayed.");
			Log.info("Expected Result: No results found and appropriate message displayed.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:15 - Click on the Clear Data");
		Log.info("Step:15 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		
		return true;
		}
	
	public boolean searchWithoutInputs() throws InterruptedException {
		
		ExtentTestManager.startTest("Customer Search with No Filter");
		Log.info("Customer Search with No Filter");
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Clear Data");
		Log.info("Step:01 - Click on the Clear Data");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button without entering any filters.");
		Log.info("Step:02 - Click on the Search button without entering any filters.");
		
		
		boolean flag1 = ElementDisplayed(custSearch.custListTable);
		boolean flag = flag1;
		if(flag == true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All Availabe customer details displayed, Successfully!");
		Log.info("Expected Result: All Availabe customer details displayed, Successfully!");
				}
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public boolean searchByInvalidAadhaar(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
				//AADHAAR No < 12 digits.
		
		ExtentTestManager.startTest("Invalid Aadhaar Number");
		Log.info("Invalid Aadhaar Number");
		
		String invalidAadhaar = testdata.get("invalidAadhaar").toString();
		input(custSearch.custAadhaar, invalidAadhaar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
		Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button");
		Log.info("Step:02 - Click on the Search button");
		
		
		if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Aadhaar(< 12 digits)");
					Log.info("Error message displayed for incorrect Aadhaar(< 12 digits)");
				}						
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public boolean clearFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Clear Functionality");
		Log.info("Clear Functionality");
		
        String nameTextBoxId = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtFirstName";
        String mobileNumTextBoxId = "ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtMobileNo"; 
        
		String validName = testdata.get("validName").toString();				
		input(custSearch.custName, validName);
		String validMobileNum = testdata.get("validMobileNum").toString();
		input(custSearch.custMobile, validMobileNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter inputs in various fields.");
		Log.info("Step:01 - Enter inputs in various fields.");
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Clear button.");
		Log.info("Step:02 - Click on the Clear button.");
		
        String valueAfterClear1 = driver.findElement(By.id(nameTextBoxId)).getAttribute("value");
        String valueAfterClear2 = driver.findElement(By.id(mobileNumTextBoxId)).getAttribute("value");

        if (valueAfterClear1.isEmpty() && valueAfterClear2.isEmpty()) {
        	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All Inputs Cleared, Successfully!");
			Log.info("Expected Result: All Inputs Cleared, Successfully!");
        } else {
        	ExtentTestManager.getTest().log(Status.FAIL, "Clear Functionality, Failed");
			Log.info("Clear Functionality, Failed");
        }	
		ExtentTestManager.endTest();
		
		return true;
	}
	
	public boolean fetchInstitutions() throws InterruptedException {
				click(custSearch.custClearBtn);
				
				ExtentTestManager.startTest("Toggle Is Institutional Checkbox");
				Log.info("Toggle Is Institutional Checkbox");
				
				click(custSearch.custKYCCompliantOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
				Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
				
				click(custSearch.custActiveOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Active Only checkbox");
				Log.info("Step:02 - Uncheck Active Only checkbox");
				
				click(custSearch.custProspectsOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck Prospects Only checkbox");
				Log.info("Step:03 - Uncheck Prospects Only checkbox");
				
				click(custSearch.custIsInstitutional);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Check Prospects Only checkbox");
				Log.info("Step:04 - Check Prospects Only checkbox");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button");
				Log.info("Step:05 - Click on the Search button");
				
				try {
//					boolean tableDisplayed = ElementDisplayed(NBFC_Locators.custTable);
					if(ElementDisplayed(custSearch.custTable)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid displays only institutional customers.");
						Log.info("Expected Result: Grid displays only institutional customers.");
						}
				}
				catch(Exception e1)
				{
					ExtentTestManager.getTest().log(Status.PASS, "Failed to Fetch Institutional Customers in the Grid");
					Log.info("Failed to Fetch Institutional Customers in the Grid");
				}
				
				click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean houseName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
				
		ExtentTestManager.startTest("Verify the field House Name");
		Log.info("Verify the field House Name");
		
				//Alphanumeric
				String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();				
				input(custSearch.custHouseName, houseNameAlphanumeric);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter House name in House field (Alphanumeric Input)");
				Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button");
				Log.info("Step:02 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name (Alphanumeric Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name (Alphanumeric Input), Successfully!");
				}
				
				click(custSearch.custClearBtn);
				
				
				//Alphabet
				String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();				
				input(custSearch.custHouseName, houseNameAlphabet);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter House name in House field (Alphanumeric Input)");
				Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Search button");
				Log.info("Step:02 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name(Alphabetic Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name(Alphabetic Input), Successfully!");
				}
				click(custSearch.custClearBtn);
				
				//Numeric
				String houseNameNumeric = testdata.get("houseNameNumeric").toString();				
				input(custSearch.custHouseName, houseNameNumeric);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Enter House name in House field (Numeric Input)");
				Log.info("Step:05 - Enter House name in House field (Numeric Input)");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Search button");
				Log.info("Step:06 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name(Numeric Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name(Numeric Input), Successfully!");
				}
				click(custSearch.custClearBtn);
				ExtentTestManager.endTest();
		return true;
	}
	
	public boolean docTypeAndDocNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Verify the field Doc Type");
		Log.info("Verify the field Doc Type");
		
		click(custSearch.custDocType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Doc Type drop down box.");
		Log.info("Step:01 - Click on Doc Type drop down box");
		
		click(custSearch.custDocTypeElectionId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a document type from the drop down.");
		Log.info("Step:02 - Select a document type from the drop down.");

		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button");
		Log.info("Step:03 - Click on the Search button");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
			Log.info("Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
		}
		ExtentTestManager.endTest();
		
		
		ExtentTestManager.startTest("Verify the field Doc No");
		Log.info("Verify the field Doc No");
		
		String docNum = testdata.get("docNum").toString();
		click(custSearch.custDocNum);
		input(custSearch.custDocNum, docNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Document number in Doc No. field.");
		Log.info("Step:03 - Enter Document number in Doc No. field.");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button");
		Log.info("Step:03 - Click on the Search button");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
			Log.info("Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
		}
		
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean panNum(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Verify the field PAN No");
		Log.info("Verify the field PAN No");
		
		String alphanumericPanNum = testdata.get("alphanumericPanNum").toString();				
		input(custSearch.custPanNum, alphanumericPanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter PAN number in PAN NO. field.");
		Log.info("Step:01 - Enter PAN number in PAN NO. field.");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
		Log.info("Step:02 - Click on the Search button.");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details should be shows in the grid against the given PAN No.");
			Log.info("Expected Result: Customer details should be shows in the grid against the given PAN No.");
		}
		ExtentTestManager.endTest();
		
		
		
		ExtentTestManager.startTest("Customer details in grid");
		Log.info("Customer details in grid");
		
		boolean flag1 = ElementDisplayed(custSearch.columnCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Cust ID.");
		Log.info("Step:01 - Verify the Presence of Column - Cust ID.");
		
		boolean flag2 = ElementDisplayed(custSearch.columnDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Date.");
		Log.info("Step:02 - Verify the Presence of Column - Date.");
		
		boolean flag3 = ElementDisplayed(custSearch.columnFName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - First Name.");
		Log.info("Step:03 - Verify the Presence of Column - First Name.");
		
		boolean flag4 = ElementDisplayed(custSearch.columnLName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - Last Name.");
		Log.info("Step:04 - Verify the Presence of Column - Last Name.");
		
		boolean flag5 = ElementDisplayed(custSearch.columnMName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Middle Name.");
		Log.info("Step:05 - Verify the Presence of Column - Middle Name.");
		
		boolean flag6 = ElementDisplayed(custSearch.columnDisplayName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Display Name.");
		Log.info("Step:06 - Verify the Presence of Column - Display Name.");
		
		boolean flag7 = ElementDisplayed(custSearch.columnPrntSpouse);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Verify the Presence of Column - Parent/Spouse");
		Log.info("Step:07 - Verify the Presence of Column - Parent/Spouse");
		
		boolean flag8 = ElementDisplayed(custSearch.columnRelation);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Verify the Presence of Column - Relation.");
		Log.info("Step:08 - Verify the Presence of Column - Relation.");
		
		boolean flag9 = ElementDisplayed(custSearch.columnHouse);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Verify the Presence of Column - House.");
		Log.info("Step:09 - Verify the Presence of Column - House.");
		
		boolean flag10 = ElementDisplayed(custSearch.columnPlace);
		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Verify the Presence of Column - Place");
		Log.info("Step:10 - Verify the Presence of Column - Place");
		
		boolean flag11 = ElementDisplayed(custSearch.columnMobNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:11 - Verify the Presence of Column - Mobile No.");
		Log.info("Step:11 - Verify the Presence of Column - Mobile No.");
		
		boolean flag12 = ElementDisplayed(custSearch.columnStatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:12 - Verify the Presence of Column - Status");
		Log.info("Step:12 - Verify the Presence of Column - Status");

		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details is showing under the grid");
			Log.info("Expected Result: Customer details is showing under the grid");
		}
		ExtentTestManager.endTest();
		click(custSearch.custClearBtn);
return true;
}
	
	public boolean kycCompliantOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check KYC Compliant Only Checkbox.");
		Log.info("Check KYC Compliant Only Checkbox.");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck Active Only checkbox");
		Log.info("Step:01 - Uncheck Active Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only shows the KYC completed customer details.");
			Log.info("Expected Result: Only shows the KYC completed customer details.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean isActiveOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Active Only, Checkbox");
		Log.info("Check Active Only, Checkbox");
		
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.statusActive)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only shows the Active customer details.");
			Log.info("Expected Result: Only shows the Active customer details.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean prospectsOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Prospects Only Checkbox");
		Log.info("Check Prospects Only Checkbox");
		
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Active Only checkbox");
		Log.info("Step:02 - Uncheck Active Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only listing the customer which dont have accounts.");
			Log.info("Expected Result: Only listing the customer which dont have accounts.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean includeReject() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Include Reject Checkbox");
		Log.info("Check Include Reject Checkbox");
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck Active Only checkbox");
		Log.info("Step:03 - Uncheck Active Only checkbox");
		
		click(custSearch.custIncludeReject);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Check the Include Reject checkbox");
		Log.info("Step:04 - Check the Include Reject checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
		Log.info("Step:05 - Click on the Search button.");
		
		
		if(ElementDisplayed(custSearch.custGridItem)) {
			ExtentTestManager.getTest().log(Status.PASS, "Listing the customer include rejected customer ");
			Log.info("Listing the customer include rejected customer ");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean custLastNameEdit(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		

		
		String generatedCustId = generateCustId();
		
        //Edit Customer Last Name - Valid Edit
		 input(custSearch.custId, generatedCustId);
		 click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		try {
		click(custSearch.custEditBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click Edit button.");
		Log.info("Step:02 -  Click Edit button.");
				
		
		SwitchToFrame(custSearch.iframe);
		
		click(custSearch.custLastName);
		clear(custSearch.custLastName);

		String validLastName = testdata.get("validLastName").toString();
		input(custSearch.custLastName, validLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Modify the last name in customer details.");
		Log.info("Step:03 -  Modify the last name in customer details.");
		
//		Remove white spaces in First name if any
		click(custSearch.custFirstNameTxtBox);
		String fname = driver.findElement(custSearch.custFirstNameTxtBox).getAttribute("value");
		String modifiedValue = fname.replaceAll("\\s", "");
		clear(custSearch.custFirstNameTxtBox);
		input(custSearch.custFirstNameTxtBox, modifiedValue);
		

//        Actions actions = new Actions(driver);
//        // Perform the backspace action
//        actions.moveToElement(driver.findElement(custSearch.pdFirstNameTxtBox)).click().sendKeys(Keys.BACK_SPACE).perform();
		
        //Age group
        select("Major",custSearch.pdAgeGroupDropdown);
        
//        //AgeAsOn
//        clear(custSearch.pdAgeAsOnTxtBox);
//	    click(custSearch.pdAgeAsOnTxtBox);      
//			String AgeAsOn = testdata.get("AgeAsOn").toString();
//			input(custSearch.pdAgeAsOnTxtBox,AgeAsOn);	

		//aadhar num
		clear(custSearch.pdAadharNumTxtBox);
		String validAadhar = quickCust.generateUniqueId(quickCust.spAadhaar, quickCust.clmnNamAadhaar);
		input(custSearch.pdAadharNumTxtBox,validAadhar);
		
		//mobile num, 
		clear(custSearch.pdMobileNumTxtBox);
		String validMobNum = quickCust.generateUniqueId(quickCust.spMobileNum, quickCust.clmnNamMobileNum);
		input(custSearch.pdMobileNumTxtBox,validMobNum);
		
		//pan num
		clear(custSearch.pdPanTxtBox);
		String validPAN = quickCust.generateUniqueId(quickCust.spPAN, quickCust.clmnNamPAN);
		input(custSearch.pdPanTxtBox,validPAN);
		
		//CKYC ID
		clear(custSearch.pdCKYCIdTxtBox);
		String CKYCId = quickCust.generateUniqueId(quickCust.spAadhaar, quickCust.clmnNamAadhaar);
		input(custSearch.pdCKYCIdTxtBox,"69"+CKYCId);
		
		ScrollUntilElementVisible(custSearch.custCheckAvailabilityBtn);
		click(custSearch.custCheckAvailabilityBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Check Availability Button.");
		Log.info("Step:04 - Click Check Availability Button.");
		
		//Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
//		        driver.manage().window().maximize();
		        popupAppeared = true;
				if(ElementDisplayed(custSearch.popWindowErrMsg)) {
					driver.close();
					driver.switchTo().window(mainWindowHandle);
				}        
		    }
		    }
		
		SwitchToFrame(custSearch.iframe);		
		click(custSearch.custSaveNProceedBtn);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on Save and Proceed button.");
		Log.info("Step:05 - Click on Save and Proceed button.");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(custSearch.savedPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are updated successfully.");
			Log.info("Expected Result: Customer details are updated successfully.");
		}
		click(custSearch.savedPopUp);

		ExtentTestManager.endTest();		

		click(custSearch.custSrch);
		click(custSearch.custClearBtn);
		
		ExtentTestManager.endTest();
		
		
		
		}catch(Exception e) {
			deleteDuplicates();
			driver.close();
			Base_Class.SetUp();
			pcRegistration(testdata, context);
			userLoginValidPaswrd(testdata, context);
			customerSearchWindow();
			custLastNameEdit(testdata, context);

		}
		return true;
}//end
	
	
	public boolean lastNameECP(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Last Name Field - ECP Validations");
		Log.info("Last Name Field - ECP Validations");
		
		String validCustId3 = testdata.get("validCustId3").toString();
		click(custSearch.custId);
		input(custSearch.custId, validCustId3);
//		click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select an existing customer.");
		Log.info("Step:01 -  Select an existing customer.");
		
		
		click(custSearch.custEditBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click Edit button.");
		Log.info("Step:02 -  Click Edit button.");
		
		//Numeric Name input
		SwitchToFrame(custSearch.iframe);
		click(custSearch.custLastName);
		clear(custSearch.custLastName);
		String numericLastName = testdata.get("numericLastName").toString();
		input(custSearch.custLastName, numericLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Enter Last Name in Last Name field (Numeric Input).");
		Log.info("Step:03 -  Enter Last Name in Last Name field (Numeric Input).");
		
		click(custSearch.lastNameTxt);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric inputs prompts error message.");
			Log.info("Expected Result: Numeric inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		//AlphaNumeric Name input
		click(custSearch.custLastName);
		clear(custSearch.custLastName);
		String alphanumericLastName = testdata.get("alphanumericLastName").toString();
		input(custSearch.custLastName, alphanumericLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 -  Enter Last Name in Last Name field (AlphaNumeric Input).");
		Log.info("Step:04 -  Enter Last Name in Last Name field (AlphaNumeric Input).");
		
		click(custSearch.lastNameTxt);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AlphaNumeric inputs prompts error message.");
			Log.info("Expected Result: AlphaNumeric inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		//Special Characters Name input
		
		ExtentTestManager.startTest("Invalid Data Format in Last Name");
		Log.info("Invalid Data Format in Last Name");
		click(custSearch.custLastName);
		clear(custSearch.custLastName);
		String specialCharacterLastName = testdata.get("specialCharacterLastName").toString();
		input(custSearch.custLastName, specialCharacterLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 -  Enter Last Name in Last Name field (Special Characters Input).");
		Log.info("Step:05 -  Enter Last Name in Last Name field (Special Characters Input).");
		
		click(custSearch.lastNameTxt);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Special Characters inputs prompts error message.");
			Log.info("Expected Result: Special Characters inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		
		//Alphabetic Name input
		click(custSearch.custLastName);
		clear(custSearch.custLastName);
		String validLastName = testdata.get("validLastName").toString();
		input(custSearch.custLastName, validLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 -  Enter Last Name in Last Name field (Alphabetic Input).");
		Log.info("Step:06 -  Enter Last Name in Last Name field (Alphabetic Input).");
		click(custSearch.lastNameTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabetic inputs are allowed.");
		Log.info("Expected Result: Alphabetic inputs are allowed.");
		
		ExtentTestManager.endTest();
			driver.switchTo().defaultContent();			
			click(custSearch.custSrch);
			click(custSearch.custClearBtn);
			
			ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewCustomerDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		//View Customer Details
		ExtentTestManager.startTest("View Customer Details");
		Log.info("View Customer Details");
		String validCustId = testdata.get("validCustId").toString();
		click(custSearch.custId);
		input(custSearch.custId, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid Customer Id in Customer ID field.");
		Log.info("Step:01 - Enter valid Customer Id in Customer ID field.");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Search button.");
		Log.info("Step:02 - Click on Search button.");
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select the customer from the list.");
		Log.info("Step:03 - Select the customer from the list.");
		
		click(custSearch.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the View button.");
		Log.info("Step:04 - Click on the View button.");
		
		if(ElementDisplayed(custSearch.personalDetails)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details page displays KYC, address, and bank details.");
			Log.info("Expected Result: Customer details page displays KYC, address, and bank details.");
		}
		ExtentTestManager.endTest();
		
		//Verify Non-Editable Customer Details
		
		ExtentTestManager.startTest("Verify Non-Editable Customer Details");
		Log.info("Verify Non-Editable Customer Details");
		String tagName = driver.findElement(custSearch.nonEditableField).getTagName();
		if(tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("textarea")) {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Customer details page displays KYC, address, and bank details.");
			Log.info("Expected Result: Fields are editable, user can modify details.");
			
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fields are non-editable, user cannot modify details.");
			Log.info("Expected Result: Fields are non-editable, user cannot modify details.");
		}
		
		ScrollUntilElementVisible(custSearch.previousBtn);
		click(custSearch.previousBtn);		
		
		click(custSearch.custClearBtn);
		
		ExtentTestManager.endTest();
		return true;
	}
	

	public boolean docNum(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		String docNum = testdata.get("docNum").toString();				
		input(custSearch.custDocNum, docNum);
		click(custSearch.custDocType);
		click(custSearch.custDocTypeElection);
		click(custSearch.custSearchBtn);
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Customer details should be shows in the grid against the given PAN No");
			Log.info("Customer details should be shows in the grid against the given PAN No");
		}
		click(custSearch.custClearBtn);
return true;
}
	
	public boolean attachmentPopUp(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		
		
		ExtentTestManager.startTest("Attachment Popup");
		Log.info("Attachment Popup");
		String custIDAttachments = testdata.get("custIDAttachments").toString();
		click(custSearch.custId);
		input(custSearch.custId, custIDAttachments);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid Customer Id in Customer ID field.");
		Log.info("Step:01 - Enter valid Customer Id in Customer ID field.");
		
		click(custSearch.custSearchBtn);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Search button.");
		Log.info("Step:02 - Click on Search button.");
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select the customer from the list.");
		Log.info("Step:03 - Select the customer from the list.");
		
		click(custSearch.custAttachmentsBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Attachments button.");
		Log.info("Step:04 - Click on the Attachments button.");
		
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                //driver.manage().window().maximize();
                popupAppeared = true;
                if(ElementDisplayed(custSearch.photoSignWndow)) {
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Attachment popup window open.");
        			Log.info("Expected Result: Attachment popup window open."); 			
        		}
                ExtentTestManager.endTest();
        		
        		
        		
        		
        		ExtentTestManager.startTest("Attachment Popup Image Display");
        		Log.info("Attachment Popup Image Display");
        		if(ElementDisplayed(custSearch.attachmentImg)) {
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image is visible in the attachment popup");
        			Log.info("Expected Result: Image is visible in the attachment popup");
        		}
    			ExtentTestManager.endTest();
        		
        		
        		
        		
        		ExtentTestManager.startTest("Rotate Button Functionality");
        		Log.info("Rotate Button Functionality");
        		click(custSearch.attachmentRotate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Rotate button.");
        		Log.info("Step:01 - Click on Rotate button.");
        		
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image rotates.");
        			Log.info("Expected Result: Image rotates.");
     
        		ExtentTestManager.endTest();
        		
        		
        		
        		ExtentTestManager.startTest("Image Button Functionality");
        		Log.info("Image Button Functionality");
        		click(custSearch.attachmentImg);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the image button.");
        		Log.info("Step:01 - Click on the image button.");
        		
        		if(ElementDisplayed(custSearch.attachmentZoom)) {        			
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image is displayed in a larger view");
        			Log.info("Expected Result: Image is displayed in a larger view");
        		}
        		
        		
        		
        		ExtentTestManager.startTest("Close Button Functionality");
        		Log.info("Close Button Functionality");	
        		click(custSearch.attachmentClose);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Close button.");
        		Log.info("Step:01 - Click on Close button.");
        		
    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image popup closes.");
    			Log.info("Expected Result: Image popup closes.");
    			
        		ExtentTestManager.endTest();
        		
        		
        		
        		ExtentTestManager.startTest("Zoom Image Functionality");
        		Log.info("Zoom Image Functionality");
        		
        		click(custSearch.attachmentImg);
        		click(custSearch.attachmentZoom);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Zoom button.");
        		Log.info("Step:01 - Click on Zoom button.");
        		driver.manage().window().maximize();
    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image zooms in/out as expected.");
    			Log.info("Expected Result: Image zooms in/out as expected.");
    			
        		ExtentTestManager.endTest();
        		
        		driver.close();
        		 
            }
            driver.switchTo().window(mainWindowHandle);
            }
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
return true;
}	
	
	public boolean freeze(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Freeze Customer");
		Log.info("Freeze Customer");
		
		//freeze window
		
		String generatedCustId = generateCustId();
		
		click(custSearch.custClearBtn);
		click(custSearch.custProspectsOnly);
//		String validCustId3 = testdata.get("validCustId3").toString();
		click(custSearch.custId);
		input(custSearch.custId, generatedCustId);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.freeze);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Freeze button.");
		Log.info("Step:02 - Click on Freeze button.");
		
		
		if(ElementDisplayed(custSearch.custFreezeWndow)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Freeze window opens with customer details");
			Log.info("Expected Result: Freeze window opens with customer details");
		}
		ExtentTestManager.endTest();
		
		
		
		//Verify Customer Details in Freeze Window
		ExtentTestManager.startTest("Verify Customer Details in Freeze Window");
		Log.info("Verify Customer Details in Freeze Window");
		boolean flag1 = ElementDisplayed(custSearch.freezeCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Customer ID.");
		Log.info("Step:01 - Verify the Presence of Column - Customer ID.");
		
		boolean flag2 = ElementDisplayed(custSearch.freezeName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Name.");
		Log.info("Step:02 - Verify the Presence of Column - Name.");
		
		boolean flag3 = ElementDisplayed(custSearch.freezeRisk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Risk.");
		Log.info("Step:03 - Verify the Presence of Column - Risk.");
		
		boolean flag4 = ElementDisplayed(custSearch.freezePanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - PAN No.");
		Log.info("Step:04 - Verify the Presence of Column - PAN No.");
		
		boolean flag5 = ElementDisplayed(custSearch.freezeCrntAge);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Current Age.");
		Log.info("Step:05 - Verify the Presence of Column - Current Age.");
		
		boolean flag6 = ElementDisplayed(custSearch.freezeCustType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Customer Type.");
		Log.info("Step:06 - Verify the Presence of Column - Customer Type.");
		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
			Log.info("Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
		}
		ExtentTestManager.endTest();
		
		
		
		//fAttempt to Freeze Without Checkbox
		ExtentTestManager.startTest("Attempt to Freeze Without Checkbox");
		Log.info("Attempt to Freeze Without Checkbox");
		click(custSearch.freezeSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Submit button without checking the freeze checkbox");
		Log.info("Step:01 - Click Submit button without checking the freeze checkbox");
		
		
		if(ElementDisplayed(custSearch.freezeErrMsgPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed: \"Please select the freeze checkbox\"");
			Log.info("Expected Result: Error message displayed: \"Please select the freeze checkbox\"");
		}
		click(custSearch.freezeErrMsgOKBtn);
		
		ExtentTestManager.endTest();
		
		
		
		//cancel freeze
		ExtentTestManager.startTest("Cancel Freeze Operation");
		Log.info("Cancel");
		click(custSearch.freezeCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Cancel button.");
		Log.info("Step:01 - Click on Cancel button.");
		if(ElementDisplayed(custSearch.custSrch)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Action is canceled, navigates back to customer search window");
			Log.info("Expected Result: Action is canceled, navigates back to customer search window");
		}
		ExtentTestManager.endTest();
		click(custSearch.custClearBtn);
		


return true;
}	
	
	//Enter Valid Freeze Remark and Submit
	public void freezeCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException {
					
					String generatedCustId = generateCustId();
		            
		             //Enter Valid Freeze Remark and Submit
		        	ExtentTestManager.startTest("Enter Valid Freeze Remark and Submit");
		        	click(custSearch.custClearBtn);
		        	Log.info("Enter Valid Freeze Remark and Submit");
		       		 input(custSearch.custId, generatedCustId);
//		       		 click(custSearch.custActiveOnly);
		       		 click(custSearch.custProspectsOnly);
		     		click(custSearch.custSearchBtn);
		    		
		    		click(custSearch.custSelect);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		    		Log.info("Step:01 - Select a customer from the list.");
		    		
		    		click(custSearch.freeze);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Freeze' button");
		    		Log.info("Step:02 - Click 'Freeze' button");
		    		
		    		click(custSearch.freezeCheckBox);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Check the freeze checkbox.");
		    		Log.info("Step:03 - Check the freeze checkbox.");
		    		
		    		String remarkComment = testdata.get("remarkComment").toString();
		    		input(custSearch.freezeRemark, remarkComment);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Remarks in Remarks field.");
		    		Log.info("Step:04 - Enter Remarks in Remarks field.");
		    		
		    		click(custSearch.freezeSubmitBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on Submit button.");
		    		Log.info("Step:05 - Click on Submit button.");
		    		
		    		
		    		if(ElementDisplayed(custSearch.savedPopUp)) {
		    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is updated into freeze list");
		    			Log.info("Expected Result: Customer is updated into freeze list");
		    		}
		    		click(custSearch.savedPopUp);

		    		ExtentTestManager.endTest(); 
		    		click(custSearch.freezeCancelBtn);
			click(custSearch.custClearBtn);	 
	}
	
	public boolean activate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Select Customer and Open Active Window");
		Log.info("Select Customer and Open Active Window");
		
		//Select Customer and Open Active Window
		click(custSearch.custClearBtn);
		click(custSearch.custProspectsOnly);
//		click(custSearch.custProspectsOnly);
		
		String generatedCustId = generateCustId();
		
//		String validCustId3 = testdata.get("validCustId3").toString();
		click(custSearch.custId);
		input(custSearch.custId, generatedCustId);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.activate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Active' button");
		Log.info("Step:02 - Click 'Active' button");
		
		if(ElementDisplayed(custSearch.custActiveWndow)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Active window opens showing customer details");
			Log.info("Expected Result: Customer Active window opens showing customer details");
		}
		ExtentTestManager.endTest();
		
		
		//Verify Customer Details Display
		ExtentTestManager.startTest("Verify Customer Details Display");
		Log.info("Verify Customer Details Display");
		
		boolean flag1 = ElementDisplayed(custSearch.freezeCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Customer ID.");
		Log.info("Step:01 - Verify the Presence of Column - Customer ID.");
		
		boolean flag2 = ElementDisplayed(custSearch.freezeName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Name.");
		Log.info("Step:02 - Verify the Presence of Column - Name.");
		
		boolean flag3 = ElementDisplayed(custSearch.freezeRisk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Risk.");
		Log.info("Step:03 - Verify the Presence of Column - Risk.");
		
		boolean flag4 = ElementDisplayed(custSearch.freezePanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - PAN No.");
		Log.info("Step:04 - Verify the Presence of Column - PAN No.");
		
		boolean flag5 = ElementDisplayed(custSearch.freezeCrntAge);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Current Age.");
		Log.info("Step:05 - Verify the Presence of Column - Current Age.");
		
		boolean flag6 = ElementDisplayed(custSearch.freezeCustType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Customer Type.");
		Log.info("Step:06 - Verify the Presence of Column - Customer Type.");
		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
			Log.info("Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
		}
		ExtentTestManager.endTest();
		
		//Submit De-activation Without Date
		ExtentTestManager.startTest("Submit Deactivation Without Date");
		Log.info("Submit Deactivation Without Date");
		click(custSearch.deactiveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the Deactivate Checkbox");
		Log.info("Step:01 - Check the Deactivate Checkbox");
		
		clear(custSearch.activateDateTxtBox);
		click(custSearch.activateDateTxt);
		input(custSearch.activateDateTxtBox,""+Keys.ENTER);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Leave date empty");
		Log.info("Step:02 - Leave date empty");
		
		if(ElementDisplayed(custSearch.activateDateErrMsgPopUp)) {
			click(custSearch.activateDateErrMsgPopUp);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message to select a date is displayed");
			Log.info("Expected Result: Error message to select a date is displayed");
		}
		ExtentTestManager.endTest();
		
		
		//Deactivate a Customer with Valid Date
//		ExtentTestManager.startTest("Deactivate a Customer with Valid Date");
//		
//		String freezeFutureDate = testdata.get("freezeFutureDate").toString();
//		click(custSearch.activateDateTxtBox);
//		input(custSearch.activateDateTxtBox, freezeFutureDate);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a date from the calendar (not future date)");
//		Log.info("Step:01 - Select a date from the calendar (not future date)");
//		
//		String remarkComment = testdata.get("remarkComment").toString();
//		input(custSearch.freezeRemark, remarkComment);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Remarks in Remarks field.");
//		Log.info("Step:02 - Enter Remarks in Remarks field.");
//		
//		click(custSearch.freezeSubmitBtn);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Submit Button");
//		Log.info("Step:03 - Click on Submit Button");
//		
//		
//		if(ElementDisplayed(custSearch.deactiveOrActiveConfirmPopUp)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is moved to the deactivate list");
//			Log.info("Expected Result: Customer is moved to the deactivate list");
//		}
//		click(custSearch.deactiveOrActiveConfirmPopUp);
//		ExtentTestManager.endTest();
			
		
		//Cancel De-activation Process
		ExtentTestManager.startTest("Cancel Deactivation Process");
		Log.info("Cancel Deactivation Process");
		click(custSearch.freezeCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Cancel button.");
		Log.info("Step:01 - Click Cancel button.");
		
		if(ElementDisplayed(custSearch.custSrch)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Page redirects back to the Customer Search window");
			Log.info("Expected Result: Page redirects back to the Customer Search window");
		}
	
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	//Deactivate a Customer with Valid Date
	public void deactivateACustomerWithValidDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException {
             
			 String generatedCustId = generateCustId();
			 
		             //Enter Valid Remark and Submit
		        	ExtentTestManager.startTest("Deactivate a Customer with Valid Date");
		        	Log.info("Deactivate a Customer with Valid Date");
		       		 input(custSearch.custId, generatedCustId);
//		       		 click(custSearch.custActiveOnly);
		       		 click(custSearch.custProspectsOnly);
		     		click(custSearch.custSearchBtn);
		    		
		    		click(custSearch.custSelect);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		    		Log.info("Step:01 - Select a customer from the list.");
		    		
		    		click(custSearch.activate);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Active' button");
		    		Log.info("Step:02 - Click 'Active' button");
		    		
		    		click(custSearch.deactiveCheckBox);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Check the Deactivate Checkbox");
		    		Log.info("Step:03 - Check the Deactivate Checkbox");
		    		
		    		String remarkComment = testdata.get("remarkComment").toString();
		    		input(custSearch.freezeRemark, remarkComment);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Remarks in Remarks field.");
		    		Log.info("Step:04 - Enter Remarks in Remarks field.");
		    		
		    		click(custSearch.freezeSubmitBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Submit Button");
		    		Log.info("Step:03 - Click on Submit Button");
		    		
		    		
		    		if(ElementDisplayed(custSearch.deactiveOrActiveConfirmPopUp)) {
		    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is moved to the deactivate list");
		    			Log.info("Expected Result: Customer is moved to the deactivate list");
		    			click(custSearch.deactiveOrActiveConfirmPopUp);
		    		}else {
		    			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Customer is not moved to the deactivate list");
		    			Log.info("Expected Result: Customer is not moved to the deactivate list");
		            }

		      

		    ExtentTestManager.endTest();
			click(custSearch.freezeCancelBtn);
			click(custSearch.custClearBtn);	 
	}
	
	
	public boolean deleteCust(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		
		click(custSearch.custClearBtn);
		
		ExtentTestManager.startTest("Delete Customer - Authorized Customer");
		Log.info("Delete Customer - Authorized Customer");
		
		String authorizedCustomer = generateCustId();
		input(custSearch.custId, authorizedCustomer);
		click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an authorized customer from the list.");
		Log.info("Step:01 - Select an authorized customer from the list.");
		
		click(custSearch.custDeleteBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Delete button");
		Log.info("Step:02 - Click on Delete button");
		
		Base_Class.AcceptAlert();
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Accept the Alert");
		Log.info("Step:03 - Accept the Alert");
		
			if(ElementDisplayed(custSearch.deleteAuthorizedPopUpOkBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Validation message displayed: \"Cannot Delete. Authorized Customer.\"");
				Log.info("Validation message displayed: \"Cannot Delete. Authorized Customer.\"");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
		click(custSearch.deleteAuthorizedPopUpOkBtn);
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Validation Message on Delete
		
		ExtentTestManager.startTest("Verify Validation Message on Delete");
		Log.info("Verify Validation Message on Delete");
		
		click(custSearch.custClearBtn);
		input(custSearch.custId, authorizedCustomer);
		click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an customer from the list.");
		Log.info("Step:01 - Select an customer from the list.");
		
		click(custSearch.custDeleteBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Delete button");
		Log.info("Step:02 - Click on Delete button");
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation Message displayed= " + alertText);
		Log.info( "Expected Result: Validation Message displayed= " + alertText);
		
		Base_Class.DismissAlert();
		ExtentTestManager.endTest();
		
		
		
		
		//cancel delete
		click(custSearch.custClearBtn);
		
		ExtentTestManager.startTest("Cancel Deletion Confirmation");
		Log.info("Cancel Deletion Confirmation");
		
		input(custSearch.custId, authorizedCustomer);
		click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an authorized customer from the list.");
		Log.info("Step:01 - Select an authorized customer from the list.");
		
		click(custSearch.custDeleteBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Delete button");
		Log.info("Step:02 - Click on Delete button");
		
		Base_Class.DismissAlert();
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Reject the Alert");
		Log.info("Step:03 - Reject the Alert");
		
			if(ElementDisplayed(custSearch.custListTable)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deletion is canceled, customer remains in the list.");
				Log.info("Expected Result: Deletion is canceled, customer remains in the list.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			ExtentTestManager.endTest();
			
			
			

			//Click Delete Without Selection

			ExtentTestManager.startTest("Click Delete Without Selection");
			Log.info("Click Delete Without Selection");
			
			click(custSearch.custClearBtn);
			click(custSearch.custProspectsOnly);
			click(custSearch.custSearchBtn);
			
			click(custSearch.custDeleteBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Delete button without selecting any customer.");
			Log.info("Step:01 - Click on the Delete button without selecting any customer.");
			
			if(ElementDisplayed(custSearch.deleteWithoutSelectOkBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed, e.g., \"Please select a customer to delete.\"");
				Log.info("Expected Result: Error message displayed, e.g., \"Please select a customer to delete.\"");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			click(custSearch.deleteWithoutSelectOkBtn);
			
			ExtentTestManager.endTest();
		return true;
	}
	
	public boolean mark(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		
		//Select Customer and Mark - Valid Data
		ExtentTestManager.startTest("Select Customer and Mark - Valid Data");
		Log.info("Select Customer and Mark - Valid Data");
		click(custSearch.custProspectsOnly);
		
		String generatedCustId = generateCustId();

		
//		String validCustId3 = testdata.get("validCustId3").toString();
		click(custSearch.custId);
		input(custSearch.custId, generatedCustId);
		
		click(custSearch.custSearchBtn);
		
		
		String custSrchCustIdTxtBoxValue = driver.findElement(custSearch.custSrchCustIdTxtBox).getAttribute("value");
		System.out.println(custSrchCustIdTxtBoxValue);
		String custSrchDispNameTxtBoxValue = driver.findElement(custSearch.custSrchDispName).getText();
		System.out.println(custSrchDispNameTxtBoxValue);
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.custMarkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Mark button.");
		Log.info("Step:02 - Click on Mark button.");
	
		String markCustId = driver.findElement(custSearch.markCustIdTxtBox).getAttribute("value");
		String markCustName = driver.findElement(custSearch.markCustName).getAttribute("value");
		String markDispName = driver.findElement(custSearch.markDisplayName).getAttribute("value");
		String markCustDOB = driver.findElement(custSearch.markDOB).getAttribute("value");
		String markCustAge = driver.findElement(custSearch.markAge).getAttribute("value");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer mark window opens with customer data pre-filled."
				+ " Customer ID - " + markCustId +" Customer Name - " + markCustName + " Display Name - " + markDispName+ " DOB & Age - " + markCustDOB + " & " + markCustAge);
		Log.info( "Expected Result: Customer mark window opens with customer data pre-filled."
				+ " Customer ID - " + markCustId +" Customer Name - " + markCustName + " Display Name - " + markDispName+ " DOB & Age - " + markCustDOB + " & " + markCustAge);
		ExtentTestManager.endTest();
		
		
		//Verify Customer Mark Details
		ExtentTestManager.startTest("Verify Customer Mark Details");
		Log.info("Verify Customer Mark Details");
//		String custSrchCustIdTxtBoxValue = driver.findElement(custSearch.custSrchCustIdTxtBox).getAttribute("value");
//		String custSrchDispNameTxtBoxValue = driver.findElement(custSearch.custSrchDispName).getAttribute("value");

		if(markCustId.equalsIgnoreCase(custSrchCustIdTxtBoxValue) && markDispName.equalsIgnoreCase(custSrchDispNameTxtBoxValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Customer ID & Display Name.");
			Log.info("Step:01 - Verify Customer ID & Display Name.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All details match with selected customer from search results.");
			Log.info("Expected Result: All details match with selected customer from search results.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Details doesn't match with selected customer from search results.");
			Log.info("Expected Result: Details doesn't match with selected customer from search results.");
		}
		ExtentTestManager.endTest();
		
		
		
		//Leave Remarks Empty
		ExtentTestManager.startTest("Leave Remarks Empty");
		Log.info("Leave Remarks Empty");
		clear(custSearch.markRemarkTxtBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Customer ID & Display Name.");
		Log.info("Step:01 - Leave 'Remark' field empty.");
		
		click(custSearch.markSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Submit' button.");
		Log.info("Step:02 - Click 'Submit' button.");

		if(ElementDisplayed(custSearch.markRemarkReqClose)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed requiring remarks.");
			Log.info("Expected Result: Error message displayed requiring remarks.");
		}
		click(custSearch.markRemarkReqClose);
		
		ExtentTestManager.endTest();
		
		
		
		//Status Required
		ExtentTestManager.startTest("Status Required");
		Log.info("Status Required");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Do not select any option in the Status drop down");
		Log.info("Step:01 - Do not select any option in the Status drop down");
		
		String remarkComment = testdata.get("remarkComment").toString();
		input(custSearch.markRemarkTxtBox, remarkComment);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Remarks in Remarks field.");
		Log.info("Step:02 - Enter Remarks in Remarks field.");
		
		click(custSearch.markSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click 'Submit' button.");
		Log.info("Step:03 - Click 'Submit' button.");

		
		if(ElementDisplayed(custSearch.markStatusRqrdPopUpOkBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed, Please select Status.");
			Log.info("Expected Result: Error message displayed, Please select Status.");
		}
		click(custSearch.markStatusRqrdPopUpOkBtn);
		//clear(custSearch.markRemarkTxtBox);
		ExtentTestManager.endTest();
		
		
		
		//Select Valid Status
		ExtentTestManager.startTest("Select Valid Status");
		Log.info("Select Valid Status");
//		click(custSearch.markStatusDropDown);
		select("BANKRUPT",custSearch.markStatusDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select valid status from dropdown.");
		Log.info("Step:01 - Select valid status from dropdown.");
		ExtentTestManager.endTest();
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Status is selected successfully.");
		Log.info("Expected Result: Status is selected successfully.");
		
		
		
		
		//Invalid Date Format
		ExtentTestManager.startTest("Invalid Date Format");
		Log.info("Invalid Date Format");
		String invalidDate = testdata.get("invalidDate").toString();
		click(custSearch.markEffDate);
		input(custSearch.markEffDate, invalidDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select any past or current date.");
		Log.info("Step:01 - Manually enter date in invalid format.");	
		
		click(custSearch.markSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Submit' button.");
		Log.info("Step:02 - Click 'Submit' button.");
		
		ElementDisplayed(custSearch.markRemarkReqClose);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed requiring correct date format.");
			Log.info("Expected Result: Error message displayed requiring correct date format.");
		click(custSearch.markRemarkReqClose);
		
		ExtentTestManager.endTest();	
		
		
		
		
		//Select Effect Date - Valid Past or Current Date
		ExtentTestManager.startTest("Select Effect Date - Valid Past or Current Date");
		Log.info("Select Effect Date - Valid Past or Current Date");
		String freezeFutureDate = testdata.get("freezeFutureDate").toString();
		click(custSearch.markEffDate);
		input(custSearch.markEffDate, freezeFutureDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select any past or current date.");
		Log.info("Step:01 - Select any past or current date.");	
		
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is selected successfully.");
			Log.info("Expected Result: Date is selected successfully.");
		
		ExtentTestManager.endTest();
		

		//Submit and Close Window
		ExtentTestManager.startTest("Submit and Close Window");
		Log.info("Submit and Close Window");
		click(custSearch.markCloseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Close' button.");
		Log.info("Step:01 -  Click 'Close' button.");	
		
		ElementDisplayed(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search window is displayed, and data is not saved.");
		Log.info("Expected Result: Customer search window is displayed, and data is not saved.");
		
		click(custSearch.custClearBtn);
		
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public void expired1(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		click(custSearch.custSrch);

		//Verify Customer Expire Details
		
		ExtentTestManager.startTest("Verify Customer Expire Details");
		Log.info("Verify Customer Expire Details");
		
		click(custSearch.custClearBtn);
		
		String generatedCustId = generateCustId();

		click(custSearch.custId);
		input(custSearch.custId, generatedCustId);
		click(custSearch.custProspectsOnly);
		click(custSearch.custSearchBtn);
		
		
		String custSrchCustIdTxtBoxValue = driver.findElement(custSearch.custSrchCustIdTxtBox).getAttribute("value");
		String custSrchDispNameTxtBoxValue = driver.findElement(custSearch.custSrchDispName).getText();
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.custExpiredBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Expired button.");
		Log.info("Step:02 - Click on Expired button.");
		
		String expireCustId = driver.findElement(custSearch.expireCustId).getAttribute("value");
		String expireCustName = driver.findElement(custSearch.expireCustName).getAttribute("value");
		String expireDispName = driver.findElement(custSearch.expireDispName).getAttribute("value");
		String expireDOBAndAge = driver.findElement(custSearch.expireDOBAndAge).getAttribute("value");
		

		
		if(expireCustId.equals(custSrchCustIdTxtBoxValue) && expireDispName.equals(custSrchDispNameTxtBoxValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Customer ID & Display Name.");
			Log.info("Step:01 - Verify Customer ID & Display Name.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All customer details are displayed correctly on the expired window.");
			Log.info("Expected Result: All customer details are displayed correctly on the expired window.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Displayed customer details doesn't match");
			Log.info("Expected Result: Displayed customer details doesn't match");
		}

		
		ExtentTestManager.endTest();
		
	}
	
	public boolean expired(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		
		try {
			
			click(custSearch.custSrch);
			click(custSearch.custClearBtn);
			
			String generatedCustId = generateCustId();

			click(custSearch.custId);
			input(custSearch.custId, generatedCustId);
			click(custSearch.custProspectsOnly);
			click(custSearch.custSearchBtn);
			
			click(custSearch.custSelect);
			click(custSearch.custExpiredBtn);

			String expireCustName = driver.findElement(custSearch.expireCustName).getAttribute("value");

			
			//Select State, Bank ID, Branch ID, Date
			
			click(custSearch.bankDetailsStateDropDown);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on State drop down.");
			Log.info("Step:01 - Click on State drop down.");
			
			click(custSearch.selectState);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a State from the drop down.");
			Log.info("Step:02 - Select a State from the drop down.");
			
			click(custSearch.bankDetailsBankIdDropDown);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Bank ID drop down.");
			Log.info("Step:03 - Click on Bank ID drop down.");
			
			click(custSearch.selectBankId);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Select a Bank ID from the drop down.");
			Log.info("Step:04 - Select a Bank ID from the drop down.");
			
			click(custSearch.bankDetailsBranchIdDropDown);
			ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on Branch ID drop down.");
			Log.info("Step:05 - Click on Branch ID drop down.");
			
			click(custSearch.selectBranchId);
			ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Select a Branch ID from the drop down.");
			Log.info("Step:06 - Select a Branch ID from the drop down.");
			
			String ifsc = driver.findElement(custSearch.bankDetailsIFSC).getAttribute("value");
			 if(ifsc.trim().isEmpty()) {
					ExtentTestManager.getTest().log(Status.FAIL, "IFSC code didn't load");
					Log.info("IFSC code didn't load");
			 }
			 else {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct IFSC code - "+ ifsc+" loads when Branch ID is selected." );
					Log.info("Expected Result: Correct IFSC code - "+ ifsc+" loads when Branch ID is selected." );
			 }
			ExtentTestManager.endTest();

		
		
		//Verify IFSC Code After Branch Selection
		
		ExtentTestManager.startTest("Verify IFSC Code After Branch Selection");
		Log.info("Verify IFSC Code After Branch Selection");
		click(custSearch.bankDetailsBranchIdDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Branch ID drop down.");
		Log.info("Step:01 - Click on Branch ID drop down.");
		
		click(custSearch.selectBranchId1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		Log.info("Step:02 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		
		String ifsc1 = driver.findElement(custSearch.bankDetailsIFSC).getAttribute("value");
		
		click(custSearch.bankDetailsBranchIdDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Branch ID drop down.");
		Log.info("Step:03 - Click on Branch ID drop down.");
		
		click(custSearch.selectBranchId2);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		Log.info("Step:04 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		
		String ifsc2 = driver.findElement(custSearch.bankDetailsIFSC).getAttribute("value");
		
		click(custSearch.bankDetailsBranchIdDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on Branch ID drop down.");
		Log.info("Step:05 - Click on Branch ID drop down.");
		
		click(custSearch.selectBranchId3);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		Log.info("Step:06 - Select a Branch ID from the drop down & Observe the IFSC code field.");
		
		String ifsc3 = driver.findElement(custSearch.bankDetailsIFSC).getAttribute("value");

		 if(ifsc1.trim().isEmpty() && ifsc2.trim().isEmpty() && ifsc3.trim().isEmpty()) {
				ExtentTestManager.getTest().log(Status.FAIL, "IFSC code didn't load");
				Log.info("IFSC code didn't load");
		 }
		 else {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: IFSC code updates correctly with each branch selection. "+ "Selection:01 - "+ifsc1+ " Selection:02 - "+ifsc2+ " Selection:03 - "+ifsc3);
				Log.info("Expected Result: IFSC code updates correctly with each branch selection. "+ "Selection:01 - "+ifsc1+ " Selection:02 - "+ifsc2+ " Selection:03 - "+ifsc3);
		 }
		
		ExtentTestManager.endTest();
		
		
		
		//Add Customer Details to Grid
				ExtentTestManager.startTest("Add Customer Details to Grid");
				Log.info("Add Customer Details to Grid");
				input(custSearch.bankDetailsCustName, expireCustName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Customer Name in Cust Name field.");
				Log.info("Step:01 - Enter Customer Name in Cust Name field.");
				
				String bankDetailsAddress = testdata.get("bankDetailsAddress").toString();
				input(custSearch.bankDetailsAddressTxtBox, bankDetailsAddress);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter ADDRESS in Address field.");
				Log.info("Step:02 - Enter ADDRESS in Address field.");
				
				String bankDetailsAccNum = testdata.get("bankDetailsAccNum").toString();
				input(custSearch.bankDetailsAccNumTxtBox, bankDetailsAccNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Bank Account number in BankAccNo field.");
				Log.info("Step:03 - Enter Bank Account number in BankAccNo field.");
				
				input(custSearch.bankDetailsReTypeAccNumTxtBox, bankDetailsAccNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter same Bank Account number in Retype AccNo field.");
				Log.info("Step:04 - Enter same Account number in Retype AccNo field as BankAccNo field.");
				
				click(custSearch.bankDetailsAddBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on ADD button.");
				Log.info("Step:05 - Click on ADD button.");

				ElementDisplayed(custSearch.bankDetailsDataGrid);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is added to the grid upon adding.");
				Log.info("Expected Result: Data is added to the grid upon adding.");
			
				ExtentTestManager.endTest();
				
				
				//Validate Retype Bank Acc No
				
				ExtentTestManager.startTest("Validate Retype Bank Acc No");
				Log.info("Validate Retype Bank Acc No");
				click(custSearch.bankDetailsAccNumTxtBox);
				
				input(custSearch.bankDetailsAccNumTxtBox, bankDetailsAccNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Bank Account number in BankAccNo field.");
				Log.info("Step:01 - Enter Bank Account number in BankAccNo field.");
				
				click(custSearch.bankDetailsReTypeAccNumTxtBox);
				
				String bankDetailsInvalidAccNum = testdata.get("bankDetailsInvalidAccNum").toString();
				input(custSearch.bankDetailsReTypeAccNumTxtBox, bankDetailsInvalidAccNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter different values in Bank Acc No and Retype Acc No fields.");
				Log.info("Step:02 - Enter different values in Bank Acc No and Retype Acc No fields.");
				
				click(custSearch.bankDetailsRetypeAccNumTxt);
				
				ElementDisplayed(custSearch.accNumMismatchCloseBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed if values don't match.");
				Log.info("Expected Result: Error message displayed if values don't match.");
			
				click(custSearch.accNumMismatchCloseBtn);
				
				ExtentTestManager.endTest();
				
				
				
				//Error Handling for Empty Fields
				
				ExtentTestManager.startTest("Error Handling for Empty Fields");
				Log.info("Error Handling for Empty Fields");
				click(custSearch.expireSubmitBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Submit' button.");
				Log.info("Step:01 -  Click 'Submit' button.");	
				
				ElementDisplayed(custSearch.expireDateReqPopUpClose);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Appropriate error message is displayed for empty fields.");
				Log.info("Expected Result: Appropriate error message is displayed for empty fields.");
				
				click(custSearch.expireDateReqPopUpClose);
				
				ExtentTestManager.endTest();
				
				
				
				
				//Cancel and Redirect to Customer Search
				
				ExtentTestManager.startTest("Cancel and Redirect to Customer Search");
				Log.info("Cancel and Redirect to Customer Search");
				click(custSearch.expireCloseBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Close' button.");
				Log.info("Step:01 -  Click 'Close' button.");	
				
				ElementDisplayed(custSearch.custClearBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is canceled and page redirects to customer search window.");
				Log.info("Expected Result: Data is canceled and page redirects to customer search window.");
				
				click(custSearch.custClearBtn);
				
				ExtentTestManager.endTest();
				
		}catch(Exception e) {
			deleteDuplicates();
			expired(testdata, context);
		}
		

		return true;
	
	}

	public void updateMakerId() throws InterruptedException,ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		
		String query = "SELECT TOP(1000) Cust_ID, RecordStatus, LogAction, TrnMode, ProductOperationCode, TransID, EntryID, Remark, MakerID, EntryDate, Cashier, CancelledBy, Checker1ID FROM TransactionLog WHERE MakerID = 'akash' ORDER BY EntryDate DESC;";

		// Establish the connection
		try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
		     Statement statement = connection.createStatement();
		     ResultSet resultSet = statement.executeQuery(query)) {

		    // Flag to track if we've found the first Entry Date
		    boolean isFirstTransaction = true;
		    String firstEntryDate = null;

		    // Iterate through the result set
		    while (resultSet.next()) {
		        // Fetch the relevant columns
		        long custId = resultSet.getLong(1);  // Column 1: Cust_ID
		        int entryID = resultSet.getInt(7);  // Column 7: EntryID
		        String makerId = resultSet.getString(9);  // Column 9: MakerID
		        String entryDate = resultSet.getString(10);  // Column 10: EntryDate

		        // If this is the first transaction, save the Entry Date
		        if (isFirstTransaction) {
		            firstEntryDate = entryDate;  // Store the Entry Date of the first transaction
		            isFirstTransaction = false;  // Mark that we've processed the first transaction
		        }

		        // Check if the Entry Date matches the first Entry Date
		        if (entryDate.equals(firstEntryDate)) {
		            // Check if the value in Column 9 (MakerID) is "akash"
		            if ("akash".equals(makerId)) {
		                // Print or process the required data
		                System.out.println("Cust_ID: " + custId);

		                // Update MakerID to 'aish' for the respective EntryID
		                String updateQuery = "UPDATE TransactionLog SET MakerID = 'aish' WHERE EntryID = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
		                    // Set the EntryID parameter
		                    preparedStatement.setInt(1, entryID);

		                    // Execute the update query
		                    int rowsUpdated = preparedStatement.executeUpdate();
		                    if (rowsUpdated > 0) {
		                        System.out.println("Successfully updated MakerID for EntryID " + entryID);
		                    }
		                } catch (SQLException e) {
		                    System.out.println("Error updating MakerID for EntryID " + entryID);
		                    e.printStackTrace();
		                }
		            }
		        } else {
		            // Exit the loop if the Entry Date changes
		            System.out.println("Entry Date changed. Stopping the loop.");
		            break;
		        }
		    }
		} catch (SQLException e) {
		    System.out.println("Error executing the query or processing results.");
		    e.printStackTrace();
		}
		

		

	}
	
	public void authorize() throws InterruptedException {
	    System.out.println("Authorization Started");
        // Authorize the transactions
        click(custSearch.authorizeAndCancelBtn);
        ScrollUntilElementVisible(custSearch.managerAuthorisation);
        click(custSearch.managerAuthorisation);
         // Optional: Replace with WebDriverWait if necessary

        click(custSearch.mangrAuthorOthersBtn);
        click(custSearch.mangrAuthorRefreshBtn);
	    while (true) {
	        try {
	        	if(ElementDisplayed(custSearch.selectToAuthorize)) {
	        		 System.out.println("Entries available for authorization");
		            click(custSearch.selectToAuthorize);
		            click(custSearch.mangrAuthorAuthorizeBtn);
	        	}
	        } catch (Exception e) {
	        	click(custSearch.mangrAuthorCloseBtn);
	        	System.out.println("No entries to authorize. Stopping the authorization process.");
	            break;
	        }
	    }
	    
	}

	public void activateDeactiveCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException {
		

					String generatedCustId = generateCustId();
		             
		             //Activate de-active member
		        	ExtentTestManager.startTest("Activate Deactive Customer");
//		        	customerSearchWindow();
		        	Log.info("Activate Deactive Customer");
		        	input(custSearch.custId, generatedCustId);
		       		 click(custSearch.custActiveOnly);
		       		 click(custSearch.custProspectsOnly);
		     		click(custSearch.custSearchBtn);
		    		
		    		click(custSearch.custSelect);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		    		Log.info("Step:01 - Select a customer from the list.");
		    		
		    		click(custSearch.activate);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Active' button");
		    		Log.info("Step:02 - Click 'Active' button");
		    		
		    		if(ElementDisplayed(custSearch.custActiveWndow)) {
		    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Active window opens showing customer details");
		    			Log.info("Expected Result: Customer Active window opens showing customer details");
		    		}
		    		ExtentTestManager.endTest();
		    		
		    		
		        	
		    		
		    		ExtentTestManager.startTest("Activate Customer with Current Date");
		        	Log.info("Activate Customer with Current Date");
		    		
		    		click(custSearch.deactiveCheckBox);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the Deactivate Checkbox");
		    		Log.info("Step:01 - Check the Deactivate Checkbox");
		    		
		    		click(custSearch.activateDateTxtBox);
		    		String futureDateToDeactivate = testdata.get("futureDateToDeactivate").toString();
		    		input(custSearch.activateDateTxtBox, futureDateToDeactivate);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a date from the calendar");
		    		Log.info("Step:02 - Select a date from the calendar");
		    		
		    		String remarkComment = testdata.get("remarkComment").toString();
		    		input(custSearch.freezeRemark, remarkComment);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Remarks in Remarks field.");
		    		Log.info("Step:03 - Enter Remarks in Remarks field.");
		    		
		    		click(custSearch.freezeSubmitBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit Button");
		    		Log.info("Step:04 - Click on Submit Button");
		    		
		    	
		    		if(ElementDisplayed(custSearch.deactiveOrActiveConfirmPopUp)) {
		    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is moved to the deactivate list");
		    			Log.info("Expected Result: Customer is moved into the active list");
		    		}
		    		click(custSearch.deactiveOrActiveConfirmPopUp);
		    		

		 click(custSearch.freezeCancelBtn);
			click(custSearch.custClearBtn);
			ExtentTestManager.endTest();
	}
	
	
	
	//Mark Customer as Expired
	public void markCustomerAsExpired(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		try {
			
		
			 String generatedCustId = generateCustId();
		             
			 click(custSearch.custSrch);
			 click(custSearch.custClearBtn);
			 
		             //Mark Customer as Expired

		        	input(custSearch.custId, generatedCustId);
		       		 //click(custSearch.custActiveOnly);
		       		 click(custSearch.custProspectsOnly);
		     		click(custSearch.custSearchBtn);
		    		
		    		click(custSearch.custSelect);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		    		Log.info("Step:01 - Select a customer from the list.");
		    		
		    		click(custSearch.custExpiredBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Expire' button");
		    		Log.info("Step:02 - Click 'Expire' button");
		    		
		    		String expireCustName = driver.findElement(custSearch.expireCustName).getAttribute("value");

		    		//get current transaction date
		    		click(custSearch.expiredAdditionalInfoCheckBox);
		    		String expireDate = driver.findElement(custSearch.expiredBalanceAson).getAttribute("value");
		    		click(custSearch.expiredAdditionalInfoCheckBox);
		    		
		    		click(custSearch.expireDate);
//		    		String expireDate = testdata.get("expireDate").toString();
		    		input(custSearch.expireDate, expireDate);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Date in Expire Date field.");
		    		Log.info("Step:03 - Enter Date in Expire Date field.");
		    		
		    		String remarkComment = testdata.get("remarkComment").toString();
		    		input(custSearch.expireRemark, remarkComment);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Remarks in Remarks field.");
		    		Log.info("Step:04 - Enter Remarks in Remarks field.");
		    		
//		    		select("KERALA",custSearch.bankDetailsStateDropDown);
		    		click(custSearch.bankDetailsStateDropDown);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on State drop down.");
		    		Log.info("Step:05 - Click on State drop down.");
		    		
		    		click(custSearch.selectState);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Select a State from the drop down.");
		    		Log.info("Step:06 - Select a State from the drop down.");
		    		
		    		select("KERALA GRAMIN BANK",custSearch.bankDetailsBankIdDropDown);
//		    		click(custSearch.bankDetailsBankIdDropDown);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Click on Bank ID drop down.");
		    		Log.info("Step:07 - Click on Bank ID drop down.");
//		    		click(custSearch.selectBankId);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Select a Bank ID from the drop down.");
		    		Log.info("Step:08 - Select a Bank ID from the drop down.");
		    		
		    		
		    		select("ALUR",custSearch.bankDetailsBranchIdDropDown);
//		    		click(custSearch.bankDetailsBranchIdDropDown);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on Branch ID drop down.");
		    		Log.info("Step:09 - Click on Branch ID drop down.");
//		    		click(custSearch.selectBranchId);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Select a Branch ID from the drop down.");
		    		Log.info("Step:10 - Select a Branch ID from the drop down.");
		    		
		    		input(custSearch.bankDetailsCustName, expireCustName);
					ExtentTestManager.getTest().log(Status.PASS, "Step:11 - Enter Customer Name in Cust Name field.");
					Log.info("Step:11 - Enter Customer Name in Cust Name field.");
					
					String bankDetailsAddress = testdata.get("bankDetailsAddress").toString();
					input(custSearch.bankDetailsAddressTxtBox, bankDetailsAddress);
					ExtentTestManager.getTest().log(Status.PASS, "Step:12 - Enter ADDRESS in Address field.");
					Log.info("Step:12 - Enter ADDRESS in Address field.");
					
					String bankDetailsAccNum = testdata.get("bankDetailsAccNum").toString();
					input(custSearch.bankDetailsAccNumTxtBox, bankDetailsAccNum);
					ExtentTestManager.getTest().log(Status.PASS, "Step:13 - Enter Bank Account number in BankAccNo field.");
					Log.info("Step:13 - Enter Bank Account number in BankAccNo field.");
					
					input(custSearch.bankDetailsReTypeAccNumTxtBox, bankDetailsAccNum);
					ExtentTestManager.getTest().log(Status.PASS, "Step:14 - Enter same Bank Account number in Retype AccNo field.");
					Log.info("Step:14 - Enter same Account number in Retype AccNo field as BankAccNo field.");
					
					input(custSearch.bankDetailsStartDate, expireDate);
					ExtentTestManager.getTest().log(Status.PASS, "Step:15 - Enter Date in Start Date field.");
					Log.info("Step:15 - Enter Date in Start Date field.");
					
					click(custSearch.bankDetailsAddBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:16 - Click on ADD button.");
					Log.info("Step:16 - Click on ADD button.");
		    		
					click(custSearch.expireSubmitBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:17 - Click on Submit button.");
					Log.info("Step:17 - Click on Submit button.");		    		
		    		
		    		AcceptAlert();
					ExtentTestManager.getTest().log(Status.PASS, "Step:18 - Click on OK button.");
					Log.info("Step:18 - Click on OK button.");	
		    		
		    		
		    		if(ElementDisplayed(custSearch.savedPopUp)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is marked as expired, confirmation message is displayed.");
					Log.info("Expected Result: Customer is marked as expired, confirmation message is displayed.");
					
					click(custSearch.savedPopUp);
					click(custSearch.expireCloseBtn);
					click(custSearch.custClearBtn);
					
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				
	    		

		}catch(Exception e) {
			deleteDuplicates();
			markCustomerAsExpired(testdata, context);
		}
		ExtentTestManager.endTest();
	}
	
	//Enter Remark and Submit
	public void enterRemarkAndSubmit(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

			 		String generatedCustId = generateCustId();
		             
		             
		             //Enter Remark and Submit
		        	ExtentTestManager.startTest("Enter Remark and Submit");
//		        	customerSearchWindow();
		        	Log.info("Enter Remark and Submit");
		        	input(custSearch.custId, generatedCustId);
		       		 //click(custSearch.custActiveOnly);
		       		 click(custSearch.custProspectsOnly);
		     		click(custSearch.custSearchBtn);
		    		
		    		click(custSearch.custSelect);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		    		Log.info("Step:01 - Select a customer from the list.");
		    		
		    		click(custSearch.custMarkBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Mark' button");
		    		Log.info("Step:02 - Click 'Mark' button");
		    		
		    		
		    		select("BANKRUPT",custSearch.markStatusDropDown);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select valid status from dropdown.");
		    		Log.info("Step:03 - Select valid status from dropdown.");
		    		
		    		String remarkComment = testdata.get("remarkComment").toString();
		    		input(custSearch.markRemarkTxtBox, remarkComment);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Remarks in Remarks field.");
		    		Log.info("Step:04 - Enter Remarks in Remarks field.");
		    		
		    		click(custSearch.markSubmitBtn);
		    		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click 'Submit' button.");
		    		Log.info("Step:05 - Click 'Submit' button.");

		    		
		    		
		    		if(ElementDisplayed(custSearch.savedPopUp)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is marked with selected status, success message displayed.");
					Log.info("Expected Result: Customer is marked with selected status, success message displayed.");
				}
				click(custSearch.savedPopUp);
				click(custSearch.markCloseBtn);
				click(custSearch.custClearBtn);
		    		ExtentTestManager.endTest();
            
	}
	
	
	public void deleteUnauthorisedCust (Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException{
		ExtentTestManager.startTest("Delete Customer - Unauthorized Customer");
		Log.info("Delete Customer - Unauthorized Customer");
		
		String generatedCustId = generateCustId();
		
	        //Edit Customer Last Name - Valid Edit
			 input(custSearch.custId, generatedCustId);
			 click(custSearch.custProspectsOnly);
			click(custSearch.custSearchBtn);
			
			click(custSearch.custSelect);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
			Log.info("Step:01 - Select a customer from the list.");
			
			click(custSearch.custDeleteBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click Edit button.");
			Log.info("Step:02 -  Click Edit button.");
			
			
			Base_Class.AcceptAlert();
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Accept the Alert");
			Log.info("Step:03 - Accept the Alert");
			
			if(ElementDisplayed(custSearch.deleteConfirmationOkBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is deleted successfully.");
				Log.info("Expected Result: Customer is deleted successfully.");
			}
	

	click(custSearch.deleteConfirmationOkBtn);
	click(custSearch.custClearBtn);
	ExtentTestManager.endTest();
	}
	
	
	
	
	public boolean logout() throws InterruptedException {
		ExtentTestManager.startTest("Logout");
		Log.info("Logout");
		
		Thread.sleep(4000);
		PageRefresh();
		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
		Log.info("Step:01 -  Click on 'Signout'");
		if(ElementDisplayed(custSearch.loginButton)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
			Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		}
		driver.close();
		ExtentTestManager.endTest();
		return true;
	}
	
}

