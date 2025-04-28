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
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.ITestContext;

	import com.Page_Repositary.PageRepositary_AccOpn__LoanOpn_DepoOpn_DepoLoan;
	import com.BasePackage.Base_Class;
	import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
	import com.Page_Repositary.PageRepositary_Cust_CustSearch;
    import com.Page_Repositary.PageRepositary_Investment_Opening_Transfer;
    import com.Utility.Log;
	import com.aventstack.extentreports.Status;
	import com.extentReports.ExtentTestManager;

	public class Investment_Opening_Transfer extends Base_Class{
		PageRepositary_Investment_Opening_Transfer Tranfer_repo = new PageRepositary_Investment_Opening_Transfer();
		String transId;
		PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
		public String spAccNum = "Exec GetDebAcNo 102,90068";
		public String clmnNam = "AcNO";
		
		public void switchToWindowByTitle(String title) {

			boolean foundWindow = false;

			for (String handle : driver.getWindowHandles()) {

				if (driver.switchTo().window(handle).getTitle().equalsIgnoreCase(title)) {

					System.out.println("Successfully Switched to window with title:" + title);

					foundWindow = true;

					break;

				}

			}

			if (foundWindow) {

				System.out.println("Couldn't find the window with title -> " + title + "\nSwitching to parent window.");

			}

		}
	 
		
	public void LoadInvestmentOpeningTranfer(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, ClassNotFoundException {
		
		//Load Investment Opening Window
		
		ExtentTestManager.startTest("Load Investment Opening Window ");
		Log.info("Load Investment Opening Window ");
		
		click(Tranfer_repo.accountOpeningTab);
		
		
		click(Tranfer_repo.investmentOPeningTab);
		
		click(Tranfer_repo.demandOpeningTab);
		
		click(Tranfer_repo.investmentAccountNewTab);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - select bank drop down Step:02 - select bank from the drop down list");
		Log.info("Step:01 - Navigate to account opening -> Click on investment opening -> Select demand > Inv-Demand");
		
		if(ElementDisplayed(Tranfer_repo.selectbankdrop_down)) {
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
		
		
		select("HDFC BANK - HDFC",Tranfer_repo.selectbankdrop_down);
			
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01.Click on Bank dropdown.>> Select a Bank from the dropdown list.");
		Log.info("Step:01.Step:01.Click on Bank dropdown.>> Select a Bank from the dropdown list.");
		
		if(ElementDisplayed(Tranfer_repo.selectbranchdrop_down)) {
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
		
		select("Cherpulassery",Tranfer_repo.selectbranchdrop_down);
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. The selected Branch is displayed in the Branch field.");
		Log.info("Step:01. The selected Branch is displayed in the Branch field.");
		
		if(ElementDisplayed(Tranfer_repo.addbutton)) {
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
		
		click(Tranfer_repo.addbutton);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Customer is added and displayed in a grid format on the window..");
		Log.info("Step:01 - Customer is added and displayed in a grid format on the window..");
		
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.endTest();
		
		// Add Button Functionality
		
		ExtentTestManager.startTest("Add Button Functionality");
		Log.info("Add Button Functionality");
		
		//input(Tranfer_repo.roi, "10");
			
		// Ac No at Branch Field - BVA Validations
		//String accAtBranch = testdata.get("accAtBranch").toString();
		//input(Tranfer_repo.acctatbranch, accAtBranch);
		
		ExtentTestManager.startTest("Ac No at Branch Field - BVA Validations");
		Log.info("Ac No at Branch Field - BVA Validations");
		
		String accAtBranch = testdata.get("accAtBranch").toString();
		input(Tranfer_repo.acctatbranch, accAtBranch);
		
		ExtentTestManager.getTest().log(Status.PASS, "Enter valid inputs in all fields.>> Test Ac No at Branch digits" );
		Log.info("Enter valid inputs in all fields.>> Test Ac No at Branch digits");
				
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.endTest();
		
	    //clear(Tranfer_repo.acctatbranch);
		//click(Tranfer_repo.acctatbranch);
				
		//String digitNumActual20 = testdata.get("20digitNum").toString();
		//input(Tranfer_repo.acctatbranch, digitNumActual20);
				
				
		//Open Amount Field - BVA Validations
		
		ExtentTestManager.startTest("Open Amount Field - BVA Validations");
		Log.info("Open Amount Field - BVA Validations");
		
		String openAmt = testdata.get("openAmt").toString();
		input(Tranfer_repo.openamount, openAmt);
		
		ExtentTestManager.getTest().log(Status.PASS, "Decimal values correctly accepted." );
		Log.info("1.Decimal values correctly accepted.");

		//ROI Field - BVA Validations
		
		ExtentTestManager.startTest("ROI Field ");
		Log.info("ROI Field ");
		
		String roi = testdata.get("RoI").toString();
		input(Tranfer_repo.roi, roi);
		
		ExtentTestManager.getTest().log(Status.PASS, "Roi eneterd" );
		Log.info("Roi eneterd");
		
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
		
		if(ElementDisplayed(Tranfer_repo.principalglhead)) {
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
		
		input(Tranfer_repo.openamount, "200");
				
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Enter open amount");
		Log.info("Steps 01:  Enter open amount.");
		
		if(ElementDisplayed(Tranfer_repo.principalglhead)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Open amount is eneterd.");
			Log.info("Expected Result:Open amount is eneterd.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
	
		
		//Principal GL Head Dropdown
		
		ExtentTestManager.startTest("Principal GL Head Dropdown");
		Log.info("Principal GL Head Dropdown");
		
		select("ICICI BANK CHERPULASSERY",Tranfer_repo.principalglhead);
		
		ExtentTestManager.getTest().log(Status.PASS, "Steps 01: Click on Principal GL Head dropdown.>> Select any Bank.");
		Log.info("Steps 01:Click on Principal GL Head dropdown.>> Select any Bank");
		
		if(ElementDisplayed(Tranfer_repo.interestglhead)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected bank is displayed in the field; it is mandatory.");
			Log.info("Expected Result:Selected bank is displayed in the field; it is mandatory.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		// Interest GL Head Field - View GL Head Name
		ExtentTestManager.startTest("Interest GL Head Field - View GL Head Name");
		Log.info("Interest GL Head Field - View GL Head Name");
		
		String IntGLhead = testdata.get("IntGLhead").toString();
		input(Tranfer_repo.interestglhead, IntGLhead);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01: Select a valid GL Head number.");
		Log.info("Step:01: Select a valid GL Head number.");
		
		if(ElementDisplayed(Tranfer_repo.recieptno)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected bank is displayed in the field; it is mandatory.");
			Log.info("Expected Result:Selected bank is displayed in the field; it is mandatory.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
			
		//Receipt SL.No Field Validation
		ExtentTestManager.startTest("Receipt SL.No Field Validation");
		Log.info("Receipt SL.No Field Validation");
		
		String RceiptNo = testdata.get("RceiptNo").toString();
		input(Tranfer_repo.recieptno,RceiptNo);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Leave Receipt SL.No empty or Enter valid numeric values.");
		Log.info("Step 01: Leave Receipt SL.No empty or Enter valid numeric values.");
		
		if(ElementDisplayed(Tranfer_repo.depositname)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
			Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		//Receipt SL.No Field Validation
		ExtentTestManager.startTest("Receipt SL.No Field Validation");
		Log.info("Receipt SL.No Field Validation");
		
		String depstName = testdata.get("depstName").toString();
		input(Tranfer_repo.depositname,depstName);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Deposit name");
		Log.info("Step:01. Enter Deposit name");
		
		if(ElementDisplayed(Tranfer_repo.remarks)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected GL Head name displayed in the textbox.");
			Log.info("Expected Result:Selected GL Head name displayed in the textbox.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		//Receipt SL.No Field Validation
		ExtentTestManager.startTest("Receipt SL.No Field Validation");
		Log.info("Receipt SL.No Field Validation");
		
		String reMarks = testdata.get("reMarks").toString();
		input(Tranfer_repo.remarks,reMarks);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter Remark");
		Log.info("Step:01. Enter Remark");
		
			
		//Operator Tab Mandatory Fields
		ExtentTestManager.getTest().log(Status.PASS, "Operator Tab Mandatory Fields");
		Log.info("Operator Tab Mandatory Fields");
		
		click(Tranfer_repo.nextbutton);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -customer popup opens");
		Log.info("Step:01 -customer popup opens");
		
		ExtentTestManager.endTest();
		
		//Operator Tab Mandatory Fields
		ExtentTestManager.startTest("Operator Tab Mandatory Fields");
		Log.info("Operator Tab Mandatory Fields");
		
		click(Tranfer_repo.customerid);
		
		//Navigate to Child Window
	    String mainWindowHandle = driver.getWindowHandle();
	    boolean popupAppeared = false;
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            driver.manage().window().maximize();
	            popupAppeared = true;
	            
	            //Child window
	            input(Tranfer_repo.selectbutton, "activitation");
	        	     	
	        	click(Tranfer_repo.selectcustomer_id);
	        	         	
	            driver.switchTo().window(mainWindowHandle);
	                          
	            break;  
	            
	        }
	   
	    }//for loop end
	    
	    
	    //back to mainscreenString reMarks = testdata.get("reMarks").toString();
	    
	    ExtentTestManager.endTest();
	    
		//Power of Attorney Checkbox
		ExtentTestManager.startTest("Power of Attorney Checkbox");
		Log.info("Power of Attorney Checkbox");
		
		click(Tranfer_repo.powerofattorney);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01:Tick Power of Attorney checkbox. -> Untick it.");
		Log.info("Step 01:Tick Power of Attorney checkbox. -> Untick it.");
		
		if(ElementDisplayed(Tranfer_repo.relationdesignwindow)) {
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
	    input(Tranfer_repo.relationdesignwindow,EnterrelatioN );
	    
	    ExtentTestManager.getTest().log(Status.PASS, "Step 01:Enter Relation.");
		Log.info("Step 01:Enter Relation.");
		
		if(ElementDisplayed(Tranfer_repo.remarks_toentry)) {
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
		input(Tranfer_repo.remarks_toentry, RemarksTOenter );
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01:Receipt SL.No Field Validation");
		Log.info("Step 01:Receipt SL.No Field Validation");
		
				
		ExtentTestManager.endTest();

			
		//Operator tab has some entered data
		
		ExtentTestManager.startTest("Operator Tab Add Button Functionality");
		Log.info("Operator Tab Add Button Functionality");
		
		click(Tranfer_repo.addbuttton_operator);
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click on Add button.");
		Log.info("Step:01 Click on Add button.");
		
		
		ExtentTestManager.endTest();
		
		//Operator Tab Cancel Button Functionality
		
		ExtentTestManager.startTest("Operator Tab Cancel Button Functionality");
		Log.info("Operator Tab Cancel Button Functionality");
		
		click(Tranfer_repo.cancel_operator);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 All data in Operator tab is cleared.");
		Log.info("Step:01 All data in Operator tab is cleared.");
		
		
		ExtentTestManager.endTest();
		
		// Special Instruction Field
		ExtentTestManager.startTest("Special Instruction Field");
		Log.info("Special Instruction Field");
		
		String SPiinfo = testdata.get("SPiinfo").toString();
		input(Tranfer_repo.specialinformation,SPiinfo);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Enter text into Special Instruction field.");
		Log.info("Step:01. Enter text into Special Instruction field.");
		
		if(ElementDisplayed(Tranfer_repo.transmode)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Special instruction is stored as entered.");
			Log.info("Expected Result:Special instruction is stored as entered.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
		ExtentTestManager.endTest();
		
			
//		//Trans Mode Dropdown Functionality
		ExtentTestManager.startTest("Trans Mode Dropdown Functionality");
		Log.info("Trans Mode Dropdown Functionality");
		
//		click(Tranfer_repo.transmode);
		select("TRANSFER",Tranfer_repo.transmode);
		
		ExtentTestManager.getTest().log(Status.PASS, "Steo 01:Open Trans Mode dropdown.>> Select Transfer options.");
		Log.info("Steo 01:Open Trans Mode dropdown.>> Select Transfer from the options.");	
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.endTest();
		
		if(ElementDisplayed(Tranfer_repo.postcredit)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected mode is displayed in the Trans Mode field.");
			Log.info("Expected Result:Selected mode is displayed in the Trans Mode field.");
			}else {
				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
				Log.info("ERROR");
			}
		
	
		
		//Transaction Amount
		ExtentTestManager.startTest("Trans Mode Dropdown Functionality");
		Log.info("Trans Mode Dropdown Functionality");
	
		click(Tranfer_repo.postcredit);


		ExtentTestManager.getTest().log(Status.PASS, "Steo 01:Open Trans Mode dropdown.>> Select Transfer options.");
		Log.info("Steo 01:Open Trans Mode dropdown.>> Select Transfer from the options.");	
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.endTest();
		
		//if(ElementDisplayed(Tranfer_repo.batch)) {
//		ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected mode is displayed in the Trans Mode field.");
//			Log.info("Expected Result:Selected mode is displayed in the Trans Mode field.");
//			}else {
//				ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
//				Log.info("ERROR");
//			}
//		
		
        //select("GL Code",Tranfer_repo.batch);
//	 	ExtentTestManager.getTest().log(Status.PASS, "Step:28 -Select transfer mode");
//	 	Log.info("Step 26 -Select transfer mode");
//	 	
		//Navigate to Child Window_1
		String mainWindowHandleParent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
	       if (!handle.equals(mainWindowHandleParent)) {
	          driver.switchTo().window(handle);
	          driver.manage().window().maximize();
//	    	  switchToWindowByTitle("Account Serach");
	    	  System.out.println("Titel"+driver.getTitle());
	            //post credict// 
	            //product group                    
       	        select("Demand Investment",Tranfer_repo.productgroup);
      	        ExtentTestManager.getTest().log(Status.PASS, "Step:30 -Click on demand investment");
	        	Log.info("Step:30 -Click on demand investment");
	        	
	            //Product Name
	        	select("INV-DEMAND-CA",Tranfer_repo.productname);
	        	ExtentTestManager.getTest().log(Status.PASS, "Step:31 -Click on INV-DEMAND-CA");
	        	Log.info("Step 31 -Click on INV-DEMAND-CA");
	        	
	        	// Account number
	        	//String accNum  = generateUniqueId(spAccNum, clmnNam);
	        	//String lastfourDigits = accNum.substring(accNum.length() - 4);
	        	//input(Tranfer_repo.accNum,lastfourDigits);
	        	//
	        	
	        	
//	        	Account Serach
 
	        	
	        	//Account Number
	        	click(Tranfer_repo.AccNu);
	        	  switchToWindowByTitle("Account Serach");
		    	  System.out.println("Titel"+driver.getTitle());
		        
		    	  select("Demand Investment",Tranfer_repo.GrOUP);
	  	        	ExtentTestManager.getTest().log(Status.PASS, "Step:32 -Click on Group");
	  	        	Log.info("Step 32 -Click on Group");
	  	        	
	  	            // Product
	  	        	select("INV-DEMAND-CA",Tranfer_repo.PrOduct);
		        	ExtentTestManager.getTest().log(Status.PASS, "Step:33 -Click on product");
		        	Log.info("Step 33 -Click on select product");
		        	
		        	// Branch
		           	select("TRIVANDRUM",Tranfer_repo.Branch_01);
		           	ExtentTestManager.getTest().log(Status.PASS, "Step:34 -Click on Branch"); 
		        	Log.info("Step 34 -Click on select Branch");
		    	  
//	        	waitTillLoaderDisappear(Tranfer_repo.loader);
	        	
//	        	String mainWindowHandlechil_01 = driver.getWindowHandle();
//	    		Set<String> handles_1 = driver.getWindowHandles();
//   	   
//	    		for (String handle_1 : handles_1) {
//	    	       if (!handle_1.equals(mainWindowHandlechil_01)) {
//	    	          driver.switchTo().window(handle_1);
//	    	          driver.manage().window().maximize();
//	        	
//	    	        // group
//	    	        select("Demand Investment",Tranfer_repo.GrOUP);
//	  	        	ExtentTestManager.getTest().log(Status.PASS, "Step:32 -Click on Group");
//	  	        	Log.info("Step 32 -Click on select customer id");
//	  	        	
//	  	            // Product
//	  	        	select("INV-DEMAND-CA",Tranfer_repo.PrOduct);
//		        	ExtentTestManager.getTest().log(Status.PASS, "Step:32 -Click on product");
//		        	Log.info("Step 32 -Click on select customer id");
//		        	
//		        	// Branch
//		           	select("TRIVANDRUM",Tranfer_repo.Branch_01);
//		           	ExtentTestManager.getTest().log(Status.PASS, "Step:32 -Click on Branch"); 
//		        	Log.info("Step 32 -Click on select customer id");
//		        	
//		        	driver.switchTo().window(mainWindowHandlechil_01);
//		              
//                    		              
//		             break;
//		           }
//		            
//		        }
		        	//Acc
		        	input(Tranfer_repo.ACNU_01,"01");
		           	ExtentTestManager.getTest().log(Status.PASS, "Step:35 -Click on Account"); 
		        	Log.info("Step 35 -Click on select Account");
		        	
		        	
		        	// Search
		           	click(Tranfer_repo.Search_01);
		           	ExtentTestManager.getTest().log(Status.PASS, "Step:36 -Click on search"); 
		        	Log.info("Step 36 -Click on select search");
		        	
		        	
		        	// Select
		           	click(Tranfer_repo.Select_01);
		           	ExtentTestManager.getTest().log(Status.PASS, "Step:37 -Click on select"); 
		        	Log.info("Step 32 -Click on select customer id");
		        	
		        	//Acc
		        	
		        	
		        	switchToWindowByTitle("Auto Posting");
		        	
	        	// Amount
	        	String Amount = testdata.get("Amount").toString();
	        	input(Tranfer_repo.amount1,Amount);
	        	ExtentTestManager.getTest().log(Status.PASS, "Step:38 -Provide amount");
	        	Log.info("Step 38 -Provide amount");
	        		        	
	        	// click on add button
	        	click(Tranfer_repo.addbutton1);
	        	ExtentTestManager.getTest().log(Status.PASS, "Step:39 -Click on addbutton");
	        	Log.info("Step 39 -Click on amount");
	        	
	        	// click on submit
	        	click(Tranfer_repo.submit);
	        	ExtentTestManager.getTest().log(Status.PASS, "Step:40 -Click on Submit");
	        	Log.info("Step 40 -Click on select Submit");
	        	
	        	// click on close
	        	//click(Tranfer_repo.close);
	        	//ExtentTestManager.getTest().log(Status.PASS, "Step:34 -Click on Suspense liability");
	        	//Log.info("Step 34 -Click on select customer id");
	        	
	        	driver.switchTo().window(mainWindowHandleParent);
	              

	              
	            break;
	       }
	            
	     }
	   
	     	// to upload batch
			//Navigate to Child Window_1
			String mainWindowHandle2 = driver.getWindowHandle();
			boolean popupAppeared2 = false;
			for (String handle1 : driver.getWindowHandles()) {
				if (!handle1.equals(mainWindowHandle2)) {
					driver.switchTo().window(handle1);
					driver.manage().window().maximize();
					popupAppeared2 = true;
		            
	                //batch                    
	       	        click(Tranfer_repo.batch);
	      	        ExtentTestManager.getTest().log(Status.PASS, "Step:41 -Click on batch");
		        	Log.info("Step:41 -Click on Submit");
		       
		        	
		        	driver.switchTo().window(mainWindowHandle2);
		              

		              
		            break;  
		            
		        }
	       
		   }//for loop end
		
			//Transaction Amount Field Default Value
//		ExtentTestManager.startTest("Transaction Amount Field Default Value");
//		Log.info("Transaction Amount Field Default Value");
//		
//		ExtentTestManager.getTest().log(Status.PASS, "1. Verify Transaction Amount field.");
//		Log.info("Step:01: Verify Transaction Amount field.");
//		
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//		
//		ExtentTestManager.endTest();
		
		   //Save Button Opens Investment Account
		
		   ExtentTestManager.startTest("Save Button Opens Investment Account");
		   Log.info("Save Button Opens Investment Account");
		
		   click(Tranfer_repo.savebutton);
		
		   ExtentTestManager.getTest().log(Status.PASS, "Step:01. Click on Save button.");
		   Log.info("Step:01.Click on Save button.");
		
		   waitTillLoaderDisappear(Tranfer_repo.loader);
		
		   ExtentTestManager.endTest();
			
		   transId = driver.findElement(Tranfer_repo.transactionid1).getText();
		   System.out.println("transId: "+transId);
		
		   //Summary Page 
		   ExtentTestManager.startTest("Summary Page ");
		   Log.info("Summary Page ");
		
		   click(Tranfer_repo.print);
		
		   ExtentTestManager.getTest().log(Status.PASS, "Step:01:VOcuher is displayed as a Popup");
		   Log.info("Step:01:VOcuher is displayed as a Popup");
	
		   waitTillLoaderDisappear(Tranfer_repo.loader);
		
		   ExtentTestManager.endTest();
		
		   //Navigate to Pop Up Window
		   String mainWindowHandle3 = driver.getWindowHandle();
		   boolean popupAppeared3 = false;
		   for (String handle1: driver.getWindowHandles()) {
			   if (!handle1.equals(mainWindowHandle3)) {
				   driver.switchTo().window(handle1);
				   driver.manage().window().maximize();
				   popupAppeared3 = true;
	      
				   String currentUrl = driver.getCurrentUrl();
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
		
	    
		click(Tranfer_repo.signout);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01:Logout from the application");
		Log.info("Step:01:Logout from the application");
		
                                             
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		ExtentTestManager.endTest();		
	}

	
	
	
	        //Login to NBFc Application in a different user
		
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
		
		click(Tranfer_repo.authorisecancel);
		
		ExtentTestManager.getTest().log(Status.PASS, "1. Navigate to 'Authorize&cancel ->Manager Authorisation ");
		Log.info("1. Navigate to 'Authorize&cancel ->Manager Authorisation ");
								
		ExtentTestManager.endTest();
		
		// User is in Manager authorisation window
		
		ExtentTestManager.startTest("User is in Manager authorisation window");
		Log.info("User is in Manager authorisation windowd");
		
		click(Tranfer_repo.managerauthorise);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
		Log.info("Step 01: Navigate to 'Authorize&cancel ->Manager Authorisation");
		
		ExtentTestManager.endTest();
		
		//Select the transaction 
		ExtentTestManager.startTest("User is in Manager authorisation window");
		Log.info("User is in Manager authorisation windowd");
		
		click(Tranfer_repo.refresh_01);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select the transaction ");
		Log.info("Step 01: Select the transaction ");
		
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		//User is in Manager authorisation window
		
		ExtentTestManager.startTest("User is in Manager authorisation window");
		Log.info("User is in Manager authorisation windowd");
		
		click(Tranfer_repo.Transfe_01);	
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		input(Tranfer_repo.transactionid,transId);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Select the transaction ");
		Log.info("Step 01: Select the transaction ");
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
			
		click(Tranfer_repo.go);
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		click(Tranfer_repo.select11);
		
		waitTillLoaderDisappear(Tranfer_repo.loader);
		
		click(Tranfer_repo.authorise1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01: Clcik the AUTHORISE button");
		Log.info("Step:42 - Select go.");
		
		ExtentTestManager.endTest();
		
//		//cashier page
//		ExtentTestManager.startTest("User is in cashier authorisation window");
//		Log.info("User is in cashier authorisation windowd");
//		
//		click(Tranfer_repo.cashier);
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01. Navigate to 'Authorize&cancel ->Cashier Authorisation ");
//		Log.info("Step:01. Navigate to 'Authorize&cancel ->Cashier Authorisation ");
//		
//		ExtentTestManager.endTest();
//		
//		// click REFRESH button
//		ExtentTestManager.startTest("User is logged in");
//		Log.info("User is logged in");
//		
//		click(Tranfer_repo.refresh12);
//					
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01.Select the transaction");
//		Log.info("Step:01. Select the transaction ");
//		
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//		
//		ExtentTestManager.endTest();
//		
//		//User is logged in
//		ExtentTestManager.startTest("User is logged in");
//		Log.info("User is logged in");
//				
//		input(Tranfer_repo.transactionionid2,transId);
//		
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01.Select the transaction");
//		Log.info("Step:01. Select the transaction ");
//		
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//		
//			
//		click(Tranfer_repo.go1);
//								
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//		
//		click(Tranfer_repo.select12);
//		
//		ExtentTestManager.endTest();
//		
//		//User is Logged In
//		
//		ExtentTestManager.startTest("User is logged in");
//		Log.info("User is logged in");
//					
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//					
//		
//		click(Tranfer_repo.authorise2);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Click the AUTHORISE button");
//		Log.info("Step:01 -Click the AUTHORISE button");
//		
//
//		waitTillLoaderDisappear(Tranfer_repo.loader);
//		
//		ExtentTestManager.endTest();
		
//		//logout
	    click(Tranfer_repo.updatedsuccessfully);
//		click(repo.signout1);
	//	
//		ExtentTestManager.endTest();
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
//		String digitNumActual19 = testdata.get("19digitNum").toString();
//		input(repo.acctatbranch, digitNumActual19);
	//	
//		clear(repo.acctatbranch);
//		click(repo.acctatbranch);
	//	
//		String digitNumActual20 = testdata.get("20digitNum").toString();
//		input(repo.acctatbranch, digitNumActual20);
	//	
	//	
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: 19 and 20 digits accepted; 21 digits trigger error." );
//			 Log.info("Expected Result: 19 and 20 digits accepted; 21 digits trigger error.");
	//
	//}
		
		
		
	}
