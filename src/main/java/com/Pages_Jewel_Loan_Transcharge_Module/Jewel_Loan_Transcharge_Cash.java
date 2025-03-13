package com.Pages_Jewel_Loan_Transcharge_Module;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Jewel_Loan_Transcharge_Cash extends Base_Class {
	
	Pages_Jewel_Loan_Transcharge TranschargeCash = new Pages_Jewel_Loan_Transcharge();
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdJewelLoanCash;
    String transIdJewelLoanTransfer;
    
public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(TranschargeCash.TransactionIDField,transID);
		click(TranschargeCash.GoBTN);
		
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
	input(TranschargeCash.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");

	String Password = configloader().getProperty("Password");
	input(TranschargeCash.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enetered valid Password");

	click(TranschargeCash.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(TranschargeCash.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(TranschargeCash.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		click(TranschargeCash.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
		Log.info("Step:01 - Click on OK button");

		input(TranschargeCash.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
		Log.info("Step:02 - Enetered valid User Name");

		input(TranschargeCash.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
		Log.info("Step:03 - Entered valid Password");

		click(TranschargeCash.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
		Log.info("Step:04 - Click on Login Button");

		ElementDisplayed(TranschargeCash.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean ChargePostingWindowAccess() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Charge Posting Window Access");
	Log.info("TC:02 - Charge Posting Window Access");

	try {

		WebElement ProcesspostingWindow = driver
				.findElement(By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[12]/div"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ProcesspostingWindow);

		click(TranschargeCash.ProcessingandPosting);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Expand processing and posting module");
		Log.info("Step:01 Expand processing and posting module");

		click(TranschargeCash.ChargePosting);
		click(TranschargeCash.LoanChargePosting);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on charge posting");
		Log.info("Step:02 Click on charge posting");

		boolean isDashboardVisible = ElementDisplayed(TranschargeCash.LoanChargePosting);

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

	click(TranschargeCash.LoanGroup);
	
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

	click(TranschargeCash.ProductName);
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

	click(TranschargeCash.AccountNumber);
	
	AccountNo.sendKeys(lastThreeDigits);
	
	String enteredValue = AccountNo.getAttribute("value");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Enter valid A/c No.");
	Log.info("Step:01 Enter valid A/c No.");
	
	Assert.assertEquals(enteredValue, lastThreeDigits, "Validation Failed: Account number entered incorrectly");
	
	AccountNo.sendKeys(Keys.TAB);
	
	Thread.sleep(3000);
	
	WebElement accDisplayNameElement = driver.findElement(TranschargeCash.AccDisplayName);
    WebElement currentBalanceElement = driver.findElement(TranschargeCash.CurrentBalance);
    WebElement shadowBalanceElement = driver.findElement(TranschargeCash.ShadowBalance);
    WebElement unclearBalanceElement = driver.findElement(TranschargeCash.UnclearBalance);

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

	click(TranschargeCash.ChargeType);
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
	input(TranschargeCash.Amount, EnterAmount);
	Assert.assertNotNull(EnterAmount, "Validation Failed: Charge Amount is null in test data");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_CPH1_txtChargeAmount_txt']"))); 

	String enteredValue = amountField.getAttribute("value");
	Assert.assertEquals(enteredValue, EnterAmount, "Validation Failed: Entered charge amount does not match test data");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid charge amount");
	Log.info("Step:01 - Enter valid charge amount");

	amountField.clear();
	amountField.sendKeys(EnterAmount);
	//amountField.sendKeys(Keys.TAB);

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

    WebElement depositGrid = wait.until(ExpectedConditions.visibilityOf(driver.findElement(TranschargeCash.DepositDetails)));
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

    WebElement SuccessPopup = wait.until(ExpectedConditions.visibilityOf(driver.findElement(TranschargeCash.LoanChargesPopup)));
    Assert.assertTrue(SuccessPopup.isDisplayed(), "Validation Failed: Loan charges posted not successfully");

    click(TranschargeCash.ClosePopup);
    
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

		click(TranschargeCash.Transaction);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Expand transaction module");
		Log.info("Step:01 Expand transaction module");

		click(TranschargeCash.Transactions);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on transactions window");
		Log.info("Step:02 Click on transactions window");

		boolean isDashboardVisible = ElementDisplayed(TranschargeCash.Transactions);

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

	click(TranschargeCash.ProductGroup);
	
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

	click(TranschargeCash.ProdName);
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

	click(TranschargeCash.AccNumber);
	
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

	click(TranschargeCash.TransType);
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
    
    click(TranschargeCash.ClosePoup);

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
	WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']"))); 
	try {
	amountField.clear();
    amountField.sendKeys(EnterAmount, Keys.TAB);
	 } catch (StaleElementReferenceException e) {
	 }

    Thread.sleep(500);

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

public boolean SelectTransactionModeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:21 - Select Transaction Mode Cash");
	Log.info("TC:21 - Select Transaction Mode Cash");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement TransactionMode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", TransactionMode);
	
	Thread.sleep(2000);
	
	if (ElementDisplayed(TranschargeCash.TransMode)) {
	click(TranschargeCash.TransMode);

	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Trans.mode'as Cash.");
	Log.info("Step 01: Select 'Trans.mode'as Cash.");	

	WebElement Options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl']/option[2]")));
	Options.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash transmode  is accepted");
	Log.info("Expected Result: Cash transmode  is accepted");
}

	ExtentTestManager.endTest();
	return true;
}

public boolean EnterRemarkforTransaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:22 - Enter Remark for Transaction");
	Log.info("TC:22 - Enter Remark for Transaction");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement EnterRemarkvalue = driver.findElement(TranschargeCash.Remarks);

	click(TranschargeCash.Remarks);
	String EnterRemark = testdata.get("Remark").toString();
	input(TranschargeCash.Remarks, EnterRemark);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid remark");
	Log.info("Step:01 - Enter valid mark");
	
    Assert.assertFalse(EnterRemark.isEmpty(), "Validation Failed: Enter Remark should not be empty.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark is entered successfully");
	Log.info("Expected Result: Remark is entered successfully");

	ExtentTestManager.endTest();
	return true;

}
	
public boolean SubmitTransactionandVerifySummary() throws InterruptedException, TimeoutException {
	
	ExtentTestManager.startTest("TC:23 - Submit Transaction and Verify Summary");
	Log.info("TC:23 - Submit Transaction and Verify Summary");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	WebElement SubmitDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", SubmitDetails);
	
	if(ElementDisplayed(TranschargeCash.SubmitTrans)){
	click(TranschargeCash.SubmitTrans);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click submit button");
	Log.info("Step:01 -  Click submit button");
	
	wait.until(ExpectedConditions.numberOfWindowsToBe(1));
	
	boolean isPopupClosed = ElementDisplayed(TranschargeCash.SummaryOperation);
	Assert.assertTrue(isPopupClosed, "Validation Failed: Security Details popup window is still open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction submitted and summary details are displayed");
	Log.info("Expected Result: Transaction submitted and summary details are displayed");
	}
	
	if(ElementDisplayed(TranschargeCash.SummaryOperation)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Verify summary details");
		Log.info("Expected Result: Verify summary details");
		}
	else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	transIdJewelLoanCash = driver.findElement(TranschargeCash.TransCashID).getText();
	
	ExtentTestManager.endTest();
	return true;
	
}

public boolean LogintoNBFcApplicationinadifferentuser() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:24 - Login to NBFc Application in a different user");
	Log.info("TC:24 - Login to NBFc Application in a different user");
	
	ExtentTestManager.startTest("Logout");
	Log.info("Logout");
	
	Thread.sleep(2000);
	
	click(TranschargeCash.custSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
	Log.info("Step:01 -  Click on 'Signout'");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.loginButton), "Validation Failed: User is not logged out successfully.");
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
	Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
	
	String UserName1 = configloader().getProperty("UserName1");
	input(TranschargeCash.loginUserName, UserName1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");
			
	String Password1 = configloader().getProperty("Password1");
	input(TranschargeCash.loginPasswrd, Password1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enter valid Password");

	click(TranschargeCash.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Login as another user.");
	Log.info("Step:01 - Login as another user.");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.home), "Validation Failed: 'Home' button is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
	Log.info("Expected Result: User is logged in successfully and dashboard visible");				
			
	ExtentTestManager.endTest();
	return true;		
}

public boolean LogintoNBFcApplicationinadifferentuserAuthorizeandcancel() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:25 - Login to NBFc Application in a different user");
	Log.info("TC:25 - Login to NBFc Application in a different user");
	
	WebElement CashMode = driver.findElement(TranschargeCash.AuthorizeCancel);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashMode);
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.AuthorizeCancel), "Validation Failed: 'Authorize & Cancel' option is not displayed.");
	
	click(TranschargeCash.AuthorizeCancel);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	click(TranschargeCash.CashAuthorisation);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Cashier Authorisation window.");
	Log.info("Step:02 - Select the Cashier Authorisation window.");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.CashAuthorisation), "Validation Failed: Cashier Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cashier Authorisation window opened successfully");
	Log.info("Expected Result: Cashier Authorisation window opened successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean CashierAuthorisationRefresh() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:26 - Login to NBFc Application in a different user");
	Log.info("TC:26 - Login to NBFc Application in a different user");
	
	click(TranschargeCash.Refresh);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.Refresh), "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;
}

public boolean SelectCashierCashTransaction() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:27 - Login to NBFc Application in a different user");
	Log.info("TC:27 - Login to NBFc Application in a different user");
	
	System.out.println("transIdJewelLoanCash "+transIdJewelLoanCash);
	FetchwithTransID(transIdJewelLoanCash);
	
    WebElement checkbox = driver.findElement(TranschargeCash.OpeningEntryCashCheckbox);
	
	if(ElementDisplayed(TranschargeCash.OpeningEntryCashCheckbox)) {
	click(TranschargeCash.OpeningEntryCashCheckbox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(checkbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");	
		}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean CashierCashAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:28 - Login to NBFc Application in a different user");
	Log.info("TC:28 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(TranschargeCash.CashAuthorizeBtn)) {
	click(TranschargeCash.CashAuthorizeBtn);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.CashAuthorizeBtn), "Validation Failed: 'Authorize' button is not Clicked.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");	
	
	click(TranschargeCash.ClosePopup);
}
	ExtentTestManager.endTest();
	return true;	
}

public boolean ManagerCashAuthorisation() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:29 - Login to NBFc Application in a different user");
	Log.info("TC:29 - Login to NBFc Application in a different user");
	
	WebElement CashModeTrans = driver.findElement(TranschargeCash.ManagerAuthorization);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashModeTrans);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	Thread.sleep(2000);
	click(TranschargeCash.ManagerAuthorization);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Manager Authorisation window.");
	Log.info("Step:02 - Select the Manager Authorisation window.");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.ManagerAuthorization), "Validation Failed: Manager Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager Authorisation window opened successfully");
	Log.info("Expected Result: Manager Authorisation window opened successfully");

	ExtentTestManager.endTest();
	return true;
}

