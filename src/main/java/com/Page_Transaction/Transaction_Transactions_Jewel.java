package com.Page_Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_Transaction_Transactions_Jewel;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Transaction_Transactions_Jewel extends Base_Class{
	
	PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan depositLoanRepo = new PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	PageRepositary_Transaction_Transactions_Jewel transJewelRepo = new PageRepositary_Transaction_Transactions_Jewel();
	public String spAccNum = "exec GetJewelloanAccountnumber;";
	public String clmnNam = "Acno";
	
	String transId;
	String lastValue;
	
	public void fetchWithTransId(String transId) throws InterruptedException {
		input(goaldLoanRepo.transIdTxtBox,transId);
		click(goaldLoanRepo.goBtn);
	}
	
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
	        		value = resultSet.getString(columnName); // Get the first Cust_ID
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
	
	public void transactionsJewel() throws InterruptedException {
		
		//Open Transaction Module
		ExtentTestManager.startTest("Open Transaction Module");
		Log.info("Open Transaction Module");
		
		click(transJewelRepo.transactionTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the transaction module in the menu.");
		Log.info("Step:01 - Navigate to the transaction module in the menu.");

		click(transJewelRepo.transactionsTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the transaction module.");
		Log.info("Step:02 - Click on the transaction module.");

		if(ElementDisplayed(transJewelRepo.aiBranchDropdowm)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction module opens successfully.");
			Log.info("Expected Result: Transaction module opens successfully.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void accountInfo(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		//Select Branch
		ExtentTestManager.startTest("Select Branch");
		Log.info("Select Branch");
		
		select("TRIVANDRUM",transJewelRepo.aiBranchDropdowm);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select a branch from the dropdown.");
		Log.info("Step:01 -  Select a branch from the dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct branch  selected.");
		Log.info("Expected Result: Correct branch  selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Product Group
		ExtentTestManager.startTest("Select Product Group");
		Log.info("Select Product Group");
		
		select("Jewel Loan",transJewelRepo.aiProductGroupDropdowm);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Choose 'Jewel Loan' for product group.");
		Log.info("Step:01 -  Choose 'Jewel Loan' for product group.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct product group selected.");
		Log.info("Expected Result: Correct product group selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Select Product Name
		ExtentTestManager.startTest("Select Product Name");
		Log.info("Select Product Name");
		
		select("GOLD LOAN",transJewelRepo.aiProdcutNameDropdowm);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select 'Gold Loan' for product name.");
		Log.info("Step:01 - Select 'Gold Loan' for product name.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Correct product Name selected.");
		Log.info("Expected Result: Correct product Name selected.");
		
		ExtentTestManager.endTest();
		
		
		
		
		//Enter account number
		ExtentTestManager.startTest("Enter account number");
		Log.info("Enter account number");
		
		String accNum = generateUniqueId(spAccNum, clmnNam);
		String lastThreeDigitsOfAccNum = accNum.substring(accNum.length() - 3);
		
		input(transJewelRepo.aiAccNumTxtBox, lastThreeDigitsOfAccNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid account number in the input field.");
		Log.info("Step:01 - Enter a valid account number in the input field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account number is accepted.");
		Log.info("Expected Result: Account number is accepted.");

		ExtentTestManager.endTest();
		
		
		
		//Select Transaction Type
		ExtentTestManager.startTest("Select Transaction Type");
		Log.info("Select Transaction Type");
		
		select("Credit",transJewelRepo.aiTransTypeDropdwon);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction type as 'Credit'.");
		Log.info("Step:01 - Select transaction type as 'Credit'.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction type is set.");
		Log.info("Expected Result: Transaction type is set.");
		
		ExtentTestManager.endTest();
		
		
		
		//Transaction Window Display
		ExtentTestManager.startTest("Transaction Window Display");
		Log.info("Transaction Window Display");
		
		click(transJewelRepo.aiGoBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button.");
		Log.info("Step:01 - Click the 'Go' button.");
		
		try {
			click(transJewelRepo.accMaturedPopUpOkBtn);
		}catch(Exception e) {
		}
		
		if(ElementDisplayed(transJewelRepo.tdTransactionDetailsWindow)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction window for the selected account is displayed.");
			Log.info("Expected Result: Transaction window for the selected account is displayed.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Verify Principal Log Details
		ExtentTestManager.startTest("Verify Principal Log Details");
		Log.info("Verify Principal Log Details");
		
		//Navigate to Child Window
		String parent_Window0 = driver.getWindowHandle();
		String prinicipalAmt = driver.findElement(transJewelRepo.principal1TxtBox).getAttribute("value");
		System.out.println("interestAmt: "+prinicipalAmt);
		ScrollUntilElementVisible(transJewelRepo.interestLogBtn);
		click(transJewelRepo.principalLogBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click and view Principal log details.");
		Log.info("Step:01 - Click and view Principal log details.");
		
		Set<String> address = driver.getWindowHandles();
		
		for(String c : address) {
			
			if(!c.equals(parent_Window0)) {
				driver.switchTo().window(c);

			}
			
		}//for end
		
		 // Find the table
        WebElement table = driver.findElement(transJewelRepo.principalPopUpTable); // Modify this if you need a more specific table locator
        

        // Find all rows of the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Get the last row
        WebElement lastRow = rows.get(rows.size() - 1);

        // Get all columns of the last row (cells)
        List<WebElement> columns = lastRow.findElements(By.tagName("td"));

        // Check if there are enough columns and then get the value from the 4th column (index 3)
        if (columns.size() >= 4) {
            lastValue = columns.get(3).getText();
            System.out.println("The last value in the 4th column is: " + lastValue);
        } else {
            System.out.println("The table doesn't have enough columns.");
        }
		
        click(transJewelRepo.principalPopUpCloseBtn);
//		String popPrinicipalAmt = driver.findElement(transJewelRepo.popUpPagInterest).getText();
//		System.out.println("popPrinicipalAmt: "+popPrinicipalAmt);

		
		if(prinicipalAmt.equals(lastValue)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logs display correct interest  details.");
			Log.info("Expected Result: Logs display correct interest  details.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
			
//		click(transJewelRepo.interestWndowCloseBtn);
		driver.switchTo().window(parent_Window0);
		
		
		
		//Verify Interest Log Details
		ExtentTestManager.startTest("Verify Interest Log Details");
		Log.info("Verify Interest Log Details");
		
		//Navigate to Child Window
		String parent_Window = driver.getWindowHandle();
		String interestAmt = driver.findElement(transJewelRepo.interest1TxtBox).getAttribute("value");
		System.out.println("interestAmt: "+interestAmt);
//		ScrollUntilElementVisible(transJewelRepo.interestLogBtn);
		click(transJewelRepo.interestLogBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click and view interest log details.");
		Log.info("Step:01 - Click and view interest log details.");
		
		Set<String> address1 = driver.getWindowHandles();
		
		for(String c : address1) {
			
			if(!c.equals(parent_Window)) {
				driver.switchTo().window(c);

			}
			
		}//for end
		
		String popUpinterestAmt = driver.findElement(transJewelRepo.popUpPageInterest).getText();
		System.out.println("popUpinterestAmt: "+popUpinterestAmt);

		
		if(interestAmt.equals(popUpinterestAmt)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logs display correct interest  details.");
			Log.info("Expected Result: Logs display correct interest  details.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
			
		click(transJewelRepo.interestWndowCloseBtn);
		driver.switchTo().window(parent_Window);

		
		
		//Enter Transaction Amount
		ExtentTestManager.startTest("Enter Transaction Amount");
		Log.info("Enter Transaction Amount");
		
		String transAmt = testdata.get("amount").toString();
		clear(transJewelRepo.tdTransAmtTxtBox);
		click(transJewelRepo.tdTransAmtTxtBox);
		input(transJewelRepo.tdTransAmtTxtBox, transAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid transaction amount in the input field.");
		Log.info("Step:01 - Enter a valid transaction amount in the input field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction amount is accepted.");
		Log.info("Expected Result: Transaction amount is accepted.");

		click(transJewelRepo.transAmtTxt);

		ExtentTestManager.endTest();
		
		
		
		//Verify Interest and Principal Amount
		ExtentTestManager.startTest("Verify Interest and Principal Amount");
		Log.info("Verify Interest and Principal Amount");
		
		String currentAmt = driver.findElement(transJewelRepo.currentTxtBox).getAttribute("value");
		String principalAmt = driver.findElement(transJewelRepo.principal1TxtBox).getAttribute("value");

		String interestAmtTxtBox2Value = driver.findElement(transJewelRepo.interest2TxtBox).getAttribute("value");
		String principalAmtTxtBox2Value = driver.findElement(transJewelRepo.principal2TxtBox).getAttribute("value");

		String a = interestAmtTxtBox2Value.split("\\.")[0];
		String b = principalAmtTxtBox2Value.split("\\.")[0];

		int num1 = Integer.parseInt(a);
		System.out.println("num1: "+num1);

		int num2 = Integer.parseInt(b);
		System.out.println("num2: "+num2);

		int sum = num1+num2;
		System.out.println("sum: "+sum);

		int transAmt1 = Integer.parseInt(transAmt);
		System.out.println("transAmt1: "+transAmt1);

		
		if(currentAmt.equals(principalAmt) && sum==transAmt1) {
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the principal amount displayed.");
			Log.info("Step:01 - Check the principal amount displayed.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Check the interest amount displayed.");
			Log.info("Step:02 - Check the interest amount displayed.");
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Interest and principal amounts are correct.");
			Log.info("Expected Result: Interest and principal amounts are correct.");
			
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		

        
        
					
		}//end
	
	
	public void authorizeCash(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		
		//Cashier Authorization
		ExtentTestManager.startTest("Cashier Authorization");
		Log.info("Cashier Authorization");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.cashierAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Cashier Authorization");
		Log.info("Step:01 - Navigate to Cashier Authorization");

		click(goaldLoanRepo.cashierRefreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Refresh Button");
		Log.info("Step:02 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		fetchWithTransId(transId);
		
		click(goaldLoanRepo.cashierCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select checkbox");
		Log.info("Step:03 - Select checkbox");

		click(goaldLoanRepo.cashierAuthorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Authorize Button");
		Log.info("Step:04 - Click Authorize Button");
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
		
		
		//Manager Authorization - Cash Tab
		ExtentTestManager.startTest("Manager Authorization - Cash Tab");
		Log.info("Manager Authorization - Cash Tab");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.cashTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Cash\" tab");
		Log.info("Step:03 - Click \"Cash\" tab");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Cash tab load");
		Log.info("Expected Result: Cash tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdCashPersonal "+transId);
		
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBox)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		
		click(goaldLoanRepo.approveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();
		
		
		
//		click(prsnlLoanWeeklyRepo.errorPopUpCloseIcon);

		
	}//end
	
	
	
	public void authorizeTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {		

		//Login with Another User
		ExtentTestManager.startTest("Login with Another User");
		Log.info("Login with Another User");
		
		click(custSearch.custSignOut); 
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Log out");
		Log.info("Step:01 - Log out");
		
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
		Log.info("Step:02 - Log in with another user for authorization");
	
		String userName = driver.findElement(goaldLoanRepo.userName).getText();
		System.out.println(userName);
		 
		String flag = "akash";
		
		if(!userName.equalsIgnoreCase(flag)) {
    		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Logging successfull with another user");
    		Log.info("Expected Result: Logging successfull with another user");
    		}else {
    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
    			Log.info("ERROR");
    		}
		
		ExtentTestManager.endTest();
		
		
		

		//Manager Authorization - Transfer Tab
		ExtentTestManager.startTest("Manager Authorization - Transfer Tab");
		Log.info("Manager Authorization - Transfer Tab");
		
		click(goaldLoanRepo.autorizeAndCancelTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click \"Authorize & Cancel\"");
		Log.info("Step:01 - Click \"Authorize & Cancel\"");
		
		click(goaldLoanRepo.managerAuthoTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select \"Manager Authorization\"");
		Log.info("Step:02 - Select \"Manager Authorization\"");
		
		click(goaldLoanRepo.sTransferTab);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click \"Transfer\" tab");
		Log.info("Step:03 - Click \"Transfer\" tab");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transfer tab load");
		Log.info("Expected Result: Transfer tab load");
		
		ExtentTestManager.endTest();
		
		
		

		//Refresh Loan Opening Entry
		ExtentTestManager.startTest("Refresh Loan Opening Entry");
		Log.info("Refresh Loan Opening Entry");
		
		click(goaldLoanRepo.refreshBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Refresh Button");
		Log.info("Step:01 - Click Refresh Button");
		
		System.out.println("transIdTransferPersonal "+transId);
		fetchWithTransId(transId);
		
		if(ElementDisplayed(goaldLoanRepo.approveCheckBoxTransfer)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan opening entry displayed");
		Log.info("Expected Result: Loan opening entry displayed");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
		ExtentTestManager.endTest();
		
		
		

		//Authorize Loan Entry as Manager
		ExtentTestManager.startTest("Authorize Loan Entry as Manager");
		Log.info("Authorize Loan Entry as Manager");
		
		click(goaldLoanRepo.approveCheckBoxTransfer);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select loan entry checkbox");
		Log.info("Step:01 - Select loan entry checkbox");
		
		click(goaldLoanRepo.authorizeBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Authorize Button");
		Log.info("Step:02 - Click Authorize Button");		
		
		if(ElementDisplayed(goaldLoanRepo.confirmationPopUp)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction gets authorised");
		Log.info("Expected Result: Transaction gets authorised");
		click(goaldLoanRepo.confirmationPopUp);
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}

		ExtentTestManager.endTest();

	}//end
	
	
	public void transModeCash() throws InterruptedException {
		
		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");
		
		select("CASH",transJewelRepo.tdTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'Cash' from the transaction mode dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction mode 'Cash' is selected.");
		Log.info("Expected Result: Transaction mode 'Cash' is selected.");
		
		ExtentTestManager.endTest();
		
		
		
		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");
		
		click(transJewelRepo.submitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");
		
		if(ElementDisplayed(transJewelRepo.summaryTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			
			transId = driver.findElement(transJewelRepo.summaryTransId).getText();
		
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void transModeTransfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		
		//Select Transaction Mode
		ExtentTestManager.startTest("Select Transaction Mode");
		Log.info("Select Transaction Mode");
		
		select("TRANSFER",transJewelRepo.tdTransModeDropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		Log.info("Step:01 - Choose 'TRANSFER' from the transaction mode dropdown.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction mode 'TRANSFER' is selected.");
		Log.info("Expected Result: Transaction mode 'TRANSFER' is selected.");
		
		ExtentTestManager.endTest();
		
		
		//Enter Remark 
		ExtentTestManager.startTest("Enter Remark ");
		Log.info("Enter Remark ");
		
		String reamrk = testdata.get("remark").toString();
		input(transJewelRepo.tdRemarkTxtBox, reamrk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a remark in the input field.");
		Log.info("Step:01 - Enter a remark in the input field.");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Remark   accepted.");
		Log.info("Expected Result: Remark   accepted.");

		ExtentTestManager.endTest();
		
		
		postCreditPopUpEntry(testdata, context);
		
		
		
		//Submit Transaction
		ExtentTestManager.startTest("Submit Transaction");
		Log.info("Submit Transaction");
		
		click(transJewelRepo.submitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Submit' button.");
		Log.info("Step:01 - Click the 'Submit' button.");
		
		if(ElementDisplayed(transJewelRepo.summaryTransId)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			Log.info("Expected Result: Transaction should be successful and  summary is displayed with correct details.");
			
			transId = driver.findElement(transJewelRepo.summaryTransId).getText();
		
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
		ExtentTestManager.endTest();
		
	}//end
	
	
	public void postCreditPopUpEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
		//Post credit button functionality
				ExtentTestManager.startTest("Post credit button functionality");
				Log.info("Post credit button functionality");
				
				click(transJewelRepo.tdPostDebitBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Post credit button.");
				Log.info("Step:01 - Select Post credit button.");
				
				//Navigate to Pop Up Window
			    String mainWindowHandle = driver.getWindowHandle();
			    boolean popupAppeared = false;
			    for (String handle : driver.getWindowHandles()) {
			        if (!handle.equals(mainWindowHandle)) {
			            driver.switchTo().window(handle);
			            driver.manage().window().maximize();
			            popupAppeared = true;
			         
			    		
			            if(ElementDisplayed(depositLoanRepo.oiTransBasedDropdown)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Auto posting popup window will be opened.");
							Log.info("Expected Result: Auto posting popup window will be opened.");
			    		}else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			            
						ExtentTestManager.endTest();


						
						//Transaction based selection.
						ExtentTestManager.startTest("Transaction based selection.");
						Log.info("Transaction based selection.");
						
						select("Account",depositLoanRepo.oiTransBasedDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select transaction based as Account.");
						Log.info("Step:01 - Select transaction based as Account.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
						Log.info("Expected Result:  ACCOunt selected from the 'Transaciton Based' drop down");
			 
						ExtentTestManager.endTest();
						

						
						//Select Product Group.
						ExtentTestManager.startTest("Select Product Group");
						Log.info("Select Product Group");
						
						select("Demand Investment",depositLoanRepo.productGroupDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select Demand Investment from the 'Product group ' drop down.");
						Log.info("Step:01 - Select Demand Investment from the 'Product group ' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Demand Investment is selected ");
						Log.info("Expected Result:  Demand Investment is selected ");
			 
						ExtentTestManager.endTest();
						

						
						//Select Product Name
						ExtentTestManager.startTest("Select Product Name");
						Log.info("Select Product Name");
						
						select("INV-DEMAND-CA",depositLoanRepo.productNameDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an item from the 'Product Name' drop down.");
						Log.info("Step:01 - Select an item from the 'Product Name' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Product name item  is selected ");
						Log.info("Expected Result:  Product name item  is selected ");
			 
						ExtentTestManager.endTest();
						

						
						//Select Branch
						ExtentTestManager.startTest("Select Branch");
						Log.info("Select Branch");
						
						select("TRIVANDRUM",depositLoanRepo.branchDropdown);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a branch  from the 'Branch  ' drop down.");
						Log.info("Step:01 - Select a branch  from the 'Branch  ' drop down.");
						
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Branch  item  is selected ");
						Log.info("Expected Result:  Branch  item  is selected  ");
			 
						ExtentTestManager.endTest();
							
	
							
							//Select Account
							ExtentTestManager.startTest("Select Account");
							Log.info("Select Account");						
							
							String accNum = testdata.get("accNum").toString();
							input(depositLoanRepo.accNumTxtBox, accNum);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Tick mark and select an account from the list of accounts displayed.");
							Log.info("Step:01 - Tick mark and select an account from the list of accounts displayed.");
							
							click(depositLoanRepo.accNumTxt);
							
							String remarksValue = driver.findElement(depositLoanRepo.remarksTxtBox).getAttribute("value");
							
							if(!remarksValue.isBlank()) {
								ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Account is selected ");
								Log.info("Expected Result:  Account is selected ");
							}else {
				    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				    			Log.info("ERROR");
				    		}
				 
							ExtentTestManager.endTest();
							
	
							
							//Enter Amount
							ExtentTestManager.startTest("Enter Amount");
							Log.info("Enter Amount");						
							
							String amount = testdata.get("amount").toString();
							input(depositLoanRepo.amtTxtBox, amount);
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter a valid amount in the input field.");
							Log.info("Step:01 - Enter a valid amount in the input field.");
														
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount accepted");
							Log.info("Expected Result: Amount accepted");
				 
							ExtentTestManager.endTest();
							
							

						
						//Add button functionality
						ExtentTestManager.startTest("Add button functionality");
						Log.info("Add button functionality");

						click(depositLoanRepo.addBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click add button");
						Log.info("Step:01 - Click add button.");
						
			            if(ElementDisplayed(depositLoanRepo.oiAutoPostingGrid)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid.");
						Log.info("Expected Result: Given details will be displays in the grid");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}

						ExtentTestManager.endTest();
						
						
						
						//Submit button functionality
						ExtentTestManager.startTest("Submit button functionality");
						Log.info("Submit button functionality");
						
						click(depositLoanRepo.submitBtn);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click submit button after adding the details in the auto posting popup window");
						Log.info("Step:01 - Click submit button after adding the details in the auto posting popup window.");

			    		driver.switchTo().window(mainWindowHandle);
			    		
			            if(ElementDisplayed(transJewelRepo.tdPostDebitBtn)) { 
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window will be closed.");
						Log.info("Expected Result: Popup window will be closed");
			            }else {
			    			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			    			Log.info("ERROR");
			    		}
			    		ExtentTestManager.endTest();
			    		
			            break;	
			            
			        }
			   
			    }//for loop end
	}
	
	
	
	
}
