package com.Pages_Jewel_Gold_Loan_Renewal_Module;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Jewel_Gold_Loan_Renewal_Transfer extends Base_Class {
	
	Pages_Jewel_Gold_Loan_Renewals LoanClosureCash = new Pages_Jewel_Gold_Loan_Renewals();
	
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdCashLoan;
    String transIdTransferLoan;
    String mainWindowHandle;

	
	public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(LoanClosureCash.TransactionIDField,transID);
		click(LoanClosureCash.GoBTN);
		
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
	
	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:01 - Login to NBFC Application");
		Log.info("TC_01 - Login to NBFC Application");

		String UserName = configloader().getProperty("UserName");
		input(LoanClosureCash.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		String Password = configloader().getProperty("Password");
		input(LoanClosureCash.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
		Log.info("Step:02 - Enetered valid Password");

		click(LoanClosureCash.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");

		try {
			ElementDisplayed(LoanClosureCash.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		} catch (Exception e) {
			ElementDisplayed(LoanClosureCash.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS,
					"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(LoanClosureCash.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			input(LoanClosureCash.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			input(LoanClosureCash.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(LoanClosureCash.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(LoanClosureCash.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}

		ElementDisplayed(LoanClosureCash.home);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
		ExtentTestManager.endTest();

		return true;
	}

	public boolean OpenAccountClosureWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Open Account Closure Window");
		Log.info("TC:02 - Open Account Closure Window");

		try {
			
			/*WebElement LoanClosureWindow = driver.findElement(By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/ul/li[7]/a"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", LoanClosureWindow);*/

			click(LoanClosureCash.ClosureRenewal);
			ExtentTestManager.getTest().log(Status.PASS,"Step:01 Navigate to the main menu");
			Log.info("Step:01 Navigate to the main menu");
			
			click(LoanClosureCash.LoanClosure);
			ExtentTestManager.getTest().log(Status.PASS,"Step:02 Click 'Account loan Closure'");
			Log.info("Step:02 Click 'Account loan Closure'");
			

			boolean isDashboardVisible = ElementDisplayed(LoanClosureCash.LoanClosure);

			Assert.assertTrue(isDashboardVisible, "Validation Failed: Deposit opening window is NOT displayed.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account Closure window opens");
			Log.info("Expected Result: Account Closure window opens");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred while accessing Deposit Opening Window: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;

	}
	public boolean SelectJewelLoanProductGroup() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:03 - Select Jewel Loan Product Group");
	Log.info("TC:03 - Select Jewel Loan Product Group");

	click(LoanClosureCash.TopUp);
	click(LoanClosureCash.ProductGroup);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Select topup checkbox");
	Log.info("Step:01 Select topup checkbox");
	
	WebElement ProductGroupDropDown = driver.findElement(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup']"));
	Select dropdown = new Select(ProductGroupDropDown);
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 Click on the 'Product Group' dropdown");
	Log.info("Step:02 Click on the 'Product Group' dropdown");
	
	dropdown.selectByVisibleText("Jewel Loan");
	ExtentTestManager.getTest().log(Status.PASS,"Step:03 Select 'Jewel Loan'");
	Log.info("Step:03 Select 'Jewel Loan'");

	String selectedOption = dropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Jewel Loan","Validation Failed: The selected duration mode should be 'Jewel Loan'.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Jewel Loan is selected in the product group field");
	Log.info("Expected Result: Jewel Loan is selected in the product group field");

	ExtentTestManager.endTest();
	return true;

}
	public boolean SelectProductNamefromDropdown() throws InterruptedException {
		
		ExtentTestManager.startTest("TC:04 - Select Product Name from Dropdown");
		Log.info("TC:04 - Select Product Name from Dropdown");


		click(LoanClosureCash.ProductName);
		ExtentTestManager.getTest().log(Status.PASS,"Step:01 Click on the 'Product Name' dropdown");
		Log.info("Step:01 Click on the 'Product Name' dropdown");
		
		WebElement ProductNameDropDown = driver.findElement(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl']"));
		Select dropdown = new Select(ProductNameDropDown);
		
		dropdown.selectByVisibleText("GOLD LOAN");
		ExtentTestManager.getTest().log(Status.PASS,"Step:02 Select a product");
		Log.info("Step:02 Select a product");

		String selectedOption = dropdown.getFirstSelectedOption().getText();

		Assert.assertEquals(selectedOption, "GOLD LOAN","Validation Failed: The selected duration mode should be 'GOLD LOAN'.");

		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Selected product name is displayed");
		Log.info("Expected Result: Selected product name is displayed");

		ExtentTestManager.endTest();
		return true;

	}
public boolean EnterLoanAccountNumber() throws InterruptedException, ClassNotFoundException {
		
		ExtentTestManager.startTest("TC:05 - Enter Loan Account Number");
		Log.info("TC:05 - Enter Loan Account Number");
		
		String AccountNum = generateAccountNumber();
		Assert.assertNotNull(AccountNum, "Validation Failed: Account number should not be null");
		Log.info("Fetched Account Number from DB: " + AccountNum);
		
		String lastThreeDigits = AccountNum.length() > 3 ? AccountNum.substring(AccountNum.length() - 3) : AccountNum;
		Log.info("Extracted Last 3 Digits: " + lastThreeDigits);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement AccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")));

		Assert.assertTrue(AccountNo.isDisplayed(), "Validation Failed: Account Number field is not displayed");

		click(LoanClosureCash.AccountNumber);
		
		AccountNo.sendKeys(lastThreeDigits);
		
		String enteredValue = AccountNo.getAttribute("value");
		
		ExtentTestManager.getTest().log(Status.PASS,"Step:01 Enter a valid loan account number in the 'Account Number' field");
		Log.info("Step:01 Enter a valid loan account number in the 'Account Number' field");

		Assert.assertEquals(enteredValue, lastThreeDigits, "Validation Failed: Account number entered incorrectly");
		
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Loan account number is accepted");
		Log.info("Expected Result: Loan account number is accepted");
		
		ExtentTestManager.endTest();
		return true;

	}

public boolean DisplayLoanAccountDetails() throws InterruptedException {

	ExtentTestManager.startTest("TC:06 - Display Loan Account Details");
	Log.info("TC:06 - Display Loan Account Details");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement GoButton = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo']"));
	click(LoanClosureCash.GoBtn);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Go' button");
	Log.info("Step:01 - Click 'Go' button");
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
		driver.switchTo().window(handle);
			break;
		}
	}

	 try { 
		 
		 WebElement PreMatureClosurePopup =wait.until(ExpectedConditions.presenceOfElementLocated(LoanClosureCash.PreMatureClosure));
	 
	 if (PreMatureClosurePopup.isDisplayed()) {
	 Log.info("Pre-Mature Closure popup detected, clicking...");
	 PreMatureClosurePopup.click(); } } catch (TimeoutException e) {
	 Log.info("No Pre-Mature Closure popup detected, continuing..."); }
	
	

    driver.switchTo().window(mainWindowHandle);
    Log.info("Switched back to the main window.");
    
	boolean LoanDetails = ElementDisplayed(LoanClosureCash.LoanDetailSection);

	Assert.assertTrue(LoanDetails, "Validation Failed: Loan account details section is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan account details are displayed");
	Log.info("Expected Result: Loan account details are displayed");

	ExtentTestManager.endTest();
	return true;
}

public boolean ExpandRenewalSection() throws InterruptedException {

	ExtentTestManager.startTest("TC:07 - Expand Renewal Section");
	Log.info("TC:07 - Expand Renewal Section");

	//WebElement RenewAccountCheckbox = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucLoanClosure_chkRenewLoanAccount']"));

	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].scrollIntoView(true);", RenewAccountCheckbox);
	
	ScrollUntilElementVisible(LoanClosureCash.RenewAccount);
	click(LoanClosureCash.RenewAccount);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Renew Account' checkbox");
	Log.info("Step:01 - Click 'Renew Account' checkbox");

	boolean RenewAccountDetail = ElementDisplayed(LoanClosureCash.RenewAccountDetail);

	Assert.assertTrue(RenewAccountDetail, "Validation Failed: Renew account details section is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS, "Renewal section is expanded");
	Log.info("Expected Result: Renewal section is expanded");

	ExtentTestManager.endTest();
	return true;
}

public boolean OpenSecurityDetailsPopup() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:08 - Open Security Details Popup");
	Log.info("TC:08 - Open Security Details Popup");
	
	click(LoanClosureCash.SecurityDetails);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click 'Security' button");
	Log.info("Step 1: Click 'Security' button");
	
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
	Assert.assertTrue(popupOpened, "Validation Failed: Securities popup window did not open");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details popup window is opened");
	Log.info("Expected Result: Security details popup window is opened");
		
	ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetails() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:09 - Add Security Details");
	Log.info("TC:09 - Add Security Details");

	WebDriverWait wait = new WebDriverWait(driver, 10);

	// ✅ Select Item Group
	WebElement ItemGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='JSF_ddlItemGroup_ddl']")));
	
	Select dropdown = new Select(ItemGroup);
	dropdown.selectByVisibleText("Gold");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Select Item Group");
	Log.info("Step:01 Select Item Group");

	String selectedOption = dropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Gold","Validation Failed: The selected Item Group should not be 'Gold'.");
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details are added to the grid");
    Log.info("Expected Result: Security details are added to the grid");

    ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetailsItemName() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:10 - Add Security Details Item Name");
	Log.info("TC:10 - Add Security Details Item Name");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	// ✅ Select Item Name
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("PIECE");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Select Item Name");
	Log.info("Step:01 Select Item Name");

	//String selectedItemName = dropdown.getFirstSelectedOption().getText();

	//Assert.assertEquals(selectedItemName, "RING","Validation Failed: The selected Item Name should not be 'RING'.");
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item name is selected");
    Log.info("Expected Result: Item name is selected");

    ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetailsItemDescription(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:11 - Add Security Details Item Description");
	Log.info("TC:11 - Add Security Details Item Description");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Item Description
	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select Item Description");
	Log.info("Step:01 -  Select Item Description");

	Assert.assertEquals(ItemDescription.getAttribute("value"), EnterItemDescrption, "Validation Failed: Item Description is incorrect.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item Description selected");
	Log.info("Expected Result: Item Description selected");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsItemQuantity(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:12 - Add Security Details Item Quantity");
	Log.info("TC:12 - Add Security Details Item Quantity");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Item Quantity
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select Item quantity");
	Log.info("Step:01 -  Select Item quantity");

	Assert.assertEquals(ItemQuantity.getAttribute("value"), EnterItemItemQuantity, "Validation Failed: Item Quantity is incorrect.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item quantity selected");
	Log.info("Expected Result: Item quantity selected");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsStoneWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:13 - Add Security Details Stone Weight");
	Log.info("TC:13 - Add Security Details Stone Weight");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Stone Weight
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Stone Weight 0");
	Log.info("Step:01 - Enter Stone Weight 0");

	Assert.assertEquals(StoneWeight.getAttribute("value"), EnterStoneWeight, "Validation Failed: Entered Stone Weight is incorrect.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Stone Weight Entered");
	Log.info("Expected Result: Stone Weight Entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsTickPurityCheckbox(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:14 - Add Security Details Tick Purity Checkbox");
	Log.info("TC:14 - Add Security Details Tick Purity Checkbox");

	WebDriverWait wait = new WebDriverWait(driver, 10);

	// ✅ Tick Purity Checkbox
	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick purity test checkbox");
	Log.info("Step:01 - Tick purity test checkbox");
	
	boolean PurityTick = ElementDisplayed(LoanClosureCash.PurityTest);

	Assert.assertTrue(PurityTick, "Validation Failed: Purity Tick checkbox is not Selected.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purity is ticked");
	Log.info("Expected Result: Purity is ticked");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsItemWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:15 - Add Security Details Item Weight");
	Log.info("TC:15 - Add Security Details Item Weight");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Item Weight
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Item Weight as 24");
	Log.info("Step:01 - Enter Item Weight as 24");
	
	Assert.assertEquals(ItemWeight.getAttribute("value"), EnterItemWeight, "Validation Failed: Entered Item Weight is incorrect.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item Weight entered");
	Log.info("Expected Result: Item Weight entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsDirtWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:16 - Add Security Details Dirt Weight");
	Log.info("TC:16 - Add Security Details Dirt Weight");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Dirt Weight
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Dirt Weight as 1");
	Log.info("Step:01 - Enter Dirt Weight as 1");
	
	Assert.assertEquals(DirtWeight.getAttribute("value"), EnterDirtWeight, "Validation Failed: Entered Dirt Weight is incorrect.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dirt Weight entered");
	Log.info("Expected Result: Dirt Weight entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsEnterPurity(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:17 - Add Security Details Enter Purity");
	Log.info("TC:17 - Add Security Details Enter Purity");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Enter Purity
	WebElement EnterPurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtPurity_txt']")));
	
	click(LoanClosureCash.EnterPurity);
	
	String EnterPurityDetail = testdata.get("Enter_Purity").toString();
	input(LoanClosureCash.EnterPurity, EnterPurityDetail);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Purity  as 22");
	Log.info("Step:01 - Enter Purity  as 22");
	
	Assert.assertEquals(EnterPurity.getAttribute("value"), EnterPurityDetail, "Validation Failed: Entered Purity is incorrect.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purity added");
	Log.info("Expected Result: Purity added");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsAdd(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:18 - Add Security Details Add");
	Log.info("TC:18 - Add Security Details Add");

	WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement AddDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_btnGoldAdd']")));
	
	if(ElementDisplayed(LoanClosureCash.AddBtn)){
	click(LoanClosureCash.AddBtn);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add' button");
	Log.info("Step:01 - Click 'Add' button");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ItemDesption), "Validation Failed: Item Description field is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ItemQty), "Validation Failed: Item Quantity field is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.StoneWeight), "Validation Failed: Stone Weight field is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.PurityTest), "Validation Failed: Purity Test checkbox is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ItemWeight), "Validation Failed: Item Weight field is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.DirtWeight), "Validation Failed: Dirt Weight field is not visible.");
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.EnterPurity), "Validation Failed: Entered Purity field is not visible.");	
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add button selected date is inseted into the grid");
	Log.info("Expected Result: Add button selected date is inseted into the grid");
	}
	
	ExtentTestManager.endTest();
	return true;
}


public boolean CloseSecurityDetailsPopup(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:19 - Close Security Details Popup");
	Log.info("TC:19 - Close Security Details Popup");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	 // ✅ Select Appraiser from Dropdown
	WebElement AppraiserDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_rdlAppraiser_ddl']")));

	Select appraiser = new Select(AppraiserDropdown);
	appraiser.selectByVisibleText("DIVYA");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01  Select Appraiser from dropdown");
	Log.info("Step:01  Select Appraiser from dropdown");
	
	Thread.sleep(1000);
	
	WebElement AppraiserDropdownAfterSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_rdlAppraiser_ddl']")));
	Select appraiserAfterSelection = new Select(AppraiserDropdownAfterSelection);
	String selectedAppraiserName = appraiserAfterSelection.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedAppraiserName, "DIVYA","Validation Failed: The selected Appraiser Name should not be 'DIVYA'.");
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: appraiser selected");
    Log.info("Expected Result: appraiser selected");

    ExtentTestManager.endTest();
	return true;

}

