package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepository_Cust_InstitutionalCust {


	public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By dashboard=By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/table/tbody/tr[1]/th/div[1]");

	//div[text()='Dashboard']
	public By customer=By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");



	///html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div
	public By institutionalCustomer=By.xpath("//a[text()='Institutional Customer ']");
	public By institutionalDetails=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_SectionCaption1_lblCaption\"]");
	public By newCustLabel=By.xpath("//div[text()=\"New Customer\"]");
	public By firstName=By.xpath("//span[text()=\"First Name\"]");
	public By fisrtName_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFirstName_txt\"]");
	public By start_date=By.xpath("//span[text()=\"Start Date\"]");
	public By disable_textfield=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtStartDate_txt\"]");
	public By displayName=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtDisplayName_txt\"]");
	public By dashboard_label=By.xpath("//*[@id=\"ctl00_ctl00_MasterCaption\"]");
	//public By dashboard=By.xpath("//div[text()='Dashboard']");
	public By start_date_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtStartDate_txt\"]");

	public By frame=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	public By ConstType_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlConstType_ddl\"]");
	public By Business_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlBusiness_ddl\"]");
	public By RegdTo_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlRegdTo_ddl\"]");

	public By RegNo =By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtRegNo_txt\"]");
	public By cst=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtCST_txt\"]");
	public By RegPalce =By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtRegPalce_txt\"]");
	public By pan=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPan_txt\"]");
	public By pin = By.xpath("//input[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtPin_txt']");
	public By tin=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtTIN_txt\"]");
	public By tanNo = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtTANNo_txt\"]");
	public By faxNo = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtFAXNo_txt\"]");
	public By Email = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtEmail_txt\"]");
	public By MobileNo = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtMobileNo_txt\"]");
	public By boardResolution = By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtBoardResolution_txt\"]");

	public By operatorName=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_txtOperatorName_txt\"]");
	public By perferredLanguage = By.xpath("//select[@id='ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_ddlCustomerPreferredLanguage_ddl']/option");
	public By insti_saveAndProceed = By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");

	public By DateOfIncOp =By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_CM1_dtDateOfIncOp_txt\"]");



	public By selectDate=By.xpath("\"//div[@title='Wednesday, January 01, 2025']\"");

	//Owner section
	public By ownerSectionLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_InstitutionOwnerDetails1_SectionCaption1_lblCaption\"]");
	public By addOwnerBtn=By.xpath("//a[@id='ctl00_CPHFrame_InstitutionOwnerDetails1_lstCustOwnerDetails_ctrl0_btnEmptyInser']");
	public By ownerSection_nameField=By.xpath("//*[@id=\"ctl00_CPHFrame_InstitutionOwnerDetails1_lstCustOwnerDetails_ctrl0_txtName_txt\"]");
	public By ownerSection_designationField=By.xpath("//*[@id=\"ctl00_CPHFrame_InstitutionOwnerDetails1_lstCustOwnerDetails_ctrl0_txtDesignation_txt\"]");
    public By searchIconInOwnerSection=By.xpath("/html/body/form/div[3]/div/div/div[1]/div/table/tbody/tr/td/div[3]/table/tbody/tr[2]/td/div[1]/div/div/table/tbody/tr[2]/td[1]/a/img");
    public By OwnerSectionCustId_textbox=By.xpath("//*[@id=\"PopQuick1_txtCustID\"]");
    public By OwnerSectionSearchBttn=By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
    public By OwnerSectionSelectLink=By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
    

	
	
	//MSME section
	public By msmeSection=By.xpath("//*[@id=\"ctl00_CPHFrame_SectionCaption3_lblCaption\"]");
	public By IsmsmeCustomer=By.xpath("//*[@id=\"ctl00_CPHFrame_lblIsMSME\"]");
	public By noRadioBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_rbnNo\"]");
	public By yesRadioBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_rbnYes\"]");
	public By browseBtn_msme=By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	public By msme_registration=By.xpath("//*[@id=\"ctl00_CPHFrame_txtMSMERegNo_txt\"]");
	

	//GST section
	public By gst_YesRadioBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_gstYes\"]");
	public By gstTinNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_txtGSTNo_txt\"]");
	public By browseBtm_gst=By.xpath("//*[@id=\"ctl00_CPHFrame_docsUpload\"]");


	//Institution Other Details
	public By othetDetailsLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_SecInstOther_lblCaption\"]");
	public By cinNo=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtCIN_txt\"]");
	public By Share_Holding_By_Individuals =By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtShareholdingByIndividuals_txt\"]");

	public By DPIIT_Number=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtDPIITNumber_txt\"]");


	public By KSUM_Number =By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtKSUMNumber_txt\"]");

	public By External_Credit_Rating=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtExtCreditRating_txt\"]");

	public By browse_MOA=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_docUploadMOA\"]");

	public By Share_Holding_By_Entity_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_txtShareHoldingByEntity_txt\"]");

	public By DPIIT_Document_browseBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_docUploadDPI\"]");

	public By KSUM_Document_browseBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_docUploadKSUM\"]");

	public By AOA_Document_browseBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_docUploadAOA\"]");

	public By Institution_Sector_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_ddlInstitutionSector_ddl\"]");

	public By CMR_Score_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_ddlCMRScore\"]");

	public By External_Credit_Rating_browseBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstInstOther_ctrl0_CIO_docUploadCrd\"]");

	public By institution_closeBtn=By.xpath("//img[@id='closetop']");
	
	public By institution_frame=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");

	//Address

	public By address_frame=By.xpath("//iframe[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");

	//Official 

	public By addressLabel =By.xpath("//a[@id='ctl00_ctl00_CPH1_CustContent_ucCustProfProg_lbAddress']");
	public By officialLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_SectionCaption1_lblCaption\"]");
	public By regionalLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_SectionCaption1_lblCaption\"]");
	public By building_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouse_txt\"]");

	public By buildingNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtHouseNo_txt\"]");
	public By doorNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtDoorNo_txt\"]");

	public By state_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlState_ddl\"]");
	public By district_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlDist_ID_ddl\"]");
	public By post_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_ddlPost_ddl\"]");
	public By place_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPlace_txt\"]");
	public By city_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtCity_txt\"]");
	public By street_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtStreet_txt\"]");
	public By residence_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtResidence_txt\"]");
	public By pin_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPin_txt\"]");
	public By phoneNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtPhoneNo_txt\"]");
	public By electricPostNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_txtElectricPostNo_txt\"]");
	public By mailingAddressCheckbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_AF1_chkMailAddress\"]");


	//Regional

	public By regional_building_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtHouse_txt\"]");
	public By regional_buildingNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtHouseNo_txt\"]");
	public By regional_doorNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtDoorNo_txt\"]");
	public By regional_state_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_ddlState_ddl\"]");
	public By regional_district_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_ddlDist_ID_ddl\"]");
	public By regional_post_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_ddlPost_ddl\"]");
	public By regional_place_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtPlace_txt\"]");
	public By regional_city_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtCity_txt\"]");
	public By regional_street_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtStreet_txt\"]");
	public By regional_residence_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtResidence_txt\"]");
	public By regional_pin_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtPin_txt\"]");
	public By regional_phoneNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_txtPhoneNo_txt\"]");
	public By regional_mailingAddressCheckbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl1_ctl00_AF1_chkMailAddress\"]");
	public By address_saveAndProceedBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");

	public By address_closeBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");


	//Introducer
	public By introducer_custID=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntCust_ID_txt\"]");
	public By introducer_intName=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntName_txt\"]");
	public By introducer_intAddress=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntroducerAddress_txt\"]");
	public By introducer_relIdDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_ddlRel_ID_ddl\"]");
	public By introducer_remarks=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtIntDesignation_txt\"]");
	public By introducer_activeAccountBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnShowActiveAccount\"]");
	public By introducer_closeBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnCLose\"]");
	public By introducer_saveAndProceedBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By introducerNotRequiredCheckbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_cbNotRequired\"]");

	public By reason_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_txtReason_txt\"]");

	public By introducerSuccessMessage=By.xpath("//span[text()='Introducer Details Saved Successfully']");
	public By introducerDetailsLabel=By.xpath("//span[text()='Introducer Details']");
	public By introducer_custIdSearch=By.xpath("/html/body/form/div[3]/div/div/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a/img");
	public By introducerWindow_custID=By.xpath("//*[@id=\"PopQuick1_txtCustID\"]");
	public By introducerWindow_searchBtn=By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By introducerWindow_select=By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
	
	public By introducer_frame=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
	
	
	public By activeAccountGrid=By.xpath("//*[@id=\"tblintroduceActiveAccount\"]");
	
	//Identity

	public By addIdentityDetailsLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_SectionCaption2_lblCaption\"]");
	public By identityTypeDDropdown=By.xpath("//*[@id=\"ddl\"]");
	public By identityNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtDoc_No_txt\"]");
	public By proofTypeDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_ddlDocProofType_ddl\"]");
	public By issuedAuthority_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtIssuedAuthority_txt\"]");
	public By issueDate_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtIssueDate_txt\"]");
	public By validUpTo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_dtValidupTo_txt\"]");
	public By details_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_txtRemarks_txt\"]");
	public By identity_addImages=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_BtnAddImages\"]");
	public By addImageBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_BtnAddImages\"]");
	public By childWindow_browseBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	
	public By childWindow_addBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By validateDocumentBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_btn_validate\"]");
	public By addDocumentBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnDocAdd\"]");
    public By identityGrid=By.xpath("/html/body/form/div[3]/div/div/div[1]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/table");

    public By invalidMessage=By.xpath("/html/body/form/table/tbody/tr[1]/td[3]");
    
    public By issueDateLabel=By.xpath("//*[@id=\"ctl00_CPHFrame_lstDocumentForm_ctrl0_DF1_lblIssueDate\"]");

