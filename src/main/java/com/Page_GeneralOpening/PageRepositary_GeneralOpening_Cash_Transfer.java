
package com.Page_GeneralOpening;

import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class PageRepositary_GeneralOpening_Cash_Transfer {

	public By AccOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By GeneralOpenTab = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[4]/div");
	public By Suspenseliability = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[4]/ul/li[1]/div");
	public By Suspliability = By.xpath("//a[text()='SUSPENSE LIABILITY  (30001)']");
	public By custnameevisi = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]");
	public By clicksearch = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a");

	// Cust Informatiom
	public By Custname = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By Clickonsearch = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By Clickonselect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By ClickonADD = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer\"]");
	public By Customergrid = By.xpath("//*[@id=\"tblCustList\"]");

	// valid data

	public By enteropenamount = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt\"]");
	public By enteremarks = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtRemark_txt\"]");

	// transaction

	public By Opentransdropdown = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_ucOtherInfoForm_ddlTransactionMode_ddl\"]");
	public By clickonsubmit = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");

	// Logout

	public By Singout = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	public By transIdd = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");

	// close X

	public By closesuccesmsg = By.xpath("//*[@id=\"closetop\"]");

	// accopening
	public By AO = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By GeneOp = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/a");

	// click on postdebit

	public By PostDeb = By.xpath("//input[@value='Post Debit']");
	public By clickonacc = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By Sleecttransaction = By.xpath("//select[@class='DropRequiedField']");
	public By selectGLname = By.xpath("//*[@id=\"hyjackText0\"]");
	public By add = By.xpath("/html/body/form/div[3]/div/table[1]/tbody/tr[6]/td[4]/div/div/div[2]/ul/li[5]");
	public By amount=By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	public By clicksubmit= By.xpath("//*[@id=\"btnSubmit\"]");
	public By clickaddbutton= By.xpath(" //*[@id=\"btnAddGLAcHead\"] ");
	public By clicksaves= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By visible= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_ucOtherInfoForm_lblTransMode\"]");
	public By errorPopUpCloseIcon = By.xpath("//*[@id=\"closetop\"]");
	public By Transid =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl1_lbllstTransID\"]");
	
	public By accountOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By loanOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/div");
	public By loanAndAdvancesTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/div");
	public By personalLoanWeeeklyTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/ul/li[1]/a");
	
	//Account Info
	public By aciCustSearchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
	public By popUpWndNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpWndSearchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpWndSelectBtn = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By aciCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt\"]");
	public By aciAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
	public By aciCustDetailsGrid = By.xpath("//*[@id=\"tblCustViewList\"]");
	public By aciPrvOkBtn = By.xpath("/html/body/div[4]/div[3]/div/button/span");
	public By aciResolutionNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt\"]");
	public By aciResolutionDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtResDate_txt\"]");
	public By aciReferedByDropdown = By.xpath("//*[@id=\"hyjackText0\"]");
	public By aciDropdownOption = By.xpath("//li[@val='101000006511']");
	public By aciMortgagerRegNoTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtEquitableMortgagerRegNo_txt\"]");
	public By invalidDatePopUp = By.xpath("/html/body/form/table[4]/tbody/tr[1]/td[4]/div/img");
	public By aciEMRDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtEMRDate_txt\"]");
	public By aciRandomTxt = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/div[1]/div/div[2]/div[1]/div/table/tbody/tr[11]/td[1]");
	public By aciAgentCodeTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentCode_txt\"]");
	public By aciAgentNameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentName_txt\"]");
	public By aciDSACodeTextBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSACode_txt\"]");
	public By aciDSANameTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSAName_txt\"]");
	public By invalidCodePopUpOkBtn = By.xpath("//*[@id=\"close\"]");
	public By aciReamrkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtRemark_txt\"]");
	public By nextBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	
	//Personal Sureties
	public By psPersonalSuretiesTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel\"]");
	public By psCustSrchIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/div[1]/div/div[2]/div[2]/div/div[2]/div[5]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By psCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtPRCust_ID_txt\"]");
	public By psOffNameIcon = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[9]/div[1]/div/div[2]/div[2]/div/div[2]/div[5]/div/table/tbody/tr[3]/td[2]/a/img");
	public By psOffNameOption = By.xpath("//a[@title='MALAPPURAM']");
	public By psSalaryCertCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_chkSalaryCert\"]");
	public By psBasicPayTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtBasicPay_txt\"]");
	public By psNetSalaryTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtNetSalary_txt\"]");
	public By psRetdDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_dtRetdDate_txt\"]");
	public By psReamrksTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_txtRemarks_txt\"]");
	public By psAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpPersonel_ucPersonal_btnSPAdd\"]");
	public By psPopUpOkBtn = By.xpath("/html/body/div[1]/div[3]/div/button/span");
	public By psPersonalSecuGrid = By.xpath("//*[@id=\"tblPersonalSecurity\"]");
	
	//Nominee
	public By nNomineeNotReqCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee\"]");
	public By nNomineeCustSrchIcon = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup\"]");
	public By nRelationDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl\"]");
	public By nAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee\"]");
	public By nNomineeDetailsGrid = By.xpath("//*[@id=\"tblNomineeItemsList\"]");
	public By nCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomCust_ID_txt\"]");
	public By npreviousOverDueLoanPopUpOkBtn = By.xpath("//span[text()='OK']");

	//Loan Details
	public By ldGetValues = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI\"]");
	public By ldLimitTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt\"]");
	public By ldROITxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtROI_txt\"]");
	public By ldAmountTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtInstAmount_txt\"]");
	public By ldTransModeDropdown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl\"]");
	public By ldSaveBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By ldPostCreditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_btnAutoPost\"]");
	public By ldTransBasedDropdown = By.xpath("//*[@id=\"ddlTrnsBased_ddl\"]");
	public By ldGLNameTxtBox = By.xpath("//*[@id=\"hyjackText0\"]");
	public By ldGLAccCodeTxtBox = By.xpath("//*[@id=\"txtGLAcCode_txt\"]");
	public By ldGLNameOption = By.xpath("//li[@val=50 and text()='AL INTEREST']");
	public By ldBalanceAmtTxtBox = By.xpath("//*[@id=\"txtBalanceAmount_txt\"]");
	public By ldAmntTxtBox = By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	public By ldAddBtn = By.xpath("//*[@id=\"btnAddGLAcHead\"]");
	public By ldSubmitBtn = By.xpath("//*[@id=\"btnSubmit\"]");
	
	//Summary
	public By sSimilarDataExistsPopUpOkBtn = By.xpath("/html/body/form/div[14]/div[3]/div/button[1]/span");
	public By sTransId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	public By sPrintBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
	public By sTransferTab = By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer\"]");
	public By errorPopUpOkBtn = By.xpath("/html/body/div[3]/div[11]/div/button[1]/span");
//	public By variable = By.xpath("");
	public By ldAutoPostingGrid = By.xpath("//*[@id=\"tblContra\"]");
	public By errorPopUpCloseIcon1 = By.xpath("//*[@id=\"closetop\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");

}