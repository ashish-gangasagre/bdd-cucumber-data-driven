Feature:Admin



Scenario: Login with valid Credential
 Given User Lanch Chrome Browser
 When  User open url "https://admin-demo.nopcommerce.com/login"
 And  User enter Email as "admin@yourstore.com" and password as "admin"  
 And   User click on Login button
 Then  page title should be "Dashboard / nopCommerce administration"
 When  user click on log out link
 Then  page title should be "Your store. Login"
 Then  close browser
 
 
Scenario Outline: Login data driven 
 Given User Lanch Chrome Browser
 When User open url "https://admin-demo.nopcommerce.com/login"
 And User enter Email as "<email>" and password as "<password>"
 And User click on Login button
 Then page title should be "Dashboard / nopCommerce administration"
 When user click on log out link
 Then page title should be "Your store. Login"
 Then close browser
 
 Examples:
 
 | email               | password |
 |admin@yourstore.com  | admin    |
 |admin@yoursstore.com |admin123  |