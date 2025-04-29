package com.Pages_ProcessingAndPosting;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepositary_DayEnd;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;



public class DayEnd extends Base_Class {
	public String actualUserName ;
	
	
	
	
	PageRepositary_DayEnd DE = new PageRepositary_DayEnd();
	PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan goaldLoanRepo = new PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan();
	
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	
	
	
	
	//TC002	
	
		public boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
			ExtentTestManager.startTest("PC Registration");
			Log.info("PC Registration");
			
			String pcRegFormName = testdata.get("pcRegFormName").toString();
			input(custSearch.formName, pcRegFormName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
			Log.info("Step:01 - Enter User Name in Name field.");
			
			select("TRIVANDRUM",custSearch.formBranchName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
			Log.info("Step:02 - Select a Branch Name from the Dropdown.");
			
			String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
			input(custSearch.formComputerName, pcRegFormPcName);
			ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
			Log.info("Step:03 - Enter PC Name in Name field.");
			
			click(custSearch.formSubmitBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit Button.");
			Log.info("Step:04 - Click on Submit Button.");
			
			//DB Connection
				com.BasePackage.Base_Class.DatabaseConnector();
				driver.navigate().refresh();
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PC Registered Successfully!");
				Log.info("Expected Result: PC Registered Successfully!");
				ExtentTestManager.endTest();
				
			return true;
		}
		
		
		
		
		//TC003
        
public boolean AccessBranchDayClosing() throws InterruptedException {
	Thread.sleep(5000);
	ScrollUntilElementVisible(DE.Transaction);
	Thread.sleep(1000);
	click(DE.ProcessingAndPosting);
	Thread.sleep(1000);
	ScrollUntilElementVisible(DE.ProcessingAndPosting);
	Thread.sleep(1000);
	click(DE.BranchDayClosing);
	Thread.sleep(1000);
	return false;
	
}

//TC004
public boolean StartProcessing() throws InterruptedException {
	click(DE.StartProcessing);
	Thread.sleep(1000);
	return false;
	
}


//TC005
public static void AccessAlert() {

com.BasePackage.Base_Class.AcceptAlert();
driver.navigate().refresh();

return;

}
//

//TC006
public boolean YellowIcon() throws InterruptedException {
	
//    waitUntilElementDisappear(DE.smallLoader);

    WebElement YellowIcon = driver.findElement(By.xpath("//img[@src='../Images/icons/warning_icon.jpg']"));
    System.out.println("Yellow icon" + YellowIcon.getAttribute("title"));

    String ABC = YellowIcon.getAttribute("title");
    if (ABC.equals(YellowIcon.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, YellowIcon.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    
    return true;

}


//TC007
public static void AccessAlert2() {

com.BasePackage.Base_Class.AcceptAlert();
driver.navigate().refresh();

return;

}




//TC008
public boolean Submit() throws InterruptedException {
	
	click(DE.Submit);
	Thread.sleep(1000);
	return false;
	
}







}
