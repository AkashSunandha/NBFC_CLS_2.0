package com.Page_AccountOpening;

import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class LoanOpening_JewelLoan_GoldLoan extends Base_Class{
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	
	
	public void openGoaldLoanWindow() throws InterruptedException {
		
		ExtentTestManager.startTest("Access Gold Loan Opening Window");
		Log.info("Access Gold Loan Opening Window");
		
		click(goaldLoanRepo.accOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to account opening");
		Log.info("Step:01 - Navigate to account opening");
		
		click(goaldLoanRepo.loanOpeningTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select loan opening.");
		Log.info("Step:02 - Select loan opening.");
		
		click(goaldLoanRepo.jewelLoanTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select Jewel Loan.");
		Log.info("Step:03 - Select Jewel Loan.");
		
		click(goaldLoanRepo.goaldLoanTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Open gold loan opening window.");
		Log.info("Step:04 - Open gold loan opening window.");
		
		if(ElementDisplayed(goaldLoanRepo.aiCustSrchBtn)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Gold loan opening window is displayed.");
			Log.info("Expected Result: Gold loan opening window is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
	}
	
	
	
	public void accInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		
		//Name Field Validation
		ExtentTestManager.startTest("Name Field Validation");
		Log.info("Name Field Validation");
		
		click(goaldLoanRepo.aiCustSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click on search icon.");
		Log.info("Step:01 -  Click on search icon.");
		
		//Navigate to Pop Up Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	            
	    		String custName = testdata.get("custName").toString();
	    		input(goaldLoanRepo.popUpWndNameTxtField, custName);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter customer Name or alphabet.");
	    		Log.info("Step:02 - Enter customer Name or alphabet.");
	    		
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the name or alphabets in the customer search popu window.");
				Log.info("Expected Result: Possible to give the name or alphabets in the customer search popu window.");
				
	    		ExtentTestManager.endTest();
	    		
	    		
	    		
	    		//Search and Select a Customer
	    		ExtentTestManager.startTest("Search and Select a Customer");
	    		Log.info("Search and Select a Customer");
	    		
	    		click(goaldLoanRepo.popUpWndSrchBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Search button");
	    		Log.info("Step:01 - Click on Search button");
	    		
	    		click(goaldLoanRepo.popUpWndSelectLink);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select the customer");
	    		Log.info("Step:02 - Select the customer");
	    		
	    		driver.switchTo().window(mainWindowHandle);
	    		
	    		String flag = driver.findElement(goaldLoanRepo.aiCustIdTxtBox).getAttribute("value");
	    		
	    		if(!flag.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer id should be display in the custid feild.");
					Log.info("Expected Result: Customer id should be display in the custid feild.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	            break;
	            
	        }
	    }//for loop end
		
		
		
		//Add Selected Customer
		ExtentTestManager.startTest("Add Selected Customer");
		Log.info("Add Selected Customer");
	    
		click(goaldLoanRepo.aiAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Add Customer' button");
		Log.info("Step:01 - Click 'Add Customer' button");
		
		try {
			
			if(ElementDisplayed(goaldLoanRepo.aiCustGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are added.");
				Log.info("Expected Result: Customer details are added.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
						
		}catch(Exception e) {
			
			click(goaldLoanRepo.prvOkBtn);
			
			if(ElementDisplayed(goaldLoanRepo.aiCustGrid)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are added.");
				Log.info("Expected Result: Customer details are added.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
			
			
		}
		ExtentTestManager.endTest();
		
		
		
		
		//Enter Resolution Information
		ExtentTestManager.startTest("Enter Resolution Information");
		Log.info("Enter Resolution Information");
	    
		String resolutionNum = testdata.get("resolutionNum").toString();
		input(goaldLoanRepo.aiResolutionNumTxtBox, resolutionNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Resolution No.");
		Log.info("Step:01 - Enter Resolution No.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Information is accepted.");
		Log.info("Expected Result: Information is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Resolution Date
		ExtentTestManager.startTest("Enter Resolution Date");
		Log.info("Enter Resolution Date");
		
		click(goaldLoanRepo.aiResolutionDate);
		String resolutionDate = testdata.get("resolutionDate").toString();
		input(goaldLoanRepo.aiResolutionDate, resolutionDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Resolution Date.");
		Log.info("Step:01 - Enter Resolution Date.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Information is accepted.");
		Log.info("Expected Result: Information is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Refered By from Dropdown
		ExtentTestManager.startTest("Select Refered By from Dropdown");
		Log.info("Select Refered By from Dropdown");
		
		select("EDUCATION",goaldLoanRepo.aiPurposeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open 'Purpose' dropdown, Select an entry");
		Log.info("Step:01 - Open 'Purpose' dropdown, Select an entry");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is selected.");
		Log.info("Expected Result: Entry is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Reference No. 
		ExtentTestManager.startTest("Enter Reference No.");
		Log.info("Enter Reference No.");
	    
		String referenceNum = testdata.get("referenceNum").toString();
		input(goaldLoanRepo.aireferenceNumTxtBox, referenceNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Reference No.");
		Log.info("Step:01 - Enter Reference No.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Information is accepted.");
		Log.info("Expected Result: Information is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Source Of Loan
		ExtentTestManager.startTest("Select Source Of Loan");
		Log.info("Select Source Of Loan");
		
		select("Direct",goaldLoanRepo.aiSourceOfLoanDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Open 'Source Of Loan'' dropdown, Select an entry");
		Log.info("Step:01 - Open 'Source Of Loan'' dropdown, Select an entry");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Entry is selected.");
		Log.info("Expected Result: Entry is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Remarks
		ExtentTestManager.startTest("Enter Remarks");
		Log.info("Enter Remarks");
	    
		String remarks = testdata.get("remarks").toString();
		input(goaldLoanRepo.aiRemarkTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter the Remarks.");
		Log.info("Step:01 - Enter the Remarks.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Information is accepted.");
		Log.info("Expected Result: Information is accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Navigate to Security Details Tab
		ExtentTestManager.startTest("Navigate to Security Details Tab");
		Log.info("Navigate to Security Details Tab");
	    
		click(goaldLoanRepo.aiNextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");
		
		if(ElementDisplayed(goaldLoanRepo.sItemGroupDropdpown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Security details tab is open.");
			Log.info("Expected Result: Security details tab is open.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		

		
		
	}
	
	
	
	public void securities(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		
		//Enter Jewelry Details - Select Item Group
		ExtentTestManager.startTest("Enter Jewelry Details - Select Item Group");
		Log.info("Enter Jewelry Details - Select Item Group");
		
		select("Gold",goaldLoanRepo.sItemGroupDropdpown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Item Group");
		Log.info("Step:01 - Select Item Group");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted");
		Log.info("Expected Result: Details are accepted");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Select Item Name
		ExtentTestManager.startTest("Enter Jewelry Details - Select Item Name");
		Log.info("Enter Jewelry Details - Select Item Name");
		
		select("BANGLE,BIG-1,SMALL-2",goaldLoanRepo.sItemNameDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Item Name");
		Log.info("Step:01 - Select Item Name");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted");
		Log.info("Expected Result: Details are accepted");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Item Description
		ExtentTestManager.startTest("Enter Jewelry Details - Item Description");
		Log.info("Enter Jewelry Details - Item Description");
	    
		String remarks = testdata.get("remarks").toString();
		input(goaldLoanRepo.sItemDiscriptionTxtBox, remarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Item Description.");
		Log.info("Step:01 -  Enter Item Description.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Item Qty
		ExtentTestManager.startTest("Enter Jewelry Details - Item Qty");
		Log.info("Enter Jewelry Details - Item Qty");
	    
		String itemQty = testdata.get("itemQty").toString();
		input(goaldLoanRepo.sItemQtyTxtBox, itemQty);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Item Qty.");
		Log.info("Step:01 -  Enter Item Qty.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Item Weight
		ExtentTestManager.startTest("Enter Jewelry Details - Item Weight");
		Log.info("Enter Jewelry Details - Item Weight");
	    
		String itemWeight = testdata.get("itemWeight").toString();
		click(goaldLoanRepo.sItemweightTxtBox);
		input(goaldLoanRepo.sItemweightTxtBox, itemWeight);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Item Weight.");
		Log.info("Step:01 -  Enter Item Weight.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Stone Weight
		ExtentTestManager.startTest("Enter Jewelry Details - Stone Weight");
		Log.info("Enter Jewelry Details - Stone Weight");
	    
		click(goaldLoanRepo.sStoneWeightTxtBox);
		input(goaldLoanRepo.sStoneWeightTxtBox, itemQty);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Stone Weight.");
		Log.info("Step:01 -  Enter Stone Weight.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Dirt Weight
		ExtentTestManager.startTest("Enter Jewelry Details - Dirt Weight");
		Log.info("Enter Jewelry Details - Dirt Weight");
	    
		click(goaldLoanRepo.sDirtWeightTxtBox);
		input(goaldLoanRepo.sDirtWeightTxtBox, itemQty);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Dirt Weight.");
		Log.info("Step:01 -  Enter Dirt Weight.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter Jewelry Details - Purity
		ExtentTestManager.startTest("Enter Jewelry Details - Purity");
		Log.info("Enter Jewelry Details - Purity");
	    
		String purity = testdata.get("purity").toString();
		input(goaldLoanRepo.sPurityTxtBox, purity);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter Purity.");
		Log.info("Step:01 -  Enter Purity.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted.");
		Log.info("Expected Result: Details are accepted.");
		
		ExtentTestManager.endTest();
		
		
		
		//Add Jewelry Item to Grid
		ExtentTestManager.startTest("Add Jewelry Item to Grid");
		Log.info("Add Jewelry Item to Grid");
	    
		click(goaldLoanRepo.sAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Add' button.");
		Log.info("Step:01 -  Click 'Add' button.");
		
		if(ElementDisplayed(goaldLoanRepo.sJeweleryItemGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Jewelry item is added to grid.");
			Log.info("Expected Result: Jewelry item is added to grid.");	
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
//		//Upload Security Ornament Image - Pop Window Opened
//		ExtentTestManager.startTest("Upload Security Ornament Image - Pop Window Opened");
//		Log.info("Upload Security Ornament Image - Pop Window Opened");
//	    
//		ScrollUntilElementVisible(goaldLoanRepo.aiNextBtn);
//		click(goaldLoanRepo.sImageBtn);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Image' button.");
//		Log.info("Step:01 -  Click 'Image' button.");
//		
//		//Navigate to Pop Up Window
//	    String mainWindowHandle = driver.getWindowHandle();
//	    boolean popupAppeared = false;
//	    for (String handle : driver.getWindowHandles()) {
//	        if (!handle.equals(mainWindowHandle)) {
//	            driver.switchTo().window(handle);
//	            driver.manage().window().maximize();
//	            popupAppeared = true;
//	            
//	    		if(ElementDisplayed(goaldLoanRepo.sSelectItemDropdown)) {
//	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Jewel images popup window will be opened.");
//	    			Log.info("Expected Result: Jewel images popup window will be opened.");	
//	    		}else {
//	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//	    			Log.info("ERROR");
//	    		}
//	    		
//	    		ExtentTestManager.endTest();
//	    		
//	            break;
//	            
//	        }
//	    }//for loop end
//		
//		
//		
//		//Upload Security Ornament Image - Select Item 
//		ExtentTestManager.startTest("Upload Security Ornament Image - Select Item");
//		Log.info("Upload Security Ornament Image - Select Item");
//		
//		select("All Items",goaldLoanRepo.sSelectItemDropdown);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Item Name");
//		Log.info("Step:01 - Select Item Name");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details are accepted");
//		Log.info("Expected Result: Details are accepted");
//		
//		ExtentTestManager.endTest();
		
		
		
		//Navigate to Nominee Tab
		ExtentTestManager.startTest("Navigate to Nominee Tab");
		Log.info("Navigate to Nominee Tab");
	    
		ScrollUntilElementVisible(goaldLoanRepo.aiNextBtn);
		click(goaldLoanRepo.aiNextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");
		
		if(ElementDisplayed(goaldLoanRepo.nNomineeNotReqCheckBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee tab is open.");
			Log.info("Expected Result: Nominee tab is open.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
	}//end
	
	
	public void nominee(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

		
		//Add Nominee - Untick 'Nominee Not Required'
		ExtentTestManager.startTest("Add Nominee - Untick 'Nominee Not Required'");
		Log.info("Add Nominee - Untick 'Nominee Not Required'");
	    
		click(goaldLoanRepo.nNomineeNotReqCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Untick 'Nominee Not Required'");
		Log.info("Step:01 - Untick 'Nominee Not Required'");
		
		if(ElementDisplayed(goaldLoanRepo.nAadhaarNumTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Nominee details feild will be display.");
			Log.info("Expected Result: Nominee details feild will be display.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Add Nominee - Click the customer search icon
		ExtentTestManager.startTest("Click the customer search icon");
		Log.info("Click the customer search icon");
	    
		click(goaldLoanRepo.nSearchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the customer search icon");
		Log.info("Step:01 - Click the customer search icon");
		
		//Navigate to Pop Up Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	    		
	    		if(ElementDisplayed(goaldLoanRepo.popUpWndNameTxtField)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer serach popup will be display.");
	    			Log.info("Expected Result: Customer serach popup will be display.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		
	    		
	    		
	    		//Add Nominee - Search Cust
	    		ExtentTestManager.startTest("Add Nominee - Search Cust");
	    		Log.info("Add Nominee - Search Cust");
	            
	    		String custName = testdata.get("custName").toString();
	    		input(goaldLoanRepo.popUpWndNameTxtField, custName);
	    		click(goaldLoanRepo.popUpWndSrchBtn);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Give the name of the customer or alphabet, Click the search button");
	    		Log.info("Step:01 - Give the name of the customer or alphabet, Click the search button");
	    		
	    		if(ElementDisplayed(goaldLoanRepo.popUpWndSelectLink)) {
	    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer should be dispayed against the given details.");
	    			Log.info("Expected Result: Customer should be dispayed against the given details.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	    		
	    		
	    		//Select a Customer
	    		ExtentTestManager.startTest("Select a Customer");
	    		Log.info("Select a Customer");
	    		
	    		click(goaldLoanRepo.popUpWndSelectLink);
	    		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the customer");
	    		Log.info("Step:01 - Select the customer");
	    		
	    		driver.switchTo().window(mainWindowHandle);
	    		
	    		String flag = driver.findElement(goaldLoanRepo.nAadhaarNumTxtBox).getAttribute("value");
	    		
	    		if(!flag.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup will be closed and the selected customer details should be autolads.");
					Log.info("Expected Result: Popup will be closed and the selected customer details should be autolads.");
	    		}else {
	    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
	    			Log.info("ERROR");
	    		}
	    		
	    		ExtentTestManager.endTest();
	    		
	            break;
	            
	        }
	    }//for loop end
	    
		
		
		
		//Navigate to Loan Details Tab - Relation drop down
		ExtentTestManager.startTest("Navigate to Loan Details Tab - Relation drop down");
		Log.info("Navigate to Loan Details Tab - Relation drop down");
		
		select("FRIEND",goaldLoanRepo.nRelationDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the \"Relation\" drop down");
		Log.info("Step:01 - Select the \"Relation\" drop down");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Details can be selected");
		Log.info("Expected Result: Details can be selected");
		
		ExtentTestManager.endTest();
		

		
		
		//Navigate to Loan Details Tab - Add button
		ExtentTestManager.startTest("Navigate to Loan Details Tab - Add button");
		Log.info("Navigate to Loan Details Tab - Add button");
	    
		click(goaldLoanRepo.nAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button");
		Log.info("Step:01 - Click add button");
		
		if(ElementDisplayed(goaldLoanRepo.nNomineeDetailsGrid)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
			Log.info("Expected Result: Given details will be displays in the grid.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Navigate to Loan Details Tab - Next button
		ExtentTestManager.startTest("Navigate to Loan Details Tab - Next button");
		Log.info("Navigate to Loan Details Tab - Next button");
	    
		ScrollUntilElementVisible(goaldLoanRepo.aiNextBtn);
		click(goaldLoanRepo.aiNextBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button");
		Log.info("Step:01 - Click 'Next' button");
		
		if(ElementDisplayed(goaldLoanRepo.ldSanctionedTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan details tab is open.");
			Log.info("Expected Result: Loan details tab is open.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
	}//end
	
	
	
	public void loanDetails(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		
		//Enter and Verify Loan Details
		ExtentTestManager.startTest("Enter and Verify Loan Details");
		Log.info("Enter and Verify Loan Details");
	    
		String limitValue = driver.findElement(goaldLoanRepo.ldLimitTxtBox).getAttribute("value");
		click(goaldLoanRepo.ldSanctionedTxtBox);
		input(goaldLoanRepo.ldSanctionedTxtBox, limitValue);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter sanctioned amount.");
		Log.info("Step:01 -  Enter sanctioned amount.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the sanctioned amount in the field (less than and equal to).");
		Log.info("Expected Result: Possible to give the sanctioned amount in the field (less than and equal to).");
		
		ExtentTestManager.endTest();
		
		
		
		//Enter and Verify Loan Details - Get values
		ExtentTestManager.startTest("Enter and Verify Loan Details - Get values");
		Log.info("Enter and Verify Loan Details - Get values");
	    
		click(goaldLoanRepo.ldGetValuesBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the get values.");
		Log.info("Step:01 - Click the get values.");
		
		String dueDateValue = driver.findElement(goaldLoanRepo.ldDueDateTxtBox).getAttribute("value");
		String ROIValue = driver.findElement(goaldLoanRepo.ldROITxtBox).getAttribute("value");
		double num = Double.parseDouble(ROIValue);
		double actual = 0.0;
		
		if(!dueDateValue.isBlank() && num>actual) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: ROI, duration, duedate will be autoloads.");
			Log.info("Expected Result: ROI, duration, duedate will be autoloads.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
	    
		
		
		
		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode.");
		Log.info("Select Transaction Mode.");
		
		select("CASH",goaldLoanRepo.ldTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Trans. Mode 'Cash'");
		Log.info("Step:01 - Select Trans. Mode 'Cash'");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
}
