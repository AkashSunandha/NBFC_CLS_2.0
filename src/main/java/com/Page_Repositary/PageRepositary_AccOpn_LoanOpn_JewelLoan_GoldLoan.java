package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan { 

	public By accOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By loanOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/div");
	public By jewelLoanTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[1]/div");
	public By goaldLoanTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[1]/ul/li/a");
	
	//Account Info
	public By aiCustSrchBtn = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	public By popUpWndNameTxtField = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpWndSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpWndSelectLink = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By prvOkBtn = By.xpath("/html/body/div[4]/div[3]/div/button/span");
	public By aiCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt\"]");
	public By aiAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
	public By aiCustGrid = By.xpath("//*[@id=\"tblCustViewList\"]");
	public By aiResolutionNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt\"]");
	public By aiResolutionDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtResDate_txt\"]");
	public By aiPurposeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlPurposeCode_ddl\"]");
	public By aireferenceNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRefernceNo_txt\"]");
	public By aiSourceOfLoanDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlSourceOfLoan_ddl\"]");
	public By aiRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt\"]");
	public By aiNextBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	public By aiAppraiserDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_rdlAppraiser_ddl\"]");

	//Securities
	public By sItemGroupDropdpown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_ddlItemGroup_ddl\"]");
	public By sItemNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_ddlItems_ddl\"]");
	public By sItemDiscriptionTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtJewelDescription_txt\"]");
	public By sItemQtyTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtItemQty_txt\"]");
	public By sItemweightTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtItemWeight_txt\"]");
	public By sStoneWeightTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtStoneWeight_txt\"]");
	public By sDirtWeightTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtDirtWeight_txt\"]");
	public By sPurityTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtPurity_txt\"]");
	public By sAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_btnGoldAdd\"]");
	public By sJeweleryItemGrid = By.xpath("//*[@id=\"tblGold\"]");
	public By sImageBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_btnImageUpload\"]");
	public By sSelectItemDropdown = By.xpath("//*[@id=\"ddlItemCode_ddl\"]");
	public By sBrowseBtn = By.xpath("//*[@id=\"docUpload\"]");
	public By sImgAddBtn = By.xpath("//*[@id=\"btnAdd\"]");
	public By sImgRemoveIcon = By.xpath("//*[@id=\"lst_ctrl0_lstData_ctl00_btnRemove\"]");
	public By sSubmitBtn = By.xpath("//*[@id=\"btnSubmit\"]");
	
	//Nominee
	public By nNomineeNotReqCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee\"]");
	public By nAadhaarNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtAdhaarNo_txt\"]");
	public By nSearchIcon = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup\"]");
	public By nRelationDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl\"]");
	public By nAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee\"]");
	public By nNomineeDetailsGrid = By.xpath("//*[@id=\"tblNomineeItemsList\"]");

	//Loan Details
	public By ldSanctionedTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt\"]");
	public By ldSanctionedAmtErrorPopUpOkBtn = By.xpath("//*[@id=\"closeSanimi\"]");
	public By ldLimitTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtDebitLimit_txt\"]");
	public By ldGetValuesBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI\"]");
	public By ldROITxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtROI_txt\"]");
	public By ldDueDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_dtDueDate_txt\"]");
	public By ldTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl\"]");
//	
	public By saveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By summaryPage = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAccountDisplayName\"]");
	public By summaryCloseBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnClose\"]");
	
	//Transfer
	public By tPostCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_btnAutoPost\"]");
	
	//Auto posting
	public By apGLNameTxtBox = By.xpath("//*[@id=\"hyjackText0\"]");
	public By apTransBasedDropdown = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By apGLNameOptionAdver = By.xpath("//li[@val=463 and text()='ADVERTISEMENT']");
	public By apAmountTxtBox = By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	public By apAddBtn = By.xpath("//*[@id=\"btnAddGLAcHead\"]");
	public By apGrid = By.xpath("//*[@id=\"tblContra\"]");
	public By apSubmitBtn = By.xpath("//*[@id=\"btnSubmit\"]");
	public By apGlAccCodeTxtBox = By.xpath("//*[@id=\"txtGLAcCode_txt\"]");
	public By errorPopupYesBtn = By.xpath("//span[text()='YES']");
	
	//User Login
	public By userName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
	public By autorizeAndCancelTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/div");
	public By managerAuthoTab = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
	public By cashTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash\"]");
	public By refreshBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By approveCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By cashierAuthoTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/ul/li[8]/a");
	public By cashierRefreshBtn = By.xpath(" //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By confirmationPopUp = By.xpath("//*[@id=\"closetop\"]");
	public By othersTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	public By othersCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By otherAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By transIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	public By goBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By transId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By sTransferTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");

	public By approveCheckBoxTransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");

}
