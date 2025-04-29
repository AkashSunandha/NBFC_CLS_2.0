package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepository_User_Creation {

	
	public By continueBtn=By.xpath("//span[text()='Continue']");
	public By admin_signOutBtn=By.xpath("//strong[text()='Signout']");
	
	public By admin=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]");
	public By user_management=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/ul/li[1]/div");
	public By addNewUser=By.xpath("//a[text()='Add New User ']");
	public By addNewUserLabel=By.xpath("//span[text()='Add New User']");
	public By userID=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_txtUserID_txt\"]");
	public By name=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_txtName_txt\"]");
	public By saveBtn=By.xpath("//*[@id=\"ctl00_CPH1_btnSave\"]");
	
	public By group_dropdown=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_ddlGroups\"]");
	public By branch_dropdown=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_ddlBranches\"]");
	public By machineID_dropdown=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_ddlTerminalID\"]");
	public By emailID=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_txtEmailID_txt\"]");
	public By mobile=By.xpath("//*[@id=\"ctl00_CPH1_AddUser_txtMobile_txt\"]");
	public By level_checkBoxes=By.xpath("//table[@id='ctl00_CPH1_AddUser_chkLevel']/tbody/tr/td/input/following-sibling::label[text()='CASHIER']");
	public By level_checkBoxes1=By.xpath("//table[@id='ctl00_CPH1_AddUser_chkLevel']/tbody/tr/td/input/following-sibling::label[text()='credit']");
	public By level_checkBoxes2=By.xpath("//table[@id='ctl00_CPH1_AddUser_chkLevel']/tbody/tr/td/input/following-sibling::label[text()='view']");
	public By level_checkBoxes3=By.xpath("//table[@id='ctl00_CPH1_AddUser_chkLevel']/tbody/tr/td/input/following-sibling::label[text()='CRO']");

	

	public By password=By.xpath("//strong/font");
	
//	public By password=By.xpath("/html/body/form/div[12]/table/tbody/tr[2]/td/span/strong/font");
	//public By closeBtn=By.xpath("//*[@id=\"ctl00_CPH1_btnClose\"]");
	public By closeBtn=By.xpath("//*[@id=\"ctl00_CPH1_btnClose\"]");;
	public By errorMessage=By.xpath("//span[@id='ctl00_lblErrorMessage']");
	public By errorMessageOkBtn=By.xpath("//*[@id=\"closeFaiOnl\"]");
	
	public By validNameSuccuessMessage=By.xpath("//*[@id=\"ctl00_CPH1_lblMessageArea\"]");
	
	public By oldPassword=By.xpath("//*[@id=\"ctl00_ctl00_txtOldPassword\"]");
	public By newPassword=By.xpath("//*[@id=\"ctl00_ctl00_txtNewPassword\"]");
	public By cnfirmPwd=By.xpath("//*[@id=\"ctl00_ctl00_txtConfirmPassword\"]");
	public By submitBtn=By.xpath("/html/body/form/div[12]/div[11]/div/button/span");
	
	
	//*[@id="ctl00_CPH1_btnClose"]
	
	
}
