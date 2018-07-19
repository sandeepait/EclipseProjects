package urlBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowseToURL {

	public WebDriver driver;
	public String browser = "Firefox";
	public String url = "https://gmail.com";
	public WebDriverWait wait;

	@Test
	public void browseGivenURL() {

		if (browser == "Firefox") {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browser == "Chrome") {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			driver = new FirefoxDriver();

		} else if (browser == "internetexplorer") {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");

			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);

		// Enter Email id
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("megaslain@gmail.com");
		// Click Next
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/content"))
				.click();

		// Enter Password
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"//*[@name='password']"))))
				.sendKeys("Doctor1986");
	
		 //Click next 
		 driver.findElement(By.xpath(
		 "/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/content"
		 )) .click();
		
		 Assert.assertTrue(driver.getTitle().contains("megaslain@gmail.com"));
		
	}

}
