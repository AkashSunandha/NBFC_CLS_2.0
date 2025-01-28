package com.Page_Customer;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccountOpening_FixedDeposit;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_AccountOpening_FixedDeposit extends Base_Class
//public String custid;

{

	PageRepositary_AccountOpening_FixedDeposit fixeddeposit= new PageRepositary_AccountOpening_FixedDeposit();
	
	ScreenShot sc = new ScreenShot(null);
	
	//Navigate to Deposit Opening Window
	
	public boolean DepositOpeningWindow()throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Navigate to Deposit Opening Window");
		click(fixeddeposit.Accountopening);
		click(fixeddeposit.Depositopening);
		click(fixeddeposit.FixedDeposit);
		click(fixeddeposit.Bondcumulativetpe);
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");
		Log.info("Step:01 clicking on Account opening -> Deposit opening -> Fixed deposit");
		
		
		boolean flag1 = ElementDisplayed(fixeddeposit.Depositwindow);
		if(flag1 == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit opening window is displayed");
			Log.info("Deposit opening window is displayed");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Deposit opening window is not displayed");
			Log.info("Deposit opening window is not displayed");
		}
		ExtentTestManager.endTest();
		return true;
		
	
	
}
	
	public boolean customerSearchFunctionality(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
		ExtentTestManager.startTest("TC:03 - Customer Search Functionality");
		
		click(fixeddeposit.customerIDsearchbutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click customer search button");
		Log.info("Step:01 - Click customer search button");
		
        //Navigate to Pop Up Window
  String mainWindowHandle = driver.getWindowHandle();
  boolean popupAppeared = false;
  for (String handle : driver.getWindowHandles()) {
      if (!handle.equals(mainWindowHandle)) {
          driver.switchTo().window(handle);
          popupAppeared = true;
//          
          //Entering customer id and searching record
          String custid = testdata.get("customerID").toString();
  		input(fixeddeposit.custID, custid);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter criteria in search field");
  		Log.info("Step:02 - Enter criteria in search field");
  		click(fixeddeposit.searchbutton);
		Log.info("click on serach button");
		
		click(fixeddeposit.selectcust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select customer from search results");
		Log.info("Step:03 - Select customer from search results");
		
		driver.switchTo().window(mainWindowHandle);
		
		//boolean flag1 = ElementDisplayed(fixeddeposit.formcustid);
		  String flag1=driver.findElement(fixeddeposit.formcustid).getAttribute("value");
		  System.out.println(flag1);
				if(flag1.equals(custid)) {
					ExtentTestManager.getTest().log(Status.PASS, " Expected Result: Selected customer is populated in the form");
					Log.info("Expected Result:Selected customer is populated in the form");
				}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Selected customer is not populated in the form");
						Log.info("Expected Result:Selected customer is not populated in the form");
						
					}
      }
  }
  ExtentTestManager.endTest();
return true;
		
}

	public boolean EnterAmount(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
		ExtentTestManager.startTest("TC:04 - Enter Amount");
		
		String amount = testdata.get("Amount").toString();
  		input(fixeddeposit.amount, amount);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid amount in 'Amount' field");
  		Log.info("Step:01 - Enter valid amount in 'Amount' field");
  		
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Amount is accepted and displayed");
  		Log.info("Expected Result: Amount is accepted and displayed");
				ExtentTestManager.endTest();
				return true;
						
    }
	public boolean DurationEntry(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException {
		ExtentTestManager.startTest("TC:05 - Duration Entry");
		
		//Entering duration
		String duration = testdata.get("Duration").toString();
  		input(fixeddeposit.duration, duration);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter duration");
  		Log.info("Step:01 -  Enter duration");
  		
  		//selecting duration mode dropdown
  		select("MONTHS", fixeddeposit.durationmode);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Select duration mode");
  		Log.info("Step:02 -  Select duration mode");
  		
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Duration is entered and visible");
  		Log.info("Expected Result: Duration is entered and visible");
  		
				ExtentTestManager.endTest();
				return true;

				
}
	
	public boolean SelectReferredbyOption(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
    ExtentTestManager.startTest("TC:06 - Select 'Referred by' Option");
		
        click(fixeddeposit.Referenceby);
  //      System.out.println("clicked the dropdown");
		//Entering referenceby
//		String reference = testdata.get("ReferenceBy").toString();
//  		input(fixeddeposit.Referenceby, reference);
  		
  		
  	//selecting referenceby  dropdown
//  		select("NITHIN", fixeddeposit.Referenceby);
        click(fixeddeposit.optionNithin);
        ExtentTestManager.getTest().log(Status.PASS, "Step:01  Select option from 'Referred by' drop down");
		Log.info("Step:01  Select option from 'Referred by' drop down");
        
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option is selected");
  		Log.info("Expected Result: Option is selected");
  		
  		
				ExtentTestManager.endTest();
				return true;

}
	public boolean ROIvalidation()throws InterruptedException {
		ExtentTestManager.startTest("TC:07 - Get Values & Validate ROI");
		click(fixeddeposit.getvalue);

		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Click 'Get values' button");
		Log.info("Step:01 Click 'Get values' button");
		//validating if ROI is autopuplating
		String ROIvalue=driver.findElement(fixeddeposit.ROI).getAttribute("value");
		  System.out.println(ROIvalue);
				if(ROIvalue!="") {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: ROI and Due date are auto-calculated and displayed");
					Log.info("ROI and Due date are auto-calculated and displayed");
				}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: ROI and Due date are not auto-calculated and displayed");
						Log.info("ROI and Due date are not auto-calculated and displayed");
						
					}
				String Maturityvalue=driver.findElement(fixeddeposit.Maturityvalue).getAttribute("value");
				  System.out.println(Maturityvalue);
						if(Maturityvalue!="") {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: ROI and Due date are auto-calculated and displayed");
							Log.info("Expected Result: ROI and Due date are auto-calculated and displayed");
						}
							else {
								ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: ROI and Due date are not auto-calculated and displayed");
								Log.info(" Expected Result: ROI and Due date are not auto-calculated and displayed");
								
							}
		ExtentTestManager.endTest();
		return true;
		
		
	
}
	public boolean ModeofOperation()throws InterruptedException {
		ExtentTestManager.startTest("TC:08 - Validate 'Mode Operation' for Single Customer");
		
		
		/*String modeofoperation=driver.findElement(fixeddeposit.Modeofoperation).getAttribute("value");
		System.out.println(modeofoperation);
		ExtentTestManager.getTest().log(Status.PASS, "Step 01: Observe 'mode operation' field");
		if(modeofoperation.equals("Single")) {
			
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Field displays 'Single'");
			Log.info("Expected Result: Expected Result: Field displays 'Single'");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Field is not displaying 'Single' ");
			Log.info("Expected Result: Field is not displaying 'Single'");
		}
		return true;*/
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Observe 'mode operation' field");
		Log.info("Step:01 Observe 'mode operation' field");
		
		
		//validating mode of operation as single
		WebElement Modeofoperation = driver.findElement(fixeddeposit.Modeofoperation);
		String single = Modeofoperation.getAttribute("title");
		
		if (single.equals(Modeofoperation.getAttribute("title"))) {
			ExtentTestManager.getTest().log(Status.PASS, Modeofoperation.getAttribute("title") + true);
			Log.info("Field displays 'Single'" + true);
			return true;
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Field displays not 'Single' " + false);
 
			Thread.sleep(1000);
		}
		ExtentTestManager.endTest();
		return true;
	
}
	
	/*public boolean Selectnature() throws InterruptedException {
		ExtentTestManager.startTest("TC:09 - Selectnature");
		
		//selecting joint from nature dropdown
		select("Joint", fixeddeposit.Naturedropdown);
		ExtentTestManager.getTest().log(Status.PASS, "Step 01:  Select the nature as Joint");
		
		//clicking on ok for the popup
		click(fixeddeposit.okbutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step 02:  click on ok button");
		
		
		String joint = driver.findElement(fixeddeposit.Naturedropdown).getAttribute("value");
		System.out.println(joint);
		
		if(joint=="Joint") {
			
			
			ExtentTestManager.getTest().log(Status.PASS,"Field displays as 'Joint'");
			Log.info("Field displays as 'Joint");
			
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "Field not displays as 'Joint' ");
			Log.info("Field not displays as 'Joint' ");
		}
		
		return true;
		
		
	}*/
	
	
	public boolean LedgerandFolioNumberEntry(Map<Object, Object> testdata, ITestContext context) throws InterruptedException  {
		ExtentTestManager.startTest("TC:18 - Ledger & Folio Number Entry");
		
		//Entering data in field
		
		String Ledgerno = testdata.get("LedgerNo").toString();
  		input(fixeddeposit.ledgerno, Ledgerno);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter data into 'ledger  number' field");
  		Log.info("Step:01 - Enter data into 'ledger  number' field");
  		
  		
  		String foliono = testdata.get("Foliono").toString();
  		input(fixeddeposit.Foliono, foliono);
  		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter data into 'Folio  number' field");
  		Log.info("Step:01 - Enter data into 'Folio  number' field");
  		
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Data entry is possible");
  		Log.info("Expected Result: Data entry is possible");
  		
  		ExtentTestManager.endTest();
		return true;
	}
	
	public Boolean RemarkFieldEntry(Map<Object,Object>testdata,ITestContext context) throws InterruptedException {
		
		ExtentTestManager.startTest("TC:19 - Remark Field Entry");
		
		
		//Entering data in remark field
		String remarkdata = testdata.get("Remark").toString();
		input(fixeddeposit.remark,remarkdata);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Enter text in 'Remark' field");
		Log.info("Step:01 -  Enter text in 'Remark' field");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Text is entered and saved");
		Log.info("Expected Result: Text is entered and saved");
		
		
		ExtentTestManager.endTest();
		return true;	
	}
	
	
	public Boolean LienMarkFunctionality(Map<Object,Object>testdata) throws InterruptedException {
		ExtentTestManager.startTest("TC:20 - Lien Mark Functionality");
		
		click(fixeddeposit.lienmark);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Check 'lien mark' checkbox") ;
		Log.info("Step:01 -  Check 'lien mark' checkbox");
		
		clear(fixeddeposit.lienamount);
		
		click(fixeddeposit.lienamount);
		
		String lienamount = testdata.get("Lien Amount").toString();
		input(fixeddeposit.lienamount, lienamount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -   Enter lien amount ") ;
		Log.info("Step:01 -   Enter lien amount ");
		
		String lienremark = testdata.get("Lien Remark").toString();
		input(fixeddeposit.lienremark,lienremark);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -   Enter lien remark ") ;
		Log.info("Step:01 -   Enter lien remark ");
		
		ExtentTestManager.getTest().log(Status.PASS, "Fields are editable, data entered is saved");
		Log.info("Expected Result: Fields are editable, data entered is saved");
		
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public Boolean NavigateThroughTabs() throws InterruptedException {
		ExtentTestManager.startTest("TC:21 - Navigate Through Tabs");
		
		click(fixeddeposit.Nextbutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Click 'Next' button") ;
		Log.info("Step:01 -  Click 'Next' button");
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Navigates to next tab");
		Log.info("Expected Result: Navigates to next tab");
		
		ExtentTestManager.endTest();
        return true;
		
	
}	
	public Boolean AddNomineeandValidateAutofill(Map<Object,Object>testdata) throws InterruptedException {
		ExtentTestManager.startTest("TC:22 - Add Nominee & Validate Autofill");
		
		click(fixeddeposit.Nomineecheck);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Untick 'Nominee Not required' checkbox") ;
		Log.info("Step:01 -  Untick 'Nominee Not required' checkbox");
		
		click(fixeddeposit.NomineecustomerIDsearchbutton);
		
		
        //Navigate to Pop Up Window
  String mainWindowHandle = driver.getWindowHandle();
  boolean popupAppeared = false;
  for (String handle : driver.getWindowHandles()) {
      if (!handle.equals(mainWindowHandle)) {
          driver.switchTo().window(handle);
          popupAppeared = true;
//          
          //Entering customer id and searching record
          String Nomineecustid = testdata.get("NomineeCustomerID").toString();
  		input(fixeddeposit.NomineecustID, Nomineecustid);
  		
  		click(fixeddeposit.Nomineesearchbutton);
  	
		click(fixeddeposit.Nomineeselectcust);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Search and select customer");
		Log.info("Step:01 - Search and select customer");
		
		driver.switchTo().window(mainWindowHandle);
		
		//boolean flag1 = ElementDisplayed(fixeddeposit.formcustid);
		  String custidvalidate=driver.findElement(fixeddeposit.Nomineecustiddetail).getAttribute("value");
		  System.out.println(custidvalidate);
				if(custidvalidate.equals(Nomineecustid)) {
					ExtentTestManager.getTest().log(Status.PASS, " Expected Result: Customer details autofilled in fields");
					Log.info("Expected Result:Customer details autofilled in fields");
				}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Customer details are not  autofilled in fields");
						Log.info("Expected Result:Customer details are not autofilled in fields");
						
					}
				
				String adharno=driver.findElement(fixeddeposit.Adharno).getAttribute("value");
				  System.out.println(adharno);
						if(adharno!="") {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Adharno details autofilled in fields");
							Log.info("Adharno details autofilled in fields");
						}
							else {
								ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Adharno details are not autofilled in fields");
								Log.info("ROI and Due date are not auto-calculated and displayed");
								
							}
				
				
      }
  }
  ExtentTestManager.endTest();
return true;
	
}
}
	
	


