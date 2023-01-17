package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	HomePage homepage;
	@Given("User opens the application")
	public void user_opens_the_application() {
	  driver= DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String string) {
		HomePage homepage=new HomePage(driver);
		homepage.enterSearchProduct(string);
		
	    
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		HomePage homepage=new HomePage(driver);
		homepage.clickOnSearchButton(); 
		
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		SearchResultPage srp=new SearchResultPage(driver);
		srp.displaySearchResult();
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String string) {
		HomePage homepage=new HomePage(driver);
		homepage.enterSearchProduct(string);
	}
	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		SearchResultPage srp=new SearchResultPage(driver);
		srp.displayMessage();			
	}

	@When("User do not enter any product name into Search box field")
	public void user_do_not_enter_any_product_name_into_search_box_field(){
		HomePage homepage=new HomePage(driver);
		
	}
}
