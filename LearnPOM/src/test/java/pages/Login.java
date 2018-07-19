package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;

	By user99GuruName = By.name("email");
	By password99Guru = By.name("passwd");
	By titleText = By.className("page-subheading");
	By login = By.id("SubmitLogin");
	// Constructor
	public Login(WebDriver driver) {

		this.driver = driver;

	}

	// setUserName
	public void setUsername(String strUserName) {
		driver.findElement(user99GuruName).sendKeys(strUserName);

	}

	// setPassword
	public void setPassword(String strPwd) {
		driver.findElement(password99Guru).sendKeys(strPwd);

	}

	// click login
	public void clickLogin() {
		driver.findElement(login).click();
	}

	// Get the title of Login Page

	public String getLoginTitle() {

		return driver.findElement(titleText).getText();

	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 * 
	 */
	public void loginToGuru99(String strUserName, String strPasword) {

		// Fill user name
		this.setUsername(strUserName);

		// Fill password
		this.setPassword(strPasword);

		// Click Login button
		this.clickLogin();

	}

}
