package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage {
	WebDriver driver;
	private ElementUtils elementutills;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtils(driver);
	}
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[1]/a")
	private WebElement successfullLogin;
	
	public boolean loginSuccessfull() {
		return elementutills.displaySuccessfullElement(successfullLogin,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
