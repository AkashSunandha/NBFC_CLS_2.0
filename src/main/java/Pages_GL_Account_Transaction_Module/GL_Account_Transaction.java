package Pages_GL_Account_Transaction_Module;

import org.openqa.selenium.By;


public class GL_Account_Transaction
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
		public By GLTransactions = By.xpath("//a[normalize-space()='GL A/c Transaction']");
		public By GLAccInfo = By.xpath("//div[@id='ctl00_ctl00_CPH1_PRDCNT_UPGLTransaction']//div[@class='iframebox']");
		public By Date = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_dtDate_txt']");
		public By Valuedate = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_dtValueDate_dtValueDate_txt']");
		public By Branch = By.xpath("//select[@ id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlBranch_ddl']");
		public By GLaccname = By.xpath("//input [@id = 'hyjackText0']");      
		public By GLacccode = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_txtGLCode_txt']");
		public By TransType = By.xpath("//Select[@id ='ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_ddlTrnType']");
		public By RefNo = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRefNo_txt']");
		public By AppManager = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlAppManager_ddl']");
		public By GoButton = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_GLTransactionAccInfo_btnGo']");
		public By PreTranCheckbox = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_chkLastN']");
		public By PreviousTrans = By.xpath("//div[@id='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_divLastNT']");
		public By TransAmt = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtTrnAmount_txt']");
		public By RecoveryTotal = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ucNonProductTransactionRecovery_txtRecoveryTotal_txt']");
		public By Netpayable = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ucNonProductTransactionRecovery_txtGrandTotal_txt']");
		public By TransMode = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_ddlTransactionMode_ddl']");
		public By PartyName = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtPartyName_txt']");
		public By Particulars = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_ucGLAcTransactionOtherInfo_txtRemarks_txt']");
		public By Submitbutton = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstCurrentBalance_ctrl0_btnSubmit']");
		public By SummaryOperation = By.xpath("(//div[@class='iframebox'])[4]");
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
