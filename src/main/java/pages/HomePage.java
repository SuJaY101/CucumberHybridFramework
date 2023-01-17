package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutills;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		  elementutills = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement  loginOption;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	private WebElement register;
	
	@FindBy(name="search")
	private WebElement searchOption;
	
	@FindBy(xpath=("//*[@id=\"search\"]/span/button"))
	private WebElement searchClick;

	
	public void clickOnMyAccount() {
		elementutills.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage clickOnLogin() {
		elementutills.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	public RegisterPage clickRegisterButton() {
		elementutills.clickOnElement(register,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterSearchProduct(String product) {
		elementutills.typeTextIntoElement(searchOption, product,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}	
	
	public SearchResultPage clickOnSearchButton() {
		elementutills.clickOnElement(searchClick,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
		
	}
}
