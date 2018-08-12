package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;

	/*
	 * Constructor to get the driver from test where object is being created
	 * 
	 */

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Locating elements
	 * 
	 */

	@FindBy(how = How.ID, using = "email")
	WebElement emailOrPhone;
	
	@FindBy(name="pass")
	WebElement password;

}
