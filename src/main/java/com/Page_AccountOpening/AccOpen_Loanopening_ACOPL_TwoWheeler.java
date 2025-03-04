package com.Page_AccountOpening;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccountOpening_FixedDeposit;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccOpen_Loanopening_ACOPL_TwoWheeler extends Base_Class 
{
	//Navigate to Deposit Opening Window
	
//	PageRepositary_AccountOpening_FixedDeposit fixeddeposit= new PageRepositary_AccountOpening_FixedDeposit();
//	PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler fixeddeposit = new PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler();
//	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
   
	//ScreenShot sc = new ScreenShot(null)
	
		/* public boolean TwoWheelerLoan()throws InterruptedException {
			ExtentTestManager.startTest("TC:03 - select Two Wheeler Loan product");
			//click(fixeddeposit.Accountopening);
			//click(fixeddeposit.Loanopening);
			//click(fixeddeposit.LoanandAdvance);
			//click(fixeddeposit.TwoWheelerLoan);
		
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Account opening -> Loan opening-> Loan and Advances ->Two wheeler Loan");
			Log.info("\"Step:01 Navigate to Account opening -> Loan opening-> Loan and Advances ->Two wheeler Loan\\");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.Depositaccountopeningwindow);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Two Wheeler Loan  (23027) screen is displayed");
				Log.info("Two Wheeler Loan  (23027) screen is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Deposit opening window is not displayed");
				Log.info("Deposit opening window is not displayed");
			}
			ExtentTestManager.endTest();
			return true; */
			
			
		
		
	}

