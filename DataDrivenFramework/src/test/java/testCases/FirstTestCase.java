package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class FirstTestCase extends BaseClass{
	
	@Test()
	public void loginAsBankManager() throws InterruptedException {
		
		click("bankManagerLoginBtn_CSS");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"),"Add Customer button not found");
		Assert.fail("Failing Bank Manager Login Test");
	}


}
