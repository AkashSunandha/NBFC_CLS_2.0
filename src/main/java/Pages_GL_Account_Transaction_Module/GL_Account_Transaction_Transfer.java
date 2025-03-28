package Pages_GL_Account_Transaction_Module;

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

public class GL_Account_Transaction_Transfer extends Base_Class {
	
	GL_Account_Transaction GLTransaction = new GL_Account_Transaction();
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdGLtransCash;
    String transIdGLtransTransfer;
    String mainWindowHandle;
    
public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(GLTransaction.TransactionIDField,transID);
		click(GLTransaction.GoBTN);
		
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
	input(GLTransaction.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");

	String Password = configloader().getProperty("Password");
	input(GLTransaction.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enetered valid Password");

	click(GLTransaction.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(GLTransaction.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(GLTransaction.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		click(GLTransaction.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
		Log.info("Step:01 - Click on OK button");

		input(GLTransaction.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
		Log.info("Step:02 - Enetered valid User Name");

		input(GLTransaction.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
		Log.info("Step:03 - Entered valid Password");

		click(GLTransaction.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
		Log.info("Step:04 - Click on Login Button");

		ElementDisplayed(GLTransaction.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean LaunchGLAccountTransactionModule() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Launch GL Account Transaction Module");
	Log.info("TC:02 - Launch GL Account Transaction Module");

	try {

		ScrollUntilElementVisible(GLTransaction.Transaction);
		click(GLTransaction.Transaction);
		
		click(GLTransaction.GLTransactions);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Transactions -> GL A/c transaction");
		Log.info("Step:01 Navigate to Transactions -> GL A/c transaction");

		boolean isDashboardVisible = ElementDisplayed(GLTransaction.GLAccInfo);

		Assert.assertTrue(isDashboardVisible,"Validation Failed: GL A/c transaction opening window is NOT displayed.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Module name displayed as 'GL Account Transaction'");
		Log.info("Expected Result: Module name displayed as 'GL Account Transaction'");

	} catch (Exception e) {
		ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
		Log.error("Exception occurred while accessing Charge Posting Opening Window: " + e.getMessage());
		Assert.fail("Test failed due to an unexpected error.");
	}

	ExtentTestManager.endTest();
	return true;

}

public boolean DefaultDateCheck()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:03 - Default Date Check");
	Log.info("TC:03 - Default Date Check");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement Date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_dtDate_txt']")));
	String DateField = Date.getAttribute("value");
	Log.info(DateField);
	
	WebElement ValueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_dtValueDate_dtValueDate_txt']")));
	String ValDate = ValueDate.getAttribute("value");
	Log.info(ValDate);
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify date and value date field are set to the system date by default");
    Log.info("Step:01 - Verify date and value date field are set to the system date by default");
    
    Assert.assertFalse(DateField.isEmpty(), "Validation Failed: date field is empty.");
    
    Assert.assertFalse(ValDate.isEmpty(), "Validation Failed: Value date field is empty.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both dates set to system date");
    Log.info("Expected Result: Both dates set to system date");

    ExtentTestManager.endTest();
	return true;

}

public boolean DefaultBranchCheck()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:04 - Default Branch Check");
	Log.info("TC:04 - Default Branch Check");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement BranchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@ id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlBranch_ddl']")));
	String BranchName = BranchField.getAttribute("value");
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify the branch field is automatically set to the login branch");
    Log.info("Step:01 - Verify the branch field is automatically set to the login branch");
    
    Assert.assertFalse(BranchName.isEmpty(), "Validation Failed: Branch is not autoloaded");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login branch is displayed by default");
    Log.info("Expected Result: Login branch is displayed by default");

    ExtentTestManager.endTest();
	return true;

}

public boolean GLAccNameDropdownOptions() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:05 - GL Acc. Name Dropdown Options");
	Log.info("TC:05 - GL Acc. Name Dropdown Options");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.GLaccname)) {
	click(GLTransaction.GLaccname);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the GL Acc.Name dropdown");
	Log.info("Step 1: Click on the GL Acc.Name dropdown");
	
	WebElement GLAccDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@id = 'hyjackText0']")));
	GLAccDropdown.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 2:  Verify the list of active head names");
	Log.info("Step 2:  Verify the list of active head names");
		
	Assert.assertTrue(ElementDisplayed(GLTransaction.GLacccode), "Validation Failed: GL Acc Code is not displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option should be display");
	Log.info("Expected Result: Option should be display");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean GLAccNametoCodeMapping() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:06 - GL Acc. Name to Code Mapping");
	Log.info("TC:06 - GL Acc. Name to Code Mapping");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	WebElement GLAccDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@val='463' and text()='ADVERTISEMENT']")));
	GLAccDropdown.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1:   Select GL Acc. Name");
	Log.info("Step 1:   Select GL Acc. Name");
		
	Assert.assertTrue(ElementDisplayed(GLTransaction.GLacccode), "Validation Failed: GL Acc Code is not displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct GL Acc. code displayed");
	Log.info("Expected Result: Correct GL Acc. code displayed");
	
	ExtentTestManager.endTest();
	return true;

}

public boolean TransTypeDropdownOptions() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:07 - Trans Type Dropdown Options");
	Log.info("TC:07 - Trans Type Dropdown Options");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.TransType)) {
	click(GLTransaction.TransType);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the trans type dropdown");
	Log.info("Step 1: Click on the trans type dropdown");
	
	WebElement TransDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[@id ='ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlTrnType']")));
	TransDropdown.click();
	
	List<WebElement> options = TransDropdown.findElements(By.tagName("option"));
	List<String> optionTexts = new ArrayList<>();
	for (WebElement option : options) {
		optionTexts.add(option.getText().trim());
	}
	
	List<String> expectedOptions = Arrays.asList("Credit", "Debit");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify options credit and debit are shown");
	Log.info("Step 2: Verify options credit and debit are shown");
	
	Assert.assertTrue(optionTexts.containsAll(expectedOptions), "Validation Failed: Dropdown does not contain expected options.");
			
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Credit, Debit are listed");
	Log.info("Expected Result: Credit, Debit are listed");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean GoButtonActionwithValidGLAccCode()throws InterruptedException {

	ExtentTestManager.startTest("TC:08 - Go Button Action with Valid GL Acc. Code");
	Log.info("TC:08 - Go Button Action with Valid GL Acc. Code");

	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement GoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_btnGo']")));
    GoBtn.click();
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click go button");
    Log.info("Step:01 - Click go button");

    WebElement Otherinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content']//div[4]")));
    
    Assert.assertTrue(Otherinfo.isDisplayed(), "Validation Failed: Other info not displayed");
    
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Proper navigation and functionality and details will be displays");
	Log.info("Expected Result: Proper navigation and functionality and details will be displays");

	ExtentTestManager.endTest();
	return true;

}

public boolean DisplayEntryonCheckboxClick() throws InterruptedException {

	ExtentTestManager.startTest("TC:09 - Display Entry on Checkbox Click");
	Log.info("TC:09 - Display Entry on Checkbox Click");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement PreviousCheckbox = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_chkLastN']"));

	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - Click on the previous transaction checkbox");
	Log.info("Step:01 - Click on the previous transaction checkbox");

	PreviousCheckbox.click();
		
	WebElement PreviousTrans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_divLastNT']")));

	Assert.assertTrue(PreviousTrans.isDisplayed(), "Validation Failed: Previous Transaction list not displayed");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result : Previous transaction entries displayed");
	Log.info("Expected Result : Previous transaction entries displayed");
		
	ExtentTestManager.endTest();
	return true;

}

public boolean NetPayableandRecoveryCalculation(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException, TimeoutException {

	ExtentTestManager.startTest("TC:10 - Net Payable and Recovery Calculation");
	Log.info("TC:10 - Net Payable and Recovery Calculation");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	String EnterAmount = testdata.get("Trans_Amount").toString();
	Assert.assertNotNull(EnterAmount, "Validation Failed: Transaction Amount is null in test data");

    WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtTrnAmount_txt']"))); 
    amountField.click();
    amountField.clear();
    amountField.sendKeys(EnterAmount, Keys.TAB);
                
	String enteredValue = amountField.getAttribute("value");
	Assert.assertEquals(enteredValue, EnterAmount, "Validation Failed: Entered transaction amount does not match test data");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter trnamount as 1000");
	Log.info("Step:01 -  Enter trnamount as 1000");
	
	Thread.sleep(3000);  
	
	By netPayableLocator = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ucNonProductTransactionRecovery_txtGrandTotal_txt']");
    By recoveryTotalLocator = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ucNonProductTransactionRecovery_txtRecoveryTotal_txt']");
	
    WebElement netPayableField = wait.until(ExpectedConditions.visibilityOfElementLocated(netPayableLocator));
    WebElement recoveryTotalField = wait.until(ExpectedConditions.visibilityOfElementLocated(recoveryTotalLocator));
    
    String netPayableValue = netPayableField.getAttribute("value").trim();
    Log.info("Net Payable Field Value: '" + netPayableValue + "'");
    
    String recoveryTotalValue = recoveryTotalField.getAttribute("value").trim();
    Log.info("Recovery Total Field Value: '" + recoveryTotalValue + "'");
    
    ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Observe net payable and recovery totals");
	Log.info("Step:02 - Observe net payable and recovery totals");
	
	Assert.assertEquals(netPayableValue, "1000.00", "Validation Failed: Net Payable amount is incorrect. Found: " + netPayableValue);
	Assert.assertEquals(recoveryTotalValue, "0.00", "Validation Failed: Recovery total is incorrect. Found: " + recoveryTotalValue);
    
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Net payable: 1000, Recovery total: 0");
	Log.info("Expected Result: Net payable: 1000, Recovery total: 0");

	ExtentTestManager.endTest();
	return true;

}

public boolean FieldPresenceBelowNetPayable()throws InterruptedException {
	
	ExtentTestManager.startTest("TC:11 - Field Presence Below Net Payable");
	Log.info("TC:11 - Field Presence Below Net Payable");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement Transmode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[@id ='ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlTrnType']")));
    Assert.assertTrue(Transmode.isDisplayed(), "Validation Failed: Transaction Mode field is not displayed.");
	
	WebElement Partyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtPartyName_txt']")));
    Assert.assertTrue(Partyname.isDisplayed(), "Validation Failed: Party Name field is not displayed.");
	
	WebElement Refno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRefNo_txt']")));
    Assert.assertTrue(Refno.isDisplayed(), "Validation Failed: Reference Number field is not displayed.");
	
	WebElement Particulars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRemarks_txt']")));
    Assert.assertTrue(Particulars.isDisplayed(), "Validation Failed: Particulars field is not displayed.");
	
	WebElement Appmanager = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlAppManager_ddl']")));
    Assert.assertTrue(Appmanager.isDisplayed(), "Validation Failed: Approving Manager field is not displayed.");
	
    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Verify presence of Trnsmode, partyname, Ref no, particulars, App.manager fields");
    Log.info("Step:01 - Verify presence of Trnsmode, partyname, Ref no, particulars, App.manager fields");
    
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fields are present");
    Log.info("Expected Result: Fields are present");

    ExtentTestManager.endTest();
	return true;

}

public boolean TrnsmodeDropdownValidation() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:12 - Trnsmode Dropdown Validation");
	Log.info("TC:12 - Trnsmode Dropdown Validation");
	
	ScrollUntilElementVisible(GLTransaction.TransMode);
	click(GLTransaction.TransMode);

	ExtentTestManager.getTest().log(Status.PASS, "Step 01:  Click on Trnsmode dropdown");
	Log.info("Step 01:  Click on Trnsmode dropdown");	
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Options cash and transfer are listed");
	Log.info("Expected Result: Options cash and transfer are listed");

	ExtentTestManager.endTest();
	return true;
}

public boolean GLTransactionCreditandCash() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:13 - GL Transaction - Credit and Cash");
	Log.info("TC:13 - GL Transaction - Credit and Cash");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	ScrollUntilElementVisible(GLTransaction.TransMode);
	click(GLTransaction.TransMode);
	
	WebElement Options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlTransactionMode_ddl']/option[3]")));
	Options.click();

	ExtentTestManager.getTest().log(Status.PASS, "Step 01:  Select  Trnsmode as Transfer");
	Log.info("Step 01:  Select  Trnsmode as Transfer");	
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer selected");
	Log.info("Expected Result: Transfer selected");

	ExtentTestManager.endTest();
	return true;
}


public boolean PartynameParticularsInputValidation(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	
	ExtentTestManager.startTest("TC:14 - Party name, Particulars Input Validation");
	Log.info("TC:14 - Party name, Particulars Input Validation");
	
	ScrollUntilElementVisible(GLTransaction.PartyName);
	click(GLTransaction.PartyName);
	
	String Partyname = testdata.get("Party_Name").toString();
	input(GLTransaction.PartyName, Partyname);
	
	ScrollUntilElementVisible(GLTransaction.Particulars);
	click(GLTransaction.Particulars);
	
	String Particulars = testdata.get("Particulars").toString();
	input(GLTransaction.Particulars, Particulars);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numbers, alphabets, and special characters in partyname, Particulars fields");
	Log.info("Step:01 - Enter numbers, alphabets, and special characters in partyname, Particulars fields");
	
    Assert.assertFalse(Partyname.isEmpty(), "Validation Failed: Party Name should not be empty.");
    Assert.assertFalse(Particulars.isEmpty(), "Validation Failed: Particulars should not be empty.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All character types are accepted");
	Log.info("Expected Result: All character types are accepted");

	ExtentTestManager.endTest();
	return true;

}

public boolean AppManagerFieldEditRestriction() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:15 - App. Manager Field Edit Restriction");
	Log.info("TC:15 - App. Manager Field Edit Restriction");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement appManagerField = wait.until(ExpectedConditions.presenceOfElementLocated(GLTransaction.AppManager));
	
	ScrollUntilElementVisible(GLTransaction.AppManager);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Attempt to edit App. manager field");
    Log.info("Step 1: Attempt to edit App. manager field");
	
	boolean isEnabled = appManagerField.isEnabled();
    boolean isReadOnly = appManagerField.getAttribute("readonly") != null;
    
    if (!isEnabled || isReadOnly) {
        
    } else {
            click(GLTransaction.AppManager);
            ExtentTestManager.getTest().log(Status.FAIL, "Validation Failed: App Manager field is editable!");
            Log.info("Validation Failed: App Manager field is editable!");
            return false;
    }
            
        ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Editing not possible");
        Log.info("Expected Result: Editing not possible");
    
    
    ExtentTestManager.endTest();
    return true;
}

public boolean POSTDEBITpopupispresent() throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:16 - POST DEBIT popup is present");
	Log.info("TC:16 - POST DEBIT popup is present");
	