public boolean CloseSecurityDetailsPopupSubmit(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, StaleElementReferenceException{
	
	ExtentTestManager.startTest("TC:20 - Close Security Details Popup Submit");
	Log.info("TC:20 - Close Security Details Popup Submit");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Click Submit Button
	WebElement SubmitDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='btnSubmit']")));
	
	if(ElementDisplayed(LoanClosureCash.SubmitBtn)){
	click(LoanClosureCash.SubmitBtn);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Submit' button");
	Log.info("Step:01 - Click 'Submit' button");
	
	driver.switchTo().window(mainWindowHandle);
	
    Assert.assertEquals(driver.getWindowHandles().size(), 1, "Validation Failed: Security Details popup window is still open.");
		
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details popup window is closed");
    Log.info("Expected Result: Security details popup window is closed");
	
	}
    ExtentTestManager.endTest();
	return true;

}


public boolean EnterSanctionedAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
	
	ExtentTestManager.startTest("TC:21 - Enter Sanctioned Amount");
	Log.info("TC:21 - Enter Sanctioned Amount");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String Amount = "";

    WebElement Enteramount = wait.until(ExpectedConditions.elementToBeClickable(LoanClosureCash.SanctionedAmount));
    Assert.assertTrue(ElementDisplayed(LoanClosureCash.SanctionedAmount), "Validation Failed: Amount field is not visible.");

    try {
        WebElement LimitSanctioned = wait.until(ExpectedConditions.visibilityOfElementLocated(LoanClosureCash.LimitAmount));

        Amount = (String) js.executeScript("return arguments[0].value;", LimitSanctioned);
        
        if (Amount == null || Amount.isEmpty()) {
            Amount = LimitSanctioned.getText();
        }

        Log.info("Captured Transaction Amount: " + Amount);

    } catch (StaleElementReferenceException e) {
        Log.warn("StaleElementReferenceException encountered. Retrying...");
    }

    Assert.assertFalse(Amount.isEmpty(), "Validation Failed: Transaction amount could not be captured!");

    js.executeScript("arguments[0].value=arguments[1];", Enteramount, Amount);

    ExtentTestManager.getTest().log(Status.PASS, "Step 1: Enter the sanctioned amount in the respective field.");
    Log.info("Step 1: Enter the sanctioned amount in the respective field");

    String enteredValue = (String) js.executeScript("return arguments[0].value;", Enteramount);
    Assert.assertEquals(enteredValue, Amount, "Validation Failed: Sanctioned amount should not be empty.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Sanctioned amount is accepted");
    Log.info("Expected Result: Sanctioned amount is accepted");

    ExtentTestManager.endTest();
    return true;
}
	
