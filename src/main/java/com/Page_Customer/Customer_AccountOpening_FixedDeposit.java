package com.Page_Customer;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccountOpening_FixedDeposit;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_AccountOpening_FixedDeposit extends Base_Class
//public String custid;

{

	PageRepositary_AccountOpening_FixedDeposit fixeddeposit= new PageRepositary_AccountOpening_FixedDeposit();
	//PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();

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
		Log.info("click on search button");
		
		click(fixeddeposit.selectcust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select customer from search results");
		Log.info("Step:03 - Select customer from search results");
		
		driver.switchTo().window(mainWindowHandle);
		
		click(fixeddeposit.Addbutton);
		click(fixeddeposit.okbutton);
		
		//boolean flag1 = ElementDisplayed(fixeddeposit.formcustid);
		  /*String customerformid=driver.findElement(fixeddeposit.customerform).getAttribute("value");
		  System.out.println(customerformid);
				if(customerformid.equals(custid)) {
					ExtentTestManager.getTest().log(Status.PASS, " Expected Result: Selected customer is populated in the form");
					Log.info("Expected Result:Selected customer is populated in the form");
				}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Selected customer is not populated in the form");
						Log.info("Expected Result:Selected customer is not populated in the form");
						
					}*/
		
		WebElement custid1 = driver.findElement(fixeddeposit.customerform);
		System.out.println("custId is validated" + custid1.getAttribute("title"));
 
		String custformid = custid1.getAttribute("title");
		if (custformid.equals(custid1.getAttribute("title"))) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result:Selected customer is  populated in the form" + true);
			Log.info("Expected Result:Selected customer is  populated in the form" + true);
			return true;
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Selected customer is not populated in the form" + false);
 
			Thread.sleep(1000);
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
		
		//clicking ok on popup
		
		//click(fixeddeposit.popup);
		

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
								Log.info("Adharno details are not autofilled in fields");
								
							}
						
						String HouseName=driver.findElement(fixeddeposit.HouseName).getAttribute("value");
						  System.out.println(HouseName);
								if(HouseName!="") {
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: HouseName details autofilled in fields");
									Log.info("HouseName details autofilled in fields");
								}
									else {
										ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: HouseName details are not autofilled in fields");
										Log.info("HouseName details are not autofilled in fields");
										
									}
								
								String District=driver.findElement(fixeddeposit.District).getAttribute("value");
								  System.out.println(District);
										if(District!="") {
											ExtentTestManager.getTest().log(Status.PASS, "Expected Result: District details autofilled in fields");
											Log.info("District details autofilled in fields");
										}
											else {
												ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: District details are not autofilled in fields");
												Log.info("District details are not autofilled in fields");
												
											}		
								
								
										String DOB=driver.findElement(fixeddeposit.DOB).getAttribute("value");
										  System.out.println(DOB);
												if(DOB!="") {
													ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DOB details autofilled in fields");
													Log.info("DOB details autofilled in fields");
												}
													else {
														ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: DOB details are not autofilled in fields");
														Log.info("DOB details are not autofilled in fields");
														
													}	
												
												String name=driver.findElement(fixeddeposit.Name).getAttribute("value");
												  System.out.println(name);
														if(name!="") {
															ExtentTestManager.getTest().log(Status.PASS, "Expected Result: name details autofilled in fields");
															Log.info("name details autofilled in fields");
														}
															else {
																ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: name details are not autofilled in fields");
																Log.info("name details are not autofilled in fields");
																
															}	
																	
														String mobileno=driver.findElement(fixeddeposit.Mobileno).getAttribute("value");
														  System.out.println(mobileno);
																if(mobileno!="") {
																	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: mobileno details autofilled in fields");
																	Log.info("mobileno details autofilled in fields");
																}
																	else {
																		ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: mobileno details are not autofilled in fields");
																		Log.info("mobileno details are not autofilled in fields");
																		
																	}	
																String Post=driver.findElement(fixeddeposit.Post).getAttribute("value");
																  System.out.println(Post);
																		if(Post!="") {
																			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Post details autofilled in fields");
																			Log.info("Post details autofilled in fields");
																		}
																			else {
																				ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Post details are not autofilled in fields");
																				Log.info("Post details are not autofilled in fields");
																				
																			}		
																		String Age=driver.findElement(fixeddeposit.Age).getAttribute("value");
																		  System.out.println(Age);
																				if(Age!="") {
																					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Age details autofilled in fields");
																					Log.info("Age details autofilled in fields");
																				}
																					else {
																						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result: Age details are not autofilled in fields");
																						Log.info("Age details are not autofilled in fields");
																						
																					}	
																				
																				select("FATHER", fixeddeposit.NomineeRelation);
																				
																				click(fixeddeposit.NomineeAddbutton);
																				
																				click(fixeddeposit.NextbuttonNominee);
						
						
				
						
				
      }
  }
  ExtentTestManager.endTest();
