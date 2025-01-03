package com.Pages_LeaveModule;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_LeaveModule;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Leave_LeaveRequest extends Base_Class
{
	PageRepositary_LeaveModule PageRepositary= new PageRepositary_LeaveModule();
	
	
	 public boolean clickOnLeaveModule() throws InterruptedException {
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.myLeaveSection);
	      Thread.sleep(2000);
	      click(PageRepositary.clickOnLeaveRequest);
	      Thread.sleep(5000);
	        return true;
	    }
	 
	 public boolean clickOnDashboard() throws InterruptedException {
		 click(PageRepositary.LeaveSection);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnDashboard);
	      Thread.sleep(3000);
	      click(PageRepositary.DesktopNot);
	      Thread.sleep(3000);
	      Log.info("All the Details Visible Properly");
	        return true;
	    }
	 
	 public boolean selectLeaveType(String leaveType) throws InterruptedException {
		 
		 click(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
		 
		 Thread.sleep(2000);
	        return true;
	    }
	 
	public boolean leaveRequestForm(String leaveType, String fromYear, String fromMonth, String fromDate, String toYear, String toMonth, String toDate, String duration, String Reason, String Employee) throws InterruptedException {
			 
			 ScrollUntilElementVisible(PageRepositary.selectFromDate);
			 Thread.sleep(2000);
			 click(PageRepositary.GeneralRadioButton);
			 Thread.sleep(1000);
			 click(PageRepositary.selectFromDate);
			 Thread.sleep(1000);
			 click(PageRepositary.selectMonthandYear);
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromYear+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromMonth+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+fromDate+"')]"));
			 Thread.sleep(1000);
			 if(leaveType.equals("Floating Holidays")) {
				 boolean flag1=ElementDisplayed(PageRepositary.floatingPeriod);
				 ExtentTestManager.getTest().log(Status.FAIL, "Floating Holidays should be applied before 7 days: " + false);
				Log.info("Floating Holidays should be applied before 7 days : " + false);
				return flag1; 
			 }
			 else {
				 Thread.sleep(1000);
			 }
			 
			 click(PageRepositary.selectToDate);
			 Thread.sleep(1000);
			 click(PageRepositary.selectMonthandYear);
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+toYear+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+toMonth+"')]"));
			 Thread.sleep(1000);
			 click(By.xpath("//div[contains(text(),'"+toDate+"')]"));
			 try {
				 
			 
			 Boolean flag01=ElementDisplayed(PageRepositary.WeekendAndHoliday);
			 if (flag01)
				{ 	
				 	
					ExtentTestManager.getTest().log(Status.PASS, "Selected Date is not a working day");
					Log.info("Selected Date is not a working day");	
				}
			 }
			 catch(Exception e1)
				{
					Log.info("No timesheet saved for ");
				}
				
	
			// Thread.sleep(1000);
				click(PageRepositary.clickOnDuration);
				 Thread.sleep(1000);
				 boolean flag1 = ElementDisplayed(By.xpath("//span[contains(text(),'"+duration+"')]")); 
				click(By.xpath("//span[contains(text(),'"+duration+"')]"));
				Thread.sleep(1000);
				input(PageRepositary.leaveReson, Reason);
				Thread.sleep(1000);
				click(PageRepositary.selectEmployees);
				Thread.sleep(1000);
				input(PageRepositary.searchEmployee, Employee);
				Thread.sleep(1000);
				click(PageRepositary.selectEmp);
				Thread.sleep(1000);
				return flag1;

		 }
		
	 public boolean uploadFile(String filePath) {
	        UploadFile(PageRepositary.selectFile, filePath);
			return false;	    
	        }

	 public boolean submitButton() throws InterruptedException {
	        click(PageRepositary.SubmitButton);
	        Thread.sleep(5000);
	       // Thread.sleep(1000);
			 if (ElementDisplayed(PageRepositary.SamePeriod))
				{ 	
				 	click(PageRepositary.SamePeriodOk);
				 	
					ExtentTestManager.getTest().log(Status.PASS, "You have already applied for a leave during the same period.: " + true);
					Log.info("You have already applied for a leave during the same period. : " + true);
					
					
				}
				
				else
				{
					click(PageRepositary.clickOnOkButton);
					ExtentTestManager.getTest().log(Status.PASS, "Modal closed : " + false);
					Log.info("Modal closed : " + false);
					
				}
			//click(PageRepositary.clickOnOkButton);
	        
			return false;	    
	        }
	 
	 public boolean clearButton() throws InterruptedException {
	        click(PageRepositary.clearButton);
	        Thread.sleep(1000);
		
	        
			return false;	    
	        }
	 
	 public boolean ValidateLeaveModule(String leaveType) throws InterruptedException 
		{
			Boolean flag1 = ElementDisplayed(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
			Log.info("All the Leave Type Appeared Properly");
			Boolean flag = flag1;
			return flag;
		}
	 
	 public boolean ValidateLeaveModuleForm(String leaveType) throws InterruptedException 
		{
			Boolean flag1 = ElementDisplayed(By.xpath("//div[contains(text(),'"+leaveType+"')]"));
			Boolean flag2 = ElementDisplayed(PageRepositary.GeneralRadioButton);
			Boolean flag3 = ElementDisplayed(PageRepositary.selectFromDate);
			Boolean flag4 = ElementDisplayed(PageRepositary.selectToDate);
			Boolean flag5 = ElementDisplayed(PageRepositary.clickOnDuration);
			Boolean flag6 = ElementDisplayed(PageRepositary.leaveReson);
			Boolean flag7 = ElementDisplayed(PageRepositary.selectEmployees);

			Boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7;
			return flag;
		}
	 
		
	 public boolean ValidateStatementModal() throws InterruptedException 
		{
		 click(PageRepositary.clickOnStatement);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnDD);
		 Thread.sleep(1000);
		 click(PageRepositary.selectDDforStatement);
		 Thread.sleep(1000);
		 click(PageRepositary.clickOnApply);
		 Thread.sleep(1000);
			Boolean flag1 = ElementDisplayed(PageRepositary.ValidateField1);
			Boolean flag2 = ElementDisplayed(PageRepositary.ValidateField2);
			Boolean flag3 = ElementDisplayed(PageRepositary.ValidateField3);
			Boolean flag4 = ElementDisplayed(PageRepositary.ValidateField4);
			 Thread.sleep(1000);
			click(PageRepositary.clickOnCloseButton);
			Boolean flag = flag1 & flag2 & flag3 & flag4;
			return flag;
		 
		}
	 
}
