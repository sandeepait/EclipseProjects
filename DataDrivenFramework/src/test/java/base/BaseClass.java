package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.DbManager;
import utilities.MonitoringMail;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;

	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Config.load(fis);
				log.debug("Config properties file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("OR properties file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox Launched !!!");

			} else if (Config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Launched !!!");

			} else if (Config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("IE Launched !!!");

			}

			driver.get(Config.getProperty("testsiteurl"));
			log.debug("Navigating to : " + Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

			try {
				DbManager.setMysqlDbConnection();
				log.debug("Db Connection established !!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@AfterSuite
	public void teardown() {
		
		driver.quit();
		log.debug("Test Execution Completed");

	}
	
	public void click(String locator) {
		
		WebElement element = null;
		
		try {
			
		if(locator.endsWith("_XPATH")) {
			element= driver.findElement(By.xpath(OR.getProperty(locator)));			
		}else if (locator.endsWith("_CSS")) {
			element=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}else if (locator.endsWith("_ID")) {
			element=driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		element.click();
		
		log.debug("Clicking on an Element : "+locator);
		
	}catch(Throwable t) {
		log.debug("Error while clicking on an Element : "+locator);
		log.debug(t.getMessage());
		Assert.fail(t.getMessage());
	}
		
	}
	
	public void select(String locator, String value) {
		
		WebElement dropdown = null;
		
		try {
			
			if(locator.endsWith("_XPATH")) {
				dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
				
			} else if(locator.endsWith("_CSS")) {
				dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
				
			} else if(locator.endsWith("_ID")) {
				dropdown=driver.findElement(By.id(OR.getProperty(locator)));
				
			} 
			
			Select select = new Select(dropdown);
			select.selectByVisibleText(OR.getProperty(value));
			
			log.debug("Selecting an Element from : "+locator+" selected value as : "+value);
			
		}catch(Throwable t) {
			log.debug("Error while selecting an Element : "+locator);
			log.debug(t.getMessage());
			Assert.fail(t.getMessage());
			
		}
		
	}
	
	public boolean isElementPresent(String locator) {

		try {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator)));
		}
		log.debug("Finding Element : "+locator);
			return true;
		}catch(Throwable t) {
			
			log.debug("Error while Finding an Element : "+locator);
			log.debug(t.getMessage());
			Assert.fail(t.getMessage());
			return false;
		}

	}
	
public void type(String locator, String value) {

		
		try {
			if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}
			log.debug("Typing in an Element : "+locator+" entered the value as : "+value);
			
			}catch(Throwable t) {
				
				
				log.debug("Error while typing in an Element : "+locator);
				log.debug(t.getMessage());
				Assert.fail(t.getMessage());
				
			}
	}

	
	

}
