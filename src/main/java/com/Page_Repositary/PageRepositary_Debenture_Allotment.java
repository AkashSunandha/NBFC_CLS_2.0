package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Allotment {

	public By Debenture = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture']/preceding-sibling::div");
	public By Debenture_Allotment =By.xpath("//li[@class=' item']//a[text()='Debenture Allotment ']");
	public By ValidationDebenture_AllotmentPage =By.xpath("//*[@class='SecCapLeft']//span");
	public By AllotmentBranch =By.xpath("//*[@title='Branches']");
	public By AllotmentDebentureType =By.xpath("//*[@title='Debenture Type']");
	public By AllotmentIssueType =By.xpath("//*[@title='Issue Type']");
	public By AllotmentDebentureSeries =By.xpath("//*[@title='Debenture Series']");
	public By AllotmentStatus =By.xpath("//*[@title='Status']");
	public By AllotmentSearch =By.xpath("//*[@value='Search']");
	public By AllotmentProcess =By.xpath("//*[@value='Process']");
	public By ManagerAuthProduct_ID =By.xpath("//*[@title='Product ID']");
	public By MarkerID =By.xpath("//*[@title='MakerID']");
	public By Gobutton =By.xpath("//*[@value='Go']");
	public By VerifyProductProcessingStatus =By.id("sucess");
	public By VerifyProductProcessingProgress =By.xpath("//span[contains(@id,'PRDCNT_lvwProcessQueueList_ctrl0_lblPv')]");
	public By ReturnButton =By.xpath("(//*[text()='Return'])[1]");
	public By ReturnSubmit =By.xpath("//*[@value='Submit'][contains(@name,'btnSave')]");
	///////////////
	public By managerAuthoTab = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
	public By cashTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash\"]");
	public By refreshBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By approveCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
	public By cashierAuthoTab = By.xpath("//li[@class=' item']//a[text()='Cashier Authorisation (CAAU)']");
	public By cashierRefreshBtn = By.xpath(" //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By confirmationPopUp = By.xpath("//*[@id='closetop']");
	public By userName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
	public By autorizeAndCancelTab = By.xpath("(//*[@id='CreateMenu']//*[text()='Authorize & Cancel']//parent::li//div)[1]");
	public By CollapseAll =By.xpath("//*[@title='Collapse all']");
	public By sTransferTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	public By approveCheckBoxTransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"] | //*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By transIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	public By BatchIDTxtBox = By.xpath("//*[@title='BatchID']");	
	public By goBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By Amount =By.xpath("//*[@title='Amount']");
	public By BatchID =By.xpath("(//*[@class='GridItem']//td)[5]");
	
}
