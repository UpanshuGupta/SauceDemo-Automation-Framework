package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
    
    WebDriver driver;
    
    public productPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;
    
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;
    
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;
    
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement jacket;
    
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;
    
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;
    
    public void addBackpack() {
        backpack.click();
    }
    
    public void addBikeLight() {
        bikeLight.click();
    }
    
    public void addTshirt() {
        tshirt.click();
    }
    
    public void addJacket() {
        jacket.click();
    }
    
    public void goToCart() {
        cartIcon.click();
    }
    
    public String getCartCount() {
        return cartBadge.getText();
    }
}