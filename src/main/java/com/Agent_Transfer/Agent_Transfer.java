package com.Agent_Transfer;

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
import com.Page_Repositary.PageRepositary_OLTransaction_Cash_Transfer;
import com.Page_Repositary.PageRepositary_OL_Transaction_Closure_Cash_Transfer;
import com.Page_Repositary.PageRepositary_SusAssetTransaction_Cash_Transfer;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Agent_Transfer extends Base_Class {

	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	PageRepositary_Jewel_Loan_Closure_Cash_Transfer JewelClosure = new PageRepositary_Jewel_Loan_Closure_Cash_Transfer();
	PageRepositary_OLTransaction_Cash_Transfer OLtrans = new PageRepositary_OLTransaction_Cash_Transfer();
	PageRepositary_OL_Transaction_Closure_Cash_Transfer ClosureTrans = new PageRepositary_OL_Transaction_Closure_Cash_Transfer();
	PageRepositary_Agent_Transfer Agent = new PageRepositary_Agent_Transfer();

	String transId;
	String transIdTransfer;
	String mainWindowHandle;
	String Display;

	public String sp = "GetSuspenseAssetAccountnumber";
	public String columnName = "Acno";

	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox, transId);
		click(goaldLoanRepo.goBtn);

	}

	public void displayamount(String Display) throws InterruptedException {
		input(JewelClosure.enteramount, Display);
	}

	public void AgentTransferNavigation() throws InterruptedException {
		ExtentTestManager.startTest("VerifyAgentTransferNavigation");
		Log.info("VerifyAgentTransferNavigation");

		click(Agent.clickonAgenttransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Agent Transfer.");
		Log.info("Step:01 - Navigate to Agent Transfer.");

		click(Agent.agentTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Agent Transfer ");
		Log.info("Step:02 - Click on Agent Transfer.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: The Agent Transfer Return is displayed");
		Log.info("Expected Result: The Agent Transfer Return is displayed");
		ExtentTestManager.endTest();
	}

	public void AgentCodeDropdown() throws InterruptedException {

		ExtentTestManager.startTest("Agent Code dropdown is present");
		Log.info("Agent Code dropdown is present ");

		click(Agent.seecltagentcode);
		click(Agent.clickdhanya);
		// select("DHANYA K - 1", Agent.seecltagentcode);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Agent Code dropdown.");
		Log.info("Step:01 - Click on Agent Code dropdown.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select an AGENT from the dropdown.");
		Log.info("Step:02 - Select an AGENT from the dropdown.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: An agent from the Agent Code dropdown is selected");
		Log.info("Expected Result: An agent from the Agent Code dropdown is selected");

	}

	public void ProducCheckboxesFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("Verify Product Checkboxes Functionality");
		Log.info("Verify Product Checkboxes Functionality ");

		click(Agent.selectallproduct);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select All option in products option.");
		Log.info("Step:01 - Select All option in products option.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All product will be selected");
		Log.info("Expected Result: All product will be selected");

	}

	public void AreaCheckboxesFunctionality() throws InterruptedException {

		ExtentTestManager.startTest("Selection of Area field");
		Log.info("Selection of Area field ");

		click(Agent.selectallarea);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the All in the Area field.");
		Log.info("Step:01 - Select the All in the Area field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the Area");
		Log.info("Expected Result:Possible to select the Area");

	}

	public void CheckTemporaryTransferCheckboxDefault() throws InterruptedException {
		ExtentTestManager.startTest("Check Temporary Transfer Checkbox Default");
		Log.info("Check Temporary Transfer Checkbox Default");

		if (ElementDisplayed(Agent.visible)) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Expected Result: Temporary Transfer checkbox is present and ticked by default.");
			Log.info("Expected Result: Temporary Transfer checkbox is present and ticked by default.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Temporary Transfer checkbox is present and ticked by default.");
		Log.info("Expected Result: Temporary Transfer checkbox is present and ticked by default..");

		ExtentTestManager.endTest();
	}

	public void VerifyShowButton() throws InterruptedException {

		ExtentTestManager.startTest("Selection of Area field");
		Log.info("Selection of Area field ");

		click(Agent.clickshow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select the All in the Area field.");
		Log.info("Step:01 - Select the All in the Area field.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Possible to select the Area");
		Log.info("Expected Result:Possible to select the Area");

	}

	public void ItemfromToAgentCodeDropdown() throws InterruptedException {

		ExtentTestManager.startTest("Select an Item from To Agent Code Dropdown");
		Log.info("Select an Item from To Agent Code Dropdown ");

		click(Agent.agentnamecode);
		click(Agent.selectname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click to agent name.");
		Log.info("Step:01 - Click to agent name.");

		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select item from dropdown.");
		Log.info("Step:01 - select item from drop down.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Selected agent displayed and 'Agent Code' field auto-filled");
		Log.info("Expected Result:Selected agent displayed and 'Agent Code' field auto-filled");

	}

	public void accounttotransfer() throws InterruptedException {
		ExtentTestManager.startTest("Select an account to transfer ");
		Log.info("Select an account to transfer  ");

		
		click(Agent.clickofAC);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 - Select the account number which to transfer (Multiple).");
		Log.info("Step:01 - Select the account number which to transfer (Multiple)");

		ExtentTestManager.getTest().log(Status.PASS, "Possibel to select the multiple account number to transfer");
		Log.info("Possibel to select the multiple account number to transfer");

	}

	public void TransferAccountsCheckbox1() throws InterruptedException {
		ExtentTestManager.startTest("Verify Transfer Accounts Checkbox");
		Log.info("Verify Transfer Accounts Checkbox ");

		
		click(Agent.downarrow);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the down arrow mark .");
		Log.info("Step:01 - Click the down arrow mark ");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Selected account will be display in the  another grid");
		Log.info("Selected account will be display in the  another grid");

	}

	public void transferAccountsCheckbox2() throws InterruptedException {
		ExtentTestManager.startTest("Verify Transfer Accounts Checkbox");
		Log.info("Verify Transfer Accounts Checkbox ");

		click(Agent.AllAC);
		ExtentTestManager.getTest().log(Status.PASS,
				"Step:01 -Tick checkboxes against displayed accounts which to transfer.");
		Log.info("Step:01 -  Tick checkboxes against displayed accounts which to transfer.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Account checkboxes can be ticked and verified the include radio button is selected");
		Log.info("Expected Result:Account checkboxes can be ticked and verified the include radio button is selected");

	}

	public void VerifydataTransfer() throws InterruptedException {
		ExtentTestManager.startTest("Click and Verify Data Transfer");
		Log.info("Click and Verify Data Transfer");

		click(Agent.clicktransfer1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click 'TRANSFER' button");
		Log.info("Step:01 - Click 'TRANSFER' button.");

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Data saved in backend tablesAgent transfered sucessfully validation message will be displays");
		Log.info(
				"Expected Result:Data saved in backend tablesAgent transfered sucessfully validation message will be displays");

	}

	public void SingleAccountCheckbox() throws InterruptedException {

		ExtentTestManager.startTest("Verify Transfer Single Account ");
		Log.info("Verify Transfer Single Account ");

		click(Agent.clicktransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 1. Verify checkbox Transfer Single Account present.");
		Log.info("Step:01 - Verify checkbox Transfer Single Account present.");
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Checkbox 'Transfer Single Account' can be clicked/ticked");
		Log.info(
				"Expected Result:Checkbox 'Transfer Single Account' can be clicked/ticked");

		//select("OTHER LOANS", Agent.SelectOtherloan);
		//select("OTHER LOANS", Agent.selectproname);
	}

	
	
	
	public void Productgroup() throws InterruptedException {

		ExtentTestManager.startTest("Verify Product Group Dropdown Selection");
		Log.info("Verify Product Group Dropdown Selection ");

		select("OTHER LOANS", Agent.SelectOtherloan);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'PRODUCT GROUP' dropdown");
		Log.info("Step:01 -Click 'PRODUCT GROUP' dropdown");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select a group");
		Log.info("Step:01 - Select a group");
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Correct product group is selected from dropdown");
		Log.info(
				"Expected Result:Correct product group is selected from dropdown");

		
	}
	
	
	public void Productname() throws InterruptedException {

		ExtentTestManager.startTest("Verify Transfer Single Account ");
		Log.info("Verify Transfer Single Account ");

		
		select("PERSONAL LOAN WEEKLY", Agent.selectproname);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'PRODUCT GROUP name' dropdown");
		Log.info("Step:01 -Click 'PRODUCT GROUP name' dropdown");
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select a group");
		Log.info("Step:01 - Select a group");
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Correct product group name is selected from dropdown");
		Log.info(
				"Expected Result:Correct product group name is selected from dropdown");


		//select("OTHER LOANS", Agent.SelectOtherloan);
		//select("OTHER LOANS", Agent.selectproname);
	}
	
	
	
	

	
	
	public String generateUniqueCode(String query, String columnName) throws ClassNotFoundException {

		ExtentTestManager.startTest("Enter Loan Account Number");
		Log.info("Enter Loan Account Number");

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
	public void Accountnumber(Map<Object, Object> testdata, ITestContext context)
			throws ClassNotFoundException, InterruptedException {
		
		


		String valueAccNum = generateUniqueCode(sp, columnName);
		String AccNum = valueAccNum.substring(valueAccNum.length() - 3);
		input(JewelClosure.StoreAccun, AccNum);
		

		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result:Loan number can be entered Account details are displayed ");
		Log.info("Expected Result: Loan number can be entered Account details are displayed");

		ExtentTestManager.endTest();

}
	
	
	
	
	public void gobutton() throws InterruptedException{
		
		ExtentTestManager.startTest("Verify GO Button Functional ");
		Log.info("Verify GO Button Functional ");

		
	click(Agent.clickongo);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter valid Account No");
		Log.info("Step:01 - Enter valid Account No");
		
		
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: AccountNo accepted without errors");
		Log.info(
				"Expected Result:AccountNo accepted without errors");

	}
	
public void showbutton() throws InterruptedException{
	ExtentTestManager.startTest("Check SHOW Button in Account Transfer");
	Log.info("Check SHOW Button in Account Transfer");

	
	click(Agent.clickonshow);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'SHOW' after entering details");
	Log.info("Step:01 -  Click 'SHOW' after entering details");
	
	
	
	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result: Selected account is displayed");
	Log.info(
			"Expected Result:Selected account is displayed");
		
	}

public void agentcodedropwn()
{
	
	ExtentTestManager.startTest("Verify To Agent Code Dropdown after SHOW");
	Log.info("Verify To Agent Code Dropdown after SHOW");

	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click To Agent Code");
	Log.info("Step:01 -Click To Agent Code");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Select agent");
	Log.info("Step:02 - Select agent");
	
	ExtentTestManager.getTest().log(Status.PASS,
			"Expected Result:'Agent Code' field is auto-filled correctly");
	Log.info(
			"Expected Result:'Agent Code' field is auto-filled correctly");
	
}
	public void accountbumcheckbox(){
		
		ExtentTestManager.startTest("Select the account number checkbox");
		Log.info("Select the account number checkbox");

		
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick the checkbox of the accountber");
		Log.info("Step:01 - Tick the checkbox of the accountber");
		
		
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: 'Possible to tick the checkbox");
		Log.info(
				"Expected Result:'Possible to tick the checkbox");
		
	}
	
	public void clicktransfer()
	{
		
		ExtentTestManager.startTest("Verify GO Button Functional ");
		Log.info("Verify GO Button Functional ");

		
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click 'TRANSFER' button");
		Log.info("Step:01 -Click 'TRANSFER' button");
		
		
		
		ExtentTestManager.getTest().log(Status.PASS,
				"Expected Result: Data saved and transfer successful validation message displays");
		Log.info(
				"Expected Result:Data saved and transfer successful validation message displays");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
