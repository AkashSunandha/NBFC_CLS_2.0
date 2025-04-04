package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Cust_QuickCustomer { 
	//Quick Customer 
	public By currentDate = By.xpath("//*[@id=\"ctl00_lblHeaderDate\"]");
	public By customerTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Customer']/preceding-sibling::div");
	public By quickCustomerTab = By.xpath("//a[text()='Quick Customer ']");
	public By quickCustomerWindowTitle = By.xpath("//*[@id=\"ctl00_MasterCaption\"]");
	
//	Quick Account Details
	public By qadStartDate = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtStartDate_txt\"]");
	public By qadSalutationDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlSalutation_ddl\"]");
	public By qadSalutationDrpdwnMR = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/div[1]/div/select/option[6]");
	public By qadSalutationInvalidCloseBtn = By.xpath("/html/body/form/table[2]/tbody/tr[2]/td[4]/div/img");
	public By qadFNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtFirstName_txt\"]");
	public By qadFameInvalidPopUp = By.xpath("/html/body/form/table[10]/tbody/tr[2]/td[4]/div/img");
	public By qadMNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMiddleName_txt\"]");
	public By qadLNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtLastName_txt\"]");
	public By qadAliasNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtAliasName_txt\"]");
	public By qadDispNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtDisplayName_txt\"]");
	public By qadDOBTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtDateOfBirth_txt\"]");
	public By qadDOBTxt = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lblDateOfBirth\"]");
	public By qadDOBReqCloseBtn = By.xpath("/html/body/form/table[4]/tbody/tr[1]/td[4]/div/img");
	public By qadAgeTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtAge_txt\"]");
	public By qadAgeAsOnTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_dtAgeAsOnDate_txt\"]");
	public By qadFNameTxt = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lblFirstName\"]");
	public By qadAgeGroupDropdwn = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlAgeGroup_ID_ddl\"]");
	public By qadAgeGroupMajor = By.xpath("//option[@value='1' and text()='Major']");
	public By qadNationalityDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlCountry_ID_ddl\"]");
	public By qadNationalityIndia = By.xpath("//select[@id='ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlCountry_ID_ddl']/option[@value='1' and text()='INDIA']");
	public By qadNativityDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlState_ID_ddl\"]");
	public By qadNativityAndhradesh = By.xpath("//select[@id='ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlState_ID_ddl']/option[@value='2' and text()='ANDRAPRADESH']");
	public By qadGenderDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlGender_ddl\"]");
	public By qadGenderMale = By.xpath("//option[@value='1' and text()='Male']");
	public By qadQualificationDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlQual_ID_ddl\"]");
	public By qadQualificationOther = By.xpath("//option[@value='39' and text()='OTHERS']");
	public By qadReligionDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlReligion_ID_ddl\"]");
	public By qadReligionHindhu = By.xpath("//option[@value='1' and text()='HINDU']");
	public By qadCategoryDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlCaste_ID_ddl\"]");
	public By qadCategoryGeneral = By.xpath("//option[@value='1' and text()='GENERAL']");
	public By qadMaritalStatusDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlFamilyStatus_ID\"]");
	public By qadMaritalStatusSingle = By.xpath("//option[@value='1' and text()='Single']");
	public By qadOccupGroupDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlOccup_ID_ddl\"]");
	public By qadOccupGroupOther = By.xpath("//option[@value='5' and text()='OTHERS']");
	public By qadOccupationTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtOccupation_txt\"]");
	public By qadOccOrganisationTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtOccupationOrganisation_txt\"]");
	public By qadMonthlyIncomeTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMonthlyIncome_txt\"]");
	public By qadIncomeSourceDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlMultiListIncome_DropImage\"]");
	public By qadPrntSalutationDropDown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlFMSSal_ddl\"]");
	public By qadparentOrSpouseTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtFMSName_txt\"]");
	public By qadRelationDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlFMSRel_ddl\"]");
	public By qadMentRetardCheckBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_chkMentallyRetarded\"]");
	public By qadGuardianSalutationDropDown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlGaSalutation_ddl\"]");
	public By qadGuardianTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtGaurdian_txt\"]");
	public By qadGuardRelationDropDown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlGaRel_ID_ddl\"]");
	public By qadFathrNameSalutationDropDown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlFatherSalutation_ddl\"]");
	public By qadFathrNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtFatherName_txt\"]");
	public By qadMthrNameSalutationDropDown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlMotherSalutation_ddl\"]");
	public By qadMthrNameTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMothername_txt\"]");
	public By qadIncomeSrcSalary = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlMultiListIncome_ctl19\"]");
	public By qadAadhaarTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtUniversal_ID_txt\"]");
	public By qadPANTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtPAN_txt\"]");
	public By qadInvalidPopUp = By.xpath("//div[@class='ajax__validatorcallout_innerdiv']/img");
	public By qadMobileNumTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtMobileNo_txt\"]");
	public By qadEmailTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_txtEMail_txt\"]");
	public By qadPreferredLangDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_ddlCustomerPreferredLanguage_ddl\"]");
	public By qadInvalidAadhaarCloseBtn = By.xpath("/html/body/form/table[11]/tbody/tr[1]/td[4]/div/img");
	public By qadInvalidPANCloseBtn = By.xpath("/html/body/form/table[12]/tbody/tr[1]/td[4]/div/img");
	public By qadInvalidMobileCloseBtn = By.xpath("/html/body/form/table[13]/tbody/tr[1]/td[4]/div/img");
	public By qadInvalidEmailCloseBtn = By.xpath("/html/body/form/table[14]/tbody/tr[1]/td[4]/div/img");
	
	//Present
	public By presentHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtHouse_txt\"]");
	public By presentHouseNumTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtHouseNo_txt\"]");
	public By presentDoorNumTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtDoorNo_txt\"]");
	public By presentStateDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_ddlState_ddl\"]");
	public By presentDistrictDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_ddlDist_ID_ddl\"]");
	public By presentPostDropdown = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_ddlPost_ddl\"]");
	public By presentPlaceTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtPlace_txt\"]");
	public By presentCityTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtCity_txt\"]");
	public By presentStreetTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtStreet_txt\"]");
	public By presentResidenceTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtResidence_txt\"]");
	public By presentPINTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtPin_txt\"]");
	public By presentPhoneNumTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtPhoneNo_txt\"]");
	public By presentElectricPostNumTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_txtElectricPostNo_txt\"]");
	public By checkAvailabilityBtn = By.xpath("//*[@id=\"btnCheckAvailability\"]");
	public By presentMailAddrCheckBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl0_ctl00_AF1_chkMailAddress\"]");
	
	//Permanent
	public By permanentUsePresentCheckBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_chkCopyAddress\"]");
	public By permanentPINTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtPin_txt\"]");
	public By permanentHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_txtHouse_txt\"]");
	public By permanentStateTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_ddlState_ddl\"]");
	public By permanentPostTxtBox = By.xpath("//*[@id=\"ctl00_CPH1_lstMaster_ctrl0_ctl00_CM1_lstMaster_ctrl1_ctl00_AF1_ddlPost_ddl\"]");
	
	//Referred By
	public By refByDropDown = By.xpath("//*[@id=\"ctl00_CPH1_ddlReferredBy_ddl\"]");
	
	//Introducer
	public By btnIntroducer = By.xpath("//*[@id=\"ctl00_CPH1_btnIntroducer\"]");
	public By introDetailsNotReqCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_cbNotRequired\"]");
	public By introDetailsReasonTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_txtReason_txt\"]");
	public By introDetailsCustIdTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_txtIntCust_ID_txt\"]");
	public By introDetailsIntNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_txtIntName_txt\"]");
	public By introDetailsAddressTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_txtIntroducerAddress_txt\"]");
	public By introDetailsRelationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_ddlRel_ID_ddl\"]");
	public By introDetailsIntDesignationTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_txtIntDesignation_txt\"]");
	public By introDetailsActiveAcc = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_btnShowActiveAccount\"]");
	public By introDetailsCloseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_QIF_btnCLose\"]");
	public By introducerCustIdSrchBtn = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By introduceSaveBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By introduceCloseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnCancel\"]");
	public By introSelectSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By introSelectBtn = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");

	
	//Customer Select window
	public By custIdTxtBox = By.xpath("//*[@id=\"PopQuick1_txtCustID\"]");
	public By searchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By selectCust = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	
	//Identity And Area
	public By identityAndAreaBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnIdentityAndArea\"]");
	//Add Identity Details
	public By aidIdentityTypeDropdown = By.xpath("//*[@id=\"ddl\"]");
	public By aidProofTypeDropDown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocProofType_ddl\"]");
	public By aidProofTypeDrpDwnValue = By.xpath("//select[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocProofType_ddl\"]/option[@selected='selected']");
	public By aidIdentityNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtDoc_No_txt\"]");
	public By aidIssuedAuthorityTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtIssuedAuthority_txt\"]");
	public By aidIssueDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtIssueDate_txt\"]");
	public By aidValidUpToTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtValidupTo_txt\"]");
	public By aidDetailsTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtRemarks_txt\"]");
	public By aidAddDocumentBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnDocAdd\"]");
	public By aidIssueDateTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_lblIssueDate\"]");
	public By aidIssueDateInvalidPopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By aidValidUpToInvalidPopUp = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[4]/div/img");
	public By aidAddDocTable = By.xpath("/html/body/form/div[3]/div/div/div[1]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/table");
	//Area Details
	public By adAreaDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlArea_ddl\"]");
	public By adAmshamDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlAmsham_ddl\"]");
	public By adDeshamDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlDesham_ddl\"]");
	public By adVillageDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlVillage_ddl\"]");
	public By adPanchayathDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlPanchayath_ddl\"]");
	public By adMunicipalityDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlMunicipality_ddl\"]");
	public By adCorporationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlCorporation_ddl\"]");
	public By adAssemblyConstituencyDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlConstituency_ddl\"]");
	public By adTalukDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlTaluk_ddl\"]");
	public By adWardTextBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtWard_txt\"]");
	public By adPanchayathWardTextBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtPanchayathWard_txt\"]");
	public By adPanchayathWardInvalidPopUp = By.xpath("/html/body/form/table[1]/tbody/tr[1]/td[4]/div/img");
	public By adBankWardTextBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtBankWard_txt\"]");
	//LandDetails
	public By ldLandTypeDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlLandType\"]");
	public By ldSurveyNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtSurveyNo_txt\"]");
	public By ldResurveyNo  = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtResurveyNo_txt\"]");
	public By ldUnitDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlUnit_ddl\"]");
	public By ldWetTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtWet_txt\"]");
	public By ldDryTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtDry_txt\"]");
	public By ldAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnLandAdd\"]");
	public By iaaSaveBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By iaaCloseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnCancel\"]");
	public By ldLandDetailsTable = By.xpath("/html/body/form/div[3]/div/div/div[2]/div/table/tbody");
	
	//Photo & Sign	
	public By photoAndSignBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnPhotoAndSign\"]");
	//Documents
	public By docDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_ddlFilterDoc\"]");
	public By psAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By selectOneImgErrMsg = By.xpath("//*[@id=\"ctl00_CPHFrame_lblErrorMsg\" and text()='Select One Image']");
	public By docSaveBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSaveDetails\"]");
	public By saveErrMsg = By.xpath("//*[@id=\"ctl00_CPHFrame_lblErrorMsg\" and text()='Please Add Cust Documents Before Save']");
	public By docBrowseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	public By fileTypeNotSupportedErrMsg = By.xpath("//*[@id=\"ctl00_CPHFrame_lblErrorMsg\" and text()='Sorry..File type not supported.']");
	public By photoSavedSuccessfully = By.xpath("//*[@id=\"ctl00_CPHFrame_lstData\"]");
