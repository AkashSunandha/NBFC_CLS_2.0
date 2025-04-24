package com.test.AccountOpening;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_AccountOpening.AccOpen_Loanopening_ACOPL_TwoWheeler;
import com.Page_AccountOpening.Transfer_AccOpen_Loanopening_ACOPL_TwoWheeler;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.github.dockerjava.api.model.Driver;
import com.listeners.TestListener;

public class Allscenarios_Accopen_Loan_ACOPL_Twowheelers_Transfer {
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Transfer_AccOpen_Loanopening_ACOPL_TwoWheeler  fixeddeposit  = new Transfer_AccOpen_Loanopening_ACOPL_TwoWheeler();
	
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("AccountOpening_Loan_ACOPL_TwoWh");
		
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void customerRegister( Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest("AccountOpening_loanOpening_ACOPL_TwoWheeler_Transfer");
				Log.info("AccountOpening_loanOpening_ACOPL_TwoWheeler_Transfer");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();
				
				
				//Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				


				 //PC Registration TC 01
				custSrchMthds.pcRegistration(testdata, context);
			
			     //TC 02
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);
				
				//TC 03
				//Account Opening
				fixeddeposit.TwoWheelerLoan();
				
				//TC 04, 05,06,07
				fixeddeposit.AddandselectCustomer(testdata, context);
				
				//TC 08
				fixeddeposit.FillAccountInfoTab(testdata,context);
				
				//TC 09
				fixeddeposit.FillAccountInfoTabResolutionNo(testdata, context);
				
				//TC 10
				fixeddeposit.FillAccountInfoTabEnterResoultionDate(testdata,context);
				
				//TC 11
				fixeddeposit.FillAccountInfoTabReferedBy(testdata, context); 
				
				 //TC 12
				fixeddeposit.FillAccountInfoTabCanvasserName(testdata, context);
				
				//TC 13
				fixeddeposit.FillAccountInfoTabEquitableMortRegNo(testdata, context);
				
				//TC 14,15
				fixeddeposit.FillAccountInfoTabEMRDate(testdata, context);
				
				//TC 16
				fixeddeposit.FillAccountInfoTabAgentCode(testdata, context);
				
				//TC 17
				fixeddeposit.FillAccountInfoTabDSACode(testdata, context);
				
				//TC 18
				fixeddeposit.NextButtonFunctionality();
				
				//TC 19, 20
				fixeddeposit.SelectvehicleSecurityTab(testdata, context);
				
				//TC 21
				fixeddeposit.FillVehicleSecurityDetialsRCno(testdata, context);
				
				//TC 22
				fixeddeposit.FillVehicleSecurityDetailsSelectVehicleStatus(testdata, context);
			
				//TC 23
				fixeddeposit.FillVehicleSecurityDetailsSelectVehicleType(testdata, context);
				
				//TC 24
				fixeddeposit.FillVehicleSecurityDetailsSelectVehicleDetails(testdata, context);
				
				//TC 25
				fixeddeposit.FillVehicleSecurityDetailsSelectVehicleCatergory(testdata, context);
				
				//TC 26
				fixeddeposit.FillVehiclesecuritydetailsExshowroomprice(testdata, context);
				
				//TC 27
				fixeddeposit.FillVehiclesecuritydetailsRoadTax(testdata, context);
				
				//TC 28
				fixeddeposit.FillVehiclesecuritydetailsInsurance(testdata, context);
				
				//TC 29
				fixeddeposit.FillVehiclesecuritydetailsRegandOthercharges(testdata, context);
				
				//TC 30
				fixeddeposit.FillVehiclesecuritydetailsDealerDiscount(testdata, context);
			
				//TC 31
				fixeddeposit.GetButton();
				
				//TC 32
				fixeddeposit.FillVehiclesecuritydetailsDownPayment(testdata,context); 
				
				//TC 33
				fixeddeposit.FillVehiclesecuritydetailsInsuranceDocumentNo(testdata, context);
				
				//TC 34
				fixeddeposit.FillVehiclesecuritydetailsYearofManufacture(testdata, context);
				
				//TC 35
				fixeddeposit.FillVehiclesecuritydetailsIDV(testdata, context);
				
