package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Jewel_Loan_Closure_Cash_Transfer {

	
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
	public By Clickcashierauth = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/ul/li[8]/a");
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
public By checkboxtrue = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect\"]");
}


