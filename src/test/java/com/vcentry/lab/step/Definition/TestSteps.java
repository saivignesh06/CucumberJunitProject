package com.vcentry.lab.step.Definition;

import com.vcentry.lab.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends BaseClass{

@Given("Open {string} browser")
public void open_browser(String string) {
   openBrowser(string);
   initObject();
}

@Given("Launch the given url")
public void launch_the_given_url() {
getDriver().get("https://www.saucedemo.com/");
}


@Given("Enter username as {string}")
public void enter_username_as(String string) {
   login.enterUsername(string);
}

@Given("Enter password as {string}")
public void enter_Password_as(String string) {
	 login.enterPassword(string);
}

@When("Click on Login button")
public void click_on_login_button() {
	login.clickLogin();
    }

@Then("User should navigate to Homepage")
public void user_should_navigate_to_homepage() {
	home.verifyLogin();
}
@Then ("verify login error message")
public void verify_login_error_message() {
	login.verifyErrorMsg();
}

@Given("Add Backpack to cart")
public void add_backpack_to_cart() {
    // Write code here that turns the phrase above into concrete actions
    home.addBackpacktocart();
}

@Then("Verify product in the cart")
public void verify_product_in_the_cart() {
    // Write code here that turns the phrase above into concrete actions
    cart.verifyProduct();
}

@Then("Click Checkout and fill the details")
public void click_checkout_and_fill_the_details() {
    // Write code here that turns the phrase above into concrete actions
	cart.clickCheckOut();
	 cart.enterCheckoutDetails("Test", "test", "56789");

}

@When("click on continue and Finish")
public void click_on_continue_and_finish() {
    // Write code here that turns the phrase above into concrete actions
    cart.clickContinueAndFinish();
}

@Then("verify order is placed")
public void verify_order_is_placed() {
    // Write code here that turns the phrase above into concrete actions
    cart.verifyOrderPlaced();
}
}