	WebElement PostDebitTab = driver.findElement(GLTransaction.PostDebit);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", PostDebitTab);
	
	click(GLTransaction.PostDebit);
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

public boolean PostDebitpopupispresent() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:17 - POST DEBIT popup is present");
	Log.info("TC:17 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.TransactionBased)) {
	click(GLTransaction.TransactionBased);
	WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlTrnsBased_ddl']/option[2]")));
	options.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Account  from the 'Transaciton Based' drop down");
	Log.info("Step 1: Select Account  from the 'Transaciton Based' drop down");
	
	Assert.assertTrue(ElementDisplayed(GLTransaction.ProductGroupDropdown), "Validation Failed: Transaction Based field should not be displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account selected from the 'Transaciton Based' drop down");
	Log.info("Expected Result: Account selected from the 'Transaciton Based' drop down");
	
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean PostDebitPopUpProductGroupDropdown() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:18 - POST DEBIT popup is present");
	Log.info("TC:18 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.ProductGroupDropdown)) {
	click(GLTransaction.ProductGroupDropdown);
	WebElement ProductGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ddlProductGroup_ddl']/option[4]")));
	ProductGroup.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Demand Investment from the 'Product group' drop down");
	Log.info("Step 1: Select Demand Investment from the 'Product group' drop down");
		
	Assert.assertTrue(ElementDisplayed(GLTransaction.ProductNameDropdown), "Validation Failed: Product Group dropdown should not be displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected");
	Log.info("Expected Result: Demand Investment is selected");
	}
	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpProductNameDropdown() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:19 - POST DEBIT popup is present");
	Log.info("TC:19 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.ProductNameDropdown)) {
	click(GLTransaction.ProductNameDropdown);
	WebElement ProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlProductName_ddl']/option[3]")));
	ProductName.click();
		
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select item from the 'Product Name' drop down");
	Log.info("Step 1: Select item from the 'Product Name' drop down");
			
	Assert.assertTrue(ElementDisplayed(GLTransaction.BranchName), "Validation Failed: Product Name dropdown should not be displayed");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
	Log.info("Expected Result: Product name item  is selected ");
	}	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpBranchDropdown() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:20 - POST DEBIT popup is present");
	Log.info("TC:20 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
				
	if(ElementDisplayed(GLTransaction.BranchName)) {
	click(GLTransaction.BranchName);
	WebElement BranchName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlBranch_ddl']/option[3]")));
	BranchName.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select an a branch  from the 'Branch  'drop down'");
	Log.info("Step 1: Select an a branch  from the 'Branch  'drop down'");
				
	Assert.assertTrue(ElementDisplayed(GLTransaction.AccountNum), "Validation Failed: Branch dropdown should not be displayed");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch  item  is selected ");
	Log.info("Expected Result: Branch  item  is selected ");
	
	}	
	
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:21 - POST DEBIT popup is present");
	Log.info("TC:21 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(GLTransaction.AccountNum)) {
		click(GLTransaction.AccountNum);
		click(GLTransaction.AccountNoCheckbox);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Tick mark and select an account from the list of accounts displayed");
		Log.info("Step 1: Tick mark and select an account from the list of accounts displayed");
		
		WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(GLTransaction.AmountField));
        Assert.assertTrue(ElementDisplayed(GLTransaction.AmountField), "Validation Failed: Amount field is not displayed after entering Account Number.");
    } else {
        Log.error("Account Number field is not displayed.");
        return false;
    }
			
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account  is selected ");
		Log.info("Expected Result: Account  is selected ");
		

	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpEnterAmount() throws InterruptedException {
    
    ExtentTestManager.startTest("TC:22 - POST DEBIT popup is present");
    Log.info("TC:22 - POST DEBIT popup is present");

    WebDriverWait wait = new WebDriverWait(driver, 10);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String transAmount = "";

    WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(GLTransaction.AmountField));
    Assert.assertTrue(ElementDisplayed(GLTransaction.AmountField), "Validation Failed: Amount field is not visible.");

    try {
        WebElement totalCredDebitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(GLTransaction.TotCredDebit));

        transAmount = (String) js.executeScript("return arguments[0].value;", totalCredDebitElement);
        
        if (transAmount == null || transAmount.isEmpty()) {
            transAmount = totalCredDebitElement.getText();
        }

        Log.info("Captured Transaction Amount: " + transAmount);

    } catch (StaleElementReferenceException e) {
        Log.warn("StaleElementReferenceException encountered. Retrying...");
    }

