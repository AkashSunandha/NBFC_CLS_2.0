package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Series {
	
	//Loader 
	public By loader = By.xpath("//div[@id=\"progressdiv\"]");
		
	//Continue button
	public By continueBtn = By.xpath("//span[text()='Continue']");
	
	//Connect to debenture
	public By debture = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
	public By debenture_Srs =By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[3]/a");
	
	//Debenture Issue Selection
	public By debenture_type =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl\"]");
		
	//Series Name Input
	public By debenture_issue =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDebentureIssue_ddl\"]");
	
    //Series Name_1 Input
	public By series_name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtSeriesName_txt\"]");
	
	//ISIN No Input Validation
	public By ISin =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtISINNo_txt\"]");
	
	//Interest Payment Method Selection
	public By Interest_Payment_Method =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlInterestPaymentMethod_ddl\"]");
	
	//ROI Input Validation
	public By Roi =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtROI_txt\"]");
	
	//GL Acc Code Dependency Loading
	public By Acc_code =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtGLAccCode_txt\"]");
	
	//int_GL Acc Code Dependency Loading
	public By Int_Acc_code =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtIntGlHeadName_txt\"]");
		
	//GL Acc Name Dependency Loading
	public By Acc_Name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtGLAccCode_txt\"]");
		
	//int_GL Acc Name Dependency Loading
	public By Int_Acc_Name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtIntGlHeadName_txt\"]");
			
		
}
