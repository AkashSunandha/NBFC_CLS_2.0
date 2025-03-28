package com.Pages_Share_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Pages_Jewel_Gold_Loan_Renewal_Module.Pages_Jewel_Gold_Loan_Renewals;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Share_Transfer_Module extends Base_Class {
	
	Share_Transfer sharetransfer = new Share_Transfer();
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdGLtransCash;
    String transIdGLtransTransfer;
    
public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(sharetransfer.TransactionIDField,transID);
		click(sharetransfer.GoBTN);
		
		ExtentTestManager.endTest();
		return true;
		
	}
public static  String generateAccountNumber() throws ClassNotFoundException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String UserName = "sqa";
	String Password = "SPQA@sql2019" ;
	String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

	String query = "exec GetJewelloanAccountnumber;";
	String AccountNum = null; 
	try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(query)) {
	        	
	if (resultSet.next()) {
	    AccountNum = resultSet.getString("Acno");
	    System.out.println("Account Number of Loan Opening: " + AccountNum);
	      } else {
	    System.out.println("No Account Number found.");
	            }

	    } catch (SQLException e) {
	    System.out.println("Error executing the SQL query or processing the result set.");
	    e.printStackTrace();
	  }
	    	return AccountNum;         
}	
	

public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException, IOException {
	ExtentTestManager.startTest("TC:01 - Login Functionality");
	Log.info("TC_01 - Login Functionality");

	String UserName = configloader().getProperty("UserName");
	input(sharetransfer.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");

	String Password = configloader().getProperty("Password");
	input(sharetransfer.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enetered valid Password");

	click(sharetransfer.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(sharetransfer.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(sharetransfer.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		click(sharetransfer.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
		Log.info("Step:01 - Click on OK button");

		input(sharetransfer.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
		Log.info("Step:02 - Enetered valid User Name");

		input(sharetransfer.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
		Log.info("Step:03 - Entered valid Password");

		click(sharetransfer.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
		Log.info("Step:04 - Click on Login Button");

		ElementDisplayed(sharetransfer.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean AccessShareTransferWindow() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Access Share Transfer Window");
	Log.info("TC:02 - Access Share Transfer Window");

		ScrollUntilElementVisible(sharetransfer.Transaction);
		click(sharetransfer.Transaction);
		
		ScrollUntilElementVisible(sharetransfer.ShareTransfer);
		click(sharetransfer.ShareTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to 'Transaction' > 'Share Transfer");
		Log.info("Step:01 Navigate to 'Transaction' > 'Share Transfer");

		boolean isDashboardVisible = ElementDisplayed(sharetransfer.Productinfo);

		Assert.assertTrue(isDashboardVisible,"Validation Failed: Share transfer opening window is NOT displayed.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: share transfer window displays");
		Log.info("Expected Result: share transfer window displays");

	ExtentTestManager.endTest();
	return true;

}

public boolean Selectionbranchfromdropdown()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:03 - Selection branch from drop down");
	Log.info("TC:03 - Selection branch from drop down");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(sharetransfer.Branch)) {
	click(sharetransfer.Branch);
	
	WebElement BranchName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlBranch_ddl']/option[3]")));
	BranchName.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Select branch from drop down");
	Log.info("Step 1:  Select branch from drop down");
				
	Assert.assertTrue(ElementDisplayed(sharetransfer.Productgrp), "Validation Failed: Branch dropdown should not be displayed");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: branch should be selected");
	Log.info("Expected Result: branch should be selected");
	
	}	
	
	ExtentTestManager.endTest();
	return true;

}

public boolean Productgroupselection() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:04 - Product group selection");
	Log.info("TC:04 - Product group selection");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(sharetransfer.Productgrp)) {
	click(sharetransfer.Productgrp);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1:  Select 'A Class Share' from the Product Group dropdown.");
	Log.info("Step 1:  Select 'A Class Share' from the Product Group dropdown.");
	
	WebElement ProductDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlProductGroup_ddl']/option[2]")));
	ProductDropdown.click();
		
	Assert.assertTrue(ElementDisplayed(sharetransfer.Productname), "Validation Failed: Product name is not displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product Group should be selected ");
	Log.info("Expected Result: Product Group should be selected ");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean ProductNameselection() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:05 - Product Name selection");
	Log.info("TC:05 - Product Name selection");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(sharetransfer.Productname)) {
	click(sharetransfer.Productname);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select 'A Class Share' from the Product name dropdown.");
	Log.info("Step 1: Select 'A Class Share' from the Product name dropdown.");
	
	WebElement ProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlProductName_ddl']/option[2]")));
	ProductName.click();
		
	Assert.assertTrue(ElementDisplayed(sharetransfer.AccInfo), "Validation Failed: Account Info is not displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name should be selected and Account Info (Transfer From) section will be displays");
	Log.info("Expected Result: Product name should be selected and Account Info (Transfer From) section will be displays");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean VerifyClickonGOAfterEnteringAccountNo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException, TimeoutException {

	ExtentTestManager.startTest("TC:06 - Verify Click on 'GO' After Entering Account No");
	Log.info("TC:06 - Verify Click on 'GO' After Entering Account No");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	String EnterAccount = testdata.get("Account_No").toString();
	Assert.assertNotNull(EnterAccount, "Validation Failed: Transfer account no is null in test data");

    WebElement accountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucFromAccountInfo_txtAcNo_txt']"))); 
    accountField.click();
    accountField.clear();
    accountField.sendKeys(EnterAccount);
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Valid Account No entered");
	Log.info("Step:01 - Valid Account No entered");
	
    click(sharetransfer.GoButton);
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'GO' button.");
   	Log.info("Step:01 - Click on the 'GO' button.");
   	
   	boolean isDataLoaded = ElementDisplayed(sharetransfer.Accdetails); 
    Assert.assertTrue(isDataLoaded, "Validation Failed: Relevant data is NOT loaded after clicking 'GO'.");
   		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: System should proceed with the entered Account No and load relevant data.");
	Log.info("Expected Result: System should proceed with the entered Account No and load relevant data.");

	ExtentTestManager.endTest();
	return true;

}

public boolean VerifyClickonGOAfterEnteringAccountNoinTransferTo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException, TimeoutException {

	ExtentTestManager.startTest("TC:07 - Verify Click on 'GO' After Entering Account No in 'Transfer To'");
	Log.info("TC:07 - Verify Click on 'GO' After Entering Account No in 'Transfer To'");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	String EntertransferAccount = testdata.get("Account_No1").toString();
	Assert.assertNotNull(EntertransferAccount, "Validation Failed: Transfer account no is null in test data");

    WebElement accountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucToAccountDetails_txtAcNo_txt']"))); 
    accountField.click();
    accountField.clear();
    accountField.sendKeys(EntertransferAccount);
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Account No in 'Transfer To'section");
	Log.info("Step:01 - Enter Account No in 'Transfer To'section");
	
    click(sharetransfer.Gobtn);
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the 'GO' button.");
   	Log.info("Step:01 - Click on the 'GO' button.");
   	
   	boolean isDataLoaded = ElementDisplayed(sharetransfer.Sharedetails); 
    Assert.assertTrue(isDataLoaded, "Validation Failed: Relevant data is NOT loaded after clicking 'GO'.");
   		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: System should proceed with the entered Account No and load 'Transfer To' account info.");
	Log.info("Expected Result: System should proceed with the entered Account No and load 'Transfer To' account info.");

	ExtentTestManager.endTest();
	return true;

}

public boolean VerifyShareValueAutoload() throws InterruptedException {

	ExtentTestManager.startTest("TC:08 - Verify 'Share Value' Autoload");
	Log.info("TC:08 - Verify 'Share Value' Autoload");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement ShareValue = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_lstShareSeries_ctrl0_chkList']"));

	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - Click on Share Series checkbox.");
	Log.info("Step:01 - Click on Share Series checkbox.");

	ShareValue.click();
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - Observe 'Share Value' field.");
	Log.info("Step:01 - Observe 'Share Value' field.");
		
	WebElement sharevalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_txtShareValue_txt']")));

	Assert.assertTrue(sharevalue.isDisplayed(), "Validation Failed: Share value field not updated");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result : 'Share Value' should be autoloaded after selecting the Share Series.");
	Log.info("Expected Result : 'Share Value' should be autoloaded after selecting the Share Series.");
		
	ExtentTestManager.endTest();
	return true;

}





	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
