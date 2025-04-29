package com.Page_BondTransfer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_BondTransfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class BondTransfer_mainpage extends Base_Class
{
	String mainWindowHandle ;
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("BondTransfer");
	Base_Class Base_Class= new Base_Class();
	Log log= new Log();
	
	PageRepositary_BondTransfer bondtrRepo = new PageRepositary_BondTransfer();
//	private static long lastGeneratedNumber = 100000000000L;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	//PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	
	
	public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException 
	{
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
	             ResultSet resultSet = statement.executeQuery(query)) 
	        {
	        	
	        	if (resultSet.next()) 
	        	{
	        		value = resultSet.getString(columnName); // DB column name
	                System.out.println("Generated Unique ID: " + value);
	            } else 
	            {
	                System.out.println("Unique ID not generated.");
	            }

	        } catch (SQLException e) 
	        {
	            System.out.println("Error executing the SQL query or processing the result set.");
	            e.printStackTrace();
	        }

	        return value; // Return the firstCustId
	    }
	
	public void bondtransferWindow() throws InterruptedException 
	{
		
		ExtentTestManager.startTest("Navigate to Bond Transfer Page");
		Log.info("Navigate to Bond Transfer Page");
		
		ScrollUntilElementVisible(bondtrRepo.BondTab);
		click(bondtrRepo.BondTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Bond tab in the left menu bar.");
		Log.info("Step:01 - Expand the Bond tab in the left menu bar.");
		
		click(bondtrRepo.BondtransferTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Bond Transfer");
		Log.info("Step:02 - Click on Bond Transfer");
		
		
		if(ElementDisplayed(bondtrRepo.BondWindowTitle)) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Bond Transfer window is displayed.");
			Log.info("Expected Result: Bond Transfer is displayed.");
		}
		
		ExtentTestManager.endTest();
		
	}
	public void selectbranch() throws InterruptedException 
	{
		ExtentTestManager.startTest("Select a branch from Dropdown");
		Log.info("Select a branch from Dropdown");
		

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'branch' dropdown");
		Log.info("Step:01 - Click 'branch' dropdown");
		
		select("TRIVANDRUM",bondtrRepo.branchfield);
		
		/*String branchvalue = driver.findElement(bondtrRepo.branchfield).getAttribute("brvalue");
		
		if(!branchvalue.isBlank()) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch selected from dropdown.");
			Log.info("Expected Result: Branch selected from dropdown.");
		}
		else 
		{
			ExtentTestManager.getTest().log(Status.FAIL, "Branch not selected");
			Log.info("Branch not selected");
		}*/
		
		ExtentTestManager.endTest();
		
		
	}
	
	
	public void selectproduct() throws InterruptedException 
	{
		ExtentTestManager.startTest("Select a Product from Dropdown");
		Log.info("Select a Product from Dropdown");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Product' dropdown and select value");
		Log.info("Step:01 - Click 'Product' dropdown and select value");
		
		
		select("SUBORDINATE DEBT",bondtrRepo.productfieldvalue);
		
		String prodvalue = driver.findElement(bondtrRepo.productfieldvalue).getAttribute("value");
		if(!prodvalue.isBlank()) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected product from dropdown.");
			Log.info("Expected Result: Selected product from dropdown.");
		}
		else 
		{
			ExtentTestManager.getTest().log(Status.FAIL, "Product not selected");
			Log.info("Product not selected");
		}
		
		ExtentTestManager.endTest();
		
	}
	
	public boolean accno(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException 
	{
		ExtentTestManager.startTest("Enter Account Number");
		Log.info("Enter Account Number");
		
	String AccNumber = generateAccountNumber();
	String lastthreedigit=AccNumber.substring(AccNumber.length() - 3);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter last three digit of account number");
	Log.info("Step:01 - Enter last three digit of account number");
	
	input(bondtrRepo.bankDetailsAccNumTxtBox, lastthreedigit);
	
	String accvalue = driver.findElement(bondtrRepo.bankDetailsAccNumTxtBox).getAttribute("value");
	if(!accvalue.isBlank()) 
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entered last three digit of account number");
		Log.info("Expected Result: Entered last three digit of account number");
		
	}
	else 
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Account number not entered");
		Log.info("Account number not entered");
	}
	return true;
	}
	public static  String generateAccountNumber() throws ClassNotFoundException 
	{
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		String query = "EXEC GetSpBondAcNo '102','14006'";
		String AccountNum = null; 
		try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query)) 
		{
		        	
		if (resultSet.next()) 
		{
		    AccountNum = resultSet.getString("Acno");
		    System.out.println("Account Number of Loan Opening: " + AccountNum);
		} else 
		{
		    System.out.println("No Account Number found.");
		 }

		    } catch (SQLException e) 
		{
		    System.out.println("Error executing the SQL query or processing the result set.");
		    e.printStackTrace();
		  }
		    	return AccountNum;  
		    	
		    	
	}	
	
	
	
	
	public boolean searchcust() throws InterruptedException
	
	{
		//click on go button
    	
    	ExtentTestManager.startTest("Click on Go button");
    	Log.info("Click on Go button");
    	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Go button");
    	Log.info("Step:01 - Click on Go button");
    	
    	click(bondtrRepo.bondsubmit);
    	if(ElementDisplayed(bondtrRepo.accinfo)) 
    	{
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are loaded successfully");
    		Log.info("Expected Result: Account details are loaded successfully");
    	}
    	
	
	
		ExtentTestManager.startTest("Open Customer search Popup on Transfer to section");
		Log.info("Open Customer search Popup on Transfer to section");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click search button present near 'CustomerID' field");
		Log.info("Step 1: Click search button present near 'CustomerID' field");
		
		
		click(bondtrRepo.custsearch);
		
		
		//Navigate to customer search pop-up 
		
		
		mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) 
	    {
	        if (!handle.equals(mainWindowHandle)) 
	        {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	        }
		
	        
	    }
	    
		if(ElementDisplayed(bondtrRepo.custsearchwindow)) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search window is displayed.");
			Log.info("Expected Result: Customer search window is displayed.");
		}
		

		//return false;
		ExtentTestManager.endTest();
    	return true;
    	
		}
	
	
	public void searchcustdatas(Map<Object, Object> testdata, ITestContext context) throws InterruptedException
	{
	
	ExtentTestManager.startTest("Search for customer");
	Log.info("Search for customer");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter 'Name' in the field");
	Log.info("Step 1: Enter 'Name' in the field");
	
	
	//Passing customer name
	String custname = testdata.get("Custname").toString();
	input(bondtrRepo.custnameTxtBox, custname);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Customer number.");
	Log.info("Step:02 - Enter Customer number.");
	
	//Passing customer id
	String custnumber = testdata.get("Custid").toString();
	input(bondtrRepo.custnumTxtBox, custnumber);
	
	//clicking on search button
	ExtentTestManager.getTest().log(Status.PASS, "Step 3: Click on Search button");
	Log.info("Step 3: Click on Search button");
	
	click(bondtrRepo.searchbutton);
	
	if(ElementDisplayed(bondtrRepo.custdatagrid)) 
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer IDs list matching 'First Name' and 'Customer id' is displayed");
		Log.info("Expected Result: Customer IDs list matching 'First Name' and 'Customer id' is displayed");
	}
	//Select customer from customer searched list
	ExtentTestManager.startTest("Select Customer ID from List");
	Log.info("Select Customer ID from List");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1:Click on Select button against any Customer ID");
	Log.info("Step 1:Click on Select button against any Customer ID");
	
	click(bondtrRepo.selectcust);
	
		//Navigating to main window
	driver.switchTo().window(mainWindowHandle);
	
	String custid = driver.findElement(bondtrRepo.customeridfield).getAttribute("value");
	if(!custid.isBlank()) 
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is selected");
		Log.info("Expected Result: Customer is selected");
		
	}
	else 
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Customer is not selected");
		Log.info("Customer is not selected");
		
	}
	
	
	
	//Click on add button
	ExtentTestManager.startTest("Add customer");
	Log.info("Add customer");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on 'Add' button");
	Log.info("Step 1: Click on 'Add' button");
	click(bondtrRepo.addcust);
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer added successfully");
	Log.info("Expected Result: Customer added successfully");
	
	//Adding Remarks
	ExtentTestManager.startTest("Adding remarks");
	Log.info("Adding remarks");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Remarks");
	Log.info("Step:01 - Enter Remarks");
	String remarksdata = testdata.get("Remarks").toString();
	input(bondtrRepo.remarksTxtBox, remarksdata);
	
	String remarkvalue = driver.findElement(bondtrRepo.remarksTxtBox).getAttribute("value");
	if(!remarkvalue.isBlank()) 
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks have added");
		Log.info("Expected Result: Remarks have added");
		
	}
	else 
	{
		ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Remarks have not added");
		Log.info("Expected Result: Remarks have not added");
		
	}
	
	
	
	//Click Bond transfer submit
	ExtentTestManager.startTest("Bond Transfer submit");
	Log.info("Bond Transfer submit");
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: click on submit button");
	Log.info("Step 1: click on submit button");
	click(bondtrRepo.submit);
	if(ElementDisplayed(bondtrRepo.summarypage)) 
	{
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Bond transfer submitted successfully and summary page is loaded");
		Log.info("Expected Result: Bond transfer submitted successfully and summary page is loaded");
	}
	
	ExtentTestManager.endTest();
	}
	
	public void authorizeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException 
	{
		
	//Getting user id from summary page
	String userid_summary = driver.findElement(bondtrRepo.useridTxtBox).getAttribute("value");
	
	
	//Sign out
	ExtentTestManager.startTest("Signout from user");
	Log.info("Signout from user");
	click(bondtrRepo.signout);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on sign out button");
	Log.info("Step 1: Click on sign out button");
	ExtentTestManager.getTest().log(Status.PASS, "Expected result: Signed out successfully");
	Log.info("Expected result: Signed out successfully");
	
	//Authorisation		

		//Login with Another User
		ExtentTestManager.startTest("Manager login for Authorisation");
		Log.info("Manager login for Authorisation");
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Login to manager user");
		Log.info("Step 1: Login to manager user");
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		
		
		//Click authorisation and cancel tab
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Click on 'Authorisation and cancel' tab");
		Log.info("Step 2: Click on 'Authorisation and cancel' tab");
		click(bondtrRepo.authtab);
		
		//Click Manager authorisation tab
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Click on Manager Authorisation tab");
		Log.info("Step 3: Click on Manager Authorisation tab");
		click(bondtrRepo.managerauthtab);
		
		if(ElementDisplayed(bondtrRepo.managerauthpage)) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorisation and cancel window have loaded");
			Log.info("Expected Result: Manager authorisation and cancel window have loaded");
		} 
		
		//Click Others authorisation tab
		ExtentTestManager.startTest("Manager Authorization Refresh");
		Log.info("Manager Authorization Refresh");
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on 'Others' tab");
		Log.info("Step 1: Click on 'Others' tab");
		click(bondtrRepo.otherstab);
		
		//Click Refresh tab
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Click on 'Refresh' button");
		Log.info("Step 2: Click on 'Refresh' button");
		click(bondtrRepo.refreshtab);
		
		if(ElementDisplayed(bondtrRepo.authdatas)) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorization entries are updated and displayed");
			Log.info("Expected Result: Authorization entries are updated and displayed");
		} 
		
		//Authorize Transfer Entry
		ExtentTestManager.startTest("Authorize Transfer Entry");
		Log.info("Authorize Transfer Entry");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter Makerid field value");
		Log.info("Step 1: Enter Makerid field value");
		

		String makervalue = userid_summary.toString();
		input(bondtrRepo.makerid, makervalue);
		
		//click on go button
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Click on go button");
		Log.info("Step 2: Click on go button");
		click(bondtrRepo.authgobutton);
		
		//Select Entry for authorization
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Select Entry for authorization");
		Log.info("tep 3: Select Entry for authorization");
		click(bondtrRepo.selectauthentry);
		
		//Click on Authorise button
		ExtentTestManager.getTest().log(Status.PASS, "Step 4: Click on Authorise button");
		Log.info("Step 4: Click on Authorise button");
		click(bondtrRepo.authbutton);
		
		if(ElementDisplayed(bondtrRepo.authsuccessmsg)) 
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorization done successfully");
			Log.info("Expected Result: Authorization done successfully");
		} 
		
		click(bondtrRepo.successclosebutton);
		ExtentTestManager.endTest();
	}
	
	public void logout() throws InterruptedException 
	{
	//Sign out
		ExtentTestManager.startTest("Logout from user");
		Log.info("Logout from user");
		click(bondtrRepo.signout);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on sign out button");
		Log.info("Step 1: Click on sign out button");
		ExtentTestManager.getTest().log(Status.PASS, "Expected result: Signed out successfully");
		Log.info("Expected result: Signed out successfully");
		driver.quit();
	}
 }
