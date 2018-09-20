package com.test.automation.UIAutomation.homepage;

import org.testng.annotations.Test;

import com.test.automation.UIAutomation.testBase.basePage;
import com.test.automation.UIAutomation.uiActions.pageUI;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class TC001_VerifyLoginWithInvalidCredentials extends basePage{
  
	pageUI page;
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	@Test
  public void project() throws Exception
  {
		log.info("------Started TC001_VerifyLoginWithInvalidCredentials------");
		page = new pageUI(driver);
		page.AccountCreate();
		log.info("----------Ended TC001_VerifyLoginWithInvalidCredentials -----");
  }
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  Launch(loadData("Browser"), loadData("Url"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
