package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils elementutills; 
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtils(driver);
	}
	@FindBy(linkText="HP LP3065")
	private WebElement searchResult;
	
	public void displaySearchResult() {
		elementutills.displaySuccessfullElement(searchResult,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	private WebElement noMatchMessage;
	
	public void displayMessage() {
		elementutills.displaySuccessfullElement(noMatchMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
}
