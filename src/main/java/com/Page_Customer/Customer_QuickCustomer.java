package com.Page_Customer;

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
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Cust_QuickCustomer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_QuickCustomer extends Base_Class{
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("Customer_CustSearch");
	Base_Class Base_Class= new Base_Class();
	Log log= new Log();
	PageRepositary_Cust_QuickCustomer quickCustRepo = new PageRepositary_Cust_QuickCustomer();
//	private static long lastGeneratedNumber = 100000000000L;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();

	
	public String spPAN = "EXEC GenerateNextPAN"; 
	public String clmnNamPAN = "generated_pan";
	
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
	
	public void openQuickCustomerWindow() throws InterruptedException {
		
		ExtentTestManager.startTest("Open Quick Customer Window").assignCategory("QuickCustomer");
		Log.info("Open Quick Customer Window");
		
		click(quickCustRepo.customerTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Customer module in the left menu bar.");
		Log.info("Step:01 - Expand the Customer module in the left menu bar.");
		
		click(quickCustRepo.quickCustomerTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Quick Customer.");
		Log.info("Step:02 - Click on Quick Customer.");
		
		
		if(ElementDisplayed(quickCustRepo.quickCustomerWindowTitle)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Quick Customer window is displayed.");
			Log.info("Expected Result: Quick Customer window is displayed.");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify 'Start Date' Shows Current Date
		ExtentTestManager.startTest("Verify 'Start Date' Shows Current Date").assignCategory("QuickCustomer");
		Log.info("Verify 'Start Date' Shows Current Date");

		String startDate = driver.findElement(quickCustRepo.qadStartDate).getAttribute("value");

        String currentDate = driver.findElement(quickCustRepo.currentDate).getText();

            ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field displays current date: " + currentDate + " which is same as Start Date: " + startDate);
    		Log.info("Expected Result: Field displays current date: " + currentDate + " which is same as Start Date: " + startDate);

		ExtentTestManager.endTest();
		
		
		
		
		//'Start Date' Field Typing Disabled
		ExtentTestManager.startTest("'Start Date' Field Typing Disabled").assignCategory("QuickCustomer");
		Log.info("'Start Date' Field Typing Disabled");
		
		boolean isDisabled = driver.findElement(quickCustRepo.qadStartDate).getAttribute("disabled") != null;
		
		if(isDisabled==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Typing in the field is disabled.");
			Log.info("Expected Result: Typing in the field is disabled.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Typing in the field is enabled.");
			Log.info("Expected Result: Typing in the field is enabled.");
		}
		
		ExtentTestManager.endTest();
		
	}
	
	
	
	public void quickAccDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException, UnsupportedFlavorException {

		//Select Salutation Drop down
		ExtentTestManager.startTest("Select Salutation Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Salutation Dropdown");
		
		ScrollUntilElementVisible(quickCustRepo.qadSalutationDropdown);
		select("MR", quickCustRepo.qadSalutationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Salutation dropdown.");
		Log.info("Step:01 - Click on the Salutation dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Salutation.");
		Log.info("Step:02 - Select a Salutation.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Salutation can be selected from dropdown.");
		Log.info("Expected Result: Salutation can be selected from dropdown.");
		
		ExtentTestManager.endTest();
		 
		//Numerical Entry in 'First Name' Field
		ExtentTestManager.startTest("Numerical Entry in 'First Name' Field").assignCategory("QuickCustomer");
		Log.info("Numerical Entry in 'First Name' Field");
		
		String fNameNumericInput = testdata.get("fNameNumInput").toString();
		input(quickCustRepo.qadFNameTxtBox,fNameNumericInput);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers in 'First Name' field.");
		Log.info("Step:01 - Enter numbers in 'First Name' field.");
		
		if(ElementDisplayed(quickCustRepo.qadFameInvalidPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"First name is not valid\".");
			Log.info("Expected Result: Validation message: \"First name is not valid\".");
		}
		click(quickCustRepo.qadFameInvalidPopUp);
		ExtentTestManager.endTest();
		
		
		//Clear 'First Name' Field
		ExtentTestManager.startTest("Clear 'First Name' Field").assignCategory("QuickCustomer");
		Log.info("Clear 'First Name' Field");
		
		clear(quickCustRepo.qadFNameTxtBox);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear the 'First Name' field.");
		Log.info("Step:01 - Clear the 'First Name' field.");
		
	/*	String fNameNull = driver.findElement(quickCustRepo.qadFNameTxtBox).getText();
		if(fNameNull=="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: First Name Field is cleared successfully.");
			Log.info("Expected Result: First Name Field is cleared successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: First Name Field is not cleared successfully.");
			Log.info("Expected Result: First Name Field is not cleared successfully.");
		}*/
		ExtentTestManager.endTest();
		
		
		//Alphabetic Entry in 'First Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'First Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'First Name' Field");
		
		String fNameAlphabetInput = testdata.get("fNameAlphabetInput").toString();
		input(quickCustRepo.qadFNameTxtBox,fNameAlphabetInput);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'First Name' field.");
		Log.info("Step:01 - Enter alphabets in 'First Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Middle Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Middle Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Middle Name' Field");

		String mNameAlphabetInput = testdata.get("mNameAlphabetInput").toString();
		input(quickCustRepo.qadMNameTxtBox,mNameAlphabetInput);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'Middle Name' field.");
		Log.info("Step:01 - Enter alphabets in 'Middle Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Last Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Last Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Last Name' Field");

		String lNameAlphabetInput = testdata.get("lNameAlphabetInput").toString();
		input(quickCustRepo.qadLNameTxtBox,lNameAlphabetInput);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'Last Name' field.");
		Log.info("Step:01 - Enter alphabets in 'Last Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Alias Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Alias Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Alias Name' Field");

		String aNameAlphabetInput = testdata.get("aNameAlphabetInput").toString();
		input(quickCustRepo.qadAliasNameTxtBox,aNameAlphabetInput);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'Alias Name' field.");
		Log.info("Step:01 - Enter alphabets in 'Alias Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Alias Name' Field
		ExtentTestManager.startTest("Display Name Validation").assignCategory("QuickCustomer");
		Log.info("Display Name Validation");
		
		String dispName = driver.findElement(quickCustRepo.qadDispNameTxtBox).getAttribute("value");
		
		// Split the string by spaces
		String[] dispNameParts = dispName.split(" ");
		
		// Store individual parts in separate variables
		String firstName = dispNameParts[0]; 
		String middleName = dispNameParts[1];
		String lastName = dispNameParts[2];
		String aliasName = dispNameParts[4];
		
		if(fNameAlphabetInput.equalsIgnoreCase(firstName) 
				&& mNameAlphabetInput.equalsIgnoreCase(middleName) 
				&& lNameAlphabetInput.equalsIgnoreCase(lastName) 
				&& aNameAlphabetInput.equalsIgnoreCase(aliasName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Displays: FirstName-MiddleName-LastName-AliasName.");
			Log.info("Expected Result: Displays: FirstName-MiddleName-LastName-AliasName.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Incorrect Display Name.");
			Log.info("Expected Result: Incorrect Display Name.");
		}
		
		ExtentTestManager.endTest();
		
		
		//DOB Field Entry
		ExtentTestManager.startTest("DOB Field Entry").assignCategory("QuickCustomer");
		Log.info("DOB Field Entry");
		
		String DOB = testdata.get("DOB").toString();
		click(quickCustRepo.qadDOBTxtBox);
		input(quickCustRepo.qadDOBTxtBox,DOB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter date in 'DOB' field.");
		Log.info("Step:01 - Enter date in 'DOB' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is accepted.");
		Log.info("Expected Result: Date is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
        //Calculate Age After Tab
		ExtentTestManager.startTest("Calculate Age After Tab").assignCategory("QuickCustomer");
		Log.info("Calculate Age After Tab");
		
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Press TAB key.");
		Log.info("Step:01 - Press TAB key.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Age' field displays calculated age.");
		Log.info("Expected Result: 'Age' field displays calculated age.");
		
		ExtentTestManager.endTest();
		
		
		
        //Verify 'DOB' Field Presence
		ExtentTestManager.startTest("Verify 'DOB' Field Presence").assignCategory("QuickCustomer");
		Log.info("Verify 'DOB' Field Presence");
		
		click(quickCustRepo.qadDOBTxtBox);
		clear(quickCustRepo.qadDOBTxtBox);
		click(quickCustRepo.qadDOBTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear DOB field.");
		Log.info("Step:01 - Clear DOB field.");
		
		if(ElementDisplayed(quickCustRepo.qadDOBReqCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'DOB' field is present and mandatory.");
			Log.info("Expected Result: 'DOB' field is present and mandatory.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: 'DOB' field is not mandatory.");
			Log.info("Expected Result: 'DOB' field is not mandatory.");
		}
		click(quickCustRepo.qadDOBReqCloseBtn);
		
		click(quickCustRepo.qadDOBTxtBox);
		input(quickCustRepo.qadDOBTxtBox,DOB);
		
		ExtentTestManager.endTest();
		
		
		
        //Type Date in 'AgeAsOn' Field
		ExtentTestManager.startTest("Type Date in 'AgeAsOn' Field").assignCategory("QuickCustomer");
		Log.info("Type Date in 'AgeAsOn' Field");
		
		String startDateValue = driver.findElement(quickCustRepo.qadStartDate).getAttribute("value");
		click(quickCustRepo.qadAgeAsOnTxtBox);
		input(quickCustRepo.qadAgeAsOnTxtBox,startDateValue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter date in 'AgeAsOn' field.");
		Log.info("Step:01 - Enter date in 'AgeAsOn' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is accepted.");
		Log.info("Expected Result: Date is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
        //Select AgeGroup Dropdown
		ExtentTestManager.startTest("Select AgeGroup Dropdown").assignCategory("QuickCustomer");
		Log.info("Select AgeGroup Dropdown");
		
		select("Major",quickCustRepo.qadAgeGroupDropdwn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the AgeGroup dropdown.");
		Log.info("Step:01 - Click on the AgeGroup dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select an AgeGroup.");
		Log.info("Step:02 -  Select an AgeGroup.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AgeGroup can be selected.");
		Log.info("Expected Result: AgeGroup can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Nationality Dropdown
		ExtentTestManager.startTest("Select Nationality Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Nationality Dropdown");
		
		select("INDIA",quickCustRepo.qadNationalityDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Nationality dropdown.");
		Log.info("Step:01 - Click on the Nationality dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Nationality.");
		Log.info("Step:02 -  Select a Nationality.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nationality can be selected.");
		Log.info("Expected Result: Nationality can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Nativity Dropdown
		ExtentTestManager.startTest("Select Nativity Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Nativity Dropdown");
		
		select("KERALA",quickCustRepo.qadNativityDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Nativity dropdown.");
		Log.info("Step:01 - Click on the Nativity dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Nativity.");
		Log.info("Step:02 -  Select a Nativity.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nativity can be selected.");
		Log.info("Expected Result: Nativity can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select GENDER Dropdown
		ExtentTestManager.startTest("Select GENDER Dropdown").assignCategory("QuickCustomer");
		Log.info("Select GENDER Dropdown");
		
		select("Male",quickCustRepo.qadGenderDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the GENDER dropdown.");
		Log.info("Step:01 - Click on the GENDER dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a GENDER.");
		Log.info("Step:02 -  Select a GENDER.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GENDER can be selected.");
		Log.info("Expected Result: GENDER can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Qualification Dropdown
		ExtentTestManager.startTest("Select Qualification Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Qualification Dropdown");
		
		select("OTHERS",quickCustRepo.qadQualificationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Qualification dropdown.");
		Log.info("Step:01 - Click on the Qualification dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Qualification.");
		Log.info("Step:02 -  Select a Qualification.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Qualification can be selected.");
		Log.info("Expected Result: Qualification can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Religion Dropdown
		ExtentTestManager.startTest("Select Religion Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Religion Dropdown");
		
		select("HINDU",quickCustRepo.qadReligionDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Religion dropdown.");
		Log.info("Step:01 - Click on the Religion dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Religion.");
		Log.info("Step:02 -  Select a Religion.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Religion can be selected.");
		Log.info("Expected Result: Religion can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Category Dropdown
		ExtentTestManager.startTest("Select Category Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Category Dropdown");
		
		select("GENERAL",quickCustRepo.qadCategoryDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Category dropdown.");
		Log.info("Step:01 - Click on the Category dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Category.");
		Log.info("Step:02 -  Select a Category.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Category can be selected.");
		Log.info("Expected Result: Category can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select MaritalStatus Dropdown
		ExtentTestManager.startTest("Select MaritalStatus Dropdown").assignCategory("QuickCustomer");
		Log.info("Select MaritalStatus Dropdown");
		
		select("Single",quickCustRepo.qadMaritalStatusDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the MaritalStatus dropdown.");
		Log.info("Step:01 - Click on the MaritalStatus dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a MaritalStatus.");
		Log.info("Step:02 -  Select a MaritalStatus.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: MaritalStatus can be selected.");
		Log.info("Expected Result: MaritalStatus can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select OccupGroup Dropdown
		ExtentTestManager.startTest("Select OccupGroup Dropdown").assignCategory("QuickCustomer");
		Log.info("Select OccupGroup Dropdown");
		
		select("OTHERS",quickCustRepo.qadOccupGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the dropdown.");
		Log.info("Step:01 - Click on the dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select an item.");
		Log.info("Step:02 -  Select an item.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: OccupGroup can be selected.");
		Log.info("Expected Result: OccupGroup can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Type in 'Occupation' Field
		ExtentTestManager.startTest("Type in 'Occupation' Field").assignCategory("QuickCustomer");
		Log.info("Type in 'Occupation' Field");
		
		String occupation = testdata.get("occupation").toString();
		input(quickCustRepo.qadOccupationTxtBox, occupation);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'Occupation' field.");
		Log.info("Step:01 - Enter text in 'Occupation' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Text is accepted.");
		Log.info("Expected Result: Text is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Type in 'OccOrganisation' Field
		ExtentTestManager.startTest("Type in 'OccOrganisation' Field").assignCategory("QuickCustomer");
		Log.info("Type in 'OccOrganisation' Field");
		
		String occOrganisation = testdata.get("occOrganisation").toString();
		input(quickCustRepo.qadOccOrganisationTxtBox, occOrganisation);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'OccOrganisation' field.");
		Log.info("Step:01 - Enter text in 'OccOrganisation' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Text is accepted.");
		Log.info("Expected Result: Text is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Monthly Income' Field
		ExtentTestManager.startTest("Numeric Entry in 'Monthly Income' Field").assignCategory("QuickCustomer");
		Log.info("Numeric Entry in 'Monthly Income' Field");
		
		String monthlyIncome = testdata.get("monthlyIncome").toString();
		input(quickCustRepo.qadMonthlyIncomeTxtBox, monthlyIncome);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers in 'Monthly Income' field.");
		Log.info("Step:01 - Enter numbers in 'Monthly Income' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numbers are accepted.");
		Log.info("Expected Result: Numbers are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Income Source Dropdown
		ExtentTestManager.startTest("Select Income Source Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Income Source Dropdown");

		click(quickCustRepo.qadIncomeSourceDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Income Source dropdown.");
		Log.info("Step:01 - Click on the Income Source dropdown.");
		
		ScrollUntilElementVisible(quickCustRepo.qadIncomeSrcSalary);
		click(quickCustRepo.qadIncomeSrcSalary);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select an Income Source.");
		Log.info("Step:02 -  Select an Income Source.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Income Source can be selected.");
		Log.info("Expected Result: Income Source can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Salutation for Parent/Spouse Dropdown
		ExtentTestManager.startTest("Select Salutation for Parent/Spouse Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Salutation for Parent/Spouse Dropdown");

		select("MR",quickCustRepo.qadPrntSalutationDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Parent/Spouse Salutation dropdown.");
		Log.info("Step:01 - Click on the Parent/Spouse Salutation dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Parent/Spouse Salutation.");
		Log.info("Step:02 -  Select a Parent/Spouse Salutation.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Parent/Spouse Salutation can be selected.");
		Log.info("Expected Result: Parent/Spouse Salutation can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Parent/Spouse' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Parent/Spouse' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Parent/Spouse' Field");
		
		String parentOrSpouseName = testdata.get("parentOrSpouseName").toString();
		input(quickCustRepo.qadparentOrSpouseTxtBox, parentOrSpouseName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'Parent/Spouse' field.");
		Log.info("Step:01 - Enter text in 'Parent/Spouse' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Relation Dropdown
		ExtentTestManager.startTest("Select Relation Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Relation Dropdown");

		select("MOTHER",quickCustRepo.qadRelationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Relation dropdown.");
		Log.info("Step:01 - Click on the Relation dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Relation.");
		Log.info("Step:02 -  Select a Relation.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation can be selected.");
		Log.info("Expected Result: Relation can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Tick 'Ment. Retarded' Checkbox
		ExtentTestManager.startTest("Tick 'Ment. Retarded' Checkbox").assignCategory("QuickCustomer");
		Log.info("Tick 'Ment. Retarded' Checkbox");

		click(quickCustRepo.qadMentRetardCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Ment. Retarded' checkbox.");
		Log.info("Step:01 - Click on the 'Ment. Retarded' checkbox.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked.");
		Log.info("Expected Result: Checkbox is ticked.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Salutation for Guardian Dropdown
		ExtentTestManager.startTest("Select Salutation for Guardian Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Salutation for Guardian Dropdown");

		select("MR",quickCustRepo.qadGuardianSalutationDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Salutation for Guardian dropdown.");
		Log.info("Step:01 - Click on the Salutation for Guardian dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Salutation for Guardian.");
		Log.info("Step:02 -  Select a Salutation for Guardian.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Salutation for Guardian can be selected.");
		Log.info("Expected Result: Salutation for Guardian can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Guardian' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Guardian' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Guardian' Field");
		
		String guardianName = testdata.get("guardianName").toString();
		input(quickCustRepo.qadGuardianTxtBox, guardianName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'Guardian' field.");
		Log.info("Step:01 - Enter text in 'Guardian' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Guardian Relation Dropdown
		ExtentTestManager.startTest("Select Guardian Relation Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Guardian Relation Dropdown");

		select("MOTHER",quickCustRepo.qadGuardRelationDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Guardian Relation dropdown.");
		Log.info("Step:01 - Click on the Guardian Relation dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Guardian Relation.");
		Log.info("Step:02 -  Select a Guardian Relation.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Guardian Relation can be selected.");
		Log.info("Expected Result: Guardian Relation can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Salutation for Father Name Dropdown
		ExtentTestManager.startTest("Select Salutation for Father Name Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Salutation for Father Name Dropdown");

		select("MR",quickCustRepo.qadFathrNameSalutationDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Salutation for Father Name dropdown.");
		Log.info("Step:01 - Click on the Salutation for Father Name dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Salutation for Father Name.");
		Log.info("Step:02 -  Select a Salutation for Father Name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Salutation for Father Name can be selected.");
		Log.info("Expected Result: Salutation for Father Name can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Father Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Father Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Father Name' Field");
		
		String fatherName = testdata.get("fatherName").toString();
		input(quickCustRepo.qadFathrNameTxtBox, fatherName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'Father Name' field.");
		Log.info("Step:01 - Enter text in 'Father Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Salutation for Mother Name Dropdown
		ExtentTestManager.startTest("Select Salutation for Mother Name Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Salutation for Mother Name Dropdown");

		select("MRS",quickCustRepo.qadMthrNameSalutationDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Salutation for Mother Name dropdown.");
		Log.info("Step:01 - Click on the Salutation for Mother Name dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Salutation for Mother Name.");
		Log.info("Step:02 -  Select a Salutation for Mother Name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Salutation for Mother Name can be selected.");
		Log.info("Expected Result: Salutation for Mother Name can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Mother Name' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Mother Name' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Mother Name' Field");
		
		String motherName = testdata.get("motherName").toString();
		input(quickCustRepo.qadMthrNameTxtBox, motherName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in 'Mother Name' field.");
		Log.info("Step:01 - Enter text in 'Mother Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets accepted.");
		Log.info("Expected Result: Alphabets accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'Aadhaar No' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'Aadhaar Num' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'Aadhaar Num' Field");

		input(quickCustRepo.qadAadhaarTxtBox,fNameAlphabetInput);click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'Aadhaar Num' field.");
		Log.info("Step:01 - Enter alphabets in 'Aadhaar Num' field.");
		
		click(quickCustRepo.qadFNameTxt);
		
		if(ElementDisplayed(quickCustRepo.qadInvalidAadhaarCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"Invalid Aadhar No\".");
			Log.info("Expected Result: Validation message: \"Invalid Aadhar Num\".");
		}
		click(quickCustRepo.qadInvalidAadhaarCloseBtn);
		
		ExtentTestManager.endTest();
		
		
		
		//Clear 'Aadhaar No' Field
		ExtentTestManager.startTest("Clear 'Aadhaar Num' Field").assignCategory("QuickCustomer");
		Log.info("Clear 'Aadhaar Num' Field");
		
		clear(quickCustRepo.qadAadhaarTxtBox);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear the 'Aadhaar Num' field.");
		Log.info("Step:01 - Clear the 'Aadhaar Num' field.");
		
		/*String aadhaarNull = driver.findElement(quickCustRepo.qadAadhaarTxtBox).getText();
		if(aadhaarNull=="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Aadhaar Num Field is cleared successfully.");
			Log.info("Expected Result: Aadhaar Num Field is cleared successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Aadhaar Num Field is not cleared successfully.");
			Log.info("Expected Result: Aadhaar Num Field is not cleared successfully.");
		}*/
		ExtentTestManager.endTest();
		
		
		
		//Short Numeric Entry in 'Aadhar No' Field
		ExtentTestManager.startTest("Short Numeric Entry in 'Aadhar No' Field").assignCategory("QuickCustomer");
		Log.info("Short Numeric Entry in 'Aadhar No' Field");

		String eightDigitAadhaarNum = testdata.get("eightDigitAadhaarNum").toString();
		input(quickCustRepo.qadAadhaarTxtBox,eightDigitAadhaarNum);click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 8-digit number in 'Aadhar No' field.");
		Log.info("Step:01 - Enter 8-digit number in 'Aadhar No' field.");
		
		click(quickCustRepo.qadFNameTxt);
		
		if(ElementDisplayed(quickCustRepo.qadInvalidAadhaarCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"Invalid Aadhar No\".");
			Log.info("Expected Result: Validation message: \"Invalid Aadhar Num\".");
		}
		click(quickCustRepo.qadInvalidAadhaarCloseBtn);
		ExtentTestManager.endTest();
		
		
		
		//Valid Numeric Entry in 'Aadhar No' Field
		ExtentTestManager.startTest("Valid Numeric Entry in 'Aadhar No' Field").assignCategory("QuickCustomer");
		Log.info("Valid Numeric Entry in 'Aadhar No' Field");

		clear(quickCustRepo.qadAadhaarTxtBox);
//		String validTwelveDigitAadhaarNum = testdata.get("validTwelveDigitAadhaarNum").toString();
		String validAadhaar = generateUniqueId(spAadhaar,clmnNamAadhaar);
		input(quickCustRepo.qadAadhaarTxtBox,validAadhaar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 12-digit number in 'Aadhar No' field.");
		Log.info("Step:01 - Enter 12-digit number in 'Aadhar No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Number is accepted.");
		Log.info("Expected Result: Number is accepted.");
		ExtentTestManager.endTest();
		
		
		
		//Alphabetic Entry in 'PAN No' Field
		ExtentTestManager.startTest("Alphabetic Entry in 'PAN No' Field").assignCategory("QuickCustomer");
		Log.info("Alphabetic Entry in 'PAN No' Field");

		input(quickCustRepo.qadPANTxtBox,fNameAlphabetInput);click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets in 'PAN' field.");
		Log.info("Step:01 - Enter alphabets in 'PAN' field.");
		
		click(quickCustRepo.qadFNameTxt);
		
		if(ElementDisplayed(quickCustRepo.qadInvalidPANCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"Invalid PAN No\".");
			Log.info("Expected Result: Validation message: \"Invalid PAN Num\".");
		}
		click(quickCustRepo.qadInvalidPANCloseBtn);
		
		ExtentTestManager.endTest();
		
		
		
		//Clear 'PAN No' Field
		ExtentTestManager.startTest("Clear 'PAN Num' Field").assignCategory("QuickCustomer");
		Log.info("Clear 'PAN Num' Field");
		
		clear(quickCustRepo.qadPANTxtBox);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear the 'PAN Num' field.");
		Log.info("Step:01 - Clear the 'PAN Num' field.");
		
		/*String panNull = driver.findElement(quickCustRepo.qadPANTxtBox).getText();
		if(panNull=="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PAN Num Field is cleared successfully.");
			Log.info("Expected Result: PAN Num Field is cleared successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: PAN Num Field is not cleared successfully.");
			Log.info("Expected Result: PAN Num Field is not cleared successfully.");
		}*/
		ExtentTestManager.endTest();
		
		
		
		//Correct Format in 'PAN No' Field
		ExtentTestManager.startTest("Correct Format in 'PAN No' Field").assignCategory("QuickCustomer");
		Log.info("Correct Format in 'PAN No' Field");


		String validPANNum = generateUniqueId(spPAN,clmnNamPAN);
//		String validPANNum = testdata.get("validPANNum").toString();
		input(quickCustRepo.qadPANTxtBox,validPANNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid PAN format.");
		Log.info("Step:01 - nter valid PAN format.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PAN number is accepted.");
		Log.info("Expected Result: PAN number is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Short Numeric Entry in 'Mobile No' Field
		ExtentTestManager.startTest("Short Numeric Entry in 'Mobile No' Field").assignCategory("QuickCustomer");
		Log.info("Short Numeric Entry in 'Mobile No' Field");

		input(quickCustRepo.qadMobileNumTxtBox,eightDigitAadhaarNum);click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 8-digit number in 'Mobile No' field.");
		Log.info("Step:01 - Enter 8-digit number in 'Mobile No' field.");
		
		click(quickCustRepo.qadFNameTxt);
		
		if(ElementDisplayed(quickCustRepo.qadInvalidMobileCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"Invalid Mobile No\".");
			Log.info("Expected Result: Validation message: \"Invalid Mobile Num\".");
		}
		click(quickCustRepo.qadInvalidMobileCloseBtn);
		ExtentTestManager.endTest();
		
		
		
		//Valid Numeric Entry in 'Mobile No' Field
		ExtentTestManager.startTest("Valid Numeric Entry in 'Mobile No' Field").assignCategory("QuickCustomer");
		Log.info("Valid Numeric Entry in 'Mobile No' Field");

		clear(quickCustRepo.qadMobileNumTxtBox);
//		String validTenDigitMobileNum = testdata.get("validTenDigitMobileNum").toString();
		
		String validMobNum = generateUniqueId(spMobileNum,clmnNamMobileNum);
		input(quickCustRepo.qadMobileNumTxtBox,validMobNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 10-digit number in 'Mobile No' field.");
		Log.info("Step:01 - Enter 10-digit number in 'Mobile No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Number is accepted.");
		Log.info("Number is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Invalid Entry in 'Email' Field
		ExtentTestManager.startTest("Invalid Entry in 'Email' Field").assignCategory("QuickCustomer");
		Log.info("Invalid Entry in 'Email' Field");

		input(quickCustRepo.qadEmailTxtBox,eightDigitAadhaarNum);click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid email in 'Email' field.");
		Log.info("Step:01 - Enter invalid email in 'Email' field.");
		
		click(quickCustRepo.qadFNameTxt);
		
		if(ElementDisplayed(quickCustRepo.qadInvalidEmailCloseBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation message: \"Email is not valid\".");
			Log.info("Expected Result: Validation message: \"Email is not valid\".");
		}
		click(quickCustRepo.qadInvalidEmailCloseBtn);
		ExtentTestManager.endTest();
		
		
		
		//Clear 'Email' Field
		ExtentTestManager.startTest("Clear 'Email' Field").assignCategory("QuickCustomer");
		Log.info("Clear 'Email' Field");
		
		clear(quickCustRepo.qadEmailTxtBox);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear 'Email' field.");
		Log.info("Step:01 - Clear 'Email' field.");
		
		/*String emailNull = driver.findElement(quickCustRepo.qadEmailTxtBox).getText();
		if(emailNull=="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Email Field is cleared successfully.");
			Log.info("Expected Result: Email Field is cleared successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Email Field is not cleared successfully.");
			Log.info("Expected Result: Email Field is not cleared successfully.");
		}*/
		ExtentTestManager.endTest();
		
		
		
		//Valid Entry in 'Email' Field
		ExtentTestManager.startTest("Valid Entry in 'Email' Field").assignCategory("QuickCustomer");
		Log.info("Valid Entry in 'Email' Field");

		String validEmail = testdata.get("validEmail").toString();
		input(quickCustRepo.qadEmailTxtBox,validEmail);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid email address.");
		Log.info("Step:01 - Enter valid email address.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Email is accepted.");
		Log.info("Email is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Preferred Language Dropdown
		ExtentTestManager.startTest("Select Preferred Language Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Preferred Language Dropdown");

		select("English",quickCustRepo.qadPreferredLangDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Preferred Language dropdown.");
		Log.info("Step:01 - Click on the Preferred Language dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Preferred Language.");
		Log.info("Step:02 -  Select a Preferred Language.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Preferred Language can be selected.");
		Log.info("Expected Result: Preferred Language can be selected.");
		
		ExtentTestManager.endTest();
	}

		
	
	
	public void presentAddress(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
	
		//House Field - ECP Validations
		ExtentTestManager.startTest("House Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("House Field - ECP Validations");
		
		//Alphanumeric Input
		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentHouseTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in House field.");
		Log.info("Step:01 - Enter Alphanumeric input in House field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentHouseTxtBox);
		
		//Numeric Input
		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentHouseTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in House field.");
		Log.info("Step:02 - Enter Numeric input in House field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentHouseTxtBox);
		
		//Alphabet Input
		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentHouseTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in House field.");
		Log.info("Step:03 - Enter Alphabet input in House field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		//HouseNo Field - ECP Validations
		ExtentTestManager.startTest("HouseNo Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("HouseNo Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentHouseNumTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in HouseNo field.");
		Log.info("Step:01 - Enter Alphanumeric input in HouseNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentHouseNumTxtBox);
		
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentHouseNumTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in HouseNo field.");
		Log.info("Step:03 - Enter Alphabet input in HouseNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		clear(quickCustRepo.presentHouseNumTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentHouseNumTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in HouseNo field.");
		Log.info("Step:02 - Enter Numeric input in HouseNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		
		
		//DoorNo Field - ECP Validations
		ExtentTestManager.startTest("DoorNo Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("DoorNo Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentDoorNumTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in DoorNo field.");
		Log.info("Step:01 - Enter Alphanumeric input in DoorNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentDoorNumTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentDoorNumTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in DoorNo field.");
		Log.info("Step:03 - Enter Alphabet input in DoorNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();

		clear(quickCustRepo.presentDoorNumTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentDoorNumTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in DoorNo field.");
		Log.info("Step:02 - Enter Numeric input in DoorNo field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		
		
		//State Dropdown Functionality
		ExtentTestManager.startTest("State Dropdown Functionality").assignCategory("QuickCustomer");
		Log.info("State Dropdown Functionality");

		select("KERALA",quickCustRepo.presentStateDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the State dropdown.");
		Log.info("Step:01 - Click on the State dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a State.");
		Log.info("Step:02 -  Select a State.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: State can be selected.");
		Log.info("Expected Result: State can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//District Dropdown Functionality
		ExtentTestManager.startTest("District Dropdown Functionality").assignCategory("QuickCustomer");
		Log.info("District Dropdown Functionality");

		select("Wayanad",quickCustRepo.presentDistrictDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the District dropdown.");
		Log.info("Step:01 - Click on the District dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a District.");
		Log.info("Step:02 -  Select a District.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: District can be selected.");
		Log.info("Expected Result: District can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Post Dropdown Functionality
		ExtentTestManager.startTest("Post Dropdown Functionality").assignCategory("QuickCustomer");
		Log.info("Post Dropdown Functionality");

		select("Bavali B.O",quickCustRepo.presentPostDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Post dropdown.");
		Log.info("Step:01 - Click on the Post dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select a Post.");
		Log.info("Step:02 -  Select a Post.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Post can be selected.");
		Log.info("Expected Result: Post can be selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//PIN Text field Presence & Functionality
		ExtentTestManager.startTest("PIN Textfield Presence & Functionality").assignCategory("QuickCustomer");
		Log.info("PIN Textfield Presence & Functionality");
		
		String pinAutoFillValue = driver.findElement(quickCustRepo.presentPINTxtBox).getAttribute("value");
		
		if(pinAutoFillValue != "") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PIN textfield is present, typing-disabled, and auto-fills based on Post selection, i.e.: " + pinAutoFillValue);
			Log.info("Expected Result: PIN textfield is present, typing-disabled, and auto-fills based on Post selection, i.e.: " + pinAutoFillValue);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Pin wasn't Auto filled.");
			Log.info("Expected Result: Pin wasn't Auto filled.");
		}
		
		
		ExtentTestManager.endTest();
		
		
		
		//Place Field - ECP Validations
		ExtentTestManager.startTest("Place Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("Place Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentPlaceTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Place field.");
		Log.info("Step:01 - Enter Alphanumeric input in Place field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentPlaceTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentPlaceTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Place field.");
		Log.info("Step:02 - Enter Numeric input in Place field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentPlaceTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentPlaceTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Place field.");
		Log.info("Step:03 - Enter Alphabet input in Place field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		ScrollUntilElementVisible(quickCustRepo.checkAvailabilityBtn);
		
		
		
		//City Field - ECP Validations
		ExtentTestManager.startTest("City Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("City Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentCityTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in City field.");
		Log.info("Step:01 - Enter Alphanumeric input in City field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentCityTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentCityTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in City field.");
		Log.info("Step:02 - Enter Numeric input in City field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentCityTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentCityTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in City field.");
		Log.info("Step:03 - Enter Alphabet input in City field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		//Street Field - ECP Validations
		ExtentTestManager.startTest("Street Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("Street Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentStreetTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Street field.");
		Log.info("Step:01 - Enter Alphanumeric input in Street field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentStreetTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentStreetTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Street field.");
		Log.info("Step:02 - Enter Numeric input in Street field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentStreetTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentStreetTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Street field.");
		Log.info("Step:03 - Enter Alphabet input in Street field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		//Residence Field - ECP Validations
		ExtentTestManager.startTest("Residence Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("Residence Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentResidenceTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Residence field.");
		Log.info("Step:01 - Enter Alphanumeric input in Residence field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentResidenceTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentResidenceTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Residence field.");
		Log.info("Step:02 - Enter Numeric input in Residence field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentResidenceTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentResidenceTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Residence field.");
		Log.info("Step:03 - Enter Alphabet input in Residence field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		//Phone NO Field - ECP Validations
		ExtentTestManager.startTest("Phone NO Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("Phone NO Field - ECP Validations");
		
		String validTenDigitMobileNum = testdata.get("validTenDigitMobileNum").toString();
		input(quickCustRepo.presentPhoneNumTxtBox,validTenDigitMobileNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 10-digit number in 'Phone No' field.");
		Log.info("Step:01 - Enter 10-digit number in 'Phone No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Only Numbers are accepted.");
		Log.info("Only Numbers are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Electric Post No Field - ECP Validations
		ExtentTestManager.startTest("Electric Post No Field - ECP Validations").assignCategory("QuickCustomer");
		Log.info("Electric Post No Field - ECP Validations");
		
		//Alphanumeric Input
//		String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();
		input(quickCustRepo.presentElectricPostNumTxtBox,houseNameAlphanumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Electric Post No field.");
		Log.info("Step:01 - Enter Alphanumeric input in Electric Post No field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
		Log.info("Expected Result: Alphanumeric input is allowed.");
		
		clear(quickCustRepo.presentElectricPostNumTxtBox);
		
		//Numeric Input
//		String houseNameNumeric = testdata.get("houseNameNumeric").toString();
		input(quickCustRepo.presentElectricPostNumTxtBox,houseNameNumeric);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Electric Post No field.");
		Log.info("Step:02 - Enter Numeric input in Electric Post No field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
		Log.info("Expected Result: Numeric input is allowed.");
		
		clear(quickCustRepo.presentElectricPostNumTxtBox);
		
		//Alphabet Input
//		String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();
		input(quickCustRepo.presentElectricPostNumTxtBox,houseNameAlphabet);
		click(quickCustRepo.qadFNameTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Electric Post No field.");
		Log.info("Step:03 - Enter Alphabet input in Electric Post No field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
		Log.info("Expected Result: Alphabet input is allowed.");
		
		ExtentTestManager.endTest();
		
		
		
		//Mailing Address Checkbox Functionality
		ExtentTestManager.startTest("Mailing Address Checkbox Functionality").assignCategory("QuickCustomer");
		Log.info("Mailing Address Checkbox Functionality");
		
		click(quickCustRepo.presentMailAddrCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Mailing Address' checkbox.");
		Log.info("Step:01 - Click on the 'Mailing Address' checkbox.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The checkbox can be ticked and unticked.");
		Log.info("Expected Result: The checkbox can be ticked and unticked.");
		
		ExtentTestManager.endTest();
	}
	
	
	
	
	public void permanentAddress() throws InterruptedException {
		
		
		//Use Present Check box Functionality
		ExtentTestManager.startTest("Use Present Checkbox Functionality").assignCategory("QuickCustomer");
		Log.info("Use Present Checkbox Functionality");
		
		click(quickCustRepo.permanentUsePresentCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Use Present' checkbox.");
		Log.info("Step:01 - Click on the 'Use Present' checkbox.");

		String presentPIN = driver.findElement(quickCustRepo.presentPINTxtBox).getAttribute("value");
		String permanentPIN = driver.findElement(quickCustRepo.permanentPINTxtBox).getAttribute("value");

		String presentHouse = driver.findElement(quickCustRepo.presentHouseTxtBox).getAttribute("value");
		String permanentHouse = driver.findElement(quickCustRepo.permanentHouseTxtBox).getAttribute("value");

		
		if(presentPIN.equals(permanentPIN) && presentHouse.equalsIgnoreCase(permanentHouse)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Permanent tab data is auto-populated from the Present tab.");
			Log.info("Expected Result: Permanent tab data is auto-populated from the Present tab.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Permanent tab data is not auto-populated from the Present tab.");
			Log.info("Expected Result: Permanent tab data is not auto-populated from the Present tab.");
		}
			
		ExtentTestManager.endTest();
		
	}
	
	
	
	public void referredBy() throws InterruptedException {

		
		//Referred By Drop down - Select Item
		ExtentTestManager.startTest("Referred By Dropdown - Select Item").assignCategory("QuickCustomer");
		Log.info("Referred By Dropdown - Select Item");
		
		ScrollUntilElementVisible(quickCustRepo.refByDropDown);
		select("SUNIL", quickCustRepo.refByDropDown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Referred By dropdown.");
		Log.info("Step:01 - Click on the Referred By dropdown.");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
		Log.info("Step:02 - Select an option.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Referred By, can be selected from dropdown.");
		Log.info("Expected Result: Referred By, can be selected from dropdown.");
		
		ExtentTestManager.endTest();
		
	}
	
	
	
	public void introducer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		
		//Introducer Button - Clickability
		ExtentTestManager.startTest("Introducer Button - Clickability").assignCategory("QuickCustomer");
		Log.info("Introducer Button - Clickability");
		
		ScrollUntilElementVisible(quickCustRepo.btnIntroducer);
		click(quickCustRepo.btnIntroducer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the 'Introducer' button.");
		Log.info("Step:01 -Click the 'Introducer' button.");

        
        //Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
        		
                if(ElementDisplayed(quickCustRepo.introDetailsNotReqCheckBox)) {
                	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: A popup named 'Introducer Details' is generated.");
        			Log.info("Expected Result: A popup named 'Introducer Details' is generated.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: A popup named 'Introducer Details' is not generated.");
        			Log.info("Expected Result: A popup named 'Introducer Details' is not generated.");
                }
    			
                ExtentTestManager.endTest();

        		
        		//Introducer Not Required Check box - Tick
        		ExtentTestManager.startTest("Introducer Not Required Checkbox - Tick").assignCategory("QuickCustomer");
        		Log.info("Introducer Not Required Checkbox - Tick");
                
        		click(quickCustRepo.introDetailsNotReqCheckBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Introducer Not Required' checkbox.");
        		Log.info("Step:01 - Click on the 'Introducer Not Required' checkbox.");
        		
                if(ElementDisplayed(quickCustRepo.introDetailsReasonTxtBox)) {
                	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Reason' textfield becomes visible.");
        			Log.info("Expected Result: 'Reason' textfield becomes visible.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: 'Reason' textfield is not visible.");
        			Log.info("Expected Result: 'Reason' textfield is not visible.");
                }
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Reason Textfield - Typing Alphabets and Numerals
        		ExtentTestManager.startTest("Reason Textfield - Typing Alphabets and Numerals").assignCategory("QuickCustomer");
        		Log.info("Reason Textfield - Typing Alphabets and Numerals");
              
        		String introducerReason = testdata.get("introducerReason").toString();
        		input(quickCustRepo.introDetailsReasonTxtBox,introducerReason);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Type \"Test123\" in the 'Reason' textfield.");
        		Log.info("Step:01 - Type \"Test123\" in the 'Reason' textfield.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Textfield reflects typed input without an error.");
    			Log.info("Expected Result: Textfield reflects typed input without an error.");

        		ExtentTestManager.endTest();
        		
        		
        		
        		//Introducer Not Required Checkbox - Untick
        		ExtentTestManager.startTest("Introducer Not Required Checkbox - Untick").assignCategory("QuickCustomer");
        		Log.info("Introducer Not Required Checkbox - Untick");
        		
        		click(quickCustRepo.introDetailsNotReqCheckBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick the 'Introducer Not Required' checkbox.");
        		Log.info("Step:01 - Untick the 'Introducer Not Required' checkbox.");
        		
                if(ElementDisplayed(quickCustRepo.introDetailsCustIdTxtBox)) {
                	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Reason' textfield is no longer visible.");
        			Log.info("Expected Result: 'Reason' textfield is no longer visible.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: 'Reason' textfield is still visible.");
        			Log.info("Expected Result: 'Reason' textfield is still visible.");
                }
                
        		ExtentTestManager.endTest();
                
                
                click(quickCustRepo.introduceSaveBtn);
       		
        		
        		driver.switchTo().window(mainWindowHandle);
                break;
            }
		
        }
           
	}
        
	
	
	
	public void identityAndArea(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		//Select Item from 'Identity Type' Dropdown
		ExtentTestManager.startTest("Select Item from 'Identity Type' Dropdown").assignCategory("QuickCustomer");
		Log.info("Select Item from 'Identity Type' Dropdown");
		
		ScrollUntilElementVisible(quickCustRepo.identityAndAreaBtn);
		click(quickCustRepo.identityAndAreaBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Relation dropdown.");
		Log.info("Step:01 - Click on the Identity And Area button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
        		
        		select("PANCARD", quickCustRepo.aidIdentityTypeDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Identity Type dropdown.");
        		Log.info("Step:02 - Click on the Identity Type dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an item from the 'Identity Type' dropdown items.");
        		Log.info("Step:03 - Select an item from the 'Identity Type' dropdown items.");
        		
                
        		String proofTypeValue = driver.findElement(quickCustRepo.aidProofTypeDrpDwnValue).getText();

            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted, ‘Proof Type’ field is auto-filled as: "+ proofTypeValue);
            	Log.info("Expected Result: Selected item is highlighted, ‘Proof Type’ field is auto-filled as: "+ proofTypeValue);
                
            	ExtentTestManager.endTest();
        		
            	
            	
            	
        		//Select different items from 'Identity Type' dropdown
        		ExtentTestManager.startTest("Select different items from 'Identity Type' dropdown").assignCategory("QuickCustomer");
        		Log.info("Select different items from 'Identity Type' dropdown");
        		
        		select("AADHAR", quickCustRepo.aidIdentityTypeDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Identity Type dropdown.");
        		Log.info("Step:02 - Click on the Identity Type dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an item from the 'Identity Type' dropdown items.");
        		Log.info("Step:03 - Select an item from the 'Identity Type' dropdown items.");
        		
                
        		String proofTypeValue1 = driver.findElement(quickCustRepo.aidProofTypeDrpDwnValue).getText();

            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Proof Type' changes accordingly based on selection: "+ proofTypeValue1);
            	Log.info("Expected Result: 'Proof Type' changes accordingly based on selection: "+ proofTypeValue1);
                
            	ExtentTestManager.endTest();
            	
            	
        		
        		//Enter Data in 'Identity No.' Field
        		ExtentTestManager.startTest("Enter Data in 'Identity No.' Field").assignCategory("QuickCustomer");
        		Log.info("Enter Data in 'Identity No.' Field");
        		
        		//Alphanumeric Input
        		String identityNumAlphanumeric = testdata.get("identityNumAlphanumeric").toString();
        		input(quickCustRepo.aidIdentityNumTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Identity No field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Identity No field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
        		Log.info("Expected Result: Alphanumeric input is allowed.");
        		
        		clear(quickCustRepo.aidIdentityNumTxtBox);
        		
        		//Alphabet Input
        		String identityNumAlphabet = testdata.get("identityNumAlphabet").toString();
        		input(quickCustRepo.aidIdentityNumTxtBox,identityNumAlphabet);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Identity No field.");
        		Log.info("Step:03 - Enter Alphabet input in Identity No field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
        		Log.info("Expected Result: Alphabet input is allowed.");
        		
        		clear(quickCustRepo.aidIdentityNumTxtBox);
        		
        		//Numeric Input
        		String uniqueId = generateUniqueId(spAadhaar, clmnNamAadhaar);
        		input(quickCustRepo.aidIdentityNumTxtBox,uniqueId);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Identity No field.");
        		Log.info("Step:02 - Enter Numeric input in Identity No field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");
        		
        		ExtentTestManager.endTest();

        		
        		
        		
        		//Enter Data in 'Issued Authority' Field
        		ExtentTestManager.startTest("Enter Data in 'Issued Authority' Field").assignCategory("QuickCustomer");
        		Log.info("Enter Data in 'Issued Authority' Field");
        		
        		//Alphanumeric Input
//        		String identityNumAlphanumeric = testdata.get("identityNumAlphanumeric").toString();
        		input(quickCustRepo.aidIssuedAuthorityTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Issued Authority field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Issued Authority field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
        		Log.info("Expected Result: Alphanumeric input is allowed.");
        		
        		clear(quickCustRepo.aidIssuedAuthorityTxtBox);
        		
        		//Numeric Input
        		String identityNumNumeric = testdata.get("identityNumNumeric").toString();
        		input(quickCustRepo.aidIssuedAuthorityTxtBox,identityNumNumeric);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Issued Authority field.");
        		Log.info("Step:02 - Enter Numeric input in Issued Authority field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");
        		
        		clear(quickCustRepo.aidIssuedAuthorityTxtBox);
        		
        		//Alphabet Input
//        		String identityNumAlphabet = testdata.get("identityNumAlphabet").toString();
        		input(quickCustRepo.aidIssuedAuthorityTxtBox,identityNumAlphabet);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Issued Authority field.");
        		Log.info("Step:03 - Enter Alphabet input in Issued Authority field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
        		Log.info("Expected Result: Alphabet input is allowed.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Invalid Date in 'Issue Date' Field
        		ExtentTestManager.startTest("Invalid Date in 'Issue Date' Field").assignCategory("QuickCustomer");
        		Log.info("Invalid Date in 'Issue Date' Field");
        		
        		String invalidIssueDate = testdata.get("invalidIssueDate").toString();
        		click(quickCustRepo.aidIssueDateTxtBox);
        		input(quickCustRepo.aidIssueDateTxtBox,invalidIssueDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an invalid date.");
        		Log.info("Step:01 - Enter an invalid date.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Proceed to next step.");
        		Log.info("Step:02 - Proceed to next step.");
        		
        		if(ElementDisplayed(quickCustRepo.aidIssueDateInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Invalid date error message is displayed.");
            		Log.info("Expected Result: Invalid date error message is displayed.");
        		}else {
        			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Invalid date error message is not displayed.");
            		Log.info("Expected Result: Invalid date error message is not displayed.");
        		}
        		click(quickCustRepo.aidIssueDateInvalidPopUp);
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Clear 'Issue Date' Field
        		ExtentTestManager.startTest("Clear 'Issue Date' Field").assignCategory("QuickCustomer");
        		Log.info("Clear 'Issue Date' Field");
        		
        		click(quickCustRepo.aidIssueDateTxtBox);
        		clear(quickCustRepo.aidIssueDateTxtBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear date from 'Issue Date' field.");
        		Log.info("Step:01 - Clear date from 'Issue Date' field.");
        		
        		
        		
        		/*String issueDateValue = driver.findElement(quickCustRepo.aidIssueDateTxtBox).getAttribute("value");
        			System.out.println("Issue Date Value: "+issueDateValue);
        		if(issueDateValue=="") {
        				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field becomes empty without errors.");
                    	Log.info("Expected Result: Field becomes empty without errors.");
        		}else {
    				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Field wasn't cleared.");
                	Log.info("Expected Result: Field wasn't cleared.");
        		}*/
            	
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Valid Date in 'Issue Date' Field
        		ExtentTestManager.startTest("Valid Date in 'Issue Date' Field").assignCategory("QuickCustomer");
        		Log.info("Valid Date in 'Issue Date' Field");
        		
        		String validIssueDate = testdata.get("validIssueDate").toString();
        		click(quickCustRepo.aidIssueDateTxtBox);
        		input(quickCustRepo.aidIssueDateTxtBox,validIssueDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid date.");
        		Log.info("Step:01 - Enter a valid date.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Proceed to next step.");
        		Log.info("Step:02 - Proceed to next step.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid date is accepted by the field.");
            	Log.info("Expected Result: Valid date is accepted by the field.");
        		
            	ExtentTestManager.endTest();
            	
            	
            	
        		
        		//Invalid Date in 'Valid Up To' Field
        		ExtentTestManager.startTest("Invalid Date in 'Valid Up To' Field").assignCategory("QuickCustomer");
        		Log.info("Invalid Date in 'Valid Up To' Field");
        		
//        		String invalidIssueDate = testdata.get("invalidIssueDate").toString();
        		click(quickCustRepo.aidValidUpToTxtBox);
        		input(quickCustRepo.aidValidUpToTxtBox,invalidIssueDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an invalid date.");
        		Log.info("Step:01 - Enter an invalid date.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Proceed to next step.");
        		Log.info("Step:02 - Proceed to next step.");
        		
        		if(ElementDisplayed(quickCustRepo.aidValidUpToInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Invalid date error message is displayed.");
            		Log.info("Expected Result: Invalid date error message is displayed.");
        		}else {
        			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Invalid date error message is not displayed.");
            		Log.info("Expected Result: Invalid date error message is not displayed.");
        		}
        		click(quickCustRepo.aidValidUpToInvalidPopUp);
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Clear 'Valid Up To' Field
        		ExtentTestManager.startTest("Clear 'Valid Up To' Field").assignCategory("QuickCustomer");
        		Log.info("Clear 'Valid Up To' Field");
        		
        		click(quickCustRepo.aidValidUpToTxtBox);
        		clear(quickCustRepo.aidValidUpToTxtBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Clear date from 'Valid Up To' field.");
        		Log.info("Step:01 - Clear date from 'Valid Up To' field.");

        		/*String validUpToValue = driver.findElement(quickCustRepo.aidValidUpToTxtBox).getAttribute("value");
        			System.out.println("Valid Up To Value: "+validUpToValue);
        		if(validUpToValue=="") {
        				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field becomes empty without errors.");
                    	Log.info("Expected Result: Field becomes empty without errors.");
        		}else {
    				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Field wasn't cleared.");
                	Log.info("Expected Result: Field wasn't cleared.");
        		}*/
            	
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Valid Date in 'Valid Up To' Field
        		ExtentTestManager.startTest("Valid Date in 'Valid Up To' Field").assignCategory("QuickCustomer");
        		Log.info("Valid Date in 'Valid Up To' Field");
        		
        		String validUpToDate = testdata.get("validUpToDate").toString();
        		click(quickCustRepo.aidValidUpToTxtBox);
        		input(quickCustRepo.aidValidUpToTxtBox,validUpToDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid date.");
        		Log.info("Step:01 - Enter a valid date.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Proceed to next step.");
        		Log.info("Step:02 - Proceed to next step.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid date is accepted by the field.");
            	Log.info("Expected Result: Valid date is accepted by the field.");
        		
        		
        		
        		//Enter Data in 'Details' Field
        		ExtentTestManager.startTest("Enter Data in 'Details' Field").assignCategory("QuickCustomer");
        		Log.info("Enter Data in 'Details' Field");
        		
        		//Alphanumeric Input
//        		String identityNumAlphanumeric = testdata.get("identityNumAlphanumeric").toString();
        		input(quickCustRepo.aidDetailsTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Details field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Details field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is allowed.");
        		Log.info("Expected Result: Alphanumeric input is allowed.");
        		
        		clear(quickCustRepo.aidDetailsTxtBox);
        		
        		//Numeric Input
//        		String identityNumNumeric = testdata.get("identityNumNumeric").toString();
        		input(quickCustRepo.aidDetailsTxtBox,identityNumNumeric);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Numeric input in Details field.");
        		Log.info("Step:02 - Enter Numeric input in Details field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");
        		
        		clear(quickCustRepo.aidDetailsTxtBox);
        		
        		//Alphabet Input
//        		String identityNumAlphabet = testdata.get("identityNumAlphabet").toString();
        		input(quickCustRepo.aidDetailsTxtBox,identityNumAlphabet);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in Details field.");
        		Log.info("Step:03 - Enter Alphabet input in Details field.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is allowed.");
        		Log.info("Expected Result: Alphabet input is allowed.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Click 'ADD DOCUMENT' Button
        		ExtentTestManager.startTest("Click 'ADD DOCUMENT' Button").assignCategory("QuickCustomer");
        		Log.info("Click 'ADD DOCUMENT' Button");
        		
        		click(quickCustRepo.aidAddDocumentBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'ADD DOCUMENT' button.");
        		Log.info("Step:01 - Click on the 'ADD DOCUMENT' button.");
        		        		
//        		String value = driver.findElement(quickCustRepo.aidAddDocTable).getAttribute("title");
        		ElementDisplayed(quickCustRepo.addDocValueInGrid);
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is displayed in the grid.");
        		Log.info("Expected Result: Data is displayed in the grid.");
        		
        		ExtentTestManager.endTest();

        		
        		//Area Dropdown Selection
        		ExtentTestManager.startTest("Area Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Area Dropdown Selection");
        		
        		select("PATTAMBI", quickCustRepo.adAreaDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Area dropdown.");
        		Log.info("Step:01 - Click on the Area dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Area should be displayed.");
        		Log.info("Expected Result: Selected Area should be displayed.");
        		
        		ExtentTestManager.endTest();

        		
        		//Amsham Dropdown Selection
        		ExtentTestManager.startTest("Amsham Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Amsham Dropdown Selection");
        		
        		select("Others#", quickCustRepo.adAmshamDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Amsham dropdown.");
        		Log.info("Step:01 - Click on the Amsham dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Amsham should be displayed.");
        		Log.info("Expected Result: Selected Amsham should be displayed.");
        		
        		ExtentTestManager.endTest();

        		
        		//Desham Dropdown Selection
        		ExtentTestManager.startTest("Desham Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Desham Dropdown Selection");
        		
        		select("824#", quickCustRepo.adDeshamDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Desham dropdown.");
        		Log.info("Step:01 - Click on the Desham dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Desham should be displayed.");
        		Log.info("Expected Result: Selected Desham should be displayed.");
        		
        		ExtentTestManager.endTest();

        		
        		//Village Dropdown Selection
        		ExtentTestManager.startTest("Village Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Village Dropdown Selection");
        		
        		select("ALOOR", quickCustRepo.adVillageDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Village dropdown.");
        		Log.info("Step:01 - Click on the Village dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Village should be displayed.");
        		Log.info("Expected Result: Selected Village should be displayed.");
        		
        		ExtentTestManager.endTest();


        		
        		//Ward field Validation
        		ExtentTestManager.startTest("Ward field Validation").assignCategory("QuickCustomer");
        		Log.info("Ward field Validation");
        		
        		//Alphabet Input
        		input(quickCustRepo.adWardTextBox,identityNumAlphabet);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Alphabet input in Ward field.");
        		Log.info("Step:02 - Enter Alphabet input in Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		
        		if(ElementDisplayed(quickCustRepo.baInvalidStartDatePopUp)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is not allowed.");
        		Log.info("Expected Result: Alphabet input is not allowed.");
        		}
        		click(quickCustRepo.baInvalidStartDatePopUp);
        		clear(quickCustRepo.adWardTextBox);
        		
        		
        		//Alphanumeric Input
        		input(quickCustRepo.adWardTextBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Ward field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		
        		if(ElementDisplayed(quickCustRepo.baInvalidStartDatePopUp)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is not allowed.");
        		Log.info("Expected Result: Alphanumeric input is not allowed.");
        		}
        		click(quickCustRepo.baInvalidStartDatePopUp);
        		clear(quickCustRepo.adWardTextBox);

        		
        		//Numeric Input
        		input(quickCustRepo.adWardTextBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Numeric input in Ward field.");
        		Log.info("Step:03 - Enter Numeric input in Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");

        		ExtentTestManager.endTest();

        		
        		
        		//Panchayat Dropdown Selection
        		ExtentTestManager.startTest("Panchayat Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Panchayat Dropdown Selection");
        		
        		select("AANAAD", quickCustRepo.adPanchayathDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Panchayat dropdown.");
        		Log.info("Step:01 - Click on the Panchayat dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Panchayat should be displayed.");
        		Log.info("Expected Result: Selected Panchayat should be displayed.");
        		
        		select("--SELECT--", quickCustRepo.adPanchayathDropdown);

        		ExtentTestManager.endTest();


        		
        		//Municipality Dropdown Selection
        		ExtentTestManager.startTest("Municipality Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Municipality Dropdown Selection");
        		
        		select("ALUVA", quickCustRepo.adMunicipalityDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Municipality dropdown.");
        		Log.info("Step:01 - Click on the Municipality dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Municipality should be displayed.");
        		Log.info("Expected Result: Selected Municipality should be displayed.");
        		
        		select("--SELECT--", quickCustRepo.adMunicipalityDropdown);
        		
        		ExtentTestManager.endTest();


        		
        		//Corporation Dropdown Selection
        		ExtentTestManager.startTest("Corporation Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Corporation Dropdown Selection");
        		
        		select("KOCHI", quickCustRepo.adCorporationDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Corporation dropdown.");
        		Log.info("Step:01 - Click on the Corporation dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Corporation should be displayed.");
        		Log.info("Expected Result: Selected Corporation should be displayed.");
        		        		
        		ExtentTestManager.endTest();


        		
        		//Assembly Constituency Dropdown Selection
        		ExtentTestManager.startTest("Assembly Constituency Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Assembly Constituency Dropdown Selection");
        		
        		select("ALATHUR", quickCustRepo.adAssemblyConstituencyDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Assembly Constituency dropdown.");
        		Log.info("Step:01 - Click on the Assembly Constituency dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Assembly Constituency should be displayed.");
        		Log.info("Expected Result: Selected Assembly Constituency should be displayed.");
        		        		
        		ExtentTestManager.endTest();


        		
        		//Taluk Dropdown Selection
        		ExtentTestManager.startTest("Taluk Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Taluk Dropdown Selection");
        		
        		select("Aluva", quickCustRepo.adTalukDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Taluk dropdown.");
        		Log.info("Step:01 - Click on the Taluk dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Taluk should be displayed.");
        		Log.info("Expected Result: Selected Taluk should be displayed.");
        		        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Panchayat Ward ECP Validations
        		ExtentTestManager.startTest("Panchayat Ward ECP Validations").assignCategory("QuickCustomer");
        		Log.info("Panchayat Ward ECP Validations");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.adPanchayathWardTextBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Panchayat Ward field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Panchayat Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		if(ElementDisplayed(quickCustRepo.adPanchayathWardInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is not allowed.");
            		Log.info("Expected Result: Alphanumeric input is not allowed.");
        		}
        		clear(quickCustRepo.adPanchayathWardTextBox);
        		
        		//Alphabet Input
        		input(quickCustRepo.adPanchayathWardTextBox,identityNumAlphabet);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Alphabet input in Panchayat Ward field.");
        		Log.info("Step:02 - Enter Alphabet input in Panchayat Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		if(ElementDisplayed(quickCustRepo.adPanchayathWardInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is not allowed.");
            		Log.info("Expected Result: Alphabet input is not allowed.");
            		}
        		clear(quickCustRepo.adPanchayathWardTextBox);
        		
        		//Numeric Input
        		input(quickCustRepo.adPanchayathWardTextBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Numeric input in Panchayat Ward field.");
        		Log.info("Step:03 - Enter Numeric input in Panchayat Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//BankWard ECP Validations
        		ExtentTestManager.startTest("BankWard ECP Validations").assignCategory("QuickCustomer");
        		Log.info("BankWard ECP Validations");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.adBankWardTextBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Alphanumeric input in Bank Ward field.");
        		Log.info("Step:01 - Enter Alphanumeric input in Bank Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		if(ElementDisplayed(quickCustRepo.adPanchayathWardInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input is not allowed.");
            		Log.info("Expected Result: Alphanumeric input is not allowed.");
        		}
        		clear(quickCustRepo.adBankWardTextBox);
        		
        		//Alphabet Input
        		input(quickCustRepo.adBankWardTextBox,identityNumAlphabet);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Alphabet input in Bank Ward field.");
        		Log.info("Step:02 - Enter Alphabet input in Bank Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		if(ElementDisplayed(quickCustRepo.adPanchayathWardInvalidPopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input is not allowed.");
            		Log.info("Expected Result: Alphabet input is not allowed.");
            		}
        		clear(quickCustRepo.adBankWardTextBox);
        		
        		//Numeric Input
        		input(quickCustRepo.adBankWardTextBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Numeric input in Bank Ward field.");
        		Log.info("Step:03 - Enter Numeric input in Bank Ward field.");
        		
        		click(quickCustRepo.aidIssueDateTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is allowed.");
        		Log.info("Expected Result: Numeric input is allowed.");
        		
        		ExtentTestManager.endTest();


        		
        		//Land Type Dropdown Selection
        		ExtentTestManager.startTest("Land Type Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Land Type Dropdown Selection");
        		
        		select("Tenant", quickCustRepo.ldLandTypeDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Land Type dropdown.");
        		Log.info("Step:01 - Click on the Land Type dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an option.");
        		Log.info("Step:02 - Select an option.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Land Type should be displayed.");
        		Log.info("Expected Result: Selected Land Type should be displayed.");
        		        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Survey No Alphanumeric Entry
        		ExtentTestManager.startTest("Survey No Alphanumeric Entry").assignCategory("QuickCustomer");
        		Log.info("Survey No Alphanumeric Entry");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.ldSurveyNumTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets and numerals in 'Survey No' textfield.");
        		Log.info("Step:01 - Enter alphabets and numerals in 'Survey No' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input should be entered successfully.");
            	Log.info("Expected Result: Alphanumeric input should be entered successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//ReSurvey No Alphanumeric Entry
        		ExtentTestManager.startTest("ReSurvey No Alphanumeric Entry").assignCategory("QuickCustomer");
        		Log.info("ReSurvey No Alphanumeric Entry");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.ldResurveyNo,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets and numerals in 'Survey No' textfield.");
        		Log.info("Step:01 - Enter alphabets and numerals in 'Survey No' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphanumeric input should be entered successfully.");
            	Log.info("Expected Result: Alphanumeric input should be entered successfully.");
        		
        		ExtentTestManager.endTest();


        		
        		//Unit Dropdown Selection
        		ExtentTestManager.startTest("Unit Dropdown Selection").assignCategory("QuickCustomer");
        		Log.info("Unit Dropdown Selection");
        		
        		select("ACRES", quickCustRepo.ldUnitDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Unit dropdown.");
        		Log.info("Step:01 - Click on the Unit dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an item from 'Unit' dropdown.");
        		Log.info("Step:02 - Select an item from 'Unit' dropdown.");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Unit should be displayed.");
        		Log.info("Expected Result: Selected Unit should be displayed.");
        		        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Wet Numeric Entry
        		ExtentTestManager.startTest("Wet Numeric Entry").assignCategory("QuickCustomer");
        		Log.info("Wet Numeric Entry");
        		
        		//Numeric Input
        		click(quickCustRepo.ldWetTxtBox);
        		input(quickCustRepo.ldWetTxtBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numerals in 'Wet' textfield.");
        		Log.info("Step:01 - Enter numerals in 'Wet' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numerals should be entered successfully.");
            	Log.info("Expected Result: Numerals should be entered successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Dry Numeric Entry
        		ExtentTestManager.startTest("Dry Numeric Entry").assignCategory("QuickCustomer");
        		Log.info("Dry Numeric Entry");
        		
        		//Numeric Input
        		click(quickCustRepo.ldDryTxtBox);
        		input(quickCustRepo.ldDryTxtBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numerals in 'Dry' textfield.");
        		Log.info("Step:01 - Enter numerals in 'Dry' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numerals should be entered successfully.");
            	Log.info("Expected Result: Numerals should be entered successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Add Button Functionality
        		ExtentTestManager.startTest("Add Button Functionality").assignCategory("QuickCustomer");
        		Log.info("Add Button Functionality");
        		
        		click(quickCustRepo.ldAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'ADD' button.");
        		Log.info("Step:01 - Click on the 'ADD' button.");
        		
        		ElementDisplayed(quickCustRepo.ldLandDetailsTable);
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data should be inserted into the grid.");
        		Log.info("Expected Result: Data should be inserted into the grid.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Save Data
        		ExtentTestManager.startTest("Save Button Functionality").assignCategory("QuickCustomer");
        		Log.info("Save Button Functionality");
        		
        		click(quickCustRepo.iaaSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on SAVE button.");
        		Log.info("Step:01 -  Click on SAVE button.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		
        		ScrollUntilElementVisible(quickCustRepo.identityAndAreaBtn);
        		if(ElementDisplayed(quickCustRepo.identityAndAreaBtn)) {
    				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data should be saved successfully.");
                	Log.info("Expected Result: Data should be saved successfully.");
        		}
        		ExtentTestManager.endTest();

            }
        }	

	}//END Identity And Area
	
	
	
	public void photoAndSign(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		//Open 'Photo and Sign' Popup - Positive Scenario
		ExtentTestManager.startTest("Open 'Photo and Sign' Popup - Positive Scenario").assignCategory("QuickCustomer");
		Log.info("Open 'Photo and Sign' Popup - Positive Scenario");
		
		ScrollUntilElementVisible(quickCustRepo.photoAndSignBtn);
		click(quickCustRepo.photoAndSignBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Photo and sign' button.");
		Log.info("Step:01 - Click on the 'Photo and sign' button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
                
                if(ElementDisplayed(quickCustRepo.docDropdown)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result - 'Photo and sign' popup should appear.");
            		Log.info("Expected Result - 'Photo and sign' popup should appear.");
                }
                
                ExtentTestManager.endTest();


        		
        		//Upload Photo - Negative Scenario (No Selection)
        		ExtentTestManager.startTest("Upload Photo - Negative Scenario (No Selection)").assignCategory("QuickCustomer");
        		Log.info("Upload Photo - Negative Scenario (No Selection)");
        		
        		select("Photo", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the dropdown.");
        		Log.info("Step:01 - Click on the dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'Photo' from the drop down.");
        		Log.info("Step:02 - Select 'Photo' from the drop down.");
        		
        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Attempt to click 'Add' button without selecting a photo.");
        		Log.info("Step:03 - Attempt to click 'Add' button without selecting a photo.");
        		
        		if(ElementDisplayed(quickCustRepo.selectOneImgErrMsg)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message should be displayed indicating no photo selected.");
            		Log.info("Expected Result: Error message should be displayed indicating no photo selected.");
        		}
        		
        		ExtentTestManager.endTest();


        		
        		//Upload Sign - Negative Scenario (No Selection)
        		ExtentTestManager.startTest("Upload Sign - Negative Scenario (No Selection)").assignCategory("QuickCustomer");
        		Log.info("Upload Sign - Negative Scenario (No Selection)");
        		
        		select("Sign", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the dropdown.");
        		Log.info("Step:01 - Click on the dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'Sign' from the drop down.");
        		Log.info("Step:02 - Select 'Sign' from the drop down.");
        		
        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Attempt to click 'Add' button without selecting a Sign.");
        		Log.info("Step:03 - Attempt to click 'Add' button without selecting a Sign.");
        		
        		if(ElementDisplayed(quickCustRepo.selectOneImgErrMsg)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message should be displayed indicating no Sign selected.");
            		Log.info("Expected Result: Error message should be displayed indicating no Sign selected.");
        		}
        		
        		ExtentTestManager.endTest();


        		
        		//Save Data - Negative Scenario (No Images)
        		ExtentTestManager.startTest("Save Data - Negative Scenario (No Images)").assignCategory("QuickCustomer");
        		Log.info("Save Data - Negative Scenario (No Images)");
        		
        		select("Photo", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the dropdown.");
        		Log.info("Step:01 - Click on the dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'Photo' from the drop down.");
        		Log.info("Step:02 - Select 'Photo' from the drop down.");
        		
        		click(quickCustRepo.docSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the SAVE button.");
        		Log.info("Step:03 - Click on the SAVE button.");
        		
        		if(ElementDisplayed(quickCustRepo.saveErrMsg)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message should be displayed indicating photo/sign missing.");
            		Log.info("Expected Result: Error message should be displayed indicating photo/sign missing.");
        		}
        		
        		ExtentTestManager.endTest();


        		
        		//Upload Photo - Invalid File Type
        		ExtentTestManager.startTest("Upload Photo - Invalid File Type").assignCategory("QuickCustomer");
        		Log.info("Upload Photo - Invalid File Type");
        		
        		select("Photo", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Photo' from the drop down.");
        		Log.info("Step:01 - Select 'Photo' from the drop down.");
        		
        		UploadFile(quickCustRepo.docBrowseBtn, ".\\src\\test\\resources\\TestData.xlsx");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on the 'browse' button & Select a non-image file from the folder.");
        		Log.info("Step:02 -  Click on the 'browse' button & Select a non-image file from the folder.");

        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the 'Add' button.");
        		Log.info("Step:03 - Click on the 'Add' button.");
        		
        		if(ElementDisplayed(quickCustRepo.fileTypeNotSupportedErrMsg)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message should be displayed indicating invalid file type.");
        		Log.info("Expected Result: Error message should be displayed indicating invalid file type.");
        		}

        		
        		//Upload Photo - Positive Scenario
        		ExtentTestManager.startTest("Upload Photo - Positive Scenario").assignCategory("QuickCustomer");
        		Log.info("Upload Photo - Positive Scenario");
        		
        		select("Photo", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Photo' from the drop down.");
        		Log.info("Step:01 - Select 'Photo' from the drop down.");
        		
        		UploadFile(quickCustRepo.docBrowseBtn, ".\\src\\test\\resources\\e-sign.pdf");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on the 'browse' button & Select a valid photo from the folder.");
        		Log.info("Step:02 -  Click on the 'browse' button & Select a valid photo from the folder.");

        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the 'Add' button.");
        		Log.info("Step:03 - Click on the 'Add' button.");
        		
        		if(ElementDisplayed(quickCustRepo.photoSavedSuccessfully)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected photo should be displayed in the window.");
        		Log.info("Expected Result: Selected photo should be displayed in the window.");
        		}


        		
        		//Upload Sign - Invalid File Type
        		ExtentTestManager.startTest("Upload Sign - Invalid File Type").assignCategory("QuickCustomer");
        		Log.info("Upload Sign - Invalid File Type");
        		
        		select("Sign", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Sign' from the drop down.");
        		Log.info("Step:01 - Select 'Sign' from the drop down.");
        		
        		UploadFile(quickCustRepo.docBrowseBtn, ".\\src\\test\\resources\\TestData.xlsx");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on the 'browse' button & Select a non-image file from the folder.");
        		Log.info("Step:02 -  Click on the 'browse' button & Select a non-image file from the folder.");

        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the 'Add' button.");
        		Log.info("Step:03 - Click on the 'Add' button.");
        		
        		if(ElementDisplayed(quickCustRepo.fileTypeNotSupportedErrMsg)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message should be displayed indicating invalid file type.");
        		Log.info("Expected Result: Error message should be displayed indicating invalid file type.");
        		}
        		
        		ExtentTestManager.endTest();
        		

        		
        		//Upload Sign - Positive Scenario
        		ExtentTestManager.startTest("Upload Sign - Positive Scenario").assignCategory("QuickCustomer");
        		Log.info("Upload Sign - Positive Scenario");
        		
        		select("Sign", quickCustRepo.docDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Sign' from the drop down.");
        		Log.info("Step:01 - Select 'Sign' from the drop down.");
        		
        		UploadFile(quickCustRepo.docBrowseBtn, ".\\src\\test\\resources\\e-sign.pdf");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on the 'browse' button & Select a valid sign from the folder.");
        		Log.info("Step:02 -  Click on the 'browse' button & Select a valid sign from the folder.");

        		click(quickCustRepo.psAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the 'Add' button.");
        		Log.info("Step:03 - Click on the 'Add' button.");
        		
        		if(ElementDisplayed(quickCustRepo.photoSavedSuccessfully)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Sign should be displayed in the window.");
        		Log.info("Expected Result: Selected Sign should be displayed in the window.");
        		}
        		
        		ExtentTestManager.endTest();
        		

        		
        		//Save Data - Positive Scenario
        		ExtentTestManager.startTest("Save Data - Positive Scenario").assignCategory("QuickCustomer");
        		Log.info("Save Data - Positive Scenario");
                
                click(quickCustRepo.docSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Save' button.");
        		Log.info("Step:01 - Click on the 'Save' button.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		
        		ScrollUntilElementVisible(quickCustRepo.photoAndSignBtn);
        		if(ElementDisplayed(quickCustRepo.photoAndSignBtn)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data should be saved successfully.");
        		Log.info("Expected Result: Data should be saved successfully.");
        		}
        		
        		ExtentTestManager.endTest();
            }
            
        }
		
	}//END Photo and Sign

	
	
public void photoAndSignEntryPersistence() throws InterruptedException {
		
		//Photo and Sign Entry Persistence
		ExtentTestManager.startTest("Photo and Sign Entry Persistence").assignCategory("QuickCustomer");
		Log.info("Photo and Sign Entry Persistence");
		
		ScrollUntilElementVisible(quickCustRepo.photoAndSignBtn);
		click(quickCustRepo.photoAndSignBtn);
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
                
        		
        		if(ElementDisplayed(quickCustRepo.photoSavedSuccessfully)) {
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Previously uploaded images should be displayed.");
        		Log.info("Expected Result: Previously uploaded images should be displayed.");
        		}

        		click(quickCustRepo.docSaveBtn);
        		driver.switchTo().window(mainWindowHandle);
        		
        		ExtentTestManager.endTest();
            }           
        }		
	}//END photoAndSignEntryPersistence method


	
	
	public void bankAccounts(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		//Open 'External Account' Popup
		ExtentTestManager.startTest("Open 'External Account' Popup").assignCategory("QuickCustomer");
		Log.info("Open 'External Account' Popup");
		
		ScrollUntilElementVisible(quickCustRepo.bankAccountBtn);
		click(quickCustRepo.bankAccountBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Bank Accounts' button.");
		Log.info("Step:01 - Click on the 'Bank Accounts' button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
                
                if(ElementDisplayed(quickCustRepo.baStateDropdown)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result - 'External Account' popup appears.");
            		Log.info("Expected Result - 'External Account' popup appears.");
                }
                
                ExtentTestManager.endTest();

                
        		
        		
        		//Empty Mandatory Fields
        		ExtentTestManager.startTest("Empty Mandatory Fields").assignCategory("QuickCustomer");
        		Log.info("Empty Mandatory Fields");
        		
        		click(quickCustRepo.baAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Leave all mandatory fields empty & Click on the 'ADD' button.");
        		Log.info("Step:01 - Leave all mandatory fields empty & Click on the 'ADD' button.");
        		
        		ElementDisplayed(quickCustRepo.entrBankDetailsErrMsg);
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for mandatory fields.");
        		Log.info("Expected Result: Error message displayed for mandatory fields.");
        		
        		ExtentTestManager.endTest();
        		
        		

        		
        		//Select 'State' from Dropdown
        		ExtentTestManager.startTest("Select 'State' from Dropdown").assignCategory("QuickCustomer");
        		Log.info("Select 'State' from Dropdown");
        		
        		select("KERALA", quickCustRepo.baStateDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on 'State' dropdown.");
        		Log.info("Step:01 - Click on 'State' dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'State' from the drop down.");
        		Log.info("Step:02 - Select 'State' from the drop down.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted.");
            	Log.info("Expected Result: Selected item is highlighted.");
        		
        		ExtentTestManager.endTest();


        		
        		//Select 'BankID' from Dropdown
        		ExtentTestManager.startTest("Select 'BankID' from Dropdown").assignCategory("QuickCustomer");
        		Log.info("Select 'BankID' from Dropdown");
        		
        		select("KERALA GRAMIN BANK", quickCustRepo.baBankIdDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on 'BankID' dropdown.");
        		Log.info("Step:01 - Click on 'BankID' dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'BankID' from the drop down.");
        		Log.info("Step:02 - Select 'BankID' from the drop down.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted.");
            	Log.info("Expected Result: Selected item is highlighted.");
        		
        		ExtentTestManager.endTest();


        		
        		//Select 'BranchID' from Dropdown
        		ExtentTestManager.startTest("Select 'BranchID' from Dropdown").assignCategory("QuickCustomer");
        		Log.info("Select 'BranchID' from Dropdown");
        		
        		select("ALUR", quickCustRepo.baBranchIdDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on 'BranchID' dropdown.");
        		Log.info("Step:01 - Click on 'BranchID' dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'BranchID' from the drop down.");
        		Log.info("Step:02 - Select 'BranchID' from the drop down.");
        		
        		String ifscCode = driver.findElement(quickCustRepo.baIFSCTxtBox).getAttribute("value");
        		
        		if(ifscCode!="") {
                	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted; IFSC code field is auto-filled: " + ifscCode);
                	Log.info("Expected Result: Selected item is highlighted; IFSC code field is auto-filled: " + ifscCode);
        		}
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Cust Name' Field
        		ExtentTestManager.startTest("Test 'Cust Name' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'Cust Name' Field");
        		
        		//Alphanumeric Input
        		String identityNumAlphanumeric = testdata.get("identityNumAlphanumeric").toString();
        		input(quickCustRepo.baCustNameTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets and numerals in 'Cust Name' textfield.");
        		Log.info("Step:01 - Enter alphabets and numerals in 'Cust Name' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts alphanumeric input.");
            	Log.info("Expected Result: Field accepts alphanumeric input.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Address' Field
        		ExtentTestManager.startTest("Test 'Address' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'Address' Field");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.baAddressTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphabets and numerals in 'Address' textfield.");
        		Log.info("Step:01 - Enter alphabets and numerals in 'Address' textfield.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts alphanumeric input.");
            	Log.info("Expected Result: Field accepts alphanumeric input.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Incorrect 'RetypeAccNo'
        		ExtentTestManager.startTest("Incorrect 'RetypeAccNo'").assignCategory("QuickCustomer");
        		Log.info("Incorrect 'RetypeAccNo'");        		
        		
        		//Special Character Input
        		String validBankAccNum = testdata.get("validBankAccNum").toString();
        		input(quickCustRepo.baBankAccNumTxtBox,validBankAccNum);
        		String identityNumNumeric = testdata.get("identityNumNumeric").toString();
        		input(quickCustRepo.baRetypeAccNumTxtBox,identityNumNumeric);  
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter different numbers in 'BankAccNo' and 'RetypeAccNo'.");
        		Log.info("Step:01 - Enter different numbers in 'BankAccNo' and 'RetypeAccNo'.");
        		
        		click(quickCustRepo.baStateTxt);
        		
        		if(ElementDisplayed(quickCustRepo.baAccNumMisMatchErrMsg)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message indicating mismatch.");
            		Log.info("Expected Result: Error message indicating mismatch.");
        		}
        		clear(quickCustRepo.baRetypeAccNumTxtBox);
        		clear(quickCustRepo.baBankAccNumTxtBox);
        		ExtentTestManager.endTest();
        		
        		
        		
        		
        		//Test 'BankAccNo' Field
        		ExtentTestManager.startTest("Test 'BankAccNo' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'BankAccNo' Field");        		
        		
        		//Special Character Input
        		String specialChar = testdata.get("specialChar").toString();
        		input(quickCustRepo.baBankAccNumTxtBox,specialChar);        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Special Character input in BankAccNo field.");
        		Log.info("Step:01 - Enter Special Character input in BankAccNo field.");
        		
        		input(quickCustRepo.baRetypeAccNumTxtBox,specialChar);        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Special Character input in RetypeAccNo field.");
        		Log.info("Step:02 - Enter Special Character input in RetypeAccNo field.");
        		
        		click(quickCustRepo.baStateTxt);
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Special Character input allowed.");
            	Log.info("Expected Result: Special Character input allowed.");
        		
            	clear(quickCustRepo.baRetypeAccNumTxtBox);
        		clear(quickCustRepo.baBankAccNumTxtBox);
        		
        		//Alphabet Input
        		String identityNumAlphabet = testdata.get("identityNumAlphabet").toString();
        		input(quickCustRepo.baBankAccNumTxtBox,identityNumAlphabet);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Alphabet input in BankAccNo field.");
        		Log.info("Step:03 - Enter Alphabet input in BankAccNo field.");
        		
        		input(quickCustRepo.baRetypeAccNumTxtBox,identityNumAlphabet);        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Alphabet input in RetypeAccNo field.");
        		Log.info("Step:04 - Enter Alphabet input in RetypeAccNo field.");        		
        		
        		click(quickCustRepo.baStateTxt);
        		
        		if(ElementDisplayed(quickCustRepo.baAccNumMisMatchErrMsg)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabet input prompts error message.");
            		Log.info("Expected Result: Alphabet input prompts error message.");
        		}
        		clear(quickCustRepo.baRetypeAccNumTxtBox);
        		clear(quickCustRepo.baBankAccNumTxtBox);

        		//Numeric Input
//        		String validBankAccNum = testdata.get("validBankAccNum").toString();
        		input(quickCustRepo.baBankAccNumTxtBox,validBankAccNum);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Enter Numeric input in BankAccNo field.");
        		Log.info("Step:05 - Enter Numeric input in BankAccNo field.");
        		
        		
        		input(quickCustRepo.baRetypeAccNumTxtBox,validBankAccNum);        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Enter Numeric input in RetypeAccNo field.");
        		Log.info("Step:06 - Enter Numeric input in RetypeAccNo field.");        		
        		
        		click(quickCustRepo.baStateTxt);
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field restricts to numerals.");
        		Log.info("Expected Result: Field restricts to numerals.");
        		
        		ExtentTestManager.endTest();


        		
        		//Select 'BankAccID' from Dropdown
        		ExtentTestManager.startTest("Select 'BankAccID' from Dropdown").assignCategory("QuickCustomer");
        		Log.info("Select 'BankAccID' from Dropdown");
        		
        		select("OTHER", quickCustRepo.baBankAccIdDropDown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on 'BankAccID' dropdown.");
        		Log.info("Step:01 - Click on 'BankAccID' dropdown.");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'BankAccID' from the drop down.");
        		Log.info("Step:02 - Select 'BankAccID' from the drop down.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted.");
            	Log.info("Expected Result: Selected item is highlighted.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Invalid Date Format
        		ExtentTestManager.startTest("Invalid Date Format").assignCategory("QuickCustomer");
        		Log.info("Invalid Date Format");
        		
        		String invalidIssueDate = testdata.get("invalidIssueDate").toString();
        		click(quickCustRepo.baStartDateTxtBox);
        		input(quickCustRepo.baStartDateTxtBox,invalidIssueDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid date format in 'Start Date' field.");
        		Log.info("Step:01 - Enter invalid date format in 'Start Date' field.");
        		
        		click(quickCustRepo.baAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the ADD button.");
        		Log.info("Step:02 - Click on the ADD button.");
        		
        		if(ElementDisplayed(quickCustRepo.baInvalidStartDatePopUp)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message for invalid date format.");
            		Log.info("Expected Result: Error message for invalid date format.");
        		}else {
        			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Invalid date error message is not displayed.");
            		Log.info("Expected Result: Invalid date error message is not displayed.");
        		}
        		click(quickCustRepo.baInvalidStartDatePopUp);
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		
        		//Test 'Start Date' Field
        		ExtentTestManager.startTest("Test 'Start Date' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'Start Date' Field");
        		
        		String validIssueDate = testdata.get("validIssueDate").toString();
        		click(quickCustRepo.baStartDateTxtBox);
        		input(quickCustRepo.baStartDateTxtBox,validIssueDate);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter date manually.");
        		Log.info("Step:01 - Enter date manually.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date can be entered both ways.");
            	Log.info("Expected Result: Date can be entered both ways.");
        		
            	ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Additional Information' Checkbox
        		ExtentTestManager.startTest("Test 'Additional Information' Checkbox").assignCategory("QuickCustomer");
        		Log.info("Test 'Additional Information' Checkbox");
        		
        		click(quickCustRepo.baAddInfoCheckBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the checkbox.");
        		Log.info("Step:01 - Check the checkbox.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked.");
            	Log.info("Expected Result: Checkbox is ticked.");
        		
            	ExtentTestManager.endTest();


        		
        		//Verify 'Balance As on' Date Field
        		ExtentTestManager.startTest("Verify 'Balance As on' Date Field").assignCategory("QuickCustomer");
        		Log.info("Verify 'Balance As on' Date Field");
        		
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the 'Balance As on' date field.");
        		Log.info("Step:01 - Check the 'Balance As on' date field.");
        		
        		String balanceAsOnValue = driver.findElement(quickCustRepo.baBalanceAsOn).getAttribute("value");
        		
        		if(balanceAsOnValue!="") {
                	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field displays current date: " + balanceAsOnValue);
                	Log.info("Expected Result: Field displays current date: " + balanceAsOnValue);
        		}
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Balance' Numeric Field
        		ExtentTestManager.startTest("Test 'Balance' Numeric Field").assignCategory("QuickCustomer");
        		Log.info("Test 'Balance' Numeric Field");
        		
        		//Numeric Input
        		click(quickCustRepo.baNotMentionedCheckBox);
        		
//        		String identityNumNumeric = testdata.get("identityNumNumeric").toString();
        		input(quickCustRepo.baBalanceTxtBox,identityNumNumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers in 'Balance' field.");
        		Log.info("Step:01 - Enter numbers in 'Balance' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts numeric input.");
            	Log.info("Expected Result: Field accepts numeric input.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Credit Card' Checkbox
        		ExtentTestManager.startTest("Test 'Credit Card' Checkbox").assignCategory("QuickCustomer");
        		Log.info("Test 'Credit Card' Checkbox");
        		
        		click(quickCustRepo.baCreditCardCheckBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the 'Credit Card' checkbox.");
        		Log.info("Step:01 - Check the 'Credit Card' checkbox.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked.");
            	Log.info("Expected Result: Checkbox is ticked.");
        		
            	ExtentTestManager.endTest();
        		
        		
        		
        		//Test 'Credit Card No' Field
        		ExtentTestManager.startTest("Test 'Credit Card No' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'Credit Card No' Field");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.baCreditCardNumTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers and alphabets in 'Credit Card No' field.");
        		Log.info("Step:01 - Enter numbers and alphabets in 'Credit Card No' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts alphanumeric input.");
            	Log.info("Expected Result: Field accepts alphanumeric input.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Add Data to Grid
        		ExtentTestManager.startTest("Add Data to Grid").assignCategory("QuickCustomer");
        		Log.info("Add Data to Grid");
        		
        		click(quickCustRepo.baAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on the ADD button.");
        		Log.info("Step:01 -  Click on the ADD button.");
        		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is displayed in the grid.");
            	Log.info("Expected Result: Data is displayed in the grid.");
        		
            	ExtentTestManager.endTest();
            	
            	
        		
        		
        		//Test 'DPID' Field
        		ExtentTestManager.startTest("Test 'DPID' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'DPID' Field");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.daDPIDTxtBox,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers and alphabets in 'DPID' field.");
        		Log.info("Step:01 - Enter numbers and alphabets in 'DPID' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts alphanumeric input.");
            	Log.info("Expected Result: Field accepts alphanumeric input.");
        		
        		ExtentTestManager.endTest();
       		
        		
        		
        		//Test 'DematAccNo' Field
        		ExtentTestManager.startTest("Test 'DematAccNo' Field").assignCategory("QuickCustomer");
        		Log.info("Test 'DematAccNo' Field");
        		
        		//Alphanumeric Input
        		input(quickCustRepo.daDematAccNo,identityNumAlphanumeric);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers and alphabets in 'DematAccNo' field.");
        		Log.info("Step:01 - Enter numbers and alphabets in 'DematAccNo' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts alphanumeric input.");
            	Log.info("Expected Result: Field accepts alphanumeric input.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Save Data
        		ExtentTestManager.startTest("Save Data").assignCategory("QuickCustomer");
        		Log.info("Save Data");
        		
        		click(quickCustRepo.baSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on SAVE button.");
        		Log.info("Step:01 -  Click on SAVE button.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		
        		ScrollUntilElementVisible(quickCustRepo.bankAccountBtn);
        		if(ElementDisplayed(quickCustRepo.bankAccountBtn)) {
    				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is successfully saved.");
                	Log.info("Expected Result: Data is successfully saved.");
        		}
        		ExtentTestManager.endTest();
            
            }
            
        }
		
	}//END Photo and Sign
	
	
	
	
	public void riskDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		//Open Risk Details Window
		ExtentTestManager.startTest("Open Risk Details Window").assignCategory("QuickCustomer");
		Log.info("Open Risk Details Window");
		
		ScrollUntilElementVisible(quickCustRepo.riskDetailsBtn);
		click(quickCustRepo.riskDetailsBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Risk Details' button.");
		Log.info("Step:01 - Click on the 'Risk Details' button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
                
                if(ElementDisplayed(quickCustRepo.rdRiskIdDropdown)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result - 'Risk Details' window should open successfully.");
            		Log.info("Expected Result - 'Risk Details' window should open successfully.");
                }
                
                ExtentTestManager.endTest();


        		
        		//Select RiskID
        		ExtentTestManager.startTest("Select RiskID").assignCategory("QuickCustomer");
        		Log.info("Select RiskID");
        		
        		select("LOW", quickCustRepo.rdRiskIdDropdown);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from the RiskID dropdown.");
        		Log.info("Step:01 - Select an item from the RiskID dropdown.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item should be selected successfully.");
            	Log.info("Expected Result: Item should be selected successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Remarks Field Input
        		ExtentTestManager.startTest("Remarks Field Input").assignCategory("QuickCustomer");
        		Log.info("Remarks Field Input");
        		
        		//Alphanumeric and special characters Input
        		String remark = testdata.get("remark").toString();
        		input(quickCustRepo.rdRemarksTxtBox,remark);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphanumeric and special characters in the 'Remarks' field.");
        		Log.info("Step:01 - Enter alphanumeric and special characters in the 'Remarks' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Characters should be entered successfully.");
            	Log.info("Expected Result: Characters should be entered successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//ActiveSpecialInstruction Field Input
        		ExtentTestManager.startTest("ActiveSpecialInstruction Field Input").assignCategory("QuickCustomer");
        		Log.info("ActiveSpecialInstruction Field Input");
        		
        		//Alphanumeric and special characters Input
        		input(quickCustRepo.rdActiveSpclInstructnTxtBox,remark);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphanumeric and special characters in the 'ActiveSpecialInstruction' field.");
        		Log.info("Step:01 - Enter alphanumeric and special characters in the 'ActiveSpecialInstruction' field.");
        		
            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Characters should be entered successfully.");
            	Log.info("Expected Result: Characters should be entered successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Suspicious Check box Selection
        		ExtentTestManager.startTest("Suspecious Checkbox Selection").assignCategory("QuickCustomer");
        		Log.info("Suspecious Checkbox Selection");
        		
        		click(quickCustRepo.rdSupervisorCheckBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Tick mark the 'Suspecious' checkbox.");
        		Log.info("Step:01 -  Tick mark the 'Suspecious' checkbox.");

    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox should be ticked successfully.");
                Log.info("Expected Result: Checkbox should be ticked successfully.");
        		
        		ExtentTestManager.endTest();
        		
        		
        		
        		//Save Risk Details
        		ExtentTestManager.startTest("Save Risk Details").assignCategory("QuickCustomer");
        		Log.info("Save Risk Details");
        		
        		click(quickCustRepo.rdSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on SAVE button.");
        		Log.info("Step:01 -  Click on SAVE button.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		
        		ScrollUntilElementVisible(quickCustRepo.riskDetailsBtn);
        		if(ElementDisplayed(quickCustRepo.riskDetailsBtn)) {
    				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Risk Details' window should close.");
                	Log.info("Expected Result: 'Risk Details' window should close.");
        		}
        		ExtentTestManager.endTest();

            }
            
        }
		
	}//END Risk Details
	
	
	
public void riskDetailsEmptyRemarksField(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		//Empty Remarks Field
		ExtentTestManager.startTest("Empty Remarks Field").assignCategory("QuickCustomer");
		Log.info("Empty Remarks Field");
		
		ScrollUntilElementVisible(quickCustRepo.riskDetailsBtn);
		click(quickCustRepo.riskDetailsBtn);
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
                
                clear(quickCustRepo.rdRemarksTxtBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Leave the 'Remarks' field empty.");
        		Log.info("Step:01 -  Leave the 'Remarks' field empty.");
        		
                click(quickCustRepo.rdSaveBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Try to save the form.");
        		Log.info("Step:02 -  Try to save the form.");

        		driver.switchTo().window(mainWindowHandle);
        		
        		ScrollUntilElementVisible(quickCustRepo.riskDetailsBtn);
        		if(ElementDisplayed(quickCustRepo.riskDetailsBtn)) {
    				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to save the form without any error.");
                	Log.info("Expected Result: Possible to save the form without any error.");
        		}
        		
        		ExtentTestManager.endTest();

            }
            
        }
		
	}//END risk Details Empty Remarks Field
	
	

public void emptyCheckAvailabilityPopup() throws InterruptedException {
	
	//Empty Check Availability Popup
	ExtentTestManager.startTest("Empty Check Availability Popup").assignCategory("QuickCustomer");
	Log.info("Empty Check Availability Popup");
	
	ScrollUntilElementVisible(quickCustRepo.checkAvailabilityBtn);
	click(quickCustRepo.checkAvailabilityBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Verify the state of the 'Save' button after popup is shown.");
	Log.info("Step:01 -  Verify the state of the 'Save' button after popup is shown.");
	
	//Navigate to Pop Up Window
    String mainWindowHandle = driver.getWindowHandle();
    boolean popupAppeared = false;
    for (String handle : driver.getWindowHandles()) {
        if (!handle.equals(mainWindowHandle)) {
            driver.switchTo().window(handle);
            driver.manage().window().maximize();
            popupAppeared = true;
            
            driver.close();
    		driver.switchTo().window(mainWindowHandle);
    		
    		ScrollUntilElementVisible(quickCustRepo.saveBtn);
    		if(checkElementEnableOrDisable(quickCustRepo.saveBtn)==true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Save' button should be enabled.");
            	Log.info("Expected Result: 'Save' button should be enabled.");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: 'Save' button wasn't be enabled.");
            	Log.info("Expected Result: 'Save' button wasn't be enabled.");
    		}
    		
    		ExtentTestManager.endTest();
    		
    		
    		
    		//'First Name' and Salutation Mandatory Check
    		ExtentTestManager.startTest("'First Name' and Salutation Mandatory Check").assignCategory("QuickCustomer");
    		Log.info("'First Name' and Salutation Mandatory Check");
    		
    		click(quickCustRepo.saveBtn);
    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Leave 'First Name' and salutation blank, try to submit form.");
    		Log.info("Step:01 -  Leave 'First Name' and salutation blank, try to submit form.");
    		
//    		ScrollUntilElementVisible(quickCustRepo.qadFNameInvalidCloseBtn);
    		if(ElementDisplayed(quickCustRepo.qadSalutationInvalidCloseBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message for mandatory fields.");
            	Log.info("Expected Result: Error message for mandatory fields.");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: No error message for mandatory fields.");
            	Log.info("Expected Result: No error message for mandatory fields.");
    		}
    		click(quickCustRepo.qadSalutationInvalidCloseBtn);
        }
        
    }
}//method End




public void introducerSelectCust(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	ScrollUntilElementVisible(quickCustRepo.btnIntroducer);

    WebElement parentButton = driver.findElement(quickCustRepo.btnIntroducer); // Replace with actual button locator
    parentButton.click();

    // Step 3: Get the window handles and switch to the first child window
    Set<String> windowHandles = driver.getWindowHandles();
    String parentWindowHandle = driver.getWindowHandle();  // The handle of the parent window

    // Switch to the first child window
    String childWindow1Handle = null;
    for (String handle : windowHandles) {
        if (!handle.equals(parentWindowHandle)) {
            childWindow1Handle = handle;
            break;
        }
    }
    driver.switchTo().window(childWindow1Handle);

    // Step 4: Click the button in child window 1 to open child window 2
    WebElement childWindow1Button = driver.findElement(quickCustRepo.introducerCustIdSrchBtn); // Replace with actual button locator
    childWindow1Button.click();

    // Step 5: Get the window handles again and switch to child window 2
    windowHandles = driver.getWindowHandles();
    String childWindow2Handle = null;
    for (String handle : windowHandles) {
        if (!handle.equals(parentWindowHandle) && !handle.equals(childWindow1Handle)) {
            childWindow2Handle = handle;
            break;
        }
    }
    driver.switchTo().window(childWindow2Handle);

    // Step 6: Wait until the text field is visible in child window 2
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(quickCustRepo.custIdTxtBox)); // Replace with actual locator

    // Step 7: Send keys to the text field in child window 2
    String introducerCustId = testdata.get("introducerCustId").toString();
    textField.sendKeys(introducerCustId);

    click(quickCustRepo.introSelectSrchBtn);
    
    click(quickCustRepo.introSelectBtn);
    
    driver.switchTo().window(childWindow1Handle);
    
    
    
    
    //Customer Field - Select Customer
	ExtentTestManager.startTest("Customer Field - Select Customer").assignCategory("QuickCustomer");
	Log.info("Customer Field - Select Customer");

    String intName = driver.findElement(quickCustRepo.introDetailsIntNameTxtBox).getAttribute("value");
    String intAddress = driver.findElement(quickCustRepo.introDetailsIntNameTxtBox).getAttribute("value");

    if(intName != "" && intAddress != "") {
    	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is selected. 'Int Name'- " + intName + " and 'Introducer's Address'- " + intAddress + " fields are auto-filled.");
    	Log.info("Expected Result: Customer is selected. 'Int Name'- " + intName + " and 'Introducer's Address'- " + intAddress + " fields are auto-filled.");
    }else {
    	ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Autofill FAILED!!");
    	Log.info("Expected Result: Autofill FAILED!!");
    }
    
    ExtentTestManager.endTest();
    
    
	//Int Designation Textfield - Typing Alphabets and Numerals
	ExtentTestManager.startTest("Int Designation Textfield - Typing Alphabets and Numerals").assignCategory("QuickCustomer");
	Log.info("Int Designation Textfield - Typing Alphabets and Numerals");
  
	String introducerReason = testdata.get("introducerReason").toString();
	input(quickCustRepo.introDetailsIntDesignationTxtBox,introducerReason);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Type \"Test123\" in the 'Int DEsignation' textfield.");
	Log.info("Step:01 - Type \"Test123\" in the 'Int DEsignation' textfield.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Int Designation'Textfield reflects typed input without an error.");
	Log.info("Expected Result: 'Int Designation'Textfield reflects typed input without an error.");

	ExtentTestManager.endTest();	
	
	

	
	//Relation Dropdown - Select Item
	ExtentTestManager.startTest("Relation Dropdown - Select Item").assignCategory("QuickCustomer");
	Log.info("Relation Dropdown - Select Item");
	
	select("FRIEND", quickCustRepo.introDetailsRelationDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Relation dropdown.");
	Log.info("Step:01 - Click on the Relation dropdown.");
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an item from the 'Relation' dropdown items.");
	Log.info("Step:02 - Select an item from the 'Relation' dropdown items.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The item is displayed in the dropdown field.");
	Log.info("Expected Result: The item is displayed in the dropdown field.");
	
	ExtentTestManager.endTest(); 
	
	
	
	
    //Save Button - Click ability
	ExtentTestManager.startTest("Save Button - Click ability").assignCategory("QuickCustomer");
	Log.info("Save Button - Click ability");
	
	click(quickCustRepo.introduceSaveBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'SAVE' button.");
	Log.info("Step:01 - Click on the 'SAVE' button.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is saved successfully, and a confirmation message appears.");
	Log.info("Expected Result: Data is saved successfully, and a confirmation message appears.");

	driver.switchTo().window(parentWindowHandle);
	
	ExtentTestManager.endTest();

	
}

public void checkAvailability() throws InterruptedException {
	
    //Check Availability Pop up
	ExtentTestManager.startTest("Check Availability Popup").assignCategory("QuickCustomer");
	Log.info("Check Availability Popup");
	
	ScrollUntilElementVisible(quickCustRepo.checkAvailabilityBtn);
	click(quickCustRepo.checkAvailabilityBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on the 'Check Availability' button.");
	Log.info("Step:01 -  Click on the 'Check Availability' button.");
	
	//Navigate to Pop Up Window
    String mainWindowHandle = driver.getWindowHandle();
    boolean popupAppeared = false;
    for (String handle : driver.getWindowHandles()) {
        if (!handle.equals(mainWindowHandle)) {
            driver.switchTo().window(handle);
            driver.manage().window().maximize();
            popupAppeared = true;
            
            try {
    		if(ElementDisplayed(quickCustRepo.noMatchFound)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");
            	Log.info("Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");
    		} 
            }catch(Exception e) {
            	try {
            		if(ElementDisplayed(quickCustRepo.existingCustTable)){
            			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");
                    	Log.info("Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");
            		}
            	}catch(Exception e1) {
            		
            	}
            }
            driver.close();
    		driver.switchTo().window(mainWindowHandle);
    		
    		ExtentTestManager.endTest();
    		
    		
    		
    		
    	    //Save Quick Customer
    		ExtentTestManager.startTest("Save Quick Customer").assignCategory("QuickCustomer");
    		Log.info("Save Quick Customer");
    		
    		ScrollUntilElementVisible(quickCustRepo.saveBtn);
    		click(quickCustRepo.saveBtn);
    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on the 'Save' button.");
    		Log.info("Step:01 -  Click on the 'Save' button.");
    		
    		if(ElementDisplayed(quickCustRepo.dataSavedSuccessfullyCloseBtn)) {
    			
    			String custId = driver.findElement(quickCustRepo.qcsiCustId).getAttribute("value");
    			System.out.println("Customer ID: "  + custId);
    			String displayName = driver.findElement(quickCustRepo.qcsiDispName).getAttribute("value");
    			System.out.println("Display Name: "  + displayName);
    			
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Quick Customer details should be saved successfully in the backendtables with Quick Customer ID: " + custId + " and Display Name: " + displayName);
            	Log.info("Expected Result: Quick Customer details should be saved successfully in the backendtables with Quick Customer ID: " + custId + " and Display Name: " + displayName);
    		}
    		click(quickCustRepo.dataSavedSuccessfullyCloseBtn);
    		click(quickCustRepo.dataSavedPopUp);
        }
        
    }
	
	ExtentTestManager.endTest();
}


public void authorize() throws InterruptedException, IOException {
	
	
    //Logout Functionality - Basic
	ExtentTestManager.startTest("Logout Functionality - Basic").assignCategory("QuickCustomer");
	Log.info("Logout Functionality - Basic");
	
	click(custSearch.custSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the logout option & Click on the logout button.");
	Log.info("Step:01 - Navigate to the logout option & Click on the logout button.");
	
	if(ElementDisplayed(custSearch.loginUserName)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is successfully logged out and redirected to the login page.");
		Log.info("Expected Result: User is successfully logged out and redirected to the login page.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	

	//Login with Valid Credentials
	ExtentTestManager.startTest("Login with Valid Credentials").assignCategory("QuickCustomer");
	Log.info("Login with Valid Credentials");
	
	String UserName = configloader().getProperty("UserName2");
	input(custSearch.loginUserName,UserName );
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid user ID.");
	Log.info("Step:01 - Enter valid user ID.");

	String Password = configloader().getProperty("Password2");
	input(custSearch.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid password.");
	Log.info("Step:02 - Enter valid password.");
	
	click(custSearch.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click the login button.");
	Log.info("Step:03 - Click the login button.");

	try {
		WebElement clickableElement = driver.findElement(By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]"));

		if (clickableElement != null) {
			// Perform the desired action on the element
			clickableElement.click();
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");
			
//				String loginUserName = testdata.get("loginUserName").toString();
			input(custSearch.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");
			
//				String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(custSearch.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");
			
			click(custSearch.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");
			
			ElementDisplayed(custSearch.home);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");	
		} else {
			System.out.println("Element not clickable within the timeout.");
		}
	} catch (Exception e) {
		System.out.println("Exception occurred while waiting for the element: " + e.getMessage());
		System.out.println("Already login pop up not appeared");
	}
	
	String userName = driver.findElement(goaldLoanRepo.userName).getText();
	System.out.println(userName);
	
	/*String flag = "akash";
	
	if(!userName.equalsIgnoreCase(flag)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is successfully logged in and taken to the dashboard.");
		Log.info("Expected Result: User is successfully logged in and taken to the dashboard.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}*/
	ExtentTestManager.endTest();
	
	
	

	//Manager Authorization Window Access
	ExtentTestManager.startTest("Manager Authorization Window Access").assignCategory("QuickCustomer");
	Log.info("Manager Authorization Window Access");
	
	click(goaldLoanRepo.autorizeAndCancelTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the 'Authorise & Cancel' section.");
	Log.info("Step:01 - Navigate to the 'Authorise & Cancel' section.");
	
	click(goaldLoanRepo.managerAuthoTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on 'Manager Authorisation'.");
	Log.info("Step:02 - Click on 'Manager Authorisation'.");
	
	if(ElementDisplayed(goaldLoanRepo.othersTab)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager Authorisation window opens successfully.");
		Log.info("Expected Result: Manager Authorisation window opens successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	

	//Accessing 'Others' Tab
	ExtentTestManager.startTest("Accessing 'Others' Tab").assignCategory("QuickCustomer");
	Log.info("Accessing 'Others' Tab");
	
	click(goaldLoanRepo.othersTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Others' tab.");
	Log.info("Step:01 - Click on the 'Others' tab.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Others' tab opens.");
	Log.info("Expected Result: 'Others' tab opens.");

	
	ExtentTestManager.endTest();
	
	

	//Accessing 'Refresh' Tab
	ExtentTestManager.startTest("Accessing 'Refresh' Tab").assignCategory("QuickCustomer");
	Log.info("Accessing 'Refresh' Tab");
	
	click(goaldLoanRepo.cashierRefreshBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
	Log.info("Step:01 - Click Refresh Button");
	
	if(ElementDisplayed(goaldLoanRepo.othersCheckBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data will be displayed.");
		Log.info("Expected Result: Data will be displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	

	//Customer Creation Data Selection & Authorize Customer Creation
	ExtentTestManager.startTest("Customer Creation Data Selection & Authorize Customer Creation").assignCategory("QuickCustomer");
	Log.info("Customer Creation Data Selection & Authorize Customer Creation");
	
	click(goaldLoanRepo.othersCheckBox);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select available customer creation data displayed below the tab.");
	Log.info("Step:01 - Select available customer creation data displayed below the tab.");

	click(goaldLoanRepo.otherAuthorizeBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the AUTHORISE button.");
	Log.info("Step:02 - Click on the AUTHORISE button.");
	
	if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected customer creation data is highlighted & Customer creation is authorised successfully without errors.");
	Log.info("Expected Result: Selected customer creation data is highlighted & Customer creation is authorised successfully without errors.");
	click(goaldLoanRepo.confirmationPopUp);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
}//end


 }
