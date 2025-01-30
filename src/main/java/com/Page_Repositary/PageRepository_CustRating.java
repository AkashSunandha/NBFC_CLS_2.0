package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepository_CustRating {

	////*[@id="ctl00_CPH1_txtCustomerName_txt"]
	
	public By custID=By.xpath("//*[@id=\'ctl00_CPH1_txtCustomerId_txt\']");
	public By custName=By.xpath("//*[@id=\"ctl00_CPH1_txtCustomerName_txt\"]");
	public By goBtn=By.xpath("//*[@id=\'ctl00_CPH1_btnGo\']");
	public By saveBtn=By.xpath("//*[@id=\'ctl00_CPH1_btnSave\']");
	public By closeBtn=By.xpath("//*[@id=\'ctl00_CPH1_btnClose\']");
	public By cancelBtn=By.xpath("//*[@id=\'ctl00_CPH1_btnCancel\']");
	
	public By cust=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
	public By custRat=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/ul/li[8]/a");
	public By pageName=By.xpath("//*[@id=\'ctl00_MasterCaption\']");
	public By srhBtn=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/a/img");
	public By name_popup=By.id("PopQuick1 _txtName");
	
	//New Windows
	public By cust_search_btn = By.xpath("//input[@id='PopQuick1_btnSearch']");
	public By custID_popup=By.id("PopQuick1_txtCustID");
	public By txt = By.xpath("(//*[@id='CustList']//td)[3]//span");
	public By custRating_custID=By.xpath("//td[contains(text(),'Cust ID')]");
	public By custRating_risk=By.xpath("//td[contains(text(),'Risk')]");
	public By warning_closeBtn=By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
	public By window_dropdown=By.xpath("PopQuick1_ddlBranch");	
	public By custRating_dropdown=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/div/table/tbody/tr[3]/td/div/table/tbody/tr/td/div/div/table/tbody/tr[2]/td[10]/div/a/img");
	public By currentRating=By.xpath("//span[@id='ctl00_CPH1_SectionCaption1_lblCaption']");
	public By newRating=By.xpath("//span[@id='ctl00_CPH1_SectionCaption2_lblCaption']");
	public By nodata=By.xpath("//span[@id='ctl00_CPH1_lblNoDataFound']");
	
	
	//new rating
	public By agency=By.xpath("//*[@id=\"ctl00_CPH1_ddlAgency_ddl\"]");
	public By rating=By.xpath("//*[@id=\"ctl00_CPH1_txtRating_txt\"]");
	public By date=By.xpath("//*[@id=\"ctl00_CPH1_txtDateFrom_txt\"]");
	public By remarks=By.xpath("//*[@id=\"ctl00_CPH1_txtRemarks_txt\"]");
	public By rating_saveBtn=By.xpath("//*[@id=\"ctl00_CPH1_btnSave\"]");
	public By successMessage=By.xpath("//*[@id=\"FloatingErrorMessageBoxTop\"]");
	public By rating_closeBtn=By.xpath("//*[@id=\"closetop\"]");
	
	
}
