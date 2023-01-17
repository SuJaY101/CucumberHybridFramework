package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementutills;  
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtils(driver);
	}
	@FindBy(name="email")
	private WebElement emailField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement loginbutton;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement Warning;
	
	
	public void enterEmailAddress(String string) {
		elementutills.typeTextIntoElement(emailField, string,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
		
	public void enterPassword(String string) {
		elementutills.typeTextIntoElement(passwordField, string,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
		
	public AccountPage clickLoginButton() {
		elementutills.clickOnElement(loginbutton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public boolean warningDisplay1() {
		return elementutills.displaySuccessfullElement(Warning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
		 
	}
	

	
}
