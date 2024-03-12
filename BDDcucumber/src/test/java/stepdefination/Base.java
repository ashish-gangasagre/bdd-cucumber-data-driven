package stepdefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageobject.AddcustomerPage;
import pageobject.Adminpage;
import pageobject.searchcustomerpage;

public class Base {

	public WebDriver driver;
	
	public Adminpage ad;
	
	public AddcustomerPage adcust;
	
	public searchcustomerpage searchcust;
	
	//created for generating random String for unique email
	public static String randomestring() {
		String genratedString1 =RandomStringUtils.randomAlphabetic(5);
		return(genratedString1);
	}
}
