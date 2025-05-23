package com.Page_Admin;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Bond_BondConfiguration;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Bond_BondConfiguration extends Base_Class{

	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_Bond_BondConfiguration bondRepo = new PageRepositary_Bond_BondConfiguration();
	
	
	public void adminLogin() throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("**Basic Login Functionality**").assignCategory("BondConfiguration");
		Log.info("**Basic Login Functionality**");
			
			
					String UserName = configloader().getProperty("AdminUserName");
					input(custSearch.loginUserName,UserName );
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
					Log.info("Step:01 - Enetered valid Admin User Name");
					
					String Password = configloader().getProperty("AdminPassword");
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
					input(custSearch.loginPasswrd, Password);
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
					Log.info("Step:02 - Enetered valid Admin Password");
					
					click(custSearch.loginButton);
					ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
					Log.info("Step:03 - Click on Login Button");
					
					try {
					ElementDisplayed(bondRepo.continueBtn);
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
						
						input(custSearch.loginUserName, UserName);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
						Log.info("Step:02 - Enetered valid Admin User Name");
						
						input(custSearch.loginPasswrd, Password);
						ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
						Log.info("Step:03 - Entered valid Admin Password");
						
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
						Log.info("Step:04 - Click on Login Button");
						
									ElementDisplayed(bondRepo.continueBtn);
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
									Log.info("Expected Result: User is logged in successfully and dashboard visible");	
							}
					
		ExtentTestManager.endTest();

	}//end
	
	
	public void navigateToBondConfiguration() throws InterruptedException {
		
		//Expand Module for Collection Importing
		ExtentTestManager.startTest("**Open Bond Configuration**").assignCategory("BondConfiguration");
		Log.info("**Open Bond Configuration**");
		
		click(bondRepo.continueBtn);
		
		click(bondRepo.bondTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to 'Bond' section");
		Log.info("1. Navigate to 'Bond' section");

		click(bondRepo.bondConfigTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Click on Bond Configuration.");
		Log.info("2. Click on Bond Configuration.");
		
		if(ElementDisplayed(bondRepo.bdProductNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Bond configuration window is opened.");
			Log.info("Expected Result: Bond configuration window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void bondConfiguration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		//**Select Product Name**
		ExtentTestManager.startTest("**Select Product Name**").assignCategory("BondConfiguration");
		Log.info("**Select Product Name**");
		
		select("DEBUNTURE SCHEME 2",bondRepo.bdProductNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Open Product Name dropdown\r\n"
				+ "2. Select a valid product name\"");
		Log.info("\"1. Open Product Name dropdown\r\n"
				+ "2. Select a valid product name\"");
		
		if(dropdownSelectionValidation("DEBUNTURE SCHEME 2",bondRepo.bdProductNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product Name is selected.");
			Log.info("Expected Result: Product Name is selected.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//**Enter Face Value**
		ExtentTestManager.startTest("**Enter Face Value**").assignCategory("BondConfiguration");
		Log.info("**Enter Face Value**");
	
		String faceValue = testdata.get("faceValue").toString();
		input(bondRepo.bdFaceValueTxtBox,faceValue);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter '100' in Face Value field");
		Log.info("1. Enter '100' in Face Value field");
		
		if(inputValidation(bondRepo.bdFaceValueTxtBox,faceValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Face Value is entered as 100");
			Log.info("Expected Result: Face Value is entered as 100");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		

		//**Select App. GLAcc Name and Verify Code**
		ExtentTestManager.startTest("**Select App. GLAcc Name and Verify Code**").assignCategory("BondConfiguration");
		Log.info("**Select App. GLAcc Name and Verify Code**");
		
		select("ALLOWANCE",bondRepo.bdAppAccNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Open App. GLAcc Name dropdown\r\n"
				+ "2. Select an account name");
		Log.info("1. Open App. GLAcc Name dropdown\r\n"
				+ "2. Select an account name");
		
		waitUntilElementDisappear(bondRepo.loader);
		
		String AppAccCodeValue = driver.findElement(bondRepo.bdAppAccCodeTxtBox).getAttribute("value");
		System.out.println("AppAccCodeValue: "+AppAccCodeValue);

		if(dropdownSelectionValidation("ALLOWANCE",bondRepo.bdAppAccNameDropdown) && !AppAccCodeValue.isBlank()) {
			
			ExtentTestManager.getTest().log(Status.PASS, "3. Verify the App. GLAcc code is autoloaded");
			Log.info("3. Verify the App. GLAcc code is autoloaded");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//**Enter Duration and Select Frequency**
		ExtentTestManager.startTest("**Enter Duration and Select Frequency**").assignCategory("BondConfiguration");
		Log.info("**Enter Duration and Select Frequency**");
	
		String duration = testdata.get("duration").toString();
		input(bondRepo.bdDurationTxtBox,duration);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter '12' in Duration field");
		Log.info("1. Enter '12' in Duration field");
		
		select("MONTHS",bondRepo.bdDurationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "2. Select 'monthly' from Duration dropdown");
		Log.info("2. Select 'monthly' from Duration dropdown");
		
		if(inputValidation(bondRepo.bdDurationTxtBox,duration) && dropdownSelectionValidation("MONTHS",bondRepo.bdDurationDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Duration is set correctly");
			Log.info("Expected Result: Duration is set correctly");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//**Enter Int.Transfer Frequency and Select Unit**
		ExtentTestManager.startTest("**Enter Int.Transfer Frequency and Select Unit**").assignCategory("BondConfiguration");
		Log.info("**Enter Int.Transfer Frequency and Select Unit**");
	
		String frequency = testdata.get("frequency").toString();
		input(bondRepo.bdIntTransferFrequencyTxtBox,frequency);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter '30' in Int.Transfer Frequency");
		Log.info("1. Enter '30' in Int.Transfer Frequency");
		
		select("DAYS",bondRepo.bdIntTransferFrequencyDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "2. Select 'days' from the dropdown");
		Log.info("2. Select 'days' from the dropdown");
		
		if(inputValidation(bondRepo.bdIntTransferFrequencyTxtBox,frequency) && dropdownSelectionValidation("DAYS",bondRepo.bdIntTransferFrequencyDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Int. Transfer Frequency set to 30 days");
			Log.info("Expected Result: Int. Transfer Frequency set to 30 days");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//**Enter Minimum and Maximum Amt**
		ExtentTestManager.startTest("**Enter Minimum and Maximum Amt**").assignCategory("BondConfiguration");
		Log.info("**Enter Minimum and Maximum Amt**");
	
		String minAmt = testdata.get("minAmt").toString();
		input(bondRepo.bdMinAmtTxtBox,minAmt);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter '500' in Minimum Amt");
		Log.info("1. Enter '500' in Minimum Amt");
		
		String maxAmt = testdata.get("maxAmt").toString();
		input(bondRepo.bdMaxAmtTxtBox,maxAmt);
		ExtentTestManager.getTest().log(Status.PASS, "2. Enter '10000000' in Maximum Amt");
		Log.info("2. Enter '10000000' in Maximum Amt");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Minimum and Maximum amounts are set");
		Log.info("Expected Result: Minimum and Maximum amounts are set");
		
		ExtentTestManager.endTest();
		
		

		//**Select Int. Calc Method**
		ExtentTestManager.startTest("**Select Int. Calc Method**").assignCategory("BondConfiguration");
		Log.info("**Select Int. Calc Method**");
		
		select("Monthly Simple Interest",bondRepo.bdIntCalcMethodDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Open Int. Calc Method dropdown\r\n"
				+ "2. Select a calculation method\"");
		Log.info("\"1. Open Int. Calc Method dropdown\r\n"
				+ "2. Select a calculation method\"");
		
		if(dropdownSelectionValidation("Monthly Simple Interest",bondRepo.bdIntCalcMethodDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Int. Calc Method is selected");
			Log.info("Expected Result: Int. Calc Method is selected");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//**Allow Premature Closure**
		ExtentTestManager.startTest("**Allow Premature Closure**").assignCategory("BondConfiguration");
		Log.info("**Allow Premature Closure**");
		
		if(!CheckBoxStatus(bondRepo.bdAllowPrematureClosureCheckBox)) {
			click(bondRepo.bdAllowPrematureClosureCheckBox);
			ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Allow Premature Closure' checkbox");
			Log.info("1. Click 'Allow Premature Closure' checkbox");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Allow Premature Closure' checkbox");
			Log.info("1. Click 'Allow Premature Closure' checkbox");
		}
		
		if(CheckBoxStatus(bondRepo.bdAllowPrematureClosureCheckBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is selected");
			Log.info("Expected Result: Checkbox is selected");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//**Block Issue For Realization**
		ExtentTestManager.startTest("**Block Issue For Realization**").assignCategory("BondConfiguration");
		Log.info("**Block Issue For Realization**");
		
		if(!CheckBoxStatus(bondRepo.bdBlkIssForRealizatnOnAppDateCheckBox)) {
			click(bondRepo.bdBlkIssForRealizatnOnAppDateCheckBox);
			ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Block Issue For Realization On Application Date' checkbox");
			Log.info("1. Click 'Block Issue For Realization On Application Date' checkbox");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Block Issue For Realization On Application Date' checkbox");
			Log.info("1. Click 'Block Issue For Realization On Application Date' checkbox");
		}
		
		if(CheckBoxStatus(bondRepo.bdBlkIssForRealizatnOnAppDateCheckBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Checkbox is selected");
			Log.info("Expected Result: Checkbox is selected");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//**Select Cheque Head/Account**
		ExtentTestManager.startTest("**Select Cheque Head/Account**").assignCategory("BondConfiguration");
		Log.info("**Select Cheque Head/Account**");
		
		if(!CheckBoxStatus(bondRepo.bdAccTypeGLHeadCheckBoxCheque)) {
			click(bondRepo.bdAccTypeGLHeadCheckBoxCheque);
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
			Log.info("1. Select 'GL head' checkbox");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
			Log.info("1. Select 'GL head' checkbox");
		}
		
		select("ALLOWANCE",bondRepo.bdGLAccNameDropdownCheque);
		ExtentTestManager.getTest().log(Status.PASS, "2. Open App. GLAcc Name dropdown\r\n"
				+ "3. Select an account name");
		Log.info("2. Open App. GLAcc Name dropdown\r\n"
				+ "3. Select an account name");
		
		waitUntilElementDisappear(bondRepo.loader);
		
		String bdGLAccCodeTxtBoxChequeValue = driver.findElement(bondRepo.bdGLAccCodeTxtBoxCheque).getAttribute("value");
		System.out.println("bdGLAccCodeTxtBoxCheque: "+bdGLAccCodeTxtBoxChequeValue);
		
		if(!bdGLAccCodeTxtBoxChequeValue.isBlank()) {
			
			ExtentTestManager.getTest().log(Status.PASS, "4. Verify App. GLAcc code is autoloaded");
			Log.info("4. Verify App. GLAcc code is autoloaded");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//**Select EFT Head/Account**
		ExtentTestManager.startTest("**Select EFT Head/Account**").assignCategory("BondConfiguration");
		Log.info("**Select EFT Head/Account**");
		
		if(!CheckBoxStatus(bondRepo.bdAccTypeGLHeadCheckBoxEFT)) {
			click(bondRepo.bdAccTypeGLHeadCheckBoxEFT);
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
			Log.info("1. Select 'GL head' checkbox");
		}else {
			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
			Log.info("1. Select 'GL head' checkbox");
		}
		
		select("ALLOWANCE",bondRepo.bdGLAccNameDropdownEFT);
		ExtentTestManager.getTest().log(Status.PASS, "2. Open App. GLAcc Name dropdown\r\n"
				+ "3. Select an account name");
		Log.info("2. Open App. GLAcc Name dropdown\r\n"
				+ "3. Select an account name");
		
		waitUntilElementDisappear(bondRepo.loader);
		
		String bdGLAccCodeTxtBoxEFTValue = driver.findElement(bondRepo.bdGLAccCodeTxtBoxEFT).getAttribute("value");
		System.out.println("bdGLAccCodeTxtBoxEFTValue: "+bdGLAccCodeTxtBoxEFTValue);
		
		if(!bdGLAccCodeTxtBoxEFTValue.isBlank()) {
			
			ExtentTestManager.getTest().log(Status.PASS, "4. Verify App. GLAcc code is autoloaded");
			Log.info("4. Verify App. GLAcc code is autoloaded");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

//		//**Select DD Head/Account**
//		ExtentTestManager.startTest("**Select DD Head/Account**").assignCategory("BondConfiguration");
//		Log.info("**Select DD Head/Account**");
//				
//		if(!CheckBoxStatus(bondRepo.bdAccTypeGLHeadCheckBoxDD)) {
//			click(bondRepo.bdAccTypeGLHeadCheckBoxDD);
//			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
//			Log.info("1. Select 'GL head' checkbox");
//		}else {
//			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
//			Log.info("1. Select 'GL head' checkbox");
//		}
//		
//		select("ALLOWANCE",bondRepo.bdGLAccNameDropdownDD);
//		ExtentTestManager.getTest().log(Status.PASS, "2. Open App. GLAcc Name dropdown\r\n"
//				+ "3. Select an account name");
//		Log.info("2. Open App. GLAcc Name dropdown\r\n"
//				+ "3. Select an account name");
//		
//		waitUntilElementDisappear(bondRepo.loader);
//		
//		String bdGLAccCodeTxtBoxDDValue = driver.findElement(bondRepo.bdGLAccCodeTxtBoxDD).getAttribute("value");
//		System.out.println("bdGLAccCodeTxtBoxDDValue: "+bdGLAccCodeTxtBoxDDValue);
//		
//		if(!bdGLAccCodeTxtBoxDDValue.isBlank()) {
//			
//			ExtentTestManager.getTest().log(Status.PASS, "4. Verify App. GLAcc code is autoloaded");
//			Log.info("4. Verify App. GLAcc code is autoloaded");
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
//			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
//		}else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
//		
//		ExtentTestManager.endTest();
//		
//		
//
//		//**Select UPI Head/Account**
//		ExtentTestManager.startTest("**Select UPI Head/Account**").assignCategory("BondConfiguration");
//		Log.info("**Select UPI Head/Account**");
//		
//		if(!CheckBoxStatus(bondRepo.bdAccTypeGLHeadCheckBoxUPI)) {
//			click(bondRepo.bdAccTypeGLHeadCheckBoxUPI);
//			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
//			Log.info("1. Select 'GL head' checkbox");
//		}else {
//			ExtentTestManager.getTest().log(Status.PASS, "1. Select 'GL head' checkbox");
//			Log.info("1. Select 'GL head' checkbox");
//		}
//		
//		select("ALLOWANCE",bondRepo.bdGLAccNameDropdownUPI);
//		ExtentTestManager.getTest().log(Status.PASS, "2. Open App. GLAcc Name dropdown\r\n"
//				+ "3. Select an account name");
//		Log.info("2. Open App. GLAcc Name dropdown\r\n"
//				+ "3. Select an account name");
//		
//		waitUntilElementDisappear(bondRepo.loader);
//		
//		String bdGLAccCodeTxtBoxUPIValue = driver.findElement(bondRepo.bdGLAccCodeTxtBoxUPI).getAttribute("value");
//		System.out.println("bdGLAccCodeTxtBoxUPIValue: "+bdGLAccCodeTxtBoxUPIValue);
//		
//		if(!bdGLAccCodeTxtBoxUPIValue.isBlank()) {
//			
//			ExtentTestManager.getTest().log(Status.PASS, "4. Verify App. GLAcc code is autoloaded");
//			Log.info("4. Verify App. GLAcc code is autoloaded");
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
//			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
//		}else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
//		
//		ExtentTestManager.endTest();
//		
//		
//
//		//**Select Pooling Head**
//		ExtentTestManager.startTest("**Select Pooling Head**").assignCategory("BondConfiguration");
//		Log.info("**Select Pooling Head**");
//		
//		select("ALLOWANCE",bondRepo.bdGLAccNameDropdownPooling);
//		ExtentTestManager.getTest().log(Status.PASS, "1. Open App. GLAcc Name dropdown\r\n"
//				+ "2. Select an account name");
//		Log.info("1. Open App. GLAcc Name dropdown\r\n"
//				+ "2. Select an account name");
//		
//		waitUntilElementDisappear(bondRepo.loader);
//		
//		String bdGLAccCodeTxtBoxPooling = driver.findElement(bondRepo.bdGLAccCodeTxtBoxPooling).getAttribute("value");
//		System.out.println("bdGLAccCodeTxtBoxPooling: "+bdGLAccCodeTxtBoxPooling);
//		
//		if(!bdGLAccCodeTxtBoxPooling.isBlank()) {
//			
//			ExtentTestManager.getTest().log(Status.PASS, "3. Verify App. GLAcc code is autoloaded");
//			Log.info("3. Verify App. GLAcc code is autoloaded");
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: App. GLAcc code is autoloaded correctly");
//			Log.info("Expected Result: App. GLAcc code is autoloaded correctly");
//		}else {
//			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//			Log.info("ERROR");
//		}
//		
//		ExtentTestManager.endTest();
		
		

		//**Save Bond Configuration**
		ExtentTestManager.startTest("**Save Bond Configuration**").assignCategory("BondConfiguration");
		Log.info("**Save Bond Configuration**");
		
		click(bondRepo.bdSaveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click 'Save' button");
		Log.info("1. Click 'Save' button");
		
		if(ElementDisplayed(bondRepo.bdConfirmationPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Bond Configuration Added successfully' message appears");
			Log.info("Expected Result: Bond Configuration Added successfully' message appears");
			click(bondRepo.bdConfirmationPopUpCloseBtn);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//**Verify Bond Configuration in Grid**
		ExtentTestManager.startTest("**Verify Bond Configuration in Grid**").assignCategory("BondConfiguration");
		Log.info("**Verify Bond Configuration in Grid**");
		
		ScrollUntilElementVisible(bondRepo.bdGridPrdName);
		
		String bdPrdNameValue = driver.findElement(bondRepo.bdGridPrdName).getText();
		System.out.println("bdPrdNameValue: "+bdPrdNameValue);
		
		String bdEFTHeadValue = driver.findElement(bondRepo.bdGridEFTHead).getText();
		System.out.println("bdEFTHeadValue: "+bdEFTHeadValue);
		
		String bdGridDuration = driver.findElement(bondRepo.bdGridDuration).getText();
		System.out.println("bdGridDuration: "+bdGridDuration);
		
		String bdGridFrequency = driver.findElement(bondRepo.bdGridFrequency).getText();
		System.out.println("bdGridFrequency: "+bdGridFrequency);
		
		ExtentTestManager.getTest().log(Status.PASS, "1. Observe Bond Configuration Details grid");
		Log.info("1. Observe Bond Configuration Details grid");
		
		if(bdPrdNameValue.equals("DEBUNTURE SCHEME 2") 
				&& bdEFTHeadValue.equals(bdGLAccCodeTxtBoxEFTValue) 
				&& bdGridDuration.equals(duration) 
				&& bdGridFrequency.equals(frequency)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Configuration details appear in grid");
			Log.info("Expected Result: Configuration details appear in grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		 
		
	}//end
	
	
}
