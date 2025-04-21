package com.Page_AccountOpening;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_AccountSearch;
import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class AccountSearchEditbutton extends Base_Class {

	PageRepositary_AccOpn_AccountSearch AccountSearchRepo = new PageRepositary_AccOpn_AccountSearch();

	public String sp = "GetOtherloanAccountnumber";
	public String columnName = "Acno";

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
		click(AccountSearchRepo.SearchButton);
		ExtentSuccessMessage("Clicked on Search Button");
		Log.info("Clicked on Search Button");
	}

	public void ClickOnClearButton() throws InterruptedException {
		click(AccountSearchRepo.ClearButton);
		ExtentSuccessMessage("Clicked on Clear Button");
		Log.info("Clicked on Clear Button");
	}

	public void NavigateToAccSearchTab() throws InterruptedException {
		ExtentTestManager.startTest("Navigate to Account Search Window");
		Log.info("Navigate to Account Search Window");
		ClickOnaccountOpeningTab();
		ClickOnSearchTab();
		ClickOnAccountSearchTab();
		ExtentTestManager.endTest();
	}

	public void SelectAllDropdown() throws InterruptedException {		
		SelectGroupDropdown();
		SelectSubGroupDropdown();
		SelectProductDropdown();
	}

	public void AccSearchInfo(Map<Object, Object> testdata) throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("Select Group, Subgroup, and Product");
		Log.info("Select Group, Subgroup, and Product");
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

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		EnterAccNo(AccNum);
		ClickOnSearchButton();

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
		ExtentTestManager.startTest("Enter an Valid Account no in the field.");
		Log.info("Enter an Valid Account no in the field.");
		clear(AccountSearchRepo.AccNoField);
		click(AccountSearchRepo.AccNoField);
		input(AccountSearchRepo.AccNoField,AccNo);
		ExtentSuccessMessage( "Step:01 - Enter a valid Account No in the input field.");
		Log.info("Step:01 - Enter a valid Account No in the input field.");
		//		ExtentTestManager.endTest();
	}



}
