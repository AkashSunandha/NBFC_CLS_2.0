package com.Page_Repositary;
import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
public class PageRepositary_InvestmentTransaction_Cash_Transfer extends Base_Class {

	
	public By transactionTab = By.xpath("(//*[@id='CreateMenu']//li[@class=' close']//*[text()='Transaction']//parent::li//div)[1]");
	public By InvsttransactionsTab = By.xpath("//*[@title=' Quick Code: INVTR'][text()='Invst. Transaction (INVTR)']");
	public By ProductGroupDD =By.xpath("//*[@title='Product Group']");
	public By ProductNameDD =By.xpath("//*[@title='Product Name']");
	public By SelectBankDD =By.xpath("//*[@title='Select Bank']");
	public By SelectBranchDD =By.xpath("//*[@title='Select Branch']");
	public By SelectBranchDDValue =By.xpath("//*[@title='Select Branch']//*[text()='Cherpulassery']");

	public By SelectGridFirstrow =By.xpath("(//table[@id='tblACList']//tbody//tr[@class='GridItem']//td//*[text()='1212']//parent::td//parent::tr//td//input)[1]");
	public By SelectTransactionTypeDD =By.xpath("//*[@title='Transaction Type']");
	public By GoButton =By.xpath("//*[@value='Go']");
	public By Transaction_Amount =By.xpath("//*[@title='Transaction Amount']");
	public By ProductName =By.xpath("//span[text()='Product Name']");
	public By TransactionModeDD =By.xpath("//*[@title='TransactionMode']");
	public By SubmitTrans=By.xpath("//*[@value='Submit'][@type='submit']");
	public By FetchTransid =By.xpath("(//table[@id='tblCustList']//tbody//tr[@class='GridItem']//td//span[contains(@id,'TransID')])[1]");
	public By TransactionBasedDD =By.xpath("//table[@id='tables']//tr//td//select[@class='DropRequiedField ']");
	public By POstDebit =By.xpath("//*[@value='Post Debit']");
	public By GL_NAME =By.xpath("//div[@class='hjsel_select']//*[@id='hyjackText0']");
	public By GL_NAMEVValue =By.xpath("//*[@class='hjsel_options']//*[text()='ADVANCE FOR LAND']");
	public By Amount =By.xpath("//*[@title='Amount']");
	public By AddButton =By.xpath("//*[@value='Add'][@type='submit']");
	
	//Auth
	public By Authorize_And_Cancel_Tab = By.xpath("(//*[@id='CreateMenu']//li[@class=' close']//*[text()='Authorize & Cancel']//parent::li//div)[1]");
	public By CashierAuthorisation=By.xpath("//*[@title=' Quick Code: CAAU']");
	public By Refresh =By.xpath("//*[@value='Refresh'] | //table[@class='NavegationBar']//*[@value='Refresh']");
	public By EnterTransID=By.xpath("//*[@title='TransID']");
	public By Transcheckbox =By.xpath("//tr[@class='GridItem']//td[@class='chk']//input[@type='checkbox']");
	public By AuthorizeButton =By.xpath("//table[@class='NavegationBar']//*[@value='Authorize'][@type='submit']");
	public By SuccessMessage=By.xpath("//*[@id='FloatingErrorMessageBoxTop']//*[contains(@id,'ErrorMessage')]");
	public By ManagerAuthorisation=By.xpath("//*[@title=' Quick Code: MNAU']");
	public By TransferTab =By.xpath("//*[@class='ajax__tab_inner']//*[text()='Transfer']");
	
	
	
}
