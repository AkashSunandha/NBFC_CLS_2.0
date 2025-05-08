package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_DebentureRedemption {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By debentureTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture']//preceding-sibling::div");
	public By debentureRedemptionTab = By.xpath("//a[text()='Debenture Redemption ']");
	
//	Debenture Redemption
	public By drLoginBranch= By.xpath("//*[@id=\"ctl00_ctl00_lblBranch\"]");
	public By drBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlBranch\"]");
	public By drBranchDropdownOption = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlBranch\"]//*[@selected='selected']");
	public By drDebTypeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureType_ddl\"]");
	public By drIssueTypeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlIssueType_ddl\"]");
	public By drSeriesDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureSeries_ddl\"]");
	public By drAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_txtAcNo_txt\"]");
	public By drGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_btnGo\"]");
	public By drTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AIF1_ddlTransMode_ddl\"]");
	public By drTransModeDropdownOption = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AIF1_ddlTransMode_ddl\"]//*[@selected='selected']");
	public By drSubmitbtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By transIdSummaryPage = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By postCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AIF1_btnAutoPost\"]");
	public By printBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
	public By interestLogBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnInterestLog\"]");
	public By interestLogTable = By.xpath("//*[@id=\"tblIntrestLogView\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
