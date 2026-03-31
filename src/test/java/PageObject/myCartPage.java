package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myCartPage {
    
    WebDriver driver;
    
    public myCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    
    public void clickCheckout() {
        checkoutBtn.click();
    }
}