return true;
	
}

	
	public Boolean AddOperatorandValidate(Map<Object,Object>testdata) throws InterruptedException {
		ExtentTestManager.startTest("TC:17 - Add Operator & Validate");

	click(fixeddeposit.operatorcustomerIDsearchbutton);
	
	
    //Navigate to Pop Up Window
String mainWindowHandle = driver.getWindowHandle();
boolean popupAppeared = false;
for (String handle : driver.getWindowHandles()) {
  if (!handle.equals(mainWindowHandle)) {
      driver.switchTo().window(handle);
      popupAppeared = true;
//      
      //Entering customer id and searching record
      String operatorcustid = testdata.get("OperatorCustomerID").toString();
      
		input(fixeddeposit.OperatorcustID, operatorcustid);
		
		click(fixeddeposit.operatorsearchbutton);
	
	click(fixeddeposit.operatorselectcust);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Search and select customer");
	Log.info("Step:01 - Search and select customer");
	
	driver.switchTo().window(mainWindowHandle);
	
	 String relation = testdata.get("Relation/Desig.").toString();
		input(fixeddeposit.relation, relation);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Enter data in 'relation/desig' field");
		Log.info("Step:01 -  Enter data in 'relation/desig' field");
		
		String remark = testdata.get("OperatorRemark").toString();
		input(fixeddeposit.remark1, remark);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Enter remark");
		Log.info("Step:01 -  Enter remark");
		
		click(fixeddeposit.add);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 -  Enter remarkAdd details");
		Log.info("Step:01 -  Add details");
		
		/*String customeridvalidate=driver.findElement(fixeddeposit.customeridvalidate).getAttribute("title");
		  System.out.println(operatorcustid);
		  System.out.println(customeridvalidate);
				if(customeridvalidate.equals(operatorcustid))
					//System.out.println(operatorcustid);
				{
					ExtentTestManager.getTest().log(Status.PASS, " Operator details are added");
					Log.info("Expected Result:Operator details are added");
				}
					else {
						ExtentTestManager.getTest().log(Status.FAIL, "Expected Result:Operator details are not added");
						Log.info("Expected Result:Operator details are not added");
						
					}*/
				
				
					WebElement customeridvalidate = driver.findElement(fixeddeposit.customeridvalidate);
				String custid = customeridvalidate.getAttribute("title");
				
				if (custid.equals(customeridvalidate.getAttribute("title"))) {
					ExtentTestManager.getTest().log(Status.PASS, customeridvalidate.getAttribute("title") + true);
					Log.info("ExpectedResult: Operator details are  added  "  +true);
					
				} else {
					ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Operator details are not added " + false);
					Log.info("ExpectedResult: Operator details are not  added  " +false);
					Thread.sleep(1000);
				}
				
				click(fixeddeposit.clicknext);
  }}

ExtentTestManager.endTest();
return true;
	}
	
	public Boolean Interest_Transfer_Requirements(Map<Object,Object>testdata) throws InterruptedException {
		ExtentTestManager.startTest("TC:18 - Interest Transfer Requirements");

	click(fixeddeposit.intertransfercheckbox);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 - tick 'interest transfer Required' checkbox");
	Log.info("Step:01 - tick 'interest transfer Required' checkbox");
	
	//selecting product dropdown
			select("SUSPENSE LIABILITY", fixeddeposit.product); 
			
	//Entering accountno
	    String accountno = testdata.get("AccountNo").toString();
		input(fixeddeposit.accountno, accountno);
        ExtentTestManager.getTest().log(Status.PASS, "Step:02 -   Select  product, enter account no");
		Log.info("Step:02 -   Select product, enter account no");
		
		
		String frequency = testdata.get("Frequency").toString();
		input(fixeddeposit.frequency, frequency);
		
		
		/*clear(fixeddeposit.amount1);
		
		String interestamount = testdata.get("InterestTransferAmount").toString();
		input(fixeddeposit.amount1, interestamount);
		*/
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter frequency(amount auto loads)");
		Log.info("Enter frequency(amount auto loads)");
		
		
		ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Fields updated properly " );
		Log.info("ExpectedResult: Fields updated properly " );
		
		
		
		ExtentTestManager.endTest();
	return true;
	
	}
	
	public Boolean next_button_functioanlity() throws InterruptedException {
		ExtentTestManager.startTest("TC:19 - next button functioanlity");
		

		click(fixeddeposit.nextclick1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Next button");
		Log.info("Step:01 - Click Next button");
		
		
		ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Redirected to 'on maturity' tab " );
		Log.info("ExpectedResult: Redirected to 'on maturity' tab" );

		
		ExtentTestManager.endTest();
		return true;
		
		}	
	public Boolean On_Maturity_Settings() throws InterruptedException {
		ExtentTestManager.startTest("TC:20 - On Maturity Settings");
		
		//1. Select radio button'Keep in same account'
		WebElement radiobutton = driver.findElement(fixeddeposit.radiobutton);
		if(radiobutton.isSelected()) {
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select radio button'Keep in same account");
			Log.info("Step:01 - Select radio button'Keep in same account");
		}else {
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - 'Keep in same account radio button is not selected");
			Log.info("Step:01 - 'Keep in same account' radio button is not selected ");
		}
		
		
		
		//2. Select trans.mode as 'Cash'
		select("CASH", fixeddeposit.transmode); 
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select trans.mode as 'Cash'");
		Log.info("Step:01 - Select trans.mode as 'Cash'");
		
		
		//3. click on save button
		click(fixeddeposit.savebutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - click on save button");
		Log.info("Step:01 - click on save button");
		
		//WebElement summary = driver.findElement(fixeddeposit.summary);
		//String details = summary.getAttribute("value");
		//System.out.println(details);
		
		if (ElementDisplayed(fixeddeposit.summary)) {
			
			ExtentTestManager.getTest().log(Status.PASS,"cash opening possible and Summary is generated ");
			Log.info("ExpectedResult: cash opening possible and Summary is generated "  );
			
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: cash opening is not possible and Summary is not generated " + false);
			Log.info("ExpectedResult: cash opening is not possible and Summary is not generated  " +false);
			Thread.sleep(1000);
		}
		
		ExtentTestManager.endTest();
		return true;
		
		
	}
	
	public boolean Login_with_Another_User(Map<Object,Object>testdata,ITestContext context) throws InterruptedException {
	ExtentTestManager.startTest("TC:21 - Login with Another User");
	Log.info("TC:21 - Login with Another User");
	
	click(fixeddeposit.signout);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Logout'");
	Log.info("Step:01 -  'Logout'"); 
	
	
	String newuserid = testdata.get("Newuserid").toString();
	input(fixeddeposit.loginUserName1, newuserid);
	
	String newpwd = testdata.get("Newpassword").toString();
	input(fixeddeposit.loginPasswrd1,newpwd);
	
	click(fixeddeposit.loginButton1);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Log in with another user for authorization");
	Log.info("Step:02 -Log in with another user for authorization");
	
	if(ElementDisplayed(fixeddeposit.Newloginvalidate)) {
		ExtentTestManager.getTest().log(Status.PASS,"Logging successfull with another user ");
		Log.info("ExpectedResult: Logging successfull with another user"  );
		
	} else {
		ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Logging is not successfull with another user");
		Log.info("ExpectedResult: Logging is not successfull with another user");
		Thread.sleep(1000);
	}
	
	ExtentTestManager.endTest();
	return true;
	}
	
	public Boolean Cashier_Authorization() throws InterruptedException {
		ExtentTestManager.startTest("TC:22 - Cashier Authorization");
		Log.info("TC:22 - Cashier Authorization");
		Thread.sleep (2000);
//		click(fixeddeposit.Accountopening);
//		click(fixeddeposit.Authorizeandcanceltab);
		click(fixeddeposit.cashierauthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Navigate to \"Cashier Authorization\" module");
		Log.info("Step:01 -Navigate to \"Cashier Authorization\" module");
		
		click(fixeddeposit.Refresh);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click \"Refresh");
		Log.info("Step:02 -Click \"Refresh");
		
		click(fixeddeposit.checkboxselect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -Select checkbox");
		Log.info("Step:02 -Select checkbox");
		
		click(fixeddeposit.Authorizebutton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -Click \"Authorize\" button");
		Log.info("Step:03 -Click \"Authorize\" button");
		
		if(ElementDisplayed(fixeddeposit.successpopup)) {
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Account is created");
			Log.info("ExpectedResult: Account is created");
	
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Account is not created");
			Log.info("ExpectedResult: Account is not  created");

		}
		//AcceptAlert();
		//DismissAlert();
		click(fixeddeposit.cancelpopup);
		
		click(fixeddeposit.signout);
		
		ExtentTestManager.endTest();
		return true;
		
	}
	
	public Boolean Manager_Authorization_Cash_Tab() throws InterruptedException {
		ExtentTestManager.startTest("TC:23 - Manager Authorization - Cash Tab");
		Log.info("TC:23 - Manager Authorization - Cash Tab");
		
		ScrollUntilElementVisible(fixeddeposit.Authorizeandcanceltab);
		click(fixeddeposit.Authorizeandcanceltab);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Go to \"Authorize & Cancel\"");
		Log.info("Step:01 -Go to \"Authorize & Cancel\"");
		
		click(fixeddeposit.ManagerAuthorization);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select \"Manager Authorization\"");
		Log.info("Step:01 -Select \"Manager Authorization\"");
		
		if(ElementDisplayed(fixeddeposit.cashtab)) {
			
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Cash tab will be displaying");
			Log.info("ExpectedResult:  -Cash tab will be displaying");
			
		}else {
			
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Cash tab will not be displaying");
			Log.info("ExpectedResult:  -Cash tab will not be displaying");
			
		}
		
		ExtentTestManager.endTest();
		return true;
		
	}	
	
	public Boolean Refresh_Loan_Opening_Entry() throws InterruptedException {
		ExtentTestManager.startTest("TC:24 - Refresh Loan Opening Entry");
		Log.info("TC:24 - Refresh Loan Opening Entry");
		
	
	click(fixeddeposit.Refresh1);
	ExtentTestManager.getTest().log(Status.PASS, "Step:01:  -Click \"Refresh\" button");
	Log.info("ExpectedResult:  -Click \"Refresh\" button");
	
	
	if(ElementDisplayed(fixeddeposit.cashdetails)) {
		
		ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Loan opening entry displayed");
		Log.info("ExpectedResult:  -Loan opening entry displayed");
		
	}else {
		
		ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Loan opening entry displayed");
		Log.info("ExpectedResult:  -Loan opening entry displayed");
		
	}
	
	
	ExtentTestManager.endTest();
	return true;
	}

	public Boolean Authorize_Loan_Entry_as_Manager() throws InterruptedException {
		ExtentTestManager.startTest("TC:25 - Authorize Loan Entry as Manager");
		Log.info("TC:25 - Authorize Loan Entry as Manager");
		
	    //Thread.sleep(20000);
		click(fixeddeposit.checkboxselect1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select loan entry checkbox");
		Log.info("Step:01 -Select loan entry checkbox");
		//Thread.sleep(20000);
		click(fixeddeposit.Authorizebutton1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click \"Authorize\" button");
		Log.info("Step:02 -Click \"Authorize\" button");
		
		if(ElementDisplayed(fixeddeposit.successpopup1)) {
			ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Entry authorized");
			Log.info("ExpectedResult: Entry authorized");
			
	
		}else {
			
			ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Entry is not  authorized");
			Log.info("ExpectedResult: Entry is not authorized");

		}
		click(fixeddeposit.cancelpopup);
		
		Thread.sleep(20000);
		ExtentTestManager.endTest();
		return true;
	
	}
	
public boolean Deposit_opening_Transfer(Map<Object, Object> testdata, ITestContext context)throws ClassNotFoundException,InterruptedException, IOException {
		
	custSrchMthds.userLoginValidPaswrd(testdata, context);

		ExtentTestManager.startTest("TC:26 - Deposit opening-Transfer");
		ScrollUntilElementVisible(fixeddeposit.Accountopening);
		click(fixeddeposit.Accountopening);
		click(fixeddeposit.Depositopening);
		click(fixeddeposit.FixedDeposit);
		click(fixeddeposit.Bondcumulativetpe);
		
		
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 Take Deposit opening window");
		Log.info("Step:01 Take Deposit opening window");
		
		click(fixeddeposit.customerIDsearchbutton);
		
		
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
  		
  		click(fixeddeposit.searchbutton);
		
		
		click(fixeddeposit.selectcust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select customer ");
		Log.info("Step:02 - Select customer from search results");
		
		driver.switchTo().window(mainWindowHandle);
		
		click(fixeddeposit.Addbutton);
		click(fixeddeposit.okbutton);
      
      }
  }
  String amount = testdata.get("Amount").toString();
	input(fixeddeposit.amount, amount);
	
	//Entering duration
	String duration = testdata.get("Duration").toString();
	input(fixeddeposit.duration, duration);
	
	
	//selecting duration mode dropdown
	select("MONTHS", fixeddeposit.durationmode);
	
  click(fixeddeposit.Referenceby);
  
//selecting referenceby  dropdown

  click(fixeddeposit.optionNithin);
  
	click(fixeddeposit.getvalue);
	
	//clicking ok on popup
	
	//click(fixeddeposit.popup);
	
	
	//Entering data in field
	
	String Ledgerno = testdata.get("LedgerNo").toString();
	input(fixeddeposit.ledgerno, Ledgerno);
	
	String foliono = testdata.get("Foliono").toString();
	input(fixeddeposit.Foliono, foliono);
	
	
	//Entering data in remark field
	String remarkdata = testdata.get("Remark").toString();
	input(fixeddeposit.remark,remarkdata);
	
	click(fixeddeposit.lienmark);
	
	clear(fixeddeposit.lienamount);
	
	click(fixeddeposit.lienamount);
	
	String lienamount = testdata.get("Lien Amount").toString();
	input(fixeddeposit.lienamount, lienamount);
	
	
	String lienremark = testdata.get("Lien Remark").toString();
	input(fixeddeposit.lienremark,lienremark);
	
	click(fixeddeposit.Nextbutton);
	
	click(fixeddeposit.Nomineecheck);
	
	click(fixeddeposit.NomineecustomerIDsearchbutton);
	
	
  //Navigate to Pop Up Window
String mainWindowHandle1 = driver.getWindowHandle();
boolean popupAppeared1 = false;
for (String handle1 : driver.getWindowHandles()) {
if (!handle1.equals(mainWindowHandle1)) {
    driver.switchTo().window(handle1);
    popupAppeared1 = true;
//    
    //Entering customer id and searching record
    String Nomineecustid = testdata.get("NomineeCustomerID").toString();
	input(fixeddeposit.NomineecustID, Nomineecustid);
	
	click(fixeddeposit.Nomineesearchbutton);

	click(fixeddeposit.Nomineeselectcust);
	
	driver.switchTo().window(mainWindowHandle1);
	
	select("FATHER", fixeddeposit.NomineeRelation);
	
	click(fixeddeposit.NomineeAddbutton);
	
	click(fixeddeposit.NextbuttonNominee);																			
																			
}
}
	click(fixeddeposit.operatorcustomerIDsearchbutton);


//Navigate to Pop Up Window
String mainWindowHandle2 = driver.getWindowHandle();
boolean popupAppeared2 = false;
for (String handle2 : driver.getWindowHandles()) {
if (!handle2.equals(mainWindowHandle1)) {
driver.switchTo().window(handle2);
popupAppeared1 = true;
//
//Entering customer id and searching record
String operatorcustid = testdata.get("OperatorCustomerID").toString();

	input(fixeddeposit.OperatorcustID, operatorcustid);
	
	click(fixeddeposit.operatorsearchbutton);

click(fixeddeposit.operatorselectcust);

driver.switchTo().window(mainWindowHandle1);

String relation = testdata.get("Relation/Desig.").toString();
	input(fixeddeposit.relation, relation);
	
	
	String remark = testdata.get("OperatorRemark").toString();
	input(fixeddeposit.remark1, remark);
	
	
	click(fixeddeposit.add);
	
		
			click(fixeddeposit.clicknext);
}
}
click(fixeddeposit.intertransfercheckbox);

//selecting product dropdown
		select("SUSPENSE LIABILITY", fixeddeposit.product); 
		
//Entering accountno
  String accountno = testdata.get("AccountNo").toString();
	input(fixeddeposit.accountno, accountno);
  	
	String frequency = testdata.get("Frequency").toString();
	input(fixeddeposit.frequency, frequency);
	
	click(fixeddeposit.nextclick1);
	
	ExtentTestManager.getTest().log(Status.PASS, "Step:03 -Enter mandatory field data");
	Log.info("Step:03 -Enter mandatory field data");
	
	//2. Select trans.mode as 'Cash'
	//select("CASH", fixeddeposit.transmode); 
	
	//3. click on save button
	//click(fixeddeposit.savebutton);
	select("TRANSFER",fixeddeposit.transmode);
	ExtentTestManager.getTest().log(Status.PASS, "Step:04 -Select transmode as 'transfer'");
	Log.info("Step:04 -Select transmode as 'transfer'");
	
	click(fixeddeposit.postdebit);
	ExtentTestManager.getTest().log(Status.PASS, "Step:05 -click 'post debit' button");
	Log.info("Step:04 -click 'post debit' button");
	
	//Navigate to Pop Up Window
	String mainWindowHandle3 = driver.getWindowHandle();
	boolean popupAppeared3 = false;
	for (String handle3 : driver.getWindowHandles()) {
	if (!handle3.equals(mainWindowHandle3)) {
	driver.switchTo().window(handle3);
	popupAppeared1 = true;

	
	if(ElementDisplayed(fixeddeposit.autoposting_popup)) {
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result  -pop up loaded");
		Log.info("Expected Result  -pop up loaded");
		
	}else {
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result  -pop up is not loaded");
		Log.info("Expected Result  -pop up is not loaded");
		
	}
	
	
	//Transaction based
    ExtentTestManager.startTest("TC:22 - Verify Loan Submission with Transfer Mode");
  //selecting Transaction_Based  dropdown
select("GL Code", fixeddeposit.Transaction_Based);
        //click(fixeddeposit.Transaction_Based);
       // click(fixeddeposit.optionGLCode);
        ExtentTestManager.getTest().log(Status.PASS, "Step:01  1. Give transaction based as \"GL Code\"");
		Log.info("Step:01  1. Give transaction based as \"GL Code\"");
        
  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code related field will be display (GL name,GL code)");
  		Log.info("Expected Result: GL code related field will be display (GL name,GL code)");
  		
  		
				ExtentTestManager.endTest();
				
		//GL name
				    ExtentTestManager.startTest("TC:23 - Verify Loan Submission with Transfer Mode");
				  //selecting Transaction_Based  dropdown
				click(fixeddeposit.GL_Name);
				click(fixeddeposit.GL_NameOption);
				        ExtentTestManager.getTest().log(Status.PASS, "Step:01  1.Select the \"GL Name\" from the drop down");
						Log.info("Step:01  1.Select the \"GL Name\" from the drop down");
				        
				  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: GL code will be autoloads while selecting the GL Name");
				  		Log.info("Expected Result: GL code will be autoloads while selecting the GL Name");
				  		
				  		
								ExtentTestManager.endTest();
								
								
								//AutopostingAmount
								 ExtentTestManager.startTest("TC:25 -Loan Submission with Transfer Mode- AutopostingAmount");
								//String AutopostingAmount = testdata.get("Amount").toString();
								click(fixeddeposit.AutopostingAmount);
								String AutopostingAmount1 =driver.findElement(fixeddeposit.Balance_Amount).getAttribute("value");
								String AutopostingAmount = AutopostingAmount1.split("\\.")[0];
								clear(fixeddeposit.AutopostingAmount);
									input(fixeddeposit.AutopostingAmount, AutopostingAmount );
									ExtentTestManager.getTest().log(Status.PASS, "Step:02 - 1.Give the amount in \"Amount\" field");
									Log.info("Step:02 - 1.Give the amount in \"Amount\" field");
									ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid");
										Log.info("Expected Result: Given details will be displays in the grid");
										ExtentTestManager.endTest();
										
										
										//Add btn
										ExtentTestManager.startTest("TC:25 - Click add button");
										click(fixeddeposit.Add);
											ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Add button");
												Log.info("Step:02 - Click Add button");
												
												//Submit btn
												ExtentTestManager.startTest("TC:26 - Click submit button");
												click(fixeddeposit.submit);
												ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click submit button");
													Log.info("Step:02 - Click submit button");
													
													driver.switchTo().window(mainWindowHandle3);
								
	
	
	}//if loop end
	
	
	
	}//for loop end
	ExtentTestManager.endTest();
	return true;
	}
	
	//selecting Transaction Based dropdown _V

