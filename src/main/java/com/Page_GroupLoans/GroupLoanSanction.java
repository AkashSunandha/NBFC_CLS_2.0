
package com.Page_GroupLoans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanAgreement;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanSanction;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanSanction extends Base_Class{
	By lastSelectXPath;
	int lastRow;

	PageRepositary_GroupLoans_GroupLoanSanction grpLoanSactRepo = new PageRepositary_GroupLoans_GroupLoanSanction();

	public void groupLoanSanction() throws InterruptedException {
		
		//Navigation of  group loan agreement page  
		ExtentTestManager.startTest("Navigation of  group loan agreement page ");
		Log.info("Navigation of  group loan agreement page ");
		
		click(grpLoanSactRepo.groupLoansTab);
		
		click(grpLoanSactRepo.groupLoansSactionTab);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan sanction page.\"");
		Log.info("\"1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan sanction page.\"");
		
		if(ElementDisplayed(grpLoanSactRepo.gdBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " +  "Group loan sanction page loaded \"");
			Log.info("Expected Result: " +  "Group loan sanction page loaded \"");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupDetails() throws InterruptedException {
		
		
		//Select Trivandrum Branch 
		ExtentTestManager.startTest("Select Trivandrum Branch");
		Log.info("Select Trivandrum Branch");
		
		select("TRIVANDRUM",grpLoanSactRepo.gdBranchDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
		Log.info("\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
				
		if(dropdownSelectionValidation("TRIVANDRUM",grpLoanSactRepo.gdBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
			Log.info("Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Center from Dropdown
		ExtentTestManager.startTest("Select Center from Dropdown");
		Log.info("Select Center from Dropdown");
		
		select("14 - GUARANTOR",grpLoanSactRepo.gdCentreDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Open the center dropdown\r\n"
				+ "2. Select a center\"");
		Log.info("\"1. Open the center dropdown\r\n"
				+ "2. Select a center\"");
		
		waitUntilElementDisappear(grpLoanSactRepo.loader);
		
		if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanSactRepo.gdCentreDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Chosen center is displayed in the center field.");
			Log.info("Expected Result: " + "Chosen center is displayed in the center field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Group from Drop down
		ExtentTestManager.startTest("Select Group from Dropdown");
		Log.info("Select Group from Dropdown");
		
		select("25 - GUARANTOR 3",grpLoanSactRepo.gdGroupDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on Group Name Dropdown.\r\n"
				+ "2. Select a Group.\"");
		Log.info("\"1. Click on Group Name Dropdown.\r\n"
				+ "2. Select a Group.\"");
		
		waitUntilElementDisappear(grpLoanSactRepo.loader);
		
		if(dropdownSelectionValidation("25 - GUARANTOR 3",grpLoanSactRepo.gdGroupDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Chosen group is displayed in the group field");
			Log.info("Expected Result: " + "Chosen group is displayed in the group field");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
//		Applications Listed after Clicking GO
		ExtentTestManager.startTest("Applications Listed after Clicking GO");
		Log.info("Applications Listed after Clicking GO");
				
		click(grpLoanSactRepo.gdGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
		
		waitUntilElementDisappear(grpLoanSactRepo.loader);

		if(ElementDisplayed(grpLoanSactRepo.gdSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Applications are listed in a grid");
			Log.info("Expected Result: " + "Applications are listed in a grid");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Display Application Details
		ExtentTestManager.startTest("Display Application Details");
		Log.info("Display Application Details");
				
		
	       WebElement table = driver.findElement(By.xpath("//*[@id=\"tblLoanApplications\"]"));
	       
	        // Find all <tr> elements in the table
	        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
	 	        
	        // Output the number of <tr> tags
	        System.out.println("Number of rows in the table: " + rows.size());
	        lastRow = rows.size();
	        System.out.println("lastRow: " + lastRow);
	        
	        if(lastRow>1) {
	        	lastRow=lastRow-2;
	        	System.out.println("updatedlastRow:" + lastRow);
	        
	        if(lastRow<10) {
			String xpath = "//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstLoanApplications_ctrl"+ lastRow +"_lnkSelect\"]";
			lastSelectXPath = By.xpath(xpath);
	        }else {
				String xpath = "//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstLoanApplications_ctrl"+ lastRow +"_lnkSelect\"]";
				lastSelectXPath = By.xpath(xpath);
	        }
	        }
	        else {
	        	
	        }
	        ScrollUntilElementVisible(lastSelectXPath);

		click(lastSelectXPath);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the 'Select' button for an application");
		Log.info("1. Click the 'Select' button for an application");
		
		waitUntilElementDisappear(grpLoanSactRepo.loader);

		ScrollUntilElementVisible(grpLoanSactRepo.sanctionBtn);
		
		if(ElementDisplayed(grpLoanSactRepo.applicationDetailsTab) && ElementDisplayed(grpLoanSactRepo.loanAmtTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Application details are displayed");
			Log.info("Expected Result: " + "Application details are displayed");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Sanction Application
		ExtentTestManager.startTest("Sanction Application");
		Log.info("Sanction Application");
				
		click(grpLoanSactRepo.sanctionBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on 'Sanction' button");
		Log.info("1. Click on 'Sanction' button");
        
		if(ElementDisplayed(grpLoanSactRepo.popSuccessMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Message 'Application Sanction Successfully' is displayed");
			Log.info("Expected Result: " + "Message 'Application Sanction Successfully' is displayed");
			
			click(grpLoanSactRepo.popUpCloseBtn);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end

	
	
}
