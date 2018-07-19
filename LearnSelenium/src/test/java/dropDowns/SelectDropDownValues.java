package dropDowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDownValues {
	@Test
	public void doSelectDropDownValues() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebDriverWait exWait = new WebDriverWait(driver,200);
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		
		String secondUrl= "http://jsbin.com/osebed/2";

		driver.get(baseUrl);
		WebElement countryDpElement = driver.findElement(By.name("country"));

		Select dpCountry = new Select(countryDpElement);

		dpCountry.selectByIndex(5);
		Thread.sleep(5);
		dpCountry.selectByValue("INDIA");
		Thread.sleep(5);
		dpCountry.selectByVisibleText("FIJI");
		
		driver.get(secondUrl);
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		
		driver.close();

	}
}
