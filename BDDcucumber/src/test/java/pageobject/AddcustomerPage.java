package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

public WebDriver ldriver;

   public AddcustomerPage(WebDriver rdriver)
   {
   
   ldriver=rdriver;
   
	PageFactory.initElements(ldriver, this);
   }
   
   
   By lnkCustomers_menu=By.xpath("(//p[contains(text(),'Customers')])[1]");
   
   By lnkcustumers_menuitem=By.xpath("(//p[contains(text(),'Customers')])[2]");
   By btnaddnew=By.xpath("//a[normalize-space()='Add new']");
   
   By textemail=By.id("Email");
   By textpassword=By.id("Password");
   By firstname=By.id("FirstName");
   By lastname=By.id("LastName");
   
   By mgender=By.id("Gender_Male");
   By fgender=By.id("Gender_female");
   
   By dob=By.id("DateOfBirth");
   By drpmgrofvendor=By.xpath("//*[@id='VendorId']");
   
   By textcustemerrole=By.id("VendorId");
   By listitemadministration=By.xpath("(//li[contains(text(),'Administrators')])");
   By listitemguest=By.xpath("(//li[contains(text(),'Guests')])");
   By listitemregister=By.xpath("(//li[contains(text(),'Registered')])");
   By listitemvendor=By.xpath("(//li[contains(text(),'Vendors')])");
   
   
   By company=By.id("Company");
   By textadmincontent=By.id("AdminComment");
   By btnsave=By.xpath("(//button[@name='save'])[1]");
   
   
   //Actions method
   
   public String getpagetitle() {
	   return ldriver.getTitle();
   }
   
   public void clickoncustemersmenu() {
	  ldriver.findElement(lnkCustomers_menu).click();
   }
   public void clickoncustemermenuitem() {
	   ldriver.findElement(lnkcustumers_menuitem).click();
   }
   public void clickonaddnew() {
	   ldriver.findElement(btnaddnew).click();
   }
   public void setemail(String email) {
	   ldriver.findElement(textemail).sendKeys(email);
   }
   public void setpassword(String pass) {
	   ldriver.findElement(textpassword).sendKeys(pass);
   }
   public void enterfirstname(String fname) {
	   ldriver.findElement(firstname).sendKeys(fname);
   }
   public void enterlastname(String lname) {
	   ldriver.findElement(lastname).sendKeys(lname);
   }
   
   public void enterdob(String edob) {
	   ldriver.findElement(dob).sendKeys(edob);
   }
   
   public void setcustemerroles(String role) throws InterruptedException 
   {
	   if(!role.equals("vendors")) 
	   {
		ldriver.findElement(By.xpath("(//div[@role='listbox'])[2]"));  
	   }
	   ldriver.findElement(textcustemerrole).click();
		
	   WebElement listitem = null;
	   Thread.sleep(3000);
	   if(role.equals("adminstratiors")) {
		   listitem=ldriver.findElement(listitemadministration);
	   }
	   else if(role.equals("Guest")) {
		   listitem=ldriver.findElement(listitemguest);
	   }
	   else if(role.equals("registered")) {
		   listitem=ldriver.findElement(listitemregister);
	   }
	   else if(role.equals("vendor")) {
		   listitem=ldriver.findElement(listitemvendor);
	   }
	  // listitem.click();
	   
	   JavascriptExecutor js=(JavascriptExecutor)ldriver;
	   js.executeAsyncScript("arguments[0].click();", listitem);
   }
   
   
   public void setmanagerofvendor(String value) {
	   Select drp=new Select(ldriver.findElement(drpmgrofvendor));
	   drp.selectByVisibleText(value);
   }
   public void setgender(String gender) {
	   if(gender.equals("male")) {
		   ldriver.findElement(mgender).click();
	   }
	   else if(gender.equals("female")) {
		   ldriver.findElement(fgender).click();
	   }
	   else
	   {
		   ldriver.findElement(mgender).click();
	   }
   }
   
   
   
   public void entercompany(String ccompany) {
	   ldriver.findElement(company).sendKeys(ccompany);
   }
   public void admincontent(String content) {
	   ldriver.findElement(textadmincontent).sendKeys(content);
   }
   public void clickonbtnsave() {
	   ldriver.findElement(btnsave).click();
   }
  
     
}
