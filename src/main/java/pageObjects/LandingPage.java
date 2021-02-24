package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin= By.cssSelector("a[href*='sign_in']");
	By getTitle = By.cssSelector(".text-center>h2");
	By listItems = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	
	
	
	
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		//we need to put this to let the driver know that driver is driver2 so it gets life 
		this.driver=driver2;
	}





	public LoginPage getLogin() {
		
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		
		return driver.findElement(getTitle);
		
	}
	
	public WebElement listItems() {
		
		return driver.findElement(listItems);
		
	}
		
		
	
	
}
