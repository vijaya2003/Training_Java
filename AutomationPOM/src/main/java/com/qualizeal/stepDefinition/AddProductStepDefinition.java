package com.qualizeal.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.qualizeal.utils.BaseClass;
import com.qualizeal.utils.SeleniumHelpers;
import com.qualizeal.pages.HomePage;
import com.qualizeal.pages.LoginPage;
import com.qualizeal.pages.ProductPage;
import com.qualizeal.pages.ShoppingCartPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductStepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	
	@Before
	public void openBrowser() {
		    BaseClass.initializeDriver();  
	        driver = BaseClass.getDriver();  
	        new SeleniumHelpers(driver); 
	        loginPage = new LoginPage(driver);
	}
	
	@Given("Launch the demo web shop application")
	public void launch_the_demo_web_shop_application() {
	    driver.get("https://demowebshop.tricentis.com/login");
	}

	@And("Enter valid username password")
	public void enter_valid_username_password() {
	    LoginPage.enterUsername("dasarisaibalaji2006@gmail.com");
	    LoginPage.enterPass("Dasari@123");
	}

	@And("click on the Remember me? check box")
	public void click_on_the_remember_me_check_box() {
	   LoginPage.clickOnCheck();
	}

	@And("click on login button")
	public void click_on_login_button() {
	   LoginPage.clickOnLogin();
	}

	@Then("Demo web shop home application should be opened")
	public void demo_web_shop_home_application_should_be_opened() {
	    
	}

	@Then("click on the Electronics button for the categories")
	public void click_on_the_electronics_button_for_the_categories() {
	    HomePage.clcikOnElectronics();
	}

	@When("Sub-category of electronics page should open")
	public void sub_category_of_electronics_page_should_open() {
	   
	}

	@And("click on cell-phone")
	public void click_on_cell_phone() {
	    HomePage.clickOnCellphone();
	}

	@And("cell-phone products page should display")
	public void cell_phone_products_page_should_display() {
	    
	}

	@Then("click on smartphone")
	public void click_on_smartphone() throws InterruptedException {
	    HomePage.clickOnSmartPhone();
	}

	@And("smartphone page should display with the selected item")
	public void smartphone_page_should_display_with_the_selected_item() {
	   
	}

	@Then("click on add to cart button")
	public void click_on_add_to_cart_button() {
	    ProductPage.clickAddCart();
	}

	@Then("sucessfully added message should be see")
	public void sucessfully_added_message_should_be_see() {
	   
	}

	@And("click on shopping cart button")
	public void click_on_shopping_cart_button() {
	   ProductPage.clcikShoppingCart();
	}

	@Then("cart page should be displayed")
	public void cart_page_should_be_displayed() {
	    
	}

	@And("smartphone should be displayed in cart")
	public void smartphone_should_be_displayed_in_cart() {
	    
	}

	@Then("click on qty box")
	public void click_on_qty_box() {
	    ShoppingCartPage.clickOnQty();
	}

	@And("change the qty to {int}")
	public void change_the_qty_to(Integer int1) {
	    
	}

	@And("click on update cart button")
	public void click_on_update_cart_button() {
	   
	}

	@Then("cart should be updated with two smartphone")
	public void cart_should_be_updated_with_two_smartphone() {
	   
	}

	@Then("select the country as india and state")
	public void select_the_country_as_india_and_state() {
	    
	}

	@Then("enter the pincode")
	public void enter_the_pincode() {
	    
	}

	@Then("click on estimate shoping button")
	public void click_on_estimate_shoping_button() {
	   
	}

	@Then("click on terms checkbox")
	public void click_on_terms_checkbox() {
	    
	}

	@Then("click on checkout button")
	public void click_on_checkout_button() {
	    
	}

	@Then("checkout page should open")
	public void checkout_page_should_open() {
	    
	}

	@Then("click on continue in billing address")
	public void click_on_continue_in_billing_address() {
	   
	}

	@Then("click on check box in shipping address")
	public void click_on_check_box_in_shipping_address() {
	   
	}

	@Then("click on continue button in shipping address")
	public void click_on_continue_button_in_shipping_address() {
	    
	}

	@Then("select payment method and click on continue")
	public void select_payment_method_and_click_on_continue() {
	    
	}

	@Then("click on continue button in the payment info")
	public void click_on_continue_button_in_the_payment_info() {
	    
	}

	@Then("Click on confirm button in the confirm order")
	public void click_on_confirm_button_in_the_confirm_order() {
	    
	}

	@Then("order successfully processed! message should display")
	public void order_successfully_processed_message_should_display() {
	    
	}
	
}
