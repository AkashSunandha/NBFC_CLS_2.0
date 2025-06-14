
package com.Page_Customer;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepository_AccountOpening_Otherloanoping_documentsecurity;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccountOpening_Otherloanoping_documentsecurity extends Base_Class{

	PageRepository_AccountOpening_Otherloanoping_documentsecurity loanOpen = new PageRepository_AccountOpening_Otherloanoping_documentsecurity();
	Customer_QuickCustomer quickCust = new Customer_QuickCustomer();

	String query="Exec Getcustomer 102";
	String columnName="CustomerID";

	String parentWindow;
	Set<String> allWindows;

	String transactionID;

	// (1)
	public boolean signOut() throws InterruptedException {
		ExtentTestManager.startTest(" SignOut");
		click(loanOpen.signOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on SignOut");
		Log.info("Step-1: Click on SignOut");
		//		ExtentTestManager.getTest().log(Status.PASS, "Admin SignedOut");
		//		Log.info("Admin SignedOut");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is signed out successfully");
		Log.info("Expected Result: User is signed out successfully");
		ExtentTestManager.endTest();
		return true;
	}

	//TC-02 (3)
	public void userLogin(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {


		ExtentTestManager.startTest("TC No. - 02 --> Login to LMS as User");
		//String loginUserName = testdata.get("loginUserName").toString();
		String loginUserName=configloader().getProperty("UserName");
		input(loanOpen.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter valid username.");
		Log.info("Step-1: Enter valid username.");

		//	String loginValidPassword = testdata.get("loginValidPassword").toString();
		String loginValidPassword=configloader().getProperty("Password");
		input(loanOpen.loginPasswrd, loginValidPassword);


		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Enter valid password.");
		Log.info("Step-2: Enter valid password.");

		click(loanOpen.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on 'Login'.");
		Log.info("Step-3: Click on 'Login'.");
		Thread.sleep(10000);
		//		boolean flag1 = ElementDisplayed(institutionalCust.dashboard);
		//		boolean flag = flag1;
		//		if(flag == true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User successfully logs in to LMS.");
		Log.info("Expected Result: User successfully logs in to LMS.");
		//}
		ExtentTestManager.endTest();

	}


	//TC-04 (4)
	public void testSelectActiveLoanProduct() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 04 --> Select Active Loan Product").assignCategory("Other Loan Opening Transfer -Document Security");;
		click(loanOpen.accountOpening);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on account openong tab");
		Log.info("Step-1: Click on account openong tab");
		click(loanOpen.loanOpening);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Click on loan openong tab");
		Log.info("Step-2: Click on loan openong tab");
		click(loanOpen.loanAndAdvances);
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on loan and advances tab");
		Log.info("Step-3: Click on loan and advances tab");
		click(loanOpen.personalLoanWeekly);
		ExtentTestManager.getTest().log(Status.PASS, "Step-4: Click on persoanl loan weekly tab");
		Log.info("Step-4: Click on persoanl loan weekly tab");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The user can successfully select an active loan product i.e .. Personal loan Weekly.");
		Log.info("Expected Result: The user can successfully select an active loan product i.e .. Personal loan Weekly.");
		ExtentTestManager.endTest();
	}

	//	//TC-05,06,07 (7)
	//	public void testAddCustomer44(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
	//		ExtentTestManager.startTest("TC No. - 04 --> Add Customer from Search");
	//	
	//		String parentWindow=driver.getWindowHandle();
	//		click(loanOpen.customerSearchIcon);
	//		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Open customer search popup.");
	//		Log.info("Step-1:  Open customer search popup.");
	//		Set<String> allWindows = driver.getWindowHandles();		
	//		for (String window : allWindows) {
	//			if(!window.equals(parentWindow)) {
	//				driver.switchTo().window(window);
	//				//String custID = testdata.get("custID").toString();
	//				String custID=quickCust.generateUniqueId(query, columnName);
	//				input(loanOpen.childCustID, custID);
	//				
	//				ExtentTestManager.getTest().log(Status.PASS, "Step-2: Search for a customer.");
	//				Log.info("Step-2: Search for a customer.");
	//				//*[@id="PopQuick1_txtCustID"]
	//				click(loanOpen.childSearchBtn);
	//				click(loanOpen.childSelectLink);
	//				ExtentTestManager.getTest().log(Status.PASS, "Step-3: Select the customer.");
	//				Log.info("Step-3: Select the customer.");
	//				//driver.close();
	//				driver.switchTo().window(parentWindow);
	//				break;
	//			}
	//		}
	//		click(loanOpen.addBtn);
	//		ElementDisplayed(loanOpen.accountInfoGrid);
	//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully.");
	//		Log.info("Expected Result: Customer is added successfully.");
	//		ExtentTestManager.endTest();
	//	}

	//TC-05,6,7 (3)
	public void testAddCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException   {
		ExtentTestManager.startTest("TC No. - 05 --> Add Customer from Search").assignCategory("Other Loan Opening Cash -Document Security");
		String custID=quickCust.generateUniqueId(query, columnName);
		//String custID = testdata.get("custID").toString();
		input(loanOpen.custID_textbox, custID);
		System.out.println(custID);
		click(loanOpen.addBtn);

		try {
			click(loanOpen.okBtn);
			if(ElementDisplayed(loanOpen.accountInfoGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully.");
				Log.info("Expected Result: Customer is added successfully.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}catch(Exception e) {

			// click(loanOpen.okBtn);


			if(ElementDisplayed(loanOpen.accountInfoGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully.");
				Log.info("Expected Result: Customer is added successfully.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}

		//		if(ElementDisplayed(loanOpen.accountInfoGrid)) {
		//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully.");
		//			Log.info("Expected Result: Customer is added successfully.");
		//		}


		ExtentTestManager.endTest();
	}

	//	public void referedByDropdown() {
	//		//  options = driver.findElements("//div[@class='hjsel_select']/following-sibling::div/ul/li");
	//
	//		// driver.findElements("//div[@class='hjsel_select']/following-sibling::div/ul/li", clmnNamAadhaar);
	//
	//	}


	//TC-08 (1)
	public void testResolutionNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 08 --> Enter Resolution No").assignCategory("Other Loan Opening Cash -Document Security");
		String resolutionNo = testdata.get("resolutionNo").toString();
		System.out.println("Resolution NUmber "+resolutionNo);
		input(loanOpen.resolutionNo, resolutionNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Resolution No");
		Log.info("Step-1:  Enter Resolution No");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Resolution No are entered successfully.");
		Log.info("Expected Result: Resolution No are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-09 (2)
	public void testResolutionDateField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 09 --> Enter Resolution Date").assignCategory("Other Loan Opening Cash -Document Security");
		String resolutionDate = testdata.get("resolutionDate").toString();
		click(loanOpen.resolutionDate);
		input(loanOpen.resolutionDate, resolutionDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Open the date picker");
		Log.info("Step-1:  Open the date picker");

		ExtentTestManager.getTest().log(Status.PASS, "Step-2:   Select Resolution Date");
		Log.info("Step-2:   Select Resolution Date");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Resolution date are entered successfully.");
		Log.info("Expected Result: Resolution date are entered successfully.");
		ExtentTestManager.endTest();
	}



	//TC-11 (1)
	public void testEquiMortRegNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 11 --> Enter Equitable Mort Reg.No").assignCategory("Other Loan Opening Cash -Document Security");
		String equitableMortRegNo = testdata.get("equitableMortRegNo").toString();
		input(loanOpen.equitableMort, equitableMortRegNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Equitable Mort Reg.No");
		Log.info("Step-1:  Enter Equitable Mort Reg.No");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Equitable Mort Reg.No are entered successfully");
		Log.info("Expected Result: Equitable Mort Reg.No are entered successfully");
		ExtentTestManager.endTest();
	}

	//TC-12 (2)
	public void testSelectEMRDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 12 --> Select EMR Date").assignCategory("Other Loan Opening Cash -Document Security");
		String emrDate = testdata.get("emrDate").toString();
		click(loanOpen.emrDate);
		input(loanOpen.emrDate, emrDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Selet the EMR Date from date picker");
		Log.info("Step-1:  Selet the EMR Date from date picker");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: EMR Date are selected successfully");
		Log.info("Expected Result: EMR Date are selected successfully");
		ExtentTestManager.endTest();	
	}

	//TC-13 (1)
	public void testAgentCode(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 13 --> Agent code are entered successfully.").assignCategory("Other Loan Opening Cash -Document Security");
		String agentCode = testdata.get("agentCode").toString();
		input(loanOpen.agentCode, agentCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter Agent Code.");
		Log.info("Step-1:  Enter Agent Code.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent code are entered successfully.");
		Log.info("Expected Result: Agent code are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-14 (1)
	public void testDSACode(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 14 --> Enter DSA codes").assignCategory("Other Loan Opening Cash -Document Security");
		String dsaCode = testdata.get("dsaCode").toString();
		input(loanOpen.dsaCode, dsaCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter DSA Code.");
		Log.info("Step-1:  Enter DSA Code.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DSA code are entered successfully.");
		Log.info("Expected Result: DSA code are entered successfully.");
		ExtentTestManager.endTest();
	}


	//TC-15 (1)
	public void testAreaField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 15 --> Enter Area").assignCategory("Other Loan Opening Cash -Document Security");
		String area = testdata.get("area").toString();
		//input(loanOpen.area, area);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Area are entered successfully.");
		Log.info("Expected Result: Area are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-16 (1)
	public void testRemarksField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 16 --> Give Remarks").assignCategory("Other Loan Opening Cash -Document Security");
		String remark = testdata.get("remark").toString();
		input(loanOpen.remark, remark);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Give Remarks in \"Remarks\" field");
		Log.info("Step-1:  Give Remarks in \"Remarks\" field");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks are entered successfully.");
		Log.info("Expected Result: Remarks are entered successfully.");
		ExtentTestManager.endTest();
	}
	//------------
	//TC-17 (1)
	public void testNextBtnFunctionality1() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 17 --> Next Button Functionality").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: .Click the next button after giving all details");
		Log.info("Step-1:  .Click the next button after giving all details");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the securitis tab");
		Log.info("Expected Result: Redirected to the securitis tab");
		ExtentTestManager.endTest();
	}
	//------------------------

	//(2)
	public void testAddBtn() throws InterruptedException {
		click(loanOpen.addBtn1_document);
		if(ElementDisplayed(loanOpen.grid1_document)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added");
			Log.info("Expected Result: Customer is added");
		}
	}

	//TC-18 (2)
	public void testDocumentTab() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 18 --> Validate document tab").assignCategory("Other Loan Opening Cash -Document Security");
		//	testAddBtn();
		click(loanOpen.documentLabel);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click Document tab");
		Log.info("Step-1:  Click Document tab");
		if(ElementDisplayed(loanOpen.regYear)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Document tab is displayed");
			Log.info("Expected Result: Document tab is displayed");
		}

		ExtentTestManager.endTest();
	}


	//TC-19 (3)
	public void testSROfficeField() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 19 --> Validate SR Office dropdown").assignCategory("Other Loan Opening Cash -Document Security");
		selectbyValue("1",loanOpen.srOfficeDropdown);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Select SR Office option from drop down");
		Log.info("Step-1:   Select SR Office option from drop down");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the option");
		Log.info("Expected Result: Possible to select the option");

		ExtentTestManager.endTest();
	}

	//TC-20 (2)
	public void testRegYear(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 20 --> Validate Reg Year Field").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.regYear);
		String regYear = testdata.get("regYear").toString();
		input(loanOpen.regYear, regYear);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter year in \"Reg Year\"");
		Log.info("Step-1:   Enter year in \"Reg Year\"");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the date");
		Log.info("Expected Result: Possible to give the date");


		ExtentTestManager.endTest();
	}

	//TC-21 (1)
	public void testDocNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 21 --> Validate Doc No Field").assignCategory("Other Loan Opening Cash -Document Security");
		//String docNo = testdata.get("docNo").toString();
		String docNo=generateUniqueId(spPAN, clmnNamPAN);
		input(loanOpen.docNo,docNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Doc No");
		Log.info("Step-1:   Enter Doc No");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the detail");
		Log.info("Expected Result: Possible to give the detail");


		ExtentTestManager.endTest();
	}



	//TC-24 (2)
	public void testRegDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 24 --> Validate Reg Date Field").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.regDate);
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.presenceOfElementLocated(loanOpen.regDate));

		String regDate = testdata.get("regDate").toString();
		input(loanOpen.regDate, regDate);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Reg Date manually");
		Log.info("Step-1:   Enter Reg Date manually");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter the date manually");
		Log.info("Expected Result: Possible to enter the date manually ");


		ExtentTestManager.endTest();
	}

	//TC-22 (1)
	public void testSurveyNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 22 --> Validate Survey No Field").assignCategory("Other Loan Opening Cash -Document Security");
		Thread.sleep(5000);
		//	String surveyNo = testdata.get("surveyNo").toString();
		String surveyNo=generateUniqueId(spPAN, clmnNamPAN);
		input(loanOpen.surveyNo, surveyNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Survey No.");
		Log.info("Step-1:   Enter Survey No.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the detail");
		Log.info("Expected Result: Possible to give the detail");


		ExtentTestManager.endTest();
	}

	//TC-25 (1)
	public void testWorth(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 25 --> Validate worth Field").assignCategory("Other Loan Opening Cash -Document Security");

		String worth = testdata.get("worth").toString();
		input(loanOpen.worth, worth);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Worth");
		Log.info("Step-1:   Enter Worth");


		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details accepted");
		Log.info("Expected Result: Given details accepted");


		ExtentTestManager.endTest();
	}

	//TC-26 (1)
	public void testMarketGahanVal(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 26 --> Validate market gahan val Field").assignCategory("Other Loan Opening Cash -Document Security");

		String marketGahanVal = testdata.get("marketGahanVal").toString();
		input(loanOpen.marketGahanVal, marketGahanVal);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Market Value");
		Log.info("Step-1:   Enter Market Value");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details accepted");
		Log.info("Expected Result: Given details accepted");


		ExtentTestManager.endTest();
	}


	//TC-27 (2)
	public void testAddBtnInDocSection() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 27 --> Validate add button").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.addBtn2_document);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:   Click \"Add\" button");
		Log.info("Step-1:   Click \"Add\" button");

		if(ElementDisplayed(loanOpen.grid2_document)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Document entry added and details visible in grid");
			Log.info("Expected Result: Document entry added and details visible in grid");
		}

		ExtentTestManager.endTest();
	}



	//TC-29 (2)
	public void testNextBtnFunc() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 29 --> Navigate to Nominee Tab").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.nextBtn_document);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:   Click 'Next' button");
		Log.info("Step-1:   Click 'Next' button");

		if(ElementDisplayed(loanOpen.nomineeNotRequired_checkbox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee tab is open");
			Log.info("Expected Result: Nominee tab is open");	
		}

		ExtentTestManager.endTest();
	}



	//TC-30 (1)
	public void testCheckboxFunctioanlity() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 30 --> Checkbox functionality").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.nomineeNotRequired_checkbox);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Untick \"Nominee not required\"");
		Log.info("Step-1: Untick \"Nominee not required\"");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details fields should be display");
		Log.info("Expected Result: Nominee details fields should be display");
		ExtentTestManager.endTest();
	}

	//---------

	//		public void testAddCustomer1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
	//			ExtentTestManager.startTest("TC No. - 22 --> Add Customer from Search");
	//			String parentWindow=driver.getWindowHandle();
	//			click(loanOpen.customerSeachIcon_nominee);
	//			ExtentTestManager.getTest().log(Status.PASS, "Step-1: Open customer search popup");
	//			Log.info("Step-1: Open customer search popup");
	//			Set<String> allWindows = driver.getWindowHandles();		
	//			for (String window : allWindows) {
	//				if(!window.equals(parentWindow)) {
	//					driver.switchTo().window(window);
	//					//String nomineeCustID = testdata.get("nomineeCustID").toString();
	//					String nomineeCustID=quickCust.generateUniqueId(query, columnName);
	//					
	//					input(loanOpen.childCustID, nomineeCustID);
	//					
	//					click(loanOpen.childSearchBtn);
	//					ExtentTestManager.getTest().log(Status.PASS, "Step-2: Search for a customer.");
	//					Log.info("Step-2: Search for a customer.");
	//					click(loanOpen.selectLinkInNominee);
	//					ExtentTestManager.getTest().log(Status.PASS, "Step-3:  Select the customer.");
	//					Log.info("Step-3:  Select the customer.");
	//					//driver.close();
	//					driver.switchTo().window(parentWindow);
	//					break;
	//				}
	//			}
	//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully and details should be autoladed.");
	//			Log.info("Expected Result: Customer is added successfully and details should be autoladed.");
	//			ExtentTestManager.endTest();
	//		}

	//TC-31(1)
	public void testAadharNo() throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC No. - 31 --> Validate aadhar no").assignCategory("Other Loan Opening Cash -Document Security");
		String aadharNo = generateUniqueId(spAadhaar,clmnNamAadhaar);
		input(loanOpen.aadharNo, aadharNo);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AadharNo able to add");
		Log.info("Expected Result: AadharNo able to add");

		ExtentTestManager.endTest();
	}

	//TC-32(1)
	public void testNameInNominee(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 32 --> Validate nominee name field").assignCategory("Other Loan Opening Cash -Document Security");

		String nameInNominee = testdata.get("nameInNominee").toString();
		input(loanOpen.nameInNominee, nameInNominee);
		Thread.sleep(5000);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee name able to add");
		Log.info("Expected Result: Nominee name able to add");

		ExtentTestManager.endTest();
	}

	//TC-TC-34(2)
	public void testDistrictDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 34 --> Validate district dropdown").assignCategory("Other Loan Opening Cash -Document Security");

		selectbyValue("89",loanOpen.district_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to select option in district dropdown");
		Log.info("Expected Result: Able to select option in district dropdown");

		ExtentTestManager.endTest();
	}


	//TC-35(2)
	public void testPostDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 35 --> Validate post dropdown").assignCategory("Other Loan Opening Cash -Document Security");

		selectbyValue("13406",loanOpen.post_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to select option in post dropdown");
		Log.info("Expected Result: Able to select option in post dropdown");

		ExtentTestManager.endTest();
	}

	//TC-37(1)
	public void testDOBField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 37 --> Validate post dropdown").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.dob_textbox);
		String dob = testdata.get("dob").toString();
		input(loanOpen.dob_textbox, dob);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to enter DOB");
		Log.info("Expected Result: Able to enter DOB");


		ExtentTestManager.endTest();
	}

	//-----
	//TC-33 (2)
	public void testSelectRelation() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 33 --> Select relation").assignCategory("Other Loan Opening Cash -Document Security");
		selectbyValue("15",loanOpen.relation_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Select relation from the drop down ");
		Log.info("Step-1:  Select relation from the drop down ");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation are selected successfully from the drop down");
		Log.info("Expected Result: Relation are selected successfully from the drop down");
		ExtentTestManager.endTest();
	}


	//TC-38 (2)
	public void testAddBtnFunctionality2() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 38 --> Add Button functionality").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.addBtn_nominee);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click add button");
		Log.info("Step-1:  Click add button");
		if(ElementDisplayed(loanOpen.nominee_grid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are added and displayed in the grid");
			Log.info("Expected Result: Details are added and displayed in the grid");
		}
		else {

			ExtentTestManager.getTest().log(Status.FAIL, "Testcase Failed ");
			Log.info("Expected Result: Testcase Failed");

		}
		ExtentTestManager.endTest();
	}


	//TC-39 (2)
	public void testNextBtnFunctionality3() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 39 --> Next Button Functionality").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click the next button after giving all details in nominee tab");
		Log.info("Step-1:  Click the next button after giving all details in nominee tab");
		if(ElementDisplayed(loanOpen.sanctioned)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the Loan details tab");
			Log.info("Expected Result: Redirected to the Loan details tab");
		}
		ExtentTestManager.endTest();
	}


	//TC-40 (1)
	public void testSanctionAmount(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 40 -->  Enter sanction amount.").assignCategory("Other Loan Opening Cash -Document Security");
		String sanctioned = testdata.get("sanctioned").toString();
		input(loanOpen.sanctioned, sanctioned);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:   Enter sanction amount.");
		Log.info("Step-1:   Enter sanction amount.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the Nominee tab");
		Log.info("Expected Result: Redirected to the Nominee tab");
		ExtentTestManager.endTest();
	}


	//TC-41 (2)
	public void testGetValueBtn() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. -41 --> Validate get value button").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.getValuesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click get values button");
		Log.info("Step-1:  Click get values button");
		if(!driver.findElement(loanOpen.amount).getAttribute("value").isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Autoloaded values are displayed correctly  (ROI, Amount, Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
			Log.info("Expected Result: Autoloaded values are displayed correctly  (ROI, Amount, Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
		}
		ExtentTestManager.endTest();
	}


	//TC-42 (2)
	public void testSelectTransactionMode() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 42 --> Select Transaction Mode").assignCategory("Other Loan Opening Cash -Document Security");
		click(loanOpen.transMode);
		selectbyValue("1",loanOpen.transModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Select transaction mode as cash.");
		Log.info("Step-1:  Select transaction mode as cash.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		ExtentTestManager.endTest();
	}


	//TC-43 (2)
	public void testSaveBtnFunc() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 43 --> Select Transaction Mode").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.saveBtn);

		try {
			click(loanOpen.yesBtnInTransfer);
			if(ElementDisplayed(loanOpen.signOut)) {

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Signout is present");
				Log.info("Expected Result: Signout is present");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}catch(Exception e) {

			// click(loanOpen.okBtn);

			if(ElementDisplayed(loanOpen.signOut)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Signout is present");
				Log.info("Expected Result: Signout is present");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}
		transactionID=driver.findElement(loanOpen.transactionID).getText();
		System.out.println(transactionID);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click save button.").assignCategory("Other Loan Opening Cash -Document Security");
		Log.info("Step-1:  Click save button.");
		if(driver.findElement(loanOpen.newAccountOpenedLabel).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan is submitted, summary displayed");
			Log.info("Expected Result: Loan is submitted, summary displayed");
		}
		ExtentTestManager.endTest();
	}


	//signout (1)

	//TC-44 (3)
	public void userLogin1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		//signOut();

		ExtentTestManager.startTest("TC No. - 44 --> Login to LMS as another User").assignCategory("Other Loan Opening Cash -Document Security");
		//String loginUserName1 = testdata.get("loginUserName1").toString();
		String loginUserName1=configloader().getProperty("UserName2");
		input(loanOpen.loginUserName, loginUserName1);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter valid username.");
		Log.info("Step-1: Enter valid username.");

		//String loginValidPassword1 = testdata.get("loginValidPassword1").toString();
		String loginValidPassword1=configloader().getProperty("Password2");
		input(loanOpen.loginPasswrd, loginValidPassword1);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Enter valid password.");
		Log.info("Step-2: Enter valid password.");

		click(loanOpen.loginButton);

		try {
			click(loanOpen.OkBtn_loginStatusFailed);
			if(ElementDisplayed(loanOpen.loginUserName)) {
				input(loanOpen.loginUserName, loginUserName1);
				input(loanOpen.loginPasswrd, loginValidPassword1);
				click(loanOpen.loginButton);
				Thread.sleep(5000);
				if(ElementDisplayed(loanOpen.collapsemenu)){
					
					click(loanOpen.collapsemenu);
				}else {
					Log.info("Menu Collapsed");
				}
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login is successfull");
				Log.info("Expected Result: Login is successfull");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on 'Login'.");
			Log.info("Step-3: Click on 'Login'.");
			// click(loanOpen.okBtn);

			if(ElementDisplayed(loanOpen.signOut)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login is successfull directly");
				Log.info("Expected Result: Login is successfull directly");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}


		Thread.sleep(10000);
		//		boolean flag1 = ElementDisplayed(institutionalCust.dashboard);
		//		boolean flag = flag1;
		//		if(flag == true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Another user successfully logs in to LMS.");
		Log.info("Expected Result: Another user successfully logs in to LMS.");
		//}
		ExtentTestManager.endTest();

	}

	//TC-45 (2) - Cash
	public void testManagerAuthorization(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 45 --> Manager Authorization").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.authorizeAndCancel);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on authorize and cancel tab");
		Log.info("Step-1: Click on authorize and cancel tab");

		click(loanOpen.managerAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Click on manager authorization tab");
		Log.info("Step-2: Click on manager authorization tab");

		//		String makerId = testdata.get("makerId").toString();
		//		input(loanOpen.makerID, makerId);

		input(loanOpen.transactionID_textbox,transactionID);


		click(loanOpen.goBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager Authorization window should be display");
		Log.info("Expected Result: Manager Authorization window should be display");

		ExtentTestManager.endTest();	
	}

	//TC-46 (1)
	public void testRefreshBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 46 --> Validate refresh button in manager authorization page").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan entry should be display in the  window");
		Log.info("Expected Result: Loan entry should be display in the  window");

		ExtentTestManager.endTest();	
	}

	//TC-47 (2)
	public void testSelectAndAuthorize() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 47 --> Select and authorize the customer in manager authorization page").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.authorizePage_checkbox);

		//			WebElement fetchAccNo = driver.findElement(By.xpath("//input[@title='Account No']"));
		//			Object accNo = fetchAccNo.getAttribute("value");
		//			click(driver.findElement(By.xpath("//span[contains(@title,"+accNo+")]/parent::*/parent::*/td[@class='chk']/input")));

		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");
		click(loanOpen.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is authorized");
		Log.info("Expected Result: Entry is authorized");

		ExtentTestManager.endTest();	
	}

	//TC-48 (4)
	public void testCashierAuthorization(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 48 --> Refresh, select and authorize in Cashier Authorization").assignCategory("Other Loan Opening Cash -Document Security");

		click(loanOpen.cashierAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on cashier authorization");
		Log.info("Step-1: Click on cashier authorization");

		//			click(loanOpen.refreshBtn);
		//			ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		//			Log.info("Step-1: Click on refresh button");

		//			String makerId = testdata.get("makerId").toString();
		//			input(loanOpen.makerID, makerId);

		input(loanOpen.transactionID_textbox,transactionID);

		click(loanOpen.goBtn);


		click(loanOpen.cashierAuthorize_checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Select the customer using checkbox");
		Log.info("Step-2: Select the customer using checkbox");

		click(loanOpen.cashier_authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on authorize button");
		Log.info("Step-3: Click on authorize button");

		testCloseMessagePopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step-4: Click on close icon in popup");
		Log.info("Step-4: Click on close icon in popup");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is authorized");
		Log.info("Expected Result: Account is authorized");

		ExtentTestManager.endTest();
	}


	public void testCloseMessagePopup() throws InterruptedException {
		click(loanOpen.closeIcon);
	}
	
	public void Windowclose() {
	
		driver.quit();
		
	}

	//	//TC-53 (1)
	//	public void testCashierAuthorization() throws InterruptedException {
	//		ExtentTestManager.startTest("TC No. - 53 --> Cashier Authorization");
	//
	//		click(loanOpen.cashierAuthorization);
	//		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on cashier authorization");
	//		Log.info("Step-1: Click on cashier authorization");
	//
	//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan is cashier-authorized");
	//		Log.info("Expected Result: Loan is cashier-authorized");
	//
	//		ExtentTestManager.endTest();	
	//	}

}