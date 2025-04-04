package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Transaction_LoanCollectionTransfer {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By transactionTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Transaction']/preceding-sibling::div");
	public By loanCollectionTransfer = By.xpath("//a[text()='Loan Collection Transfer ']");
	
//	Loan Collection Details
	public By lcdAgentNameDropdown = By.xpath("//*[@id=\"hyjackText0\"]");
	public By lcdAgentNameOption = By.xpath("//li[@val='1']");
	public By lcdAgentCodeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAgentCode_txt\"]");
	public By lcdTransDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_dtTransferDate_txt\"]");
	public By lcdCollectionUpTo = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_dtCollectionTo_txt\"]");
	public By lcdPersonalWeeklyOption = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProducts_ctrl37_chkProduct\"]");
	public By lcdProcessBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnProcess\"]");
	public By lcdProcessDetailsGrid = By.xpath("//*[@id=\"tblLoanTransferDetails\"]");
	public By lcdTransModeDropdownOption = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_ddlTransactionMode_ddl\"]/option[@selected='selected']");
	public By lcdRemarksTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_txtRemarks_txt\"]");
	public By lcdSubmitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By lcdcurrentTransDate = By.xpath("//*[@id=\"ctl00_ctl00_lblHeaderDate\"]");
	public By lcdErrorPopUpMsgOkBtn = By.xpath("//*[@id=\"closeColDat\"]");
	public By lcdSummaryPageTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By lcdRemarksRequiredCloseBtn = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
