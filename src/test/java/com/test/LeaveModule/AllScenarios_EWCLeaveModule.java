package com.test.LeaveModule;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages_LeaveModule.Leave_EWCLeaveRequest;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_EWCLeaveModule extends Base_Class {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	Leave_EWCLeaveRequest Leave_EWCLeaveRequest;

	private static By userDropDown = By.xpath("//div[@id='userDropdown']/h4");
	private static By L_signout = By.xpath("//button[@class='dropdown-item ' and contains(text(),'Sign out')]");
	private static By L_username = By.xpath("//input[@id='Username']");
	private static By L_password = By.xpath("//input[@id='Password']");
	private static By L_SignIn = By.xpath("//span[contains(text(),'Sign In')]");
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("EWCLeaveRequest");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();		
		Leave_EWCLeaveRequest= new Leave_EWCLeaveRequest();

	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				// TC_BAC_Login_Positive case
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
			
				Base_Class.SetUp();
				ExtentTestManager.getTest().log(Status.PASS,
						"Application Login" + com.BasePackage.Base_Class.Pagetitle);
				Log.info("Login successful !");
				Thread.sleep(3000);
				
				String EWCType = testdata.get("EWCType").toString();
				String fromYear = testdata.get("fromYear").toString();
				String fromMonth = testdata.get("fromMonth").toString();
				String fromDate = testdata.get("fromDate").toString();
				String toYear = testdata.get("toYear").toString();
				String toMonth = testdata.get("toMonth").toString();
				String toDate = testdata.get("toDate").toString();
				String project = testdata.get("project").toString();
				String Reason = testdata.get("Reason").toString();
				String Employee = testdata.get("Employee").toString();
				String LeaveRequester = testdata.get("LeaveRequester").toString();
				String RejectCommnents = testdata.get("RejectCommnents").toString();
				String Employee1 = testdata.get("Employee1").toString();



			//EWC Leave Selection
			ExtentTestManager.startTest("TestScenario01 : Leave Request Form");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnLeaveModule();
			boolean flag1 = Leave_EWCLeaveRequest.EWCleaveRequest(EWCType);
			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag1);
			Log.info("Validated Leave Request Form : " + flag1);
			
