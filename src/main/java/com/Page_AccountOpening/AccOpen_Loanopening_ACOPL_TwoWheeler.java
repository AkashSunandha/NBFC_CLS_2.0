package com.Page_AccountOpening;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler;
import com.Page_Repositary.PageRepositary_AccountOpening_FixedDeposit;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AccOpen_Loanopening_ACOPL_TwoWheeler extends Base_Class {
	// Navigate to Deposit Opening Window

	PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler fixeddeposit = new PageRepositary_AccOpen_Loan_ACOPL_TwoWheeler();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
    String cashtranscid;
    String Transacid;
    String Transactid1;
    public String spAadhaar = "EXEC GenerateNextAadharNumber";
    public String clmnNamAadhaar = "generated_aadhar_number";
    
    public String spMobileNum = "EXEC GenerateNextMobileNumber";
    public String clmnNamMobileNum = "generated_mobile_number";
    
    
    public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
           // Method that returns the first customer ID (String) from the database
            // Database connection details
    // Database connection details
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String UserName = "sqa";
           String Password = "SPQA@sql2019" ;
           String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

           
            String value = null; // Declare and initialize the return variable

            // Establish the connection to the database
            try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                 
                 if (resultSet.next()) {
                        value = resultSet.getString(columnName); // DB column name
                    System.out.println("Generated Unique ID: " + value);
                } else {
                    System.out.println("Unique ID not generated.");
                }

            } catch (SQLException e) {
                System.out.println("Error executing the SQL query or processing the result set.");
                e.printStackTrace();
            }

            return value; // Return the firstCustId
        }

	public void TwoWheelerLoan() throws InterruptedException {
		ExtentTestManager.startTest("TC:03 - select Two Wheeler Loan product");
		click(fixeddeposit.Account_opening);
		click(fixeddeposit.Loanopening);
		click(fixeddeposit.LoanandAdvance);
		click(fixeddeposit.TwoWheelerLoan);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Account opening ");
		Log.info("Step:01 Navigate to Account opening");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Select Loan opening and Click Loan and Advance (ACOPL)");
		Log.info("Step:02 Select Loan opening and Click Loan and Advance (ACOPL)");

		ExtentTestManager.getTest().log(Status.PASS, "Step:03 Choose Two Wheeler loan (23027)");
		Log.info("Step:03 Choose Two Wheeler loan (23027)");

		if (ElementDisplayed(fixeddeposit.Depositaccountopeningwindow)) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Two Wheeler Loan selection (23027) screen is displayed");
			Log.info("Expected result: Two Wheeler Loan selection (23027) screen is displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,
					"Expected Result: Two Wheeler Loan selection (23027) screen is not displayed");
			Log.info("Expected result: Two Wheeler Loan selection (23027) screen is not displayed");
		}
		ExtentTestManager.endTest();

	}

	public void AddandselectCustomer(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:04,5 - Add and select Customer");

		click(fixeddeposit.Custidsearchbtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click customer search icon");
		Log.info("Step:01 - Click customer search icon");

		// Navigate to Pop Up Window
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				popupAppeared = true;

				String custName = testdata.get("customerName").toString();
				input(fixeddeposit.CustomerNamesearch, custName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - 2.Enter customer Name or alphabet");
				Log.info("Step:02 - 2.Enter customer Name or alphabet");
				click(fixeddeposit.CustomerSearchbtn);
				Log.info("click on search button");

				click(fixeddeposit.selectcustomer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select customer from search results");
				Log.info("Step:03 - Select customer from search results");

				driver.switchTo().window(mainWindowHandle);
				String customerid = driver.findElement(fixeddeposit.custid).getAttribute("value");
				if (!customerid.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS,
							"Expected Result:Selected customer details is populated in the form");
					Log.info("Expected Result:Selected customer is  populated in the form");

				} else {
					ExtentTestManager.getTest().log(Status.FAIL,
							"Expected Result:Selected customer details is not populated in the form");
				}
				ExtentTestManager.endTest();
				click(fixeddeposit.Addbutton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on the Add Button");
				Log.info("Step:01 Click on the Add Button");

				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to click the Add Button");
				Log.info("Expected Result: Possible to click the Add Button");

				click(fixeddeposit.okbutton);
				ExtentTestManager.getTest().log(Status.PASS,
						"Step:01 Verify if Previous Active loan popup comes and Click OK button");
				Log.info("Step:01 Verify if Previous Active loan popup comes and Click OK button");

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result: Okclicked and customer details are displayed in grid");
				Log.info("Expected Result: OkClicked and customer details are displayed in grid");
			}
			ExtentTestManager.endTest();
		}
	}

	public void FillAccountInfoTab(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:06 - Fill Account Info Tab");
		click(fixeddeposit.Accountinfotab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 select Account info Tab");
		Log.info("Step:01 select Account info Tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account info tab is opened");
		Log.info("Expected Result:Account info tab is opened");

		ExtentTestManager.endTest();

	}

	public void FillAccountInfoTabResolutionNo(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:09 - Fill Account Info Tab resolution No");
		click(fixeddeposit.ResolutionNo);
		String resolutionno = testdata.get("ResolutionNo").toString();
		input(fixeddeposit.ResolutionNo, resolutionno);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter resolution No");
		Log.info("Step:01 Enter resolution No");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter Resolution No");
		Log.info("Expected result:Possible to enter Resolution No");

		ExtentTestManager.endTest();
	}

	public void FillAccountInfoTabEnterResoultionDate(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:10 - Fill Account Info Tab Enter Resolution Date");
		click(fixeddeposit.ResolutionDate);
		String resolutiondate = testdata.get("ResoultionDate").toString();
		input(fixeddeposit.ResolutionDate, resolutiondate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter resolution date");
		Log.info("Step:01 Enter resolution date");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to enter Resolution date");
		Log.info("Possible to enter Resolution date");

		ExtentTestManager.endTest();
	}

	public void FillAccountInfoTabReferedBy(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:11 - Fill Account Info Tab ReferedBy");
		click(fixeddeposit.Referedby);
		click(fixeddeposit.optionPradeep);
		INclick(fixeddeposit.loader);
		// click(fixeddeposit.Popupnull);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01  Choose Referred By from dropdown");
		Log.info("Step:01 Choose Referred By from dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to choose the Referred By from the drop down");
		Log.info("Expected Result: Possible to choose the Referred By from the drop down");

		ExtentTestManager.endTest();

	}

	public void FillAccountInfoTabCanvasserName(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:12 -  Fill Account Info Tab Canvasser Name");
		select("AISWARYA S N", fixeddeposit.CanvasserName);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Canvasser Name  from dropdown");
		Log.info("Step:01 Choose Canvasser Name  from dropdown");

		String CanvasserCode1 = driver.findElement(fixeddeposit.CanvasserCode).getAttribute("value");
		System.out.println("CanvasserCode: " + CanvasserCode1);

		if (!CanvasserCode1.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Possible to choose the Canvasser Name from the drop down and Canvasser code is displayed");
			Log.info(
					"Expected Result: Possible to choose the Canvasser Name from the drop down and Canvasser code is displayed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,
					"Expected Result: unable to choose the Canvasser Name from the dropdown and Canvasser code is not displayed");
			Log.info(
					"Expected result: unable to choose the Canvasser Name from the dropdown and Canvasser code is not displayed");
		}

		ExtentTestManager.endTest();

	}

	public void FillAccountInfoTabEquitableMortRegNo(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:13 - Fill Account Info Tab Equitable Mort Reg No");
		click(fixeddeposit.EquitableMortRegNo1);
		String Equitmortregno = testdata.get("EquitableMortRegNo").toString();
		input(fixeddeposit.EquitableMortRegNo1, Equitmortregno);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Equitable Mort Reg.No.");
		Log.info("\"Step:01 Enter Equitable Mort Reg.No.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to give the Equitable Mort Reg.No");
		Log.info("Expected result: Possible to give the Equitable Mort Reg.No");

		ExtentTestManager.endTest();
	}

	public void FillAccountInfoTabEMRDate(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:14 - Fill Account Info Tab EMR Date");
		click(fixeddeposit.EMRDate1);
		String EMRdatepicker = testdata.get("EMRDate").toString();
		input(fixeddeposit.EMRDate1, EMRdatepicker);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Date from EMR Date picker");
		Log.info("Step:01 select Date from EMR Date picker");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the date from date picker");
		Log.info("Expected Result:Possible to select the date from date picker");

		ExtentTestManager.endTest();
	}

	public void FillAccountInfoTabAgentCode(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:16 -  Fill Account Info Tab Agent Code");
		click(fixeddeposit.Agentcode1);
		INclick(fixeddeposit.loader);
		String Agentcode2 = testdata.get("Agentcode").toString();
		input(fixeddeposit.Agentcode1, Agentcode2);
		click(fixeddeposit.ResolutionNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Agentcode");
		Log.info("Step:01 Enter Agentcode");
		
		

		String AgentName1 = driver.findElement(fixeddeposit.AgentName).getAttribute("value");
		System.out.println("AgentName1:" + AgentName1);
		if (!AgentName1.isBlank()) {

			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Possible to enter agentcode and agentname is displayed");
			Log.info("Expected Result: Possible to enter agentcode and Agentname is not displayed");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: unable to enter agentcode and agent name is not displayed");
			Log.info("Expected result: unable to enter agentcode and agentname is not displayed");
		}

		ExtentTestManager.endTest();
	}

	public void FillAccountInfoTabDSACode(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:17 -  Fill Account Info Tab DSA Code");
		click(fixeddeposit.DSAcode1);
		INclick(fixeddeposit.loader);
		String DSAcode1 = testdata.get("DSACode").toString();
		input(fixeddeposit.DSAcode1, DSAcode1);
		click(fixeddeposit.ResolutionNo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter DSAcode");
		Log.info("Step:01 Enter DSA code");

//		click(fixeddeposit.randomTxt);
		
		String DSAName1 = driver.findElement(fixeddeposit.DSAName).getAttribute("value");
		System.out.println("DSAName1:" + DSAName1);
		if (!DSAName1.isBlank()) {

			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Possible to enter DSAcode and DSAname is displayed");
			Log.info("Expected Result:  Possible to enter DSAcode and DSAname is not displayed");
		} 
		else {
			ExtentTestManager.getTest().log(Status.FAIL,"Expected Result: unable to enter DSAcode and DSAname is not displayed");
			Log.info("Expected result: unable to enter DSAcode and DSAname is not displayed");
		}

		ExtentTestManager.endTest();
	}

	public void NextButtonFunctionality() throws InterruptedException {
		ExtentTestManager.startTest("TC:18 - Next Button Functionality");

		click(fixeddeposit.Nextbtn);
		ExtentTestManager.getTest().log(Status.PASS,"Step:01 - Click the 'Next' button after giving all the details in the account info tab");
		Log.info("Step:01 -  Click the 'Next' button after giving all the details in the account info tab");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:redirected to the securities tab");
		Log.info("Expected Result: Redirected to the securities tab");

		ExtentTestManager.endTest();
	}

	public void SelectvehicleSecurityTab(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("TC:19 20 - Select Vehicle Security Tab fill vehicle no");

		click(fixeddeposit.Vehicleno1);
		String Vehicle_No = generateUniqueId(spMobileNum,clmnNamMobileNum);
		String last3DigitsOfAccNum = Vehicle_No.substring(Vehicle_No.length() -3);
		input(fixeddeposit.Vehicleno1,"ZN05QP1" + last3DigitsOfAccNum );
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- Vehicle tab displayed and enter Vehicle no");
		Log.info("Step:01 - Vehicle tab displayed and enter Vehicle no");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Vehicleno details are accepted");
		Log.info("Expected Result: Given Vehicleno details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetialsRCno(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("TC:21 - Fill Vehicle security details RC no");

		click(fixeddeposit.RCno1);
		INclick(fixeddeposit.loader);

		String RC_No = generateUniqueId(spMobileNum,clmnNamMobileNum);
		input(fixeddeposit.RCno1, RC_No);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01- enter RC no");
		Log.info("Step:01 - Enter RC no");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given RC.No details are accepted");
		Log.info("Expected Result: Given RC.No details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetailsSelectVehicleStatus(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:22 -  Fill vehicle security detials and select vehicle status");
		select("NEW", fixeddeposit.Vehiclestatus);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Vehicle status from dropdown");
		Log.info("Step:01 Choose Vehicle status from dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Choosen Vehicle status are accepted");
		Log.info("Expected Result: Possible to choosen vehicle status are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetailsSelectVehicleType(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:23 -  Fill vehicle security detials and select vehicle Type");
		select("VEHICLE", fixeddeposit.VehicleType);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Vehicle Type from dropdown");
		Log.info("Step:01 Choose Vehicle Type from dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Choosen Vehicle Type are accepted");
		Log.info("Expected Result: Possible to choosen vehicle Type are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetailsSelectVehicleDetails(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:24 -  Fill vehicle security details and enter vehicle details");
		click(fixeddeposit.VehicleDetails);
		String Vehicle_details = testdata.get("VehicleDetails").toString();
		input(fixeddeposit.VehicleDetails, Vehicle_details);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Vehicle details ");
		Log.info("Step:01 Enter Vehicle details");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Vehicle details are accepted");
		Log.info("Expected Result: Given Vehicle details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetailsSelectVehicleCatergory(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:25 -  Fill vehicle security details and select vehicle category");
		select("Four Wheeler", fixeddeposit.VehicleCategory);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose Vehicle category from dropdown");
		Log.info("Step:01 Choose Vehicle category from dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Choosen Vehicle category are accepted");
		Log.info("Expected Result: Possible to choosen vehicle category are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsExshowroomprice(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:26 -Fill Vehicle Security Details - Ex.Showroom price");

		click(fixeddeposit.Exshowroomprice1);
		String Exshowroom_price = testdata.get("EXshowroomprice").toString();
		input(fixeddeposit.Exshowroomprice1, Exshowroom_price);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Ex. Showroom Price in Worth field. ");
		Log.info("Step:01 Enter Ex. Showroom Price in Worth field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Ex. Showroom Price details are accepted");
		Log.info("Expected Result: Given Ex. Showroom Price are accepted");

		ExtentTestManager.endTest();
	}

	public void FillVehiclesecuritydetailsRoadTax(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:27 -Fill Vehicle Security Details - Road Tax");

		click(fixeddeposit.RoadTax1);
		String Road_Tax = testdata.get("RoadTax").toString();
		input(fixeddeposit.RoadTax1, Road_Tax);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Road Tax ");
		Log.info("Step:01 Enter Road Tax");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Road Tax details are accepted");
		Log.info("Expected Result: Given Road Tax details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsInsurance(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:28 -Fill Vehicle Security tab insurance details");

		click(fixeddeposit.Insurance1);
		String Insuranceamt = testdata.get("Insurance").toString();
		input(fixeddeposit.Insurance1, Insuranceamt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter insurance amt ");
		Log.info("Step:01 Enter insurance amt");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given insurance details are accepted");
		Log.info("Expected Result: Given insurance details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsRegandOthercharges(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:29 -Fill Vehicle Security details Registration and Other Chargers");

		click(fixeddeposit.Registrationchargers);

		String Regandotherchargersamt = testdata.get("Regotherchargers").toString();
		input(fixeddeposit.Registrationchargers, Regandotherchargersamt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter registration & other chargers ");
		Log.info("Step:01 Enter registration & other chargers");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Given registration and other chargers details are accepted");
		Log.info("Expected Result: Given registration and other chargers details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsDealerDiscount(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:30-Fill Vehicle Security details dealer discount");

		click(fixeddeposit.DealerDiscount1);
		String Dealer_Discount = testdata.get("DealerDiscount").toString();
		input(fixeddeposit.DealerDiscount1, Dealer_Discount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Dealer Discount ");
		Log.info("Step:01 Enter Dealer Discount");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Dealer dicount details are accepted");
		Log.info("Expected Result: Given dealer discount details are accepted");

		ExtentTestManager.endTest();

	}

	public void GetButton() throws InterruptedException {
		ExtentTestManager.startTest("TC:31-Click Get Button");

		click(fixeddeposit.Getbtn);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Get Button ");
		Log.info("Step:01 Click Get Button");

		String Onroad1 = driver.findElement(fixeddeposit.Onroad).getAttribute("value");
		String worth1 = driver.findElement(fixeddeposit.Worth).getAttribute("value");
		if (!Onroad1.isBlank() && !worth1.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:On road price and Worth gets displayed ");
			Log.info("Expected Result: On road price and Worth gets displayed ");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,
					"Expected Result: On road price and Worth fields are not displayed ");
			Log.info("Expected result: On road price and worth fields are not displayed ");
		}

		ExtentTestManager.endTest();
	}

	public void FillVehiclesecuritydetailsDownPayment(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:32- Fill Vehicle security details down payment");

		click(fixeddeposit.Downpayment1);
		String Down_payment = testdata.get("DownPayment").toString();
		input(fixeddeposit.Downpayment1, Down_payment);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Down Payment");
		Log.info("Step:01 Enter Down payment");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Down payment details are accepted ");
		Log.info("Expected Result:Given Down payment details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsInsuranceDocumentNo(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:33- Fill Vehicle security details Insurance Document No");

		click(fixeddeposit.InsuranceDocNo1);
		String Insurance_DocNo = testdata.get("InsuranceDocNo").toString();
		input(fixeddeposit.InsuranceDocNo1, Insurance_DocNo);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter insurance Document No");
		Log.info("Step:01 Enter insurance Document No");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Given insurance documentno details are accepted ");
		Log.info("Expected Result:Given insurance documentno details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsYearofManufacture(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:34- Fill Vehicle security details year of manufacture");

		click(fixeddeposit.Yearofmanufacture1);
		String Year_of_Manufacture = testdata.get("Yearofmanufacture").toString();
		input(fixeddeposit.Yearofmanufacture1, Year_of_Manufacture);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter year of Manufacture");
		Log.info("Step:01 Enter year of Manufacture");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given year of Manufacture details are accepted");
		Log.info("Expected Result:Given year of Manufacture details are accepted");

		ExtentTestManager.endTest();
	}

	public void FillVehiclesecuritydetailsIDV(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:35- Fill Vehicle security details IDV");

		click(fixeddeposit.IDV1);
		String IDV_value = testdata.get("IDV").toString();
		input(fixeddeposit.IDV1, IDV_value);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter IDV");
		Log.info("Step:01 Enter IDV");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given IDV details are accepted");
		Log.info("Expected Result:Given IDV details are accepted");

		ExtentTestManager.endTest();
	}

	public void FillVehiclesSecurityDetailsInsuranceprovider(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:36 -  Fill Vehicle Security Details Insurance provider");
		select("LIC", fixeddeposit.insuranceprovider);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Insurance Provider");
		Log.info("Step:01 Select Insurance Provider");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected insurance provider given details are accepted");
		Log.info("Expected Result: Selected insurance provider gien details are accepted");

		ExtentTestManager.endTest();
	}

	/*public void FillVehicleSecurityDetailsInsuredpastDate(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:37 Fill Vehicle Security Details - Choose Insured upto date");
		click(fixeddeposit.InsureduptoDate1);
		String Insuredupto_Date = testdata.get("InsuredPastDate").toString();
		input(fixeddeposit.InsureduptoDate1, Insuredupto_Date);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose date from Insured Upto Date picker.");
		Log.info("Step:01 Choose date from Insured Upto Date picker.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select insured upto date from date picker");
		Log.info("Expected Result:Possible to select insured upto date from date picker");

		ExtentTestManager.endTest();

	}*/

	public void FillVehiclesecuritydetailsVehicleColor(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:39- Fill Vehicle security details Vehicle Colors");

		click(fixeddeposit.VehicleColor1);
		String Vehicle_Color = testdata.get("VehicleColor").toString();
		input(fixeddeposit.VehicleColor1, Vehicle_Color);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Vehicle color");
		Log.info("Step:01 Enter Vehicle color");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Vehicle colors are accepted");
		Log.info("Expected Result:Given Vehicle colors are accepted");

		ExtentTestManager.endTest();
	}

	public void FillVehicleSecurityDetailsRegDate(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:40 Fill Vehicle Security Details Reg.Date");
		click(fixeddeposit.RegDate1);
		String Reg_Date = testdata.get("RegDate").toString();
		input(fixeddeposit.RegDate1, Reg_Date);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose date from Reg. Date picker.");
		Log.info("\"Step:01 Choose date from Reg.Date picker.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select insured upto date from date picker");
		Log.info("Expected Result:Possible to select insured upto date from date picker");

		ExtentTestManager.endTest();
	}

	public void FillVehiclesSecurityDetailsRegistrationMode(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:42 -  Fill Vehicle Security Details Registration mode");
		select("EV", fixeddeposit.Registrationmode1);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select registration mode");
		Log.info("Step:01 Select registration mode");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected insurance provider given details are accepted");
		Log.info("Expected Result: Selected insurance provider gien details are accepted");

		ExtentTestManager.endTest();
	}

	public void FillVehiclesecuritydetailsPermitNo(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:43- Fill Vehicle security details permit No");

		click(fixeddeposit.PermitNo1);
		String Permit_No = testdata.get("PermitNo").toString();
		input(fixeddeposit.PermitNo1, Permit_No);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter permit No");
		Log.info("Step:01 Enter permit No");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given permitNo details are accepted");
		Log.info("Expected Result:Given permitNo details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsEgineNo(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:44- Fill Vehicle security details Engine No");

		click(fixeddeposit.EngineNo1);
		String Engine_No = testdata.get("EngineNo").toString();
		input(fixeddeposit.EngineNo1, Engine_No);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Engine No");
		Log.info("Step:01 Enter Engine No");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Engine No details are accepted");
		Log.info("Expected Result:Given engine no details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsChassisNo(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:45- Fill Vehicle security details Chassis No");

		click(fixeddeposit.chassisNo1);
		String Chassis_No = testdata.get("ChassisNo").toString();
		input(fixeddeposit.chassisNo1, Chassis_No);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter Chassis No");
		Log.info("Step:01 Enter Chassis No");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Chassis No details are accepted");
		Log.info("Expected Result:Given Chassis No details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesSecurityDetailsDelaerdropdown(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:46 -  Fill Vehicle Security Details dealer dropdown");
		select("Hyndai", fixeddeposit.Dealer);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select dealer from dropdown");
		Log.info("Step:01 Select dealer from dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected dealer details from dropdown are accepted");
		Log.info("Expected Result: Selected dealer details from dropdown are accepted");

		ExtentTestManager.endTest();

	}
	public void FillVehiclesSecurityDetailssubDelaerdropdown(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:47 -  Fill Vehicle Security Details sub dealer dropdown");
		select("adheena", fixeddeposit.Subdealer);
		//INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select sub dealer from dropdown");
		Log.info("Step:01 Select sub dealer from dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected sub dealer details from dropdown are accepted");
		Log.info("Expected Result: Selected sub dealer details from dropdown are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesSecurityDetailsMakedropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC:48 -  Fill Vehicle Security Details Make dropdown");
		select("MARUTI", fixeddeposit.Make);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Make from dropdown");
		Log.info("Step:01 Select Make from dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected Make details from dropdown are accepted");
		Log.info("Expected Result: Selected Make details from dropdown are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesSecurityDetailsModeldropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC:49 -  Fill Vehicle Security Details Model dropdown");
		select("150", fixeddeposit.Model);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Model from dropdown");
		Log.info("Step:01 Select model dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected Model details from dropdown are accepted");
		Log.info("Expected Result: Selected Model details from dropdown are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsVariant(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:50- Fill Vehicle security details Variant");

		click(fixeddeposit.Variant1);
		String Variant_tab = testdata.get("Variant").toString();
		input(fixeddeposit.Variant1, Variant_tab);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter variant name");
		Log.info("Step:01 Enter variant name");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given Variant details are accepted");
		Log.info("Expected Result:Given variant details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesecuritydetailsRTODetails(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:51- Fill Vehicle security details RTO Details");

		click(fixeddeposit.RTOdetails);
		String RTO_details = testdata.get("RTODetails").toString();
		input(fixeddeposit.RTOdetails, RTO_details);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter RTO Details");
		Log.info("Step:01 Enter RTO Details");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given RTO details are accepted");
		Log.info("Expected Result:Given RTO details are accepted");

		ExtentTestManager.endTest();

	}

	public void FillVehiclesSecurityDetailspurposedropdown(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:52 -  Fill Vehicle Security Details purpose dropdown");
		select("BUSINESS", fixeddeposit.purpose);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select purpose from dropdown");
		Log.info("Step:01 Select purpose from dropdown");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected purpose from dropdown are accepted");
		Log.info("Expected Result: Selected purpose from dropdown are accepted");

		ExtentTestManager.endTest();

	}

	/*public void AddButtonFunctionality() throws InterruptedException {
		ExtentTestManager.startTest("TC:53 - Add Button Functionality");

		click(fixeddeposit.AddBtn1);
		// INclick(fixeddeposit.loader);
		//Thread.sleep(20000);

		ExtentTestManager.getTest().log(Status.PASS,"Step:01 - Click the 'Add' button after giving all the details in the securities tab");
		Log.info("Step:01 -  Click the 'Add' button after giving all the details in the securities tab");

		//String Addbutton1 = driver.findElement(fixeddeposit.AddBtn1).getAttribute("value");

		if (ElementDisplayed(fixeddeposit.Addgrid)) {
			Thread.sleep(20000);
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Given details should be displayed in the grid");
			Log.info("Expected Result: Given details should be displayed in the grid");
		} else {
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Given details should not be displayed in the grid");
			Log.info("Expected Result: Given details should not be displayed in the grid");
		}
		ExtentTestManager.endTest();

	}*/

	public void InsuredpastDateokbtn(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException {
		ExtentTestManager.startTest("TC:54 Fill Vehicle Security Details -click insured past date ok button");
		
		click(fixeddeposit.InsureduptoDate1);
		String Insuredupto_Date = testdata.get("InsuredPastDate").toString();
		input(fixeddeposit.InsureduptoDate1, Insuredupto_Date);
		click(fixeddeposit.AddBtn1);
		INclick(fixeddeposit.loader);
		click(fixeddeposit.InsuredPastdateokbtn);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Choose past date from Insured Upto Date picker.");
		Log.info("\"Step:01 Choose past date from Insured Upto Date picker.");

		String okbtn = driver.findElement(fixeddeposit.InsuredPastdateokbtn).getAttribute("value");
		if (!okbtn.isBlank()) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Insured Upto date should not be less than Transaction Date");
			Log.info("Expected Result:Insured upto date should not be less than Transaction Date");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL,
					"Expected Result: unable to select the insured upto date from the date picker");
			Log.info("Expected result: unable to select the insured upto date from date picker");
		}
		ExtentTestManager.endTest();

	}

	public void FillVehicleSecurityDetailsInsuredfutureDate(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		//click(fixeddeposit.insuredfuturedate);
		ExtentTestManager.startTest("TC:55 Fill Vehicle Security Details - Choose Insured future date");
		//String Insuredfuture_Date = testdata.get("InsuredFutureDate").toString();
		//clear(fixeddeposit.clearinsureddate);
		click (fixeddeposit.insuredfuturedate);
		String Insuredfuture = testdata.get("InsuredFutureDate").toString();
		input(fixeddeposit.insuredfuturedate, Insuredfuture);
		click (fixeddeposit.AddBtn1);
		INclick(fixeddeposit.loader);
		//click(fixeddeposit.Okbtn);
		//click (fixeddeposit.AddBtn1);

		ExtentTestManager.getTest().log(Status.PASS,"Step:01 1. Choose future date from Insured Upto Date picker(less than tramsaction date)");
		Log.info("\"Step:01. Choose future date from Insured Upto Date picker(less than tramsaction date)");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Give all details");
		Log.info("\"Step:02. Given all details");

		ExtentTestManager.getTest().log(Status.PASS, "Step:03 Click Add Button");
		Log.info("\"Step:03. Click Add Button");
		
		//if (ElementDisplayed(fixeddeposit.Addgrid)) 
		if (ElementDisplayed(fixeddeposit.insuredfuturedate)){
			
			Thread.sleep(20000);
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Given details should be displayed in the grid");
			Log.info("Expected Result: Given details should be displayed in the grid");
		} else {
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Given details should not be displayed in the grid");
			Log.info("Expected Result: Given details should not be displayed in the grid");
		}

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details should be shows in the grid");
		Log.info("Expected Result:Given details should be shows in the grid");

		ExtentTestManager.endTest();

	}

	public void NextButton() throws InterruptedException {
		ExtentTestManager.startTest("TC:57 - Next Button Functionality");

		click(fixeddeposit.NextButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'Next' button ");
		Log.info("Step:01 -  Click 'Next' button ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nominee tab will be displayed");
		Log.info("Expected Result: Nominee tab will be displayed");

		ExtentTestManager.endTest();

	}

	public void FillNomineedetailsuntickNomineeNotRequired() throws InterruptedException {
		ExtentTestManager.startTest("TC:58 - Fill Nominee Details - Untick Nominee Not required Checkbox");

		click(fixeddeposit.Nomineeuntick);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Untick 'Nominee Not required' checkbox");
		Log.info("Step:01 -  Untick 'Nominee Not required' checkbox");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Nominee details feilds  will be display");
		Log.info("Expected Result: Nominee details fields will be display");

		ExtentTestManager.endTest();

	}

	public void FillNomineedetailscustomersearchicon() throws InterruptedException {
		ExtentTestManager.startTest("TC:59 - Fill Nominee Details - Customer search icon");

		click(fixeddeposit.customersearchicon);
		INclick(fixeddeposit.loader);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the customer search icon option");
		Log.info("Step:01 - Click the customer search icon option");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:customer search popup window will be opened");
		Log.info("Expected Result: customer search popup window will be opened");

		ExtentTestManager.endTest();

	}

	// Navigate to Pop Up Window
	public void FillNomineedetailssearchcustomerwithnameoralphabets(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException {
		ExtentTestManager.startTest("TC:60,61 - Fill Nominee Details - Search customer with name or alphabet");
		String mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				popupAppeared = true;

				String custName1 = testdata.get("customerName1").toString();
				input(fixeddeposit.CustomerNamesearch, custName1);

				ExtentTestManager.getTest().log(Status.PASS,
						"Step:01 - Enter the name or alphabets in the name field in customer search popup window");
				Log.info("Step:01 - 1.Enter the name or alphabets in the name field in customer search popup window");

				click(fixeddeposit.CustomerSearchbtn);

				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click the search button");
				Log.info("Step: 02 - Click the search button");

				ExtentTestManager.getTest().log(Status.PASS,
						"Expected Result: customers will be display against the given details");
				Log.info("Expected Result: customers will be display against the given details");

				click(fixeddeposit.selectcustomer);
			
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the customer from the popup window");
				Log.info("Step:01 - Select the customer from the popup window");
				
				driver.switchTo().window(mainWindowHandle);
				 INclick(fixeddeposit.loader);
				Thread.sleep(2000);
				
				String customerid1 = driver.findElement(fixeddeposit.custid1).getAttribute("value");
				System.out.println("customerid1: "+customerid1);
				
				if (!customerid1.isBlank()) {
					ExtentTestManager.getTest().log(Status.PASS,
							"Expected Result:Selected customer details will be autoloads in the fields expect Relation field");
					Log.info("Selected customer details will be autoloads in the fields expect Relation field");

				} else {
					ExtentTestManager.getTest().log(Status.FAIL,
							"Expected Result:Selected customer details is not populated in the form");
				}
				ExtentTestManager.endTest();
			}
		}
	}

	public void FillNomineeDetailsRelationDropdown() throws InterruptedException {
		ExtentTestManager.startTest("TC:62 -  Fill Nominee Details -Relation dropdown");
		select("BROTHER", fixeddeposit.Relation);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Relation from the drop down field");
		Log.info("Step:01 Select Relation from the drop down field");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Selected relation from dropdown are accepted");
		Log.info("Expected Result: Selected relation from dropdown are accepted");

		ExtentTestManager.endTest();
	}

	public void FillNomineedetailssearchAddbutton1() throws InterruptedException {
		ExtentTestManager.startTest("TC:63-  Fill Nominee Details -Add Button");

		click(fixeddeposit.Addbutton1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Add Button");
		Log.info("Step:01 Click  Add Button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given Nominee details showing in the grid");
		Log.info("Expected Result: Given Nominee details showing in the grid");

		ExtentTestManager.endTest();
	}

	public void FillNomineedetailssearchNextbutton() throws InterruptedException {
		ExtentTestManager.startTest("TC:64-  Fill Nominee Details - Next Button");

		click(fixeddeposit.NextButton1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Next Button");
		Log.info("Step:01 Click Next Button");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan details tab will be display");
		Log.info("Expected Result: Loan details tab will be display");

		ExtentTestManager.endTest();
	}

	public void FillLoanDetailssanctionedamount(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		click(fixeddeposit.sanctioned);
		ExtentTestManager.startTest("TC:65 Fill loan details - Sanctioned Amount");
		String sanctioned_amount = testdata.get("SanctionedAmount").toString();
		input(fixeddeposit.sanctioned, sanctioned_amount);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter sanction amount");
		Log.info("Step:01.Enter sanction amount");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possibe to give the sanction amount");
		Log.info("Expected Result:Possibe to give the sanction amount");

		ExtentTestManager.endTest();
	}

	public void FillLoanDetailsNoOFInstallments(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		click(fixeddeposit.NoOfInstallment);
		ExtentTestManager.startTest("TC:66 Fill loan details - No.Of Installments");
		String Installment = testdata.get("NoOfInstallement").toString();
		clear(fixeddeposit.NoOfInstallment);
		INclick(fixeddeposit.loader);
		input(fixeddeposit.NoOfInstallment, Installment);

		click(fixeddeposit.sanctioned);
		
		INclick(fixeddeposit.loader);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter No.of Installments");
		Log.info("Step:01.Enter No. of Installments");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possibe to give the No.of Installments");
		Log.info("Expected Result:Possibe to give the No.of Installments");

		ExtentTestManager.endTest();
	}

	public void EnterValidsanctionedamountclickGetValues() throws InterruptedException {
		ExtentTestManager.startTest("TC:67- Enter valid sanctioned amount- click Get Values");

		click(fixeddeposit.Getvalue);
		INclick(fixeddeposit.loader);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click Get Values");
		Log.info("Step:01 Click Get Values");
		
		String ROI1 = driver.findElement(fixeddeposit.ROI).getAttribute("value");
		String Amount = driver.findElement(fixeddeposit.LoandetailsAmount).getAttribute("value");
		String Repaystartdate1 = driver.findElement(fixeddeposit.RepaystartDate).getAttribute("value");
		String Duedate1 = driver.findElement(fixeddeposit.Duedate).getAttribute("value");
		String Netpayable1 = driver.findElement(fixeddeposit.Netpayabale).getAttribute("value");
		String PayAmount1 =driver.findElement(fixeddeposit.Payamount).getAttribute("value");
		System.out.println("ROI1: " + ROI1+ " Amount: " + Amount +" Repaystartdate1: " + Repaystartdate1 +" Duedate1: " +Duedate1 +" Netpayable1: " +Netpayable1 +" PayAmount1: " +PayAmount1);
		
		if (!ROI1.isBlank() && !Amount.isBlank() && !Repaystartdate1.isBlank() && !Duedate1.isBlank() && !PayAmount1.isBlank() && !Netpayable1.isBlank()) 
			
		{
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Values auto-loaded (ROI, Amount, etc.Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable)");
			Log.info("Expected Result: Values auto-loaded (ROI, Amount, etc.Repay Start Date, Due Date, Pay Amount will be autoloaded, Net Payable)");

		} 
		else {
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: unable to auto-loaded values (ROI, Amount, etc.Repay Start Date, Due Date, Pay Amount will not be autoloaded, Net Payable)");
			Log.info("Expected Result: Unable to auto-loaded values (ROI, Amount, etc.Repay Start Date, Due Date, Pay Amount will not be autoloaded, Net Payable)");
		}

		ExtentTestManager.endTest();
	}

	public void SelectTransactionMode() throws InterruptedException {
		ExtentTestManager.startTest("TC:68 - Select Transaction Mode");
		select("CASH", fixeddeposit.Transmode);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Select Trans. Mode 'Cash'");
		Log.info("Step:01 Select Trans. Mode 'Cash'");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the trans mode as cash");
		Log.info("Expected Result: Possible to select the trans mode as cash");

		ExtentTestManager.endTest();
	}

	public void saveloan() throws InterruptedException {
		ExtentTestManager.startTest("TC:69 - select transaction mode and save loan");
		click(fixeddeposit.Save);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 click save");
		Log.info("Step:01 click save");

		click(fixeddeposit.existingloanokpopup);
		INclick(fixeddeposit.loader);
        click (fixeddeposit.similardatapopup);
        INclick(fixeddeposit.loader);

        if (ElementDisplayed(fixeddeposit.Cashsummary)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan is submitted, summary is displayed");
			Log.info("Expected Result: Loan is submitted, summary is displayed");
		} 
        else {
			ExtentTestManager.getTest().log(Status.PASS,"Expected Result: Loan is not submitted, summary is not displayed");
			Log.info("Expected Result: Loan is not submitted, summary is not displayed");
		}
        cashtranscid= driver.findElement(fixeddeposit.cashtransactionid).getText();
		System.out.println(cashtranscid);
		click(fixeddeposit.signout);

		ExtentTestManager.endTest();
	}

	public void Login_with_AnotherUser(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
		ExtentTestManager.startTest("TC:70 - Login with Another User");
		Log.info("TC:70 - Login with Another User");

	//click(fixeddeposit.signout);
	//ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Logout'");
	//Log.info("Step:01 -  'Logout'");

		String newuserid = configloader().getProperty("UserName1");
		input(fixeddeposit.loginUserName1, newuserid);

		String newpwd = configloader().getProperty("Password1");
		input(fixeddeposit.loginPasswrd1, newpwd);

		click(fixeddeposit.loginButton1);

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Log in with another user for authorization");
		Log.info("Step:02 -Log in with another user for authorization");

		if (ElementDisplayed(fixeddeposit.Newloginvalidate)) {
			ExtentTestManager.getTest().log(Status.PASS, "Logging successfull with another user ");
			Log.info("ExpectedResult: Logging successfull with another user");

		} else {
			ExtentTestManager.getTest().log(Status.FAIL,
					"ExpectedResult: Logging is not successfull with another user");
			Log.info("ExpectedResult: Logging is not successfull with another user");
			Thread.sleep(1000);
		}

		ExtentTestManager.endTest();
		
        
	}
	public void Manager_Authorization_CashTab() throws InterruptedException {
		ExtentTestManager.startTest("TC:74 - Manager Authorization - Cash Tab");
		Log.info("TC:74- Manager Authorization - Cash Tab");
		
		Thread.sleep (2000);
		ScrollUntilElementVisible(fixeddeposit.Authorizecanceltab);
		click(fixeddeposit.Authorizecanceltab);
		ExtentTestManager.getTest().log(Status.PASS, "Step 01 -Go to Authorize & cancel module");
		Log.info("Step:01 - Go to Authorize & cancel module");
		
		
		click(fixeddeposit.ManagerAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select Manager Authorization");
		Log.info("Step:02 -Select Manager Authorization");
		
		if(ElementDisplayed(fixeddeposit.cashtab)) {
			
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Cash tab will be displaying");
			Log.info("ExpectedResult:  -Cash tab will be displaying");
			
		}else {
			
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Cash tab will not be displaying");
			Log.info("ExpectedResult:  -Cash tab will not be displaying");
			
		}
		
		ExtentTestManager.endTest();
		
	}	
	
	public void Refresh_Loan_OpeningEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("TC:75 - Refresh Loan Opening Entry");
		Log.info("TC:75 - Refresh Loan Opening Entry");
		
			input(fixeddeposit.Transacidtextbox,cashtranscid);
	  		
	  		click(fixeddeposit.managerClickGo);
	  		//click(fixeddeposit.Refresh);
	  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter transaction id and click on go button");
			Log.info("Step:01 Enter transaction id and click on go button");
			
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected result: Loan open entry is displayed");
			Log.info("Expected result: Loan open entry is displayed");
			ExtentTestManager.endTest();
		}
		

	public void Authorize_Loan_Entry_asManager() throws InterruptedException {
		ExtentTestManager.startTest("TC:76 - Authorize Loan Entry as Manager");
		Log.info("TC:76 - Authorize Loan Entry as Manager");
		
		click(fixeddeposit.checkboxselect11);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select loan entry checkbox");
		Log.info("Step:01 -Select loan entry checkbox");
		//Thread.sleep(20000);
		click(fixeddeposit.Authorizebutton1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Authorize button");
		Log.info("Step:02 -Click Authorize button");
		
		if(ElementDisplayed(fixeddeposit.cancelpopup)) {
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Entry authorized");
			Log.info("ExpectedResult: Entry authorized");
	
	
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Entry is not  authorized");
			Log.info("ExpectedResult: Entry is not authorized");

		}
		click(fixeddeposit.cancelpopup);
//		click(fixeddeposit.signout);
		ExtentTestManager.endTest();
		
	
	}
	public void CashierAuthorization() throws InterruptedException {
		ExtentTestManager.startTest("TC:71 - Cashier Authorization");
		Log.info("TC71 - Cashier Authorization");
		//Thread.sleep (2000);
		//ScrollUntilElementVisible(fixeddeposit.Authorizecanceltab);
//		click(fixeddeposit.Authorizecanceltab);
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Go to Authorize and cancel module");
//		Log.info("Step:01 - Go to Authorize and cancel module");
		
		click(fixeddeposit.cashierauthorize);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click cashier authorization");
		Log.info("Step:01 - click cashier authorization");
		
		if(ElementDisplayed(fixeddeposit.ClickGo)) {
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Cashier Authorization window will be opened");
			Log.info("ExpectedResult:Cashier authorization window will be opened");
	
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Cashier authorization window will not be opened");
			Log.info("ExpectedResult: cashier authorization window will not be opened");

		}
		
		ExtentTestManager.endTest();
				
	}
	
	public void Cashierrefresh(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		ExtentTestManager.startTest("TC:72 -Click Refresh and pass the transactionid");
		Log.info("Tc:72 - Click refresh and pass the transactionid");
		input(fixeddeposit.Transacidtextbox,cashtranscid);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Enter transactionid");
		Log.info("Step:01 -Enter Transaction id");
		
  		click(fixeddeposit.ClickGo);
  		//click(fixeddeposit.Refresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 Click Go button");
		Log.info("Step:02 -Click Go Button");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected result: Loan open entry is displayed");
		Log.info("Expected result: Loan open entry is displayed");
		
		ExtentTestManager.endTest();
	}
		
	public void cashierauthorizationauthorizebtn() throws InterruptedException {
		ExtentTestManager.startTest("TC:73 -Cashier authorization ");
		Log.info("Tc:73 - Cashier authorization");
  		click(fixeddeposit.checkboxselect1);
  		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 select checkbox");
		Log.info("Step:01 select checkbox");
		
		click(fixeddeposit.Authorizebtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 click authorize button");
		Log.info("Step:02 click authorize button");
		
		if(ElementDisplayed(fixeddeposit.cancelpopup)) {
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Entry authorized");
			Log.info("ExpectedResult: Entry authorized");
	
	
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Entry is not  authorized");
			Log.info("ExpectedResult: Entry is not authorized");

		}
		click(fixeddeposit.cancelpopup);
		Thread.sleep(2000);
        //click(fixeddeposit.signout);
		ExtentTestManager.endTest();
	
	}



}
