package com.Page_AccountOpening;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_AccountSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccountSearchEditbutton extends Base_Class {

	PageRepositary_AccOpn_AccountSearch AccountSearchRepo = new PageRepositary_AccOpn_AccountSearch();

	public String sp = "GetOtherloanAccountnumber";
	public String columnName = "Acno";
	String actualUserName;
	String valueAccNum;
	public void ClickOnaccountOpeningTab() throws InterruptedException {
		click(AccountSearchRepo.accountOpeningTab);
		ExtentSuccessMessage("Clicked on Account Opening Tab");
		Log.info("Clicked on Account Opening Tab");
	}

	public void ClickOnSearchTab() throws InterruptedException {
		click(AccountSearchRepo.Search);
		ExtentSuccessMessage("Clicked on Search Tab");
		Log.info("Clicked on Search Tab");
	}

	public void ClickOnAccountSearchTab() throws InterruptedException {
		click(AccountSearchRepo.AccountSearch);
		ExtentSuccessMessage("Clicked on Account Search Tab");
		Log.info("Clicked on Account Search Tab");
	}

	public void ClickOnSearchButton() throws InterruptedException {
		ExtentTestManager.startTest("Clicked on Search Button");
		click(AccountSearchRepo.SearchButton);
		ExtentSuccessMessage("Clicked on Search Button");
		Log.info("Clicked on Search Button");
		ExtentTestManager.endTest();
	}

	public void ClickOnClearButton() throws InterruptedException {
		ExtentTestManager.startTest("Clicked on Clear Button");
		click(AccountSearchRepo.ClearButton);
		ExtentSuccessMessage("Clicked on Clear Button");
		Log.info("Clicked on Clear Button");
		ExtentTestManager.endTest();
	}

	public void NavigateToAccSearchTab() throws InterruptedException {
		actualUserName = GetElementText(AccountSearchRepo.actualUserName);
		System.out.println("actualUserName: "+actualUserName);
		if(ElementDisplayed(AccountSearchRepo.CollapseAll)) {
			click(AccountSearchRepo.CollapseAll);
		}
		ExtentTestManager.startTest("Navigate to Account Search Window");
		Log.info("Navigate to Account Search Window");
		ClickOnaccountOpeningTab();
		ClickOnSearchTab();
		ClickOnAccountSearchTab();
		ExtentTestManager.endTest();
	}

	public void SelectAllDropdown() throws InterruptedException {	
		ExtentTestManager.startTest("Select Group, Subgroup, and Product");
		Log.info("Select Group, Subgroup, and Product");
		SelectGroupDropdown();
		SelectSubGroupDropdown();
		SelectProductDropdown();
		ExtentTestManager.endTest();
	}
	public void Signout() throws InterruptedException {
		click(AccountSearchRepo.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");
	}

	public void Signin() throws InterruptedException, IOException {
		String UserName = configloader().getProperty("UserName");
		input(AccountSearchRepo.loginUserName, UserName);
		String Password = configloader().getProperty("Password");
		input(AccountSearchRepo.loginPasswrd, Password);
		click(AccountSearchRepo.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
		try {
			ElementDisplayed(AccountSearchRepo.home);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}
		catch(Exception e) {
			ElementDisplayed(AccountSearchRepo.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(AccountSearchRepo.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");

			//					String loginUserName = testdata.get("loginUserName").toString();
			input(AccountSearchRepo.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");

			//					String loginValidPassword = testdata.get("loginValidPassword").toString();
			input(AccountSearchRepo.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");

			click(AccountSearchRepo.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");

			ElementDisplayed(AccountSearchRepo.home);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
			Log.info("Expected Result: User is logged in successfully and dashboard visible");	
		}
		ExtentTestManager.endTest();
		String userName = GetElementText(AccountSearchRepo.actualUserName);
		System.out.println(userName);

	}
	public void AccSearchInfo(Map<Object, Object> testdata) throws InterruptedException, ClassNotFoundException {
		SelectAllDropdown();
		EnterName(testdata);
		ClickOnSearchButton();
		List<WebElement> AccNameList =driver.findElements(By.xpath("(//table[@id='tblAccountList']//tbody//tr//td[6]//span)"));
		System.out.println("AccNameList Size:-"+AccNameList.size());
		for(int i=0;i<AccNameList.size();i++) {
			int j=i+1;
			By Xpaths=By.xpath("(//table[@id='tblAccountList']//tbody//tr//td[6]//span)["+j+"]");
			String FirstAccname =GetElementText(Xpaths);			
			if(FirstAccname.contains(testdata.get("Alphabet").toString())) {
				Log.info("All accounts with account holder names containing the given alphabet should be listed.");
				ExtentSuccessMessage("All accounts with account holder names containing the given alphabet should be listed.");			
			}else{
				Log.error("account holder names is not containing the given alphabet. Row number:-"+j);
				ExtentErrorMessage("account holder names is not containing the given alphabet. Row number:-"+j);
			}
		}		
		ExtentTestManager.endTest();
		ClickOnClearButton();
		ExtentTestManager.endTest();
		ExtentTestManager.startTest("Select Group, Subgroup, and Product");
		Log.info("Select Group, Subgroup, and Product");
		SelectAllDropdown();
		EnterHouseName(testdata);
		ClickOnSearchButton();
		List<WebElement> HouseNameList =driver.findElements(By.xpath("(//table[@id='tblAccountList']//tbody//tr//td[7]//span)"));
		System.out.println("AccNameList Size:-"+HouseNameList.size());
		for(int i=0;i<HouseNameList.size();i++) {
			int j=i+1;
			By Xpaths=By.xpath("(//table[@id='tblAccountList']//tbody//tr//td[7]//span)["+j+"]");
			String FirstAccname =GetElementText(Xpaths);			
			if(FirstAccname.contains(testdata.get("HouseName").toString())) {
				Log.info("All accounts with account holder house names containing the given alphabet should be listed.");
				ExtentSuccessMessage("All accounts with account holder house names containing the given alphabet should be listed.");			
			}else{
				Log.error("account holder House names is not containing the given alphabet. Row number:-"+j);
				ExtentErrorMessage("account holder House names is not containing the given alphabet. Row number:-"+j);
			}
		}		
		ExtentTestManager.endTest();
		ClickOnClearButton();
		ExtentTestManager.endTest();

		valueAccNum = generateUniqueCode(sp, columnName);
		System.out.println("valueAccNum:-"+valueAccNum);
		EnterAccNo(valueAccNum);
		ClickOnSearchButton();
		SelectFirstCheckBox();
		ClickOnEditButton();
		EnterRemark("Remark Automation testing");
		ClickOnSaveButton();
		ClickOnCloseUpdateMsgPopup();


	}

	public void DeleteAcc() throws InterruptedException, ClassNotFoundException {
		valueAccNum = generateUniqueCode(sp, columnName);
		System.out.println("valueAccNum:-"+valueAccNum);
		EnterAccNo(valueAccNum);
		ClickOnSearchButton();
		SelectFirstCheckBox();
		ClickOnDeleteButton();

	}

	public void ViewDocument() throws InterruptedException {
		SelectFirstCheckBox();
		ClickOnView_DocumentButton();
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;

				if (ElementDisplayed(AccountSearchRepo.VerifyView_Document)) {
					ExtentSuccessMessage("Expected Result: View Document popup window will be opened.");
					Log.info("Expected Result: View Document popup window will be opened.");
					driver.close();
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}

				ExtentTestManager.endTest();

			}
		}

		driver.switchTo().window(mainWindowHandle);


	}

	public void ViewImages() throws InterruptedException {
		//		SelectFirstCheckBox();
		ClickOnView_ImagesButton();
	}

	public void SelectFirstCheckBox() throws InterruptedException {			
		if(ElementDisplayed(AccountSearchRepo.FirstCheckBox)) {
			ExtentTestManager.startTest("Verify checkbox presence");
			click(AccountSearchRepo.FirstCheckBox);
			ExtentSuccessMessage("Selected the First Check Box");
			Log.info("Selected the First Check Box");
		}else {
			ExtentErrorMessage("checkbox Not presence");
		}
		ExtentTestManager.endTest();
	}
	public void ClickOnSaveButton() throws InterruptedException {
		click(AccountSearchRepo.SaveChnages);
		ExtentSuccessMessage("Clicked on Save Button");
		Log.info("Clicked on Save Button");
		if(ElementDisplayed(AccountSearchRepo.Savemessage)) {
			ExtentSuccessMessage("'Updated successfully' message displayed");
		}else {
			ExtentErrorMessage("'Updated successfully' message not displayed");
		}

	}
	public void ClickOnCloseUpdateMsgPopup() throws InterruptedException {
		click(AccountSearchRepo.CloseUpdateMsgPopup);
		ExtentSuccessMessage("Clicked on Close Update Msg Popup");
		Log.info("Clicked on Close Update Msg Popup");		
	}
	public void ClickOnCancelButton() throws InterruptedException {
		click(AccountSearchRepo.CancelButton);
		ExtentSuccessMessage("Clicked on Cancel Button");
		Log.info("Clicked on Cancel Button");		
	}

	public void ClickOnDeleteButton() throws InterruptedException {
		click(AccountSearchRepo.DeleteButton);
		ExtentSuccessMessage("Clicked on Delete Button");
		Log.info("Clicked on Delete Button");
		AcceptAlert();
	}
	public void ClickOnView_DocumentButton() throws InterruptedException {
		click(AccountSearchRepo.View_DocumentButton);
		ExtentSuccessMessage("Clicked on View_Document Button");
		Log.info("Clicked on View_Document Button");		
	}
	public void ClickOnView_ImagesButton() throws InterruptedException {
		click(AccountSearchRepo.View_ImagesButton);
		ExtentSuccessMessage("Clicked on View_Images Button");
		Log.info("Clicked on View_Images Button");
		ViewImagesPopup();
	}


	public void ClickOnEditButton() throws InterruptedException {
		click(AccountSearchRepo.EditButton);
		ExtentSuccessMessage("Clicked on Edit Button");
		Log.info("Clicked on Edit Button");
		Thread.sleep(5000);
		if(ElementDisplayed(AccountSearchRepo.VerifyModifyPage)) {
			ExtentSuccessMessage("User Navigated to Account Info page");
		}else {
			ExtentErrorMessage("User not able Navigate to Account Info page");
		}
	}
	public void ClickOnViewButton() throws InterruptedException {
		click(AccountSearchRepo.ViewButton);
		ExtentSuccessMessage("Clicked on View Button");
		Log.info("Clicked on View Button");
		Thread.sleep(5000);
		if(ElementDisplayed(AccountSearchRepo.VerifyModifyPage)) {
			ExtentSuccessMessage("User Navigated to Account Info page");
		}else {
			ExtentErrorMessage("User not able Navigate to Account Info page");
		}

		VerifySaveButtondisable();
	}
	//	View_ImagesPopup
	public void ViewImagesPopup() throws InterruptedException {
		if(ElementDisplayed(AccountSearchRepo.View_ImagesPopup)) {
			ExtentSuccessMessage("User Navigated to View Images Popup page");
		}else {
			ExtentErrorMessage("User not able to Navigated to View Images Popup page");
		}
		click(AccountSearchRepo.View_ImagesPopupClose);
		ExtentSuccessMessage("Clicked on View_Images Popup Close Button");
		Log.info("Clicked on View_Images Popup Close Button");
	}


	public void VerifySaveButtondisable() throws InterruptedException {
		ScrollUntilElementVisible(AccountSearchRepo.SaveChnages);
		if(ElementDisplayed(AccountSearchRepo.SaveChnages)) {
			String ButtonStatus =GetElementAttribute(AccountSearchRepo.SaveChnages, "disabled");
			System.out.println("ButtonStatus:-"+ButtonStatus);
			if(ButtonStatus.contains("true")) {
				ExtentSuccessMessage("User Verify save button is disabled");
			}else {
				ExtentErrorMessage("User Verify save button is Not disabled");
			}
		}
	}

	public void SelectGroupDropdown() throws InterruptedException {
		//		ExtentTestManager.startTest("Select Group Dropdown");
		//		Log.info("Select Group Dropdown");
		select("Loan",AccountSearchRepo.GroupDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'Loan' for Group Dropdown.");
		Log.info("Step:01 -  Choose 'Loan' for Group Dropdown.");
		//		ExtentTestManager.endTest();	
	}

	public void SelectSubGroupDropdown() throws InterruptedException {
		//		ExtentTestManager.startTest("Select Sub Group Dropdown");
		//		Log.info("Select Sub Group Dropdown");
		select("OTHER LOANS",AccountSearchRepo.SubGroupDropdown);
		ExtentSuccessMessage( "Step:01 -  Choose 'OTHER LOANS' for Sub Group Dropdown.");
		Log.info("Step:01 -  Choose 'OTHER LOANS' for Sub Group Dropdown.");
		//		ExtentTestManager.endTest();	
	}
	public void SelectProductDropdown() throws InterruptedException {
		//		ExtentTestManager.startTest("Select Product Dropdown");
		//		Log.info("Select Product Dropdown");
		System.out.println("debug");
		click(AccountSearchRepo.ProductDropdown);
		click(AccountSearchRepo.ProductddValue);
		ExtentSuccessMessage( "Step:01 -  Choose 'PERSONAL LOAN WEEKLY ' for Product Dropdown.");
		Log.info("Step:01 -  Choose 'PERSONAL LOAN WEEKLY ' for Product Dropdown.");
		//		ExtentTestManager.endTest();	
	}
	public void EnterName (Map<Object, Object> testdata) throws InterruptedException {

		ExtentTestManager.startTest("Enter an alphabet in the name field.");
		Log.info("Enter an alphabet in the name field.");
		String Alphabet=testdata.get("Alphabet").toString();
		clear(AccountSearchRepo.Name);
		click(AccountSearchRepo.Name);
		input(AccountSearchRepo.Name,Alphabet);
		ExtentSuccessMessage( "Step:01 - Enter a valid Account Name in the input field.");
		Log.info("Step:01 - Enter a valid Account Name in the input field.");
		//		ExtentTestManager.endTest();
	}

	public void EnterHouseName(Map<Object, Object> testdata) throws InterruptedException {
		ExtentTestManager.startTest("Enter an alphabet in the House Name field.");
		Log.info("Enter an alphabet in the House Name field.");
		String Alphabet=testdata.get("HouseName").toString();
		clear(AccountSearchRepo.HouseName);
		click(AccountSearchRepo.HouseName);
		input(AccountSearchRepo.HouseName,Alphabet);
		ExtentSuccessMessage( "Step:01 - Enter a valid Account House Name in the input field.");
		Log.info("Step:01 - Enter a valid Account House Name in the input field.");
		//		ExtentTestManager.endTest();
	}

	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");

		{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019";
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

			String value = null; // Declare and initialize the return variable

			// Establish the connection to the database
			try (Connection connection = DriverManager.getConnection(Url, UserName, Password); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

				if (resultSet.next()) {
					value = resultSet.getString(columnName); // DB column name
					System.out.println("Generated Unique ID: " + value);
				} else {
					System.out.println("Unique ID not generated.");
				}

			} catch (SQLException e) {
				System.out.println("Error executing the SQL query or processing the result set.");
				e.printStackTrace();
			}

			return value; // Return the firstCustId
		}

	}
	public void EnterAccNo(String AccNo) throws InterruptedException {			
		if(ElementDisplayed(AccountSearchRepo.AccNoField)) {
			ExtentTestManager.startTest("Verify the presence of 'Account no' text field");
			ExtentTestManager.endTest();
			ExtentTestManager.startTest("Enter an Valid Account no in the field.");
			Log.info("Enter an Valid Account no in the field.");
			clear(AccountSearchRepo.AccNoField);
			click(AccountSearchRepo.AccNoField);
			input(AccountSearchRepo.AccNoField,AccNo);
			ExtentSuccessMessage( "Step:01 - Enter a valid Account No in the input field.");
			Log.info("Step:01 - Enter a valid Account No in the input field.");
			ExtentTestManager.endTest();
		}

	}

	public void EnterRemark(String AccNo) throws InterruptedException {
		ExtentTestManager.startTest("Enter an Valid Remark in the field.");
		Log.info("Enter an Valid Remark  in the field.");
		String Get=GetElementAttribute(AccountSearchRepo.Agentnamefield, "value");
		System.out.println("Get:-"+Get);
		clear(AccountSearchRepo.Remark);
		click(AccountSearchRepo.Remark);
		input(AccountSearchRepo.Remark,AccNo);
		ExtentSuccessMessage( "Step:01 - Enter a valid Remark in the input field.");
		Log.info("Step:01 - Enter a valid Remark in the input field.");
		//		ExtentTestManager.endTest();
	}

	public void authorizeOthers(Map < Object, Object > testdata, ITestContext context) throws InterruptedException, IOException {

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");

		click(AccountSearchRepo.custSignOut);
		ExtentSuccessMessage("Step:01 - Log out");
		Log.info("Step:01 - Log out");

		String UserName = configloader().getProperty("UserName2");
		input(AccountSearchRepo.loginUserName, UserName);
		String Password = configloader().getProperty("Password2");
		input(AccountSearchRepo.loginPasswrd, Password);
		click(AccountSearchRepo.loginButton);
		ExtentSuccessMessage("Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");



		ExtentTestManager.endTest();
		if(ElementDisplayed(AccountSearchRepo.CollapseAll)) {
			click(AccountSearchRepo.CollapseAll);
		}


		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");

		click(AccountSearchRepo.autorizeAndCancelTab);
		ExtentSuccessMessage("Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");

		click(AccountSearchRepo.managerAuthoTab);
		ExtentSuccessMessage("Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");

		click(AccountSearchRepo.sOthersTab);
		ExtentSuccessMessage("Step:03 - Click \"Others\" tab");
		Log.info("Step:03 - Click \"Others\" tab");

		ExtentSuccessMessage("Expected Result: Others tab load");
		Log.info("Expected Result: Others tab load");

		ExtentTestManager.endTest();

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");

		click(AccountSearchRepo.refreshBtn);
		ExtentSuccessMessage("Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");

		input(AccountSearchRepo.MakerID, actualUserName);
		click(AccountSearchRepo.goBtn);
		//		System.out.println("transIdTransferPersonal " + transId);
		//		fetchWithTransId(transId);

		By approveCheckBoxTransfer =By.xpath("//td[@class='AcNo'][contains(text(),'"+valueAccNum+"')]//parent::tr//td[@class='chk']//*[@type='checkbox']");
		if (ElementDisplayed(approveCheckBoxTransfer)) {
			ExtentSuccessMessage("Expected Result: Loan opening entry displayed");
			Log.info("Expected Result: Loan opening entry displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		ExtentTestManager.endTest();

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");

		click(approveCheckBoxTransfer);
		ExtentSuccessMessage("Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");

		click(AccountSearchRepo.authorizeBtn);
		ExtentSuccessMessage("Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");

		if (ElementDisplayed(AccountSearchRepo.confirmationPopUp)) {
			ExtentSuccessMessage("Expected Result: Transaction gets authorised");
			Log.info("Expected Result: Transaction gets authorised");
			click(AccountSearchRepo.confirmationPopUp);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	} //end

}
