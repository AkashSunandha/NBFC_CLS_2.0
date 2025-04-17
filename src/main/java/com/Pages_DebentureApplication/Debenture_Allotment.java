package com.Pages_DebentureApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_InvestmentTransactionCash_Transfer.InvestmentTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Debenture_Application;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import bsh.ParseException;

import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Debenture_Allotment;

public class Debenture_Allotment  extends Base_Class {


	PageRepositary_Debenture_Allotment DebAllRepo  = new PageRepositary_Debenture_Allotment();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	InvestmentTransaction_Cash_Transfer InvestmentTransaction = new InvestmentTransaction_Cash_Transfer();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	PageRepositary_Debenture_Application DebApp  = new PageRepositary_Debenture_Application();

	String totalValue;
	String transId;
	String userName1;
	String BatchID;

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(DebAllRepo.transIdTxtBox, transId);
		click(DebAllRepo.goBtn);
	}
	public void fetchWithBatchID(String BatchID) throws InterruptedException {
		input(DebAllRepo.BatchIDTxtBox, BatchID);
		click(DebAllRepo.goBtn);
	}
	
	public void NavigateToDebenture_Allotment() throws InterruptedException {
		if(ElementDisplayed(DebAllRepo.CollapseAll)) {
			click(DebAllRepo.CollapseAll);
		}
		ExtentTestManager.startTest("Navigate To Debenture_Allotment");
		Log.info("Navigate To Debenture_Allotment");
		ClickONDebenture();
		ClickonDebenture_Allotment();
		ExtentTestManager.endTest();
	}
	public void ClickONDebenture() throws InterruptedException {
		click(DebAllRepo.Debenture);
		ExtentTestManager.startTest("Clicked on Debenture");
		Log.info("Clicked on Debenture");
	}

	public void ClickOnAllotmentSearch() throws InterruptedException {
		ExtentTestManager.startTest("Search Button Functionality");
		Log.info("Search Button Functionality");		
		click(DebAllRepo.AllotmentSearch);
		ExtentTestManager.startTest("Clicked on Allotment Search");
		Log.info("Clicked on Allotment Search");
		ExtentTestManager.endTest();
	}
	public void ClickOnAllotmentProcess() throws InterruptedException {
		ExtentTestManager.startTest("Process Button Functionality");
		Log.info("Process Button Functionality");		
		click(DebAllRepo.AllotmentProcess);
		ExtentTestManager.startTest("Clicked on Allotment Process");
		Log.info("Clicked on Allotment Process");
		ExtentTestManager.endTest();
	}
	
	public void ClickOnAllotmentReturn() throws InterruptedException {
		ExtentTestManager.startTest("Return Button Functionality");
		Log.info("Return Button Functionality");		
		click(DebAllRepo.ReturnButton);
		ExtentTestManager.startTest("Clicked on Allotment Return");
		Log.info("Clicked on Allotment Return");
		ExtentTestManager.endTest();
	}
	
	public void ClickOnAllotmentReturnSubmit() throws InterruptedException {
		ExtentTestManager.startTest("Return Submit Button Functionality");
		Log.info("Return Submit Button Functionality");		
		click(DebAllRepo.ReturnSubmit);
		ExtentTestManager.startTest("Clicked on Allotment Return Submit Button");
		Log.info("Clicked on Allotment Return Submit Button");
		if (ElementDisplayed(DebAllRepo.BatchID)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			BatchID = driver.findElement(DebAllRepo.BatchID).getText();
			System.out.println("BatchID:-" + BatchID);
			System.out.println("BatchID:-" + BatchID);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		if (ElementDisplayed(DebAllRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(DebAllRepo.summaryTransId).getText();
			System.out.println("BatchID:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
	}
	
	
	

	public void ClickonDebenture_Allotment() throws InterruptedException {
		click(DebAllRepo.Debenture_Allotment);
		ExtentTestManager.startTest("Clicked on Debenture_Allotment");
		Log.info("Clicked on Debenture_Allotment");
		String Validataion =GetElementText(DebAllRepo.ValidationDebenture_AllotmentPage);
		Assert.assertEquals(Validataion, "Debenture Allotment");
		ExtentSuccessMessage("Successfully User landed on Debenture_Allotment Page");

	}
	public void SelectAllotmentBranch() throws InterruptedException {
		//		ExtentTestManager.startTest("Select Allotment Branch");
		//		Log.info("Select Allotment Branch");
		select("TRIVANDRUM",DebAllRepo.AllotmentBranch);
		ExtentSuccessMessage( "Step:01 -  Choose 'TRIVANDRUM' for Allotment Branch.");
		Log.info("Step:01 -  Choose 'TRIVANDRUM' for Allotment Branch.");
		//		ExtentTestManager.endTest();	
	}
	public void SelectAllotmentStatus() throws InterruptedException {
		ExtentTestManager.startTest("Select Allotment Status");
		Log.info("Select Allotment Status");
		select("Application Received",DebAllRepo.AllotmentStatus);
		ExtentSuccessMessage( "Step:01 -  Choose 'Application Received' for Allotment Status.");
		Log.info("Step:01 -  Choose 'Application Received' for Allotment Status.");
		ExtentTestManager.endTest();	
	}


	public void SelectDebentureType() throws InterruptedException {
		ExtentTestManager.startTest("Select Debenture Type");
		Log.info("Select Debenture Type");
		select("DEB TRAIL TRANSFER",DebAllRepo.AllotmentDebentureType);
		ExtentSuccessMessage( "Step:01 -  Choose 'DEB TRAIL TRANSFER' for Debenture Type.");
		Log.info("Step:01 -  Choose 'DEB TRAIL TRANSFER' for Debenture Type.");
		ExtentTestManager.endTest();	
	}

	public void SelectDebentureTypeCash() throws InterruptedException {
		ExtentTestManager.startTest("Select Debenture Type");
		Log.info("Select Debenture Type");
		select("DEB CASH",DebAllRepo.AllotmentDebentureType);
		ExtentSuccessMessage( "Step:01 -  Choose 'DEB CASH' for Debenture Type.");
		Log.info("Step:01 -  Choose 'DEB CASH' for Debenture Type.");
		ExtentTestManager.endTest();	
	}

	public void SelectIssueType() throws InterruptedException {
		ExtentTestManager.startTest("Select Issue Type");
		Log.info("Select Issue Type");
		select("ISSUE-DEB TRAIL TRANSFER-65",DebAllRepo.AllotmentIssueType);
		ExtentSuccessMessage( "Step:01 -  Choose 'ISSUE-DEB TRAIL TRANSFER-65' for Issue Type.");
		Log.info("Step:01 -  Choose 'ISSUE-DEB TRAIL TRANSFER-65' for Issue Type.");
		ExtentTestManager.endTest();	
	}

	public void SelectDebentureSeries() throws InterruptedException {
		ExtentTestManager.startTest("Select Debenture Series");
		Log.info("Select Debenture Series");
		select("SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062",DebAllRepo.AllotmentDebentureSeries);
		ExtentSuccessMessage( "Step:01 -  Choose 'SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062' for Debenture Series.");
		Log.info("Step:01 -  Choose 'SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062' for Debenture Series.");
		ExtentTestManager.endTest();	
	}
	public void SelectIssueTypeCash() throws InterruptedException {
		ExtentTestManager.startTest("Select Issue Type");
		Log.info("Select Issue Type");
		select("ISSUE-DEB CASH-66",DebAllRepo.AllotmentIssueType);
		ExtentSuccessMessage( "Step:01 -  Choose 'ISSUE-DEB CASH-66' for Issue Type.");
		Log.info("Step:01 -  Choose 'ISSUE-DEB CASH-66' for Issue Type.");
		ExtentTestManager.endTest();	
	}

	public void SelectDebentureSeriesCash() throws InterruptedException {
		ExtentTestManager.startTest("Select Debenture Series");
		Log.info("Select Debenture Series");
		select("SERIES-ISSUE-DEB CASH-66-SERIES-2063",DebAllRepo.AllotmentDebentureSeries);
		ExtentSuccessMessage( "Step:01 -  Choose 'SERIES-ISSUE-DEB CASH-66-SERIES-2063' for Debenture Series.");
		Log.info("Step:01 -  Choose 'SERIES-ISSUE-DEB CASH-66-SERIES-2063' for Debenture Series.");
		ExtentTestManager.endTest();	
	}

	public void Verify_Debenture_Allotment_Process_Completion() throws InterruptedException {
		//		do {
		Thread.sleep(8000);
		//		}while(ElementDisplayed(DebAllRepo.ValidationDebenture_AllotmentPage));


		//		waitUntilElementDisplayed(DebAllRepo.ValidationDebenture_AllotmentPage);
		String Progress =GetElementText(DebAllRepo.VerifyProductProcessingProgress);
		Assert.assertEquals(Progress, "100");
		ExtentSuccessMessage("Successfully User Verify Product Processing Progress");

	}

	public void Signout() throws InterruptedException {
		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");
	}

	public void Signin() throws InterruptedException, IOException {
		String UserName = configloader().getProperty("UserName");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName);
	}

	public void authorizeTransfer(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName);
		if(ElementDisplayed(DebAllRepo.CollapseAll)) {
			click(DebAllRepo.CollapseAll);
		}


		ExtentTestManager.endTest();

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(DebAllRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(DebAllRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(DebAllRepo.sTransferTab);
		ExtentSuccessMessage("Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");

		ExtentSuccessMessage("Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(DebAllRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		select("Debenture", DebAllRepo.ManagerAuthProduct_ID);

		input(DebAllRepo.MarkerID,userName1);

		click(DebAllRepo.Gobutton);
		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(DebAllRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(DebAllRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	public void authorizeTransferApplication(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName);
		if(ElementDisplayed(DebAllRepo.CollapseAll)) {
			click(DebAllRepo.CollapseAll);
		}


		ExtentTestManager.endTest();

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(DebAllRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(DebAllRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(DebAllRepo.sTransferTab);
		ExtentSuccessMessage("Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");

		ExtentSuccessMessage("Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(DebAllRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdTransferPersonal " + transId);
		fetchWithTransId(transId);

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(DebAllRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(DebAllRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

	//Click get value and Total value willbe calculated
	public void Calculate_Total_Value() throws InterruptedException {
//		ExtentTestManager.startTest("Tc:19 Calculate Total Value");

		click (DebApp.GetValue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Get Button Value");
		Log.info("Step:01 Click Get Button Value");


		String unitValue = driver.findElement(DebApp.UnitValuetextbox).getAttribute("value");
		System.out.println("unitValue:-"+unitValue);
		double num1 = Double.parseDouble(unitValue);
		System.out.println("num1:-"+num1);

		String numOfUnits = GetElementAttribute(DebApp.Noofunit,"value");
		//			String numOfUnits = null; // error
		double num2 = Double.parseDouble(numOfUnits);
		System.out.println("num2:-"+num2);

		totalValue = driver.findElement(DebApp.TotalValue).getAttribute("value");
		double actualTotalValue = Double.parseDouble(totalValue);

		double expectedTotalValue = num1*num2;

		if(actualTotalValue == expectedTotalValue) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Total value is correctly calculated and displayed");
			Log.info("Expected result:Total value is correctly calculated and displayed");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

//		ExtentTestManager.endTest();

	}


	public void postCreditPopUpEntry(Map < Object, Object > testdata) throws InterruptedException {
		InvestmentTransaction.ClickonPostDebitButton();
		ExtentTestManager.startTest("Post credit button functionality");
		//Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				if (ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
					ExtentSuccessMessage("Expected Result: Auto posting popup window will be opened.");
					Log.info("Expected Result: Auto posting popup window will be opened.");
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.endTest();

			}
		}

		InvestmentTransaction.SelectTransactionBasedDropdown();
		InvestmentTransaction.SelectGL_NAMEDropdown();
		EnterAmount(testdata);
		InvestmentTransaction.ClickonAddButton();
		InvestmentTransaction.ClickonSubmit_TransactionButton();
		driver.switchTo().window(mainWindowHandle);
		InvestmentTransaction.CheckPostDebitButton();
	}
	public void EnterAmount (Map<Object, Object> testdata) throws InterruptedException {
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Amount");
		Log.info("Enter Amount");			
		clear(DebAllRepo.Amount);
		click(DebAllRepo.Amount);
		input(DebAllRepo.Amount, totalValue);
		ExtentSuccessMessage( "Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		ExtentTestManager.endTest();
	}















	///////////////////////////////////////////////////////////////////////////////////////////

	public void Navigate_Debenture_Application() throws InterruptedException {
		userName1 = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName1);
		//ExtentTestManager.startTest("Tc:4 Navigate to Debenture Application");
		ScrollUntilElementVisible(DebApp.Debenture);
		click(DebApp.Debenture);
		click(DebApp.DebentureApplication);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Debenture");
		Log.info("Step:01 Navigate to Debenture");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click on Debenture Application");
		Log.info("Step:02 Click on Debenture Application");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Debenture Application window will be opened");
		Log.info("Expected result:Debenture application window will be opened");

		//ExtentTestManager.endTest();

	}
	//Observes Branch Field
	public void Verify_Branch_Field() throws InterruptedException {
		//ExtentTestManager.startTest("Tc: 05 Verify Branch Field");
		String branchname = driver.findElement(DebApp.Branch).getText();
		String Userbranchname = driver.findElement(DebApp.UserBranchName).getText();
		if(branchname.equals(Userbranchname) && !ElementEnableOrDisable(DebApp.Branch)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the Branch field ");
			Log.info("Step:01 Observe the Branch Field");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Branch field displays logged in branch and is not editable");
			Log.info("Expected result:Branch field displays logged in branch and is not editable.");	
		}


		else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Not displaying Branch field displays logged in branch and is not editable.");
			Log.info("Expected result: Not displaying Branch field displays logged in branch and is not editable");

		}
		//ExtentTestManager.endTest();

	}

	//Observers Application Date Field
	public void Verify_Application_DateField() throws InterruptedException, ParseException, java.text.ParseException {
		//ExtentTestManager.startTest("Tc: 06 Verify Application Date Field");

		String Date = driver.findElement(DebApp.Date).getText();
		String Datevalue =dateConversion(Date);

		if(!Date.equals(Datevalue)) {

			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the application date field ");
			Log.info("Step:01 Observe the application date Field");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Application Date displays the current date and is not changeable");
			Log.info("Expected result:Application Date displays the current date and is not changeable");	
		}


		else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: Application Date will not displays the current date and is not changeable");
			Log.info("Expected result: Application Date will not displays the current date and is not changeable.");

		}
		//ExtentTestManager.endTest();


	}

	public void AddcustomerviacustID(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException {
		//ExtentTestManager.startTest("TC:07 Add Customer Via Cust ID");

		click(DebApp.CustIDsearch);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the customer popup button");
		Log.info("Step:01 - Click the customer popup button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Popup Generates");
		Log.info("Expected Result: Customer popup Generates");

		//ExtentTestManager.endTest();

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				String customerName = testdata.get("customerName").toString();
				input(DebApp.CustName, customerName);

				//Enter an alphabets in the name field
				//ExtentTestManager.startTest("TC:08 Add Customer via Cust ID");
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter an alphabet in the name field");
				Log.info("Step:01 Enter an alphabet in the name field");
				click(DebApp.customersearch);
				Log.info("click on search button");

				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:List of customers starting letter given is listed");
				Log.info("Expected Result:List of customers starting letter given is listed");

				//ExtentTestManager.endTest();

				//select a customer
				//ExtentTestManager.startTest("TC:09 Add Customer via Cust ID");
				click(DebApp.selectcustomer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer");
				Log.info("Step:01 - Select a customer");

				ExtentTestManager.getTest().log(Status.PASS,"Expected Result:Customer is selected");
				Log.info("Expected Result:Customer is selected");

				//ExtentTestManager.endTest();

				driver.switchTo().window(mainWindowHandle);
				driver.findElement(DebApp.CustIDsearch).getAttribute("value");

				//Add customer
				//ExtentTestManager.startTest("TC:10 Add Customer via Cust ID");
				click(DebApp.Add);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 Try to Add customer");
				Log.info("Step:01 Try to Add Customer");

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is Added");
				Log.info("Expected Result: Customer is Added");
				//ExtentTestManager.endTest();

			}
			//ExtentTestManager.endTest();
		}

	}
	public void Select_Debenture_Type() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:11 Select Debenture Type Dropdown");
		select("DEB TRAIL TRANSFER",DebApp.DebType);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Debenture Type Dropdown");
		Log.info("Step:01 Open Debenture Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Type can be selected");
		Log.info("Expected result:Debenture Type can be selected");

		//ExtentTestManager.endTest();

	}

	public void Select_Debenture_TypeCash() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:11 Select Debenture Type Dropdown");
		select("DEB CASH",DebApp.DebType);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Debenture Type Dropdown");
		Log.info("Step:01 Open Debenture Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Type can be selected");
		Log.info("Expected result:Debenture Type can be selected");

		//ExtentTestManager.endTest();

	}
	public void Select_Debenture_IssueCash() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:12 Select Debenture Type Dropdown");
		select("ISSUE-DEB CASH-66",DebApp.IssueType);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Issue Type Dropdown");
		Log.info("Step:01 Open Issue Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue Type can be selected");
		Log.info("Expected result:Issue Type can be selected");

		//ExtentTestManager.endTest();

	}
	public void Select_Series_TypeCash() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:13 Select Series Type");
		select("SERIES-ISSUE-DEB CASH-66-SERIES-2063",DebApp.series);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Series Type Dropdown");
		Log.info("Step:01 Open Series Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Series Type can be selected");
		Log.info("Expected result: Series Type can be selected");

		//ExtentTestManager.endTest();

	}

	public void Select_Debenture_Issue() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:12 Select Debenture Type Dropdown");
		select("ISSUE-DEB TRAIL TRANSFER-65",DebApp.IssueType);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Issue Type Dropdown");
		Log.info("Step:01 Open Issue Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Issue Type can be selected");
		Log.info("Expected result:Issue Type can be selected");

		//ExtentTestManager.endTest();

	}
	public void Select_Series_Type() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:13 Select Series Type");
		select("SERIES-ISSUE-DEB TRAIL TRANSFER-65-SERIES-2062",DebApp.series);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Series Type Dropdown");
		Log.info("Step:01 Open Series Type Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select an Option");
		Log.info("Step:02 Select an option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Series Type can be selected");
		Log.info("Expected result: Series Type can be selected");

		//ExtentTestManager.endTest();

	}

	//TC 14: Nature Field Observes
	public void Verify_Nature_Field() throws InterruptedException {
		//ExtentTestManager.startTest("Tc: 14 Verify Nature Field");

		String nature = driver.findElement(DebApp.Nature).getText();

		if(!nature.equals("Single")) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe the Nature field ");
			Log.info("Step:01 Observe the Nature Field");

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nature field displays 'Single' by default");
			Log.info("Expected result:Nature field displays 'Single' by default");	
		}


		else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Result:Nature field will not displays 'Single' by default");
			Log.info("Expected result: Nature field will not displays 'Single' by default");

		}
		//ExtentTestManager.endTest();

	}

	public void Select_customer_Category() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:15 Select customer category");
		select("Normal",DebApp.Category);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Open Category Dropdown");
		Log.info("Step:01 Open Category Dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select Normal");
		Log.info("Step:02 Select Normal");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Normal can be selected as customer category");
		Log.info("Expected result:Normal can be selected as customer category");

		//ExtentTestManager.endTest();

	}

	//TC 17 Check unit value field - auto loaded
	public void Verify_Unit_Value() throws InterruptedException {
		//ExtentTestManager.startTest("Tc:17 Check Unit Value Field");
		// click (DebApp.UnitValuetextbox);

		if(inputValidation(DebApp.UnitValuetextbox, "1000.00")) {

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Unit Value is automatically loaded based on product");
			Log.info("Expected result: Unit Value is automatically loaded based on product");

		}

		else
		{

			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Unit Value is not automatically loaded based on product");
			Log.info("Expected result: Unit Value is not automatically loaded based on product");
		}

		//ExtentTestManager.endTest();

	}


	public void Validate_No_of_Units(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		//ExtentTestManager.startTest("Tc:18 Validate No of Units");
		click (DebApp.Noofunit);
		String numOfUnits = testdata.get("NoofUnit").toString();
		input(DebApp.Noofunit, numOfUnits);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter value '20' in No of Units field.");
		Log.info("Step:01 Enter value '20' in No of Units field.");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field accepts the value.");
		Log.info("Expected result:Field accepts the value.");

		//ExtentTestManager.endTest();

	}

	public void Submission_with_cash_transmode_Save() throws InterruptedException {
		//ExtentTestManager.startTest("TC:38 submission with cash transmode save application"); 
		click(DebApp.Save);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Save Application");
		Log.info("Step:01 Save Application");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Debenture Application save successfully");
		Log.info("Expected Result: Debenture Application save successfully");
		if (ElementDisplayed(DebAllRepo.summaryTransId)) {
			ExtentSuccessMessage("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");

			transId = driver.findElement(DebAllRepo.summaryTransId).getText();
			System.out.println("transId:-" + transId);

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		if (ElementDisplayed(DebAllRepo.BatchID)) {
			BatchID = driver.findElement(DebAllRepo.BatchID).getText();
			System.out.println("BatchID:-" + BatchID);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		//ExtentTestManager.endTest();
	}

	public void Precondition ( Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException, java.text.ParseException, ClassNotFoundException, IOException {
		ExtentTestManager.startTest("Precondition"); 
		//TC 04
		Navigate_Debenture_Application();
		
		//TC 05
		Verify_Branch_Field();
		
		//TC 06
		Verify_Application_DateField();
						
		//TC 11
		Select_Debenture_Type();
		
		//TC 12
		Select_Debenture_Issue();
		
		//TC 13
		Select_Series_Type();
		
		//TC 14
		Verify_Nature_Field();
		 
		//TC 15
		Select_customer_Category();
		
		//TC 07,08,09,10 and 16
		AddcustomerviacustID(testdata, context);

		
		//TC 17
		
		Verify_Unit_Value();
		
		//TC 18
		Validate_No_of_Units(testdata, context);
		
		//TC 19
		Calculate_Total_Value();
		
		postCreditPopUpEntry(testdata);
		
		Submission_with_cash_transmode_Save();
		
		authorizeTransferApplication(testdata, context);
		
		Signout();
		
		Signin();
		ExtentTestManager.endTest();
	}
	
	
	
	public void PreconditionCash ( Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException, java.text.ParseException, ClassNotFoundException, IOException {
		ExtentTestManager.startTest("Precondition"); 
		//TC 04
		Navigate_Debenture_Application();
		
		//TC 05
		Verify_Branch_Field();
		
		//TC 06
		Verify_Application_DateField();
						
		//TC 11
		Select_Debenture_TypeCash();
		
		//TC 12
		Select_Debenture_IssueCash();
		
		//TC 13
		Select_Series_TypeCash();
		
		//TC 14
		Verify_Nature_Field();
		 
		//TC 15
		Select_customer_Category();
		
		//TC 07,08,09,10 and 16
		AddcustomerviacustID(testdata, context);

		
		//TC 17
		
		Verify_Unit_Value();
		
		//TC 18
		Validate_No_of_Units(testdata, context);
		
		//TC 19
		Calculate_Total_Value();
		
//		postCreditPopUpEntry(testdata);
		
		Submission_with_cash_transmode_Save();
		
		authorizeCash(testdata, context);
		
		Signout();
		
		Signin();
		ExtentTestManager.endTest();
	}
	
	public void authorizeCash(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		//ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName);

		//ExtentTestManager.endTest();

		//Cashier Authorization
		//ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(DebAllRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(DebAllRepo.cashierAuthoTab);
		ExtentSuccessMessage("Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(DebAllRepo.cashierRefreshBtn);
		ExtentSuccessMessage("Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

//		System.out.println("BatchIDCashPersonal " + BatchID);
//		fetchWithBatchID(BatchID);
		
		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(DebAllRepo.cashierCheckBox);
		ExtentSuccessMessage("Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(DebAllRepo.cashierAuthorizeBtn);
		ExtentSuccessMessage("Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		//ExtentTestManager.endTest();

		//Manager Authorization - Cash Tab
		//ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");

		click(DebAllRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(DebAllRepo.cashTab);
		ExtentSuccessMessage("Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentSuccessMessage("Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		//ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		//ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(DebAllRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(DebAllRepo.approveCheckBox)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		//ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		//ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(DebAllRepo.approveCheckBox);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(DebAllRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		//ExtentTestManager.endTest();

		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end
	
	public void authorizeCash1(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		//ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(custSearch.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");

		String userName = driver.findElement(DebAllRepo.userName).getText();
		System.out.println(userName);

		//ExtentTestManager.endTest();

		//Cashier Authorization
		//ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");

		click(DebAllRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(DebAllRepo.cashierAuthoTab);
		ExtentSuccessMessage("Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(DebAllRepo.cashierRefreshBtn);
		ExtentSuccessMessage("Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");

		select("Debenture", DebAllRepo.ManagerAuthProduct_ID);

		input(DebAllRepo.MarkerID,userName1);
		click(DebAllRepo.Gobutton);
//		System.out.println("BatchIDCashPersonal " + BatchID);
//		fetchWithBatchID(BatchID);
		
//		System.out.println("transIdCashPersonal " + transId);
//		fetchWithTransId(transId);

		click(DebAllRepo.cashierCheckBox);
		ExtentSuccessMessage("Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(DebAllRepo.cashierAuthorizeBtn);
		ExtentSuccessMessage("Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		//ExtentTestManager.endTest();

		//Manager Authorization - Cash Tab
		//ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");

		click(DebAllRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(DebAllRepo.cashTab);
		ExtentSuccessMessage("Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");

		ExtentSuccessMessage("Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");

		//ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		//ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(DebAllRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		System.out.println("transIdCashPersonal " + transId);

		fetchWithTransId(transId);

		if (ElementDisplayed(DebAllRepo.approveCheckBox)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		//ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		//ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(DebAllRepo.approveCheckBox);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(DebAllRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(DebAllRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(DebAllRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		//ExtentTestManager.endTest();

		//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

	} //end
	
}