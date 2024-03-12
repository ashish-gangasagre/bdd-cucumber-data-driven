package stepdefination;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.util.TimeUtil;
import pageobject.AddcustomerPage;
import pageobject.Adminpage;
import pageobject.searchcustomerpage;

public class StepDefination extends Base {

	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() {
	
//		ChromeOptions chromeOptions = new ChromeOptions();
	//WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
		
	//	ChromeOptions chromeOptions = new ChromeOptions();
	//	chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

		driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  ad=new Adminpage(driver);//create object of AdminPage JAva class
	}

	@When("User open url {string}")
	public void user_open_url(String url) 
	{
		  driver.get(url);
    }

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    ad.setussername(email);
	   ad.setpassword(password);
		
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws InterruptedException {
	   ad.clickonlogin();
		Thread.sleep(8000);

	}
	@Then("page title should be {string}")
	public void page_title_should_be(String title)  {
	   if(driver.getPageSource().contains("Login Was unsuccessful.")) {
		   driver.close();
		   Assert.assertTrue(false);
	   }else {
		   Assert.assertEquals(title, driver.getTitle());
	   }
	}

	

	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		ad.clickonlogout();
		Thread.sleep(3000);
	    
	}

	
	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}
	
	//custemer.feature step definition...........
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		adcust=new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", adcust.getpagetitle());
	}

	@When("click on customers Menu")
	public void click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
	  adcust.clickoncustemersmenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	   adcust.clickoncustemermenuitem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		adcust.clickonaddnew();
		Thread.sleep(3000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	  Assert.assertEquals("Add a new customer / nopCommerce administration", adcust.getpagetitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info()  {
	   String email=randomestring()+"@gmail.com";
	   adcust.setemail(email);
	   adcust.setpassword("test123");
	   
	   
	   adcust.setmanagerofvendor("Vendor 1");
	   adcust.setgender("Male");
	   adcust.enterfirstname("ashish");
	   adcust.enterlastname("gangasagre");
	   adcust.enterdob("3/10/1999");
	   adcust.entercompany("Qualityanlyst");
	   adcust.admincontent("this is for testing...........");
	}

	@When("click on Save button")
	public void click_on_save_button() {
	   adcust.clickonbtnsave();
	}

	@Then("User view configration message {string}")
	public void user_view_configration_message(String msg) {
	   Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added succefully."));
	}
	
	
	// steps for search customer by email id
	

@When("Enter customer Email")
public void enter_customer_email() {
    searchcust = new searchcustomerpage(driver);
    searchcust.setEmail("victoria_victoria@nopCommerce.com");
}



@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
    searchcust.clickonsearchbtn();
    Thread.sleep(3000);
}

@Then("user should found Email in the search table")
public void user_should_found_email_in_the_search_table() {
  boolean status = searchcust.serchcustmerbyemail("victoria_victoria@nopCommerce.com");
  Assert.assertEquals(true, status);
}

}