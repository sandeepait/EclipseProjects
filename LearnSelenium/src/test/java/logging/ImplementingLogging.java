package logging;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplementingLogging {
  
	WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
	
		
	@BeforeTest
  public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
  }
	@Test
	public void firstLoggingTest() {
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		
		log.debug("First url launched: "+title);
		
		driver.get("http://www.yahoo.com");
		title = driver.getTitle();
		
		log.debug("Second url launched: "+title);
		
		driver.get("http://www.bing.com");
		title = driver.getTitle();
		
		log.debug("third url launched: "+title);
		
		
		
	}
}
