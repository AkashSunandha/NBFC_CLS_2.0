package com.Pages_Jewel_Loan_Transcharge_Module;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
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

public class Jewel_Loan_Transcharge_Transfer extends Base_Class {
	
	Pages_Jewel_Loan_Transcharge LoanTranscharge = new Pages_Jewel_Loan_Transcharge();
	
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdCashLoan;
    String transIdTransferLoan;
    String  mainWindowHandle;

	
public boolean FetchwithTransID(String transID) throws InterruptedException {
		
	input(LoanTranscharge.TransactionIDField,transID);
	click(LoanTranscharge.GoBTN);
		
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
	            } 
	else {
	    System.out.println("No Account Number found.");
	            }

	        } 
	catch (SQLException e) {
		System.out.println("Error executing the SQL query or processing the result set.");
	    e.printStackTrace();
	        }
	
	return AccountNum; 
	        
}	
	
public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException, IOException {
	ExtentTestManager.startTest("TC:01 - Login Functionality");
	Log.info("TC_01 - Login Functionality");

	String UserName = configloader().getProperty("UserName");
	input(LoanTranscharge.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");

	String Password = configloader().getProperty("Password");
	input(LoanTranscharge.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enetered valid Password");

	click(LoanTranscharge.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(LoanTranscharge.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(LoanTranscharge.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		click(LoanTranscharge.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
		Log.info("Step:01 - Click on OK button");

		input(LoanTranscharge.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
		Log.info("Step:02 - Enetered valid User Name");

		input(LoanTranscharge.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
		Log.info("Step:03 - Entered valid Password");

		click(LoanTranscharge.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
		Log.info("Step:04 - Click on Login Button");

		ElementDisplayed(LoanTranscharge.home);
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}

	ExtentTestManager.endTest();
	return true;
}

public boolean ChargePostingWindowAccess() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Charge Posting Window Access");
	Log.info("TC:02 - Charge Posting Window Access");

	try {

		WebElement ProcesspostingWindow = driver.findElement(By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[12]/div"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ProcesspostingWindow);

		click(LoanTranscharge.ProcessingandPosting);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Expand processing and posting module");
		Log.info("Step:01 Expand processing and posting module");

		click(LoanTranscharge.ChargePosting);
		click(LoanTranscharge.LoanChargePosting);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on charge posting");
		Log.info("Step:02 Click on charge posting");

		boolean isDashboardVisible = ElementDisplayed(LoanTranscharge.LoanChargePosting);

		Assert.assertTrue(isDashboardVisible,
				"Validation Failed: Loan Charge Posting opening window is NOT displayed.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge posting window is opened");
		Log.info("Expected Result: Charge posting window is opened");

	} catch (Exception e) {
		ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
		Log.error("Exception occurred while accessing Charge Posting Opening Window: " + e.getMessage());
		Assert.fail("Test failed due to an unexpected error.");
	}

	ExtentTestManager.endTest();
	return true;

}

public boolean BranchAutoloadinChargePosting()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:03 - Branch Autoload in Charge Posting");
	Log.info("TC:03 - Branch Autoload in Charge Posting");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement BranchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_CPH1_ddlBranch_ddl']")));
	String BranchName = BranchField.getAttribute("value");
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify the branch field");
    Log.info("Step:01 - Verify the branch field");
    
    Assert.assertFalse(BranchName.isEmpty(), "Validation Failed: Branch is not autoloaded");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch is autoloaded correctly");
    Log.info("Expected Result: Branch is autoloaded correctly");

    ExtentTestManager.endTest();
	return true;

}

public boolean TransactionandPostingDatesVerification()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:04 - Transaction and Posting Dates Verification");
	Log.info("TC:04 - Transaction and Posting Dates Verification");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement TransDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_CPH1_dtTransDate_txt']")));
	String Transdate = TransDate.getAttribute("value");
	Log.info(Transdate);
	
	WebElement PostingDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_CPH1_dtPostingDate_txt']")));
	String Postingdate = PostingDate.getAttribute("value");
	Log.info(Postingdate);
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify transaction date and posting date");
    Log.info("Step:01 - Verify transaction date and posting date");
    
    Assert.assertFalse(Transdate.isEmpty(), "Validation Failed: Transaction date field is empty.");
    
    Assert.assertFalse(Postingdate.isEmpty(), "Validation Failed: Posting date field is empty.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both dates are set to the current transaction date");
    Log.info("Expected Result: Both dates are set to the current transaction date");

    ExtentTestManager.endTest();
	return true;

}

public boolean SelectJewelLoanGroup() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:05 - Select Jewel Loan Group");
	Log.info("TC:05 - Select Jewel Loan Group");

	click(LoanTranscharge.LoanGroup);
	
	WebElement LoanGroupDropDown = driver.findElement(By.xpath("//select[@id ='ctl00_CPH1_ddlLoanGroup_ddl']"));
	Select Groupdropdown = new Select(LoanGroupDropDown);
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open Loan Group dropdown");
	Log.info("Step:01 Open Loan Group dropdown");
	
	Groupdropdown.selectByVisibleText("Jewel Loan");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Jewel Loan'");
	Log.info("Step:02 Select 'Jewel Loan'");

	String selectedOption = Groupdropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Jewel Loan","Validation Failed: The selected duration mode should be 'Jewel Loan'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Jewel loan group is selected successfully");
	Log.info("Expected Result: Jewel loan group is selected successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean SelectGoldLoanProduct() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:06 - Select Gold Loan Product");
	Log.info("TC:06 - Select Gold Loan Product");

	click(LoanTranscharge.ProductName);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open Product Name dropdown");
	Log.info("Step:01 Open Product Name dropdown");
	
	WebElement ProductNameDropDown = driver.findElement(By.xpath("//select[@id='ctl00_CPH1_ddlProductName_ddl']"));
	Select Golddropdown = new Select(ProductNameDropDown);
	
	Golddropdown.selectByVisibleText("GOLD LOAN");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Gold Loan'");
	Log.info("Step:02 Select 'Gold Loan'");

	String selectedOption = Golddropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "GOLD LOAN","Validation Failed: The selected duration mode should be 'GOLD LOAN'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Gold loan product is selected successfully");
	Log.info("Expected Result: Gold loan product is selected successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean AccountNumberEntryandAutoloadVerification() throws InterruptedException, ClassNotFoundException {
	
	ExtentTestManager.startTest("TC:07 - Account Number Entry and Auto-load Verification");
	Log.info("TC:07 - Account Number Entry and Auto-load Verification");
	
	String AccountNum = generateAccountNumber();
	Assert.assertNotNull(AccountNum, "Validation Failed: Account number should not be null");
	Log.info("Fetched Account Number from DB: " + AccountNum);
	
	String lastThreeDigits = AccountNum.length() > 3 ? AccountNum.substring(AccountNum.length() - 3) : AccountNum;
	Log.info("Extracted Last 3 Digits: " + lastThreeDigits);

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement AccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_CPH1_txtAcNo_txt']")));

	Assert.assertTrue(AccountNo.isDisplayed(), "Validation Failed: Account Number field is not displayed");

	click(LoanTranscharge.AccountNumber);
	
	AccountNo.sendKeys(lastThreeDigits);
	
	String enteredValue = AccountNo.getAttribute("value");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Enter valid A/c No.");
	Log.info("Step:01 Enter valid A/c No.");
	
	Assert.assertEquals(enteredValue, lastThreeDigits, "Validation Failed: Account number entered incorrectly");
	
	AccountNo.sendKeys(Keys.TAB);
	
	Thread.sleep(3000);
	
	WebElement accDisplayNameElement = driver.findElement(LoanTranscharge.AccDisplayName);
    WebElement currentBalanceElement = driver.findElement(LoanTranscharge.CurrentBalance);
    WebElement shadowBalanceElement = driver.findElement(LoanTranscharge.ShadowBalance);
    WebElement unclearBalanceElement = driver.findElement(LoanTranscharge.UnclearBalance);

    String actualAccDisplayName = accDisplayNameElement.getAttribute("value").trim();
    String actualCurrentBalance = currentBalanceElement.getAttribute("value").trim();
    String actualShadowBalance = shadowBalanceElement.getAttribute("value").trim();
    String actualUnclearBalance = unclearBalanceElement.getAttribute("value").trim();

    Assert.assertFalse(actualAccDisplayName.isEmpty(), "Validation Failed: Account Display Name is missing!");
    Assert.assertFalse(actualCurrentBalance.isEmpty(), "Validation Failed: Current Balance is missing!");
    Assert.assertFalse(actualShadowBalance.isEmpty(), "Validation Failed: Shadow Balance is missing!");
    Assert.assertFalse(actualUnclearBalance.isEmpty(), "Validation Failed: Unclear Balance is missing!");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are autoloaded correctly");
    Log.info("Expected Result: Account details are autoloaded correctly");
    
	ExtentTestManager.endTest();
	return true;

}

public boolean SelectMiscChargeType() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:08 - Select Misc Charge Type");
	Log.info("TC:08 - Select Misc Charge Type");

	click(LoanTranscharge.ChargeType);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open charge type dropdown");
	Log.info("Step:01 Open charge type dropdown");
	
	WebElement ChargeTypeDropdown = driver.findElement(By.xpath("//select[@id='ctl00_CPH1_ddlChargeType_ddl']"));
	Select ChargeDropdown = new Select(ChargeTypeDropdown);
	
	ChargeDropdown.selectByVisibleText("Misc");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Misc'");
	Log.info("Step:02 Select 'Misc'");

	String selectedOption = ChargeDropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Misc","Validation Failed: The selected charge type should be 'Misc'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Charge type 'Misc' is selected successfully");
	Log.info("Expected Result: Charge type 'Misc' is selected successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean EnterChargeAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:09 - Enter Charge Amount");
	Log.info("TC:09 - Enter Charge Amount");

	String EnterAmount = testdata.get("Amount").toString();
	input(LoanTranscharge.Amount, EnterAmount);
	Assert.assertNotNull(EnterAmount, "Validation Failed: Charge Amount is null in test data");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_CPH1_txtChargeAmount_txt']"))); 

	String enteredValue = amountField.getAttribute("value");
	Assert.assertEquals(enteredValue, EnterAmount, "Validation Failed: Entered charge amount does not match test data");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid charge amount");
	Log.info("Step:01 - Enter valid charge amount");

	amountField.clear();
	amountField.sendKeys(EnterAmount);

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Charge amount is entered successfully");
	Log.info("Expected Result:Charge amount is entered successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean AddChargeandVerifyinGrid()throws InterruptedException {

	ExtentTestManager.startTest("TC:10 - Add Charge and Verify in Grid");
	Log.info("TC:10 - Add Charge and Verify in Grid");

	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_CPH1_btnAdd']")));
    addButton.click();
    ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click 'Add' Button");
    Log.info("Step:03 - Click 'Add' Button");

    WebElement depositGrid = wait.until(ExpectedConditions.visibilityOf(driver.findElement(LoanTranscharge.DepositDetails)));
    Assert.assertTrue(depositGrid.isDisplayed(), "Validation Failed: Charge details grid is not displayed");
    Log.info("Charge details grid is displayed successfully");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Charge details are displayed in the grid");
	Log.info("Expected Result: Charge details are displayed in the grid");

	ExtentTestManager.endTest();
	return true;

}

public boolean SaveChargeandSuccessfulMessageDisplay()throws InterruptedException {

	ExtentTestManager.startTest("TC:11 - Save Charge and Successful Message Display");
	Log.info("TC:11 - Save Charge and Successful Message Display");

	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement SaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_CPH1_btnSave']")));
    SaveButton.click();
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click save button");
    Log.info("Step:01 - Click save button");

    WebElement SuccessPopup = wait.until(ExpectedConditions.visibilityOf(driver.findElement(LoanTranscharge.LoanChargesPopup)));
    Assert.assertTrue(SuccessPopup.isDisplayed(), "Validation Failed: Loan charges posted not successfully");

    click(LoanTranscharge.ClosePopup);
    
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: 'Loan charges posted successfully' message is displayed");
	Log.info("Expected Result: 'Loan charges posted successfully' message is displayed");

	ExtentTestManager.endTest();
	return true;

}

public boolean TransactionModuleAccess() throws InterruptedException {
	ExtentTestManager.startTest("TC:12 - Transaction Module Access");
	Log.info("TC:12 - Transaction Module Access");

	try {

		WebElement TransactionWindow = driver.findElement(By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[7]/div"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", TransactionWindow);

		click(LoanTranscharge.Transaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Expand transaction module");
		Log.info("Step:01 Expand transaction module");

		click(LoanTranscharge.Transactions);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on transactions window");
		Log.info("Step:02 Click on transactions window");

		boolean isDashboardVisible = ElementDisplayed(LoanTranscharge.Transactions);

		Assert.assertTrue(isDashboardVisible,"Validation Failed: Transactions opening window is NOT displayed.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction window is opened");
		Log.info("Expected Result: Transaction window is opened");

	} catch (Exception e) {
		ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
		Log.error("Exception occurred while accessing Transactions Opening Window: " + e.getMessage());
		Assert.fail("Test failed due to an unexpected error.");
	}

	ExtentTestManager.endTest();
	return true;

}

public boolean BranchAutoloadinTransactionModule()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:13 - Branch Autoload in Transaction Module");
	Log.info("TC:13 - Branch Autoload in Transaction Module");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement BranchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch']")));
	String BranchName = BranchField.getAttribute("value");
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify the branch field");
    Log.info("Step:01 - Verify the branch field");
    
    Assert.assertFalse(BranchName.isEmpty(), "Validation Failed: Branch is not autoloaded");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch is autoloaded correctly");
    Log.info("Expected Result: Branch is autoloaded correctly");

    ExtentTestManager.endTest();
	return true;

}

public boolean SelectJewelLoanGroupinTransaction() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:14 - Select Jewel Loan Group in Transaction");
	Log.info("TC:14 - Select Jewel Loan Group in Transaction");

	click(LoanTranscharge.ProductGroup);
	
	WebElement ProductGroupDropDown = driver.findElement(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup']"));
	Select Productdropdown = new Select(ProductGroupDropDown);
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open Loan Group dropdown");
	Log.info("Step:01 Open Loan Group dropdown");
	
	Productdropdown.selectByVisibleText("Jewel Loan");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Jewel Loan'");
	Log.info("Step:02 Select 'Jewel Loan'");

	String selectedOption = Productdropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Jewel Loan","Validation Failed: The selected duration mode should be 'Jewel Loan'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Jewel loan group is selected successfully");
	Log.info("Expected Result: Jewel loan group is selected successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean SelectGoldLoanProductinTransaction() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:15 - Select Gold Loan Product in Transaction");
	Log.info("TC:15 - Select Gold Loan Product in Transaction");

	click(LoanTranscharge.ProdName);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open Product Name dropdown");
	Log.info("Step:01 Open Product Name dropdown");
	
	WebElement ProductNameDropDown = driver.findElement(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl']"));
	Select Golddropdown = new Select(ProductNameDropDown);
	
	Golddropdown.selectByVisibleText("GOLD LOAN");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Gold Loan'");
	Log.info("Step:02 Select 'Gold Loan'");

	String selectedOption = Golddropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "GOLD LOAN","Validation Failed: The selected duration mode should be 'GOLD LOAN'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Gold loan product is selected successfully");
	Log.info("Expected Result: Gold loan product is selected successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean EnterAccountNumberinTransaction() throws InterruptedException, ClassNotFoundException {
	
	ExtentTestManager.startTest("TC:16 - Enter Account Number in Transaction");
	Log.info("TC:16 - Enter Account Number in Transaction");
	
	String AccountNum = generateAccountNumber();
	Assert.assertNotNull(AccountNum, "Validation Failed: Account number should not be null");
	Log.info("Fetched Account Number from DB: " + AccountNum);
	
	String lastThreeDigits = AccountNum.length() > 3 ? AccountNum.substring(AccountNum.length() - 3) : AccountNum;
	Log.info("Extracted Last 3 Digits: " + lastThreeDigits);

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement AccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")));

	Assert.assertTrue(AccountNo.isDisplayed(), "Validation Failed: Account Number field is not displayed");

	click(LoanTranscharge.AccNumber);
	
	AccountNo.sendKeys(lastThreeDigits);
	
	String enteredValue = AccountNo.getAttribute("value");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Enter valid A/c No.");
	Log.info("Step:01 Enter valid A/c No.");
	
	Assert.assertEquals(enteredValue, lastThreeDigits, "Validation Failed: Account number entered incorrectly");
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is entered successfully");
    Log.info("Expected Result: Account number is entered successfully");
    
	ExtentTestManager.endTest();
	return true;

}

public boolean SelectTransactionTypeCredit() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:17 - Select Transaction Type Credit");
	Log.info("TC:17 - Select Transaction Type Credit");

	click(LoanTranscharge.TransType);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Open transtype dropdown");
	Log.info("Step:01 Open transtype dropdown");
	
	WebElement TranstypeDropDown = driver.findElement(By.xpath("//Select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl']"));
	Select Transdropdown = new Select(TranstypeDropDown);
	
	Transdropdown.selectByVisibleText("Credit");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select 'Credit'");
	Log.info("Step:02 Select 'Credit'");

	String selectedOption = Transdropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Credit","Validation Failed: The selected Trans type should be 'Credit'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Transaction type 'Credit' is selected successfull");
	Log.info("Expected Result: Transaction type 'Credit' is selected successfull");

	ExtentTestManager.endTest();
	return true;

}

public boolean OpenAccountTransactions()throws InterruptedException {

	ExtentTestManager.startTest("TC:18 - Open Account Transactions");
	Log.info("TC:18 - Open Account Transactions");

	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement GoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo']")));
    GoBtn.click();
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click go button");
    Log.info("Step:01 - Click go button");
    try {
    	 WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='closewarning']")));
         if (closePopup.isDisplayed()) {
             closePopup.click();
             ExtentTestManager.getTest().log(Status.PASS, "Popup was displayed and closed.");
             Log.info("Popup was displayed and closed.");
         }
     } catch (Exception e) {
         ExtentTestManager.getTest().log(Status.INFO, "No popup displayed, continuing...");
         Log.info("No popup displayed, continuing...");
     }

    WebElement Accountsummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td/table")));
    
    Assert.assertTrue(Accountsummary.isDisplayed(), "Validation Failed: Account summary not displayed");
    
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Transaction window for selected account number is opened");
	Log.info("Expected Result: Transaction window for selected account number is opened");

	ExtentTestManager.endTest();
	return true;

}

public boolean VerifyMiscChargeinTransaction()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:19 - Verify Misc Charge in Transaction");
	Log.info("TC:19 - Verify Misc Charge in Transaction");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement MiscCharges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtDue5']")));
	String Misc = MiscCharges.getAttribute("value");
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify added 'misc' charge");
    Log.info("Step:01 - Verify added 'misc' charge");
    
    Assert.assertFalse(Misc.isEmpty(), "Validation Failed: 'Misc' charge is not displayed correctly");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Misc' charge is displayed correctly in the transaction window");
    Log.info("Expected Result: 'Misc' charge is displayed correctly in the transaction window");

    ExtentTestManager.endTest();
	return true;

}

public boolean EnterTransactionAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException {

	ExtentTestManager.startTest("TC:20 - Enter Transaction Amount");
	Log.info("TC:20 - Enter Transaction Amount");

	String EnterAmount = testdata.get("Trans_Amount").toString();
	Assert.assertNotNull(EnterAmount, "Validation Failed: Transaction Amount is null in test data");

	WebDriverWait wait = new WebDriverWait(driver, 10);
    By amountFieldLocator = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']");

	WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']"))); 
	
	int retryCount = 0;
    boolean isEntered = false;
    while (retryCount < 2) {
        try {
            amountField.clear();
            amountField.sendKeys(EnterAmount, Keys.TAB);
            isEntered = true;
            break; 
        } catch (StaleElementReferenceException e) {
            Log.warn("StaleElementReferenceException caught. Retrying... Attempt: " + (retryCount + 1));
            amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']"))); 
        }
        retryCount++;
    }

    if (!isEntered) {
        Log.error("Failed to enter transaction amount after retries.");
        Assert.fail("Validation Failed: Could not enter transaction amount due to stale element reference.");
    }

    Thread.sleep(500);
    
    amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(amountFieldLocator));

	String enteredValue = amountField.getAttribute("value");
	Assert.assertEquals(enteredValue, EnterAmount, "Validation Failed: Entered transaction amount does not match test data");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid transaction amount");
	Log.info("Step:01 - Enter valid transaction amount");
	
	Assert.assertEquals(amountField.getAttribute("value"), EnterAmount, "Validation Failed: Transaction amount is not entered correctly after re-entry.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction amount is entered successfully");
	Log.info("Expected Result: Transaction amount is entered successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean Postdebittransaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:21 - Post debit transaction");
	Log.info("TC:21 - Post debit transaction");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement TransactionMode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", TransactionMode);
	
	Thread.sleep(2000);
	
	if (ElementDisplayed(LoanTranscharge.TransMode)) {
	click(LoanTranscharge.TransMode);

	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Trans.mode'as Transfer.");
	Log.info("Step 01: Select 'Trans.mode'as Cash.");	

	WebElement Options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl']/option[3]")));
	Options.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transmode seleted");
	Log.info("Expected Result: Transmode seleted");
}

	ExtentTestManager.endTest();
	return true;
}

public boolean EnterRemarkforTransaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:22 - Enter Remark for Transaction");
	Log.info("TC:22 - Enter Remark for Transaction");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement EnterRemarkvalue = driver.findElement(LoanTranscharge.Remarks);

	click(LoanTranscharge.Remarks);
	String EnterRemark = testdata.get("Remark").toString();
	input(LoanTranscharge.Remarks, EnterRemark);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a remark in the input field.");
	Log.info("Step:01 - Enter a remark in the input field.");
	
    Assert.assertFalse(EnterRemark.isEmpty(), "Validation Failed: Enter Remark should not be empty.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark accepted.");
	Log.info("Expected Result: Remark accepted.");

	ExtentTestManager.endTest();
	return true;

}

public boolean POSTDEBITpopupispresent(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:23 - POST DEBIT popup is present");
	Log.info("TC:23 - POST DEBIT popup is present");
	
	WebElement PostDebitTab = driver.findElement(LoanTranscharge.PostDebit);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", PostDebitTab);
	
	click(LoanTranscharge.PostDebit);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on 'Post Debit' Popup");
	Log.info("Step 1: Click on 'Post Debit' Popup");
	
	mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean popupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			popupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(popupOpened, "Validation Failed: Auto posting popup window did not open");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  POST DEBIT popup is opened");
	Log.info("Expected Result:  POST DEBIT popup is opened");
		
	ExtentTestManager.endTest();
	return true;
}

public boolean PostDebitpopupispresent(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:24 - POST DEBIT popup is present");
	Log.info("TC:24 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanTranscharge.TransactionBased)) {
	click(LoanTranscharge.TransactionBased);
	WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlTrnsBased_ddl']/option[1]")));
	options.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Account  from the 'Transaciton Based' drop down");
	Log.info("Step 1: Select Account  from the 'Transaciton Based' drop down");
	
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.ProductGroupDropdown), "Validation Failed: Transaction Based field should not be displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account selected from the 'Transaciton Based' drop down");
	Log.info("Expected Result: Account selected from the 'Transaciton Based' drop down");
	
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean PostDebitPopUpProductGroupDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:25 - POST DEBIT popup is present");
	Log.info("TC:25 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanTranscharge.ProductGroupDropdown)) {
	click(LoanTranscharge.ProductGroupDropdown);
	WebElement ProductGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ddlProductGroup_ddl']/option[4]")));
	ProductGroup.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Demand Investment from the 'Product group' drop down");
	Log.info("Step 1: Select Demand Investment from the 'Product group' drop down");
		
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.ProductNameDropdown), "Validation Failed: Product Group dropdown should not be displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected");
	Log.info("Expected Result: Demand Investment is selected");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpProductNameDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:26 - POST DEBIT popup is present");
	Log.info("TC:26 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanTranscharge.ProductNameDropdown)) {
	click(LoanTranscharge.ProductNameDropdown);
	WebElement ProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlProductName_ddl']/option[2]")));
	ProductName.click();
		
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select item from the 'Product Name' drop down");
	Log.info("Step 1: Select item from the 'Product Name' drop down");
			
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.BranchName), "Validation Failed: Product Name dropdown should not be displayed");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
	Log.info("Expected Result: Product name item  is selected ");
	}	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpBranchDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:27 - POST DEBIT popup is present");
	Log.info("TC:27 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
				
	if(ElementDisplayed(LoanTranscharge.BranchName)) {
	click(LoanTranscharge.BranchName);
	WebElement BranchName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlBranch_ddl']/option[3]")));
	BranchName.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select an a branch  from the 'Branch  'drop down'");
	Log.info("Step 1: Select an a branch  from the 'Branch  'drop down'");
				
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.AccountNum), "Validation Failed: Branch dropdown should not be displayed");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch  item  is selected ");
	Log.info("Expected Result: Branch  item  is selected ");
	
	}	
	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:28 - POST DEBIT popup is present");
	Log.info("TC:28 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	if(ElementDisplayed(LoanTranscharge.AccountNum)) {
	click(LoanTranscharge.AccountNum);
	WebElement AccountNumber = driver.findElement(LoanTranscharge.AccountNum);
	String EnterAccountNumber = testdata.get("Account_Number").toString();
	input(LoanTranscharge.AccountNum, EnterAccountNumber);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Tick mark and select an account from the list of accounts displayed");
	Log.info("Step 1: Tick mark and select an account from the list of accounts displayed");
					
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.AmountField), "Validation Failed: Account Number is not displayed");
					
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account  is selected ");
	Log.info("Expected Result: Account  is selected ");
	}	
	
	ExtentTestManager.endTest();
	return true;

}
public boolean PostDebitPopUpEnterAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
	ExtentTestManager.startTest("TC:29 - POST DEBIT popup is present");
	Log.info("TC:29 - POST DEBIT popup is present");
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
		
	if(ElementDisplayed(LoanTranscharge.AmountField)) {
	click(LoanTranscharge.AmountField);
	WebElement Amount = driver.findElement(LoanTranscharge.AmountField);
	String EnterAmount = testdata.get("Enter_Amount").toString();
	input(LoanTranscharge.AmountField, EnterAmount);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check if data is filled in the text fields");
	Log.info("Step 1: Check if data is filled in the text fields");
							
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.AmountField), "Validation Failed: Account Number is not displayed");
					
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets auto filled in the text fields");
	Log.info("Expected Result: Data gets auto filled in the text fields");
	
	}	
	
	ExtentTestManager.endTest();
	return true;

	}
	
