package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Application {
	
	public By Debenture = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture']/preceding-sibling::div");
	public By DebentureApplication = By.xpath("//a[text()='Debenture Application ']");
	public By DebentureAppWindow = By.id("ctl00_ctl00_MasterCaption");
	public By Branch = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlBranches_ddl']/option[@selected='selected']");
	public By UserBranchName = By.id("ctl00_ctl00_lblBranch");
	public By ApplicationDate = By.id("ctl00_ctl00_CPH1_PRDCNT_dtApplication_txt");
	public By Date = By.id("ctl00_ctl00_lblHeaderDate");
	public By DebType = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl");
	public By IssueType = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlIssueType_ddl");
	public By series = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDebentureSeries_ddl");
	public By Category = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlCategory_ddl");
	//public By CustIDsearch = By.id("ctl00_ctl00_CPH1_PRDCNT_txtCustomerId_txt");
	public By CustIDsearch = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[6]/table/tbody/tr/td[2]/a/img");
	public By CustName = By.id("PopQuick1_txtName");
    public By Nature = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlNature_ddl\"]//option[@selected='selected']");
    public By Add = By.id("ctl00_ctl00_CPH1_PRDCNT_btnAddCustomer");
    public By customersearch = By.id("PopQuick1_btnSearch");
    public By selectcustomer = By.id("PopQuick1_lst_ctrl0_linkSelect");
    
    //Account Info
    public By UnitValuetextbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtUnitValue_txt");
    public By Noofunit = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtNoUnit_txt");
    public By GetValue = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_btnGet");
    public By TotalValue = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtTotal_txt");
    public By ROI =By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtRoi_txt");
    public By DPName = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_ddldpName_ddl");
    public By DematACNOsmalltextbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtDematFromAcNo_txt");
    public By DemateAcNolargetextbox =By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtDematAcNo_txt");
    public By IntRepayMode = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtRepayMode_txt");
    public By MaturityValue = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtMaturity_txt");
    public By Referred = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_ddlReferedBy_ddl");
    
    //Nominee tab
    public By NomineeTab = By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_TabContainer1_tpNominee");
    public By Unticknomineecheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_tpNominee_chkNominee");
    public By Nomineesearchicon = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_tpNominee_NF1_btnPopup");
    public By NomineeName1 = By.id("PopQuick1_txtName");
    public By Nomineesearchbtn = By.id("PopQuick1_btnSearch");
    public By Nomineeselect = By.id("PopQuick1_lst_ctrl0_linkSelect");
    public By NomineeAdd = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_tpNominee_NF1_btnAddNominee");
    public By NomineeRelation = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_tpNominee_NF1_ddlNomRelation_ddl");
    
    //Internet Transfer Tab
    public By InterestTransfer = By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel3");
    public By Interestrequiredcheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel3_chkIntrestTransferRequired");
    public By Clickinteresttranscheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel3_chkIntrestTransferRequired");
    public By ExternalAccountcheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel3_chkExternal");
    public By Externalaccountgridcheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel3_lstInvAccountList_ctrl0_chkInvAccountList");
    public By Transmodecash = By.id("ctl00_ctl00_CPH1_PRDCNT_AIF1_ddlTransMode_ddl");
    public By Save = By.id("ctl00_ctl00_CPH1_PRDCNT_btnSave");
    public By SummaryTranscid = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
    public By Printvoucher = By.id("ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1");
    public By signout = By.xpath("//*[text()='Signout']");
    
	//Login with Another User
	public By loginUserName1 = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd1 = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton1 = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By Newloginvalidate=By.id("ctl00_ctl00_lblUser");
    
	
	//Cashier Authorization - Cash Tab
		
		public By Authorizecanceltab = By.xpath("//ul[@id='CreateMenu']//a[text()='Authorize & Cancel']/preceding-sibling::div");
		public By cashierauthorize = By.xpath("//a[text()='Cashier Authorisation (CAAU)']");
		public By Transacidtextbox =By.id("ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt");
		
		public By transacid = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
		public By ClickGo =By.id("ctl00_ctl00_CPH1_PRDCNT_btnGo");
		public By Refresh=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
		public By checkboxselect1=By.id("ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect");
		public By Authorizebtn=By.id("ctl00_ctl00_CPH1_PRDCNT_btnSubmit"); 
		public By successpopup1=By.id("ctl00_ctl00_lblErrorMessage");
		public By cancelpopup=By.id("closetop");
		
		//Manager Authorization - Cash Tab
				
		public By ManagerAuthorization = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
		        public By Refresh1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
				public By cashtab=By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash");
				public By cashdetails=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_lblBatchID");
				public By managerClickGo =By.id("ctl00_ctl00_CPH1_PRDCNT_btnGo");
				public By checkboxselect11=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect");
				
				public By Transactid1 = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
				public By Authorizebutton1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnOtherPass");
				public By successpopup11=By.id("ctl00_ctl00_lblErrorMessage");
				public By cancelpopup1=By.id("closetop");
    
				//Transfer flow
				public By TransmodeTransfer = By.id("ctl00_ctl00_CPH1_PRDCNT_AIF1_ddlTransMode_ddl");
				public By postdebit =By.id("ctl00_ctl00_CPH1_PRDCNT_AIF1_btnAutoPost");
				
				//Autoposting Window
				public By TransactionBasedaccount = By.id("ddlTrnsBased_ddl");
				public By Productgroup = By.id("ddlProductGroup_ddl");
				public By ProductName = By.id("ddlProductName_ddl");
				
				
				public By Branchfiled =By.id("ddlBranch_ddl");

				public By Accountsearchicon = By.xpath ("/html/body/form/div[3]/div/table[1]/tbody/tr[4]/td[4]/a/img");
				public By Group = By.id("ucddlSchema_ddl");
				public By BranchTVM = By.id("ddlBranch");
				public By Product = By.id("ucddlProduct_ddl");
				public By Accountsearchbutton = By.id("btnSearch");
				//public By selectaccount = By.id("lstAccount_ctrl0_btnView");
				public By selectaccount = By.id("lstAccount_ctrl9_btnView");
				public By Balance_Amount =By.id("txtBalAmount_txt");
				public By AutopostingAmount = By.id("txtAmount_txt");
				public By Addbtn = By.id("btnAdd");
				public By submit = By.id("btnSubmit");
				public By savebtn = By.id("ctl00_ctl00_CPH1_PRDCNT_btnSave");
				public By Summarytransfer = By.id("ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption");
				public By transfercheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl0_chkSelect");
				public By Transfertab = By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer");
				
				//Child popup window auto load
				public By DisplayName = By.id("txtDisplayName_txt");
				public By AccountNosmalltextbox = By.id("txtChildBGPAcNo_txt");
				public By AccountNolargetextbox = By.id("txtChildAcNo_txt");
				} 


				
				
				
    



