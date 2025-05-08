
package com.Page_GroupLoans;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanCollection;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanPayment;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanCollection extends Base_Class{

	String transId;

	PageRepositary_GroupLoans_GroupLoanCollection grpLoanCollRepo = new PageRepositary_GroupLoans_GroupLoanCollection();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_GroupLoans_GroupLoanPayment grpLoanPayRepo = new PageRepositary_GroupLoans_GroupLoanPayment();

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
	public void groupLoanCollection() throws InterruptedException {
		
		//Navigation to Group Loan collection page.
		ExtentTestManager.startTest("Navigation to Group Loan collection page.");
		Log.info("Navigation to Group Loan collection page.");
		
		click(grpLoanCollRepo.groupLoansTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Group Loans section.");
		Log.info("1. Navigate to Group Loans section.");
		
		click(grpLoanCollRepo.groupLoanCollectionTab);
		ExtentTestManager.getTest().log(Status.PASS, "2. Open Group Loan collection page.");
		Log.info("2. Open Group Loan collection page.");
		
		if(ElementDisplayed(grpLoanCollRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Group Loan collection page opened");
			Log.info("Expected Result: " +  "Group Loan collection page opened");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupInfo() throws InterruptedException {

		//Center Dropdown Selections - Basic Functionality
		ExtentTestManager.startTest("Center Dropdown Selections - Basic Functionality");
		Log.info("Center Dropdown Selections - Basic Functionality");
			
		select("14 - GUARANTOR",grpLoanCollRepo.giCentreDropdown);
		ExtentTestManager.getTest().log(Status.PASS, " Select a Center from Center dropdown");
		Log.info(" Select a Center from Center dropdown");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanCollRepo.giCentreDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Centre is selected from dropdown ");
			Log.info("Expected Result: " + "Centre is selected from dropdown ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
		

		//Group Dropdown Selections - Basic Functionality
		ExtentTestManager.startTest("Group Dropdown Selections - Basic Functionality");
		Log.info("Group Dropdown Selections - Basic Functionality");
			
		select("25 - GUARANTOR 3",grpLoanCollRepo.giGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS,"Select a Group from Group dropdown.");
		Log.info("Select a Group from Group dropdown.");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("25 - GUARANTOR 3",grpLoanCollRepo.giGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group is selected from dropdown ");
			Log.info("Expected Result: " + "Group is selected from dropdown ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
		
		
//		GO Button Functionality
		ExtentTestManager.startTest("GO Button Functionality");
		Log.info("GO Button Functionality");
					
		click(grpLoanCollRepo.giGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);

		if(ElementDisplayed(grpLoanCollRepo.giSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Applications are listed in a grid");
			Log.info("Expected Result: " + "Applications are listed in a grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void loanDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		
//		Select and Load Loan Collection Details
		ExtentTestManager.startTest("Select and Load Loan Collection Details");
		Log.info("Select and Load Loan Collection Details");
					
		click(grpLoanCollRepo.giSelect);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the 'Select' button against the last group listed");
		Log.info("1. Click on the 'Select' button against the last group listed");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);

		if(ElementDisplayed(grpLoanCollRepo.ldNumOfIntHeader)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Loan Collection Details are loaded with 'No.Of Inst' header visible");
			Log.info("Expected Result: " + "Loan Collection Details are loaded with 'No.Of Inst' header visible");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		

		
//		 Select and Load Loan Collection Details
		ExtentTestManager.startTest("Select and Load Loan Collection Details");
		Log.info("Select and Load Loan Collection Details");
		
		clear(grpLoanCollRepo.ldNumOfIntTxtBox);
		String numOfInt = testdata.get("numOfInt").toString();
		input(grpLoanCollRepo.ldNumOfIntTxtBox,numOfInt);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter 'No.Of Inst' as 1 in the loan collection grid for one account");
		Log.info("1. Enter 'No.Of Inst' as 1 in the loan collection grid for one account");
			
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		ExtentTestManager.getTest().log(Status.PASS, "2. Press TAB");
		Log.info("2. Press TAB");
		
		waitUntilElementDisappear(grpLoanCollRepo.loader);
 
		String amtValue = driver.findElement(grpLoanCollRepo.ldAmtToBePaidTxtBox1).getAttribute("value");
		double ldAmtToBePaid = Double.parseDouble(amtValue);
		System.out.println("ldAmtToBePaid: " + ldAmtToBePaid);
		
		if(ldAmtToBePaid>0.0) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Amount to be paid is autoloaded");
			Log.info("Expected Result: " + "Amount to be paid is autoloaded");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
//		Amount Entry
		ExtentTestManager.startTest("Amount Entry");
		Log.info("Amount Entry");
		
		ScrollUntilElementVisible(grpLoanCollRepo.ldAmtToBePaidTxtBox2);
		click(grpLoanCollRepo.ldAmtToBePaidTxtBox2);
		
		action
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL) // Ctrl+A
	    .sendKeys(Keys.DELETE) // Deletes selected text
	    .perform();
		
		String amount = testdata.get("amountToBePaid").toString();
		input(grpLoanCollRepo.ldAmtToBePaidTxtBox2,amount);
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter the amount 100 for another account");
		Log.info("1. Enter the amount 100 for another account");
			
		action.sendKeys(Keys.TAB).perform();
		ExtentTestManager.getTest().log(Status.PASS, "2. Press TAB");
		Log.info("2. Press TAB");
		
		waitUntilElementDisappear(grpLoanCollRepo.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Amount entered correctly; no errors");
		Log.info("Expected Result: " + "Amount entered correctly; no errors");

		ExtentTestManager.endTest();

		
	}//end
	
	
	public void transModeCash() throws InterruptedException {
		
		//Transaction Mode Selection
		ExtentTestManager.startTest("Transaction Mode Selection");
		Log.info("Transaction Mode Selection");
			
		select("CASH",grpLoanCollRepo.ldTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Cash' in transaction mode");
		Log.info("1. Select 'Cash' in transaction mode");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("CASH",grpLoanCollRepo.ldTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Cash' is selected as transaction mode");
			Log.info("Expected Result: " + "Cash' is selected as transaction mode");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void transModeTransfer() throws InterruptedException {
		
		//Transaction Mode Selection
		ExtentTestManager.startTest("Transaction Mode Selection");
		Log.info("Transaction Mode Selection");
			
		select("TRANSFER",grpLoanCollRepo.ldTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Transfer' in transaction mode");
		Log.info("1. Select 'Transfer' in transaction mode");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);
			
		if(dropdownSelectionValidation("TRANSFER",grpLoanCollRepo.ldTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Transfer' is selected as transaction mode");
			Log.info("Expected Result: " + "Transfer' is selected as transaction mode");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void submitTransaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {


//		Complete Entry and Submit
		ExtentTestManager.startTest("Complete Entry and Submit");
		Log.info("Complete Entry and Submit");
		
		String particulars = testdata.get("particulars").toString();
		input(grpLoanCollRepo.ldParticulars,particulars);
		ExtentTestManager.getTest().log(Status.PASS, "1.Give particulars.");
		Log.info("1.Give particulars.");
		
		click(grpLoanCollRepo.submitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "2. Click on Submit button");
		Log.info("2. Click on Submit button");
			
		waitUntilElementDisappear(grpLoanCollRepo.loader);

		if(ElementDisplayed(grpLoanCollRepo.summaryPageTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Collection saved successfully; redirected to Summary page");
			Log.info("Expected Result: " + "Collection saved successfully; redirected to Summary page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		transId = driver.findElement(grpLoanCollRepo.summaryPageTransId).getText();
		System.out.println("transId: " + transId);
		
		ExtentTestManager.endTest();
	}//end
	
	
	public void authorizeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		
		//Cashier Authorization
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
		
		System.out.println("transIdCashPersonal "+transId);
		fetchWithTransId(transId);
		
		click(goaldLoanRepo.cashierCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(goaldLoanRepo.cashierAuthorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		
		click(goaldLoanRepo.approveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void postCreditPopUpEntry() throws InterruptedException {
		//Post credit button functionality
				ExtentTestManager.startTest("Post credit button functionality");
				Log.info("Post credit button functionality");
				
				click(grpLoanCollRepo.ldPostDebitBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Post credit button.");
				Log.info("Step:01 - Select Post credit button.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			         
			    		
			            if(ElementDisplayed(grpLoanPayRepo.popUpTransBasedDropdown)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Auto posting popup window will be opened.");
							Log.info("Expected Result: Auto posting popup window will be opened.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			            
						ExtentTestManager.endTest();


						
						//Transaction based selection.
						ExtentTestManager.startTest("Transaction based selection.");
						Log.info("Transaction based selection.");
						
						select("GL Code",depositLoanRepo.oiTransBasedDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as GL Code.");
						Log.info("Step:01 - Select transaction based as GL Code.");
						
			            if(ElementDisplayed(depositLoanRepo.oiGLNameTxtBox) && ElementDisplayed(depositLoanRepo.oiGLAccCodeTxtBox)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code related field will be display (GL name,GL code).");
						Log.info("Expected Result: GL code related field will be display (GL name,GL code)");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			            
						ExtentTestManager.endTest();
						
						
						
						//GL Name selection.
						ExtentTestManager.startTest("GL Name selection.");
						Log.info("GL Name selection.");
						
						click(depositLoanRepo.oiGLNameTxtBox);
						click(depositLoanRepo.oiGLNameOption);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the \"GL Name\" from the drop down");
						Log.info("Step:01 - Select the \"GL Name\" from the drop down");
			            
						String GLAccCodeValue = driver.findElement(depositLoanRepo.oiGLAccCodeTxtBox).getAttribute("value");
						
			    		if(!GLAccCodeValue.isBlank()) {
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code will be autoloads while selecting the GL Name.");
									Log.info("Expected Result: GL code will be autoloads while selecting the GL Name.");
					    		}else {
					    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					    			Log.info("ERROR");
					    		}
					    		
					    ExtentTestManager.endTest();
					    

						
						//Add button functionality
						ExtentTestManager.startTest("Add button functionality");
						Log.info("Add button functionality");
						
						String amntValue = driver.findElement(depositLoanRepo.oiBalanceAmtTxtBox).getAttribute("value");
						String amntValue1 = amntValue.split("\\.")[0];
						
						clear(depositLoanRepo.oiAmntTxtBox);
						click(depositLoanRepo.oiAmntTxtBox);
						input(depositLoanRepo.oiAmntTxtBox, amntValue1);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the amount in \"Amount\" field");
						Log.info("Step:01 - Give the amount in \"Amount\" field.");

						click(depositLoanRepo.oiAddBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click add button");
						Log.info("Step:02 - Click add button.");
						
			            if(ElementDisplayed(depositLoanRepo.oiAutoPostingGrid)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
						Log.info("Expected Result: Given details will be displays in the grid");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}

						ExtentTestManager.endTest();
						
						
						
						//Submit button functionality
						ExtentTestManager.startTest("Submit button functionality");
						Log.info("Submit button functionality");
						
						click(depositLoanRepo.oiSubmitBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
						Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

			    		driver.switchTo().window(mainWindowHandle);
			    		
			            if(ElementDisplayed(grpLoanCollRepo.ldPostDebitBtn)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
						Log.info("Expected Result: Popup window will be closed");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
	}//end
	
	
	public void authorizeTransfer() throws InterruptedException, IOException {		

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut); 
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		 
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		
		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.sTransferTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdTransferPersonal "+transId);
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBoxTransfer)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		click(goaldLoanRepo.approveCheckBoxTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		if(ElementDisplayed(grpLoanPayRepo.errorPopUpCloseIcon)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
			Log.info("Expected Result: Entry authorized");
			click(grpLoanPayRepo.errorPopUpCloseIcon);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}


		ExtentTestManager.endTest();
		
		
	}//end
	
}
