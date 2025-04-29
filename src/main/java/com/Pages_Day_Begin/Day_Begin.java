package com.Pages_Day_Begin;

import org.openqa.selenium.By;


public class Day_Begin
{
	//PC Registration
		public By formName = By.xpath("//*[@id='Username']");
		public By formBranchName = By.xpath("//select[@id='ddlBranches']");
		public By formBranchNameTrivandrum = By.xpath("//option[text()='TRIVANDRUM']");
		public By formBranchNameKochi = By.xpath("//option[text()='KOCHI']");
		public By formComputerName = By.xpath("//*[@id=\"MacName\"]");
		public By formSubmitBtn = By.xpath("/html/body/div[2]/div[11]/div/button/span");
		
		//Login Module
		public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
		public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
		public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
		public By logoutMsg = By.xpath("//*[@id=\"logMessage\"]");
		public By logoutOk = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");
		public By invalidPaswrdErrMsg = By.xpath("//*[@id=\"lblErrorMessage\"]");
		public By home = By.xpath("//*[@id=\"WorkingDiv\"]");
		public By loginWarningOkBtn = By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]");
		public By ContinueBtn = By.xpath("/html/body/div[1]/div[3]/div/button/span");
		
		//GL Acc Transaction
	
		public By Processes = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/ul/li[6]/div");
		public By DayBegin = By.xpath("//a[normalize-space()='Day Begin']");
		public By ProcessDayBegin = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div");
		public By Admin = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
		public By StartProcessing = By.xpath("//input[@id = 'ctl00_CPH1_DEPDC1_btnStartEODDC']");
		public By ContinueButton = By.xpath("//input[@id = 'ctl00_CPH1_DEPDC1_btnSubmitDC']");
		public By SubmitButton = By.xpath("//input[@id = 'ctl00_CPH1_DCAPL_btnSubmitProcess']");   
		public By ProcessandPosting = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[13]/div");
		
		
		
		public By Daybegin = By.xpath("//a[normalize-space()='Day Begin']");
		public By Startprocessing = By.xpath("//input[@id = 'ctl00_CPH1_DEPV1_btnStartEOD']");
		public By Processdaybegin = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/table[1]");
		public By ClosePopup = By.xpath("//img[@id ='closetop']");

		
		
		//Signout
		public By custSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[6]/strong");
		public By adminSignOut = By.xpath("/html/body/form/div[3]/div[2]/a[5]/strong");

    



}
