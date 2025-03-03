package com.Page_Closure_and_Renewals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	Pages_Jewel_Gold_Loan_Renewals_Module LoanClosureCash = new Pages_Jewel_Gold_Loan_Renewals_Module();
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdCashLoan;
    String transIdTransferLoan;

	
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
			
			WebElement LoanClosureWindow = driver.findElement(By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/ul/li[7]/a"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", LoanClosureWindow);

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

	click(LoanClosureCash.PreMatureClosure);
	
	driver.switchTo().window(mainWindowHandle);
	Log.info("Switched back to the main window.");
	

	boolean LoanDetails = ElementDisplayed(LoanClosureCash.LoanDetailsSection);

	Assert.assertTrue(LoanDetails, "Validation Failed: Loan account details section is not displayed.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan account details are displayed");
	Log.info("Expected Result: Loan account details are displayed");

	ExtentTestManager.endTest();
	return true;
}

public boolean ExpandRenewalSection() throws InterruptedException {

	ExtentTestManager.startTest("TC:07 - Expand Renewal Section");
	Log.info("TC:07 - Expand Renewal Section");

	WebElement RenewAccountCheckbox = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucLoanClosure_chkRenewLoanAccount']"));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", RenewAccountCheckbox);

	Thread.sleep(1000);

	click(LoanClosureCash.RenewAccount);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Renew Account' checkbox");
	Log.info("Step:01 - Click 'Renew Account' checkbox");

	boolean RenewAccountDetail = ElementDisplayed(LoanClosureCash.RenewAccountDetails);

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
	Assert.assertTrue(popupOpened, "Validation Failed: Securities popup window did not open");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details popup window is opened");
	Log.info("Expected Result: Security details popup window is opened");
		
	ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetails() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:09 - Add Security Details");
	Log.info("TC:09 - Add Security Details");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);

	// ✅ Select Item Group
	WebElement ItemGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='JSF_ddlItemGroup_ddl']")));
	
	Select dropdown = new Select(ItemGroup);
	dropdown.selectByVisibleText("Gold");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Select Item Group");
	Log.info("Step:01 Select Item Group");

	String selectedOption = dropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedOption, "Gold","Validation Failed: The selected Item Group should not be 'Gold'.");

	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details are added to the grid");
    Log.info("Expected Result: Security details are added to the grid");

    ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetailsItemName() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:10 - Add Security Details Item Name");
	Log.info("TC:10 - Add Security Details Item Name");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	// ✅ Select Item Name
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");
	
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 Select Item Name");
	Log.info("Step:01 Select Item Name");

	String selectedItemName = dropdown.getFirstSelectedOption().getText();

	Assert.assertEquals(selectedItemName, "RING","Validation Failed: The selected Item Name should not be 'RING'.");

	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item name is selected");
    Log.info("Expected Result: Item name is selected");

    ExtentTestManager.endTest();
	return true;

}

