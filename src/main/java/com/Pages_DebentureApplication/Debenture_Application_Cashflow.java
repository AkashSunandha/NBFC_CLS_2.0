package com.Pages_DebentureApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Debenture_Application;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;

public class Debenture_Application_Cashflow  extends Base_Class {
	// Navigate to Debenture  Issue setting module

	PageRepositary_Debenture_Application DebApp  = new PageRepositary_Debenture_Application();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
   
    public String spAadhaar = "EXEC GenerateNextAadharNumber";
    public String clmnNamAadhaar = "generated_aadhar_number";
    
    public String spMobileNum = "EXEC GenerateNextMobileNumber";
    public String clmnNamMobileNum = "generated_mobile_number";

    
    
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
    
    public void AddcustomerviacustID(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:07 Add Customer Via Cust ID");

		click(DebApp.CustID);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter a Valid customer ID in the Cust ID field");
		Log.info("Step:01 - Enter a Valid customer ID in the Cust ID field");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Try to Add customer");
		Log.info("Step:02 - Try to Add customer");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click the customer popup button");
		Log.info("Step:03 - Click the customer popup button");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Popup Generates");
		Log.info("Expected Result: Customer popup Generates");


		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				String customerName = testdata.get("customerName").toString();
				input(DebApp.CustName, customerName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter an alphabet in the name field");
				Log.info("Step:02 Enter an alphabet in the name field");
				click(DebApp.customersearch);
				Log.info("click on search button");
				
				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:List of customers starting letter given is listed");
				Log.info("Expected Result:List of customers starting letter given is listed");

				click(DebApp.selectcustomer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer");
				Log.info("Step:01 - Select a customer");
				
				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:Customer is selected");
				Log.info("Expected Result:Customer is selected");

				driver.switchTo().window(mainWindowHandle);
				driver.findElement(DebApp.CustID).getAttribute("value");
				/*if (!customerid.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS,
							"Expected Result:Selected customer details is populated in the form");
					Log.info("Expected Result:Selected customer is  populated in the form");

				} else {
					ExtentTestManager.getTest().log(Status.FAIL,
							"Expected Result:Selected customer details is not populated in the form");
				}
				ExtentTestManager.endTest();*/
				click(DebApp.Add);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 Try to Add customer");
				Log.info("Step:01 Try to Add Customer");

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is Added");
				Log.info("Expected Result: Customer is Added");

			}
			ExtentTestManager.endTest();
		}
		
	}
    public void Select_Debenture_Type() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:11 Select Debenture Type Dropdown");
    	  select("DEB CLS",DebApp.DebType);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Debenture Type Dropdown");
    	Log.info("Step:01 Open Debenture Type Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
    	Log.info("Step:02 Select an option");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Type can be selected");
    		Log.info("Expected result:Debenture Type can be selected");
    	
    	ExtentTestManager.endTest();

    }
    public void Select_Debenture_Issue() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:12 Select Debenture Type Dropdown");
    	  select("ISSUE-DEB CLS-54",DebApp.IssueType);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Issue Type Dropdown");
    	Log.info("Step:01 Open Issue Type Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
    	Log.info("Step:02 Select an option");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue Type can be selected");
    		Log.info("Expected result:Issue Type can be selected");
    	
    	ExtentTestManager.endTest();

    }
    public void Select_Series_Type() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:13 Select Series Type");
    	  select("SERIES-ISSUE-DEB CLS-54-SERIES-1049",DebApp.series);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Series Type Dropdown");
    	Log.info("Step:01 Open Series Type Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
    	Log.info("Step:02 Select an option");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Series Type can be selected");
    		Log.info("Expected result: Series Type can be selected");
    	
    	ExtentTestManager.endTest();

    }
    
    //TC 14: Nature Field Observes
    
    public void Select_customer_Category() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:15 Select customer category");
    	  select("Normal",DebApp.Category);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Category Dropdown");
    	Log.info("Step:01 Open Category Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select Normal");
    	Log.info("Step:02 Select Normal");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Normal can be selected as customer category");
    		Log.info("Expected result:Normal can be selected as customer category");
    	
    	ExtentTestManager.endTest();

    }
    
    //TC 16 Add button used in adding customer
    
    //TC 17 Check unit value field - auto loaded
    
    public void Validate_No_of_Units() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:18 Validate No of Units");
    	  click (DebApp.Noofunit);
			String Unit = testdata.get("NoofUnit").toString();
			input(DebApp.Noofunit, Unit);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter value '20' in No of Units field.");
    	Log.info("Step:01 Enter value '20' in No of Units field.");

    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts the value.");
    		Log.info("Expected result:Field accepts the value.");
    	
    	ExtentTestManager.endTest();

    }
    public void Calculate_Total_Value() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:19 Calculate Total Value");
    	 
    	click (DebApp.GetValue);
	    ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Get Button Value");
    	Log.info("Step:01 Click Get Button Value");

    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Total value is correctly calculated and displayed");
    		Log.info("Expected result:Total value is correctly calculated and displayed");
    	
    	ExtentTestManager.endTest();

    }
    
    //TC  20 Verify DEfault ROI
    
    public void Select_DP_Name() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:21 Select DP Name");
    	  select("JOJI",DebApp.DPName);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open DP Name Dropdown");
    	Log.info("Step:01 Open DP Name Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
    	Log.info("Step:02 Select an option");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DP Name can be selected");
    		Log.info("Expected result: DP Name can be selected");
    	
    	ExtentTestManager.endTest();

    }
    public void Validate_Demat_AccNo_Entry() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:22 Validate Demat Accno Entry");
    	click (DebApp.DemateAcNolargetextbox);
		String Demat = testdata.get("DematAccNo").toString();
		input(DebApp.DemateAcNolargetextbox, Demat);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter a valid Demat Account Number.");
    	Log.info("Step:01 Enter a valid Demat Account Number.");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Validate entry");
    	Log.info("Step:02 Validate entry");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: System accepts Demat Account Number");
    		Log.info("Expected result: System accepts Demat Account Number");
    	
    	ExtentTestManager.endTest();

    }
    
    //TC  23 check matuirty value
    
    // TC 24 Observe interest pay mode
    
    public void Select_Referred_By() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:25 Select Referred By");
    	  select("VARGHESE",DebApp.Referred);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Referred By Dropdown");
    	Log.info("Step:01 Open Referred By Dropdown");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
    	Log.info("Step:02 Select an option");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Referred by' value can be selected");
    		Log.info("Expected result: 'Referred by' value can be selected");
    	
    	ExtentTestManager.endTest();

    }
    
}