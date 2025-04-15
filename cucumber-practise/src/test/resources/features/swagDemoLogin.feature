Feature: verify swag demo login
  @Smoke 
	Scenario: verify success login
  	Given Launch swag demo application
   	When Enter valid username and password
   	And Click on login button 
   	Then Validate home page is launched
   	And Close swag demo application
  
  @Sanity	
	Scenario: verify success login orangeHRM
  	Given Launch orangeHRM application
   	When Enter login credintials
   	And Click on submit button 
   	Then Validate orangeHRM home page is launched
   	And Close orangeHRM application
  
 