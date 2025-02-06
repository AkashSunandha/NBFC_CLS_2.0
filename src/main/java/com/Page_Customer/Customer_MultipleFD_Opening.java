package com.Page_Customer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
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
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");

		String loginValidPassword = testdata.get("loginValidPassword").toString();
		input(multifd.loginPasswrd, loginValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
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
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
		ExtentTestManager.endTest();

		return true;
	}

	public boolean DepositOpeningWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Access to Deposit Opening Window");
		// Thread.sleep(3000);
		click(multifd.AccOpening);
		click(multifd.DepositOpening);
		click(multifd.FixedDeposit);
		click(multifd.FixedType2Years);

		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");
		Log.info("Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");

		boolean flag = ElementDisplayed(multifd.FixedType2Years);

		if (flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Deposit opening window is displayed");
			Log.info("Deposit opening window is displayed");

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Deposit opening window is not displayed");
			Log.info("Deposit opening window is not displayed");
			Assert.assertEquals(flag, true, "Element is not displayed as expected");
		}
		ExtentTestManager.endTest();
		return true;

	}

	public boolean customerSearchandSelectionWindow(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:03 - Customer Search and Selection");

		click(multifd.custSrch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Customer Search' button");
		Log.info("Step:01 - Click 'Customer Search' button");

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle); // Switch to popup window
				break;
			}
		}
		// Thread.sleep(2000);

		String CustomerName = testdata.get("CustomerName").toString();
		input(multifd.custName1, CustomerName);

		// Thread.sleep(1000);

		click(multifd.SearchBtn);
		click(multifd.SelectCust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Customer from Search Popup.");
		Log.info("Step:02 - Select Customer from Search Popup");

		driver.switchTo().window(mainWindowHandle);

		click(multifd.AddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click 'Add' Button");
		Log.info("Step:03 - Click 'Add' Button");

		if (ElementDisplayed(multifd.OkBtn)) {
			click(multifd.OkBtn);
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Selected customer details populate necessary fields");
			Log.info("Expected Result: Selected customer details populate necessary fields");

		}

		ExtentTestManager.endTest();
		return true;
	}

	public boolean EnterValidDuration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("TC:04 - Enter Valid Duration"); // Duration

		String ValidDuration = testdata.get("Duration").toString();
		input(multifd.DurationNum, ValidDuration);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Duration eg: 12");
		Log.info("Step:01 - Enter Valid Duration eg: 12");

		click(multifd.DurationDropDown);
		WebElement DurationDropDown = driver.findElement(By.xpath(
				"//select [@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl']"));
		Select dropdown = new Select(DurationDropDown);
		dropdown.selectByVisibleText("MONTHS");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");
		Log.info(
				"Expected Result: 12 is entered in the Duration field, Month is seleced from the Duration Mode Dropdown list.");

		ExtentTestManager.endTest();
		return true;

	}

	public boolean SelectReferral() throws InterruptedException {
		ExtentTestManager.startTest("TC:05 - Select Referral");
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

	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
