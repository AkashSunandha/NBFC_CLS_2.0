package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRating;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepository_CustRating;	
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class AllScenarios_Cust_CustRating  {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();

	Customer_CustomerRating custRa = new Customer_CustomerRating();
	PageRepository_CustRating pcr= new PageRepository_CustRating();
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_CustRating");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void customerRating(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//Application launch
				Base_Class.SetUp();
				Thread.sleep(2000);

				//					String pcRegFormName = testdata.get("pcRegFormName").toString();
				//					String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();
				//					String loginUserName = testdata.get("loginUserName").toString();
				//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				//					String validCustId = testdata.get("validCustId").toString();

				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				// assertEquals(Base_Class.getDriver().getCurrentUrl(), "http://192.168.32.33:9799/NBFC_CLS_Liability/Dashboard/DashBoardKSIDC.aspx");


				//TC -2 -->Access Customer Rating Window
				custRa.testAccessCustomerRatingWindow();
				// assertEquals(Base_Class.ElementDisplayed(By.xpath("//div[.='Customer Rating']")), true);


				//TC -3 -->Verify Module Name Display
				custRa.testModuleNameIsDisplayed();

				//TC -4 -->Verify Presence of Customer ID and Name Fields
				custRa.verifyCustomerIDAndNameFieldsPresence();

				//TC -5 --> Verify Presence of Buttons
				custRa.testButtonPresence();

                //TC -6-->Check Mandatory Fields
				custRa.checkMandField();

				//TC-07-->Check field colour
				custRa.checkColour();
				
				//TC -8-->Verify Tooltips
				custRa.verifyToolTips();

				//TC -9-->Verify Customer Search Button
				custRa.testCustomerSearchButtonPresence();

				//TC-10-->Validate Search Button Functionality
				custRa.testSearchButtonFunctionality();

				//TC-11-->Select Customer from Search Popup
				custRa.searchcCustFromPopup();

				//TC-12-->Test Go Button Functionality
                custRa.goBtnFun(testdata, context);

                //TC-13-->Verify drop down arrow Option
                custRa.testVerifyDropDownArrowOption();
                
                //TC-15-->Check Current and New Rating Section
				custRa.testRatingSectionsPresence();
                
				//TC-16-->Validate 'No Data Found' Message
				custRa.validateNoDataFoundMessage();
				
				//AgencyFunctionality
				custRa.agencyFunc(testdata, context);
				
				//Sign out
				Thread.sleep(5000);
				custSrchMthds.signOut();

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