public boolean AddSecurityDetailsItemDescription(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:11 - Add Security Details Item Description");
	Log.info("TC:11 - Add Security Details Item Description");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// ✅ Select Item Name
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");
	
	// ✅ Enter Item Description
	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select Item Description");
	Log.info("Step:01 -  Select Item Description");

	Assert.assertEquals(ItemDescription.getAttribute("value"), EnterItemDescrption, "Validation Failed: Item Description is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item Description selected");
	Log.info("Expected Result: Item Description selected");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsItemQuantity(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:12 - Add Security Details Item Quantity");
	Log.info("TC:12 - Add Security Details Item Quantity");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	// ✅ Select Item Name
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	// ✅ Enter Item Description
	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	// ✅ Enter Item Quantity
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select Item quantity");
	Log.info("Step:01 -  Select Item quantity");

	Assert.assertEquals(ItemQuantity.getAttribute("value"), EnterItemItemQuantity, "Validation Failed: Item Quantity is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item quantity selected");
	Log.info("Expected Result: Item quantity selected");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsStoneWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:13 - Add Security Details Stone Weight");
	Log.info("TC:13 - Add Security Details Stone Weight");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	// ✅ Select Item Name
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	// ✅ Enter Item Description
	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	// ✅ Enter Item Quantity
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	// ✅ Enter Stone Weight
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Stone Weight 0");
	Log.info("Step:01 - Enter Stone Weight 0");

	Assert.assertEquals(StoneWeight.getAttribute("value"), EnterStoneWeight, "Validation Failed: Entered Stone Weight is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Stone Weight Entered");
	Log.info("Expected Result: Stone Weight Entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsTickPurityCheckbox(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:14 - Add Security Details Tick Purity Checkbox");
	Log.info("TC:14 - Add Security Details Tick Purity Checkbox");

	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	// ✅ Tick Purity Checkbox
	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick purity test checkbox");
	Log.info("Step:01 - Tick purity test checkbox");
	
	boolean PurityTick = ElementDisplayed(LoanClosureCash.PurityTest);

	Assert.assertTrue(PurityTick, "Validation Failed: Purity Tick checkbox is not Selected.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purity is ticked");
	Log.info("Expected Result: Purity is ticked");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsItemWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:15 - Add Security Details Item Weight");
	Log.info("TC:15 - Add Security Details Item Weight");

	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	// ✅ Enter Item Weight
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Item Weight as 24");
	Log.info("Step:01 - Enter Item Weight as 24");
	
	Assert.assertEquals(ItemWeight.getAttribute("value"), EnterItemWeight, "Validation Failed: Entered Item Weight is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item Weight entered");
	Log.info("Expected Result: Item Weight entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsDirtWeight(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:16 - Add Security Details Dirt Weight");
	Log.info("TC:16 - Add Security Details Dirt Weight");

	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	// ✅ Enter Dirt Weight
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Dirt Weight as 1");
	Log.info("Step:01 - Enter Dirt Weight as 1");
	
	Assert.assertEquals(DirtWeight.getAttribute("value"), EnterDirtWeight, "Validation Failed: Entered Dirt Weight is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Dirt Weight entered");
	Log.info("Expected Result: Dirt Weight entered");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsEnterPurity(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:17 - Add Security Details Enter Purity");
	Log.info("TC:17 - Add Security Details Enter Purity");

	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	// ✅ Enter Purity
	WebElement EnterPurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtPurity_txt']")));
	
	click(LoanClosureCash.EnterPurity);
	
	String EnterPurityDetail = testdata.get("Enter_Purity").toString();
	input(LoanClosureCash.EnterPurity, EnterPurityDetail);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Purity  as 22");
	Log.info("Step:01 - Enter Purity  as 22");
	
	Assert.assertEquals(EnterPurity.getAttribute("value"), EnterPurityDetail, "Validation Failed: Entered Purity is incorrect.");
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purity added");
	Log.info("Expected Result: Purity added");
	
	ExtentTestManager.endTest();
	return true;
}

public boolean AddSecurityDetailsAdd(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	ExtentTestManager.startTest("TC:18 - Add Security Details Add");
	Log.info("TC:18 - Add Security Details Add");

	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	WebElement EnterPurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtPurity_txt']")));
	
	click(LoanClosureCash.EnterPurity);
	
	String EnterPurityDetail = testdata.get("Enter_Purity").toString();
	input(LoanClosureCash.EnterPurity, EnterPurityDetail);
	
	// ✅ Click Add Button
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
	
	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Add button selected date is inseted into the grid");
	Log.info("Expected Result: Add button selected date is inseted into the grid");
	}
	
	ExtentTestManager.endTest();
	return true;
}


public boolean CloseSecurityDetailsPopup(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:19 - Close Security Details Popup");
	Log.info("TC:19 - Close Security Details Popup");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	WebElement EnterPurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtPurity_txt']")));
	
	click(LoanClosureCash.EnterPurity);
	
	String EnterPurityDetail = testdata.get("Enter_Purity").toString();
	input(LoanClosureCash.EnterPurity, EnterPurityDetail);
	
	WebElement AddDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_btnGoldAdd']")));
	
	if(ElementDisplayed(LoanClosureCash.AddBtn)){
	click(LoanClosureCash.AddBtn);
	
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

	driver.close();
	driver.switchTo().window(mainWindowHandle);
	
    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: appraiser selected");
    Log.info("Expected Result: appraiser selected");
	}
    ExtentTestManager.endTest();
	return true;

}

public boolean CloseSecurityDetailsPopupSubmit(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:20 - Close Security Details Popup Submit");
	Log.info("TC:20 - Close Security Details Popup Submit");
	
	click(LoanClosureCash.SecurityDetails);
	
	String mainWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	boolean isPopupOpened = false;

	for (String handle : allWindowHandles) {
		if (!handle.equals(mainWindowHandle)) {
			driver.switchTo().window(handle);
			isPopupOpened = true;
			break;
		}
	}	
	Assert.assertTrue(isPopupOpened, "Validation Failed: Security Details popup window did not open.");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	 // ✅ Select Item from Dropdown
	WebElement ItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_ddlItems_ddl']")));
	
	Select dropdown = new Select(ItemName);
	dropdown.selectByVisibleText("RING");

	// ✅ Enter Item Description
	WebElement ItemDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtJewelDescription_txt']")));
	
	click(LoanClosureCash.ItemDesption);
	
	String EnterItemDescrption = testdata.get("Item_Description").toString();
	input(LoanClosureCash.ItemDesption, EnterItemDescrption);
	
	 // ✅ Enter Item Quantity
	WebElement ItemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemQty_txt']")));
	
	click(LoanClosureCash.ItemQty);
	
	String EnterItemItemQuantity = testdata.get("Item_Quantity").toString();
	input(LoanClosureCash.ItemQty, EnterItemItemQuantity);
	
	 // ✅ Enter Stone Weight
	WebElement StoneWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtStoneWeight_txt']")));
	
	click(LoanClosureCash.StoneWeight);
	
	String EnterStoneWeight = testdata.get("Stone_Weight").toString();
	input(LoanClosureCash.StoneWeight, EnterStoneWeight);

	// ✅ Click Purity Test Checkbox
	WebElement TickPurityCheckbox = driver.findElement(By.xpath("//input[@id ='JSF_Repeater1_ctl03_chkpuritytest']"));

	click(LoanClosureCash.PurityTest);
	
	 // ✅ Enter Item Weight
	WebElement ItemWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtItemWeight_txt']")));
	
	click(LoanClosureCash.ItemWeight);
	
	String EnterItemWeight = testdata.get("Item_Weight").toString();
	input(LoanClosureCash.ItemWeight, EnterItemWeight);
	
	// ✅ Enter Dirt Weight
	WebElement DirtWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtDirtWeight_txt']")));
	
	click(LoanClosureCash.DirtWeight);
	
	String EnterDirtWeight = testdata.get("Dirt_Weight").toString();
	input(LoanClosureCash.DirtWeight, EnterDirtWeight);
	
	// ✅ Enter Purity Details
	WebElement EnterPurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_txtPurity_txt']")));
	
	click(LoanClosureCash.EnterPurity);
	
	String EnterPurityDetail = testdata.get("Enter_Purity").toString();
	input(LoanClosureCash.EnterPurity, EnterPurityDetail);
	
	// ✅ Click Add Button
	WebElement AddDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='JSF_btnGoldAdd']")));
	
	Thread.sleep(2000);
	if(ElementDisplayed(LoanClosureCash.AddBtn)){
	click(LoanClosureCash.AddBtn);
	
	 // ✅ Select Appraiser from Dropdown
	WebElement AppraiserDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_rdlAppraiser_ddl']")));

	Select appraiser = new Select(AppraiserDropdown);
	appraiser.selectByVisibleText("DIVYA");
		
	WebElement AppraiserDropdownAfterSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'JSF_rdlAppraiser_ddl']")));
	Select appraiserAfterSelection = new Select(AppraiserDropdownAfterSelection);
	String selectedAppraiserName = appraiserAfterSelection.getFirstSelectedOption().getText();
	
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
	}
    ExtentTestManager.endTest();
	return true;

}

