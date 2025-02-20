package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpn_LoanOpn_LoanAndAdvan_PersnlLoanWeekly {

	public By accountOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By loanOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/div");
	public By loanAndAdvancesTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/div");
	public By personalLoanWeeeklyTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/ul/li[1]/a");
	
	//Account Info
	public By aciCustSearchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	public By popUpWndNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpWndSearchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpWndSelectBtn = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By aciCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt\"]");
	public By aciAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
	public By aciCustDetailsGrid = By.xpath("//*[@id=\"tblCustViewList\"]");
	public By aciPrvOkBtn = By.xpath("/html/body/div[4]/div[3]/div/button/span");
	public By aciResolutionNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt\"]");
	public By aciResolutionDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtResDate_txt\"]");
	public By aciReferedByDropdown = By.xpath("//*[@id=\"hyjackText0\"]");
	public By aciDropdownOption = By.xpath("//li[@val='101000006511']");
	public By aciMortgagerRegNoTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtEquitableMortgagerRegNo_txt\"]");
	public By invalidDatePopUp = By.xpath("/html/body/form/table[4]/tbody/tr[1]/td[4]/div/img");
	public By aciEMRDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtEMRDate_txt\"]");
	public By aciRandomTxt = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/div[1]/div/div[2]/div[1]/div/table/tbody/tr[11]/td[1]");
	public By aciAgentCodeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentCode_txt\"]");
	public By aciAgentNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentName_txt\"]");
	public By aciDSACodeTextBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSACode_txt\"]");
	public By aciDSANameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSAName_txt\"]");
	public By invalidCodePopUpOkBtn = By.xpath("//*[@id=\"close\"]");
	public By aciReamrkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt\"]");
	public By nextBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	
	//Personal Sureties
	public By psPersonalSuretiesTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel\"]");
	public By psCustSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/div[1]/div/div[2]/div[2]/div/div[2]/div[5]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By psCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtPRCust_ID_txt\"]");
	public By psOffNameIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[9]/div[1]/div/div[2]/div[2]/div/div[2]/div[5]/div/table/tbody/tr[3]/td[2]/a/img");
	public By psOffNameOption = By.xpath("//a[@title='MALAPPURAM']");
	public By psSalaryCertCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_chkSalaryCert\"]");
	public By psBasicPayTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtBasicPay_txt\"]");
	public By psNetSalaryTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtNetSalary_txt\"]");
	public By psRetdDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_dtRetdDate_txt\"]");
	public By psReamrksTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtRemarks_txt\"]");
	public By psAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_btnSPAdd\"]");
	public By psPopUpOkBtn = By.xpath("/html/body/div[1]/div[3]/div/button/span");
	public By psPersonalSecuGrid = By.xpath("//*[@id=\"tblPersonalSecurity\"]");
	
	//Nominee
	public By nNomineeNotReqCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee\"]");
	public By nNomineeCustSrchIcon = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup\"]");
	public By nRelationDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl\"]");
	public By nAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee\"]");
	public By nNomineeDetailsGrid = By.xpath("//*[@id=\"tblNomineeItemsList\"]");
	public By nCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomCust_ID_txt\"]");
	public By npreviousOverDueLoanPopUpOkBtn = By.xpath("//span[text()='OK']");

	//Loan Details
	public By ldGetValues = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI\"]");
	public By ldLimitTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt\"]");
	public By ldROITxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtROI_txt\"]");
	public By ldAmountTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtInstAmount_txt\"]");
	public By ldTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl\"]");
	public By ldSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	
	//Summary
	public By sSimilarDataExistsPopUpOkBtn = By.xpath("/html/body/form/div[14]/div[3]/div/button[1]/span");
	public By sTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By sPrintBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
	public By sTransferTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	public By errorPopUpOkBtn = By.xpath("/html/body/div[3]/div[11]/div/button[1]/span");
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
