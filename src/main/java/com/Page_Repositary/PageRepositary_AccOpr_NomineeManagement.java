package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpr_NomineeManagement {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");
	public By loginBranch = By.xpath("//*[@id=\"ctl00_ctl00_lblBranch\"]");
	public By actualUserName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");

	public By accountOperationsTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/div");
	public By nomineeManagementTab = By.xpath("//a[text()='Nominee Management ']");
	public By actualBranch = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_ddlBranch\"]/option[@selected='selected']");

//	Account Info
	public By aiBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_ddlBranch\"]");
	public By aiProductGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_ddlProductGroup\"]");
	public By aiProductNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_ddlProductName\"]");
	public By aiAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_txtAcNo_txt\"]");
	public By aiGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_OPNA_btnGo\"]");
	public By aiAccDetailsGrid = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_divVisible2\"]");
	
//	New Nominee
	public By nnNomineeNotRequired = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ACNM_chkNominee\"]");
	public By nnCustSRchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/table/tbody/tr/td/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By nnCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ACNM_txtNomCust_ID_txt\"]");
	public By nnPopUpNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By nnPopUpSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By nnPopUpSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By nnNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ACNM_txtNomName_txt\"]");
	public By nnRelationDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ACNM_ddlNomRelation_ddl\"]");
	public By nnAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ACNM_btnAddNominee\"]");
	public By popUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
	public By confirmationMsg = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
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