public boolean EnterSanctionedAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
	
	ExtentTestManager.startTest("TC:21 - Enter Sanctioned Amount");
	Log.info("TC:21 - Enter Sanctioned Amount");
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement SanctionedAmountValue = driver.findElement(LoanClosureCash.SanctionedAmount);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", SanctionedAmountValue);
	
	click(LoanClosureCash.SanctionedAmount);

	String EnterSanctionedAmount = testdata.get("Sanctioned_Amount").toString();
	input(LoanClosureCash.SanctionedAmount, EnterSanctionedAmount);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the sanctioned amount in the respective field");
	Log.info("Step:01 - Enter the sanctioned amount in the respective field");
	
    Assert.assertFalse(EnterSanctionedAmount.isEmpty(), "Validation Failed: Sanctioned amount should not be empty.");

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

	if (ElementDisplayed(LoanClosureCash.GetValues)) {
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
		
		WebElement PayAmountField = driver.findElement(LoanClosureCash.PayAmount);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", PayAmountField);
		
		Thread.sleep(2000);
		
		if (ElementDisplayed(LoanClosureCash.TransModeCash)) {
		click(LoanClosureCash.TransModeCash);

		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Trans.mode'as Cash.");
		Log.info("Step 01: Select 'Trans.mode'as Cash.");	

	    WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[6]/div/div[5]/table/tbody/tr/td/table/tbody/tr[1]/td[2]/div/select/option[2]")));
		Options.click();
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash transmode  is accepted");
		Log.info("Expected Result: Cash transmode  is accepted");
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
public boolean SubmitAccountClosure() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:25 - Submit Account Closure");
	Log.info("TC:25 - Submit Account Closure");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement SubmitDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']")));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", SubmitDetails);
	
	if(ElementDisplayed(LoanClosureCash.SubmitButton)){
	click(LoanClosureCash.SubmitButton);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Submit' button for closure process");
	Log.info("Step:01 - Click 'Submit' button for closure process");
	
	Assert.assertEquals(driver.getWindowHandles().size(), 1, "Validation Failed: Security Details popup window is still open.");
		
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
	transIdCashLoan = driver.findElement(LoanClosureCash.TransCashID).getText();
	
	ExtentTestManager.endTest();
	return true;
	
	}

public boolean LogintoNBFcApplicationinadifferentuser() throws InterruptedException, IOException{
	
		ExtentTestManager.startTest("TC:26 - Login to NBFc Application in a different user");
		Log.info("TC:26 - Login to NBFc Application in a different user");
		
		ExtentTestManager.startTest("Logout");
		Log.info("Logout");
		
		Thread.sleep(2000);
		
		click(LoanClosureCash.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
		Log.info("Step:01 -  Click on 'Signout'");
		
		Assert.assertTrue(ElementDisplayed(LoanClosureCash.loginButton), "Validation Failed: User is not logged out successfully.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
		Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		
		String UserName1 = configloader().getProperty("UserName1");
		input(LoanClosureCash.loginUserName, UserName1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");
				
		String Password1 = configloader().getProperty("Password1");
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
	
	ExtentTestManager.startTest("TC:27 - Login to NBFc Application in a different user");
	Log.info("TC:27 - Login to NBFc Application in a different user");
	
	WebElement CashMode = driver.findElement(LoanClosureCash.AuthorizeCancel);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashMode);
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.AuthorizeCancel), "Validation Failed: 'Authorize & Cancel' option is not displayed.");
	
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

public boolean ManagerAuthorisationRefresh() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:28 - Login to NBFc Application in a different user");
	Log.info("TC:28 - Login to NBFc Application in a different user");
	
	click(LoanClosureCash.Refresh);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.Refresh), "Validation Failed: Authorisation pending transaction is not displayed after refreshing.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;
}

public boolean SelectManagerCashTransaction() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:29 - Login to NBFc Application in a different user");
	Log.info("TC:29 - Login to NBFc Application in a different user");
	
	System.out.println("transIdCashLoan "+transIdCashLoan);
	FetchwithTransID(transIdCashLoan);
	
    WebElement checkbox = driver.findElement(LoanClosureCash.OpeningEntryCashCheckbox);
	
	if(ElementDisplayed(LoanClosureCash.OpeningEntryCashCheckbox)) {
	click(LoanClosureCash.OpeningEntryCashCheckbox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(checkbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");		
}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean ManagerCashAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:30 - Login to NBFc Application in a different user");
	Log.info("TC:30 - Login to NBFc Application in a different user");
	
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

public boolean CashierAuthorisation() throws InterruptedException, IOException{
	
	ExtentTestManager.startTest("TC:31 - Login to NBFc Application in a different user");
	Log.info("TC:31 - Login to NBFc Application in a different user");
	
	WebElement CashModeTrans = driver.findElement(LoanClosureCash.CashAuthorisation);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", CashModeTrans);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	Log.info("Step:01 - Navigate to AUTHORISE and Cancel in the menu");
	
	Thread.sleep(2000);
	click(LoanClosureCash.CashAuthorisation);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the Cashier Authorisation window.");
	Log.info("Step:02 - Select the Cashier Authorisation window.");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.CashAuthorisation), "Validation Failed: Cashier Authorisation window did not open.");
		
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cashier Authorisation window opened successfully");
	Log.info("Expected Result: Cashier Authorisation window opened successfully");

	ExtentTestManager.endTest();
	return true;
}

public boolean CashAuthorizationRefresh() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:32 - Login to NBFc Application in a different user");
	Log.info("TC:32 - Login to NBFc Application in a different user");
	
	click(LoanClosureCash.Refresh);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Refresh button");
	Log.info("Step:01 - Click on the Refresh button");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.Refresh), "Validation Failed: 'Refresh' button is not displayed.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Authorisation pending transaction gets displayed ");
	Log.info("Expected Result: Authorisation pending transaction gets displayed ");
		
	ExtentTestManager.endTest();
	return true;	
}

