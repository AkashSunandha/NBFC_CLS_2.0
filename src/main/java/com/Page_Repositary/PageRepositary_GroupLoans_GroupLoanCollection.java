package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_GroupLoanCollection {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By groupLoanCollectionTab = By.xpath("//a[text()='GroupLoan Collection']");
	
//	Group Info
	public By giBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlBranch\"]");
	public By giCentreDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlCentre\"]");
	public By giGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlGroups\"]");
	public By giGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_btnGO2\"]");
	public By giSelect = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvApplication\"]//tr[2]//td//a[text()='Select']");
	
//	Loan Details
	public By ldNumOfIntHeader = By.xpath("//td[text()='No.Of Inst']");
	public By ldNumOfIntTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_glcCustomer_ctrl0_txtnoinst\"]");
	public By ldAmtToBePaidTxtBox1 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_glcCustomer_ctrl0_txtAmountPaid\"]");
	public By ldAmtToBePaidTxtBox2 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_glcCustomer_ctrl1_txtAmountPaid\"]");
	public By ldTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlTransactionMode_ddl\"]");
	public By ldParticulars = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtRemarks_txt\"]");
	public By submitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By summaryPageTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By ldPostDebitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAutoPost\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
