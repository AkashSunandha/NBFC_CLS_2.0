package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpn_AccountSearch {

	public By accountOpeningTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Account Opening']/preceding-sibling::div");
	public By Search=By.xpath("//ul[@id='CreateMenu']//a[text()='Search']/preceding-sibling::div");
	public By AccountSearch=By.xpath("//ul[@id='CreateMenu']//a[text()='Account Search ']");
	
//	Acc Search Info
	
	public By GroupDropdown=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlSchema_ddl']");	
	public By SubGroupDropdown=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlGroup_ddl']");
	public By ProductDropdown =By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlProduct_ddl']");
	public By ProductddValue=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_ucddlProduct_ddl']//option[text()='PERSONAL LOAN WEEKLY ']");
	public By Name=By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_txtAccName']");
	public By SearchButton=By.xpath("//*[@value='Search']");
	public By ClearButton =By.xpath("//*[@id='ctl00_ctl00_CPH1_PRDCNT_PAS_Button1']");
	public By GetFirstAccName =By.xpath("(//table[@id='tblAccountList']//tbody//tr[2]//td[6]//span)[1]");
	public By HouseName=By.id("ctl00_ctl00_CPH1_PRDCNT_PAS_txtHouseName");
	public By AccNoField =By.id("ctl00_ctl00_CPH1_PRDCNT_PAS_txtAccNo");
	//table[@id='tblAccountList']//tbody//tr//td//input[@type='checkbox']
	
	
}
