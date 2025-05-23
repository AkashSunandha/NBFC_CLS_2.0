
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Bond_Application {
	
	public By bond = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/div");
	public By bondapplication = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/ul/li[1]/a");
	
	public By branchchoose = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_ddlIntBranch\"]");

	public By prod =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_ddlFromProduct_ddl\"]");
	
	public By outside=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div/table[4]/tbody/tr/td/div/div[2]/div[3]/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td"); 
	
	public By acno = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_txtStandAcNoF_txt\"]");
	
	public By sellectproduct = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondAccountInfo_ctrl0_BondAccountInfo1_ddlProduct_ddl\"]");

	public By Naturefield = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondAccountInfo_ctrl0_BondAccountInfo1_ddlNature_ddl\"]");

	public By clickonsearch = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div/table[3]/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/a/img");

	public By clickname = By.xpath("//*[@id=\"PopQuick1_txtName\"]");

	public By popupsearch = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");

	public By select = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");

	public By clickadd = By.xpath("//input[contains(@id, 'btnAddCustomer')]");

	public By noofunits = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel1_lsBondGeneralInfo_ctrl0_ucBondGeneralInfo_txtNoOfUnit_txt\"]");
	public By duration = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel1_lsBondGeneralInfo_ctrl0_ucBondGeneralInfo_txtDuration_txt\"]");

	public By getvaluebutton = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel1_lsBondGeneralInfo_ctrl0_ucBondGeneralInfo_btnGetROI\"]");

	public By clicktheadd = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAdd\"]");

	// nominee

	public By clickonnominee = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee\"]");

	public By unticknominee = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee\"]");

	public By searchcust = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div/table[4]/tbody/tr/td/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	
	public By selectt= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_lstBondNomineeinfo_ctrl0_ucBondNomineeinfo_ddlNomRelation_ddl\"]");

	public By clickonadd= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_lstBondNomineeinfo_ctrl0_ucBondNomineeinfo_btnAddNominee\"]");
	
	public By clickintrest= By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3\"]");
	
	public By tickonintrest= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_chkIntrestTransferRequired\"]");
	
	public By frequence= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_txtExeFrequency_txt\"]");
	
	public By dropdown= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_ddlMonthDay_ddl\"]");
	
	public By clickonaddd = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAdd\"]");
	
	public By clickdocumnt= By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_TC1_tpDocuments\"]");
	
	public By clickdoctype= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_tpDocuments_ucBondDocumentUpload_ddlDocTypes\"]");
	
	public By browser= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_tpDocuments_ucBondDocumentUpload_docUpload\"]");
	
	public By clickcustomer= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TC1_TabPanel3_lstBondInternalAccountInfo_ctrl0_ucBondInternalAccountInfo_lstExtAccountList_ctrl0_chkInvAccountList\"]");	
	
	
	public By clickcASH = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondOtherInfo_ctrl0_ucBondOtherInfo_ddlPaymentMode_ddl\"]");
	
	public By clicksave= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	
	public By logout= By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	
	public By cashauth= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/ul/li[8]/a");
	
	public By clickauthorize= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/div");
	
	public By managertab= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/ul/li[7]/a");
	
	public By makerid= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMakerID_txt\"]");
	
	public By checkbox= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	
	public By authorize= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	
	public By close= By.xpath("//*[@id=\"closetop\"]");
	
	public By others= By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	
	public By refresh= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	
	public By go = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	
	public By cashierTransactionIds =  By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	
	public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	
	public By ManagerAuth = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	
	public By ManagerAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	
	
	
	
	
	

	
}
