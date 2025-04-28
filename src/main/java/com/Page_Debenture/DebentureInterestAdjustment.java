package com.Page_Debenture;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Page_Repositary.PageRepository_DebentureInterestAdjustment;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;



//TC001

public class DebentureInterestAdjustment extends Base_Class {	
	
	public String actualUserName;



String mainWindowHandle;

PageRepository_DebentureInterestAdjustment DIA  = new PageRepository_DebentureInterestAdjustment();
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
public boolean AccessDebentureInterestAdjustment() throws InterruptedException {
	Thread.sleep(5000);
	ScrollUntilElementVisible(DIA.Transaction);
	Thread.sleep(1000);
	click(DIA.Debenture);
	Thread.sleep(1000);
	click(DIA.DebentureInterestAdjustment);
	Thread.sleep(1000);
	return false;
	
}



//TC004
public boolean SelectDebentureType() throws InterruptedException {
	click(DIA.DropdownofDebenureType);
	Thread.sleep(1000);
	click(DIA.DebentureType);
	Thread.sleep(1000);
	
	return false;
	

	
}



//TC005
public boolean SelectDebentureIssue() throws InterruptedException {
	click(DIA.DropdownofDebentureIssue);
	Thread.sleep(1000);
	click(DIA.DebentureIssue);
	Thread.sleep(1000);
	
	return false;
	

	
}



//TC006
public boolean SelectDebentureSeries() throws InterruptedException {
	click(DIA.DropdownofDebentureSeries);
	Thread.sleep(1000);
	click(DIA.DebentureSeries);
	Thread.sleep(1000);
	
	return false;
	
	

	
}



//TC007
public boolean Search() throws InterruptedException {
	click(DIA.search);
	Thread.sleep(1000);
	return false;
	
}


//TC008
public boolean validateAccountNo() throws InterruptedException {
    WebElement AutoloadedAccountNo = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[2]"));
    System.out.println("Autoloaded Account No" + AutoloadedAccountNo.getAttribute("title"));

    String ABC = AutoloadedAccountNo.getAttribute("title");
    if (ABC.equals(AutoloadedAccountNo.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedAccountNo.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}



public boolean validateName() throws InterruptedException {
    WebElement AutoloadedNameField = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[3]"));
    System.out.println("Autoloaded Name field" + AutoloadedNameField.getAttribute("title"));

    String ABC = AutoloadedNameField.getAttribute("title");
    if (ABC.equals(AutoloadedNameField.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedNameField.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}



public boolean validateToAccountNoField() throws InterruptedException {
    WebElement AutoloadedAccountNoField = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[4]"));
    System.out.println("Autoloaded To Account No field" + AutoloadedAccountNoField.getAttribute("title"));

    String ABC = AutoloadedAccountNoField.getAttribute("title");
    if (ABC.equals(AutoloadedAccountNoField.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedAccountNoField.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}



public boolean validateToBank() throws InterruptedException {
    WebElement AutoloadedToBank = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[5]"));
    System.out.println("Autoloaded To Bank field" + AutoloadedToBank.getAttribute("title"));

    String ABC = AutoloadedToBank.getAttribute("title");
    if (ABC.equals(AutoloadedToBank.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedToBank.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}


public boolean validateNameField() throws InterruptedException {
    WebElement AutoloadedName = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[6]"));
    System.out.println("Autoloaded Name field" + AutoloadedName.getAttribute("title"));

    String ABC = AutoloadedName.getAttribute("title");
    if (ABC.equals(AutoloadedName.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedName.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}


public boolean validateAmount() throws InterruptedException {
    WebElement AutoloadedAmount = driver.findElement(By.xpath("//table[@class='tablescroll_head']//tr//td[7]"));
    System.out.println("Autoloaded Amount field" + AutoloadedAmount.getAttribute("title"));

    String ABC = AutoloadedAmount.getAttribute("title");
    if (ABC.equals(AutoloadedAmount.getAttribute("title"))) {
          ExtentTestManager.getTest().log(Status.PASS, AutoloadedAmount.getAttribute("title") + true);
          Log.info(ABC + true);
          return true;
    } else {
          ExtentTestManager.getTest().log(Status.FAIL, "rfe43rsd4: " + false);

          Thread.sleep(1000);
    }

    return true;

}

//TC009
public boolean Process() throws InterruptedException {
	click(DIA.Process);
	Thread.sleep(1000);
	return false;
	
}


//TC010
public boolean Close() throws InterruptedException {
	click(DIA.close);
	Thread.sleep(1000);
	return false;
	
}

















	

}

