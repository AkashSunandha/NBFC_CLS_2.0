package com.Pages_Jewel_Gold_Loan_Renewal_Module;

import org.openqa.selenium.By;


public class Pages_Jewel_Gold_Loan_Renewals
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
		
		public By ClosureRenewal = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/div");
		public By LoanClosure = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/ul/li[7]/a");
		public By ProductGroup = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup']");
		public By ProductName = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl']");
		public By AccountNumber = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']");
		public By GoBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo']");
		public By LoanDetailsSection= By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[6]/div/div[2]/table/tbody/tr[2]/td/table");
		public By PreMatureClosure = By.xpath("/html/body/form/div[12]/div[3]/div/button[1]/span");
		public By RenewAccount = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucLoanClosure_chkRenewLoanAccount']");
		public By RenewAccountDetails = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[6]/div/div[4]/div[1]/table/tbody/tr[2]/td/table[2]");
		public By SecurityDetails = By.xpath("//input[@id ='btnSecurityDetails']");
		public By ItemGroup = By.xpath("//select[@id ='JSF_ddlItemGroup_ddl']");
		public By ItemName = By.xpath("//select[@id = 'JSF_ddlItems_ddl']");
		public By ItemDesption = By.xpath("//input[@id ='JSF_txtJewelDescription_txt']");
		public By ItemQty = By.xpath("//input[@id ='JSF_txtItemQty_txt']");
		public By StoneWeight = By.xpath("//input[@id ='JSF_txtStoneWeight_txt']");
		public By PurityTest = By.xpath("//input[@id ='JSF_Repeater1_ctl01_chkpuritytest']");
		public By ItemWeight  = By.xpath("//input[@id ='JSF_txtItemWeight_txt']");
		public By DirtWeight = By.xpath("//input[@id ='JSF_txtDirtWeight_txt']");
		public By EnterPurity = By.xpath("//input[@id ='JSF_txtPurity_txt']");
		public By AddBtn = By.xpath("//input[@id ='JSF_btnGoldAdd']");
		public By Appraiser = By.xpath("//select[@id = 'JSF_rdlAppraiser_ddl']");
		public By SubmitBtn = By.xpath("//input[@id ='btnSubmit']");
		public By SanctionedAmount = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstLoanDetails_ctrl0_LDF_txtSactAmt_txt']");
		public By GetValues = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstLoanDetails_ctrl0_LDF_btnGetROI']");
		public By TransModeCash = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_ddlTransactionMode_ddl']");
		public By PayAmount = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstLoanDetails_ctrl0_LDF_txtPayAmount_txt']");
		public By CashRemarks = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_txtRemarks_txt']");
		public By SubmitButton = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By TopUp = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ChkTopUp']");
		public By OkTopup = By.xpath("//input[@id ='closeSelopU']");
		public By TransCashID = By.xpath("//span[@id ='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By SummaryOperation = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By AuthorizeCancel = By.xpath("//body/form[@id='aspnetForm']/div[@id='divBody']/div[@id='navAlpha']/div/div/div[@id='outmost']/div[@id='scWrapper']/div[@id='scMenu']/div[@id='divGlossyMenuContent']/div[@class='submenu']/ul[@id='CreateMenu']/li[10]/div[1]");
		public By CashAuthorisation = By.xpath("//a[normalize-space()='Cashier Authorisation (CAAU)']");
		public By Refresh = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnRefresh']");
		public By TransactionIDField = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']");
		public By GoBTN = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnGo']");
		public By ManagerSelectCheckbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");
		public By SubmitButon = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By OpeningEntryCashCheckbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect']");
		public By CashAuthorizeBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By ManagerAuthorization = By.xpath("//a[normalize-space()='Manager Authorisation (MNAU)']");
		public By ManagerCheckBox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect']");
		public By ManagerAuthorize = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
		public By ClosePopup = By.xpath("//img[@id = 'closetop']");
		public By ItemAlready = By.xpath("//input[@id='close']");
		public By TrasID = By.xpath("//span[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By SummaryPage = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By TransferTab = By.xpath("//span[@id ='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']");
		//Post debit
		
		public By PostDebit = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstApproval_ctrl0_ucClosureApproval_btnAutoPost']");
		public By TransactionBased = By.xpath("//select[@id='ddlTrnsBased_ddl']");
		public By ProductGroupDropdown = By.xpath("//select[@id = 'ddlProductGroup_ddl']");
		public By ProductNameDropdown = By.xpath("//select[@id ='ddlProductName_ddl']");
		public By BranchName = By.xpath("//select[@id ='ddlBranch_ddl']");
		public By AccountNum = By.xpath("//input[@id ='txtChildAcNo_txt']");
		public By AmountField = By.xpath("//input[@id ='txtAmount_txt']");
		public By RemoveEntry = By.xpath("//a[@id ='lstContraEntry_ctrl0_lnkRemove']");
		public By AddButton = By.xpath("//input[@id='btnAdd']");
		public By SubButton = By.xpath("//input[@id='btnSubmit']");
		
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

    



}
