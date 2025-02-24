package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_FixedDeposit 
{
	
	//PC Registration
		public By formName = By.xpath("//*[@id='Username']");
		public By formBranchName = By.xpath("//select[@id='ddlBranches']/option[text()='TRIVANDRUM']");
		public By formComputerName = By.xpath("//*[@id=\"MacName\"]");
		public By formSubmitBtn = By.xpath("/html/body/div[2]/div[11]/div/button/span");
		
		//Login Module
		public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
		public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
		public By Branch = By.xpath ("//*[@id=\"txtBranch_txt\"]");
		public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
		
	//Deposit Opening window for DebuntureFixedType 2yrs (14003)
	public By Accountopening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/div");
	public By Depositopening = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[1]/a");
	public By FixedDeposit = By.xpath("//*[@id=\"searchlink0\"]");
	public By DebuntureFixedType = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[6]/ul/li[1]/ul/li/ul/li[2]/a");
	
	

	}
