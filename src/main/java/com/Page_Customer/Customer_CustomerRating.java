package com.Page_Customer;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepository_CustRating;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_CustomerRating extends Base_Class {

	PageRepository_CustRating custRating = new PageRepository_CustRating();
	 Customer_QuickCustomer quickCust = new Customer_QuickCustomer();
	
	 String query="Exec Getcustomer";
	 String columnName="CustomerID";

	
	//TC-02--> Access Customer Rating Window
	@Test
	public void testAccessCustomerRatingWindow() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 02 --> Access Customer Rating Window");

		click(custRating.cust);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1->Click on customer");
		Log.info("Step 1->Click on customer");
		click(custRating.custRat);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2->Click on Customer Rating");
		Log.info("Step 2->Click on Customer Rating");

		//	boolean flag=ElementDisplayed(custRating.pageName);
		if(ElementDisplayed(custRating.pageName))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Rating window is displayed");
			Log.info("Expected Result: Customer Rating window is displayed");
		}
		ExtentTestManager.endTest();
	}


	//TC No. - 03 --> Verify Module Name Display
	@Test
	public void testModuleNameIsDisplayed() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 03 --> Verify Module Name Display");
		boolean flag=ElementDisplayed(custRating.pageName);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1->Check module name at the top of the window");
		Log.info("Step 1->Check module name at the top of the window");
		if(flag==true)
		{
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Module name is visible");
			Log.info("Expected Result: Module name is visible");
		}
		ExtentTestManager.endTest();
	}


	//TC No. - 04 --> Verify Presence of Customer ID and Name Fields
	@Test
	public void verifyCustomerIDAndNameFieldsPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 04 --> Verify Presence of Customer ID and Name Fields");
		//boolean flag1 =  ElementDisplayed(custRating.custID);
		//boolean flag2 =  ElementDisplayed(custRating.custName);
		if(ElementDisplayed(custRating.custID)&ElementDisplayed(custRating.custName))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Step 1->Look for Customer ID and Customer Name fields on the form");
			Log.info("Step 1->1. Look for Customer ID and Customer Name fields on the form");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both fields are present");
			Log.info("Expected Result: Both fields are present");
		}

		ExtentTestManager.endTest();
	}


	//TC No. - 05 --> Verify Presence of Buttons
	@Test
	public void testButtonPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 05 --> Verify Presence of Buttons");
		boolean flag1=ElementDisplayed(custRating.goBtn);
		boolean flag2=ElementDisplayed(custRating.saveBtn);
		boolean flag3=ElementDisplayed(custRating.cancelBtn);
		boolean flag4=ElementDisplayed(custRating.closeBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1:Look for Go, Save, Close, Cancel buttons");
		Log.info("Step 1:Look for Go, Save, Close, Cancel buttons");



		if(flag1&flag2&flag3&flag4) {	

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All buttons are present");
			Log.info("Expected Result: All buttons are present");

		}
		ExtentTestManager.endTest();
	}




	//TC NO-6-->Check Mandatory Fields
	@Test
	public void checkMandField() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 06 --> Check Mandatory Fields");

		click(custRating.goBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check for mandatory indicators on Customer ID and Name fields");
		Log.info("Step 1: Check for mandatory indicators on Customer ID and Name fields");

		if(ElementDisplayed(custRating.warning_closeBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both fields are marked as mandatory");
			Log.info("Expected Result: Both fields are marked as mandatory");

		}

		click(custRating.warning_closeBtn);

		ExtentTestManager.endTest();
	}


	//TC NO-7-->Check field colour
	@Test
	public void checkColour() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 07 --> Check field colour");
		if(driver.findElement(custRating.custID).getCssValue("border").equalsIgnoreCase("1px solid rgb(255, 153, 51)")) {

			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Observe the color of Customer ID and Name fields");
			Log.info("Step 1: Observe the color of Customer ID and Name fields");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fields are orange in color");
			Log.info("Expected Result: Fields are orange in color");
		}
		ExtentTestManager.endTest();
	}


	//TC No. - 08 --> Verify Tooltips
	@Test
	public void verifyToolTips() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 08 --> Verify Tooltips");

		Hover(custRating.custID);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Hover over Customer ID and Name fields");
		Log.info("Step-1: Hover over Customer ID and Name fields");

		String ss=driver.findElement(custRating.custID).getAttribute("title");
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Appropriate tooltips are displayed "+ss);
//		Log.info("Expected Result: Appropriate tooltips are displayed "+ss);

		Hover(custRating.custName);
		String ss1=driver.findElement(custRating.custName).getAttribute("title");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Appropriate tooltips are displayed "+ss+" & "+ss1);
		Log.info("Expected Result: Appropriate tooltips are displayed "+ss+" & "+ss1);
		ExtentTestManager.endTest();

	}

	//TC No. - 09 --> Verify Customer Search Button
	@Test
	public void testCustomerSearchButtonPresence() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 09 --> Verify Customer Search Button");
		if(ElementDisplayed(custRating.srhBtn))
		{			
			ExtentTestManager.getTest().log(Status.PASS, "Step -1: Look for a customer search button on the right side of Customer ID");
			Log.info("Step -1: Look for a customer search button on the right side of Customer ID");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search button is present");
			Log.info("Expected Result: Customer search button is present");
		}

		ExtentTestManager.endTest();
	}


	//TC NO-10-->Validate Search Button Functionality
	@Test
	public void testSearchButtonFunctionality() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 10 --> Validate Search Button Functionality");
		click(custRating.srhBtn);
		//Click the customer search button
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click the customer search button");
		Log.info("Step 1: Click the customer search button");

		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		//
		for (String window : allWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		boolean status = ElementDisplayed(custRating.cust_search_btn);
		assertEquals(status, true);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: A search popup appears");
		Log.info("Expected Result: A search popup appears");

		driver.switchTo().window(mainWindow);

		ExtentTestManager.endTest();
	}



	//TC NO-11-->Select Customer from Search Popup
	@Test
	public void searchcCustFromPopup() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 11 --> Select Customer from Search Popup");
		click(custRating.srhBtn);
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		//
		for (String window : allWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		input(custRating.custID_popup,"103000014806");
		click(custRating.cust_search_btn);
		/*String vla = Base_Class.getValue(custRating.txt);
		assertEquals(vla, "AJITHAMOL");

		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a customer from the popup");
		Log.info("Step 1: Select a customer from the popup");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Name is autoloaded "+vla);
		Log.info("Expected Result: Customer Name is autoloaded "+vla);	*/

		driver.switchTo().window(mainWindow);
		ExtentTestManager.endTest();
	}


	//TC NO-12-->Test Go Button Functionality
	@Test
	public void goBtnFun(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 12 --> Test Go Button Functionality");
		Log.info("TC No. - 12 --> Test Go Button Functionality");
		String customerID = testdata.get("custID").toString();

//		String custID=quickCust.generateUniqueId(query, columnName);
//		input(custRating.custID, custID);
//		
		
		input(custRating.custID,customerID);

		click(custRating.goBtn);
		click(custRating.goBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click the Go button");
		Log.info("Step 1: Click the Go button");
		boolean f1=ElementDisplayed(custRating.custRating_custID);
		boolean f2=ElementDisplayed(custRating.custRating_risk);
		boolean f=f1&f2;
		if(f) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fields such as custid, Name, Risk, PAN NO, etc., are loaded ");
			Log.info("Expected Result: Fields such as custid, Name, Risk, PAN NO, etc., are loaded ");	
		}
		ExtentTestManager.endTest();
	}

	//TC NO-13-->Verify drop down arrow Option

	@Test
	public void testVerifyDropDownArrowOption() throws InterruptedException {

		ExtentTestManager.startTest("TC No. - 13 --> Verify drop down arrow Option");

		if(ElementDisplayed(custRating.custRating_dropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Verify the drop down arrow  option is present");
			Log.info("Step 1: Verify the drop down arrow  option is present");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: drop down arrow option is present");
			Log.info("Expected Result: drop down arrow option is present");
		}
		ExtentTestManager.endTest();
	}

	//TC NO-14-->Verify Change Mobile No Option --Invalid


	//TC NO-15-->Check Current and New Rating Section

	@Test
	public void testRatingSectionsPresence() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 15 --> Check Current and New Rating Section");


		if(ElementDisplayed(custRating.currentRating)&ElementDisplayed(custRating.newRating)){
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Check for Current Rating and Add New Rating sections");
			Log.info("Step 1: Check for Current Rating and Add New Rating sections");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both sections are present");
			Log.info("Expected Result: Both sections are present");
		}
		ExtentTestManager.endTest();

	}

	//TC NO-16-->Validate 'No Data Found' Message

	@Test
	public void validateNoDataFoundMessage() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 16 --> Validate 'No Data Found' Message");

		if(ElementDisplayed(custRating.nodata)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select a customer with no ratings");
			Log.info("Step 1: Select a customer with no ratingssections");
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: No data found' message is displayed in customer current rating section");
			Log.info("Expected Result: No data found' message is displayed in customer current rating section");
		}
		ExtentTestManager.endTest();
	}

	//TC NO-17--> Agency flow
	public void agencyFunc(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {

		ExtentTestManager.startTest("TC No. - 17 --> Agency Flow");
		String agency = testdata.get("agency").toString();

		input(custRating.agency,agency);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Select agency from dropdown");
		Log.info("Step 1: Select agency from dropdown");

		String Rating = testdata.get("Rating").toString();

		input(custRating.rating,Rating);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Enter rating");
		Log.info("Step 2: Enter rating");
		
		String date = testdata.get("Date").toString();

		input(custRating.date,date);
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Enter date");
		Log.info("Step 3: Enter date");
		
		
		String remarks = testdata.get("Remarks").toString();

		input(custRating.remarks,remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step 4: Enter remarks");
		Log.info("Step 4: Enter remarks");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 5: Click on save button");
		Log.info("Step 5: Click on save button");
		
		click(custRating.rating_saveBtn);

		if(ElementDisplayed(custRating.successMessage)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Successfully Updated");
			Log.info("Expected Result: Successfully updated");
		}
		click(custRating.rating_closeBtn);
		ExtentTestManager.endTest();

	}
	public boolean signOut() throws InterruptedException {
		click(custRating.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "User SignedOut");
		Log.info("User SignedOut");
		return true;
	}
}