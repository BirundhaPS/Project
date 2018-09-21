package com.test.automation.UIAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basePage {
	
	public static WebDriver driver;
	public static String path="./testdata.properties";
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ITestResult result;
	
	public static void Launch(String Browser,String Url)
	{
		if(Browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//driver//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//driver//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.get(Url);
		driver.manage().window().maximize();
		String log4jconfigpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	//explicit wait
	public static void elementToClick(long time,WebElement locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static String loadData(String key) throws IOException
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fis);	
		return prop.getProperty(key);
		
	}
	
	public int randomNumber() 
	{
		Random r=new Random();
		int i=r.nextInt(9999);	
		return i;
	}
	
	@AfterClass
	public void endTest()
	{
		closeBrowser();
	}
	
	public void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}

	@BeforeMethod
	public void beforeMethod(Method result)
	{
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO,result.getName() + "Test Started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		getResult(result);
	}

	public void getResult(ITestResult result2) {
		if(result2.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS, result2.getName() + "Test is passed");
		else if(result2.getStatus()==ITestResult.SKIP)
			test.log(LogStatus.SKIP, result2.getName() + "Test is Skipped and reason is: " + result2.getThrowable());
		else if(result2.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.ERROR, result2.getName() + "Test is failed " + result2.getThrowable());
			String screenshot = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshot));
		}
		
	}

	public String captureScreen(String fileName) {
	    File destFile = null;
	    Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    try 
	    {
	        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/UIAutomation/screenshots/";
	        destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
	        FileUtils.copyFile(scrFile, destFile);
	        // This will help us to link the screen shot in testNG report
	        Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return destFile.toString();
		}
	
	
	}
