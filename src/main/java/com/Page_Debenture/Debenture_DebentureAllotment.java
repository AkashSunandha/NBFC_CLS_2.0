package com.Page_Debenture;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Cust_QuickCustomer;
import com.Page_Repositary.PageRepositary_Debenture_DebentureAllotment;
import com.Page_Repositary.PageRepositary_GroupLoans_CentreGroupRegistration;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Debenture_DebentureAllotment extends Base_Class{
	private static By formName;
	private static By formBranchName;
	private static By formComputerName;
	private static By formSubmitBtn;
	private static By loginUserName;
	private static By loginPasswrd;
	private static By loginButton;
	private static By invalidPaswrdErrMsg;
	private static By home;
	private static By loginWarningOkBtn;
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("Debenture_DebentureAllotment");
	Base_Class Base_Class= new Base_Class();
	Log log= new Log();
	
	PageRepositary_Debenture_DebentureAllotment DebtAllot = new PageRepositary_Debenture_DebentureAllotment();
	
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	public Object debentureMthds;	
	
//	private static long lastGeneratedNumber = 100000000000L;
	
	//Debenture_DebentureAllotment debtallotMthds  = new Debenture_DebentureAllotment ();
	
	//PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	
	//com.Page_Debenture.Debenture_DebentureAllotment debtallotMthds1 = new com.Page_Debenture .Debenture_DebentureAllotment();

	
	/*public String spPAN = "EXEC GenerateNextPAN"; 
	public String clmnNamPAN = "generated_pan";
	
	public String spAadhaar = "EXEC GenerateNextAadharNumber";
	public String clmnNamAadhaar = "generated_aadhar_number";
	
	public String spMobileNum = "EXEC GenerateNextMobileNumber";
	public String clmnNamMobileNum = "generated_mobile_number";*/
	
	
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

	public static boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("PC Registration");
		Log.info("PC Registration");
		
		String pcRegFormName = testdata.get("pcRegFormName").toString();
		input(Debenture_DebentureAllotment.formName, pcRegFormName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
		Log.info("Step:01 - Enter User Name in Name field.");
		
		select("TRIVANDRUM",Debenture_DebentureAllotment.formBranchName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
		Log.info("Step:02 - Select a Branch Name from the Dropdown.");
		
		String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
		input(Debenture_DebentureAllotment.formComputerName, pcRegFormPcName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
		Log.info("Step:03 - Enter PC Name in Name field.");
		
		click(Debenture_DebentureAllotment.formSubmitBtn);
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
		input(Debenture_DebentureAllotment.loginUserName, loginInValidUsername);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
		Log.info("Step:01 - Enetered Valid User Name");
		
		String loginInValidPassword = testdata.get("loginInValidPassword").toString();
		input(Debenture_DebentureAllotment.loginPasswrd, loginInValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
		Log.info("Step:02 - Enetered Invalid Password");
		
		click(Debenture_DebentureAllotment.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		
		if(ElementDisplayed(Debenture_DebentureAllotment.invalidPaswrdErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed for invalid credentials.");
			Log.info("Expect Result: Error message displayed for invalid credentials.");
		}
		clear(Debenture_DebentureAllotment.loginUserName);
		ExtentTestManager.endTest();
		
		
		
		ExtentTestManager.startTest("Invalid Login - Incorrect Password");
		Log.info("Invalid Login - Incorrect Password");
		
		String loginUserName = testdata.get("loginUserName").toString();
		input(Debenture_DebentureAllotment.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
		Log.info("Step:01 - Enetered Valid User Name");
		
		input(Debenture_DebentureAllotment.loginPasswrd, loginInValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
		Log.info("Step:02 - Enetered Invalid Password");
		
		click(Debenture_DebentureAllotment.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		
		if(ElementDisplayed(Debenture_DebentureAllotment.invalidPaswrdErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed indicating incorrect password.");
			Log.info("Expect Result: Error message displayed indicating incorrect password.");
		}
		clear(Debenture_DebentureAllotment.loginUserName);
		ExtentTestManager.endTest();
		
		return true;
	}
	
	public static void userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Valid Login");
		Log.info("Valid Login");
			
			
					String UserName = configloader().getProperty("UserName");
					input(Debenture_DebentureAllotment.loginUserName,UserName );
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
					Log.info("Step:01 - Enetered valid User Name");
					
					String Password = configloader().getProperty("Password");
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
					input(Debenture_DebentureAllotment.loginPasswrd, Password);
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
					Log.info("Step:02 - Enetered valid Password");
					
					click(Debenture_DebentureAllotment.loginButton);
					ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
					Log.info("Step:03 - Click on Login Button");
					
					try {
					ElementDisplayed(Debenture_DebentureAllotment.home);
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
					Log.info("Expected Result: User is logged in successfully and dashboard visible");
					}
					catch(Exception e) {
						ElementDisplayed(Debenture_DebentureAllotment.loginWarningOkBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
						Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

						click(Debenture_DebentureAllotment.loginWarningOkBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
						Log.info("Step:01 - Click on OK button");
						
	//					String loginUserName = testdata.get("loginUserName").toString();
						input(Debenture_DebentureAllotment.loginUserName, UserName);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
						Log.info("Step:02 - Enetered valid User Name");
						
	//					String loginValidPassword = testdata.get("loginValidPassword").toString();
						input(Debenture_DebentureAllotment.loginPasswrd, Password);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
						Log.info("Step:03 - Entered valid Password");
						
						click(Debenture_DebentureAllotment.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
						Log.info("Step:04 - Click on Login Button");
						
									ElementDisplayed(Debenture_DebentureAllotment.home);
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
									Log.info("Expected Result: User is logged in successfully and dashboard visible");	
					}}


	
				




public void navigateToDebenture() throws InterruptedException {
	
	ExtentTestManager.startTest("navigateToDebenture");
	Log.info("navigateToDebenture");
	
	click(DebtAllot.debenturetab);
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Debenture module in the left menu bar.");
	Log.info("Step:01 - Expand the Debenture module in the left menu bar.");
	
	click(DebtAllot.debentureallotmenttab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Debenture Allotment.");
	Log.info("Step:02 - Click on Debenture Allotment.");
	
	
	if(ElementDisplayed(DebtAllot.DebentureWindowTitle)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Allotment Title is displayed.");
		Log.info("Expected Result: Debenture Allotment title is displayed.");
	}
	
	ExtentTestManager.endTest();
	
}
	
	

public void branchdropdown () throws InterruptedException {
	// TODO Auto-generated method stub
	
	
	

		//Select Branch from Drop down
		
			ExtentTestManager.startTest("Select Branch from Drop down");
			Log.info("Select Branch from Drop down");
			
			select("TRIVANDRUM",DebtAllot.grBranchDropdown);
			
			ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
					+ "2. Select 'Trivandrum'.\"");
			Log.info("\"1. Click on branch dropdown.\r\n"
					+ "2. Select 'Trivandrum'.\"");
			
		
	}

/*public void debenturetypedropdown() throws InterruptedException {
	// TODO Auto-generated method stub

	ExtentTestManager.startTest("Select debenturetype from Drop down");
	Log.info("Select debenturetype from Drop down");
	
	select("Debenture-TYPE1",DebtAllot.debenturetypeDropdown);
	
	
	
}*/

public void debenturetypedropdown()throws InterruptedException {{
	// TODO Auto-generated method stub
	
	ExtentTestManager.startTest("Select debenturetype from Drop down");
	Log.info("Select debenturetype from Drop down");
	
	click(DebtAllot.debtdropdown);
	
	click(DebtAllot.debenturetypeDropdown);
	
	
	ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on debenturetypedropdown.\r\n"
			+ "2. Select 'Debenture-TYPE1'.\"");
	
	Log.info("\"1. Click on debenturetypedropdown.\r\n"
			+ "2. Select 'Debenture-TYPE1'.\"");
	
	
	

	
}

}}
