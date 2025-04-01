package com.Pages_Share_Transfer;

import org.openqa.selenium.By;


public class Share_Transfer
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
		
		//GL Acc Transaction
	
		public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[7]/div");
		public By Productinfo = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div/table");
		public By ShareTransfer = By.xpath("//a[normalize-space()='Share Transfer (STR)']");
		public By Branch = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlBranch_ddl']");
		public By Productgrp = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlProductGroup_ddl']");
		public By Productname = By.xpath("//select[@ id = 'ctl00_ctl00_CPH1_PRDCNT_ucProductInfo_ddlProductName_ddl']");
		public By AccInfo = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/table");   
		public By Accno = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucFromAccountInfo_txtAcNo_txt']");
		public By GoButton = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucFromAccountInfo_btnGo']");
		public By Accdetails = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table");
		public By Accno1 = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucToAccountDetails_txtAcNo_txt']");
		public By Gobtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucToAccountDetails_btnGo']");
		public By Sharedetails = By.xpath("//*[@id=\"tblShareSeriesList\"]");
		public By Sharecheckbox = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_lstShareSeries_ctrl0_chkList']");
		public By Sharevalue = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_txtShareValue_txt']");
		public By Noofshares = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_txtNoOfShares_txt']");
		public By Shareamt = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransferDetails_txtShareAmount_txt']");
		public By Submitbtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSave']");

		
		public By AppManager = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlAppManager_ddl']");
		public By PreviousTrans = By.xpath("//div[@id='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_divLastNT']");
		public By Netpayable = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ucNonProductTransactionRecovery_txtGrandTotal_txt']");
		public By TransMode = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlTransactionMode_ddl']");
		public By PartyName = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtPartyName_txt']");
		public By Particulars = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRemarks_txt']");
		public By Submitbutton = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_btnSubmit']");
		public By SummaryOperation = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By ClosePopup = By.xpath("//img[@id ='closetop']");
		public By TransCashID = By.xpath("//span[@id ='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		
		//Authorization
		public By AuthorizeCancel = By.xpath("//body/form[@id='aspnetForm']/div[@id='divBody']/div[@id='navAlpha']/div/div/div[@id='outmost']/div[@id='scWrapper']/div[@id='scMenu']/div[@id='divGlossyMenuContent']/div[@class='submenu']/ul[@id='CreateMenu']/li[10]/div[1]");
		public By CashAuthorisation = By.xpath("//a[normalize-space()='Cashier Authorisation (CAAU)']");
		public By Refresh = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnRefresh']");
		public By TransactionIDField = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']");
		public By GoBTN = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnGo']");
		public By ManagerSelectCheckbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");
		public By SubmitButon = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By OpeningEntryCashCheckbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect']");
		public By CashAuthorizeBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By ManagerAuthorization = By.xpath("//a[normalize-space()='Manager Authorisation (MNAU)']");
		public By ManagerCheckBox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect']");
		public By TransManagerCheckBox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");

		public By ManagerAuthorize = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
		public By ItemAlready = By.xpath("//input[@id='close']");
		public By TrasID = By.xpath("//span[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By SummaryPage = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By TransferTab = By.xpath("//span[@id ='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']");
		//Post debit
		
		public By PostDebit = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_btnAutoPost']");
		public By TransactionBased = By.xpath("//select[@id='ddlTrnsBased_ddl']");
		public By ProductGroupDropdown = By.xpath("//select[@id = 'ddlProductGroup_ddl']");
		public By ProductNameDropdown = By.xpath("//select[@id ='ddlProductName_ddl']");
		public By BranchName = By.xpath("//select[@id ='ddlBranch_ddl']");
		public By AccountNum = By.xpath("//input[@id ='txtChildAcNo_txt']");
		public By AmountField = By.xpath("//input[@id ='txtAmount_txt']");
		public By RemoveEntry = By.xpath("//a[@id ='lstContraEntry_ctrl0_lnkRemove']");
		public By SubButton = By.xpath("//input[@id='btnSubmit']");
		public By TotCredDebit = By.xpath("//input[@id = 'txtTotalCrDr_txt']");
		public By AddButton = By.xpath("//input[@id='btnAdd']");
		public By AccountNoCheckbox = By.xpath("//input[@id = 'lstAccountList_ctrl0_chkInvAccountList']");

		
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

    



}
