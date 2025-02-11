package com.Page_Customer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Multi_FD_Module;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_MultipleFD_Opening extends Base_Class {
	PageRepositary_Multi_FD_Module multifd = new PageRepositary_Multi_FD_Module();
	ScreenShot sc = new ScreenShot(null);

//Customer Login Window
	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:01 - Login to NBFC Application");
		Log.info("TC_01 - Login to NBFC Application");

		String loginUserName = testdata.get("loginUserName").toString();
		input(multifd.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		String loginValidPassword = testdata.get("loginValidPassword").toString();
		input(multifd.loginPasswrd, loginValidPassword);
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
			input(multifd.loginUserName, loginUserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			// String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(multifd.loginPasswrd, loginValidPassword);
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
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
		
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Deposit opening window is displayed");
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
		
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Selected customer details populate necessary fields");
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
			
		if(ElementDisplayed(multifd.Amount)) {
		click(multifd.Amount);
				
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result:Possible to Enter the Amount");
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
		WebElement DurationDropDown = driver.findElement(By.xpath("//select [@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl']"));
		Select dropdown = new Select(DurationDropDown);
		dropdown.selectByVisibleText("MONTHS");
		
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		
	    Assert.assertEquals(selectedOption, "MONTHS", "Validation Failed: The selected duration mode should be 'MONTHS'.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");
		Log.info("Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");

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
			WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='NITHIN']")));
			option.click();
				
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Referral is successfully selected");
			Log.info("Expected Result: Referral is successfully selected");

		}
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean ROIandDueDateCalculation() throws InterruptedException{
		
		ExtentTestManager.startTest("TC:07 - ROI and Due Date Calculation");
		Log.info("TC:07 - ROI and Due Date Calculation");
		
		boolean isClicked = false;
		
		if(ElementDisplayed(multifd.GetValues)) {
			click(multifd.GetValues);
			isClicked = true;
			
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Click 'Get Values' button");
		Log.info("Step 01: Click 'Get Values' button");
		
		} else {
	        ExtentTestManager.getTest().log(Status.FAIL, "'Get Values' button is not displayed");
	        Log.error("'Get Values' button is not displayed");
	    }
		
		Assert.assertTrue(isClicked, "Validation Failed: 'Get Values' button was not clicked successfully.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: ROI and Due date are auto-calculated and displayed");
		Log.info("Expected Result: ROI and Due date are auto-calculated and displayed");

		
		ExtentTestManager.endTest();
		return true;
		
	}
	
public boolean LedgerandFolioNo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
		
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
		 
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Folio number is entered.");
		Log.info("Expected Result: Folio number is entered.");
					
		ExtentTestManager.endTest();
		return true;
}

public boolean Remark(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:09 - Remark Field Entry");
	Log.info("TC:09 - Remark Field Entry");
	
	click(multifd.Remark);
	
	String EnterRemark = testdata.get("Remark").toString();
	input(multifd.Remark, EnterRemark);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter remark in Remark Field.");
	Log.info("Step:01 - Enter remark in Remark Field.");
		 
	Assert.assertTrue(ElementDisplayed(multifd.Remark), "Validation Failed: Remark is not entered.");
	 
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Remark is entered.");
	Log.info("Expected Result: Remark is entered.");
	 
	ExtentTestManager.endTest();
	return true;
}

public boolean clickLienMarkCheckbox() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:10 - Lien Mark Interaction");
	Log.info("TC:10 - Lien Mark Interaction");
	
	try {
	
	WebElement LienCheckbox = driver.findElement(By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_chkIsLienMark']"));

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
    }catch (Exception e) {
        ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
        Log.error("Exception occurred: " + e.getMessage());
        Assert.fail("Test failed due to an unexpected error.");
    }

	ExtentTestManager.endTest();
	return true;
}

public boolean EnterLienAmount(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
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
	 
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Lien Amount is entered.");
	Log.info("Expected Result: Lien Amount is entered.");
	
	ExtentTestManager.endTest();
	return true;
	
}

public boolean EnterLienRemark(Map<Object, Object> testdata, ITestContext context) throws InterruptedException{
	
	ExtentTestManager.startTest("TC:12 - Lien Mark Interaction");
	Log.info("TC:12 - Lien Mark Interaction");
	
	click(multifd.LienRemark);
	String EnterLienRemark = testdata.get("LienRemark").toString();
	input(multifd.LienRemark, EnterLienRemark);
	 	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter value in the Lien Remar field");
	Log.info("Step:01 - Enter value in the Lien Remar field");
	
	Assert.assertTrue(ElementDisplayed(multifd.LienRemark), "Validation Failed: Lien Remark is not entered.");
	 
	ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Lien Remark is entered.");
	Log.info("Expected Result: Lien Remark is entered.");
	
	ExtentTestManager.endTest();
	return true;
	
}

public boolean NextButtonNavigation() throws InterruptedException{
	
	ExtentTestManager.startTest("TC:13 - Next Button Navigation");
	Log.info("TC:13 - Next Button Navigation");
	//Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	Thread.sleep(3000);
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


	

	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
