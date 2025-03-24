package com.Agent_Transfer;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Agent_Transfer;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_SusAssetTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Agent_Transfer extends Base_Class
{
	
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	PageRepositary_Agent_Transfer Agent = new PageRepositary_Agent_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	public String sp = "GetSuspenseAssetAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}
	
	public void AgentTransferNavigation() throws InterruptedException
	{
		ExtentTestManager.startTest("VerifyAgentTransferNavigation");
		Log.info("VerifyAgentTransferNavigation");

		click(Agent.clickonAgenttransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Agent Transfer.");
		Log.info("Step:01 - Navigate to Agent Transfer.");

		click(Agent.agentTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Agent Transfer " );
		Log.info("Step:02 - Click on Agent Transfer.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The Agent Transfer Return is displayed");
		Log.info("Expected Result: The Agent Transfer Return is displayed");
		ExtentTestManager.endTest();
	}
	
	public void selectthecheckbox() throws InterruptedException
	{
		
		ExtentTestManager.startTest("Verify Transfer Single Account ");
		Log.info("Verify Transfer Single Account ");
		
		click(Agent.clicktransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Agent Transfer.");
		Log.info("Step:01 - Navigate to Agent Transfer.");
	}



}
