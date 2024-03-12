Feature: customers

Scenario: Add a new Custumer 
 Given User Lanch Chrome Browser
 When User open url "https://admin-demo.nopcommerce.com/login"
 And  User enter Email as "admin@yourstore.com" and password as "admin"  
 And  User click on Login button
 Then User can view Dashboard 
 When click on customers Menu
 And click on customers Menu Item
 And click on Add new button
 Then User can view Add new customer page
 When User enter customer info
 And click on Save button 
 Then User view configration message "The new customer has been added succefully."
 And close browser
 
 
 
 
 Scenario: verify user by email id
 Given User Lanch Chrome Browser
 When  User open url "https://admin-demo.nopcommerce.com/login"
 And  User enter Email as "admin@yourstore.com" and password as "admin"  
 And  User click on Login button
 Then User can view Dashboard 
 When click on customers Menu
 And click on customers Menu Item
 And Enter customer Email
 When Click on search button
 Then user should found Email in the search table
 And close browser