package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_DayEnd {
	
		
		public By loader =By.xpath("//div[@id=\"progressdiv\"]");
		
		public By Transaction = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[8]/a");
		
		public By ProcessingAndPosting = By.xpath("//ul[@id='CreateMenu']//a[text()='Processing & Posting']/preceding-sibling::div");
		
		public By BranchDayClosing = By.xpath("//ul[@id='CreateMenu']//a[text()='Branch Day Closing ']//preceding-sibling::div//following-sibling::a");
		
		public By StartProcessing = By.xpath("//input[@id='ctl00_CPH1_DEPV1_btnStartEOD']");
		
		public By Submit = By.xpath("//input[@id='ctl00_CPH1_DEPV1_btnSubmit']");
		
		public By YellowIcon = By.xpath("//img[@src='../Images/icons/warning_icon.jpg']");
		
		public By smallLoader = By.xpath("//*[@id=\"tblOpList\"]//tr[2]/td[1]//*[@id=\"start\"]//*[contains(@src,'loadingsmall.gif')]");

}
