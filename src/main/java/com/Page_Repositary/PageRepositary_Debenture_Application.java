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
    public By Nature = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlNature_ddl");
    public By Add = By.id("ctl00_ctl00_CPH1_PRDCNT_btnAddCustomer");
    public By customersearch = By.id("PopQuick1_btnSearch");
    public By selectcustomer = By.id("PopQuick1_lst_ctrl0_linkSelect");
    
    //Account Info
    public By UnitValue = By.id("ctl00_ctl00_CPH1_PRDCNT_TabContainer1_TabPanel1_txtUnitValue_txt");
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
    
    
    


}
