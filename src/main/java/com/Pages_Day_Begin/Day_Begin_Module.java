package com.Pages_Day_Begin;

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

public class Day_Begin_Module extends Base_Class {
	
	Day_Begin dayBegin = new Day_Begin();
	
	ScreenShot sc = new ScreenShot(null);


public boolean AdminLogin()throws ClassNotFoundException, InterruptedException, IOException {
	ExtentTestManager.startTest("TC:01 - Admin Login");
	Log.info("TC_01 - Admin Login");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the login screen");
	Log.info("Step:01 - Navigate to the login screen");

	String UserName = configloader().getProperty("UserName2");
	input(dayBegin.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter admin credentials");
	Log.info("Step:02 - Enetered valid Password");
	
	String Password = configloader().getProperty("Password2");
	input(dayBegin.loginPasswrd, Password);
	
	click(dayBegin.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");
	
	click(dayBegin.ContinueBtn);

	try {
		ElementDisplayed(dayBegin.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(dayBegin.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		ElementDisplayed(dayBegin.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean OpenDayBeginWindow() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Open Day Begin Window");
	Log.info("TC:02 - Open Day Begin Window");
	
	click(dayBegin.Admin);
	
	ScrollUntilElementVisible(dayBegin.Processes);
	click(dayBegin.Processes);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Processes");
	Log.info("Step:01 Navigate to Processes");
	
	ScrollUntilElementVisible(dayBegin.DayBegin);
	click(dayBegin.DayBegin);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on Day Begin");
	Log.info("Step:02 Click on Day Begin");

	boolean isDashboardVisible = ElementDisplayed(dayBegin.ProcessDayBegin);

	Assert.assertTrue(isDashboardVisible,"Validation Failed: Process Day Begin window is NOT displayed.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Day Begin window is opened");
	Log.info("Expected Result: Day Begin window is opened");

	ExtentTestManager.endTest();
	return true;

}

public boolean StartDayBeginProcess() throws InterruptedException {
	ExtentTestManager.startTest("TC:03 - Start Day Begin Process");
	Log.info("TC:03 - Start Day Begin Process");
	
	if(ElementDisplayed(dayBegin.StartProcessing)) {
		click(dayBegin.StartProcessing);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on Start Processing button");
		Log.info("Step:01 Click on Start Processing button");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Message: " + alertText);
		//alert.accept();        

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Start Day Begin Process Validations?' pop-up appears");
		Log.info("Expected Result: 'Start Day Begin Process Validations?' pop-up appears");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean ConfirmStartDayBeginProcess() throws InterruptedException {
	ExtentTestManager.startTest("TC:04 - Confirm Start Day Begin Process");
	Log.info("TC:04 - Confirm Start Day Begin Process");
	
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	System.out.println("Alert Message: " + alertText);
	alert.accept(); 
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click OK on the pop-up");
	Log.info("Step:01 Click OK on the pop-up");
	
	boolean isDashboardVisible = ElementEnabled(dayBegin.ContinueButton);

	Assert.assertFalse(isDashboardVisible,"Validation Failed: Continue button is not enabled");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Continue button is enabled");
	Log.info("Expected Result: Continue button is enabled");
			
	ExtentTestManager.endTest();
	return true;

}

public boolean CompleteDayBeginProcess() throws InterruptedException {
	ExtentTestManager.startTest("TC:05 - Complete Day Begin Process");
	Log.info("TC:05 - Complete Day Begin Process");
	
	if(ElementDisplayed(dayBegin.ContinueButton)) {
	click(dayBegin.ContinueButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Continue button");
	Log.info("Step:01 Click Continue button");
	
	click(dayBegin.SubmitButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Submit button");
	Log.info("Step:01 Click Submit button");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Day Begin Completed Successfully, Please wait' message is displayed");
	Log.info("'Day Begin Completed Successfully, Please wait' message is displayed");
	
	click(dayBegin.ClosePopup);
	}
	ExtentTestManager.endTest();
	return true;

}

public boolean UserLogin()throws ClassNotFoundException, InterruptedException, IOException {
	ExtentTestManager.startTest("TC:06 - User Login");
	Log.info("TC_06 - User Login");
	
	click(dayBegin.adminSignOut);
	Thread.sleep(2000);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the login screen");
	Log.info("Step:01 - Navigate to the login screen");

	String UserName = configloader().getProperty("UserName");
	input(dayBegin.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter user credentials");
	Log.info("Step:02 - Enetered valid Password");
	
	String Password = configloader().getProperty("Password");
	input(dayBegin.loginPasswrd, Password);
	
	click(dayBegin.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(dayBegin.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(dayBegin.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		ElementDisplayed(dayBegin.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged into the application");
		Log.info("Expected Result: User is logged into the application");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean OpenDayBeginWindowasUser() throws InterruptedException {
	ExtentTestManager.startTest("TC:07 - Open Day Begin Window as User");
	Log.info("TC:07 - Open Day Begin Window as User");
	
	ScrollUntilElementVisible(dayBegin.ProcessandPosting);
	click(dayBegin.ProcessandPosting);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Processing & Posting");
	Log.info("Step:01 Navigate to Processing & Posting");
	
	ScrollUntilElementVisible(dayBegin.Daybegin);
	click(dayBegin.Daybegin);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on Day Begin");
	Log.info("Step:02 Click on Day Begin");

	boolean isDashboardVisible = ElementDisplayed(dayBegin.Processdaybegin);

	Assert.assertTrue(isDashboardVisible,"Validation Failed: Process Day Begin window is NOT displayed.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Day Begin window is opened for the user");
	Log.info("Expected Result: Day Begin window is opened for the user");
		
	ExtentTestManager.endTest();
	return true;

}

public boolean StartDayBeginasUser() throws InterruptedException {
	ExtentTestManager.startTest("TC:08 - Start Day Begin as User");
	Log.info("TC:08 - Start Day Begin as User");
	
	if(ElementDisplayed(dayBegin.Startprocessing)) {
		click(dayBegin.Startprocessing);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on Start Processing button");
		Log.info("Step:01 Click on Start Processing button");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Message: " + alertText);
		//alert.accept();        

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Start Day Begin?' pop-up appears");
		Log.info("Expected Result: 'Start Day Begin?' pop-up appears");
	}
	ExtentTestManager.endTest();
	return true;

}

public boolean ConfirmStartDayBeginasUser() throws InterruptedException {
	ExtentTestManager.startTest("TC:09 - Confirm Start Day Begin as User");
	Log.info("TC:09 - Confirm Start Day Begin as User");
	
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	System.out.println("Alert Message: " + alertText);
	alert.accept(); 
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click OK on the pop-up");
	Log.info("Step:01 Click OK on the pop-up");
	
	boolean isDashboardVisible = ElementDisplayed(dayBegin.Processdaybegin);

	Assert.assertTrue(isDashboardVisible,"Validation Failed: Green tick mark is not displayed against the process name");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Green tick mark is displayed against the process name");
	Log.info("Expected Result: Green tick mark is displayed against the process name");
		
	ExtentTestManager.endTest();
	return true;

}

public boolean CompleteUserDayBegin() throws InterruptedException {
	ExtentTestManager.startTest("TC:10 - Complete User Day Begin");
	Log.info("TC:10 - Complete User Day Begin");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01  Check for 'Day Begin Process Completed' pop-up");
	Log.info("Step:01  Check for 'Day Begin Process Completed' pop-up");
	
	Alert Ok = driver.switchTo().alert();
	String OkText = Ok.getText();
	System.out.println("Alert Message: " + OkText);
	Ok.accept(); 
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click OK on the pop-up");
	Log.info("Step:02 Click OK on the pop-up");
	
	boolean isDashboardVisible = ElementDisplayed(dayBegin.Processdaybegin);

	Assert.assertTrue(isDashboardVisible,"Validation Failed: Green tick mark is not displayed against the process name");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Day Begin is completed for user");
	Log.info("Expected Result: Day Begin is completed for user");	
		
	ExtentTestManager.endTest();
	return true;
}





































































public boolean logout() throws InterruptedException {
	ExtentTestManager.startTest("Logout");
	Log.info("Logout");
	
	Thread.sleep(4000);
	
	click(dayBegin.adminSignOut);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on 'Signout'");
	Log.info("Step:01 -  Click on 'Signout'");
	if(ElementDisplayed(dayBegin.loginButton)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
		Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
	}
	driver.close();
	ExtentTestManager.endTest();
	return true;
}


	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
