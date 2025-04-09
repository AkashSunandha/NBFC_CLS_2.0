package com.Page_AccountOpening;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_InvestOpn_Demand;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class InvestmentOpening_Demand extends Base_Class{
	PageRepositary_InvestOpn_Demand repo = new PageRepositary_InvestOpn_Demand();
	String transId;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	
public void LoadInvestmentOpeningWindow(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
	
	//Load Investment Opening Window
	ExtentTestManager.startTest("Load Investment Opening Window");
	Log.info("Load Investment Opening Window");
	
	click(repo.accountOpeningTab);
	
	
	click(repo.investmentOPeningTab);
	
	click(repo.demandOpeningTab);
	
	click(repo.investmentAccountNewTab);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - select bank drop down Step:02 - select bank from the drop down list");
	Log.info("Step:01 - Navigate to account opening -> Click on investment opening -> Select demand > Inv-Demand");
	
	ExtentTestManager.endTest();
	
	//select bank from the drop down list
	
	ExtentTestManager.startTest("Investment Opening window is open");
	Log.info("Investment Opening window is open");
	
	
	select("HDFC BANK - HDFC",repo.selectbankdrop_down);
		
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Click on Branch dropdown after selecting the Bank -> Select branch from drop down");
	Log.info("Step:01. Click on Branch dropdown after selecting the Bank -> Select branch from drop down");
	
	ExtentTestManager.endTest();
	
	//Select Branch fields are selected
	
	ExtentTestManager.startTest("Bank and Branch fields are selected");
	Log.info("Bank and Branch fields are selected");
	
	select("Cherpulassery",repo.selectbranchdrop_down);
	
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.addbutton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Add button.");
	Log.info("Step:01 - Click on Add button.");
	
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
	// Investment Opening window is open
	
	ExtentTestManager.startTest("Investment Opening window is open");
	Log.info("Investment Opening window is open");
	
	
	String accAtBranch = testdata.get("accAtBranch").toString();
	input(repo.acctatbranch, accAtBranch);
		
	String openAmt = testdata.get("openAmt").toString();
	input(repo.openamount, openAmt);
	
	
//	input(repo.roi, "10");
		
	ExtentTestManager.startTest("Investment Info tab is open");
	Log.info("Investment Info tab is open");
	

	select("ICICI BANK CHERPULASSERY",repo.principalglhead);
	ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Click on Principal GL Head dropdown -> Select any Bank.");
	Log.info("Steps 01: Click on Principal GL Head dropdown -> Select any Bank.");
	
	String IntGLhead = testdata.get("IntGLhead").toString();
	input(repo.interestglhead, IntGLhead);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Select a valid GL Head number.");
	Log.info("Step:01: Select a valid GL Head number.");
	
	waitTillLoaderDisappear(repo.loader);
		
	String RceiptNo = testdata.get("RceiptNo").toString();
	input(repo.recieptno,RceiptNo);
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Leave Receipt SL.No empty -> Enter valid numeric values.");
	Log.info("Step 01: Leave Receipt SL.No empty -> Enter valid numeric values.");
	
	String depstName = testdata.get("depstName").toString();
	input(repo.depositname,depstName);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Deposit name");
	Log.info("Step:01. Enter Deposit name");
	
	String reMarks = testdata.get("reMarks").toString();
	input(repo.remarks,reMarks);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Remark");
	Log.info("Step:01. Enter Remark");
	
	ExtentTestManager.endTest();
	
	//Next/Previous
	ExtentTestManager.startTest("Investment Info tab is filled");
	Log.info("Investment Info tab is filled");
	
	click(repo.nextbutton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select any one customer");
	Log.info("Step:01 -Select any one customer");
	
	ExtentTestManager.endTest();
	
	//Operator
	ExtentTestManager.startTest("Operator tab is open");
	Log.info("Operator tab is open");
	
	click(repo.customerid);
	
	//Navigate to Child Window
    String mainWindowHandle = driver.getWindowHandle();
    boolean popupAppeared = false;
    for (String handle : driver.getWindowHandles()) {
        if (!handle.equals(mainWindowHandle)) {
            driver.switchTo().window(handle);
            driver.manage().window().maximize();
            popupAppeared = true;
            
            //Child window
            input(repo.selectbutton, "activitation");
        	     	
        	click(repo.selectcustomer_id);
        	         	
            driver.switchTo().window(mainWindowHandle);
                          
            break;  
            
        }
   
    }//for loop end
    
    
    //back to mainscreenString reMarks = testdata.get("reMarks").toString();
    
    String EnterrelatioN = testdata.get("EnterrelatioN").toString();
    input(repo.relationdesignwindow,EnterrelatioN );
    ExtentTestManager.getTest().log(Status.PASS, "Step 01:Enter Relation.");
	Log.info("Step 01:Enter Relation.");
	
	
	click(repo.powerofattorney);
	ExtentTestManager.getTest().log(Status.PASS, "Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	Log.info("Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	
	String RemarksTOenter = testdata.get("RemarksTOenter").toString();
	input(repo.remarks_toentry, RemarksTOenter );
	ExtentTestManager.getTest().log(Status.PASS, "Step 01:Enter Remark");
	Log.info("Step 01:Enter Remarks");
	
	click(repo.addbuttton_operator);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on Add button.");
	Log.info("Step:01 Click on Add button.");
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();

		
	//Operator tab has some entered data
	
	ExtentTestManager.startTest("Operator tab has some entered data");
	Log.info("Operator tab has some entered data");
	
	click(repo.cancel_operator);
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Enter data in fields in Operator tab.-> Click on Cancel button.");
	Log.info("Step:23 -Click on cancel button");
	
	ExtentTestManager.endTest();
	
	// other Info	
	String SPiinfo = testdata.get("SPiinfo").toString();
	input(repo.specialinformation,SPiinfo);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter text into Special Instruction field.");
	Log.info("Step:01. Enter text into Special Instruction field.");
	
		
	select("CASH",repo.transmode);
	ExtentTestManager.getTest().log(Status.PASS, "Step 26 -Select transfer mode");
	Log.info("Step 26 -Select transfer mode");	
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
	//Transaction Amount
	
	//click(repo.postcredit);
	//ExtentTestManager.getTest().log(Status.PASS, "Step:27 -Click on post credit");
	//Log.info("Step:27 -Click on post credit");
	//ExtentTestManager.endTest();
	
	//select("GL Code",repo.batch1);
 	//ExtentTestManager.getTest().log(Status.PASS, "Step:28 -Select transfer mode");
 	//Log.info("Step 26 -Select transfer mode");
 	
	//Navigate to Child Window_1
    //String mainWindowHandle1 = driver.getWindowHandle();
    //boolean popupAppeared1 = false;
    //for (String handle : driver.getWindowHandles()) {
        //if (!handle.equals(mainWindowHandle1)) {
         //  driver.switchTo().window(handle);
           // driver.manage().window().maximize();
            //popupAppeared1 = true;
            
            //post credict// 
            //product group                    
        	//select("Demand Investment",repo.productgroup);
        	//ExtentTestManager.getTest().log(Status.PASS, "Step:30 -Click on demand investment");
        	//Log.info("Step:30 -Click on select customer id");
        	//product name 
        	//select("INV-DEMAND-CA",repo.productname);
        	//ExtentTestManager.getTest().log(Status.PASS, "Step:31 -Click on Suspense liability");
        	//Log.info("Step 31 -Click on select customer id");
        	// add amount
        	//input(repo.amount1,"txtAmount_txt");
        	//ExtentTestManager.getTest().log(Status.PASS, "Step:32 -Click on Suspense liability");
        	//Log.info("Step 32 -Click on select customer id");
        	// click on add button
        	//click(repo.addbutton1);
        	//ExtentTestManager.getTest().log(Status.PASS, "Step:33 -Click on Suspense liability");
        	//Log.info("Step 33 -Click on select customer id");
        	// click on submit
        	//click(repo.submit);
        	//ExtentTestManager.getTest().log(Status.PASS, "Step:34 -Click on Suspense liability");
        	//Log.info("Step 34 -Click on select customer id");
        	
              //driver.switchTo().window(mainWindowHandle1);
              

              
            //break;  
            
       // }
   
    //}//for loop end
	
	
	//Summary Page is displayed After Transaction is completed
	
	ExtentTestManager.startTest("Summary Page is displayed After Transaction/cash is completed");
	Log.info("Summary Page is displayed After Transaction/cash is completed");
	
	click(repo.savebutton);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01.Complete Investment account Opening -> Verify the Summary generated");
	Log.info("Step:01.Complete Investment account Opening -> Verify the Summary generated");
		
	transId = driver.findElement(repo.transactionid1).getText();
	System.out.println("transId: "+transId);
	
	click(repo.print);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01.Complete Investment account Opening -> CLick on VOucher Print Button");
	Log.info("Step:01.Complete Investment account Opening -> CLick on VOucher Print Button");
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
    //Navigate to Pop Up Window
 String mainWindowHandle3 = driver.getWindowHandle();
 boolean popupAppeared3 = false;
 for (String handle : driver.getWindowHandles()) {
     if (!handle.equals(mainWindowHandle3)) {
         driver.switchTo().window(handle);
         driver.manage().window().maximize();
         popupAppeared3 = true;
      
         String currentUrl = driver.getCurrentUrl();
         System.out.println("currentUrl: "+currentUrl);
         if (currentUrl.endsWith(".pdf")) {
                        ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Voucher is generated correctly.");
                        Log.info("Expected Result: Voucher is generated correctly.");                     
                        }else {
                 ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
                 Log.info("ERROR");
           }
         
           driver.close();
           driver.switchTo().window(mainWindowHandle3);
           
           ExtentTestManager.endTest();
           
         break;  
         
     }

 }//for loop end

	// Summary is displayed
 	ExtentTestManager.startTest("Summary Page is displayed After Transaction/cash is completed");
	Log.info("Summary Page is displayed After Transaction/cash is completed");
	
 
	click(repo.signout);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01:Logout from the application");
	Log.info("Step:01:Logout from the application");
	
	ExtentTestManager.endTest();
}
	//Login to authorise
//	ExtentTestManager.startTest("Enter username and password.");
//	Log.info("Enter username and password.");
//	
//	input(repo.authorise, "authorise");
//	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Username");
//	Log.info("Step 39 -Click on Username");
//	
//	input(repo.password, "test123");
//	ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click on password");
//	Log.info("Step 39 -Click on password");
//	
//	click(repo.login);
//	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the login button.");
//	Log.info("Step:01 - Click the login button.");
//	
//	

	public void authoriseLogin() throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("**Basic Login Functionality**");
		Log.info("**Basic Login Functionality**");
			
			
		String UserName = configloader().getProperty("UserName2");
		input(custSearch.loginUserName,UserName );
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");
		
		String Password = configloader().getProperty("Password2");
		input(custSearch.loginPasswrd, Password);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
		Log.info("Step:02 - Enetered valid Password");
		
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		try {
		ElementDisplayed(custSearch.home);
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
		Log.info("Expected Result: User is logged in successfully and dashboard visible");
		}
		catch(Exception e) {
			ElementDisplayed(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
			Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

			click(custSearch.loginWarningOkBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
			Log.info("Step:01 - Click on OK button");
			
			input(custSearch.loginUserName, UserName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
			Log.info("Step:02 - Enetered valid User Name");
			
			input(custSearch.loginPasswrd, Password);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
			Log.info("Step:03 - Entered valid Password");
			
			click(custSearch.loginButton);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
			Log.info("Step:04 - Click on Login Button");
			
						ElementDisplayed(custSearch.home);
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
						Log.info("Expected Result: User is logged in successfully and dashboard visible");	
				}
					
    //load investment tab
    ExtentTestManager.startTest("User is logged in");
	Log.info("User is logged in.");
	
	click(repo.authorisecancel);
						
	ExtentTestManager.endTest();
	
	//manager 
	
	ExtentTestManager.startTest("User is in Manager authorisation window");
	Log.info("User is in Manager authorisation windowd");
	
	click(repo.managerauthorise);
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
	Log.info("Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
	
	click(repo.refresh_01);
	
	waitTillLoaderDisappear(repo.loader);
			
	input(repo.transactionid,transId);
	
	waitTillLoaderDisappear(repo.loader);
		
	click(repo.go);
	
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.select11);
	
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.authorise1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Clcik the AUTHORISE button");
	Log.info("Step:42 - Select go.");
	
	ExtentTestManager.endTest();
	
	//cashier page
	ExtentTestManager.startTest("User is in cashier authorisation window");
	Log.info("User is in cashier authorisation windowd");
	
	click(repo.cashier);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Navigate to 'Authorize&cancel ->Cashier Authorisation ");
	Log.info("Step:01. Navigate to 'Authorize&cancel ->Cashier Authorisation ");
	
	click(repo.refresh12);
				
	waitTillLoaderDisappear(repo.loader);
			
	input(repo.transactionionid2,transId);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Select transaction ID");
	Log.info("Step:01: Select transaction ID");
			
	waitTillLoaderDisappear(repo.loader);
			
	click(repo.go1);
							
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.select12);
	
	click(repo.authorise2);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the AUTHORISE button");
	Log.info("Step:01 -Click the AUTHORISE button");
	
//	//logout
    click(repo.updatedsuccessfully);
//	click(repo.signout1);
//	
//	ExtentTestManager.endTest();
}

public static String getClipboardContents() {
    String result = "";
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contents = clipboard.getContents(null);

    // Check if clipboard has any content
    if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        try {
            result = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }
    return result;
}


//public void accNumBVAValidation(Map<Object, Object> testdata, ITestContext context) throws InterruptedException {
//	
//		
//	String digitNumActual19 = testdata.get("19digitNum").toString();
//	input(repo.acctatbranch, digitNumActual19);
//	
//	clear(repo.acctatbranch);
//	click(repo.acctatbranch);
//	
//	String digitNumActual20 = testdata.get("20digitNum").toString();
//	input(repo.acctatbranch, digitNumActual20);
//	
//	
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 19 and 20 digits accepted; 21 digits trigger error." );
//		 Log.info("Expected Result: 19 and 20 digits accepted; 21 digits trigger error.");
//
//}
	
	
	
}
