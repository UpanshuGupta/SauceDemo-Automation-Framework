package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class basePagee {
	
	WebDriver driver;
	public basePagee(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
}
