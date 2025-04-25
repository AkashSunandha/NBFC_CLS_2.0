package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpn_AccountSearch {

	public By accountOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Account Opening']/preceding-sibling::div");
	public By Search=By.xpath("//ul[@id='CreateMenu']//a[text()='Search']/preceding-sibling::div");
	public By AccountSearch=By.xpath("//ul[@id='CreateMenu']//a[text()='Account Search ']");
	public By actualUserName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
//	Acc Search Info
	
	public By GroupDropdown=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlSchema_ddl']");	
	public By SubGroupDropdown=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlGroup_ddl']");
	public By ProductDropdown =By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlProduct_ddl']");
	public By ProductddValue=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlProduct_ddl']//option[text()='PERSONAL LOAN WEEKLY ']");
	public By Name=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_txtAccName']");
	public By SearchButton=By.xpath("//*[@value='Search']");
	public By ClearButton =By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_Button1']");
	public By GetFirstAccName =By.xpath("(//table[@id='tblAccountList']//tbody//tr[2]//td[6]//span)[1]");
	public By HouseName=By.id("ctl00_ctl00_CPH1_PRDCNT_PAS_txtHouseName");
	public By AccNoField =By.id("ctl00_ctl00_CPH1_PRDCNT_PAS_txtAccNo");
	public By FirstCheckBox=By.xpath("//table[@id='tblAccountList']//tbody//tr//td//input[@type='checkbox']");
	public By EditButton =By.id("ctl00_ctl00_CPH1_PRDCNT_ProductCommToolBar1_btnEdit");
	public By VerifyModifyPage =By.id("ctl00_ctl00_MasterCaption");
	public By Remark=By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt");
	public By SaveChnages =By.id("ctl00_ctl00_CPH1_PRDCNT_btnSave");
	public By Savemessage=By.id("FloatingErrorMessageBoxTop");
	public By CloseUpdateMsgPopup=By.id("closetop");
	public By Agentnamefield =By.xpath("//*[@title='Agent Name']");
	
	
	
	public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By logoutMsg = By.xpath("//*[@id=\"logMessage\"]");
	public By logoutOk = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
	public By invalidPaswrdErrMsg = By.xpath("//*[@id=\"lblErrorMessage\"]");
	public By home = By.xpath("//div[text()='Dashboard']");
	public By loginWarningOkBtn = By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]");
	public By custSignOut = By.xpath("//*[@title='Signout']//strong");
	public By ViewButton=By.id("ctl00_ctl00_CPH1_PRDCNT_ProductCommToolBar1_btnView");
	
	public By managerAuthoTab = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
	public By cashTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash\"]");
	public By refreshBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By approveCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By cashierAuthoTab = By.xpath("//*[text()='Cashier Authorisation (CAAU)']");
	public By cashierRefreshBtn = By.xpath(" //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"] | //*[@id='ctl00_ctl00_CPH1_PRDCNT_CancelTrans1_lvwTransDetails_ctrl0_chkSelect']");
	public By confirmationPopUp = By.xpath("//*[@id='closetop']");
	public By othersTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	public By othersCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By otherAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By transIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	public By goBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By transId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By sTransferTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	public By approveCheckBoxTransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"] | //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
	public By sOthersTab =By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	public By CollapseAll =By.xpath("//*[@title='Collapse all']");
	public By autorizeAndCancelTab = By.xpath("(//*[@id='CreateMenu']//*[text()='Authorize & Cancel']//parent::li//div)[1]");
	public By MakerID=By.xpath("//*[@title='MakerID']");

	public By CancelButton =By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnCancel']");
	public By DeleteButton =By.xpath("//*[@value='Delete']");
	public By View_DocumentButton =By.xpath("//*[@value='View Document']");
	public By VerifyView_Document=By.id("SectionCaption1_lblCaption");
	public By View_ImagesButton =By.xpath("//*[@value='View Images']");
	public By View_ImagesPopup=By.id("ui-dialog-title-divPhoto");
	public By View_ImagesPopupClose=By.xpath("//*[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-focus']");
	
}
