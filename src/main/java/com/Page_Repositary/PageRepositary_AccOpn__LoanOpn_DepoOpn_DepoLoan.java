package com.Page_Repositary;

import org.openqa.selenium.By;
 
public class PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan { 
	
	public By accountOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Account Opening']/preceding-sibling::div");
	public By loanOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Loan Opening']/preceding-sibling::div");
	public By depositLoanTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Deposit Loan ']/preceding-sibling::div");
	public By depositLoan = By.xpath("//a[text()='DEPOSIT LOAN  (22001)']");
	public By nextBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	public By currentBranch = By.xpath("//*[@id=\"ctl00_ctl00_lblBranch\"]"); 
 
//	Account Info
	
	public By aiCustSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	public By popUpNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpCustSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By aiAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
	public By popUpSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By aiCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt\"]");
	public By prevActiveLoanPopUpOkBtn = By.xpath("//span[text()='OK']");
	public By aiCustDetailsGrid = By.xpath("//*[@id=\"tblCustViewList\"]");
	public By aiReferedByDropdown = By.xpath("//*[@id=\"hyjackText0\"]");
	public By aiReferedByOption = By.xpath("//*[@val=\"101000006511\"]");
	public By aiPurposeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlPurposeCode_ddl\"]");
	public By aiRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt\"]");
	public By aiIntimateCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_chkIsIntimate\"]");
	
	//Securities
	public By sSecurityDepositTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit\"]");
	public By sBranchIdDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_ddlBranch\"]");
	public By sProductNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_ddlProduct_ddl\"]");
	public By sAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_txtAcNo_txt\"]");
	public By sAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_btnSDADD\"]");
	public By sBranchIdDropdownDefaultValue = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_ddlBranch']/option[@selected='selected']");
	public By sSecuritiesGrid = By.xpath("//*[@id=\"tblSecDeposit\"]");
	public By accNotBelongsToApplicantErrPopUpOkBtn = By.xpath("//*[@id=\"closewarning\"]");

	//Nominee
	public By nomineeTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee\"]");
	public By nNomineeNotRequiredCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee\"]");
	public By nAadhaarTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtAdhaarNo_txt\"]");
	public By nNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomName_txt\"]");
	public By nRealtionDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl\"]");
	public By nDistrictDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomDistrict_ddl\"]");
	public By nPostDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomPost_ddl\"]");
	public By nDOBTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_dtDOB_txt\"]");
	public By nAgeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomAge_txt\"]");
	public By nAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee\"]");
	public By nNomineeDetailsGrid = By.xpath("//*[@id=\"tblNomineeItemsList\"]");
	public By ageTxt = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/div[1]/div/div[2]/div[3]/div/div/table/tbody/tr[6]/td[3]");

	//Loan Details
	public By ldActualSanctionedAmt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtDebitLimit_txt\"]");
	public By ldSanctionedTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt\"]");
	public By ldGetValuesBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI\"]");
	public By ldROITxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtROI_txt\"]");
	public By ldDueDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_dtDueDate_txt\"]");
	public By ldPayAmountTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt\"]");
	
	//Other info
	public By oitransMode = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl\"]");
	public By oisaveButton = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By oiPostCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_btnAutoPost\"]");
	public By existingLoanClosureOkBtn = By.xpath("/html/body/div[3]/div[11]/div/button[1]/span");
	public By similarDataExistPopUpYesBtn = By.xpath("//span[text()='YES']");
	public By transIdCash = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	public By oiTransBasedDropdown = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]"); 
	public By oiGLNameTxtBox = By.xpath("//*[@id=\"hyjackText0\"]");
	public By oiGLAccCodeTxtBox = By.xpath("//*[@id=\"txtGLAcCode_txt\"]");
	public By oiGLNameOption = By.xpath("//li[@val=50 and text()='AL INTEREST']");
	public By oiBalanceAmtTxtBox = By.xpath("//*[@id=\"txtBalanceAmount_txt\"]");
	public By oiAmntTxtBox = By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	public By oiAddBtn = By.xpath("//*[@id=\"btnAddGLAcHead\"]");
	public By oiSubmitBtn = By.xpath("//*[@id=\"btnSubmit\"]");//	public By variable = By.xpath("");
	public By oiAutoPostingGrid = By.xpath("//*[@id=\"tblContra\"]");
//	public By variable = By.xpath("");
	public By oiBatchOpenPopUp = By.xpath("/html/body/div[2]/div[11]/div/button[1]/span");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
	
	//postCredit 
	public By transactionDropdown = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By productGroupDropdown = By.xpath("//*[@id=\"ddlProductGroup_ddl\"]");
	public By productNameDropdown = By.xpath("//*[@id=\"ddlProductName_ddl\"]");
	public By branchDropdown = By.xpath("//*[@id=\"ddlBranch_ddl\"]");
	public By accNumTxtBox = By.xpath("//*[@id=\"txtChildAcNo_txt\"]");
	public By amtTxtBox = By.xpath("//*[@id=\"txtAmount_txt\"]");
	public By submitBtn = By.xpath("//*[@id=\"btnSubmit\"]");
	public By accNumTxt = By.xpath("//*[@id=\"lblAcno\"]");
	public By remarksTxtBox = By.xpath("//*[@id=\"txtRemarks_txt\"]");
	public By addBtn = By.xpath("//*[@id=\"btnAdd\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");


}
