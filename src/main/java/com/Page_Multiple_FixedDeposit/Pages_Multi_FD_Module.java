package com.Page_Multiple_FixedDeposit;

import org.openqa.selenium.By;


public class Pages_Multi_FD_Module
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
		
		public By AccOpening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/div");
		public By DepositOpening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[1]/div");
		public By FixedDeposit = By.xpath("//li[contains(@class,'open')]//li[contains(@class,'open')]//div[contains(@class,'last symbol-close')]");
		public By FixedType2Years = By.xpath("//a[contains(text(),'DEBUNTURE FIXED TYPE 2 YRS')]");

		

		
		//Customer Search Window
		public By cust = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
		public By custSrch = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a/img");
		public By custName1 = By.xpath("//input[@id = 'PopQuick1_txtName']");
		public By SearchBtn = By.id("PopQuick1_btnSearch");
		public By SelectCust = By.id("PopQuick1_lst_ctrl0_linkSelect");
		public By SelectCustName = By.id("PopQuick1_lst_ctrl4_linkSelect");
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
		
		//Nominee Form
		public By NomineeCheckbox = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee']");
		public By SearchIcon = By.xpath("//a[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_btnPopup']");
		public By CustomerID = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomCust_ID_txt']");
		public By NameField = By.xpath("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomName_txt");
		public By RelationDropdown = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomRelation_ddl']");
		public By MobileNumber = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomMobileNo_txt']");
		public By HouseName = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomHouseName_txt']");
		public By Residence = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomResidence_txt']");
		public By District = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomDistrict_ddl']");
		public By Post = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomPost_ddl']");
		public By DOB = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_dtDOB_txt']");
		public By Age = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomAge_txt']");
		public By AddNomineeBtn = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_btnAddNominee']");
		public By NextButton = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnNext']");
		public By OperatorSearchIcon = By.xpath("//td[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_tdCustAdd']");
		public By OperatorRemark = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRemark_txt']");
		public By RelationDesig = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt']");
		public By OperatorAdd = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator']");
		public By OperatorNext = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnNext']");
		public By IntrestTransferCheckbox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_chkStandInst']");
		public By IntrestNextBtn = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_btnNext']");
		public By KeepSameAccount = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpAutoRenewal_MATFM_rdbSameAccount']");
		public By IsMultipleAccount = By.xpath("//input[@id ='chkIsMultipleAc']");
		public By MutipleAccountText = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_txtMultipleAc']");
		public By TransMode = By.xpath("//select[@id ='ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl']");
		public By SaveBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSave']");
		public By SelectProduct = By.xpath("//select[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlFromProduct_ddl']");
		public By AccountNumber = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAcNoF_txt']");
		public By Frequency = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtExeFrequency_txt']");
		public By Amount1 = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAmount_txt']");
		public By OkPopup = By.xpath("//span[normalize-space()='OK']");
		public By TransactionIDField = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt']");
		public By TrasID = By.xpath("//span[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
		public By GoBTN = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnGo']");
		public By SummaryPage = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[3]/table[1]");
		public By IntrestNextButton = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnNext']");
		public By AuthorizeCancel = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/div");
		public By ManagerAuthorization = By.xpath("//a[normalize-space()='Manager Authorisation (MNAU)']");
		public By Transfer = By.xpath("//span[@id = '__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer']");
		public By Refresh = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnRefresh']");
		public By OpeningEntryTransferCheckbox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");
		public By TransferAuthorizeBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
		public By Cash = By.xpath("//span[@id ='__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash']");
		public By CashAuthorisation = By.xpath("//a[normalize-space()='Cashier Authorisation (CAAU)']");
		public By OpeningEntryCashCheckbox = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect']");
		public By ManagerAuthorizen = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']");
		public By CashAuthorizeBtn = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
		public By CashSectionEntry = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect']");
		public By ManagerCheckBox = By.xpath("//input[@id ='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect']");
		public By ClosePopup = By.xpath("//img[@id = 'closetop']");
		public By ManagerSelectCheckBox = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect']");
		public By PostDebit = By.xpath("//input[@id = 'ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost']");
		public By TransactionBased = By.xpath("//select[@id='ddlTrnsBased_ddl']");
		public By GLName = By.xpath("//input[@id = 'hyjackText0']");
		public By GLNameList = By.xpath("/html/body/form/div[3]/div/table[1]/tbody/tr[6]/td[4]/div/div/div[2]/ul/li[5]");
		public By BalanceAmount = By.xpath("//input[@id = 'txtBalanceAmount_txt']");
		public By AmountTrans = By.xpath("//input[@id='txtAmountForGLHead_txt']");
		public By AddButton = By.xpath("//input[@id='btnAddGLAcHead']");
		public By SubmitButton = By.xpath("//input[@id='btnSubmit']");
		
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");

    



}
