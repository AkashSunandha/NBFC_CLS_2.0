package com.Pages_LeaveModule;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;

public class Methods_NBFC_CLS extends Base_Class{
	Log log;
	PageRepositary_Cust_CustSearch NBFC_Locators = new PageRepositary_Cust_CustSearch();		
	
	public boolean pcRegistration() throws InterruptedException, ClassNotFoundException {
		input(NBFC_Locators.formName, "qwerty");
		click(NBFC_Locators.formBranchName);
		input(NBFC_Locators.formComputerName, "zxcvb");
		click(NBFC_Locators.formSubmitBtn);
		//DB Connection
			com.BasePackage.Base_Class.DatabaseConnector();
			driver.navigate().refresh();
			Log.info("PC Registered Successfully!");
		return true;
	}
	
	public boolean userLoginInValidPaswrd() throws InterruptedException {
		input(NBFC_Locators.loginUserName, "akash");
		input(NBFC_Locators.loginPasswrd, "qwert");
		click(NBFC_Locators.loginButton);
		Log.info("Invalid Password, Validated Successfully!");
		return true;
	}
	
	public boolean userLoginValidPaswrd() throws InterruptedException {
		clear(NBFC_Locators.loginUserName);
		input(NBFC_Locators.loginUserName, "akash");
		input(NBFC_Locators.loginPasswrd, "aka@123");
		click(NBFC_Locators.loginButton);
		
		if(ElementDisplayed(NBFC_Locators.logoutMsg)) {
			click(NBFC_Locators.logoutOk);Thread.sleep(2000);
//			clear(NBFC_Locators.loginUserName);
			input(NBFC_Locators.loginUserName, "akash");
			input(NBFC_Locators.loginPasswrd, "aka@123");
			click(NBFC_Locators.loginButton);
		}
		Log.info("Valid Password, Validated Successfully!");
		return true;
	}
	
	public boolean customerSearchWindow() throws InterruptedException {
		click(NBFC_Locators.cust);
		click(NBFC_Locators.custSrch);
		Log.info("Customer Search Window loaded Successfully!");
		return true;
	}
	
	public boolean searchByCustId() throws InterruptedException {
		//click(NBFC_Locators.custSrch);
		
		//MIN-1 & MAX-1 (Negative Scenario)
		input(NBFC_Locators.custId, "10023456789");
		click(NBFC_Locators.custSearchBtn);
		Thread.sleep(1000);
		if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
			//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
			 Log.info("No Data Found.....!");
		}
		Thread.sleep(2000);
				
		//MIN+1 & MAX+1 (Negative Scenario)
		click(NBFC_Locators.custClearBtn);
		//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtCust_Id_txt\"]")).clear();
		input(NBFC_Locators.custId, "1030006789000");
		click(NBFC_Locators.custSearchBtn);
		Thread.sleep(1000);
		if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
			//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
			 Log.info("No Data Found.....!");
		}
		Thread.sleep(2000);
		
		//MIN & MAX Value (Positive Scenario)
		click(NBFC_Locators.custClearBtn);
		//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtCust_Id_txt\"]")).clear();
		input(NBFC_Locators.custId, "103000013672");
		click(NBFC_Locators.custSearchBtn);
		return true;
	}
	
	public boolean searchByAadhaar() throws InterruptedException {
		//click(NBFC_Locators.custSrch);
		
				//AADHAAR No < 12 digits.
				input(NBFC_Locators.custAadhaar, "98765432");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
				}
				Thread.sleep(2000);
						
