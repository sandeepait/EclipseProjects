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
	
	@FindBy(how=How.XPATH, using = "//*[@id='loginbutton']")
	WebElement loginButton;
	
	
	
	//Clicking on Login Button
	
	public void clickLogin() {
		loginButton.click();
	}
	
	//input user name into the field
	
	public void setUserName(String username) {
		emailOrPhone.sendKeys(username);
	}
	
	//input password into the field
	
	public void setPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

}
