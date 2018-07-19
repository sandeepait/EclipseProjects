package test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Login;

public class LoginTest extends BaseClass {

	Login objLogin;
	HomePage objHomePage;

	

	/**
	 * 
	 * This test case will login in http://demo.guru99.com/V4/
	 * 
	 * Verify login page title as guru99 bank
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 */

	@Test(priority = 2)
	public void testHomePage() {

		objLogin = new Login(driver);
		String strLoginPageTitle = objLogin.getLoginTitle();

		log.debug("LoginTitle: " + strLoginPageTitle);

		Assert.assertEquals(strLoginPageTitle, "ALREADY REGISTERED?");

		log.debug("Test for login title: ");

		objLogin.loginToGuru99("mngr138120", "zenubUp");

		log.debug("logged in");

		objHomePage = new HomePage(driver);

		String homePageTitle = objHomePage.getText();

		log.debug("home page title: " + homePageTitle);

		Assert.assertEquals(homePageTitle, "Successfully Logged in...");

		log.debug("verifying home page title");

	}
}
