package com.JewelLoan_Closure;

import com.BasePackage.Base_Class;
import com.Page_JewelLoanClosure.PageRepository_JewelLoan_cash_Transfer;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class JewelLoan_Closure_Cash_Transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepository_JewelLoan_cash_Transfer JewelClosure = new PageRepository_JewelLoan_cash_Transfer();

	String transId;
	String transIdTransfer;

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);
	}

	public void Closurerenewal() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Jewel Loan Closure Window");
		Log.info("Navigate to Jewel Loan Closure Window");

		click(JewelClosure.OpenClosureandrenewal);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Navigate to Closure & Renewals Loan Closure");
		Log.info("Step:01 -  Navigate to Closure & Renewals Loan Closure");
		
		click(JewelClosure.Clickonclosure);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  click on Loan Closure");
		Log.info("Step:02 -click on Loan Closure");
		
		
		ExtentTestManager.startTest("Select Product Group and Name");
		Log.info("Select Product Group and Name");
		
		select("Jewel Loan", JewelClosure.selectproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select product group 'Jewel Loan'");
		Log.info("Step:01 -Select product group 'Jewel Loan'");
		
		select("GOLD LOAN",JewelClosure.productname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select appropriate product name'");
		Log.info("Step:02 -Select appropriate product name'");
		
		
		
		
		
		
		
	/*	ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");
		
		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");
		
		ExtentTestManager.startTest("Warning Validation Popup window");
		Log.info("Warning Validation Popup window");
		
		ExtentTestManager.startTest("Verify Closure Amount Display");
		Log.info("Verify Closure Amount Display");
		
		ExtentTestManager.startTest("Verify Transmode Dropdown Presence");
		Log.info("Verify Transmode Dropdown Presence");
		
		ExtentTestManager.startTest("Select Cash as Transmode and Submit");
		Log.info("Select Cash as Transmode and Submit");
		
		ExtentTestManager.startTest("Select Cash as Transmode and Submit");
		Log.info("Select Cash as Transmode and Submit");*/
		
		
		

	}
}