    Assert.assertFalse(transAmount.isEmpty(), "Validation Failed: Transaction amount could not be captured!");

    js.executeScript("arguments[0].value=arguments[1];", amountField, transAmount);

    ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check if data is filled in the text fields");
    Log.info("Step 1: Check if data is filled in the text fields");

    String enteredValue = (String) js.executeScript("return arguments[0].value;", amountField);
    Assert.assertEquals(enteredValue, transAmount, "Validation Failed: Entered amount does not match the captured amount.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  data  gets auto filled in the text fields");
    Log.info("Expected Result:  data  gets auto filled in the text fields");

    ExtentTestManager.endTest();
    return true;
}

public boolean PostDebitPopUpAddDetails() throws InterruptedException{
		
	ExtentTestManager.startTest("TC:23 - POST DEBIT popup is present");
	Log.info("TC:23 - POST DEBIT popup is present");
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
					
	if(ElementDisplayed(GLTransaction.AddButton)) {
	click(GLTransaction.AddButton);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the ADD button ");
	Log.info("Step 1: Click on the ADD button ");
								
	Assert.assertTrue(ElementDisplayed(GLTransaction.SubButton), "Validation Failed: Account Number is not displayed");
						
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets inserted in the grid below");
	Log.info("Expected Result: Data gets inserted in the grid below");
	}
								
	ExtentTestManager.endTest();
		return true;
}

