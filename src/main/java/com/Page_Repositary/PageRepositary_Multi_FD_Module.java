package com.Page_Repositary;

import org.openqa.selenium.By;


public class PageRepositary_Multi_FD_Module
{
	//PC Registration
		public By formName = By.xpath("//*[@id='Username']");
		public By formBranchName = By.xpath("//select[@id='ddlBranches']");
		public By formBranchNameTrivandrum = By.xpath("//option[text()='TRIVANDRUM']");
		public By formBranchNameKochi = By.xpath("//option[text()='KOCHI']");
		public By formComputerName = By.xpath("//*[@id=\"MacName\"]");
		public By formSubmitBtn = By.xpath("/html/body/div[2]/div[11]/div/button/span");
		
		//Login Module
		public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
		public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
		public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
		public By logoutMsg = By.xpath("//*[@id=\"logMessage\"]");
		public By logoutOk = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
		public By invalidPaswrdErrMsg = By.xpath("//*[@id=\"lblErrorMessage\"]");
		public By home = By.xpath("//div[text()='Dashboard']");
		public By loginWarningOkBtn = By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]");
		
		//Account Opening sub module
		
		public By AccOpening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
		public By DepositOpening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/div");
		public By FixedDeposit = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/ul/li/div");
		public By FixedType2Years = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/ul/li/ul/li[2]/a");

		

		
		//Customer Search Window
		public By cust = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
		public By custSrch = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a/img");
		public By custName1 = By.xpath("//input[@id = 'PopQuick1_txtName']");
		public By SearchBtn = By.id("PopQuick1_btnSearch");
		public By SelectCust = By.id("PopQuick1_lst_ctrl0_linkSelect");
		public By AddBtn = By.id("ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer");
		public By OkBtn = By.xpath("//span[@class = 'ui-button-text']");
		public By Amount = By.xpath("//input[@id= 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt']");
		public By DurationNum = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtDuration_txt']");
		public By DurationDropDown = By.xpath("//select [@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl']");
		public By ReferedBy = By.xpath("//*[@id=\"hyjackText0\"]");
		public By GetValues = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI']");
		public By LedgerNum = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLedgerNo_txt']");
		public By FolioNum = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtFolioNo_txt']");
		public By Remark = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtRemark_txt']");
		public By LienMark = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_chkIsLienMark']");
		public By LienAmount = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLienAmount_txt']");
		public By LienRemark = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLienRemark_txt']");
		public By NextBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnNext']");
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

    



}
