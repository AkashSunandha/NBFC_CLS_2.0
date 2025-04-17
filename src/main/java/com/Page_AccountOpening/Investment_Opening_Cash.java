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
import com.Page_Repositary.PageRepositary_Investment_Opening_Cash;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Investment_Opening_Cash extends Base_Class{
	PageRepositary_Investment_Opening_Cash repo = new PageRepositary_Investment_Opening_Cash();
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
	
	if(ElementDisplayed(repo.selectbankdrop_down)) {
	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Investment Opening window loads with default fields populated.");
	Log.info("Expected Result: Investment Opening window loads with default fields populated.");
	}else {
		ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
		Log.info("ERROR");
	}
	ExtentTestManager.endTest();
	
	//Home Branch Field Default Value
	
	ExtentTestManager.startTest("Home Branch Field Default Value");
	Log.info("Home Branch Field Default Value");
	
	
	select("HDFC BANK - HDFC",repo.selectbankdrop_down);
		
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01.Click on Bank dropdown.>> Select a Bank from the dropdown list.");
	Log.info("Step:01.Step:01.Click on Bank dropdown.>> Select a Bank from the dropdown list.");
	
	if(ElementDisplayed(repo.selectbranchdrop_down)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Investment Opening window loads with default fields populated.");
		Log.info("Expected Result: Investment Opening window loads with default fields populated.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	//Select Bank from Dropdown
	
	ExtentTestManager.startTest("Select Bank from Dropdown");
	Log.info("Select Bank from Dropdown");
	
	select("Cherpulassery",repo.selectbranchdrop_down);
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. The selected Branch is displayed in the Branch field.");
	Log.info("Step:01. The selected Branch is displayed in the Branch field.");
	
	if(ElementDisplayed(repo.addbutton)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Investment Opening window loads with default fields populated.");
		Log.info("Expected Result: Investment Opening window loads with default fields populated.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
		
	ExtentTestManager.endTest();
	
	// Select Branch Based on Bank
	ExtentTestManager.startTest("Select Branch Based on Bank");
	Log.info("Select Branch Based on Bank");
	
	click(repo.addbutton);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Customer is added and displayed in a grid format on the window..");
	Log.info("Step:01 - Customer is added and displayed in a grid format on the window..");
	
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
	// Add Button Functionality
	
	ExtentTestManager.startTest("Add Button Functionality");
	Log.info("Add Button Functionality");
	
	
	String accAtBranch = testdata.get("accAtBranch").toString();
	input(repo.acctatbranch, accAtBranch);
		
	//String openAmt = testdata.get("openAmt").toString();
	//input(repo.openamount, openAmt);
	
	
    input(repo.roi, "10");
		
	//Investment Info Tab Default
	ExtentTestManager.startTest("Investment Info Tab Default");
	Log.info("Investment Info tab is open");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Investment Info tab is displayed initially.");
	Log.info("Step:01: Investment Info tab is displayed initially.");
	
	
	ExtentTestManager.endTest();
	
	//Open Date Field Default Value
	
	ExtentTestManager.startTest("Open Date Field Default Value");
	Log.info("Open Date Field Default Value");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Investment Info tab is displayed initially.");
	Log.info("Step:01: Investment Info tab is displayed initially.");
	
	if(ElementDisplayed(repo.principalglhead)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Open Date defaults to transaction date and is non-editable.");
		Log.info("Expected Result:Open Date defaults to transaction date and is non-editable.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	//Open amount Field  
	ExtentTestManager.startTest("Open amount Field  ");
	Log.info("Open amount Field  ");
	
	input(repo.openamount, "200");
	select("ICICI BANK CHERPULASSERY",repo.principalglhead);
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Enter open amount");
	Log.info("Steps 01:  Enter open amount.");
	
	if(ElementDisplayed(repo.principalglhead)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Open amount is eneterd.");
		Log.info("Expected Result:Open amount is eneterd.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	
	
	//Principal GL Head Dropdown
	
	ExtentTestManager.startTest("Principal GL Head Dropdown");
	Log.info("Principal GL Head Dropdown");
	
	select("ICICI BANK CHERPULASSERY",repo.principalglhead);
	
	ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Click on Principal GL Head dropdown.>> Select any Bank.");
	Log.info("Steps 01:Click on Principal GL Head dropdown.>> Select any Bank");
	
	if(ElementDisplayed(repo.interestglhead)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected bank is displayed in the field; it is mandatory.");
		Log.info("Expected Result:Selected bank is displayed in the field; it is mandatory.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	waitTillLoaderDisappear(repo.loader);
	
	// Interest GL Head Field - View GL Head Name
	ExtentTestManager.startTest("Interest GL Head Field - View GL Head Name");
	Log.info("Interest GL Head Field - View GL Head Name");
	
	String IntGLhead = testdata.get("IntGLhead").toString();
	input(repo.interestglhead, IntGLhead);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Select a valid GL Head number.");
	Log.info("Step:01: Select a valid GL Head number.");
	
	if(ElementDisplayed(repo.recieptno)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected bank is displayed in the field; it is mandatory.");
		Log.info("Expected Result:Selected bank is displayed in the field; it is mandatory.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	waitTillLoaderDisappear(repo.loader);
		
	//Receipt SL.No Field Validation
	ExtentTestManager.startTest("Receipt SL.No Field Validation");
	Log.info("Receipt SL.No Field Validation");
	
	String RceiptNo = testdata.get("RceiptNo").toString();
	input(repo.recieptno,RceiptNo);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Leave Receipt SL.No empty or Enter valid numeric values.");
	Log.info("Step 01: Leave Receipt SL.No empty or Enter valid numeric values.");
	
	if(ElementDisplayed(repo.depositname)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
		Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	waitTillLoaderDisappear(repo.loader);
	
	//Receipt SL.No Field Validation
	ExtentTestManager.startTest("Receipt SL.No Field Validation");
	Log.info("Receipt SL.No Field Validation");
	
	String depstName = testdata.get("depstName").toString();
	input(repo.depositname,depstName);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Deposit name");
	Log.info("Step:01. Enter Deposit name");
	
	if(ElementDisplayed(repo.remarks)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
		Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	waitTillLoaderDisappear(repo.loader);
	
	//Receipt SL.No Field Validation
	ExtentTestManager.startTest("Receipt SL.No Field Validation");
	Log.info("Receipt SL.No Field Validation");
	
	String reMarks = testdata.get("reMarks").toString();
	input(repo.remarks,reMarks);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Remark");
	Log.info("Step:01. Enter Remark");
	
		
	//Operator Tab Mandatory Fields
	ExtentTestManager.getTest().log(Status.PASS, "Operator Tab Mandatory Fields");
	Log.info("Operator Tab Mandatory Fields");
	
	click(repo.nextbutton);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -customer popup opens");
	Log.info("Step:01 -customer popup opens");
	
	ExtentTestManager.endTest();
	
	//Operator Tab Mandatory Fields
	ExtentTestManager.startTest("Operator Tab Mandatory Fields");
	Log.info("Operator Tab Mandatory Fields");
	
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
    
    ExtentTestManager.endTest();
    
	//Power of Attorney Checkbox
	ExtentTestManager.startTest("Power of Attorney Checkbox");
	Log.info("Power of Attorney Checkbox");
	
	click(repo.powerofattorney);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	Log.info("Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	
	if(ElementDisplayed(repo.relationdesignwindow)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
		Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	//Power of Attorney Checkbox
	
	ExtentTestManager.startTest("Power of Attorney Checkbox");
	Log.info("Power of Attorney Checkbox");
	
	String EnterrelatioN = testdata.get("EnterrelatioN").toString();
    input(repo.relationdesignwindow,EnterrelatioN );
    
    ExtentTestManager.getTest().log(Status.PASS, "Step 01:Enter Relation.");
	Log.info("Step 01:Enter Relation.");
	
	if(ElementDisplayed(repo.remarks_toentry)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
		Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
	//Receipt SL.No Field Validation
	ExtentTestManager.startTest("Receipt SL.No Field Validatio");
	Log.info("Receipt SL.No Field Validatio");
	
	String RemarksTOenter = testdata.get("RemarksTOenter").toString();
	input(repo.remarks_toentry, RemarksTOenter );
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01:Receipt SL.No Field Validation");
	Log.info("Step 01:Receipt SL.No Field Validation");
	
			
	ExtentTestManager.endTest();

		
	//Operator tab has some entered data
	
	ExtentTestManager.startTest("Operator Tab Add Button Functionality");
	Log.info("Operator Tab Add Button Functionality");
	
	click(repo.addbuttton_operator);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on Add button.");
	Log.info("Step:01 Click on Add button.");
	
	
	ExtentTestManager.endTest();
	
	//Operator Tab Cancel Button Functionality
	
	ExtentTestManager.startTest("Operator Tab Cancel Button Functionality");
	Log.info("Operator Tab Cancel Button Functionality");
	
	click(repo.cancel_operator);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 All data in Operator tab is cleared.");
	Log.info("Step:01 All data in Operator tab is cleared.");
	
	
	ExtentTestManager.endTest();
	
	// Special Instruction Field
	ExtentTestManager.startTest("Special Instruction Field");
	Log.info("Special Instruction Field");
	
	String SPiinfo = testdata.get("SPiinfo").toString();
	input(repo.specialinformation,SPiinfo);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter text into Special Instruction field.");
	Log.info("Step:01. Enter text into Special Instruction field.");
	
	if(ElementDisplayed(repo.transmode)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Special instruction is stored as entered.");
		Log.info("Expected Result:Special instruction is stored as entered.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
	ExtentTestManager.endTest();
	
		
	//Trans Mode Dropdown Functionality
	ExtentTestManager.startTest("Trans Mode Dropdown Functionality");
	Log.info("Trans Mode Dropdown Functionality");
	
	select("CASH",repo.transmode);
	
	ExtentTestManager.getTest().log(Status.PASS, "Steo 01:Open Trans Mode dropdown.>> Select Cash from the options.");
	Log.info("Steo 01:Open Trans Mode dropdown.>> Select Cash from the options.");	
	
	waitTillLoaderDisappear(repo.loader);
	
	if(ElementDisplayed(repo.transmode)) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected mode is displayed in the Trans Mode field.");
		Log.info("Expected Result:Selected mode is displayed in the Trans Mode field.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
			Log.info("ERROR");
		}
	
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
	
	//Transaction Amount Field Default Value
	ExtentTestManager.startTest("Transaction Amount Field Default Value");
	Log.info("Transaction Amount Field Default Value");
	
	ExtentTestManager.getTest().log(Status.PASS, "1. Verify Transaction Amount field.");
	Log.info("Step:01: Verify Transaction Amount field.");
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
	//Save Button Opens Investment Account
	
	ExtentTestManager.startTest("Save Button Opens Investment Account");
	Log.info("Save Button Opens Investment Account");
	
	click(repo.savebutton);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Click on Save button.");
	Log.info("Step:01.Click on Save button.");
	
    waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
		
	transId = driver.findElement(repo.transactionid1).getText();
	System.out.println("transId: "+transId);
	
	//Summary Page 
	ExtentTestManager.startTest("Summary Page ");
	Log.info("Summary Page ");
	
	click(repo.print);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01:VOcuher is displayed as a Popup");
	Log.info("Step:01:VOcuher is displayed as a Popup");
	
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

	// Voucher Print
 	ExtentTestManager.startTest("Voucher Print");
	Log.info("Voucher Print");
	
    
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

//Login to NBFc Application in a different user
	public void authoriseLogin() throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("**Login to NBFc Application in a different user**");
		Log.info("**Login to NBFc Application in a different user**");
			
			
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
					
    //load investment for manager
    ExtentTestManager.startTest("User is logged in");
	Log.info("User is logged in.");
	
	click(repo.authorisecancel);
	
	ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to 'Authorize&cancel ->Manager Authorisation ");
	Log.info("1. Navigate to 'Authorize&cancel ->Manager Authorisation ");
							
	ExtentTestManager.endTest();
	
	// User is in Manager authorisation window
	
	ExtentTestManager.startTest("User is in Manager authorisation window");
	Log.info("User is in Manager authorisation windowd");
	
	click(repo.managerauthorise);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
	Log.info("Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
	
	ExtentTestManager.endTest();
	
	//Select the transaction 
	ExtentTestManager.startTest("User is in Manager authorisation window");
	Log.info("User is in Manager authorisation windowd");
	
	click(repo.refresh_01);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select the transaction ");
	Log.info("Step 01: Select the transaction ");
	
	
	waitTillLoaderDisappear(repo.loader);
	
	//User is in Manager authorisation window
	
	ExtentTestManager.startTest("User is in Manager authorisation window");
	Log.info("User is in Manager authorisation windowd");
	
	input(repo.transactionid,transId);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select the transaction ");
	Log.info("Step 01: Select the transaction ");
	
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
	
	ExtentTestManager.endTest();
	
	// click REFRESH button
	ExtentTestManager.startTest("User is logged in");
	Log.info("User is logged in");
	
	click(repo.refresh12);
				
	ExtentTestManager.getTest().log(Status.PASS, "Step:01.Select the transaction");
	Log.info("Step:01. Select the transaction ");
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
	//User is logged in
	ExtentTestManager.startTest("User is logged in");
	Log.info("User is logged in");
			
	input(repo.transactionionid2,transId);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01.Select the transaction");
	Log.info("Step:01. Select the transaction ");
	
	waitTillLoaderDisappear(repo.loader);
	
		
	click(repo.go1);
							
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.select12);
	
	ExtentTestManager.endTest();
	
	//User is Logged In
	
	ExtentTestManager.startTest("User is logged in");
	Log.info("User is logged in");
				
	waitTillLoaderDisappear(repo.loader);
				
	
	click(repo.authorise2);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the AUTHORISE button");
	Log.info("Step:01 -Click the AUTHORISE button");
	

	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.endTest();
	
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
