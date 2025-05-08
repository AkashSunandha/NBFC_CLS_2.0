package com.Page_GroupLoans;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_GroupLoans_CentreGroupRegistration;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanApplication;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanApplication extends Base_Class{

	PageRepositary_GroupLoans_GroupLoanApplication grpLoanAppRegRepo = new PageRepositary_GroupLoans_GroupLoanApplication();
	

	public void navigateToGroupLoanApplication() throws InterruptedException {
		
		//Navigation of  group loan application page 
		ExtentTestManager.startTest("Navigation of  group loan application page ");
		Log.info("Navigation of  group loan application page ");
		
		click(grpLoanAppRegRepo.groupLoansTab);
		
		click(grpLoanAppRegRepo.groupLoanApplicationTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to the Group Loan Application page.");
		Log.info("1. Navigate to the Group Loan Application page.");
		
		if(ElementDisplayed(grpLoanAppRegRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group Loan Application page Loaded.");
			Log.info("Expected Result: " + "Group Loan Application page Loaded.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupInfo() throws InterruptedException {

		
		//Select Trivandrum Branch
		ExtentTestManager.startTest("Select Trivandrum Branch");
		Log.info("Select Trivandrum Branch");
		
		select("TRIVANDRUM",grpLoanAppRegRepo.giBranchDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
		Log.info("\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
		
//		waitUntilElementDisappear(grpLoanAppRegRepo.loader);
		
		if(dropdownSelectionValidation("TRIVANDRUM",grpLoanAppRegRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
			Log.info("Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Centre Created Earlier
		ExtentTestManager.startTest("Select Centre Created Earlier");
		Log.info("Select Centre Created Earlier");
		
		select("14 - GUARANTOR",grpLoanAppRegRepo.giCentreDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click the Centre dropdown.\r\n"
				+ "2. Select the previously created Centre from the list.\"");
		Log.info("\"1. Click the Centre dropdown.\r\n"
				+ "2. Select the previously created Centre from the list.\"");
		
		waitUntilElementDisappear(grpLoanAppRegRepo.loader);
		
		if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanAppRegRepo.giCentreDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "The centre is selected from the dropdown list.");
			Log.info("Expected Result: " + "The centre is selected from the dropdown list.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Click Go Button
		ExtentTestManager.startTest("Click Go Button");
		Log.info("Click Go Button");
				
		click(grpLoanAppRegRepo.giGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
		
		waitUntilElementDisappear(grpLoanAppRegRepo.loader);

		if(ElementDisplayed(grpLoanAppRegRepo.giSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Details are listed.");
			Log.info("Expected Result: " + "Details are listed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Select Group to Show Customer Details
		ExtentTestManager.startTest("Select Group to Show Customer Details");
		Log.info("Select Group to Show Customer Details");
				
		click(grpLoanAppRegRepo.giSelect);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
		
		waitUntilElementDisappear(grpLoanAppRegRepo.loader);

		if(ElementDisplayed(grpLoanAppRegRepo.giCustDetails)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer Details section is visible.");
			Log.info("Expected Result: " + "Customer Details section is visible.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void customerDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		//Select Product from Product Name Dropdown
		ExtentTestManager.startTest("Select Product from Product Name Dropdown");
		Log.info("Select Product from Product Name Dropdown");
		
        WebElement table = driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer\"]"));

        // Find all <tr> elements in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Output the number of <tr> tags
        System.out.println("Number of rows in the table: " + rows.size());
        int rowSize = rows.size();
		
		try {
			for(int i = 2;i<=rowSize-1;i++) {
				String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl0"+i+"_ddlProduct_ddl']";
				By XPath = By.xpath(xpath);
				
				select("PERSONAL LOAN WEEKLY",XPath);
				
				waitUntilElementDisappear(grpLoanAppRegRepo.loader);

			}
		}catch(Exception e) {
			System.out.println("No more dropdowns");
		}
		
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click the Product Name dropdown.\r\n"
				+ "2. Select a product from the list.\"");
		Log.info("\"1. Click the Product Name dropdown.\r\n"
				+ "2. Select a product from the list.\"");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Loan Amount is auto-loaded with default value.");
		Log.info("Expected Result: " + "Loan Amount is auto-loaded with default value.");
		
		ExtentTestManager.endTest();

		
		
		//Check Auto-load of Loan Amount
		ExtentTestManager.startTest("Check Auto-load of Loan Amount");
		Log.info("Check Auto-load of Loan Amount");
		
		String defaultLoan = driver.findElement(grpLoanAppRegRepo.cdLoanAmountTxtBox).getAttribute("value");
        System.out.println("defaultLoan: " + defaultLoan);
        
        double defaultLoanValue = Double.parseDouble(defaultLoan);
        System.out.println("defaultLoanValue: " + defaultLoanValue);
        
		if(defaultLoanValue == 9999999.00) {
			ExtentTestManager.getTest().log(Status.PASS, "1. Observe the Loan Amount field.");
			Log.info("1. Observe the Loan Amount field.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Loan Amount is auto-loaded with default value.");
			Log.info("Expected Result: " + "Loan Amount is auto-loaded with default value.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Manually Change Loan Amount to 25000
		ExtentTestManager.startTest("Manually Change Loan Amount to 25000");
		Log.info("Manually Change Loan Amount to 25000");
		
		clear(grpLoanAppRegRepo.cdLoanAmountTxtBox);
		click(grpLoanAppRegRepo.cdLoanAmountTxtBox);
		
		String loan = testdata.get("loan").toString();
		input(grpLoanAppRegRepo.cdLoanAmountTxtBox,loan);		
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on the Loan Amount field.\r\n"
				+ "2. Change the amount to 25000.\"");
		Log.info("\"1. Click on the Loan Amount field.\r\n"
				+ "2. Change the amount to 25000.\"");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Loan Amount is set to 25000.");
		Log.info("Expected Result: " + "Loan Amount is set to 25000.");
		
		ExtentTestManager.endTest();

		
		
		//Select Purpose from Dropdown
		ExtentTestManager.startTest("Select Purpose from Dropdown");
		Log.info("Select Purpose from Dropdown");
		
		select("BUSINESS",grpLoanAppRegRepo.cdPurposeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click the Purpose dropdown.\r\n"
				+ "2. Select a purpose from the list.\"");
		Log.info("\"1. Click the Purpose dropdown.\r\n"
				+ "2. Select a purpose from the list.\"");
				
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "A purpose is selected from the dropdown.");
		Log.info("Expected Result: " + "A purpose is selected from the dropdown.");

		
		ExtentTestManager.endTest();

		
		
		//Validate Popup on Selecting Purpose
		ExtentTestManager.startTest("Validate Popup on Selecting Purpose");
		Log.info("Validate Popup on Selecting Purpose");
		
		// Try to handle the alert
        boolean alertPresent = false;
        
        try {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();
            alertPresent = true;
            String alertTxt = alert.getText();
            String actualTxt = "Do you want to change purpose for all";
            
            if(alertPresent && alertTxt.equals(actualTxt)) {
    			
    			ExtentTestManager.getTest().log(Status.PASS, "1. Observe for any validation popup.");
    			Log.info("1. Observe for any validation popup.");
    			
    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Popup message \"Do you want to change purpose for all\" appears.");
    			Log.info("Expected Result: " + "Popup message \"Do you want to change purpose for all\" appears.");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
    		
    		
        } catch (NoAlertPresentException e) {
            alertPresent = false;  // No alert is present
            System.out.println("No alert is present.");
        }
        
        ExtentTestManager.endTest();

		
		
		//Confirm Purpose Change for All
		ExtentTestManager.startTest("Confirm Purpose Change for All");
		Log.info("Confirm Purpose Change for All");
		
		AcceptAlert();
		ExtentTestManager.getTest().log(Status.PASS, "1. Click the OK button on the popup.");
		Log.info("1. Click the OK button on the popup.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Purpose is updated for all applications of the selected group.");
		Log.info("Expected Result: " + "Purpose is updated for all applications of the selected group.");
        
        ExtentTestManager.endTest();

		
		
		//Verify the Ticking of  the  Guarantor Field
		ExtentTestManager.startTest("Verify the Ticking of  the  Guarantor Field");
		Log.info("Verify the Ticking of  the  Guarantor Field");
		
		ScrollUntilElementVisible(grpLoanAppRegRepo.cdIsGuarantorCheckBox);

		click(grpLoanAppRegRepo.cdIsGuarantorCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "1.Tick the Guarantor section.");
		Log.info("1.Tick the Guarantor section.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Guarantor should be ticked");
		Log.info("Expected Result: " + "Guarantor should be ticked");
        
        ExtentTestManager.endTest();

		
		
		//Click Save to Confirm Group Loan application
		ExtentTestManager.startTest("Click Save to Confirm Group Loan application");
		Log.info("Click Save to Confirm Group Loan application");
		
		ScrollUntilElementVisible(grpLoanAppRegRepo.cdSaveBtn);

		click(grpLoanAppRegRepo.cdSaveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Save button.");
		Log.info("1. Click on the Save button.");
		
		if(ElementDisplayed(grpLoanAppRegRepo.savedPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group loan application is successfully saved.");
		Log.info("Expected Result: " + "Group loan application is successfully saved.");
		
		click(grpLoanAppRegRepo.popUpCloseBtn);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
        ExtentTestManager.endTest();
        
        
        
	}//end
}
