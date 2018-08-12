package testClasses;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageClasses.HomePage;

public class HomePageTest extends BaseClass {
	
	@Test
	public void loginTest() {
		
		log.debug("creating homepage object");
		HomePage hp = new HomePage(myDriver);
		log.debug("created homepage object");
		
		String userName = config.getProperty("userName");
		
		log.debug("Setting up username");
		hp.setUserName(userName);
		log.debug("username set up");
		
		String userPassword = config.getProperty("userPassword");
		log.debug("Setting up password");
		hp.setPassword(userPassword);
		log.debug("password entered");
		
		log.debug("clicking on login button");
		hp.clickLogin();
		log.debug("clicked on login button");
		
	}

}