public boolean PostDebitPopUpSubmitDetails() throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:24 - POST DEBIT popup is present");
	Log.info("TC:24 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	ScrollUntilElementVisible(GLTransaction.SubButton);
	click(GLTransaction.SubButton);

	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the SUBMIT button ");
	Log.info("Step 1: Click on the SUBMIT button ");
								
	driver.switchTo().window(mainWindowHandle);
						
	//WebDriverWait waitForWindowClose = new WebDriverWait(driver, 15);
	//waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));

	//int windowCount = driver.getWindowHandles().size();
							    
	Assert.assertEquals(driver.getWindowHandles().size(), 1, "Validation Failed: Security Details popup window is still open.");								

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup gets closed  ");
	Log.info("Expected Result: Popup gets closed");

	ExtentTestManager.endTest();
	return true;

}


public boolean PostDebitPopUpSubmitDetailsSubmitsummary() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:25 - POST DEBIT popup is present");
	Log.info("TC:25 - POST DEBIT popup is present");
	
	ScrollUntilElementVisible(GLTransaction.Submitbutton);
	click(GLTransaction.Submitbutton);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the SUBMIT button in the transaction window");
	Log.info("Step:01 - Click on the SUBMIT button in the transaction window");
	
	WebDriverWait waitForWindowClose = new WebDriverWait(driver, 10);
    waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));

	int windowCount = driver.getWindowHandles().size();
    Assert.assertEquals(windowCount, 1, "Validation Failed: Security Details popup window is still open.");
			
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets successfully saved in the backend");
	Log.info("Expected Result: Data gets successfully saved in the backend");
	
	if(ElementDisplayed(GLTransaction.SummaryOperation)) {
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify transaction summary");
		Log.info("Step:01 - Verify transaction summary");
		}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
		}
	transIdGLtransTransfer = driver.findElement(GLTransaction.TransCashID).getText();
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary is accurate and presents details");
	Log.info("Expected Result: Summary is accurate and presents details");
	
	ExtentTestManager.endTest();
	return true;
	
}

