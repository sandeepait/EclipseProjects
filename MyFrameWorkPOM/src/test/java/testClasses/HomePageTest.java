package testClasses;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageClasses.HomePage;

public class HomePageTest extends BaseClass {
	
	@Test
	public void loginTest() {
		HomePage hp = new HomePage(myDriver);
		hp.setUserName("megaslain@gmail.com");
		hp.setPassword("dummy");
		hp.clickLogin();
	}

}
