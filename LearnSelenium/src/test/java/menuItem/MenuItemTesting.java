package menuItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MenuItemTesting {
	String url="http://demo.guru99.com/test/login.html";
	String executablePath="\\src\\test\\resources\\executables";
	
  @Test
  public void testMenuItem() {
	  
	  System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + executablePath+"\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		WebElement seleniumDropdown = driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[1]/a"));
		
		seleniumDropdown.click();
		WebElement yahoo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[1]/ul/li[8]/a"));
		yahoo.click();
		
		String yahooText = driver.findElement(By.xpath("/html/body/div[2]/div[2]/font/strong")).getText();
		
		System.out.println(yahooText);
	  
  }
}