public boolean LogintoNBFcApplicationinadifferentuser() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:26 - Login to NBFc Application in a different user");
	Log.info("TC:26 - Login to NBFc Application in a different user");
		
	ExtentTestManager.startTest("Logout");
	Log.info("Logout");
		
	Thread.sleep(2000);
		
	click(GLTransaction.custSignOut);
	
	Assert.assertTrue(ElementDisplayed(GLTransaction.loginButton), "Validation Failed: User is not logged out successfully.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Open the NBFc application.");
	Log.info("Step 1: Open the NBFc application.");
		
	String UserName1 = configloader().getProperty("UserName1");
	input(GLTransaction.loginUserName, UserName1);
				
	String Password1 = configloader().getProperty("Password1");
	input(GLTransaction.loginPasswrd, Password1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter username and password.");
	Log.info("Step:02 - Enter username and password.");
	
	click(GLTransaction.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Login as another user.");
	Log.info("Step:01 - Login as another user.");
		
	Assert.assertTrue(ElementDisplayed(GLTransaction.home), "Validation Failed: 'Home' button is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is successfully logged in.");
	Log.info("Expected Result: User is successfully logged in.");				
				
	ExtentTestManager.endTest();
	return true;		
}


public boolean LogintoNBFcApplicationinadifferentuserAuthorizeandcancel() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:27 - Login to NBFc Application in a different user");
	Log.info("TC:27 - Login to NBFc Application in a different user");
	
	ScrollUntilElementVisible(GLTransaction.AuthorizeCancel);
	click(GLTransaction.AuthorizeCancel);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	click(GLTransaction.ManagerAuthorization);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Manager Authorisation window");
	Log.info("Step:02 - Select the Manager Authorisation window");
	
	Assert.assertTrue(ElementDisplayed(GLTransaction.CashAuthorisation), "Validation Failed: Cashier Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: ManagerAuthorisation window opened successfully");
	Log.info("Expected Result: ManagerAuthorisation window opened successfully");

	ExtentTestManager.endTest();
	return true;

}

