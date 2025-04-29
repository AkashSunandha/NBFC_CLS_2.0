package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Cust_NewCustomer { 

	public By customerTab = By.xpath("//ul[@id='CreateMenu']//a[text()='Customer']/preceding-sibling::div");
	public By newCustomerTab = By.xpath("//a[text()='New Customer (CUST)']"); 
	
	//Personal Details
	public By pdStartDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtStartDate_txt\"]");
	public By pdIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By pdSalutationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlSalutation_ddl\"]");
	public By pdFNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFirstName_txt\"]");
	public By pdMNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMiddleName_txt\"]");
	public By pdLNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtLastName_txt\"]");
	public By pdANameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtAliasName_txt\"]");
	public By pdDNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtDisplayName_txt\"]");
	public By pdDOBDatePicker = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtCustDateOfBirth_txt\"]");
	public By pdAgeTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtAge_txt\"]");
	public By pdAgeAsOnDatePicker = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_dtAgeAsOnDate_txt\"]");
	public By pdAgeGroupDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlAgeGroup_ID_ddl\"]");
	public By pdNationalityDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlCountry_ID_ddl\"]");
	public By pdNativityDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlState_ID_ddl\"]");
	public By pdGenderDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlGender_ddl\"]");
	public By pdQualificationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlQual_ID_ddl\"]");
	public By pdReligionDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlReligion_ID_ddl\"]");
	public By pdCategoryDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlCaste_ID_ddl\"]");
	public By pdMaritalStatusDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlFamilyStatus_ID\"]");
	public By pdOccupGroupDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlOccup_ID_ddl\"]");
	public By pdOccupationTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtOccupation_txt\"]");
	public By pdOccOrganisationTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtOccupationOrganisation_txt\"]");
	public By pdMonthlyIncomeTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMonthlyIncome_txt\"]");
	public By pdIncomeSourceDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlMultiListIncome_DropImage\"]");
	public By pdIncmSrcNillOption = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlMultiListIncome_ctl09\"]");
	public By pdParentTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFMSName_txt\"]");
	public By pdPANTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_lblPAN\"]");
	public By pdRelationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlFMSRel_ddl\"]");
	public By pdMentRetardedcheckbox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_chkMentallyRetarded\"]");
	public By pdGuardianTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtGaurdian_txt\"]");
	public By pdGuardianRelationDrpodown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlGaRel_ID_ddl\"]");
	public By pdFatherNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFatherName_txt\"]");
	public By pdMotherNameTxtBpx = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMothername_txt\"]");
	public By pdAadharNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtUniversal_ID_txt\"]");
	public By pdPANTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPAN_txt\"]");
	public By pdIsNRICheckbox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_chkIsNRI\"]");
	public By pdPhyChallengedCheckbox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_chkPhysicallyChallenged\"]");
	public By pdPhyChallengedDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlPhysically_ddl\"]");
	public By pdPhoneNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPhoneNo_txt\"]");
	public By pdMobileNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMobileNo_txt\"]");
	public By pdEmailTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtEMail_txt\"]");
	public By pdAssetOwnedDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlMultiListAssetOwned_DropImage\"]");
	public By pdAssetOwnedOption = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlMultiListAssetOwned_ctl03\"]");
	public By pdCustSegmentDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlPoverty\"]");
	public By pdWeddingDatePicker = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_dtCustWeddingDate_txt\"]");
	public By pdBloodGroupDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlBloodGrps_ddl\"]");
	public By pdPreferredLangDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlCustomerPreferredLanguage_ddl\"]");
	public By pdCKYCIdTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtCKYCID_txt\"]");
	public By pdCountryDropDown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlCountry_ddl\"]");
	
	//Buttons
	public By checkAvailabilityBtn = By.xpath("//*[@id=\"btnCheckAvailability\"]");
	public By saveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By previousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By checkBannedBtn = By.xpath("//*[@id=\"btnBannedCustList\"]");
	
	
//	public By pdinvalidAadharNumPopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By invalidPANNumPopUp = By.xpath("/html/body/form/table[18]/tbody/tr[1]/td[4]/div/img");
	public By invalidMobileNumPopUp = By.xpath("//*[@id=\"close\"]");
	public By invalidEmailPopUp = By.xpath("/html/body/form/table[19]/tbody/tr[1]/td[4]/div/img");
	public By noMatchFound = By.xpath("/html/body/form/div[3]/table/tbody/tr/td[contains(text(),'No Matches Found')]");
	public By invalidPopUpFirstName = By.xpath("/html/body/form/table[10]/tbody/tr[2]/td[4]/div/img");
	public By invalidPopUpMiddleName = By.xpath("/html/body/form/table[11]/tbody/tr[1]/td[4]/div/img");
	public By invalidPopUpLastName = By.xpath("/html/body/form/table[12]/tbody/tr[1]/td[4]/div/img");
	public By invalidPopUpAliasName = By.xpath("/html/body/form/table[13]/tbody/tr[1]/td[4]/div/img");
	public By invalidPopUpFatherName = By.xpath("/html/body/form/table[14]/tbody/tr[2]/td[4]/div/img");
	public By invalidPopUpMotherName = By.xpath("/html/body/form/table[15]/tbody/tr[2]/td[4]/div/img");
	public By invalidPopUpSalutation = By.xpath("/html/body/form/table[1]/tbody/tr[2]/td[4]/div/img");
	public By invalidPopUpAadhaar = By.xpath("/html/body/form/table[17]/tbody/tr[1]/td[4]/div/img");
	public By invalidPopUpCKYCId = By.xpath("/html/body/form/table[16]/tbody/tr[1]/td[4]/div/img");
	public By pdSavedSuccessfullyPopUp = By.xpath("//*[@id=\"closetop\"]");
	
	//Address
	//Present
	public By prHouseTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_lblHouse\"]");
	public By prHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouse_txt\"]");
	public By invalidPresentHouseName = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By addressIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By prHouseNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouseNo_txt\"]");
	public By prDoorNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtDoorNo_txt\"]");
	public By prStateDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlState_ddl\"]");
	public By prDistrictDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlDist_ID_ddl\"]");
	public By prPostDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlPost_ddl\"]");
	public By prPlaceTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPlace_txt\"]");
	public By prCityTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtCity_txt\"]");
	public By prStreetTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtStreet_txt\"]");
	public By prResidenceTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtResidence_txt\"]");
	public By prPinTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPin_txt\"]");
	public By prPhoneNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPhoneNo_txt\"]");
	public By prElectricPostNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtElectricPostNo_txt\"]");
	public By prMailingAddress1CheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_chkMailAddress\"]");
	public By prMailingAddress2CheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_chkMailAddress\"]");
	//Permanent
	public By prmUsePresentCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_chkCopyAddress\"]");
	public By invalidPresentResidence = By.xpath("/html/body/form/table[3]/tbody/tr[1]/td[4]/div/img");
	public By prmHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtHouse_txt\"]");
	public By prmPIN = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtPin_txt\"]");
	public By prmPhoneNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtPhoneNo_txt\"]");
	public By prmPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By prmSaveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	//Official
	public By offBuildingTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl2_ctl00_AF1_txtHouse_txt\"]");
	//Regional
	public By regHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl3_ctl00_AF1_txtHouse_txt\"]");
	//Overseas
	public By ovrHouseTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl4_ctl00_AF1_txtHouse_txt\"]");
	public By ovrPINTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl4_ctl00_AF1_txtPin_txt\"]");

	//Introducer
	public By introdNotReqCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_cbNotRequired\"]");
	public By introducerIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By introReasonTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtReason_txt\"]");
	public By introCustIdTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntCust_ID_txt\"]");
	public By introCustIdTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_lblIntCust_ID\"]");
	public By invalidIntCustIdPopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By invalidCustIdPopUpWnd = By.xpath("//*[@id=\"close\"]");
	public By introCustomerIDSrchBtn = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By introIntNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntName_txt\"]");
	public By introIntroducersAddressTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntroducerAddress_txt\"]");
	public By introRelIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_ddlRel_ID_ddl\"]");
	public By introRemarksTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntDesignation_txt\"]");
	public By introActiveAccBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnShowActiveAccount\"]");
	public By introCloseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnCLose\"]");
	public By introSaveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By introPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By introRelationWithDirectorCheckbox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_chkRelationWithDirector\"]");
	public By introDirectorDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_ddlDirectors_ddl\"]");
	public By introRelationBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_ddlDirRelation_ddl\"]");
	public By introDirctrRemarksTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtRemarks_txt\"]");
	public By introTable = By.xpath("//*[@id=\"tblintroduceActiveAccount\"]");
	//Customer Search Window
	public By custSrchNameTxt = By.xpath("/html/body/form/div[3]/div/div/div[1]/table/tbody/tr[1]/td[1]");
	public By custSrchNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By custSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By custSelectLinkTxt = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");

	
	//Identity And Area
	//Add Identity Details
	public By aidIdentityTypeDropdown = By.xpath("//*[@id=\"ddl\"]");
	public By aidIdentityNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtDoc_No_txt\"]");
	public By aidProofTypeDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocProofType_ddl\"]");
	public By aidIssuedAutTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtIssuedAuthority_txt\"]");
	public By aidIssueDate = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtIssueDate_txt\"]");
	public By aidValidUpTo = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtValidupTo_txt\"]");
	public By aidDetailsTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtRemarks_txt\"]");
	public By aidAddImgBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_BtnAddImages\"]");
	public By aidAddDocBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnDocAdd\"]");
	//Area Details
	public By adAreaDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlArea_ddl\"]");
	public By adAmshamDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlAmsham_ddl\"]");
	public By adDeshamDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlDesham_ddl\"]");
	public By adVillageDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlVillage_ddl\"]");
	public By adWardDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtWard_txt\"]");
	public By adPanchayathDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlPanchayath_ddl\"]");
	public By adMunicipalityDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlMunicipality_ddl\"]");
	public By adCorporationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlCorporation_ddl\"]");
	public By adAssemblyConstituencyDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlConstituency_ddl\"]");
	public By adTalukDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlTaluk_ddl\"]");
	public By adPanchayathWardTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtPanchayathWard_txt\"]");
	public By adBankWardTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtBankWard_txt\"]");
	//LandDetails
	public By ldLandTypeDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlLandType\"]");
	public By ldSurveyNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtSurveyNo_txt\"]");
	public By ldResurveyNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtResurveyNo_txt\"]");
	public By ldUnitDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlUnit_ddl\"]");
	public By ldWetTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtWet_txt\"]");
	public By ldDryTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtDry_txt\"]");
	public By ldAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnLandAdd\"]");
	//Buttons
	public By iaaSaveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By iaaPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By aidBrowseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	public By aidAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By imgAddedSuccessfully = By.xpath("//*[@id=\"ctl00_CPHFrame_lstData_ctl00_imgRotate\"]");
	public By tableSlNum = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lblSl\"]");
	public By tableDocType = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl1\"]");
	public By tableDocNum = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl2\"]");
	public By tableIssudAuth = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl89\"]");
	public By tableIssueDate = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl3\"]");
	public By tableValidUpTo = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl4\"]");
	public By tableRemarks = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl5\"]");
	public By tableDocProoofType = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl6\"]");
	public By tableDocVerification = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_lbl7\"]");
	public By tableNewEntry = By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentView_ctrl2_CDV1_lbl1\"]");
	
	//Family
	public By fmGentsTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtFamliyGentsCount_txt\"]");
	public By fmFamilyIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By fmLadiesTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtFamliyLadiesCount_txt\"]");
	public By fmTotalMembTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtTotalMembers_txt\"]");
	public By fmLadiesTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_lblFamliyLadiesCount\"]");
	public By fmEmployedTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtFamliyEmployedCount_txt\"]");
	public By fmNRITxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtFamliyNRICount_txt\"]");
	public By fmUnemployedTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyCount_ctrl0_FCF1_txtUnemployed_txt\"]");
	public By fmNameSalutationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_ddlFmlSalutation_ddl\"]");
	public By fmNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_txtFmName_txt\"]");
	public By fmInvalidFmNamePopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By fmEmailTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_txtEmailID_txt\"]");
	public By fmRelationDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_ddlRel_ID_ddl\"]");
	public By fmMobileNum = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_txtPhoneNo_txt\"]");
	public By fmCountry = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_ddlJobCountry_ID_ddl\"]");
	public By fmAddress1TxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_txtAddress1_txt\"]");
	public By fmUsePresentCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_chkCopyAddress\"]");
	public By fmAddress2 = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_txtAddress3_txt\"]");
	public By fmOccupGroupDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_ddlOccup_ID_ddl\"]");
	public By fmDOB = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_dtFamDateOfBirth_txt\"]");
	public By fmAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By fmFamilyDetailsGrid = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/table");
	public By fmPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By fmSaveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnNext\"]");
	public By fmIsNRICheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstFamilyForm_ctrl0_FDF1_chkNRI\"]");

	//Bank A/C Details
	public By bdIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By bdStateDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlState_ddl\"]");
	public By bdBankIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBank_ID_ddl\"]");
	public By bdBranchID = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBankBranch_ddl\"]");
	public By bdCustName = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtbeneficiaryname_txt\"]");
	public By bdIFSCTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtIFSC_txt\"]");
	public By bdAddressTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtAddress_txt\"]");
	public By bdBankAccNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtExtAc_No_txt\"]");
	public By bdRetypeAccNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtReEnterExtAcNo_txt\"]");
	public By bdBankAccIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlAccount_ddl\"]");
	public By bdStartDate = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtStartDate_txt\"]");
	public By bdAddInfoCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkAdditionalInfo\"]");
	public By bdBalanceAsOn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtAsOn_txt\"]");
	public By bdNotMentionedCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_cbBalance\"]");
	public By bdBalanceTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtBalance_txt\"]");
	public By bdCreditCardCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkCreditCard\"]");
	public By bdCreditCardNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtCreditCardNo_txt\"]");
	public By bdAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By bdBankDetailsSavedGrid = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div[1]/table/tbody/tr[5]/td/table");
	public By bdDPIDTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_txtDpid_txt\"]");
	public By bdDematAccNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_txtDematAc_txt\"]");
	public By bdPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By bdProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnNext\"]");
	public By bdStartDateTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_lblStartDate\"]");
	public By bdBnkAccNumMismatchOkBtn = By.xpath("//*[@id=\"close\"]");
	public By bdInvalidCustNamePopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");

	
	//Visits
	public By visitsIframe = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By vNoVisitsCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_cbVisited\"]");
	public By vCountryDropdwon = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_ddlCountry_ID_ddl\"]");
	public By vNoOfTimesTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_txtNoOfTimes_txt\"]");
	public By vLastDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_txtLastDate_txt\"]");
	public By vPurposeTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_txtPurpose_txt\"]");
	public By vRemarksTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_txtRemark_txt\"]");
	public By vaNewAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By vVisaNumTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCustVisa_ctrl0_ucCustVisa_txtVisaNo_txt\"]");
	public By vVisaExpireDate = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCustVisa_ctrl0_ucCustVisa_dtVisaExpDate_txt\"]");
	public By vdCountryDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCustVisa_ctrl0_ucCustVisa_ddlCountry_ID_ddl\"]");
	public By vdAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_BtnAddVisa\"]");
	public By vPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By vProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnNext\"]");
	public By vaAddNewGrid = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div/table/tbody/tr[5]/td/table");
	public By vdVisaDetailsGrid = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div/table/tbody/tr[8]/td/div/table");
	public By vPurposeTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstCountryForm_ctrl0_VCF1_lblPurpose\"]");
	
	//Risk & Others Details
	public By rdRiskIdDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_ddlRiskID_ddl\"]");
	public By rdRemarksTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtRemarks_txt\"]");
	public By rdActiveSpecialInstrTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtActiveSpecialInstruction_txt\"]");
	public By rdSuspeciousCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_chkSusp\"]");
	public By rdAMLStatusTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneursAdditionalDeails_ctrl0_EOD_txtAMLStatus_txt\"]");
	public By rdCibilScoreTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneursAdditionalDeails_ctrl0_EOD_txtCibilScore_txt\"]");
	public By rdentityDetailsIDTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneursAdditionalDeails_ctrl0_EOD_txtEntityDetailsID_txt\"]");
	public By rdpercentageOfShareHoldingTxtBox  = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneursAdditionalDeails_ctrl0_EOD_txtPerOfShareHolding_txt\"]");
	public By rdInvalidPercentagePopUp = By.xpath("/html/body/form/table/tbody/tr[1]/td[4]/div/img");
	public By rdYearTxt = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAwardDetails_ctrl0_CAD_lblYear\"]");
	public By rdDeclarationMarkedCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneursAdditionalDeails_ctrl0_EOD_chkIsMarkedDeclaration\"]");
	public By rdAwardNameTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAwardDetails_ctrl0_CAD_txtAwardName_txt\"]");
	public By rdAwardProvidedByTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAwardDetails_ctrl0_CAD_txtAwardProvidedBy_txt\"]");
	public By rdYearTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstAwardDetails_ctrl0_CAD_txtYear_txt\"]");
	public By rdAwardDetailsGrid = By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr/td/div/table[2]/tbody/tr[4]/td/table");
	public By rdAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnAddAward\"]");
	public By rdIndustryCodeTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_txtIndustryCode_txt\"]");
	public By rdbusinessSectorCodeTxtBox  = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_txtBusinessSectorCode_txt\"]");
	public By rdExperienceInYear  = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_txtExperienceInYear_txt\"]");
	public By rdRemarks1TxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_txtRemarks_txt\"]");
	public By rdPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By rdSaveAndProceedBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By rdStartDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_dtStartDate_txt\"]");
	public By rdEndDateTxtBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstEntrepreneurExpDetails_ctrl0_EED_dtEndDate_txt\"]");
	public By rdAddBtn1 = By.xpath("//*[@id=\"ctl00_CPHFrame_BtnAddEntrepreneurExp\"]");
	public By rdEntrExpGrid = By.xpath("//*[@id=\"ctl00_CPHFrame_trEntrepreneurExpList\"]");
	
