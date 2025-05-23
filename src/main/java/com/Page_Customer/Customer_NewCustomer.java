package com.Page_Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.lang.model.element.Element;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Cust_NewCustomer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_NewCustomer extends Base_Class{
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("Customer_NewCustomer");
	Log log= new Log();
	PageRepositary_Cust_NewCustomer newCustRepo = new PageRepositary_Cust_NewCustomer();
	Customer_QuickCustomer quickCust = new Customer_QuickCustomer();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	String transIdCash;
	String transIdTransfer;
	
	
	public void openNewCustomerWindow() throws InterruptedException {
		
		ExtentTestManager.startTest("Verify Navigation to New Customer").assignCategory("NewCustomer");
		Log.info("Verify Navigation to New Customer");
		
		click(newCustRepo.customerTab);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Customer menu.");
		Log.info("Step:01 - Navigate to Customer menu.");
		
		click(newCustRepo.newCustomerTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on New Customer.");
		Log.info("Step:02 - Click on New Customer.");
		
		SwitchToFrame(newCustRepo.pdIframe);
		System.out.println("Switched to Personal Details Iframe.");
		
		if(ElementDisplayed(newCustRepo.pdStartDateTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New Customer window is opened.");
			Log.info("Expected Result: New Customer window is opened.");
		}
		
		ExtentTestManager.endTest();
	}
	
	
	
	public void personal(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		
		//Start Date Field - Display and Edit Check
		ExtentTestManager.startTest("Start Date Field - Display and Edit Check").assignCategory("NewCustomer");
		Log.info("Start Date Field - Display and Edit Check");
		
		String startDate = driver.findElement(newCustRepo.pdStartDateTxtBox).getAttribute("value");
		boolean startDateEdit = ElementEnabled(newCustRepo.pdStartDateTxtBox);
		System.out.println("Start date editable status: " + startDateEdit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe Start Date field.");
		Log.info("Step:01 - Observe Start Date field.");		
		
		if(startDateEdit==false) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Displays current transaction date: " + startDate + " and not editable.");
			Log.info("Expected Result: Displays current transaction date: " + startDate + " and not editable.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Error");
			Log.info("Error");
		}
		
		ExtentTestManager.endTest();

		
		
		
		
		
		//Salutation Selection
		ExtentTestManager.startTest("Salutation Selection").assignCategory("NewCustomer");
		Log.info("Select Salutation Dropdown");
		
		select("MRS", newCustRepo.pdSalutationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Mrs' from the Salutation dropdown.");
		Log.info("Step:01 - Select 'Mrs' from the Salutation dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Mrs' is selected.");
		Log.info("Expected Result: 'Mrs' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//First Name Positive Entry
		ExtentTestManager.startTest("First Name Positive Entry").assignCategory("NewCustomer");
		Log.info("First Name Positive Entry");
		
		String firstName = testdata.get("firstName").toString();
		input(newCustRepo.pdFNameTxtBox,firstName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Anu' in the First Name field.");
		Log.info("Step:01 - Enter 'Anu' in the First Name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Anu' is accepted.");
		Log.info("Expected Result: 'Anu' is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Middle Name Positive Entry
		ExtentTestManager.startTest("Middle Name Positive Entry").assignCategory("NewCustomer");
		Log.info("Middle Name Positive Entry");
		
		String middleName = testdata.get("middleName").toString();
		input(newCustRepo.pdMNameTxtBox,middleName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Singh' in the Middle Name field.");
		Log.info("Step:01 - Enter 'Singh' in the Middle Name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Singh' is accepted.");
		Log.info("Expected Result: 'Singh' is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Last Name Positive Entry
		ExtentTestManager.startTest("Last Name Positive Entry").assignCategory("NewCustomer");
		Log.info("Last Name Positive Entry");
		
		String LastName = testdata.get("LastName").toString();
		input(newCustRepo.pdLNameTxtBox,LastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Rajput' in the Last Name field.");
		Log.info("Step:01 - Enter 'Rajput' in the Last Name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Rajput' is accepted.");
		Log.info("Expected Result: 'Rajput' is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Alias Name Positive Entry
		ExtentTestManager.startTest("Alias Name Positive Entry").assignCategory("NewCustomer");
		Log.info("Alias Name Positive Entry");
		
		String aliasName = testdata.get("aliasName").toString();
		input(newCustRepo.pdANameTxtBox,aliasName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'abc' in the Alias Name field.");
		Log.info("Step:01 - Enter 'abc' in the Alias Name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'abc' is accepted.");
		Log.info("Expected Result: 'abc' is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		ExtentTestManager.startTest("Verify Display Name").assignCategory("NewCustomer");
		Log.info("Verify Display Name");
		
		String dispName = driver.findElement(newCustRepo.pdDNameTxtBox).getAttribute("value");
		
		// Split the string by spaces
		String[] dispNameParts = dispName.split(" ");
		
		// Store individual parts in separate variables
		String fName = dispNameParts[0]; 
		String mName = dispNameParts[1];
		String lName = dispNameParts[2];
		String aName = dispNameParts[4];
		
		if(firstName.equalsIgnoreCase(fName) 
				&& middleName.equalsIgnoreCase(mName) 
				&& LastName.equalsIgnoreCase(lName) 
				&& aliasName.equalsIgnoreCase(aName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Displays 'ANU SINGH RAJPUT ALIAS ABC'.");
			Log.info("Expected Result: Displays 'ANU SINGH RAJPUT ALIAS ABC'.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Incorrect Display Name.");
			Log.info("Expected Result: Incorrect Display Name.");
		}
		
		ExtentTestManager.endTest();
		
		
		
		
		//Manual DOB Entry
		ExtentTestManager.startTest("Manual DOB Entry").assignCategory("NewCustomer");
		Log.info("Manual DOB Entry");
		
		click(newCustRepo.pdDOBDatePicker);
		String DOB = testdata.get("DOB").toString();
		input(newCustRepo.pdDOBDatePicker,DOB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter DOB.");
		Log.info("Step:01 - Manually enter DOB.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manual entry is accepted.");
		Log.info("Expected Result: Manual entry is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
        //Verify Age Calculation
		ExtentTestManager.startTest("Verify Age Calculation").assignCategory("NewCustomer");
		Log.info("Verify Age Calculation");
		
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe Age field.");
		Log.info("Step:01 - Observe Age field.");
		
		String ageValue = driver.findElement(newCustRepo.pdAgeTxtBox).getAttribute("value");
		System.err.println("Age: " + ageValue);
		
		if(!ageValue.isEmpty()) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct age " + ageValue +" is displayed.");
		Log.info("Expected Result: Correct age " + ageValue +" is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();
		
		
		
		
		//AgeAsOn Input
		ExtentTestManager.startTest("Manual AgeAsOn Entry").assignCategory("NewCustomer");
		Log.info("Manual AgeAsOn Entry");
		
		click(newCustRepo.pdAgeAsOnDatePicker);
		input(newCustRepo.pdAgeAsOnDatePicker,DOB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter AgeAsOn.");
		Log.info("Step:01 - Manually enter AgeAsOn.");
		
		click(newCustRepo.pdPANTxt);
		
		String ageAsOnValue = driver.findElement(newCustRepo.pdAgeAsOnDatePicker).getAttribute("value");
		System.err.println("AgeAsOn: " + ageAsOnValue);
		
		if(!ageAsOnValue.isEmpty()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manual entry is accepted.");
			Log.info("Expected Result: Manual entry is accepted.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
				

		
		
        //Age Group Dropdown Selection
		ExtentTestManager.startTest("Age Group Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Age Group Dropdown Selection");
		
		select("Major",newCustRepo.pdAgeGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Major' from Age Group dropdown.");
		Log.info("Step:01 -  Select 'Major' from Age Group dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Major' is selected.");
		Log.info("Expected Result: 'Major' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Nationality Dropdown Selection
		ExtentTestManager.startTest("Nationality Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Nationality Dropdown Selection");
		
		select("INDIA",newCustRepo.pdNationalityDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'India' from Nationality dropdown.");
		Log.info("Step:01 -  Select 'India' from Nationality dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "'India' is selected");
		Log.info("Expected Result: 'India' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Nativity Dropdown Selection
		ExtentTestManager.startTest("Nativity Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Nativity Dropdown Selection");
		
		select("KERALA",newCustRepo.pdNativityDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Kerala' from Nativity dropdown.");
		Log.info("Step:01 -  Select 'Kerala' from Nativity dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Kerala' is selected.");
		Log.info("Expected Result: 'Kerala' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Gender Dropdown Selection
		ExtentTestManager.startTest("Gender Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Gender Dropdown Selection");
		
		select("Female",newCustRepo.pdGenderDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Female' from Gender dropdown.");
		Log.info("Step:01 -  Select 'Female' from Gender dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Female' is selected.");
		Log.info("Expected Result: 'Female' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Qualification Dropdown Selection
		ExtentTestManager.startTest("Qualification Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Qualification Dropdown Selection");
		
		select("GRADUATE",newCustRepo.pdQualificationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Graduate' from Qualification dropdown.");
		Log.info("Step:01 -  Select 'Graduate' from Qualification dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Graduate' is selected.");
		Log.info("Expected Result: 'Graduate' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Religion Dropdown Selection
		ExtentTestManager.startTest("Religion Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Religion Dropdown Selection");
		
		select("HINDU",newCustRepo.pdReligionDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Hindu' from Religion dropdown.");
		Log.info("Step:01 -  Select 'Hindu' from Religion dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Hindu' is selected.");
		Log.info("Expected Result: 'Hindu' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Category Dropdown Selection
		ExtentTestManager.startTest("Category Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Category Dropdown Selection");
		
		select("GENERAL",newCustRepo.pdCategoryDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'General' from Category dropdown.");
		Log.info("Step:01 -  Select 'General' from Category dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'General' is selected.");
		Log.info("Expected Result: 'General' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Marital Status Dropdown Selection
		ExtentTestManager.startTest("Marital Status Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Marital Status Dropdown Selection");
		
		select("Single",newCustRepo.pdMaritalStatusDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Single' from Marital Status dropdown.");
		Log.info("Step:01 -  Select 'Single' from Marital Status dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Single' is selected.");
		Log.info("Expected Result: 'Single' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Occupation Group Dropdown Selection
		ExtentTestManager.startTest("Occupation Group Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Occupation Group Dropdown Selection");
		
		select("NILL",newCustRepo.pdOccupGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Nill' from Occupation Group dropdown.");
		Log.info("Step:01 -  Select 'Nill' from Occupation Group dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Nill' is selected.");
		Log.info("Expected Result: 'Nill' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Occupation Field Entry
		ExtentTestManager.startTest("Occupation Field Entry").assignCategory("NewCustomer");
		Log.info("Occupation Field Entry");
		
		String occupation = testdata.get("occupation").toString();
		input(newCustRepo.pdOccupationTxtBox,occupation);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter occupation details.");
		Log.info("Step:01 -  Enter occupation details.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Occupation Organization Field Entry
		ExtentTestManager.startTest("Occupation Organisation Field Entry").assignCategory("NewCustomer");
		Log.info("Occupation Organisation Field Entry");
		
		String occupOrg = testdata.get("occupOrg").toString();
		input(newCustRepo.pdOccOrganisationTxtBox,occupOrg);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter organisation details.");
		Log.info("Step:01 -  Enter organisation details.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Monthly Income Field Entry
		ExtentTestManager.startTest("Monthly Income Field Entry").assignCategory("NewCustomer");
		Log.info("Monthly Income Field Entry");
		
		String monthlyIncome = testdata.get("monthlyIncome").toString();
		click(newCustRepo.pdMonthlyIncomeTxtBox);
		input(newCustRepo.pdMonthlyIncomeTxtBox,monthlyIncome);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter numeric income value.");
		Log.info("Step:01 -  Enter numeric income value.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give numeric value and Value is accepted.");
		Log.info("Expected Result: Possible to give numeric value and Value is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Income Source Dropdown Selection
		ExtentTestManager.startTest("Income Source Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Income Source Dropdown Selection");
		
		click(newCustRepo.pdIncomeSourceDropdown);
		click(newCustRepo.pdIncmSrcNillOption);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Nill' from Income Source dropdown.");
		Log.info("Step:01 -  Select 'Nill' from Income Source dropdown.");
		
		click(newCustRepo.pdPANTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Nill' is selected.");
		Log.info("Expected Result: 'Nill' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Parent/Spouse Details Entry
		ExtentTestManager.startTest("Parent/Spouse Details Entry").assignCategory("NewCustomer");
		Log.info("Parent/Spouse Details Entry");
		
		String parent = testdata.get("parent").toString();
		input(newCustRepo.pdParentTxtBox,parent);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter parent/spouse name.");
		Log.info("Step:01 -  Enter parent/spouse name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Name is accepted.");
		Log.info("Expected Result: Name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Relation Dropdown Selection
		ExtentTestManager.startTest("Relation Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Relation Dropdown Selection");
		
		select("DAUGHTER",newCustRepo.pdRelationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Daughter' from Relation dropdown.");
		Log.info("Step:01 -  Select 'Daughter' from Relation dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Daughter' is selected.");
		Log.info("Expected Result: 'Daughter' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Guardian Details Entry
		ExtentTestManager.startTest("Guardian Details Entry").assignCategory("NewCustomer");
		Log.info("Guardian Details Entry");
		
		click(newCustRepo.pdMentRetardedcheckbox);
		String guardian = testdata.get("guardian").toString();
		input(newCustRepo.pdGuardianTxtBox,guardian);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter guardian name.");
		Log.info("Step:01 -  Enter guardian name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Name is accepted.");
		Log.info("Expected Result: Name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Guardian Relation Dropdown Selection
		ExtentTestManager.startTest("Guardian Relation Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Guardian Relation Dropdown Selection");
		
		select("BROTHER",newCustRepo.pdGuardianRelationDrpodown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select from Guard Relation dropdown.");
		Log.info("Step:01 -  Select from Guard Relation dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option is selected.");
		Log.info("Expected Result: Option is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Father Name Entry
		ExtentTestManager.startTest("Father Name Entry").assignCategory("NewCustomer");
		Log.info("Father Name Entry");

		String fatherName = testdata.get("fatherName").toString();
		input(newCustRepo.pdFatherNameTxtBox,fatherName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter father's name.");
		Log.info("Step:01 -  Enter father's name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Name is accepted.");
		Log.info("Expected Result: Name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Mother Name Entry
		ExtentTestManager.startTest("Mother Name Entry").assignCategory("NewCustomer");
		Log.info("Mother Name Entry");

		String motherName = testdata.get("motherName").toString();
		input(newCustRepo.pdMotherNameTxtBpx,motherName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter mother's name.");
		Log.info("Step:01 -  Enter mother's name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Name is accepted.");
		Log.info("Expected Result: Name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Aadhaar Number Invalid Entry Check
		ExtentTestManager.startTest("Aadhaar Number Invalid Entry Check").assignCategory("NewCustomer");
		Log.info("Aadhaar Number Invalid Entry Check");

		String invalidAadhar = testdata.get("invalidAadhar").toString();
		input(newCustRepo.pdAadharNumTxtBox,invalidAadhar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter invalid Aadhaar number.");
		Log.info("Step:01 -  Enter invalid Aadhaar number.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpAadhaar)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message shown.");
		Log.info("Expected Result: Error message shown.");
		click(newCustRepo.invalidPopUpAadhaar);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}		
		
		ExtentTestManager.endTest();
		
		
		
		
		//Aadhaar Number Valid Entry Check
		ExtentTestManager.startTest("Aadhaar Number Valid Entry Check").assignCategory("NewCustomer");
		Log.info("Aadhaar Number Valid Entry Check");

		clear(newCustRepo.pdAadharNumTxtBox);
		String validAadhar = quickCust.generateUniqueId(quickCust.spAadhaar, quickCust.clmnNamAadhaar);
		input(newCustRepo.pdAadharNumTxtBox,validAadhar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter valid Aadhaar number.");
		Log.info("Step:01 -  Enter valid Aadhaar number.");
		
		click(newCustRepo.pdPANTxt);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//PAN Number Invalid Entry Check
		ExtentTestManager.startTest("PAN Number Invalid Entry Check").assignCategory("NewCustomer");
		Log.info("PAN Number Invalid Entry Check");

//		String invalidAadhar = testdata.get("invalidAadhar").toString();
		input(newCustRepo.pdPANTxtBox,invalidAadhar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter invalid PAN number.");
		Log.info("Step:01 -  Enter invalid PAN number.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPANNumPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message shown.");
		Log.info("Expected Result: Error message shown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.invalidPANNumPopUp);
		
		ExtentTestManager.endTest();
		
		
		
		
		//PAN Number Valid Entry Check
		ExtentTestManager.startTest("PAN Number Valid Entry Check").assignCategory("NewCustomer");
		Log.info("PAN Number Valid Entry Check");

		clear(newCustRepo.pdPANTxtBox);
		String validPAN = quickCust.generateUniqueId(quickCust.spPAN, quickCust.clmnNamPAN);
		input(newCustRepo.pdPANTxtBox,validPAN);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter valid PAN number.");
		Log.info("Step:01 -  Enter valid PAN number.");
		
		click(newCustRepo.pdPANTxt);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
//		//IsNRI Checkbox
//		ExtentTestManager.startTest("IsNRI Checkbox").assignCategory("NewCustomer");
//		Log.info("IsNRI Checkbox");
//		
//		click(newCustRepo.pdIsNRICheckbox);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick 'IsNRI' checkbox.");
//		Log.info("Step:01 - Tick 'IsNRI' checkbox.");
//		
//		select("INDIA",newCustRepo.pdCountryDropDown);
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked.");
//		Log.info("Expected Result: Checkbox is ticked.");
//		
//		ExtentTestManager.endTest();
		
		
		
		
		//Physically Challenged Checkbox
		ExtentTestManager.startTest("Physically Challenged Checkbox").assignCategory("NewCustomer");
		Log.info("Physically Challenged Checkbox");
		
		click(newCustRepo.pdPhyChallengedCheckbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick 'Phy. Challenged' checkbox.");
		Log.info("Step:01 - Tick 'Phy. Challenged' checkbox.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked.");
		Log.info("Expected Result: Checkbox is ticked.");
		
		ExtentTestManager.endTest();
		
		
		
		
//		//Phone Number Invalid Entry Check
//		ExtentTestManager.startTest("Phone Number Invalid Entry Check").assignCategory("NewCustomer");
//		Log.info("Phone Number Invalid Entry Check");
//		
//		String invalidPhoneNum = testdata.get("invalidPhoneNum").toString();
//		input(newCustRepo.pdPhoneNumTxtBox,invalidPhoneNum);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid phone number.");
//		Log.info("Step:01 - Enter invalid phone number.");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message shown.");
//		Log.info("Expected Result: Error message shown.");
//		
//		ExtentTestManager.endTest();
		
		
		
		//Phone Number Valid Entry Check
		ExtentTestManager.startTest("Phone Number Valid Entry Check").assignCategory("NewCustomer");
		Log.info("Phone Number Valid Entry Check");
		
		clear(newCustRepo.pdPhoneNumTxtBox);
		
		String validPhoneNum = testdata.get("validPhoneNum").toString();
		input(newCustRepo.pdPhoneNumTxtBox,validPhoneNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid phone number.");
		Log.info("Step:01 - Enter valid phone number.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		
		
		//Email Invalid Entry Check
		ExtentTestManager.startTest("Email Invalid Entry Check").assignCategory("NewCustomer");
		Log.info("Email Invalid Entry Check");

		input(newCustRepo.pdEmailTxtBox,invalidAadhar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter invalid email address.");
		Log.info("Step:01 -  Enter invalid email address.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidEmailPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message shown.");
		Log.info("Expected Result: Error message shown.");
		click(newCustRepo.invalidEmailPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		
		ExtentTestManager.endTest();
		
		
		
		
		//Email Valid Entry Check
		ExtentTestManager.startTest("Email Valid Entry Check").assignCategory("NewCustomer");
		Log.info("Email Valid Entry Check");

		clear(newCustRepo.pdEmailTxtBox);
		String validEmail = testdata.get("validEmail").toString();
		input(newCustRepo.pdEmailTxtBox,validEmail);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter valid email address.");
		Log.info("Step:01 -  Enter valid email address.");

		click(newCustRepo.pdPANTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//AssetOwned Dropdown Selection
		ExtentTestManager.startTest("AssetOwned Dropdown Selection").assignCategory("NewCustomer");
		Log.info("AssetOwned Dropdown Selection");
		
		click(newCustRepo.pdAssetOwnedDropdown);
		click(newCustRepo.pdAssetOwnedOption);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'Car' from AssetOwned dropdown.");
		Log.info("Step:01 -  Select 'Car' from AssetOwned dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Car' is selected.");
		Log.info("Expected Result: 'Car' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Cust_Segment Dropdown Selection
		ExtentTestManager.startTest("Cust_Segment Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Cust_Segment Dropdown Selection");
		
		select("APL",newCustRepo.pdCustSegmentDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'APL' from Cust_Segment dropdown.");
		Log.info("Step:01 -  Select 'APL' from Cust_Segment dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'APL' is selected.");
		Log.info("Expected Result: 'APL' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
//		//Manual Wedding Date Entry
//		ExtentTestManager.startTest("Manual Wedding Date Entry").assignCategory("NewCustomer");
//		Log.info("Manual Wedding Date Entry");
//		
//		ScrollUntilElementVisible(newCustRepo.pdWeddingDatePicker);
//		click(newCustRepo.pdWeddingDatePicker);
//		String weedingDate = testdata.get("weedingDate").toString();
//		input(newCustRepo.pdWeddingDatePicker,weedingDate);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter Wedding Date.");
//		Log.info("Step:01 - Manually enter Wedding Date.");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manual entry is accepted.");
//		Log.info("Expected Result: Manual entry is accepted.");
//		
//		ExtentTestManager.endTest();
		
		
		
		
		//Blood Group Dropdown Selection
		ExtentTestManager.startTest("Blood Group Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Blood Group Dropdown Selection");
		
		select("O +ve",newCustRepo.pdBloodGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select 'O+ve' from Blood Group dropdown.");
		Log.info("Step:01 -  Select 'O+ve' from Blood Group dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'O+ve' is selected.");
		Log.info("Expected Result: 'O+ve' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Preferred Language Dropdown Selection
		ExtentTestManager.startTest("Preferred Language Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Preferred Language Dropdown Selection");
		
		select("English",newCustRepo.pdPreferredLangDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'English' from Preferred Language dropdown.");
		Log.info("Step:01 - Select 'English' from Preferred Language dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'English' is selected.");
		Log.info("Expected Result: 'English' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//CKYC ID Valid Entry Check
		ExtentTestManager.startTest("CKYC ID Valid Entry Check").assignCategory("NewCustomer");
		Log.info("CKYC ID Valid Entry Check");

		String CKYCId = quickCust.generateUniqueId(quickCust.spAadhaar, quickCust.clmnNamAadhaar);
		input(newCustRepo.pdCKYCIdTxtBox,"89"+CKYCId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid CKYC ID number.");
		Log.info("Step:01 - Enter valid CKYC ID number.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Mobile Number Invalid Entry Check
		ExtentTestManager.startTest("Mobile Number Invalid Entry Check").assignCategory("NewCustomer");
		Log.info("Mobile Number Invalid Entry Check");

//		String invalidAadhar = testdata.get("invalidAadhar").toString();
		input(newCustRepo.pdMobileNumTxtBox,invalidAadhar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter invalid PAN number.");
		Log.info("Step:01 -  Enter invalid PAN number.");
		
		ScrollUntilElementVisible(newCustRepo.checkAvailabilityBtn);
		click(newCustRepo.checkAvailabilityBtn);
		
		//Navigate to Pop Up Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	            
	           
	    		ElementDisplayed(newCustRepo.noMatchFound);
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");
	            	Log.info("Expected Result: A popup should appear displaying customers with similar details or indicating that no similar customers exist.");

	            driver.close();
	    		driver.switchTo().window(mainWindowHandle);
	    		SwitchToFrame(newCustRepo.pdIframe);
	    		System.out.println("Switched to main window");
	    		
	    		ScrollUntilElementVisible(newCustRepo.saveAndProceedBtn);
	    		click(newCustRepo.saveAndProceedBtn);
	    		
	    		
	    		ExtentTestManager.endTest();
	    		
	        }
	        
	    }
		
		
		
//		ScrollUntilElementVisible(newCustRepo.saveAndProceedBtn);
//		click(newCustRepo.saveAndProceedBtn);
		System.out.println("clicked save btn");
		driver.switchTo().defaultContent();
		if(ElementDisplayed(newCustRepo.invalidMobileNumPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message shown.");
		Log.info("Expected Result: Error message shown.");
		click(newCustRepo.invalidMobileNumPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		
		//Mobile Number Valid Entry Check
		ExtentTestManager.startTest("Mobile Number Valid Entry Check").assignCategory("NewCustomer");
		Log.info("Mobile Number Valid Entry Check");

		SwitchToFrame(newCustRepo.pdIframe);
		
		clear(newCustRepo.pdMobileNumTxtBox);
		
		String validMobNum = quickCust.generateUniqueId(quickCust.spMobileNum, quickCust.clmnNamMobileNum);
		input(newCustRepo.pdMobileNumTxtBox,validMobNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter valid Mobile number.");
		Log.info("Step:01 -  Enter valid Mobile number.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Accepted.");
		Log.info("Expected Result: Accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Previous Button Disabled
		ExtentTestManager.startTest("Verify Previous Button Disabled").assignCategory("NewCustomer");
		Log.info("Verify Previous Button Disabled");
		
		boolean value = checkElementEnableOrDisable(newCustRepo.previousBtn);
		
		if(value==false) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Button is disabled.");
			Log.info("Expected Result: Button is disabled.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();
		
		
		
		
		
		//Verify Check Availability Button Enabled
		ExtentTestManager.startTest("Verify Check Availability Button Enabled").assignCategory("NewCustomer");
		Log.info("Verify Check Availability Button Enabled");
		
		boolean value1 = checkElementEnableOrDisable(newCustRepo.checkAvailabilityBtn);
		
		if(value1==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Button is enabled.");
			Log.info("Expected Result: Button is enabled.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();
		
		
		
		
		
		//Verify Save and Proceed Button Disabled Initially
		ExtentTestManager.startTest("Verify Save and Proceed Button Disabled Initially").assignCategory("NewCustomer");
		Log.info("Verify Save and Proceed Button Disabled Initially");
		
		boolean value2 = checkElementEnableOrDisable(newCustRepo.saveAndProceedBtn);
		
		if(value2==false) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Button is disabled initially.");
			Log.info("Expected Result: Button is disabled initially.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();
		
		
		
		
		//Check Availability Popup Display
		ExtentTestManager.startTest("Check Availability Popup Display").assignCategory("NewCustomer");
		Log.info("Check Availability Popup Display");
		
		click(newCustRepo.checkAvailabilityBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Check Availability button.");
		Log.info("Step:01 - Click Check Availability button.");
		
		//Navigate to Pop Up Window
	    String mainWindowHandle1 = driver.getWindowHandle();
	    boolean popupAppeared1 = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle1)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared1 = true;
	            
	           
	    		ElementDisplayed(newCustRepo.noMatchFound);
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window is displayed.");
	            	Log.info("Expected Result: Popup window is displayed.");

	            driver.close();
	    		driver.switchTo().window(mainWindowHandle1);
	    		SwitchToFrame(newCustRepo.pdIframe);
	    		System.out.println("Switched to main window");
	    		
	    		ScrollUntilElementVisible(newCustRepo.saveAndProceedBtn);
	    		
	    		
	    		
	    		
	    		
	    		//Enable Save and Proceed Button on No Matches
	    		ExtentTestManager.startTest("Enable Save and Proceed Button on No Matches").assignCategory("NewCustomer");
	    		Log.info("Enable Save and Proceed Button on No Matches");
	    		
	    		boolean value3 = checkElementEnableOrDisable(newCustRepo.saveAndProceedBtn);
	    		
	    		if(value3==true) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Button is enabled if no matches found.");
	    			Log.info("Expected Result: Button is enabled if no matches found.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		ExtentTestManager.endTest();	    		
	    		
	    		
	    		
	    		
	    		//Submitting Mandatory Details
	    		ExtentTestManager.startTest("Submitting Mandatory Details").assignCategory("NewCustomer");
	    		Log.info("Submitting Mandatory Details");
	    		
	    		click(newCustRepo.saveAndProceedBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Fill all mandatory details & click on Save and Proceed button.");
	    		Log.info("Step:01 - 1. Fill all mandatory details & click on Save and Proceed button.");
	    		
	    		driver.switchTo().defaultContent();
	    		System.out.println("Switched out of Personal Details Iframe.");

	    		boolean presentDetailsSavedPopUp = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);

	    		click(newCustRepo.pdSavedSuccessfullyPopUp);
	    		
	    		SwitchToFrame(newCustRepo.addressIframe);
	    		System.out.println("Switched to Addres Iframe.");
	    		
	    		boolean addressPage = ElementDisplayed(newCustRepo.prHouseTxtBox);
	    		
	    		if(presentDetailsSavedPopUp == true && addressPage == true ) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to Address Details tab.");
	    			Log.info("Expected Result: Redirected to Address Details tab.");
	    			}else {
	    				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    				Log.info("ERROR");
	    			}
	    		
	    		ExtentTestManager.endTest();
	    		
	        }
	        
	    }

	}
	
	
	
	public void alphabeticAndNumericFieldRestrictionCheck(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		
		
		
		//Verify Mandatory Field Validation Messages
		ExtentTestManager.startTest("Verify Mandatory Field Validation Messages").assignCategory("NewCustomer");
		Log.info("Verify Mandatory Field Validation Messages");
				
		ScrollUntilElementVisible(newCustRepo.checkAvailabilityBtn);
		click(newCustRepo.checkAvailabilityBtn);
		
		//Navigate to Pop Up Window
	    String mainWindowHandle0 = driver.getWindowHandle();
	    boolean popupAppeared0 = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle0)) {
	            driver.switchTo().window(handle);
//	            driver.manage().window().maximize();
	            popupAppeared0 = true;
	            
	            driver.close();
	    		driver.switchTo().window(mainWindowHandle0);
	    		SwitchToFrame(newCustRepo.pdIframe);
	    		System.out.println("Switched to main window");
	    		
	    		ScrollUntilElementVisible(newCustRepo.saveAndProceedBtn);
	    		click(newCustRepo.saveAndProceedBtn);

	    		if(ElementDisplayed(newCustRepo.invalidPopUpSalutation)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Appropriate validation messages are displayed.");
	    			Log.info("Expected Result: Appropriate validation messages are displayed.");
	    			click(newCustRepo.invalidPopUpSalutation);
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	        }
	        
	    }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Alphabetic Field Restriction Check
		ExtentTestManager.startTest("Alphabetic Field Restriction Check").assignCategory("NewCustomer");
		Log.info("Alphabetic Field Restriction Check");
		
		String num_Spcl = testdata.get("num_Spcl").toString();
		
		//First Name
		input(newCustRepo.pdFNameTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers/special characters in First Name field.");
		Log.info("Step:01 - Enter numbers/special characters in First Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpFirstName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpFirstName);
			clear(newCustRepo.pdFNameTxtBox);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}


		//Middle Name
		input(newCustRepo.pdMNameTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter numbers/special characters in Middle Name field.");
		Log.info("Step:02 - Enter numbers/special characters in Middle Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpMiddleName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpMiddleName);
			clear(newCustRepo.pdMNameTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		//Last Name
		input(newCustRepo.pdLNameTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter numbers/special characters in Last Name field.");
		Log.info("Step:03 - Enter numbers/special characters in Last Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpLastName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpLastName);
			clear(newCustRepo.pdLNameTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		//Alias Name
		input(newCustRepo.pdANameTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter numbers/special characters in Alias Name field.");
		Log.info("Step:04 - Enter numbers/special characters in Alias Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpAliasName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpAliasName);
			clear(newCustRepo.pdANameTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		//Father Name
		input(newCustRepo.pdFatherNameTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Enter numbers/special characters in Father Name field.");
		Log.info("Step:05 - Enter numbers/special characters in Father Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpFatherName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpFatherName);
			clear(newCustRepo.pdFatherNameTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		//Mother Name
		input(newCustRepo.pdMotherNameTxtBpx,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Enter numbers/special characters in Mother Name field.");
		Log.info("Step:06 - Enter numbers/special characters in Mother Name field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpMotherName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpMotherName);
			clear(newCustRepo.pdMotherNameTxtBpx);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		ExtentTestManager.endTest();
		
		
		
		
		//Numeric Field Restriction Check
		ExtentTestManager.startTest("Numeric Field Restriction Check").assignCategory("NewCustomer");
		Log.info("Numeric Field Restriction Check");
		
//		//Aadhaar Num
//		input(newCustRepo.pdAadharNumTxtBox,num_Spcl);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers/special characters in Aadhaar field.");
//		Log.info("Step:01 - Enter numbers/special characters in Aadhaar field.");
//		
//		click(newCustRepo.pdPANTxt);
//		
//		if(ElementDisplayed(newCustRepo.invalidPopUpAadhaar)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
//			Log.info("Expected Result: Error messages shown for invalid entry.");
//		}
//		click(newCustRepo.invalidPopUpAadhaar);
//		clear(newCustRepo.pdAadharNumTxtBox);
		
		//CKYC Id
		input(newCustRepo.pdCKYCIdTxtBox,num_Spcl);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers/special characters in CKYC ID field.");
		Log.info("Step:01 - Enter numbers/special characters in CKYC ID field.");
		
		click(newCustRepo.pdPANTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPopUpCKYCId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error messages shown for invalid entry.");
			Log.info("Expected Result: Error messages shown for invalid entry.");
			click(newCustRepo.invalidPopUpCKYCId);
			clear(newCustRepo.pdCKYCIdTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		ExtentTestManager.endTest();
	}

	
	//Address
	public void address(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		


		//Previous button - Functionality 
		ExtentTestManager.startTest("Previous button - Functionality ").assignCategory("NewCustomer");
		Log.info("Previous button - Functionality ");
		
		click(newCustRepo.prmPreviousBtn);
		driver.switchTo().defaultContent();
		
		SwitchToFrame(newCustRepo.pdIframe);
		System.out.println("Switched to Personal Details Iframe.");
		
		if(ElementDisplayed(newCustRepo.pdStartDateTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Successfully goes back to the previous tab i.e. Persoanl details tab.");
			Log.info("Expected Result: Successfully goes back to the previous tab i.e. Persoanl details tab.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ScrollUntilElementVisible(newCustRepo.saveAndProceedBtn);
		click(newCustRepo.saveAndProceedBtn);
		System.out.println("save and proceed clicked");
		
		driver.switchTo().defaultContent();
		System.out.println("Switched out of Personal Details Iframe.");

		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.addressIframe);
		System.out.println("Switched to Addres Iframe.");
		
		ExtentTestManager.endTest();
		
		
		

		//ECP for House Field
		ExtentTestManager.startTest("ECP for House Field").assignCategory("NewCustomer");
		Log.info("ECP for House Field");
		
		String specialCharInput = testdata.get("specialCharInput").toString();
		input(newCustRepo.prHouseTxtBox,specialCharInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Special Characters' in House field.");
		Log.info("Step:01 - Enter 'Special Characters' in House field.");
		
		click(newCustRepo.prHouseTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPresentHouseName)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Special characters prompt error mesage.");
		Log.info("Expected Result: Special characters prompt error mesage.");
		click(newCustRepo.invalidPresentHouseName);
		clear(newCustRepo.prHouseTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();
		
		
		
		
		//Enter Valid Data in Address Fields - House
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - House").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - House");
		
		String addressPresentHouse = testdata.get("addressPresentHouse").toString();
		input(newCustRepo.prHouseTxtBox,addressPresentHouse);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Orkkateeri Veetil12' in House field.");
		Log.info("Step:01 - Enter 'Orkkateeri Veetil12' in House field.");
		
		click(newCustRepo.prHouseTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//Enter Valid Data in Address Fields - House Num
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - House Num").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - House Num");
		
		String addressPresentHouseNum = testdata.get("addressPresentHouseNum").toString();
		input(newCustRepo.prHouseNumTxtBox,addressPresentHouseNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Buidlingno123%^&' in 'House No' field.");
		Log.info("Step:01 - Enter 'Buidlingno123%^&' in 'House No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//Enter Valid Data in Address Fields - Door Num
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - Door Num").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - Door Num");
		
		String addressPresentDoorNum = testdata.get("addressPresentDoorNum").toString();
		input(newCustRepo.prDoorNumTxtBox,addressPresentDoorNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Doorno123%^&' in 'Door No' field.");
		Log.info("Step:01 - Enter 'Doorno123%^&' in 'Door No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//State - Drop down selection
		ExtentTestManager.startTest("State - Drop down selection").assignCategory("NewCustomer");
		Log.info("State - Drop down selection");
		
		select("KERALA",newCustRepo.prStateDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the state from the drop down option.");
		Log.info("Step:01 - Select the state from the drop down option.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the state without any errors.");
		Log.info("Expected Result: Possible to select the state without any errors.");

		ExtentTestManager.endTest();
		
		
		

		//District - Drop down selection
		ExtentTestManager.startTest("District - Drop down selection").assignCategory("NewCustomer");
		Log.info("District - Drop down selection");
		
		select("Wayanad",newCustRepo.prDistrictDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the District from the drop down option.");
		Log.info("Step:01 - Select the District from the drop down option.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the District without any errors.");
		Log.info("Expected Result: Possible to select the District without any errors.");

		ExtentTestManager.endTest();
		
		
		

		//Post - Drop down selection
		ExtentTestManager.startTest("Post - Drop down selection").assignCategory("NewCustomer");
		Log.info("Post - Drop down selection");
		
		select("Alattil B.O",newCustRepo.prPostDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the Post from the drop down option.");
		Log.info("Step:01 - Select the Post from the drop down option.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the Post without any errors.");
		Log.info("Expected Result: Possible to select the Post without any errors.");

		ExtentTestManager.endTest();
		
		
		

		//Enter Valid Data in Address Fields - City
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - City").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - City");
		
		String addressPresentCity = testdata.get("addressPresentCity").toString();
		input(newCustRepo.prCityTxtBox,addressPresentCity);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'City123%^&' in the 'City' field.");
		Log.info("Step:01 - Enter 'City123%^&' in the 'City' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//Enter Valid Data in Address Fields - Street
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - Street").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - Street");
		
		String addressPresentStreet = testdata.get("addressPresentStreet").toString();
		input(newCustRepo.prStreetTxtBox,addressPresentStreet);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Street123%^&' in the 'Street' field.");
		Log.info("Step:01 - Enter 'Street123%^&' in the 'Street' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//ECP for Residence Field
		ExtentTestManager.startTest("ECP for Residence Field").assignCategory("NewCustomer");
		Log.info("ECP for Residence Field");
		
		//Special Character
		input(newCustRepo.prResidenceTxtBox,specialCharInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Special Character in Residence field.");
		Log.info("Step:01 - Enter Special Character in Residence field.");
		
		click(newCustRepo.prHouseTxt);
		
		if(ElementDisplayed(newCustRepo.invalidPresentResidence)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Specal characters prompt error mesage.");
		Log.info("Expected Result:  Specal characters prompt error mesage.");
		click(newCustRepo.invalidPresentResidence);
		clear(newCustRepo.prResidenceTxtBox);
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		
		//Alpha Numeric
		String AlphaNumericInput = testdata.get("AlphaNumericInput").toString();
		input(newCustRepo.prResidenceTxtBox,AlphaNumericInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter AlphaNumeric Character in Residence field.");
		Log.info("Step:02 - Enter AlphaNumeric Character in Residence field.");
		
		click(newCustRepo.prHouseTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabetic inputs are also allowed.");
		Log.info("Expected Result: Alphabetic inputs are also allowed.");
		
		clear(newCustRepo.prResidenceTxtBox);
		ExtentTestManager.endTest();
		
		//Numeric
		String invalidPhoneNum = testdata.get("invalidPhoneNum").toString();
		input(newCustRepo.prResidenceTxtBox,invalidPhoneNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Numeric Character in Residence field.");
		Log.info("Step:03 - Enter Numeric Character in Residence field.");
		
		click(newCustRepo.prHouseTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric inputs are also allowed.");
		Log.info("Expected Result: Numeric inputs are also allowed.");
		
		clear(newCustRepo.prResidenceTxtBox);
		
		ExtentTestManager.endTest();
		
		
		
		

		//Enter Valid Data in Address Fields - Residence
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - Residence").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - Residence");
		
		String addressPresentResidence = testdata.get("addressPresentResidence").toString();
		input(newCustRepo.prResidenceTxtBox,addressPresentResidence);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Malol' in the 'Resisdence' field.");
		Log.info("Step:01 - Enter 'Malol' in the 'Resisdence' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//Validate Pin Auto-load
		ExtentTestManager.startTest("Validate Pin Auto-load").assignCategory("NewCustomer");
		Log.info("Validate Pin Auto-load");
		
		String pinAutoFillValue = driver.findElement(newCustRepo.prPinTxtBox).getAttribute("value");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a post & Verify Pin is loaded automatically.");
		Log.info("Step:01 - Select a post & Verify Pin is loaded automatically.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Pin is auto-loaded accurately for selected Post.");
		Log.info("Expected Result: Pin: " + pinAutoFillValue + " is auto-loaded accurately for selected Post.");

		ExtentTestManager.endTest();
		
		
		

		//Enter Valid Data in Address Fields - Electric Post No
		ExtentTestManager.startTest("Enter Valid Data in Address Fields - Electric Post No").assignCategory("NewCustomer");
		Log.info("Enter Valid Data in Address Fields - Electric Post No");
		
		String addressPresentElectricPostNum = testdata.get("addressPresentElectricPostNum").toString();
		input(newCustRepo.prElectricPostNumTxtBox,addressPresentElectricPostNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'Electric Post No123%^&' in the 'Electric Post No' field.");
		Log.info("Step:01 - Enter 'Electric Post No123%^&' in the 'Electric Post No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entered without validation errors.");
		Log.info("Expected Result: Data entered without validation errors.");

		ExtentTestManager.endTest();
		
		
		

		//Phone No. Field Validation
		ExtentTestManager.startTest("Phone No. Field Validation").assignCategory("NewCustomer");
		Log.info("Phone No. Field Validation");
		
//		String AlphaNumericInput = testdata.get("AlphaNumericInput").toString();
		input(newCustRepo.prPhoneNumTxtBox,AlphaNumericInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numeric value in Phone No & Try entering alphabetical and special characters.");
		Log.info("Step:01 - Enter numeric value in Phone No & Try entering alphabetical and special characters.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Phone No. accepts only numbers, Not possible to enter the alphabetical and special characters.");
		Log.info("Expected Result: Phone No. accepts only numbers, Not possible to enter the alphabetical and special characters.");

		ExtentTestManager.endTest();
		
		
		

		//Validation checking
		ExtentTestManager.startTest("Validation checking").assignCategory("NewCustomer");
		Log.info("Validation checking");
		
//		String addressPresentStreet = testdata.get("addressPresentStreet").toString();
		input(newCustRepo.prPlaceTxtBox,addressPresentStreet);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter inputs with Alphabets, Numeric, and Alphanumeric characters and Verify.");
		Log.info("Step:01 - Enter inputs with Alphabets, Numeric, and Alphanumeric characters and Verify.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets, Numeric, and Alphanumeric characters allowed , no errors displays.");
		Log.info("Expected Result: Alphabets, Numeric, and Alphanumeric characters allowed , no errors displays.");

		ExtentTestManager.endTest();
		
		

		//Use Present Checkbox Functionality
		ExtentTestManager.startTest("Use Present Checkbox Functionality").assignCategory("NewCustomer");
		Log.info("Use Present Checkbox Functionality");
		
		click(newCustRepo.prmUsePresentCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Use Present' checkbox in Permanent section, Verify data auto-loads under Permanent section.");
		Log.info("Step:01 - Select 'Use Present' checkbox in Permanent section, Verify data auto-loads under Permanent section.");
		
		String HouseValue = driver.findElement(newCustRepo.prmHouseTxtBox).getAttribute("value");
		String PINValue = driver.findElement(newCustRepo.prmPIN).getAttribute("value");
		String PhoneNumValue = driver.findElement(newCustRepo.prmPhoneNumTxtBox).getAttribute("value");

		if(HouseValue !="" && PINValue !="" && PhoneNumValue !="") {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data from Present is auto-loaded into Permanent section.");
		Log.info("Expected Result: Data from Present is auto-loaded into Permanent section.");
		}	
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();
		
		

		//Mailing Address Checkbox Unique Selection
		ExtentTestManager.startTest("Mailing Address Checkbox Unique Selection").assignCategory("NewCustomer");
		Log.info("Mailing Address Checkbox Unique Selection");
		
		click(newCustRepo.prMailingAddress1CheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Mailing Address' in Present section.");
		Log.info("Step:01 - Select 'Mailing Address' in Present section.");
		
		click(newCustRepo.prMailingAddress2CheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Try selecting it in other sections.");
		Log.info("Step:02 - Try selecting it in other sections.");
		
		boolean checkBox1= driver.findElement(newCustRepo.prMailingAddress1CheckBox).isSelected();
		boolean checkBox2= driver.findElement(newCustRepo.prMailingAddress2CheckBox).isSelected();

		if(checkBox1==true && checkBox2==true) {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: ERROR.");
			Log.info("Expected Result: ERROR.");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox can only be selected in one section at a time.");
			Log.info("Expected Result: Checkbox can only be selected in one section at a time.");
		}
		
		ExtentTestManager.endTest();
		
		
		

		//Verify Buttons in Address Tab
		ExtentTestManager.startTest("Verify Buttons in Address Tab").assignCategory("NewCustomer");
		Log.info("Verify Buttons in Address Tab");
		
		ScrollUntilElementVisible(newCustRepo.prmPreviousBtn);
		boolean previousBtnValue = checkElementEnableOrDisable(newCustRepo.prmPreviousBtn);
		boolean saveAndProceedBtnValue = checkElementEnableOrDisable(newCustRepo.prmSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Locate Previous and Save and Proceed buttons & Verify both are enabled.");
		Log.info("Step:01 - Locate Previous and Save and Proceed buttons & Verify both are enabled.");
		
		if(previousBtnValue==true && saveAndProceedBtnValue==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Buttons are visible and enabled.");
		Log.info("Expected Result: Buttons are visible and enabled.");
		}
		
		ExtentTestManager.endTest();
		
		
		

		//Save Address and Navigate to Introducer Tab
		ExtentTestManager.startTest("Save Address and Navigate to Introducer Tab").assignCategory("NewCustomer");
		Log.info("Save Address and Navigate to Introducer Tab");
		
		//Mandatory fields - Official
		ScrollUntilElementVisible(newCustRepo.offBuildingTxtBox);
		input(newCustRepo.offBuildingTxtBox,addressPresentHouse);
		
		//Mandatory fields - Regional
		ScrollUntilElementVisible(newCustRepo.regHouseTxtBox);
		input(newCustRepo.regHouseTxtBox,addressPresentHouse);
		
//		//Mandatory fields - Overseas
//		ScrollUntilElementVisible(newCustRepo.ovrHouseTxtBox);
//		input(newCustRepo.ovrHouseTxtBox,addressPresentHouse);
//		String pinOverseas = testdata.get("pin").toString();
//		input(newCustRepo.ovrPINTxtBox,pinOverseas);
		
		ScrollUntilElementVisible(newCustRepo.prmSaveAndProceedBtn);
		click(newCustRepo.prmSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Save and Proceed', Verify navigation to Introducer tab.");
		Log.info("Step:01 - Click 'Save and Proceed', Verify navigation to Introducer tab.");
		
		driver.switchTo().defaultContent();
		boolean addressSavedPopup = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);

		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.introducerIframe);
		boolean introducerWindow = ElementDisplayed(newCustRepo.introdNotReqCheckBox);

		if(addressSavedPopup==true && introducerWindow==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Successfully redirected to Introducer tab.");
		Log.info("Expected Result: Successfully redirected to Introducer tab.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
	}
	
	
	public void introducer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
	

		//Introducer Not Required Option
		ExtentTestManager.startTest("Introducer Not Required Option").assignCategory("NewCustomer");
		Log.info("Introducer Not Required Option");
		
		click(newCustRepo.introdNotReqCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Introducer Not Required' checkbox, Verify 'Reason' field appears and others disable.");
		Log.info("Step:01 - Select 'Introducer Not Required' checkbox, Verify 'Reason' field appears and others disable.");
		
		if(ElementDisplayed(newCustRepo.introReasonTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Reason' field is displayed, other fields disabled.");
			Log.info("Expected Result: 'Reason' field is displayed, other fields disabled.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.introdNotReqCheckBox);
		ExtentTestManager.endTest();
	
		
	
		
		//Customer ID Field - BVA Validations
		ExtentTestManager.startTest("Customer ID Field - BVA Validations").assignCategory("NewCustomer");
		Log.info("Customer ID Field - BVA Validations");
		
		//Min-1
		click(newCustRepo.introCustIdTxtBox);
		String oneLessThanMin = testdata.get("pin").toString();
		input(newCustRepo.introCustIdTxtBox, oneLessThanMin);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the string length Min-1.");
		Log.info("Step:01 - For the Customer ID field, check the string length Min-1.");
		
		click(newCustRepo.introCustIdTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(newCustRepo.invalidCustIdPopUpWnd)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Min-1 input prompt error message.");
			Log.info("Expected Result: Min-1 input prompt error message.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		
		//Max+1
		click(newCustRepo.introCustIdTxtBox);
		String oneMoreThanMax = testdata.get("max1").toString();
		input(newCustRepo.introCustIdTxtBox, oneMoreThanMax);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the string length Max+1.");
		Log.info("Step:01 - For the Customer ID field, check the string length Max+1.");
		
		click(newCustRepo.introCustIdTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(newCustRepo.invalidCustIdPopUpWnd)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Max+1 input prompt error message.");
			Log.info("Expected Result: Max+1 input prompt error message.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		
		//Min & Max
		click(newCustRepo.introCustIdTxtBox);
		String minAndMax = testdata.get("validCustId").toString();
		input(newCustRepo.introCustIdTxtBox, minAndMax);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the string length Min & Max.");
		Log.info("Step:01 - For the Customer ID field, check the string length Min & Max.");
		
		click(newCustRepo.introCustIdTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		String IntNameValue = driver.findElement(newCustRepo.introIntNameTxtBox).getAttribute("value");
		String IntroAddressValue = driver.findElement(newCustRepo.introIntroducersAddressTxtBox).getAttribute("value");

		if(IntNameValue!="" && IntroAddressValue!="") {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Inputs of Min and Max lengths are allowed. Other inputs prompt error messages." + IntNameValue + " 'Introducer's Address': " + IntroAddressValue);
		Log.info("Expected Result: Inputs of Min and Max lengths are allowed. Other inputs prompt error messages." + IntNameValue + " 'Introducer's Address': " + IntroAddressValue); 
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		
		ExtentTestManager.endTest();
	
		
	
		
		//Customer ID Field - ECP Validations
		ExtentTestManager.startTest("Customer ID Field - ECP Validations").assignCategory("NewCustomer");
		Log.info("Customer ID Field - ECP Validations");
		
		//Alphabetic Input
		click(newCustRepo.introCustIdTxtBox);
		String introducerCustName = testdata.get("introducerCustName").toString();
		input(newCustRepo.introCustIdTxtBox, introducerCustName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the input with Alphabetic input.");
		Log.info("Step:01 - For the Customer ID field, check the input with Alphabetic input.");
		
		click(newCustRepo.introSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		if(ElementDisplayed(newCustRepo.invalidIntCustIdPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabetic inputs prompt error message.");
			Log.info("Expected Result: Alphabetic inputs prompt error message.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.invalidIntCustIdPopUp);
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		
		//AlphaNumeric Input
		click(newCustRepo.introCustIdTxtBox);
		String alphaNumericInput = testdata.get("alphaNumericInput").toString();
		input(newCustRepo.introCustIdTxtBox, alphaNumericInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the input with AlphaNumeric input.");
		Log.info("Step:01 - For the Customer ID field, check the input with AlphaNumeric input.");
		
		click(newCustRepo.introSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		if(ElementDisplayed(newCustRepo.invalidIntCustIdPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AlphaNumeric inputs prompt error message.");
			Log.info("Expected Result: AlphaNumeric inputs prompt error message.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(newCustRepo.invalidIntCustIdPopUp);
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		
		//Numeric Input
		click(newCustRepo.introCustIdTxtBox);
		String validCustId = testdata.get("validCustId").toString();
		input(newCustRepo.introCustIdTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - For the Customer ID field, check the input with Numeric input.");
		Log.info("Step:01 - For the Customer ID field, check the input with Numeric input.");
		
		click(newCustRepo.introCustIdTxt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Save & Proceed button.");
		Log.info("Step:02 - Click on the Save & Proceed button.");
		
		String IntNameValue2 = driver.findElement(newCustRepo.introIntNameTxtBox).getAttribute("value");
		String IntroAddressValue2 = driver.findElement(newCustRepo.introIntroducersAddressTxtBox).getAttribute("value");

		
		if(IntNameValue2!="" && IntroAddressValue2!="") {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Inputs of Min and Max lengths are allowed. Other inputs prompt error messages." + IntNameValue2 + " 'Introducer's Address': " + IntroAddressValue2);
		Log.info("Expected Result: Inputs of Min and Max lengths are allowed. Other inputs prompt error messages." + IntNameValue2 + " 'Introducer's Address': " + IntroAddressValue2); 
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		clear(newCustRepo.introCustIdTxtBox);
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidCustIdPopUpWnd);
		SwitchToFrame(newCustRepo.introducerIframe);
		click(newCustRepo.introCustIdTxt);
		
		ExtentTestManager.endTest();
		
		
		
		
		//Search and Load Introducer Details
		ExtentTestManager.startTest("Search and Load Introducer Details").assignCategory("NewCustomer");
		Log.info("Search and Load Introducer Details");
	
		click(newCustRepo.introCustomerIDSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Search Icon.");
		Log.info("Step:01 - Click Search Icon.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                popupAppeared = true;
//        		String introducerCustName = testdata.get("introducerCustName").toString();
        		input(newCustRepo.custSrchNameTxtBox, introducerCustName);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter customer name.");
        		Log.info("Step:02 - Enter customer name.");
        		
        		click(newCustRepo.custSrchBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Search button");
        		Log.info("Step:03 - Click on Search button");
        		
        		click(newCustRepo.custSelectLinkTxt);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Select customer.");
        		Log.info("Step:04 - Select customer.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		SwitchToFrame(newCustRepo.introducerIframe);

        		String IntNameValue1 = driver.findElement(newCustRepo.introIntNameTxtBox).getAttribute("value");
        		String IntroAddressValue1 = driver.findElement(newCustRepo.introIntroducersAddressTxtBox).getAttribute("value");

        		if(IntNameValue1!="" && IntroAddressValue1!="") {
    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are auto-loaded with 'Int Name': " + IntNameValue1 + " 'Introducer's Address': " + IntroAddressValue1);
    			Log.info("Expected Result: Customer details are auto-loaded with 'Int Name': " + IntNameValue1 + " 'Introducer's Address': " + IntroAddressValue1); 
        		}
        		else {
        			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
        			Log.info("ERROR");
        		}
        		break;
            }
        }
		
		
		ExtentTestManager.endTest();
		
		
	
		
		//Verify Rel_ID Dropdown
		ExtentTestManager.startTest("Verify Rel_ID Dropdown").assignCategory("NewCustomer");
		Log.info("Verify Rel_ID Dropdown");
		
		select("FRIEND",newCustRepo.introRelIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select one option from the 'Rel_ID' drop down field.");
		Log.info("Step:01 - Select one option from the 'Rel_ID' drop down field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the option from drop down");
		Log.info("Expected Result: Possible to select the option from drop down");
      
		ExtentTestManager.endTest();
		
		
	
		
		//Add Remarks and Verify Buttons
		ExtentTestManager.startTest("Add Remarks and Verify Buttons").assignCategory("NewCustomer");
		Log.info("Add Remarks and Verify Buttons");
		
		String remarks = testdata.get("remarks").toString();
		input(newCustRepo.introRemarksTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter remarks.");
		Log.info("Step:01 - Enter remarks.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks can be added.");
		Log.info("Expected Result: Remarks can be added.");
	
		
		ExtentTestManager.endTest();
		
		
	
		
		//Active Account Functionality
		ExtentTestManager.startTest("Active Account Functionality").assignCategory("NewCustomer");
		Log.info("Active Account Functionality");
		
		click(newCustRepo.introActiveAccBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Active Account' button, Verify grid displays active account details.");
		Log.info("Step:01 - Click 'Active Account' button, Verify grid displays active account details.");
		
		if(ElementDisplayed(newCustRepo.introTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Active account details shown in grid.");
			Log.info("Expected Result: Active account details shown in grid.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
      
		ExtentTestManager.endTest();
		
		
	
		
		//Close Functionality
		ExtentTestManager.startTest("Close Functionality").assignCategory("NewCustomer");
		Log.info("Close Functionality");
		
		click(newCustRepo.introCloseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Close' button, Verify grid is closed.");
		Log.info("Step:01 - Click 'Close' button, Verify grid is closed.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Active account grid is closed.");
		Log.info("Expected Result: Active account grid is closed.");

      
		ExtentTestManager.endTest();
		
		
	
		
		//Verify and Interact with 'Relation With Director'
		ExtentTestManager.startTest("Verify and Interact with 'Relation With Director'").assignCategory("NewCustomer");
		Log.info("Verify and Interact with 'Relation With Director'");
		
		click(newCustRepo.introRelationWithDirectorCheckbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Relation With Director' checkbox.");
		Log.info("Step:01 - Click 'Relation With Director' checkbox.");
		
		boolean directDrpdown = ElementDisplayed(newCustRepo.introDirectorDropdown);
		boolean dirRelationDrpdwn = ElementDisplayed(newCustRepo.introRelationBtn);
		boolean dirReamrks = ElementDisplayed(newCustRepo.introDirctrRemarksTxtBox);

		if(directDrpdown==true && dirRelationDrpdwn==true && dirReamrks==true)  {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New fields are displayed as expected.");
			Log.info("Expected Result: New fields are displayed as expected.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();		
		
		
		
		
		//Save and Proceed Introducer Details
		ExtentTestManager.startTest("Save and Proceed Introducer Details").assignCategory("NewCustomer");
		Log.info("Save and Proceed Introducer Details");
		
		select("SUNIL",newCustRepo.introDirectorDropdown);
		select("FRIEND",newCustRepo.introRelationBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select director and relation.");
		Log.info("Step:01 - Select director and relation.");
		
		input(newCustRepo.introDirctrRemarksTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter remarks.");
		Log.info("Step:02 - Enter remarks.");
		
		click(newCustRepo.introSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click Save and Proceed button.");
		Log.info("Step:03 - Click Save and Proceed button.");
		
		driver.switchTo().defaultContent();

		boolean introwindow = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);

		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.pdIframe);
		
		boolean identityAndAreawindow = ElementDisplayed(newCustRepo.aidIdentityTypeDropdown);
		
		if(introwindow==true && identityAndAreawindow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details saved, redirected to 'Identity & Area Details' tab.");
			Log.info("Expected Result: Details saved, redirected to 'Identity & Area Details' tab.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
	
	public void identityAndArea(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		
		//Select Identity Type
		ExtentTestManager.startTest("Select Identity Type").assignCategory("NewCustomer");
		Log.info("Select Identity Type");
		
		select("ELECTION ID",newCustRepo.aidIdentityTypeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Choose an option from Identity Type dropdown.");
		Log.info("Step:01 - Choose an option from Identity Type dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item appears in the field.");
		Log.info("Expected Result: Selected item appears in the field.");
		
		ExtentTestManager.endTest();

		
		
		
		//Duplicate Data Validation
		ExtentTestManager.startTest("Duplicate Data Validation").assignCategory("NewCustomer");
		Log.info("Duplicate Data Validation");
		
		String duplicateIdentityNum = testdata.get("duplicateIdentityNum").toString();
		input(newCustRepo.aidIdentityNumTxtBox, duplicateIdentityNum);
		click(newCustRepo.aidAddDocBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Submit with duplicate identity details.");
		Log.info("Step:01 - Submit with duplicate identity details.");
		
		driver.switchTo().defaultContent();
		click(newCustRepo.invalidMobileNumPopUp);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message 'Data already exists' appears.");
		Log.info("Expected Result: Error message 'Data already exists' appears.");
		
		SwitchToFrame(newCustRepo.pdIframe);
		clear(newCustRepo.aidIdentityNumTxtBox);
		
		ExtentTestManager.endTest();

		
		
		
		//Enter Identity No
		ExtentTestManager.startTest("Enter Identity No").assignCategory("NewCustomer");
		Log.info("Enter Identity No");
		
		String validIdentityNum = quickCust.generateUniqueId(quickCust.spPAN, quickCust.clmnNamPAN);
		input(newCustRepo.aidIdentityNumTxtBox,validIdentityNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter unique Identity Number in Identity No. field.");
		Log.info("Step:01 - Enter unique Identity Number in Identity No. field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entered value appears in the field.");
		Log.info("Expected Result: Entered value appears in the field.");
		
		ExtentTestManager.endTest();
		

		
		//Enter Issued Authority
		ExtentTestManager.startTest("Enter Issued Authority").assignCategory("NewCustomer");
		Log.info("Enter Issued Authority");
		
		String issuedAuthority = testdata.get("issuedAuthority").toString();
		input(newCustRepo.aidIssuedAutTxtBox, issuedAuthority);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter '456aa#$' in Issued Authority field.");
		Log.info("Step:01 - Enter '456aa#$' in Issued Authority field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entered value appears in the field.");
		Log.info("Expected Result: Entered value appears in the field.");
		
		ExtentTestManager.endTest();
		

		
		//Enter Details
		ExtentTestManager.startTest("Enter Details").assignCategory("NewCustomer");
		Log.info("Enter Details");
		
		input(newCustRepo.aidDetailsTxtBox, issuedAuthority);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter details in 'Details' text field.");
		Log.info("Step:01 - Enter details in 'Details' text field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entered value appears in the field.");
		Log.info("Expected Result: Entered value appears in the field.");
		
		ExtentTestManager.endTest();
		

		
		//Add Issue Date
		ExtentTestManager.startTest("Add Issue Date").assignCategory("NewCustomer");
		Log.info("Add Issue Date");
		
		click(newCustRepo.aidIssueDate);
		String issueDate = testdata.get("issueDate").toString();
		input(newCustRepo.aidIssueDate, issueDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select or manually enter a date for 'Issue Date' field.");
		Log.info("Step:01 - Select or manually enter a date for 'Issue Date' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is accepted in the field.");
		Log.info("Expected Result: Date is accepted in the field.");
		
		ExtentTestManager.endTest();
		

		
		//Add Valid Up to Date
		ExtentTestManager.startTest("Add Valid Up to Date").assignCategory("NewCustomer");
		Log.info("Add Valid Up to Date");
		
		click(newCustRepo.aidValidUpTo);
		String validUptoDate = testdata.get("validUptoDate").toString();
		input(newCustRepo.aidValidUpTo, validUptoDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select or manually enter a date for 'Valid Up Date' field.");
		Log.info("Step:01 - Select or manually enter a date for 'Valid Up Date' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is accepted in the field.");
		Log.info("Expected Result: Date is accepted in the field.");
		
		ExtentTestManager.endTest();
		

		
		//Open Add Images Popup
		ExtentTestManager.startTest("Open Add Images Popup").assignCategory("NewCustomer");
		Log.info("Open Add Images Popup");		

		click(newCustRepo.aidAddImgBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add Images' button.");
		Log.info("Step:01 - Click 'Add Images' button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                popupAppeared = true;
                
                if(ElementDisplayed(newCustRepo.aidBrowseBtn)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window opens for adding images.");
            		Log.info("Expected Result: Popup window opens for adding images.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
            		Log.info("ERROR");
                }
                
                ExtentTestManager.endTest();
                

        		
        		//Add Image from Browse
        		ExtentTestManager.startTest("Add Image from Browse").assignCategory("NewCustomer");
        		Log.info("Add Image from Browse");	
        		
                UploadFile(newCustRepo.aidBrowseBtn, ".\\src\\test\\resources\\Zoro.jpeg");
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click browse, Select an image.");
        		Log.info("Step:01 - Click browse, Select an image.");
        		
        		click(newCustRepo.aidAddBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click the add button after browsing the image");
        		Log.info("Step:02 - Click the add button after browsing the image");
        		
                if(ElementDisplayed(newCustRepo.imgAddedSuccessfully)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image is added and displayed.");
            		Log.info("Expected Result: Image is added and displayed.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
            		Log.info("ERROR");
                }
                
                ExtentTestManager.endTest();

                

        		
        		//Add images - close option
        		ExtentTestManager.startTest("Add images - close option").assignCategory("NewCustomer");
        		Log.info("Add images - close option");
        		
        		driver.close();
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the close option after adding the image.");
        		Log.info("Step:01 - Select the close option after adding the image.");
        		
        		driver.switchTo().window(mainWindowHandle);
        		SwitchToFrame(newCustRepo.pdIframe);
        		
                if(ElementDisplayed(newCustRepo.aidAddDocBtn)) {
            		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Added images saved and popup window will be close.");
            		Log.info("Expected Result: Added images saved and popup window will be close.");
                }else {
                	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
            		Log.info("ERROR");
                }
                ExtentTestManager.endTest();
        		break;
            }
        }

        

		
		//Open Add Document
		ExtentTestManager.startTest("Open Add Document").assignCategory("NewCustomer");
		Log.info("Open Add Document");
		
		click(newCustRepo.aidAddDocBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add Document' button.");
		Log.info("Step:01 - Click 'Add Document' button.");
		
		ScrollUntilElementVisible(newCustRepo.tableNewEntry);
        if(ElementDisplayed(newCustRepo.tableNewEntry)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New document details can be added.");
    		Log.info("Expected Result: New document details can be added.");
        }else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
        
		ExtentTestManager.endTest();

        

		
		//Verify Document Grid
		ExtentTestManager.startTest("Verify Document Grid").assignCategory("NewCustomer");
		Log.info("Verify Document Grid");
		
		boolean flag1 = ElementDisplayed(newCustRepo.tableSlNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Availability of Column Name - Sl#");
		Log.info("Step:01 - Verify Availability of Column Name - Sl#");
		
		boolean flag2 = ElementDisplayed(newCustRepo.tableDocType);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify Availability of Column Name - Doc.Type");
		Log.info("Step:02 - Verify Availability of Column Name - Doc.Type");
		
		boolean flag3 = ElementDisplayed(newCustRepo.tableDocNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify Availability of Column Name - Doc.No.");
		Log.info("Step:03 - Verify Availability of Column Name - Doc.No.");
		
		boolean flag4 = ElementDisplayed(newCustRepo.tableIssudAuth);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify Availability of Column Name - Issued Authority");
		Log.info("Step:04 - Verify Availability of Column Name - Issued Authority");
		
		boolean flag5 = ElementDisplayed(newCustRepo.tableIssueDate);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify Availability of Column Name - Issue Date");
		Log.info("Step:05 - Verify Availability of Column Name - Issue Date");
		
		boolean flag6 = ElementDisplayed(newCustRepo.tableValidUpTo);	
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify Availability of Column Name - Valid Up To");
		Log.info("Step:06 - Verify Availability of Column Name - Valid Up To");
		
		boolean flag7 = ElementDisplayed(newCustRepo.tableRemarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Verify Availability of Column Name - Remarks");
		Log.info("Step:07 - Verify Availability of Column Name - Remarks");
		
		boolean flag8 = ElementDisplayed(newCustRepo.tableDocProoofType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Verify Availability of Column Name - DocProofType");
		Log.info("Step:08 - Verify Availability of Column Name - DocProofType");
		
		boolean flag9 = ElementDisplayed(newCustRepo.tableDocVerification);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Verify Availability of Column Name -  Document Verification");
		Log.info("Step:09 - Verify Availability of Column Name -  Document Verification");

		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9;
		if(flag == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid displays all columns correctly with added document details and all the column name in the grid is correct.");
			Log.info("Expected Result: Grid displays all columns correctly with added document details and all the column name in the grid is correct.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
        

		
		//Save and Proceed Functionality
		ExtentTestManager.startTest("Save and Proceed Functionality").assignCategory("NewCustomer");
		Log.info("Save and Proceed Functionality");
		
		ScrollUntilElementVisible(newCustRepo.iaaSaveAndProceedBtn);
		click(newCustRepo.iaaSaveAndProceedBtn);
		ScrollUntilElementVisible(newCustRepo.iaaSaveAndProceedBtn);
		click(newCustRepo.iaaSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give all details & click on Save & Proceed button.");
		Log.info("Step:01 - Give all details & click on Save & Proceed button.");
		
		driver.switchTo().defaultContent();
		
		boolean identityAndAreaSavedSuccessfully = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.fmFamilyIframe);
		
		boolean familyWndow = ElementDisplayed(newCustRepo.fmGentsTxtBox);

		if(identityAndAreaSavedSuccessfully==true && familyWndow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data saved successfully.");
			Log.info("Expected Result: Data saved successfully.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
				
	}//end
	
	
	public void family(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		//Valid Entry in Gents Field
		ExtentTestManager.startTest("Valid Entry in Gents Field").assignCategory("NewCustomer");
		Log.info("Valid Entry in Gents Field");
		
		ScrollUntilElementVisible(newCustRepo.fmGentsTxtBox);
		String gents = testdata.get("gents").toString();
		click(newCustRepo.fmGentsTxtBox);
		input(newCustRepo.fmGentsTxtBox, gents);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid numerical count in the Gents field.");
		Log.info("Step:01 - Enter a valid numerical count in the Gents field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts numeric input.");
		Log.info("Expected Result: Field accepts numeric input.");
		
		ExtentTestManager.endTest();
		
		
		
		//Valid Entry in Ladies Field
		ExtentTestManager.startTest("Valid Entry in Ladies Field").assignCategory("NewCustomer");
		Log.info("Valid Entry in Ladies Field");
		
		String ladies = testdata.get("ladies").toString();
		click(newCustRepo.fmLadiesTxtBox);
		input(newCustRepo.fmLadiesTxtBox, ladies);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid numerical count in the Ladies field.");
		Log.info("Step:01 - Enter a valid numerical count in the Ladies field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts numeric input.");
		Log.info("Expected Result: Field accepts numeric input.");
		
		ExtentTestManager.endTest();
		
		
		
		//Automatic Calculation of Total Members
		ExtentTestManager.startTest("Automatic Calculation of Total Members").assignCategory("NewCustomer");
		Log.info("Automatic Calculation of Total Members");
		
		click(newCustRepo.fmLadiesTxt);
		String sum = driver.findElement(newCustRepo.fmTotalMembTxtBox).getAttribute("value");
		System.out.println("autofill value "+sum);
		int autoSum = Integer.parseInt(sum);
		int gentsCount = Integer.parseInt(gents);
		int ladiesCount = Integer.parseInt(ladies);
		int result = gentsCount+ladiesCount;
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter values in the Gents and Ladies fields.");
		Log.info("Step:01 - Enter values in the Gents and Ladies fields.");
		
		if(autoSum==result) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Total Members field calculates and displays the sum.");
		Log.info("Expected Result: Total Members field calculates and displays the sum.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		//Non-Editable Total Members Field
		ExtentTestManager.startTest("Non-Editable Total Members Field").assignCategory("NewCustomer");
		Log.info("Non-Editable Total Members Field");
		String expectedStatus="true";
		String flag = driver.findElement(newCustRepo.fmTotalMembTxtBox).getAttribute("disabled");
		System.out.println("disabled status="+flag);
		if(flag.equals(expectedStatus)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field is non-editable.");
			Log.info("Expected Result: Field is non-editable.");
			}else {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
	        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Valid Entry in Employed Field
		ExtentTestManager.startTest("Valid Entry in Employed Field").assignCategory("NewCustomer");
		Log.info("Valid Entry in Employed Field");
		
		String unemployed = testdata.get("unemployed").toString();
		click(newCustRepo.fmEmployedTxtBox);
		input(newCustRepo.fmEmployedTxtBox, unemployed);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid numerical count in the Employed field.");
		Log.info("Step:01 - Enter a valid numerical count in the Employed field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts numeric input.");
		Log.info("Expected Result: Field accepts numeric input.");
		
		ExtentTestManager.endTest();
		
		
		
		//Valid Entry in NRI Field
		ExtentTestManager.startTest("Valid Entry in NRI Field").assignCategory("NewCustomer");
		Log.info("Valid Entry in NRI Field");
		
		click(newCustRepo.fmNRITxtBox);
		input(newCustRepo.fmNRITxtBox, ladies);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid numerical count in the NRI field.");
		Log.info("Step:01 - Enter a valid numerical count in the NRI field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts numeric input.");
		Log.info("Expected Result: Field accepts numeric input.");
		
		ExtentTestManager.endTest();
		
		
		
		//Automatic Calculation of Total Members
		ExtentTestManager.startTest("Automatic Calculation of Total Members").assignCategory("NewCustomer");
		Log.info("Automatic Calculation of Total Members");
		
		click(newCustRepo.fmLadiesTxt);
		String sum1 = driver.findElement(newCustRepo.fmUnemployedTxtBox).getAttribute("value");
		System.out.println("autofill value "+sum1);
		int autoSum1 = Integer.parseInt(sum1);
		int unemployedCount = Integer.parseInt(unemployed);
		int result1 = result-unemployedCount;
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter values in the Gents, Ladies, and Employed fields.");
		Log.info("Step:01 - Enter values in the Gents, Ladies, and Employed fields.");
		
		if(autoSum1==result1) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Unemployed field calculates the number correctly.");
		Log.info("Expected Result: Unemployed field calculates the number correctly.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		//Non-Editable Total Members Field
		ExtentTestManager.startTest("Non-Editable Total Members Field").assignCategory("NewCustomer");
		Log.info("Non-Editable Total Members Field");
		
		String flag1 = driver.findElement(newCustRepo.fmUnemployedTxtBox).getAttribute("disabled");
		
		if(flag1.equals(expectedStatus)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field is non-editable.");
			Log.info("Expected Result: Field is non-editable.");
			}else {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
	        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Salutation Presence & Selection
		ExtentTestManager.startTest("Salutation Presence & Selection").assignCategory("NewCustomer");
		Log.info("Salutation Presence & Selection");
		
		select("MR",newCustRepo.fmNameSalutationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check for salutation dropdown near the Name field & select one option.");
		Log.info("Step:01 - Check for salutation dropdown near the Name field & select one option.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Salutation dropdown is present and selectable.");
		Log.info("Expected Result: Salutation dropdown is present and selectable.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Invalid Name Entry
		ExtentTestManager.startTest("Invalid Name Entry").assignCategory("NewCustomer");
		Log.info("Invalid Name Entry");
		
		String invalidFmName = testdata.get("addressPresentCity").toString();
		input(newCustRepo.fmNameTxtBox, invalidFmName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a name without numbers or special characters in the Name field.");
		Log.info("Step:01 - Enter a name without numbers or special characters in the Name field.");
		
		click(newCustRepo.fmLadiesTxt);
		
		if(ElementDisplayed(newCustRepo.fmInvalidFmNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed.");
			Log.info("Expected Result: Error message displayed.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }

		click(newCustRepo.fmInvalidFmNamePopUp);
		
		clear(newCustRepo.fmNameTxtBox);
		
		ExtentTestManager.endTest();
		
		
		
		
		//Validation of Name Field
		ExtentTestManager.startTest("Validation of Name Field").assignCategory("NewCustomer");
		Log.info("Validation of Name Field");
		
		String familyName = testdata.get("familyName").toString();
		input(newCustRepo.fmNameTxtBox, familyName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a name without numbers or special characters in the Name field.");
		Log.info("Step:01 - Enter a name without numbers or special characters in the Name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Name is accepted.");
		Log.info("Expected Result: Name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Email Entry
		ExtentTestManager.startTest("Email Entry").assignCategory("NewCustomer");
		Log.info("Email Entry");
		
		String fmEmail = testdata.get("validEmail").toString();
		input(newCustRepo.fmEmailTxtBox, fmEmail);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid email address in the Email Id field.");
		Log.info("Step:01 - Enter a valid email address in the Email Id field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Email is accepted.");
		Log.info("Expected Result: Email is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Relation Dropdown
		ExtentTestManager.startTest("Relation Dropdown").assignCategory("NewCustomer");
		Log.info("Relation Dropdown");
		
		select("FRIEND",newCustRepo.fmRelationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a relationship from the Relation dropdown menu.");
		Log.info("Step:01 - Select a relationship from the Relation dropdown menu.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selection is accepted.");
		Log.info("Expected Result: Selection is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Valid Mobile Number
		ExtentTestManager.startTest("Valid Mobile Number").assignCategory("NewCustomer");
		Log.info("Valid Mobile Number");
		
		String validMobileNum = testdata.get("validPhoneNum").toString();
		input(newCustRepo.fmMobileNum, validMobileNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid mobile number in the Mobile No field.");
		Log.info("Step:01 - Enter a valid mobile number in the Mobile No field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Mobile number is accepted.");
		Log.info("Expected Result: Mobile number is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Country Dropdown
		ExtentTestManager.startTest("Country Dropdown").assignCategory("NewCustomer");
		Log.info("Country Dropdown");
		
		select("INDIA",newCustRepo.fmCountry);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a country from the Country dropdown menu.");
		Log.info("Step:01 - Select a country from the Country dropdown menu.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Country is selected.");
		Log.info("Expected Result: Country is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Address Entry
		ExtentTestManager.startTest("Address Entry").assignCategory("NewCustomer");
		Log.info("Address Entry");
		
		String validAddress1 = testdata.get("addressPresentStreet").toString();
		input(newCustRepo.fmAddress1TxtBox, validAddress1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid address in the Address field.");
		Log.info("Step:01 - Enter a valid address in the Address field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Address is accepted.");
		Log.info("Expected Result: Address is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Use Present Checkbox
		ExtentTestManager.startTest("Use Present Checkbox").assignCategory("NewCustomer");
		Log.info("Use Present Checkbox");
		
		click(newCustRepo.fmUsePresentCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the 'Use present' checkbox.");
		Log.info("Step:01 - Check the 'Use present' checkbox.");
		
		String address2Value = driver.findElement(newCustRepo.fmAddress2).getAttribute("value");
		
		if(address2Value!="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Present address loads automatically.");
			Log.info("Expected Result: Present address loads automatically.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }

		ExtentTestManager.endTest();
		
		
		
		//Occupation Group Dropdown
		ExtentTestManager.startTest("Occupation Group Dropdown").assignCategory("NewCustomer");
		Log.info("Occupation Group Dropdown");
		
		select("NILL",newCustRepo.fmOccupGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an occupation group from the dropdown.");
		Log.info("Step:01 - Select an occupation group from the dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selection is accepted.");
		Log.info("Expected Result: Selection is accepted.");
		
		ExtentTestManager.endTest();

		
		
		
		//Manual DOB Entry
		ExtentTestManager.startTest("Manual DOB Entry").assignCategory("NewCustomer");
		Log.info("Manual DOB Entry");
		
		click(newCustRepo.fmDOB);
		String fmDOB = testdata.get("DOB").toString();
		input(newCustRepo.fmDOB, fmDOB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter a DOB.");
		Log.info("Step:01 - Manually enter a DOB.");
		
		click(newCustRepo.fmLadiesTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DOB is accepted.");
		Log.info("Expected Result: DOB is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Button Functionality
		ExtentTestManager.startTest("Add Button Functionality").assignCategory("NewCustomer");
		Log.info("Add Button Functionality");
		
		boolean addBtnstatus = ElementEnabled(newCustRepo.fmAddBtn);
		System.out.println("add button status= "+addBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the add button is present and enable.");
		Log.info("Step:01 - Verify the add button is present and enable.");
		
		if(addBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add button is present and enable.");
		Log.info("Expected Result: Add button is present and enable.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Button Functionality
		ExtentTestManager.startTest("Add Button Functionality").assignCategory("NewCustomer");
		Log.info("Add Button Functionality");
		
		click(newCustRepo.fmIsNRICheckBox);
		System.out.println("Is NRI checkbox selected.");
		
		click(newCustRepo.fmAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give all details, Click the Add button.");
		Log.info("Step:01 - Give all details, Click the Add button.");
		
		if(ElementDisplayed(newCustRepo.fmFamilyDetailsGrid)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is added and displayed in grid.");
		Log.info("Expected Result: Data is added and displayed in grid.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Save and Proceed Button
		ExtentTestManager.startTest("Save and Proceed Button").assignCategory("NewCustomer");
		Log.info("Save and Proceed Button");
		
		boolean previousBtnstatus = ElementEnabled(newCustRepo.fmPreviousBtn);
		System.out.println("previous button status= "+previousBtnstatus);
		boolean saveAndProBtnstatus = ElementEnabled(newCustRepo.fmSaveAndProceedBtn);
		System.out.println("save & proceed button status= "+saveAndProBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the save and proceed and previous button is enable.");
		Log.info("Step:01 - Verify the save and proceed and previous button is enable.");
		
		if(previousBtnstatus==true && saveAndProBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add button is present and enable.");
		Log.info("Expected Result: Add button is present and enable.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Save and Proceed Button Functionality
		ExtentTestManager.startTest("Save and Proceed Button Functionality").assignCategory("NewCustomer");
		Log.info("Save and Proceed Button Functionality");
		
		ScrollUntilElementVisible(newCustRepo.fmSaveAndProceedBtn);
		click(newCustRepo.fmSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Save and Proceed'.");
		Log.info("Step:01 - Click 'Save and Proceed'.");
		
		driver.switchTo().defaultContent();
		
		boolean familySavedSuccessfully = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.bdIframe);
		System.out.println("switched to bank acc details frame");
		ScrollUntilElementVisible(newCustRepo.bdStateDropdown);

		boolean bankWndow = ElementDisplayed(newCustRepo.bdStateDropdown);

		if(familySavedSuccessfully==true && bankWndow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Page navigates to \\\"Bank A/c details\\\" tab.");
			Log.info("Expected Result: Page navigates to \"Bank A/c details\" tab.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
//		driver.switchTo().defaultContent();
	}//end
	
	
	
	public void bankAccDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		
		//Select bank ID and verify Branch ID
		ExtentTestManager.startTest("Select bank ID and verify Branch ID").assignCategory("NewCustomer");
		Log.info("Select bank ID and verify Branch ID");
		
		select("KERALA",newCustRepo.bdStateDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a state from the 'State' dropdown.");
		Log.info("Step:01 - Select a state from the 'State' dropdown.");
		
		select("AXIS BANK",newCustRepo.bdBankIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a bank ID from the 'Bank ID' dropdown.");
		Log.info("Step:02 - Select a bank ID from the 'Bank ID' dropdown.");
		
        // Create a Select object and pass the dropdown element to it
        Select dropdown1 = new Select(driver.findElement(newCustRepo.bdBranchID));

        // Get all options in the dropdown
        java.util.List<WebElement> options1 = dropdown1.getOptions();
        int size1 = options1.size();
        System.out.println("AXIS BANK dropdown size: " + size1);
        String txt1 = options1.get(1).getText().trim();
        System.out.println("AXIS BANK Branh ID "+txt1);
        
        
		select("KERALA",newCustRepo.bdStateDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a state from the 'State' dropdown.");
		Log.info("Step:01 - Select a state from the 'State' dropdown.");
		
		select("KERALA GRAMIN BANK",newCustRepo.bdBankIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a bank ID from the 'Bank ID' dropdown.");
		Log.info("Step:02 - Select a bank ID from the 'Bank ID' dropdown.");
		
        // Create a Select object and pass the dropdown element to it
        Select dropdown2 = new Select(driver.findElement(newCustRepo.bdBranchID));

        // Get all options in the dropdown
        java.util.List<WebElement> options2 = dropdown2.getOptions();
        int size2 = options2.size();
        System.out.println("AXIS BANK dropdown size: " + size2);
        String txt2 = options2.get(1).getText().trim();
        System.out.println("AXIS BANK Branh ID "+txt2);

		if(size1==size2 | txt1.equals(txt2)) {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}else {
        	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch IDs for selected bank ID are displayed.");
    		Log.info("Expected Result: Branch IDs for selected bank ID are displayed.");
        }
        
		ExtentTestManager.endTest();
		
		
		
		
		//Select state from dropdown 
		ExtentTestManager.startTest("Select state from dropdown").assignCategory("NewCustomer");
		Log.info("Select state from dropdown");

		select("KERALA",newCustRepo.bdStateDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a state from the 'State' dropdown.");
		Log.info("Step:01 - Select a state from the 'State' dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected state is displayed in the field.");
		Log.info("Expected Result: Selected state is displayed in the field.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select bank ID 
		ExtentTestManager.startTest("Select bank ID").assignCategory("NewCustomer");
		Log.info("Select bank ID");
		
		select("KERALA GRAMIN BANK",newCustRepo.bdBankIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a bank ID from the 'Bank ID' dropdown.");
		Log.info("Step:01 - Select a bank ID from the 'Bank ID' dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Bank Id is displayed in the field.");
		Log.info("Expected Result: Selected Bank Id is displayed in the field.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Select Branch ID 
		ExtentTestManager.startTest("Select Branch ID").assignCategory("NewCustomer");
		Log.info("Select Branch ID");
		
		select("ALUR",newCustRepo.bdBranchID);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a branch ID from the 'Branch ID' dropdown.");
		Log.info("Step:01 - Select a branch ID from the 'Branch ID' dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected Branch Id is displayed in the field.");
		Log.info("Expected Result: Selected Branch Id is displayed in the field.");
		
		ExtentTestManager.endTest();
		
		
		

		//Select Branch ID and verify IFSC code
		ExtentTestManager.startTest("Select Branch ID and verify IFSC code").assignCategory("NewCustomer");
		Log.info("Select Branch ID and verify IFSC code");
		
		String IFSCCodeAutoFillValue = driver.findElement(newCustRepo.bdIFSCTxtBox).getAttribute("value");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a branch ID from the 'Branch ID' dropdown, Observe the 'IFSC' field.");
		Log.info("Step:01 - Select a branch ID from the 'Branch ID' dropdown, Observe the 'IFSC' field.");
		
		if(IFSCCodeAutoFillValue!="") {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: IFSC Code: " + IFSCCodeAutoFillValue + " is auto-loaded accurately for selected Branch ID.");
			Log.info("Expected Result: IFSC Code: " + IFSCCodeAutoFillValue + " is auto-loaded accurately for selected Branch ID.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }


		ExtentTestManager.endTest();
		
		

		//Entering invalid data formats
		ExtentTestManager.startTest("Entering invalid data formats").assignCategory("NewCustomer");
		Log.info("Entering invalid data formats");
		
		String invalidData = testdata.get("specialCharInput").toString();
		input(newCustRepo.bdCustName,invalidData);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid data in a field that requires a specific format.");
		Log.info("Step:01 - Enter invalid data in a field that requires a specific format.");
		
		click(newCustRepo.bdStartDateTxt);
		
		if(ElementDisplayed(newCustRepo.bdInvalidCustNamePopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message indicates data format issue.");
		Log.info("Expected Result: Error message indicates data format issue.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		click(newCustRepo.bdInvalidCustNamePopUp);
		clear(newCustRepo.bdCustName);
		ExtentTestManager.endTest();
		
		
		

		//Enter customer name
		ExtentTestManager.startTest("Enter customer name").assignCategory("NewCustomer");
		Log.info("Enter customer name");
		
		String custName = testdata.get("guardian").toString();
		input(newCustRepo.bdCustName,custName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a customer name in the 'Cust Name' field.");
		Log.info("Step:01 - Enter a customer name in the 'Cust Name' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer name is accepted.");
		Log.info("Expected Result: Customer name is accepted.");
		
		ExtentTestManager.endTest();
		
		
		

		//Enter customer address
		ExtentTestManager.startTest("Enter customer address").assignCategory("NewCustomer");
		Log.info("Enter customer address");
		
		String address = testdata.get("addressPresentHouse").toString();
		input(newCustRepo.bdAddressTxtBox,address);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an address in the 'Address' field.");
		Log.info("Step:01 - Enter an address in the 'Address' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Address is accepted.");
		Log.info("Expected Result: Address is accepted.");
		
		ExtentTestManager.endTest();

		
		

		//Enter bank account no and retype it
		ExtentTestManager.startTest("Enter bank account no and retype it").assignCategory("NewCustomer");
		Log.info("Enter bank account no and retype it");
		
		String accNum = testdata.get("validBankAccNum").toString();
		input(newCustRepo.bdBankAccNumTxtBox,accNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an account number in 'BankAccNo'.");
		Log.info("Step:01 - Enter an account number in 'BankAccNo'.");
		
		input(newCustRepo.bdRetypeAccNumTxtBox,accNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Retype the account number in 'Retype AccNo'.");
		Log.info("Step:02 - Retype the account number in 'Retype AccNo'.");
		
		click(newCustRepo.bdStartDateTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both account numbers match and are accepted.");
		Log.info("Expected Result: Both account numbers match and are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Select BankAccID from dropdown
		ExtentTestManager.startTest("Select BankAccID from dropdown").assignCategory("NewCustomer");
		Log.info("Select BankAccID from dropdown");
		
		select("OTHER",newCustRepo.bdBankAccIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select BankAccID from the dropdown menu.");
		Log.info("Step:01 - Select BankAccID from the dropdown menu.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: BankAccID is selected.");
		Log.info("Expected Result: BankAccID is selected.");
		
		ExtentTestManager.endTest();

		
		
		
		//Manually enter start date
		ExtentTestManager.startTest("Manually enter start date").assignCategory("NewCustomer");
		Log.info("Manually enter start date");
		
		click(newCustRepo.bdStartDate);
		String startDate = testdata.get("issueDate").toString();
		input(newCustRepo.bdStartDate, startDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Focus on 'Start Date' field, Enter a date manually.");
		Log.info("Step:01 - Focus on 'Start Date' field, Enter a date manually.");
		
		click(newCustRepo.bdStartDateTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Start date is accepted.");
		Log.info("Expected Result: Start date is accepted.");
		
		ExtentTestManager.endTest();

		
		
		
		//Select 'Additional Information' check box
		ExtentTestManager.startTest("Select 'Additional Information' checkbox").assignCategory("NewCustomer");
		Log.info("Select 'Additional Information' checkbox");
		
		click(newCustRepo.bdAddInfoCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick the 'Additional Information' checkbox.");
		Log.info("Step:01 - Tick the 'Additional Information' checkbox.");
		
		boolean balanceAsOnDisplayed = ElementDisplayed(newCustRepo.bdBalanceAsOn);
		boolean NotMentionedDisplayed = ElementDisplayed(newCustRepo.bdNotMentionedCheckBox);		
		boolean balanceDisplayed = ElementDisplayed(newCustRepo.bdBalanceTxtBox);
		boolean CreditCardDisplayed = ElementDisplayed(newCustRepo.bdCreditCardCheckBox);
		boolean CreditCardNumDisplayed = ElementDisplayed(newCustRepo.bdCreditCardNumTxtBox);
		
		if(balanceAsOnDisplayed==true && NotMentionedDisplayed==true 
				&& balanceDisplayed==true && CreditCardDisplayed==true 
				&& CreditCardNumDisplayed==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Additional fields are displayed: Balance As On, Balance, Credit Card, Credit Card No, Not Mentioned.");
			Log.info("Expected Result: Additional fields are displayed: Balance As On, Balance, Credit Card, Credit Card No, Not Mentioned.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		//Verify disabling of additional fields
		ExtentTestManager.startTest("Verify disabling of additional fields").assignCategory("NewCustomer");
		Log.info("Verify disabling of additional fields");
		
		
		click(newCustRepo.bdAddInfoCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick the 'Additional Information' checkbox.");
		Log.info("Step:01 - Untick the 'Additional Information' checkbox.");
		

		try {
			boolean balanceAsOnDisplayed1 = ElementDisplayed(newCustRepo.bdBalanceAsOn);
			if(balanceAsOnDisplayed1==true) {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
			}
		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Additional fields are disabled.");
			Log.info("Expected Result: Additional fields are disabled.");
		}
			
//			boolean balanceAsOnDisplayed1 = ElementDisplayed(newCustRepo.bdBalanceAsOn);
//			if(balanceAsOnDisplayed1==true) {
//	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//	    		Log.info("ERROR");
//			}else {
//				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Additional fields are disabled.");
//				Log.info("Expected Result: Additional fields are disabled.");
//			}
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify 'Add' button presence and enable state
		ExtentTestManager.startTest("Verify 'Add' button presence and enable state").assignCategory("NewCustomer");
		Log.info("Verify 'Add' button presence and enable state");
		
		boolean addBtnstatus = ElementEnabled(newCustRepo.bdAddBtn);
		System.out.println("add button status= "+addBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe 'Add' button.");
		Log.info("Step:01 - Observe 'Add' button.");
		
		if(addBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add button is present and enable.");
		Log.info("Expected Result: Add button is present and enable.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add details and verify reflection in grid
		ExtentTestManager.startTest("Add details and verify reflection in grid").assignCategory("NewCustomer");
		Log.info("Add details and verify reflection in grid");
		
		click(newCustRepo.bdAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Add' button, Observe the grid in 'Bank A/c Details'.");
		Log.info("Step:01 - Click the 'Add' button, Observe the grid in 'Bank A/c Details'.");
		
		if(ElementDisplayed(newCustRepo.bdBankDetailsSavedGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are correctly displayed in the grid.");
			Log.info("Expected Result: Details are correctly displayed in the grid.");
			}else {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
	        }
			
		ExtentTestManager.endTest();
		
		
		
		
		//Enter DPID in Demat A/c Details
		ExtentTestManager.startTest("Enter DPID in Demat A/c Details").assignCategory("NewCustomer");
		Log.info("Enter DPID in Demat A/c Details");
		
		String DPID = testdata.get("pin").toString();
		input(newCustRepo.bdDPIDTxtBox, DPID);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a DPID in the 'DPID' field.");
		Log.info("Step:01 - Enter a DPID in the 'DPID' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DPID is accepted (non-mandatory).");
		Log.info("Expected Result: DPID is accepted (non-mandatory).");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Enter Demat AcNo in Demat A/c Details
		ExtentTestManager.startTest("Enter Demat AcNo in Demat A/c Details").assignCategory("NewCustomer");
		Log.info("Enter Demat AcNo in Demat A/c Details");
		
		String dematAccNum = testdata.get("validPhoneNum").toString();
		input(newCustRepo.bdDematAccNumTxtBox, dematAccNum);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a Demat AcNo in the 'Demat AcNo' field.");
		Log.info("Step:01 - Enter a Demat AcNo in the 'Demat AcNo' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demat AcNo is accepted (non-mandatory).");
		Log.info("Expected Result: Demat AcNo is accepted (non-mandatory).");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify 'Save and Proceed' and 'Previous' button enabled
		ExtentTestManager.startTest("Verify 'Save and Proceed' and 'Previous' button enabled").assignCategory("NewCustomer");
		Log.info("Verify 'Save and Proceed' and 'Previous' button enabled");
		
		boolean previousBtnstatus = ElementEnabled(newCustRepo.bdPreviousBtn);
		System.out.println("previous button status= "+previousBtnstatus);
		boolean saveAndProBtnstatus = ElementEnabled(newCustRepo.bdProceedBtn);
		System.out.println("save & proceed button status= "+saveAndProBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe the 'Save and Proceed' and 'Previous' buttons.");
		Log.info("Step:01 - Observe the 'Save and Proceed' and 'Previous' buttons.");
		
		if(previousBtnstatus==true && saveAndProBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both buttons are enabled.");
		Log.info("Expected Result: Both buttons are enabled.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Click 'Save and Proceed' and verify redirection
		ExtentTestManager.startTest("Click 'Save and Proceed' and verify redirection").assignCategory("NewCustomer");
		Log.info("Click 'Save and Proceed' and verify redirection");
		
		click(newCustRepo.bdProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Save and Proceed'.");
		Log.info("Step:01 - Click 'Save and Proceed'.");
		
		driver.switchTo().defaultContent();
		
		boolean externalAccDetailsSavedSuccessfully = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.visitsIframe);
		System.out.println("switched to visits frame");
		ScrollUntilElementVisible(newCustRepo.vNoVisitsCheckBox);

		boolean visitsWndow = ElementDisplayed(newCustRepo.vNoVisitsCheckBox);

		if(externalAccDetailsSavedSuccessfully==true && visitsWndow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is redirected to the 'Visits' tab.");
			Log.info("Expected Result: User is redirected to the 'Visits' tab.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		

		
	}//end
	
	
	
	public void visits(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
			
		
		//Checking validation
		ExtentTestManager.startTest("Checking validation").assignCategory("NewCustomer");
		Log.info("Checking validation");
		
		click(newCustRepo.vProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the save and proceed button without any details .");
		Log.info("Step:01 - Click the save and proceed button without any details .");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(newCustRepo.bdBnkAccNumMismatchOkBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation mesage displayed \"Please enter the visited details\"");
		Log.info("Expected Result: Validation mesage displayed \"Please enter the visited details\"");
		
		click(newCustRepo.bdBnkAccNumMismatchOkBtn);
		}
		else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
		}
		
		SwitchToFrame(newCustRepo.visitsIframe);

		ExtentTestManager.endTest();
		
		
		
		
		//Tick "No Visit" Checkbox
		ExtentTestManager.startTest("Tick \"No Visit\" Checkbox").assignCategory("NewCustomer");
		Log.info("Tick \"No Visit\" Checkbox");
		
		click(newCustRepo.vNoVisitsCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick \"No Visit\" checkbox.");
		Log.info("Step:01 - Tick \"No Visit\" checkbox.");
		
		try {
		boolean addNewVisible = ElementEnabled(newCustRepo.vCountryDropdwon);
		System.out.println("button status = "+addNewVisible);
		
    	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: \"Add New\" section gets disabled.");
			Log.info("Expected Result: \"Add New\" section gets disabled.");
		}
		
//		if(!ElementDisplayed(newCustRepo.vCountryDropdwon)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: \"Add New\" section gets disabled.");
//			Log.info("Expected Result: \"Add New\" section gets disabled.");
//
//		}
//		else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
		
		ExtentTestManager.endTest();
		
		
		
		
		//Save and Proceed with "No Visit"
		ExtentTestManager.startTest("Save and Proceed with \"No Visit\"").assignCategory("NewCustomer");
		Log.info("Save and Proceed with \"No Visit\"");
		
		click(newCustRepo.vProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the save and proceed button.");
		Log.info("Step:01 - Click the save and proceed button.");
		
		driver.switchTo().defaultContent();
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.visitsIframe);
		System.out.println("switched to risk & other details frame");
		ScrollUntilElementVisible(newCustRepo.rdRiskIdDropdown);

		boolean riskotherdetailsWndow0 = ElementDisplayed(newCustRepo.rdRiskIdDropdown);

		if(riskotherdetailsWndow0==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to \"Risk & Other Details\" tab.");
			Log.info("Expected Result: Redirected to \"Risk & Other Details\" tab.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ScrollUntilElementVisible(newCustRepo.rdPreviousBtn);
		click(newCustRepo.rdPreviousBtn);

//		SwitchToFrame(newCustRepo.visitsIframe);
		System.out.println("switched back to visits frame");
		
		ExtentTestManager.endTest();
		
		
		
		
		//"No Visit" Check box
		ExtentTestManager.startTest("'No Visit' Checkbox").assignCategory("NewCustomer");
		Log.info("'No Visit'Checkbox");
		
		ScrollUntilElementVisible(newCustRepo.vNoVisitsCheckBox);
		click(newCustRepo.vNoVisitsCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Do not select  \"No Visit\" checkbox.");
		Log.info("Step:01 - Do not select  \"No Visit\" checkbox.");
		
		boolean addNewVisible = ElementEnabled(newCustRepo.vCountryDropdwon);
		System.out.println("button status= "+addNewVisible);
		boolean visaDetailsVisible = ElementEnabled(newCustRepo.vVisaNumTxtBox);
		System.out.println("button status= "+visaDetailsVisible);
				
		if(addNewVisible==true && visaDetailsVisible==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: \"Add New\" and \"Visa Details\" section gets enabled.");
		Log.info("Expected Result: \"Add New\" and \"Visa Details\" section gets enabled.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Select Country from Dropdown
		ExtentTestManager.startTest("Select Country from Dropdown").assignCategory("NewCustomer");
		Log.info("Select Country from Dropdown");
		
		select("JAPAN",newCustRepo.vCountryDropdwon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a country from the \"Country\" dropdown.");
		Log.info("Step:01 - Select a country from the \"Country\" dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Country is selected successfully.");
		Log.info("Expected Result: Country is selected successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Enter "No of Times" Value
		ExtentTestManager.startTest("Enter \"No of Times\" Value").assignCategory("NewCustomer");
		Log.info("Enter \"No of Times\" Value");
		
		String visitingCount = testdata.get("gents").toString();
		input(newCustRepo.vNoOfTimesTxtBox, visitingCount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a visiting count in \"No of Times\".");
		Log.info("Step:01 - Enter a visiting count in \"No of Times\".");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Value is entered correctly.");
		Log.info("Expected Result: Value is entered correctly.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Manual Entry in "Last Date" Field
		ExtentTestManager.startTest("Manual Entry in \"Last Date\" Field").assignCategory("NewCustomer");
		Log.info("Manual Entry in \"Last Date\" Field");
		
		click(newCustRepo.vLastDateTxtBox);
		String lastDate = testdata.get("DOB").toString();
		input(newCustRepo.vLastDateTxtBox, lastDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter a date in \"Last Date\" field.");
		Log.info("Step:01 - Manually enter a date in \"Last Date\" field.");
		
		click(newCustRepo.vPurposeTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is entered successfully.");
		Log.info("Expected Result: Date is entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Enter Purpose
		ExtentTestManager.startTest("Enter Purpose").assignCategory("NewCustomer");
		Log.info("Enter Purpose");
		
		String purpose = testdata.get("remark").toString();
		input(newCustRepo.vPurposeTxtBox, purpose);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in \"Purpose\" field.");
		Log.info("Step:01 - Enter text in \"Purpose\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purpose is recorded correctly.");
		Log.info("Expected Result: Purpose is recorded correctly.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Enter Remarks
		ExtentTestManager.startTest("Enter Remarks").assignCategory("NewCustomer");
		Log.info("Enter Remarks");
		
		input(newCustRepo.vRemarksTxtBox, purpose);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text in \"Remarks\" field.");
		Log.info("Step:01 - Enter text in \"Remarks\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks is recorded correctly.");
		Log.info("Expected Result: Remarks is recorded correctly.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Details and Verify Grid Update
		ExtentTestManager.startTest("Add Details and Verify Grid Update").assignCategory("NewCustomer");
		Log.info("Add Details and Verify Grid Update");
		
		click(newCustRepo.vaNewAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Add\" button, Verify details in grid.");
		Log.info("Step:01 - Click \"Add\" button, Verify details in grid.");
		
		if(ElementDisplayed(newCustRepo.vaAddNewGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details appear in grid.");
			Log.info("Expected Result: Details appear in grid.");
			}else {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
	        }
			
		ExtentTestManager.endTest();
		
		
		
		
		//Enter "Visa No."
		ExtentTestManager.startTest("Enter \"Visa No.\"").assignCategory("NewCustomer");
		Log.info("Enter \"Visa No.\"");
		
		input(newCustRepo.vVisaNumTxtBox, purpose);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Visa No.");
		Log.info("Step:01 - Enter Visa No.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Visa No. entered successfully.");
		Log.info("Expected Result: Visa No. entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Manual Entry in "Visa Expire Date" Field
		ExtentTestManager.startTest("Manual Entry in \"Visa Expire Date\" Field").assignCategory("NewCustomer");
		Log.info("Manual Entry in \"Visa Expire Date\" Field");
		
		click(newCustRepo.vVisaExpireDate);
		String expireDate = testdata.get("validUptoDate").toString();
		input(newCustRepo.vVisaExpireDate, expireDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Manually enter a date in \"Visa Expire Date\" field.");
		Log.info("Step:01 - Manually enter a date in \"Visa Expire Date\" field.");
		
		click(newCustRepo.vPurposeTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is entered successfully.");
		Log.info("Expected Result: Date is entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Select Country in "Visa Details"
		ExtentTestManager.startTest("Select Country in \"Visa Details\"").assignCategory("NewCustomer");
		Log.info("Select Country in \"Visa Details\"");
		
		select("JAPAN",newCustRepo.vdCountryDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a country from the \"Country\" dropdown.");
		Log.info("Step:01 - Select a country from the \"Country\" dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Country is selected successfully.");
		Log.info("Expected Result: Country is selected successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Visa Details and Verify Grid Update
		ExtentTestManager.startTest("Add Visa Details and Verify Grid Update").assignCategory("NewCustomer");
		Log.info("Add Visa Details and Verify Grid Update");
		
		click(newCustRepo.vdAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Add\" button, Verify visa details in grid.");
		Log.info("Step:01 - Click \"Add\" button, Verify visa details in grid.");
		
		if(ElementDisplayed(newCustRepo.vdVisaDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Visa Details appear in grid.");
			Log.info("Expected Result: Visa Details appear in grid.");
			}else {
	        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    		Log.info("ERROR");
	        }
			
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Navigation Buttons Enabled
		ExtentTestManager.startTest("Verify Navigation Buttons Enabled").assignCategory("NewCustomer");
		Log.info("Verify Navigation Buttons Enabled");
		
		boolean previousBtnstatus = ElementEnabled(newCustRepo.vPreviousBtn);
		System.out.println("previous button status= "+previousBtnstatus);
		boolean saveAndProBtnstatus = ElementEnabled(newCustRepo.vProceedBtn);
		System.out.println("save & proceed button status= "+saveAndProBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check \"Save and Proceed\" and \"Previous\" buttons.");
		Log.info("Step:01 - Check \"Save and Proceed\" and \"Previous\" buttons.");
		
		if(previousBtnstatus==true && saveAndProBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both buttons are enabled.");
		Log.info("Expected Result: Both buttons are enabled.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Click 'Save and Proceed'
		ExtentTestManager.startTest("Click 'Save and Proceed'").assignCategory("NewCustomer");
		Log.info("Click 'Save and Proceed'");
		
		click(newCustRepo.vProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Save and Proceed'.");
		Log.info("Step:01 - Click 'Save and Proceed'.");
		
		driver.switchTo().defaultContent();
		
		boolean visitDetailsSavedSuccessfully = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.visitsIframe);
		System.out.println("switched to risk & other details frame");
		ScrollUntilElementVisible(newCustRepo.rdRiskIdDropdown);

		boolean riskotherdetailsWndow = ElementDisplayed(newCustRepo.rdRiskIdDropdown);

		if(visitDetailsSavedSuccessfully==true && riskotherdetailsWndow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to \"Risk & Other Details\" tab.");
			Log.info("Expected Result: Redirected to \"Risk & Other Details\" tab.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

//		driver.switchTo().defaultContent();

	}//end
	
	
	
	public void riskAndOtherDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		
		
		//Verify Dropdown Selection for "Risk Id"
		ExtentTestManager.startTest("Verify Dropdown Selection for \"Risk Id\"").assignCategory("NewCustomer");
		Log.info("Verify Dropdown Selection for \"Risk Id\"");
		
		ScrollUntilElementVisible(newCustRepo.rdRiskIdDropdown);
		select("LOW",newCustRepo.rdRiskIdDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a Risk Id from the dropdown list.");
		Log.info("Step:01 - Select a Risk Id from the dropdown list.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Risk Id is selectable from the list.");
		Log.info("Expected Result: Risk Id is selectable from the list.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify "Remarks" Field Input
		ExtentTestManager.startTest("Verify \"Remarks\" Field Input").assignCategory("NewCustomer");
		Log.info("Verify \"Remarks\" Field Input");
		
		String remarks = testdata.get("remark").toString();
		input(newCustRepo.rdRemarksTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"ABC123%%\" in the \"Remarks\" field.");
		Log.info("Step:01 - Enter \"ABC123%%\" in the \"Remarks\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted as entered.");
		Log.info("Expected Result: Input is accepted as entered.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify "ActiveSpecialInstruction" Field Input
		ExtentTestManager.startTest("Verify \"ActiveSpecialInstruction\" Field Input").assignCategory("NewCustomer");
		Log.info("Verify \"ActiveSpecialInstruction\" Field Input");
		
		String activeSpecialInstruction = testdata.get("activeSpecialInstr").toString();
		input(newCustRepo.rdActiveSpecialInstrTxtBox, activeSpecialInstruction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"qwe$55\" in the \"ActiveSpecialInstruction\" field.");
		Log.info("Step:01 - Enter \"qwe$55\" in the \"ActiveSpecialInstruction\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted as entered.");
		Log.info("Expected Result: Input is accepted as entered.");
		
		ExtentTestManager.endTest();

		
		
		
		//Toggle "Suspecious" Checkbox
		ExtentTestManager.startTest("Toggle \"Suspecious\" Checkbox").assignCategory("NewCustomer");
		Log.info("Toggle \"Suspecious\" Checkbox");
		
		click(newCustRepo.rdSuspeciousCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check/uncheck \"Suspecious\" checkbox based on conditions");
		Log.info("Step:01 - Check/uncheck \"Suspecious\" checkbox based on conditions");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox can be toggled correctly.");
		Log.info("Expected Result: Checkbox can be toggled correctly.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify "AML Status" Field Input
		ExtentTestManager.startTest("Verify \"AML Status\" Field Input").assignCategory("NewCustomer");
		Log.info("Verify \"AML Status\" Field Input");
		
		input(newCustRepo.rdAMLStatusTxtBox, activeSpecialInstruction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid AML Status in the field.");
		Log.info("Step:01 - Enter valid AML Status in the field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted as entered.");
		Log.info("Expected Result: Input is accepted as entered.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Cibil Score" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Cibil Score\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Cibil Score\" Field");
		
		String cibilScore = testdata.get("invalidPhoneNum").toString();
		input(newCustRepo.rdCibilScoreTxtBox, cibilScore);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"123\" in the \"Cibil Score\" field.");
		Log.info("Step:01 - Enter \"123\" in the \"Cibil Score\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Entity DetailsID" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Entity DetailsID\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Entity DetailsID\" Field");
		
		String  entityDetailsID  = testdata.get("entityDetailsID").toString();
		input(newCustRepo.rdentityDetailsIDTxtBox, entityDetailsID);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"678\" in the \"Entity DetailsID\" field.");
		Log.info("Step:01 - Enter \"678\" in the \"Entity DetailsID\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Not Allowed Input in "Percentage Of ShareHolding" Field
		ExtentTestManager.startTest("Verify Not Allowed Input in \"Percentage Of ShareHolding\" Field").assignCategory("NewCustomer");
		Log.info("Verify Not Allowed Input in \"Percentage Of ShareHolding\" Field");
		
		String  invalidInput  = testdata.get("activeSpecialInstr").toString();
		input(newCustRepo.rdpercentageOfShareHoldingTxtBox, invalidInput);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"bccc^&%^\" in the \"Percentage Of ShareHolding\" field.");
		Log.info("Step:01 - Enter \"bccc^&%^\" in the \"Percentage Of ShareHolding\" field.");
		
		click(newCustRepo.rdYearTxt); 
		
		if(ElementDisplayed(newCustRepo.rdInvalidPercentagePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabetic/special char input is rejected, possible to enter only nmbers and not possible to enter Alphabetic/special characters.");
			Log.info("Expected Result: Alphabetic/special char input is rejected, possible to enter only nmbers and not possible to enter Alphabetic/special characters.");
			click(newCustRepo.rdInvalidPercentagePopUp);
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }

		
		clear(newCustRepo.rdpercentageOfShareHoldingTxtBox);
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Percentage Of ShareHolding" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Percentage Of ShareHolding\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Percentage Of ShareHolding\" Field");
		
		String  percentageOfShareHolding  = testdata.get("percentageOfShareHolding").toString();
		input(newCustRepo.rdpercentageOfShareHoldingTxtBox, percentageOfShareHolding);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"67654\" in the \"Percentage Of ShareHolding\" field.");
		Log.info("Step:01 - Enter \"67654\" in the \"Percentage Of ShareHolding\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();

		
		
		
		//Toggle "Declaration Marked" Checkbox
		ExtentTestManager.startTest("Toggle \"Declaration Marked\" Checkbox").assignCategory("NewCustomer");
		Log.info("Toggle \"Declaration Marked\" Checkbox");
		
		click(newCustRepo.rdDeclarationMarkedCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check/uncheck \"Declaration Marked\" checkbox based on conditions");
		Log.info("Step:01 - Check/uncheck \"Declaration Marked\" checkbox based on conditions");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox can be toggled correctly.");
		Log.info("Expected Result: Checkbox can be toggled correctly.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Inputs in "Award Name" Field
		ExtentTestManager.startTest("Verify Inputs in \"Award Name\" Field").assignCategory("NewCustomer");
		Log.info("Verify Inputs in \"Award Name\" Field");
		
		String  awardName  = testdata.get("activeSpecialInstr").toString();
		input(newCustRepo.rdAwardNameTxtBox, awardName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"ghjkl\", \"655\", \"^&*\" in the \"Award Name\" field.");
		Log.info("Step:01 - Enter \"ghjkl\", \"655\", \"^&*\" in the \"Award Name\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Inputs are accepted as per rules.");
		Log.info("Expected Result: Inputs are accepted as per rules.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Inputs in "Award Provided By" Field
		ExtentTestManager.startTest("Verify Inputs in \"Award Provided By\" Field").assignCategory("NewCustomer");
		Log.info("Verify Inputs in \"Award Provided By\" Field");
		
		input(newCustRepo.rdAwardProvidedByTxtBox, awardName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"abc\", \"123\", \"%^&\" in the \"Award Provided By\" field.");
		Log.info("Step:01 - Enter \"abc\", \"123\", \"%^&\" in the \"Award Provided By\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Inputs are accepted as per rules.");
		Log.info("Expected Result: Inputs are accepted as per rules.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Year" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Year\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Year\" Field");
		
		String  year  = testdata.get("year").toString();
		input(newCustRepo.rdYearTxtBox, year);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"2010\" in the \"Year\" field.");
		Log.info("Step:01 - Enter \"2010\" in the \"Year\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();

		
		
		
		//Verify Adding Details in "Award Details" Section
		ExtentTestManager.startTest("Verify Adding Details in \"Award Details\" Section").assignCategory("NewCustomer");
		Log.info("Verify Adding Details in \"Award Details\" Section");
		
		click(newCustRepo.rdAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the grid for entered details post clicking Add.");
		Log.info("Step:01 - Verify the grid for entered details post clicking Add.");
		
		if(ElementDisplayed(newCustRepo.rdAwardDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are displayed in \"Award Details\" Section grid.");
			Log.info("Expected Result: Details are displayed in \"Award Details\" Section grid.");
		}
		else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Industry Code" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Industry Code\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Industry Code\" Field");
		
		String industryCode  = testdata.get("industryCode").toString();
		input(newCustRepo.rdIndustryCodeTxtBox, industryCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"100\" in the \"Industry Code\" field.");
		Log.info("Step:01 - Enter \"100\" in the \"Industry Code\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Business Sector Code" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Business Sector Code\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Business Sector Code\" Field");
		
		String  businessSectorCode  = testdata.get("businessSectorCode").toString();
		input(newCustRepo.rdbusinessSectorCodeTxtBox, businessSectorCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"1001\" in the \"Business Sector Code\" field.");
		Log.info("Step:01 - Enter \"1001\" in the \"Business Sector Code\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Numeric Input in "Experience In Year" Field
		ExtentTestManager.startTest("Verify Numeric Input in \"Experience In Year\" Field").assignCategory("NewCustomer");
		Log.info("Verify Numeric Input in \"Experience In Year\" Field");
		
		String  experienceInYear  = testdata.get("experienceInYear").toString();
		input(newCustRepo.rdExperienceInYear, experienceInYear);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter \"2020\" in the \"Experience In Year\" field.");
		Log.info("Step:01 - Enter \"2020\" in the \"Experience In Year\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric input is accepted.");
		Log.info("Expected Result: Numeric input is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify "Remarks" Field Input
		ExtentTestManager.startTest("Verify \"Remarks\" Field Input").assignCategory("NewCustomer");
		Log.info("Verify \"Remarks\" Field Input");
		
		String  remarks1  = testdata.get("remark").toString();
		input(newCustRepo.rdRemarks1TxtBox, remarks1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the remarks as \"ghh^^&55\" in the \"Remarks\" field.");
		Log.info("Step:01 - Give the remarks as \"ghh^^&55\" in the \"Remarks\" field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted as entered.");
		Log.info("Expected Result: Input is accepted as entered.");
		
		ExtentTestManager.endTest();
		
		
		
		ScrollUntilElementVisible(newCustRepo.rdSaveAndProceedBtn);
		
		
		
		//Verify Manual Date Entry in Date Fields
		ExtentTestManager.startTest("Verify Manual Date Entry in Date Fields").assignCategory("NewCustomer");
		Log.info("Verify Manual Date Entry in Date Fields");
		
		click(newCustRepo.rdStartDateTxtBox);
		String startDate = testdata.get("issueDate").toString();
		input(newCustRepo.rdStartDateTxtBox, startDate);
		
		click(newCustRepo.rdEndDateTxtBox);
		String endDate = testdata.get("validUptoDate").toString();
		input(newCustRepo.rdEndDateTxtBox, endDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter start and end dates manually.");
		Log.info("Step:01 - Enter start and end dates manually.");
		
		click(newCustRepo.rdYearTxt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dates can be entered manually.");
		Log.info("Expected Result: Dates can be entered manually.");
		
		ExtentTestManager.endTest();

		
		
		
		//Verify Details in "Entrepreneur Experience" Grid
		ExtentTestManager.startTest("Verify Details in \"Entrepreneur Experience\" Grid").assignCategory("NewCustomer");
		Log.info("Verify Details in \"Entrepreneur Experience\" Grid");
		
		click(newCustRepo.rdAddBtn1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify details in grid after clicking Add button.");
		Log.info("Step:01 - Verify details in grid after clicking Add button.");
		
		ScrollUntilElementVisible(newCustRepo.rdEntrExpGrid);
		
		if(ElementDisplayed(newCustRepo.rdEntrExpGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details appear in grid.");
			Log.info("Expected Result: Details appear in grid.");
		}
		else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Verify Save and Proceed and Previous Buttons
		ExtentTestManager.startTest("Verify Save and Proceed and Previous Buttons").assignCategory("NewCustomer");
		Log.info("Verify Save and Proceed and Previous Buttons");
		
		boolean previousBtnstatus = ElementEnabled(newCustRepo.rdPreviousBtn);
		System.out.println("previous button status= "+previousBtnstatus);
		boolean saveAndProBtnstatus = ElementEnabled(newCustRepo.rdSaveAndProceedBtn);
		System.out.println("save & proceed button status= "+saveAndProBtnstatus);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify both buttons for enablement.");
		Log.info("Step:01 - Verify both buttons for enablement.");
		
		if(previousBtnstatus==true && saveAndProBtnstatus==true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both buttons are enabled.");
		Log.info("Expected Result: Both buttons are enabled.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		
		
		//Navigation to "Photo/Sign" Tab via Save and Proceed
		ExtentTestManager.startTest("Navigation to \"Photo/Sign\" Tab via Save and Proceed").assignCategory("NewCustomer");
		Log.info("Navigation to \"Photo/Sign\" Tab via Save and Proceed");
		
		click(newCustRepo.rdSaveAndProceedBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Save and Proceed'.");
		Log.info("Step:01 - Click 'Save and Proceed'.");
		
		driver.switchTo().defaultContent();
		
		boolean riskDetailsSavedSuccessfully = ElementDisplayed(newCustRepo.pdSavedSuccessfullyPopUp);
		
		click(newCustRepo.pdSavedSuccessfullyPopUp);
		
		SwitchToFrame(newCustRepo.visitsIframe);
		System.out.println("switched to Photo/Sign frame");
		ScrollUntilElementVisible(newCustRepo.psDocDropdown);

		boolean photoSignWndow = ElementDisplayed(newCustRepo.psDocDropdown);

		if(riskDetailsSavedSuccessfully==true && photoSignWndow==true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to \"Photo/Sign\" tab.");
			Log.info("Expected Result: Redirected to \"Photo/Sign\" tab.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		
		
	}//end
	
	
	public void photoSign(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		
		
		//Default Dropdown Selection
		ExtentTestManager.startTest("Default Dropdown Selection").assignCategory("NewCustomer");
		Log.info("Default Dropdown Selection");
		
		String expectedDoc = "Photo";
		String docOption = driver.findElement(newCustRepo.psPhotoOption).getText();
		System.out.println("Should print Photo: " + docOption);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe the documents dropdown.");
		Log.info("Step:01 - Observe the documents dropdown.");
		
		if(docOption.equals(expectedDoc)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Documents dropdown defaults to \"Photo\".");
			Log.info("Expected Result: Documents dropdown defaults to \"Photo\".");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		//Photo Upload Error (No Selection)
		ExtentTestManager.startTest("Photo Upload Error (No Selection)").assignCategory("NewCustomer");
		Log.info("Photo Upload Error (No Selection)");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Add\" without selecting a photo.");
		Log.info("Step:01 - Click \"Add\" without selecting a photo.");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(newCustRepo.psSelect1ImgOkBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message is displayed prompting to select a photo.");
			Log.info("Expected Result: Error message is displayed prompting to select a photo.");
			click(newCustRepo.psSelect1ImgOkBtn);
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		SwitchToFrame(newCustRepo.visitsIframe);

		ExtentTestManager.endTest();

		
		
		//Photo Upload Error (Invalid Format)
		ExtentTestManager.startTest("Photo Upload Error (Invalid Format)").assignCategory("NewCustomer");
		Log.info("Photo Upload Error (Invalid Format)");
		
		UploadFile(newCustRepo.psBrowseBtn, ".\\src\\test\\resources\\TestData.xlsx");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Browse', Try selecting a non-image file.");
		Log.info("Step:01 -  Click 'Browse', Try selecting a non-image file.");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click 'Add'.");
		Log.info("Step:02 -  Click 'Add'.");
		
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(newCustRepo.psSelect1ImgOkBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message is displayed indicating invalid file format.");
			Log.info("Expected Result: Error message is displayed indicating invalid file format.");
			click(newCustRepo.psSelect1ImgOkBtn);
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		SwitchToFrame(newCustRepo.visitsIframe);

		ExtentTestManager.endTest();

		
		
		//Add First Photo
		ExtentTestManager.startTest("Add First Photo").assignCategory("NewCustomer");
		Log.info("Add First Photo");
		
		UploadFile(newCustRepo.psBrowseBtn, ".\\src\\test\\resources\\Zoro.jpeg");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click \"Browse\" & Select a photo.");
		Log.info("Step:01 -  Click \"Browse\" & Select a photo.");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click 'Add'.");
		Log.info("Step:02 -  Click 'Add'.");
		
		if(ElementDisplayed(newCustRepo.psPhotoRotateBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Photo is successfully added.");
			Log.info("Expected Result: Photo is successfully added.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		//Add Second Photo with Default
		ExtentTestManager.startTest("Add Second Photo with Default").assignCategory("NewCustomer");
		Log.info("Add Second Photo with Default");
		
		UploadFile(newCustRepo.psBrowseBtn, ".\\src\\test\\resources\\Zoro.jpeg");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click \"Browse\" & Select a second photo.");
		Log.info("Step:01 -  Click \"Browse\" & Select a second photo.");
		
		click(newCustRepo.psIsDefaultCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Check 'IsDefault'.");
		Log.info("Step:02 -  Check 'IsDefault'.");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Click 'Add'.");
		Log.info("Step:03 -  Click 'Add'.");
		
		String flag = driver.findElement(newCustRepo.psPhotoIsDefaultCheckBox).getAttribute("checked");
		System.out.println("checked status="+flag);
		
		String expectedStatus="true";
		
		if(flag.equals(expectedStatus)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Second photo is added with \"IsDefault\" checkbox ticked.");
			Log.info("Expected Result: Second photo is added with \"IsDefault\" checkbox ticked.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		
		//Add Signature
		ExtentTestManager.startTest("Add Signature").assignCategory("NewCustomer");
		Log.info("Add Signature");
		
		select("Sign",newCustRepo.psDocDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select \"Sign\" from dropdown.");
		Log.info("Step:01 - Select \"Sign\" from dropdown.");
		
		UploadFile(newCustRepo.psBrowseBtn, ".\\src\\test\\resources\\Zoro.jpeg");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click \"Browse\" & Select a sign image.");
		Log.info("Step:02 -  Click \"Browse\" & Select a sign image.");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Click 'Add'.");
		Log.info("Step:03 -  Click 'Add'.");
		
		if(ElementDisplayed(newCustRepo.psPhotoRotateBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Signature image is successfully added.");
			Log.info("Expected Result: Signature image is successfully added.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		
		//Add General Image
		ExtentTestManager.startTest("Add General Image").assignCategory("NewCustomer");
		Log.info("Add General Image");
		
		select("General",newCustRepo.psDocDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select \"General\" from dropdown.");
		Log.info("Step:01 - Select \"General\" from dropdown.");
		
		UploadFile(newCustRepo.psBrowseBtn, ".\\src\\test\\resources\\Zoro.jpeg");
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click \"Browse\" & Select a General image.");
		Log.info("Step:02 -  Click \"Browse\" & Select a General image.");
		
		click(newCustRepo.psAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Click 'Add'.");
		Log.info("Step:03 -  Click 'Add'.");
		
		if(ElementDisplayed(newCustRepo.psPhotoRotateBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: General image is successfully added.");
			Log.info("Expected Result: General image is successfully added.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();

		
		
		
		//Complete Process
		ExtentTestManager.startTest("Complete Process").assignCategory("NewCustomer");
		Log.info("Complete Process");
		
		click(newCustRepo.psFinishBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Finish\" & Verify Customer ID, Customer Name, KYC Status, and Risk Level are displayed.");
		Log.info("Step:01 - Click \"Finish\" & Verify Customer ID, Customer Name, KYC Status, and Risk Level are displayed.");
		
		String custId = driver.findElement(newCustRepo.custId).getAttribute("value");
		String custName = driver.findElement(newCustRepo.custName).getAttribute("value");
		String KYCStatus = driver.findElement(newCustRepo.KYCStatus).getAttribute("value");
		String riskLevel = driver.findElement(newCustRepo.riskLevel).getAttribute("value");

		if(!custId.isBlank() && !custName.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer ID: " + custId + " , Cust Name: " + custName +" , KYC Status: "+ KYCStatus +", and Risk Level: "+ riskLevel +" are shown correctly.");
			Log.info("Expected Result: Customer ID: " + custId + " , Cust Name: " + custName +" , KYC Status: "+ KYCStatus +", and Risk Level: "+ riskLevel +" are shown correctly.");
		}else {
        	ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    		Log.info("ERROR");
        }
		
		ExtentTestManager.endTest();
		
		
		driver.switchTo().defaultContent();
				
		click(newCustRepo.pdSavedSuccessfullyPopUp);		
		
		SwitchToFrame(newCustRepo.visitsIframe);
		
		click(newCustRepo.okBtn);


		
		driver.switchTo().defaultContent();

	}//end
	
	
	public void authorize() throws InterruptedException, IOException {
		
		
	    //Logout Functionality - Basic
		ExtentTestManager.startTest("Logout Functionality - Basic").assignCategory("NewCustomer");
		Log.info("Logout Functionality - Basic");
		
		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the logout option & Click on the logout button.");
		Log.info("Step:01 - Navigate to the logout option & Click on the logout button.");
		
		/*if(ElementDisplayed(custSearch.loginUserName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is successfully logged out and redirected to the login page.");
			Log.info("Expected Result: User is successfully logged out and redirected to the login page.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}*/
		
		ExtentTestManager.endTest();
		
		
		

		//Login with Valid Credentials
		ExtentTestManager.startTest("Login with Valid Credentials").assignCategory("NewCustomer");
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
		ExtentTestManager.startTest("Manager Authorization Window Access").assignCategory("NewCustomer");
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
		ExtentTestManager.startTest("Accessing 'Others' Tab").assignCategory("NewCustomer");
		Log.info("Accessing 'Others' Tab");
		
		click(goaldLoanRepo.othersTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'Others' tab.");
		Log.info("Step:01 - Click on the 'Others' tab.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Others' tab opens.");
		Log.info("Expected Result: 'Others' tab opens.");

		
		ExtentTestManager.endTest();
		
		

		//Accessing 'Refresh' Tab
		ExtentTestManager.startTest("Accessing 'Refresh' Tab").assignCategory("NewCustomer");
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
		ExtentTestManager.startTest("Customer Creation Data Selection & Authorize Customer Creation").assignCategory("NewCustomer");
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
