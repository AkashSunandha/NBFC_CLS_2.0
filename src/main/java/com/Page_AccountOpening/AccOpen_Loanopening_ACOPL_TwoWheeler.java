package com.Page_AccountOpening;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler;
import com.Page_Repositary.PageRepositary_AccountOpening_FixedDeposit;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccOpen_Loanopening_ACOPL_TwoWheeler extends Base_Class 
{
	//Navigate to Deposit Opening Window
	
PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler fixeddeposit = new PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
   

	
		public boolean TwoWheelerLoan()throws InterruptedException {
			ExtentTestManager.startTest("TC:03 - select Two Wheeler Loan product");
			click(fixeddeposit.Account_opening);
			click(fixeddeposit.Loanopening);
			click(fixeddeposit.LoanandAdvance);
			click(fixeddeposit.TwoWheelerLoan);
		
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Account opening -> Loan opening-> Loan and Advances ->Two wheeler Loan");
			Log.info("\"Step:01 Navigate to Account opening -> Loan opening-> Loan and Advances ->Two wheeler Loan\\");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.Depositaccountopeningwindow);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Two Wheeler Loan selection (23027) screen is displayed");
				Log.info("Expected result: Two Wheeler Loan selection (23027) screen is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Two Wheeler Loan selection (23027) screen is displayed");
				Log.info("Expected result: Two Wheeler Loan selection (23027) screen is displayed");
			}
			ExtentTestManager.endTest();
					return true; 
		}

		public boolean AddandselectCustomer(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:04,5 - Add and select Customer");
			
			click(fixeddeposit.Custidsearchbtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click customer search icon");
			Log.info("Step:01 - Click customer search icon");
			
	        //Navigate to Pop Up Window
	  String mainWindowHandle = driver.getWindowHandle();
	  boolean popupAppeared = false;
	  for (String handle : driver.getWindowHandles()) {
	      if (!handle.equals(mainWindowHandle)) {
	          driver.switchTo().window(handle);
	          popupAppeared = true;       
	 
	          String custName = testdata.get("customerName").toString();
		  	  input(fixeddeposit.CustomerNamesearch, custName);
	  		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - 2.Enter customer Name or alphabet");
	  		Log.info("Step:02 - 2.Enter customer Name or alphabet");
	  		click(fixeddeposit.CustomerSearchbtn );
			Log.info("click on search button");
			
			click(fixeddeposit.selectcustomer);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select customer from search results");
			Log.info("Step:03 - Select customer from search results");
			
			driver.switchTo().window(mainWindowHandle);
			String customerid =driver.findElement(fixeddeposit.custid).getAttribute("value");
			if (!customerid.isBlank()) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected customer details is populated in the form");
				Log.info("Expected Result:Selected customer is  populated in the form");
			
			}
			 else {
					ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Selected customer details is not populated in the form");	
				}
			 ExtentTestManager.endTest();
			 click(fixeddeposit.Addbutton);
			 click(fixeddeposit.okbutton);
		  }
		  ExtentTestManager.endTest();		
		}
	  return true;
		}
		public boolean FillAccountInfoTab(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:06 - Fill Account Info Tab");
			click(fixeddeposit.Accountinfotab);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 select Account info Tab");
			Log.info("\"Step:01 select Account info Tab");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.Accountinfotab);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account info tab is opened");
				Log.info("Account info tab is opened");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Account info tab is opened is not opened");
				Log.info("Expected result: Account info tab is opened is not opened");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
		public boolean FillAccountInfoTabResolutionNo(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:09 - Fill Account Info Tab resolution No");
			click(fixeddeposit.ResolutionNo);
			String resolutionno = testdata.get("ResolutionNo").toString();
		  	  input(fixeddeposit.ResolutionNo, resolutionno);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter resolution No");
			Log.info("\"Step:01 Enter resolution No");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.ResolutionNo);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter Resolution No");
				Log.info("Possible to enter Resolution No");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Possible to enter Resolution No");
				Log.info("Expected result: Possible to enter Resolution No");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
		public boolean FillAccountInfoTabEnterResoultionDate(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:10 - Fill Account Info Tab Enter Resolution Date");
			click(fixeddeposit.ResolutionDate);
			String resolutiondate = testdata.get("ResoultionDate").toString();
		  	  input(fixeddeposit.ResolutionDate, resolutiondate);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter resolution date");
			Log.info("\"Step:01 Enter resolution date");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.ResolutionDate);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter Resolution date");
				Log.info("Possible to enter Resolution date");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Possible to enter Resolution date");
				Log.info("Expected result: Possible to enter Resolution date");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
		public boolean FillAccountInfoTabReferedBy(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
		    ExtentTestManager.startTest("TC:11 - Fill Account Info Tab ReferedBy");
		        click(fixeddeposit.Referedby);
		        String reference = testdata.get("ReferenceBy").toString();
                input(fixeddeposit.Referedby, reference);
		        click(fixeddeposit.optionPradeep);
		        click(fixeddeposit.Popupnull);
		        ExtentTestManager.getTest().log(Status.PASS, "Step:01  Choose Referred By from dropdown");
				Log.info("Step:01 Choose Referred By from dropdown");
		        
		  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to choose the Referred By from the drop down");
		  		Log.info("Expected Result: Possible to choose the Referred By from the drop down");
		  		
		  		
						ExtentTestManager.endTest();
						return true; 

		}
		public boolean FillAccountInfoTabCanvasserName (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
		ExtentTestManager.startTest("TC:12 -  Fill Account Info Tab Canvasser Name");
	
		click(fixeddeposit.CanvasserName);
		String Canvasser_Name = testdata.get("Canvassername").toString();
        input(fixeddeposit.CanvasserName,Canvasser_Name);
		click(fixeddeposit.optionASMA);
	        ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Canvasser Name  from dropdown");
			Log.info("Step:01 Choose Canvasser Name  from dropdown");
	        
	  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to choose the Canvasser Name from the drop down"
	  				+ "Canvasser code is displayed");
	  		Log.info("Expected Result: Possible to choose the Canvasser Name from the drop down"
	  				+"Canvasser code is displayed\"");
	  		
	  		
				ExtentTestManager.endTest();
					return true; 
}
}

	  
	

