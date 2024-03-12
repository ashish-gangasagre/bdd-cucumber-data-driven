package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class searchcustomerpage {
	
	
	public WebDriver lDriver;
	
	 
	
	public searchcustomerpage(WebDriver rdriver) {
		lDriver=rdriver;
		PageFactory.initElements(lDriver, this);
		
	}
	@FindBy(xpath= "(//input[@id='SearchEmail'])[1]")
	WebElement textEmail;
	
	//@FindBy(how = How.ID, using = "searchEmail")
	//@CacheLookup
	//WebElement textEmail;
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement lastname;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='search-customers']")
	@CacheLookup
	WebElement searchbtn;
	
	@FindBy(how=How.XPATH, using="//*[@class='dataTables_scroll']")
	@CacheLookup
	WebElement table;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='dataTables_scroll']//tbody/tr")
	@CacheLookup
	List<WebElement> tablerow;
	
	@FindBy(how=How.XPATH,using ="//*[@class='dataTables_scroll']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecolumns;
	
	
	
	
	public void setEmail(String email) {

	textEmail.clear();
	textEmail.sendKeys(email);
	}
	
	public void enterfname(String fname) {
		
		firstname.clear();
		firstname.sendKeys(fname);
		
	}
	public void enterlname(String lname) {
		
		lastname.clear();
		lastname.sendKeys(lname);
	}
	public void clickonsearchbtn() {
	searchbtn.click();
     }
	
	public int getnoofrows() {
		return(tablerow.size());
	}
	
	public int getnoofcolumns() {
		return(tablecolumns.size());
	}
	
	public boolean serchcustmerbyemail(String email)
	{
		boolean flag=false;
		
		for(int i=1;i<=getnoofrows();i++) {
			String emailid=table.findElement(By.xpath("//*[@class='dataTables_scroll']//tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
			}
			
		}
		return flag;
	}
	
	
	
	
}
