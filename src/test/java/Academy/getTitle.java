package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class getTitle extends base{
	
	public WebDriver driver;
	
	//public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		
		driver = initinalizeBrowser();
	//	Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
	//	Log.info("Navigated to home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		//we added an argument of "driver inside then we created an constructor to give life to driver"
		LandingPage l = new LandingPage(driver);

		String text1 = "FEATURED COURSES";
		String course = l.getTitle().getText();
		
		Assert.assertEquals(course, text1);
	//	Log.info("Successfully Validated text message");
		
		Assert.assertTrue(l.listItems().isDisplayed());
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
