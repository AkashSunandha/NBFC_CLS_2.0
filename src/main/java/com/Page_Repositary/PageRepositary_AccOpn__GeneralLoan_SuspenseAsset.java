package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpn__GeneralLoan_SuspenseAsset {

	public By accountOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Account Opening']/preceding-sibling::div");
	public By generalOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='General Opening']/preceding-sibling::div");
	public By suspenseAssetTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Suspense Asset ']/preceding-sibling::div");
	public By suspenseAssetTab_31002 = By.xpath("//*[text()='SUSPENSE ASSET  (31002)']");
	
	//Product Acc Info
	public By paiCustSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a/img");
	public By popUpNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By paiAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer\"]");
	public By paiCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_txtCustomerId_txt\"]");
	public By paiCustDetailsGrid = By.xpath("//*[@id=\"tblCustList\"]");
	public By paiOPeningAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt\"]");
	public By paiRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtRemark_txt\"]");
	public By paiTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_ucOtherInfoForm_ddlTransactionMode_ddl\"]");
	public By paiSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By summaryTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
	public By paiPostCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_ucOtherInfoForm_btnAutoPost\"]");

}
