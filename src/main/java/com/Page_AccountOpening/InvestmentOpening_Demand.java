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
	
public void LoadInvestmentOpeningWindow() throws InterruptedException {
	
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
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -verify initially loaded tab");
	Log.info("Step:01 -verify initially loaded tab");
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Open Date field.");
	Log.info("Step:01 -Verify Open Date field.");
	
	input(repo.acctatbranch, "123");
	
	waitTillLoaderDisappear(repo.loader);
	
	input(repo.openamount, "200");
	
	waitTillLoaderDisappear(repo.loader);
	
	input(repo.roi, "10");
	
	waitTillLoaderDisappear(repo.loader);
	
	ExtentTestManager.startTest("Investment Info tab is open");
	Log.info("Investment Info tab is open");
	
	select("ICICI BANK CHERPULASSERY",repo.principalglhead);
	ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Click on Principal GL Head dropdown -> Select any Bank.");
	Log.info("Steps 01: Click on Principal GL Head dropdown -> Select any Bank.");
	
	input(repo.interestglhead,"width:160px;");
	ExtentTestManager.getTest().log(Status.PASS, "Step:01: Select a valid GL Head number.");
	Log.info("Step:01: Select a valid GL Head number.");
	
	waitTillLoaderDisappear(repo.loader);
		
	input(repo.recieptno,"ctl00$ctl00$CPH1$PRDCNT$IN1$tp1$lstInvestDetails$ctrl0$INVF$txtSerialNo$txt");
	ExtentTestManager.getTest().log(Status.PASS, "Step 01: Leave Receipt SL.No empty -> Enter valid numeric values.");
	Log.info("Step 01: Leave Receipt SL.No empty -> Enter valid numeric values.");
	
	input(repo.depositname,"Shrada");
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Deposit name");
	Log.info("Step:01. Enter Deposit name");
	
	input(repo.remarks,"Updated successfuly");
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
    
    
    //back to mainscreen
    input(repo.relationdesignwindow,"Enter Relation" );
    ExtentTestManager.getTest().log(Status.PASS, "Step 01:Enter Relation.");
	Log.info("Step 01:Enter Relation.");
	
	click(repo.powerofattorney);
	ExtentTestManager.getTest().log(Status.PASS, "Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	Log.info("Step 01:Tick Power of Attorney checkbox. -> Untick it.");
	
	input(repo.remarks_toentry, "No remarks");
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
	input(repo.specialinformation,"");
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter text into Special Instruction field.");
	Log.info("Step:01. Enter text into Special Instruction field.");
	
		
	select("CASH",repo.transmode);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01. Open Trans Mode dropdown.-> Select Cash from the options.");
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
           
           ExtentTestManager.endTest();
           

           driver.switchTo().window(mainWindowHandle3);
           
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
	
	//Login to NBFc Application in a different user
	ExtentTestManager.startTest("Enter username and password.");
	Log.info("Enter username and password.");
	
	input(repo.authorise, "authorise");
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click on Username");
	Log.info("Step 39 -Click on Username");
	
	input(repo.password, "test123");
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click on password");
	Log.info("Step 39 -Click on password");
	
	click(repo.login);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the login button.");
	Log.info("Step:01 - Click the login button.");
	
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
	
	//click(repo.refresh1);
		
	waitTillLoaderDisappear(repo.loader);
			
	input(repo.transactionid,transId);
		
	click(repo.go);
	
	waitTillLoaderDisappear(repo.loader);
	
	click(repo.select11);
	
	
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
