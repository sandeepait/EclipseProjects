package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageByPageFactory {
	
	/**

     * All WebElements are identified by @FindBy annotation

     */
	
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement 	emailId;
	
	@FindBy(id="passwd")
	WebElement 	passWd;
	
	@FindBy(id="SubmitLogin")
	WebElement 	submitLogin;
	
   public LoginPageByPageFactory(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	   
   }
   
   //Set user name in textbox

   public void setUserName(String strUserName){

	   emailId.sendKeys(strUserName);

       

   }
   
   //Set password in password textbox

   public void setPassword(String strPassword){

	   passWd.sendKeys(strPassword);
       

   }
 //Click on login button

   public void clickLogin(){

	   submitLogin.click();

   }
   
   /**

    * This POM method will be exposed in test case to login in the application

    * @param strUserName

    * @param strPasword

    * @return

    */

   public void loginToGuru99(String strUserName,String strPasword){

       //Fill user name

       this.setUserName(strUserName);

       //Fill password

       this.setPassword(strPasword);

       //Click Login button

       this.clickLogin();

               

   }

}
