package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepository_AccountOpening_Otherloanoping_documentsecurity {

	public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	
	public By accountOpening=By.xpath("//a[text()='Account Opening']/parent::li");
	public By loanOpening=By.xpath("//a[text()='Loan Opening']/parent::li");
	public By loanAndAdvances=By.xpath("//a[text()='Loan and Advances (ACOPL)']/parent::li");
	public By personalLoanWeekly=By.xpath("//a[text()='PERSONAL LOAN WEEKLY   (23001)']/parent::li");
	public By customerSearchIcon=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	public By childCustID=By.xpath("//input[@id='PopQuick1_txtCustID']");
	
	public By custID_textbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt\"]");
	
	
	//*[@id="PopQuick1_txtCustID"]
	
	public By childSearchBtn=By.xpath("//input[@id='PopQuick1_btnSearch']");
	
	//*[@id="PopQuick1_btnSearch"]
	
	public By childSelectLink=By.xpath("//a[text()='Select ']");
	public By selectLinkInNominee=By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");	
	//*[@id="PopQuick1_lst_ctrl0_linkSelect"]
	public By okBtn=By.xpath("//span[text()='OK']");
	public By addBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
	public By accountInfoGrid=By.xpath("//*[@id=\"tblCustViewList\"]");
	public By signOut=By.xpath("//strong[text()='Signout']/parent::a");
	
	public By resolutionNo=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt\"]");
	public By resolutionDate=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtResDate_txt\"]");
	public By referedByDropdown=By.xpath("//*[@id=\"hyjackText0\"]");
	public By equitableMort=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtEquitableMortgagerRegNo_txt\"]");
	public By emrDate=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtEMRDate_txt\"]");
	public By agentCode=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentCode_txt\"]");
	public By dsaCode=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSACode_txt\"]");
	public By area=By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtCDLArea_txt']");
	public By remark=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt\"]");
	public By nextBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	

	//Document
	public By documentLabel=By.xpath("//span[contains(text(),'Document')]//parent::span[@class='ajax__tab_tab']");
	public By srOfficeDropdown=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_ddlSubRegOffice_ddl\"]");
	public By regYear=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtRegYear_txt\"]");
	public By docNo=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtDocNo_txt\"]");
	public By surveyNo=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtSurveyNo_txt\"]");
	public By regDate=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_dtRegDate_txt\"]");
	public By worth=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtWorth_txt\"]");
	public By marketGahanVal=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_txtMarketVal_txt\"]");
	public By addBtn1_document=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_btnAddCustDoc\"]");
	public By addBtn2_document=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpDocuments_ucDoc_btnDocAdd\"]");
	
	public By grid1_document=By.xpath("//table[@class='DocumentCustomerList']");
	//public By grid1_document=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[9]/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[5]/td/table/tbody/tr/td/table");
	
	
	public By grid2_document=By.xpath("//table[@id='tblLAS']");
	public By nextBtn_document=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	
	
	public By nomineeNotRequired_checkbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee\"]");
	public By relation_dropdown=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl\"]");
	
	
	
	//*[@id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup"]
	
	public By customerSeachIcon_nominee=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup\"]");
	
	//public By customerSearchIcon=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	//*[@id="ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup"] - nomi
	
	public By addBtn_nominee=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee\"]");
	public By nominee_grid=By.xpath("//*[@id=\"tblNomineeItemsList\"]");
	
	public By sanctioned=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt\"]");
	public By getValuesBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI\"]");
	public By amount=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtInstAmount_txt\"]");
	
	public By aadharNo=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtAdhaarNo_txt\"]");
	public By nameInNominee=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomName_txt\"]");
	public By district_dropdown=By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomDistrict_ddl']");
	public By post_dropdown=By.xpath("(//select[@title='Select Post'])[1]");
	public By dob_textbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_dtDOB_txt\"]");
	
	
	
	
	
	public By transModeDropdown=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl\"]");
	public By saveBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	
	public By newAccountOpenedLabel=By.xpath("//span[text()='New Account Opened']");
	
	public By authorizeAndCancel=By.xpath("//a[text()='Authorize & Cancel']/parent::li");
	public By managerAuthorization=By.xpath("//a[text()='Manager Authorisation (MNAU)']/parent::li");
	public By cashierAuthorization=By.xpath("//a[text()='Cashier Authorisation (CAAU)']/parent::li");
	public By refreshBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By authorizeBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");	
	public By authorizePage_checkbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");

	
	
	public By checkboxInTransfer=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"]");

public By cashierAuthorize_checkbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	//*[@id="ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect"]
	public By cashier_authorizeBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By closeIcon=By.xpath("//*[@id=\"closetop\"]");
	
	
	//Transfer
	
	public By postCreditBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_btnAutoPost\"]");
	public By transactionBased=By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By glName=By.xpath("//*[@id=\"hyjackText0\"]");
	public By glAccCode=By.xpath("//*[@id=\"txtGLAcCode_txt\"]");
	public By amountInTransfer=By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	public By addBtnInTransfer=By.xpath("//*[@id=\"btnAddGLAcHead\"]");
	public By submitInTransfer=By.xpath("//*[@id=\"btnSubmit\"]");
	
	public By transferTab=By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	
	public By yesBtnInTransfer=By.xpath("//span[text()='YES']/parent::button");
	public By makerID=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMakerID_txt\"]");
	public By goBtn=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By OkBtn=By.xpath("//*[@id=\"close\"]");
	
	public By authorizeCheckbox=By.xpath("//span[contains(@title,\"102000015930 \")]/parent::*/parent::*/td[@class='chk']/input");
	public By transactionID=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By transactionID_textbox=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	
	public By OkBtn_loginStatusFailed=By.xpath("//span[text()='OK']");
}