public boolean PostDebitPopUpAddDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
	ExtentTestManager.startTest("TC:30 - POST DEBIT popup is present");
	Log.info("TC:30 - POST DEBIT popup is present");
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
			
	//click(LoanClosureCash.RemoveEntry);
	//Alert alert = driver.switchTo().alert();
	//alert.accept();
								
	if(ElementDisplayed(LoanTranscharge.AddButton)) {
	click(LoanTranscharge.AddButton);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the ADD button ");
	Log.info("Step 1: Click on the ADD button ");
								
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.SubButton), "Validation Failed: Account Number is not displayed");
						
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets inserted in the grid below");
	Log.info("Expected Result: Data gets inserted in the grid below");
}
								
	ExtentTestManager.endTest();
		return true;
}

public boolean PostDebitPopUpSubmitDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:31 - POST DEBIT popup is present");
	Log.info("TC:31 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	if(ElementDisplayed(LoanTranscharge.SubButton)) {
	click(LoanTranscharge.SubButton);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the SUBMIT button ");
	Log.info("Step 1: Click on the SUBMIT button ");
								
	driver.switchTo().window(mainWindowHandle);
						
	//WebDriverWait waitForWindowClose = new WebDriverWait(driver, 15);
	//waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));

	//int windowCount = driver.getWindowHandles().size();
							    
	Assert.assertEquals(driver.getWindowHandles().size(), 1, "Validation Failed: Security Details popup window is still open.");								

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup gets closed  ");
	Log.info("Expected Result: Popup gets closed");
}

	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitSubmitAccountClosure() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:32 - POST DEBIT popup is present");
	Log.info("TC:32 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement SubmitDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", SubmitDetails);
	
	if(ElementDisplayed(LoanTranscharge.SubmitButon)){
	click(LoanTranscharge.SubmitButon);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the SUBMIT button in the transaction window");
	Log.info("Step:01 - Click on the SUBMIT button in the transaction window");
	
	WebDriverWait waitForWindowClose = new WebDriverWait(driver, 10);
    waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));

	int windowCount = driver.getWindowHandles().size();
    Assert.assertEquals(windowCount, 1, "Validation Failed: Security Details popup window is still open.");
			
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets successfully saved in the backend  ");
	Log.info("Expected Result: Data gets successfully saved in the backend  ");
	}
	if(ElementDisplayed(LoanTranscharge.SummaryOperation)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary will be generated");
		Log.info("Expected Result: Summary will be generated");
		}
	else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	transIdTransferLoan = driver.findElement(LoanTranscharge.TransCashID).getText();
	
	ExtentTestManager.endTest();
	return true;
	
	}