//	Photo/Sign
	public By psDocDropdown = By.xpath("//*[@id=\"ctl00_CPHFrame_ddlFilterDoc\"]");
	public By psBrowseBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	public By psAddBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By psPhotoRotateBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_lstData_ctl00_imgRotate\"]");
	public By psPhotoIsDefaultCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_lstData_ctl00_chkIsActive\"]");
	public By psIsDefaultCheckBox = By.xpath("//*[@id=\"ctl00_CPHFrame_chkIsDefault\"]");
	public By psSelect1ImgOkBtn = By.xpath("//*[@id=\"close\"]");
	public By psPhotoOption = By.xpath("//option[@value=1 and text()='Photo']");
	public By psPreviousBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnPrev\"]");
	public By psFinishBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnFinish\"]");
	
	//Summary of Customer
	public By custId = By.xpath("//*[@id=\"ctl00_CPHFrame_txtCustomerID_txt\"]");
	public By custName = By.xpath("//*[@id=\"ctl00_CPHFrame_txtCustomerName_txt\"]");
	public By KYCStatus = By.xpath("//*[@id=\"ctl00_CPHFrame_txtKycStatus_txt\"]");
	public By riskLevel = By.xpath("//*[@id=\"ctl00_CPHFrame_txtRiskLevel_txt\"]");
	public By okBtn = By.xpath("//*[@id=\"ctl00_CPHFrame_btnClose\"]");
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
}
