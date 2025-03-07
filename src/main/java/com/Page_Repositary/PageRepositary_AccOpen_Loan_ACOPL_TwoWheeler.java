package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler {
	//public static final By Account_opening1 = null;


	
	//Account Opening window for Two Wheeler Loan (23027)
	
	public By Account_opening=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div") ;
	public By Loanopening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/div");
    public By LoanandAdvance = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[2]/ul/li[3]/div");
    public By TwoWheelerLoan = By.xpath("//*[text()='TWO WHEELER LOAN NEW  (23027)']");
    public By Depositaccountopeningwindow = By.id ("ctl00_ctl00_MasterCaption");
    
    // Customer Search Functionality
    
    public By Custidsearchbtn = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[8]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/a/img");
    public By CustomerNamesearch = By.id("PopQuick1_txtName");
   // public By custID=By.id("PopQuick1_txtCustID");
    public By CustomerSearchbtn = By.id("PopQuick1_btnSearch");
    public By selectcustomer =By.id("PopQuick1_lst_ctrl0_linkSelect"); 
    public By custid =By.id("ctl00_ctl00_CPH1_PRDCNT_LAI_txtCoCustID_txt");
    public By Addbutton=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1\"]");
    public By Accountinfotab =By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_body");
   
    
    //Fill Account Info Tab
    public By ResolutionNo=By.id("ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtResNo_txt");
    public By EquitableMortRegNo =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpAccInfo_lstProductLoan_ctrl0_LAF_txtEquitableMortgagerRegNo_txt\"]");
    public By EMRDate = By.xpath("//*[@id=\"__LASTFOCUS\"]");
    //public By ReferredBy = By.id("hyjackText0");
	
		
		
	
}



