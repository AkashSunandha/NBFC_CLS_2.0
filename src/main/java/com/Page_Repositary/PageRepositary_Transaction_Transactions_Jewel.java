package com.Page_Repositary;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class PageRepositary_Transaction_Transactions_Jewel extends Base_Class{

	public By transactionTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Transaction']/preceding-sibling::div");
	public By transactionsTab = By.xpath("//*[text()='Transactions ']");
	
	//Account info
	public By aiBranchDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch\"]");
	public By aiProductGroupDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup\"]");
	public By aiProdcutNameDropdowm = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl\"]");
	public By aiAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt\"]");
	public By aiTransTypeDropdwon = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl\"]");
	public By aiGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo\"]");
	public By actualBranch = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch\"]/option[@selected='selected']");
	
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
	public By fineTxtBox2 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtRemittance3\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");

	
}
