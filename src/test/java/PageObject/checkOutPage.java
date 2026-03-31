package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends basePagee{
    
   
    
    public checkOutPage(WebDriver driver) {
        
    	super(driver);
    }
    
    @FindBy(id = "first-name")
    WebElement firstName;
    
    @FindBy(id = "last-name")
    WebElement lastName;
    
    @FindBy(id = "postal-code")
    WebElement postalCode;
    
    @FindBy(id = "continue")
    WebElement continueBtn;
    
    public void enterFirstName(String name) {
        firstName.sendKeys(name);
    }
    
    public void enterLastName(String name) {
        lastName.sendKeys(name);
    }
    
    public void enterPostalCode(String code) {
        postalCode.sendKeys(code);
    }
    
    public void clickContinue() {
        continueBtn.click();
    }
}