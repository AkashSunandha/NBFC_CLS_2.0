package com.Page_Debenture;



		import java.awt.datatransfer.UnsupportedFlavorException;
		import java.io.IOException;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
import java.time.Duration;
import java.util.Map;
		import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import org.testng.ITestContext;

		import com.BasePackage.Base_Class;
		import com.Page_Repositary.PageRepositary_AccOpn_LoanOpn_JewelLoan_GoldLoan;
		import com.Page_Repositary.PageRepositary_Cust_CustSearch;
		import com.Page_Repositary.PageRepositary_Cust_QuickCustomer;
		//import com.Page_Repositary.PageRepositary_Debenture_DebentureAllotment;
import com.Page_Repositary.PageRepositary_Debenture_DebentureInterestPaymentCash;
import com.Page_Repositary.PageRepositary_GroupLoans_CentreGroupRegistration;
		import com.Utility.Log;
		import com.aventstack.extentreports.Status;
		import com.extentReports.ExtentTestManager;

		public class Debenture_DebentureInterestPaymentTransferCash extends Base_Class {
			String mainWindowHandle ;
			private static By formName;
			private static By formBranchName;
			private static By formComputerName;
			private static By formSubmitBtn;
			private static By loginUserName;
			private static By loginPasswrd;
			private static By loginButton;
			private static By invalidPaswrdErrMsg;
			private static By home;
			private static By loginWarningOkBtn;
			private static By loginUserName2;
			private static By loginPasswrd2;
			//public String TransactionId;
			com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("DebtIntpaymentcash");
			Base_Class Base_Class= new Base_Class();
			Log log= new Log();
			
			//PageRepositary_Debenture_DebentureAllotment DebtAllot = new PageRepositary_Debenture_DebentureAllotment();
			
			PageRepositary_Debenture_DebentureInterestPaymentCash IntCash = new PageRepositary_Debenture_DebentureInterestPaymentCash();
			
			PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();
			public Object debentureMthds;
			private Map<Object, Object> testdata;	
			

			public String sp = "Exec GetDebAcNo 102,90068";
			public String clmnNam = "AcNO";
			
			
			public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
				 // Method that returns the first customer ID (String) from the database
			        // Database connection details
		       // Database connection details
		       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String UserName = "sqa";
				String Password = "SPQA@sql2019" ;
				String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

				
			        String value = null; // Declare and initialize the return variable

			        // Establish the connection to the database
			        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
			             Statement statement = connection.createStatement();
			             ResultSet resultSet = statement.executeQuery(query)) {
			        	
			        	if (resultSet.next()) {
			        		value = resultSet.getString(columnName); // DB column name
			                System.out.println("Generated Unique ID: " + value);
			            } else {
			                System.out.println("Unique ID not generated.");
			            }

			        } catch (SQLException e) {
			            System.out.println("Error executing the SQL query or processing the result set.");
			            e.printStackTrace();
			        }

			        return value; // Return the firstCustId
			    }

			public static boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
				ExtentTestManager.startTest("PC Registration");
				Log.info("PC Registration");
				
				String pcRegFormName = testdata.get("pcRegFormName").toString();
				input(Debenture_DebentureInterestPaymentTransferCash.formName, pcRegFormName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
				Log.info("Step:01 - Enter User Name in Name field.");
				
				select("TRIVANDRUM",Debenture_DebentureInterestPaymentTransferCash.formBranchName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a Branch Name from the Dropdown.");
				Log.info("Step:02 - Select a Branch Name from the Dropdown.");
				
				String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
				input(Debenture_DebentureInterestPaymentTransferCash.formComputerName, pcRegFormPcName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter PC Name in Name field.");
				Log.info("Step:03 - Enter PC Name in Name field.");
				
				click(Debenture_DebentureInterestPaymentTransferCash.formSubmitBtn);
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
			
				
		


			public boolean userLoginInValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
				ExtentTestManager.startTest("Login with Invalid Credentials");
				Log.info("Login with Invalid Credentials");
				
				String loginInValidUsername = testdata.get("loginInValidUsername").toString();
				input(Debenture_DebentureInterestPaymentTransferCash.loginUserName, loginInValidUsername);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
				Log.info("Step:01 - Enetered Valid User Name");
				
				String loginInValidPassword = testdata.get("loginInValidPassword").toString();
				input(Debenture_DebentureInterestPaymentTransferCash.loginPasswrd, loginInValidPassword);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
				Log.info("Step:02 - Enetered Invalid Password");
				
				click(Debenture_DebentureInterestPaymentTransferCash.loginButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
				Log.info("Step:03 - Click on Login Button");
				
				
				if(ElementDisplayed(Debenture_DebentureInterestPaymentTransferCash.invalidPaswrdErrMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed for invalid credentials.");
					Log.info("Expect Result: Error message displayed for invalid credentials.");
				}
				clear(Debenture_DebentureInterestPaymentTransferCash.loginUserName);
				ExtentTestManager.endTest();
				
				
				
				ExtentTestManager.startTest("Invalid Login - Incorrect Password");
				Log.info("Invalid Login - Incorrect Password");
				
				String loginUserName = testdata.get("loginUserName").toString();
				input(Debenture_DebentureInterestPaymentTransferCash.loginUserName, loginUserName);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
				Log.info("Step:01 - Enetered Valid User Name");
				
				input(Debenture_DebentureInterestPaymentTransferCash.loginPasswrd, loginInValidPassword);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
				Log.info("Step:02 - Enetered Invalid Password");
				
				click(Debenture_DebentureInterestPaymentTransferCash.loginButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
				Log.info("Step:03 - Click on Login Button");
				
				
				if(ElementDisplayed(Debenture_DebentureInterestPaymentTransferCash.invalidPaswrdErrMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed indicating incorrect password.");
					Log.info("Expect Result: Error message displayed indicating incorrect password.");
				}
				clear(Debenture_DebentureInterestPaymentTransferCash.loginUserName);
				ExtentTestManager.endTest();
				
				return true;
			}
			
			public static void userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
				ExtentTestManager.startTest("Valid Login");
				Log.info("Valid Login");
					
					
							String UserName = configloader().getProperty("UserName");
							input(Debenture_DebentureInterestPaymentTransferCash.loginUserName,UserName );
							ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
							Log.info("Step:01 - Enetered valid User Name");
							
							String Password = configloader().getProperty("Password");
//							String loginValidPassword = testdata.get("loginValidPassword").toString();
							input(Debenture_DebentureInterestPaymentTransferCash.loginPasswrd, Password);
							ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
							Log.info("Step:02 - Enetered valid Password");
							
							click(Debenture_DebentureInterestPaymentTransferCash.loginButton);
							ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
							Log.info("Step:03 - Click on Login Button");
							
							try {
							ElementDisplayed(Debenture_DebentureInterestPaymentTransferCash.home);
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
							Log.info("Expected Result: User is logged in successfully and dashboard visible");
							}
							catch(Exception e) {
								ElementDisplayed(Debenture_DebentureInterestPaymentTransferCash.loginWarningOkBtn);
								ExtentTestManager.getTest().log(Status.PASS, "Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");
								Log.info("Error Message displayed: Already Logged in another system/browser.. Do you want to log out?");

								click(Debenture_DebentureInterestPaymentTransferCash.loginWarningOkBtn);
								ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on OK button");
								Log.info("Step:01 - Click on OK button");
								
			//					String loginUserName = testdata.get("loginUserName").toString();
								input(Debenture_DebentureInterestPaymentTransferCash.loginUserName, UserName);
								ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter valid User Name");
								Log.info("Step:02 - Enetered valid User Name");
								
			//					String loginValidPassword = testdata.get("loginValidPassword").toString();
								input(Debenture_DebentureInterestPaymentTransferCash.loginPasswrd, Password);
								ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter valid Password");
								Log.info("Step:03 - Entered valid Password");
								
								click(Debenture_DebentureInterestPaymentTransferCash.loginButton);
								ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Login Button");
								Log.info("Step:04 - Click on Login Button");
								
											ElementDisplayed(Debenture_DebentureInterestPaymentTransferCash.home);
											ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
											Log.info("Expected Result: User is logged in successfully and dashboard visible");	
			
							
							}}

			// Navigate to Debenture
			
			public void navigateToDebenture()throws InterruptedException {
				// TODO Auto-generated method stub
				
			
				ExtentTestManager.startTest("navigateToDebenture");
				Log.info("navigateToDebenture");
				
				click(IntCash.debenturetab);
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Debenture module in the left menu bar.");
				Log.info("Step:01 - Expand the Debenture module in the left menu bar.");
				
				click(IntCash.DebentureInterestPaymenttab);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on DebentureInterestPayment.");
				Log.info("Step:02 - Click on DebentureInterestPayment.");
				
				
				if(ElementDisplayed(IntCash.DebentureWindowTitle)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: DebentureInterestPayment Title is displayed.");
					Log.info("Expected Result: DebentureInterestPayment title is displayed.");
				}
				
				ExtentTestManager.endTest();
				
			}

			// Branch drop down
			
		/*	public void branchdropdown()throws InterruptedException {
				// TODO Auto-generated method stub
				
			
			
				//Select Branch from Drop down
				
				ExtentTestManager.startTest("Select Branch from Drop down");
				Log.info("Select Branch from Drop down");
				
				select("TRIVANDRUM",IntCash.grBranchDropdown);
				
				ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on branch dropdown.\r\n"
						+ "2. Select 'Trivandrum'.\"");
				Log.info("\"1. Click on branch dropdown.\r\n"
						+ "2. Select 'Trivandrum'.\"");
				
			
		}*/

			// Dropdown for Debenture Type
			
			public void debenturetypedropdown()throws InterruptedException {
				// TODO Auto-generated method stub
			
				
				
				ExtentTestManager.startTest("Select debenturetype from Drop down");
				Log.info("Select debenturetype from Drop down");
				
				click(IntCash.debtdropdown);
				
				click(IntCash.debenturetypeDropdown);
				
				
				ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on debenturetypedropdown.\r\n"
						+ "2. Select 'DEB CASH'.\"");
				
				Log.info("\"1. Click on debenturetypedropdown.\r\n"
						+ "2. Select 'DEB CASH'.\"");
				
				
				

				
			}

			// Dropdown for issue Type
			
			public void issuetypedropdown() throws InterruptedException{
				// TODO Auto-generated method stub
			
				
				ExtentTestManager.startTest("Select issuetype from Drop down");
				Log.info("Select issuetype from Drop down");
				
				click(IntCash.issuetypedropdown);
				
				click(IntCash.issuetypeitemDropdown);
				
				
				ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on issuetypedropdown.\r\n"
						+ "2. Select 'ISSUE-DEB CASH-66'.\"");
				
				Log.info("\"1. Click on issuetypedropdown.\r\n"
						+ "2. Select 'ISSUE-DEB CASH-66'.\"");
				
				
				
			}

			// Dropdown for series Type
			
			public void seriesdropdown()throws InterruptedException {
				// TODO Auto-generated method stub

	
				ExtentTestManager.startTest("Select seriestype from Drop down");
				Log.info("Select seriestype from Drop down");
				
				click(IntCash.seriesdropdown);
				
				click(IntCash.seriestypeDropdown);
				
				
				ExtentTestManager.getTest().log(Status.PASS, "\"1. Click on seriestypedropdown.\r\n"
						+ "2. Select 'SERIES-ISSUE-DEB CASH-66-SERIES-2063'.\"");
				
				Log.info("\"1. Click on seriestypedropdown.\r\n"
						+ "2. Select 'SERIES-ISSUE-DEB CASH-66-SERIES-2063'.\"");
				
				
				

				
			}

			
			// account number field entry
			
			public boolean  accnumber(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
				// TODO Auto-generated method stub
			
				ExtentTestManager.startTest("Enter account number");
				Log.info("Enter account number");
				
				String bankDetailsAccNum = generateUniqueId(sp,clmnNam);
				String lastthreedigit=bankDetailsAccNum.substring(bankDetailsAccNum.length() - 3);
				System.out.println("lastthreedigit: " + lastthreedigit);
				
				input(IntCash.bankDetailsAccNumTxtBox, lastthreedigit);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Bank Account number in BankAccNo field.");
				Log.info("Step:01 - Enter Bank Account number in BankAccNo field.");
				
				click(IntCash.GoButton);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click the 'Go' button.");
				Log.info("Step:01 - Click the 'Go' button.");
				
				ExtentTestManager.endTest();
				return true;
			
					
				
				
			}


            //Duration field entry
			
			
			public boolean  durationclass (Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
				// TODO Auto-generated method stub
				
				ExtentTestManager.startTest("Enter Duration");
				Log.info("Enter Duration");
				
				String Durationvalue = testdata.get("Duration1").toString();
				
				input(IntCash.DurationTxtBox, Durationvalue);
				
				driver.manage().timeouts().implicitlyWait(210,TimeUnit.SECONDS);
				
				//waitUntilElementDisappear(IntCash.loader);
				
				//ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Duration in duration field.");
				//Log.info("Step:01 - Enter Duration in duration field.");
				
		
				ExtentTestManager.endTest();
			
			return true;
			
			}
			
            // submit button functionality
			

			public void submitbutton() throws InterruptedException {
				// TODO Auto-generated method stub
				
				//Thread.sleep(60000);	
				
				driver.manage().timeouts().implicitlyWait(210,TimeUnit.SECONDS);
				
				click(IntCash.stbutton);
				click(IntCash.stbutton);
				
				ExtentTestManager.getTest().log(Status.PASS, "Step:16 - Click on SUBMIT button.");
				Log.info("Step:16 - Click on SUBMIT button.");
				
				
				
				if(ElementDisplayed(IntCash.summaryTab)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: summary page loaded.");
					Log.info("Expected Result: summary page loaded.");
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
					}
				
				ExtentTestManager.endTest();
			}
				
				// print button
				
				public void printbutton() throws InterruptedException {
					// TODO Auto-generated method stub
			
					
					ExtentTestManager.getTest().log(Status.PASS, "Step:16 - Click on print button.");
					Log.info("Step:16 - Click on print button.");
					
					click(IntCash.ptbutton);
					
					mainWindowHandle = driver.getWindowHandle();
					Set<String> allWindowHandles = driver.getWindowHandles();
					boolean popupOpened = false;
				 
					for (String handle : allWindowHandles) {
						if (!handle.equals(mainWindowHandle)) {
							driver.switchTo().window(handle);
							popupOpened = true;
							break;
							
							
						}
					}	
					
					driver.close();				
					
					//Navigating to main window
					
					driver.switchTo().window(mainWindowHandle);
					
					ExtentTestManager.endTest();
					
					
				
					
					
				}
				
				
				
					public void logout_authorize(Map<Object, Object> testdata, ITestContext context) throws InterruptedException, IOException {
						// TODO Auto-generated method stub
						
						// fetch data from trans id field in summary page
						
						String TransactionId = driver.findElement(IntCash.TransactionIdprint).getText();
						
					    // click close button
						
						driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
						
						click(IntCash.closebutton);
						
						//click signout button
						
						driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
						
						ExtentTestManager.startTest("Signout from user");
						Log.info("Signout from user");
						click(IntCash.custSignOut);
						ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on sign out button");
						Log.info("Step 1: Click on sign out button");
						ExtentTestManager.getTest().log(Status.PASS, "Expected result: Signed out successfully");
						Log.info("Expected result: Signed out successfully");
						
						//Login with Another User
						
						String UserName = configloader().getProperty("UserName2");
						input(custSearch.loginUserName,UserName );
						String Password = configloader().getProperty("Password2");
						input(custSearch.loginPasswrd, Password);
						click(custSearch.loginButton);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Log in with another user for authorization");
						Log.info("Step:02 - Log in with another user for authorization");
					
						
						//Manager Authorization Window Access
						ExtentTestManager.startTest("Manager Authorization Window Access");
						Log.info("Manager Authorization Window Access");
						
						click(IntCash.autorizeAndCancelTab);
						ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the 'Authorise & Cancel' section.");
						Log.info("Step:01 - Navigate to the 'Authorise & Cancel' section.");
						
						click(IntCash.managerAuthoTab);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on 'Manager Authorisation'.");
						Log.info("Step:02 - Click on 'Manager Authorisation'.");
						
						if(ElementDisplayed(IntCash.managerTab)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Manager Authorisation window opens successfully.");
							Log.info("Expected Result: Manager Authorisation window opens successfully.");
							}else {
								ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
								Log.info("ERROR");
							}
						
						
						String trans = TransactionId. toString();
						
						input(IntCash.TransactionIds ,trans);
						
						// click go button
						
						Thread.sleep(1000);
						
						click(IntCash.Go);
						
						//click checkbox
						
						Thread.sleep(1000);
						
						click(IntCash.Checkbox);
						
						//click authorize button
						
						Thread.sleep(1000);
						
						click(IntCash.Authorize);
						
						Thread.sleep(1000);
						
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the AUTHORISE button.");
						Log.info("Step:02 - Click on the AUTHORISE button.");
						
						if(ElementDisplayed(IntCash.confirmationPopUp)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: manager authorization sucessfully updated.");
							Log.info("Expected Result: manager authorization sucessfully updated.");
							
							click(IntCash.confirmationPopUp);
							
							}else {
								ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
								Log.info("ERROR");
							}
					
						
						//cashier Authorization Window Access
						
						ExtentTestManager.startTest("cashier Authorization Window Access");
						Log.info("cashier Authorization Window Access");
						
						//click(IntCash.autorizeAndCancelTab);
						//ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to the 'Authorise & Cancel' section.");
						//Log.info("Step:01 - Navigate to the 'Authorise & Cancel' section.");
						
						click(IntCash.cashierAuthoTab);
						ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on 'cashier Authorisation'.");
						Log.info("Step:02 - Click on 'cashier Authorisation'.");
						
						Thread.sleep(2000);
						
						if(ElementDisplayed(IntCash.cashierAuthoscreen)) {
							ExtentTestManager.getTest().log(Status.PASS, "Expected Result: cashier Authorisation window opens successfully.");
							Log.info("Expected Result: cashier Authorisation window opens successfully.");
							}else {
								ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
								Log.info("ERROR");
							}	
						
						
					
				
                      // fetch data in transaction field
				
					
					input(IntCash.cashierTransactionIds ,trans);
					
					//click go button
					
					Thread.sleep(1000);
					
					click(IntCash.Go);
					
					//click checkbox
					
					Thread.sleep(1000);
					
					click(IntCash.cashierCheckBox);
					
					//click  authorize button
					
					Thread.sleep(1000);
					
					click(IntCash.cashierAuthorizeBtn);
					
					Thread.sleep(1000);
					
					
					ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the AUTHORISE button.");
					Log.info("Step:02 - Click on the AUTHORISE button.");
					
					if(ElementDisplayed(IntCash.confirmationPopUp)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: sucessfully updated.");
					Log.info("Expected Result: sucessfully updated.");
					click(IntCash.confirmationPopUp);
					}else {
						ExtentTestManager.getTest().log(Status.FAIL, "ERROR");
						Log.info("ERROR");
						
						
					}
					
					
					ExtentTestManager.startTest("Signout from user");
					Log.info("Signout from user");
					click(IntCash.custSignOut);
					ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on sign out button");
					Log.info("Step 1: Click on sign out button");
					ExtentTestManager.getTest().log(Status.PASS, "Expected result: Signed out successfully");
					Log.info("Expected result: Signed out successfully");
		}
				
				
				
		
			
				
		}		
				
				
		
				
			
		
				
				
				
				
			

		
			
			
			
		
		
				
		
			
			
			


			
						

	
	
	
	
	
	
	
	
	


