package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_GroupLoanPayment {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By groupLoansPaymentTab = By.xpath("//a[text()='GroupLoanPayment']");

//	Group Info
	public By giBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlBranch\"]");
	public By giCentreDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlCentre\"]");
	public By GiGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlGroups\"]");
	public By giGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_btnGO2\"]");
	public By giSelect = By.xpath("//tr[@class='GridItem excludeList'][1]//a[contains(text(),'Select')]");
	
//	Loan Details
	public By ldApplicationNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAppNo\"]");
	public By ldCentreNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtCentreNo\"]");
	public By ldCustDetailsCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl02_chkShelect\"]");
	public By ldTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucPaymentInfo_ddlTransactionMode_ddl\"]");
	public By transId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By postCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucPaymentInfo_btnAutoPost\"]");
	public By popUpTransBasedDropdown = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By saveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