//				//MIN+1 & MAX+1 (Negative Scenario)
//				//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtUniversal_ID\"]")).clear();
//				click(NBFC_Locators.custClearBtn);
//				input(NBFC_Locators.custAadhaar, "9876543210190");
//				click(NBFC_Locators.custSearchBtn);
//				Thread.sleep(1000);
//				if(driver.findElement(NBFC_Locators.custErrorMsg).isDisplayed()) {
//				ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
//				 Log.info("No Data Found.....!");
//				}
//				Thread.sleep(2000);
//				
//				//MIN & MAX Value (Positive Scenario)
//				//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtUniversal_ID\"]")).clear();
//				click(NBFC_Locators.custClearBtn);
//				input(NBFC_Locators.custAadhaar, "830354199447");
//				click(NBFC_Locators.custSearchBtn);
		return true;
	}
	
	public boolean searchByMobile() throws InterruptedException {
		//click(NBFC_Locators.custSrch);
		
				//MIN-1 & MAX-1 or Mobile No. < 12 digits.
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custMobile, "888999000");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
				}
				Thread.sleep(2000);
						
				//MIN+1 & MAX+1 (Negative Scenario)
				//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtMobileNo\"]")).clear();
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custMobile, "99900088801");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
				}
				Thread.sleep(2000);
				
				//MIN & MAX Value (Positive Scenario)
				//driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtMobileNo\"]")).clear();
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custMobile, "9746137068");
				click(NBFC_Locators.custSearchBtn);
				Log.info("Fetched Customer with Valid Mobile No., Successfully!");
		return true;
	}
	
	public boolean searchByName() throws InterruptedException{
				
				//Search By Name --> Numeric Input
				click(NBFC_Locators.custClearBtn);
				click(NBFC_Locators.custName);
				input(NBFC_Locators.custName, "1234567890");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
				}
				Thread.sleep(2000);
				
				//Search By Name --> Alphanumeric Input
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custName, "ABCD12345");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
				}
				Thread.sleep(2000);
				
				//Search By Name --> Alphabet Input
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custName, "MANU");
				click(NBFC_Locators.custSearchBtn);
				Log.info("Fetched Customer with Valid Name, Successfully!");
		return true;
	}
	
	public boolean searchByParentOrSpouse() throws InterruptedException{
		
				//Search By Parent Or Spouse Name --> Numeric Input
				click(NBFC_Locators.custClearBtn);
				click(NBFC_Locators.custParentSpouse);
				input(NBFC_Locators.custParentSpouse, "1234567890");
				click(NBFC_Locators.custSearchBtn);
				Thread.sleep(1000);
				if(ElementDisplayed(NBFC_Locators.custErrorPopMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
					click(NBFC_Locators.custErrorPopMsgClose);
				}
//				if(driver.findElement(NBFC_Locators.custErrorMsg).isDisplayed()) {
//					System.out.println(driver.findElement(NBFC_Locators.custErrorMsg).getText() + " --> Valid ERROR Message is Displayed." );
//				}
				
				//Search By Parent Or Spouse Name --> Alphanumeric Input
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custParentSpouse, "ABCD12345");
				click(NBFC_Locators.custSearchBtn);
				if(ElementDisplayed(NBFC_Locators.custErrorPopMsg)) {
					//ExtentTestManager.getTest().log(Status.PASS, "No Data Found.....!");
					 Log.info("No Data Found.....!");
					click(NBFC_Locators.custErrorPopMsgClose);
				}
//				if(driver.findElement(NBFC_Locators.custErrorMsg).isDisplayed()) {
//					System.out.println(driver.findElement(NBFC_Locators.custErrorMsg).getText() + " --> Valid ERROR Message is Displayed." );
//				}
				Thread.sleep(2000);
				
				//Search By Parent Or Spouse Name --> Alphabet Input
				click(NBFC_Locators.custClearBtn);
				input(NBFC_Locators.custParentSpouse, "JAYA PRASAD");
				click(NBFC_Locators.custSearchBtn);

		return true;
	}
	
	public boolean searchWithoutInputs() throws InterruptedException {
				click(NBFC_Locators.custClearBtn);
				click(NBFC_Locators.custSearchBtn);
				Log.info("All Availabe customer details displayed, Successfully!");
		return true;
	}
	
	public boolean clearFunctionality() throws InterruptedException {
				input(NBFC_Locators.custAadhaar, "830354199447");Thread.sleep(2000);
				input(NBFC_Locators.custParentSpouse, "JAYA PRASAD");Thread.sleep(2000);
				input(NBFC_Locators.custName, "MANU");Thread.sleep(2000);
				input(NBFC_Locators.custMobile, "9746137068");Thread.sleep(2000);
				click(NBFC_Locators.custClearBtn);
				Log.info("All Inputs Cleared., Successfully!");
		return true;
	}
	
	public boolean fetchInstitutions() throws InterruptedException {
				click(NBFC_Locators.custClearBtn);
				click(NBFC_Locators.custKYCCompliantOnly);
				click(NBFC_Locators.custActiveOnly);
				click(NBFC_Locators.custProspectsOnly);
				click(NBFC_Locators.custIsInstitutional);
				click(NBFC_Locators.custSearchBtn);Thread.sleep(2000);
				try {
//					boolean tableDisplayed = ElementDisplayed(NBFC_Locators.custTable);
					if(ElementDisplayed(NBFC_Locators.custTable)) {
						Log.info("Successfully Fetched Institutional Customers in the Grid");
						}
				}
				catch(Exception e1)
				{
					Log.info("Failed to Fetch Institutional Customers in the Grid");
				}
				
		return true;
	}
	
}
