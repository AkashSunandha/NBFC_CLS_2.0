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
	
	String transIdShareCash;
    String transIdShareTransfer;
    
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
	ExtentTestManager.startTest("TC:01 - Login Functionality").assignCategory("ShareTransfer");
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
	ExtentTestManager.startTest("TC:02 - Access Share Transfer Window").assignCategory("ShareTransfer");
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
	
	ExtentTestManager.startTest("TC:03 - Selection branch from drop down").assignCategory("ShareTransfer");
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
	
	ExtentTestManager.startTest("TC:04 - Product group selection").assignCategory("ShareTransfer");
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
	
	ExtentTestManager.startTest("TC:05 - Product Name selection").assignCategory("ShareTransfer");
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

	ExtentTestManager.startTest("TC:06 - Verify Click on 'GO' After Entering Account No").assignCategory("ShareTransfer");
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

	ExtentTestManager.startTest("TC:07 - Verify Click on 'GO' After Entering Account No in 'Transfer To'").assignCategory("ShareTransfer");
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

	ExtentTestManager.startTest("TC:08 - Verify 'Share Value' Autoload").assignCategory("ShareTransfer");
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

public boolean VerifyShareAmountAutoloadonNoofSharesEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException, TimeoutException {

	ExtentTestManager.startTest("TC:09 - Verify 'Share Amount' Autoload on 'No. of Shares' Entry").assignCategory("ShareTransfer");
	Log.info("TC:09 - Verify 'Share Amount' Autoload on 'No. of Shares' Entry");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	String shares = testdata.get("NoOfShares").toString();
	Assert.assertNotNull(shares, "Validation Failed: Shares field is null in test data");

    WebElement Noofshares = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_txtNoOfShares_txt']"))); 
    Noofshares.click();
    Noofshares.clear();
    Noofshares.sendKeys(shares,Keys.TAB);
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter value into 'No. of Shares'.");
	Log.info("Step:01 - Enter value into 'No. of Shares'.");
	
   	boolean isDataLoaded = ElementDisplayed(sharetransfer.Shareamt); 

    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Observe 'Share Amount' field.");
   	Log.info("Step:01 - Observe 'Share Amount' field.");
   	
    Assert.assertTrue(isDataLoaded, "Validation Failed: Relevant data is NOT loaded after clicking 'GO'.");
   		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Share Amount' should be autoloaded based on the entered value in 'No. of Shares'.");
	Log.info("Expected Result: 'Share Amount' should be autoloaded based on the entered value in 'No. of Shares'.");

	ExtentTestManager.endTest();
	return true;

}

public boolean VerifyTransactionSuccessonSubmit() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:10 - Verify Transaction Success on Submit").assignCategory("ShareTransfer");
	Log.info("TC:10 - Verify Transaction Success on Submit");
	
	ScrollUntilElementVisible(sharetransfer.Submitbtn);
	click(sharetransfer.Submitbtn);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Submit button.");
	Log.info("Step:01 - Click on Submit button.");
	
	Assert.assertEquals(driver.getWindowHandles().size(), 1, "Validation Failed: Security Details popup window is still open.");								
			
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction should be saved successfully, and a confirmation message displayed.");
	Log.info("Expected Result: Transaction should be saved successfully, and a confirmation message displayed.");
	
	if(ElementDisplayed(sharetransfer.SummaryOperation)) {
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify transaction summary");
		Log.info("Step:01 - Verify transaction summary");
		}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
		}
	transIdShareTransfer = driver.findElement(sharetransfer.TransCashID).getText();
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary is accurate and presents details");
	Log.info("Expected Result: Summary is accurate and presents details");
	
	ExtentTestManager.endTest();
	return true;
	
}

public boolean Logout() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:11 - Logout").assignCategory("ShareTransfer");
	Log.info("TC:11 - Logout");
		
	Thread.sleep(2000);
		
	click(sharetransfer.custSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Logout' button");
	Log.info("Step:01 - Click 'Logout' button");
		
	Assert.assertTrue(ElementDisplayed(sharetransfer.loginButton), "Validation Failed: User is not logged out successfully.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out and login screen is displayed again");
	Log.info("Expected Result: User is logged out and login screen is displayed again");
	
	ExtentTestManager.endTest();
	return true;		
}

public boolean ManagerLoginforAuthorization() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:12 - Manager Login for Authorization").assignCategory("ShareTransfer");
	Log.info("TC:12 - Manager Login for Authorization");
		
	String UserName1 = configloader().getProperty("UserName2");
	input(sharetransfer.loginUserName, UserName1);
				
	String Password1 = configloader().getProperty("Password2");
	input(sharetransfer.loginPasswrd, Password1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter manager credentials `<manager_username>` and `<manager_password>`");
	Log.info("Step:01 - Enter manager credentials `<manager_username>` and `<manager_password>`");
	
	click(sharetransfer.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Login'");
	Log.info("Step:02 - Click 'Login'");
		
	Assert.assertTrue(ElementDisplayed(sharetransfer.home), "Validation Failed: 'Home' button is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Manager successfully logs in and is directed to the authorization page");
	Log.info("Expected Result: Manager successfully logs in and is directed to the authorization page");	

	ExtentTestManager.endTest();
	return true;

}

public boolean ManagerAuthorizationRefresh() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:13 - Manager Authorization Refresh").assignCategory("ShareTransfer");
	Log.info("TC:13 - Manager Authorization Refresh");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	
	ScrollUntilElementVisible(sharetransfer.AuthorizeCancel);
	click(sharetransfer.AuthorizeCancel);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Go to 'Authorize & Cancel' window");
	Log.info("Step:01 - Go to 'Authorize & Cancel' window");
	
	click(sharetransfer.ManagerAuthorization);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select 'Manager Authorization'");
	Log.info("Step:02 - Select 'Manager Authorization'");
	
	click(sharetransfer.TransferTab);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click Transfer tab");
	Log.info("Step:03 - Click Transfer tab");
	
	WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(sharetransfer.Refresh));
    refreshButton.click();
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click 'Refresh' button");
	Log.info("Step:04 - Click 'Refresh' button");
	
	Assert.assertTrue(ElementDisplayed(sharetransfer.Refresh), "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorization entries are updated and displayed");
	Log.info("Expected Result: Authorization entries are updated and displayed");

	ExtentTestManager.endTest();
	return true;

}

public boolean AuthorizeShareEntry() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:14 - Authorize Share Entry").assignCategory("ShareTransfer");
	Log.info("TC:14 - Authorize Share Entry");
	
	System.out.println("transIdShareTransfer "+transIdShareTransfer);
	FetchwithTransID(transIdShareTransfer);
	
	WebElement Managercheckbox = driver.findElement(sharetransfer.TransManagerCheckBox);
	
	if(ElementDisplayed(sharetransfer.TransManagerCheckBox)) {
	click(sharetransfer.TransManagerCheckBox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select share entry checkbox in the transfer section");
	Log.info("Step:01 - Select share entry checkbox in the transfer section");
	
	if(ElementDisplayed(sharetransfer.ManagerAuthorize)) {
		click(sharetransfer.ManagerAuthorize);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
		Log.info("Step:01 - Click on the Authorize button");
		
		Assert.assertTrue(ElementDisplayed(sharetransfer.ManagerAuthorize), "Validation Failed: 'Authorize' button is not Clicked.");
	
		click(sharetransfer.ClosePopup);
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Share entry is authorized with confirmation message");
		Log.info("Expected Result: Share entry is authorized with confirmation message");
}	
	}
	
	ExtentTestManager.endTest();
	return true;	
}







	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
