package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;	
	By guru99Text = By.xpath("/html/body/div[2]/div/div/h3");
	
	//Constructor
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public String getText() {
		
		return (driver.findElement(guru99Text).getText());
		
	}
	

}
