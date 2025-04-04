package com.Page_Group_Loans;

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

	public void navigateToCentreReg() throws InterruptedException {
		
	//Navigate to General Opening
	ExtentTestManager.startTest("Navigate to General Opening");
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
	ExtentTestManager.startTest("Select Branch");
	Log.info("Select Branch");
	
	select("HEAD OFFICE", grploansrepo.branch_dropdown);
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Open Branch dropdown-> Select branch");
	Log.info("Step:01 - 1. Open Branch dropdown-> Select branch");
	   	
    ExtentTestManager.endTest();
	
	 //Select District 
    ExtentTestManager.startTest("Select district");
	Log.info("Select district"); 
	 
	select("Tumkur",grploansrepo.district); 
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1. 1. Open District dropdown -> select a district"); 
	Log.info("Step:01 - 1. Open District dropdown");
	 
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest(); 
	
	 //Street Name Field Enable & Enter Street name 
	ExtentTestManager.startTest("Street Name Field Enable"); 
	Log.info("Street Name Field Enable"); 
	 
	input(grploansrepo.strt_name,"Rockstar"); 
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Check if Street Name field is enabled -> Enter street name in the 'Street name'field");
	Log.info("Step:01 - 1.Check if Street Name field is enabled -> Enter street name in the 'Street name'field"); 
	ExtentTestManager.endTest(); 
	
	waitTillLoaderDisappear(grploansrepo.loader);
	
	 //Taluk Field Enabled and Selectable
	ExtentTestManager.startTest("Taluk Field Enabled and Selectable");
	Log.info("Taluk Field Enabled and Selectablee");
	 
    input(grploansrepo.taluk,"Mavelikkara"); 
    ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Open Taluk dropdown ->Select a Taluk");
	Log.info("Step:01 - 1.  Open Taluk dropdown");
	 
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	 
	 //Panchayath Field Enabled and Selectable
	ExtentTestManager.startTest("Panchayath Field Enabled and Selectable");
    Log.info("Panchayath Field Enabled and Selectable");
	 
	input(grploansrepo.pachayath,"AANAAD");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Panchayath dropdown ->Select a Panchayath");
	Log.info("Step:01 - 1.Open Panchayath dropdown->Select a Panchayath");
	  
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	
	 //Centre Name Field Enabled
	ExtentTestManager.startTest("Panchayath Field Enabled and Selectable");
	Log.info("Panchayath Field Enabled and Selectable");
		 
	input(grploansrepo.cntr_name,"KHUSHI");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Panchayath dropdown ->Select a Panchayath");
	Log.info("Step:01 - 1.Open Panchayath dropdown->Select a Panchayath");
		  
	waitTillLoaderDisappear(grploansrepo.loader);
		
	ExtentTestManager.endTest();
		
	//Meeting day
	ExtentTestManager.startTest("Meeting Day Field Enabled and Selectable");
	Log.info("Meeting Day Field Enabled and Selectable");
			 
	input(grploansrepo.meeting_day,"THUESDAY");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Meeting Day dropdown ->Select a Meeting Day");
	Log.info("Step:01 - 1.Open Meeting Day dropdown ->Select a Meeting Day");
			  
	waitTillLoaderDisappear(grploansrepo.loader);
			
	ExtentTestManager.endTest();
	
	//Distance from Branch to Centre Field Enabled
	ExtentTestManager.startTest("Distance from Branch to Centre Field Enabled");
	Log.info("Distance from Branch to Centre Field Enabled");
			 
	input(grploansrepo.distanceFrmdtoc,"10kms");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1. Enter 'Distance from Branch to Centre");
	Log.info("Step:01 - 1.Enter 'Distance from Branch to Centre");
				  
	waitTillLoaderDisappear(grploansrepo.loader);
				
	ExtentTestManager.endTest();
     
	//Village Field Enabled and Selectable
	ExtentTestManager.startTest("Village Field Enabled and Selectable");
	Log.info("Village Field Enabled and Selectable");
				 
	input(grploansrepo.villagefield,"ANJUR");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Village dropdown -> Select a Village");
	Log.info("Step:01 - 1.Open Village dropdown -> Select a Village");
					  
	waitTillLoaderDisappear(grploansrepo.loader);
					
	ExtentTestManager.endTest();
	
	//Block Field Enabled Enter block
	ExtentTestManager.startTest("Block Field Enabled Enter block");
	Log.info("Block Field Enabled Enter block");
					 
	input(grploansrepo.blockfield,"3block");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Village dropdown -> Select a Village");
	Log.info("Step:01 - 1.Open Village dropdown -> Select a Village");
						  
	waitTillLoaderDisappear(grploansrepo.loader);
						
	ExtentTestManager.endTest();
	
	//LandMark Field Enabled Enter Landmark
	ExtentTestManager.startTest("LandMark Field Enabled Enter Landmark");
	Log.info("Block Field Enabled Enter block");
							 
	input(grploansrepo.landmark,"next ashok ");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Check if LandMark field is enabled -> Enter LandMark field data ");
	Log.info("Step:01 - 1.Check if LandMark field is enabled -> Enter LandMark field data");
								  
	waitTillLoaderDisappear(grploansrepo.loader);
								
	ExtentTestManager.endTest();
	
		
	//Post Office Field Enabled and Selectable
	ExtentTestManager.startTest("Post Office Field Enabled and Selectable");
	Log.info("Post Office Field Enabled and Selectable");
									 
	input(grploansrepo.pofield,"Roppa B.O");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Post Office dropdown-> Select a Post Office ");
	Log.info("Step:01 - 1.Open Post Office dropdown-> Select a Post Office");
										  
	waitTillLoaderDisappear(grploansrepo.loader);
										
	ExtentTestManager.endTest();
	
//	//PINCODE Field Auto-Populated
//	ExtentTestManager.startTest("PINCODE Field Auto-Populated");
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
	ExtentTestManager.startTest("Field Officer Field Enabled and Selectable");
	Log.info("Field Officer Field Enabled and Selectable");
										 
	input(grploansrepo.fofficer,"SANTHOSH");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Open Field Officer dropdown -> Select a Field Officer ");
	Log.info("Step:01 - 1.Open Field Officer dropdown -> Select a Field Officer ");
												  
	waitTillLoaderDisappear(grploansrepo.loader);
												
	ExtentTestManager.endTest();
		
	//Enter meeting time
	ExtentTestManager.startTest("Post Office Field Enabled and Selectable");
	Log.info("Post Office Field Enabled and Selectable");
											 
	input(grploansrepo.Meeting_time,"10");
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Enter 10 in Hours text field ");
	Log.info("Step:01 - 1.Enter 10 in Hours text field ");
													  
	input(grploansrepo.Meeting_minutes,"30");
	ExtentTestManager.getTest().log(Status.PASS,"Step:02 - 1.Enter 30 in Minutes text field");
	Log.info("Step:01 - 1.Enter 30 in Minutes text field ");
	
	input(grploansrepo.meetingAM,"AM");
	ExtentTestManager.getTest().log(Status.PASS,"Step:03 - 1.Select AM from Meridians dropdown ");
	Log.info("Step:01 - 1.Select AM from Meridians dropdown  ");
	waitTillLoaderDisappear(grploansrepo.loader);
	
	ExtentTestManager.endTest();
	
	//Save Centre Registration
	ExtentTestManager.startTest("Save Centre Registration");
	Log.info("Save Centre Registration");
											 
	click(grploansrepo.save);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
	Log.info("Step:01 - 1.Centre is created successfully");
	
	ExtentTestManager.endTest();
	
	//logout
	ExtentTestManager.startTest("Save Centre Registration");
	Log.info("Save Centre Registration");
											 
	click(grploansrepo.updated);
	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
	Log.info("Step:01 - 1.Centre is created successfully");
	
//	click(grploansrepo.signout);
//	ExtentTestManager.getTest().log(Status.PASS,"Step:01 - 1.Centre is created successfully");
//	Log.info("Step:01 - 1.Centre is created successfully");
	
	ExtentTestManager.endTest();
	
	}
}	


