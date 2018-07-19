package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	WebDriver driver;
	Logger log =Logger.getLogger("devpinoyLogger");
	WebDriver wait;
	String browser="firefox";
	String url="http://demo.guru99.com/test/login.html";
	String executablePath="\\src\\test\\resources\\executables";
	
	
	@BeforeClass
	public void doSetIp() {
		
		if(browser=="firefox") {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + executablePath+"\\geckodriver.exe");
		driver = new FirefoxDriver();
		}else if (browser=="chrome") {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browser=="ie") {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new FirefoxDriver();
		
		}
		
		
		driver.manage().window().maximize();
		driver.get(url);

		log.debug("Opening the url");

	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
