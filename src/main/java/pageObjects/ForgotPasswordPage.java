package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	

	
	public WebDriver driver;
	
	By getEmail = By.id("user_email");
	By sendMeInstructions = By.name("commit");
	

	
	public void LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver2;
	}





	public ForgotPasswordPage forgotPassword() {
		
		By forgotPassword = null;
		driver.findElement(forgotPassword).click();
		ForgotPasswordPage fp= new ForgotPasswordPage();
		return fp;
	}
	
	public WebElement getEmail() {
		
		return driver.findElement(getEmail);
	}
	
	public WebElement sendMeInstruction() {
		
		return driver.findElement(sendMeInstructions);
	}
}
