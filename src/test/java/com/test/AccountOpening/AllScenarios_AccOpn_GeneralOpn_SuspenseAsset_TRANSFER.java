package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.GeneralOpening_SuspenseAsset;
import com.Page_AccountOpening.LoanOpening_DepositOpn_DepositLoan;
import com.Page_AccountOpening.LoanOpening_LoanAndAdvances_PersonalLoanWeekly;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_AccOpn_GeneralOpn_SuspenseAsset_TRANSFER {


	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	LoanOpening_DepositOpn_DepositLoan bondCumulativeMthds = new LoanOpening_DepositOpn_DepositLoan();
	LoanOpening_LoanAndAdvances_PersonalLoanWeekly personl = new LoanOpening_LoanAndAdvances_PersonalLoanWeekly();
	GeneralOpening_SuspenseAsset generalOpnMthds = new GeneralOpening_SuspenseAsset();
	Base_Class Base_Class =new Base_Class();



	public void SuspenseAsset_TRANSFER(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		//TC No. - 01 --> Application launch
		ExtentTestManager.startTest("Application launch");
		Base_Class.SetUp();
		ExtentTestManager.endTest();
		Thread.sleep(2000);

		custSrchMthds.pcRegistration(testdata, context);

		custSrchMthds.userLoginValidPaswrd(testdata, context);

		generalOpnMthds.generalOpening();

		generalOpnMthds.productAccInfo(testdata, context);

		generalOpnMthds.selectTransferAndSubmit();

		generalOpnMthds.authorizeTransfer(testdata, context);

		custSrchMthds.logout();
	}
}

