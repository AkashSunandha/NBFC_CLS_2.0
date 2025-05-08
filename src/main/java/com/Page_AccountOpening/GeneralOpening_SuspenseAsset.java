package com.Page_AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__GeneralLoan_SuspenseAsset;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GeneralOpening_SuspenseAsset extends Base_Class{

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn__GeneralLoan_SuspenseAsset suspenseAssetRepo = new PageRepositary_AccOpn__GeneralLoan_SuspenseAsset();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();

	
	String transId; 
	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
	public void generalOpening() throws InterruptedException {
		
		//Navigate to General Opening
		ExtentTestManager.startTest("Navigate to General Opening");
		Log.info("Navigate to General Opening");
		
		click(suspenseAssetRepo.accountOpeningTab);
		
		click(suspenseAssetRepo.generalOpeningTab);

		click(suspenseAssetRepo.suspenseAssetTab);

		click(suspenseAssetRepo.suspenseAssetTab_31002);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate through: Account opening -> General opening -> Suspense Asset-> Suspense Asset(31002)");
		Log.info("Step:01 - Navigate through: Account opening -> General opening -> Suspense Asset-> Suspense Asset(31002)");

		if(ElementDisplayed(suspenseAssetRepo.paiCustSrchIcon)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: General Opening page is displayed.");
			Log.info("Expected Result: General Opening page is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void productAccInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		//Customer Search Popup
		ExtentTestManager.startTest("Customer Search Popup");
		Log.info("Customer Search Popup");
		
		click(suspenseAssetRepo.paiCustSrchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Search Icon");
		Log.info("Step:01 - Click on Search Icon");

		//Navigate to Pop Up Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	            
	    		if(ElementDisplayed(suspenseAssetRepo.popUpNameTxtBox)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search popup window is opened.");
	    			Log.info("Expected Result: Customer search popup window is opened.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		

	    		//Search Customer by Name
	    		ExtentTestManager.startTest("Search Customer by Name");
	    		Log.info("Search Customer by Name");
	    		
	    		String custName = testdata.get("custName").toString();
	    		input(suspenseAssetRepo.popUpNameTxtBox, custName);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter any alphabet in the name  field.");
	    		Log.info("Step:01 - Enter any alphabet in the name  field.");
	    		
	    		click(suspenseAssetRepo.popUpSrchBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on Search button.");
	    		Log.info("Step:02 -  Click on Search button.");
	    		
	    		if(ElementDisplayed(suspenseAssetRepo.popUpSelect)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: List of customers matching criteria are displayed.");
	    			Log.info("Expected Result: List of customers matching criteria are displayed.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		
	    		
	    		//Select and Open Customer Details
	    		ExtentTestManager.startTest("Select and Open Customer Details");
	    		Log.info("Select and Open Customer Details");
	    		
	    		click(suspenseAssetRepo.popUpSelect);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the search result list.");
	    		Log.info("Step:01 - Select a customer from the search result list.");
	    		
	    		driver.switchTo().window(mainWindowHandle);
	    		
	       		click(suspenseAssetRepo.paiAddBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Add Button.");
	    		Log.info("Step:02 - Click Add Button.");
	    		
	    		String flag = driver.findElement(suspenseAssetRepo.paiCustIdTxtBox).getAttribute("value");
	    		System.out.println("CustId: "+flag);
	    		
	    		if(ElementDisplayed(suspenseAssetRepo.paiCustDetailsGrid)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are shown in grid.");
					Log.info("Expected Result: Customer details are shown in grid.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	            break;	
	            
	        }
	   
	    }//for loop end
		
		
		
		//Enter Opening Amount
		ExtentTestManager.startTest("Enter Opening Amount");
		Log.info("Enter Opening Amount");
		
		String openingAmt = testdata.get("openingAmt").toString();
		click(suspenseAssetRepo.paiOPeningAmtTxtBox);
		input(suspenseAssetRepo.paiOPeningAmtTxtBox, openingAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid numeric value into the 'Opening Amount 'field.");
		Log.info("Step:01 - Enter valid numeric value into the 'Opening Amount 'field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Value is accepted as valid input.");
		Log.info("Expected Result: Value is accepted as valid input.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Remarks
		ExtentTestManager.startTest("Enter Remarks");
		Log.info("Enter Remarks");
		
		String remark = testdata.get("remark").toString();
		input(suspenseAssetRepo.paiRemarkTxtBox, remark);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter text into the Remarks field.");
		Log.info("Step:01 - Enter text into the Remarks field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Text is accepted; field allows non-mandatory input");
		Log.info("Expected Result: Text is accepted; field allows non-mandatory input");
		
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
	
		String authorizeUserName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(authorizeUserName);
		
		
		if(!authorizeUserName.equalsIgnoreCase(custSrchMtds.actualUserName)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
			Log.info("Expected Result: Logging successfull with another user");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		ExtentTestManager.endTest();
		
		
		

		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		
		

		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");
		 

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
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is created");
		Log.info("Expected Result: Account is created");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

		
	}//end
	
	
	
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
	
	
	
	public void transModeCash() throws InterruptedException {
		
		//Select Transaction Mode as Cash
		ExtentTestManager.startTest("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		select("CASH",suspenseAssetRepo.paiTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'.");
		Log.info("Step:01 - Select Trans. Mode 'Cash'.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the cash trasaction mode");
		Log.info("Expected Result: Possible to select the cash trasaction mode");
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void transModeTransfer() throws InterruptedException {
		
		//Select Transaction Mode as TRANSFER
		ExtentTestManager.startTest("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		select("TRANSFER",suspenseAssetRepo.paiTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'TRANSFER'.");
		Log.info("Step:01 - Select Trans. Mode 'TRANSFER'.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the TRANSFER trasaction mode");
		Log.info("Expected Result: Possible to select the TRANSFER trasaction mode");
		
		ExtentTestManager.endTest();
		
	}//end
	
	public void submitTrans() throws InterruptedException {
		
		//Submit the transaction
				ExtentTestManager.startTest("Submit the Transaction");
				Log.info("Submit the transaction");
				
				click(suspenseAssetRepo.paiSaveBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'save'");
				Log.info("Step:01 - Click 'save'");
				

				if(ElementDisplayed(suspenseAssetRepo.summaryTransId)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirects to summary page");
				Log.info("Expected Result: Redirects to summary page");
				
				transId = driver.findElement(suspenseAssetRepo.summaryTransId).getText();

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
				
				click(suspenseAssetRepo.paiPostCreditBtn);
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
			    		
			            if(ElementDisplayed(suspenseAssetRepo.paiPostCreditBtn)) { 
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
	
	
	
}
