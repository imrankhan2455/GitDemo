package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initinalizeBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\khani\\Documents\\Udemy Java Selenium Course\\Projects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//this gives knowledge that the data.properties file exists in fis
		prop.load(fis);
		//this sets a string value for browser from the data file
		//we use to this to run mvn test -Dbrowser=chrome
		String browserName= System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		
		//if chrome is needed
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\khani\\Documents\\Udemy Java Selenium Course\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}
		
		//if firefox is needed 
		else if (browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\khani\\Documents\\Udemy Java Selenium Course\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//if IE is needed
		else if (browserName.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\khani\\Documents\\Udemy Java Selenium Course\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
		
		}
	
	/*
	
		public void getScreenShotPath() {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source, new File(destinationFile));
		}
		*/
}
