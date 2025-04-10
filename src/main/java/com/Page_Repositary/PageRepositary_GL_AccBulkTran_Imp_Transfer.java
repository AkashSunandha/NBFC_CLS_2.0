package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_GL_AccBulkTran_Imp_Transfer {
	
	
	
	public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/a");
	
	public By Others = By.xpath("//ul[@id='CreateMenu']//a[text()='Others']/preceding-sibling::div");
	
	public By DataSharing = By.xpath("//ul[@id='CreateMenu']//a[text()='Data Sharing']/preceding-sibling::div");
	
	public By GLAccBulkTranImp = By.xpath("//ul[@id='CreateMenu']//a[text()='GL A/c Bulk Transaction Excel Import ']//preceding-sibling::div//following-sibling::a");
	
	public By DownloadArrow = By.xpath("//a[@id='ctl00_ctl00_CPH1_PRDCNT_LnkDownload']");
	
	public By BrowseButton = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_updExcel']");
	
	public By Get = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnGet']");
	
	public By TransactionMode = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlTransactionMode_ddl']");
	
	public By Submit = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']");
	
	public By Tranfermode = By.xpath("//select[@id='ctl00_ctl00_CPH1_PRDCNT_ddlTransactionMode_ddl']//option[@value='2']");
	
	public By TransactionId = By.xpath("//span[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID']");
	
	public By NetAmount = By.xpath("//span[@id='ctl00_ctl00_CPH1_PRDCNT_lstXmlDetails_lblTotal']");
	
	public By Postdebit = By.xpath("//input[@id='ctl00_ctl00_CPH1_PRDCNT_btnAutoPost']");
	
	public By GLCode = By.xpath("//select[@id='ddlTrnsBased_ddl']//option[@value='2']");
	
	
}