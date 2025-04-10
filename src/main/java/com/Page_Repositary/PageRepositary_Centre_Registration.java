package com.Page_Repositary;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class PageRepositary_Centre_Registration {
	
	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By grp_loans =By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
	public By ctr_registration =By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/a");

	//Select Branch
	public By branch_dropdown =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch_ddl\"]");
	
    
	//Select District
	public By district =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDistrict_ddl\"]");

	//Select street name
	public By strt_name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtStreetName_txt\"]");

	//Select Taluk
	public By taluk =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlTaluk_ddl\"]");

	//Select Pachayath
	public By pachayath =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlPanchayath_ddl\"]");

	//Select Centre name
	public By cntr_name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtCentreName_txt\"]");

	//Select Meeting day
	public By meeting_day =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlMeetingDay_ddl\"]");
	
	//Distance from Branch to Centre Field Enabled
	public By distanceFrmdtoc =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDistanceFromBranch_txt\"]");
		
	//Village Field Enabled and Selectable
	public By villagefield =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlVillage_ddl\"]");
	
	//Block Field Enabled Enter block
	public By blockfield =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtBlock_txt\"]");
	
	//LandMark Field Enabled Enter Landmark
	public By landmark =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtLandmark_txt\"]");
	
	//Post Office Field Enabled and Selectable
	public By pofield =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlPostOffice_ddl\"]");
		
//	//PINCODE Field Auto-Populated
//	public By picode =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtPincode_txt\"]");
	
	//Field Officer Field Enabled and Selectable
	public By fofficer =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlFieldOfficer_ddl\"]");
	
	//Enter Meeting Time
	public By Meeting_time =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tpkMeetingTime_txtAHour_txt\"]");
	public By Meeting_minutes =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tpkMeetingTime_txtAMinute_txt\"]");
	public By meetingAM=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tpkMeetingTime_ddlAMPM\"]");
	
	//Save Centre Registration
	public By save =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_BtnSave\"]");
	
	//Logout
	public By updated =By.xpath("//*[@id=\"closetop\"]");
	public By signout =By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	
	
}
