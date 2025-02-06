package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccountOpening_FixedDeposit {

	//PC Registration
	public By formName = By.xpath("//*[@id='Username']");
	public By formBranchName = By.xpath("//select[@id='ddlBranches']/option[text()='TRIVANDRUM']");
	public By formComputerName = By.xpath("//*[@id=\"MacName\"]");
	public By formSubmitBtn = By.xpath("/html/body/div[2]/div[11]/div/button/span");
	
	//Login Module
	public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By logoutMsg = By.xpath("//*[@id=\"logMessage\"]");
	public By logoutOk = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
		

	
	//Deposit Opening window
	
	public By Accountopening=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div") ;
	public By Depositopening= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[1]/div");
	public By FixedDeposit=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[1]/ul/li/div");
	public By Bondcumulativetpe=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[1]/ul/li/ul/li[1]/a");
	public By Depositwindow=By.id("ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_txtProduct_txt");
	
	//CustmerID search
	public By customerIDsearchbutton=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a/img") ;
	public By custID=By.id("PopQuick1_txtCustID");
	public By searchbutton=By.id("PopQuick1_btnSearch");
	public By selectcust=By.id("PopQuick1_lst_ctrl0_linkSelect");
	//public By formcustid=By.id("ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_txtCustomerId_txt");
	public By Addbutton=By.id("ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer");
	public By okbutton=By.className("ui-button-text");
	public By customerform=By.xpath("//*[@id=\"Cust_ID\"]");
	
	//Entering Amount 
	public By amount=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtAcOpeningAmount_txt");
	
	//Entering Duration
	public By duration=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtDuration_txt");
	public By durationmode=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlDurationMode_ddl");
	
	//selecting ReferenceBy
	public By Referenceby=By.xpath("//*[@id=\"hyjackText0\"]");
	public By optionNithin = By.xpath("//li[text()='NITHIN']");
	
	//clicking on Getvalues
	public By getvalue=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI");
	public By popup=By.id("closewarning");
	public By ROI=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtROI_txt");
	public By Maturityvalue=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtMaturityValue_txt");
	
	
	//Mode operation display single
	//public By Modeofoperation=By.xpath("//select[@title='Mode Of Operation']");
	public By Modeofoperation=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_ddlModeOfOperationCode_ddl");
	
	//selecting join
//public By Naturedropdown=By.id("ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_ddlNature_ddl");
//public By okbutton=By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");
	
	
	//selecting Ledger & Folino
	public By ledgerno=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLedgerNo_txt");
	public By Foliono=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtFolioNo_txt");
	
	//Remark field
	public By remark=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtRemark_txt");
	
	//Lien Mark/Remark,Amount
	public By lienmark=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_chkIsLienMark");
	public By lienamount=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLienAmount_txt");
	public By lienremark=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_txtLienRemark_txt");
	
	//clicking on next button
	public By Nextbutton=By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
	
	//Adding Nominee
	public By Nomineecheck=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_chkNominee");
	
	//Nominee CustmerID search
		public By NomineecustomerIDsearchbutton=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img") ;
		public By NomineecustID=By.id("PopQuick1_txtCustID");
		public By Nomineesearchbutton=By.id("PopQuick1_btnSearch");
		public By Nomineeselectcust=By.id("PopQuick1_lst_ctrl0_linkSelect");
		public By Nomineecustiddetail=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomCust_ID_txt");
		
		public By Adharno=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtAdhaarNo_txt");
		public By HouseName=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomHouseName_txt");
		public By District=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomDistrict_ddl");
		public By DOB=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_dtDOB_txt");
		public By Name=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomName_txt");
		public By Mobileno=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomMobileNo_txt");
		public By Post=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomPost_ddl");
		public By Age=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_txtNomAge_txt");
		public By NomineeRelation=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_ddlNomRelation_ddl");
		public By NomineeAddbutton=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpNominee_NF1_btnAddNominee");
		public By NextbuttonNominee=By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
		
	
	//Operator CustmerID search
		public By operatorcustomerIDsearchbutton=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[3]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img") ;
		public By OperatorcustID=By.id("PopQuick1_txtCustID");
		public By operatorsearchbutton=By.id("PopQuick1_btnSearch");
		public By operatorselectcust=By.id("PopQuick1_lst_ctrl0_linkSelect");
		public By operatorcustiddetail=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtCust_ID_txt");
		
		public By relation=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRelation_txt");
		public By remark1=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_txtRemark_txt");
		public By add=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_btnAddOperator");
		
		public By customeridvalidate=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tp3_OF1_lstAccOperator_ctrl0_OFV1_lblCust_ID");
		public By clicknext=By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
	
		
		//Interest transfer
		public By intertransfercheckbox=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_chkStandInst");
		public By Branch=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlBranch");
		public By product=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_ddlFromProduct_ddl");
		public By accountno=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAcNoF_txt");
		public By frequency=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtExeFrequency_txt");
		public By amount1=By.id("ctl00_ctl00_CPH1_PRDCNT_TC1_tpStandInst_ucStandInst_txtStandAmount_txt");
		public By nextclick1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
		
		
		
		//Maturity
		public By radiobutton=By.xpath("//*[text()='  Keep In Same Account']");
		public By transmode=By.id("ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl");
		public By savebutton=By.id("ctl00_ctl00_CPH1_PRDCNT_btnSave");
		public By summary=By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_tdPrdName");
		
		
		
	//Login with another user
		//logout
		public By signout = By.xpath("//*[text()='Signout']");

		
		//Login
		public By loginUserName1 = By.xpath("//*[@id=\"txtUserName_txt\"]");
		public By loginPasswrd1 = By.xpath("//*[@id=\"txtPassword_txt\"]");
		public By loginButton1 = By.xpath("//*[@id=\"imgbtnSubmit\"]");
		public By Newloginvalidate=By.xpath("//span[text()='mhatre']");
		//public By logoutMsg1 = By.xpath("//*[@id=\"logMessage\"]");
		//public By logoutOk1 = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
		
		//Cashier Authorization
		public By Authorizeandcanceltab=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/div");
		public By cashierauthorization=By.linkText("Cashier Authorisation (CAAU)");
		public By Refresh=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
		public By checkboxselect=By.id("ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect");
		public By Authorizebutton=By.id("ctl00_ctl00_CPH1_PRDCNT_btnSubmit");
		public By successpopup=By.id("ctl00_ctl00_lblErrorMessage");
		public By cancelpopup=By.id("closetop");
		
		//Manager Authorization - Cash Tab
		public By ManagerAuthorization=By.linkText("Manager Authorisation (MNAU)");
		public By Refresh1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
		public By cashtab=By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash");
		public By cashdetails=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_lblBatchID");
		public By checkboxselect1=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect");
		public By Authorizebutton1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnOtherPass");
		public By successpopup1=By.id("ctl00_ctl00_lblErrorMessage");
		public By cancelpopup1=By.id("closetop");
		
        //Deposit opening-Transfer
		//public By transmode1=By.id("ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_ddlTransMode_ddl");
		public By postdebit=By.id("ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_AIF1_btnAutoPost");
		public By autoposting_popup=By.id("ddlTrnsBased_ddl");
		
}


