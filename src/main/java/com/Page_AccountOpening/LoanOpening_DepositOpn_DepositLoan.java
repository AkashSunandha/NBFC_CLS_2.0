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
		ExtentTestManager.startTest("Navigate to account opening");
		Log.info("Navigate to account opening");
		
		click(depositLoanRepo.accountOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");
		
		if(ElementDisplayed(depositLoanRepo.loanOpeningTab)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Other module names will be displays.");
			Log.info("Expected Result: Other module names will be displays.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Open Loan Opening>>Deposit Opening Window
		ExtentTestManager.startTest("Open Loan Opening>>Deposit Opening Window");
		Log.info("Open Loan Opening>>Deposit Opening Window");
		
		click(depositLoanRepo.loanOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Loan opening.");
		Log.info("Step:01 - Select Loan opening.");
		
		click(depositLoanRepo.depositLoanTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Deposit loan.");
		Log.info("Step:02 - Select Deposit loan.");
		
		if(ElementDisplayed(depositLoanRepo.depositLoan)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit module will be displays.");
			Log.info("Expected Result: Deposit module will be displays.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Navigate to Deposit Loan
		ExtentTestManager.startTest("Navigate to Deposit Loan");
		Log.info("Navigate to Deposit Loan");
		
		click(depositLoanRepo.depositLoan);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select DEPOSIT LOAN  (22001)");
		Log.info("Step:01 - Select DEPOSIT LOAN  (22001)");
		
		if(ElementDisplayed(depositLoanRepo.aiCustSrchIcon)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit opening window should open successfully.");
			Log.info("Expected Result: Deposit opening window should open successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void accInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		
		//Customer Search Icon functionality
				ExtentTestManager.startTest("Customer Search Icon functionality");
				Log.info("Customer Search Icon functionality");
				
				click(depositLoanRepo.aiCustSrchIcon);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the search icon on the customer name.");
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
			    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer search popup window will be open.");
			    			Log.info("Expected Result: Customer search popup window will be open.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			    		

			    		//Search Customer by Name
			    		ExtentTestManager.startTest("Search Customer by Name");
			    		Log.info("Search Customer by Name");
			    		
			    		String custName = testdata.get("custName").toString();
			    		input(depositLoanRepo.popUpNameTxtBox, custName);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter 'A' in the customer name field.");
			    		Log.info("Step:01 - Enter 'A' in the customer name field.");
			    		
			    		click(depositLoanRepo.popUpSrchBtn);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click on Search button.");
			    		Log.info("Step:02 -  Click on Search button.");
			    		
			    		if(ElementDisplayed(depositLoanRepo.popUpCustSelect)) {
			    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customers with 'A' in their name should be displayed.");
			    			Log.info("Expected Result: Customers with 'A' in their name should be displayed.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		
			    		ExtentTestManager.endTest();
			    		
			    		
			    		
			    		//Select Customer from List
			    		ExtentTestManager.startTest("Select Customer from List");
			    		Log.info("Select Customer from List");
			    		
			    		click(depositLoanRepo.popUpCustSelect);
			    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the search result list.");
			    		Log.info("Step:01 - Select a customer from the search result list.");
			    		
			    		driver.switchTo().window(mainWindowHandle);
			    		
			    		String flag = driver.findElement(depositLoanRepo.aiCustIdTxtBox).getAttribute("value");
			    		
			    		if(!flag.isBlank()) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The customer search popup window closes and the selected Customer ID appears in the Customer ID field.");
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
				ExtentTestManager.startTest("Add Button functionality");
				Log.info("Add Button functionality");
				
				click(depositLoanRepo.aiAddBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Add button");
				Log.info("Step:01 - Click on Add button");
				
				try {
					
					click(depositLoanRepo.prevActiveLoanPopUpOkBtn);
					
					if(ElementDisplayed(depositLoanRepo.aiCustDetailsGrid)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are added in the grid.");
						Log.info("Expected Result: Customer details are added in the grid.");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
								
				}catch(Exception e) {
					
					if(ElementDisplayed(depositLoanRepo.aiCustDetailsGrid)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are added in the grid.");
						Log.info("Expected Result: Customer details are added in the grid.");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
					
				}
					
				ExtentTestManager.endTest();
			    
				
				
				//Add Account Info Details - Select Referred By
				ExtentTestManager.startTest("Add Account Info Details - Select Referred By");
				Log.info("Add Account Info Details - Select Referred By");
				
				click(depositLoanRepo.aiReferedByDropdown);
				click(depositLoanRepo.aiReferedByOption);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Referred By' from the dropdown.");
				Log.info("Step:01 - Select 'Referred By' from the dropdown.");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the 'Referred By' from the dropdown.");
				Log.info("Expected Result: Possible to select the 'Referred By' from the dropdown.");
				
				ExtentTestManager.endTest();
			    
				
				
				//Add Account Info Details - Select Purpose
				ExtentTestManager.startTest("Add Account Info Details - Select Purpose");
				Log.info("Add Account Info Details - Select Purpose");
				
				select("EDUCATION",depositLoanRepo.aiPurposeDropdown);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Purpose' from the dropdown.");
				Log.info("Step:01 - Select 'Purpose' from the dropdown.");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the 'Purpose' from the dropdown.");
				Log.info("Expected Result: Possible to select the 'Purpose' from the dropdown.");
				
				ExtentTestManager.endTest();
				
				
				
				
				//Add Account Info Details - Enter Remark
				ExtentTestManager.startTest("Add Account Info Details - Enter Remark");
				Log.info("Add Account Info Details - Enter Remark");
				
	    		String remark = testdata.get("remark").toString();
	    		input(depositLoanRepo.aiRemarkTxtBox, remark);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Remark.");
	    		Log.info("Step:01 - Enter Remark.");
	    		
	    		if(CheckBoxStatus(depositLoanRepo.aiIntimateCheckBox)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Ensure Intimate checkbox is ticked.");
		    		Log.info("Step:02 - Ensure Intimate checkbox is ticked.");
	    		}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
	    		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details accepted and checkbox is ticked.");
				Log.info("Expected Result: Given details accepted and checkbox is ticked.");
				
				ExtentTestManager.endTest();
			    
				
				
				//Next Button Functionality
				ExtentTestManager.startTest("Next Button Functionality");
				Log.info("Next Button Functionality");
				
				click(depositLoanRepo.nextBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click next button.");
				Log.info("Step:01 - Click next button.");
				
	    		if(ElementDisplayed(depositLoanRepo.sSecurityDepositTab)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to Securities tab.");
					Log.info("Expected Result: Redirected to Securities tab.");
	    		}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
	    		
				ExtentTestManager.endTest();
			    

						
	}//end
	
	
	public void securities(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {

		
		//Securities tab display
		ExtentTestManager.startTest("Securities tab display");
		Log.info("Securities tab display");
		
		click(depositLoanRepo.sSecurityDepositTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click next button.");
		Log.info("Step:01 - Click next button.");
		
		if(ElementDisplayed(depositLoanRepo.sBranchIdDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security deposit window will be display.");
			Log.info("Expected Result: Security deposit window will be display");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");  
		} 
		
		ExtentTestManager.endTest(); 

		
		
		//Select Branch
		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");
		
		String curBranch = driver.findElement(depositLoanRepo.currentBranch).getText();
		String defaultValue = driver.findElement(depositLoanRepo.sBranchIdDropdownDefaultValue).getText();
	
		if(curBranch.equals(defaultValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the branch is autoloads in 'Branch' dropdown.");
			Log.info("Step:01 - Verify the branch is autoloads in 'Branch' dropdown.");
			
			select("KOCHI",depositLoanRepo.sBranchIdDropdown);
			select("TRIVANDRUM",depositLoanRepo.sBranchIdDropdown);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch is autoloads in 'Branch' dropdown and its is possible to change the branch.");
			Log.info("Expected Result: Branch is autoloads in 'Branch' dropdown and its is possible to change the branch.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Product Name
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Select Product Name");
		
		select("DEBUNTURE FIXED TYPE 2 YRS",depositLoanRepo.sProductNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Debenture Fixed Type 2 yrs' product name  from the product drop down.");
		Log.info("Step:01 - Select 'Debenture Fixed Type 2 yrs' product name  from the product drop down.");
			
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the prouctname from the drop down.");
		Log.info("Expected Result: Possible to select the prouctname from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Enter account number
		ExtentTestManager.startTest("Enter account number");
		Log.info("Enter account number");
		
		String accNum = generateUniqueId(spAccNum, clmnNam);
//		System.out.println("generateUniqueId: " + accNum);
		String lastThreeDigitsOfAccNum = accNum.substring(accNum.length() - 3);
		
		input(depositLoanRepo.sAccNumTxtBox, lastThreeDigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter account number '625' on the A/C No field.");
		Log.info("Step:01 - Enter account number '625' on the A/C No field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the account number and given details is accepted.");
		Log.info("Expected Result: Possible to give the account number and given details is accepted.");

		ExtentTestManager.endTest();

		
		
		//Add Button Functionality
		ExtentTestManager.startTest("Add Button Functionality");
		Log.info("Add Button Functionality");
		
		click(depositLoanRepo.sAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button.");
		Log.info("Step:01 - Click add button.");
		
		try {
			
			click(depositLoanRepo.accNotBelongsToApplicantErrPopUpOkBtn);

		if(ElementDisplayed(depositLoanRepo.sSecuritiesGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid");
			Log.info("Expected Result: Given details will be displays in the grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		}catch(Exception e) {

			if(ElementDisplayed(depositLoanRepo.sSecuritiesGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid");
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
		ExtentTestManager.startTest("Add Nominee - Untick Nominee Not Required");
		Log.info("Add Nominee - Untick Nominee Not Required");
		
		click(depositLoanRepo.nNomineeNotRequiredCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick 'Nominee Not Required'.");
		Log.info("Step:01 - Untick 'Nominee Not Required'.");
		
		if(ElementDisplayed(depositLoanRepo.nAadhaarTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details feild will be display.");
			Log.info("Expected Result: Nominee details feild will be display.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		} 
		
		ExtentTestManager.endTest();
		
		
		
		
		//Add Nominee - Enter Nominee Aadhaar No.
		ExtentTestManager.startTest("Add Nominee - Enter Nominee Aadhaar No.");
		Log.info("Add Nominee - Enter Nominee Aadhaar No.");
		
		String nomineeAadhaar = testdata.get("nomineeAadhaar").toString();
		input(depositLoanRepo.nAadhaarTxtBox, nomineeAadhaar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the nominne  Adhaar number in tne 'Adhaar No' field.");
		Log.info("Step:01 - Give the nominne  Adhaar number in tne 'Adhaar No' field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Adhaar number accepted.");
		Log.info("Expected Result: Given Adhaar number accepted.");

		ExtentTestManager.endTest();
		
		
		
		
		//Add Nominee - Enter Nominee Name.
		ExtentTestManager.startTest("Add Nominee - Enter Nominee Name.");
		Log.info("Add Nominee - Enter Nominee Name.");
		
		String nomineeName = testdata.get("nomineeName").toString();
		input(depositLoanRepo.nNameTxtBox, nomineeName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the nominee name in the name field.");
		Log.info("Step:01 - Give the nominee name in the name field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given nomine name accepted.");
		Log.info("Expected Result: Given nomine name accepted.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee Relation
		ExtentTestManager.startTest("Select Nominee Relation");
		Log.info("Select Nominee Relation");		
		
		select("FRIEND",depositLoanRepo.nRealtionDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the 'Relation' from drop down.");
		Log.info("Step:01 - Select the 'Relation' from drop down.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the relation from the drop down.");
		Log.info("Expected Result: Possible to select the relation from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee District
		ExtentTestManager.startTest("Select Nominee District");
		Log.info("Select Nominee District");		
		
		select("Palakkad",depositLoanRepo.nDistrictDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the 'District' from drop down.");
		Log.info("Step:01 - Select the 'District' from drop down.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the District from the drop down.");
		Log.info("Expected Result: Possible to select the District from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Select Nominee Post
		ExtentTestManager.startTest("Select Nominee Post");
		Log.info("Select Nominee Post");		
		
		select("Anamari B.O",depositLoanRepo.nPostDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the 'Post' from drop down.");
		Log.info("Step:01 - Select the 'Post' from drop down.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the Post from the drop down.");
		Log.info("Expected Result: Possible to select the Post from the drop down.");

		ExtentTestManager.endTest();
		
		
		
		
		//Enter Nominee DOB.
		ExtentTestManager.startTest("Enter Nominee DOB.");
		Log.info("Enter Nominee DOB.");
		
		String nomineeDOB = testdata.get("nomineeDOB").toString();
		click(depositLoanRepo.nDOBTxtBox);
		input(depositLoanRepo.nDOBTxtBox, nomineeDOB);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the DOB manually in the DOB  field.");
		Log.info("Step:01 - Enter the DOB manually in the DOB  field.");
		
		click(depositLoanRepo.ageTxt);
		
		String ageValue = driver.findElement(depositLoanRepo.nAgeTxtBox).getAttribute("value");
		System.out.println("ageValue: "+ageValue);
		
		if(!ageValue.isBlank()) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter the dob manually and 'Age' will be autoloads depends on the given DOB.");
		Log.info("Expected Result: Possible to enter the dob manually and 'Age' will be autoloads depends on the given DOB.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Add Button Functionality
		ExtentTestManager.startTest("Add Button Functionality");
		Log.info("Add Button Functionality");
		
		click(depositLoanRepo.nAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick Add button.");
		Log.info("Step:01 - Untick Add button.");
		
		if(ElementDisplayed(depositLoanRepo.nNomineeDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
			Log.info("Expected Result: Given details will be displays in the grid.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Navigate to Loan Details Tab
		ExtentTestManager.startTest("Navigate to Loan Details Tab");
		Log.info("Navigate to Loan Details Tab");
		
		click(depositLoanRepo.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button.");
		Log.info("Step:01 - Click 'Next' button.");
		
		if(ElementDisplayed(depositLoanRepo.ldActualSanctionedAmt)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan details tab is open.");
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
		ExtentTestManager.startTest("Enter Valid Sanction Amount");
		Log.info("Enter Valid Sanction Amount");
		
		String sancAmt = driver.findElement(depositLoanRepo.ldActualSanctionedAmt).getAttribute("value");
		System.out.println("sancAmt: "+sancAmt);
		input(depositLoanRepo.ldSanctionedTxtBox, sancAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid Sanctioned amount in loan details tab.");
		Log.info("Step:01 - Enter valid Sanctioned amount in loan details tab.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the sanctioned amount.");
		Log.info("Expected Result: Possible to give the sanctioned amount.");

		ExtentTestManager.endTest();
		
		
		
		//Get Values button functionality
		ExtentTestManager.startTest("Get Values button functionality");
		Log.info("Get Values button functionality");
			
		click(depositLoanRepo.ldGetValuesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click GET VALUES button.");
		Log.info("Step:01 - Click GET VALUES button.");
		
		String ROIValue = driver.findElement(depositLoanRepo.ldROITxtBox).getAttribute("value");
		String DueDateValue = driver.findElement(depositLoanRepo.ldDueDateTxtBox).getAttribute("value");
		String PayAmountValue = driver.findElement(depositLoanRepo.ldPayAmountTxtBox).getAttribute("value");
		
		double num1 = Double.parseDouble(ROIValue);
		double num2 = Double.parseDouble(PayAmountValue);
		double actual = 0.0;
		
		if(num1>actual && num2>actual && !DueDateValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Values auto-loaded (ROI, Amount, etc. , Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
			Log.info("Expected Result: Values auto-loaded (ROI, Amount, etc. , Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	
	public void transModeCASH() throws InterruptedException {

		//Select Transaction Mode and Submit Loan
		ExtentTestManager.startTest("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		ScrollUntilElementVisible(depositLoanRepo.oitransMode);
		select("CASH",depositLoanRepo.oitransMode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'.");
		Log.info("Step:01 - Select Trans. Mode 'Cash'.");
		
		click(depositLoanRepo.oisaveButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'save'");
		Log.info("Step:02 - Click 'save'");
		
		if(ElementDisplayed(depositLoanRepo.existingLoanClosureOkBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		Log.info("Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		} 
		
		ExtentTestManager.endTest();
		
		

		//Existing Loan - Ok button Functionality
		ExtentTestManager.startTest("Existing Loan - Ok button Functionality");
		Log.info("Existing Loan - Ok button Functionality");
				
		click(depositLoanRepo.existingLoanClosureOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Ok'");
		Log.info("Step:01 - Click 'Ok'");
		
		if(ElementDisplayed(depositLoanRepo.similarDataExistPopUpYesBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		Log.info("Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Similar Data Exists - Yes button Functionality
		ExtentTestManager.startTest("Similar Data Exists - Yes button Functionality");
		Log.info("Similar Data Exists - Yes button Functionality");
				
		click(depositLoanRepo.similarDataExistPopUpYesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'YES'");
		Log.info("Step:01 - Click 'YES'");
		
		try {
			
			click(depositLoanRepo.accNotBelongsToApplicantErrPopUpOkBtn);
			click(depositLoanRepo.oisaveButton);
			click(depositLoanRepo.existingLoanClosureOkBtn);
			
		}catch(Exception e) {
			
		}
		
		if(ElementDisplayed(depositLoanRepo.transIdCash)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed & Summary will be display");
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
		ExtentTestManager.startTest("Select Transaction Mode and Submit Loan");
		Log.info("Select Transaction Mode and Submit Loan");
		
		ScrollUntilElementVisible(depositLoanRepo.oitransMode);
		select("TRANSFER",depositLoanRepo.oitransMode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'.");
		Log.info("Step:01 - Select Trans. Mode 'Cash'.");
		
		if(ElementDisplayed(depositLoanRepo.oiPostCreditBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Post debit button will be display");
		Log.info("Expected Result: Post debit button will be display");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Post credit button functionality
		ExtentTestManager.startTest("Post credit button functionality");
		Log.info("Post credit button functionality");
		
		click(depositLoanRepo.oiPostCreditBtn);
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
	    		
	            if(ElementDisplayed(depositLoanRepo.oiPostCreditBtn)) { 
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
		
		
	    
		//Submit Loan
		ExtentTestManager.startTest("Submit Loan");
		Log.info("Submit Loan");
		
		click(depositLoanRepo.oisaveButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'save'");
		Log.info("Step:01 - Click 'save'");
		

		if(ElementDisplayed(depositLoanRepo.existingLoanClosureOkBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		Log.info("Expected Result: Validation popup wndow will be display \"Do You want to continue without closing existing loans? \"");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Existing Loan - Ok button Functionality
		ExtentTestManager.startTest("Existing Loan - Ok button Functionality");
		Log.info("Existing Loan - Ok button Functionality");
				
		click(depositLoanRepo.existingLoanClosureOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Ok'");
		Log.info("Step:01 - Click 'Ok'");
		
		if(ElementDisplayed(depositLoanRepo.similarDataExistPopUpYesBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		Log.info("Expected Result: Again one validation message will be display, This Account Not belongs to the Applicant");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Similar Data Exists - Yes button Functionality
		ExtentTestManager.startTest("Similar Data Exists - Yes button Functionality");
		Log.info("Similar Data Exists - Yes button Functionality");
				
		click(depositLoanRepo.similarDataExistPopUpYesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'YES'");
		Log.info("Step:01 - Click 'YES'");
		
		try {

		if(ElementDisplayed(depositLoanRepo.transIdCash)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed & Summary will be display");
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
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed & Summary will be display");
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
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry authorized");
		Log.info("Expected Result: Entry authorized");

		ExtentTestManager.endTest();
		
		click(depositLoanRepo.errorPopUpCloseIcon);

		
	}//end
	
	
	
	
	
}