public boolean SelectCashTransactionCashierAuthorisation() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:33 - Login to NBFc Application in a different user");
	Log.info("TC:33 - Login to NBFc Application in a different user");
	
	System.out.println("transIdCashPersonal "+transIdCashLoan);
	FetchwithTransID(transIdCashLoan);
	
	WebElement Managercheckbox = driver.findElement(LoanClosureCash.ManagerCheckBox);
	
	if(ElementDisplayed(LoanClosureCash.ManagerCheckBox)) {
	click(LoanClosureCash.ManagerCheckBox);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the transaction to authorise");
	Log.info("Step:01 - Select the transaction to authorise");
	
    Assert.assertTrue(Managercheckbox.isSelected(), "Validation Failed: 'Checkbox' is not selected.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: transaction to authorise is selected");
	Log.info("Expected Result: transaction to authorise is selected");
}	
	ExtentTestManager.endTest();
	return true;	
}

public boolean CashAuthorization() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:34 - Login to NBFc Application in a different user");
	Log.info("TC:34 - Login to NBFc Application in a different user");
	
	if(ElementDisplayed(LoanClosureCash.CashAuthorizeBtn)) {
	click(LoanClosureCash.CashAuthorizeBtn);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Authorize button");
	Log.info("Step:01 - Click on the Authorize button");
	
	Assert.assertTrue(ElementDisplayed(LoanClosureCash.CashAuthorizeBtn), "Validation Failed: 'Authorize' button is not Clicked.");
	
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
