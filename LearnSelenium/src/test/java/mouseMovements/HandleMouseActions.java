package mouseMovements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleMouseActions {
  @Test
  public void doHandleMouseActions() {
	  
	  String baseUrl = "http://demo.guru99.com/test/newtours/";
	  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  
	  WebElement link_Home = driver.findElement(By.linkText("Home"));
      WebElement td_Home = driver
              .findElement(By
              .xpath("//html/body/div"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr/td"
              + "/table/tbody/tr"));    
       
      Actions builder = new Actions(driver);
      Action mouseOverHome = builder
              .moveToElement(link_Home)
              .build();
      
            
      String bgColor = td_Home.getCssValue("background-color");
      System.out.println("Before hover: " + bgColor);        
      mouseOverHome.perform();        
      bgColor = td_Home.getCssValue("background-color");
      System.out.println("After hover: " + bgColor);
      driver.close();
	  
  }
}
