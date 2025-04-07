package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Application {
	
	public By Debenture = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/div");
	public By DebentureApplication = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/ul/li[1]/a");
	public By DebentureAppWindow = By.id("ctl00_ctl00_MasterCaption");
	public By Branch = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlBranches_ddl");
	public By ApplicationDate = By.id("ctl00_ctl00_CPH1_PRDCNT_dtApplication_txt");
	public By DebType = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl");
	public By IssueType = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlIssueType_ddl");
	public By series = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDebentureSeries_ddl");
	public By Category = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlCategory_ddl");
	public By CustID = By.id("ctl00_ctl00_CPH1_PRDCNT_txtCustomerId_txt");
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
    


}
