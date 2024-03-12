package pageobject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminpage {

	public WebDriver ldriver;
	
	public Adminpage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(xpath = "//*[@id='Email']")
	WebElement username;
	
	@FindBy(xpath = "//*[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//*[text()='Log in']")
	WebElement loginbtn;
	
	@FindBy(xpath= "//*[@id='navbarText']/ul/li[3]/a")
	WebElement logout;
	
	 public String getpagetitle() {
		   return ldriver.getTitle();
	   }
	 
	public void setussername(String usename) {
		username.clear();
	username.sendKeys(usename);
	}
	public void setpassword(String passwd) {
		password.clear();
		password.sendKeys(passwd);
	}
	public void clickonlogin() {
		loginbtn.click();
	}
	public void clickonlogout() {
		logout.click();
	}
	
	
}
