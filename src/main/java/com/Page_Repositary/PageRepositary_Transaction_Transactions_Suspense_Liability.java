package com.Page_Repositary;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class PageRepositary_Transaction_Transactions_Suspense_Liability extends Base_Class{

	public By transactionTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By transactionsTab = By.xpath("//*[text()='Transactions ']");

	//Account info
	public By aiBranchDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch\"]");
	public By aiProductGroupDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup\"]");
	public By aiProdcutNameDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl\"]");
	public By aiAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt\"]");
	public By aiTransTypeDropdwon = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl\"]");
	public By aiGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo\"]");
	public By aiErrorpopup =By.xpath("//*[@id='FloatingErrorMessageBoxThiche']");
	public By aiErrorpopupOk =By.xpath("//*[@id='closeThiche']");

	//Transaction Details
	public By tdTransactionDetailsWindow = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption\"]");
	public By accMaturedPopUpOkBtn = By.xpath("//*[@id=\"closewarning\"]");
	public By interestLogBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnInterestLog\"]");
	public By interestWndowCloseBtn = By.xpath("//*[@id=\"Close\"]");
	public By tdTransAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt\"]");
	public By tdTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl\"]");
	public By tdRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtRemarks_txt\"]");
	public By submitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By tdPostDebitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost\"]");
	public By currentTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtAvailBalance_txt\"]");
	public By principal1TxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtDue1\"]");
	public By principal2TxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtRemittance1\"]");
	public By interest1TxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtDue2\"]");
	public By interest2TxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtRemittance2\"]");
	public By popUpPageInterest = By.xpath("//*[@id=\"lstLog_lblIntSum\"]");
	public By transAmtTxt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_lblTrnAmount\"]");
	public By principalLogBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrincipalLog\"]");
	public By principalPopUpTable = By.xpath("//*[@id=\"tblLog\"]");
	public By principalPopUpCloseBtn = By.xpath("//*[@id=\"Close\"]");

	public By TransAmount =By.xpath("//*[contains(@name,'txtTrnAmount')][@type='text']");

	//////////////////////
	public By OpenClosureandrenewal = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/div");
	public By Clickonclosure = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/ul/li[7]/a");
	public By selectproduct = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup\"]");
	public By productname = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl\"]");
	public By StoreAccun = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt\"]");
	public By clickGo = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo\"]");
	public By ClickNo = By.xpath("/html/body/form/div[12]/div[3]/div/button[2]/span");
	public By Totalamount = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtTotalAllDue_txt\"]");
	public By Selectcash = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl\"]");
	public By scrolldown = By.xpath("//*[@id=\"WorkArea\"]");
	public By scrolldownside = By.xpath("//*[@id=\"CreateMenu\"]");


	public By remarks = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_txtRemarks_txt\"]");
	public By submit = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By TrasidVisible = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl1_lbllstTransID\"]");
	public By Singout = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

	// another user

	public By authandcancel = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/div");
//	public By Clickcashierauth = By
//			.xpath("//*[text()='Cashier Authorisation (CAAU)']");
	public By clickrefresh = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By checkbox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By transIdd = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl1_lbllstTransID\"]");
	public By clickauths = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By close = By.xpath("//*[@id=\"closetop\"]");

	//manager

	public By managertab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/ul/li[4]/a");
	public By cashtab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash\"]");
	public By refreshtab = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By checkboxman = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By clickauth = By.xpath("//input[@value='Authorize']");
	public By close2 = By.xpath("//*[@id=\"closetop\"]");      

	//transfer

	public By selecttransfer= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl\"]");
	public By cloamtdisplay= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucLoanClosure_txtTrnAmount_txt\"]");
	public By clickPD = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost\"]");

	public By produgroup= By.xpath("//*[@id=\"ddlProductGroup_ddl\"]");
	public By produname= By.xpath("//*[@id=\"ddlProductName_ddl\"]");
	public By enteramount= By.xpath("//input[@id='txtAmount_txt']");
	public By accnumber= By.xpath("//*[@id=\"txtChildAcNo_txt\"]");
	public By CliADD= By.xpath("//*[@id=\"btnAdd\"]");
	public By clickSubmit= By.xpath("//*[@id=\"btnSubmit\"]");

	public By submitpostD= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By ttransid= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl1_lbllstTransID\"]");


	public By Transfertab= By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	public By dispname= By.xpath("//input[@id='txtTotalCrDr_txt']");

	public By userName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
	public By autorizeAndCancelTab = By.xpath("(//*[@id='CreateMenu']//*[text()='Authorize & Cancel']//parent::li//div)[1]");
	public By TransactionCancellations =By.xpath("//*[text()='Transaction Cancellation ']");
	public By LastEntryCancellation=By.xpath("//*[text()='Last Entry Cancellation ']");
	
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
	public By sOthersTab =By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	public By ApproveCheckBoxOthers=By.xpath("//table[@id='tblCustList']//tbody/tr[@class='GridItem']//td[@class='chk']//*[@type='checkbox']");
	public By approveCheckBoxTransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
	public By HeaderDate =By.xpath("//*[contains(@id,'HeaderDate')]");
	public By TransactionDate =By.xpath("//*[@title='Transaction Date']");



}
