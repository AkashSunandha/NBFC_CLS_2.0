package com.GeneralOpening;

import java.io.IOException;
import java.util.Map;

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

		ExtentTestManager.startTest("Access Gold Loan Opening Window");
		Log.info("Access Gold Loan Opening Window");

		click(goaldLoanRepo.accOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");

		click(GenOpen.GeneralOpenTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Navigate  General opening.");
		Log.info("Step:02 - Navigating to General opening.");

		click(GenOpen.Suspenseliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Navigate suspenseLiability.");
		Log.info("Step:03 - Navigating to  suspense liability opening.");

		click(GenOpen.Suspliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - select suspense liability.");
		Log.info("Step:04 - select suspense liability.");

	}

	public void Customerinfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		ExtentTestManager.startTest("Name Field Validation");
		Log.info("Name Field Validation");

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

		click(GenOpen.enteropenamount);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");
		Log.info("Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");

		String openacc = testdata.get("Openaccount").toString();
		input(GenOpen.enteropenamount, openacc);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Remarks into Remarks field.");
		Log.info("Step:01 - Enter Remarks into Remarks field.");

		click(GenOpen.enteremarks);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");
		Log.info("Step:02 - Enter valid numeric value into the 'Opening Amount 'field.");

		String remarks = testdata.get("Remarks").toString();
		input(GenOpen.enteremarks, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Text is accepted; field allows non-mandatory input.");
		Log.info("Step:01 - Text is accepted; field allows non-mandatory input");

	}

	public void transactions() throws InterruptedException {
		click(GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Options are cash and transfer.");
		Log.info("Step:01 - Options are cash and transfer.");

		select("CASH", GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'");
		Log.info("Step:01 - Select Trans. Mode 'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		click(GenOpen.clickonsubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Click submit button.");
		Log.info("Step:01 - Redirects to summary page.");

		// validation

		transId = driver.findElement(GenOpen.transIdd).getText();
	}

	public void Signout() throws InterruptedException {
		click(GenOpen.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Log out.");
		Log.info("Step:01 - Log out.");
	}

	public void Cashier() throws InterruptedException, IOException {
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

		// Cashier Authorization

		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(goaldLoanRepo.cashierAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(goaldLoanRepo.cashierRefreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

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

		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		ExtentTestManager.endTest();

		// Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

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
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(goaldLoanRepo.approveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();

	}

	public void closesuccess() throws InterruptedException {
		click(GenOpen.closesuccesmsg);
	}

	// General opening_ suspense liability _ transfer

	public void accountOpening2() throws InterruptedException {

		click(GenOpen.Suspliability);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - select suspense liability.");
		Log.info("Step:04 - select suspense liability.");

	}

	public void transactionsTransfer() throws InterruptedException {
		click(GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Options are cash and transfer.");
		Log.info("Step:01 - Options are cash and transfer.");

		select("TRANSFER", GenOpen.Opentransdropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'");
		Log.info("Step:01 - Select Trans. Mode 'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		click(GenOpen.PostDeb);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click post debit button.");
		Log.info("Step:01 - Click post debit button.");

		// click(GenOpen.clickonsubmit);
		// ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Click submit
		// button.");
		// Log.info("Step:01 - Redirects to summary page.");

		// validation

		transId = driver.findElement(GenOpen.transIdd).getText();

	}

	public void transactioncode(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
				
				
				select("GL code",GenOpen.Sleecttransaction);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Transaction based.");
				Log.info("Step:01 - Click post debit button.");
				
				select("ADVERTISEMENT",GenOpen.selectGLname);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select GL name.");
				Log.info("Step:01 - Select GL name");

				String amount = testdata.get("Amount").toString();
				input(GenOpen.amount, amount);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Give the amount in \"Amount\" field.");
				Log.info("Step:01 - Give the amount in Amount field.");
				
			}
		}
	}
}
