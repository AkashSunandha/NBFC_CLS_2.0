package com.Page_Repositary;
import org.openqa.selenium.By;

public class PageRepositary_BondTransfer 
{
	//Navigating to Bond Transfer page
	public By BondTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/div");
	public By BondtransferTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[21]/ul/li[3]/a");
	public By BondWindowTitle = By.xpath("//*[@id=\"ctl00_ctl00_MasterCaption\"]");
	
	//Click branch field value
	public By branchfield=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlBranch\"]");
	
	//check product field visibility
		public By productfield=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lblProductName\"]");
	
	//select product field value
	public By productfieldvalue=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlProductName_ddl\"]");
	
	//Select Account number field
	public By bankDetailsAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtAcno_txt\"]");
	
	//Click on submit
	public By bondsubmit= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By accinfo= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption\"]");
	
	
	//Click customer search icon
	public By custsearch= By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[4]/table/tbody/tr[1]/td[2]/a/img");
	
	//Customer search window
	public By custsearchwindow= By.xpath("//*[@id=\"UpdatePanel1\"]");
	
	//Enter customer name and number
		public By custsearchpopup = By.xpath("//*[@id=\"form1\"]");
		public By custnameTxtBox= By.xpath("//*[@id=\"PopQuick1_txtName\"]");
		public By custnumTxtBox= By.xpath("//*[@id=\"PopQuick1_txtCustID\"]");
		public By searchbutton= By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
		public By custdatagrid= By.xpath("//*[@id=\"PopQuick1_UP1\"]");
		
		public By selectcust= By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
		public By customeridfield= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtNewMenCustID_txt\"]");

		
		public By addcust= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAddCustomer\"]");
	
	//Enter remarks
		public By remarksTxtBox= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtRemarks_txt\"]");
		public By submit= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnAddMember\"]");
		public By summarypage= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_SectionCaption2_lblCaption\"]");
		public By useridTxtBox= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtUserId\"]");

		
		
	//Sign out
		public By signout= By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	//Navigate to Authorise --> manager --> other tab
		public By authtab= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/div");
	//Select manager authorisation
		public By managerauthtab= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[9]/ul/li[7]/a");
		public By managerauthpage= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucSectionCaption1_lblCaption\"]");

	//Click Others tab
		public By otherstab= By.xpath("//*[@id=\"__tab_ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers\"]");
	//Click Refresh tab
		public By refreshtab= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
		public By authdatas= By.xpath("//*[@id=\"tblCustList\"]");
	//searching with maker id
		public By makerid= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtMakerID_txt\"]");
		public By authgobutton= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	//select authorisation entry
		public By selectauthentry= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
		public By authbutton= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
		public By authsuccessmsg= By.xpath("//*[@id=\"FloatingErrorMessageBoxTop\"]");
	//success close button
		public By successclosebutton= By.xpath("//*[@id=\"closetop\"]");

		
		
	

}