//			ExtentTestManager.startTest("TestScenario02 : Leave Request Form Field Display");
//			Thread.sleep(3000);
//			boolean flag2 = Leave_EWCLeaveRequest.elementDisplayed();
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Field Displayed : " + flag2);
//			Log.info("Leave Request Form Field Displayed : " + flag2);
//			
//			//Fill the EWC Form
//			ExtentTestManager.startTest("TestScenario03 : Leave Request Form");
//			Thread.sleep(3000);
//			boolean flag3 = Leave_EWCLeaveRequest.EWCleaveRequestForm(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag3);
//			Log.info("Validated Leave Request Form : " + flag3);
//			
//			//Click On Canel Button
//			ExtentTestManager.startTest("TestScenario04 : Leave Request Form Cancelled");
//			Thread.sleep(3000);
//			boolean flag4 = Leave_EWCLeaveRequest.clickOnCancelButton();
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Cancelled : " + flag4);
//			Log.info("Leave Request Form Cancelled : " + flag4);
//			
//			//Again Fill the EWC Form
//			ExtentTestManager.startTest("TestScenario05 : Leave Request Form");
//			Thread.sleep(3000);
//			boolean flag5 = Leave_EWCLeaveRequest.EWCleaveRequestForm(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag5);
//			Log.info("Validated Leave Request Form : " + flag5);
//			
//			//Click On Submit Button
//			ExtentTestManager.startTest("TestScenario06 : Leave Request Form Submitted");
//			Thread.sleep(3000);
//			boolean flag6 = Leave_EWCLeaveRequest.clickOnSubmitButton();
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag6);
//			Log.info("Leave Request Form Submitted : " + flag6);
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
//			Log.info("Logging out and logging in as Approver.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			String UserName = configloader().getProperty("ApproverUsername");
//			String Password = configloader().getProperty("ApproverPassword");
//			input(L_username, UserName);
//			input(L_password, Password);
//			click(L_SignIn);
//			
//			//Verify Approval Fields Functionality Button
//			ExtentTestManager.startTest("TestScenario07 : Leave Request Form Submitted");
//			Thread.sleep(3000);
//			Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
//			boolean flag7 = Leave_EWCLeaveRequest.ApprovalButtonFieldsDisplayed(LeaveRequester);
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag7);
//			Log.info("Leave Request Form Submitted : " + flag7);
//			
//			//Verify Rejected Functionality Button
//			ExtentTestManager.startTest("TestScenario08 : Leave Request Rejection");
//			Thread.sleep(3000);
//			//Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
//			boolean flag8 = Leave_EWCLeaveRequest.RejectFunctionality(LeaveRequester, RejectCommnents);
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Rejected: " + flag8);
//			Log.info("Leave Request Rejected : " + flag8);
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Requester.");
//			Log.info("Logging out and logging in as Requester.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			String UserName1 = configloader().getProperty("UserName");
//			String Password1 = configloader().getProperty("Password");
//			input(L_username, UserName1);
//			input(L_password, Password1);
//			click(L_SignIn);
//			
//			//Fill the EWC Form
//			ExtentTestManager.startTest("TestScenario09 : Leave Request Form");
//			Thread.sleep(3000);
//			Leave_EWCLeaveRequest.clickOnLeaveModule();
//			boolean flag9 = Leave_EWCLeaveRequest.EWCleaveRequestForm(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag9);
//			Log.info("Validated Leave Request Form : " + flag9);
//			
//			//Click On Submit Button
//			ExtentTestManager.startTest("TestScenario10 : Leave Request Form Submitted");
//			Thread.sleep(3000);
//			boolean flag10 = Leave_EWCLeaveRequest.clickOnSubmitButton();
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag10);
//			Log.info("Leave Request Form Submitted : " + flag10);
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
//			Log.info("Logging out and logging in as Approver.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			String UserName2 = configloader().getProperty("ApproverUsername");
//			String Password2 = configloader().getProperty("ApproverPassword");
//			input(L_username, UserName2);
//			input(L_password, Password2);
//			click(L_SignIn);
//			
//			//Verify Approval Fields Functionality Button
//			ExtentTestManager.startTest("TestScenario11 : Leave Request Approved");
//			Thread.sleep(3000);
//			Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
//			boolean flag11 = Leave_EWCLeaveRequest.ApproveFunctionality(LeaveRequester);
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Approved : " + flag11);
//			Log.info("Leave Request Form Approved : " + flag11);
//			
//			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Requester.");
//			Log.info("Logging out and logging in as Requester.");
//			context.setAttribute("fileName", "Logout"); 
//			click(userDropDown);
//			click(L_signout);
//			String UserName3 = configloader().getProperty("UserName");
//			String Password3 = configloader().getProperty("Password");
//			input(L_username, UserName3);
//			input(L_password, Password3);
//			click(L_SignIn);
//			
//			//Fill the EWC Form
//			ExtentTestManager.startTest("TestScenario12 : Leave Request Form");
//			Thread.sleep(3000);
//			Leave_EWCLeaveRequest.clickOnLeaveModule();
//			boolean flag12 = Leave_EWCLeaveRequest.EWCleaveRequestForm(fromYear, fromMonth, fromDate, toYear, toMonth, toDate, project, Reason, Employee);
//			ExtentTestManager.getTest().log(Status.PASS, "Validated Leave Request Form : " + flag12);
//			Log.info("Validated Leave Request Form : " + flag12);
//			
//			//Click On Submit Button
//			ExtentTestManager.startTest("TestScenario13 : Leave Request Form Submitted");
//			Thread.sleep(3000);
//			boolean flag13 = Leave_EWCLeaveRequest.clickOnSubmitButton();
//			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Submitted : " + flag13);
//			Log.info("Leave Request Form Submitted : " + flag13);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Approver.");
			Log.info("Logging out and logging in as Approver.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName4 = configloader().getProperty("ApproverUsername");
			String Password4 = configloader().getProperty("ApproverPassword");
			input(L_username, UserName4);
			input(L_password, Password4);
			click(L_SignIn);
			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario14 : Leave Request Send for Review");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
			boolean flag14 = Leave_EWCLeaveRequest.sendForReviewFunctionality(LeaveRequester, Employee1);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Rerouted Successfully : " + flag14);
			Log.info("Leave Request Rerouted Successfully : " + flag14);
			
			ExtentTestManager.getTest().log(Status.PASS, "Logging out and logging in as Reviewer.");
			Log.info("Logging out and logging in as Reviewer.");
			context.setAttribute("fileName", "Logout"); 
			click(userDropDown);
			click(L_signout);
			String UserName5 = configloader().getProperty("ReviewerUsername");
			String Password5 = configloader().getProperty("ReviewerPassword");
			input(L_username, UserName5);
			input(L_password, Password5);
			click(L_SignIn);

			
			//Verify Approval Fields Functionality Button
			ExtentTestManager.startTest("TestScenario15 : Leave Request Approved");
			Thread.sleep(3000);
			Leave_EWCLeaveRequest.clickOnEWCModuleApproval();
			boolean flag15 = Leave_EWCLeaveRequest.ApproveFunctionality(LeaveRequester);
			ExtentTestManager.getTest().log(Status.PASS, "Leave Request Form Approved : " + flag15);
			Log.info("Leave Request Form Approved : " + flag15);

			
			Thread.sleep(5000);
			// Logout
			ExtentTestManager.startTest("Application Logout Initiated.");
			context.setAttribute("fileName", "Logout");
			click(userDropDown);
			click(L_signout);
			Thread.sleep(2000);
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done!");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

			}
			catch (Exception e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
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