//	public By variable = By.xpath("");
//	public By variable = By.xpath("");
	
	//Bank Accounts
	public By bankAccountBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnExternalAcc\"]");
	public By baStateDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlState_ddl\"]");
	public By baBankIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBank_ID_ddl\"]");
	public By baBranchIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBankBranch_ddl\"]");
	public By baIFSCTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtIFSC_txt\"]");
	public By baCustNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtbeneficiaryname_txt\"]");
	public By baAddressTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtAddress_txt\"]");
	public By baBankAccNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtExtAc_No_txt\"]");
	public By baRetypeAccNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtReEnterExtAcNo_txt\"]");
	public By baAccNumMisMatchErrMsg = By.xpath("//*[@id=\"ctl00_CPHFrame_lblErrorMsg\" and text()='Bank account number mismatch']");
	public By baStateTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_lblState\"]");
	public By baBankAccIdDropDown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlAccount_ddl\"]");
	public By baStartDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtStartDate_txt\"]");
	public By baInvalidStartDatePopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By baAddInfoCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkAdditionalInfo\"]");
	public By baBalanceAsOn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtAsOn_txt\"]");
	public By baBalanceTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtBalance_txt\"]");
	public By baCreditCardCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkCreditCard\"]");
	public By baCreditCardNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtCreditCardNo_txt\"]");
	public By baNotMentionedCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_cbBalance\"]");
	
