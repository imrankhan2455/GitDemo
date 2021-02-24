package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By getEmail = By.id("user_email");
	By password = By.cssSelector("[type='password']");
	By submit = By.cssSelector("[type='submit']");
	By forgotPassword = By.cssSelector("[href*='index.php']");
	
	
	
	
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver2;
	}





	public ForgotPasswordPage forgotPassword() {
		
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage();
		
	}
	
	public WebElement getEmail() {
		
		return driver.findElement(getEmail);
	}
	
	public WebElement password() {
		
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		
		return driver.findElement(submit);
	}
}
