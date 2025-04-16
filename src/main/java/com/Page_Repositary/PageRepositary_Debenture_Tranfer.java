package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Debenture_Tranfer {
    
	public By loader =By.xpath("//div[@id=\"progressdiv\"]");
	
	//load debenture transfer
	public By debentureTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Debenture']/preceding-sibling::div");
	
	//Verify Debenture Type Selection
	public By Deb_TranferTab = By.xpath("//a[text()='Debenture Transfer ']");
	
	//Verify Debenture Issue Based on Type
	public By Deb_branch = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlBranch\"]");
	 
	//Verify Debenture type Based on Type
	public By Deb_Type = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucDebentureAccInfo_ddlDebentureType_ddl\"]");
	 

}
