
package com.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Page_Customer.Customer_CustomerSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver = null;
	
	public String spPAN = "GenerateNextPAN";
    public String clmnNamPAN = "generated_pan";
    
    public String spAadhaar = "GenerateNextAadharNumber";
    public String clmnNamAadhaar = "generated_aadhar_number";
    
    public String spMobileNum = "GenerateNextMobileNumber";
    public String clmnNamMobileNum = "generated_mobile_number";
    
    public String spIdentityNo = "GenerateNextIdentityNo";
    public String clmnNamIdentityNo = "generated_identity_no";

	
	public WebDriver getDriver() {
		return driver;
	} 
	
	private static By L_username = By.id("txtUserName_txt");
	private static By L_password = By.id("txtPassword_txt");
	//private static  By L_SignIn = By.xpath("//span[text()=' Sign In ']");
	private static  By L_SignIn = By.id("imgbtnSubmit");
	private static By DesktopNot = By.xpath("//button[text()='OK']");
	//private static By L_LogOut= By.xpath("//div[@class='user position ng-tns-c3-15 ng-star-inserted']");
	//private static By L_LogAlert= By.xpath("//button[text()='Sign out']");
	
	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	
	
	public void SetUp() throws IOException, InterruptedException {
		
		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		String UserName = configloader().getProperty("UserName");
		String Password = configloader().getProperty("Password");
		
		switch (Browser.toUpperCase()) {

		case "CHROME":

			ChromeOptions options = new ChromeOptions();
			//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			options.addArguments("--disable-extensions");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\linita.shivalkar\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);		
			break;

//		case "FIREFOX":
//			
//			System.setProperty("webdriver.gecko.driver","D:\\Testing\\geckodriver.exe");
//			File pathBinary = new File("C:\\Users\\akash.venkatesh\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
//			DesiredCapabilities desired = DesiredCapabilities.firefox();
//			FirefoxOptions options1 = new FirefoxOptions();
//			desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options1.setBinary(firefoxBinary));
//			driver = new FirefoxDriver(options1);
////			FirefoxOptions options1 = new FirefoxOptions();
////			WebDriverManager.firefoxdriver().setup();
////			//System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
////			driver = new FirefoxDriver(options1);
//			ExtentTestManager.getTest().log(Status.PASS, "Firefox Driver & Application Launched successfully.");
//			break;
			
			
		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
			break;

		default:
			System.err.println("The Driver is not defined");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Log.info("Driver has initialized successfully for "+Browser+"browser");
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//		Thread.sleep(9000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : "+Pagetitle);
	
//		input(L_username, UserName);
//		Log.info("Username is added");
//		input(L_password, Password);
//		Log.info("Password is added");
//		click(L_SignIn);
//		Log.info("Signed In");
//		Thread.sleep(4000);
//		click(DesktopNot);
//		Thread.sleep(1000);
	}

	
	public static String getValue(By path) {
		return driver.findElement(path).getText(); 
	}
	
	public static  void input(By element, String Value) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
	}

	public static  void click(By element) throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(2000);
	}

	public static void select(String value,By element) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		//selWeekDayDropDown.selectByVisibleText(value);
		//selWeekDayDropDown.selectByValue(value);
		selWeekDayDropDown.selectByVisibleText(value);
	}
	
	public static void selectbyValue(String value,By element) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		//selWeekDayDropDown.selectByVisibleText(value);
		selWeekDayDropDown.selectByValue(value);
		//selWeekDayDropDown.selectByVisibleText(value);
	}
	
	/* public static void select(String value,By element) throws  {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		selWeekDayDropDown.selectByVisibleText(value);
//		selWeekDayDropDown.selectByValue(value);
	}*/

	public static void clear(By element)throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}

	public static void AcceptAlert()
	{
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();	
	}
	
	public static void DismissAlert()
	{
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();	
	}

	public static void waitUntilElementDisappear(By element) throws InterruptedException {

		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		//Thread.sleep(2000);

	}
	
	public static void SwitchToFrame(By frameName) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}
	
	public static void ScrollUntilElementVisible(By locator) throws InterruptedException
	{ 
		Thread.sleep(1000);
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static boolean ElementDisplayed(By locator) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isDisplayed();
		return flag;
	}
	
	public static boolean ElementEnabled(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}
	
	public static boolean CheckBoxStatus(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isSelected();
		return flag;
	}
	
	public static void UploadFile(By locator, String path)
	{
		WebElement uploadElement = driver.findElement(locator);
		String path1=System.getProperty("user.dir");
		Log.info("path is :" + path1);
		uploadElement.sendKeys(path1 + path);
		
	}
	
	
	public static void UploadFile(By locator)
	{
		WebElement uploadElement = driver.findElement(locator);
		 String path=System.getProperty("user.dir");
		 Log.info("path is :" + path);
		//System.out.Directory.GetParent(this.GetType().Assembly.Location).ToString();
		uploadElement.sendKeys(path);
		
		
	}
	public static boolean checkElementEnableOrDisable(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}
	
	public static boolean CheckElementDisable(By locator)
	{  
		//disable
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();	
		
		if (flag==false) {
			flag=true;
		}else if(flag==true)
			flag=false;
		
		return flag;
	}
	
	
	public static  void Hover(By element) throws InterruptedException {
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).perform();
	}
	
	
