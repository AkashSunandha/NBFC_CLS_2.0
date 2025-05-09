package com.Pages_Jewel_Loan_Transcharge_Module;

import org.openqa.selenium.By;


public class Pages_Jewel_Loan_Transcharge
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
		
		//Jewel Gold Loan Renewal
		
		public By ProcessingandPosting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/div");
		public By ChargePosting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/ul/li[1]/div");
		public By LoanChargePosting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[11]/ul/li[1]/ul/li/a");
		public By Branch = By.xpath("//select[@id ='ctl00_CPH1_ddlBranch_ddl']");
		public By TrnDate = By.xpath("//input[@id ='ctl00_CPH1_dtTransDate_txt']");
		public By PostingDate = By.xpath("//input[@id ='ctl00_CPH1_dtPostingDate_txt']");
		public By LoanGroup= By.xpath("//select[@id ='ctl00_CPH1_ddlLoanGroup_ddl']");
		public By ProductName = By.xpath("//select[@id='ctl00_CPH1_ddlProductName_ddl']");
		public By AccountNumber = By.xpath("//input[@id ='ctl00_CPH1_txtAcNo_txt']");
		public By AccDisplayName = By.xpath("//input[@id ='ctl00_CPH1_txtDisplayName_txt']");
		public By CurrentBalance = By.xpath("//input[@id ='ctl00_CPH1_txtCurrentBalance_txt']");
		public By ShadowBalance = By.xpath("//input[@id ='ctl00_CPH1_txtShadowBalance_txt']");
		public By UnclearBalance = By.xpath("//input[@id ='ctl00_CPH1_txtUnClearBalance_txt']");
		public By ChargeType = By.xpath("//select[@id='ctl00_CPH1_ddlChargeType_ddl']");
		public By Amount = By.xpath("//input[@id='ctl00_CPH1_txtChargeAmount_txt']");
		public By AddButton = By.xpath("//input[@id='btnAdd']");
		public By DepositDetails = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table[2]/tbody/tr[8]/td");
		public By SaveDetails  = By.xpath("//input[@id ='ctl00_CPH1_btnSave']");
		public By LoanChargesPopup = By.xpath("//div[@id ='FloatingErrorMessageBoxTop']");
		public By ClosePopup = By.xpath("//img[@id ='closetop']");
		public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
		public By Transactions = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/a");
		public By TransactionsBranch = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlBranch']");
		public By ProductGroup = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup']");
		public By ProdName	 = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl']");
		public By AccNumber = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']");
		public By TransType = By.xpath("//Select[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl']");
		public By GoButton = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo']");
		public By AccountTrans = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td/table");
		public By MiscCharge = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtDue5']");
		public By TransAmt = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']");
		public By TransMode = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl']");
		public By Remarks = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtRemarks_txt']");
		public By SubmitTrans = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By SummaryOperation = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By ClosePoup = By.xpath("//input[@id ='closewarning']");
		public By TransCashID = By.xpath("//span[@id ='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By TotCredDebit = By.xpath("//input[@id = 'txtTotalCrDr_txt']");
		
		//Authorization
		public By AuthorizeCancel = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/div");
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
		public By ManagerAuthorize = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
		public By ItemAlready = By.xpath("//input[@id='close']");
		public By TrasID = By.xpath("//span[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By SummaryPage = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By TransferTab = By.xpath("//span[@id ='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']");
		//Post debit
		
		public By PostDebit = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost']");
		public By TransactionBased = By.xpath("//select[@id='ddlTrnsBased_ddl']");
		public By ProductGroupDropdown = By.xpath("//select[@id = 'ddlProductGroup_ddl']");
		public By ProductNameDropdown = By.xpath("//select[@id ='ddlProductName_ddl']");
		public By BranchName = By.xpath("//select[@id ='ddlBranch_ddl']");
		public By AccountNum = By.xpath("//input[@id ='txtChildAcNo_txt']");
		public By AmountField = By.xpath("//input[@id ='txtAmount_txt']");
		public By RemoveEntry = By.xpath("//a[@id ='lstContraEntry_ctrl0_lnkRemove']");
		public By SubButton = By.xpath("//input[@id='btnSubmit']");
		
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

    



}
