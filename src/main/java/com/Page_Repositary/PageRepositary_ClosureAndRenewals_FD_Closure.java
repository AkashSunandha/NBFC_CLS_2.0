package com.Page_Repositary;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class PageRepositary_ClosureAndRenewals_FD_Closure extends Base_Class{

	public By ClosureAndRenewalsTab = By.xpath("(//*[@id='CreateMenu']//li[@class=' close']//*[text()='Closure & Renewals']//parent::li//div)[1]");
	
	public By Term_Deposit_ClosureTab=By.xpath("//*[text()='Term Deposit Closure']");
	public By VerifyTerm_Deposit_ClosureTab =By.xpath("//*[@title='Branch']");
	public By acBranchDropdown =By.xpath("//*[@title='Branch']");
	
	
	
	public By acGroupNameDropdown =By.xpath("//*[@title='Product Group']");
	public By acProductNameDropdown =By.xpath("//*[@title='Product Name']");
	public By acTransactionModeDropdown =By.xpath("//*[@title='TransactionMode']");
	public By acAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt\"]");
	public By acGOButton =By.xpath("//*[@value='Go']");
	public By SubmitButton=By.xpath("//*[@name='btnSubmit']");
	public By SubmitTrans=By.xpath("//*[@value='Submit'][@type='submit'][contains(@id,'_btnSubmit')]");
	public By POstDebit =By.xpath("//*[@value='Post Debit'] | //*[@value='Post Credit']");
	public By GL_NAME =By.xpath("//div[@class='hjsel_select']//*[@id='hyjackText0']");
	public By GL_NAMEVValue =By.xpath("//*[@class='hjsel_options']//*[text()='ADVANCE FOR LAND']");
	public By Amount =By.xpath("//*[@title='Amount']");
	public By AddButton =By.xpath("//*[@value='Add'][@type='submit']");
	
	public By PrincipalBalance =By.xpath("//*[@title='Principal Amount Balance']");
	public By Re_Depositing_Check_Box =By.xpath("//*[contains(@id,'_chkRenew')]");
	public By Enter_Duration =By.xpath("//*[contains(@name,'txtDuration')][@type='text'][@title='Enter Duration']");
	public By SelectDurationMode=By.xpath("//*[@title='Select Duration Mode']");
	
	public By AccountsearchBranchDropdown =By.name("ddlBranch");
	public By SearchButton =By.name("btnSearch");
	public By SelectAccountFromList=By.xpath("(//table[@id='tblAccountList']//tbody//tr[@class='GridItem']//a)[1]");
	public By aiAccNoField =By.xpath("//*[@title='Acc No']");
	public By TransAmount =By.xpath("//*[contains(@name,'txtTrnAmount')][@type='text']");
	public By TransactionModeDD =By.xpath("//*[@title='TransactionMode']");
	public By PartyName =By.xpath("//*[contains(@id,'txtPartyName_txt')]");
	public By Remarks =By.xpath("//*[contains(@id,'txtRemarks_txt')]");
	
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	
	
	
	
	
	public By userName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
	public By autorizeAndCancelTab = By.xpath("(//*[@id='CreateMenu']//li[@class=' close']//*[text()='Authorize & Cancel']//parent::li//div)[1]");
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
	public By TransactionBasedDD =By.xpath("//table[@id='tables']//tr//td//select[@class='DropRequiedField ']");
	public By approveCheckBoxTransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");



}
