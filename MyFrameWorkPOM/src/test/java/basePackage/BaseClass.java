package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver myDriver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait explicitWait;

	/*
	 * Initialize testing by loading config files, launching browser and doing other
	 * initial setup
	 * 
	 */
	@BeforeSuite
	public void initializeTest() {

		if (myDriver == null) {

			/*
			 * Initializing the fis to config.properties loading config.properties file
			 */

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properites\\Config.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.debug("Config File not found");
			}

			try {
				config.load(fis);
				log.debug("Config File Loaded");
			} catch (IOException e) {
				e.printStackTrace();
				log.debug("Config File not Loaded");
			}

			/*
			 * Launching browser based on what is defined in properties file
			 */

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
				myDriver = new ChromeDriver();
				log.debug("Chrome Browser Launched!");
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\geckodriver.exe");
				myDriver = new FirefoxDriver();
				log.debug("Firefox Browser Launched!");
			} else if (config.getProperty("browser").equals("internetexplorer")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\IEDriverServer.exe");
				myDriver = new FirefoxDriver();
				log.debug("Intenet Explorer Browser Launched!");
			}

			/*
			 * maximize, implicit wait, open url
			 * 
			 */

			myDriver.manage().window().maximize();
			myDriver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),
					TimeUnit.SECONDS);
			myDriver.navigate().to(config.getProperty("baseUrl"));

			log.debug("Navigated to the Web Page: " + myDriver.getTitle());
		}

	}

	/*
	 * Closing down the browser after testing has been finished
	 */

	@AfterSuite
	public void windUp() {
		myDriver.quit();
		log.debug("Test Execution Completed");

	}

	/*
	 * Defining Keywords
	 * 
	 */
	
	

}
