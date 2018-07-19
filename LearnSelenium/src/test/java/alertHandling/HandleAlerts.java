package alertHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandleAlerts {
	@Test
	public void do_Handle_Alerts() {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait exWait = new WebDriverWait(driver,200); 
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Alert alert1 = driver.switchTo().alert();
		
		System.out.println("+++++++++++++++++++++");
		System.out.println("Alert Text is: "+alert1.getText());
		System.out.println("+++++++++++++++++++++");
		
		SoftAssert sAssert = new SoftAssert();		
		sAssert.assertTrue(alert1.getText().contains("delete"));
		
		alert1.dismiss();		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		alert1.accept();
		
		Alert alert2 =  exWait.until(ExpectedConditions.alertIsPresent());	
		alert2.accept();
		
		sAssert.assertAll();
		
		

	}
}
