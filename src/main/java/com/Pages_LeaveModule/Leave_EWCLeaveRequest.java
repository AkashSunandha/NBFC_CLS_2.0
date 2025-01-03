package com.Pages_LeaveModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;


public class Leave_EWCLeaveRequest extends Base_Class
{
	PageRepositary_LeaveModule PageRepositary= new PageRepositary_LeaveModule();
	
	
	 public boolean clickOnLeaveModule() throws InterruptedException {
		
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.EWCSection);
	      Thread.sleep(3000);
	        return true;
	    }
	 
	 public boolean clickOnEWCModuleApproval() throws InterruptedException {
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.ApprovalsSection);
	      Thread.sleep(1000);
	      click(PageRepositary.EWCApprovalSection);
	      Thread.sleep(3000);
	      click(PageRepositary.ewcSection);
	      Thread.sleep(3000);
	        return true;
	    }
	 
	 
	 public boolean elementDisplayed() throws InterruptedException {
		 boolean flag0 = ElementDisplayed(PageRepositary.FromDate);
		 boolean flag1 = ElementDisplayed(PageRepositary.ToDate);
		 boolean flag2 = ElementDisplayed(PageRepositary.selectProject);
		 boolean flag3 = ElementDisplayed(PageRepositary.enterReason);
		 boolean flag4 = ElementDisplayed(PageRepositary.notifyOthers);
		 boolean flag5 = ElementDisplayed(PageRepositary.cancelButton);
	     Thread.sleep(1000);
		 boolean flag= flag0 & flag1 & flag2 & flag3 & flag4 & flag5;
	     return flag;
	    }
	 
	public boolean EWCleaveRequest(String EWCType) throws InterruptedException {
			 
			 if(EWCType.equals(" Client Holiday ")) {
				 boolean flag1=ElementDisplayed(PageRepositary.clientHolidayDisplayed);
				 click(PageRepositary.clientHolidayDisplayed);
				 Thread.sleep(2000);
				 
				 ExtentTestManager.getTest().log(Status.PASS, "Client Holiday Section Displayed: " + true);
				Log.info("Client Holidaye Section Displayed : " + true);
				return flag1; 
			 }
			 else if(EWCType.equals(" Comp off Credit ")){
				 Thread.sleep(1000);
				 boolean flag2=ElementDisplayed(PageRepositary.compOffDisplayed);
				 click(PageRepositary.compOffDisplayed);
				 Thread.sleep(3000);
				 return flag2;
			 }
			 else if(EWCType.equals("Work from Home")){
				 Thread.sleep(1000);
				 boolean flag3=ElementDisplayed(PageRepositary.wfhDisplayed);
				 click(PageRepositary.wfhDisplayed);
				 Thread.sleep(1000);
				 return flag3;
			 }
			 
			return true;
	}
	
	
	
	public boolean EWCleaveRequestForm(String fromYear, String fromMonth, String fromDate, String toYear, String toMonth, String toDate,
			String project, String Reason, String Employee) throws InterruptedException {
		
		Thread.sleep(1000);
		click(PageRepositary.FromDate);
		Thread.sleep(1000);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(1000);
		click(By.xpath("//div[contains(text(),'"+fromYear+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+fromMonth+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+fromDate+"')]"));
		 Thread.sleep(2000);
		 click(PageRepositary.ToDate);
		Thread.sleep(1000);
		click(PageRepositary.selectMonthandYear);
		Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+toYear+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+toMonth+"')]"));
		 Thread.sleep(1000);
		 click(By.xpath("//div[contains(text(),'"+toDate+"')]"));
		 Thread.sleep(1000);
		 click(PageRepositary.selectProject);
	    Thread.sleep(2000);
	    click(By.xpath("//option[contains(text(),'"+project+"')]"));
	    Thread.sleep(1000);
		input(PageRepositary.enterReason, Reason);
		Thread.sleep(1000);
		click(PageRepositary.notifyOthers);
		Thread.sleep(1000);
		input(PageRepositary.searchEmp, Employee);
		Thread.sleep(1000);
		click(PageRepositary.selectEmp);
		//click(PageRepositary.notifyOthers);
		Thread.sleep(1000);
		
		return true;
		
	
	}
	
	 public boolean clickOnCancelButton() throws InterruptedException {
		 click(PageRepositary.cancelButton);
		 Thread.sleep(4000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Cancelled");
		Log.info("EWC Leave Request Cancelled!");
	        return true;
	    }
	 
	 public boolean clickOnSubmitButton() throws InterruptedException {
		 click(PageRepositary.submitButton);
		 Thread.sleep(2000);
		 click(PageRepositary.okButton);
		 Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Submitted!");
		Log.info("EWC Leave Request Submitted!");
	        return true;
	    }
	
	 
	 
	 public boolean ApprovalButtonFieldsDisplayed(String LeaveRequester) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+LeaveRequester+"')]"));
		 Thread.sleep(2000);
		 boolean flag0 = ElementDisplayed(PageRepositary.sendForReview1);
		 boolean flag1 = ElementDisplayed(PageRepositary.prjectAllocation1);
		 boolean flag2 = ElementDisplayed(PageRepositary.approvebutton);
		 boolean flag3 = ElementDisplayed(PageRepositary.rejectbutton);
	     Thread.sleep(1000);
		 boolean flag= flag0 & flag1 & flag2 & flag3;
	     return flag;
	    }
	 
	 public boolean sendForReviewFunctionality(String LeaveRequester, String Employee1) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+LeaveRequester+"')]"));
		 Thread.sleep(2000);
		 click(PageRepositary.sendForReview1);
		 Thread.sleep(2000);
		 click(PageRepositary.overlay);
		 click(PageRepositary.approverSelection);
		 Thread.sleep(2000);
		 select(Employee1, PageRepositary.approverSelection);
		 click(PageRepositary.overlay);
		 click(PageRepositary.sendForReview1);

		Thread.sleep(2000);
		 click(PageRepositary.overlay);
		 Thread.sleep(1000);
		click(PageRepositary.sendForReview2); 
		Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Rerouted Successfully");
		 Log.info("EWC Leave Request Rerouted Successfully!");
	     return true;
	    }
	 
	 
	 public boolean RejectFunctionality(String LeaveRequester, String RejectCommnents) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+LeaveRequester+"')]"));
		 Thread.sleep(2000);
		 click(PageRepositary.rejectbutton);
		 Thread.sleep(2000);
		 input(PageRepositary.enterRejectComments, RejectCommnents);
		 Thread.sleep(1000);
		 click(PageRepositary.sendButton1);
		 Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Rejected Successfully");
		 Log.info("EWC Leave Request Rejected Successfully!");
		 return true;
	    }
	 
	 public boolean ApproveFunctionality(String LeaveRequester) throws InterruptedException {
		 click(By.xpath("//span[contains(text(),'"+LeaveRequester+"')]"));
		 Thread.sleep(2000);
		 click(PageRepositary.approvebutton);
		 Thread.sleep(2000);
		 Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.PASS, "EWC Leave Request Approved Successfully");
		 Log.info("EWC Leave Request Approved Successfully!");
		 return true;
	    }
	 
	 
	
	
	 	 
}
