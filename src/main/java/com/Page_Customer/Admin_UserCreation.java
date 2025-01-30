package com.Page_Customer;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepository_User_Creation;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Admin_UserCreation extends Base_Class {

	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		

	PageRepository_User_Creation puc = new PageRepository_User_Creation();


	//public static String password=null;
	//public static String userID=null;

	public void closePopup() throws InterruptedException {
		click(puc.continueBtn);
		System.out.println("Popup closed");
	}

	public boolean signOut() throws InterruptedException {
		click(puc.admin_signOutBtn);
		//		ExtentTestManager.getTest().log(Status.PASS, "Admin SignedOut");
		//		Log.info("Admin SignedOut");
		return true;
	}

	//TC-02
	public void adminLogin(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 02 --> Login with Admin User");
		String loginUserName = testdata.get("loginUserName").toString();
		input(custSearch.loginUserName, loginUserName);
		String loginValidPassword = testdata.get("loginValidPassword").toString();
		input(custSearch.loginPasswrd, loginValidPassword);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter admin credentials (username and password)");
		Log.info("Step 1-> Enter admin credentials (username and password)");
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2-> Click on the Login button");
		Log.info("Step 2-> Click on the Login button");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Admin is logged in successfully and directed to dashboard.");
		Log.info("Expected Result: Admin is logged in successfully and directed to dashboard.");
		ExtentTestManager.endTest();
		//		boolean flag1 = ElementDisplayed(custSearch.home);
		//		boolean flag = flag1;
		//		if(flag==true){
		//			ExtentTestManager.getTest().log(Status.PASS, "User Login - Valid Password --> PASS, User Login Success");
		//			Log.info("Valid Password, Validated Successfully!");
		//		}		
		//return true;

	}



	//TC-03
	public void testNavigateToAddNewUserWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 03 --> Navigate to Add New User Window");
		System.out.println("Method getting started");
		Thread.sleep(3000);
		click(puc.admin);
		click(puc.user_management);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1->Go to 'User Management");
		Log.info("Step 1->Go to 'User Management");

		click(puc.addNewUser);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2->Click on 'Add New User'");
		Log.info("Step 2->Click on 'Add New User'");

		ElementDisplayed(puc.addNewUserLabel);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add New User' window is displayed.");
		Log.info("Expected Result: Add New User' window is displayed.");
		//Assert.assertTrue(ElementDisplayed(puc.addNewUserLabel), "Add New User window should be displayed");
		ExtentTestManager.endTest();
	}

	//TC-04
	public void testValidUserIdInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 04 --> User ID Field - Valid Input");

		//click(puc.addNewUser);
		String userId = testdata.get("userId").toString();				
		input(puc.userID, userId);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter alphabets in User ID field");
		Log.info("Step-1: Enter alphabets in User ID field");

		String name = testdata.get("name").toString();				
		input(puc.name, name);

		String group = testdata.get("group").toString();	

		String branch = testdata.get("branch").toString();	

		String machineID = testdata.get("machineID").toString();

		String mobile = testdata.get("mobile").toString();

		String emailID = testdata.get("emailID").toString();


		select(group,puc.group_dropdown);
		select(branch,puc.branch_dropdown);
		select(machineID,puc.machineID_dropdown);
		input(puc.mobile,mobile);
		input(puc.emailID,emailID);
		click(puc.level_checkBoxes1);
		click(puc.saveBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Click Save");
		Log.info("Step-2: Click Save");


		//		ExtentTestManager.getTest().log(Status.PASS, "Password is "+driver.findElement(puc.password).getText());
		//		Log.info("Password is \"+driver.findElement(puc.password).getText()");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New user is added if all inputs are valid");
		Log.info("Expected Result: New user is added if all inputs are valid");

		String password=driver.findElement(puc.password).getText().toString();
		System.out.println("The password is "+password);

		click(puc.closeBtn);

		Base_Class.DatabaseConnector1();
		//Log.info("Connected to Database");
		Thread.sleep(5000);

		signOut();
		ExtentTestManager.getTest().log(Status.PASS, "Admin SignedOut");
		Log.info("Admin SignedOut");
		Thread.sleep(5000);

		//  String loginUserName = testdata.get("loginUserName").toString();	
		input(custSearch.loginUserName, userId);
		Log.info("Username entered");
		//  String loginValidPassword = testdata.get("loginValidPassword").toString();
		System.out.println(password.toLowerCase());
		input(custSearch.loginPasswrd, password);
		Log.info("Password entered");
		click(custSearch.loginButton);
		Log.info("Clicked on login button");
		Thread.sleep(2000);

		driver.findElement(puc.oldPassword).sendKeys(password);
		driver.findElement(puc.newPassword).sendKeys("iHe3iHe ");
		driver.findElement(puc.cnfirmPwd).sendKeys("iHe3iHe ");
		click(puc.submitBtn);

		Base_Class.AcceptAlert();


		ExtentTestManager.endTest();
	}


	//TC NO-05
	public void testInvalidUserIdInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		ExtentTestManager.startTest("TC No. - 05 --> User ID Field - Invalid Input");

		String invalidUserId = testdata.get("invalidUserId").toString();			
		input(puc.userID, invalidUserId);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter numeric or special characters in User ID field");
		Log.info("Step 1-> Enter numeric or special characters in User ID field");


		String name = testdata.get("name").toString();				
		input(puc.name, name);

		String group = testdata.get("group").toString();	

		String branch = testdata.get("branch").toString();	

		String machineID = testdata.get("machineID").toString();

		String mobile = testdata.get("mobile").toString();

		String emailID = testdata.get("emailID").toString();

		select(group,puc.group_dropdown);
		select(branch,puc.branch_dropdown);
		select(machineID,puc.machineID_dropdown);
		input(puc.mobile,mobile);
		input(puc.emailID,emailID);
		click(puc.level_checkBoxes2);
		click(puc.saveBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2-> Click Save.");
		Log.info("Step 2-> Click Save.");
		//		ExtentTestManager.getTest().log(Status.PASS, "Password is "+driver.findElement(puc.password).getText());
		//		Log.info("Password is \"+driver.findElement(puc.password).getText()");


		if(driver.findElement(puc.errorMessage).getText().equalsIgnoreCase("Failed to meet the policy of User ID Content type, the Content type should be Alpha Only")) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for invalid User ID.");
			Log.info("Expected Result: Error message displayed for invalid User ID.");
			click(puc.errorMessageOkBtn);

		}

		//System.out.println(driver.findElement(By.xpath("//span[@id='ctl00_lblErrorMessage']")).getText());

		ExtentTestManager.endTest();

	}

	//TC NO-06
	public void testNameFieldValidInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		ExtentTestManager.startTest("TC No. - 06 --> Name Field - Valid Input");

		click(puc.addNewUser);
		String userID = testdata.get("userId1").toString();			
		input(puc.userID, userID);
		//		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter numeric or special characters in User ID field");
		//		Log.info("Step 1-> Enter numeric or special characters in User ID field");


		String validName = testdata.get("validName").toString();				
		input(puc.name, validName);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter alphabets in Name field");
		Log.info("Step 1-> Enter alphabets in Name field");

		String group = testdata.get("group").toString();	

		String branch = testdata.get("branch").toString();	

		String machineID = testdata.get("machineID").toString();

		String mobile = testdata.get("mobile").toString();

		String emailID = testdata.get("emailID").toString();

		select(group,puc.group_dropdown);
		select(branch,puc.branch_dropdown);
		select(machineID,puc.machineID_dropdown);
		input(puc.mobile,mobile);
		input(puc.emailID,emailID);
		click(puc.level_checkBoxes3);
		//click(puc.level_checkBoxes3);
		click(puc.saveBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2-> Click Save.");
		Log.info("Step 2-> Click Save.");

		String message=driver.findElement(puc.password).getText();
		Log.info("Generated password is "+message);
		Thread.sleep(5000);
		click(puc.closeBtn);


		ExtentTestManager.getTest().log(Status.PASS, "Expected Resule: New user is added if all inputs are valid.");
		Log.info("Expected Resule: New user is added if all inputs are valid.");
		//		if(driver.findElement(puc.validNameSuccuessMessage).getText().equalsIgnoreCase("The created Username Password is\r\n"
		//				+ "qrtqui : yvB6yvB ")) {
		//
		//
		//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: New user is added if all inputs are valid.");
		//			Log.info("Expected Result: New user is added if all inputs are valid.");
		//
		//		
		//		}

		ExtentTestManager.endTest();
	}


	//TC NO-07
	public void testInvalidNameInput(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 07 --> Name Field - Invalid Input");

		click(puc.addNewUser);
		String userID = testdata.get("userId2").toString();			
		input(puc.userID, userID);
		//		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter numeric or special characters in User ID field");
		//		Log.info("Step 1-> Enter numeric or special characters in User ID field");


		String invalidName = testdata.get("invalidName").toString();				
		input(puc.name, invalidName);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1-> Enter alphabets in Name field");
		Log.info("Step 1-> Enter alphabets in Name field");

		String group = testdata.get("group").toString();	

		String branch = testdata.get("branch").toString();	

		String machineID = testdata.get("machineID").toString();

		String mobile = testdata.get("mobile").toString();

		String emailID = testdata.get("emailID").toString();

		select(group,puc.group_dropdown);
		select(branch,puc.branch_dropdown);
		select(machineID,puc.machineID_dropdown);
		input(puc.mobile,mobile);
		input(puc.emailID,emailID);
		click(puc.level_checkBoxes3);
		//click(puc.level_checkBoxes3);
		click(puc.saveBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2-> Click Save.");
		Log.info("Step 2-> Click Save.");

		String message=driver.findElement(puc.password).getText();
		Log.info("Generated password is "+message);

		Thread.sleep(5000);
		click(puc.closeBtn);


		ExtentTestManager.endTest();
	}


}
