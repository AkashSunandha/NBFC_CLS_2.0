package com.Page_GeneralOpening;

import org.openqa.selenium.By;

public class PageRepositary_GeneralOpening_Cash_Transfer {

	public By AccOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By GeneralOpenTab = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/div");
	public By Suspenseliability = By
			.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/ul/li[1]/div");
	public By Suspliability = By.xpath("//a[text()='SUSPENSE LIABILITY  (30001)']");
	public By custnameevisi = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]");
	public By clicksearch = By.xpath(
			"/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]/a");

	// Cust Informatiom
	public By Custname = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By Clickonsearch = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By Clickonselect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	public By ClickonADD = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer\"]");
	public By Customergrid = By.xpath("//*[@id=\"tblCustList\"]");

	// valid data

	public By enteropenamount = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt\"]");
	public By enteremarks = By.xpath(
			"//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtRemark_txt\"]");

	// transaction

	public By Opentransdropdown = By
			.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstOtherInfo_ctrl0_ucOtherInfoForm_ddlTransactionMode_ddl\"]");
	public By clickonsubmit = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");

	// Logout

	public By Singout = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	public By transIdd = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");

	// close X

	public By closesuccesmsg = By.xpath("//*[@id=\"closetop\"]");

	// accopening
	public By AO = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By GeneOp = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[4]/a");

	// click on postdebit

	public By PostDeb = By.xpath("//input[@value='Post Debit']");
	public By Sleecttransaction = By.xpath("//select[@class='DropRequiedField']");
	public By selectGLname = By.xpath("//input[@id='hyjackText0']");
	public By amount=By.xpath("//*[@id=\"txtAmountForGLHead_txt\"]");
	}
