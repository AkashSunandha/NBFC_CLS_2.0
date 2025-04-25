package com.test.AccountOpening;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.AccountSearchEditbutton;
import com.Page_AccountOpening.GeneralOpening_SuspenseAsset;
import com.Page_AccountOpening.LoanOpening_DepositOpn_DepositLoan;
import com.Page_AccountOpening.LoanOpening_LoanAndAdvances_PersonalLoanWeekly;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.sun.mail.smtp.SMTPSendFailedException;

import Common.TriggerEmail;

public class AllScenarios_AccOpn_Account_Search_Edit_button extends Base_Class {

	Base_Class Base_Class=new Base_Class();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	AccountSearchEditbutton AccountSearchMethods = new AccountSearchEditbutton();


	public void Account_Search_Edit_button(Map<Object, Object> testdata, ITestContext context) throws SMTPSendFailedException, Exception{

		//TC No. - 01 --> Application launch
		ExtentTestManager.startTest("Application launch");
		Base_Class.SetUp();
		ExtentTestManager.endTest();
		Thread.sleep(2000);

		custSrchMthds.pcRegistration(testdata, context);

		custSrchMthds.userLoginValidPaswrd(testdata, context);		

		AccountSearchMethods.NavigateToAccSearchTab();

		AccountSearchMethods.AccSearchInfo(testdata);

		AccountSearchMethods.authorizeOthers(testdata, context);

		AccountSearchMethods.Signout();

		AccountSearchMethods.Signin();

		AccountSearchMethods.NavigateToAccSearchTab();

		AccountSearchMethods.SelectAllDropdown();

		AccountSearchMethods.EnterName(testdata);

		AccountSearchMethods.ClickOnSearchButton();

		AccountSearchMethods.SelectFirstCheckBox();

		AccountSearchMethods.ClickOnViewButton();

		AccountSearchMethods.ClickOnCancelButton();

		//				AccountSearchMethods.DeleteAcc();

		AccountSearchMethods.ViewDocument();

		AccountSearchMethods.ViewImages();

		custSrchMthds.logout();


	}
}
