package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class overviewPage extends basePagee {
    

    
    public overviewPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "finish")
    WebElement finishBtn;
    
    @FindBy(className = "complete-header")
    WebElement successMessage;
    
    public void clickFinish() {
        finishBtn.click();
    }
    
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}