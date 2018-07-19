package dataroviders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByDataprovider {
	
	 WebDriver driver;
	 String driverPath = "\\src\\test\\resources\\executables\\geckodriver.exe";
	 String baseUrl= "http://www.google.com";   
	    
	    @BeforeTest
  public void setup() {
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+driverPath);
	    	driver=new FirefoxDriver();
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	driver.get(baseUrl);
  }
	    
	    /** Test case to verify google search box
	     * @param author
	     * @param searchKey
	     * @throws InterruptedException
	     */
	    
	    @Test(dataProvider="SearchProvider")
	    public void testMethod(String author,String searchKey) throws InterruptedException{
	    {
	        WebElement searchText = driver.findElement(By.name("q"));
	        //search value in google searchbox
	        searchText.sendKeys(searchKey);
	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	        Thread.sleep(3000);
	        String testValue = searchText.getAttribute("value");
	        System.out.println(testValue +"::::"+searchKey);
	        searchText.clear();
	        //Verify if the value in google search box is correct
	        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	    }
	    }
	    /**
	     * @return Object[][] where first column contains 'author'
	     * and second column contains 'searchKey'
	     */

	    @DataProvider(name="SearchProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "Guru99", "India" },
	            { "Krishna", "UK" },
	            { "Bhupesh", "USA" }
	        };

	    }
}
