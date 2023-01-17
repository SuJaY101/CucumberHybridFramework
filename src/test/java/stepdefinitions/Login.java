package stepdefinitions;



import org.openqa.selenium.WebDriver;


import factory.DriverFactory;


import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	 WebDriver driver; 
	 private LoginPage loginpage;
	 private AccountPage accountpage;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
	  loginpage= homepage.clickOnLogin(); 
	}

	@When("User enters valid emai address {string} into email field")
	public void user_enters_valid_emai_address_into_email_field(String string) {	
		loginpage.enterEmailAddress(string); 
	}

	@When("User has entered valid password {string} into password field")
	public void user_has_entered_valid_password_into_password_field(String string) {
		loginpage.enterPassword(string);	
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountpage=loginpage.clickLoginButton();	
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() { 
		accountpage.loginSuccessfull();  
	} 
	
	@When("User enters invalid emai address into email field")
	public void user_enters_invalid_emai_address_into_email_field() {
		loginpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());	
	}
	
	@Then("User should get warning message about credentials mismatch")
	public void user_should_get_warning_message_about_credentials_mismatch() {
		loginpage.warningDisplay1();
	}

	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		loginpage.enterEmailAddress("");	
	}

	@When("User do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
		loginpage.enterPassword("");	
	}
	
}
