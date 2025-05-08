
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GroupLoans_GroupLoanSanction {


	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By groupLoansTab = By.xpath("//ul[@id='CreateMenu']//a[text()='GroupLoans']/preceding-sibling::div");
	public By groupLoansSactionTab = By.xpath("//a[text()='GroupLoanSanction']");
	
//	Group Details
	public By gdBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch_ddl\"]");
	public By gdCentreDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlCentre\"]");
	public By gdGroupDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlGroup\"]");
	public By gdGoBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By gdSelect = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstLoanApplications_ctrl0_lnkSelect\"]");
	public By applicationDetailsTab = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_SecApplDetails_lblCaption\"]");
	public By loanAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtLoanAmount_txt\"]");
	public By sanctionBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSanction\"]");
	public By popUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
	public By popSuccessMsg = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");//	public By variable = By.xpath("");
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
