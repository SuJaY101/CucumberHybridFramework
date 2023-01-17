package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	private String screenshotName;
	@Before
	public void setup() {
	Properties prop=ConfigReader.initalizeProperties();
	driver=DriverFactory.initializeBrowser(prop.getProperty("browser"));	
	driver.get(prop.getProperty("url"));
	} 
	
	@After
	public void teardown(Scenario scenario) {
		scenario.getName().replaceAll(" ","_");
		if(scenario.isFailed())
		{
		byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	
		
		scenario.attach(srcScreenshot,"image/png",screenshotName);
		}
		
		driver.quit();
	}
}
 