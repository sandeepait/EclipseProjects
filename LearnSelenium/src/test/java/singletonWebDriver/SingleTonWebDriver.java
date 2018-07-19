package singletonWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SingleTonWebDriver {
	
	private static SingleTonWebDriver instance = null;
	private WebDriver driver;
	
	private SingleTonWebDriver() {
		
	}
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "F:\\Adhyayan\\Selenium\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static SingleTonWebDriver instantiateDriver() {
		
		if(instance == null) {
		 instance = new  SingleTonWebDriver();
		}
		return instance;
	}
	
  
}
