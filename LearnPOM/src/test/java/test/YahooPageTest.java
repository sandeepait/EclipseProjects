package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.YahooPage;

public class YahooPageTest extends BaseClass {
	
	YahooPage yPageTest;
 
	@Test(priority=1)
  public void yahooPageTest() {
		
		yPageTest=new YahooPage(driver);
		
		log.debug("YahooPage constructor called");
		
		yPageTest.clickSelenium();
		
		log.debug("Clicked on Selenium");
		
		yPageTest.clickYahoo();
		
		log.debug("Clicked on Yahoo");
		
	Assert.assertTrue(yPageTest.yahooPageText().equals("This is DEMO site for TESTING purpose"));
		
		log.debug("text found: "+yPageTest.yahooPageText());
		
  }
}
