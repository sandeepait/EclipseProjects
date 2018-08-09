package dynamicWebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandleWebTables {

	WebDriver driver;
	String browser = "firefox";

	@Test
	public void doHandleDynamicWebTables() {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().maximize();
		
		List<WebElement> col = driver.findElements(By.xpath("/html/body/div[1]/div[9]/div[9]/div[1]/div[2]/ul[1]/li"));
		
		List<WebElement> row = driver.findElements(By.xpath("/html/body/div[1]/div[9]/div[9]/div[1]/div[2]/ul[2]"));
		System.out.println(col.size());
		
		System.out.println(row.size());

	}

}
