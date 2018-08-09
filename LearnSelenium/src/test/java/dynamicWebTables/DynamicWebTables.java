package dynamicWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebTables {

	WebDriver driver;

	@Test
	public void handleDynamicWebTables() {

		String url = "https://money.rediff.com/index.html";
		String output = "";
		String output1 = "";
		String output2 = "";
		int numberOfElements;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		int WebElementSize = driver.findElements(By.xpath("//a[@href='//money.rediff.com/indices/nse/NIFTY-50']"))
				.size();

		if (WebElementSize == 1) {

			output = driver
					.findElement(By.xpath("//a[@href='//money.rediff.com/indices/nse/NIFTY-50']/following::li[1]"))
					.getText();
			
			output1 = driver
					.findElement(By.xpath("//a[@href='//money.rediff.com/indices/nse/NIFTY-50']/following::li[2]"))
					.getText();
			
			output2 = driver
					.findElement(By.xpath("//a[@href='//money.rediff.com/indices/nse/NIFTY-50']/following::li[3]"))
					.getText();
			
			System.out.println("Nifty 50 index price today is at: "+output);
			System.out.println("Nifty 50 index Price change is : "+output1);
			System.out.println("Nifty 50 index Price % change is: "+output2);
		} else {
			System.out.println("Nifty Not Found");
		}

		
		numberOfElements = driver.findElements(By.xpath("//*[@id=\"div_nseindices\"]/div/div/div/ul")).size();
		
		System.out.println("Size is: "+numberOfElements);
	}
}
