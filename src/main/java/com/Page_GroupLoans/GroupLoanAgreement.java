package com.Page_GroupLoans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanAgreement;
import com.Page_Repositary.PageRepositary_GroupLoans_GroupLoanApplication;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GroupLoanAgreement extends Base_Class{
	By lastSelectXPath;
	int lastRow;
	PageRepositary_GroupLoans_GroupLoanAgreement grpLoanAgrRegRepo = new PageRepositary_GroupLoans_GroupLoanAgreement();

	public void groupLoanAgreement() throws InterruptedException {
		
		//Navigation of  group loan agreement page  
		ExtentTestManager.startTest("Navigation of  group loan agreement page ").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Navigation of  group loan agreement page ");
		
		click(grpLoanAgrRegRepo.groupLoansTab);
		
		click(grpLoanAgrRegRepo.groupLoanAgreementTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan Agreement page.");
		Log.info("1. Navigate to Group Loans section.\r\n"
				+ "2. Open Group Loan Agreement page.");
		
		if(ElementDisplayed(grpLoanAgrRegRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group loan Agreement page loaded ");
			Log.info("Expected Result: " + "Group loan Agreement page loaded ");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
public void groupInfo() throws InterruptedException {

		
		//Select Trivandrum from Branch Dropdown
		ExtentTestManager.startTest("Select Trivandrum from Branch Dropdown").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Select Trivandrum from Branch Dropdown");
		
		select("TRIVANDRUM",grpLoanAgrRegRepo.giBranchDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
		Log.info("\"1. Click on branch dropdown.\r\n"
				+ "2. Select 'Trivandrum'.\"");
				
		if(dropdownSelectionValidation("TRIVANDRUM",grpLoanAgrRegRepo.giBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
			Log.info("Expected Result: " + "Trivandrum' is selected in the Branch dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select a Centre from Dropdown
		ExtentTestManager.startTest("Select a Centre from Dropdown").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Select a Centre from Dropdown");
		
		select("14 - GUARANTOR",grpLoanAgrRegRepo.giCentreNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click the Centre dropdown.\r\n"
				+ "2. Select the previously created Centre from the list.\"");
		Log.info("\"1. Click the Centre dropdown.\r\n"
				+ "2. Select the previously created Centre from the list.\"");
		
		waitUntilElementDisappear(grpLoanAgrRegRepo.loader);
		
		if(dropdownSelectionValidation("14 - GUARANTOR",grpLoanAgrRegRepo.giCentreNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "The chosen Centre is selected in the Dropdown.");
			Log.info("Expected Result: " + "The chosen Centre is selected in the Dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();

		
		
		//Select Group from Group Name Dropdown
		ExtentTestManager.startTest("Select Group from Group Name Dropdown").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Select Group from Group Name Dropdown");
		
		select("25 - GUARANTOR 3",grpLoanAgrRegRepo.giGroupNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on Group Name Dropdown.\r\n"
				+ "2. Select a Group.\"");
		Log.info("\"1. Click on Group Name Dropdown.\r\n"
				+ "2. Select a Group.\"");
		
		waitUntilElementDisappear(grpLoanAgrRegRepo.loader);
		
		if(dropdownSelectionValidation("25 - GUARANTOR 3",grpLoanAgrRegRepo.giGroupNameDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "The selected Group appears in the Group Name Dropdown.");
			Log.info("Expected Result: " + "The selected Group appears in the Group Name Dropdown.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Click Go Button to View Application Details
		ExtentTestManager.startTest("Click Go Button to View Application Details").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Click Go Button to View Application Details");
				
		click(grpLoanAgrRegRepo.giGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Go button.");
		Log.info("1. Click on the Go button.");
		
		waitUntilElementDisappear(grpLoanAgrRegRepo.loader);

		if(ElementDisplayed(grpLoanAgrRegRepo.alApplicationListDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Application details list is displayed.");
			Log.info("Expected Result: " + "Application details list is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Click 'Select' to View Customer List
		ExtentTestManager.startTest("Click 'Select' to View Customer List").assignCategory("Microfinance concept-GroupLoanagreement");
		Log.info("Click 'Select' to View Customer List");
		
	       WebElement table = driver.findElement(By.xpath("//*[@id=\"tblLoanAgreement\"]"));
	       
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
			String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstLoanAgreement_ctrl"+ lastRow +"_lnkSelect']";
			lastSelectXPath = By.xpath(xpath);
	        }else {
				String xpath = "//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstLoanAgreement_ctrl"+ lastRow +"_lnkSelect']";
				lastSelectXPath = By.xpath(xpath);
	        }
	        }
	        else {
	        	
	        }
	        
		click(lastSelectXPath);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on 'Select' button next to an application number.");
		Log.info("1. Click on 'Select' button next to an application number.");
		
		waitUntilElementDisappear(grpLoanAgrRegRepo.loader);

		ScrollUntilElementVisible(grpLoanAgrRegRepo.alPrintAgreementBtn);
		
		if(ElementDisplayed(grpLoanAgrRegRepo.alCustListGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer list is visible.");
			Log.info("Expected Result: " + "Customer list is visible.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
//			THROWING CONFIGURATION ERROR
//        //Click Print Agreement to Generate PDF
//        ExtentTestManager.startTest("Click Print Agreement to Generate PDF").assignCategory("Microfinance concept-GroupLoanagreement");
//        Log.info("Click Print Agreement to Generate PDF");
//        
//        click(grpLoanAgrRegRepo.alPrintAgreementBtn);
//        ExtentTestManager.getTest().log(Status.PASS, "1. Click on 'Print Agreement' button.");
//        Log.info("1. Click on 'Print Agreement' button.");
//        
//        //Navigate to Pop Up Window
//     String mainWindowHandle = driver.getWindowHandle();
//     boolean popupAppeared = false;
//     for (String handle : driver.getWindowHandles()) {
//         if (!handle.equals(mainWindowHandle)) {
//             driver.switchTo().window(handle);
//             driver.manage().window().maximize();
//             popupAppeared = true;
//          
//             String currentUrl = driver.getCurrentUrl();
//             System.out.println("currentUrl: "+currentUrl);
//             
//             if (currentUrl.endsWith(".pdf")) {
//     			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "PDF page is generated with agreement details.");
//    			Log.info("Expected Result: " + "PDF page is generated with agreement details.");                   
//             }else {
//                     ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//                     Log.info("ERROR");
//              }
//               
//               ExtentTestManager.endTest();
//               
//               driver.close();
//               driver.switchTo().window(mainWindowHandle);
//               
//             break;  
//             
//         }
//    
//     }//for loop end

		
		
		
     //Click Save to Confirm Group Loan Agreement
     ExtentTestManager.startTest("Click Save to Confirm Group Loan Agreement").assignCategory("Microfinance concept-GroupLoanagreement");
     Log.info("Click Save to Confirm Group Loan Agreement");
     
		click(grpLoanAgrRegRepo.alSubmitBtn);
        ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Save button.");
        Log.info("1. Click on the Save button.");
        
		if(ElementDisplayed(grpLoanAgrRegRepo.popSuccessMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group loan agreement is successfully saved.");
			Log.info("Expected Result: " + "Group loan agreement is successfully saved.");
			
			click(grpLoanAgrRegRepo.popUpCloseBtn);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

	}//end



}