public boolean GetValuewithCashTransactionMode() throws InterruptedException {

	ExtentTestManager.startTest("TC:22 - Get Value with Cash Transaction Mode");
	Log.info("TC:22 - Get Value with Cash Transaction Mode");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
    
    WebElement getValuesBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(LoanClosureCash.GetValues));

    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", getValuesBtn);
	
	boolean isClicked = false;
	

    if(ElementDisplayed(LoanClosureCash.GetValues)) {
	click(LoanClosureCash.GetValues);
	isClicked = true;

	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Click 'Get Value' button");
	Log.info("Step 01: Click 'Get Value' button");

	} else {
		ExtentTestManager.getTest().log(Status.FAIL, "'Get Values' button is not displayed");
		Log.error("'Get Values' button is not displayed");
	}

	Assert.assertTrue(isClicked, "Validation Failed: 'Get Values' button was not clicked successfully.");

	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Value is calculated and displayed");
	Log.info("Expected Result: Value is calculated and displayed");

	ExtentTestManager.endTest();
	return true;

}

public boolean GetValuewithCashTransactionMode(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
		ExtentTestManager.startTest("TC:23 - Get Value with Cash Transaction Mode");
		Log.info("TC:23 - Get Value with Cash Transaction Mode");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement PayAmountField = driver.findElement(LoanClosureCash.PayAmount);
		js.executeScript("arguments[0].scrollIntoView(true);", PayAmountField);
		
		 try {
		        WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'closewarning']")));
		        if (closePopup.isDisplayed()) {
		            closePopup.click();
		            ExtentTestManager.getTest().log(Status.PASS, "Popup was displayed and closed.");
		            Log.info("Popup was displayed and closed.");
		        }
		    } catch (Exception e) {
		        ExtentTestManager.getTest().log(Status.INFO, "No popup displayed, continuing...");
		        Log.info("No popup displayed, continuing...");
		    }

		Thread.sleep(2000);
		
		if (ElementDisplayed(LoanClosureCash.TransModeCash)) {
		click(LoanClosureCash.TransModeCash);

		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Trans.mode'as Transfer.");
		Log.info("Step 01: Select 'Trans.mode'as Transfer.");	


		WebElement Options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl']/option[3]")));
		Options.click();
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer transmode  is accepted");
		Log.info("Expected Result: Transfer transmode  is accepted");
	}
	
		ExtentTestManager.endTest();
		return true;
}

