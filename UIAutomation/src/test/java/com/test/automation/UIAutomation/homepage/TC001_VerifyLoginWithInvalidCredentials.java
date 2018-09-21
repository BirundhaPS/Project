package com.test.automation.UIAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.testBase.basePage;
import com.test.automation.UIAutomation.uiActions.pageUI;

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
	
  @BeforeClass
  public void startTest() throws IOException {
	  Launch(loadData("Browser"), loadData("Url"));
  }


  }
