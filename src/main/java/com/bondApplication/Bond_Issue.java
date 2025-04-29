package com.bondApplication;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Agent_Transfer;
import com.Page_Repositary.PageRepositary_Bond_Issue;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Multiple_Fd_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;



public class Bond_Issue extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_Multiple_Fd_Cash_Transfer FDintrest = new PageRepositary_Multiple_Fd_Cash_Transfer();
	PageRepositary_Bond_Issue Bondissue = new PageRepositary_Bond_Issue();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	
	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;
	
	String Actualusername;
	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void username() {
		Actualusername = getActualUserName(ClosureTrans.Username);
		System.out.println("Firstusername: " + Actualusername);
	}
	public void displayamount(String Display) throws InterruptedException {
		clear(Bondissue.enteramount);
		click(Bondissue.enteramount);
		input(Bondissue.enteramount, Display);
	}

	public String getActualUserName(By locator) {
		String actualUserName = driver.findElement(locator).getText();
		System.out.println("actualUserName: "+actualUserName);
		return actualUserName;
		
		
	}
	
	public void verifyBondIssuePage() throws InterruptedException {
		ExtentTestManager.startTest("Verify Bond Issue Page");
		Log.info("Verifying bond issue page");

		
		ScrollUntilElementVisible(Bondissue.clickonBond);
		click(Bondissue.clickonBond);
		click(Bondissue.clickonBondissue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the Bond Issue page. ");
		Log.info("Step:01 - Navigate to the Bond Issue page ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Check if the Branch field is visible and enabled. ");
		Log.info("Step:02 - Check if the Branch field is visible and enabled.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Branch dropdown is visible and enabled for selection.Bond issue page loaded");
		Log.info("Branch dropdown is visible and enabled for selection Bond issue page loaded");

	}

	public void verifyBondIssuePage1() throws InterruptedException {
		ExtentTestManager.startTest("Verify Bond Issue Page");
		Log.info("Verifying bond issue page");

		// click(Bondissue.clickonBond);
		click(Bondissue.clickonBondissue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the Bond Issue page. ");
		Log.info("Step:01 - Navigate to the Bond Issue page ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Check if the Branch field is visible and enabled. ");
		Log.info("Step:02 - Check if the Branch field is visible and enabled.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Branch dropdown is visible and enabled for selection.Bond issue page loaded");
		Log.info("Branch dropdown is visible and enabled for selection Bond issue page loaded");

	}

//	public void selectTrivandrumBranch() {
//		
//		ExtentTestManager.startTest("Select Trivandrum Branch");
//		Log.info("Selecting Trivandrum branch");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  ");
//		Log.info("Step:01 -  ");
//
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - ");
//		Log.info("Step:02 - ");
//
//		ExtentTestManager.getTest().log(Status.PASS, "");
//		Log.info("");

	// }

//	public void selectStatusApplicationReceived() {
//		
//		ExtentTestManager.startTest("Select Status as Application Received");
//		Log.info("Selecting status as Application Received");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  ");
//		Log.info("Step:01 -  ");
//
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - ");
//		Log.info("Step:02 - ");
//
//		ExtentTestManager.getTest().log(Status.PASS, "");
//		Log.info("");
//		
//		
//	}
	public void selectProductAll() throws InterruptedException {

		ExtentTestManager.startTest("Select Product as All");
		Log.info("Selecting product as All");

		// select("DEBUNTURE SCHEME 2", Bondissue.product);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - select the product ");
		Log.info("Step:01 - select the product ");

		ExtentTestManager.getTest().log(Status.PASS, "product as been selected");
		Log.info("product as been selected");

	}

	public void selectProductAll1() throws InterruptedException {

		ExtentTestManager.startTest("Select Product as All");
		Log.info("Selecting product as All");

		// select("DEBUNTURE SCHEME 2", Bondissue.product);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - select the product ");
		Log.info("Step:01 - select the product ");

		ExtentTestManager.getTest().log(Status.PASS, "product as been selected");
		Log.info("product as been selected");

	}

//	}
	public void verifyNameFieldFunctionality(Map<Object, Object> testdata, ITestContext contex)
			throws InterruptedException {

		ExtentTestManager.startTest("Name Field Functionality");
		Log.info("Verifying name field functionality");

		String Name = testdata.get("Name").toString();
		input(Bondissue.Bondname, Name);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter 'A' in the Name field.  ");
		Log.info("Step:01 -  Enter 'A' in the Name field.");

		click(Bondissue.Clicksearch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click the Search button");
		Log.info("Step:02 - Click the Search button");

		ExtentTestManager.getTest().log(Status.PASS, "Applications with customer names containing 'A' are listed.");
		Log.info("Applications with customer names containing 'A' are listed.");
	}

	public void verifyApplicationDetailsPopupFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("Application Details Popup Functionality");
		Log.info("Verifying application details popup functionality");

		ScrollUntilElementVisible(Bondissue.Scrolldown);

		click(Bondissue.clickonappdetails);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Application Details button  ");
		Log.info("Step:01 -Click on Application Details button  ");

		ExtentTestManager.getTest().log(Status.PASS, "Application Details popup is displayed.");
		Log.info("Application Details popup is displayed.");

	}

	public void closeApplicationDetailsPopup() throws InterruptedException {

		ExtentTestManager.startTest("Close Application Details Popup");
		Log.info("Closing application details popup");

		// Navigate to Pop Up Window
		
		
		 mainWindowHandle = driver.getWindowHandle();
		 boolean popupAppeared = false;
		 for (String handle : driver.getWindowHandles()) {
		 	if (!handle.equals(mainWindowHandle)) {
		 		driver.switchTo().window(handle);
		 		driver.manage().window().maximize();
		 		popupAppeared = true;
		 	}
		 }
//		
//		String mainWindowHandle = driver.getWindowHandle();
//		boolean popupAppeared = false;
//		for (String handle : driver.getWindowHandles()) {
//			if (!handle.equals(mainWindowHandle)) {
//				driver.switchTo().window(handle);
//				driver.manage().window().maximize();
//				popupAppeared = true;
//				// Thread.sleep(5000);
//				String currentUrl = driver.getCurrentUrl();
//				System.out.println("currentUrl: " + currentUrl);
//				
		 
//		 ScrollUntilElementVisible(Bondissue.frame);
//			Thread.sleep(5000);
			
			
//				if (currentUrl.endsWith(".pdf")) {
//					ExtentTestManager.getTest().log(Status.PASS,
//							"Expected Result: Popup is closed, return to application listing..");
//					Log.info("Expected Result: Popup is closed, return to application listing..");
//				} else {
//					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//					Log.info("ERROR");
//				}
//
//				ExtentTestManager.getTest().log(Status.PASS,
//						"Expected Result:Popup is closed, return to application listing.");
//				Log.info("Expected Result: Popup is closed, return to application listing.");
//				ExtentTestManager.endTest();
//
				driver.close();
				
				driver.switchTo().window(mainWindowHandle);
////
////				break;
//
//			}
//
//		} // for loop end

	}

	public void verifyIssueButtonFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("Issue Button Functionality");
		Log.info("Verifying issue button functionality");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Check if Issue button is enabled ");
		Log.info("Step:01 -  Check if Issue button is enabled ");

		WebElement table = driver.findElement(By.xpath("//*[@id=\"tblBondIssueList\"]"));

		// Find all <tr> elements in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Output the number of <tr> tags
		System.out.println("Number of rows in the table: " + rows.size());

		int lastRowCount = rows.size() - 1;
		System.out.println("lastRow: " + lastRowCount);

		String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstBondIssue_ctrl" + lastRowCount + "_btnView']";
		By lastRowViewXPath = By.xpath(xpath);
		System.out.println("lastRowViewXPath: " + lastRowViewXPath);

//			try {
//				for(int i = 2;i<=rowSize-1;i++) {
//					String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl0"+i+"_ddlProduct_ddl']";
//					By XPath = By.xpath(xpath);
//					
//					select("PERSONAL LOAN WEEKLY",XPath);
//					
//					INclick(Bondissue.loader);
//	 
//				}
//			}catch(Exception e) {
//				System.out.println("No more dropdowns");
//			}

		ScrollUntilElementVisible(lastRowViewXPath);

		click(lastRowViewXPath);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Issue button. ");
		Log.info("Step:02 - Click Issue button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Popup named 'Application Issue' is displayed.");
		Log.info("Popup named 'Application Issue' is displayed.");

	}

	public void confirmIssueApplication() throws InterruptedException {

		ExtentTestManager.startTest("Issue Application Confirmation");
		Log.info("Confirming application issue");

		click(Bondissue.clickonOk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click OK button on the popup.  ");
		Log.info("Step:01 -Click OK button on the popup.  ");

		ExtentTestManager.getTest().log(Status.PASS, "Application is issued successfully, summary page displayed.");
		Log.info("Application is issued successfully, summary page displayed.");

		transId = driver.findElement(Bondissue.Transid).getText();

	}

	public void logout() {

		ExtentTestManager.startTest("Logout After Issue");
		Log.info("Logging out after issuing the application");

		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();

	}

	public void loginAsManagerForAuthorization() {

		ExtentTestManager.startTest("Manager Login for Authorization");
		Log.info("Manager logging in for authorization");

	}

	public void cashierAuthorizationRefresh() throws InterruptedException {

		ExtentTestManager.startTest("Cashier Authorization Refresh");
		Log.info("Refreshing cashier authorization list");

		ExtentTestManager.startTest("Manager authorization");
		Log.info("Manager authorization");

		click(FDintrest.clickonauth);

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.clickcashier);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar");
		Log.info("Step:01 -Click the authoirze & Cancel module from the taskbar ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click cashier authorisation Submodule");
		Log.info("Step:02 - Click cashier authorisation Submodule ");

		ExtentTestManager.getTest().log(Status.PASS, "Cashier authorization window will be display");
		Log.info("Cashier authorization window will be display");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.refresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab ");
		Log.info("Step:01 - Click the Refresh tab ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Transaction entry will be diaply after clicking the refresh button");
		Log.info("Transaction entry will be diaply after clicking the refresh button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(FDintrest.clickgo2);

	}

	public void authorizeBondIssueEntry() throws InterruptedException {

		ExtentTestManager.startTest("Authorize Bond Issue Entry");
		Log.info("Authorizing bond issue entry");

		click(Bondissue.check);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select bond issue entry checkbox in the cash section  ");
		Log.info("Step:01 - Select bond issue entry checkbox in the cash section ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click 'Authorize' button  ");
		Log.info("Step:02 - Click 'Authorize' button");

		ExtentTestManager.getTest().log(Status.PASS, "Bond issue entry is authorized with confirmation message");
		Log.info("Bond issue entry is authorized with confirmation message");

	}

	public void openManagerAuthorizationModule() throws InterruptedException {

		ExtentTestManager.startTest("Manager Authorization Module");
		Log.info("Verifying manager authorization module");

		click(JewelClosure.managertab);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Navigated to Manager Authorization submodule.");
		Log.info("Step: 01 - Navigated to Manager Authorization submodule.");

		click(JewelClosure.refreshtab);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 - Clicked the Refresh tab again.");
		Log.info("Step: 01 - Clicked the Refresh tab again.");

		click(JewelClosure.checkboxman);

		ExtentTestManager.getTest().log(Status.PASS,
				"Step: 1 - Selected checkbox of Transaction Suspense Asset Transaction again.");
		Log.info("Step: 1 - Selected checkbox of Transaction Suspense Asset Transaction again.");

		click(JewelClosure.clickauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Clicked Authorize button again.");
		Log.info("Step: 1 - Clicked Authorize button again.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager authorization window will be displayed");
		Log.info("Expected Result: Manager authorization window will be displayed");
		ExtentTestManager.endTest();

	}

	public void logoutAgain() {

		ExtentTestManager.startTest("Logout After Authorization");
		Log.info("Logging out after manager authorization");

	}

	public void loginApplicationAgain() {

		ExtentTestManager.startTest("Login for Rejection - Cash Mode");
		Log.info("Logging in to perform rejection using cash mode");

	}

	public void verifyBondIssuePageAgain() {
		ExtentTestManager.startTest("Verify Bond Issue Page Again");
		Log.info("Verifying bond issue page again");

	}

	public void searchWithBranchStatusProduct() {

		ExtentTestManager.startTest("Search with Branch, Status and Product");
		Log.info("Searching with selected branch, status and product");
	}

	public void clickRejectButton() {

		ExtentTestManager.startTest("Reject Button Functionality");
		Log.info("Verifying reject button functionality");

	}

	public void enterRejectionRemark() {

		ExtentTestManager.startTest("Enter Rejection Remark");
		Log.info("Entering rejection remark");
	}

	public void selectTransactionModeCash() throws InterruptedException {

		ExtentTestManager.startTest("Select Transaction Mode as Cash");
		Log.info("Selecting transaction mode as Cash");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 -Open dropdown.");
		Log.info("Step: 01 - Open dropdown..");

		select("CASH", Bondissue.selectCASH);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 02 -  Select 'Cash'..");
		Log.info("Step: 02 - Select 'Cash'..");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - 'Cash' is selected in Transaction Mode dropdown..");
		Log.info("Step: 1 - 'Cash' is selected in Transaction Mode dropdown..");

	}

	public void submitRejection() throws InterruptedException {
		ExtentTestManager.startTest("Submit Rejection (Cash Mode)");
		Log.info("Submitting rejection in cash mode");

		click(Bondissue.clicksubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 -  Click Submit.");
		Log.info("Step: 01 -Click Submit..");

		ExtentTestManager.getTest().log(Status.PASS,
				"Step: 1 - Application is rejected successfully and summary page is displayed.");
		Log.info("Step: 1 -Application is rejected successfully and summary page is displayed.");

		transId = driver.findElement(Bondissue.Transid).getText();

	}

	public void logoutOnceMore() {
		ExtentTestManager.startTest("Logout After Cash Rejection");
		Log.info("Logging out after cash rejection");

	}

	public void loginAsManagerForAuthorizationAgain() {

		ExtentTestManager.startTest("Manager Login for Cash Rejection Authorization");
		Log.info("Manager logging in to authorize cash rejection");

	}

	public void managerauthorisation() throws InterruptedException {

		ExtentTestManager.startTest("Manager authorization");
		Log.info("Manager authorization");

		// click(FDintrest.clickonauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		click(FDintrest.clickonmanger);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule ");
		Log.info("Step:02 - Click Manager authorisation Submodule");

		click(Bondissue.clickonothers);

		click(FDintrest.clickrefresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab");
		Log.info("Step:01 - Click the Refresh tab");

		ExtentTestManager.getTest().log(Status.PASS, "Authorization entries are updated and displayed");
		Log.info("Authorization entries are updated and displayed");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);
	}

	public void logoutApplication1() throws InterruptedException {
		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");

		click(JewelClosure.close);
		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();

	}

	public void managerAuthorizationRefresh() {
		ExtentTestManager.startTest("Manager Authorization Refresh (Cash Rejection)");
		Log.info("Refreshing manager authorization list for cash rejection");

	}

	public void authorizeRejectedEntry() throws InterruptedException {
		ExtentTestManager.startTest("Authorize Rejected Entry (Cash Mode)");
		Log.info("Authorizing rejected entry submitted in cash mode");

		click(Bondissue.clickcheckbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Reject entry checkbox in the Others section");
		Log.info("Step:01 - Select Reject entry checkbox in the Others section");

		click(Bondissue.clickauthoriz);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Authorize' button");
		Log.info("Step:01 - Click 'Authorize' button");

		ExtentTestManager.getTest().log(Status.PASS, "Rejected entry is authorized with confirmation message");
		Log.info("Rejected entry is authorized with confirmation message");

	}

	public void logoutFinal() {
		ExtentTestManager.startTest("Logout After Cash Rejection Authorization");
		Log.info("Logging out after authorizing cash rejection");

	}

	public void loginApplicationThirdTime() {
		ExtentTestManager.startTest("Login for Rejection - Transfer Mode");
		Log.info("Logging in to perform rejection using transfer mode");

	}

	public void verifyBondIssuePageThirdTime() {
		ExtentTestManager.startTest("Verify Bond Issue Page Again (Transfer Mode)");
		Log.info("Verifying bond issue page again for transfer mode");

	}

	public void searchWithBranchStatusProductAgain() {
		ExtentTestManager.startTest("Search with Branch, Status and Product Again");
		Log.info("Searching again with selected branch, status and product");

	}

	public void clickRejectButtonAgain(Map<Object, Object> testdata, ITestContext contex) throws InterruptedException {
		ExtentTestManager.startTest("Reject Button Functionality (Transfer Mode)");
		Log.info("Verifying reject button functionality in transfer mode");

		click(Bondissue.clickreject);

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Reject button.");
		Log.info("Step:02 - Click Reject button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Redirected to Reject page.");
		Log.info("Redirected to Reject page.");

		ExtentTestManager.startTest("Enter Rejection Remark (Transfer Mode)");
		Log.info("Entering rejection remark for transfer mode");

		String Reject = testdata.get("Reject").toString();
		input(Bondissue.rejectionremarks, Reject);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01: Enter 'Rejected' in the Remark field.");
		Log.info("Step:01 - Enter 'Rejected' in the Remark field. ");

		ExtentTestManager.getTest().log(Status.PASS, "Remark is added successfully..");
		Log.info("Remark is added successfully..");
	}

	public void enterRejectionRemarkAgain() throws InterruptedException {
		ExtentTestManager.startTest("Enter Rejection Remark (Transfer Mode)");
		Log.info("Entering rejection remark for transfer mode");

		ExtentTestManager.startTest("Submit Rejection");
		Log.info("Submit Rejection");

		click(Bondissue.clicksubmit);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01: Click Submit.");
		Log.info("Step:01 -Click Submit.. ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Application is rejected successfully and summary page is displayed..");
		Log.info("Application is rejected successfully and summary page is displayed.");

	}

	public void selectTransactionModeTransfer() throws InterruptedException {
		ExtentTestManager.startTest("Select Transaction Mode as Transfer");
		Log.info("Selecting transaction mode as Transfer");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 -Open dropdown.");
		Log.info("Step: 01 - Open dropdown..");

		select("TRANSFER", Bondissue.selectCASH);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 02 -  Select 'Cash'..");
		Log.info("Step: 02 - Select 'Cash'..");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - 'TRANSFER' is selected in Transaction Mode dropdown..");
		Log.info("Step: 1 - 'TRANSEFR' is selected in Transaction Mode dropdown..");

	}

	public void verifyPostCreditButtonFunctionality(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("Post Credit Button Functionality");
		Log.info("Verifying post credit button functionality");

		click(Bondissue.Postdebit);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click on the POST DEBIT button ");
		Log.info("Step: 1 -Click on the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Auto posting popup window will be display .");
		Log.info("Expected Result:Auto posting popup window will be display .");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Search Account Number");
		Log.info("Searched for Account Number");

		mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
			}
		}

		select("GL Code", Bondissue.GLcode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- Select the GL Name from the drop down.");
		Log.info("Step:02 -Select the GL Name from the drop down.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:GL code will be autoloads while selecting the GL Name ");
		Log.info("Expected Result:GL code will be autoloads while selecting the GL Name");
		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Add button functionality");
		Log.info("Add button functionality");

		click(Bondissue.clickonglname);

		click(Bondissue.clickonGL);
		// select("ADVERTISEMENT",Bondissue.clickonglname);

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Give the amount in Amount field");
		Log.info("Step: 1 -Give the amount in Amount field");

		String amntValue = driver.findElement(Bondissue.accounttag).getAttribute("value");
		String amntValue1 = amntValue.split("\\.")[0];		
		
		displayamount(amntValue1);

		click(Bondissue.clickonadddd);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 2 -Click add button");
		Log.info("Step: 2 -Click add button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given details will be displays in the grid .");
		Log.info("Given details will be displays in the grid.");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Add Transaction Amount");
		Log.info("Transaction Amount Added");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Enter amount.");
		Log.info("Step: 1 - Enter amount.");

	//	click(JewelClosure.CliADD);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 2- Click ADD.");
		Log.info("Step: 2 - Click ADD.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Amount and details is added in the grid in the auto posting popup window.");
		Log.info("Expected Result:Amount and details is added in the grid in the auto posting popup window  .");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Submit button functionality");
		Log.info("Submit button functionality");

		click(Bondissue.clickonsubmitt);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Enter submit in the auto posting popu window ");
		Log.info("Step: 1 - Enter submit in the auto posting popu window .");

		driver.switchTo().window(mainWindowHandle);

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Details is added and auto posting popu window closes .");
		Log.info("Expected Result:Details is added and auto posting popu window closes .");

		ExtentTestManager.endTest();
	}

	public void selectGLName() {
		ExtentTestManager.startTest("GL Name Selection");
		Log.info("Selecting GL name");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 01 -  Click Post Credit button.");
		Log.info("Step: 01 - Click Post Credit button..");

		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Auto posting popup window will be opened");
		Log.info("Step: 1 - Auto posting popup window will be opened");

	}

	public void clickAddButton() {
		ExtentTestManager.startTest("Add Button Functionality");
		Log.info("Verifying add button functionality");

	}

	public void clickSubmitButton() throws InterruptedException {
		ExtentTestManager.startTest("Submit Button Functionality");
		Log.info("Verifying submit button functionality");

		click(Bondissue.clickonsubmut);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click Submit button.");
		Log.info("Step: 1 - Click Submit button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User navigates to the summary page.");
		Log.info("Expected Result: User navigates to the summary page.");

		transId = driver.findElement(Bondissue.Transid).getText();

	}

	public void submitRejectionFinal() {

		ExtentTestManager.startTest("Submit Rejection (Transfer Mode)");
		Log.info("Submitting rejection in transfer mode");
	}

	public void logoutLast() {
		ExtentTestManager.startTest("Logout After Transfer Rejection");
		Log.info("Logging out after transfer rejection");

	}

	public void loginAsManagerForFinalAuthorization() {

		ExtentTestManager.startTest("Manager Login for Transfer Rejection Authorization");
		Log.info("Manager logging in to authorize transfer rejection");

	}

	public void managerAuthorizationRefreshFinal1() throws InterruptedException {

		ExtentTestManager.startTest("Manager Authorization Refresh (Transfer Rejection)");
		Log.info("Refreshing manager authorization list for transfer rejection");

		// click(FDintrest.clickonauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		click(FDintrest.clickonmanger);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule ");
		Log.info("Step:02 - Click Manager authorisation Submodule");

		click(Bondissue.clickonTransfer);

		click(FDintrest.clickrefresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab");
		Log.info("Step:01 - Click the Refresh tab");

		ExtentTestManager.getTest().log(Status.PASS, "Authorization entries are updated and displayed");
		Log.info("Authorization entries are updated and displayed");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);
	}

	public void managerAuthorizationRefreshFinal() throws InterruptedException {

		ExtentTestManager.startTest("Manager Authorization Refresh (Transfer Rejection)");
		Log.info("Refreshing manager authorization list for transfer rejection");

		click(FDintrest.clickonauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		click(FDintrest.clickonmanger);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule ");
		Log.info("Step:02 - Click Manager authorisation Submodule");

		click(Bondissue.clickonTransfer);

		click(FDintrest.clickrefresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab");
		Log.info("Step:01 - Click the Refresh tab");

		ExtentTestManager.getTest().log(Status.PASS, "Authorization entries are updated and displayed");
		Log.info("Authorization entries are updated and displayed");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);
	}

	public void authorizeRejectedEntryFinal() {

		ExtentTestManager.startTest("Authorize Rejected Entry (Transfer Mode)");
		Log.info("Authorizing rejected entry submitted in transfer mode");

	}
}
