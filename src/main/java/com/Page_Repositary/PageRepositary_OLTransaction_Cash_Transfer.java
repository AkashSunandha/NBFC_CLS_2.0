
package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_OLTransaction_Cash_Transfer {
	
	public By ClickTransaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By clickTranswindow = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/a");
	
	
public By productname= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProduct_ddl\"]");
public By productgroup= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlProductGroup\"]");
public By transaccount = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt\"]");
public By selectcredit = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_ddlTrnType_ddl\"]");
public By clickGoo = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_btnGo\"]");
public By transamount = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt\"]");
public By selectcash= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_ddlTransactionMode_ddl\"]");
public By submittrans=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
public By scrolldwn= By.xpath("//*[@id=\"WorkArea\"]");
public By TransIID= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
public By clickprint=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
//transfer

public By Clickpostdeb= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_btnAutoPost\"]");
}
