  package com.Page_GroupLoans;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.extentReports.ExtentTestManager;
import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__GeneralLoan_SuspenseAsset;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Centre_Registration;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Centre_Registration extends Base_Class{

	PageRepositary_Centre_Registration grploansrepo = new PageRepositary_Centre_Registration();

	public void navigateToCentreReg(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	
		
	//Navigate to General Opening
	ExtentTestManager.startTest("Navigate to General Opening").assignCategory("Centre_Registration");
	Log.info("Navigate to General Opening");
	
	click(grploansrepo.grp_loans);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Navigate to Group Loan");
	Log.info("Step:01 - 1. Navigate to Group Loan");
	
	
	click(grploansrepo.ctr_registration);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - 2. Click on Centre Registration");
	Log.info("Step:02 - 2. Click on Centre Registration");
	
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	
	//Select Branch
	ExtentTestManager.startTest("Select Branch").assignCategory("Centre_Registration");
	Log.info("Select Branch");
	
	select("HEAD OFFICE", grploansrepo.branch_dropdown);
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Open Branch dropdown-> Select branch");
	Log.info("Step:01 - 1. Open Branch dropdown-> Select branch");
	   	
    ExtentTestManager.endTest();
	
	 //Select District 
    ExtentTestManager.startTest("Select district").assignCategory("Centre_Registration");
	Log.info("Select district"); 
	 
	select("Tumkur",grploansrepo.district); 
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1. 1. Open District dropdown -> select a district"); 
	Log.info("Step:01 - 1. Open District dropdown");
	 
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest(); 
	
	 //Street Name Field Enable & Enter Street name 
	ExtentTestManager.startTest("Street Name Field Enable").assignCategory("Centre_Registration"); 
	Log.info("Street Name Field Enable"); 
	 
	
	String StreetName = testdata.get("StreetName").toString();
	input(grploansrepo.strt_name,StreetName); 
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Check if Street Name field is enabled -> Enter street name in the 'Street name'field");
	Log.info("Step:01 - 1.Check if Street Name field is enabled -> Enter street name in the 'Street name'field"); 
	ExtentTestManager.endTest(); 
	
	waitTillLoaderDisappear(grploansrepo.loader);
	
	 //Taluk Field Enabled and Selectable
	ExtentTestManager.startTest("Taluk Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Taluk Field Enabled and Selectablee");
	 
    input(grploansrepo.taluk,"Mavelikkara"); 
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Open Taluk dropdown ->Select a Taluk");
	Log.info("Step:01 - 1.  Open Taluk dropdown");
	 
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	 
	 //Panchayath Field Enabled and Selectable
	ExtentTestManager.startTest("Panchayath Field Enabled and Selectable").assignCategory("Centre_Registration");
    Log.info("Panchayath Field Enabled and Selectable");
	 
	input(grploansrepo.pachayath,"AANAAD");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Panchayath dropdown ->Select a Panchayath");
	Log.info("Step:01 - 1.Open Panchayath dropdown->Select a Panchayath");
	  
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	
	 //Centre Name Field Enabled
	ExtentTestManager.startTest("Panchayath Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Panchayath Field Enabled and Selectable");
		 
	String CentrName = testdata.get("CentrName").toString();
	input(grploansrepo.cntr_name,CentrName);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Panchayath dropdown ->Select a Panchayath");
	Log.info("Step:01 - 1.Open Panchayath dropdown->Select a Panchayath");
		  
	waitTillLoaderDisappear(grploansrepo.loader);
		
	ExtentTestManager.endTest();
		
	//Meeting day
	ExtentTestManager.startTest("Meeting Day Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Meeting Day Field Enabled and Selectable");
			 
	input(grploansrepo.meeting_day,"THUESDAY");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Meeting Day dropdown ->Select a Meeting Day");
	Log.info("Step:01 - 1.Open Meeting Day dropdown ->Select a Meeting Day");
			  
	waitTillLoaderDisappear(grploansrepo.loader);
			
	ExtentTestManager.endTest();
	
	//Distance from Branch to Centre Field Enabled
	ExtentTestManager.startTest("Distance from Branch to Centre Field Enabled").assignCategory("Centre_Registration");
	Log.info("Distance from Branch to Centre Field Enabled");
			
	String DisfromBranch = testdata.get("DisfromBranch").toString();
	input(grploansrepo.distanceFrmdtoc,DisfromBranch);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1. Enter 'Distance from Branch to Centre");
	Log.info("Step:01 - 1.Enter 'Distance from Branch to Centre");
				  
	waitTillLoaderDisappear(grploansrepo.loader);
				
	ExtentTestManager.endTest();
     
	//Village Field Enabled and Selectable
	ExtentTestManager.startTest("Village Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Village Field Enabled and Selectable");
				 
	input(grploansrepo.villagefield,"ANJUR");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Village dropdown -> Select a Village");
	Log.info("Step:01 - 1.Open Village dropdown -> Select a Village");
					  
	waitTillLoaderDisappear(grploansrepo.loader);
					
	ExtentTestManager.endTest();
	
	//Block Field Enabled Enter block
	ExtentTestManager.startTest("Block Field Enabled Enter block").assignCategory("Centre_Registration");
	Log.info("Block Field Enabled Enter block");
			
	String BlockFld = testdata.get("BlockFld").toString();
	input(grploansrepo.blockfield,BlockFld);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Village dropdown -> Select a Village");
	Log.info("Step:01 - 1.Open Village dropdown -> Select a Village");
						  
	waitTillLoaderDisappear(grploansrepo.loader);
						
	ExtentTestManager.endTest();
	
	//LandMark Field Enabled Enter Landmark
	ExtentTestManager.startTest("LandMark Field Enabled Enter Landmark").assignCategory("Centre_Registration");
	Log.info("Block Field Enabled Enter block");
	
	String LandMark = testdata.get("LandMark").toString();
	input(grploansrepo.landmark,LandMark);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Check if LandMark field is enabled -> Enter LandMark field data ");
	Log.info("Step:01 - 1.Check if LandMark field is enabled -> Enter LandMark field data");
								  
	waitTillLoaderDisappear(grploansrepo.loader);
								
	ExtentTestManager.endTest();
	
		
	//Post Office Field Enabled and Selectable
	ExtentTestManager.startTest("Post Office Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Post Office Field Enabled and Selectable");
									 
	input(grploansrepo.pofield,"Roppa B.O");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Post Office dropdown-> Select a Post Office ");
	Log.info("Step:01 - 1.Open Post Office dropdown-> Select a Post Office");
										  
	waitTillLoaderDisappear(grploansrepo.loader);
										
	ExtentTestManager.endTest();
	
//	//PINCODE Field Auto-Populated
//	ExtentTestManager.startTest("PINCODE Field Auto-Populated").assignCategory("Centre_Registration concept-CentreGroup  registration");
//	Log.info("PINCODE Field Auto-Populated");
//										 
//	click(grploansrepo.pofield);
//	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Post Office dropdown-> Select a Post Office ");
//	Log.info("Step:01 - 1.Open Post Office dropdown-> Select a Post Office");
//											  
//	waitTillLoaderDisappear(grploansrepo.loader);
//											
//	ExtentTestManager.endTest();
	
	//Field Officer Field Enabled and Selectable
	ExtentTestManager.startTest("Field Officer Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Field Officer Field Enabled and Selectable");
										 
	input(grploansrepo.fofficer,"SANTHOSH");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Field Officer dropdown -> Select a Field Officer ");
	Log.info("Step:01 - 1.Open Field Officer dropdown -> Select a Field Officer ");
												  
	waitTillLoaderDisappear(grploansrepo.loader);
												
	ExtentTestManager.endTest();
		
	//Enter meeting time
	ExtentTestManager.startTest("Post Office Field Enabled and Selectable").assignCategory("Centre_Registration");
	Log.info("Post Office Field Enabled and Selectable");
	
	String Meeting_Time= testdata.get("Meeting_Time").toString();
	input(grploansrepo.Meeting_time,Meeting_Time);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Enter 10 in Hours text field ");
	Log.info("Step:01 - 1.Enter 10 in Hours text field ");
		
	String Meeting_Min= testdata.get("Meeting_Min").toString();
	input(grploansrepo.Meeting_minutes,Meeting_Min);
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 - 1.Enter 30 in Minutes text field");
	Log.info("Step:01 - 1.Enter 30 in Minutes text field ");
	
	input(grploansrepo.meetingAM,"AM");
	ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
	Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	
	//Save Centre Registration
	ExtentTestManager.startTest("Save Centre Registration").assignCategory("Centre_Registration");
	Log.info("Save Centre Registration");
											 
	click(grploansrepo.save);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
	Log.info("Step:01 - 1.Centre is created successfully");
	
	ExtentTestManager.endTest();
	
	//logout
	ExtentTestManager.startTest("Save Centre Registration").assignCategory("Centre_Registration");
	Log.info("Save Centre Registration");
											 
	click(grploansrepo.updated);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
	Log.info("Step:01 - 1.Centre is created successfully");
	
//	click(grploansrepo.signout);
//	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
//	Log.info("Step:01 - 1.Centre is created successfully");
	
	ExtentTestManager.endTest();
	
	}

//	public void navigateToCentreReg(Map<Object, Object> testdata, ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
}	


