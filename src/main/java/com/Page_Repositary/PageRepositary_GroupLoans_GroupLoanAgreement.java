package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_GroupLoanAgreement {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By groupLoanAgreementTab = By.xpath("//a[text()='GroupLoan Agreement']");
	
//	Group Info
	public By giBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch_ddl\"]");
	public By giCentreNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlCentre\"]");
	public By giGroupNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlGroup\"]");
	public By giGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	
//	Application List
	public By alApplicationListDetailsGrid = By.xpath("//*[@id=\"tblLoanAgreement\"]");
	public By alSelectBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstLoanAgreement_ctrl0_lnkSelect\"]");
	public By alCustListGrid = By.xpath("//*[@id=\"tblGroupMembers\"]");
	public By alPrintAgreementBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrt\"]");
	public By alSubmitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	public By savedPopUp = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
	public By popUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
	public By popSuccessMsg = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
