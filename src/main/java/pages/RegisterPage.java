package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
WebDriver driver;
private ElementUtils elementutills;  
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtils(driver);
	}
	@FindBy(name="firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		elementutills.typeTextIntoElement(firstNameField, firstNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastName(String lastNameText) {
		elementutills.typeTextIntoElement(lastNameField, lastNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enteremail(String emailText) {
		elementutills.typeTextIntoElement(emailField, emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void entertelephone(String telephoneText) {
		elementutills.typeTextIntoElement(telephoneField, telephoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterpassword(String passwordText) {
		elementutills.typeTextIntoElement(passwordField, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	public void enterConPassword(String confirmText) {
		elementutills.typeTextIntoElement(confirmPasswordField, confirmText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	public void selectPrivacyPolicy() {
		elementutills.clickOnElement(privacyPolicyOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement continueButton;
	
	public void clickOnContinue() {
		elementutills.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	private WebElement newsletter;
	
	public void selectNewsletter() {
		elementutills.clickOnElement(newsletter,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
	private WebElement warningmsg;
	
	public void warnMessage() {
		elementutills.displaySuccessfullElement(warningmsg,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
}
	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	private WebElement duplicatemsg;
	
	public void DuplicateMessage() {
		elementutills.displaySuccessfullElement(duplicatemsg,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
	}
