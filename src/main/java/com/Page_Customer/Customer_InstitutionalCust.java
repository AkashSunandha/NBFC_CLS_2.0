
package com.Page_Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bouncycastle.its.bc.BcITSContentSigner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepository_Cust_InstitutionalCust;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_InstitutionalCust extends Base_Class {

	PageRepository_Cust_InstitutionalCust institutionalCust = new PageRepository_Cust_InstitutionalCust();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();


	String query="Exec Getcustomer 102";
	String columnName="CustomerID";
	String transactionID;

	//TC-02 (3)
	public void userLogin(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("TC No. - 02 --> User Login");
	//	String loginUserName = testdata.get("loginUserName").toString();
		String loginUserName=configloader().getProperty("UserName");
		input(institutionalCust.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter valid username.");
		Log.info("Step-1: Enter valid username.");

	//	String loginValidPassword = testdata.get("loginValidPassword").toString();
		String loginValidPassword=configloader().getProperty("Password");
		input(institutionalCust.loginPasswrd, loginValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Enter valid password.");
		Log.info("Step-2: Enter valid password.");

		click(institutionalCust.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on 'Login'.");
		Log.info("Step-3: Click on 'Login'.");
		Thread.sleep(10000);
		//		boolean flag1 = ElementDisplayed(institutionalCust.dashboard);
		//		boolean flag = flag1;
		//		if(flag == true) {
		//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully.");
		Log.info("Expected Result: User is logged in successfully.");
		//}
		ExtentTestManager.endTest();
	}

	//TC-03 (3)
	public void testOpenInstitutionalCustomerWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 03 --> Open Institutional Customer Window");
		click(institutionalCust.customer);
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Navigate to 'Customer'.");
		Log.info("Step1: Navigate to 'Customer'.");

		click(institutionalCust.institutionalCustomer);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Select 'Institutional Customer'.");
		Log.info("Step-2: Select 'Institutional Customer'.");

		SwitchToFrame(institutionalCust.frame);
		ElementDisplayed(institutionalCust.institutionalDetails);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Resut: Institutional Customer window opens successfully.");
		Log.info("Expected Resut: Institutional Customer window opens successfully.");

		ExtentTestManager.endTest();
	}


	//TC-05 (1)
	public void testModuleNameIsNewCustomer() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 05 --> Verify Module Name");

		ElementDisplayed(institutionalCust.firstName);
	
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Check module name displayed at the top.");
		Log.info("Step1: Check module name displayed at the top.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Resut: Module name is displayed as 'New Customer'.");
		Log.info("Expected Resut: Module name is displayed as 'New Customer'.");

		ExtentTestManager.endTest();
	}

	//TC-07 (1)
	public void testInstitutionDetailsSectionPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 07 --> Verify Institution Details Section");

		Thread.sleep(5000);

		ElementDisplayed(institutionalCust.firstName);
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Check for the presence of 'Institution Details' section.");
		Log.info("Step1: Check for the presence of 'Institution Details' section.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Resut: 'Institution Details' section is present.");
		Log.info("Expected Resut: 'Institution Details' section is present.");

		ExtentTestManager.endTest();
	}

	//TC-08 (1)
	public void testStartDateFieldPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 08 --> Verify Start Date Field Presence");

		ElementDisplayed(institutionalCust.start_date);
		ExtentTestManager.getTest().log(Status.PASS, "Step1:  Check the presence of 'Start Date' field.");
		Log.info("Step1:  Check the presence of 'Start Date' field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Resut: 'Start Date' field is present.");
		Log.info("Expected Resut: 'Start Date' field is present.");


		ExtentTestManager.endTest();
	}


	//TC-09 (1)
	public void testStartDateFormat() {
		ExtentTestManager.startTest("TC No. - 09 --> Start Date Field - Date Format");
		String date=driver.findElement(institutionalCust.start_date_textbox).getAttribute("value");

		System.out.println(date);
		ExtentTestManager.getTest().log(Status.PASS, "Step1:  Check display format of 'Start Date' field.");
		Log.info("Step1:  Check display format of 'Start Date' field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Resut: 'Start Date' field is displayed in date format.");
		Log.info("Expected Resut: 'Start Date' field is displayed in date format.");
		ExtentTestManager.endTest();
	}




	//TC-10 (1)
	public void testStartDateFieldNotEditable() {
		ExtentTestManager.startTest("TC No. - 10 --> Start Date Field - No Editing");

		if(driver.findElement(institutionalCust.disable_textfield).isEnabled()) {

			Log.info("Editing is possible");

		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step1: Try to edit 'Start Date' field.");
			Log.info("Step1: Try to edit 'Start Date' field.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Editing is not possible");
			Log.info("Expected Result: Editing is not possible");
		}

		ExtentTestManager.endTest();
	}

	//TC-12 (1)
	public void verifyFirstNameFieldPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 12 --> First Name Field Presence");
		if(ElementDisplayed(institutionalCust.firstName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step1: Check the presence of 'First Name' field.");
			Log.info("Step1: Check the presence of 'First Name' field.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'First Name' field is present.");
			Log.info("Expected Result: 'First Name' field is present.");

		}
		ExtentTestManager.endTest();
	}

	//TC-14 (1)
	public void testFirstNameField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 14 --> First Name Field - Text Entry");
		String firstName = testdata.get("firstName").toString();
		input(institutionalCust.fisrtName_textbox, firstName);

		ExtentTestManager.getTest().log(Status.PASS, "Step1: Enter alphabets.");
		Log.info("Step1: Enter alphabets.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in the 'First Name' field.");
		Log.info("Expected Result: All inputs are possible in the 'First Name' field.");
		ExtentTestManager.endTest();
	}



	/////////
	//TC-17 (2)
	public void testDisplayNameAutoLoad(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 17 --> Display Name Field Autoload");
		String firstName = testdata.get("firstName").toString();
		//input(institutionalCust.fisrtName_textbox, firstName);
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Enter 'First Name'.");
		Log.info("Step1: Enter 'First Name'.");

		String text=driver.findElement(institutionalCust.displayName).getAttribute("value");
		System.out.println(text);
		if(text.equalsIgnoreCase(firstName)) {


			ExtentTestManager.getTest().log(Status.PASS, "Step 2:Check 'Display Name'.");
			Log.info("Step 2:Check 'Display Name'.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Display Name' auto-loads with 'First Name'.");
			Log.info("Expected Result: 'Display Name' auto-loads with 'First Name'.");
		}

		ExtentTestManager.endTest();
	}

	//TC-18 (1)
	public void testConstTypeFieldPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 18 --> Const Type Field Presence");
		ElementDisplayed(institutionalCust.ConstType_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Check the presence of 'Const Type' field.");
		Log.info("Step 1:Check the presence of 'Const Type' field.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Const Type' field is present.");
		Log.info("Expected Result: 'Const Type' field is present.");
		ExtentTestManager.endTest();
	}

	//TC-19 (2)
	public void testConstTypeDropdownOptions() {

		ExtentTestManager.startTest("TC No. - 19 --> Const Type Field - Dropdown Options");
		List<WebElement> constTypeOptions = driver.findElements(By.xpath("//select[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlConstType_ddl']/option"));

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Open 'Const Type' dropdown.");
		Log.info("Step 1:Open 'Const Type' dropdown.");

		for (WebElement constTypeOption : constTypeOptions) {

			System.out.println(constTypeOption.getText());
		}	

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:Check available options.");
		Log.info("Step 2:Check available options.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown lists valid Const Types.");
		Log.info("Expected Result: Dropdown lists valid Const Types.");

		ExtentTestManager.endTest();
	}


	//TC-20 (2)
	public void testSelectConstType() {
		ExtentTestManager.startTest("TC No. - 20 --> Select Const Type from Dropdown");
		List<WebElement> constTypeOptions = driver.findElements(By.xpath("//select[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlConstType_ddl']/option"));
		for (WebElement constTypeOption : constTypeOptions) {

			if(constTypeOption.getText().equalsIgnoreCase("JOINT LIABILITY GROUP")) {
				constTypeOption.click();
			}
		}	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Select an option from 'Const Type' dropdown.");
		Log.info("Step 1:Select an option from 'Const Type' dropdown..");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected 'Const Type' is displayed.");
		Log.info("Expected Result: Selected 'Const Type' is displayed.");

		ExtentTestManager.endTest();
	}


	//TC-21 (1)
	public void testBusinessFieldPresence() {
		ExtentTestManager.startTest("TC No. - 21 --> Business Field Presence");
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Check the presence of 'Business' field.");
		Log.info("Step 1:Check the presence of 'Business' field.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Business' field is present.");
		Log.info("Expected Result: 'Business' field is present.");
		ExtentTestManager.endTest();
	}


	//TC-22(2)
	public void testBusinessDropdownListsAllBusinesses() {
		ExtentTestManager.startTest("TC No. - 22 --> Business Field - Dropdown Options");
		List<WebElement> businessOptions = driver.findElements(By.xpath("//select[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlBusiness_ddl']/option"));

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Open 'Business' dropdown.");
		Log.info("Step 1:Open 'Business' dropdown.");
		for (WebElement busniessOption : businessOptions) {
			System.out.println(busniessOption.getText());
		}
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown lists all Businesses.");
		Log.info("Expected Result: Dropdown lists all Businesses.");


		ExtentTestManager.endTest();	
	}

	//TC-23(2)
	public void testSelectBusinessFromDropdown() {
		ExtentTestManager.startTest("TC No. - 23 --> Select Business from Dropdown");
		List<WebElement> businessOptions = driver.findElements(By.xpath("//select[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlBusiness_ddl']/option"));

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Select an option from 'Business' dropdown.");
		Log.info("Step 1:Select an option from 'Business' dropdown.");
		for (WebElement busniessOption : businessOptions) {
			if(busniessOption.getText().equalsIgnoreCase("Farming")) {
				busniessOption.click();
			}
		}

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected 'Business' is displayed.");
		Log.info("Expected Result: Selected 'Business' is displayed.");

		ExtentTestManager.endTest();	
	}

	//TC-26(2)
	public void testSelectRegdToFromDropdown() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 26 --> Select Regd To from Dropdown");
		select("3",institutionalCust.RegdTo_dropdown);
		//click(institutionalCust.RegdTo_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Select an option from 'Regd To' dropdown.");
		Log.info("Step 1:Select an option from 'Regd To' dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected 'Regd To' is displayed.");
		Log.info("Expected Result: Selected 'Regd To' is displayed.");
		ExtentTestManager.endTest();	
	}

	//TC-29(2)
	public void verifyDateSelectionAndManualEntry(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 29 --> Dateofincop - Calendar and Manual Entry");


		//		String DateOfIncOp = testdata.get("DateOfIncOp").toString();
		//		input(institutionalCust.DateOfIncOp, DateOfIncOp);
		//		System.out.println(DateOfIncOp);

		click(institutionalCust.DateOfIncOp);
		String DateOfIncOp = testdata.get("DateOfIncOp").toString();
		input(institutionalCust.DateOfIncOp, DateOfIncOp);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Select date from calendar.");
		Log.info("Step 1:Select date from calendar.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selection and manual typing are possible.");
		Log.info("Expected Result: Selection and manual typing are possible.");
		ExtentTestManager.endTest();	
	}

	//TC-31(2)
	public void testRegNoFieldEntry(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 31 --> Verify RegNo Field Entry");

		String RegNo = testdata.get("RegNo").toString();
		input(institutionalCust.RegNo, RegNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'RegNo'..");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'RegNo'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'RegNo'.");
		Log.info("Expected Result: All inputs are possible in 'RegNo'.");

		ExtentTestManager.endTest();
	}

	//TC-33(2)
	public void testRegplaceFieldAcceptsVariousInputs(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 33 --> Regplace Field - Data Entry");

		String RegPalce = testdata.get("RegPalce").toString();
		input(institutionalCust.RegPalce, RegPalce);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'Regplace'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'Regplace'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'Regplace'.");
		Log.info("Expected Result: All inputs are possible in 'Regplace'.");

		ExtentTestManager.endTest();
	}


	//TC-35(2)
	public void testEnterSpecialCharactersInPANField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 35 --> PAN Field - Data Entry");

		//generateUniqueId(Pagetitle, Pagetitle);

		String pan = generateUniqueId(spPAN,clmnNamPAN);
		//    input(quickCustRepo.qadAadhaarTxtBox,validAadhaar);


		//		String pan = testdata.get("pan").toString();
		input(institutionalCust.pan, pan);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'PAN'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'PAN'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'Regplace'.");
		Log.info("Expected Result: All inputs are possible in 'Regplace'.");


		ExtentTestManager.endTest();
	}

	//TC-38(2)
	public void testCSTFieldAcceptsAllCharacters(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 38 --> CST Field - Data Entry");

		String cst = testdata.get("cst").toString();
		input(institutionalCust.cst, cst);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'CST'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'CST'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'CST'.");
		Log.info("Expected Result: All inputs are possible in 'CST'.");


		ExtentTestManager.endTest();


	}

	//TC-41(2)
	public void testPin(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 41 --> PIN Field - Numeric Only");

		String pin = testdata.get("pin").toString();
		input(institutionalCust.pin,pin);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter numbers.");
		Log.info("Step 1:Enter numbers.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numbers are accepted.");
		Log.info("Expected Result: Only numbers are accepted.");


		ExtentTestManager.endTest();

	}

	//TC-43(2)
	public void testTINFieldDataEntry(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 43 --> TIN Field - Data Entry");

		String tin = testdata.get("tin").toString();
		input(institutionalCust.tin, tin);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'TIN'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'TIN'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'TIN'.");
		Log.info("Expected Result: All inputs are possible in 'TIN'.");

		ExtentTestManager.endTest();


	}

	////////

	//TC-45(2)
	public void testTanNoFieldAllowsAllInputs(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("TC No. - 45 --> TAN No Field - Data Entry");

		String tanNo = testdata.get("tanNo").toString();
		input(institutionalCust.tanNo, tanNo);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'TAN No'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'TAN No'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'TAN No'.");
		Log.info("Expected Result: All inputs are possible in 'TAN No'.");

		ExtentTestManager.endTest();


	}


	//TC-47 (3)
	public void testFaxNoDataEntry(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 47 --> FAX No Field - Data Entry");

		input(institutionalCust.faxNo, "+");
		String faxNo = testdata.get("faxNo").toString();
		input(institutionalCust.faxNo, faxNo);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'FAX No'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'FAX No'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'FAX No'.");
		Log.info("Expected Result: All inputs are possible in 'FAX No'.");

		ExtentTestManager.endTest();	
	}


	//TC-49 (2)
	public void testEmailFieldEntry(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 49 --> Email Field - Data Entry");

		String Email = testdata.get("Email").toString();
		input(institutionalCust.Email, Email);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'Email'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'Email'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'Email'.");
		Log.info("Expected Result: All inputs are possible in 'Email'.");



		ExtentTestManager.endTest();

	}

	//TC--52(2)
	public void testOperatorName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 52 --> Operator Name Field - Mandatory Check");

		String operatorName = testdata.get("operatorName").toString();
		input(institutionalCust.operatorName, operatorName);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters in 'Email'.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters in 'Email'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible in 'OperatorName'.");
		Log.info("Expected Result: All inputs are possible in 'OperatorName'.");


		ExtentTestManager.endTest();

	}

	//TC-56(2)
	public void testMobileNumberFieldWithNumbers(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 56 --> Mobile No Field - Numeric Only");

		String MobileNo = testdata.get("MobileNo").toString();
		input(institutionalCust.MobileNo, MobileNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter numbers.");
		Log.info("Step 1:Enter numbers..");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numbers are accepted.");
		Log.info("Expected Result: Only numbers are accepted.");



		ExtentTestManager.endTest();
	}


	//TC-59(2)
	public void testBoardResolutionField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 59 --> Board Resolution Field - Data Entry");

		String boardResolution = testdata.get("boardResolution").toString();
		input(institutionalCust.boardResolution, boardResolution);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Enter alphabets, numbers, and special characters.");
		Log.info("Step 1:Enter alphabets, numbers, and special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible.");
		Log.info("Expected Result: All inputs are possible.");


		ExtentTestManager.endTest();
	}

	//TC-62
	//	public void selectPreferredLanguage() {
	//		ExtentTestManager.startTest("TC No. - 62 --> Select Preferred Language from Dropdown");
	//		select("2",institutionalCust.perferredLanguage);
	//
	//
	//		ExtentTestManager.endTest();
	//	}


	//TC-63(1)
	public void testOwnerDetailsSectionPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 63 --> Owner Details Section");

		ElementDisplayed(institutionalCust.ownerSectionLabel);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Verify the presence of the Owner Details section.");
		Log.info("Step 1: Verify the presence of the Owner Details section.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Owner Details Section is present.");
		Log.info("Expected Result: Owner Details Section is present.");

		ExtentTestManager.endTest();
	}

	//TC-64(1)
	public void testAddOwnerDetailsButtonPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 64 --> Add Owner Details Button");
		ElementDisplayed(institutionalCust.addOwnerBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check for the 'Add owner Details' button under Owner Details Section..");
		Log.info("Step 1: Check for the 'Add owner Details' button under Owner Details Section.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add owner Details' Button is present.");
		Log.info("Expected Result: Add owner Details' Button is present.");

		ExtentTestManager.endTest();
	}

	//TC-65(2)
	public void testOwnerDetailsFieldDisplay() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 65 --> Owner Details Field Display");
		click(institutionalCust.addOwnerBtn);
		ElementDisplayed(institutionalCust.ownerSection_nameField);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Verify the display of Customer ID, Member No, Name, and Designation fields.");
		Log.info("Step 1: Verify the display of Customer ID, Member No, Name, and Designation fields.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All specified fields are displayed.");
		Log.info("Expected Result: All specified fields are displayed.");

		ExtentTestManager.endTest();
	}

	//TC-67(2)
	public void testNameFieldInOwnerDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 67 --> Verify and enter name field");
		String nameInOwnerDetails = testdata.get("nameInOwnerDetails").toString();
		input(institutionalCust.ownerSection_nameField, nameInOwnerDetails);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numbers, and special characters.");
		Log.info("Step 1: Enter alphabets, numbers, and special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All inputs are possible.");
		Log.info("Expected Result: All inputs are possible.");
		ExtentTestManager.endTest();

	}

	//TC-68(2)
	public void testDesignationFieldInOwnerDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		ExtentTestManager.startTest("TC No. - 68 --> Designation Field Data Entry");
		String designationInOwnerDetails = testdata.get("designationInOwnerDetails").toString();
		input(institutionalCust.ownerSection_designationField, designationInOwnerDetails);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Attempt to enter alphabets, numbers, and special characters into the Designation field.");
		Log.info("Step 1: Attempt to enter alphabets, numbers, and special characters into the Designation field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All types of entries are possible.");
		Log.info("Expected Result: All types of entries are possible.");

		ExtentTestManager.endTest();
	}


