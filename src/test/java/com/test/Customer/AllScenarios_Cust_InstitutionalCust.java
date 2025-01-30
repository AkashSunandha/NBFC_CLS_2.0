package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Admin_UserCreation;
import com.Page_Customer.Customer_InstitutionalCust;
import com.Page_Repositary.PageRepository_Cust_InstitutionalCust;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

import net.bytebuddy.asm.Advice.Enter;

public class AllScenarios_Cust_InstitutionalCust extends Base_Class{

	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	//PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	//Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();

	Admin_UserCreation userCreate = new Admin_UserCreation();
	Customer_InstitutionalCust instituCust = new Customer_InstitutionalCust();
	PageRepository_Cust_InstitutionalCust institutionalCust = new PageRepository_Cust_InstitutionalCust();
	
	
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("InstitutionalCustomer");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}


	@Test(dataProvider = "TestData")
	public void institutionalCustomer(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//Application launch
				ExtentTestManager.startTest("TC No. - 01 --> Launch NBFC Application");
				ExtentTestManager.getTest().log(Status.PASS, "Step-1: Launch NBFC application.");
				Log.info("Step-1: Launch NBFC application.");

				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);

				//					String pcRegFormName = testdata.get("pcRegFormName").toString();
				//					String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();
				//					String loginUserName = testdata.get("loginUserName").toString();
				//					String loginValidPassword = testdata.get("loginValidPassword").toString();
				//					String validCustId = testdata.get("validCustId").toString();

				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);



				//TC-02
				instituCust.userLogin(testdata, context);


				//TC-03
				instituCust.testOpenInstitutionalCustomerWindow();


				//TC-05
				instituCust.testModuleNameIsNewCustomer();

				//TC-07
				instituCust.testInstitutionDetailsSectionPresence();

				//TC-08
				instituCust.testStartDateFieldPresence();

				//TC-09
				instituCust.testStartDateFormat();

				//TC-10
				instituCust.testStartDateFieldNotEditable();

				//TC-12
				instituCust.verifyFirstNameFieldPresence();

				
				//TC-14
				instituCust.testFirstNameField(testdata, context);
				//TC-17
				instituCust.testDisplayNameAutoLoad(testdata, context);

				//TC-19
				instituCust.testConstTypeDropdownOptions();


				//TC-20
				instituCust.testSelectConstType();

				//TC-21
				instituCust.testBusinessFieldPresence();

				//TC-22
				instituCust.testBusinessDropdownListsAllBusinesses();

				//TC-23
				instituCust.testSelectBusinessFromDropdown();


				//TC-26
				instituCust.testSelectRegdToFromDropdown();


				//TC-29
				instituCust.verifyDateSelectionAndManualEntry(testdata, context);
				
				//TC-31
				instituCust.testRegNoFieldEntry(testdata, context);

				//TC-33
				instituCust.testRegplaceFieldAcceptsVariousInputs(testdata, context);

				//TC-35
				instituCust.testEnterSpecialCharactersInPANField(testdata, context);

				//TC-38
				instituCust.testCSTFieldAcceptsAllCharacters(testdata, context);


				//TC-41
				instituCust.testPin(testdata, context);


				//TC-43
				instituCust.testTINFieldDataEntry(testdata, context);

				//TC-45
				instituCust.testTanNoFieldAllowsAllInputs(testdata, context);

				//TC-47
				instituCust.testFaxNoDataEntry(testdata, context);

				//TC-49
				instituCust.testEmailFieldEntry(testdata, context);


				//TC-52
				instituCust.testOperatorName(testdata, context);


				//TC-56
				instituCust.testMobileNumberFieldWithNumbers(testdata, context);

				//TC-59
				instituCust.testBoardResolutionField(testdata, context);

				//TC-62
				//instituCust.selectPreferredLanguage();  ---bug

				//TC-63
				instituCust.testOwnerDetailsSectionPresence();

				//TC-64
				instituCust.testAddOwnerDetailsButtonPresence();


				//TC-65
				instituCust.testOwnerDetailsFieldDisplay();

				
				//TC-67
				instituCust.testNameFieldInOwnerDetails(testdata, context);
				
				
				//TC-68
				instituCust.testDesignationFieldInOwnerDetails(testdata, context);
				
				
				//TC-70
				instituCust.testCustPopupInOwnerSection(testdata, context);
				
				//TC-71
				instituCust.testMSMEDetailsSectionPresence();

				//TC-72
				instituCust.testVerifyMSMECheckboxAndLabels();

				//TC-73
				instituCust.testDefaultIsMsmeCustomerCheckbox();


				//TC-74
				instituCust.testDeclarationBrowsingOptionPresence();

				//TC-77
				instituCust.testRegistrationField(testdata, context);

				//TC-83
				instituCust.testGstinFieldAcceptsAllEntries(testdata, context);
				
				//TC-84
				instituCust.testDocumentBrowsingOptionPresence();
				
				//TC-85
				instituCust.testInstitutionOtherDetailsSectionPresence();
				
				//TC-86
				instituCust.testEnterDataAndSelectInCINNumberField(testdata, context);
				
				//TC-87
				instituCust.testCmrScoreDropdownPresenceAndSelect();
				
				//TC-88
				instituCust.verifyShareHoldingFieldPresenceAndEnterNumbers(testdata, context);
				
				//TC-89
				instituCust.testDataEntryForShareHoldingFieldAndPresence(testdata, context);
				
				//TC-90
				instituCust.testDPIITNumberFieldInputAndPresence(testdata, context);
				
				//TC-91
				instituCust.testDPIITPresenceAndUpload();
				
				//TC-92
				instituCust.testKsumNumberFieldInputAndPresence(testdata, context);
				
				//TC-93
				instituCust.verifyBrowsingOptionPresenceAndUpload();
				
				
				//TC-94
				instituCust.testEnterDataInExternalCreditRatingFieldAndPresence(testdata, context);
				
				//TC-95
				instituCust.testExternalCreditRatingFieldBrowseBtn();
				
				//TC-96
				instituCust.testAOADocumentBrowseBtn();
				
				//TC-97
				instituCust.testMOADocumentBrowseBtn();
				
				//TC-98
				instituCust.testInstitutionSectorDropdownPresenceAndSelect();
				
				
				//TC-100
				instituCust.insti_saveAndProceedFunc();
				
			
				
				//click(institutionalCust.institution_closeBtn);
				//Thread.sleep(15000);
				//SwitchToFrame(institutionalCust.address_frame);
				
				//driver.switchTo().frame("//iframe[@id=ctl00_ctl00_CPH1_CustContent_Cust]");
				//driver.switchTo().frame(0);
				//System.out.println("switched to frame");
				
				//TC-101
			//	instituCust.testAddressPageTitle();
				
				//*[@id="ctl00_CPHFrame_lstMaster_ctrl0_ctl00_IF1_btnCLose"]
				
				//TC-102
				//instituCust.testVerifySectionsInAddressPage();
				
				//TC-104
				instituCust.testBuildingFieldInput(testdata, context);
				
				
				//TC-108
				instituCust.testBuildingNoFieldInput(testdata, context);
				
				
				//TC-110
				instituCust.testEnterLettersAndNumbersInDoorNoField(testdata, context);
				
				
				//TC-111
				instituCust.testStateDropdownFunctionality();
				
				//TC-112
				instituCust.testDistrictDropdownFunctionality();
				
				//TC-113
				instituCust.testPostDropdownFunctionality();
				
				//TC-116
				instituCust.testEnterPlaceField(testdata, context);
				
				//TC-118
				instituCust.testCityFieldInput(testdata, context);
				
				//TC-120
				instituCust.testStreetFieldInput(testdata, context);
				
				//TC-122
				instituCust.testResidenceFieldInput(testdata, context);
				
				
				instituCust.testPinField(testdata, context);
				
				//TC-127
				instituCust.testEnteringPhoneNumber(testdata, context);
				
				//TC-129
				instituCust.testEnterElectricPostNo(testdata, context);
				
				//TC-130
				instituCust.testClickMailingAddressCheckbox();
				
				//TC-132
				instituCust.regional_testEnterBuildingDetails(testdata, context);
				
				//TC-136
				instituCust.regional_testBuildingNoFieldInput(testdata, context);
				
				//TC-138
				instituCust.regional_testDoorNoFieldInput(testdata, context);
				
				//TC-139
				instituCust.regional_testSelectStateFromDropdown();
				
				//TC-140
				instituCust.regional_testDistrictDropdownFunctionality();
				
				//TC-141
				instituCust.regional_testPostDropdownFunctionality();
				
				//TC-144
				instituCust.regional_testPlaceField(testdata, context);
				
				//TC-146
				instituCust.regional_testCityField(testdata, context);
				
				//TC-148
				instituCust.regional_testStreetField(testdata, context);
				
				//TC-150
				instituCust.regional_testResidenceField(testdata, context);
				
				//TC-153
				instituCust.regional_testPinField(testdata, context);
				
				//TC-155
				instituCust.regional_testPhoneField(testdata, context);
				
				//TC-156
				instituCust.regional_testMailingAddressCheckbox();
				
				//TC-157
				instituCust.address_saveAndProceed();
				
				//TC-158
				instituCust.verifyIntroducerDetailsLabel();
				
				//TC-160
				instituCust.tickIntroducerNotRequiredCheckbox();
				
				//TC-161
				instituCust.testReasonField(testdata, context);
				
				//TC-163
				instituCust.untickIntroducerNotRequiredCheckbox();
				
				//TC-165
				instituCust.testCustomerSelection(testdata, context);
				
				//TC-166
				instituCust.testIntNameAutofill();
				
				//TC-167
				instituCust.testIntAddressAutofill();
				
				
				
				//TC-169
				instituCust.testRelIDdropdown();
				
				//TC-170
				instituCust.testRemarksField(testdata, context);
				
				//TC-172
				instituCust.testActiveAccountDisplay();
				
				//TC-173
				instituCust.testCloseBtn();
				
				//TC-174
				instituCust.testIntroducerSaveAndProceedBtn();
				
				
				//TC-177
				instituCust.testIdentityTypeDropdown();
				
				//TC-179
				instituCust.testIdentityNoField(testdata, context);
				
				//TC-181
				instituCust.testIssuedAuthorityField(testdata, context);
				
				//TC-182
				instituCust.testIssueDate(testdata, context);
				
				//TC-183
				instituCust.testValidUpTo(testdata, context);
				
				//TC-185
				instituCust.testDetailsField(testdata, context);
				
				//TC-186
				instituCust.testImageBtn();
				
				//TC-187
				instituCust.testAddDocument();
				
				//TC-190
				instituCust.testAreaDropdown();
				
				//TC-193
				instituCust.testAmshamDropdown();
				
				//TC-196
				instituCust.testDeshamDropdown();
				
				//TC-199
				instituCust.testVillageDropdown();
				
				//TC-202
				instituCust.testWardTextbox(testdata, context);
				
				//TC-205
				instituCust.testPanchayathDropdown();
				
				//TC-208
				//instituCust.testMunicipalityDropdown();
				
				//TC-211
				//instituCust.testCorporationDropdown();
				
				//TC-214
				instituCust.testAssemblyConstiDropdown();
				
				//TC-217
				instituCust.testTalukDropdown();
				
				//TC-219
				instituCust.testPanchayathWardField(testdata, context);
				
				//TC-221
				instituCust.testBankWardField(testdata, context);
				
				
				//TC-224
				instituCust.testLandTypeDropdown();
				
				//TC-226
				instituCust.testSurveyNoField(testdata, context);
				
				//TC-228
				instituCust.testResurveyNoField(testdata, context);
				
				
				//TC-231
				instituCust.testUnitDropdown();
				
				//TC-233
				instituCust.testWetField(testdata, context);
				
				
				//TC-235
				instituCust.testDryField(testdata, context);
				
				//TC-237
				instituCust.testAddBtn();
				
				//TC-239
				instituCust.testIdentityAndArea_saveAndProceedBtn();
				
				
				//TC-244
				instituCust.testStateDropdown();
				
				//TC-247
				instituCust.testBankIdDropdown();
				
				//TC-250
				instituCust.testBranchIdDropdown();
				
				//TC-251
				instituCust.testIFSCAutofill();
				
				//TC-253
				instituCust.testCustName(testdata, context);
				
				//TC-255
				instituCust.testAddress(testdata, context);
				
				
				//TC-257
				instituCust.testBankAccNo(testdata, context);
				
				
				//TC-259
				instituCust.testRetypeAccNo(testdata, context);
				
				
				//TC-262
				instituCust.testBankAccIdDropdown();
				
				//TC-264
				instituCust.testBankStartDate(testdata, context);
				
				//TC-267
				instituCust.testAdditionalInfoCheckBox();
				
				//TC-268
				instituCust.testBalanceAsOn(testdata, context);
				
				
				//TC-270
				instituCust.testBalanceField(testdata, context);
				
				//TC-272
				instituCust.testBalanceFieldIsRemoved();
				
				//TC-273
				instituCust.testCreditCardTick();
				
				//TC-274
				instituCust.testCreditCardNoField(testdata, context);
				
				//TC-276
				instituCust.testBankAddBtnFunc();
				
				//TC-279
				instituCust.testDPIDField(testdata, context);
				
				//TC-281
				instituCust.testDematAcc(testdata, context);
				
				
				//TC-283
				instituCust.testProceedBtnFunc();
				
				
				//TC-286
				instituCust.testRiskIdDropdown();
				
				//TC-288
				instituCust.testRiskRemarksField(testdata, context);
				
				
				//TC-290
				instituCust.testActivespecialinstructionField(testdata, context);
				
				
				//TC-292
				instituCust.testDefaultStateOfSusCheckbox();
				
				//TC-293
				instituCust.testTickSusField();
				
				//TC-295
				instituCust.testRiskSaveAndProceed();
				
				//TC-304
				instituCust.testselectPhotoFromDropdown();
				
				//TC-305
				instituCust.testUploadPhoto();
				
				//TC-307
				instituCust.testCheckDefaultCheckbox();
				
				//TC-308
				instituCust.testselectSignFromDropdown();
				
				//TC-309
				instituCust.testUploadSign();
				
				//TC-310
				instituCust.testAddSign();
				
				//TC-311
				instituCust.testselectGeneralFromDropdown();
				
				//TC-312
				instituCust.testDocumentNameDropdown();
				
				//TC-313
				instituCust.testUploadGeneralDocument();
				
				//TC-314
				instituCust.testAddGenDocWindow();
				
				//TC-316
				instituCust.testFinishBtn();
				

				Thread.sleep(5000);
				userCreate.signOut();

				// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}

}