//	Demat A/c details
	public By daDPIDTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_txtDpid_txt\"]");
	public By daDematAccNo = By.xpath("//*[@id=\"ctl00_CPHFrame_txtDematAc_txt\"]");
//	Bank A/c details
	public By bankDeailsTable = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div/table/tbody/tr[5]/td/table/tbody");
	public By baAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By baSaveBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSaveDetails\"]");
	public By entrBankDetailsErrMsg = By.xpath("//*[@id=\"ctl00_CPHFrame_lblErrorMsg\" and text()='Enter Bank Details']");
	
	//Risk Details
	public By riskDetailsBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnRisk\"]");
	public By rdRiskIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_ddlRiskID_ddl\"]");
	public By rdRemarksTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtRemarks_txt\"]");
	public By rdActiveSpclInstructnTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtActiveSpecialInstruction_txt\"]");
	public By rdSupervisorCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_chkSusp\"]");
	public By rdSaveBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	
	public By saveBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnSave\"]");
	public By noMatchFound = By.xpath("//td[contains(text(),'No Matches Found.....!')]");
	public By dataSavedSuccessfullyCloseBtn = By.xpath("//*[@id=\"ctl00_CPH1_btnClosechange\"]");
	public By dataSavedPopUp = By.xpath("//*[@id=\"closetop\"]");
	public By existingCustTable = By.xpath("//*[@id=\"tblCustList\"]");
	
	//Quick Cust saved Info
	public By qcsiCustId = By.xpath("//*[@id=\"ctl00_CPH1_txtCustIDpopup\"]");
	public By qcsiDispName = By.xpath("//*[@id=\"ctl00_CPH1_txtCustNamePopup\"]");
//	public By variable = By.xpath("");
	public By addDocValueInGrid = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_ctrl2_CDV1_lbl1\"]");
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
}