public static  void DatabaseConnector() throws ClassNotFoundException {
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

		
		try(Connection connection = DriverManager.getConnection(Url,UserName,Password)){
		//con = DriverManager.getConnection(Url,UserName,Password);
		System.out.println("Class: Common Method: DatabaseConnector: Connected");
		
		//Execute Query for getting approval
		CallableStatement callableStatement = connection.prepareCall("{call cl}");
		//callableStatement.setLong(1, 9999999991L);
		//System.out.println("Stored procedure called with parameter: 9999999991");
		
		 // Execute stored procedure
        callableStatement.executeQuery();
//        while (resultSet.next()) {
//            String column1 = resultSet.getString("O");
//            System.out.println("OTP : " + column1  );
//
//		
//        }
		
	}catch(Exception e)
	{
		System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
		//e.printStackTrace();
	
	}  
}
	
	
//	public static  void DatabaseConnector() throws ClassNotFoundException {
//		
//		
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String UserName = "sqa";
//		String Password = "SPQA@sql2019" ;
//		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";
//
//		
////		try(Connection connection = DriverManager.getConnection(Url,UserName,Password)){
////		//con = DriverManager.getConnection(Url,UserName,Password);
////		System.out.println("Class: Common Method: DatabaseConnector: Connected");
////		
////		//Execute Query for getting approval
////		CallableStatement callableStatement = connection.prepareCall("{call cl}");
////		//callableStatement.setLong(1, 9999999991L);
////		//System.out.println("Stored procedure called with parameter: 9999999991");
////		
////		 // Execute stored procedure
////        callableStatement.executeQuery();
////        System.out.println("Stored procedure executed successfully.");
//////        while (resultSet.next()) {
//////            String column1 = resultSet.getString("O");
//////            System.out.println("OTP : " + column1  );
//////
//////		
//////        }
//		String query = "cl;";
//        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
//	             Statement statement = connection.createStatement();
//	             ResultSet resultSet = statement.executeQuery(query)) {
//
//	        } catch (SQLException e) {
//	            System.out.println("Error executing the SQL query.");
//	            //e.printStackTrace();
//	        }
//        
//
//        
//		
//	}catch(Exception e)
//	{
//		System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
//		//e.printStackTrace();
//	
//	}
//   
//}
	
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
	                     value = resultSet.getString(columnName); // Get the first Cust_ID
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

		
		
		
	public static  void DatabaseConnector1() throws ClassNotFoundException {
			
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019" ;
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";

			
			try(Connection connection = DriverManager.getConnection(Url,UserName,Password)){
			//con = DriverManager.getConnection(Url,UserName,Password);
			System.out.println("Class: Common Method: DatabaseConnector: Connected");
			
			//Execute Query for getting approval
			CallableStatement callableStatement = connection.prepareCall("update users set RecordStatus=3");
			
			//callableStatement.setLong(1, 9999999991L);
			//System.out.println("Stored procedure called with parameter: 9999999991");
			
			 // Execute stored procedure
	        callableStatement.executeQuery();
	        System.out.println("Query Executed");
//	        while (resultSet.next()) {
//	            String column1 = resultSet.getString("O");
//	            System.out.println("OTP : " + column1  );
	//
//			
//	        }
			
		}catch(Exception e)
		{
			System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
			//e.printStackTrace();
		
		}  
	}
	
	
    public String dateConversion(String inputDate) throws ParseException {
    	
        // Define the original format of the date string
        SimpleDateFormat originalFormat = new SimpleDateFormat("EEEE, MMMM dd yyyy", Locale.ENGLISH);

        // Parse the input date string
        Date date = originalFormat.parse(inputDate);

        // Define the desired output format (DD/MM/YYYY)
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Format the parsed date into the desired format
        String formattedDate = targetFormat.format(date);
        
    	return formattedDate;
    }


    public static void waitForSpinnerToStop(WebDriver driver, By spinnerLocator) {
         int MAX_WAIT_TIME = 60;  // Max total wait time in seconds
         int POLL_INTERVAL = 1;   // Poll interval in seconds
         int CONSECUTIVE_DISAPPEAR_COUNT = 3;  // Number of consecutive times the spinner must disappear
         
        int remainingTime = MAX_WAIT_TIME;
        int disappearCount = 0;

        // WebDriverWait setup
        WebDriverWait wait = new WebDriverWait(driver, POLL_INTERVAL);

        // Loop until the spinner disappears for the set number of cycles or time runs out
        while (remainingTime > 0) {
            try {
                // Wait until the spinner becomes invisible
                wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));

                // If spinner disappeared, increment the disappearCount
                disappearCount++;

                // If spinner has disappeared for enough consecutive cycles, we stop the wait
                if (disappearCount >= CONSECUTIVE_DISAPPEAR_COUNT) {
                    System.out.println("Spinner has stopped appearing.");
                    return;
                }

            } catch (Exception e) {
                // Spinner is still visible, reset disappearCount
                disappearCount = 0;
                System.out.println("Spinner is still visible. Waiting...");
            }

            // Sleep for the polling interval before checking again
            try {
                Thread.sleep(POLL_INTERVAL * 1000); // Polling interval
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            // Reduce the remaining time
            remainingTime -= POLL_INTERVAL;
        }

        System.out.println("Timeout reached, spinner still shows up intermittently.");
    }//end
    
    
    // Method to verify drop down selection
	public boolean dropdownSelectionValidation(String expectedOption,By locator) {
    	WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        return dropdown.getFirstSelectedOption().getText().equals(expectedOption);
    }
	
	 // Method to get the value of the entered account number
    public boolean inputValidation(By locator,String input) {
    	WebElement element = driver.findElement(locator);
    	System.out.println("InputValue: "+element.getAttribute("value"));
        return element.getAttribute("value").equals(input);
    }
    
    public static void ExtentSuccessMessage(String strPassSuccessMessage) {
		ExtentTestManager.getTest().log(Status.PASS, strPassSuccessMessage);
	}
 
	public static void ExtentErrorMessage(String strPassErrorMessage) {
		ExtentTestManager.getTest().log(Status.FAIL, strPassErrorMessage);
	}
	
	public static String GetElementText(By locator) throws InterruptedException {
		 
		String stxt = null;
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			stxt = element.getText();
			Log.info("System able to found the element :" + locator);
		} else {
			Log.error("System not able to found the element :" + locator);
		}
		return stxt;
	}
	
	public void PageRefresh() {
		driver.navigate().refresh();
	}
	
	public static String GetElementAttribute(By locator,String Values)
	{
		WebElement element = driver.findElement(locator);
		String flags = element.getAttribute(Values);
		return flags;
	}
	
	public static boolean ElementEnableOrDisable(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}
	
	public static  void INclick(By element) throws InterruptedException {
		 
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		//Thread.sleep(2000);
 
	}
	
	public static  void waitTillLoaderDisappear(By element) throws InterruptedException {
		 
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		//Thread.sleep(2000);
 
	}
	
	public static void PressTabKey() {
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
	}
	
    
    
//	public  String generateUniqueId(String query,String columnName) throws ClassNotFoundException {
//		 // Method that returns the first customer ID (String) from the database
//	        // Database connection details
//      // Database connection details
//      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String UserName = "sqa";
//		String Password = "SPQA@sql2019" ;
//		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";
//
//		
//	        String value = null; // Declare and initialize the return variable
//
//	        // Establish the connection to the database
//	        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
//	             Statement statement = connection.createStatement();
//	             ResultSet resultSet = statement.executeQuery(query)) {
//	        	
//	        	if (resultSet.next()) {
//	        		value = resultSet.getString(columnName); // Get the first Cust_ID
//	                System.out.println("Generated Unique ID: " + value);
//	            } else {
//	                System.out.println("Unique ID not generated.");
//	            }
//
//	        } catch (SQLException e) {
//	            System.out.println("Error executing the SQL query or processing the result set.");
//	            e.printStackTrace();
//	        }
//
//	        return value; // Return the firstCustId
//	    }//end
	
	
    

    
}


