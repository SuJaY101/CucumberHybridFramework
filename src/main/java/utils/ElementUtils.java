package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
		
	}
	public void clickOnElement(WebElement element,long durationInSeconds) {	
	WebElement webelement = waitForElement(element,durationInSeconds);
	webelement.click();
	}
	
public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
	WebElement webelement = waitForElement(element,durationInSeconds);
	webelement.click();
	webelement.clear();
	webelement.sendKeys(textToBeTyped);
}

public WebElement waitForElement(WebElement element,long durationInSeconds) {
	WebElement webelement=null;
	try {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
	webelement= wait.until(ExpectedConditions.elementToBeClickable(element));	
}catch(Throwable e) {
	e.printStackTrace();
}
	return webelement;
}

public void selectOptionInDropDown(WebElement element,String dropDownOption,long durationInSeconds) {
	
	WebElement webelement = waitForElement(element,durationInSeconds);
	Select select=new Select(element);
	select.deselectByVisibleText(dropDownOption);
}
public void acceptAlert(long durationInSeconds) {
	Alert alert=waitForAlert(durationInSeconds);
			alert.accept();
	
}
public void dismissAlert(long durationInSeconds) {
	Alert alert=waitForAlert(durationInSeconds);
			alert.dismiss();
	
}
public Alert waitForAlert(long durationInSeconds) {
	Alert alert = null;
	try {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
	alert = wait.until(ExpectedConditions.alertIsPresent());
}catch(Throwable e) {
	e.printStackTrace();
}
	return alert;
}
public void mouseOverAndClick(WebElement element,long durationInSeconds) {	
	
	WebElement webelement = waitForVisibilityOfElement(element,durationInSeconds);
	
	Actions actions=new Actions(driver);
	actions.moveToElement(webelement).click().build().perform();

}
public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {	
	WebElement webelement=null;
	try {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
	 webelement = wait.until(ExpectedConditions.visibilityOf(element));
	}catch(Throwable e) {
		e.printStackTrace();
	}
	return webelement;

} 

public void javaScriptClick(WebElement element,long durationInSeconds) {
	WebElement webelement = waitForVisibilityOfElement(element,durationInSeconds);
	 JavascriptExecutor jse = ((JavascriptExecutor)driver);
	 jse.executeScript("arguments[0].click();",webelement);
} 

public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
	WebElement webelement = waitForVisibilityOfElement(element,durationInSeconds);
	 JavascriptExecutor jse = ((JavascriptExecutor)driver);
	 jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webelement);
}

public boolean displaySuccessfullElement(WebElement element, long durationInSeconds) {
	try {
	WebElement webelement = waitForVisibilityOfElement(element,durationInSeconds);
	webelement.isDisplayed();
}catch(Throwable e) {
	return false;
}
	return false;



}
}