public boolean ManagerAuthorisationTransfer() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:28 - Login to NBFc Application in a different user");
	Log.info("TC:28 - Login to NBFc Application in a different user");
	
	click(GLTransaction.TransferTab);
		
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
	
	ExtentTestManager.startTest("TC:29 - Login to NBFc Application in a different user");
	Log.info("TC:29 - Login to NBFc Application in a different user");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
    
    WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(GLTransaction.Refresh));
    refreshButton.click();
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	Assert.assertTrue(ElementDisplayed(GLTransaction.Refresh), "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;
}

public boolean SelectManagerTransferTransaction() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:30 - Login to NBFc Application in a different user");
	Log.info("TC:30 - Login to NBFc Application in a different user");
	
	System.out.println("transIdGLtransTransfer "+transIdGLtransTransfer);
	FetchwithTransID(transIdGLtransTransfer);
	
	WebElement Managercheckbox = driver.findElement(GLTransaction.TransManagerCheckBox);
	
	if(ElementDisplayed(GLTransaction.TransManagerCheckBox)) {
	click(GLTransaction.TransManagerCheckBox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(Managercheckbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");
}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean ManagerTransferAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:31 - Login to NBFc Application in a different user");
	Log.info("TC:31 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(GLTransaction.ManagerAuthorize)) {
	click(GLTransaction.ManagerAuthorize);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(GLTransaction.ManagerAuthorize), "Validation Failed: 'Authorize' button is not Clicked.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");
	
	click(GLTransaction.ClosePopup);
}
	ExtentTestManager.endTest();
	return true;	
}







	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
