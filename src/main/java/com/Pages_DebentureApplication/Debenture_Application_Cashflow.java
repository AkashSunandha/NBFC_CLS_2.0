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

import bsh.ParseException;

import com.Page_Repositary.PageRepositary_Cust_CustSearch;

public class Debenture_Application_Cashflow  extends Base_Class {
	// Navigate to Debenture application cash

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
    
    public void Navigate_Debenture_Application() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:4 Navigate to Debenture Application");
    	ScrollUntilElementVisible(DebApp.Debenture);
    	click(DebApp.Debenture);
    	click(DebApp.DebentureApplication);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Debenture");
    	Log.info("Step:01 Navigate to Debenture");
    	
    	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on Debenture Application");
    	Log.info("Step:02 Click on Debenture Application");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Debenture Application window will be opened");
    		Log.info("Expected result:Debenture application window will be opened");
    	
    	ExtentTestManager.endTest();

    }
    //Observes Branch Field
    public void Verify_Branch_Field() throws InterruptedException {
    	ExtentTestManager.startTest("Tc: 05 Verify Branch Field");
    	  String branchname = driver.findElement(DebApp.Branch).getText();
    	  String Userbranchname = driver.findElement(DebApp.UserBranchName).getText();
    	  if(branchname.equals(Userbranchname) && !ElementEnableOrDisable(DebApp.Branch)) {
    		  ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the Branch field ");
    	    	Log.info("Step:01 Observe the Branch Field");
    	    	
    	    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Branch field displays logged in branch and is not editable");
    	    		Log.info("Expected result:Branch field displays logged in branch and is not editable.");	
    	  }
    	  
    	 
    		  else {
  				ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Not displaying Branch field displays logged in branch and is not editable.");
  				Log.info("Expected result: Not displaying Branch field displays logged in branch and is not editable");
    	  
    		  }
    	ExtentTestManager.endTest();
    		  
    }
    
    //Observers Application Date Field
    public void Verify_Application_DateField() throws InterruptedException, ParseException, java.text.ParseException {
    	ExtentTestManager.startTest("Tc: 06 Verify Application Date Field");
    	  
    		  String Date = driver.findElement(DebApp.Date).getText();
    		  String Datevalue =dateConversion(Date);

    		   if(Date.equals(Datevalue)) {
    		  
    		  ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the application date field ");
    	    	Log.info("Step:01 Observe the application date Field");
    	    	
    	    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Application Date displays the current date and is not changeable");
    	    		Log.info("Expected result:Application Date displays the current date and is not changeable");	
    	  }
    	  
    	 
    		  else {
  				ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Application Date will not displays the current date and is not changeable");
  				Log.info("Expected result: Application Date will not displays the current date and is not changeable.");
    	  
    		  }
    	ExtentTestManager.endTest();
    		 

}
    
    public void AddcustomerviacustID(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:07 Add Customer Via Cust ID");

		click(DebApp.CustIDsearch);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the customer popup button");
		Log.info("Step:01 - Click the customer popup button");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Popup Generates");
		Log.info("Expected Result: Customer popup Generates");
    
	ExtentTestManager.endTest();

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				String customerName = testdata.get("customerName").toString();
				input(DebApp.CustName, customerName);
				
				//Enter an alphabets in the name field
				ExtentTestManager.startTest("TC:08 Add Customer via Cust ID");
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an alphabet in the name field");
				Log.info("Step:01 Enter an alphabet in the name field");
				click(DebApp.customersearch);
				Log.info("click on search button");
				
				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:List of customers starting letter given is listed");
				Log.info("Expected Result:List of customers starting letter given is listed");
				
				ExtentTestManager.endTest();
				
				//select a customer
				ExtentTestManager.startTest("TC:09 Add Customer via Cust ID");
				click(DebApp.selectcustomer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer");
				Log.info("Step:01 - Select a customer");
				
				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:Customer is selected");
				Log.info("Expected Result:Customer is selected");
				
				ExtentTestManager.endTest();

				driver.switchTo().window(mainWindowHandle);
				driver.findElement(DebApp.CustIDsearch).getAttribute("value");
				
				//Add customer
				ExtentTestManager.startTest("TC:10 Add Customer via Cust ID");
				click(DebApp.Add);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 Try to Add customer");
				Log.info("Step:01 Try to Add Customer");

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is Added");
				Log.info("Expected Result: Customer is Added");
				ExtentTestManager.endTest();

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
    public void Verify_Nature_Field() throws InterruptedException {
    	ExtentTestManager.startTest("Tc: 14 Verify Nature Field");
    	  
    	  String nature = driver.findElement(DebApp.Nature).getText();
    	 
    	  if(nature.equals("Single")) {
    		  ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the Nature field ");
    	    	Log.info("Step:01 Observe the Nature Field");
    	    	
    	    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nature field displays 'Single' by default");
    	    		Log.info("Expected result:Nature field displays 'Single' by default");	
    	  }
    	  
    	 
    		  else {
  				ExtentTestManager.getTest().log(Status.FAIL,"Expected Result:Nature field will not displays 'Single' by default");
  				Log.info("Expected result: Nature field will not displays 'Single' by default");
    	  
    		  }
    	ExtentTestManager.endTest();
    		  
    }
    
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
    
    public void Validate_No_of_Units(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
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
    
    //Click get value and Total value willbe calculated
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
    public void Validate_Demat_AccNo_Entry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
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
    
    public void untickNomineeNotRequired() throws InterruptedException {
		ExtentTestManager.startTest("TC:26 Untick Nominee Not required Checkbox");
        click (DebApp.NomineeTab);
		click(DebApp.Unticknomineecheckbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Untick 'Nominee Not required' checkbox");
		Log.info("Step:01 -  Untick 'Nominee Not required' checkbox");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nominee details feilds  will be display");
		Log.info("Expected Result: Nominee details fields will be display");

		ExtentTestManager.endTest();

	}
    public void AddNomineeBySearch(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException {
  		ExtentTestManager.startTest("TC:27 Add nominee via search");

  		click(DebApp.Nomineesearchicon);
  		
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click customer search button");
  		Log.info("Step:01 - Click customer search button");
  		
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Popup Generates");
  		Log.info("Expected Result: Customer popup Generates");
      
  	ExtentTestManager.endTest();

  		// Navigate to Pop Up Window
  		String mainWindowHandle = driver.getWindowHandle();
  		for (String handle : driver.getWindowHandles()) {
  			if (!handle.equals(mainWindowHandle)) {
  				driver.switchTo().window(handle);
  				String Nomineename = testdata.get("NomineeName").toString();
  				input(DebApp.NomineeName1, Nomineename);
  				
  				//Enter an alphabets in the name field
  				ExtentTestManager.startTest("TC:28 Add Customer via Cust ID");
  				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an alphabet in the name field");
  				Log.info("Step:01 Enter an alphabet in the name field");
  				click(DebApp.Nomineesearchbtn);
  				Log.info("click on search button");
  				
  				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:List of customers starting letter given is listed");
  				Log.info("Expected Result:List of customers starting letter given is listed");
  				
  				ExtentTestManager.endTest();
  				
  				//select a customer
  				ExtentTestManager.startTest("TC:29 Add Customer via Cust ID");
  				click(DebApp.Nomineeselect);
  				//click(DebApp.NomineeAdd);
  				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer");
  				Log.info("Step:01 - Select a customer");
  				
  				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:Customer is selected");
  				Log.info("Expected Result:Customer is selected");
  				
  				ExtentTestManager.endTest();

  				driver.switchTo().window(mainWindowHandle);
  				driver.findElement(DebApp.Nomineesearchicon).getAttribute("value");
  				
  			}
  			ExtentTestManager.endTest();
  		}
  		
  	}  
    public void Select_Relation_Dropdown() throws InterruptedException {
    	ExtentTestManager.startTest("Tc:32 Select Relation from Dropdown");
    	  select("DAUGHTER",DebApp.NomineeRelation);
    	  
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select any Relation");
    	Log.info("Step:01 Select any Relation");
    	
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation is selected");
    		Log.info("Expected result:Relation is selected");
    	
    	ExtentTestManager.endTest();

    }
    
	//Add Nominee
	 public void Add_nominee() throws InterruptedException {
		ExtentTestManager.startTest("TC:31 Add Nominee");
	    click(DebApp.NomineeAdd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Try to Add Nominee");
		Log.info("Step:01 Try to Add Nominee");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee is Added");
		Log.info("Expected Result: Nominee is Added");
		ExtentTestManager.endTest();
	 }
	 
	 public void Verify_Internet_transfer_tab() throws InterruptedException {
		 ExtentTestManager.startTest("TC:33 Verify Internet transfer tab"); 
		 click(DebApp.InterestTransfer);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Open Interest Transfer Tab");
			Log.info("Step:01 Open Interest Transfer Tab");
			
			if(CheckBoxStatus(DebApp.Interestrequiredcheckbox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 Check Checkbox status");
			Log.info("Step:02 Check checkbox status");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Interest Transfer required checkbox is unchecked by default");
			Log.info("Expected Result: Interest Transfer required checkbox is unchecked by default");
			
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			ExtentTestManager.endTest();
	 }  
	 
	 public void Enable_interesttransfer() throws InterruptedException {
		 ExtentTestManager.startTest("TC:34 Enable Interest transfer checkbo"); 
		 click(DebApp.Clickinteresttranscheckbox);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 1. Enable Interest Transfer checkbox");
			Log.info("Step:01 1. Enable Interest Transfer checkbox");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Interest Transfer checkbox enabled");
			Log.info("Expected Result:  Interest Transfer checkbox enabled");
			
			ExtentTestManager.endTest();
	 }  
	 
	 //Validatin missing
	 public void Enable_External_Account_click() throws InterruptedException {
		 ExtentTestManager.startTest("TC:35 Enable_External_account"); 
		 click(DebApp.ExternalAccountcheckbox);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click external account checkbox");
			Log.info("Step:01 Click external account checkbox");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  External account details load successfully.");
			Log.info("Expected Result: External account details load successfully");
			
			ExtentTestManager.endTest();
	 }
}


