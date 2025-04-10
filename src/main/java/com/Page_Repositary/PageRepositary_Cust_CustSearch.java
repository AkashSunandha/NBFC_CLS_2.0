package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Cust_CustSearch {
	
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
	public By home = By.xpath("//div[text()='Dashboard']");
	public By loginWarningOkBtn = By.xpath("//span[@class='ui-button-text' and contains(text(), 'OK')]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
	
	//Customer Search Window
	public By cust = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
	public By custSrch = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/ul/li[2]/a");
	public By custId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtCust_Id_txt\"]");
	public By custPanNum = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtPAN\"]");
	public By custDocType = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_ddlDocType_ID\"]");
	public By custDocNum = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtDoc_No\"]");
	public By custDocTypeElectionId = By.xpath("//option[@value='1' and contains(text(),'ELECTION ID')]");
	public By custSelect = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_lst_ctrl0_chkCustList\"]");
	public By custEditBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_UCCustCommToolBar_btnEdit\"]");
	public By custLastName = By.xpath("//input[@title='Enter LastName']");
	public By custCheckAvailabilityBtn = By.xpath("//*[@id=\"btnCheckAvailability\"]");
	public By custSaveNProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By savedPopUp = By.xpath("//img[@id='closetop']");
	public By invalidlastNamePopUp= By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By lastNameTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_lblLastName\"]");
	public By previousBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_btnClose\"]");
	public By custViewBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_UCCustCommToolBar_btnView\"]");
	public By personalDetails = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_SectionCaption1_lblCaption\"]");
	public By statusActive = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_lst_ctrl0_hfRecordStatus\"]");
	public By iframe = By.xpath("//iframe[@id='ctl00_ctl00_CPH1_CustContent_Cust']");
	public By popWindowErrMsg = By.xpath("//td[contains(text(),'No Matches Found.....!')]");
	public By custDocTypeElection = By.xpath("//option[@value='1' and contains(text(),'ELECTION ID')]");
	public By custAttachmentsBtn = By.xpath("//*[@value=\"Attachments\"]");
	public By photoSignWndow = By.xpath("//span[text()='Photo/Sign']");
	public By attachmentImg = By.xpath("//*[@id=\"ucPhotoSign_dlImages_ctl00_img\"]");
	public By attachmentZoom = By.xpath("//a[@title='Expand the image']");
	public By attachmentRotate = By.xpath("//*[@id=\"ucPhotoSign_dlImages_ctl00_imgRotate\"]");
	public By attachmentClose = By.xpath("//a[@class='pp_close']");
	public By freeze = By.xpath("//input[@value='Freeze']");
	public By custFreezeWndow = By.xpath("//*[@id=\"ctl00_ctl00_MasterCaption\"]");
	public By freezeCustId = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'Cust ID')]");
	public By freezeName = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'Name')]");
	public By freezeRisk = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'Risk')]");
	public By freezePanNum = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'PAN No')]");
	public By freezeCrntAge = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'Current Age')]");
	public By freezeCustType = By.xpath("//table[@id='tblCustList']/tbody/tr[@class=\"GridHeader\"]/td[contains(text(),'Customer Type')]");
	public By freezeCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_chkFreeze\"]");
	public By freezeSubmitBtn = By.xpath("//td/input[@value=\"Submit\"]");
	public By freezeCancelBtn = By.xpath("//td/input[@value=\"Cancel\"]");
	public By freezeErrMsgPopUp = By.xpath("//span[text()='Please select Freeze/UnFreeze']");
	public By freezeErrMsgOKBtn = By.xpath("//*[@id=\"close\"]");
	public By freezeDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_dtFreeze_txt\"]");
	public By futureDateErrMsgPopUp = By.xpath("//span[text()='freeze Date should be less than Transaction Date']");
	public By futureDateErrMsgOkBtn = By.xpath("//*[@id=\"close\"]");
	public By freezeRemark = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_txtRemarks\"]");
	public By freeszeListGrid = By.xpath("//*[@id=\"tblFreezeList\"]");
	public By activate = By.xpath("//input[@value='Activate']");
	public By custActiveWndow = By.xpath("//div[text()='Customer Active']");
	public By deactiveCheckBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_chkActivate\"]");
	public By activateDateTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_dtActivate_txt\"]");
	public By activateListGrid = By.xpath("//*[@id=\"tblActList\"]");
	public By activateRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_txtRemarks\"]");
	public By activateDateTxt = By.xpath("//span[text()='Date']");
	public By activateDateErrMsgPopUp = By.xpath("/html/body/form/table[3]/tbody/tr[1]/td[4]/div/img");
	public By custDeleteBtn = By.xpath("//input[@value='Delete']");
	public By deleteAuthorizedPopUpOkBtn = By.xpath("//*[@id=\"closeCanome\"]");
	public By deleteWithoutSelectOkBtn = By.xpath("//*[@id=\"close\"]");
	public By custSrchTxt = By.xpath("//div[@class='SecCapLeft']/span[text()='Customer Search']");
	public By deactiveOrActiveConfirmPopUp = By.xpath("//img[@id=\"closetop\"]");
	
	public By columnCustId = By.xpath("//table[@id='tblCustList']/thead/tr/td[3]");
	public By columnDate = By.xpath("//table[@id='tblCustList']/thead/tr/td[4]");
	public By columnFName = By.xpath("//table[@id='tblCustList']/thead/tr/td[5]");
	public By columnLName = By.xpath("//table[@id='tblCustList']/thead/tr/td[6]");
	public By columnMName = By.xpath("//table[@id='tblCustList']/thead/tr/td[7]");
	public By columnDisplayName = By.xpath("//table[@id='tblCustList']/thead/tr/td[8]");
	public By columnPrntSpouse = By.xpath("//table[@id='tblCustList']/thead/tr/td[9]");
	public By columnRelation = By.xpath("//table[@id='tblCustList']/thead/tr/td[10]");
	public By columnHouse = By.xpath("//table[@id='tblCustList']/thead/tr/td[11]");
	public By columnPlace = By.xpath("//table[@id='tblCustList']/thead/tr/td[12]");
	public By columnMobNum = By.xpath("//table[@id='tblCustList']/thead/tr/td[13]");
	public By columnStatus = By.xpath("//table[@id='tblCustList']/thead/tr/td[14]");

	//MARK
	public By custMarkBtn = By.xpath("//input[@value='Mark']");
	public By markCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtCustomerId_txt\"]");
	public By markCustName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtFirstName_txt\"]");
	public By markDisplayName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtDisplayName_txt\"]");
	public By markDOB = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtDateOfBirth_txt\"]");
	public By markAge = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtAge_txt\"]");
	public By markStatusDropDown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_ddlStatus_ddl\"]");
	public By markRemarkTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_txtMarkRemark_txt\"]");
	public By markEffDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_dtMarkDate_txt\"]");
	public By markSubmitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_btnSubmit\"]");
	public By markCloseBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustMark_btnClose\"]");
	public By custSrchCustIdTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_lst_ctrl0_hdnCustID\"]");
	public By custSrchDispName = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]");
	public By markRemarkReqClose = By.xpath("//div[@class='ajax__validatorcallout_innerdiv']/img");
	public By markStatusRqrdPopUpOkBtn = By.xpath("//*[@id=\"closePleatu\"]");
	public By markInvalidDatePopUpClose = By.xpath("");

	//Expired 
	public By custExpiredBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_UCCustView_UCCustCommToolBar_btnExpired\"]");
	public By expireCustId = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_txtCustomerId_txt\"]");
	public By expireDispName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_txtDisplayName_txt\"]");
	public By expireCustName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_txtFirstName_txt\"]");
	public By expireDOBAndAge = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_txtDateOfBirth_txt\"]");
	public By bankDetailsStateDropDown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_ddlState_ddl\"]");
	public By selectState = By.xpath("//option[@value='KERALA']");
	public By bankDetailsBankIdDropDown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_ddlBank_ID_ddl\"]");
	public By selectBankId = By.xpath("//option[@value='73']");
	public By bankDetailsBranchIdDropDown = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_ddlBankBranch_ddl\"]");
	public By selectBranchId = By.xpath("//option[@value='ABDURAHIMAN NAGAR']");
	public By bankDetailsIFSC = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_txtIFSC_txt\"]");
	public By bankDetailsCustName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_txtbeneficiaryname_txt\"]");
	public By bankDetailsAddressTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_txtAddress_txt\"]");
	public By bankDetailsAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_txtExtAc_No_txt\"]");
	public By bankDetailsReTypeAccNumTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_txtReEnterExtAcNo_txt\"]");
	public By bankDetailsAddBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_btnSave\"]");
	public By expireSubmitBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_btnSubmit\"]");
	public By expireCloseBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_btnClose\"]");
	public By bankDetailsDataGrid = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_bnkAcc\"]");
	public By expireDateReqPopUpClose = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
	public By selectBranchId1 = By.xpath("//option[@value='ALUR']");
	public By selectBranchId2 = By.xpath("//option[@value='ADIVAD']");
	public By selectBranchId3 = By.xpath("//option[@value='AGASTIANMOOZHY']");
	public By bankDetailsRetypeAccNumTxt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_LblReEnterExtAcNo\"]");
	public By accNumMismatchCloseBtn = By.xpath("//*[@id=\"close\"]");
	public By expireDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_dtMarkDate_txt\"]");
	public By expireRemark = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_txtMarkRemark_txt\"]");
	public By bankDetailsStartDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_ucCustExpire_lstAccountForm_ctrl0_BAF1_dtStartDate_txt\"]");

	//View
	public By nonEditableField = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_lstMaster_ctrl0_ctl00_CPP_lblDispName\"]");
	
	//Authorize
	public By managerAuthorisation = By.xpath("//a[text()='Manager Authorisation (MNAU)']");
	public By mangrAuthorRefreshBtn = By.xpath("//input[@value='Refresh']");
	public By mangrAuthorAuthorizeBtn = By.xpath("//input[@value='Authorize']");
	public By mangrAuthorCloseBtn = By.xpath("//input[@value='Close']");
	public By mangrAuthorOthersBtn = By.xpath("//span[text()='Others']");
	public By selectToAuthorize = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpOthers_ucMAOthers_lvwOtherDetails_ctrl0_chkSelect\"]");
	public By authorizeAndCancelBtn = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[10]");
	public By noData = By.xpath("//div[contains(text(),'No Data Found.....!')]");
	
	public By deleteConfirmationOkBtn = By.xpath("//*[@id=\"closeSeltio\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
	
	public By custAadhaar = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtUniversal_ID\"]");
	public By custMobile = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtMobileNo\"]");
	public By custName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtFirstName\"]");
	public By custParentSpouse = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtGuardian1_txt\"]");
	public By custSearchBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_btnSearch\"]");
	public By custClearBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_Button1\"]");
	public By custHouseName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_txtHouseName\"]");
	public By custErrorMsg = By.xpath("//*[@id=\"CustList\"]");
	public By custErrorPopMsgClose = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
	public By custErrorPopMsg = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[3]");
	public By custIsInstitutional = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsInstitutional\"]");
	public By custKYCCompliantOnly = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsCustomerComplaint\"]");
	public By custActiveOnly = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsActive\"]");
	public By custProspectsOnly = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsProspects\"]");
	public By custIncludeReject = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_ucCustomerSearch_chkIsRejected\"]");
	public By custTable = By.xpath("//*[@id=\"tblCustList\"]");
	public By custGridItem = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr");
	public By custListTable = By.xpath("//*[@id=\"tblCustList\"]");
	
	//Signout
	public By custSignOut = By.xpath("//strong[text()='Signout']");
}
