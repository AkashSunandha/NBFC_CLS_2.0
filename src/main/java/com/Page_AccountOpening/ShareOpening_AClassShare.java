package com.Page_AccountOpening;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn_ShareOpn_AClassShare;
import com.Page_Repositary.PageRepositary_AccOpn__GeneralLoan_SuspenseAsset;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ShareOpening_AClassShare extends Base_Class{
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_AccOpn_ShareOpn_AClassShare shareOpnRepo = new PageRepositary_AccOpn_ShareOpn_AClassShare();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn__GeneralLoan_SuspenseAsset suspenseAssetRepo = new PageRepositary_AccOpn__GeneralLoan_SuspenseAsset();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();

	String transId;
	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
	
	public void openAClasShare() throws InterruptedException {
		
		//Access Share Opening Window
		ExtentTestManager.startTest("Access Share Opening Window");
		Log.info("Access Share Opening Window");
		
		click(shareOpnRepo.accountOpeningTab);
		
		click(shareOpnRepo.shareOpnTab);

		click(shareOpnRepo.AClassShareTab);

		click(shareOpnRepo.aClassShare);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to 'Account Opening' > 'Share Opening' > 'A-class share'");
		Log.info("Step:01 - Navigate to 'Account Opening' > 'Share Opening' > 'A-class share'");

		if(ElementDisplayed(shareOpnRepo.saiCustSrchIcon)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'A-class share' opening window displays");
			Log.info("Expected Result: 'A-class share' opening window displays");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void shareAccountInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		//Search Customer by Name
		ExtentTestManager.startTest("Search Customer by Name");
		Log.info("Search Customer by Name");
		
		click(shareOpnRepo.saiCustSrchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on 'Select Customer' popup button");
		Log.info("Step:01 - Click on 'Select Customer' popup button");

		String parentWindow = driver.getWindowHandle();
		
		Set<String> address = driver.getWindowHandles();
		
		for(String c : address) {
			if(!c.equals(parentWindow)) {
				driver.switchTo().window(c);
			}
		}//for end
		
		String custName = testdata.get("custName").toString();
		input(shareOpnRepo.popUpWndNameTxtBox,custName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter alphabets in 'Name' field");
		Log.info("Step:02 - Enter alphabets in 'Name' field");
		
		click(shareOpnRepo.popUpWndSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click 'Search' button");
		Log.info("Step:03 - Click 'Search' button");
		
		if(ElementDisplayed(shareOpnRepo.popUpWndSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search results display based on name input");
			Log.info("Expected Result: Customer search results display based on name input");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Select and Add Customer
		ExtentTestManager.startTest("Select and Add Customer");
		Log.info("Select and Add Customer");
		
		click(shareOpnRepo.popUpWndSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Select'");
		Log.info("Step:01 - Click 'Select'");

		driver.switchTo().window(parentWindow);
		
		click(shareOpnRepo.saiAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Add'");
		Log.info("Step:02 - Click 'Add'");
		
		if(ElementDisplayed(shareOpnRepo.saiCustDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer info added to the form successfully");
			Log.info("Expected Result: Customer info added to the form successfully");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Valid Resolution Date Entry
		ExtentTestManager.startTest("Valid Resolution Date Entry");
		Log.info("Valid Resolution Date Entry");
		
		click(shareOpnRepo.saiResolutionDateTxtBox);
		String resolutionDate = testdata.get("resolutionDate").toString();
		input(shareOpnRepo.saiResolutionDateTxtBox,resolutionDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Use date picker to select a valid date in the 'Resolution Date' field");
		Log.info("Step:01 - Use date picker to select a valid date in the 'Resolution Date' field");
		
		click(shareOpnRepo.saiTotalTxt);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected date is accepted and displayed in the field");
		Log.info("Expected Result: Selected date is accepted and displayed in the field");
		
		ExtentTestManager.endTest();
		
		
		
		//Select 'Referred By' Dropdown
		ExtentTestManager.startTest("Select 'Referred By' Dropdown");
		Log.info("Select 'Referred By' Dropdown");
		
		select("SUNIL",shareOpnRepo.saiReferredByDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from the 'Referred By' dropdown list");
		Log.info("Step:01 - Select an item from the 'Referred By' dropdown list");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item appears in the 'Referred By' field");
		Log.info("Expected Result: Selected item appears in the 'Referred By' field");
		
		ExtentTestManager.endTest();
		
		

		//Enter Remarks
		ExtentTestManager.startTest("Enter Remarks");
		Log.info("Enter Remarks");
		
		String remark = testdata.get("remark").toString();
		input(shareOpnRepo.saiRemarkTxtBox,remark);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphanumeric data in the 'Remarks' field");
		Log.info("Step:01 - Enter alphanumeric data in the 'Remarks' field");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks field accepts alphanumeric input and displays it correctly");
		Log.info("Expected Result: Remarks field accepts alphanumeric input and displays it correctly");
		
		ExtentTestManager.endTest();
		
		

		//Enter Number of Shares
		ExtentTestManager.startTest("Enter Number of Shares");
		Log.info("Enter Number of Shares");
		
		click(shareOpnRepo.saiNumOfSharesTxtBox);
		String shares = testdata.get("shares").toString();
		input(shareOpnRepo.saiNumOfSharesTxtBox,shares);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter `No of  share` in the 'No of shares' field");
		Log.info("Step:01 - Enter `No of  share` in the 'No of shares' field");
		
		click(shareOpnRepo.saiTotalTxt);
		
		String perShareValue0 = driver.findElement(shareOpnRepo.saiPerShareValueTxtBox).getAttribute("value");
		double perShareValue = Double.parseDouble(perShareValue0);
		System.out.println("perShareValue: "+perShareValue);
		
		String totalValue0 = driver.findElement(shareOpnRepo.saiTotalTxtBox).getAttribute("value");
		double totalValue = Double.parseDouble(totalValue0);
		System.out.println("totalValue: "+totalValue);
		
		String seriesNumValue0 = driver.findElement(shareOpnRepo.saiSeriesNumTxtBox).getAttribute("value");
		
		String totalShareValue0 = driver.findElement(shareOpnRepo.saiTotalShareValueTxtBox).getAttribute("value");
		double totalShareValue = Double.parseDouble(totalShareValue0);
		System.out.println("totalShareValue: "+totalShareValue);
		
		int sharesValue = Integer.parseInt(shares);
		System.out.println("sharesValue: "+sharesValue);
		
		double actualTotal = sharesValue*perShareValue;
		System.out.println("actualTotal: "+actualTotal);
		
		if(actualTotal==totalValue && actualTotal==totalShareValue && !seriesNumValue0.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Total', 'series No', and 'Total share value' auto populate accurately based on input");
			Log.info("Expected Result: 'Total', 'series No', and 'Total share value' auto populate accurately based on input");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
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
		
		
		
//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

		
	}//end	
public void transModeCash() throws InterruptedException {
	
	//Select Transaction Mode
	ExtentTestManager.startTest("Select Transaction Mode");
	Log.info("Select Transaction Mode");
	
	ScrollUntilElementVisible(shareOpnRepo.saveBtn);
	select("CASH",shareOpnRepo.saiTransModeDropDown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Cash' from 'Trans.Mode' options");
	Log.info("Step:01 - Select 'Cash' from 'Trans.Mode' options");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Cash' option is highlighted as selected");
	Log.info("Expected Result: 'Cash' option is highlighted as selected");
	
	ExtentTestManager.endTest();
	
}//end


public void transModeTransfer() throws InterruptedException {
	
	//Select Transaction Mode
	ExtentTestManager.startTest("Select Transaction Mode");
	Log.info("Select Transaction Mode");
	
	ScrollUntilElementVisible(shareOpnRepo.saveBtn);
	select("TRANSFER",shareOpnRepo.saiTransModeDropDown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'TRANSFER' from 'Trans.Mode' options");
	Log.info("Step:01 - Select 'TRANSFER' from 'Trans.Mode' options");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'TRANSFER' option is highlighted as selected");
	Log.info("Expected Result: 'TRANSFER' option is highlighted as selected");
	
	ExtentTestManager.endTest();
	
}//end

public void submitTrans() throws InterruptedException {
	
	//Save Share Entry
	ExtentTestManager.startTest("Save Share Entry");
	Log.info("Save Share Entry");
	
	click(shareOpnRepo.saveBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Save' button");
	Log.info("Step:01 -  Click 'Save' button");
	
	if(ElementDisplayed(shareOpnRepo.summaryTransId)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is saved successfully with confirmation message");
		Log.info("Expected Result: Entry is saved successfully with confirmation message");
		
		transId = driver.findElement(shareOpnRepo.summaryTransId).getText();
		System.out.println("transId: "+transId);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}

	ExtentTestManager.endTest();
			
}


public void selectCashAndSubmit() throws InterruptedException {
	
	transModeCash();
	
	submitTrans();
	
}

public void selectTransferAndSubmit() throws InterruptedException {
	
	transModeTransfer();
	
	postCreditPopUpEntry();
	
	submitTrans();
	
}

public void postCreditPopUpEntry() throws InterruptedException {
	//Post credit button functionality
			ExtentTestManager.startTest("Post credit button functionality");
			Log.info("Post credit button functionality");
			
			click(shareOpnRepo.postCreditBtn);
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
		         
		    		
		            if(ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
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
		    		
		            if(ElementDisplayed(shareOpnRepo.postCreditBtn)) { 
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
}


public void authorizeTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

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
	
	if(ElementDisplayed(suspenseAssetRepo.errorPopUpCloseIcon)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");
		click(suspenseAssetRepo.errorPopUpCloseIcon);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}


	ExtentTestManager.endTest();
	
	
}//end
	

	
	
}