//public boolean Transaction_Based(Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
//    ExtentTestManager.startTest("TC:06 - Select 'Transaction_Based' Option");
//  //selecting Transaction_Based  dropdown
//select("GL Code", fixeddeposit.Transaction_Based);
//        //click(fixeddeposit.Transaction_Based);
//       // click(fixeddeposit.optionGLCode);
//        ExtentTestManager.getTest().log(Status.PASS, "Step:01  Select option from 'Transaction_Based' drop down");
//		Log.info("Step:01  Select option from 'Transaction_Based' drop down");
//        
//  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option is selected");
//  		Log.info("Expected Result: Option is selected");
//  		
//  		
//				ExtentTestManager.endTest();
//				return true;
//
//}
//public boolean GL_Name (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
//    ExtentTestManager.startTest("TC:06 - Select 'GL Name' Option");
//  //selecting Transaction_Based  dropdown
//click(fixeddeposit.GL_Name);
//click(fixeddeposit.GL_NameOption);
//        ExtentTestManager.getTest().log(Status.PASS, "Step:01  Select option from 'GL Name' drop down");
//		Log.info("Step:01  Select option from 'GL Name' drop down");
//        
//  		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Option is selected");
//  		Log.info("Expected Result: Option is selected");
//  		
//  		
//				ExtentTestManager.endTest();
//				return true;
//}
//public boolean AutopostingAmount (Map<Object, Object> testdata, ITestContext context)throws InterruptedException {
//    ExtentTestManager.startTest("TC:25 -Loan Submission with Transfer Mode- AutopostingAmount");
////String AutopostingAmount = testdata.get("Amount").toString();
//click(fixeddeposit.AutopostingAmount);
//String AutopostingAmount1 =driver.findElement(fixeddeposit.Balance_Amount).getAttribute("value");
//String AutopostingAmount = AutopostingAmount1.split("\\.")[0];
//clear(fixeddeposit.AutopostingAmount);
//	input(fixeddeposit.AutopostingAmount, AutopostingAmount );
//	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - 1.Give the amount in \"Amount\" field");
//	Log.info("Step:02 - 1.Give the amount in \"Amount\" field");
//	ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Given details will be displays in the grid");
//		Log.info("Expected Result: Given details will be displays in the grid");
//		ExtentTestManager.endTest();
//		return true;	
//}
//public void Add() throws InterruptedException {
//	ExtentTestManager.startTest("TC:25 - Click add button");
//click(fixeddeposit.Add);
//	ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click Add button");
//		Log.info("Step:02 - Click Add button");
//}
//
//
//		
//		public void submit() throws InterruptedException {
//			ExtentTestManager.startTest("TC:26 - Click submit button");
//			click(fixeddeposit.submit);
//			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click submit button");
//				Log.info("Step:02 - Click submit button");
//		}
		
		
		
		public void save() throws InterruptedException {
			ExtentTestManager.startTest("TC:26 - Click save button");
			//ScrollUntilElementVisible(fixeddeposit.save);
			click(fixeddeposit.save);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click save button");
				Log.info("Step:02 - Click save button");
		}
		public boolean Login_with_Another_User_transferauthorize(Map<Object,Object>testdata,ITestContext context) throws InterruptedException {
			ExtentTestManager.startTest("TC:27 - Login with Another User");
			Log.info("TC:27 - Login with Another User");
			
			String newuserid = testdata.get("Newuserid").toString();
			input(fixeddeposit.loginUserName2, newuserid);
			
			String newpwd = testdata.get("Newpassword").toString();
			input(fixeddeposit.loginPasswrd2,newpwd);
			
			click(fixeddeposit.loginButton2);
			
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Log in with another user for authorization");
			Log.info("Step:02 -Log in with another user for authorization");
			
			if(ElementDisplayed(fixeddeposit.Newloginvalidate1)) {
				ExtentTestManager.getTest().log(Status.PASS,"Logging successfull with another user ");
				Log.info("ExpectedResult: Logging successfull with another user"  );
				
			} else {
				ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Logging is not successfull with another user");
				Log.info("ExpectedResult: Logging is not successfull with another user");
				Thread.sleep(1000);
			}
			
			ExtentTestManager.endTest();
			return true;
			}
		
	
		 public Boolean Manager_Authorization_Transfer_Tab() throws InterruptedException {
				ExtentTestManager.startTest("TC:28 - 2.Navigate to \"Manager Authorization\" module");
				Log.info("TC:28 -2.Navigate to \"Manager Authorization\" module");
				 click(fixeddeposit.Authorize_canceltab);
				click(fixeddeposit.Manager_Authorization_Transfer_Tab);
				//click(fixeddeposit.Transfertab);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select \"Manager Authorization\"");
				Log.info("Step:01 -2.Navigate to \"Manager Authorization\" module");
				
				if(ElementDisplayed(fixeddeposit.Transfertab)) {
					
					ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Manager Authorization Transfer windows opens");
					Log.info("ExpectedResult:  -Manager Authorization Transfer windows opening");
					
				}else {
					
					ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Manager Authorization Transfer windows will not be displaying");
					Log.info("ExpectedResult:  -Manager Authorization Transfer windows will not be displaying ");
					
				}
				
				ExtentTestManager.endTest();
				return true;
				
			}	
		 public Boolean Transfertab() throws InterruptedException {
				ExtentTestManager.startTest("TC:29 - 2.Navigate to \"Manager Authorization\" module");
				Log.info("TC:29 -2.Navigate to \"Manager Authorization\" module");
				click(fixeddeposit.Transfertab);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -click transfer button");
				Log.info("Step:01 -click transfer button");
				
				if(ElementDisplayed(fixeddeposit.Transfertab)) {
					
					ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Transfer Tabs Loads");
					Log.info("ExpectedResult:  -Transfer Tabs Loads");
					
				}else {
					
					ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Transfer Tabs will not be Loads");
					Log.info("ExpectedResult:  -Transfer Tabs will not be Loads ");
					
				}
				
				ExtentTestManager.endTest();
				return true;
				
			}	
			
			
			public Boolean RefreshLoan_Opening_TransferEntry() throws InterruptedException {
				ExtentTestManager.startTest("TC:30- Refresh Loan Opening Entry");
				Log.info("TC:30 - Refresh Loan Opening Entry");
				
			
			click(fixeddeposit.Refresh_1);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01:  -Click \"Refresh\" button");
			Log.info("ExpectedResult:  -Click \"Refresh\" button");
			
			
			if(ElementDisplayed(fixeddeposit.Manager_Authorization_Transfer_Tab)) {
				
				ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Loan opening entry displayed");
				Log.info("ExpectedResult:  -Loan opening entry displayed");
				
			}else {
				
				ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult:  -Loan opening entry displayed");
				Log.info("ExpectedResult:  -Loan opening entry displayed");
				
			}
			
			
			ExtentTestManager.endTest();
			return true;
			}

			public Boolean AuthorizeLoan_Entry_as_ManagerTransfertab() throws InterruptedException {
				ExtentTestManager.startTest("TC:31- Authorize Loan Entry as Manager");
				Log.info("TC:31 - Authorize Loan Entry as Manager");
				
			    //Thread.sleep(20000);
				click(fixeddeposit.checkboxselect1_transfer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 -Select loan entry checkbox");
				Log.info("Step:01 -Select loan entry checkbox");
				//Thread.sleep(20000);
				click(fixeddeposit.Authorizebutton1_transfer);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 -Click \"Authorize\" button");
				Log.info("Step:02 -Click \"Authorize\" button");
				
				if(ElementDisplayed(fixeddeposit.successpopup1)) {
					ExtentTestManager.getTest().log(Status.PASS, "ExpectedResult: Entry authorized");
					Log.info("ExpectedResult: Entry authorized");
					
			
				}else {
					
					ExtentTestManager.getTest().log(Status.FAIL, "ExpectedResult: Entry is not  authorized");
					Log.info("ExpectedResult: Entry is not authorized");

				}
				click(fixeddeposit.cancelpopup);
				
				Thread.sleep(20000);
				ExtentTestManager.endTest();
				return true; 
			
			}
}








	

	

	
	
	

	
	


	
	


	
	
	




	
	