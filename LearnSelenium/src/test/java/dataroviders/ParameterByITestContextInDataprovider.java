package dataroviders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByITestContextInDataprovider {

	WebDriver driver;
	String driverPath = "\\src\\test\\resources\\executables\\chromedriver.exe";
	String baseUrl = "https://www.google.com";

	@BeforeTest(groups = { "A", "B" })
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--extensions");
		
		driver = new ChromeDriver(options);
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "SearchProvider", groups = "A")
	public void testMethodA(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));

		searchText.sendKeys(searchKey);

		System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + "::::" + searchKey);
		searchText.clear();
		// verify correct value in searchbox
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

	}
	
	@Test(dataProvider = "SearchProvider", groups = "B")
	public void testMethodB(String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));

		searchText.sendKeys(searchKey);

		System.out.println("Welcome -> unknown user " + "Your search key is->" + searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + "::::" + searchKey);
		searchText.clear();
		// verify correct value in searchbox
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

	}
	
	/**
	 * Here the DAtaProvider will provide Object array on the basis on ITestContext
	 * @param c
	 * @return
	 */
	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataprovider(ITestContext c){
	Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
		if(group.equalsIgnoreCase("A")){
			groupArray = new Object[][] { 
					{ "Guru99", "India" }, 
					{ "Krishna", "UK" }, 
					{ "Bhupesh", "USA" } 
				};
		break;	
		}
			else if(group.equalsIgnoreCase("B"))
			{
			groupArray = new Object[][] { 
						{  "Canada" }, 
						{  "Russia" }, 
						{  "Japan" } 
					};
			}
		break;
	}
	return groupArray;		
	}
}
