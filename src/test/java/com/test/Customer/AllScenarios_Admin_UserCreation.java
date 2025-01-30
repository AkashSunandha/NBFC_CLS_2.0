package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Admin_UserCreation;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepository_User_Creation;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Admin_UserCreation {

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	//PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	//Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();

	Admin_UserCreation userCreate = new Admin_UserCreation();

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("User_creation");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}


	@Test(dataProvider = "TestData")
	public void userCreation(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//Application launch
				ExtentTestManager.startTest("TC No. - 01 --> LMS application is launched and accessible.");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				//					String pcRegFormName = testdata.get("pcRegFormName").toString();
				//					String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();
				//					String loginUserName = testdata.get("loginUserName").toString();
				//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				//					String validCustId = testdata.get("validCustId").toString();

				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);

				//TC NO-02	
				userCreate.adminLogin(testdata, context);

				userCreate.closePopup();

				//TC NO-03
				userCreate.testNavigateToAddNewUserWindow();


				//TC NO-04
				//userCreate.testValidUserIdInput(testdata, context);


				//TC NO-05
				userCreate.testInvalidUserIdInput(testdata, context);


				//TC NO-06
				userCreate.testNameFieldValidInput(testdata, context);


				//TC NO-07
				//userCreate.testInvalidNameInput(testdata, context);

				//TC NO-04
				userCreate.testValidUserIdInput(testdata, context);

				//TC NO-08


				//TC No-09


				Thread.sleep(5000);
				userCreate.signOut();

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
