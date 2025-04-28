package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepository_DebentureInterestAdjustment {
	
	
    public By loader =By.xpath("//div[@id=\"progressdiv\"]");
	
	public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/a");
	
	public By Debenture = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture']/preceding-sibling::div");
	
	public By DebentureInterestAdjustment = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture InterestAdjustment ']//preceding-sibling::div//following-sibling::a");
	
	public By DropdownofDebenureType = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl']");
	
	public By DebentureType = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl']//following-sibling::option[@value='90068']");
	
	public By DropdownofDebentureIssue = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureIssue_ddl']");
	
	public By DebentureIssue = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureIssue_ddl']//option[@value='66']");
	
	public By DropdownofDebentureSeries = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureSeries_ddl']");
	
	public By DebentureSeries = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlDebentureSeries_ddl']//option[@value='2063']");
	
	public By search = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnSearch']");
	
	public By AccountNofield = By.xpath("//table[@class='tablescroll_head']//tr//td[2]");
	
	public By NameField = By.xpath("//table[@class='tablescroll_head']//tr//td[3]");
	
	public By ToAccountNoField = By.xpath("//table[@class='tablescroll_head']//tr//td[4]");
	
	public By ToBankField = By.xpath("//table[@class='tablescroll_head']//tr//td[5]");
	
	public By BankName = By.xpath("//table[@class='tablescroll_head']//tr//td[6]");
	
	public By AmountField = By.xpath("//table[@class='tablescroll_head']//tr//td[7]");
	
	public By Process = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnProcess']");
	
	public By NoAccountsProcessed = By.xpath("//table[@id='tblStanding']//tr[2]");
	
	public By close = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnClose']");
	
	
	
	
}