				//TC 36
				fixeddeposit.FillVehiclesSecurityDetailsInsuranceprovider(testdata, context);
				
				
				//TC 37, 38(invalid)
				
				//TC 39
				fixeddeposit.FillVehiclesecuritydetailsVehicleColor(testdata, context);
				
				//TC 40
				fixeddeposit.FillVehicleSecurityDetailsRegDate(testdata, context);
				
				//TC 41 (invalid)
				
				//TC 42
				fixeddeposit.FillVehiclesSecurityDetailsRegistrationMode(testdata, context);
				
				//TC 43
				fixeddeposit.FillVehiclesecuritydetailsPermitNo(testdata, context);
				
				//TC 44
				fixeddeposit.FillVehiclesecuritydetailsEgineNo(testdata, context);
				
				//TC 45
				fixeddeposit.FillVehiclesecuritydetailsChassisNo(testdata, context);
				
				//TC 46
				fixeddeposit.FillVehiclesSecurityDetailsDelaerdropdown(testdata, context);
				
				//TC 47
				fixeddeposit.FillVehiclesSecurityDetailssubDelaerdropdown(testdata, context);
				
				 //TC 48
				fixeddeposit.FillVehiclesSecurityDetailsMakedropdown();
				
				//TC 49
				fixeddeposit.FillVehiclesSecurityDetailsModeldropdown(); 
				
				//TC 50
				fixeddeposit.FillVehiclesecuritydetailsVariant(testdata, context);
				
				//TC 51
				fixeddeposit.FillVehiclesecuritydetailsRTODetails(testdata, context);
				
				//TC 52 
				fixeddeposit.FillVehiclesSecurityDetailspurposedropdown(testdata, context);
				
				////TC 53
				//fixeddeposit.AddButtonFunctionality();
				
				//TC 54
				fixeddeposit.InsuredpastDateokbtn(testdata, context);
				
				//TC 55
				fixeddeposit.FillVehicleSecurityDetailsInsuredfutureDate(testdata, context);
				
				//TC 56 (Invalid)
				
				//TC 57
				fixeddeposit.NextButton();
				
				// TC 58
				fixeddeposit.FillNomineedetailsuntickNomineeNotRequired();
				
				//TC 59
				fixeddeposit.FillNomineedetailscustomersearchicon();
				
				//TC 60, 61
				fixeddeposit.FillNomineedetailssearchcustomerwithnameoralphabets(testdata, context);
				
				//TC 62
				fixeddeposit.FillNomineeDetailsRelationDropdown();
				
				//TC 63
				fixeddeposit.FillNomineedetailssearchAddbutton1();
				
				//TC 64
				fixeddeposit.FillNomineedetailssearchNextbutton();
				
				//TC 65
				fixeddeposit.FillLoanDetailssanctionedamount(testdata, context);
				
				//TC 66
				fixeddeposit.FillLoanDetailsNoOFInstallments(testdata, context);
				
				//TC 67
				fixeddeposit.EnterValidsanctionedamountclickGetValues();
				
				//TC 68
				fixeddeposit.SelectTransactionModeTransfer();
				
				//TC 69
				fixeddeposit.Verify_Loan_Submission_with_Transfer_Mode();
				
				//TC 70
				fixeddeposit.Transactionbased_GLcode();
				
				//TC 75
				fixeddeposit.save(); 
				
				//TC 76
				fixeddeposit.Login_with_Another_User_transferauthorize(testdata, context);
				
				//TC 77
				fixeddeposit.Manager_Authorization_Transfer_Tab(); 
				
				 // //TC 78
				// fixeddeposit.RefreshLoan_Opening_TransferEntry();
				
				//TC 79
				fixeddeposit.AuthorizeLoan_Entry_as_ManagerTransfertab();
				
				//TC 80
				fixeddeposit.Authorize_Loan_Entry_asManagerauthorizebutton();
				
							
				//Sign out
				custSrchMthds.logout();	
				
				
				// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
            Log.info("Exception "+e);
            ExtentTestManager.endTest();
            
            // Logout
 			context.setAttribute("fileName", "Logout");
 			Driver driver = new Driver();
			driver.wait();
 			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
 			Log.info("Logout is done");

 			// EndTest
 			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
 			ExtentTestManager.endTest();
 			ExtentManager.getInstance().flush();
 			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
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
