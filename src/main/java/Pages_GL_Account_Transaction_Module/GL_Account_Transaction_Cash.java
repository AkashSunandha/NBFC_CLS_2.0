package Pages_GL_Account_Transaction_Module;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerSearch;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Pages_Jewel_Gold_Loan_Renewal_Module.Pages_Jewel_Gold_Loan_Renewals;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class GL_Account_Transaction_Cash extends Base_Class {
	
	GL_Account_Transaction GLTransaction = new GL_Account_Transaction();
	
	ScreenShot sc = new ScreenShot(null);
	
	String transIdGLtransCash;
    String transIdGLtransTransfer;
    
public boolean FetchwithTransID(String transID) throws InterruptedException {
		
		input(GLTransaction.TransactionIDField,transID);
		click(GLTransaction.GoBTN);
		
		ExtentTestManager.endTest();
		return true;
		
	}
public static  String generateAccountNumber() throws ClassNotFoundException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String UserName = "sqa";
	String Password = "SPQA@sql2019" ;
	String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

	String query = "exec GetJewelloanAccountnumber;";
	String AccountNum = null; 
	try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(query)) {
	        	
	if (resultSet.next()) {
	    AccountNum = resultSet.getString("Acno");
	    System.out.println("Account Number of Loan Opening: " + AccountNum);
	      } else {
	    System.out.println("No Account Number found.");
	            }

	    } catch (SQLException e) {
	    System.out.println("Error executing the SQL query or processing the result set.");
	    e.printStackTrace();
	  }
	    	return AccountNum;         
}	
	

public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException, InterruptedException, IOException {
	ExtentTestManager.startTest("TC:01 - Login Functionality");
	Log.info("TC_01 - Login Functionality");

	String UserName = configloader().getProperty("UserName");
	input(GLTransaction.loginUserName, UserName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid User Name");
	Log.info("Step:01 - Enetered valid User Name");

	String Password = configloader().getProperty("Password");
	input(GLTransaction.loginPasswrd, Password);
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid Password");
	Log.info("Step:02 - Enetered valid Password");

	click(GLTransaction.loginButton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
	Log.info("Step:03 - Click on Login Button");

	try {
		ElementDisplayed(GLTransaction.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	} catch (Exception e) {
		ElementDisplayed(GLTransaction.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS,
				"Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
		Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

		click(GLTransaction.loginWarningOkBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
		Log.info("Step:01 - Click on OK button");

		input(GLTransaction.loginUserName, UserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
		Log.info("Step:02 - Enetered valid User Name");

		input(GLTransaction.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
		Log.info("Step:03 - Entered valid Password");

		click(GLTransaction.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
		Log.info("Step:04 - Click on Login Button");

		ElementDisplayed(GLTransaction.home);
		ExtentTestManager.getTest().log(Status.PASS,"Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
	}
	ExtentTestManager.endTest();
	return true;
}

public boolean LaunchGLAccountTransactionModule() throws InterruptedException {
	ExtentTestManager.startTest("TC:02 - Launch GL Account Transaction Module");
	Log.info("TC:02 - Launch GL Account Transaction Module");

	try {

		ScrollUntilElementVisible(GLTransaction.Transaction);
		click(GLTransaction.Transaction);
		
		click(GLTransaction.GLTransactions);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Navigate to Transactions -> GL A/c transaction");
		Log.info("Step:01 Navigate to Transactions -> GL A/c transaction");

		boolean isDashboardVisible = ElementDisplayed(GLTransaction.GLAccInfo);

		Assert.assertTrue(isDashboardVisible,"Validation Failed: GL A/c transaction opening window is NOT displayed.");

		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Module name displayed as 'GL Account Transaction'");
		Log.info("Expected Result: Module name displayed as 'GL Account Transaction'");

	} catch (Exception e) {
		ExtentTestManager.getTest().log(Status.FAIL, "Exception occurred: " + e.getMessage());
		Log.error("Exception occurred while accessing Charge Posting Opening Window: " + e.getMessage());
		Assert.fail("Test failed due to an unexpected error.");
	}

	ExtentTestManager.endTest();
	return true;

}


	private WebElement visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
