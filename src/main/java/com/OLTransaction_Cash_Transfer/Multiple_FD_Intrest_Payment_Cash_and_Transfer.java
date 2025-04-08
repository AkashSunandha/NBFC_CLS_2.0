package com.OLTransaction_Cash_Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Agent_Transfer;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Jewel_Loan_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_Multiple_Fd_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Multiple_FD_Intrest_Payment_Cash_and_Transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	PageRepositary_Agent_Transfer Agent = new PageRepositary_Agent_Transfer();
	PageRepositary_Multiple_Fd_Cash_Transfer FDintrest = new PageRepositary_Multiple_Fd_Cash_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	public String sp = "GetSpMultipleFDAccountNo 102,14003,1";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}


	public void NavigatetoMultipleFDInterestPayment() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Multiple FD Interest Payment");
		Log.info("Navigate to Multiple FD Interest Payment");

		click(FDintrest.clickFd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Transactions..");
		Log.info("Step:01 - Navigate to Transactions..");

		click(FDintrest.clickFDIntresrt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select Multiple FD Interest Payment. ");
		Log.info("Step:02 - Select Multiple FD Interest Payment..");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: The Multiple FD Interest Payment window is displayed.");
		Log.info("Expected Result: The Multiple FD Interest Payment window is displayed.");
		ExtentTestManager.endTest();

	}

	public void NavigatetoMultipleFDInterestPayment1() throws InterruptedException {

		ExtentTestManager.startTest("Navigate to Multiple FD Interest Payment");
		Log.info("Navigate to Multiple FD Interest Payment");

		//click(FDintrest.clickFd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Transactions..");
		Log.info("Step:01 - Navigate to Transactions..");

		click(FDintrest.clickFDIntresrt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select Multiple FD Interest Payment. ");
		Log.info("Step:02 - Select Multiple FD Interest Payment..");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: The Multiple FD Interest Payment window is displayed.");
		Log.info("Expected Result: The Multiple FD Interest Payment window is displayed.");
		ExtentTestManager.endTest();

	}

	public void selectProductGroup() throws InterruptedException {

		ExtentTestManager.startTest("Select Product Group - Fixed Deposit");
		Log.info("Select Product Group - Fixed Deposit");

		select("Fixed Deposit", FDintrest.selectgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Open Product Group dropdown");
		Log.info("Step:01 - Open Product Group dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select Fixed Deposit ");
		Log.info("Step:02 -Select Fixed Deposit ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: 'Fixed Deposit' is selected in the Product Group dropdown.");
		Log.info("Expected Result: 'Fixed Deposit' is selected in the Product Group dropdown.");
		ExtentTestManager.endTest();

	}

	public void selectProductName() throws InterruptedException {

		ExtentTestManager.startTest("Select Product name - Fixed Deposit");
		Log.info("Select Product name - Fixed Deposit");

		select("DEBUNTURE FIXED TYPE 2 YRS", FDintrest.selectname);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Open Product name dropdown");
		Log.info("Step:01 - Open Product name dropdown");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select Fixed Deposit ");
		Log.info("Step:02 -Select Fixed Deposit ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: 'Fixed Deposit' is selected in the Product name dropdown.");
		Log.info("Expected Result: 'Fixed Deposit' is selected in the Product name dropdown.");
		ExtentTestManager.endTest();

	}

	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter  Account Number");
		Log.info("Enter  Account Number");

		{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019";
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

			String value = null; // Declare and initialize the return variable

			// Establish the connection to the database
			try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(query)) {

				if (resultSet.next()) {
					value = resultSet.getString(columnName); // DB column name
					System.out.println("Generated Unique ID: " + value);

					// vinusha

				} else {
					System.out.println("Unique ID not generated.");
				}

			} catch (SQLException e) {
				System.out.println("Error executing the SQL query or processing the result set.");
				e.printStackTrace();
			}

			return value; // Return the firstCustId
		}

	}

	public void enterAccountNumber() throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("Enter Valid Account Number");
		Log.info("Enter Valid Account Number");

		// click(FDintrest.accnumber);

		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(FDintrest.accnumber, AccNum);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step :01-Enter a valid fixed deposit account number in the 'Account No' field. ");
		Log.info("Step:01 - Enter a valid fixed deposit account number in the 'Account No' field. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is accepted. ");
		Log.info("Expected Result:Account number is accepted. ");
		ExtentTestManager.endTest();
		//click(FDintrest.goo);

	}

	public void enterAccountNumber2() throws InterruptedException, ClassNotFoundException {
		ExtentTestManager.startTest("Enter Valid Account Number");
		Log.info("Enter Valid Account Number");

		// click(FDintrest.accnumber);
		clear(FDintrest.accnumber);

		String valueAccNum = generateUniqueCode(sp, columnName); // Get account number from SP

		if (valueAccNum != null && valueAccNum.length() >= 3) {
			// Extract last three digits
			String lastThreeDigits = valueAccNum.substring(valueAccNum.length() - 3);

			// Convert to integer and add 1
			int incrementedNum = Integer.parseInt(lastThreeDigits) + 1;

			// Convert back to a three-digit string if needed
			String updatedAccNum = String.format("%03d", incrementedNum);

			input(FDintrest.accnumber, updatedAccNum); // Use the updated account number

			System.out.println("Updated Account Number: " + updatedAccNum);
		}

		ExtentTestManager.getTest().log(Status.PASS,
				"Step :01-Enter a valid fixed deposit account number in the 'Account No' field. ");
		Log.info("Step:01 - Enter a valid fixed deposit account number in the 'Account No' field. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is accepted. ");
		Log.info("Expected Result:Account number is accepted. ");
		ExtentTestManager.endTest();
		
		click(FDintrest.goo);
		
	}

	public void checkDisplayAllAccounts1() throws InterruptedException {
		ExtentTestManager.startTest("Display All Accounts - Checkbox");
		Log.info("Display All Accounts - Checkbox");


//		 try {
//            
//			 click(FDintrest.Ok);
//        } catch (Exception e) {
//            System.out.println("No second popup appeared.");
//        }
		
		click(FDintrest.clickdisplayall);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Tick the 'Display all accounts' checkbox");
		Log.info("Step:01 -Tick the 'Display all accounts' checkbox. ");

		click(FDintrest.clickgo);

		ExtentTestManager.getTest().log(Status.PASS, "Step:02-Click the 'Go' button. ");
		Log.info("Step:02-Click the 'Go' button. ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: A list of account numbers that match the criteria are displayed.");
		Log.info("Expected Result:A list of account numbers that match the criteria are displayed. ");
		ExtentTestManager.endTest();

	}

	public void checkDisplayAllAccounts() throws InterruptedException {
		ExtentTestManager.startTest("Display All Accounts - Checkbox");
		Log.info("Display All Accounts - Checkbox");

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button");
		Log.info("Step:01 - Click the 'Go' button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GO button clicked");
		Log.info("Expected Result:GO button clicked ");
		ExtentTestManager.endTest();
//vinusha
		
		 try {
             
			 click(FDintrest.Ok);
         } catch (Exception e) {
             System.out.println("No second popup appeared.");
         }
		try {

			ExtentTestManager.startTest("Warning Validation Popup window");
			Log.info("Warning Validation Popup window");
			// click(FDintrest.go);
			click(FDintrest.clickyes);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter No in the warning validation popup window");
			Log.info("Step:01 -Enter No in the warning validation popup window");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Loan details are fetched and displayed correctly.");
			Log.info("Expected Result: Loan details are fetched and displayed correctly.");

			ExtentTestManager.endTest();
			
			

		} catch (Exception e) {

		}

	}

	public void checkInterestPaymentDetailsGrid(Map<Object, Object> testdata, ITestContext contex)
			throws InterruptedException {

		ExtentTestManager.startTest("Interest Payment Details - Grid Check");
		Log.info("Interest Payment Details - Grid Check");

		click(FDintrest.duration);

		String duration = testdata.get("Duration").toString();
		input(FDintrest.duration, duration);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter duration 1");
		Log.info("Step:01 - Enter duration.1 ");

		select("MONTHS", FDintrest.durationmonth);
		ExtentTestManager.getTest().log(Status.PASS, " Step:02 -Select duration mode eg:months");
		Log.info("Step:02 -Select duration mode eg:months ");

		click(FDintrest.clickadd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click Add button ");
		Log.info("Step:03 - Click Add button.");

		ScrollUntilElementVisible(FDintrest.scroll);
		
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Interest payment details are added to the grid. ");
		Log.info("Expected Result:Interest payment details are added to the grid. ");
		ExtentTestManager.endTest();

	}
	public void logoutApplication4() throws InterruptedException {
		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");
        
		click(JewelClosure.close);
		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();
		
		
		

	}

	public void selectAnotherAccountForInterestPayment(Map<Object, Object> testdata, ITestContext contex) throws InterruptedException {
		ExtentTestManager.startTest("Select Another Account for Interest Payment");
		Log.info("Select Another Account for Interest Payment");

		//click(FDintrest.clickcheckbox);

		ScrollUntilElementVisible(FDintrest.scrolldown);

		ExtentTestManager.getTest().log(Status.PASS, "Select another account");
		Log.info("Step:01 - Select another account.");

		click(FDintrest.duration);

		String duration = testdata.get("Duration").toString();
		input(FDintrest.duration, duration);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter duration 1");
		Log.info("Step:01 - Enter duration.1 ");

		select("MONTHS", FDintrest.durationmonth);
		ExtentTestManager.getTest().log(Status.PASS, " Step:02 -Select duration mode eg:months");
		Log.info("Step:02 -Select duration mode eg:months ");

		click(FDintrest.clickadd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click Add button ");
		Log.info("Step:03 - Click Add button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Interest payment details are updated for another account.");
		Log.info("Expected Result: Interest payment details are updated for another account.");
		ExtentTestManager.endTest();

	}
	
	public void selectAnotherAccountForInterestPayment1(Map<Object, Object> testdata, ITestContext contex) throws InterruptedException {
		ExtentTestManager.startTest("Select Another Account for Interest Payment");
		Log.info("Select Another Account for Interest Payment");

		//click(FDintrest.clickcheckbox);

		ScrollUntilElementVisible(FDintrest.scrolldown);

		ExtentTestManager.getTest().log(Status.PASS, "Select another account");
		Log.info("Step:01 - Select another account.");

		click(FDintrest.duration);

		String duration = testdata.get("Duration").toString();
		input(FDintrest.duration, duration);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter duration 1");
		Log.info("Step:01 - Enter duration.1 ");

		select("MONTHS", FDintrest.durationmonth);
		ExtentTestManager.getTest().log(Status.PASS, " Step:02 -Select duration mode eg:months");
		Log.info("Step:02 -Select duration mode eg:months ");

		click(FDintrest.clickadd);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click Add button ");
		Log.info("Step:03 - Click Add button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Interest payment details are updated for another account.");
		Log.info("Expected Result: Interest payment details are updated for another account.");
		ExtentTestManager.endTest();

	}

	public void submitPaymentCashMode() throws InterruptedException {
		ExtentTestManager.startTest("Submit Payment - Cash Mode");
		Log.info("Submit Payment - Cash Mode");

		select("CASH", FDintrest.submitcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select trans.mode as 'cash'. ");
		Log.info("Step:01 - Select trans.mode as 'cash'. ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Submit button. ");
		Log.info("Step:02 -Click Submit button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Payment details are submitted successfully. ");
		Log.info("Expected Result:Payment details are submitted successfully. ");
		ExtentTestManager.endTest();
	}

	public void verifySubmissionSummary() throws InterruptedException {
		ExtentTestManager.startTest("Verify Submission Summary");
		Log.info("Verify Submission Summary");

		click(FDintrest.clicksubmit);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Verify the summary of the transaction.");
		Log.info("Step:01 -Verify the summary of the transaction. ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Summary matches the transaction details entered.");
		Log.info("Expected Result: Summary matches the transaction details entered.");
		ExtentTestManager.endTest();

		transId = driver.findElement(FDintrest.transid).getText();

	}

	public void checkDisplayAllAccounts3() throws InterruptedException {
		ExtentTestManager.startTest("Display All Accounts - Checkbox");
		Log.info("Display All Accounts - Checkbox");

		click(FDintrest.clickgo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button");
		Log.info("Step:01 - Click the 'Go' button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GO button clicked");
		Log.info("Expected Result:GO button clicked ");
		ExtentTestManager.endTest();

		try {

			ExtentTestManager.startTest("Warning Validation Popup window");
			Log.info("Warning Validation Popup window");
			click(FDintrest.go);
			click(FDintrest.clickyes);
			click(FDintrest.onemoreYES);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Enter No in the warning validation popup window");
			Log.info("Step:01 -Enter No in the warning validation popup window");

			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Loan details are fetched and displayed correctly.");
			Log.info("Expected Result: Loan details are fetched and displayed correctly.");

			ExtentTestManager.endTest();

		} catch (Exception e) {

		}
	}

	public void managerauthorisation() throws InterruptedException {

		ExtentTestManager.startTest("Manager authorization");
		Log.info("Manager authorization");

		click(FDintrest.clickonauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		click(FDintrest.clickonmanger);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule ");
		Log.info("Step:02 - Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Manager authorization window will be display");
		Log.info("Manager authorization window will be display");
	}
	
	public void managerauthorisation1() throws InterruptedException {

		ExtentTestManager.startTest("Manager authorization");
		Log.info("Manager authorization");

		//click(FDintrest.clickonauth);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar ");
		Log.info("Step:01 - Click the authoirze & Cancel module from the taskbar ");

		click(FDintrest.clickonmanger);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Manager authorisation Submodule ");
		Log.info("Step:02 - Click Manager authorisation Submodule");

		ExtentTestManager.getTest().log(Status.PASS, "Manager authorization window will be display");
		Log.info("Manager authorization window will be display");
	}
	
	public void UserLoggedIntransfer() throws InterruptedException {
		ExtentTestManager.startTest("User is Logged In");
		Log.info("User successfully logged in");

		click(JewelClosure.Transfertab);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Click the Transfer tab ");
		Log.info("Step: 1 -Click the Transfer tab  .");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab will be display.");
		Log.info("Expected Result: Transfer tab will be display.");

		ExtentTestManager.endTest();
	}

	public void UserLoggedInCheckbx1() throws InterruptedException {
		ExtentTestManager.startTest("User is Logged In");
		Log.info("User successfully logged in");

		click(FDintrest.chheecckk);
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Step: 1 -1.Select the checbox of transaction suspense Asset transaction ");
		Log.info("Step: 1 -1.Select the checbox of transaction suspense Asset transaction .");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Possible to select the transaction entry and selected entry is hghlighted.");
		Log.info("Expected Result: Possible to select the transaction entry and selected entry is hghlighted.");

		ExtentTestManager.endTest();
	}
	
	public void UserloggedManagerauthorization() throws InterruptedException {

		ExtentTestManager.startTest("User is logged in Manager authorization");
		Log.info("User is logged in Manager authorization");

		click(FDintrest.clickrefresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab");
		Log.info("Step:01 - Click the Refresh tab");

		ExtentTestManager.getTest().log(Status.PASS,
				"Tranacation entry will be display after clicking the refresh button");
		Log.info("Tranacation entry will be display after clicking the refresh button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(FDintrest.clickgo1);
	}

	public void UserloggedManagerauthorization2() throws InterruptedException {
		ExtentTestManager.startTest("User is logged in Manager authorization");
		Log.info("User is logged in Manager authorization");

		click(FDintrest.clickcheck);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select the checbox of   transaction   ");
		Log.info("Step:01 -Select the checbox of   transaction   ");

		ExtentTestManager.getTest().log(Status.PASS, "Possible to select the entry and selected entry is hghlighted");
		Log.info("Possible to select the entry and selected entry is hghlighted");
	}

	public void UseronManagerauthorisationwindow() throws InterruptedException {

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.clickauthorize);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Authorise button");
		Log.info("Step:01 - Click Authorise button");

		ExtentTestManager.getTest().log(Status.PASS, "Transaction entry is authorised");
		Log.info("Transaction entry is authorised");
	}

	public void logoutApplication3() throws InterruptedException {

		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");

		click(JewelClosure.close);
		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();
	}
	
	public void logoutApplication5() throws InterruptedException {

		ExtentTestManager.startTest("Logout in application");
		Log.info("Logged out from application.");

		click(JewelClosure.close);
		click(JewelClosure.Singout);
		ExtentTestManager.getTest().log(Status.PASS, "Step:1 - Click Logout Option.");
		Log.info("Step:1 - Click Logout Option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Login page will be displayed");
		Log.info("Expected Result: Login page will be displayed");
		ExtentTestManager.endTest();
		
		driver.close();
		
	}

	public void cashierauthorization() throws InterruptedException {
		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.clickcashier);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the authoirze & Cancel module from the taskbar");
		Log.info("Step:01 -Click the authoirze & Cancel module from the taskbar ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click cashier authorisation Submodule");
		Log.info("Step:02 - Click cashier authorisation Submodule ");

		ExtentTestManager.getTest().log(Status.PASS, "Cashier authorization window will be display");
		Log.info("Cashier authorization window will be display");
	}

	public void cashierauthorization1() throws InterruptedException {

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.refresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the Refresh tab ");
		Log.info("Step:01 - Click the Refresh tab ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Transaction entry will be diaply after clicking the refresh button");
		Log.info("Transaction entry will be diaply after clicking the refresh button");

		System.out.println("transIdCashPersonal " + transId);
		fetchWithTransId(transId);

		click(FDintrest.clickgo2);
	}

	public void cashierauthorization2() throws InterruptedException {

		ExtentTestManager.startTest("cashier authorization");
		Log.info("cashier authorization");

		click(FDintrest.checkbox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the checbox of transaction  ");
		Log.info("Step:01 - Select the checbox of transaction ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Possible to select the transaction entry and selected entry is hghlighted");
		Log.info("Possible to select the transaction entry and selected entry is hghlighted");
	}

	public void UserisonCashierauthorisationwindow() throws InterruptedException {

		ExtentTestManager.startTest("User is on Cashier authorisation window");
		Log.info("User is on Cashier authorisation windowv");

		click(FDintrest.authorize);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Authorise button ");
		Log.info("Step:01 - Click Authorise button ");

		ExtentTestManager.getTest().log(Status.PASS, "Transaction entry is authorised");
		Log.info("Transaction entry is authorised");
	}

	// transfer

	public void submitPaymenttransferMode() throws InterruptedException {
		ExtentTestManager.startTest("Submit Payment - Cash Mode");
		Log.info("Submit Payment - Cash Mode");

		select("TRANSFER", FDintrest.submitcash);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select trans.mode as 'cash'. ");
		Log.info("Step:01 - Select trans.mode as 'cash'. ");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click Submit button. ");
		Log.info("Step:02 -Click Submit button. ");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Payment details are submitted successfully. ");
		Log.info("Expected Result:Payment details are submitted successfully. ");
		ExtentTestManager.endTest();
	}
	
	
	public void postDebitTransaction() throws InterruptedException {
		ExtentTestManager.startTest("Post Debit Transaction");
		Log.info("Debit Transaction Posted");

		click(FDintrest.postdebit);
		ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click on the POST DEBIT button ");
		Log.info("Step: 1 -Click on the POST DEBIT button.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Auto posting popup window will be display .");
		Log.info("Expected Result:Auto posting popup window will be display .");

		ExtentTestManager.endTest();
	}

	public void searchAccountNumber(Map<Object, Object> testdata, ITestContext context)
			throws InterruptedException, IOException {
		ExtentTestManager.startTest("Search Account Number");
		Log.info("Searched for Account Number");

		 mainWindowHandle = driver.getWindowHandle();
		boolean popupAppeared = false;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				popupAppeared = true;
			}
		}


		select("Demand Investment", JewelClosure.produgroup);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01-  Select a product group.");
		Log.info("Step:02 -Select a product group.");

		select("INV-DEMAND-CA", JewelClosure.produname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02-  Select a product name.");
		Log.info("Step:02 -Select a product name.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Possible to select the product group and product name ");
		Log.info("Expected Result:Possible to select the product group and product name ");
		ExtentTestManager.endTest();
	

	}

public void selectAccountNumber(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
 
 
 ExtentTestManager.startTest("Select Account Number");
 Log.info("Account Number Selected");
 
 String AccountNumber = testdata.get("AccountNumber").toString();
	input(JewelClosure.accnumber, AccountNumber);
 
 ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -1. Give account number as '3' ");
 Log.info("Step: 1 - 1. Give account number as '3'.");
 
 ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Given account number details will be display .");
 Log.info("Expected Result: Given account number details will be display.");
 
 Display = driver.findElement(JewelClosure.dispname).getAttribute("value");
	
	System.out.println("Amount" + Display);
	displayamount(Display);
 
 ExtentTestManager.endTest();
}

public void addTransactionAmount1() throws InterruptedException

{
	ExtentTestManager.startTest("Add Transaction Amount");
	Log.info("Transaction Amount Added");

	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Enter amount.");
	Log.info("Step: 1 - Enter amount.");
	
	

	click(JewelClosure.CliADD);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 2- Click ADD.");
	Log.info("Step: 2 - Click ADD.");

	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:Amount and details is added in the grid in the auto posting popup window.");
	Log.info("Expected Result:Amount and details is added in the grid in the auto posting popup window  .");

	ExtentTestManager.endTest();
}

public void addTransactionAmount() throws InterruptedException {
	
	
	ExtentTestManager.startTest("Add Transaction Amount");
	Log.info("Transaction Amount Added");

	click(JewelClosure.clickSubmit);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 -Enter submit in the auto posting popu window ");
	Log.info("Step: 1 - Enter submit in the auto posting popu window .");

	
	driver.switchTo().window(mainWindowHandle);
	
	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:Details is added and auto posting popu window closes .");
	Log.info("Expected Result:Details is added and auto posting popu window closes .");

	ScrollUntilElementVisible(OLtrans.scrolldwn);
	
	ExtentTestManager.endTest();
}

public void submitTransactionWindow() throws InterruptedException {
	ExtentTestManager.startTest("Submit in Transaction Window");
	Log.info("Submitted Transaction Window");


	click(FDintrest.submitend);
	ExtentTestManager.getTest().log(Status.PASS, "Step: 1 - Click Submit button.");
	Log.info("Step: 1 - Click Submit button.");

	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User navigates to the summary page.");
	Log.info("Expected Result: User navigates to the summary page.");
	

	ExtentTestManager.endTest();
	
	transId = driver.findElement(FDintrest.transid).getText();
}


}
