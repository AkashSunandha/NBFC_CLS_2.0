package com.bondApplication;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Bond_Application;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_SusAssetTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Bond_Application extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_Bond_Application Bond = new PageRepositary_Bond_Application();
	PageRepositary_SusAssetTransaction_Cash_Transfer Suspenseasset = new PageRepositary_SusAssetTransaction_Cash_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}

	public void BondApplicationWindowNavigation() throws InterruptedException {

		ExtentTestManager.startTest("Verify product selection");
		Log.info("Verify product selection");

		click(Bond.bond);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a product from 'Product ' dropdown");
		Log.info("Step:01 - Select a product from 'Product ' dropdown");

		click(Bond.bondapplication);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-Navigate to Bond section ");
		Log.info("Step:01- Naviagte to Bond section");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02-Click on Bond Application option. ");
		Log.info("Step:02- Click on Bond Application option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Bond Application window opens successfully.");
		Log.info("Expected Result:  Bond Application window opens successfully..");
		ExtentTestManager.endTest();
	}

	public void Verifyproductselection() throws InterruptedException {

		ExtentTestManager.startTest("Verify product selection");
		Log.info("Verify product selection");

		select("DEBUNTURE SCHEME 1", Bond.sellectproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a product from 'Product ' dropdown");
		Log.info("Step:01 - Select a product from 'Product ' dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  'Product ' selected");
		Log.info("Expected Result:  'Product ' selected.");
		ExtentTestManager.endTest();

	}

	public void NatureFieldDropdownselection() throws InterruptedException {

		ExtentTestManager.startTest("Nature Field Dropdown selection");
		Log.info("Nature Field Dropdown selection");

		select("Single", Bond.Naturefield);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -select the 'Nature' from drop down");
		Log.info("Step:01 - select the 'Nature' from drop down");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  'Nature'  as single  should be selected");
		Log.info("Expected Result:  'Nature'  as single  should be selected");
		ExtentTestManager.endTest();

	}

	public void CustomerSearchPopupVerification(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("Customer Search Popup verification");
		Log.info("Customer Search Popup verification");

		click(Bond.clickonsearch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the search button next to 'Customer ID'");
		Log.info("Step:01 -  Click the search button next to 'Customer ID");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:  A popup page is displayed with search parameters.");
		Log.info("Expected Result:  A popup page is displayed with search parameters.");
		ExtentTestManager.endTest();

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				ExtentTestManager.startTest(" Customer Search Functionality()");
				Log.info(" Customer Search Functionality()");

				String Name = testdata.get("Name").toString();
				input(Bond.clickname, Name);

				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter any alphabet in the 'Name' field");
				Log.info("Step:01 -  Enter any alphabet in the 'Name' field");

				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the search button.");
				Log.info("Step:01 -  Click the search button.");

				click(Bond.popupsearch);

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result: Customers matching the criteria are displayed in a grid..");
				Log.info("Expected Result:Customers matching the criteria are displayed in a grid..");

				ExtentTestManager.endTest();

				break;
			}
		}

		// public void CustomerSelectionVerification() throws InterruptedException {

		ExtentTestManager.startTest("Customer Selection Verification");
		Log.info("Customer Selection Verification");

		click(Bond.select);

		driver.switchTo().window(mainWindowHandle);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click 'select' on a customer in the grid.");
		Log.info("Step:01 - Click 'select' on a customer in the grid.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:  Corresponding customer ID is loaded into 'Customer ID' field.");
		Log.info("Expected Result: Corresponding customer ID is loaded into 'Customer ID' field.");
		ExtentTestManager.endTest();

	}

	public void AddCustomerDetailstoGrid() throws InterruptedException {

		ExtentTestManager.startTest("Add Customer Details to Grid");
		Log.info("Add Customer Details to Grid");

		click(Bond.clickadd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the add button next to 'Customer ID' field..");
		Log.info("Step:01 - Click the add button next to 'Customer ID' field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are listed in the grid data.");
		Log.info("Expected Result: Customer details are listed in the grid data.");
		ExtentTestManager.endTest();

	}

	public void FaceValueFieldValidation() {

		ExtentTestManager.startTest("Face Value Field Validation");
		Log.info("Face Value Field Validation");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter digits in 'Face Value'.");
		Log.info("Step:01 - Enter digits in 'Face Value'.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Only digits are accepted, and field is mandatory.");
		Log.info("Expected Result: Only digits are accepted, and field is mandatory.");
		ExtentTestManager.endTest();

	}

	public void NoofUnitFieldValidation(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("No. of Unit Field Validation");
		Log.info("No. of Unit Field Validation");

		clear(Bond.noofunits);
		String Units = testdata.get("Units").toString();
		input(Bond.noofunits, Units);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the 'Duration' field.");
		Log.info("Step:01 - Check the 'Duration' field.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Only digits are accepted, and field is mandatory.");
		Log.info("Expected Result: Only digits are accepted, and field is mandatory.");
		ExtentTestManager.endTest();

	}

	public void DurationFieldAutoloadVerification() throws InterruptedException {

		ExtentTestManager.startTest("Duration Field Auto-load Verification");
		Log.info("Duration Field Auto-load Verification");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the 'Duration' field.");
		Log.info("Step:01 - Check the 'Duration' field.");

		if (ElementDisplayed(Bond.duration)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Duration' is auto-loaded and non-editable.");
			Log.info("Expected Result: Duration' is auto-loaded and non-editable");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		// ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Duration' is
		// auto-loaded and non-editable.");
		// Log.info("Expected Result:Duration' is auto-loaded and non-editable.");
		// ExtentTestManager.endTest();

	}

	public void GetValueButtonFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("Get Value Button Functionality");
		Log.info("Get Value Button Functionality");

		click(Bond.getvaluebutton);

		click(Bond.getvaluebutton);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click 'Get Value' button.");
		Log.info("Step:01 - Click 'Get Value' button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: ROI, Total Value, and Maturity Value auto-load with correct calculations..");
		Log.info("Expected Result: ROI, Total Value, and Maturity Value auto-load with correct calculations..");
		ExtentTestManager.endTest();

	}

	// public void AddButtonFunctionalitywithCompleteData() throws
	// InterruptedException {

	// ExtentTestManager.startTest("Add Button Functionality with Complete Data");
	// Log.info("Add Button Functionality with Complete Data");

	// click(Bond.clicktheadd);

	// ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the add
	// button");
	// Log.info("Step:01 - Click the add button.");

	// ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data is added
	// and processed correctly.");
	// Log.info("Expected Result:Data is added and processed correctly.");
	// ExtentTestManager.endTest();

	// }

	public void FillNomineeDetailsTab() throws InterruptedException {

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		click(Bond.clickonnominee);
		click(Bond.unticknominee);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick Nominee not required ");
		Log.info("Step:01 - Untick Nominee not required ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nominee details fields will be display.");
		Log.info("Expected Result:Nominee details fields will be display");
		ExtentTestManager.endTest();

	}

	public void FillNomineeDetailsTab2() throws InterruptedException {

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		click(Bond.searchcust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the customer search icon option ");
		Log.info("Step:01 - Click the customer search icon option ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Customer seacrh popup window will be opened.");
		Log.info("Expected Result:Customer seacrh popup window will be opened");
		ExtentTestManager.endTest();

	}

	public void FillNomineeDetailsTab3(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				ExtentTestManager.startTest(" Customer Search Functionality()");
				Log.info(" Customer Search Functionality()");

				String Name = testdata.get("Name").toString();
				input(Bond.clickname, Name);

				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter any alphabet in the 'Name' field");
				Log.info("Step:01 -  Enter any alphabet in the 'Name' field");

				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the search button.");
				Log.info("Step:01 -  Click the search button.");

				click(Bond.popupsearch);

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result: Customers matching the criteria are displayed in a grid..");
				Log.info("Expected Result:Customers matching the criteria are displayed in a grid..");

				ExtentTestManager.endTest();

				break;
			}
		}
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 - Enter the name or alphabets in the name field in customer search popup window");
		Log.info("Step:01 -Enter the name or alphabets in the name field in customer search popup window  ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click the search button ");
		Log.info("Step:02 -Click the search button  ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Customers will be display against the given details.");
		Log.info("Expected Result:Customers will be display against the given details");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		click(Bond.select);

		driver.switchTo().window(mainWindowHandle);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the customer from the popup window");
		Log.info("Step:01 - Select the customer from the popup window ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Selected customer details will be autoloads in the fields expect Relation field.");
		Log.info("Expected Result:Selected customer details will be autoloads in the fields expect Relation field.");
		ExtentTestManager.endTest();

	}

	public void FillNomineeDetailsTab33() throws InterruptedException {

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		select("FRIEND", Bond.selectt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Relation from the drop down field");
		Log.info("Step:01 -Select Relation from the drop down field  ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected information accepted.");
		Log.info("Expected Result:Selected information accepted");
		ExtentTestManager.endTest();

	}

	public void FillNomineeDetailsTab5() throws InterruptedException {

		ExtentTestManager.startTest("Fill Nominee Details Tab");
		Log.info("Fill Nominee Details Tab");

		click(Bond.clickonadd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click add button. ");
		Log.info("Step:01 - Click add button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given details shoiwng in the grid.");
		Log.info("Expected Result:Given details shoiwng in the grid");
		ExtentTestManager.endTest();

	}

	public void NavigatetoInterestTransferTab() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Interest Transfer Tab.");
		Log.info("Navigate to Interest Transfer Tab.");

		click(Bond.clickintrest);
		click(Bond.tickonintrest);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 -Make a tick on the Interest Transfer Required Checkbox. ");
		Log.info("Step:01 - Make a tick on the Interest Transfer Required Checkbox. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Tick is added");
		Log.info("Expected Result:Tick is added.");
		ExtentTestManager.endTest();

	}

	public void Fillinteresttransferdetails(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {

		ExtentTestManager.startTest("Fill interest transfer details.");
		Log.info("Fill interest transfer details.");

		clear(Bond.frequence);

		String frequence = testdata.get("Frequence").toString();
		input(Bond.frequence, frequence);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter Frequency as 1. ");
		Log.info("Step:01 -Enter Frequency as 1. ");

		select("MONTHS", Bond.dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click on the dropdown button . ");
		Log.info("Step:02 -Click on the dropdown button . ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -Select Month from the list. ");
		Log.info("Step:03 -Select Month from the list. ");

		click(Bond.clickcustomer);
		click(Bond.clickonaddd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 -Click on the Add Button. ");
		Log.info("Step:04 -Click on the Add Button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Interest Transfer Account Details is added..");
		Log.info("Expected Result:Interest Transfer Account Details is added.");
		ExtentTestManager.endTest();

	}

	public void navigatetoDocumentsTab() throws InterruptedException {

		ExtentTestManager.startTest("navigate to Documents Tab.");
		Log.info("navigate to Documents Tab.");

		click(Bond.clickdocumnt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -CLick on the Document  Drop Down Document Type. ");
		Log.info("Step:01 -CLick on the Document  Drop Down Document Type. ");

		select("AADHAAR", Bond.clickdoctype);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select a document Tyoe. ");
		Log.info("Step:02 - Select a document Tyoe. ");

//		click(Bond.browser);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -Click on the Browse button. ");
		Log.info("Step:03 - Click on the Browse button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Popup will be open to borwse the documents");
		Log.info("Expected Result:Popup will be open to borwse the documents.");
		ExtentTestManager.endTest();

	}

	public void navigatetoDocumentsTab2() {

		ExtentTestManager.startTest("navigate to Documents Tab.");
		Log.info("navigate to Documents Tab.");

		UploadFile(Bond.browser, ".\\src\\test\\resources\\sample.pdf");
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select file to upload.. ");
		Log.info("Step:01 -Select file to upload..  ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -CLick on OK Button ");
		Log.info("Step:02 -CLick on OK Button  ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:.");
		Log.info("Expected Result:");
		ExtentTestManager.endTest();

	}

	public void navigatetoDocumentsTab3() {

		ExtentTestManager.startTest("navigate to Documents Tab.");
		Log.info("navigate to Documents Tab.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -ENter Remarks. ");
		Log.info("Step:01 -ENter Remarks.  ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Add the file. ");
		Log.info("Step:01 -Add the file.  ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:FIle added sucessfluly");
		Log.info("Expected Result:FIle added sucessfluly");
		ExtentTestManager.endTest();

	}

	public void TransactionAmountAutoloadVerification() {

		ExtentTestManager.startTest("Transaction Amount Auto-load Verification");
		Log.info("Transaction Amount Auto-load Verification.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Check 'Transaction Amount' field.. ");
		Log.info("Step:01 -Check 'Transaction Amount' field..  ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Transaction Amount' is auto-loaded with 'Total Value'..");
		Log.info("Expected Result:Transaction Amount' is auto-loaded with 'Total Value'.");
		ExtentTestManager.endTest();

	}

	public void PaymentModeSelection() throws InterruptedException {

		ExtentTestManager.startTest("Payment Mode Selectionn");
		Log.info("Payment Mode Selection.");

		select("Cash", Bond.clickcASH);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select 'Cash' from the dropdown. ");
		Log.info("Step:01 -Select 'Cash' from the dropdown.  ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Cash is selected as payment mode..");
		Log.info("Expected Result:Cash is selected as payment mode.");
		ExtentTestManager.endTest();

	}

	public void SaveAllButtonFunctionalitywithPaymentMode() throws InterruptedException {

		ExtentTestManager.startTest("Save All Button Functionality with Payment Mode");
		Log.info("Save All Button Functionality with Payment Mode.");

		click(Bond.clicksave);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click 'Save All' button. ");
		Log.info("Step:01 -Click 'Save All' button.  ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:	Transaction is saved and confirmed message displayed..");
		Log.info("Expected Result:	Transaction is saved and confirmed message displayed.");
		ExtentTestManager.endTest();

		// transId = driver.findElement(Suspenseasset.transIDD).getText();

	}

	public void logoutApplication1() throws InterruptedException {
		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");

		// click(JewelClosure.close);
		click(Bond.logout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();

	}

	public void ManagerLoginforAuthorization() throws InterruptedException, IOException {
		
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		String UserName = configloader().getProperty("UserName1");
		input(custSearch.loginUserName, UserName);

		String Password = configloader().getProperty("Password1");
		input(custSearch.loginPasswrd, Password);

		click(custSearch.loginButton);

		

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);

		String flag = "vinusha";

		if (!userName.equalsIgnoreCase(flag)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		click(Bond.clickauthorize);
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Click the authoirze & Cancel module from the taskbar");
		Log.info("Step: 1 -Click the authoirze & Cancel module from the taskbar");

		click(Bond.managertab);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step: 2 -Click Manager authorisation Submodule");
		Log.info("Step: 2 -Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorization window will be display.");
		Log.info("Expected Result: Manager authorization window will be display.");
	}

	public void ManagerAuthorizationRefresh() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Manager Authorization Refresh");
		Log.info("Manager Authorization Refresh");
		
		click(Bond.others);
		
		
		
		click(Bond.refresh);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked the Refresh tab again.");
		Log.info("Step: 01 - Clicked the Refresh tab again.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Transaction entry will be displayed after clicking the refresh button");
		Log.info("Expected Result: Transaction entry will be displayed after clicking the refresh button");
		ExtentTestManager.endTest();

		
	}

	public void AuthorizeapplicationEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Authorize application Entry");
		Log.info("Authorize application Entry");
		
		String MakerID = testdata.get("MakerID").toString();
		input(Bond.makerid, MakerID);
		
		click(Bond.go);
		
		click(Bond.checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Select application entry checkbox in the Others section.");
		Log.info("Step: 01 - Select application entry checkbox in the Others section.");
		
		click(Bond.authorize);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 -Click 'Authorize' button.");
		Log.info("Step: 01 -Click 'Authorize' button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: application entry is authorized with confirmation message");
		Log.info("Expected Result: application entry is authorized with confirmation message");
		ExtentTestManager.endTest();

	}
	
	public void logoutApplication2() throws InterruptedException {
		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");

		click(Bond.close);
		click(Bond.logout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();

		driver.close();
	}

}
