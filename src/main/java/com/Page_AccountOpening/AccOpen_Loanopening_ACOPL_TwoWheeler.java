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
				Log.info("Expected result:Possible to enter Resolution No");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to enter Resolution No");
				Log.info("Expected result: unable to enter Resolution No");
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
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to enter Resolution date");
				Log.info("Expected result: unable to enter Resolution date");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
		public boolean FillAccountInfoTabReferedBy(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
		    ExtentTestManager.startTest("TC:11 - Fill Account Info Tab ReferedBy");
		        click(fixeddeposit.Referedby);
		        click(fixeddeposit.optionPradeep);
		        click(fixeddeposit.Popupnull);
		        ExtentTestManager.getTest().log(Status.PASS, "Step:01  Choose Referred By from dropdown");
				Log.info("Step:01 Choose Referred By from dropdown");
		        
				boolean flag1 = ElementDisplayed(fixeddeposit.Referedby);
				if(flag1 == true) {
		  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to choose the Referred By from the drop down");
		  		Log.info("Expected Result: Possible to choose the Referred By from the drop down");
				}
				else {
					ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to choose the Referred By from the dropdown");
					Log.info("Expected result: unable to choose the Referred By from the dropdown");
				}
		  		
						ExtentTestManager.endTest();
						return true; 

		}
		public boolean FillAccountInfoTabCanvasserName (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
		ExtentTestManager.startTest("TC:12 -  Fill Account Info Tab Canvasser Name");
		select("AISWARYA S N",fixeddeposit.CanvasserName);

	        ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Canvasser Name  from dropdown");
			Log.info("Step:01 Choose Canvasser Name  from dropdown");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.Referedby);
			if(flag1 == true) {
	        ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to choose the Canvasser Name from the drop down and Canvasser code is displayed");
	  		Log.info("Expected Result: Possible to choose the Canvasser Name from the drop down and Canvasser code is displayed");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to choose the Canvasser Name from the dropdown and Canvasser code is not displayed");
				Log.info("Expected result: unable to choose the Canvasser Name from the dropdown and Canvasser code is not displayed");
			}
	  		
				ExtentTestManager.endTest();
					return true; 
}
		public boolean FillAccountInfoTabREquitableMortRegNo(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:13 - Fill Account Info Tab Equitable Mort Reg No");
			click(fixeddeposit.EquitableMortRegNo);
			String Equitmortregno = testdata.get("EquitableMortRegNo").toString();
		  	  input(fixeddeposit.EquitableMortRegNo, Equitmortregno);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Equitable Mort Reg.No.");
			Log.info("\"Step:01 Enter Equitable Mort Reg.No.");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.EquitableMortRegNo);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the Equitable Mort Reg.No");
				Log.info("Expected result: Possible to give the Equitable Mort Reg.No");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Unable to give the Equitable Mort reg.No");
				Log.info("Expected result: Unable to give the Equitable Mort reg.No");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
	
		public boolean FillAccountInfoTabEMRDate(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
			ExtentTestManager.startTest("TC:14 - Fill Account Info Tab EMR Date");
			click(fixeddeposit.EMRDate1);
			String EMRdatepicker = testdata.get("EMRDate").toString();
		  	  input(fixeddeposit.EMRDate1, EMRdatepicker);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Date from EMR Date picker");
			Log.info("\"Step:01 select Date from EMR Date picker");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.EMRDate1);
			if(flag1 == true) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the date from date picker");
				Log.info("Expected Result:Possible to select the date from date picker");
			}
			else {
				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to select the date from EMR date picker");
				Log.info("Expected result: unable to select the date from EMR date picker");
			}
			ExtentTestManager.endTest();
		
					return true; 
}
		public boolean FillAccountInfoTabAgentCode (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
			ExtentTestManager.startTest("TC:16 -  Fill Account Info Tab Agent Code");
			click(fixeddeposit.Agentcode1);
			String Agent_code= testdata.get("Agentcode").toString();
		  	  input(fixeddeposit.Agentcode1,Agent_code );
		        ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Agentcode");
				Log.info("Step:01 Enter Agentcode");
				
				boolean flag1 = ElementDisplayed(fixeddeposit.Agentcode1);
				if(flag1 == true) {
		        ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter agentcode and agentname is displayed");
		  		Log.info("Expected Result: Not Possible to enter agentcode and Agentname is not displayed");
				}
				else {
					ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to enter agentcode and agent name is not displayed");
					Log.info("Expected result: unable to enter agentcode and agentname is not displayed");
				}
		  		
					ExtentTestManager.endTest();
						return true; 
}
		public boolean FillAccountInfoTabDSACode (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
			ExtentTestManager.startTest("TC:17 -  Fill Account Info Tab DSA Code");
			click(fixeddeposit.DSAcode1);
			String DSA_code= testdata.get("DSACode").toString();
		  	  input(fixeddeposit.DSAcode1,DSA_code );
		        ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter DSAcode");
				Log.info("Step:01 Enter DSA code");
				
				boolean flag1 = ElementDisplayed(fixeddeposit.DSAcode1);
				if(flag1 == true) {
		        ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter DSAcode and DSAname is displayed");
		  		Log.info("Expected Result: Not Possible to enter DSAcode and DSAname is not displayed");
				}
				else {
					ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: unable to enter DSAcode and DSAname is not displayed");
					Log.info("Expected result: unable to enter DSAcode and DSAname is not displayed");
				}
		  		
					ExtentTestManager.endTest();
						return true; 
}

		public Boolean NextButtonFunctionality() throws InterruptedException {
			ExtentTestManager.startTest("TC:18 - Next Button Functionality");
			
			click(fixeddeposit.Nextbtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Next' button after giving all the details in the account info tab") ;
			Log.info("Step:01 -  Click the 'Next' button after giving all the details in the account info tab");
			
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:redirected to the securities tab");
			Log.info("Expected Result: Redirected to the securities tab");
			
			ExtentTestManager.endTest();
	        return true;
			
		
	}
		public Boolean SelectvehicleSecurityTab(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
			ExtentTestManager.startTest("TC:19 20 - Select Vehicle Security Tab fill vehicle no");
			
			click(fixeddeposit.Vehicleno1);
			String Vehicle_No = testdata.get("VehicleNo").toString();
		  	  input(fixeddeposit.Vehicleno1, Vehicle_No);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01- Vehicle tab displayed and enter Vehicle no") ;
			Log.info("Step:01 - Vehicle tab displayed and enter Vehicle no");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.Vehicleno1);
			if(flag1 == true) {
	        ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Vehicleno details are accepted");
	  		Log.info("Expected Result: Given Vehicleno details are accepted");
			}
			else {
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given vehicleno details are not accepted");
			Log.info("Expected Result: Given vehicle no details are not accepted");
			}
			ExtentTestManager.endTest();
	        return true;
}
		public Boolean FillVehicleSecurityDetialsRCno(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
			ExtentTestManager.startTest("TC:21 - Fill Vehicle security details RC no");
			
			click(fixeddeposit.RCno1);
			String RC_No = testdata.get("RC.No").toString();
		  	  input(fixeddeposit.RCno1, RC_No);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01- enter RC no") ;
			Log.info("Step:01 - Enter RC no");
			
			boolean flag1 = ElementDisplayed(fixeddeposit.RCno1);
			if(flag1 == true) {
	        ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given RC.No details are accepted");
	  		Log.info("Expected Result: Given RC.No details are accepted");
			}
			else {
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given RC.No details are not accepted");
			Log.info("Expected Result: Given RC.No details are not accepted");
			}
			ExtentTestManager.endTest();
	        return true;
}
}



	  
	