public boolean EnterRemarksandSelectClosureType(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:24 - Enter Remarks and Select Closure Type");
	Log.info("TC:24 - Enter Remarks and Select Closure Type");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement EnterRemarkvalue = driver.findElement(LoanClosureCash.CashRemarks);

	click(LoanClosureCash.CashRemarks);
	String EnterRemark = testdata.get("Remark").toString();
	input(LoanClosureCash.CashRemarks, EnterRemark);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter remarks in the 'Remarks' field");
	Log.info("Step:01 - Enter remarks in the 'Remarks' field");
	
    Assert.assertFalse(EnterRemark.isEmpty(), "Validation Failed: Enter Remark should not be empty.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks are noted.");
	Log.info("Expected Result: Remarks are noted.");

	ExtentTestManager.endTest();
	return true;

}

public boolean POSTDEBITpopupispresent(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:25 - POST DEBIT popup is present");
	Log.info("TC:25 - POST DEBIT popup is present");
	
	WebElement PostDebitTab = driver.findElement(LoanClosureCash.PostDebit);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", PostDebitTab);
	
	click(LoanClosureCash.PostDebit);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on 'Post Debit' Popup");
	Log.info("Step 1: Click on 'Post Debit' Popup");
	
	String mainWindowHandle = driver.getWindowHandle();
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
	
	ExtentTestManager.startTest("TC:26 - POST DEBIT popup is present");
	Log.info("TC:26 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.TransactionBased)) {
	click(LoanClosureCash.TransactionBased);
	WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlTrnsBased_ddl']/option[1]")));
	options.click();
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Account  from the 'Transaciton Based' drop down");
	Log.info("Step 1: Select Account  from the 'Transaciton Based' drop down");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ProductGroupDropdown), "Validation Failed: Transaction Based field should not be displayed");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account selected from the 'Transaciton Based' drop down");
	Log.info("Expected Result: Account selected from the 'Transaciton Based' drop down");
	
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean PostDebitPopUpProductGroupDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:27 - POST DEBIT popup is present");
	Log.info("TC:27 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.ProductGroupDropdown)) {
		click(LoanClosureCash.ProductGroupDropdown);
		WebElement ProductGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'ddlProductGroup_ddl']/option[4]")));
		ProductGroup.click();
	
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select Demand Investment from the 'Product group' drop down");
		Log.info("Step 1: Select Demand Investment from the 'Product group' drop down");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.ProductNameDropdown), "Validation Failed: Product Group dropdown should not be displayed");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected");
		Log.info("Expected Result: Demand Investment is selected");
		}
	
		
	ExtentTestManager.endTest();
	return true;

}

public boolean PostDebitPopUpProductNameDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:28 - POST DEBIT popup is present");
	Log.info("TC:28 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.ProductNameDropdown)) {
		click(LoanClosureCash.ProductNameDropdown);
		WebElement ProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlProductName_ddl']/option[2]")));
		ProductName.click();
	
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select item from the 'Product Name' drop down");
		Log.info("Step 1: Select item from the 'Product Name' drop down");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.BranchName), "Validation Failed: Product Name dropdown should not be displayed");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
		Log.info("Expected Result: Product name item  is selected ");
		}	

	ExtentTestManager.endTest();
	return true;

}

	public boolean PostDebitPopUpBranchDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:29 - POST DEBIT popup is present");
	Log.info("TC:29 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.BranchName)) {
		click(LoanClosureCash.BranchName);
		WebElement BranchName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ddlBranch_ddl']/option[3]")));
		BranchName.click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select an a branch  from the 'Branch  'drop down'");
		Log.info("Step 1: Select an a branch  from the 'Branch  'drop down'");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.AccountNum), "Validation Failed: Branch dropdown should not be displayed");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed");
		Log.info("Expected Result: Popup window will be closed");
		}	
		
	ExtentTestManager.endTest();
	return true;

}

	public boolean PostDebitPopUpAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:30 - POST DEBIT popup is present");
	Log.info("TC:30 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.AccountNum)) {
		click(LoanClosureCash.AccountNum);
		
		WebElement AccountNumber = driver.findElement(LoanClosureCash.AccountNum);
		String EnterAccountNumber = testdata.get("Account_Number").toString();
		
		input(LoanClosureCash.AccountNum, EnterAccountNumber);
		AccountNumber.sendKeys(Keys.TAB);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Tick mark and select an account from the list of accounts displayed");
		Log.info("Step 1: Tick mark and select an account from the list of accounts displayed");
		
		WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(LoanClosureCash.AmountField));
        Assert.assertTrue(ElementDisplayed(LoanClosureCash.AmountField), "Validation Failed: Amount field is not displayed after entering Account Number.");
    } else {
        Log.error("Account Number field is not displayed.");
        return false;
    }
			
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account  is selected ");
		Log.info("Expected Result: Account  is selected ");
		

	ExtentTestManager.endTest();
	return true;

}
	
public boolean PostDebitPopUpEnterAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
	ExtentTestManager.startTest("TC:31 - POST DEBIT popup is present");
	Log.info("TC:31 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String transAmount = "";

    WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(LoanClosureCash.AmountField));
    Assert.assertTrue(ElementDisplayed(LoanClosureCash.AmountField), "Validation Failed: Amount field is not visible.");

    try {
        WebElement totalCredDebitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoanClosureCash.TotCredDebit));

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

    ExtentTestManager.getTest().log(Status.PASS, "Step 2: Entered Amount in the Amount field.");
    Log.info("Step 2: Entered Amount in the Amount field.");

    String enteredValue = (String) js.executeScript("return arguments[0].value;", amountField);
    Assert.assertEquals(enteredValue, transAmount, "Validation Failed: Entered amount does not match the captured amount.");

    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount is entered correctly.");
    Log.info("Expected Result: Amount is entered correctly.");

    ExtentTestManager.endTest();
    return true;
}

		
public boolean PostDebitPopUpAddDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
		ExtentTestManager.startTest("TC:32 - POST DEBIT popup is present");
		Log.info("TC:32 - POST DEBIT popup is present");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		if(ElementDisplayed(LoanClosureCash.AddButton)) {
			click(LoanClosureCash.AddButton);

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the ADD button ");
			Log.info("Step 1: Click on the ADD button ");
			
			Assert.assertTrue(ElementDisplayed(LoanClosureCash.SubButton), "Validation Failed: Account Number is not displayed");
	
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data gets inserted in the grid below");
			Log.info("Expected Result: Data gets inserted in the grid below");
			}

	ExtentTestManager.endTest();
		return true;
}

public boolean PostDebitPopUpSubmitDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, TimeoutException{
	
	ExtentTestManager.startTest("TC:33 - POST DEBIT popup is present");
	Log.info("TC:33 - POST DEBIT popup is present");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	if(ElementDisplayed(LoanClosureCash.SubButton)) {
		click(LoanClosureCash.SubButton);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on the SUBMIT button ");
		Log.info("Step 1: Click on the SUBMIT button ");
		
		WebDriverWait waitForWindowClose = new WebDriverWait(driver, 15);
		waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));
		
		driver.switchTo().window(mainWindowHandle);

		int windowCount = driver.getWindowHandles().size();
	    Assert.assertEquals(windowCount, 1, "Validation Failed: Popup did not close as expected");
	
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup gets closed  ");
	    Log.info("Expected Result: Popup gets closed");
	    }

	ExtentTestManager.endTest();
	return true;

}
	
public boolean PostDebitSubmitAccountClosure() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:34 - Submit Account Closure");
	Log.info("TC:34 - Submit Account Closure");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement SubmitDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", SubmitDetails);
	
	if(ElementDisplayed(LoanClosureCash.SubmitButon)){
	click(LoanClosureCash.SubmitButon);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Submit' button for closure process");
	Log.info("Step:01 - Click 'Submit' button for closure process");
	
	WebDriverWait waitForWindowClose = new WebDriverWait(driver, 10);
    waitForWindowClose.until(ExpectedConditions.numberOfWindowsToBe(1));

	int windowCount = driver.getWindowHandles().size();
    Assert.assertEquals(windowCount, 1, "Validation Failed: Security Details popup window is still open.");
			
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details popup window is closed");
	Log.info("Expected Result: Security details popup window is closed");
	}
	if(ElementDisplayed(LoanClosureCash.SummaryOperation)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary will be generated");
		Log.info("Expected Result: Summary will be generated");
		}
	else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	transIdTransferLoan = driver.findElement(LoanClosureCash.TransCashID).getText();
	
	ExtentTestManager.endTest();
	return true;
	
	}

