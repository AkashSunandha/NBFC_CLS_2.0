package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Series {
	
	//Loader 
	public By loader = By.xpath("//div[@id=\"progressdiv\"]");
		
	//Continue button
	public By continueBtn = By.xpath("//span[text()='Continue']");
	
	//Connect to debenture
	public By debture = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/div");
	public By debenture_Srs =By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[3]/a");
	
	//Debenture Issue Selection
	public By debenture_type =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDebentureType_ddl\"]");
		
	//Series Name Input
	public By debenture_issue =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlDebentureIssue_ddl\"]");
	
    //Series Name_1 Input
	public By series_name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtSeriesName_txt\"]");
	
	//ISIN No Input Validation
	public By ISin =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtISINNo_txt\"]");
	
	//Interest Payment Method Selection
	public By Interest_Payment_Method =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlInterestPaymentMethod_ddl\"]");
	
	//ROI Input Validation
	public By Roi =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtROI_txt\"]");
	
	//GL Acc Code Dependency Loading
	public By Acc_code =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtGLAccCode_txt\"]");
	
	//int_GL Acc Code Dependency Loading
	public By Int_Acc_code =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtIntGlHeadName_txt\"]");
		
	//GL Acc Name Dependency Loading
	public By Acc_Name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlGlHead_ddl\"]");
		
	//int_GL Acc Name Dependency Loading
	public By Int_Acc_Name =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlIntGlHead_ddl\"]");
	
	// Print Gl_Acc Code 
	public By Print_GL_Acc_Cde =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlIntGlHead_ddl\"]");
	
	// Print Gl_Acc Name1
	public By Int_Acc_Name1 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ddlPrintGlHead_ddl\"]");
	
	//Print Temp Roi
	public By Print_Temp_Roi =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_txtTempRoi_txt\"]");
	
//	// Lacks
//	public By Lacks_0 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox1\"]");
//	public By Lacks_1 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox2\"]");
//	public By Lacks_2 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox3\"]");
//	public By Lacks_3 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox4\"]");
//	public By Lacks_4 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox5\"]");
//	public By Lacks_5 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox6\"]");
//	public By Lacks_6 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox7\"]");
//	public By Lacks_7 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox8\"]");
//	public By Lacks_8 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox9\"]");
//	public By Lacks_9 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox10\"]");
//	public By Lacks_10 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox11\"]");
//	public By Lacks_11 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox12\"]");
//	public By Lacks_12 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox13\"]");
//	public By Lacks_13 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox14\"]");
//	
	
	//Roi date from
	public By Roi_Date_From =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_dtEffectFromdate_txt\"]");
	
	//Roi date To
	public By Roi_Date_To =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_dtEffectTodate_txt\"]");
	
	//Lacks_01
//	public By Lacks_15 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox15\"]");
//	public By Lacks_16 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox16\"]");
//	public By Lacks_17 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox17\"]");
//	public By Lacks_18 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox18\"]");
//	public By Lacks_19 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox19\"]");
//	public By Lacks_20 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox20\"]");
//	public By Lacks_21 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox21\"]");
//	public By Lacks_22 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox22\"]");
//	public By Lacks_23 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox23\"]");
//	public By Lacks_24 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox24\"]");
//	public By Lacks_25 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox25\"]");
//	public By Lacks_26 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox26\"]");
//	public By Lacks_27 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox27\"]");
//	public By Lacks_28 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox28\"]");
//	public By Lacks_29 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox29\"]");
//	public By Lacks_30 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox30\"]");
//	public By Lacks_31 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox31\"]");
//	public By Lacks_32 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox32\"]");
//	public By Lacks_33 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox33\"]");
//	public By Lacks_34 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox34\"]");
//	public By Lacks_35 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox35\"]");
//	public By Lacks_36 =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ROICategory_dynamictextbox36\"]");
	
	
	//Save
	public By save =By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_btnSave\"]");
	
	//Updated
	public By Updated =By.xpath("//*[@id=\"closetop\"]");
	
	//public By Updated =By.xpath("/html/body/form/div[3]/div[2]/a[5]/strong");
	
	

}
