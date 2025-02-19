package com.Page_Multiple_FixedDeposit;

import java.io.IOException;
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

public class Customer_MultipleFD_Opening_Transfer extends Base_Class {
	Pages_Multi_FD_Module multifd = new Pages_Multi_FD_Module();
	
	ScreenShot sc = new ScreenShot(null);

//Customer Login Window
	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:01 - Login to NBFC Application");
		Log.info("TC_01 - Login to NBFC Application");

		// String loginUserName = testdata.get("loginUserName").toString();
		String UserName = configloader().getProperty("UserName");
		input(multifd.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		// String loginValidPassword = testdata.get("loginValidPassword").toString();
		String Password = configloader().getProperty("Password");
		input(multifd.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
		Log.info("Step:02 - Enetered valid Password");

		click(multifd.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");

		try {
			ElementDisplayed(multifd.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		} catch (Exception e) {
			ElementDisplayed(multifd.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS,
					"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(multifd.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			// String loginUserName = testdata.get("loginUserName").toString();
			input(multifd.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			// String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(multifd.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(multifd.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(multifd.home);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}

		ElementDisplayed(multifd.home);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
		ExtentTestManager.endTest();

		return true;
	}

	public boolean DepositOpeningWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Access to Deposit Opening Window");
		Log.info("TC:02 - Access to Deposit Opening Window");

		try {

			click(multifd.AccOpening);
			click(multifd.DepositOpening);
			click(multifd.FixedDeposit);
			click(multifd.FixedType2Years);

			ExtentTestManager.getTest().log(Status.PASS,
					"Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");
			Log.info("Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");

			boolean isDashboardVisible = ElementDisplayed(multifd.FixedType2Years);

			Assert.assertTrue(isDashboardVisible, "Validation Failed: Deposit opening window is NOT displayed.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit opening window is displayed");
			Log.info("Expected Result: Deposit opening window is displayed");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred while accessing Deposit Opening Window: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;

	}

	public boolean customerSearchandSelectionWindow(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("TC:03 - Customer Search and Selection");
		Log.info("TC:03 - Customer Search and Selection");

		click(multifd.custSrch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Customer Search' button");
		Log.info("Step:01 - Click 'Customer Search' button");

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		if (testdata.get("CustomerName") != null) {
			String CustomerName = testdata.get("CustomerName").toString();
			input(multifd.custName1, CustomerName);
		} else {
			throw new IllegalArgumentException("CustomerName is missing in the test data.");
		}

		click(multifd.SearchBtn);
		click(multifd.SelectCust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Customer from Search Popup.");
		Log.info("Step:02 - Select Customer from Search Popup");

		driver.switchTo().window(mainWindowHandle);
		Log.info("Switched back to the main window.");

		click(multifd.AddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click 'Add' Button");
		Log.info("Step:03 - Click 'Add' Button");

		if (ElementDisplayed(multifd.OkBtn)) {
			click(multifd.OkBtn);
			Log.info("Clicked on OK button after adding the customer.");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Selected customer details populate necessary fields");
			Log.info("Expected Result: Selected customer details populate necessary fields");

		}

		ExtentTestManager.endTest();
		return true;

	}

	public boolean EnterAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:04 - Enter Amount");
		Log.info("TC:04 - Enter Amount");

		click(multifd.Amount);
		String EnterAmount = testdata.get("Amount").toString();
		input(multifd.Amount, EnterAmount);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the Amount in the 'Amount' Field");
		Log.info("Step:01 - Enter the Amount in the 'Amount' Field");

		if (ElementDisplayed(multifd.Amount)) {
			click(multifd.Amount);

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Possible to Enter the Amount");
			Log.info("Expected Result:Possible to Enter the Amount");

		}

		ExtentTestManager.endTest();
		return true;

	}

	public boolean EnterValidDuration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:05 - Enter Valid Duration");
		Log.info("TC:05 - Enter Valid Duration");

		String ValidDuration = testdata.get("Duration").toString();
		input(multifd.DurationNum, ValidDuration);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Duration eg: 12");
		Log.info("Step:01 - Enter Valid Duration eg: 12");

		click(multifd.DurationDropDown);
		WebElement DurationDropDown = driver.findElement(By.xpath(
				"//select [@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl']"));
		Select dropdown = new Select(DurationDropDown);
		dropdown.selectByVisibleText("MONTHS");

		String selectedOption = dropdown.getFirstSelectedOption().getText();

		Assert.assertEquals(selectedOption, "MONTHS",
				"Validation Failed: The selected duration mode should be 'MONTHS'.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");
		Log.info(
				"Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");

		ExtentTestManager.endTest();
		return true;

	}

	public boolean SelectReferral() throws InterruptedException {
		ExtentTestManager.startTest("TC:06 - Select Referral");
		Log.info("TC:06 - Select Referral");

		if (ElementDisplayed(multifd.ReferedBy)) {
			click(multifd.ReferedBy);

			ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Referred by' from dropdown");
			Log.info("Step 01: Select 'Referred by' from dropdown");

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement option = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='NITHIN']")));
			option.click();

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Referral is successfully selected");
			Log.info("Expected Result: Referral is successfully selected");

		}
		ExtentTestManager.endTest();
		return true;
	}

	public boolean ROIandDueDateCalculation() throws InterruptedException {

		ExtentTestManager.startTest("TC:07 - ROI and Due Date Calculation");
		Log.info("TC:07 - ROI and Due Date Calculation");

		boolean isClicked = false;

		if (ElementDisplayed(multifd.GetValues)) {
			click(multifd.GetValues);
			isClicked = true;

			ExtentTestManager.getTest().log(Status.PASS, "Step 01: Click 'Get Values' button");
			Log.info("Step 01: Click 'Get Values' button");

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "'Get Values' button is not displayed");
			Log.error("'Get Values' button is not displayed");
		}

		Assert.assertTrue(isClicked, "Validation Failed: 'Get Values' button was not clicked successfully.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: ROI and Due date are auto-calculated and displayed");
		Log.info("Expected Result: ROI and Due date are auto-calculated and displayed");

		ExtentTestManager.endTest();
		return true;

	}

	public boolean LedgerandFolioNo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:08 - Ledger & Folio Number Entry");
		Log.info("TC:08 - Ledger & Folio Number Entry");

		click(multifd.LedgerNum);

		String EnterLedgerNum = testdata.get("LedgerNumber").toString();
		input(multifd.LedgerNum, EnterLedgerNum);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the Folio number");
		Log.info("Step:01 - Enter the Folio number");

		click(multifd.FolioNum);
		String EnterFolioNum = testdata.get("FolioNumber").toString();
		input(multifd.FolioNum, EnterFolioNum);

		Assert.assertTrue(ElementDisplayed(multifd.FolioNum), "Validation Failed: Folio number is not entered.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Folio number is entered.");
		Log.info("Expected Result: Folio number is entered.");

		ExtentTestManager.endTest();
		return true;
	}

	public boolean Remark(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:09 - Remark Field Entry");
		Log.info("TC:09 - Remark Field Entry");

		click(multifd.Remark);

		String EnterRemark = testdata.get("Remark").toString();
		input(multifd.Remark, EnterRemark);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter remark in Remark Field.");
		Log.info("Step:01 - Enter remark in Remark Field.");

		Assert.assertTrue(ElementDisplayed(multifd.Remark), "Validation Failed: Remark is not entered.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark is entered.");
		Log.info("Expected Result: Remark is entered.");

		ExtentTestManager.endTest();
		return true;
	}

	public boolean clickLienMarkCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC:10 - Lien Mark Interaction");
		Log.info("TC:10 - Lien Mark Interaction");

		try {

			WebElement LienCheckbox = driver.findElement(By.xpath(
					"//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_chkIsLienMark']"));

			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Make a tick on the 'Lien Mark' checkbox");
			Log.info("Step:01 - Make a tick on the 'Lien Mark' checkbox");

			if (!LienCheckbox.isSelected()) {
				LienCheckbox.click();

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result : Tick is added");
				Log.info("Expected Result : Tick is added");
			} else {
				ExtentTestManager.getTest().log(Status.INFO, "Tick is already selected.");
				Log.info("Tick is already selected.");
			}

			Assert.assertTrue(LienCheckbox.isSelected(), "Validation Failed: Checkbox is not selected.");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;
	}

	public boolean EnterLienAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:11 - Lien Mark Interaction");
		Log.info("TC:11 - Lien Mark Interaction");

		click(multifd.LienAmount);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter lien amount");
		Log.info("Step:01 - Enter lien amount");

		String EnterLienAmount = testdata.get("LienAmount").toString();
		input(multifd.LienAmount, EnterLienAmount);

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter amount less than the depost amount.");
		Log.info("Step:02 - Enter amount less than the depost amount.");

		Assert.assertTrue(ElementDisplayed(multifd.LienAmount), "Validation Failed: Lien Amount is not entered.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Lien Amount is entered.");
		Log.info("Expected Result: Lien Amount is entered.");

		ExtentTestManager.endTest();
		return true;

	}

	public boolean EnterLienRemark(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:12 - Lien Mark Interaction");
		Log.info("TC:12 - Lien Mark Interaction");

		click(multifd.LienRemark);
		String EnterLienRemark = testdata.get("LienRemark").toString();
		input(multifd.LienRemark, EnterLienRemark);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter value in the Lien Remar field");
		Log.info("Step:01 - Enter value in the Lien Remar field");

		Assert.assertTrue(ElementDisplayed(multifd.LienRemark), "Validation Failed: Lien Remark is not entered.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Lien Remark is entered.");
		Log.info("Expected Result: Lien Remark is entered.");

		ExtentTestManager.endTest();
		return true;

	}

	public boolean NextButtonNavigation() throws InterruptedException {

		ExtentTestManager.startTest("TC:13 - Next Button Navigation");
		Log.info("TC:13 - Next Button Navigation");

		WebElement nextButton = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnNext']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

		Thread.sleep(1000);

		click(multifd.NextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");

		boolean isNextPageVisible = ElementDisplayed(multifd.NextBtn);

		Assert.assertTrue(isNextPageVisible, "Validation Failed: Navigation to next section was not successful.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Navigate to next section successfully");
		Log.info("Expected Result: Navigate to next section successfully");

		ExtentTestManager.endTest();
		return true;
	}

	public boolean NomineeCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC:14 - Nominee Tab Display");
		Log.info("TC:14 - Nominee Tab Display");

		try {

			WebElement NomineeCheckbox = driver
					.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee']"));

			ExtentTestManager.getTest().log(Status.PASS,
					"Step:01 - Untick the checkbox for nominee not required field.");
			Log.info("Step:01 - Untick the checkbox for nominee not required field.");

			if (NomineeCheckbox.isSelected()) {
				NomineeCheckbox.click();

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result : 'Nominee details section is visible upon unticking the checkbox");
				Log.info("Expected Result : 'Nominee details section is visible upon unticking the checkbox");
			} else {
				ExtentTestManager.getTest().log(Status.INFO, "Tick is already selected.");
				Log.info("Tick is already selected.");
			}

			Assert.assertFalse(NomineeCheckbox.isSelected(), "Validation Failed: Checkbox is selected.");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;

	}

	public boolean EnterCustomerID() throws InterruptedException {

		ExtentTestManager.startTest("TC:15 - Enter customer ID in customer");
		Log.info("TC:15 - Enter customer ID in customer");

			click(multifd.SearchIcon);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Customer ID Search button.");
			Log.info("Step:01 - Click on the Customer ID Search button.");

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
		
			driver.close();
			
			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Search popoup is visible.");
			Log.info("Expected Result: Customer Search popoup is visible.");

		ExtentTestManager.endTest();
		return true;
	}

	public boolean CustomerID(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:16 - Enter customer ID in customer");
		Log.info("TC:16 - Enter customer ID in customer");

			click(multifd.SearchIcon);

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Name ");
			Log.info("Step:01 - Enter Name ");

			if (testdata.get("CustomerName") != null) {
				String CustomerName = testdata.get("CustomerName").toString();
				input(multifd.custName1, CustomerName);
			} else {
				throw new IllegalArgumentException("CustomerName is missing in the test data.");
			}

			click(multifd.SearchBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - click on search button");
			Log.info("Step:02 - click on search button");

			driver.close();
			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Customer is listing similar to the entered Customer name");
			Log.info("Expected Result: Customer is listing similar to the entered Customer name");


		ExtentTestManager.endTest();
		return true;
	}

	public boolean CustomerNomineeSearch(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("TC:17 - Customer Nominee Search");
		Log.info("TC:17 - Customer Nominee Search");

			click(multifd.SearchIcon);

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
			if (testdata.get("CustomerName") != null) {
				String CustomerName = testdata.get("CustomerName").toString();
				input(multifd.custName1, CustomerName);
			} else {
				throw new IllegalArgumentException("CustomerName is missing in the test data.");
			}

			click(multifd.SearchBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Search for nominee");
			Log.info("Step:01 -  Search for nominee");

			click(multifd.SelectCustName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a nominee from search results");
			Log.info("Step:02 - Select a nominee from search results");

			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details auto-fill upon selection");
			Log.info("Expected Result: Nominee details auto-fill upon selection");

		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean MandatoryNameField(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		
		ExtentTestManager.startTest("TC:18 - Mandatory 'Name' Field Validation in Nominee");
		Log.info("TC:18 - Mandatory 'Name' Field Validation in Nominee");
		
		WebElement NameField = driver.findElement(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomName_txt']"));
		String nameValue = NameField.getAttribute("value");
		
	    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Ensure 'Name' field is filled");
	    Log.info("Step:01 - Ensure 'Name' field is filled");
	    
	    Assert.assertTrue(!nameValue.isEmpty(), "Validation Failed: 'Name' field is empty.");

	    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Name' field must not be empty");
	    Log.info("Expected Result: 'Name' field must not be empty");

	    ExtentTestManager.endTest();
		return true;
	
	}
	
	public boolean RelationDropDown() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:19 - Relation Dropdown List Validation");
		Log.info("TC:19 - Relation Dropdown List Validation");
		
		if (ElementDisplayed(multifd.RelationDropdown)) {
			click(multifd.RelationDropdown);

			ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select a Relation from the Relation dropdown");
			Log.info("Step 01: Select a Relation from the Relation dropdown");

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement option = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomRelation_ddl']/option[5]")));
			option.click();
			
			Assert.assertTrue(true, "The relation should be successfully selected");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation is selected from the relation Dropdown list");
			Log.info("Expected Result: Relation is selected from the relation Dropdown list");

		}
		
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean MobileNumberAutoFilled() throws InterruptedException {
		
		ExtentTestManager.startTest("TC:20 - Mobile No Auto-fill in Nominee");
		Log.info("TC:20 - Mobile No Auto-fill in Nominee");
		
		WebElement MobileField = driver.findElement(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomMobileNo_txt']"));
		String MobileValue = MobileField.getAttribute("value");
		
	    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Check 'Mobile No' field");
	    Log.info("Step:01 - Check 'Mobile No' field");
	    
	    Assert.assertTrue(!MobileValue.isEmpty(), "Validation Failed: 'Mobile' field is empty.");

	    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Mobile number is auto-filled from customer details");
	    Log.info("Expected Result: Mobile number is auto-filled from customer details");

	ExtentTestManager.endTest();
	return true;
		
	}
	
	public boolean AddressAutofilled()throws InterruptedException {
		
		ExtentTestManager.startTest("TC:21 - Address Auto-fill in Nominee");
		Log.info("TC:21 - Address Auto-fill in Nominee");
		
		WebElement HouseName = driver.findElement(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomHouseName_txt']"));
		String HouseValue = HouseName.getAttribute("value");
		
		WebElement Residence = driver.findElement(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomResidence_txt']"));
		String ResidenceValue = Residence.getAttribute("value");
		
		WebElement District = driver.findElement(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomDistrict_ddl']"));
		String DistrictValue = District.getAttribute("value");
		
		WebElement Post = driver.findElement(By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomPost_ddl']"));
		String PostValue = Post.getAttribute("value");
		
				
	    ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Check 'House Name', 'Residence', 'District', 'Post' fields");
	    Log.info("Step:01 - Check 'House Name', 'Residence', 'District', 'Post' fields");
	    
	    Assert.assertFalse(HouseValue.isEmpty(), "Validation Failed: 'House Name' field is empty.");
	    Assert.assertFalse(ResidenceValue.isEmpty(), "Validation Failed: 'Residence' field is empty.");
	    Assert.assertFalse(DistrictValue.isEmpty(), "Validation Failed: 'District' field is empty.");
	    Assert.assertFalse(PostValue.isEmpty(), "Validation Failed: 'Post' field is empty.");

	    ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All address fields are auto-filled correctly");
	    Log.info("Expected Result: All address fields are auto-filled correctly");
		
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean DOBandAgeField() throws InterruptedException {
			
		ExtentTestManager.startTest("TC:22 - Date of Birth Details in Nominee");
		Log.info("TC:22 - Date of Birth Details in Nominee");
			
		WebElement DOB = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_dtDOB_txt']"));
		String DOBValue = DOB.getAttribute("value");
			
		WebElement Age = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomAge_txt']"));
		String AgeValue = Age.getAttribute("value");
														
		ExtentTestManager.getTest().log(Status.INFO, "Step:01 - Check 'DOB' and 'Age' fields");
		Log.info("Step:01 - Check 'DOB' and 'Age' fields");
		    
		Assert.assertFalse(DOBValue.isEmpty(), "Validation Failed: 'DOB' field is empty.");
		Assert.assertFalse(AgeValue.isEmpty(), "Validation Failed: 'Age' field is empty.");
		    
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DOB and Age are correctly populated and computed");
		Log.info("Expected Result: DOB and Age are correctly populated and computed");
		    
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean AddNomineeBtn() throws InterruptedException {
		
		ExtentTestManager.startTest("TC:23 - Add Nominee Details");
		Log.info("TC:23 - Add Nominee Details");
		
		if(ElementDisplayed(multifd.AddNomineeBtn)) {
			click(multifd.AddNomineeBtn);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add' button");
		Log.info("Step:01 - Click 'Add' button");

		boolean AddDetailsVisible = ElementDisplayed(multifd.AddNomineeBtn);

		Assert.assertTrue(AddDetailsVisible, "Validation Failed: Nominee details are not added successful.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details are added to the record");
		Log.info("Expected Result: Nominee details are added to the record");
		
		}
		
		ExtentTestManager.endTest();
		return true;
			
		}
		
	public boolean OperatorTabNavigation () throws InterruptedException {
		
		ExtentTestManager.startTest("TC:24 - Operator Tab Navigation");
		Log.info("TC:24 - Operator Tab Navigation");
		
		if(ElementDisplayed(multifd.NextButton)) {
			click(multifd.NextButton);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");
		

		boolean NextPageVisible = ElementDisplayed(multifd.NextButton);

		Assert.assertTrue(NextPageVisible, "Validation Failed: Operator Tab Navigation is not successful.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Operator tab is accessed");
		Log.info("Expected Result: Operator tab is accessed");
		
		}
		
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean OperatorCustomerID() throws InterruptedException {

		ExtentTestManager.startTest("TC:25 - Operator Search and Selection");
		Log.info("TC:25 - Operator Search and Selection");

			click(multifd.OperatorSearchIcon);

			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Search button aligned near to Customer ID Field.");
			Log.info("Step:01 - Click on the Search button aligned near to Customer ID Field.");
			
			 String mainWindowHandle = driver.getWindowHandle(); 
			 Set<String> allWindowHandles = driver.getWindowHandles();
			 
			  
			 for (String handle : allWindowHandles) { 
				 if(!handle.equals(mainWindowHandle)) {
			  driver.switchTo().window(handle); 
			  break;
			 } 
				 }
						
			driver.close();
			
			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");

			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Search popup page is opened.");
			Log.info("Expected Result: Customer Search popup page is opened.");
		

		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean OperatorCustomerIDSearch(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:26 - Enter customer ID in customer");
		Log.info("TC:26 - Enter customer ID in customer");

			click(multifd.OperatorSearchIcon);

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Name ");
			Log.info("Step:01 - Enter Name ");

			if (testdata.get("CustomerName") != null) {
				String CustomerName = testdata.get("CustomerName").toString();
				input(multifd.custName1, CustomerName);
			} else {
				throw new IllegalArgumentException("CustomerName is missing in the test data.");
			}

			click(multifd.SearchBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - click on search button");
			Log.info("Step:02 - click on search button");

			driver.close();
			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Customer is listing similar to the entered Customer name");
			Log.info("Expected Result: Customer is listing similar to the entered Customer name");


		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean OperatorCustomerIDSelection(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("TC:27 - Customer Nominee Search");
		Log.info("TC:27 - Customer Nominee Search");
		
			click(multifd.OperatorSearchIcon);

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
			if (testdata.get("CustomerName") != null) {
				String CustomerName = testdata.get("CustomerName").toString();
				input(multifd.custName1, CustomerName);
			} 
			else {
				throw new IllegalArgumentException("CustomerName is missing in the test data.");
			}

			click(multifd.SearchBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Search for nominee");
			Log.info("Step:01 -  Search for nominee");

			click(multifd.SelectCustName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a nominee from search results");
			Log.info("Step:02 - Select a nominee from search results");

			driver.switchTo().window(mainWindowHandle);
			Log.info("Switched back to the main window.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details auto-fill upon selection");
			Log.info("Expected Result: Nominee details auto-fill upon selection");

		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean OperatorRelationDesig(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("TC:28 - Operator Relation Entry");
		Log.info("TC:28 - Operator Relation Entry");
				
			click(multifd.RelationDesig);
			
			String EnterOperatorRelation = testdata.get("OperatorRelation").toString();
			input(multifd.RelationDesig, EnterOperatorRelation);

			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter relation in Relation Field.");
			Log.info("Step:01 - Enter relation in Relation Field.");

			Assert.assertTrue(ElementDisplayed(multifd.RelationDesig), "Validation Failed: Relation is not entered.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation is validly entered");
			Log.info("Expected Result: Relation is validly entered");

			ExtentTestManager.endTest();
			return true;
		}
	
	
	public boolean OperatorRemarkEntry(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("TC:29 - Operator Remark Entry");
		Log.info("TC:29 - Operator Remark Entry");
				
			click(multifd.OperatorRemark);
			
			String EnterOperatorRemark = testdata.get("OperatorRemark").toString();
			input(multifd.OperatorRemark, EnterOperatorRemark);

			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter remark in Remark Field.");
			Log.info("Step:01 - Enter remark in Remark Field.");

			Assert.assertTrue(ElementDisplayed(multifd.OperatorRemark), "Validation Failed: Remark is not entered.");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark is validly entered");
			Log.info("Expected Result: Remark is validly entered");

			ExtentTestManager.endTest();
			return true;
		}
	
public boolean AddOperatorBtn() throws InterruptedException {
		
		ExtentTestManager.startTest("TC:30 - Operator Details Addition");
		Log.info("TC:30 - Operator Details Addition");
		
		if(ElementDisplayed(multifd.OperatorAdd)) {
			click(multifd.OperatorAdd);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add' button");
		Log.info("Step:01 - Click 'Add' button");

		boolean AddOperatorDetailsVisible = ElementDisplayed(multifd.OperatorAdd);

		Assert.assertTrue(AddOperatorDetailsVisible, "Validation Failed: Operator details are not added successful.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Operator details are added to the record");
		Log.info("Expected Result: Operator details are added to the record");
		
		}
		
		ExtentTestManager.endTest();
		return true;
			
		}
		
	public boolean InterestTransferTabPresence() throws InterruptedException {
		
		ExtentTestManager.startTest("TC:31 - Interest Transfer Tab Presence");
		Log.info("TC:31 - Interest Transfer Tab Presence");
		
		if(ElementDisplayed(multifd.OperatorNext)) {
			click(multifd.OperatorNext);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");
		

		boolean NextPageNavigation = ElementDisplayed(multifd.OperatorNext);

		Assert.assertTrue(NextPageNavigation, "Validation Failed: Operator Tab Navigation is not successful.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Interest transfer tab is present");
		Log.info("Expected Result: Interest transfer tab is present");
		
		}
		
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean InterestTransferRequiredCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("TC:32 - Interest Transfer Requirements");
		Log.info("TC:32 - Interest Transfer Requirements");

		try {

			WebElement IntrestTransferCheckbox = driver
					.findElement(By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_chkStandInst']"));

			ExtentTestManager.getTest().log(Status.PASS,
					"Step:01 - Add a tick on the checkbox aligned to Interest Transfer Required");
			Log.info("Step:01 - Add a tick on the checkbox aligned to Interest Transfer Required");

			if (ElementDisplayed(multifd.IntrestTransferCheckbox)) {
			click(multifd.IntrestTransferCheckbox);

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result : Interest Transfer adding fields are visible on adding  a tick on the checkbox.");
				Log.info("Expected Result : Interest Transfer adding fields are visible on adding  a tick on the checkbox.");
			} 
			else {
				ExtentTestManager.getTest().log(Status.INFO, "Tick is already selected.");
				Log.info("Tick is already selected.");
			}

			Assert.assertTrue(IntrestTransferCheckbox.isSelected(), "Validation Failed: Checkbox is selected.");
		} 
		catch (Exception e) {
			
			ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
			Log.error("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
		}

		ExtentTestManager.endTest();
		return true;

	}
	
public boolean ProductDropdown(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
		ExtentTestManager.startTest("TC:33 - Interest Transfer Data Entry");
		Log.info("TC:33 - Interest Transfer Data Entry");
		
		if (ElementDisplayed(multifd.SelectProduct)) {
			click(multifd.SelectProduct);

			ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select a Product from the product Dropdown list. Eg: Suspense Liability");
			Log.info("Step 01: Select a Product from the product Dropdown list. Eg: Suspense Liability");
			

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement option = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[4]/div/div/table/tbody/tr[1]/td[4]/div/select/optgroup/option")));
			option.click();
			
			Assert.assertTrue(true, "The Product should be successfully selected");
			
			click(multifd.AccountNumber);
			
			WebElement accountNumberField = driver.findElement(multifd.AccountNumber);
			
			String EnterAccountNumber = testdata.get("Account No.").toString();
			input(multifd.AccountNumber, EnterAccountNumber);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter an account numbr Eg: 1");
			Log.info("Step:02 - Enter an account numbr Eg: 1");
		
				
			Assert.assertTrue(ElementDisplayed(multifd.AccountNumber), "Validation Failed: Acount Number is not entered.");
						
			accountNumberField.sendKeys(Keys.TAB);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on TAB button in the keyboard");
			Log.info("Step:03 - Click on TAB button in the keyboard");
			
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account Details is autoloaded.");
			Log.info("Expected Result: Account Details is autoloaded.");

		}
		
		ExtentTestManager.endTest();
		return true;
	}

public boolean EnterFrequency(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:34 - Interest Transfer Data Entry");
	Log.info("TC:34 - Interest Transfer Data Entry");
	
	
		click(multifd.Frequency);

		WebElement FrequencyField = driver.findElement(multifd.Frequency);
		
		String EnterFrequency = testdata.get("Frequency").toString();
		input(multifd.Frequency, EnterFrequency);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the Frequency as 1");
		Log.info("Step:01 - Enter the Frequency as 1");
	
			
		Assert.assertTrue(ElementDisplayed(multifd.Frequency), "Validation Failed: Frequency Field is not entered.");
					
		FrequencyField.sendKeys(Keys.TAB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on TAB button in the keyboard");
		Log.info("Step:02 - Click on TAB button in the keyboard");
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount,  Startdate and End date are autoloaded.");
		Log.info("Expected Result: Amount,  Startdate and End date are autoloaded.");

	ExtentTestManager.endTest();
	return true;
}

public boolean OnMaturityTabNavigation() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:35 - On Maturity Tab Navigation");
	Log.info("TC:35 - On Maturity Tab Navigation");
	
	if(ElementDisplayed(multifd.IntrestNextButton)) {
		click(multifd.IntrestNextButton);
		
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
	Log.info("Step:01 - Click 'Next' button");
	

	boolean OnMaturityNextPageNavigation = ElementDisplayed(multifd.IntrestNextButton);

	Assert.assertTrue(OnMaturityNextPageNavigation, "Validation Failed: Operator Tab Navigation is not successful.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'On Maturity' tab is present");
	Log.info("Expected Result: 'On Maturity' tab is present");
	
	}
	
	ExtentTestManager.endTest();
	return true;
}

public boolean MaturityActionSelection() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:36 - Maturity Action Selection");
	Log.info("TC:36 - Maturity Action Selection");
	
		WebElement KeepSameAccountCheckbox = driver
				.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpAutoRenewal_MATFM_rdbSameAccount']"));

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - select. 'Keep in same account'");
		Log.info("Step:01 - select. 'Keep in same account'");

		if (KeepSameAccountCheckbox.isSelected()) {
			KeepSameAccountCheckbox.click();

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result : clicked on the radio aligend against 'Keep in Same Account.'");
			Log.info("Expected Result : clicked on the radio aligend against 'Keep in Same Account.'");
		} 
		else {
			
			ExtentTestManager.getTest().log(Status.INFO, "Tick is already selected.");
			Log.info("Tick is already selected.");
		}

		Assert.assertTrue(KeepSameAccountCheckbox.isSelected(), "Validation Failed: Checkbox is selected.");

	ExtentTestManager.endTest();
	return true;
}

public boolean MultipleAccountCheckbox() throws InterruptedException {
	
	ExtentTestManager.startTest("TC:37 - Multiple Account Checkbox");
	Log.info("TC:37 - Multiple Account Checkbox");
	
	WebElement MultipleAccountCheckbox = driver.findElement(By.xpath("//input[@id ='chkIsMultipleAc']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", MultipleAccountCheckbox);

		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Make a tick on the checkbox aligned newar to 'Is Multiple A/C'");
		Log.info("Step:01 - Make a tick on the checkbox aligned newar to 'Is Multiple A/C'");

			MultipleAccountCheckbox.click();
			
			Assert.assertTrue(MultipleAccountCheckbox.isSelected(), "Validation Failed: Checkbox is selected.");
			
			ExtentTestManager.getTest().log(Status.INFO, "Tick is already selected.");
			Log.info("Tick is already selected.");

			ExtentTestManager.getTest().log(Status.PASS, "Text field is enabled on adding the Tick");
			Log.info("Expected Result : Text field is enabled on adding the Tcick");
		

	ExtentTestManager.endTest();
	return true;
}

public boolean IsMultipleAccount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:38 - Multiple Account Checkbox");
	Log.info("TC:38 - Multiple Account Checkbox");
	
	
		click(multifd.MutipleAccountText);

		WebElement MutipleAccountTxtField = driver.findElement(multifd.MutipleAccountText);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", MutipleAccountTxtField);

		Thread.sleep(1000);
		
		clear(multifd.MutipleAccountText);
		
		String EnterAccountNumber = testdata.get("IsMultipleAccountText").toString();
		input(multifd.MutipleAccountText, EnterAccountNumber);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 5 as the count visible on the Text box appered near to the Checbox");
		Log.info("Step:01 - Enter 5 as the count visible on the Text box appered near to the Checbox");
	
			
		Assert.assertTrue(ElementDisplayed(multifd.MutipleAccountText), "Validation Failed: Is Multiple Account Field is not entered.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 5 is entred Successfully.");
		Log.info("Expected Result: 5 is entred Successfully.");

	ExtentTestManager.endTest();
	return true;
}

public boolean FinalDepositConfiguration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:39 - Final Deposit Configuration");
	Log.info("TC:39 - Final Deposit Configuration");
	
	WebElement TransMode = driver.findElement(multifd.MutipleAccountText);

	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", TransMode);
	
	if (ElementDisplayed(multifd.TransMode)) {
		click(multifd.TransMode);

		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select 'Trans.mode'as Cash.");
		Log.info("Step 01: Select 'Trans.mode'as Cash.");
		

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement option = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[3]/div/select/option[2]")));
		option.click();
		
		Assert.assertTrue(true, "The Cash Mode should be successfully selected");
		
		Thread.sleep(1000);
		
		click(multifd.SaveBtn);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 02: click save");
		Log.info("Step 02: click save");
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit opening is saved, results in summary");
		Log.info("Expected Result: Deposit opening is saved, results in summary");

	
	}
	ExtentTestManager.endTest();
	return true;
}

	public boolean CashierAuthorization(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:40 - Cashier Authorization");
	Log.info("TC:40 - Cashier Authorization");
	
	ExtentTestManager.startTest("Logout");
	Log.info("Logout");
	
	Thread.sleep(2000);
	
	click(multifd.custSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
	Log.info("Step:01 -  Click on 'Signout'");
	
	Assert.assertTrue(ElementDisplayed(multifd.loginButton), "Validation Failed: User is not logged out successfully.");
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
	Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
	
			String loginNewUserName = testdata.get("LoginNewUserName").toString();
			input(multifd.loginUserName, loginNewUserName);
			
			String loginNewValidPassword = testdata.get("LoginNewPassword").toString();
			input(multifd.loginPasswrd, loginNewValidPassword);

			click(multifd.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Login as another user.");
			Log.info("Step:01 - Login as another user.");
			
			Thread.sleep(4000);
			
			WebElement CashMode = driver.findElement(multifd.AuthorizeCancel);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", CashMode);
			
			Assert.assertTrue(ElementDisplayed(multifd.AuthorizeCancel), "Validation Failed: 'Authorize & Cancel' option is not displayed.");
			
				click(multifd.AuthorizeCancel);
				click(multifd.CashAuthorisation);
				
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Navigate to Authorize&cancel -> Cashier authorization window.");
			Log.info("Step:02 - Navigate to Authorize&cancel -> Cashier authorization window.");
			
			Assert.assertTrue(ElementDisplayed(multifd.CashAuthorisation), "Validation Failed: Cashier authorization window did not open.");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cashier authorization window opens");
			Log.info("Expected Result: Cashier authorization window opens");
	
	ExtentTestManager.endTest();
	return true;
	
}

	public boolean CashierAuthorizationRefresh() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:41 - Cashier Authorization");
		Log.info("TC:41 - Cashier Authorization");
		
		click(multifd.Refresh);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Refresh' button.");
		Log.info("Step:01 - Click 'Refresh' button.");
		
		Assert.assertTrue(ElementDisplayed(multifd.Refresh), "Validation Failed: 'Refresh' button is not displayed.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry will be display");
		Log.info("Expected Result: Entry will be display");
			
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean CashierAuthorizationSelectCheckBox() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:42 - Cashier Authorization");
		Log.info("TC:42 - Cashier Authorization");
		
		if(ElementDisplayed(multifd.OpeningEntryCashCheckbox)) {
		click(multifd.OpeningEntryCashCheckbox);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select check box of opening entry.");
		Log.info("Step:01 -  Select check box of opening entry.");
		
		Assert.assertTrue(ElementDisplayed(multifd.OpeningEntryCashCheckbox), "Validation Failed: 'Checkbox' is not Selected.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the entry");
		Log.info("Expected Result: Possible to select the entry");
			
		}
		
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean CashierAuthorizationAuthorize() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:43 - Cashier Authorization");
		Log.info("TC:43 - Cashier Authorization");
		
		if(ElementDisplayed(multifd.CashAuthorizeBtn)) {
		click(multifd.CashAuthorizeBtn);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Authorize button");
		Log.info("Step:01 - Click Authorize button");
		
		Assert.assertTrue(ElementDisplayed(multifd.CashAuthorizeBtn), "Validation Failed: 'Authorize' button is not Clicked.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction is authorized by Cashier.");
		Log.info("Expected Result: Transaction is authorized by Cashier.");
			
		}
		
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean ManagerAuthorization() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:44 - Manager Authorization");
		Log.info("TC:44 - Manager Authorization");
		
		WebElement ManagerCashMode = driver.findElement(multifd.ManagerAuthorization);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ManagerCashMode);
		
		click(multifd.ManagerAuthorization);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Authorize&cancel -> Manager authorization window.");
		Log.info("Step:01 - Navigate to Authorize&cancel -> Manager authorization window.");
		
		Assert.assertTrue(ElementDisplayed(multifd.ManagerAuthorization), "Validation Failed: Manager authorization window not opens");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorization window opens");
		Log.info("Expected Result: Manager authorization window opens");	
			
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean ManagerAuthorizationRefresh() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:45 - Manager Authorization");
		Log.info("TC:45 - Manager Authorization");
		
		click(multifd.Refresh);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Refresh' button.");
		Log.info("Step:01 - Click 'Refresh' button.");
		
		Assert.assertTrue(ElementDisplayed(multifd.Refresh), "Validation Failed: 'Refresh' button is not displayed.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry will be display");
		Log.info("Expected Result: Entry will be display");
			
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean ManagerAuthorizationSelectCheckBox() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:46 - Manager Authorization");
		Log.info("TC:46 - Manager Authorization");
		
		if(ElementDisplayed(multifd.ManagerCheckBox)) {
		click(multifd.ManagerCheckBox);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction entry from the cash section.");
		Log.info("Step:01 - Select transaction entry from the cash section.");
		
		Assert.assertTrue(ElementDisplayed(multifd.ManagerCheckBox), "Validation Failed: Transaction entry from the cash section not selected.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the entry");
		Log.info("Expected Result: Possible to select the entry");
			
		}
		
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public boolean ManagerAuthorizationAuthorize() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:47 - Manager Authorization");
		Log.info("TC:47 - Manager Authorization");
		
		if(ElementDisplayed(multifd.ManagerAuthorizen)) {
		click(multifd.ManagerAuthorizen);
			
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Authorize button");
		Log.info("Step:01 - Click Authorize button");
		
		Assert.assertTrue(ElementDisplayed(multifd.ManagerAuthorizen), "Validation Failed: 'Authorize' button is not Clicked.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction is authorized by Manager.");
		Log.info("Expected Result: Transaction is authorized by Manager.");
		
		click(multifd.ClosePopup);
			
		}
		
		ExtentTestManager.endTest();
		return true;
		
	}
		
	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
