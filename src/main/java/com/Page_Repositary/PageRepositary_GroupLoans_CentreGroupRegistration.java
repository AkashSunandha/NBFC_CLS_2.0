
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_CentreGroupRegistration {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By centreGroupRegistrationTab = By.xpath("//a[text()='CentreGroupRegistration']");
	
//	Group Registration
	public By grBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch_ddl\"]");
	public By grCentreDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlCentre_ddl\"]");
	public By grGroupNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtGroupName_txt\"]");
	public By grDistrictTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDistrict_txt\"]");
	public By grStreetNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtStreetName_txt\"]");
	public By grTalukTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTaluk_txt\"]");
	public By grPanchayathTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtPanchayath_txt\"]");
	public By grCentreNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtCentreName_txt\"]");
	public By grMeetingDayTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMeetingDay_txt\"]");
	public By grDistanceFromBranchTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDistanceFromBranch_txt\"]");
	public By grVillageTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtVillage_txt\"]");
	public By grBlockTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtBlock_txt\"]");
	public By grLandmarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtLandmark_txt\"]");
	public By grPostOfficeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtPostOffice_txt\"]");
	public By grPincodeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtPincode_txt\"]");
	public By grFieldOfficerTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtFieldOfficer_txt\"]");
	public By grMeetingTimeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMeetingTime_txt\"]");
	
//	Group Members
	public By gmCustIdSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/table/tbody/tr[3]/td[2]/a/img");
	public By gmCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtCustomerId_txt\"]");
	public By gmRolesDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlRoles_ddl\"]");
	public By gmAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAdd\"]");
	public By gmCustGrid1 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstGroupMembers_ctrl0_lblRoles\"]");
	public By gmCustGrid2 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstGroupMembers_ctrl1_lblRoles\"]");
	public By gmSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By popUpSuccessMsg = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
	public By popUpClose = By.xpath("//*[@id=\"closetop\"]");
	public By popUpWndNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpWndSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpWndSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
	
}

