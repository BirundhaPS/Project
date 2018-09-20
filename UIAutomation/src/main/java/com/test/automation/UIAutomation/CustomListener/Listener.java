package com.test.automation.UIAutomation.CustomListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.UIAutomation.testBase.basePage;

public class Listener extends basePage implements ITestListener {
	
	//WebDriver driver;

	public void onTestStart(ITestResult result)
	{
				Reporter.log("Test Started Running :"+ result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result)
	{
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
		String methodName = result.getName();
		
		Reporter.log("Test Success:"+result.getMethod().getMethodName());
		
		if(result.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/UIAutomation/";
				File destFile = new File((String)reportDirectory + "/success_screenshots/"+methodName + "_"+ formater.format(calender.getTime()) + ".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'><img src='"+destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public void onTestFailure(ITestResult result)
	{
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if(!result.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/UIAutomation/";
				File destFile = new File((String)reportDirectory + "/failure_screenshots/"+methodName+ "_" + formater.format(calender.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath()+ "'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}

	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Test is Skipped :"+ result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
