package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpr_MembMang_MembMang_Loan {

	public By accountOPerationsTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/div");
	public By memberManagementTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/ul/li[9]/div");
	public By memberManagementLoanTab = By.xpath("//a[text()='Member Management Loan ']");
	
	//Account Info
	public By aiBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch_ddl\"]");
	public By aiProductGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProductGroup_ddl\"]");
	public By aiProductDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProductName_ddl\"]");
	public By aiAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAcNo_txt\"]");
	public By aiGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By aiAccDetailsGrid = By.xpath("//*[@id=\"tblCustAccountData\"]");
	
	//Add New Member
	public By anmCustSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/div[2]/table/tbody/tr[1]/td[2]/a/img");
	public By popUpNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By anmAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAddCustomer\"]");
	public By anmLoaneeTypeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlMortgager\"]");
	public By anmCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtNewMenCustID_txt\"]");
	public By anmAccNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMemberName_txt\"]");
	public By anmCustDetailsGrid = By.xpath("//*[@id=\"tblCustViewList\"]");
	public By anmRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtRemarks_txt\"]");
	public By submitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAddMember\"]");
	public By errorPopUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
//	public By variable = By.xpath("");
	public By othersTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	public By otherCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By actualUserName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
