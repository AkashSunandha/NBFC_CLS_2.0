package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AgentTransfer {
	
	

	
	//Relative Xpath for Agenttransfer
	
	public By clickonAgenttransfer = By.xpath("//ul[@id='CreateMenu']//a[text()='AgentTransfer']/preceding-sibling::div");
	public By agentTransfer= By.xpath("//a[text()='Agent Transfer ']");
	
	public By Agenttransfe = By.id("ctl00_ctl00_CPH1_PRDCNT_ucSearchHead_lblCaption");
	
	//public By clickonAgenttransfer = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[4]");
	//public By agentTransfer = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[4]/ul/li[2]/a");
	public By clicktransfer = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkProcessSingleAccount\"]");
	public By SelectOtherloan = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProductGroup_ddl\"]");
	public By selectproname = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProduct_ddl\"]");
	public By StoreAccunt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAcNo_txt\"]");
	public By selectallproduct = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProducts_ctrl0_chkProduct\"]");
	public By selectallarea = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstArea_ctrl0_chkArea\"]");

	public By visible = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[4]/td/span/label");
	public By clickagent = By.xpath("//*[@id=\"hyjackText0\"]");
	public By seecltagentcode = By.xpath("//*[@id=\"hyjackText0\"]");
	public By clickdhanya = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/div/div[2]/ul/li[2]");

	public By clickshow = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnShow\"]");

	public By agentnamecode = By.xpath("//*[@id=\"hyjackText1\"]");
	public By selectname = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[7]/td/table[1]/tbody/tr[3]/td[2]/div/div/div[2]/ul/li[3]");
public By clickofAC = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAgentTransferDetails_chkAlAgentTrnsferlv\"]");
public By downarrow = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_imgbtnAdd\"]");
public By AllAC = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_chkAllInEx\"]");
public By clicktransfer1= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnTransfer\"]");

//accout

public By clickongo = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
public By clickonshow= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnShow\"]");

public By Cancelpopup = By.id ("closetop");
public By Accountnumbertextbox = By.id("ctl00_ctl00_CPH1_PRDCNT_txtAcNo_txt");
public By  Agentname = By.id("hyjackText1");
public By tickcheckbox = By.id("ctl00_ctl00_CPH1_PRDCNT_lstAgentTransferDetails_ctrl0_chkAgentTrnsferlv");
public By clicksingletransfer = By.id("ctl00_ctl00_CPH1_PRDCNT_btnTransfer");

}
