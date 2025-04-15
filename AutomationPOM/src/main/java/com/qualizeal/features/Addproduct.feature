
@tag
Feature: Increase the quantity of product and buy
  
  @tag1
  Scenario: Increase the quantity of product after adding it into the cart and buy
    Given Launch the demo web shop application
    And Enter valid username password
    And click on the Remember me? check box
    And click on login button
    Then Demo web shop home application should be opened
    Then click on the Electronics button for the categories
    When Sub-category of electronics page should open
    And click on cell-phone
    And cell-phone products page should display
    Then click on smartphone
    And smartphone page should display with the selected item
    Then click on add to cart button
    Then sucessfully added message should be see
    And click on shopping cart button
    Then cart page should be displayed
    And smartphone should be displayed in cart
    Then click on qty box
    And change the qty to 2
    And click on update cart button
    Then cart should be updated with two smartphone
    Then select the country as india and state
    Then enter the pincode
    Then click on estimate shoping button
    Then click on terms checkbox
    Then click on checkout button
    Then checkout page should open
    Then click on continue in billing address
    Then click on check box in shipping address
    Then click on continue button in shipping address
    Then select payment method and click on continue
    Then click on continue button in the payment info
    Then Click on confirm button in the confirm order
    Then order successfully processed! message should display
    
       
    

  
