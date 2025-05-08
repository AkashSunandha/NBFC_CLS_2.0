
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Others_DataSharing_CollectionImporting {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By othersTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Others']/preceding-sibling::div");
	public By dataSharingTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Data Sharing']/preceding-sibling::div");
	public By collectionImportingTab = By.xpath("//a[text()='Collection Importing ']");
	
//	Agent Details - 1
	public By adAgentCodeTextBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAgentCode_txt\"]");
	public By adAgentNameDropdown = By.xpath("//*[@id=\"hyjackText0\"]");
	public By adAgentNameOption = By.xpath("//li[@val='1']");
	public By adBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_ddlBranch_ddl\"]");
	public By adProductGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_ddlProductGroup_ddl\"]");
	public By adProductTypeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_ddlProduct1_ddl\"]");
	public By adAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtAcNo_txt\"]");
	public By adRandomTxt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_lblProduct\"]");
	public By adTotalDurationTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtTotDuration_txt\"]");
	public By adTotalDueTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtTotDue_txt\"]");
	public By adStatrtDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_dtStartDate_txt\"]");
	public By adDueDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_dtDueDate_txt\"]");
	public By adBillNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtBillNo_txt\"]");
	public By adFineTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtFine_txt\"]");
	public By adAmountTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtAmount_txt\"]");
	public By adAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_btnAdd\"]");
	public By adAgentDetailsGrid = By.xpath("//*[@id=\"tbAgent\"]");
	public By adInstallmentAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_AGV_txtInstAmount_txt\"]");
	public By adTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_ddlTransactionMode_ddl\"]");
	public By adRemarksTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_txtRemarks_txt\"]");
	public By adSubmitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By errorPopUpClose = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
	public By requiredErrMsg = By.xpath("//td[text()='TransactionMode is Required']");
	public By adPostDebitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAgentInfo_btnAutoPost\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");

	
}

