package findAllLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FindAllLinksInPage {
	public String url="http://englishpdfdocs.com/";
	public String sectionXPath = "//div[2]/div/div[3]";
	
	
  @Test
  public void FindingAllLinksInPage() {
	  
	  System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	WebDriverWait wait=new WebDriverWait(driver,5);
		
		driver.get(url);
		
		WebElement linkElement = driver.findElement(By.xpath(sectionXPath));
		
		List<WebElement> allWebLinks = linkElement.findElements(By.tagName("a"));
		
		for(WebElement webLink:allWebLinks) {
			System.out.println("Link:- "+webLink.getAttribute("href")+"       ____Link_Text:- "+webLink.getText());
			
		}
		
		

  }
}
