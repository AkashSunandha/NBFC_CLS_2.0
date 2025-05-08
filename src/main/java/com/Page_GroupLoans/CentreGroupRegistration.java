package com.Page_GroupLoans;

import java.util.Map;
import java.util.Set;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_GroupLoans_CentreGroupRegistration;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class CentreGroupRegistration extends Base_Class{

	PageRepositary_GroupLoans_CentreGroupRegistration grpRegRepo = new PageRepositary_GroupLoans_CentreGroupRegistration();
	

	public void navigateToCentreGroupRegistration() throws InterruptedException {
		
		//Navigate to Centre Group Registration page
		ExtentTestManager.startTest("Navigate to Centre Group Registration page");
		Log.info("Navigate to Centre Group Registration page");
		
		click(grpRegRepo.groupLoansTab);
		
		click(grpRegRepo.centreGroupRegistrationTab);
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to Group Loans > Centre Group Registration page.");
		Log.info("1. Navigate to Group Loans > Centre Group Registration page.");
		
		if(ElementDisplayed(grpRegRepo.grBranchDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Centre Group Registration page loaded.");
			Log.info("Expected Result: Centre Group Registration page loaded.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void groupRegistration(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {

	
	//Select Branch from Drop down
	ExtentTestManager.startTest("Select Branch from Drop down");
	Log.info("Select Branch from Drop down");
	
	select("TRIVANDRUM",grpRegRepo.grBranchDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
			+ "2. Select 'Trivandrum'.\"");
	Log.info("\"1. Click on branch dropdown.\r\n"
			+ "2. Select 'Trivandrum'.\"");
	
	waitUntilElementDisappear(grpRegRepo.loader);
	
	if(dropdownSelectionValidation("TRIVANDRUM",grpRegRepo.grBranchDropdown)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Trivandrum' should be selected without error.");
		Log.info("Expected Result: Trivandrum' should be selected without error.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	

	//Select Centre from Dropdown
	ExtentTestManager.startTest("Select Centre from Dropdown");
	Log.info("Select Centre from Dropdown");
	
	select("centre3",grpRegRepo.grCentreDropdown);
	ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on Centre dropdown.\r\n"
			+ "2. Select a Centre.\"");
	Log.info("\"1. Click on Centre dropdown.\r\n"
			+ "2. Select a Centre.\"");
	
	waitUntilElementDisappear(grpRegRepo.loader);
	
	if(dropdownSelectionValidation("centre3",grpRegRepo.grCentreDropdown)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Selected Centre should be displayed without error.");
		Log.info("Expected Result: " + "Selected Centre should be displayed without error.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	

	//Auto-load Fields upon Centre Selection
	ExtentTestManager.startTest("Auto-load Fields upon Centre Selection");
	Log.info("Auto-load Fields upon Centre Selection");
	
	String grGroupNameTxtBox = driver.findElement(grpRegRepo.grGroupNameTxtBox).getAttribute("value");
	System.out.println("grGroupNameTxtBox: " + grGroupNameTxtBox);
	
	String grDistrictTxtBox = driver.findElement(grpRegRepo.grDistrictTxtBox).getAttribute("value");
	System.out.println("grDistrictTxtBox: " + grDistrictTxtBox);
	
	String grStreetNameTxtBox = driver.findElement(grpRegRepo.grStreetNameTxtBox).getAttribute("value");
	System.out.println("grStreetNameTxtBox: " + grStreetNameTxtBox);
	
	String grTalukTxtBox = driver.findElement(grpRegRepo.grTalukTxtBox).getAttribute("value");
	System.out.println("grTalukTxtBox: " + grTalukTxtBox);
	
	String grPanchayathTxtBox = driver.findElement(grpRegRepo.grPanchayathTxtBox).getAttribute("value");
	System.out.println("grPanchayathTxtBox: " + grPanchayathTxtBox);
	
	String grCentreNameTxtBox = driver.findElement(grpRegRepo.grCentreNameTxtBox).getAttribute("value");
	System.out.println("grCentreNameTxtBox: " + grCentreNameTxtBox);
	
	String grMeetingDayTxtBox = driver.findElement(grpRegRepo.grMeetingDayTxtBox).getAttribute("value");
	System.out.println("grMeetingDayTxtBox: " + grMeetingDayTxtBox);
	
	String grDistanceFromBranchTxtBox = driver.findElement(grpRegRepo.grDistanceFromBranchTxtBox).getAttribute("value");
	System.out.println("grDistanceFromBranchTxtBox: " + grDistanceFromBranchTxtBox);
	
	String grVillageTxtBox = driver.findElement(grpRegRepo.grVillageTxtBox).getAttribute("value");
	System.out.println("grVillageTxtBox: " + grVillageTxtBox);
	
	String grBlockTxtBox = driver.findElement(grpRegRepo.grBlockTxtBox).getAttribute("value");
	System.out.println("grBlockTxtBox: " + grBlockTxtBox);
	
	String grLandmarkTxtBox = driver.findElement(grpRegRepo.grLandmarkTxtBox).getAttribute("value");
	System.out.println("grLandmarkTxtBox: " + grLandmarkTxtBox);
	
	String grPostOfficeTxtBox = driver.findElement(grpRegRepo.grPostOfficeTxtBox).getAttribute("value");
	System.out.println("grPostOfficeTxtBox: " + grPostOfficeTxtBox);
	
	String grPincodeTxtBox = driver.findElement(grpRegRepo.grPincodeTxtBox).getAttribute("value");
	System.out.println("grPincodeTxtBox: " + grPincodeTxtBox);
	
	String grFieldOfficerTxtBox = driver.findElement(grpRegRepo.grFieldOfficerTxtBox).getAttribute("value");
	System.out.println("grFieldOfficerTxtBox: " + grFieldOfficerTxtBox);
	
	String grMeetingTimeTxtBox = driver.findElement(grpRegRepo.grMeetingTimeTxtBox).getAttribute("value");
	System.out.println("grMeetingTimeTxtBox: " + grMeetingTimeTxtBox);
	
	if(grGroupNameTxtBox.isBlank() 
			&& !grDistrictTxtBox.isBlank() 
			&& !grStreetNameTxtBox.isBlank() 
			&& !grTalukTxtBox.isBlank() 
			&& !grPanchayathTxtBox.isBlank() 
			&& !grCentreNameTxtBox.isBlank() 
			&& !grMeetingDayTxtBox.isBlank() 
			&& !grDistanceFromBranchTxtBox.isBlank() 
			&& !grVillageTxtBox.isBlank() 
			&& !grBlockTxtBox.isBlank() 
			&& !grLandmarkTxtBox.isBlank() 
			&& !grPostOfficeTxtBox.isBlank() 
			&& !grPincodeTxtBox.isBlank() 
			&& !grFieldOfficerTxtBox.isBlank() 
			&& !grMeetingTimeTxtBox.isBlank()) {
		
		ExtentTestManager.getTest().log(Status.PASS, "1. Check other fields after selecting a Centre.");
		Log.info("1. Check other fields after selecting a Centre.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "All fields except Group Name should be autoloaded.");
		Log.info("Expected Result: " + "All fields except Group Name should be autoloaded.");
		
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	

	//Enter Group Name
	ExtentTestManager.startTest("Enter Group Name");
	Log.info("Enter Group Name");
	
	String groupName = testdata.get("groupName").toString();
	input(grpRegRepo.grGroupNameTxtBox,groupName);		
	ExtentTestManager.getTest().log(Status.PASS, "1. Enter 'Group' in the Group Name field.");
	Log.info("1. Enter 'Group' in the Group Name field.");
	
	if(inputValidation(grpRegRepo.grGroupNameTxtBox,groupName)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group' should be entered without error.");
		Log.info("Expected Result: " + "Group' should be entered without error.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	
	ExtentTestManager.endTest();
	
	}//end
	
	
	public void groupMembers(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		

		//Customer Search Popup Display
		ExtentTestManager.startTest("Customer Search Popup Display");
		Log.info("Customer Search Popup Display");
		
		click(grpRegRepo.gmCustIdSrchIcon);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Customer Search icon.");
		Log.info("1. Click on the Customer Search icon.");
		
		String parentWnd = driver.getWindowHandle();
		
		Set<String> wndAddress = driver.getWindowHandles();
		
		for(String e : wndAddress) {
			if(!e.equals(parentWnd)) {
				driver.switchTo().window(e);
			}
		}
		
		
		if(ElementDisplayed(grpRegRepo.popUpWndNameTxtBox)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer Search popup should be displayed.");
			Log.info("Expected Result: " + "Customer Search popup should be displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Search with Random Letter
		ExtentTestManager.startTest("Search with Random Letter");
		Log.info("Search with Random Letter");
		
		String custName = testdata.get("custName").toString();
		input(grpRegRepo.popUpWndNameTxtBox,custName);		
		ExtentTestManager.getTest().log(Status.PASS, "1. Enter a random letter in the Name field.");
		Log.info("1. Enter a random letter in the Name field.");
		
		click(grpRegRepo.popUpWndSrchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "2. Click Search button.");
		Log.info("2. Click Search button.");
		
		
		if(ElementDisplayed(grpRegRepo.popUpWndSelect)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer list similar to the entered letter should be displayed.");
			Log.info("Expected Result: " + "Customer list similar to the entered letter should be displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Select Customer from List
		ExtentTestManager.startTest("Select Customer from List");
		Log.info("Select Customer from List");

		click(grpRegRepo.popUpWndSelect);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on Select button for a customer.");
		Log.info("1. Click on Select button for a customer.");
		
		driver.switchTo().window(parentWnd);
		
		String custIdValue = driver.findElement(grpRegRepo.gmCustIdTxtBox).getAttribute("value");
		System.out.println("custIdValue: " + custIdValue);
		
		if(!custIdValue.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer ID should be displayed in Customer ID field.");
			Log.info("Expected Result: " + "Customer ID should be displayed in Customer ID field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Select Unique Role from Dropdown
		ExtentTestManager.startTest("Select Unique Role from Dropdown");
		Log.info("Select Unique Role from Dropdown");
		
		select("Ordinary Member 10",grpRegRepo.gmRolesDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on Roles dropdown.\r\n"
				+ "2. Select a unique role.");
		Log.info("\"1. Click on Roles dropdown.\r\n"
				+ "2. Select a unique role.");
		
		if(dropdownSelectionValidation("Ordinary Member 10",grpRegRepo.gmRolesDropdown)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Role should be selected without error.");
			Log.info("Expected Result: " + "Role should be selected without error.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		

		//Add Customer Details
		ExtentTestManager.startTest("Add Customer Details");
		Log.info("Add Customer Details");
		
		click(grpRegRepo.gmAddBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on Add button.");
		Log.info("1. Click on Add button.");
		
		waitUntilElementDisappear(grpRegRepo.loader);
		
		if(ElementDisplayed(grpRegRepo.gmCustGrid1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Customer details should be autoloaded.");
			Log.info("Expected Result: " + "Customer details should be autoloaded.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		addAnotherCustomer(testdata, context);
		
		
		
		//Save Group Details
		ExtentTestManager.startTest("Save Group Details");
		Log.info("Save Group Details");
		
		click(grpRegRepo.gmSaveBtn);
		ExtentTestManager.getTest().log(Status.PASS, "1. Click on the Save button.");
		Log.info("1. Click on the Save button.");
		
		waitUntilElementDisappear(grpRegRepo.loader);
		
		if(ElementDisplayed(grpRegRepo.popUpSuccessMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Group should be created successfully.");
			Log.info("Expected Result: " + "Group should be created successfully.");
			
			click(grpRegRepo.popUpClose);
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
	}//end
	
	
	public void addAnotherCustomer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		//Add another customer with different role 
		ExtentTestManager.startTest("Add another customer with different role ");
		Log.info("Add another customer with different role ");
				
				click(grpRegRepo.gmCustIdSrchIcon);
				
				String parentWnd = driver.getWindowHandle();
				
				Set<String> wndAddress = driver.getWindowHandles();
				
				for(String e : wndAddress) {
					if(!e.equals(parentWnd)) {
						driver.switchTo().window(e);
					}
				}

				String custName2 = testdata.get("custName2").toString();
				input(grpRegRepo.popUpWndNameTxtBox,custName2);		
				
				click(grpRegRepo.popUpWndSrchBtn);				

				click(grpRegRepo.popUpWndSelect);
				
				driver.switchTo().window(parentWnd);

				select("Ordinary Member 1",grpRegRepo.gmRolesDropdown);
				ExtentTestManager.getTest().log(Status.PASS, "1.Add another customer with Role as Ordinary member 1 in the group loan section ");
				Log.info("1.Add another customer with Role as Ordinary member 1 in the group loan section ");
				
				click(grpRegRepo.gmAddBtn);
				
				waitUntilElementDisappear(grpRegRepo.loader);
				
				String roleValue = driver.findElement(grpRegRepo.gmCustGrid2).getText();
				System.out.println("roleValue: " + roleValue);
				
				if(ElementDisplayed(grpRegRepo.gmCustGrid2) && roleValue.equals("Ordinary Member 1")) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: " + "Another customer should be added ");
					Log.info("Expected Result: " + "Another customer should be added ");
				}else {
					ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
					Log.info("ERROR");
				}
				
				ExtentTestManager.endTest();
	}//end
}
