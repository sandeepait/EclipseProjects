package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YahooPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/nav/div/div/ul/li[1]/a")
	WebElement seleniumDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/nav/div/div/ul/li[1]/ul/li[8]/a")
	WebElement yahoo;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/font/strong")
	WebElement yahooText;
	
	

	public YahooPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	public void clickSelenium() {
		seleniumDropdown.click();
		
			}
	
	public void clickYahoo() {
		yahoo.click();
		
			}
	
	
	
	
	public String yahooPageText() {
		return yahooText.getText();
	}


}
