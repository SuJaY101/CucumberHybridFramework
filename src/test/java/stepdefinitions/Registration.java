package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegisterPage;


public class Registration {
	WebDriver driver;
	private RegisterPage registerpage;
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage=homepage.clickRegisterButton();   
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
	  Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	  registerpage.enterFirstName(dataMap.get("firstName"));
	  registerpage.enterLastName(dataMap.get("lastName"));
	  registerpage.enteremail(dataMap.get("email"));
	  registerpage.entertelephone(dataMap.get("telephone"));
	  registerpage.enterpassword(dataMap.get("password"));
	  registerpage.enterConPassword(dataMap.get("password")); 
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
	  Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	  registerpage.enterFirstName(dataMap.get("firstName"));
	  registerpage.enterLastName(dataMap.get("lastName"));
	  registerpage.enteremail(dataMap.get("email"));
	  registerpage.entertelephone(dataMap.get("telephone"));
	  registerpage.enterpassword(dataMap.get("password"));
	  registerpage.enterConPassword(dataMap.get("password"));
	}
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	   registerpage.selectPrivacyPolicy();
	}
	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	   registerpage.clickOnContinue();
	}
	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		System.out.println("Account is created");
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectNewsletter();
	}
	
	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		registerpage.DuplicateMessage();
	}

	@When("User do not enters any details into fields")
	public void user_do_not_enters_any_details_into_fields() {
		registerpage.enterFirstName("");
		  registerpage.enterLastName("");
		  registerpage.enteremail("");
		  registerpage.entertelephone("");
		  registerpage.enterpassword("");
		  registerpage.enterConPassword(""); 
	}
	
	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
		registerpage.warnMessage();
		 
	}
	
	
}
