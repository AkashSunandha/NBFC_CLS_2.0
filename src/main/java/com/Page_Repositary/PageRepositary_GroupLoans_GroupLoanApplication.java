package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_GroupLoanApplication {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By groupLoanApplicationTab = By.xpath("//a[text()='GroupLoanApplication']");

//	Group Info
	public By giBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlBranch\"]");
	public By giCentreDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_ddlCentre\"]");
	public By giGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_GLInfo_btnGo1\"]");
	public By giSelect = By.xpath("//a[@href=\"javascript:__doPostBack('ctl00$ctl00$CPH1$PRDCNT$GLInfo$gdvGroup','Select$0')\"]");
	public By giCustDetails = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustDiv\"]");
	public By giCustDetailsGrid = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer\"]");
	
//	Customer Details
	public By cdProductDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl02_ddlProduct_ddl\"]");
	public By cdLoanAmountTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl02_txtLoanAmount\"]");
	public By cdPurposeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl02_ddlPurpose_ddl\"]");
	public By cdIsGuarantorCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_gdvCustomer_ctl02_chkGuaranteer\"]");
	public By cdSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By savedPopUp = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
	public By popUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
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
