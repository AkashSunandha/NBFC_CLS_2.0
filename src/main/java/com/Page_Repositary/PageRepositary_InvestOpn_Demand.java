package com.Page_Repositary;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class PageRepositary_InvestOpn_Demand {

	public By loader =By.xpath("//div[@id=\"progressdiv\"]");
	
	public By accountOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/div");
	public By investmentOPeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[5]/div");
    public By demandOpeningTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[5]/ul/li/div");
	public By investmentAccountNewTab = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[5]/ul/li[5]/ul/li/ul/li/a");
   
	// Account opening
	public By selectbankdrop_down = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstInvAccInfo_ctrl0_INIO_ddlBank_ddl\"]");
	public By selectbranchdrop_down = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstInvAccInfo_ctrl0_INIO_ddlBranch_ddl\"]");
	public By addbutton = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstInvAccInfo_ctrl0_INIO_btnAddCustomer\"]");
	public By opendatecurser = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_dtOpenDate_txt\"]");
	
	// Investment Info
	public By acctatbranch= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtAccAtBranch_txt\"]");
	public By openamount= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtOpenAmount_txt\"]");
	public By roi= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtROI_txt\"]");
	public By principalglhead= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_ddlGLCodePrincipal_ddl\"]");
	public By interestglhead= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtGLCodeInterest_txt\"]");
	public By recieptno= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtSerialNo_txt\"]");
	public By depositname= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtDepositName_txt\"]");
	public By remarks= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtRemark_txt\"]");
	
	//	Next/Previous
	public By nextbutton= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnNext\"]");
	
	//	Operator
	public By customerid= By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By selectbutton= By.xpath("//*[@id=\"lst_ctrl0_linkSelect\"]");
	
	// Child window
	public By selectcustomer_id= By.xpath("//*[@id=\"lst_ctrl0_linkSelect\"]");
	
	// back to main screen
	public By relationdesignwindow= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp2_lstOperator_ctrl0_OPF_txtRelation_txt\"]");
	public By powerofattorney= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp2_lstOperator_ctrl0_OPF_chkIsPowerOfAttorney\"]");
	public By remarks_toentry= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp2_lstOperator_ctrl0_OPF_txtRemark_txt\"]");
	public By addbuttton_operator= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp2_lstOperator_ctrl0_OPF_btnAddOperator\"]");
	public By cancel_operator= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_IN1_tp2_lstOperator_ctrl0_OPF_btnOperatorCancel\"]");
	
	// Other info
	public By specialinformation= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_LIF_txtSpInstruction_txt\"]");
	public By appmanagaer= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_LIF_txtSpInstruction_txt\"]");
	public By transmode= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_LIF_ddlTransactionMode_ddl\"]");
    
	// Post credit
	public By batch= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_LIF_btnAutoPost\"]");
    
	//Child window_2
	public By postcredit= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstAcInfo_ctrl0_LIF_btnAutoPost\"]");
	//public By batch1= By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[5]/table/tbody/tr/td[2]/a/img");
	
	
	//Auto posting
	//public By productgroup= By.xpath("//*[@id=\"ddlProductGroup_ddl\"]");
	//public By productname= By.xpath("//*[@id=\"ddlProductName_ddl\"]");
	//public By amount1= By.xpath("//*[@id=\"txtAmount_txt\"]");
	//public By addbutton1= By.xpath("//*[@id=\"btnAdd\"]");
	//public By submit= By.xpath("//*[@id=\"btnSubmit\"]");
	
	
	//save & cancel
	public By savebutton= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	public By print= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnPrintSingleVr1\"]");
	
	//trasanction ID
	public By transactionid1= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl0_lbllstTransID\"]");
	
	
	
	//signout
	public By signout= By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
	
	//signin authorise
	public By authorise= By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By password= By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By login= By.xpath("//*[@id=\"imgbtnSubmit\"]");
	
	public By authorisecancel= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[12]/div");
	
	// manager
	public By managerauthorise= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[12]/ul/li[4]/a");
	//public By refresh1= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By transactionid= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	public By go= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By select11= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorise1= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnOtherPass\"]");
			
	
	// for cashier
	public By cashier= By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[12]/ul/li[8]/a");
	public By refresh12= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnRefresh\"]");
	public By transactionionid2= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTransID_txt\"]");
	public By go1= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnGo\"]");
	public By select12= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl0_chkSelect\"]");
	public By authorise2= By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSubmit\"]");
	
	// for signout
//	public By updatedsuccessfully= By.xpath("//*[@id=\"closetop\"]");
//	public By signout1= By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
//			
		private void input(String string, String invalidacctatbranch) {
			// TODO Auto-generated method stub
			
		}
	
	
}
