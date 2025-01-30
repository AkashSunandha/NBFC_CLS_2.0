package com.test.Customer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Pages_LeaveModule.Leave_EWCLeaveRequest;
import com.Pages_LeaveModule.Methods_NBFC_CLS;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import org.openqa.selenium.By;

public class AllScenarios_Cust_CustSearch extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	
	
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();


	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_CustSearch");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void customerSearch(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				ExtentTestManager.startTest("Application launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				
				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
				
				//TC No. - 03, 91 --> Invalid Login - Incorrect Password
				custSrchMthds.userLoginInValidPaswrd(testdata, context);

				//TC No. - 02 --> Valid Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				//TC No. - 04, 95 --> Navigate to Customer Search
				custSrchMthds.customerSearchWindow();
	
				
				
				
//				+++++++++=====================+++++++++++++++++++++++++=====================+++++++++++++++++++++++++=====================+++++++++++++++++++++++++=====================++++++++++++++++

//				custSrchMthds.activateDeactiveCustomer(testdata, context);//---->(Not required anymore)
				
//				custSrchMthds.deleteUnauthorisedCust(testdata, context);//----> Data issue
				
//				+++++++++=====================+++++++++++++++++++++++++=====================+++++++++++++++++++++++++=====================+++++++++++++++++++++++++=====================++++++++++++++++
	
				
				
				
				ExtentTestManager.startTest("Edit Customer Last Name - Valid Edit");
				Log.info("Edit Customer Last Name - Valid Edit");
				custSrchMthds.custLastNameEdit(testdata, context);//----> Data issue-- solved
				
				
				custSrchMthds.expired1(testdata, context);

				
				ExtentTestManager.startTest("Select State, Bank ID, Branch ID, Date");
				Log.info("Select State, Bank ID, Branch ID, Date");
				custSrchMthds.expired(testdata, context);
				
				
	        	ExtentTestManager.startTest("Mark Customer as Expired");
	        	Log.info("Mark Customer as Expired");
				custSrchMthds.markCustomerAsExpired(testdata, context); //Bank Details Fields are missing
				
				
				custSrchMthds.deactivateACustomerWithValidDate(testdata, context);//----> Data issue-- solved	

				//TC No. - 71, 72, 74, 80, 82, 88, --> Activate
				custSrchMthds.activate(testdata, context);
				
				//TC No. - 57, 58, 59, 60, 61, 62 --> Freeze {Errors work on it}
				custSrchMthds.freeze(testdata, context);
				
				custSrchMthds.freezeCustomer(testdata, context);
				
				custSrchMthds.mark(testdata, context);
				
				custSrchMthds.enterRemarkAndSubmit(testdata, context);
				

				
				//TC No. - 101, 102, 103 --> Delete Customer - Authorized Customer
				custSrchMthds.deleteCust(testdata, context);
				
				//TC No. - 28 & 31--> Last Name Field - ECP Validations
				custSrchMthds.lastNameECP(testdata, context);
				
				//TC No. - 34 & 36 --> View Customer Details
				custSrchMthds.viewCustomerDetails(testdata, context);
				
				//TC No. - 44, 45, --> Open Attachment Popup {Errors work on it}
				custSrchMthds.attachmentPopUp(testdata, context);
				
				//TC No. - 05, 09 & TC - 13--> Mobile Field - BVA Validations
				custSrchMthds.mobileFieldBVA(testdata, context);
				
				//TC No. - 06, 22, 24, 27, 32, 39, 41, 42, 52, 54, 56, 65, 69, 84, 97, 98, 99, 106, 107, 120 --> Fetch Customer by Name
				custSrchMthds.nameFieldECP(testdata, context);
				
				//TC No. - 07, 55 --> Fetch Customers Without Inputs
				custSrchMthds.searchWithoutInputs();
				
				//TC No. - 08 --> Invalid Aadhaar Number
				custSrchMthds.searchByInvalidAadhaar(testdata, context);
			
				//TC No. - 10 --> Clear Functionality
				custSrchMthds.clearFunctionality(testdata, context);
				
				//TC No. - 14 & 16 --> Verify the field Doc Type & Doc No
				custSrchMthds.docTypeAndDocNo(testdata, context);
				
				//TC No. - 11 --> Toggle Is Institutional Checkbox
				custSrchMthds.fetchInstitutions();
				
				//TC No. - 12 --> Verify the field House Name
				custSrchMthds.houseName(testdata, context);
				
				//TC No. - 15, 21--> Verify the field PAN No
				custSrchMthds.panNum(testdata, context);
				
				//TC No. - 17 --> Check KYC Compliant Only Check box
				custSrchMthds.kycCompliantOnly();
				
				//TC No. - 18 --> Check Active Only Check box
				custSrchMthds.isActiveOnly();
				
				//TC No. - 19 --> Check Prospects Only Check box
				custSrchMthds.prospectsOnly();
				
				//TC No. - 20 --> Check Include Reject Checkbox
				custSrchMthds.includeReject();				

				//TC No. - 105 --> Logout
				custSrchMthds.logout();
				
				
				
		
				
				//Authorize
//				custSrchMthds.updateMakerId();
//				custSrchMthds.authorize();
				


				
			// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	
}


