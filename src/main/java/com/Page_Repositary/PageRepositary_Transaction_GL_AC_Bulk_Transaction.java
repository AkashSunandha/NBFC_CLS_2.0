package com.Page_Repositary;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class PageRepositary_Transaction_GL_AC_Bulk_Transaction extends Base_Class{

	public By transactionTab = By.xpath("(//*[@id='CreateMenu']//li[@class=' close']//*[text()='Transaction']//parent::li//div)[1]");
	/////////////////////////////////////////////
	public By GL_AC_Bulk_Transaction=By.xpath("//*[text()='GL A/c Bulk Transaction ']");
	public By VerifyGL_AC_Bulk_transaction =By.xpath("//*[contains(@id,'MasterCaption')][text()='GL A/c Bulk Transaction']");
	public By aiBranchDropdown =By.xpath("//*[@title='Branch']");
	public By aiTransactionTypeDropdown =By.xpath("//*[@title='Transaction Type']");
	public By aiAccountTypeDropdown =By.xpath("//*[@title='Account Type']");
	public By Accountpopup=By.xpath("//*[contains(@onclick,'AccountSearchPopUp')]");
	public By AccountsearchGroupNameDropdown =By.xpath("//*[@title='Group Name']");
	public By AccountsearchProductNameDropdown =By.xpath("//*[@title='Product Name']");
	public By AccountsearchBranchDropdown =By.name("ddlBranch");
	public By SearchButton =By.name("btnSearch");
	public By SelectAccountFromList=By.xpath("(//table[@id='tblAccountList']//tbody//tr[@class='GridItem']//a)[1]");
	public By aiAccNoField =By.xpath("//*[@title='Acc No']");
	public By TransAmount =By.xpath("//*[contains(@name,'txtTrnAmount')][@type='text']");
	public By TransactionModeDD =By.xpath("//*[@title='TransactionMode']");
	public By PartyName =By.xpath("//*[contains(@id,'txtPartyName_txt')]");
	public By SubmitTrans=By.xpath("//*[@value='Submit'][@type='submit']");
	public By Remarks =By.xpath("//*[contains(@id,'txtRemarks_txt')]");
	public By AddButton =By.xpath("//*[@value='Add']");
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	
	
	
	
	
	public By userName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
	public By autorizeAndCancelTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/div");
	public By managerAuthoTab = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
	public By cashTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash\"]");
	public By refreshBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By approveCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By cashierAuthoTab = By.xpath("//*[text()='Cashier Authorisation (CAAU)']");
	public By cashierRefreshBtn = By.xpath(" //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By confirmationPopUp = By.xpath("//*[@id='closetop']");
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
