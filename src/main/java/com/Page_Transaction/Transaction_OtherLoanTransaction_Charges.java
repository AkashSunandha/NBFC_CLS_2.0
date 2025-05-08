
package com.Page_Transaction;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_OtherLoanTransaction_Charges extends Base_Class{
	
	String transId;
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting loanChargPostingrepo = new PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	Customer_CustomerSearch custSrchMtds = new Customer_CustomerSearch();
	
	String last4DigitsOfAccNum;
	String loginBranchValue;
	String gridAmtValue;
	public String spAccNum = "EXEC GetOtherLoanAccountNumberForTransaction";
	public String clmnNam = "Acno";
	String amt;
	
	public void navigateToLoanChargePosting() throws InterruptedException {
		
		//Charge Posting Window Access
		ExtentTestManager.startTest("Charge Posting Window Access");
		Log.info("Charge Posting Window Access");
		
		click(loanChargPostingrepo.processingPostingTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand processing and posting module");
		Log.info("Step:01 - Expand processing and posting module");

		click(loanChargPostingrepo.chargePOstingTab);
		click(loanChargPostingrepo.loanChargePostingTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on charge posting>Charge Loan Posting");
		Log.info("Step:02 - Click on charge posting>Charge Loan Posting");

		if(ElementDisplayed(loanChargPostingrepo.lcpBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge posting window is opened.");
			Log.info("Expected Result: Charge posting window is opened.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end



public void loanChargePosting(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException, ClassNotFoundException {

	
	//Branch Auto load in Charge Posting
	ExtentTestManager.startTest("Branch Auto load in Charge Posting");
	Log.info("Branch Auto load in Charge Posting");

	loginBranchValue = driver.findElement(loanChargPostingrepo.loginBranch).getText();
	String actualBranchValue = driver.findElement(loanChargPostingrepo.lcpactualBranch).getText();
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the branch field");
	Log.info("Step:01 - Verify the branch field");
	
	if(loginBranchValue.equals(actualBranchValue)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch is autoloaded correctly");
		Log.info("Expected Result: Branch is autoloaded correctly");
	}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	

	
	//Transaction and Posting Dates Verification
	ExtentTestManager.startTest("Transaction and Posting Dates Verification");
	Log.info("Transaction and Posting Dates Verification");
	
	String currentTransDateValue = driver.findElement(loanChargPostingrepo.lcpcurrentTransDate).getText();
	
	String currentTransDate = dateConversion(currentTransDateValue);
	System.out.println("currentTransDate: " +currentTransDate);
	
	String lcpTransDate = driver.findElement(loanChargPostingrepo.lcpTransDate).getAttribute("value");
	System.out.println("lcpTransDate: "+lcpTransDate);
	
	String lcpPostingDate = driver.findElement(loanChargPostingrepo.lcpPostingDate).getAttribute("value");
	System.out.println("lcpPostingDate: "+lcpPostingDate);

	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify transaction date and posting date");
	Log.info("Step:01 - Verify transaction date and posting date");
	
	if(currentTransDate.equals(lcpTransDate) && currentTransDate.equals(lcpPostingDate)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both dates are set to the current transaction date");
		Log.info("Expected Result: Both dates are set to the current transaction date");
	}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	

	
	//Select Loan Group
	ExtentTestManager.startTest("Select Loan Group");
	Log.info("Select Loan Group");
	
	select("OTHER LOANS",loanChargPostingrepo.lcpLoanGroupDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Open Loan Group dropdown & Select 'OtherLoan'");
	Log.info("Step:01 -  Open Loan Group dropdown & Select 'OtherLoan'");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Other loan group is selected successfully");
	Log.info("Expected Result: Other loan group is selected successfully");

	ExtentTestManager.endTest();
	

	
	//Select Product Name
	ExtentTestManager.startTest("Select Product Name");
	Log.info("Select Product Name");
	
	select("PERSONAL LOAN WEEKLY",loanChargPostingrepo.lcpProductNameDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product Name dropdown & Select 'Personal loan weekly'");
	Log.info("Step:01 - Open Product Name dropdown & Select 'Personal loan weekly'");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Personal loan weekly' product is selected successfully");
	Log.info("Expected Result: 'Personal loan weekly' product is selected successfully");

	ExtentTestManager.endTest();
	

	
	//Account Number Entry and Auto-load Verification
	ExtentTestManager.startTest("Account Number Entry and Auto-load Verification");
	Log.info("Account Number Entry and Auto-load Verification");

	String accNum = transJewelMthds.generateUniqueId(spAccNum, clmnNam);
	last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

	input(loanChargPostingrepo.lcpAccNumTxtBox, last4DigitsOfAccNum);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid A/c No.");
	Log.info("Step:01 - Enter valid A/c No.");
	
	click(loanChargPostingrepo.randomTxt);
	
	String lcpAccDispName = driver.findElement(loanChargPostingrepo.lcpAccDispName).getAttribute("value");
	System.out.println("lcpAccDispName: "+lcpAccDispName);
	
	String lcpCurrentBalance = driver.findElement(loanChargPostingrepo.lcpCurrentBalance).getAttribute("value");
	System.out.println("lcpCurrentBalance: "+lcpCurrentBalance);
	
	String lcpShadowBalance = driver.findElement(loanChargPostingrepo.lcpShadowBalance).getAttribute("value");
	System.out.println("lcpShadowBalance: "+lcpShadowBalance);
	
	String lcpUnclearBalance = driver.findElement(loanChargPostingrepo.lcpUnclearBalance).getAttribute("value");
	System.out.println("lcpUnclearBalance: "+lcpUnclearBalance);
	
	if(!lcpAccDispName.isBlank()) {
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify A/c Disp Name, Current Balance, Shadow Balance, UnClear Balance");
		Log.info("Step:02 - Verify A/c Disp Name, Current Balance, Shadow Balance, UnClear Balance");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account details are autoloaded correctly with A/c Disp Name: "+lcpAccDispName+" , "
				+ "Current Balance: " + lcpCurrentBalance + ", Shadow Balance: " + lcpShadowBalance+ ", UnClear Balance: " + lcpUnclearBalance);
		Log.info("Expected Result: Account details are autoloaded correctly with A/c Disp Name: "+lcpAccDispName+" , "
				+ "Current Balance: " + lcpCurrentBalance + ", Shadow Balance: " + lcpShadowBalance+ ", UnClear Balance: " + lcpUnclearBalance);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	

	
	//Select Notice Charge Type
	ExtentTestManager.startTest("Select Notice Charge Type");
	Log.info("Select Notice Charge Type");
	
	select("Notice",loanChargPostingrepo.lcpChargeTypeDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open charge type dropdown & Select 'Notice'");
	Log.info("Step:01 - Open charge type dropdown & Select 'Notice'");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge type 'Notice' is selected successfully");
	Log.info("Expected Result: Charge type 'Notice' is selected successfully");

	ExtentTestManager.endTest();
	

	
	//Enter Charge Amount
	ExtentTestManager.startTest("Enter Charge Amount");
	Log.info("Enter Charge Amount");

	amt = testdata.get("amount").toString();
	input(loanChargPostingrepo.lcpAmountTxtBox, amt);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid charge amount");
	Log.info("Step:01 - Enter valid charge amount");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge amount is entered successfully");
	Log.info("Expected Result: Charge amount is entered successfully");

	ExtentTestManager.endTest();
	
	
	
	//Add Charge and Verify in Grid
	ExtentTestManager.startTest("Add Charge and Verify in Grid");
	Log.info("Add Charge and Verify in Grid");
	
	click(loanChargPostingrepo.lcpAddBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button");
	Log.info("Step:01 - Click add button");

	if(ElementDisplayed(loanChargPostingrepo.addChargesGrid)) {
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify charge details in grid");
		Log.info("Step:02 - Verify charge details in grid");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge details are displayed in the grid");
		Log.info("Expected Result: Charge details are displayed in the grid");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	//Copy Amount from grid for future validation
	gridAmtValue = driver.findElement(loanChargPostingrepo.addChargesGridAmtValue).getText();
	
	
	
	//Save Charge and Successful Message Display
	ExtentTestManager.startTest("Save Charge and Successful Message Display");
	Log.info("Save Charge and Successful Message Display");
	
	click(loanChargPostingrepo.lcpSaveBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Save button");
	Log.info("Step:01 - Click Save button");

	if(ElementDisplayed(loanChargPostingrepo.topPopUpCloseBtn)) {		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Loan charges posted successfully' message is displayed");
		Log.info("Expected Result: 'Loan charges posted successfully' message is displayed");
		
		click(loanChargPostingrepo.topPopUpCloseBtn);
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	
}//end



public void transaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException, ClassNotFoundException, IOException {

	transJewelMthds.transactionsJewel();
	
	//Branch Auto load in Transaction Module
	ExtentTestManager.startTest("Branch Auto load in Transaction Module");
	Log.info("Branch Auto load in Transaction Module");

//	String loginBranchValue = driver.findElement(loanChargPostingrepo.loginBranch).getText();
	String actualBranchValue = driver.findElement(transJewelRepo.actualBranch).getText();
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the branch field");
	Log.info("Step:01 - Verify the branch field");
	
	if(loginBranchValue.equals(actualBranchValue)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch is autoloaded correctly");
		Log.info("Expected Result: Branch is autoloaded correctly");
	}
	else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	
	
	//Select Loan Group
			ExtentTestManager.startTest("Select Loan Group");
			Log.info("Select Loan Group");
			
			select("OTHER LOANS",transJewelRepo.aiProductGroupDropdowm);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Loan Group dropdown & Select OtherLoan'");
			Log.info("Step:01 - Open Loan Group dropdown & Select OtherLoan'");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: OtherLoan group is selected successfully");
			Log.info("Expected Result: OtherLoan group is selected successfully");
			
			ExtentTestManager.endTest();
			
			
			
			//Select Product Name
			ExtentTestManager.startTest("Select Product Name");
			Log.info("Select Product Name");
			
			select("PERSONAL LOAN WEEKLY",transJewelRepo.aiProdcutNameDropdowm);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open Product Name dropdown & Select 'OtherLoan'");
			Log.info("Step:01 - Open Product Name dropdown & Select 'OtherLoan'");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: OtherLoan product is selected successfully");
			Log.info("Expected Result: OtherLoan product is selected successfully");
			
			ExtentTestManager.endTest();
			
			
			
			//Enter Account Number in Transaction
			ExtentTestManager.startTest("Enter Account Number in Transaction");
			Log.info("Enter Account Number in Transaction");
						
			input(transJewelRepo.aiAccNumTxtBox, last4DigitsOfAccNum);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid account number in the input field.");
			Log.info("Step:01 - Enter a valid account number in the input field.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is entered successfully");
			Log.info("Expected Result: Account number is entered successfully");

			ExtentTestManager.endTest();
			
			
			
			//Select Transaction Type
			ExtentTestManager.startTest("Select Transaction Type");
			Log.info("Select Transaction Type");
			
			select("Credit",transJewelRepo.aiTransTypeDropdwon);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction type as 'Credit'.");
			Log.info("Step:01 - Select transaction type as 'Credit'.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction type is set.");
			Log.info("Expected Result: Transaction type is set.");
			
			ExtentTestManager.endTest();
			
			
			
			
			//Open Account Transactions
			ExtentTestManager.startTest("Open Account Transactions");
			Log.info("Open Account Transactions");
			
			click(transJewelRepo.aiGoBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button.");
			Log.info("Step:01 - Click the 'Go' button.");
			
			try {
				if(ElementDisplayed(transJewelRepo.tdTransactionDetailsWindow)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction window for the selected account is displayed.");
					Log.info("Expected Result: Transaction window for the selected account is displayed.");
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
			}catch(Exception e) {
				click(transJewelRepo.accMaturedPopUpOkBtn);
				if(ElementDisplayed(transJewelRepo.tdTransactionDetailsWindow)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction window for the selected account is displayed.");
					Log.info("Expected Result: Transaction window for the selected account is displayed.");
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
			}
			
			ExtentTestManager.endTest();
			
			
			
			//Verify Notice Charge in Transaction
			ExtentTestManager.startTest("Verify Notice Charge in Transaction");
			Log.info("Verify Notice Charge in Transaction");

			String noticeTxtBox1Value = driver.findElement(loanChargPostingrepo.noticeTxtBox1).getAttribute("value");

			if(gridAmtValue.equals(noticeTxtBox1Value)) {
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify added 'Notice' charge.");
				Log.info("Step:01 - Verify added 'Notice' charge.");
				
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 'Notice' charge is displayed correctly in the transaction window");
				Log.info("Expected Result: 'Notice' charge is displayed correctly in the transaction window");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

			ExtentTestManager.endTest();

			
			
			//Enter Transaction Amount
			ExtentTestManager.startTest("Enter Transaction Amount");
			Log.info("Enter Transaction Amount");
			
			String transAmt = testdata.get("amount").toString();
			clear(transJewelRepo.tdTransAmtTxtBox);
			click(transJewelRepo.tdTransAmtTxtBox);
			input(transJewelRepo.tdTransAmtTxtBox, transAmt);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid transaction amount in the input field.");
			Log.info("Step:01 - Enter a valid transaction amount in the input field.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction amount is accepted.");
			Log.info("Expected Result: Transaction amount is accepted.");

			click(transJewelRepo.transAmtTxt);

			ExtentTestManager.endTest();


//				click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);
				
			}//end
	
public void selectTransModeAsCash() throws InterruptedException{
	
	
	//Select Transaction Mode
	ExtentTestManager.startTest("Select Transaction Mode");
	Log.info("Select Transaction Mode");
	
	select("CASH",transJewelRepo.tdTransModeDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Choose 'Cash' from the transaction mode dropdown.");
	Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction mode 'Cash' is selected.");
	Log.info("Expected Result: Transaction mode 'Cash' is selected.");
	
	ExtentTestManager.endTest();

}//end


public void selectTransModeAsTransfer() throws InterruptedException{
	
	
	//Select Transaction Mode
	ExtentTestManager.startTest("Select Transaction Mode");
	Log.info("Select Transaction Mode");
	
	select("TRANSFER",transJewelRepo.tdTransModeDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Choose 'Cash' from the transaction mode dropdown.");
	Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction mode 'Cash' is selected.");
	Log.info("Expected Result: Transaction mode 'Cash' is selected.");
	
	ExtentTestManager.endTest();
		

}//end

public void postCreditPopUpEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	//Post credit button functionality
			ExtentTestManager.startTest("Post credit button functionality");
			Log.info("Post credit button functionality");
			
			click(transJewelRepo.tdPostDebitBtn);
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


					
					//Select Transaction Based
					ExtentTestManager.startTest("Select Transaction Based");
					Log.info("Select Transaction Based");
					
					select("Account",depositLoanRepo.oiTransBasedDropdown);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as Account.");
					Log.info("Step:01 - Select transaction based as Account.");
					
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
					Log.info("Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
		 
					ExtentTestManager.endTest();
					

					
					//Select Product Group.
					ExtentTestManager.startTest("Select Product Group");
					Log.info("Select Product Group");
					
					select("Demand Investment",depositLoanRepo.productGroupDropdown);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Demand Investment from the 'Product group ' drop down.");
					Log.info("Step:01 - Select Demand Investment from the 'Product group ' drop down.");
					
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected ");
					Log.info("Expected Result:  Demand Investment is selected ");
		 
					ExtentTestManager.endTest();
					

					
					//Select Product Name
					ExtentTestManager.startTest("Select Product Name");
					Log.info("Select Product Name");
					
					select("INV-DEMAND-CA",depositLoanRepo.productNameDropdown);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from the 'Product Name' drop down.");
					Log.info("Step:01 - Select an item from the 'Product Name' drop down.");
					
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
					Log.info("Expected Result:  Product name item  is selected ");
		 
					ExtentTestManager.endTest();
					

					
					//Select Branch
					ExtentTestManager.startTest("Select Branch");
					Log.info("Select Branch");
					
					select("TRIVANDRUM",depositLoanRepo.branchDropdown);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a branch  from the 'Branch  ' drop down.");
					Log.info("Step:01 - Select a branch  from the 'Branch  ' drop down.");
					
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch  item  is selected ");
					Log.info("Expected Result:  Branch  item  is selected  ");
		 
					ExtentTestManager.endTest();
						

						
						//Select Account
						ExtentTestManager.startTest("Select Account");
						Log.info("Select Account");						
						
						String accNum = testdata.get("accNum").toString();
						input(depositLoanRepo.accNumTxtBox, accNum);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick mark and select an account from the list of accounts displayed.");
						Log.info("Step:01 - Tick mark and select an account from the list of accounts displayed.");
						
						click(depositLoanRepo.accNumTxt);
						
						String remarksValue = driver.findElement(depositLoanRepo.remarksTxtBox).getAttribute("value");
						
						if(!remarksValue.isBlank()) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is selected & data  gets auto filled in the text fields");
							Log.info("Expected Result:  Account is selected & data  gets auto filled in the text fields");
						}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			 
						ExtentTestManager.endTest();
						

						
						//Enter Amount
						ExtentTestManager.startTest("Enter Amount");
						Log.info("Enter Amount");						
						
						String amount = testdata.get("amount").toString();
						input(depositLoanRepo.amtTxtBox, amount);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid amount in the input field.");
						Log.info("Step:01 - Enter a valid amount in the input field.");
													
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount accepted");
						Log.info("Expected Result: Amount accepted");
			 
						ExtentTestManager.endTest();
						
						

					
					//Add button functionality
					ExtentTestManager.startTest("Add button functionality");
					Log.info("Add button functionality");

					click(depositLoanRepo.addBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button");
					Log.info("Step:01 - Click add button.");
					
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
					
					click(depositLoanRepo.submitBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
					Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

		    		driver.switchTo().window(mainWindowHandle);
		    		
		            if(ElementDisplayed(transJewelRepo.tdPostDebitBtn)) { 
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

public void submitTrans(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	
	//Enter Remark 
	ExtentTestManager.startTest("Enter Remark ");
	Log.info("Enter Remark ");
	
	String reamrk = testdata.get("remark").toString();
	input(transJewelRepo.tdRemarkTxtBox, reamrk);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a remark in the input field.");
	Log.info("Step:01 - Enter a remark in the input field.");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark accepted.");
	Log.info("Expected Result: Remark accepted.");

	ExtentTestManager.endTest();
	
	
	
	//Submit Transaction
	ExtentTestManager.startTest("Submit Transaction");
	Log.info("Submit Transaction");
	
	click(transJewelRepo.submitBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Submit' button.");
	Log.info("Step:01 - Click the 'Submit' button.");
	
	AcceptAlert();
	
	if(ElementDisplayed(transJewelRepo.summaryTransId)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction should be successful and  summary is displayed with correct details.");
		Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
		
		transId = driver.findElement(transJewelRepo.summaryTransId).getText();
		System.out.println("transId: "+transId);
	
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
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
	
	
	
	//Navigate to Cashier Authorization
	ExtentTestManager.startTest("Navigate to Cashier Authorization");
	Log.info("Navigate to Cashier Authorization");
	
	click(goaldLoanRepo.autorizeAndCancelTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
	Log.info("Step:01 - Click \"Authorize & Cancel\"");
	
	click(goaldLoanRepo.cashierAuthoTab);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Navigate to Cashier Authorization");
	Log.info("Step:02 - Navigate to Cashier Authorization");

	if(ElementDisplayed(goaldLoanRepo.cashierRefreshBtn)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Cahier Authorisation window opened successfully");
		Log.info("Expected Result:  Cahier Authorisation window opened successfully");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	
	//Refresh button functionality
	ExtentTestManager.startTest("Refresh button functionality");
	Log.info("Refresh button functionality");
	
	click(goaldLoanRepo.cashierRefreshBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
	Log.info("Step:01 - Click Refresh Button");

	if(ElementDisplayed(goaldLoanRepo.cashierCheckBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Authorisation pending transaction gets displayed ");
		Log.info("Expected Result:  Authorisation pending transaction gets displayed ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	
	
	//Select the transaction to authorize
	ExtentTestManager.startTest("Select the transaction to authorize");
	Log.info("Select the transaction to authorize");
	
	transJewelMthds.fetchWithTransId(transId);
	
	click(goaldLoanRepo.cashierCheckBox);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select checkbox");
	Log.info("Step:01 - Select checkbox");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  Transaction to autthorise is s elected");
	Log.info("Expected Result:  Transaction to autthorise is s elected");
	
	ExtentTestManager.endTest();
	
	
	
	//Authorize the transaction
	ExtentTestManager.startTest("Authorize the transaction");
	Log.info("Authorize the transaction");
	
	click(goaldLoanRepo.cashierAuthorizeBtn);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Authorize Button");
	Log.info("Step:01 - Click Authorize Button");
	
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
	ExtentTestManager.startTest("Manager Authorization");
	Log.info("Manager Authorization");
	
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
					
	transJewelMthds.fetchWithTransId(transId);
	
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
	transJewelMthds.fetchWithTransId(transId);
	
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


}

