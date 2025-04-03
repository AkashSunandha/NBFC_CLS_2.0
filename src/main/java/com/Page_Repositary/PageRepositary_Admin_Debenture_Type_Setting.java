package com.Page_Repositary;
import org.openqa.selenium.By;

public class PageRepositary_Admin_Debenture_Type_Setting {
	
	// Debenture Type Settings
	
	
	public By popcontinue =By.className("ui-button-text");
	public By Continuebtn = By.xpath("/html/body/div[1]/div[3]/div/button/span");
	public By cancelcontinuepopup = By.xpath("/html/body/div[1]/div[1]/a/span");
	public By Debenturesettings =By.xpath ("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
	public By DebentureTypeSetting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/a");
	public By DebentureTypeWindow = By.xpath ("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[1]/div/div[1]");
	
	//Debenture Type Setting Window
	public By Productgroup = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlProductGroup_ddl");
	public By TypeName = By.id("ctl00_ctl00_CPH1_PRDCNT_txtTypeName_txt");
	public By Amount = By.id("ctl00_ctl00_CPH1_PRDCNT_txtAmount_txt");
	public By Durationbox = By.id("ctl00_ctl00_CPH1_PRDCNT_txtDuration_txt");
	public By SelectDuration = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlDurationMode_ddl");
	public By Minimumunits = By.id("ctl00_ctl00_CPH1_PRDCNT_txtMinNoOfUnits_txt");
	public By Maximumunits = By.id("ctl00_ctl00_CPH1_PRDCNT_txtMaxNoOfUnits_txt");
	public By Transmodecash =By.id("ctl00_ctl00_CPH1_PRDCNT_ddlTransMode_ddl");
	public By InterestCalculationMethod = By.id("ctl00_ctl00_CPH1_PRDCNT_ddlIntCalc_ddl");
	public By save =By.id("ctl00_ctl00_CPH1_PRDCNT_btnAdd");
	public By Addgrid = By.id("ctl00_ctl00_CPH1_PRDCNT_SectionCaption1_lblCaption");
	public By cancelpopup =By.xpath("//*[@id=\"closetop\"]");
	public By Signout = By.xpath("/html/body/form/div[3]/div[2]/a[5]/strong");
}
