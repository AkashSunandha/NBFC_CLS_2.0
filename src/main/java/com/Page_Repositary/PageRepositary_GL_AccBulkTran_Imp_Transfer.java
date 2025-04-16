package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GL_AccBulkTran_Imp_Transfer {
	
	public By loader =By.xpath("//div[@id=\"progressdiv\"]");
	
	public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/a");
	
	public By Others = By.xpath("//ul[@id='CreateMenu']//a[text()='Others']/preceding-sibling::div");
	
	public By DataSharing = By.xpath("//ul[@id='CreateMenu']//a[text()='Data Sharing']/preceding-sibling::div");
	
	public By GLAccBulkTranImp = By.xpath("//ul[@id='CreateMenu']//a[text()='GL A/c Bulk Transaction Excel Import ']//preceding-sibling::div//following-sibling::a");
	
	public By DownloadArrow = By.xpath("//a[@id='ctl00_ctl00_CPH1_PRDCNT_LnkDownload']");
	
	public By BrowseButton = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_updExcel']");
	
	public By Get = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnGet']");
	
	public By TransactionMode = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlTransactionMode_ddl']");
	
	public By Submit = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
	
	public By Tranfermode = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlTransactionMode_ddl']//option[@value='2']");
	
	public By TransactionId = By.xpath("//span[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
	
	public By VoucherId = By.xpath("//span[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lblVoucherNo']");
	
	public By NetAmount = By.xpath("//span[@id='ctl00_ctl00_CPH1_PRDCNT_lstXmlDetails_lblTotal']");
	
	public By Postdebit = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnAutoPost']");
	
	public By TransactionBased = By.xpath("//select[@id='ddlTrnsBased_ddl']");
	
	public By GLCode = By.xpath("//select[@id='ddlTrnsBased_ddl']//option[@value='2']");
	
	public By DropdownofGLname = By.xpath("//img[@class='hjsel_ddImage']");
	
	public By GLName = By.xpath("//div[@class='hjsel_options']//li[text()='AL INTEREST']");
	
	public By Amount = By.xpath("//input[@id='txtAmountForGLHead_txt']");
	
	public By Add = By.xpath("//input[@id='btnAddGLAcHead']");
	
	public By SubmitPostDebit = By.xpath("//input[@id='btnSubmit']");
	
	public By AuthorizeandCancel = By.xpath("//ul[@id='CreateMenu']//a[text()='Authorize & Cancel']/preceding-sibling::div");
	
	public By ManagerAuthorisation = By.xpath("//ul[@id='CreateMenu']//a[text()='Manager Authorisation (MNAU)']/preceding-sibling::div//following-sibling::a");
	
	public By Transfertab = By.xpath("//span[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']");
	
	public By Refresh = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnRefresh']");
	
	public By TransactionIdSearch = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']");
	
	public By VoucherNosearch = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_txtVoucherNo_txt']");
	
	
	public By Go =By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnGo']");
	
	public By Checkbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");
	
	public By Authorize = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
	
	public By Closetop = By.xpath("//img[@id='closetop']");
	
	public By Signout = By.xpath("//a[@id='ctl00_ctl00_lnkSignout']");
	
}