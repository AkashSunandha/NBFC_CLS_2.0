package com.Page_Repositary;

//public class PageRepositary_Debenture_DebentureInterestPaymentCash {

	
		// TODO Auto-generated method stub

		
		import org.openqa.selenium.By;

		public class PageRepositary_Debenture_DebentureInterestPaymentCash {

			
				
				
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
		
		
				
				
				public By DebentureWindowTitle  = By.xpath("//*[@id=\"ctl00_ctl00_MasterCaption\"]");
				public By debenturetab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/div");
				public By DebentureInterestPaymenttab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/ul/li[7]/a");
				//public By grBranchDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranches_ddl\"]");
				public By debtdropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureType_ddl\"]");
				public By debenturetypeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureType_ddl\"]//option[@value='90068']") ;
				public By issuetypedropdown  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlIssueType_ddl\"]");
				public By issuetypeitemDropdown  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlIssueType_ddl\"]//option[@value='66']");
				public By seriesdropdown  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureSeries_ddl\"]");
				public By seriestypeDropdown  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureSeries_ddl\"]//option[@value='2063']");
				
				
				
				public By bankDetailsAccNumTxtBox =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_txtAcNo_txt\"]");
				public By GoButton =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_btnGo\"]");                                                                              
				public By DurationTxtBox =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDuration_txt\"]");
				
				public By loader =By.xpath("//div[@id=\"progressdiv\"]");
				
				public By stbutton =By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']"); 
				
				
				
				public By ptbutton = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
						
				public By closebutton = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnClose\"]");
				                                                          
				public By custSignOut = By.xpath("//strong[text()='Signout']");
				
			
				
				//manager user authorization
				
				
				public By autorizeAndCancelTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/div");
				public By managerAuthoTab  = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/ul/li[7]/a");
				public By managerTab = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucSectionCaption1_lblCaption\"]");
				public By managerRefreshBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
				public By cashCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
				public By cashAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
				public By confirmationPopUp = By.xpath("//*[@id=\"closetop\"]");
				public By cashierAuthoTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/ul/li[8]/a");
				public By cashierRefreshBtn  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
				public By cashierCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
				public By cashierAuthorizeBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
				
				
				
				public By TransactionIdprint = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
				
				
				public By Go = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
				
				
				public By TransactionIds = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
				
				public By cashierTransactionIds =  By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
				
				
				public By Checkbox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
				public By Authorize = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
				public By cashierAuthoscreen = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucSectionCaption1_lblCaption\"]");
				public By summaryTab  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption\"]");
				
				
						
				
}