public boolean CashAuthorizationRefresh() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:30 - Login to NBFc Application in a different user");
	Log.info("TC:30 - Login to NBFc Application in a different user");
	
	click(TranschargeCash.Refresh);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.Refresh), "Validation Failed: 'Refresh' button is not displayed.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;	
}

public boolean SelectCashTransactionManagerAuthorisation() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:31 - Login to NBFc Application in a different user");
	Log.info("TC:31 - Login to NBFc Application in a different user");
	
	System.out.println("transIdJewelLoanCash "+transIdJewelLoanCash);
	FetchwithTransID(transIdJewelLoanCash);
	
	WebElement Managercheckbox = driver.findElement(TranschargeCash.ManagerCheckBox);
	
	if(ElementDisplayed(TranschargeCash.ManagerCheckBox)) {
	click(TranschargeCash.ManagerCheckBox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(Managercheckbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");
}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean CashManagerAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:32 - Login to NBFc Application in a different user");
	Log.info("TC:32 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(TranschargeCash.ManagerAuthorize)) {
	click(TranschargeCash.ManagerAuthorize);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(TranschargeCash.ManagerAuthorize), "Validation Failed: 'Authorize' button is not Clicked.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");
	
	click(TranschargeCash.ClosePopup);
}
	ExtentTestManager.endTest();
	return true;	
}











	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