public boolean LogintoNBFcApplicationinadifferentuser() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:33 - Login to NBFc Application in a different user");
	Log.info("TC:33 - Login to NBFc Application in a different user");
		
	ExtentTestManager.startTest("Logout");
	Log.info("Logout");
		
	Thread.sleep(2000);
		
	click(LoanTranscharge.custSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
	Log.info("Step:01 -  Click on 'Signout'");
		
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.loginButton), "Validation Failed: User is not logged out successfully.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
	Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		
	String UserName1 = configloader().getProperty("UserName1");
	input(LoanTranscharge.loginUserName, UserName1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");
				
	String Password1 = configloader().getProperty("Password1");
	input(LoanTranscharge.loginPasswrd, Password1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enter valid Password");
	
	click(LoanTranscharge.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Login as another user.");
	Log.info("Step:01 - Login as another user.");
		
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.home), "Validation Failed: 'Home' button is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
	Log.info("Expected Result: User is logged in successfully and dashboard visible");				
				
	ExtentTestManager.endTest();
	return true;		
}

public boolean LogintoNBFcApplicationinadifferentuserAuthorizeandcancel() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:34 - Login to NBFc Application in a different user");
	Log.info("TC:34 - Login to NBFc Application in a different user");
	
	WebElement CashMode = driver.findElement(LoanTranscharge.AuthorizeCancel);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashMode);
	
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.AuthorizeCancel), "Validation Failed: 'Authorize & Cancel' option is not displayed.");
	
	click(LoanTranscharge.AuthorizeCancel);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	click(LoanTranscharge.ManagerAuthorization);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Manager Authorisation window.");
	Log.info("Step:02 - Select the Manager Authorisation window.");
	
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.ManagerAuthorization), "Validation Failed: Manager Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Manager Authorisation window opened successfully");
	Log.info("Expected Result:  Manager Authorisation window opened successfully");

