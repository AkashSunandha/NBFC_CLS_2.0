package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Admin_Debenture_Issue_Setting {
	
	//Debenture Issue Setting
	
	public By Continuebtn = By.xpath("/html/body/div[1]/div[3]/div/button/span");
	public By Debenturesettings =By.xpath ("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
    public By DebentureIssuesetting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[2]/a");
    public By Debentureissuewindow = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[1]/div/div[1]");
    public By DebentureType =By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl");
    public By IssueName = By.id("ctl00_ctl00_CPH1_PRDCNT_txtIssueName_txt");
    public By IssueFromDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtIssueFromDate_txt");
    public By IssueToDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtIssueToDate_txt");
    public By UnitValue1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtUnitValue_txt");
    public By ReturnROI1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtReturnRoi_txt");
    public By CallDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtCallDate_txt");
    public By PutDate1 = By.id("ctl00_ctl00_CPH1_PRDCNT_txtPutDate_txt");
    public By CallDateROI = By.id("ctl00_ctl00_CPH1_PRDCNT_txtCallDatePrematureROI_txt");
    public By PutDateROI = By.id("ctl00_ctl00_CPH1_PRDCNT_txtPutDatePrematureROI_txt");
    public By ISActive = By.id("ctl00_ctl00_CPH1_PRDCNT_chkActive");
    public By AddButton = By.id("ctl00_ctl00_CPH1_PRDCNT_btnAdd");
    public By Save = By.id("ctl00_ctl00_CPH1_PRDCNT_btnsave");
    public By Addgrid = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td/table");
    public By Savegrid = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/table[5]/tbody/tr[1]/td/table");
    public By CancelPopup =By.xpath ("//*[@id=\"closetop\"]");
    public By Signout = By.xpath ("/html/body/form/div[3]/div[2]/a[5]/strong");
    public By loader =By.xpath("//div[@id=\"progressdiv\"]");
}
