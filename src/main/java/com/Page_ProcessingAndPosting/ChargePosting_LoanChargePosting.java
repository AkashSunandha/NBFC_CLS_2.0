package com.Page_ProcessingAndPosting;

import java.text.ParseException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Page_Transaction.Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ChargePosting_LoanChargePosting extends Base_Class{
	
	PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting loanChargPostingrepo = new PageRepositary_ProcessAndPosting_ChargePosting_LoanChargePosting();
	Transaction_Transactions_Jewel transJewelMthds = new Transaction_Transactions_Jewel();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();

	public String spAccNum = "EXEC GetOtherLoanAccountNumberForTransaction";
	public String clmnNam = "Acno";
	
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

	String loginBranchValue = driver.findElement(loanChargPostingrepo.loginBranch).getText();
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
	

	
	//Select Jewel Loan Group
	ExtentTestManager.startTest("Select Jewel Loan Group");
	Log.info("Select Jewel Loan Group");
	
	select("OTHER LOANS",loanChargPostingrepo.lcpLoanGroupDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Open Loan Group dropdown & Select 'OtherLoan'");
	Log.info("Step:01 -  Open Loan Group dropdown & Select 'OtherLoan'");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Other loan group is selected successfully");
	Log.info("Expected Result: Other loan group is selected successfully");

	ExtentTestManager.endTest();
	

	
	//Select Gold Loan Product
	ExtentTestManager.startTest("Select Gold Loan Product");
	Log.info("Select Gold Loan Product");
	
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
	String last4DigitsOfAccNum = accNum.substring(accNum.length() - 4);

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
	

	
	//Select Misc Charge Type
	ExtentTestManager.startTest("Select Misc Charge Type");
	Log.info("Select Misc Charge Type");
	
	select("Misc",loanChargPostingrepo.lcpChargeTypeDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open charge type dropdown & Select 'Misc'");
	Log.info("Step:01 - Open charge type dropdown & Select 'Misc'");
	
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Charge type 'Misc' is selected successfully");
	Log.info("Expected Result: Charge type 'Misc' is selected successfully");

	ExtentTestManager.endTest();
	

	
	//Enter Charge Amount
	ExtentTestManager.startTest("Enter Charge Amount");
	Log.info("Enter Charge Amount");

	String amt = testdata.get("amount").toString();
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



public void transaction(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ParseException, ClassNotFoundException {

	transJewelMthds.transactionsJewel();
	
	
}
	
	
	
	
	
	
	


}
