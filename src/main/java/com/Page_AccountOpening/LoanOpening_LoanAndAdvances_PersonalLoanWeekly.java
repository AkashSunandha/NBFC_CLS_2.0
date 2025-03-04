package com.Page_AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class LoanOpening_LoanAndAdvances_PersonalLoanWeekly extends Base_Class {
	String transIdCashPersonal;
	String transIdTransferPersonal;
	
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly prsnlLoanWeeklyRepo = new PageRepositary_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly();
	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	} 
	
	public void openPersonalLoanWindow() throws InterruptedException {
		
		//Open Personal Loan Weekly window
		ExtentTestManager.startTest("Open Personal Loan Weekly window");
		Log.info("Open Personal Loan Weekly window");
		
		click(prsnlLoanWeeklyRepo.accountOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");
		
		click(prsnlLoanWeeklyRepo.loanOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select loan opening.");
		Log.info("Step:02 - Select loan opening.");
		
		click(prsnlLoanWeeklyRepo.loanAndAdvancesTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select Loan & Advances.");
		Log.info("Step:03 - Select Loan & Advances.");
		
		click(prsnlLoanWeeklyRepo.personalLoanWeeeklyTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Select Personal Loan Weekly.");
		Log.info("Step:04 - Select Personal Loan Weekly.");
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.aciCustSearchIcon)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Personal Loan Weekly window is displayed.");
			Log.info("Expected Result: Personal Loan Weekly window is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void accInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		//Select Customer from Customer pop up - Pop up displayed
		ExtentTestManager.startTest("Select Customer from Customer pop up - Pop up displayed");
		Log.info("Select Customer from Customer pop up - Pop up displayed");
		
		click(prsnlLoanWeeklyRepo.aciCustSearchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on Select Customer popup button.");
		Log.info("Step:01 -  Click on Select Customer popup button.");
		
		//Navigate to Pop Up Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	            
	    		if(ElementDisplayed(prsnlLoanWeeklyRepo.popUpWndNameTxtBox)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Pop up is opened.");
	    			Log.info("Expected Result: Pop up is opened.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		

	    		//Select Customer from Customer pop up - Customer Search
	    		ExtentTestManager.startTest("Select Customer from Customer pop up - Customer Search");
	    		Log.info("Select Customer from Customer pop up - Customer Search");
	    		
	    		String custName = testdata.get("custName").toString();
	    		input(prsnlLoanWeeklyRepo.popUpWndNameTxtBox, custName);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter customer Name or alphabet.");
	    		Log.info("Step:01 - Enter customer Name or alphabet.");
	    		
	    		click(prsnlLoanWeeklyRepo.popUpWndSearchBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on Search button.");
	    		Log.info("Step:02 -  Click on Search button.");
	    		
	    		if(ElementDisplayed(prsnlLoanWeeklyRepo.popUpWndSelectBtn)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is listing.");
	    			Log.info("Expected Result: Customer is listing.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		
	    		
	    		//Select Customer from Customer pop up
	    		ExtentTestManager.startTest("Select Customer from Customer pop up");
	    		Log.info("Select Customer from Customer pop up");
	    		
	    		click(prsnlLoanWeeklyRepo.popUpWndSelectBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the select button");
	    		Log.info("Step:01 - Click on the select button");
	    		
	    		driver.switchTo().window(mainWindowHandle);
	    		
	    		String flag = driver.findElement(prsnlLoanWeeklyRepo.aciCustIdTxtBox).getAttribute("value");
	    		
	    		if(!flag.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer ID is autoloaded in the Customer ID field.");
					Log.info("Expected Result: Customer ID is autoloaded in the Customer ID field.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	            break;	
	            
	        }
	   
	    }//for loop end
	    
		
		
		//Add Button functionality
		ExtentTestManager.startTest("Add Button functionality");
		Log.info("Add Button functionality");
		
		click(prsnlLoanWeeklyRepo.aciAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Add button");
		Log.info("Step:01 - Click on Add button");
		
		try {
			
			click(prsnlLoanWeeklyRepo.aciPrvOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click ok button in the 'previous active loan' pop up");
			Log.info("Step:02 - Click ok button in the 'previous active loan' pop up");
			
			if(ElementDisplayed(prsnlLoanWeeklyRepo.aciCustDetailsGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Previous active loan' window pops up if any & Customer details get's saved in grid");
				Log.info("Expected Result: 'Previous active loan' window pops up if any & Customer details get's saved in grid");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
						
		}catch(Exception e) {
			
			if(ElementDisplayed(prsnlLoanWeeklyRepo.aciCustDetailsGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Previous active loan' window pops up if any & Customer details get's saved in grid");
				Log.info("Expected Result: 'Previous active loan' window pops up if any & Customer details get's saved in grid");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
		}
			
		ExtentTestManager.endTest();
		
		

		//Resolution No Field - BVA Validations
		ExtentTestManager.startTest("Resolution No Field - BVA Validations");
		Log.info("Resolution No Field - BVA Validations");
		
		String resolutionNum = testdata.get("resolutionNum").toString();
		input(prsnlLoanWeeklyRepo.aciResolutionNumTxtBox, resolutionNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphanumeric data  in the 'Resolution No' field in the account info tab.");
		Log.info("Step:01 - Enter alphanumeric data  in the 'Resolution No' field in the account info tab.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Resolution No. entered successfully.");
		Log.info("Expected Result: Resolution No. entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Resolution Date
		ExtentTestManager.startTest("Enter Resolution Date");
		Log.info("Enter Resolution Date");
		
		click(prsnlLoanWeeklyRepo.aciResolutionDate);
		String resolutionDate = testdata.get("resolutionDate").toString();
		input(prsnlLoanWeeklyRepo.aciResolutionDate, resolutionDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid  dates from date picker in the Resolution Date field.");
		Log.info("Step:01 - Enter valid  dates from date picker in the Resolution Date field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Resolution Date are entered successfully.");
		Log.info("Expected Result: Resolution Date are entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		//Referred By Dropdown Selection
		ExtentTestManager.startTest("Referred By Dropdown Selection");
		Log.info("Referred By Dropdown Selection");
		
		click(prsnlLoanWeeklyRepo.aciReferedByDropdown);
		click(prsnlLoanWeeklyRepo.aciDropdownOption);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from Referred By dropdown.");
		Log.info("Step:01 - Select an item from Referred By dropdown.");
		
		String referedByOption = testdata.get("referedByOption").toString();
		String referedByValue = driver.findElement(prsnlLoanWeeklyRepo.aciReferedByDropdown).getAttribute("value");
		System.out.println("referedByValue : "+referedByValue);
		
		if(referedByOption.equals(referedByValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected item is displayed.");
			Log.info("Expected Result: Selected item is displayed.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Enter Equitable Mort Reg.No
		ExtentTestManager.startTest("Enter Equitable Mort Reg.No");
		Log.info("Enter Equitable Mort Reg.No");
		
		String MortgagerRegNo = testdata.get("MortgagerRegNo").toString();
		input(prsnlLoanWeeklyRepo.aciMortgagerRegNoTxtBox, MortgagerRegNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Equitable Mort Reg.No.");
		Log.info("Step:01 - Enter Equitable Mort Reg.No.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Equitable Mort Reg.No are entered successfully.");
		Log.info("Expected Result: Equitable Mort Reg.No are entered successfully.");
		
		ExtentTestManager.endTest();
		
		
		
		//EMR Date Field - BVA Validations
		ExtentTestManager.startTest("EMR Date Field - BVA Validations");
		Log.info("EMR Date Field - BVA Validations");
		
		//invalid
		click(prsnlLoanWeeklyRepo.aciEMRDateTxtBox);
		String invalidDate = testdata.get("invalidDate").toString();
		input(prsnlLoanWeeklyRepo.aciEMRDateTxtBox, invalidDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid dates in EMR Date field.");
		Log.info("Step:01 - Enter invalid dates in EMR Date field.");
		
		click(prsnlLoanWeeklyRepo.aciRandomTxt);

		if(ElementDisplayed(prsnlLoanWeeklyRepo.invalidDatePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error on invalid dates.");
			Log.info("Expected Result: Error on invalid dates.");
			click(prsnlLoanWeeklyRepo.invalidDatePopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		clear(prsnlLoanWeeklyRepo.aciEMRDateTxtBox);
		
		//valid
//		click(prsnlLoanWeeklyRepo.aciEMRDateTxtBox);
		input(prsnlLoanWeeklyRepo.aciEMRDateTxtBox, resolutionDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid dates in EMR Date field.");
		Log.info("Step:02 - Enter valid dates in EMR Date field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid date accepted.");
		Log.info("Expected Result: Valid date accepted.");

		ExtentTestManager.endTest();
		
		

		//Agent Code Field - ECP Validations
		ExtentTestManager.startTest("Agent Code Field - ECP Validations");
		Log.info("Agent Code Field - ECP Validations");
		
		//invalid code
		String invalidCode = testdata.get("MortgagerRegNo").toString();
		input(prsnlLoanWeeklyRepo.aciAgentCodeTxtBox, invalidCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid numeric data in Agent code field");
		Log.info("Step:01 - Enter invalid numeric data in Agent code field");
		
		click(prsnlLoanWeeklyRepo.aciRandomTxt);
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.invalidCodePopUpOkBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error on invalid Code.");
			Log.info("Expected Result: Error on invalid Code.");
			click(prsnlLoanWeeklyRepo.invalidCodePopUpOkBtn);
			clear(prsnlLoanWeeklyRepo.aciAgentCodeTxtBox);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		//valid code
		String validCode = testdata.get("validCode").toString();
		input(prsnlLoanWeeklyRepo.aciAgentCodeTxtBox, validCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid numeric data in Agent code field");
		Log.info("Step:02 - Enter valid numeric data in Agent code field");
		
		click(prsnlLoanWeeklyRepo.aciRandomTxt);
		

		String agentNameValue = driver.findElement(prsnlLoanWeeklyRepo.aciAgentNameTxtBox).getAttribute("value");
		System.out.println("agentNameValue : "+agentNameValue);
		
		if(!agentNameValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent name autoloads.");
			Log.info("Expected Result: Agent name autoloads.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//DSA Code Field - ECP Validations
		ExtentTestManager.startTest("DSA Code Field - ECP Validations");
		Log.info("DSA Code Field - ECP Validations");
		
		//invalid code
		input(prsnlLoanWeeklyRepo.aciDSACodeTextBox, invalidCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter invalid numeric data in DSA code field");
		Log.info("Step:01 - Enter invalid numeric data in DSA code field");
		
		click(prsnlLoanWeeklyRepo.aciRandomTxt);
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.invalidCodePopUpOkBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error on invalid Code.");
			Log.info("Expected Result: Error on invalid Code.");
			click(prsnlLoanWeeklyRepo.invalidCodePopUpOkBtn);
			clear(prsnlLoanWeeklyRepo.aciDSACodeTextBox);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		//valid code
//		String validCode = testdata.get("validCode").toString();
		input(prsnlLoanWeeklyRepo.aciDSACodeTextBox, validCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid numeric data in DSA code field");
		Log.info("Step:02 - Enter valid numeric data in DSA code field");
		
		click(prsnlLoanWeeklyRepo.aciRandomTxt);
		

		String DSANameValue = driver.findElement(prsnlLoanWeeklyRepo.aciDSACodeTextBox).getAttribute("value");
		System.out.println("agentNameValue : "+DSANameValue);
		
		if(!DSANameValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DSA name autoloads.");
			Log.info("Expected Result: DSA name autoloads.");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Remarks Field
		ExtentTestManager.startTest("Remarks Field");
		Log.info("Remarks Field");
		
		String remarks = testdata.get("resolutionNum").toString();
		input(prsnlLoanWeeklyRepo.aciReamrkTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter alphanumeric data in Remarks field");
		Log.info("Step:01 - Enter alphanumeric data in Remarks field");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Text is saved without issues");
		Log.info("Expected Result: Text is saved without issues");
		
		ExtentTestManager.endTest();
		
		

		//Move to Securities Tab
		ExtentTestManager.startTest("Move to Securities Tab");
		Log.info("Move to Securities Tab");

		click(prsnlLoanWeeklyRepo.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click NEXT button");
		Log.info("Step:01 - Click NEXT button");
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.psPersonalSuretiesTab)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Securities tab is displayed");
			Log.info("Expected Result: Securities tab is displayed");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		  
	}//end
	
	
	public void personalSureties(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		

		//Select Personal Sureties Tab
		ExtentTestManager.startTest("Select Personal Sureties Tab");
		Log.info("Select Personal Sureties Tab");

		click(prsnlLoanWeeklyRepo.psPersonalSuretiesTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click personal surety tab");
		Log.info("Step:01 - Click personal surety tab");
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.psCustIdTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Personal Sureties tab is displayed");
			Log.info("Expected Result: Personal Sureties tab is displayed");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();
		
		
		
		
		//Customer added in security tab
				ExtentTestManager.startTest("Customer added in security tab");
				Log.info("Customer added in security tab");
				
				click(prsnlLoanWeeklyRepo.psCustSrchIcon);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on Select Customer popup button.");
				Log.info("Step:01 -  Click on Select Customer popup button.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			         
			    		
			    		String custName = testdata.get("securitiesCustName").toString();
			    		input(prsnlLoanWeeklyRepo.popUpWndNameTxtBox, custName);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter any alphabets in the   Name Field(not applicant name).");
			    		Log.info("Step:02 - Enter any alphabets in the   Name Field(not applicant name).");
			    		
			    		click(prsnlLoanWeeklyRepo.popUpWndSearchBtn);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Click on Search button.");
			    		Log.info("Step:03 -  Click on Search button.");
			    		
			    		click(prsnlLoanWeeklyRepo.popUpWndSelectBtn);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the select button");
			    		Log.info("Step:04 - Click on the select button");
			    		
			    		driver.switchTo().window(mainWindowHandle);
			    		
			    		String flag = driver.findElement(prsnlLoanWeeklyRepo.psCustIdTxtBox).getAttribute("value");
			    		
			    		if(!flag.isBlank()) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added in security tab.");
							Log.info("Expected Result: Customer is added in security tab.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
			    
				

				//Security Addition Process
				ExtentTestManager.startTest("Security Addition Process");
				Log.info("Security Addition Process");

				click(prsnlLoanWeeklyRepo.psSalaryCertCheckBox);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Salary Certificate");
				Log.info("Step:01 - Select Salary Certificate");
				
				click(prsnlLoanWeeklyRepo.psOffNameIcon);
				click(prsnlLoanWeeklyRepo.psOffNameOption);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter details in OffName, DEpt Head, Designation, Place fields");
				Log.info("Step:02 - Enter details in OffName, DEpt Head, Designation, Place fields");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the detail");
				Log.info("Expected Result: Possible to give the detail");


				ExtentTestManager.endTest();
			    
				

				//Enter Basic Pay, Net salary, Retd. Date & Remark
				ExtentTestManager.startTest("Enter Basic Pay, Net salary, Retd. Date & Remark");
				Log.info("Enter Basic Pay, Net salary, Retd. Date & Remark");

				click(prsnlLoanWeeklyRepo.psBasicPayTxtBox);
				String basicPay = testdata.get("basicPay").toString();
				input(prsnlLoanWeeklyRepo.psBasicPayTxtBox, basicPay);
				
				click(prsnlLoanWeeklyRepo.psNetSalaryTxtBox);
				input(prsnlLoanWeeklyRepo.psNetSalaryTxtBox, basicPay);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter basic pay and  net salary  details");
				Log.info("Step:01 - Enter basic pay and  net salary  details");
				
				click(prsnlLoanWeeklyRepo.psRetdDateTxtBox);
				String retdDate = testdata.get("retdDate").toString();
				input(prsnlLoanWeeklyRepo.psRetdDateTxtBox, retdDate);				
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter date in Retd. Date field");
				Log.info("Step:02 - Enter date in Retd. Date field");
				
				String remarks = testdata.get("resolutionNum").toString();
				input(prsnlLoanWeeklyRepo.psReamrksTxtBox, remarks);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter alphanumeric data in Remarks field");
				Log.info("Step:03 - Enter alphanumeric data in Remarks field");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the detail");
				Log.info("Expected Result: Possible to give the detail");

				ExtentTestManager.endTest();
				
				

				//Add Button functionality
				ExtentTestManager.startTest("Add Button functionality");
				Log.info("Add Button functionality");

				click(prsnlLoanWeeklyRepo.psAddBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click ADD button");
				Log.info("Step:01 - Click ADD button");
				
				try {
				
				click(prsnlLoanWeeklyRepo.npreviousOverDueLoanPopUpOkBtn);

				if(ElementDisplayed(prsnlLoanWeeklyRepo.psPersonalSecuGrid)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Previous active loan' window pops up if any & Securities details get's saved in grid");
					Log.info("Expected Result: 'Previous active loan' window pops up if any & Securities details get's saved in grid");
				}
				else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
				}catch(Exception e) {
					
					if(ElementDisplayed(prsnlLoanWeeklyRepo.psPersonalSecuGrid)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Previous active loan' window pops up if any & Securities details get's saved in grid");
						Log.info("Expected Result: 'Previous active loan' window pops up if any & Securities details get's saved in grid");
					}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
				}
				
				ExtentTestManager.endTest();
				
				

				//Navigate to Nominee Tab
				ExtentTestManager.startTest("Navigate to Nominee Tab");
				Log.info("Navigate to Nominee Tab");

				ScrollUntilElementVisible(prsnlLoanWeeklyRepo.nextBtn);
				click(prsnlLoanWeeklyRepo.nextBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click NEXT button");
				Log.info("Step:01 - Click NEXT button");
				
				if(ElementDisplayed(prsnlLoanWeeklyRepo.nNomineeNotReqCheckBox)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee tab is displayed");
					Log.info("Expected Result: Nominee tab is displayed");
				}
				else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
				
				ExtentTestManager.endTest();
			    
	}//end
	
	
	
	public void nominee(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {


		//Add Nominee - Untick 'Nominee Not Required'
		ExtentTestManager.startTest("Add Nominee - Untick 'Nominee Not Required'");
		Log.info("Add Nominee - Untick 'Nominee Not Required'");

		click(prsnlLoanWeeklyRepo.nNomineeNotReqCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick 'Nominee Not Required'");
		Log.info("Step:01 - Untick 'Nominee Not Required'");
		
		if(ElementDisplayed(prsnlLoanWeeklyRepo.nCustIdTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details field will be display");
			Log.info("Expected Result: Nominee details field will be display");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		
		//Customer search icon functionality
				ExtentTestManager.startTest("Customer search icon functionality");
				Log.info("Customer search icon functionality");
				
				click(prsnlLoanWeeklyRepo.nNomineeCustSrchIcon);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on Select Customer popup button.");
				Log.info("Step:01 -  Click on Select Customer popup button.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			         
			    		if(ElementDisplayed(prsnlLoanWeeklyRepo.popUpWndNameTxtBox)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer seacrh popup window will be opened.");
							Log.info("Expected Result: Customer seacrh popup window will be opened.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			    		
			    		
			    		
			    		//Search button functionality
			    				ExtentTestManager.startTest("Search button functionality");
			    				Log.info("Search button functionality");   					    		
			    		
			    		String custName = testdata.get("securitiesCustName").toString();
			    		input(prsnlLoanWeeklyRepo.popUpWndNameTxtBox, custName);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter any alphabets in the   Name Field(not applicant name).");
			    		Log.info("Step:01 - Enter any alphabets in the   Name Field(not applicant name).");
			    		
			    		click(prsnlLoanWeeklyRepo.popUpWndSearchBtn);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on Search button.");
			    		Log.info("Step:02 -  Click on Search button.");
				         
				    		if(ElementDisplayed(prsnlLoanWeeklyRepo.popUpWndSelectBtn)) {
								ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customers will be display against the given details.");
								Log.info("Expected Result: Customers will be display against the given details.");
				    		}else {
				    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				    			Log.info("ERROR");
				    		}
				    		
				    		ExtentTestManager.endTest();
				    		
				    		
				    		
				    		
				    		//Select Customer from Customer popup
				    				ExtentTestManager.startTest("Select Customer from Customer popup");
				    				Log.info("Select Customer from Customer popup");
			    		
			    		click(prsnlLoanWeeklyRepo.popUpWndSelectBtn);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the select button");
			    		Log.info("Step:01 - Click on the select button");
			    		
			    		driver.switchTo().window(mainWindowHandle);
			    		
			    		String flag = driver.findElement(prsnlLoanWeeklyRepo.nCustIdTxtBox).getAttribute("value");
			    		
			    		if(!flag.isBlank()) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected customer details will be autoloads in the fields expect \"Relation\" field");
							Log.info("Expected Result: Selected customer details will be autoloads in the fields expect \"Relation\" field.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
				
				
				
				
				//Relation drop down selection
						ExtentTestManager.startTest("Relation drop down selection");
						Log.info("Relation drop down selection");
						
						select("FRIEND",prsnlLoanWeeklyRepo.nRelationDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on Select Customer popup button.");
						Log.info("Step:01 -  Click on Select Customer popup button.");
		
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the relation from the drop down.");
						Log.info("Expected Result: Possible to select the relation from the drop down.");
		
						ExtentTestManager.endTest();
						
						
						
						//Add Button functionality
							ExtentTestManager.startTest("Add Button functionality");
							Log.info("Add Button functionality");
								
							click(prsnlLoanWeeklyRepo.nAddBtn);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button.");
							Log.info("Step:01 - Click add button.");
								    		
							if(ElementDisplayed(prsnlLoanWeeklyRepo.nNomineeDetailsGrid)) {
								ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
								Log.info("Expected Result: Given details will be displays in the grid.");
				    		}else {
				    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				    			Log.info("ERROR");
				    		}
							
				    		ExtentTestManager.endTest();
				    		
							
							
							//Move to Loan Details Tab
								ExtentTestManager.startTest("Move to Loan Details Tab");
								Log.info("Move to Loan Details Tab");
									
								click(prsnlLoanWeeklyRepo.nextBtn);
								ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click NEXT button.");
								Log.info("Step:01 - Click NEXT button.");
					
					    		if(ElementDisplayed(prsnlLoanWeeklyRepo.ldGetValues)) {
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
									Log.info("Expected Result: Given details will be displays in the grid.");
					    		}else {
					    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					    			Log.info("ERROR");
					    		}
					    		
					    		ExtentTestManager.endTest();
		
		
	}//end
	
	
	public void loanDetailsCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	
		//Limit/Sanctioned Field - ECP Validations
		ExtentTestManager.startTest("Limit/Sanctioned Field - ECP Validations");
		Log.info("Limit/Sanctioned Field - ECP Validations");
		
		String limitAmt = testdata.get("sanctionedAmt").toString();
		input(prsnlLoanWeeklyRepo.ldLimitTxtBox, limitAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numeric data in Limit/Sanctioned field.");
		Log.info("Step:01 - Enter numeric data in Limit/Sanctioned field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric data accepted.");
		Log.info("Expected Result: Numeric data accepted.");

		ExtentTestManager.endTest();
		
		
		

		//Get Values button functionality
			ExtentTestManager.startTest("Get Values button functionality");
			Log.info("Get Values button functionality");
				
			click(prsnlLoanWeeklyRepo.ldGetValues);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click GET VALUES button.");
			Log.info("Step:01 - Click GET VALUES button.");
			
			String amtValue = driver.findElement(prsnlLoanWeeklyRepo.ldAmountTxtBox).getAttribute("value");
			double num1 = Double.parseDouble(amtValue);
			String ROIValue = driver.findElement(prsnlLoanWeeklyRepo.ldROITxtBox).getAttribute("value");
			double num2 = Double.parseDouble(ROIValue);
			double actual = 0.0;
			
			if(num1>actual && num2>actual) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid data fetched.");
				Log.info("Expected Result: Valid data fetched.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			ExtentTestManager.endTest();
			

			
			//Transmode Selection
			ExtentTestManager.startTest("Transmode Selection");
			Log.info("Transmode Selection and Save");
			
			ScrollUntilElementVisible(prsnlLoanWeeklyRepo.ldTransModeDropdown);
			select("CASH",prsnlLoanWeeklyRepo.ldTransModeDropdown);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Transmode as CASH.");
			Log.info("Step:01 - Select Transmode as CASH.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transmode CASH can be selected.");
			Log.info("Expected Result: Transmode CASH can be selected.");
			
			ExtentTestManager.endTest();
			
			
			
			//Save functionality Trans. Mode - CASH
			ExtentTestManager.startTest("Save functionality Trans. Mode - CASH");
			Log.info("Save functionality Trans. Mode - CASH");
			
			click(prsnlLoanWeeklyRepo.ldSaveBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'save'");
			Log.info("Step:01 - Click 'save'");
			
			try {
				click(prsnlLoanWeeklyRepo.sSimilarDataExistsPopUpOkBtn);
				
			if(ElementDisplayed(prsnlLoanWeeklyRepo.sTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary page is displayed");
			Log.info("Expected Result: Summary page is displayed");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			transIdCashPersonal = driver.findElement(prsnlLoanWeeklyRepo.sTransId).getText();
			
			}catch(Exception e) {
				if(ElementDisplayed(prsnlLoanWeeklyRepo.sTransId)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary page is displayed");
					Log.info("Expected Result: Summary page is displayed");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
				transIdCashPersonal = driver.findElement(prsnlLoanWeeklyRepo.sTransId).getText();
			}
			ExtentTestManager.endTest();
			
			
			
			//Voucher Generation Verification
			ExtentTestManager.startTest("Voucher Generation Verification");
			Log.info("Voucher Generation Verification");
			
			click(prsnlLoanWeeklyRepo.sPrintBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click PRINT on summary page");
			Log.info("Step:01 - Click PRINT on summary page");
			
			//Navigate to Pop Up Window
		    String mainWindowHandle = driver.getWindowHandle();
		    boolean popupAppeared = false;
		    for (String handle : driver.getWindowHandles()) {
		        if (!handle.equals(mainWindowHandle)) {
		            driver.switchTo().window(handle);
		            driver.manage().window().maximize();
		            popupAppeared = true;
		         
		            String currentUrl = driver.getCurrentUrl();
		            System.out.println("currentUrl: "+currentUrl);
		            if (currentUrl.endsWith(".pdf")) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Voucher is generated correctly.");
						Log.info("Expected Result: Voucher is generated correctly.");		    		
						}else {
		    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		    			Log.info("ERROR");
		    		}
		    		
		    		ExtentTestManager.endTest();
		    		
		    		driver.close();
		    		driver.switchTo().window(mainWindowHandle);
		    		
		            break;	
		            
		        }
		   
		    }//for loop end
			
			
			
		
		
	}//end
	
	
	
	public void loanDetailsTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		
		//Limit/Sanctioned Field - ECP Validations
		ExtentTestManager.startTest("Limit/Sanctioned Field - ECP Validations");
		Log.info("Limit/Sanctioned Field - ECP Validations");
		
		String limitAmt = testdata.get("sanctionedAmt").toString();
		input(prsnlLoanWeeklyRepo.ldLimitTxtBox, limitAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter numeric data in Limit/Sanctioned field.");
		Log.info("Step:01 - Enter numeric data in Limit/Sanctioned field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric data accepted.");
		Log.info("Expected Result: Numeric data accepted.");

		ExtentTestManager.endTest();
		
		
		

		//Get Values button functionality
			ExtentTestManager.startTest("Get Values button functionality");
			Log.info("Get Values button functionality");
				
			click(prsnlLoanWeeklyRepo.ldGetValues);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click GET VALUES button.");
			Log.info("Step:01 - Click GET VALUES button.");
			
			String amtValue = driver.findElement(prsnlLoanWeeklyRepo.ldAmountTxtBox).getAttribute("value");
			double num1 = Double.parseDouble(amtValue);
			String ROIValue = driver.findElement(prsnlLoanWeeklyRepo.ldROITxtBox).getAttribute("value");
			double num2 = Double.parseDouble(ROIValue);
			double actual = 0.0;
			
			if(num1>actual && num2>actual) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Valid data fetched.");
				Log.info("Expected Result: Valid data fetched.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			ExtentTestManager.endTest();
			

			
			//Transmode Selection
			ExtentTestManager.startTest("Transmode Selection");
			Log.info("Transmode Selection and Save");
			
			ScrollUntilElementVisible(prsnlLoanWeeklyRepo.ldTransModeDropdown);
			select("TRANSFER",prsnlLoanWeeklyRepo.ldTransModeDropdown);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Transmode as TRANSFER.");
			Log.info("Step:01 - Select Transmode as TRANSFER.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transmode TRANSFER can be selected.");
			Log.info("Expected Result: Transmode TRANSFER can be selected.");
			
			ExtentTestManager.endTest();
			
			
			
			//Post credit button functionality
			ExtentTestManager.startTest("Post credit button functionality");
			Log.info("Post credit button functionality");
			
			click(prsnlLoanWeeklyRepo.ldPostCreditBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Post credit button");
			Log.info("Step:01 - Click Post credit button");
			
			
			//Navigate to Pop Up Window
		    String mainWindowHandle = driver.getWindowHandle();
		    boolean popupAppeared = false;
		    for (String handle : driver.getWindowHandles()) {
		        if (!handle.equals(mainWindowHandle)) {
		            driver.switchTo().window(handle);
		            driver.manage().window().maximize();
		            popupAppeared = true;
		         
		    		
		            if(ElementDisplayed(prsnlLoanWeeklyRepo.ldTransBasedDropdown)) {
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
					
					select("GL Code",prsnlLoanWeeklyRepo.ldTransBasedDropdown);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as GL Code.");
					Log.info("Step:01 - Select transaction based as GL Code.");
					
		            if(ElementDisplayed(prsnlLoanWeeklyRepo.ldGLNameTxtBox) && ElementDisplayed(prsnlLoanWeeklyRepo.ldGLAccCodeTxtBox)) { 
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
					
					click(prsnlLoanWeeklyRepo.ldGLNameTxtBox);
					click(prsnlLoanWeeklyRepo.ldGLNameOption);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the \"GL Name\" from the drop down");
					Log.info("Step:01 - Select the \"GL Name\" from the drop down");
		            
					String GLAccCodeValue = driver.findElement(prsnlLoanWeeklyRepo.ldGLAccCodeTxtBox).getAttribute("value");
					
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
					
					String amntValue = driver.findElement(prsnlLoanWeeklyRepo.ldBalanceAmtTxtBox).getAttribute("value");
					String amntValue1 = amntValue.split("\\.")[0];
					
					clear(prsnlLoanWeeklyRepo.ldAmntTxtBox);
					click(prsnlLoanWeeklyRepo.ldAmntTxtBox);
					input(prsnlLoanWeeklyRepo.ldAmntTxtBox, amntValue1);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the amount in \"Amount\" field");
					Log.info("Step:01 - Give the amount in \"Amount\" field.");

					click(prsnlLoanWeeklyRepo.ldAddBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click add button");
					Log.info("Step:02 - Click add button.");
					
		            if(ElementDisplayed(prsnlLoanWeeklyRepo.ldAutoPostingGrid)) { 
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
					
					click(prsnlLoanWeeklyRepo.ldSubmitBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
					Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

		    		driver.switchTo().window(mainWindowHandle);
		    		
		            if(ElementDisplayed(prsnlLoanWeeklyRepo.ldSaveBtn)) { 
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
		    
		    
			
			
			
			//Save functionality Trans. Mode - TRANSFER
			ExtentTestManager.startTest("Save functionality Trans. Mode - TRANSFER");
			Log.info("Save functionality Trans. Mode - TRANSFER");
			
			click(prsnlLoanWeeklyRepo.ldSaveBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'save'");
			Log.info("Step:01 - Click 'save'");
			
			try {
				
//				click(prsnlLoanWeeklyRepo.errorPopUpOkBtn);

				click(prsnlLoanWeeklyRepo.sSimilarDataExistsPopUpOkBtn);
				
			if(ElementDisplayed(prsnlLoanWeeklyRepo.sTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary page is displayed");
			Log.info("Expected Result: Summary page is displayed");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			transIdTransferPersonal = driver.findElement(prsnlLoanWeeklyRepo.sTransId).getText();
			
			}catch(Exception e) {
				if(ElementDisplayed(prsnlLoanWeeklyRepo.sTransId)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Summary page is displayed");
					Log.info("Expected Result: Summary page is displayed");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
				transIdTransferPersonal = driver.findElement(prsnlLoanWeeklyRepo.sTransId).getText();
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
		
		System.out.println("transIdCashPersonal "+transIdCashPersonal);
		
		fetchWithTransId(transIdCashPersonal);
		
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
		
		System.out.println("transIdCashPersonal "+transIdCashPersonal);
		fetchWithTransId(transIdCashPersonal);

		
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
		
		System.out.println("transIdTransferPersonal "+transIdTransferPersonal);
		fetchWithTransId(transIdTransferPersonal);
		
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

		
	}//end
}
