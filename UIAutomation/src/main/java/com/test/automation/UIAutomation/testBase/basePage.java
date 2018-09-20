package com.test.automation.UIAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
	
	public static WebDriver driver;
	public static String path="./testdata.properties";
	
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
	
	
	}
