package com.Page_GroupLoans;

import java.io.IOException;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanPayment;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanPayment extends Base_Class{

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_GroupLoans_GroupLoanPayment grpLoanPayRepo = new PageRepositary_GroupLoans_GroupLoanPayment();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();

	String transId;
	By lastSelectXPath;
	By lastCheckBoxXPath;
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
	
	
	public void groupLoanPayment() throws InterruptedException {
		
		//Navigation of  group loan Payment page
		ExtentTestManager.startTest("Navigation of  group loan Payment page");
		Log.info("Navigation of  group loan Payment page");
		
		click(grpLoanPayRepo.groupLoansTab);
		
		click(grpLoanPayRepo.groupLoansPaymentTab);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan Payment page.\"");
		Log.info("\"1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan Payment page.\"");
		
		if(ElementDisplayed(grpLoanPayRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Retrieving data. Wait a few seconds and try to cut or copy again.");
			Log.info("Expected Result: " +  "Retrieving data. Wait a few seconds and try to cut or copy again.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupInfo() throws InterruptedException {
		
			//Centre Selection
			ExtentTestManager.startTest("Centre Selection");
			Log.info("Centre Selection");
				
			select("14 - GUARANTOR",grpLoanPayRepo.giCentreDropdown);
			ExtentTestManager.getTest().log(Status.PASS, "\"1. Open centre dropdown\r\n"
					+ "2. Select any centre");
			Log.info("\"1. Open centre dropdown\r\n"
					+ "2. Select any centre");
				
			waitUntilElementDisappear(grpLoanPayRepo.loader);
				
			if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanPayRepo.giCentreDropdown)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Centre is selected from dropdown ");
				Log.info("Expected Result: " + "Centre is selected from dropdown ");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
				
			ExtentTestManager.endTest();
			
				
				
			//Group Selection
			ExtentTestManager.startTest("Group Selection");
			Log.info("Group Selection");
				
			select("25 - GUARANTOR 3",grpLoanPayRepo.GiGroupDropdown);
			ExtentTestManager.getTest().log(Status.PASS, "\"1. Open group dropdown\r\n"
					+ "2. Select a group\r\n"
					+ "3. Verify selection\"");
			Log.info("\"1. Open group dropdown\r\n"
					+ "2. Select a group\r\n"
					+ "3. Verify selection\"");
				
			waitUntilElementDisappear(grpLoanPayRepo.loader);
				
			if(dropdownSelectionValidation("25 - GUARANTOR 3",grpLoanPayRepo.GiGroupDropdown)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group is selected from dropdown");
				Log.info("Expected Result: " + "Group is selected from dropdown");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
				
			ExtentTestManager.endTest();
				
				
				
//			GO Button Functionality
			ExtentTestManager.startTest("GO Button Functionality");
			Log.info("GO Button Functionality");
						
			click(grpLoanPayRepo.giGoBtn);
			ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
			Log.info("1. Click on the Go button.");
				
			waitUntilElementDisappear(grpLoanPayRepo.loader);

			if(ElementDisplayed(grpLoanPayRepo.giSelect)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Applications are listed in a grid");
				Log.info("Expected Result: " + "Applications are listed in a grid");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
				
			ExtentTestManager.endTest();

		
	}//end
	
	
	public void applicationList() throws InterruptedException {
		
//		Loan Details Loading
		ExtentTestManager.startTest("Loan Details Loading");
		Log.info("Loan Details Loading");

	       WebElement table = driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvApplication\"]"));
	       
	        // Find all <tr> elements in the table
	        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
	 	        
	        // Output the number of <tr> tags
	        System.out.println("Number of rows in the table: " + rows.size());
	        int lastRow = rows.size();
	        System.out.println("lastRow: " + lastRow);
	        
	        if(lastRow<10) {
			String xpath = "//td[*[@id='ctl00_ctl00_CPH1_PRDCNT_gdvApplication_ctl0"+ lastRow +"_lblLoanAmt']]//following-sibling::td//a[text()='Select']";
			lastSelectXPath = By.xpath(xpath);
	        }else {
				String xpath = "//td[*[@id='ctl00_ctl00_CPH1_PRDCNT_gdvApplication_ctl0"+ lastRow +"_lblLoanAmt']]//following-sibling::td//a[text()='Select']";
				lastSelectXPath = By.xpath(xpath);
	        }
			
//	    ScrollUntilElementVisible(lastSelectXPath);
		click(lastSelectXPath);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on Select button");
		Log.info("1. Click on Select button");
			
		waitUntilElementDisappear(grpLoanPayRepo.loader);

		if(ElementDisplayed(grpLoanPayRepo.ldApplicationNumTxtBox) && ElementDisplayed(grpLoanPayRepo.ldCentreNameTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Loan Details are loaded");
			Log.info("Expected Result: " + "Loan Details are loaded");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
			
		ExtentTestManager.endTest();
		
		
		
//		Checkbox Selection
		ExtentTestManager.startTest("Checkbox Selection");
		Log.info("Checkbox Selection");
		
		ScrollUntilElementVisible(grpLoanPayRepo.saveBtn);

	            
	      java.util.List<WebElement> rowsCount = driver.findElements(By.tagName("tr"));

	      int totalRows = rowsCount.size();
	      System.out.println("totalRows: " + totalRows);
	            
	      boolean checkboxClicked = false;
	      
	      if(checkboxClicked==false) {
	         for(int i=2;i<=totalRows;i++) {
	    		String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl0"+ i +"_chkShelect']";
	    		lastCheckBoxXPath = By.xpath(xpath);
	    		
		          	if(ElementEnabled(lastCheckBoxXPath)){
		        	   click(lastCheckBoxXPath);
		        	   checkboxClicked=true;
		        	   break;
		           }
		          	
	            }
	      }

	            
	        
//		click(grpLoanPayRepo.ldCustDetailsCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "1.  Tick the checkbox is  near 'payment status'");
		Log.info("1. Tick the checkbox is  near 'payment status'");
			
		waitUntilElementDisappear(grpLoanPayRepo.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Checkbox is ticked");
		Log.info("Expected Result: " + "Checkbox is ticked");
			
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void transModeCash() throws InterruptedException {
	
		//Transaction Mode Selection
		ExtentTestManager.startTest("Transaction Mode Selection");
		Log.info("Transaction Mode Selection");
			
		select("CASH",grpLoanPayRepo.ldTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Cash' in transaction mode");
		Log.info("1. Select 'Cash' in transaction mode");
			
		waitUntilElementDisappear(grpLoanPayRepo.loader);
			
		if(dropdownSelectionValidation("CASH",grpLoanPayRepo.ldTransModeDropdown)) {
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
			
		select("TRANSFER",grpLoanPayRepo.ldTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "1. Select 'Transfer' in transaction mode");
		Log.info("1. Select 'Transfer' in transaction mode");
			
		waitUntilElementDisappear(grpLoanPayRepo.loader);
			
		if(dropdownSelectionValidation("TRANSFER",grpLoanPayRepo.ldTransModeDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Transfer' is selected as transaction mode");
			Log.info("Expected Result: " + "Transfer' is selected as transaction mode");
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
				
				click(grpLoanPayRepo.postCreditBtn);
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
			    		
			            if(ElementDisplayed(grpLoanPayRepo.postCreditBtn)) { 
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
	
	
	public void clickSaveBtn() throws InterruptedException {
		
//		Save Button Functionality
		ExtentTestManager.startTest("Save Button Functionality");
		Log.info("Save Button Functionality");
				
		click(grpLoanPayRepo.saveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on Save button");
		Log.info("1. Click on Save button");
			
		waitUntilElementDisappear(grpLoanPayRepo.loader);

		if(ElementDisplayed(grpLoanPayRepo.transId)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group Loan payment is saved successfully, Navigated to summary page");
		Log.info("Expected Result: " + "Group Loan payment is saved successfully, Navigated to summary page");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		transId = driver.findElement(grpLoanPayRepo.transId).getText();
		System.out.println("transId: " + transId);
		
		ExtentTestManager.endTest();
		
	}//end


	public void authorizeCash() throws InterruptedException, IOException {		

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
