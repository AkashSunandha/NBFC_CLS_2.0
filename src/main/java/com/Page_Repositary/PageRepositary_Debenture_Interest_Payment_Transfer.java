
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Interest_Payment_Transfer {

	public By clickondebenture = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/div");
	public By clickdebpayment = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[20]/ul/li[7]/a");
	public By debtype = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureType_ddl\"]");
	public By clickonGo = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_btnGo\"]");
	public By clickonsearch = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_txtAcNo_txt\"]");
	public By accountnumber = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_txtAcNo_txt\"]");
	public By Issuetype = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlIssueType_ddl\"]");

	public By Series = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureSeries_ddl\"]");

	public By duration= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtDuration_txt\"]");
	
	public By months  = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDurationMode_ddl\"]");
	
	public By selecttransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureApprovinginfo_ddlTransMode_ddl\"]");

	public By selectpostdebit = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureApprovinginfo_btnAutoPost\"]");
	
	public By submmit= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	
	public By postdebAcno= By.xpath("//*[@id=\"txtChildAcNo_txt\"]");
	
	public By PostdebAmnt= By.xpath("//*[@id=\"txtAmount_txt\"]");
	
	public By Amt= By.xpath("//*[@id=\"txtBalAmount_txt\"]");
	
	public By PostDebAdd= By.xpath("//*[@id=\"btnAdd\"]");
	
	public By PostDebSubmit= By.xpath("//*[@id=\"btnSubmit\"]");
	
	
	
	
}