public boolean LogintoNBFcApplicationinadifferentuser() throws InterruptedException, IOException{
	
		ExtentTestManager.startTest("TC:35 - Login to NBFc Application in a different user");
		Log.info("TC:35 - Login to NBFc Application in a different user");
		
		ExtentTestManager.startTest("Logout");
		Log.info("Logout");
		
		Thread.sleep(2000);
		
		click(LoanClosureCash.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
		Log.info("Step:01 -  Click on 'Signout'");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.loginButton), "Validation Failed: User is not logged out successfully.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
		Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		
		String UserName1 = configloader().getProperty("UserName2");
		input(LoanClosureCash.loginUserName, UserName1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");
				
		String Password1 = configloader().getProperty("Password2");
		input(LoanClosureCash.loginPasswrd, Password1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
		Log.info("Step:02 - Enter valid Password");
	
		click(LoanClosureCash.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Login as another user.");
		Log.info("Step:01 - Login as another user.");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.home), "Validation Failed: 'Home' button is not displayed.");

		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");				
				
		ExtentTestManager.endTest();
		return true;		
}

public boolean LogintoNBFcApplicationinadifferentuserAuthorizeandcancel() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:36 - Login to NBFc Application in a different user");
	Log.info("TC:36 - Login to NBFc Application in a different user");
	
	/*WebElement CashMode = driver.findElement(LoanClosureCash.AuthorizeCancel);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashMode);
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.AuthorizeCancel), "Validation Failed: 'Authorize & Cancel' option is not displayed.");*/
	
	click(LoanClosureCash.AuthorizeCancel);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	click(LoanClosureCash.ManagerAuthorization);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Manager Authorisation window.");
	Log.info("Step:02 - Select the Manager Authorisation window.");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ManagerAuthorization), "Validation Failed: Manager Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Manager Authorisation window opened successfully");
	Log.info("Expected Result:  Manager Authorisation window opened successfully");

ExtentTestManager.endTest();
return true;

}

public boolean ManagerAuthorisationTransfer() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:37 - Login to NBFc Application in a different user");
	Log.info("TC:37 - Login to NBFc Application in a different user");
	
	click(LoanClosureCash.TransferTab);
		
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
	
	ExtentTestManager.startTest("TC:38 - Login to NBFc Application in a different user");
	Log.info("TC:38 - Login to NBFc Application in a different user");
	
	click(LoanClosureCash.Refresh);
		
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
	
	ExtentTestManager.startTest("TC:39 - Login to NBFc Application in a different user");
	Log.info("TC:39 - Login to NBFc Application in a different user");
	
	System.out.println("transIdTransferLoan "+transIdTransferLoan);
	FetchwithTransID(transIdTransferLoan);
	
    WebElement checkbox = driver.findElement(LoanClosureCash.ManagerSelectCheckbox);
	
	if(ElementDisplayed(LoanClosureCash.ManagerSelectCheckbox)) {
	click(LoanClosureCash.ManagerSelectCheckbox);
		
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
	
	ExtentTestManager.startTest("TC:40 - Login to NBFc Application in a different user");
	Log.info("TC:40 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(LoanClosureCash.ManagerAuthorize)) {
	click(LoanClosureCash.ManagerAuthorize);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.ManagerAuthorize), "Validation Failed: 'Authorize' button is not Clicked.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
	Log.info("Expected Result: Transaction gets authorised");	
	
	click(LoanClosureCash.ClosePopup);
}
	ExtentTestManager.endTest();
	return true;	
}



		
	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
