package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.LoanOpening_JewelLoan_GoldLoan;
import com.Page_Customer.Customer_NewCustomer;
import com.extentReports.ExtentTestManager;

public class AllScenarios_AccOpn_LoanOpn_JewelLoan_GoldLoan {
	Base_Class Base_Class=new Base_Class();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_NewCustomer newCustMths = new Customer_NewCustomer();
	LoanOpening_JewelLoan_GoldLoan goaldLoan = new LoanOpening_JewelLoan_GoldLoan();

	public void newCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{

		//TC No. - 01 --> Application launch
		ExtentTestManager.startTest("Application launch");
		Base_Class.SetUp();
		ExtentTestManager.endTest();
		Thread.sleep(2000);


		custSrchMthds.pcRegistration(testdata, context);

		custSrchMthds.userLoginValidPaswrd(testdata, context);

		goaldLoan.openGoaldLoanWindow();

		goaldLoan.accInfo(testdata, context);

		goaldLoan.securities(testdata, context);

		goaldLoan.nominee(testdata, context);

		goaldLoan.loanDetails(testdata, context);

		goaldLoan.transfer(testdata, context);

		goaldLoan.authorizeCash(testdata, context);

		goaldLoan.authorizeTransfer(testdata, context);


		custSrchMthds.logout();


	}
}
