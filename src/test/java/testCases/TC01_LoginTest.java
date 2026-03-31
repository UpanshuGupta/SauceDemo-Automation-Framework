package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import PageObject.loginPage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC01_LoginTest extends baseClass {
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", "Valid"},
            {"locked_out_user", "secret_sauce", "Invalid"},
            {"standard_user", "wrong_password", "Invalid"},
            {"problem_user", "secret_sauce", "Valid"}
        };
    }

    @Test(dataProvider = "loginData")
    public void verify_login(String username, String password, String expected) {
        driver.get("https://www.saucedemo.com/");
        
        loginPage lp = new loginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clkLogin();
        
        if(expected.equalsIgnoreCase("Valid")) {
            boolean status = driver.getCurrentUrl().contains("inventory");
            Assert.assertTrue(status, "Login failed for valid user: " + username);
        } 
        else {
            // No try-catch here. Let TestNG handle the error if element is missing.
            WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
            Assert.assertTrue(errorMsg.isDisplayed(), "Error message not visible for: " + username);
        }
    }
}