ExtentTestManager.endTest();
return true;

}

public boolean ManagerAuthorisationTransfer() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:35 - Login to NBFc Application in a different user");
	Log.info("TC:35 - Login to NBFc Application in a different user");
	
	click(LoanTranscharge.TransferTab);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the  TRANSFER  tab");
	Log.info("Step:01 - Click on the  TRANSFER  tab");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
    boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id ='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']"))).isDisplayed();
	
    Assert.assertTrue(isDisplayed, "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Moved to TRANSFER  tab  ");
	Log.info("Expected Result: Moved to TRANSFER  tab");
		
	ExtentTestManager.endTest();
	return true;
}


public boolean ManagerAuthorisationRefresh() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:36 - Login to NBFc Application in a different user");
	Log.info("TC:36 - Login to NBFc Application in a different user");
	
	click(LoanTranscharge.Refresh);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
    boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnRefresh']"))).isDisplayed();
	
    Assert.assertTrue(isDisplayed, "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;
}

public boolean SelectManagerTransferTransaction() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:37 - Login to NBFc Application in a different user");
	Log.info("TC:37 - Login to NBFc Application in a different user");
	
	System.out.println("transIdTransferLoan "+transIdTransferLoan);
	FetchwithTransID(transIdTransferLoan);
	
    WebElement checkbox = driver.findElement(LoanTranscharge.ManagerSelectCheckbox);
	
	if(ElementDisplayed(LoanTranscharge.ManagerSelectCheckbox)) {
	click(LoanTranscharge.ManagerSelectCheckbox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(checkbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");		
}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean ManagerTransferAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:38 - Login to NBFc Application in a different user");
	Log.info("TC:38 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(LoanTranscharge.ManagerAuthorize)) {
	click(LoanTranscharge.ManagerAuthorize);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(LoanTranscharge.ManagerAuthorize), "Validation Failed: 'Authorize' button is not Clicked.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");	
	
	click(LoanTranscharge.ClosePopup);
}
	ExtentTestManager.endTest();
	return true;	
}



	
		
private WebElement visibilityOfElementLocated(By xpath) {
	// TODO Auto-generated method stub
	return null;
	}

}
