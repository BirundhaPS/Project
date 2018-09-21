package com.test.automation.UIAutomation.uiActions;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		log.info("Clicked on submit using with object : "+ Submit.toString());
		//Thread.sleep(3000);
		elementToClick(30, Title_gen2);
		Title_gen2.click();
		log.info("Selected Radio button using with object : "+ Title_gen2.toString());
		FirstName.sendKeys(loadData("firstname"));
		log.info("Entered FirstName with : " + FirstName.getAttribute("value") + "using with object firstname : " + FirstName.toString());
		LastName.sendKeys(loadData("lastname"));
		log.info("Entered LastName with : " + LastName.getAttribute("value") + "using with object lastname : " + LastName.toString());
		PassWord.sendKeys(loadData("password"));
		log.info("Entered PassWord with : " + PassWord.getAttribute("value") + "using with object password : " + PassWord.toString());
		 Select sel_day = new  Select(DOB_day);
		 	sel_day.selectByValue("5");
		 log.info("Day selected with : " + sel_day.getFirstSelectedOption() + "using with object : " + sel_day.toString());
		 Select sel_month = new  Select(DOB_month);
		 	sel_month.selectByValue("7");
		 log.info("Month selected with : " + sel_month.getFirstSelectedOption() + "using with object : " + sel_month.toString());
		 Select sel_year = new  Select(DOB_year);
			 	sel_year.selectByValue("1987");
		 log.info("Year selected with : " + sel_year.getFirstSelectedOption() + "using with object : " + sel_year.toString());
	 	FirtName_address.sendKeys("Birundha");	
	 	log.info("Entered FirstName in address section with : " + FirtName_address.getAttribute("value") + "using with object FirtName_address : " + FirtName_address.toString());
	 	LastName_address.sendKeys("PS");
	 	log.info("Entered LastName in address section with : " + LastName_address.getAttribute("value") + "using with object LastName_address : " + LastName_address.toString());
	 	Company.sendKeys("Sesa");
	 	log.info("Entered Company in address section with : " + Company.getAttribute("value") + "using with object Company : " + Company.toString());
	 	Address_1.sendKeys("Avery Crossing");
	 	log.info("Entered Address_1 in address section with : " + Address_1.getAttribute("value") + "using with object Address_1 : " + Address_1.toString());
	 	City.sendKeys("Dublin");
	 	log.info("Entered City in address section with : " + City.getAttribute("value") + "using with object City : " + City.toString());
	 	Select sel_state = new  Select(State);
	 		sel_state.selectByVisibleText("Ohio");
	 	log.info("State selected with : " + sel_state.getFirstSelectedOption() + "using with object : " + sel_state.toString());
	 	Postcode.sendKeys("43016");
	 	log.info("Entered Postcode in address section with : " + Postcode.getAttribute("value") + "using with object Postcode : " + Postcode.toString());
	 	Select sel_country = new  Select(Country);
	 		sel_country.selectByVisibleText("United States");
	 	log.info("Country selected with : " + sel_country.getFirstSelectedOption() + "using with object : " + sel_country.toString() );
	 	Phone.sendKeys("6144405363");
	 	log.info("Entered Phone with : " + Phone.getAttribute("value") + "using with object Phone : " + Phone.toString());
	 	Mobile_Phone.sendKeys("6144405363");
	 	log.info("Entered Mobile_Phone with : " + Mobile_Phone.getAttribute("value") + "using with object Mobile_Phone : " + Mobile_Phone.toString());
	 	Alias_address.sendKeys("Avery Crossing");
	 	log.info("Entered Alias_address with : " + Alias_address.getAttribute("value") + "using with object Alias_address : " + Alias_address.toString());
	 	Button.click();
	 	log.info("Finally Clicked on Register button using with object : "+ Button.toString());
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
