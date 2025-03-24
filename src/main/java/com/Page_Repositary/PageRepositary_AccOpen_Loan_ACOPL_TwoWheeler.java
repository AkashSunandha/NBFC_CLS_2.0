package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler {
	//public static final By Account_opening1 = null;


	
	//Account Opening window for Two Wheeler Loan (23027)
	
	public By Account_opening=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div") ;
	public By Loanopening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/div");
    public By LoanandAdvance = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/div");
    public By TwoWheelerLoan = By.xpath("//*[text()='TWO WHEELER LOAN NEW  (23027)']");
    public By Depositaccountopeningwindow = By.id ("ctl00_ctl00_MasterCaption");
    
    // Customer Search Functionality
    
    public By Custidsearchbtn = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
    public By CustomerNamesearch = By.id("PopQuick1_txtName");
   // public By custID=By.id("PopQuick1_txtCustID");
    public By CustomerSearchbtn = By.id("PopQuick1_btnSearch");
    public By selectcustomer =By.id("PopQuick1_lst_ctrl0_linkSelect"); 
    public By custid =By.id("ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt");
    public By Addbutton=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
    public By okbutton=By.className("ui-button-text");
    public By Accountinfotab =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_body");
   
    
    //Fill Account Info Tab
    public By ResolutionNo=By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt");
    public By ResolutionDate = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtResDate_txt");
    public By Referedby = By.id("hyjackText0");
    public By optionPradeep = By.xpath("//li[@val='101000002433']");
    public By Popupnull =By.id("closeValurc");
    public By CanvasserName =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_ddlCanvasserName_ddl");
    public By EquitableMortRegNo1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtEquitableMortgagerRegNo_txt");
    public By CanvasserCode =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtCanvasserCode_txt\"]");

    
    public By EMRDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtEMRDate_txt");
    public By Agentcode1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentCode_txt");
    public By AgentName = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtAgentName_txt");
	public By DSAcode1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSACode_txt");
	public By DSAName = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtDSAName_txt");
	public By Nextbtn = By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
	
	//Securities Tab
	
	public By Vehicleno1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtVehNo_txt");
	public By RCno1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtRCNo_txt");
	public By Vehiclestatus =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_ddlUsedOrNew_ddl");
	public By VehicleType = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_ddlVehType_ddl");
	public By VehicleDetails =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtVehDetails_txt");
	public By VehicleCategory =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_ddlVehicleCategory_ddl");
	public By Exshowroomprice1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtExShowPrice_txt");
	public By RoadTax1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtRoadTax_txt");
	public By Insurance1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtInsurance_txt");
	public By Registrationchargers =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtRegCharges_txt");
	public By DealerDiscount1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtDealerDiscount_txt");
	public By Getbtn = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_btnGet");
	public By Downpayment1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtDownPayment_txt");
	public By InsuranceDocNo1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtInsuranceDocNo_txt");
	public By Yearofmanufacture1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtYearOfManufacture_txt");
	public By IDV1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtIDV_txt");
    public By insuranceprovider = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_ddlInsuranceProvider_ddl");
    public By InsureduptoDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_dtInsuredUptoDate_txt");
    public By VehicleColor1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtColour_txt");
    public By RegDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_dtRegDate_txt");
    public By Registrationmode1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_ddlRegMode_ddl");
    public By PermitNo1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtPerminNo_txt");
    public By EngineNo1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtEngineNo_txt");
    public By chassisNo1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtChasisNo_txt");
    public By Dealer = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_rdlDealer_ddl");
    public By Onroad = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtOnRoadPrice_txt");
    public By Worth = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtVehicleWorth_txt");
    public By loader =By.xpath("//div[@id=\"progressdiv\"]");
    public By Subdealer =By.id ("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_rdlSubDealer_ddl");
    public By Make = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_rdlMake_ddl");
    public By Model = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_rdlModel_ddl");
    public By Variant1 =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtvariant_txt");
    public By RTOdetails = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_txtRTODetail_txt");
    public By purpose = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_rdlPurposeCode_ddl");
    public By InsuredPastdateokbtn = By.id("closeInsdat");
    public By AddBtn1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_btnVehADD");
    public By Addgrid =By.id("//td[text()='Ex.Show Room Price']");
   public By insuredfuturedate = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_dtInsuredUptoDate_txt");
   public By NextButton = By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
   public By clearinsureddate = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpVehicle_SVF_dtInsuredUptoDate_txt");
   
   //Nominee Details
   public By Nomineeuntick = By.id ("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_chkNominee");
  // public By customersearchicon = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomCust_ID_txt");
   public By customersearchicon =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnPopup");
   public By custid1 =By.id ("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_txtNomCust_ID_txt");
   public By Relation =By.id ("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_ddlNomRelation_ddl");
   public By Addbutton1 = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpNominee_NF1_btnAddNominee");
   public By NextButton1 = By.id("ctl00_ctl00_CPH1_PRDCNT_btnNext");
   
  // Loan Details
   public By sanctioned = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtSactAmt_txt");
   public By NoOfInstallment =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtNoOfInst_txt");
   public By Getvalue = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_btnGetROI");
   public By ROI = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtROI_txt");
   public By RepaystartDate = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_dtRepaymentStartDate_txt");
   public  By LoandetailsAmount = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtInstAmount_txt");
   public By Duedate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_dtDueDate_txt\"]");
   public By Payamount = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt");
   public By Netpayabale = By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtTotal_txt");
   public By Transmode = By.id ("ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_LIF1_ddlTransactionMode_ddl");
   public By Save = By.id("ctl00_ctl00_CPH1_PRDCNT_btnSave");
   public By existingloanokpopup = By.xpath("/html/body/div[3]/div[11]/div/button[1]/span");
   public By similardatapopup =By.xpath("/html/body/form/div[14]/div[3]/div/button[1]/span");
  //public By randomTxt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_dtOpenDate_txt\"]");
  // public By randomTxt2 = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtEligibility_txt\"]");
  public By cashtransactionid = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
   public By Cashsummary =By.id("ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_topdiv");
  
   
	//Login with another user
	//logout
	public By signout = By.xpath("//*[text()='Signout']");

	
	//Login
	public By loginUserName1 = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd1 = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton1 = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By Newloginvalidate=By.id("ctl00_ctl00_lblUser");
	//public By logoutMsg1 = By.xpath("//*[@id=\"logMessage\"]");
	//public By logoutOk1 = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
	
	//Cashier Authorization
	public By Authorizecanceltab=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]/div");
	public By cashiersauthorize=By.linkText("Cashier Authorisation (CAAU)");
	public By Transacidtextbox =By.id("ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt");
	public By transacid = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
	//public By TransactionIDtext = By.id ("ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt");
	public By ClickGo =By.id("ctl00_ctl00_CPH1_PRDCNT_btnGo");
	public By Refresh=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
	public By checkboxselect1=By.id("ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect");
	public By Authorizebtn=By.id("ctl00_ctl00_CPH1_PRDCNT_btnSubmit"); 
	public By successpopup1=By.id("ctl00_ctl00_lblErrorMessage");
	public By cancelpopup=By.id("closetop");
	
	//Manager Authorization - Cash Tab
			public By ManagerAuthorization=By.xpath("//a[text()='Manager Authorisation (MNAU)']");
			public By Refresh1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnRefresh");
			public By cashtab=By.id("__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash");
			public By cashdetails=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_lblBatchID");
			public By managerClickGo =By.id("ctl00_ctl00_CPH1_PRDCNT_btnGo");
			public By checkboxselect11=By.id("ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect");
			public By Transactid1 = By.id("ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID");
			public By Authorizebutton1=By.id("ctl00_ctl00_CPH1_PRDCNT_btnOtherPass");
			public By successpopup11=By.id("ctl00_ctl00_lblErrorMessage");
			public By cancelpopup1=By.id("closetop");
	
}