//	//TC-70 (5)
//	public void testCustPopupInOwnerSection(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
//		String parentWindow = driver.getWindowHandle();
//		String ownserDetails_custId = testdata.get("ownserDetails_custId").toString();
//
//		click(institutionalCust.searchIconInOwnerSection);
//		Set<String> allWindows = driver.getWindowHandles();
//		for (String window : allWindows) {
//			if(!window.equals(parentWindow)) {
//				driver.switchTo().window(window);
//				input(institutionalCust.OwnerSectionCustId_textbox, ownserDetails_custId);
//				click(institutionalCust.OwnerSectionSearchBttn);
//				click(institutionalCust.OwnerSectionSelectLink);
//				driver.switchTo().window(parentWindow);
//				SwitchToFrame(institutionalCust.institution_frame);
//				System.out.println("Frame is switched");
//				break;
//			}
//
//		}
//		String OwnerSectionName = driver.findElement(institutionalCust.ownerSection_nameField).getText();
//		if(OwnerSectionName=="") {
//			System.out.println("Field is emply");
//		}	
//		else {
//			System.out.println("Runing further testcases");
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Name and Member are auto-loaded.");
//			Log.info("Expected Result: Customer Name and Member are auto-loaded.");
//
//		}
//	}


	//TC-71(1)
	public void testMSMEDetailsSectionPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 71 --> MSME Details Section");
		ElementDisplayed(institutionalCust.msmeSection);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify presence of MSME Details section.");
		Log.info("Step 1:  Verify presence of MSME Details section.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: MSME Details section is present.");
		Log.info("Expected Result: MSME Details section is present.");

		ExtentTestManager.endTest();
	}


	//TC-72(2)
	public void testVerifyMSMECheckboxAndLabels() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 72 --> MSME 'Yes/No' Checkbox");
		ElementDisplayed(institutionalCust.IsmsmeCustomer);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check for the 'Is MSME Customer' checkbox.");
		Log.info("Step 1: Check for the 'Is MSME Customer' checkbox.");

		ElementDisplayed(institutionalCust.noRadioBtn);
		ElementDisplayed(institutionalCust.yesRadioBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify 'Yes' and 'No' labels.");
		Log.info("Step 2: Verify 'Yes' and 'No' labels.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox with 'Yes' and 'No' is present.");
		Log.info("Expected Result: Checkbox with 'Yes' and 'No' is present.");

		ExtentTestManager.endTest();

	}

	//TC-73(1)
	public void testDefaultIsMsmeCustomerCheckbox() {


		ExtentTestManager.startTest("TC No. - 73 --> Default MSME Checkbox");
		if(driver.findElement(institutionalCust.noRadioBtn).isSelected()) {

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check if 'Is MSME Customer' default is 'No'.");
			Log.info("Step 1: Check if 'Is MSME Customer' default is 'No'.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Default marking is 'No'.");
			Log.info("Expected Result: Default marking is 'No'.");
		}
		ExtentTestManager.endTest();
	}



	//TC-74(2)
	public void testDeclarationBrowsingOptionPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 74 --> Declaration Browsing Option");


		ElementDisplayed(institutionalCust.browseBtn_msme);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Verify Declaration Browsing option presence.");
		Log.info("Step 1: Verify Declaration Browsing option presence.");

		click(institutionalCust.yesRadioBtn);
		UploadFile(institutionalCust.browseBtn_msme,".\\src\\test\\resources\\tiger.jpg");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Attempt to upload .jpeg, .jpg, .png, .gif, .pdf files.");
		Log.info("Step 2: Attempt to upload .jpeg, .jpg, .png, .gif, .pdf files.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Browsing option present; specified file types are uploadable.");
		Log.info("Expected Result: Browsing option present; specified file types are uploadable.");

		ExtentTestManager.endTest();
	}

	//TC-77 (1)
	public void testRegistrationField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 77 --> Registration No Data Entry");

		String msmeRegistNo = testdata.get("msmeRegistNo").toString();
		input(institutionalCust.msme_registration, msmeRegistNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Enter alphabets, numbers, and special characters.");
		Log.info("Step 1:  Enter alphabets, numbers, and special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All types of entries are possible.");
		Log.info("Expected Result: All types of entries are possible.");

		ExtentTestManager.endTest();
	}


	//TC-83(3)
	public void testGstinFieldAcceptsAllEntries(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		ExtentTestManager.startTest("TC No. - 83 --> GSTIN No Data Entry");
		click(institutionalCust.gst_YesRadioBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on yes radio button");
		Log.info("Step 1: Click on yes radio button");

		String gstNo = testdata.get("gstNo").toString();
		input(institutionalCust.gstTinNo_textbox, gstNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Enter alphabets, numbers, and special characters.");
		Log.info("Step 2: Enter alphabets, numbers, and special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All types of entries are possible.");
		Log.info("Expected Result: All types of entries are possible.");


		ExtentTestManager.endTest();
	}


	//TC-84(2)
	public void testDocumentBrowsingOptionPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 84 --> GSTIN Document Browsing");
		ElementDisplayed(institutionalCust.browseBtm_gst);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify document browsing option presence.");
		Log.info("Step 1:  Verify document browsing option presence.");

		UploadFile(institutionalCust.browseBtm_gst,".\\src\\test\\resources\\tiger.jpg");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Attempt to upload .jpeg, .jpg, .png, .gif, .pdf files.");
		Log.info("Step 2: Attempt to upload .jpeg, .jpg, .png, .gif, .pdf files.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Browsing option present; specified file types are uploadable.");
		Log.info("Expected Result: Browsing option present; specified file types are uploadable.");


		ExtentTestManager.endTest();
	}

	//TC-85(1)
	public void testInstitutionOtherDetailsSectionPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 85 --> Other Details Section");
		ElementDisplayed(institutionalCust.othetDetailsLabel);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify presence of 'Institution Other Details' section.");
		Log.info("Step 1:  Verify presence of 'Institution Other Details' section.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Section is present.");
		Log.info("Expected Result: Section is present.");

		ExtentTestManager.endTest();
	}

	//TC-86(2)
	public void testEnterDataAndSelectInCINNumberField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 86 --> CIN Number Field Presence");

		String cinNo = testdata.get("cinNo").toString();
		input(institutionalCust.cinNo, cinNo);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Enter alphabets, numbers, and special characters.");
		Log.info("Step 1:  Enter alphabets, numbers, and special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; all types of entries are possible.");
		Log.info("Expected Result: Field present; all types of entries are possible.");

		ExtentTestManager.endTest();
	}


	//TC-87(2)
	public void testCmrScoreDropdownPresenceAndSelect() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 87 --> CMR Score Dropdown");

		select("2", institutionalCust.CMR_Score_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Check presence of CMR Score Dropdown.");
		Log.info("Step 1:  Check presence of CMR Score Dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown is present.");
		Log.info("Expected Result: Dropdown is present.");

		ExtentTestManager.endTest();

	}

	//TC-88(3)
	public void verifyShareHoldingFieldPresenceAndEnterNumbers(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 88 --> Share Holding by Individuals");

		ElementDisplayed(institutionalCust.Share_Holding_By_Individuals);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify 'share Holding by individuals' field presence.");
		Log.info("Step 1:   Verify 'share Holding by individuals' field presence.");

		String ShareHoldingByIndividuals = testdata.get("ShareHoldingByIndividuals").toString();
		input(institutionalCust.Share_Holding_By_Individuals, ShareHoldingByIndividuals);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:    Attempt data entry of numbers.");
		Log.info("Step 2:    Attempt data entry of numbers.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; only numbers are accepted.");
		Log.info("Expected Result: Field present; only numbers are accepted.");

		ExtentTestManager.endTest();

	}


	//TC-89(3)
	public void testDataEntryForShareHoldingFieldAndPresence(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("TC No. - 89 --> Share Holding by Entity");
		ElementDisplayed(institutionalCust.Share_Holding_By_Entity_textbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify 'share Holding by Entity' field presence.");
		Log.info("Step 1:   Verify 'share Holding by Entity' field presence.");

		String ShareHoldingByEntity = testdata.get("ShareHoldingByEntity").toString();
		input(institutionalCust.Share_Holding_By_Entity_textbox, ShareHoldingByEntity);


		ExtentTestManager.getTest().log(Status.PASS, "Step 2:    Attempt data entry of numbers.");
		Log.info("Step 2:    Attempt data entry of numbers.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; only numbers are accepted.");
		Log.info("Expected Result: Field present; only numbers are accepted.");

		ExtentTestManager.endTest();
	}


	//TC-90(3)
	public void testDPIITNumberFieldInputAndPresence(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {


		ExtentTestManager.startTest("TC No. - 90 --> DPIIT Number Data Entry");
		ElementDisplayed(institutionalCust.DPIIT_Number);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify DPIIT Number field presence.");
		Log.info("Step 1:   Verify DPIIT Number field presence.");

		String DPIITNumber = testdata.get("DPIITNumber").toString();
		input(institutionalCust.DPIIT_Number, DPIITNumber);		

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Enter alphabets, numbers, special characters.");
		Log.info("Step 2:   Enter alphabets, numbers, special characters.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; all types of entries possible.");
		Log.info("Expected Result: Field present; all types of entries possible.");

		ExtentTestManager.endTest();
	}

	//TC-91(3)
	public void testDPIITPresenceAndUpload() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 91 --> DPIIT Document Browsing");

		ElementDisplayed(institutionalCust.DPIIT_Document_browseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify browsing option presence.");
		Log.info("Step 1:   Verify browsing option presence.");

		UploadFile(institutionalCust.DPIIT_Document_browseBtn, ".\\src\\test\\resources\\tiger.jpg");	
		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");
		Log.info("Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option present; files of specified types are uploadable.");
		Log.info("Expected Result: Option present; files of specified types are uploadable.");


		ExtentTestManager.endTest();
	}



	//TC-92(3)
	public void testKsumNumberFieldInputAndPresence(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 92 --> KSUM Number Data Entry");

		ElementDisplayed(institutionalCust.KSUM_Number);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify KSUM Number field presence.");
		Log.info("Step 1:   Verify KSUM Number field presence.");


		String KSUM_Number = testdata.get("KSUM_Number").toString();
		input(institutionalCust.KSUM_Number, KSUM_Number);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Enter alphabets, numbers, special characters.");
		Log.info("Step 2:   Enter alphabets, numbers, special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; all types of entries possible.");
		Log.info("Expected Result: Field present; all types of entries possible.");


		ExtentTestManager.endTest();
	}


	//TC-93(3)
	public void verifyBrowsingOptionPresenceAndUpload() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 93 --> KSUM Document Browsing");
		ElementDisplayed(institutionalCust.KSUM_Document_browseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify browsing option presence.");
		Log.info("Step 1:   Verify browsing option presence.");

		UploadFile(institutionalCust.KSUM_Document_browseBtn, ".\\src\\test\\resources\\Screenshot 2024-09-06 151619.png");ExtentTestManager.endTest();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");
		Log.info("Step 2:  Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option present; files of specified types are uploadable.");
		Log.info("Expected Result: Option present; files of specified types are uploadable.");


		ExtentTestManager.endTest();

	}


	//TC-94(3)
	public void testEnterDataInExternalCreditRatingFieldAndPresence(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("TC No. - 94 --> External Credit Rating Data");
		ElementDisplayed(institutionalCust.External_Credit_Rating);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Verify 'External Credit Rating' field presence.");
		Log.info("Step 1:   Verify 'External Credit Rating' field presence.");



		String ExternalCreditRating = testdata.get("ExternalCreditRating").toString();
		input(institutionalCust.External_Credit_Rating, ExternalCreditRating);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Enter alphabets, numbers, special characters.");
		Log.info("Step 2:  Enter alphabets, numbers, special characters.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field present; all types of entries possible.");
		Log.info("Expected Result: Field present; all types of entries possible.");

		ExtentTestManager.endTest();
	}

	//TC-95(3)
	public void testExternalCreditRatingFieldBrowseBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 95 --> External Credit Rating Document Browsing");
		ElementDisplayed(institutionalCust.External_Credit_Rating_browseBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify browsing option presence.");
		Log.info("Step 1:   Verify browsing option presence.");

		UploadFile(institutionalCust.External_Credit_Rating_browseBtn, ".\\src\\test\\resources\\Enrollment Summary - 2024-10-29T181953.903.pdf");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");
		Log.info("Step 2:  Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option present; files of specified types are uploadable.");
		Log.info("Expected Result: Option present; files of specified types are uploadable.");


		ExtentTestManager.endTest();
	}


	//TC-96(3)
	public void testAOADocumentBrowseBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 96 --> External Credit Rating Document Browsing");
		ElementDisplayed(institutionalCust.AOA_Document_browseBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify browsing option presence.");
		Log.info("Step 1:   Verify browsing option presence.");

		UploadFile(institutionalCust.AOA_Document_browseBtn, ".\\src\\test\\resources\\Enrollment Summary - 2024-10-29T181953.903.pdf");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");
		Log.info("Step 2:  Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option present; files of specified types are uploadable.");
		Log.info("Expected Result: Option present; files of specified types are uploadable.");

		ExtentTestManager.endTest();
	}


	//TC-97(3)
	public void testMOADocumentBrowseBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 97 --> MOA Document Browsing");

		ElementDisplayed(institutionalCust.browse_MOA);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify MOA Document field and browsing option presence.");
		Log.info("Step 1:   Verify MOA Document field and browsing option presence.");

		UploadFile(institutionalCust.browse_MOA, ".\\src\\test\\resources\\tiger.jpg");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:   Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");
		Log.info("Step 2:  Attempt file upload (.jpeg, .jpg, .png, .gif, .pdf).");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field and option present; files are uploadable.");
		Log.info("Expected Result: Field and option present; files are uploadable.");
		ExtentTestManager.endTest();
	}


	//TC-99(3)
	public void testInstitutionSectorDropdownPresenceAndSelect() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 99 --> Institution Sector Dropdown");
		ElementDisplayed(institutionalCust.Institution_Sector_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Verify 'Institution sector' dropdown presence.");
		Log.info("Step 1:   Verify 'Institution sector' dropdown presence.");

		select("2", institutionalCust.Institution_Sector_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown is present.");
		Log.info("Expected Result: Dropdown is present.");
		ExtentTestManager.endTest();
	}

	///////

	//TC-100(1)
	public void insti_saveAndProceedFunc() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 100 --> Save & Proceed Functionality");

		click(institutionalCust.insti_saveAndProceed);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Save&Proceed'.");
		Log.info("Step 1:   Click 'Save&Proceed'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is saved, and user is navigated to the next section.");
		Log.info("Expected Result: Data is saved, and user is navigated to the next section.");

		//click(institutionalCust.institution_closeBtn);
		ExtentTestManager.endTest();
	}


	//TC-101(1)
	public void testAddressPageTitle() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 101 --> Address Page Verification");
		Thread.sleep(5000);
		ElementDisplayed(institutionalCust.addressLabel);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Confirm 'Address' displayed in the page name");
		Log.info("Step 1:   Confirm 'Address' displayed in the page name");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Page name 'Address' is displayed accurately");
		Log.info("Expected Result: Page name 'Address' is displayed accurately");


		ExtentTestManager.endTest();
	}

	//TC-102(1)
	public void testVerifySectionsInAddressPage() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 102 --> Verify Sections in Address Page");
		ElementDisplayed(institutionalCust.regionalLabel);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Check for 'Official' and 'Regional' sections presence");
		Log.info("Step 1:   Check for 'Official' and 'Regional' sections presence");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Official and Regional sections are present");
		Log.info("Expected Result: Official and Regional sections are present");


		ExtentTestManager.endTest();
	}

	//TC-104(2)
	public void testBuildingFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("TC No. - 104 --> Official Section: Building Field Input");
		String building = testdata.get("building").toString();
		input(institutionalCust.building_textbox, building);		

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Type letters and numbers in 'House' textfield");
		Log.info("Step 1: Type letters and numbers in 'House' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Building' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Building' field");

		ExtentTestManager.endTest();
	}


	//TC-108(2)
	public void testBuildingNoFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 108 --> Official Section: BuildingNo Field Input");

		String buildingNo = testdata.get("buildingNo").toString();
		input(institutionalCust.buildingNo_textbox, buildingNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Type letters and numbers in 'BuildingNo' textfield");
		Log.info("Step 1: Type letters and numbers in 'BuildingNo' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'BuildingNo' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'BuildingNo' field");


		ExtentTestManager.endTest();

	}

	//TC-110(2)
	public void testEnterLettersAndNumbersInDoorNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 110 --> Official Section: DoorNo Field Input");

		String DoorNo = testdata.get("DoorNo").toString();
		input(institutionalCust.doorNo_textbox, DoorNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Type letters and numbers in 'DoorNo' textfield");
		Log.info("Step 1: Type letters and numbers in 'DoorNo' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'DoorNo' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'DoorNo' field");

		ExtentTestManager.endTest();
	}



	//TC-111(2)
	public void testStateDropdownFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 111 --> Official Section: State Dropdown Functionality");
		select("1", institutionalCust.state_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on State dropdown");
		Log.info("Step 1: Click on State dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list");
		Log.info("Step 2: Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: State dropdown is clickable, and an item can be selected");
		Log.info("Expected Result: State dropdown is clickable, and an item can be selected");

		ExtentTestManager.endTest();

	}


	//TC-112(2)
	public void testDistrictDropdownFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 112 --> Official Section: District Dropdown Functionality");
		select("17", institutionalCust.district_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on District dropdown");
		Log.info("Step 1: Click on District dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list");
		Log.info("Step 2: Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: District dropdown lists items related to selected State and is selectable");
		Log.info("Expected Result: District dropdown lists items related to selected State and is selectable");

		ExtentTestManager.endTest();
	}


	//TC-113(2)
	public void testPostDropdownFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 113 --> Official Section: Post Dropdown Functionality");
		select("447", institutionalCust.post_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on Post dropdown");
		Log.info("Step 1:  Click on Post dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list");
		Log.info("Step 2: Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Post dropdown lists items related to selected District and is selectable");
		Log.info("Expected Result: Post dropdown lists items related to selected District and is selectable");

		ExtentTestManager.endTest();
	}


	//TC-116(2)
	public void testEnterPlaceField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 116 --> Official Section: Place Field Input");
		String place = testdata.get("place").toString();
		input(institutionalCust.place_textbox, place);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Place' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Place' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Place' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Place' field");

		ExtentTestManager.endTest();
	}

	//TC-118(2)
	public void testCityFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 118 --> Official Section: City Field Input");
		String city = testdata.get("city").toString();
		input(institutionalCust.city_textbox, city);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Type letters and numbers in 'City' textfield");
		Log.info("Step 1:   Type letters and numbers in 'City' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'City' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'City' field");
		ExtentTestManager.endTest();
	}



	//TC-120(2)
	public void testStreetFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 120 --> Official Section: Street Field Input");
		String street = testdata.get("street").toString();
		input(institutionalCust.street_textbox, street);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Type letters and numbers in 'Street' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Street' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Street' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Street' field");

		ExtentTestManager.endTest();
	}

	//TC-122(2)
	public void testResidenceFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 122 --> Official Section: Residence Field Input");
		String residence = testdata.get("residence").toString();
		input(institutionalCust.residence_textbox, residence);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Residence' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Residence' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Residence' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Residence' field");

		ExtentTestManager.endTest();
	}

	//TC-125 (2)
	public void testPinField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 125 --> Official Section: Residence Field Input");
		//		String pin = testdata.get("pin").toString();
		//		input(institutionalCust.pin_textbox, pin);

		String pin =driver.findElement(institutionalCust.pin_textbox).getAttribute("value");
		if(pin!="")
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data automatically fills 'PIN' based on Post selection");
			Log.info("Expected Result: Data automatically fills 'PIN' based on Post selection");
		}
		ExtentTestManager.endTest();
	}

	//TC-127(2)
	public void testEnteringPhoneNumber(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 127 --> Official Section: Phone No Field Input");
		String phoneNo = testdata.get("phoneNo").toString();
		input(institutionalCust.phoneNo_textbox, phoneNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type numbers in 'Phone NO' textfield");
		Log.info("Step 1:  Type numbers in 'Phone NO' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numbers can be entered in 'Phone NO' field");
		Log.info("Expected Result: Only numbers can be entered in 'Phone NO' field");

		ExtentTestManager.endTest();
	}


	//TC-129(2)
	public void testEnterElectricPostNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 129 --> Official Section: Electric Post No Field Input");
		String electricPostNo = testdata.get("electricPostNo").toString();
		input(institutionalCust.electricPostNo_textbox, electricPostNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Electric Post No' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Electric Post No' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Electric Post No' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Electric Post No' field");


		ExtentTestManager.endTest();
	}

	//TC-130(1)
	public void testClickMailingAddressCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 130 --> Official Section: Mailing Address Checkbox");
		click(institutionalCust.mailingAddressCheckbox);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on the checkbox");
		Log.info("Step 1:  Click on the checkbox");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Mailing Address' checkbox is present and can be ticked");
		Log.info("Expected Result: Mailing Address' checkbox is present and can be ticked");


		ExtentTestManager.endTest();
	}


	//TC-132(2)
	public void regional_testEnterBuildingDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 132 --> Regional Section: Building Field Input");
		String regional_building	 = testdata.get("regional_building").toString();
		input(institutionalCust.regional_building_textbox, regional_building);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Building' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Building' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Building' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Building' field");


		ExtentTestManager.endTest();
	}

	//TC-136(2)
	public void regional_testBuildingNoFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 136 --> Regional Section: BuildingNo Field Input");
		String regional_building = testdata.get("regional_building").toString();
		input(institutionalCust.regional_buildingNo_textbox, regional_building);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'BuildingNo' textfield");
		Log.info("Step 1:  Type letters and numbers in 'BuildingNo' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'BuildingNo' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'BuildingNo' field");

		ExtentTestManager.endTest();
	}

	//TC-138(2)
	public void regional_testDoorNoFieldInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 138 --> Regional Section: DoorNo Field Input");

		String regional_DoorNo = testdata.get("regional_DoorNo").toString();
		input(institutionalCust.regional_doorNo_textbox, regional_DoorNo);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'DoorNo' textfield");
		Log.info("Step 1:  Type letters and numbers in 'DoorNo' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'DoorNo' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'DoorNo' field");
		ExtentTestManager.endTest();
	}


	////////////
	//TC-139(2)
	public void regional_testSelectStateFromDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 139 --> Regional Section: State Dropdown Functionality");

		select("2", institutionalCust.regional_state_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on State dropdown");
		Log.info("Step 1:  Click on State dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select an item from the list");
		Log.info("Step 2:  Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: State dropdown is clickable, and an item can be selected");
		Log.info("Expected Result: State dropdown is clickable, and an item can be selected");

		ExtentTestManager.endTest();
	}



	//TC-140(2)
	public void regional_testDistrictDropdownFunctionality() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 140 --> Regional Section: District Dropdown Functionality");
		select("208", institutionalCust.regional_district_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on District dropdown");
		Log.info("Step 1:  Click on District dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select an item from the list");
		Log.info("Step 2:  Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: District dropdown lists items related to selected State and is selectable");
		Log.info("Expected Result: District dropdown lists items related to selected State and is selectable");

		ExtentTestManager.endTest();
	}


	//TC-141(2)
	public void regional_testPostDropdownFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 141 --> Regional Section: Post Dropdown Functionality");
		select("13568",institutionalCust.regional_post_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on Post dropdown");
		Log.info("Step 1:  Click on Post dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select an item from the list");
		Log.info("Step 2:  Select an item from the list");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Post dropdown lists items related to selected District and is selectable");
		Log.info("Expected Result: Post dropdown lists items related to selected District and is selectable");

		ExtentTestManager.endTest();
	}


	//TC-144(2)
	public void regional_testPlaceField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 144 --> Regional Section: Place Field Input");
		String regional_place = testdata.get("regional_place").toString();
		input(institutionalCust.regional_place_textbox, regional_place);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Place' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Place' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Place' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Place' field");

		ExtentTestManager.endTest();
	}


	//TC-146(2)
	public void regional_testCityField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 146 --> Regional Section: City Field Input");
		String regional_city = testdata.get("regional_city").toString();
		input(institutionalCust.regional_city_textbox, regional_city);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'City' textfield");
		Log.info("Step 1:  Type letters and numbers in 'City' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'City' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'City' field");

		ExtentTestManager.endTest();
	}

	//TC-148(2)
	public void regional_testStreetField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 148 --> Regional Section: Street Field Input");
		String regional_street = testdata.get("regional_street").toString();
		input(institutionalCust.regional_street_textbox, regional_street);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Street' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Street' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Street' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Street' field");

		ExtentTestManager.endTest();
	}


	//TC-150(2)
	public void regional_testResidenceField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 150 --> Regional Section: Residence Field Input");
		String regional_residence = testdata.get("regional_residence").toString();
		input(institutionalCust.regional_residence_textbox, regional_residence);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Residence' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Residence' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Residence' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Residence' field");

		ExtentTestManager.endTest();
	}

	//TC-153 (2)
	public void regional_testPinField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 153 --> Regional Section: Residence Field Input");
		String regional_pinNo = testdata.get("regional_pinNo").toString();
		input(institutionalCust.regional_pin_textbox, regional_pinNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type letters and numbers in 'Residence' textfield");
		Log.info("Step 1:  Type letters and numbers in 'Residence' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Letters and numbers can be entered in 'Residence' field");
		Log.info("Expected Result: Letters and numbers can be entered in 'Residence' field");

		ExtentTestManager.endTest();

		//		if(!driver.findElement(institutionalCust.regional_pin_textbox).getText().isEmpty())
		//		{
		//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data automatically fills 'PIN' based on Post selection");
		//			Log.info("Expected Result: Data automatically fills 'PIN' based on Post selection");
		//		}


	}

	//TC-155(2)
	public void regional_testPhoneField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 155 --> Regional Section: Phone No Field Input");

		String regional_phoneNo = testdata.get("regional_phoneNo").toString();
		input(institutionalCust.regional_phoneNo_textbox, regional_phoneNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type numbers in 'Phone NO' textfield");
		Log.info("Step 1:  Type numbers in 'Phone NO' textfield");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numbers can be entered in 'Phone NO' field");
		Log.info("Expected Result: Only numbers can be entered in 'Phone NO' field");

		ExtentTestManager.endTest();
	}

	//TC-156(1)
	public void regional_testMailingAddressCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 156 --> Regional Section: Mailing Address Checkbox");
		click(institutionalCust.regional_mailingAddressCheckbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on the checkbox");
		Log.info("Step 1:  Click on the checkbox");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Mailing Address' checkbox is present and can be ticked");
		Log.info("Expected Result: Mailing Address' checkbox is present and can be ticked");

		ExtentTestManager.endTest();
	}


	//TC-157(1)
	public void address_saveAndProceed() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 157 --> Save & Proceed from Address Page");
		click(institutionalCust.address_closeBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Save & Proceed' button");
		Log.info("Step 1:  Click 'Save & Proceed' button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Address Details Successfully Saved' confirmation message displays");
		Log.info("Expected Result: Address Details Successfully Saved' confirmation message displays");

		ExtentTestManager.endTest();
	}


	//TC-158 (1)
	public void verifyIntroducerDetailsLabel() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 158 --> Introducer Page Verification");
		ElementDisplayed(institutionalCust.introducerDetailsLabel);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Check page name is 'Introducer Details'.");
		Log.info("Step 1:  Check page name is 'Introducer Details'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Page name is 'Introducer Details'.");
		Log.info("Expected Result: Page name is 'Introducer Details'.");

		ExtentTestManager.endTest();


	}


	//TC-160 (1)
	public void tickIntroducerNotRequiredCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 160 --> Tick 'Introducer Not Required' Checkbox");
		ElementDisplayed(institutionalCust.introducerDetailsLabel);
		click(institutionalCust.introducerNotRequiredCheckbox);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click checkbox to tick it.");
		Log.info("Step 1:  Click checkbox to tick it.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked; 'Reason' textfield appears.");
		Log.info("Expected Result: Checkbox is ticked; 'Reason' textfield appears.");

		ExtentTestManager.endTest();


	}

	//TC-161 (1)
	public void testReasonField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 161 --> Reason' Textfield Functionality");

		String Reason = testdata.get("Reason").toString();
		input(institutionalCust.reason_textbox, Reason);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Type alphabets and numbers in 'Reason'.");
		Log.info("Step 1:  Type alphabets and numbers in 'Reason'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Reason' textfield visible and accepts characters/numerals.");
		Log.info("Expected Result: Reason' textfield visible and accepts characters/numerals.");

		ExtentTestManager.endTest();
	}


	//TC-163 (1)
	public void untickIntroducerNotRequiredCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 163 --> Untick 'Introducer Not Required' Checkbox");
		click(institutionalCust.introducerNotRequiredCheckbox);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Untick checkbox.");
		Log.info("Step 1:  Untick checkbox.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is unticked; 'Reason' textfield disappears.");
		Log.info("Expected Result: Checkbox is unticked; 'Reason' textfield disappears.");

		ExtentTestManager.endTest();
	}


	// (8)
	public void testCustomerSelection1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		String parentWindow = driver.getWindowHandle();

		click(institutionalCust.introducer_custIdSearch);

		Set<String> allWindows = driver.getWindowHandles();
		//String childWindow_custID = testdata.get("childWindow_custID").toString();
		String custID=generateUniqueId(query, columnName);


		for (String window : allWindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				input(institutionalCust.introducerWindow_custID, custID);
				click(institutionalCust.introducerWindow_searchBtn);
				click(institutionalCust.introducerWindow_select);
				driver.switchTo().window(parentWindow);
				SwitchToFrame(institutionalCust.introducer_frame);
				System.out.println("switched to frame");
				click(institutionalCust.introducer_activeAccountBtn);	
				break;
			}
		}
	}

	//TC-165
	public void testCustomerSelection(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		//		String custID=generateUniqueId(query, columnName);
		//		input(institutionalCust.customerID_textbox, custID);

		String intName = testdata.get("intName").toString();
		input(institutionalCust.introducer_intName, intName);

		String intAddress = testdata.get("intAddress").toString();
		input(institutionalCust.introducer_intAddress, intAddress);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer ID is added");
		Log.info("Expected Result: Customer ID is added");	
	}


	//TC-166 (1)
	public void testIntNameAutofill() {
		String intName=driver.findElement(institutionalCust.introducer_intName).getAttribute("value");
		System.out.println("Int name is "+intName);

		if(intName=="") {
			System.out.println("Field is Blank");

		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: IntName' field auto-fills after customer selection.");
			Log.info("Expected Result: IntName' field auto-fills after customer selection.");

		}

	}


	//TC-167 (1)
	public void testIntAddressAutofill() {

		if(!driver.findElement(institutionalCust.introducer_intAddress).getText().isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Introducer's Address' auto-filled after customer selection.");
			Log.info("Expected Result: Introducer's Address' auto-filled after customer selection.");

		}
	}



	//TC-169 (2)
	public void testRelIDdropdown() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 169 --> Rel_ID' Dropdown Interaction");
		select("2",institutionalCust.introducer_relIdDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Rel_ID' dropdown.");
		Log.info("Step 1: Click 'Rel_ID' dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item.");
		Log.info("Step 2: Select an item.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown opens and selection is possible.");
		Log.info("Expected Result: Dropdown opens and selection is possible.");

		ExtentTestManager.endTest();
	}

	//TC-170 (1)
	public void testRemarksField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 170 --> Remarks' Field Functionality");

		String remarks = testdata.get("remarks").toString();
		input(institutionalCust.introducer_remarks, remarks);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Type alphabets and numbers in 'Remarks'.");
		Log.info("Step 1: Type alphabets and numbers in 'Remarks'.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks' field present and accepts input.");
		Log.info("Expected Result: Remarks' field present and accepts input.");

		ExtentTestManager.endTest();

	}

	//TC-172 (1)
	public void testActiveAccountDisplay() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 170 --> Remarks' Field Functionality");

		ElementDisplayed(institutionalCust.activeAccountGrid);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Active Account' button.");
		Log.info("Step 1: Click 'Active Account' button.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify details of selected customer.");
		Log.info("Step 2: Verify details of selected customer.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Active account details displayed.");
		Log.info("Expected Result: Active account details displayed.");

		ExtentTestManager.endTest();
	}



	//TC-173 (1)
	public void testCloseBtn() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 173 --> Close' Button Functionality");
		click(institutionalCust.introducer_closeBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Close' button.");
		Log.info("Step 1: Click 'Close' button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Active account details window closes.");
		Log.info("Expected Result: Active account details window closes.");

		ExtentTestManager.endTest();
	}


	//TC-174 (1)
	public void testIntroducerSaveAndProceedBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 174 --> Saving Introducer Details");
		click(institutionalCust.introducer_saveAndProceedBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Save & Proceed' after entering details.");
		Log.info("Step 1: Click 'Save & Proceed' after entering details.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Message 'Introducer Details Successfully Saved' is displayed.");
		Log.info("Expected Result: Message 'Introducer Details Successfully Saved' is displayed.");

		ExtentTestManager.endTest();
	}


	//TC-177 (2)
	public void testIdentityTypeDropdown() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 177 --> Interact with 'Identity Type' Dropdown");
		select("12",institutionalCust.identityTypeDDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the 'Identity Type' dropdown.");
		Log.info("Step 1: Click on the 'Identity Type' dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item.");
		Log.info("Step 2: Select an item.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dropdown opens, item is selectable, and 'Proof Type' is auto-filled.");
		Log.info("Expected Result: Dropdown opens, item is selectable, and 'Proof Type' is auto-filled.");

		ExtentTestManager.endTest();

	}

	//TC-179 (1)
	public void testIdentityNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 179 --> Input Alphabets and Numerals in 'Identity No.'");
		//	String identityNo = testdata.get("identityNo").toString();


		String identityNo = generateUniqueId(spPAN,clmnNamPAN);
		input(institutionalCust.identityNo_textbox, identityNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Enter alphabets and numerals.");
		Log.info("Step 1:  Enter alphabets and numerals.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets and numerals are accepted.");
		Log.info("Expected Result: Alphabets and numerals are accepted.");

		ExtentTestManager.endTest();
	}

	//TC-182 (1)
	public void testIssuedAuthorityField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 182 --> Input Alphabets and Numerals in 'Issued Authority'");
		String issuedAuthority = testdata.get("issuedAuthority").toString();
		input(institutionalCust.issuedAuthority_textbox, issuedAuthority);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Enter alphabets and numerals.");
		Log.info("Step 1:  Enter alphabets and numerals.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets and numerals are accepted.");
		Log.info("Expected Result: Alphabets and numerals are accepted.");

		ExtentTestManager.endTest();
	}


	//TC-183 (7)
	public void testIssueDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 183 --> Validate 'Issue Date' Field");

		Thread.sleep(5000);

		click(institutionalCust.issueDate_textbox);
		String invalid_issueDate = testdata.get("invalid_issueDate").toString();
		input(institutionalCust.issueDate_textbox, invalid_issueDate);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Locate the 'Issue Date' field.");
		Log.info("Step 1:  Locate the 'Issue Date' field.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Enter an invalid date.");
		Log.info("Step 2:   Enter a invalid date.");

		click(institutionalCust.issueDateLabel);
		if(driver.findElement(institutionalCust.invalidMessage).isDisplayed()) {

			driver.findElement(institutionalCust.issueDate_textbox).clear();
			driver.findElement(institutionalCust.issueDate_textbox).clear();

			//			String issueDate = testdata.get("issueDate").toString();
			//			input(institutionalCust.issueDate_textbox, issueDate);
		}


		click(institutionalCust.issueDate_textbox);
		String issueDate = testdata.get("issueDate").toString();
		input(institutionalCust.issueDate_textbox, issueDate);

		ExtentTestManager.getTest().log(Status.PASS, "Step 3:   Enter an valid date.");
		Log.info("Step 3:   Enter a valid date.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid date is accepted, invalid date prompts an error.");
		Log.info("Expected Result: Valid date is accepted, invalid date prompts an error.");

		ExtentTestManager.endTest();

	}


	//TC-184 (2)
	public void testValidUpTo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 184 --> Validate 'Issue Date' Field");
		click(institutionalCust.validUpTo_textbox);
		String ValidUpTo = testdata.get("ValidUpTo").toString();
		input(institutionalCust.validUpTo_textbox, ValidUpTo);	
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Enter an valid date.");
		Log.info("Step 3:   Enter a valid date.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid date is accepted, invalid date prompts an error.");
		Log.info("Expected Result: Valid date is accepted, invalid date prompts an error.");

		ExtentTestManager.endTest();
	}


	//TC-186 (1)
	public void testDetailsField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 186 --> Input Alphabets and Numerals in 'Details'");

		String Details = testdata.get("Details").toString();
		input(institutionalCust.details_textbox, Details);	
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets and numerals.");
		Log.info("Step 1: Enter alphabets and numerals.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabets and numerals are accepted.");
		Log.info("Expected Result: Alphabets and numerals are accepted.");

		ExtentTestManager.endTest();
	}



	//TC-187 (8)
	public void testImageBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 187 --> Add Images through Popup ");
		String parentWindow = driver.getWindowHandle();
		click(institutionalCust.addImageBtn);

		Set<String> allWindows = driver.getWindowHandles();


		for (String window : allWindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				//click(institutionalCust.childWindow_browseBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Add Images' button.");
				Log.info("Step 1: Click 'Add Images' button.");

				UploadFile(institutionalCust.childWindow_browseBtn, ".\\src\\test\\resources\\tiger.jpg");
				ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an image (.jpeg, .jpg, .png, .gif, .pdf).");
				Log.info("Step 2: Select an image (.jpeg, .jpg, .png, .gif, .pdf).");

				click(institutionalCust.childWindow_addBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step 3: Add the file.");
				Log.info("Step 3: Add the file.");
				driver.close();
				driver.switchTo().window(parentWindow);
				SwitchToFrame(institutionalCust.identityPage_frame);
				//click(institutionalCust.validateDocumentBtn);


				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected image is displayed in popup, popup closes successfully.");
				Log.info("Expected Result: Selected image is displayed in popup, popup closes successfully.");
				break;
			}
		}
		ExtentTestManager.endTest();
	}

	//TC-188(2)
	public void testAddDocument() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 188 --> Add Document to Grid");
		click(institutionalCust.addDocumentBtn);
		if(driver.findElement(institutionalCust.identityGrid).isDisplayed()) {

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'ADD DOCUMENT' button.");
			Log.info("Step 1: Click 'ADD DOCUMENT' button.");

			ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify document data appears in the grid.");
			Log.info("Step 2: Verify document data appears in the grid.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Document data displayed in the grid successfully.");
			Log.info("Expected Result: Document data displayed in the grid successfully.");
		}
		ExtentTestManager.endTest();
	}

	//TC-191 (2)
	public void testAreaDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 191 --> Select Item from 'Area' Drop Down ");
		select("1",institutionalCust.areaDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on 'Area' drop down.");
		Log.info("Step 1: Click on 'Area' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();
	}

	//TC-194 (2)
	public void testAmshamDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 194 --> Select Item from 'Amsham' Drop Down");
		select("12",institutionalCust.amshamDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on 'Amsham' drop down.");
		Log.info("Step 1:  Click on 'Amsham' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();
	}
	//TC-197 (2)
	public void testDeshamDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 197 --> Select Item from 'Desham' Drop Down");
		select("180",institutionalCust.deshamDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on 'Desham' drop down.");
		Log.info("Step 1:  Click on 'Amsham' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}
	//TC-200 (2)
	public void testVillageDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 200 --> Select Item from 'Village' Drop Down");
		select("135",institutionalCust.villageDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Village' drop down.");
		Log.info("Step 1:   Click on 'Village' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}
	//TC-203 (1)
	public void testWardTextbox(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 203 --> Select Item from 'Ward' Drop Down");
		String ValidUpTo = testdata.get("ValidUpTo").toString();
		input(institutionalCust.validUpTo_textbox, ValidUpTo);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Ward' drop down.");
		Log.info("Step 1:   Click on 'Ward' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}


	////////
	//TC-206 (2)
	public void testPanchayathDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 206 --> Select Item from 'Panchayath' Drop Down");
		select("2",institutionalCust.panchayath_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Panchayath' drop down.");
		Log.info("Step 1:   Click on 'Panchayath' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}
	//TC-209 (2)
	public void testMunicipalityDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 209 --> Select Item from 'Municipality' Drop Down");
		select("2",institutionalCust.municipalityDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Municipality' drop down.");
		Log.info("Step 1:   Click on 'Municipality' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}

	//TC-212 (2)
	public void testCorporationDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 212 --> Select Item from 'Corporation' Drop Down");
		select("2",institutionalCust.corporationDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:    Click on 'Corporation' drop down.");
		Log.info("Step 1:    Click on 'Corporation' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();
	}


	//TC-215 (2)
	public void testAssemblyConstiDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 215 --> Select Item from 'Assembly Constituency' Drop Down");
		select("23",institutionalCust.assemblyConstiDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Assembly Constituency' drop down.");
		Log.info("Step 1:   Click on 'Assembly Constituency' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();
	}


	//TC-218 (2)
	public void testTalukDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 218 --> Select Item from 'Taluk' Drop Down");
		select("16",institutionalCust.talukDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Taluk' drop down.");
		Log.info("Step 1:   Click on 'Taluk' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the list.");
		Log.info("Step 2: Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();
	}

	//TC-220 (1)
	public void testPanchayathWardField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 220 --> Enter Numerals in 'PanchayathWard' Textfield");
		String panchayathWard = testdata.get("panchayathWard").toString();
		input(institutionalCust.panchayathWard_textbox, panchayathWard);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Enter numeric values in the 'PanchayathWard' textfield.");
		Log.info("Step 1:   Enter numeric values in the 'PanchayathWard' textfield.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numerals can be entered in the 'PanchayathWard' textfield.");
		Log.info("Expected Result: Only numerals can be entered in the 'PanchayathWard' textfield.");

		ExtentTestManager.endTest();
	}


	//TC-222 (1)
	public void testBankWardField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 222 --> Enter Numerals in 'BankWard' Textfield");
		String bankWard = testdata.get("bankWard").toString();
		input(institutionalCust.bankWard_textbox, bankWard);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Enter numeric values in the 'BankWard' textfield.");
		Log.info("Step 1:   Enter numeric values in the 'BankWard' textfield.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numerals can be entered in the 'BankWard' textfield.");
		Log.info("Expected Result: Only numerals can be entered in the 'BankWard' textfield.");

		ExtentTestManager.endTest();
	}

	//TC-225 (2)
	public void testLandTypeDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 225 --> Select Item from 'Land Type' Drop Down");
		select("Owned",institutionalCust.landType_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:    Click on 'Land Type' drop down.");
		Log.info("Step 1:    Click on 'Land Type' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:    Select an item from the list.");
		Log.info("Step 2:    Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");

		ExtentTestManager.endTest();

	}

	//TC-227 (1)
	public void testSurveyNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 227 --> Enter Alphanumeric in 'Survey No' Textfield");
		String surveyNo = testdata.get("surveyNo").toString();
		input(institutionalCust.surveyNo_textbox, surveyNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:    Enter alphanumeric values in the 'Survey No' textfield.");
		Log.info("Step 1:    Enter alphanumeric values in the 'Survey No' textfield.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only alphabets and numerals can be entered in 'Survey No' textfield.");
		Log.info("Expected Result: Only alphabets and numerals can be entered in 'Survey No' textfield.");

		ExtentTestManager.endTest();

	}

	//TC-229 (1)
	public void testResurveyNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 229 --> Enter Alphanumeric in 'ReSurvey No' Textfield");
		String resurveyNo = testdata.get("resurveyNo").toString();
		input(institutionalCust.resurveyNo_textbox, resurveyNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:    Enter alphanumeric values in the 'ReSurvey No' textfield.");
		Log.info("Step 1:    Enter alphanumeric values in the 'ReSurvey No' textfield.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only alphabets and numerals can be entered in 'ReSurvey No' textfield.");
		Log.info("Expected Result: Only alphabets and numerals can be entered in 'ReSurvey No' textfield.");

		ExtentTestManager.endTest();

	}

	//TC-232 (2)
	public void testUnitDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 232 --> Select Item from 'Unit' Drop Down");
		select("1",institutionalCust.unitDropdown);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Click on 'Unit' drop down.");
		Log.info("Step 1:   Click on 'Unit' drop down.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:    Select an item from the list.");
		Log.info("Step 2:    Select an item from the list.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is highlighted and displayed.");
		Log.info("Expected Result: Selected item is highlighted and displayed.");
		ExtentTestManager.endTest();

	}

	//TC-234 (2)
	public void testWetField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 234 --> Enter Numerals in 'Wet' Textfield");
		String wet = testdata.get("wet").toString();
		click(institutionalCust.wet_textbox);
		input(institutionalCust.wet_textbox, wet);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter numeric values in the 'Wet' textfield.");
		Log.info("Step 1: Enter numeric values in the 'Wet' textfield.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numerals can be entered in the 'Wet' textfield.");
		Log.info("Expected Result: Only numerals can be entered in the 'Wet' textfield.");
		ExtentTestManager.endTest();



	}

	//TC-236 (2)
	public void testDryField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 236 --> Enter Numerals in 'Dry' Textfield");

		String dry = testdata.get("dry").toString();
		click(institutionalCust.dry_textbox);
		input(institutionalCust.dry_textbox, dry);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Enter numeric values in the 'Dry' textfield.");
		Log.info("Step 1:  Enter numeric values in the 'Dry' textfield.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numerals can be entered in the 'Dry' textfield.");
		Log.info("Expected Result: Only numerals can be entered in the 'Dry' textfield.");
		ExtentTestManager.endTest();
	}

	//TC-238 (1)
	public void testAddBtn() throws InterruptedException{
		ExtentTestManager.startTest("TC No. - 238 --> Verify Data Insertion on 'Add' Button");
		click(institutionalCust.addBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click on 'Add' button.");
		Log.info("Step 1: Click on 'Add' button.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Check the grid for data insertion.");
		Log.info("Step 2: Check the grid for data insertion.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is inserted into the grid.");
		Log.info("Expected Result: Data is inserted into the grid.");
		ExtentTestManager.endTest();
	}

	//TC-240 (1)
	public void testIdentityAndArea_saveAndProceedBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 240 --> Verify Data Saving on 'Save & Proceed' Button");
		click(institutionalCust.identityAndArea_saveAndProceedBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Save & Proceed' button.");
		Log.info("Step 1: Click 'Save & Proceed' button.");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Verify data is saved successfully.");
		Log.info("Step 2: Verify data is saved successfully.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is successfully saved.");
		Log.info("Expected Result: Data is successfully saved.");
		ExtentTestManager.endTest();
	}


	/////////////////////
	//TC-245 (2)
	public void testStateDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 245 --> Select State from Dropdown");
		select("KERALA",institutionalCust.bank_state_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a state from the list");
		Log.info("Step 1: Select a state from the list");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: State is selected");
		Log.info("Expected Result: State is selected");
		ExtentTestManager.endTest();
	}

	//TC-248 (2)
	public void testBankIdDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 248 --> Select BankID from Dropdown");
		select("2",institutionalCust.bankId_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a BankID from the list");
		Log.info("Step 1: Select a BankID from the list");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: BankID is selected");
		Log.info("Expected Result: BankID is selected");
		ExtentTestManager.endTest();
	}

	//TC-251 (2)
	public void testBranchIdDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 251 --> Select BranchID from Dropdown");
		select("CALICUT(KOZHICODE)",institutionalCust.branchId_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a BranchID from the list");
		Log.info("Step 1: Select a BranchID from the list");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: BranchID is selected");
		Log.info("Expected Result: BranchID is selected");
		ExtentTestManager.endTest();

	}


	//TC-252 (1)
	public void testIFSCAutofill() {
		ExtentTestManager.startTest("TC No. - 252 --> Check IFSC Code Field Auto-fill");
		String ifsc=driver.findElement(institutionalCust.ifsc_textbox).getAttribute("value");
		if(ifsc!="") {

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check if IFSC code field is auto-filled");
			Log.info("Step 1: Check if IFSC code field is auto-filled");


			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: IFSC code field is auto-filled");
			Log.info("Expected Result: IFSC code field is auto-filled");
			ExtentTestManager.endTest();
		}
	}

	//TC-254 (1)
	public void testCustName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		ExtentTestManager.startTest("TC No. - 254 --> Validate 'Cust Name' Input");
		String custName = testdata.get("custName").toString();
		input(institutionalCust.custName_textbox, custName);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters in 'Cust Name' field");
		Log.info("Step 1: Enter alphabets, numerals, and special characters in 'Cust Name' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only alphabets are allowed\r\n"
				+ "alphabets,numbers and special character allowed");
		Log.info("Expected Result: Only alphabets are allowed\r\n"
				+ "alphabets,numbers and special character allowed");

		ExtentTestManager.endTest();

	}

	//TC-256 (1)
	public void testAddress(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		ExtentTestManager.startTest("TC No. - 256 --> Validate 'Address' Input");
		String Address = testdata.get("Address").toString();
		input(institutionalCust.address_textbox, Address);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters in 'Address' field");
		Log.info("Step 1: Enter alphabets, numerals, and special characters in 'Address' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted");
		Log.info("Expected Result: Input is accepted");

		ExtentTestManager.endTest();
	}



	//TC-258 (1)
	public void testBankAccNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 258 --> Validate 'BankAccNo' Input");
		String bankAccNo = testdata.get("bankAccNo").toString();
		input(institutionalCust.bankAccNo_textbox, bankAccNo);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters in 'BankAccNo' field");
		Log.info("Step 1: Enter alphabets, numerals, and special characters in 'BankAccNo' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: alphabets, numerals, and special characters allowed, field is encrypted");
		Log.info("Expected Result: alphabets, numerals, and special characters allowed, field is encrypted");

		ExtentTestManager.endTest();

	}


	//TC-260 (1)
	public void testRetypeAccNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 260 --> Validate 'RetypeAccNo' Input");
		String RetypeAccNo = testdata.get("RetypeAccNo").toString();
		input(institutionalCust.retypeAccNo_textbox, RetypeAccNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters in 'RetypeAccNo' field");
		Log.info("Step 1: Enter alphabets, numerals, and special characters in 'RetypeAccNo' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: alphabets, numerals, and special characters allowed, field is encrypted");
		Log.info("Expected Result: alphabets, numerals, and special characters allowed, field is encrypted");

		ExtentTestManager.endTest();
	}

	//TC-263 (2)
	public void testBankAccIdDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 263 --> Select BankAccID from Dropdown");
		select("5",institutionalCust.bankAccId_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a BankAccID from the list");
		Log.info("Step 1: Select a BankAccID from the list");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: BankAccID is selected");
		Log.info("Expected Result: BankAccID is selected");

		ExtentTestManager.endTest();
	}

	//TC-265 (2)
	public void testBankStartDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 265 --> Enter Date in 'Start Date' Field");
		String bank_stateDate = testdata.get("bank_stateDate").toString();
		click(institutionalCust.bank_startDate_textbox);
		input(institutionalCust.bank_startDate_textbox, bank_stateDate);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter a date in 'Start Date' field");
		Log.info("Step 1: Enter a date in 'Start Date' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is entered");
		Log.info("Expected Result: Date is entered");

		ExtentTestManager.endTest();
	}

	//TC-268 (1)
	public void testAdditionalInfoCheckBox() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 268 --> Toggle 'Additional Information' Checkbox");
		click(institutionalCust.additionalInfoCheckBox);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click the 'Additional Information' checkbox");
		Log.info("Step 1: Click the 'Additional Information' checkbox");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Balance Ason', 'Balance', 'Credit card', 'Credit card no' are displayed");
		Log.info("Expected Result: Balance Ason', 'Balance', 'Credit card', 'Credit card no' are displayed");

		ExtentTestManager.endTest();
	}

	//TC-269 (1)
	public void testBalanceAsOn(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 269 --> Enter Date in 'Balance Ason' Field");
		String balanceAsOn = testdata.get("balanceAsOn").toString();
		input(institutionalCust.balanceAsOn_bank, balanceAsOn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter a date in 'Balance Ason' field");
		Log.info("Step 1: Enter a date in 'Balance Ason' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Date is entered");
		Log.info("Expected Result: Date is entered");

		ExtentTestManager.endTest();
	}

	//TC-271 (1)
	public void testBalanceField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 271 --> Validate 'Balance' Field Input");
		String balance = testdata.get("balance").toString();
		input(institutionalCust.balance_textbox, balance);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter numerals only in 'Balance' field");
		Log.info("Step 1: Enter numerals only in 'Balance' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted");
		Log.info("Expected Result: Input is accepted");

		ExtentTestManager.endTest();
	}

	//TC-273 (2)
	public void testBalanceFieldIsRemoved() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 273 --> Toggle 'Not Mentioned' Checkbox");
		click(institutionalCust.notMentionedCheckbox);
		if(!driver.findElement(institutionalCust.balance_textbox).isDisplayed()) {

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Not Mentioned' checkbox");
			Log.info("Step 1: Click 'Not Mentioned' checkbox");


			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Balance' field is removed");
			Log.info("Expected Result: Balance' field is removed");

			ExtentTestManager.endTest();
		}
	}

	//TC-274 (1)
	public void testCreditCardTick() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 274 --> Check 'Credit Card' Checkbox Tick");
		click(institutionalCust.creditCardCheckboc);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check if 'Credit Card' checkbox can be ticked");
		Log.info("Step 1: Check if 'Credit Card' checkbox can be ticked");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is ticked");
		Log.info("Expected Result: Checkbox is ticked");

		ExtentTestManager.endTest();
	}

	//TC-275 (1)
	public void testCreditCardNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 275 --> Validate 'Credit Card No' Input");
		String creditCardNo = testdata.get("creditCardNo").toString();
		input(institutionalCust.credirCardNo_textbox, creditCardNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, special characters in 'Credit Card No' field if tick the credit card checkbox");
		Log.info("Step 1: Enter alphabets, numerals, special characters in 'Credit Card No' field if tick the credit card checkbox");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only numerals are accepted\r\n"
				+ "alphabets, numerals, and special characters allowed");
		Log.info("Expected Result: Only numerals are accepted\r\n"
				+ "alphabets, numerals, and special characters allowed");

		ExtentTestManager.endTest();
	}

	//TC-277 (2)
	public void testBankAddBtnFunc() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 277 --> Verify 'Add' Button Functionality");
		click(institutionalCust.bank_addBtn);
		if(driver.findElement(institutionalCust.bankGrid).isDisplayed()) {


			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Add' button");
			Log.info("Step 1: Click 'Add' button");


			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is inserted into the gridd");
			Log.info("Expected Result: Data is inserted into the gridd");

			ExtentTestManager.endTest();
		}
	}

	//TC-280 (1)
	public void testDPIDField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 280 --> Validate 'DPID' Input");
		String dpid = testdata.get("dpid").toString();
		input(institutionalCust.dpid_textbox, dpid);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets and numerals in 'DPID' field");
		Log.info("Step 1: Enter alphabets and numerals in 'DPID' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted");
		Log.info("Expected Result: Input is accepted");

		ExtentTestManager.endTest();
	}

	//TC-282 (1)
	public void testDematAcc(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 282 --> Validate 'Demat Acno' Input");
		String demataccNo = testdata.get("demataccNo").toString();
		input(institutionalCust.dematAccNo, demataccNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets and numerals in 'Demat Acno' field");
		Log.info("Step 1: Enter alphabets and numerals in 'Demat Acno' field");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Input is accepted");
		Log.info("Expected Result: Input is accepted");

		ExtentTestManager.endTest();

	}

	//TC-284 (1)
	public void testProceedBtnFunc() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 284 --> Verify 'Proceed' Button Functionality");
		click(institutionalCust.bank_proceedBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Proceed' button");
		Log.info("Step 1: Click 'Proceed' button");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is successfully saved");
		Log.info("Expected Result: Data is successfully saved");

		ExtentTestManager.endTest();
	}

	//TC-287 (2)
	public void testRiskIdDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 287 --> Verify Selection from 'RiskID' Dropdown");
		select("3",institutionalCust.riskId_dropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the 'RiskID' dropdown.");
		Log.info("Step 1: Click 'Proceed' button");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Select an item from the dropdown.");
		Log.info("Step 2: Select an item from the dropdown.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The item is selected and reflected in the dropdown list.");
		Log.info("Expected Result: The item is selected and reflected in the dropdown list.");

		ExtentTestManager.endTest();
	}


	//TC-289(1)
	public void testRiskRemarksField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 289 --> Validate Input in 'Remarks' Field");
		String risk_remarks = testdata.get("risk_remarks").toString();
		input(institutionalCust.risk_remarks_textbox, risk_remarks);	

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters into the 'Remarks' field.");
		Log.info("Step 1: Enter alphabets, numerals, and special characters into the 'Remarks' field.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Remarks' field accepts alphabets, numerals, and special characters.");
		Log.info("Expected Result: The 'Remarks' field accepts alphabets, numerals, and special characters.");

		ExtentTestManager.endTest();
	}

	//TC-291 (1)
	public void testActivespecialinstructionField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 291 --> Validate Input in 'Activespecialinstruction' Field");
		String actSplIns = testdata.get("actSplIns").toString();
		input(institutionalCust.ActiveSpecialInstruction_textbox, actSplIns);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter alphabets, numerals, and special characters into the 'Activespecialinstruction' field.");
		Log.info("Step 1: Enter alphabets, numerals, and special characters into the 'Activespecialinstruction' field.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'Activespecialinstruction' field accepts alphabets, numerals, and special characters.");
		Log.info("Expected Result: The 'Activespecialinstruction' field accepts alphabets, numerals, and special characters.");

		ExtentTestManager.endTest();
	}


	//TC-293 (1)
	public void testDefaultStateOfSusCheckbox() {
		ExtentTestManager.startTest("TC No. - 293 --> Validate Default State of 'Suspecious' Checkbox");

		if(!driver.findElement(institutionalCust.suspecious_checkbox).isSelected()) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Verify the default state of the 'suspecious' checkbox.");
			Log.info("Step 1: Verify the default state of the 'suspecious' checkbox.");


			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'suspecious' checkbox is unticked by default.");
			Log.info("Expected Result: The 'suspecious' checkbox is unticked by default.");


		}
		ExtentTestManager.endTest();
	}

	//TC-294 (1)
	public void testTickSusField() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 294 --> Validate Ticking of 'Suspecious' Checkbox");
		click(institutionalCust.suspecious_checkbox);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Attempt to tick the 'suspecious' checkbox.");
		Log.info("Step 1: Attempt to tick the 'suspecious' checkbox.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The 'suspecious' checkbox is ticked successfully.");
		Log.info("Expected Result: The 'suspecious' checkbox is ticked successfully.");
		ExtentTestManager.endTest();
	}


	//TC-296 (2)
	public void testRiskSaveAndProceed() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 296 --> Verify Successful Save with 'Save&Proceed' Button");

		ScrollUntilElementVisible(institutionalCust.risk_saveAndProceedBtn);
		click(institutionalCust.risk_saveAndProceedBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the 'Save&Proceed' button.");
		Log.info("Step 1: Click on the 'Save&Proceed' button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is successfully saved, and the user proceeds to the next part.");
		Log.info("Expected Result: Data is successfully saved, and the user proceeds to the next part.");
		ExtentTestManager.endTest();
	}

	//TC-305 (2)
	public void testselectPhotoFromDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 305 --> Select Photo from Dropdown");
		select("1",institutionalCust.document_dropdown_one);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Select 'Photo' from dropdown");
		Log.info("Step 1:  Select 'Photo' from dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Photo' selected in dropdown");
		Log.info("Expected Result: Photo' selected in dropdown");
		ExtentTestManager.endTest();
	}


	//TC-306 (2)
	public void testUploadPhoto() {
		ExtentTestManager.startTest("TC No. - 306 --> Upload Photo in Supported Format");
		UploadFile(institutionalCust.selectDoc_browse,".\\src\\test\\resources\\tiger.jpg");

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'browse' button");
		Log.info("Step 1:  Click 'browse' button");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select an image with .jpeg, .jpg, .png, .gif, or .pdf format");
		Log.info("Step 2:  Select an image with .jpeg, .jpg, .png, .gif, or .pdf format");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected image file is accepted for upload");
		Log.info("Expected Result: Selected image file is accepted for upload");
		ExtentTestManager.endTest();
	}


	//TC-308 (3)
	public void testCheckDefaultCheckbox() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 308 --> Add Photo with Default Checkbox Checked");
		click(institutionalCust.defaultCheckbox);
		click(institutionalCust.add_photo_Btn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Add' button");
		Log.info("Step 1:  Click 'Add' button");

		if(driver.findElement(institutionalCust.imageDisplayWindow).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Photo displayed in the window");
			Log.info("Expected Result: Photo displayed in the window");
		}
		ExtentTestManager.endTest();
	}

	//TC-309 (2)
	public void testselectSignFromDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 309 --> Select Sign from Dropdown");
		select("2",institutionalCust.document_dropdown_one);


		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Select 'Sign' from dropdown");
		Log.info("Step 1:  Select 'Sign' from dropdown");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Sign' selected in dropdown");
		Log.info("Expected Result: Sign' selected in dropdown");
		ExtentTestManager.endTest();
	}

	//TC-310 (2)
	public void testUploadSign() {
		ExtentTestManager.startTest("TC No. - 310 --> Upload Sign in Supported Format");
		UploadFile(institutionalCust.selectDoc_browse, ".\\src\\test\\resources\\e-sign.pdf");

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'browse' button");
		Log.info("Step 1:  Click 'browse' button");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select a signature image with .jpeg, .jpg, .png, .gif, or .pdf format");
		Log.info("Step 2:  Select a signature image with .jpeg, .jpg, .png, .gif, or .pdf format");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected sign file is accepted for upload");
		Log.info("Expected Result: Selected sign file is accepted for upload");
		ExtentTestManager.endTest();
	}

	//TC-311 (2)
	public void testAddSign() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 311 --> Add Sign to Display Window");
		click(institutionalCust.add_photo_Btn);
		if(driver.findElement(institutionalCust.imageDisplayWindow).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Add' button");
			Log.info("Step 1:  Click 'Add' button");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Sign image displayed in the window");
			Log.info("Expected Result: Sign image displayed in the window");

		}
		ExtentTestManager.endTest();
	}

	//TC-312 (2)
	public void testselectGeneralFromDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 312 --> Select General from Dropdown");
		select("3",institutionalCust.document_dropdown_one);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Select 'General' from dropdown");
		Log.info("Step 1:  Select 'General' from dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: General' selected in dropdown");
		Log.info("Expected Result: General' selected in dropdown");
		ExtentTestManager.endTest();
	}


	//TC-313 (2)
	public void testDocumentNameDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 313 --> Verify Document Name Dropdown");
		select("15",institutionalCust.document_dropdown_two);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Check if the list of document names is present in dropdown");
		Log.info("Step 1:   Check if the list of document names is present in dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Document name dropdown is present");
		Log.info("Expected Result: Document name dropdown is present");
		ExtentTestManager.endTest();
	}

	//TC-314 (2)
	public void testUploadGeneralDocument() {
		ExtentTestManager.startTest("TC No. - 314 --> Upload General Document in Supported Format");
		UploadFile(institutionalCust.selectDoc_browse,".\\src\\test\\resources\\tiger.jpg");
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'browse' button");
		Log.info("Step 1: Click 'browse' button");

		ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Select a general image with .jpeg, .jpg, .png, .gif, or .pdf format");
		Log.info("Step 2:  Select a general image with .jpeg, .jpg, .png, .gif, or .pdf format");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected general file is accepted for upload");
		Log.info("Expected Result: Selected general file is accepted for upload");
		ExtentTestManager.endTest();

	}

	//TC-315 (1)
	public void testAddGenDocWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 315 --> Add General Document to Display Window");
		click(institutionalCust.add_photo_Btn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Add' button");
		Log.info("Step 1:  Click 'Add' button");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: General image displayed in the window");
		Log.info("Expected Result: General image displayed in the window");
		ExtentTestManager.endTest();
	}


	//TC-317 (5)
	public void testFinishBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 317 --> Save Data Upon Proceed");
		ScrollUntilElementVisible(institutionalCust.finishBtn);
		click(institutionalCust.finishBtn);
		//click(institutionalCust.finishBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Click 'Proceed' button");
		Log.info("Step 1:  Click 'Proceed' button");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is successfully saved");
		Log.info("Expected Result: Data is successfully saved");

		click(institutionalCust.final_OKBtn);
		driver.switchTo().defaultContent();
		transactionID=driver.findElement(institutionalCust.transactionID).getText();
		System.out.println(transactionID);
		ExtentTestManager.endTest();
	}

	//TC-324(3)
	public void userLogin1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		signOut();

		ExtentTestManager.startTest("TC No. - 324 --> Login to LMS as another User");
		//String loginUserName1 = testdata.get("loginUserName1").toString();
        String loginUserName1=configloader().getProperty("UserName1");
		input(institutionalCust.loginUserName, loginUserName1);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter valid username.");
		Log.info("Step-1: Enter valid username.");

		 String loginValidPassword1=configloader().getProperty("Password1");
		//String loginValidPassword1 = testdata.get("loginValidPassword1").toString();
		input(institutionalCust.loginPasswrd, loginValidPassword1);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Enter valid password.");
		Log.info("Step-2: Enter valid password.");

		click(institutionalCust.loginButton);
		
		 try {
	        	click(institutionalCust.OkBtn_loginStatusFailed);
	            if(ElementDisplayed(institutionalCust.loginUserName)) {
	            	input(institutionalCust.loginUserName, loginUserName1);
	            	input(institutionalCust.loginPasswrd, loginValidPassword1);
	            	click(institutionalCust.loginButton);
	            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login is successfull");
	    			Log.info("Expected Result: Login is successfull");
	            }else {
	                  ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	                  Log.info("ERROR");
	            }
	                                
	     }catch(Exception e) {
	            
	           // click(loanOpen.okBtn);
	            
	            if(ElementDisplayed(institutionalCust.signOut)) {
	            	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login is successfull directly");
	    			Log.info("Expected Result: Login is successfull directly");
	            }else {
	                  ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	                  Log.info("ERROR");
	            }
	            
	     }
		
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on 'Login'.");
		Log.info("Step-3: Click on 'Login'.");
		Thread.sleep(10000);
		//		boolean flag1 = ElementDisplayed(institutionalCust.dashboard);
		//		boolean flag = flag1;
		//		if(flag == true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Another user successfully logs in to LMS.");
		Log.info("Expected Result: Another user successfully logs in to LMS.");
		//}
		ExtentTestManager.endTest();

	}

	//TC-325 (2)
	public void testManagerAuthorization() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 325 --> Manager Authorization");

		click(institutionalCust.authorizeAndCancel);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on authorize and cancel tab");
		Log.info("Step-1: Click on authorize and cancel tab");

		click(institutionalCust.managerAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Click on manager authorization tab");
		Log.info("Step-2: Click on manager authorization tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager Authorization window should be display");
		Log.info("Expected Result: Manager Authorization window should be display");

		ExtentTestManager.endTest();	
	}

	
	//TC-326
	public void testOtherTabBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 327 --> Validate Others Tab");
		click(institutionalCust.otherTab);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on Others tab");
		Log.info("Step-1: Click on Others tab ");
		input(institutionalCust.transactionID_textbox,transactionID);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Others tab load");
		Log.info("Expected Result: Others tab load");
		ExtentTestManager.endTest();	
	}
	//TC-327 (1)
	public void testRefreshBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 327 --> Validate refresh button in manager authorization page");
		
		click(institutionalCust.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan entry should be display in the  window");
		Log.info("Expected Result: Loan entry should be display in the  window");

		ExtentTestManager.endTest();	
	}

	//TC-328 (2)
	public void testSelectAndAuthorize() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 328 --> Select and authorize the customer in manager authorization page");

		click(institutionalCust.otherTab_checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on checkbox");
		Log.info("Step-1: Click on checkbox");
		click(institutionalCust.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Click on authorize button");
		Log.info("Step-2: Click on authorize button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is authorized");
		Log.info("Expected Result: Entry is authorized");

		ExtentTestManager.endTest();	
	}

	public boolean signOut() throws InterruptedException {
		ExtentTestManager.startTest(" SignOut");
		//closePop();
		click(institutionalCust.signOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on SignOut");
		Log.info("Step-1: Click on SignOut");
		//		ExtentTestManager.getTest().log(Status.PASS, "Admin SignedOut");
		//		Log.info("Admin SignedOut");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is signed out successfully");
		Log.info("Expected Result: User is signed out successfully");
		ExtentTestManager.endTest();
		return true;
	}

	public void closePop() throws InterruptedException {
		click(institutionalCust.closePop);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup is closed");
		Log.info("Expected Result: Popup is closed");

	}

}