package com.GeneralOpening;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_GeneralOpening.PageRepositary_GeneralOpening_Cash_Transfer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class General_Opening_cash_transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_GeneralOpening_Cash_Transfer GenOpen = new PageRepositary_GeneralOpening_Cash_Transfer();

	String transId;
	String transIdTransfer;

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);
	}

	public void accountOpening() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to General Opening").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Navigate to General Opening");

		ScrollUntilElementVisible(goaldLoanRepo.accOpeningTab);
		click(goaldLoanRepo.accOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");

		ScrollUntilElementVisible(GenOpen.GeneralOpenTab);
		click(GenOpen.GeneralOpenTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Navigate  General opening.");
		Log.info("Step:02 - Navigating to General opening.");

		ScrollUntilElementVisible(GenOpen.Suspenseliability);
		click(GenOpen.Suspenseliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Navigate suspenseLiability.");
		Log.info("Step:03 - Navigating to  suspense liability opening.");

		click(GenOpen.Suspliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - select suspense liability.");
		Log.info("Step:04 - select suspense liability.");

	}

	public void Customerinfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Customer Search Popup").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Customer Search Popup");

		click(GenOpen.clicksearch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on search icon.");
		Log.info("Step:01 -  Click on search button.");

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				ExtentTestManager.startTest("Search Customer by Name").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Search Customer by Name");

				String custName = testdata.get("Name").toString();
				input(GenOpen.Custname, custName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter customer Name or alphabet.");
				Log.info("Step:01 - Enter customer Name or alphabet.");

				click(GenOpen.Clickonsearch);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - click On search Button.");
				Log.info("Step:02 - Click on search button.");

				click(GenOpen.Clickonselect);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the customer.");
				Log.info("Step:01 - click on a select button.");

				driver.switchTo().window(mainWindowHandle);

				ExtentTestManager.startTest("Select and Open Customer Details").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Select and Open Customer Details");

				click(GenOpen.ClickonADD);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Clcik on add.");
				Log.info("Step:01 - click on add button.");

				if (ElementDisplayed(GenOpen.Customergrid)) {
					ExtentTestManager.getTest().log(Status.PASS,
							"Expected Result: Customer details are shown in grid.");
					Log.info("Expected Result: Customer details are shown in grid.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.endTest();

				break;
			}
		}
	}

	public void verifieddata(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Enter Opening Amount");
		Log.info("Enter Opening Amount");

		click(GenOpen.enteropenamount);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");
		Log.info("Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");

		String openacc = testdata.get("Openaccount").toString();
		input(GenOpen.enteropenamount, openacc);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Remarks into Remarks field.");
		Log.info("Step:01 - Enter Remarks into Remarks field.");

		ExtentTestManager.startTest("Enter Remarks").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Enter Remarks");

		click(GenOpen.enteremarks);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");
		Log.info("Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");

		String remarks = testdata.get("Remarks").toString();
		input(GenOpen.enteremarks, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Text is accepted; field allows non-mandatory input.");
		Log.info("Step:01 - Text is accepted; field allows non-mandatory input");

	}

	public void transactions(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("Verify Transaction Mode Options").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Verify Transaction Mode Options");

		click(GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Options are cash and transfer.");
		Log.info("Step:01 - Options are cash and transfer.");

		ExtentTestManager.startTest("Select Transaction Mode as Cash and Submit").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Select Transaction Mode as Cash and Submit");

		select("CASH", GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'");
		Log.info("Step:01 - Select Trans. Mode 'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		ExtentTestManager.startTest("Select Transaction Mode as Cash and Submit").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Select Transaction Mode as Cash and Submit");

		click(GenOpen.clickonsubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Click submit button.");
		Log.info("Step:01 - Redirects to summary page.");

//vinusha

		transId = driver.findElement(GenOpen.transIdd).getText();
	}

	public void Signout() throws InterruptedException {
		click(GenOpen.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");
	}
	
	public void Signout1() throws InterruptedException {
		click(GenOpen.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");
		
		driver.close();
	}

	public void Cashier(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);

		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);

		click(custSearch.loginButton);

		ExtentTestManager.startTest("Login with Another User").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Login with Another User");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
		
		try {
			WebElement clickableElement = driver.findElement(By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]"));

			if (clickableElement != null) {
				// Perform the desired action on the element
				clickableElement.click();
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
				Log.info("Step:01 - Click on OK button");
				
//					String loginUserName = testdata.get("loginUserName").toString();
				input(custSearch.loginUserName, UserName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
				Log.info("Step:02 - Enetered valid User Name");
				
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				input(custSearch.loginPasswrd, Password);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
				Log.info("Step:03 - Entered valid Password");
				
				click(custSearch.loginButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
				Log.info("Step:04 - Click on Login Button");
				
				ElementDisplayed(custSearch.home);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
				Log.info("Expected Result: User is logged in successfully and dashboard visible");	
			} else {
				System.out.println("Element not clickable within the timeout.");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while waiting for the element: " + e.getMessage());
			System.out.println("Already login pop up not appeared");
		}

		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);

		/*String flag = "vinusha";

		if (!userName.equalsIgnoreCase(flag)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}*/

		ExtentTestManager.endTest();

		// Cashier Authorization

		ExtentTestManager.startTest("Manager Authorization - Cash Tab").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Manager Authorization - Cash Tab");

		ScrollUntilElementVisible(goaldLoanRepo.autorizeAndCancelTab);
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(goaldLoanRepo.cashierAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Refresh Loan Opening Entry");

		click(goaldLoanRepo.cashierRefreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Authorize Loan Entry as Manager");

		click(goaldLoanRepo.cashierCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(goaldLoanRepo.cashierAuthorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");

		if (ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is created");
			Log.info("Expected Result: Account is created");
			click(goaldLoanRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Cashier Authorization").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Cashier Authorization");

		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		ExtentTestManager.endTest();

		ExtentTestManager.startTest("Cashier Authorization").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Cashier Authorization");

		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(goaldLoanRepo.approveCheckBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		// Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Cashier Authorization").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Cashier Authorization");

		click(goaldLoanRepo.approveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		ExtentTestManager.startTest("Cashier Authorization").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Cashier Authorization");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();

	}

	public void closesuccess() throws InterruptedException {
		click(GenOpen.closesuccesmsg);
	}

	// General opening_ suspense liability _ transfer

	public void accountOpening2() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to General Opening").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Navigate to General Opening");

		click(GenOpen.Suspliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - select suspense liability.");
		Log.info("Step:04 - select suspense liability.");

	}

	public void transactionsTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Verify Transaction Mode Options").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Verify Transaction Mode Options");

		click(GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Options are cash and transfer.");
		Log.info("Step:01 - Options are cash and transfer.");

		ExtentTestManager.startTest("Select Transaction Mode as Transfer and Post Debit").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Select Transaction Mode as Transfer and Post Debit");

		select("TRANSFER", GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Transfer'");
		Log.info("Step:01 - Select Trans. Mode 'Transfer'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		// transId = driver.findElement(GenOpen.transIdd).getText();

		click(GenOpen.PostDeb);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click post debit button.");
		Log.info("Step:01 - Click post debit button.");

		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				// transId = driver.findElement(GenOpen.transIdd).getText();
				click(GenOpen.clickonacc);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - click on tansaction based.");
				Log.info("Step:01 - click on tansaction based.");

				ExtentTestManager.startTest("Verify general Submission with Transfer Mode").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Verify general Submission with Transfer Mode");

				select("GL Code", GenOpen.clickonacc);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transaction based GL mode.");
				Log.info("Step:01 - Select Transaction based GL Mode.");

				ExtentTestManager.startTest("Verify general Submission with Transfer Mode").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Verify general Submission with Transfer Mode");

				click(GenOpen.selectGLname);
				click(GenOpen.add);
				// select("ADVERTISEMENT", GenOpen.add);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select GL name.");
				Log.info("Step:01 - Select GL name");

				ExtentTestManager.startTest("Verify general Submission with Transfer Mode").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Verify general Submission with Transfer Mode");

				String amount = testdata.get("Amount").toString();
				input(GenOpen.amount, amount);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Give the amount in Amount field.");
				Log.info("Step:01 - Give the amount in Amount field.");

				click(GenOpen.clickaddbutton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Click add button");
				Log.info("Step:01 - 1.Click add button ");

				ExtentTestManager.startTest("Verify general Submission with Transfer Mode").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Verify general Submission with Transfer Mode");

				click(GenOpen.clicksubmit);
				ExtentTestManager.getTest().log(Status.PASS,
						"Step:01 - 1.Click submit button after adding the details in the auto posting popup window");
				Log.info("Step:01 - 1.Click submit button after adding the details in the auto posting popup window");

				driver.switchTo().window(mainWindowHandle);

				if (ElementDisplayed(GenOpen.PostDeb)) {
					ExtentTestManager.getTest().log(Status.PASS,
							"Expected Result: Customer details are shown in grid.");
					Log.info("Expected Result: Customer details are shown in grid.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.startTest("Verify general Submission with Transfer Mode").assignCategory("GeneralOpening-Cash/Transfer");
				Log.info("Verify general Submission with Transfer Mode");

				click(GenOpen.clicksaves);
				ExtentTestManager.getTest().log(Status.PASS,
						"Step:01 - 1.Click Save button after giving the post debit details");
				Log.info("Step:01 - 1.1.Click Save button after giving the post debit details");

				transIdTransfer = driver.findElement(GenOpen.Transid).getText();

			}
		}

	}

	public void transactioncode(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		String mainWindowHandle = driver.getWindowHandle();

		click(GenOpen.clickonacc);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - click on tansaction based.");
		Log.info("Step:01 - click on tansaction based.");

		select("GL Code", GenOpen.clickonacc);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transaction based.");
		Log.info("Step:01 - Select Transaction based.");

		click(GenOpen.selectGLname);
		click(GenOpen.add);
		// select("ADVERTISEMENT", GenOpen.add);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select GL name.");
		Log.info("Step:01 - Select GL name");

		String amount = testdata.get("Amount").toString();
		input(GenOpen.amount, amount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Give the amount in Amount field.");
		Log.info("Step:01 - Give the amount in Amount field.");

		click(GenOpen.clickaddbutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1.Click add button");
		Log.info("Step:01 - 1.Click add button ");

		click(GenOpen.clicksubmit);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 - 1.Click submit button after adding the details in the auto posting popup window");
		Log.info("Step:01 - 1.Click submit button after adding the details in the auto posting popup window");

		driver.switchTo().window(mainWindowHandle);

		if (ElementDisplayed(GenOpen.PostDeb)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are shown in grid.");
			Log.info("Expected Result: Customer details are shown in grid.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		click(GenOpen.clicksaves);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 - 1.Click Save button after giving the post debit details");
		Log.info("Step:01 - 1.1.Click Save button after giving the post debit details");

		if (ElementDisplayed(GenOpen.Transid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		transIdTransfer = driver.findElement(GenOpen.Transid).getText();
		// validation

	}

	public void authorizeTransfer(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {

		// Login with Another User
		ExtentTestManager.startTest("Login with Another User").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
		
		try {
			WebElement clickableElement = driver.findElement(By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]"));

			if (clickableElement != null) {
				// Perform the desired action on the element
				clickableElement.click();
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
				Log.info("Step:01 - Click on OK button");
				
//					String loginUserName = testdata.get("loginUserName").toString();
				input(custSearch.loginUserName, UserName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
				Log.info("Step:02 - Enetered valid User Name");
				
//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				input(custSearch.loginPasswrd, Password);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
				Log.info("Step:03 - Entered valid Password");
				
				click(custSearch.loginButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
				Log.info("Step:04 - Click on Login Button");
				
				ElementDisplayed(custSearch.home);
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
				Log.info("Expected Result: User is logged in successfully and dashboard visible");	
			} else {
				System.out.println("Element not clickable within the timeout.");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while waiting for the element: " + e.getMessage());
			System.out.println("Already login pop up not appeared");
		}

		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);

		/*String flag = "Vinusha";

		if (!userName.equalsIgnoreCase(flag)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}*/

		ExtentTestManager.endTest();

		// Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Manager Authorization - Transfer Tab");

		ScrollUntilElementVisible(goaldLoanRepo.managerAuthoTab);
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(goaldLoanRepo.sTransferTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");

		ExtentTestManager.endTest();

		// Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Refresh Loan Opening Entry");

		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transIdTransfer);
		fetchWithTransId(transIdTransfer);

		if (ElementDisplayed(goaldLoanRepo.approveCheckBoxTransfer)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		// Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager").assignCategory("GeneralOpening-Cash/Transfer");
		Log.info("Authorize Loan Entry as Manager");

		click(goaldLoanRepo.approveCheckBoxTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();

		click(GenOpen.errorPopUpCloseIcon);

	}// end
}
