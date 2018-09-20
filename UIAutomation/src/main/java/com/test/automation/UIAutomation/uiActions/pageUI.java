package com.test.automation.UIAutomation.uiActions;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.UIAutomation.homepage.TC001_VerifyLoginWithInvalidCredentials;
import com.test.automation.UIAutomation.testBase.basePage;

public class pageUI extends basePage
{
	public static final Logger log=Logger.getLogger(pageUI.class.getName());
	
	@FindBy(linkText="Sign in") public WebElement SignIn;
	@FindBy(id="email_create") public WebElement email;
	@FindBy(id="SubmitCreate") public WebElement Submit;
	@FindBy(xpath=".//*[@id='create_account_error']/ol/li") public WebElement error;
	@FindBy(id="id_gender1") public WebElement Title_gen1;
	@FindBy(id="id_gender2") public WebElement Title_gen2;
	@FindBy(id="customer_firstname") public WebElement FirstName;
	@FindBy(id="customer_lastname") public WebElement LastName;
	@FindBy(id="passwd") public WebElement PassWord;
	@FindBy(id="days") public WebElement DOB_day;
	@FindBy(id="months") public WebElement DOB_month;
	@FindBy(id="years") public WebElement DOB_year;
	@FindBy(id="firstname") public WebElement FirtName_address;
	@FindBy(id="lastname") public WebElement LastName_address;
	@FindBy(id="company") public WebElement Company;
	@FindBy(id="address1") public WebElement Address_1;
	@FindBy(id="address1") public WebElement Address_2;
	@FindBy(id="city") public WebElement City;
	@FindBy(id="id_state") public WebElement State;
	@FindBy(id="postcode") public WebElement Postcode;
	@FindBy(id="id_country") public WebElement Country;
	@FindBy(id="other") public WebElement TextArea;
	@FindBy(id="phone") public WebElement Phone;
	@FindBy(id="phone_mobile") public WebElement Mobile_Phone;
	@FindBy(id="alias") public WebElement Alias_address;
	@FindBy(id="submitAccount") WebElement Button;
	
	public void AccountCreate() throws InterruptedException, Exception
	{
		SignIn.click();
		log.info("Clicked on Signin using with object : "+ SignIn.toString());
		email.sendKeys(loadData("firstname")+loadData("lastname")+randomNumber()+loadData("domainname"));
		log.info("Entered email address with : " + email.getAttribute("value") + "using with object email : "+ email.toString());
		System.out.println(email.getAttribute("value"));
		Submit.click();
		//Thread.sleep(3000);
		elementToClick(30, Title_gen2);
		Title_gen2.click();
		FirstName.sendKeys(loadData("firstname"));
		LastName.sendKeys(loadData("lastname"));
		PassWord.sendKeys(loadData("password"));
		 Select sel_day = new  Select(DOB_day);
		 	sel_day.selectByValue("5");
		 Select sel_month = new  Select(DOB_month);
		 	sel_month.selectByValue("7");
		 Select sel_year = new  Select(DOB_year);
			 	sel_year.selectByValue("1987");
	 	FirtName_address.sendKeys("Birundha");	
	 	LastName_address.sendKeys("PS");
	 	Company.sendKeys("Sesa");
	 	Address_1.sendKeys("Avery Crossing");
	 	City.sendKeys("Dublin");
	 	Select sel_state = new  Select(State);
	 		sel_state.selectByVisibleText("Ohio");
	 	Postcode.sendKeys("43016");
	 	Select sel_country = new  Select(Country);
	 		sel_country.selectByVisibleText("United States");
	 	Phone.sendKeys("6144405363");
	 	Mobile_Phone.sendKeys("6144405363");
	 	Alias_address.sendKeys("Avery Crossing");
	 	Button.click();
	}


	public pageUI(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Accountverify()
	{
		return error.getText();
	}
	

}
