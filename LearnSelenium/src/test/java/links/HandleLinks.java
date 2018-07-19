package links;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandleLinks {
  @Test
  public void doHandleLinks() {
	  
	  System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		String url = "http://demo.guru99.com/test/link.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("click here")).click();
		System.out.println("Title of navigated url is: "+driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='http://www.fb.com']")).click();
		System.out.println("Title of navigated url is: "+driver.getTitle());
		driver.navigate().back();
		driver.close();
  }
}
