package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	//private static Logger log = LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver = initinalizeBrowser();
		
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver.get(prop.getProperty("url"));
		//we added an argument of "driver inside then we created an constructor to give life to driver"
		LandingPage l = new LandingPage(driver);
		
		LoginPage lp= (LoginPage) l.getLogin(); // we are manipulating the login button object we have created in the page object
		//LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.password().sendKeys(password);
		lp.submit().click();
		
		//ForgotPasswordPage fp = (ForgotPasswordPage) lp.password();
		//fp.getEmail().sendKeys("Hello");
		//fp.sendMeInstruction().click();
		
	//	Log.info("submit is clicked");
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//rows stands for how many different data types test should run
		//columns stands for how many values per run
		//number starts from 0
		Object [][] data = new Object[2][2];
		
		data[0][0]="nonrestricted@qw.com";
		data[0][1]="12345";
		
		data[1][0]="restricteddata@gmail.com";
		data[1][1]="12345";
		
		return data;
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
