package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_DebentureAllotment {

	
		
		//PC Registration
		public By formName = By.xpath("//*[@id=\"Username\"]");
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
		public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
		public By actualUserName = By.xpath("//*[@id=\"ctl00_ctl00_lblUser\"]");
//		public By variable = By.xpath("");
//		public By variable = By.xpath("");
//		public By variable = By.xpath("");
//		public By variable = By.xpath("");
		
		//Debenture Allotment Window
	
		
		
		public By debenturetab  = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/div");
		
		public By debentureallotmenttab  = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/ul/li[6]/a");
		
		public By DebentureWindowTitle  = By.xpath("//*[@id=\"ctl00_ctl00_MasterCaption\"]");
		
		
		public By grBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranches_ddl\"]");
		
		public By debenturetypeDropdown = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl']//option[@value='90006']");
		
		public By debtdropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl\"]");;
		
		//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl']//option[@value='90006']
		
		
		
		
		
	
		
	
		
		
		
		
	}