public By identityPage_frame=By.xpath("//*[@id=\"ctl00_ctl00_CPH1_CustContent_Cust\"]");
    
	//Area Details
	public By areaDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlArea_ddl\"]");
	public By amshamDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlAmsham_ddl\"]");
	public By deshamDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlDesham_ddl\"]");
	public By villageDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlVillage_ddl\"]");
	public By ward_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtWard_txt\"]");
	public By panchayath_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlPanchayath_ddl\"]");
	public By municipalityDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlMunicipality_ddl\"]");
	public By corporationDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlCorporation_ddl\"]");
	public By assemblyConstiDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlConstituency_ddl\"]");
	public By talukDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_ddlTaluk_ddl\"]");
	public By panchayathWard_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtPanchayathWard_txt\"]");
	public By bankWard_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAreaForm_ctrl0_CA1_txtBankWard_txt\"]");

	//Land Details
	public By landType_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlLandType\"]");
	public By surveyNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtSurveyNo_txt\"]");
	public By resurveyNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtResurveyNo_txt\"]");
	public By unitDropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_ddlUnit_ddl\"]");
	public By wet_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtWet_txt\"]");
	public By dry_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstLandForm_ctrl0_LF1_txtDry_txt\"]");
	public By addBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnLandAdd\"]");


	public By identityAndArea_saveAndProceedBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");




	//--//table[@class='Grid']/tbody/tr[@class='GridHeader']/td/span[text()='Land Type']

	//Bank details

	public By bank_state_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlState_ddl\"]");
	public By bankId_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBank_ID_ddl\"]");
	public By branchId_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlBankBranch_ddl\"]");
	public By ifsc_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtIFSC_txt\"]");
	public By custName_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtbeneficiaryname_txt\"]");

	public By address_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtAddress_txt\"]");
	public By bankAccNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtExtAc_No_txt\"]");
	public By retypeAccNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtReEnterExtAcNo_txt\"]");
	public By bankAccId_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_ddlAccount_ddl\"]");
	public By bank_startDate_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtStartDate_txt\"]");
	public By bank_addBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By additionalInfoCheckBox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkAdditionalInfo\"]");
	public By balanceAsOn_bank=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_dtAsOn_txt\"]");
	public By balance_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtBalance_txt\"]");
	public By creditCardCheckboc=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_chkCreditCard\"]");
	public By credirCardNo_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_txtCreditCardNo_txt\"]");
	public By dpid_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_txtDpid_txt\"]");
	public By dematAccNo=By.xpath("//*[@id=\"ctl00_CPHFrame_txtDematAc_txt\"]");
	public By notMentionedCheckbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstAccountForm_ctrl0_BAF1_cbBalance\"]");
	public By bankGrid=By.xpath("//table[@class='Grid']");

	public By bank_proceedBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnNext\"]");


	//Risk
	public By riskId_dropdown=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_ddlRiskID_ddl\"]");

	public By risk_remarks_textbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtRemarks_txt\"]");

	public By ActiveSpecialInstruction_textbox =By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_txtActiveSpecialInstruction_txt\"]");

	public By suspecious_checkbox=By.xpath("//*[@id=\"ctl00_CPHFrame_lstMaster_ctrl0_ctl00_RF1_chkSusp\"]");


	public By risk_saveAndProceedBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	


	//Photo/sign
	
	public By document_dropdown_one=By.xpath("//*[@id=\"ctl00_CPHFrame_ddlFilterDoc\"]");
	public By document_dropdown_two=By.xpath("//*[@id=\"ctl00_CPHFrame_ddlDocType\"]");
	public By selectDoc_browse=By.xpath("//*[@id=\"ctl00_CPHFrame_docUpload\"]");
	public By defaultCheckbox=By.xpath("//*[@id=\"ctl00_CPHFrame_chkIsDefault\"]");
	public By add_photo_Btn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnSave\"]");
	public By imageDisplayWindow=By.xpath("//*[@id=\"ctl00_CPHFrame_lstData_ctl00_img\"]");
	public By finishBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnFinish\"]");
	
	public By final_OKBtn=By.xpath("//*[@id=\"ctl00_CPHFrame_btnClose\"]");
	
	

}

