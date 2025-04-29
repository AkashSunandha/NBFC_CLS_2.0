package com.Page_AccountOpening;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class LoanOpening_DepositOpn_DepositLoan extends Base_Class {
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		

	String transId; 
	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn); 
	} 
	
	public String spAccNum = "EXEC SPGetNotPledgeddepositdetailsTEST  '102' , '14003'";
	public String clmnNam = "AcNO";
	
	
	public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
		 // Method that returns the first customer ID (String) from the database
	        // Database connection details
       // Database connection details
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		
	        String value = null; // Declare and initialize the return variable

	        // Establish the connection to the database
	        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	        	
	        	if (resultSet.next()) {
	        		value = resultSet.getString(columnName); // Get the first Cust_ID
	                System.out.println("Generated Unique ID: " + value);
	            } else {
	                System.out.println("Unique ID not generated.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error executing the SQL query or processing the result set.");
	            e.printStackTrace();
	        }

	        return value; // Return the firstCustId
	    }
	
	
	public void openDepositLoan() throws InterruptedException {
		
		//Navigate to account opening
		ExtentSuccessMessage("Navigate to account opening");
		Log.info("Navigate to account opening");
		
		click(depositLoanRepo.accountOpeningTab);
		ExtentSuccessMessage( "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");
		
		if(ElementDisplayed(depositLoanRepo.loanOpeningTab)) {
			ExtentSuccessMessage( "Expected Result: Other module names will be displays.");
			Log.info("Expected Result: Other module names will be displays.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Open Loan Opening>>Deposit Opening Window
		ExtentSuccessMessage("Open Loan Opening>>Deposit Opening Window");
		Log.info("Open Loan Opening>>Deposit Opening Window");
		
		click(depositLoanRepo.loanOpeningTab);
		ExtentSuccessMessage( "Step:01 - Select Loan opening.");
		Log.info("Step:01 - Select Loan opening.");
		
		click(depositLoanRepo.depositLoanTab);
		ExtentSuccessMessage( "Step:02 - Select Deposit loan.");
		Log.info("Step:02 - Select Deposit loan.");
		
		if(ElementDisplayed(depositLoanRepo.depositLoan)) {
			ExtentSuccessMessage( "Expected Result: Deposit module will be displays.");
			Log.info("Expected Result: Deposit module will be displays.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Navigate to Deposit Loan
		ExtentSuccessMessage("Navigate to Deposit Loan");
		Log.info("Navigate to Deposit Loan");
		
		click(depositLoanRepo.depositLoan);
		ExtentSuccessMessage( "Step:01 - Select DEPOSIT LOAN  (22001)");
		Log.info("Step:01 - Select DEPOSIT LOAN  (22001)");
		
		if(ElementDisplayed(depositLoanRepo.aiCustSrchIcon)) {
			ExtentSuccessMessage( "Expected Result: Deposit opening window should open successfully.");
			Log.info("Expected Result: Deposit opening window should open successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void accInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		
		//Customer Search Icon functionality
				ExtentSuccessMessage("Customer Search Icon functionality");
				Log.info("Customer Search Icon functionality");
				
				click(depositLoanRepo.aiCustSrchIcon);
				ExtentSuccessMessage( "Step:01 - Click the search icon on the customer name.");
				Log.info("Step:01 - Click the search icon on the customer name.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			            
			    		if(ElementDisplayed(depositLoanRepo.popUpNameTxtBox)) {
			    			ExtentSuccessMessage( "Expected Result: Customer search popup window will be open.");
			    			Log.info("Expected Result: Customer search popup window will be open.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			    		

			    		//Search Customer by Name
			    		ExtentSuccessMessage("Search Customer by Name");
			    		Log.info("Search Customer by Name");
			    		
			    		String custName = testdata.get("custName").toString();
			    		input(depositLoanRepo.popUpNameTxtBox, custName);
			    		ExtentSuccessMessage( "Step:01 - Enter 'A' in the customer name field.");
			    		Log.info("Step:01 - Enter 'A' in the customer name field.");
			    		
			    		click(depositLoanRepo.popUpSrchBtn);
			    		ExtentSuccessMessage( "Step:02 -  Click on Search button.");
			    		Log.info("Step:02 -  Click on Search button.");
			    		
			    		if(ElementDisplayed(depositLoanRepo.popUpCustSelect)) {
			    			ExtentSuccessMessage( "Expected Result: Customers with 'A' in their name should be displayed.");
			    			Log.info("Expected Result: Customers with 'A' in their name should be displayed.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			    		
			    		
			    		//Select Customer from List
			    		ExtentSuccessMessage("Select Customer from List");
			    		Log.info("Select Customer from List");
			    		
			    		click(depositLoanRepo.popUpCustSelect);
			    		ExtentSuccessMessage( "Step:01 - Select a customer from the search result list.");
			    		Log.info("Step:01 - Select a customer from the search result list.");
			    		
			    		driver.switchTo().window(mainWindowHandle);
			    		
			    		String flag = driver.findElement(depositLoanRepo.aiCustIdTxtBox).getAttribute("value");
			    		
			    		if(!flag.isBlank()) {
							ExtentSuccessMessage( "Expected Result: The customer search popup window closes and the selected Customer ID appears in the Customer ID field.");
							Log.info("Expected Result: The customer search popup window closes and the selected Customer ID appears in the Customer ID field.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
			    
				
				
				//Add Button functionality
				ExtentSuccessMessage("Add Button functionality");
				Log.info("Add Button functionality");
				
				click(depositLoanRepo.aiAddBtn);
				ExtentSuccessMessage( "Step:01 - Click on Add button");
				Log.info("Step:01 - Click on Add button");
				
				try {
					
					click(depositLoanRepo.prevActiveLoanPopUpOkBtn);
					
					if(ElementDisplayed(depositLoanRepo.aiCustDetailsGrid)) {
						ExtentSuccessMessage( "Expected Result: Customer details are added in the grid.");
						Log.info("Expected Result: Customer details are added in the grid.");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
								
				}catch(Exception e) {
					
					if(ElementDisplayed(depositLoanRepo.aiCustDetailsGrid)) {
						ExtentSuccessMessage( "Expected Result: Customer details are added in the grid.");
						Log.info("Expected Result: Customer details are added in the grid.");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
					
				}
					
				ExtentTestManager.endTest();
			    
				
				
				//Add Account Info Details - Select Referred By
				ExtentSuccessMessage("Add Account Info Details - Select Referred By");
				Log.info("Add Account Info Details - Select Referred By");
				
				click(depositLoanRepo.aiReferedByDropdown);
				click(depositLoanRepo.aiReferedByOption);
				ExtentSuccessMessage( "Step:01 - Select 'Referred By' from the dropdown.");
				Log.info("Step:01 - Select 'Referred By' from the dropdown.");
				
				ExtentSuccessMessage( "Expected Result: Possible to select the 'Referred By' from the dropdown.");
				Log.info("Expected Result: Possible to select the 'Referred By' from the dropdown.");
				
				ExtentTestManager.endTest();
			    
				
				
				//Add Account Info Details - Select Purpose
				ExtentSuccessMessage("Add Account Info Details - Select Purpose");
				Log.info("Add Account Info Details - Select Purpose");
				
				select("EDUCATION",depositLoanRepo.aiPurposeDropdown);
				ExtentSuccessMessage( "Step:01 - Select 'Purpose' from the dropdown.");
				Log.info("Step:01 - Select 'Purpose' from the dropdown.");
				
				ExtentSuccessMessage( "Expected Result: Possible to select the 'Purpose' from the dropdown.");
				Log.info("Expected Result: Possible to select the 'Purpose' from the dropdown.");
				
				ExtentTestManager.endTest();
				
				
				
				
				//Add Account Info Details - Enter Remark
				ExtentSuccessMessage("Add Account Info Details - Enter Remark");
				Log.info("Add Account Info Details - Enter Remark");
				
	    		String remark = testdata.get("remarks").toString();
	    		input(depositLoanRepo.aiRemarkTxtBox, remark);
	    		ExtentSuccessMessage( "Step:01 - Enter Remark.");
	    		Log.info("Step:01 - Enter Remark.");
	    		
	    		if(CheckBoxStatus(depositLoanRepo.aiIntimateCheckBox)) {
	    			ExtentSuccessMessage( "Step:02 - Ensure Intimate checkbox is ticked.");
		    		Log.info("Step:02 - Ensure Intimate checkbox is ticked.");
	    		}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
	    		
				ExtentSuccessMessage( "Expected Result: Given details accepted and checkbox is ticked.");
				Log.info("Expected Result: Given details accepted and checkbox is ticked.");
				
				ExtentTestManager.endTest();
			    
				
				
				//Next Button Functionality
				ExtentSuccessMessage("Next Button Functionality");
				Log.info("Next Button Functionality");
				
				click(depositLoanRepo.nextBtn);
				ExtentSuccessMessage( "Step:01 - Click next button.");
				Log.info("Step:01 - Click next button.");
				
	    		if(ElementDisplayed(depositLoanRepo.sSecurityDepositTab)) {
	    			ExtentSuccessMessage( "Expected Result: Redirected to Securities tab.");
					Log.info("Expected Result: Redirected to Securities tab.");
	    		}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
	    		
				ExtentTestManager.endTest();
			    

						
	}//end
	
	
	public void securities(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		
		//Securities tab display
		ExtentSuccessMessage("Securities tab display");
		Log.info("Securities tab display");
		
		click(depositLoanRepo.sSecurityDepositTab);
		ExtentSuccessMessage( "Step:01 - Click next button.");
		Log.info("Step:01 - Click next button.");
		
		if(ElementDisplayed(depositLoanRepo.sBranchIdDropdown)) {
			ExtentSuccessMessage( "Expected Result: Security deposit window will be display.");
			Log.info("Expected Result: Security deposit window will be display");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");  
		} 
		
		ExtentTestManager.endTest(); 

		
		
		//Select Branch
		ExtentSuccessMessage("Select Branch");
		Log.info("Select Branch");
		
		String curBranch = driver.findElement(depositLoanRepo.currentBranch).getText();
		String defaultValue = driver.findElement(depositLoanRepo.sBranchIdDropdownDefaultValue).getText();
	
		if(curBranch.equals(defaultValue)) {
			ExtentSuccessMessage( "Step:01 - Verify the branch is autoloads in 'Branch' dropdown.");
			Log.info("Step:01 - Verify the branch is autoloads in 'Branch' dropdown.");
			
			select("KOCHI",depositLoanRepo.sBranchIdDropdown);
			select("TRIVANDRUM",depositLoanRepo.sBranchIdDropdown);
			ExtentSuccessMessage( "Expected Result: Branch is autoloads in 'Branch' dropdown and its is possible to change the branch.");
			Log.info("Expected Result: Branch is autoloads in 'Branch' dropdown and its is possible to change the branch.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Product Name
		ExtentSuccessMessage("Select Product Name");
		Log.info("Select Product Name");
		
		select("DEBUNTURE FIXED TYPE 2 YRS",depositLoanRepo.sProductNameDropdown);
		ExtentSuccessMessage( "Step:01 - Select 'Debenture Fixed Type 2 yrs' product name  from the product drop down.");
		Log.info("Step:01 - Select 'Debenture Fixed Type 2 yrs' product name  from the product drop down.");
			
		ExtentSuccessMessage( "Expected Result: Possible to select the prouctname from the drop down.");
		Log.info("Expected Result: Possible to select the prouctname from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Enter account number
		ExtentSuccessMessage("Enter account number");
		Log.info("Enter account number");
		
		String accNum = generateUniqueId(spAccNum, clmnNam);
//		System.out.println("generateUniqueId: " + accNum);
		String lastThreeDigitsOfAccNum = accNum.substring(accNum.length() - 3);
		
		input(depositLoanRepo.sAccNumTxtBox, lastThreeDigitsOfAccNum);
		ExtentSuccessMessage( "Step:01 - Enter account number '625' on the A/C No field.");
		Log.info("Step:01 - Enter account number '625' on the A/C No field.");
		
		ExtentSuccessMessage( "Expected Result: Possible to give the account number and given details is accepted.");
		Log.info("Expected Result: Possible to give the account number and given details is accepted.");

		ExtentTestManager.endTest();

		
		
		//Add Button Functionality
		ExtentSuccessMessage("Add Button Functionality");
		Log.info("Add Button Functionality");
		
		click(depositLoanRepo.sAddBtn);
		ExtentSuccessMessage( "Step:01 - Click add button.");
		Log.info("Step:01 - Click add button.");
		
		try {
			
			click(depositLoanRepo.accNotBelongsToApplicantErrPopUpOkBtn);

		if(ElementDisplayed(depositLoanRepo.sSecuritiesGrid)) {
			ExtentSuccessMessage( "Expected Result: Given details will be displays in the grid");
			Log.info("Expected Result: Given details will be displays in the grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		}catch(Exception e) {

			if(ElementDisplayed(depositLoanRepo.sSecuritiesGrid)) {
				ExtentSuccessMessage( "Expected Result: Given details will be displays in the grid");
				Log.info("Expected Result: Given details will be displays in the grid");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		}
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
	
	public void nominee(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		click(depositLoanRepo.nomineeTab);

		
		
		//Add Nominee - Untick Nominee Not Required
		ExtentSuccessMessage("Add Nominee - Untick Nominee Not Required");
		Log.info("Add Nominee - Untick Nominee Not Required");
		
		click(depositLoanRepo.nNomineeNotRequiredCheckBox);
		ExtentSuccessMessage( "Step:01 - Untick 'Nominee Not Required'.");
		Log.info("Step:01 - Untick 'Nominee Not Required'.");
		
		if(ElementDisplayed(depositLoanRepo.nAadhaarTxtBox)) {
			ExtentSuccessMessage( "Expected Result: Nominee details feild will be display.");
			Log.info("Expected Result: Nominee details feild will be display.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		} 
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Nominee - Enter Nominee Aadhaar No.
		ExtentSuccessMessage("Add Nominee - Enter Nominee Aadhaar No.");
		Log.info("Add Nominee - Enter Nominee Aadhaar No.");
		
		String nomineeAadhaar = testdata.get("nomineeAadhaar").toString();
		input(depositLoanRepo.nAadhaarTxtBox, nomineeAadhaar);
		ExtentSuccessMessage( "Step:01 - Give the nominne  Adhaar number in tne 'Adhaar No' field.");
		Log.info("Step:01 - Give the nominne  Adhaar number in tne 'Adhaar No' field.");
		
		ExtentSuccessMessage( "Expected Result: Given Adhaar number accepted.");
		Log.info("Expected Result: Given Adhaar number accepted.");

		ExtentTestManager.endTest();
		
		
		
		
		//Add Nominee - Enter Nominee Name.
		ExtentSuccessMessage("Add Nominee - Enter Nominee Name.");
		Log.info("Add Nominee - Enter Nominee Name.");
		
		String nomineeName = testdata.get("nomineeName").toString();
		input(depositLoanRepo.nNameTxtBox, nomineeName);
		ExtentSuccessMessage( "Step:01 - Give the nominee name in the name field.");
		Log.info("Step:01 - Give the nominee name in the name field.");
		
		ExtentSuccessMessage( "Expected Result: Given nomine name accepted.");
		Log.info("Expected Result: Given nomine name accepted.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee Relation
		ExtentSuccessMessage("Select Nominee Relation");
		Log.info("Select Nominee Relation");		
		
		select("FRIEND",depositLoanRepo.nRealtionDropdown);
		ExtentSuccessMessage( "Step:01 - Select the 'Relation' from drop down.");
		Log.info("Step:01 - Select the 'Relation' from drop down.");
		
		ExtentSuccessMessage( "Expected Result: Possible to select the relation from the drop down.");
		Log.info("Expected Result: Possible to select the relation from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee District
		ExtentSuccessMessage("Select Nominee District");
		Log.info("Select Nominee District");		
		
		select("Palakkad",depositLoanRepo.nDistrictDropdown);
		ExtentSuccessMessage( "Step:01 - Select the 'District' from drop down.");
		Log.info("Step:01 - Select the 'District' from drop down.");
		
		ExtentSuccessMessage( "Expected Result: Possible to select the District from the drop down.");
		Log.info("Expected Result: Possible to select the District from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee Post
		ExtentSuccessMessage("Select Nominee Post");
		Log.info("Select Nominee Post");		
		
		select("Anamari B.O",depositLoanRepo.nPostDropdown);
		ExtentSuccessMessage( "Step:01 - Select the 'Post' from drop down.");
		Log.info("Step:01 - Select the 'Post' from drop down.");
		
		ExtentSuccessMessage( "Expected Result: Possible to select the Post from the drop down.");
		Log.info("Expected Result: Possible to select the Post from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Enter Nominee DOB.
		ExtentSuccessMessage("Enter Nominee DOB.");
		Log.info("Enter Nominee DOB.");
		
		String nomineeDOB = testdata.get("nomineeDOB").toString();
		click(depositLoanRepo.nDOBTxtBox);
		input(depositLoanRepo.nDOBTxtBox, nomineeDOB);
		ExtentSuccessMessage( "Step:01 - Enter the DOB manually in the DOB  field.");
		Log.info("Step:01 - Enter the DOB manually in the DOB  field.");
		
		click(depositLoanRepo.ageTxt);
		
		String ageValue = driver.findElement(depositLoanRepo.nAgeTxtBox).getAttribute("value");
		System.out.println("ageValue: "+ageValue);
		
		if(!ageValue.isBlank()) {
		ExtentSuccessMessage( "Expected Result: Possible to enter the dob manually and 'Age' will be autoloads depends on the given DOB.");
		Log.info("Expected Result: Possible to enter the dob manually and 'Age' will be autoloads depends on the given DOB.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Add Button Functionality
		ExtentSuccessMessage("Add Button Functionality");
		Log.info("Add Button Functionality");
		
		click(depositLoanRepo.nAddBtn);
		ExtentSuccessMessage( "Step:01 - Untick Add button.");
		Log.info("Step:01 - Untick Add button.");
		
		if(ElementDisplayed(depositLoanRepo.nNomineeDetailsGrid)) {
			ExtentSuccessMessage( "Expected Result: Given details will be displays in the grid.");
			Log.info("Expected Result: Given details will be displays in the grid.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Navigate to Loan Details Tab
		ExtentSuccessMessage("Navigate to Loan Details Tab");
		Log.info("Navigate to Loan Details Tab");
		
		click(depositLoanRepo.nextBtn);
		ExtentSuccessMessage( "Step:01 - Click 'Next' button.");
		Log.info("Step:01 - Click 'Next' button.");
		
		if(ElementDisplayed(depositLoanRepo.ldActualSanctionedAmt)) {
			ExtentSuccessMessage( "Expected Result: Loan details tab is open.");
			Log.info("Expected Result: Loan details tab is open.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void loanDetails() throws InterruptedException {

		
//		clear(bondCumulativeRepo.ldSanctionedTxtBox);
		
		//Enter Valid Sanction Amount
		ExtentSuccessMessage("Enter Valid Sanction Amount");
		Log.info("Enter Valid Sanction Amount");
		
		String sancAmt = driver.findElement(depositLoanRepo.ldActualSanctionedAmt).getAttribute("value");
		System.out.println("sancAmt: "+sancAmt);
		input(depositLoanRepo.ldSanctionedTxtBox, sancAmt);
		ExtentSuccessMessage( "Step:01 - Enter valid Sanctioned amount in loan details tab.");
		Log.info("Step:01 - Enter valid Sanctioned amount in loan details tab.");

		ExtentSuccessMessage( "Expected Result: Possible to give the sanctioned amount.");
		Log.info("Expected Result: Possible to give the sanctioned amount.");

		ExtentTestManager.endTest();
		
		
		
		//Get Values button functionality
		ExtentSuccessMessage("Get Values button functionality");
		Log.info("Get Values button functionality");
			
		click(depositLoanRepo.ldGetValuesBtn);
		ExtentSuccessMessage( "Step:01 - Click GET VALUES button.");
		Log.info("Step:01 - Click GET VALUES button.");
		
		String ROIValue = driver.findElement(depositLoanRepo.ldROITxtBox).getAttribute("value");
		String DueDateValue = driver.findElement(depositLoanRepo.ldDueDateTxtBox).getAttribute("value");
		String PayAmountValue = driver.findElement(depositLoanRepo.ldPayAmountTxtBox).getAttribute("value");
		
		double num1 = Double.parseDouble(ROIValue);
		double num2 = Double.parseDouble(PayAmountValue);
		double actual = 0.0;
		
		if(num1>actual && num2>actual && !DueDateValue.isBlank()) {
			ExtentSuccessMessage( "Expected Result: Values auto-loaded (ROI, Amount, etc. , Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
			Log.info("Expected Result: Values auto-loaded (ROI, Amount, etc. , Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void transModeCASH() throws InterruptedException {

		//Select Transaction Mode and Submit Loan
		ExtentSuccessMessage("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		ScrollUntilElementVisible(depositLoanRepo.oitransMode);
		select("CASH",depositLoanRepo.oitransMode);
		ExtentSuccessMessage( "Step:01 - Select Trans. Mode 'Cash'.");
		Log.info("Step:01 - Select Trans. Mode 'Cash'.");
		
		click(depositLoanRepo.oisaveButton);
		ExtentSuccessMessage( "Step:02 - Click 'save'");
		Log.info("Step:02 - Click 'save'");
		
		if(ElementDisplayed(depositLoanRepo.existingLoanClosureOkBtn)) {
		ExtentSuccessMessage( "Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		Log.info("Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		} 
		
		ExtentTestManager.endTest();
		
		

		//Existing Loan - Ok button Functionality
		ExtentSuccessMessage("Existing Loan - Ok button Functionality");
		Log.info("Existing Loan - Ok button Functionality");
				
		click(depositLoanRepo.existingLoanClosureOkBtn);
		ExtentSuccessMessage( "Step:01 - Click 'Ok'");
		Log.info("Step:01 - Click 'Ok'");
		
		if(ElementDisplayed(depositLoanRepo.similarDataExistPopUpYesBtn)) {
		ExtentSuccessMessage( "Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		Log.info("Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Similar Data Exists - Yes button Functionality
		ExtentSuccessMessage("Similar Data Exists - Yes button Functionality");
		Log.info("Similar Data Exists - Yes button Functionality");
				
		click(depositLoanRepo.similarDataExistPopUpYesBtn);
		ExtentSuccessMessage( "Step:01 - Click 'YES'");
		Log.info("Step:01 - Click 'YES'");
		
		try {
			
			click(depositLoanRepo.accNotBelongsToApplicantErrPopUpOkBtn);
			click(depositLoanRepo.oisaveButton);
			click(depositLoanRepo.existingLoanClosureOkBtn);
			
		}catch(Exception e) {
			
		}
		
		if(ElementDisplayed(depositLoanRepo.transIdCash)) {
		ExtentSuccessMessage( "Expected Result: Popup window will be closed & Summary will be display");
		Log.info("Expected Result: Popup window will be closed & Summary will be display");
		
		transId = driver.findElement(depositLoanRepo.transIdCash).getText();
		
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	
	}//end
	
	
	
	public void transModeTRANSFER() throws InterruptedException {

		//Select Transaction Mode and Submit Loan
		ExtentSuccessMessage("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		ScrollUntilElementVisible(depositLoanRepo.oitransMode);
		select("TRANSFER",depositLoanRepo.oitransMode);
		ExtentSuccessMessage( "Step:01 - Select Trans. Mode 'Cash'.");
		Log.info("Step:01 - Select Trans. Mode 'Cash'.");
		
		if(ElementDisplayed(depositLoanRepo.oiPostCreditBtn)) {
		ExtentSuccessMessage( "Expected Result: Post debit button will be display");
		Log.info("Expected Result: Post debit button will be display");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Post credit button functionality
		ExtentSuccessMessage("Post credit button functionality");
		Log.info("Post credit button functionality");
		
		click(depositLoanRepo.oiPostCreditBtn);
		ExtentSuccessMessage( "Step:01 - Select Post credit button.");
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
					ExtentSuccessMessage( "Expected Result: Auto posting popup window will be opened.");
					Log.info("Expected Result: Auto posting popup window will be opened.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	            
				ExtentTestManager.endTest();


				
				//Transaction based selection.
				ExtentSuccessMessage("Transaction based selection.");
				Log.info("Transaction based selection.");
				
				select("GL Code",depositLoanRepo.oiTransBasedDropdown);
				ExtentSuccessMessage( "Step:01 - Select transaction based as GL Code.");
				Log.info("Step:01 - Select transaction based as GL Code.");
				
	            if(ElementDisplayed(depositLoanRepo.oiGLNameTxtBox) && ElementDisplayed(depositLoanRepo.oiGLAccCodeTxtBox)) { 
				ExtentSuccessMessage( "Expected Result: GL code related field will be display (GL name,GL code).");
				Log.info("Expected Result: GL code related field will be display (GL name,GL code)");
	            }else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	            
				ExtentTestManager.endTest();
				
				
				
				//GL Name selection.
				ExtentSuccessMessage("GL Name selection.");
				Log.info("GL Name selection.");
				
				click(depositLoanRepo.oiGLNameTxtBox);
				click(depositLoanRepo.oiGLNameOption);
				ExtentSuccessMessage( "Step:01 - Select the \"GL Name\" from the drop down");
				Log.info("Step:01 - Select the \"GL Name\" from the drop down");
	            
				String GLAccCodeValue = driver.findElement(depositLoanRepo.oiGLAccCodeTxtBox).getAttribute("value");
				
	    		if(!GLAccCodeValue.isBlank()) {
							ExtentSuccessMessage( "Expected Result: GL code will be autoloads while selecting the GL Name.");
							Log.info("Expected Result: GL code will be autoloads while selecting the GL Name.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    ExtentTestManager.endTest();
			    

				
				//Add button functionality
				ExtentSuccessMessage("Add button functionality");
				Log.info("Add button functionality");
				
				String amntValue = driver.findElement(depositLoanRepo.oiBalanceAmtTxtBox).getAttribute("value");
				String amntValue1 = amntValue.split("\\.")[0];
				
				clear(depositLoanRepo.oiAmntTxtBox);
				click(depositLoanRepo.oiAmntTxtBox);
				input(depositLoanRepo.oiAmntTxtBox, amntValue1);
				ExtentSuccessMessage( "Step:01 - Give the amount in \"Amount\" field");
				Log.info("Step:01 - Give the amount in \"Amount\" field.");

				click(depositLoanRepo.oiAddBtn);
				ExtentSuccessMessage( "Step:02 - Click add button");
				Log.info("Step:02 - Click add button.");
				
	            if(ElementDisplayed(depositLoanRepo.oiAutoPostingGrid)) { 
				ExtentSuccessMessage( "Expected Result: Given details will be displays in the grid.");
				Log.info("Expected Result: Given details will be displays in the grid");
	            }else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}

				ExtentTestManager.endTest();
				
				
				
				//Submit button functionality
				ExtentSuccessMessage("Submit button functionality");
				Log.info("Submit button functionality");
				
				click(depositLoanRepo.oiSubmitBtn);
				ExtentSuccessMessage( "Step:01 - Click submit button after adding the details in the auto posting popup window");
				Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

	    		driver.switchTo().window(mainWindowHandle);
	    		
	            if(ElementDisplayed(depositLoanRepo.oiPostCreditBtn)) { 
				ExtentSuccessMessage( "Expected Result: Popup window will be closed.");
				Log.info("Expected Result: Popup window will be closed");
	            }else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		ExtentTestManager.endTest();
	    		
	            break;	
	            
	        }
	   
	    }//for loop end
		
		
	    
		//Submit Loan
		ExtentSuccessMessage("Submit Loan");
		Log.info("Submit Loan");
		
		click(depositLoanRepo.oisaveButton);
		ExtentSuccessMessage( "Step:01 - Click 'save'");
		Log.info("Step:01 - Click 'save'");
		

		if(ElementDisplayed(depositLoanRepo.existingLoanClosureOkBtn)) {
		ExtentSuccessMessage( "Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		Log.info("Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Existing Loan - Ok button Functionality
		ExtentSuccessMessage("Existing Loan - Ok button Functionality");
		Log.info("Existing Loan - Ok button Functionality");
				
		click(depositLoanRepo.existingLoanClosureOkBtn);
		ExtentSuccessMessage( "Step:01 - Click 'Ok'");
		Log.info("Step:01 - Click 'Ok'");
		
		if(ElementDisplayed(depositLoanRepo.similarDataExistPopUpYesBtn)) {
		ExtentSuccessMessage( "Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		Log.info("Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Similar Data Exists - Yes button Functionality
		ExtentSuccessMessage("Similar Data Exists - Yes button Functionality");
		Log.info("Similar Data Exists - Yes button Functionality");
				
		click(depositLoanRepo.similarDataExistPopUpYesBtn);
		ExtentSuccessMessage( "Step:01 - Click 'YES'");
		Log.info("Step:01 - Click 'YES'");
		
		try {

		if(ElementDisplayed(depositLoanRepo.transIdCash)) {
		ExtentSuccessMessage( "Expected Result: Popup window will be closed & Summary will be display");
		Log.info("Expected Result: Popup window will be closed & Summary will be display");
		
		transId = driver.findElement(depositLoanRepo.transIdCash).getText();
		
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		}catch(Exception e) {
			
			click(depositLoanRepo.accNotBelongsToApplicantErrPopUpOkBtn);
			click(depositLoanRepo.oisaveButton);
			click(depositLoanRepo.existingLoanClosureOkBtn);
			
			if(ElementDisplayed(depositLoanRepo.transIdCash)) {
				ExtentSuccessMessage( "Expected Result: Popup window will be closed & Summary will be display");
				Log.info("Expected Result: Popup window will be closed & Summary will be display");
				
				transId = driver.findElement(depositLoanRepo.transIdCash).getText();
				
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
			
		}
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
	
	public void authorizeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

		//Login with Another User
		ExtentSuccessMessage("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut);
		ExtentSuccessMessage( "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage( "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentSuccessMessage( "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		

		//Manager Authorization - Cash Tab
		ExtentSuccessMessage("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentSuccessMessage( "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentSuccessMessage( "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.cashTab);
		ExtentSuccessMessage( "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");
		
		ExtentSuccessMessage( "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentSuccessMessage("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentSuccessMessage( "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBox)) {
		ExtentSuccessMessage( "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentSuccessMessage("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		
		click(goaldLoanRepo.approveCheckBox);
		ExtentSuccessMessage( "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentSuccessMessage( "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		ExtentSuccessMessage( "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		
		

		//Cashier Authorization
		ExtentSuccessMessage("Cashier Authorization");
		Log.info("Cashier Authorization");
		 

		click(goaldLoanRepo.cashierAuthoTab);
		ExtentSuccessMessage( "Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(goaldLoanRepo.cashierRefreshBtn);
		ExtentSuccessMessage( "Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		fetchWithTransId(transId);

		
		click(goaldLoanRepo.cashierCheckBox);
		ExtentSuccessMessage( "Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(goaldLoanRepo.cashierAuthorizeBtn);
		ExtentSuccessMessage( "Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentSuccessMessage( "Expected Result: Account is created");
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
		ExtentSuccessMessage("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut); 
		ExtentSuccessMessage( "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentSuccessMessage( "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		 
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentSuccessMessage( "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		

		//Manager Authorization - Transfer Tab
		ExtentSuccessMessage("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentSuccessMessage( "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentSuccessMessage( "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.sTransferTab);
		ExtentSuccessMessage( "Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");
		
		ExtentSuccessMessage( "Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentSuccessMessage("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentSuccessMessage( "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdTransferPersonal "+transId);
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBoxTransfer)) {
		ExtentSuccessMessage( "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentSuccessMessage("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		click(goaldLoanRepo.approveCheckBoxTransfer);
		ExtentSuccessMessage( "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentSuccessMessage( "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		ExtentSuccessMessage( "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		click(depositLoanRepo.errorPopUpCloseIcon);

		
	}//end
	
	
	
	
	
}
