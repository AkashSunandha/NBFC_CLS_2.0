package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.LoanOpening_DepositOpn_DepositLoan;
import com.extentReports.ExtentTestManager;

public class AllScenarios_AccOpn_LoanOpn_DepoOpn_DepoLoan_TRANSFER extends Base_Class {
	Base_Class Base_Class =new Base_Class();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	LoanOpening_DepositOpn_DepositLoan bondCumulativeMthds = new LoanOpening_DepositOpn_DepositLoan();


	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		//TC No. - 01 --> Application launch
		ExtentSuccessMessage("Application launch");
		Base_Class.SetUp();
		ExtentTestManager.endTest();
		Thread.sleep(2000);

		custSrchMthds.pcRegistration(testdata, context);

		custSrchMthds.userLoginValidPaswrd(testdata, context);

		bondCumulativeMthds.openDepositLoan();

		bondCumulativeMthds.accInfo(testdata, context);

		bondCumulativeMthds.securities(testdata, context);

		bondCumulativeMthds.nominee(testdata, context);

		bondCumulativeMthds.loanDetails();

		bondCumulativeMthds.transModeTRANSFER();

		bondCumulativeMthds.authorizeTransfer(testdata, context);

		custSrchMthds.logout();

	}
}
