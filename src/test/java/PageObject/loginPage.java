package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class loginPage extends basePagee{
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn;
	
	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pass) {
		
		txtPassword.sendKeys(pass);
	}
	
	public void clkLogin() {
		
		loginBtn.click();
	}
}
