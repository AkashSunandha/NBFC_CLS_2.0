package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Bond_BondConfiguration {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");

	public By continueBtn = By.xpath("//span[text()='Continue']");
	public By bondTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[3]/div");
	public By bondConfigTab = By.xpath("//a[text()='Bond Configuration ']");
	
	//Bond Configuration
	public By bdProductNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProduct_ddl\"]");
	public By bdFaceValueTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtFaceValue_txt\"]");
	public By bdAppAccNameDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlCashGLACName_ddl\"]");
	public By bdAppAccCodeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtCashGLACCode_txt\"]");
	public By bdDurationTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDuration_txt\"]");
	public By bdDurationDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDurationMode_ddl\"]");
	public By bdIntTransferFrequencyTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtStandingDuration_txt\"]");
	public By bdIntTransferFrequencyDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlStandingDurationMode_ddl\"]");
	public By bdMinAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMinimumAmt_txt\"]");
	public By bdMaxAmtTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMaximumAmt_txt\"]");
	public By bdIntCalcMethodDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlIntCalcMethod_ddl\"]");
	public By bdAllowPrematureClosureCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkIsAllowPrematureClosure\"]");
	public By bdBlkIssForRealizatnOnAppDateCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkBlockIssueForRealizationOnAppDate\"]");
	
	public By bdAccTypeGLHeadCheckBoxCheque  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkIsGLHead\"]");
	public By bdGLAccNameDropdownCheque = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlChequeGLACName_ddl\"]");
	public By bdGLAccCodeTxtBoxCheque = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtChequeGLACCode_txt\"]");
	
	public By bdAccTypeGLHeadCheckBoxEFT = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkIsGLHeadEft\"]");
	public By bdGLAccNameDropdownEFT = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlNeftGLACName_ddl\"]");
	public By bdGLAccCodeTxtBoxEFT = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtNeftGLACCode_txt\"]");
	
	public By bdAccTypeGLHeadCheckBoxDD = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkGlDD\"]");
	public By bdGLAccNameDropdownDD = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDDGLACName_ddl\"]");
	public By bdGLAccCodeTxtBoxDD = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDDGLACCode_txt\"]");
	
	public By bdAccTypeGLHeadCheckBoxUPI = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkUPIGL\"]");
	public By bdGLAccNameDropdownUPI = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlUPIGLACName_ddl\"]");
	public By bdGLAccCodeTxtBoxUPI = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtUPIGLACCode_txt\"]");
	
	public By bdGLAccNameDropdownPooling = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlPoolGLACName_ddl\"]");
	public By bdGLAccCodeTxtBoxPooling = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtPoolGLACCode_txt\"]");
	public By bdSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAdd\"]");
	public By bdConfirmationPopUp = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
	public By bdConfirmationPopUpCloseBtn = By.xpath("//*[@id=\"closetop\"]");
	public By bdGridEFTHead = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondDetails_ctrl0_lblEFTHead\"]");
	public By bdGridPrdName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondDetails_ctrl0_lblProductName\"]");
	public By bdGridDuration = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondDetails_ctrl0_lblDuration\"]");
	public By bdGridFrequency = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstBondDetails_ctrl0_lblRepayduration\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
}
