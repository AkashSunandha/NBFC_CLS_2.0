package com.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import bsh.ParseException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver = null;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	private static By L_username = By.id("Username");
	private static By L_password = By.id("Password");
	private static  By L_SignIn = By.xpath("//span[text()=' Sign In ']");
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

	public static boolean CheckBoxStatus(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isSelected();
		return flag;
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

		case "FIREFOX":
			
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			File pathBinary = new File("C:\\Users\\vijayalakshmi.a\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
			DesiredCapabilities desired = DesiredCapabilities.firefox();
			FirefoxOptions options1 = new FirefoxOptions();
			desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options1.setBinary(firefoxBinary));
			driver = new FirefoxDriver(options1);
			
//            FirefoxOptions options1 = new FirefoxOptions();
//            WebDriverManager.firefoxdriver().setup();
//            //System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
//            driver = new FirefoxDriver(options1);
//ExtentTestManager.getTest().log(Status.PASS, "Firefox Driver & Application Launched successfully.");

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
//		input(L_password, Password);
//		click(L_SignIn);
//		Thread.sleep(4000);
//		click(DesktopNot);
//		Thread.sleep(1000);
	}


	public static  void input(By element, String Value) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
	}

	public static  void click(By element) throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(2000);
	}

	public static void select(String value,By element) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		selWeekDayDropDown.selectByVisibleText(value);
		
	}

	public static void clear(By element)throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}
    // Method to verify drop down selection
	public boolean dropdownSelectionValidation(String expectedOption,By locator) {
    	WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        return dropdown.getFirstSelectedOption().getText().equals(expectedOption);
    }
    public String dateConversion(String inputDate) throws ParseException, java.text.ParseException {
    	
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
 
	 // Method to get the value of the entered account number
    public boolean inputValidation(By locator,String input) {
    	WebElement element = driver.findElement(locator);
    	System.out.println("InputValue: "+element.getAttribute("value"));
        return element.getAttribute("value").equals(input);
    }
 

	public void AcceptAlert()
	{
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();	
	}
	public static void DismissAlert()
	{
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();	
	}

	public static  void INclick(By element) throws InterruptedException {

		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		//Thread.sleep(2000);

	}
	
	public static void SwitchToFrame(By frameName)
	{
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
		WebDriverWait wait = new WebDriverWait(driver, 60);
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
	
	public static void UploadFile(By locator, String path)
	{
		WebElement uploadElement = driver.findElement(locator);
		String path1=System.getProperty("user.dir");
		Log.info("path is :" + path1);
		uploadElement.sendKeys(path1 + path);
		
	}
	
	
//	public static void UploadFile(By locator)
//	{
//		WebElement uploadElement = driver.findElement(locator);
//		 String path=System.getProperty("user.dir");
//		 Log.info("path is :" + path);
//		//System.out.Directory.GetParent(this.GetType().Assembly.Location).ToString();
//		uploadElement.sendKeys(path);
//		
//		
//	}
	public static boolean ElementEnableOrDisable(By locator)
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

		
//		try(Connection connection = DriverManager.getConnection(Url,UserName,Password)){
//		//con = DriverManager.getConnection(Url,UserName,Password);
//		System.out.println("Class: Common Method: DatabaseConnector: Connected");
//		
//		//Execute Query for getting approval
//		CallableStatement callableStatement = connection.prepareCall("{call cl}");
//		//callableStatement.setLong(1, 9999999991L);
//		//System.out.println("Stored procedure called with parameter: 9999999991");
//		
//		 // Execute stored procedure
//        callableStatement.executeQuery();
//        System.out.println("Stored procedure executed successfully.");
////        while (resultSet.next()) {
////            String column1 = resultSet.getString("O");
////            System.out.println("OTP : " + column1  );
////
////		
////        }
		String query = "cl;";
        try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	        } catch (SQLException e) {
	            System.out.println("Error executing the SQL query.");
	            e.printStackTrace();
	        }
        

        
		
//	}catch(Exception e)
//	{
//		System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
//		//e.printStackTrace();
//	
//	}
   
}
	
	

}
