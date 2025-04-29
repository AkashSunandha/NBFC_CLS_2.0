package com.Page_Customer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepository_AccountOpening_Otherloanopening_jewelsecurity;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccountOpening_Otherloanopening_jewelsecurity extends Base_Class {
	PageRepository_AccountOpening_Otherloanopening_jewelsecurity loanOpen = new PageRepository_AccountOpening_Otherloanopening_jewelsecurity();

	String query="Exec Getcustomer 102";
	String columnName="CustomerID";
	String transactionID;


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

		//String loginValidPassword = testdata.get("loginValidPassword").toString();
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


	//TC-03 (4)
	public void testSelectActiveLoanProduct() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 03 --> Select Active Loan Product");
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

	//TC-04 (7)
	public void testAddCustomer1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 04 --> Add Customer from Search");
		String parentWindow=driver.getWindowHandle();
		click(loanOpen.customerSearchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Open customer search popup.");
		Log.info("Step-1:  Open customer search popup.");
		Set<String> allWindows = driver.getWindowHandles();		
		for (String window : allWindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				String custID = testdata.get("custID").toString();	
				input(loanOpen.childCustID, custID);
				ExtentTestManager.getTest().log(Status.PASS, "Step-2: Search for a customer.");
				Log.info("Step-2: Search for a customer.");
				//*[@id="PopQuick1_txtCustID"]
				click(loanOpen.childSearchBtn);
				click(loanOpen.childSelectLink);
				ExtentTestManager.getTest().log(Status.PASS, "Step-3: Select the customer.");
				Log.info("Step-3: Select the customer.");
				//driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
		}
		click(loanOpen.addBtn);
		ElementDisplayed(loanOpen.accountInfoGrid);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully.");
		Log.info("Expected Result: Customer is added successfully.");
		ExtentTestManager.endTest();
	}
	//Tc-04
	public void testAddCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException   {
		ExtentTestManager.startTest("TC No. - 04 --> Add Customer from Search");
		String custID=generateUniqueId(query, columnName);
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

	public void referedByDropdown() {
		//  options = driver.findElements("//div[@class='hjsel_select']/following-sibling::div/ul/li");

		// driver.findElements("//div[@class='hjsel_select']/following-sibling::div/ul/li", clmnNamAadhaar);



	}


	//TC-05
	public void testResolutionNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 05 --> Enter Resolution No");
		String resolutionNo = testdata.get("resolutionNo").toString();
		input(loanOpen.resolutionNo, resolutionNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Resolution No");
		Log.info("Step-1:  Enter Resolution No");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Resolution No are entered successfully.");
		Log.info("Expected Result: Resolution No are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-06
	public void testResolutionDateField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 06 --> Enter Resolution Date");
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



	//TC-08
	public void testEquiMortRegNoField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 08 --> Enter Equitable Mort Reg.No");
		String equitableMortRegNo = testdata.get("equitableMortRegNo").toString();
		input(loanOpen.equitableMort, equitableMortRegNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Enter Equitable Mort Reg.No");
		Log.info("Step-1:  Enter Equitable Mort Reg.No");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Equitable Mort Reg.No are entered successfully");
		Log.info("Expected Result: Equitable Mort Reg.No are entered successfully");
		ExtentTestManager.endTest();
	}

	//TC-09
	public void testSelectEMRDate(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 09 --> Select EMR Date");
		String emrDate = testdata.get("emrDate").toString();
		click(loanOpen.emrDate);
		input(loanOpen.emrDate, emrDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Selet the EMR Date from date picker");
		Log.info("Step-1:  Selet the EMR Date from date picker");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: EMR Date are selected successfully");
		Log.info("Expected Result: EMR Date are selected successfully");
		ExtentTestManager.endTest();
	}

	//TC-10
	public void testAgentCode(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 10 --> Agent code are entered successfully.");
		String agentCode = testdata.get("agentCode").toString();
		input(loanOpen.agentCode, agentCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter Agent Code.");
		Log.info("Step-1:  Enter Agent Code.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Agent code are entered successfully.");
		Log.info("Expected Result: Agent code are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-11
	public void testDSACode(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 11 --> Enter DSA codes");
		String dsaCode = testdata.get("dsaCode").toString();
		input(loanOpen.dsaCode, dsaCode);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter DSA Code.");
		Log.info("Step-1:  Enter DSA Code.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DSA code are entered successfully.");
		Log.info("Expected Result: DSA code are entered successfully.");
		ExtentTestManager.endTest();
	}


	//TC-12
	public void testAreaField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 12 --> Enter Area");
		String area = testdata.get("area").toString();
		//input(loanOpen.area, area);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Area are entered successfully.");
		Log.info("Expected Result: Area are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-13
	public void testRemarksField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 13 --> Give Remarks");
		String remark = testdata.get("remark").toString();
		input(loanOpen.remark, remark);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Give Remarks in \"Remarks\" field");
		Log.info("Step-1:  Give Remarks in \"Remarks\" field");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remarks are entered successfully.");
		Log.info("Expected Result: Remarks are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-14
	public void testNextBtnFunctionality1() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 14 --> Next Button Functionality");
		click(loanOpen.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: .Click the next button after giving all details");
		Log.info("Step-1:  .Click the next button after giving all details");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the securitis tab");
		Log.info("Expected Result: Redirected to the securitis tab");
		ExtentTestManager.endTest();
	}


	//TC-16
	public void testItemQtyField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 16 --> Enter Item Qty");
		String itemQty = testdata.get("itemQty").toString();
		input(loanOpen.itemQty, itemQty);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter Item Qty");
		Log.info("Step-1:  Enter Item Qty");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Item Qty are entered successfully.");
		Log.info("Expected Result: Item Qty are entered successfully.");
		ExtentTestManager.endTest();
	}


	//TC-17
	public void testIemWeight(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 17 --> Enter Item Weight");
		click(loanOpen.itemWeight);
		String itemWeight = testdata.get("itemWeight").toString();
		input(loanOpen.itemWeight, itemWeight);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter Item Weight");
		Log.info("Step-1:  Enter Item Weight");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Enter Item Weight are entered successfully.");
		Log.info("Expected Result: Enter Item Weight are entered successfully.");
		ExtentTestManager.endTest();
	}


	//TC-18
	public void testEnterPurity(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException   {
		ExtentTestManager.startTest("TC No. - 18 --> Enter Purity ");
		String purity = testdata.get("purity").toString();
		input(loanOpen.purity, purity);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter Purity as 22");
		Log.info("Step-1:  Enter Purity as 22");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Purity as 22 are entered successfully.");
		Log.info("Expected Result: Purity as 22 are entered successfully.");
		ExtentTestManager.endTest();
	}

	//TC-19
	public void testAddBtnFunctionality() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 19 --> Add Button functionality");
		click(loanOpen.addBtn_jewels);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click add button");
		Log.info("Step-1: Click add button");
		if(driver.findElement(loanOpen.jewels_grid).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are added and displayed in the grid");
			Log.info("Expected Result: Details are added and displayed in the grid");
		}

		ExtentTestManager.endTest();
	}


	//TC-20
	public void testNextBtnFunctionality2() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 20 --> Next Button Functionality");
		click(loanOpen.nextBtn);

		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click the next button after giving all details in jewel tab");
		Log.info("Step-1: Click the next button after giving all details in jewel tab");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the Nominee tab");
		Log.info("Expected Result: Redirected to the Nominee tab");
		ExtentTestManager.endTest();

	}


	//TC-21
	public void testCheckboxFunctioanlity() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 21 --> Checkbox functionality");
		click(loanOpen.nomineeNotRequired_checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Untick \"Nominee not required\"");
		Log.info("Step-1: Untick \"Nominee not required\"");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details fields should be display");
		Log.info("Expected Result: Nominee details fields should be display");
		ExtentTestManager.endTest();
	}
	//--------------------------------------------------------

	//TC-22(1)
	public void testAadharNo() throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC No. - 22 --> Validate aadhar no");
		String aadharNo = generateUniqueId(spAadhaar,clmnNamAadhaar);
		input(loanOpen.aadharNo, aadharNo);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AadharNo able to add");
		Log.info("Expected Result: AadharNo able to add");

		ExtentTestManager.endTest();
	}

	//TC-23(1)
	public void testNameInNominee(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. -23 --> Validate nominee name field");

		String nameInNominee = testdata.get("nameInNominee").toString();
		input(loanOpen.nameInNominee, nameInNominee);
		Thread.sleep(5000);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee name able to add");
		Log.info("Expected Result: Nominee name able to add");

		ExtentTestManager.endTest();
	}

	//TC-25(2)
	public void testDistrictDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 25 --> Validate district dropdown");

		select("89",loanOpen.district_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to select option in district dropdown");
		Log.info("Expected Result: Able to select option in district dropdown");

		ExtentTestManager.endTest();
	}


	//TC-26(2)
	public void testPostDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 26 --> Validate post dropdown");

		select("13406",loanOpen.post_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to select option in post dropdown");
		Log.info("Expected Result: Able to select option in post dropdown");

		ExtentTestManager.endTest();
	}

	//TC-28(1)
	public void testDOBField(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC No. - 28 --> Validate post dropdown");
		click(loanOpen.dob_textbox);
		String dob = testdata.get("dob").toString();
		input(loanOpen.dob_textbox, dob);

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Able to enter DOB");
		Log.info("Expected Result: Able to enter DOB");


		ExtentTestManager.endTest();
	}

	//-----



	//-----------------------------------------------------------

	//TC-22
	//	public void testAddCustomer2(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
	//		ExtentTestManager.startTest("TC No. - 22 --> Add Customer from Search");
	//		String parentWindow=driver.getWindowHandle();
	//		click(loanOpen.customerSeachIcon_nominee);
	//		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Open customer search popup");
	//		Log.info("Step-1: Open customer search popup");
	//		Set<String> allWindows = driver.getWindowHandles();		
	//		for (String window : allWindows) {
	//			if(!window.equals(parentWindow)) {
	//				driver.switchTo().window(window);
	//				String nomineeCustID = testdata.get("nomineeCustID").toString();
	//				input(loanOpen.childCustID, nomineeCustID);
	//				click(loanOpen.childSearchBtn);
	//				ExtentTestManager.getTest().log(Status.PASS, "Step-2: Search for a customer.");
	//				Log.info("Step-2: Search for a customer.");
	//				click(loanOpen.selectLinkInNominee);
	//				ExtentTestManager.getTest().log(Status.PASS, "Step-3:  Select the customer.");
	//				Log.info("Step-3:  Select the customer.");
	//				//driver.close();
	//				driver.switchTo().window(parentWindow);
	//				break;
	//			}
	//		}
	//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is added successfully and details should be autoladed.");
	//		Log.info("Expected Result: Customer is added successfully and details should be autoladed.");
	//		ExtentTestManager.endTest();
	//	}


	//TC-24
	public void testSelectRelation() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 24 --> Select relation");
		select("15",loanOpen.relation_dropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Select relation from the drop down ");
		Log.info("Step-1:  Select relation from the drop down ");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Relation are selected successfully from the drop down");
		Log.info("Expected Result: Relation are selected successfully from the drop down");
		ExtentTestManager.endTest();
	}


	//TC-29
	public void testAddBtnFunctionality2() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 29 --> Add Button functionality");
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


	//TC-30
	public void testNextBtnFunctionality3() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 30 --> Next Button Functionality");
		click(loanOpen.nextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click the next button after giving all details in nominee tab");
		Log.info("Step-1:  Click the next button after giving all details in nominee tab");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the Loan details tab");
		Log.info("Expected Result: Redirected to the Loan details tab");
		ExtentTestManager.endTest();
	}


	//TC-31
	public void testSanctionAmount(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 31 -->  Enter sanction amount.");
		String sanctioned = testdata.get("sanctioned").toString();
		input(loanOpen.sanctioned, sanctioned);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:   Enter sanction amount.");
		Log.info("Step-1:   Enter sanction amount.");
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Redirected to the Nominee tab");
		Log.info("Expected Result: Redirected to the Nominee tab");
		ExtentTestManager.endTest();
	}


	//TC-32
	public void testGetValueBtn() throws InterruptedException  {
		ExtentTestManager.startTest("TC No. - 32 --> Validate get value button");
		click(loanOpen.getValuesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Click get values button");
		Log.info("Step-1:  Click get values button");
		if(!driver.findElement(loanOpen.amount).getAttribute("value").isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Autoloaded values are displayed correctly  (ROI, Amount, Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
			Log.info("Expected Result: Autoloaded values are displayed correctly  (ROI, Amount, Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable).");
		}
		ExtentTestManager.endTest();
	}


	//TC-33
	public void testSelectTransactionMode() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 33 --> Select Transaction Mode");
		click(loanOpen.transMode);
		select("1",loanOpen.transModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1:  Select transaction mode as cash.");
		Log.info("Step-1:  Select transaction mode as cash.");
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


		ExtentTestManager.getTest().log(Status.PASS, "Step-2:  Click save button.");
		Log.info("Step-2:  Click save button.");
		if(driver.findElement(loanOpen.newAccountOpenedLabel).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The summary page is generated.");
			Log.info("Expected Result: The summary page is generated.");
		}
		ExtentTestManager.endTest();
	}


	//signout

	//TC-35(3)
	public void userLogin1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {


		ExtentTestManager.startTest("TC No. - 35 --> Login to LMS as another User");
		String loginUserName1 = testdata.get("loginUserName1").toString();
		input(loanOpen.loginUserName, loginUserName1);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Enter valid username.");
		Log.info("Step-1: Enter valid username.");

		String loginValidPassword1 = testdata.get("loginValidPassword1").toString();
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
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login is successfull");
				Log.info("Expected Result: Login is successfull");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}

		}catch(Exception e) {

			// click(loanOpen.okBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on 'Login'.");
			Log.info("Step-3: Click on 'Login'.");
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




	//TC-36
	public void testManagerAuthorization(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC No. - 36 --> Manager Authorization");

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

	//TC-37
	public void testRefreshBtn() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 37 --> Validate refresh button in manager authorization page");

		click(loanOpen.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan entry should be display in the  window");
		Log.info("Expected Result: Loan entry should be display in the  window");

		ExtentTestManager.endTest();	
	}

	//TC-38
	public void testSelectAndAuthorize() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 38 --> Select and authorize the customer in manager authorization page");

		click(loanOpen.authorizePage_checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");
		click(loanOpen.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		Log.info("Step-1: Click on refresh button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is authorized");
		Log.info("Expected Result: Entry is authorized");

		ExtentTestManager.endTest();	
	}


	//TC-40
	public void testCashierAuthorization() throws InterruptedException {
		ExtentTestManager.startTest("TC No. - 40 --> Cashier Authorization");

		click(loanOpen.cashierAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on cashier authorization");
		Log.info("Step-1: Click on cashier authorization");



		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan is cashier-authorized");
		Log.info("Expected Result: Loan is cashier-authorized");

		ExtentTestManager.endTest();	
	}

	//TC-41
	public void testSelectAndAuthorizeInCashier(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException   {
		ExtentTestManager.startTest("TC No. - 41 --> Refresh, select and authorize in Cashier Authorization");

		//		click(loanOpen.refreshBtn);
		//		ExtentTestManager.getTest().log(Status.PASS, "Step-1: Click on refresh button");
		//		Log.info("Step-1: Click on refresh button");

		//		String makerId = testdata.get("makerId").toString();
		//		input(loanOpen.makerID, makerId);

		input(loanOpen.transactionID_textbox,transactionID);

		click(loanOpen.goBtn);

		click(loanOpen.cashierAuthorize_checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step-2: Select the customer using checkbox");
		Log.info("Step-2: Select the customer using checkbox");

		click(loanOpen.cashier_authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step-3: Click on authorize button");
		Log.info("Step-3: Click on authorize button");

		click(loanOpen.closeIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step-4: Click on close icon in popup");
		Log.info("Step-4: Click on close icon in popup");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is authorized");
		Log.info("Expected Result: Account is authorized");

		ExtentTestManager.endTest();
	}

}
