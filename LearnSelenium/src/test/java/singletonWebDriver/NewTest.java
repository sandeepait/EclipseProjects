package singletonWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	private SingleTonWebDriver instace = SingleTonWebDriver.instantiateDriver();
	private WebDriver driver = instace.getDriver();
	
  @Test
  public void firstTest() {
	  driver.get("http://gmail.com");
	  driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("TestEmail");
	  
	  
  }
}
