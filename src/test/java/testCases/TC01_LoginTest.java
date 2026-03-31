package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import PageObject.loginPage;
import org.testng.Assert;
import org.openqa.selenium.By;

public class TC01_LoginTest extends baseClass {
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", "Valid"},
            {"locked_out_user", "secret_sauce", "Invalid"},
            {"standard_user", "secret_sauce", "Valid"},
            {"problem_user", "wrong_pass", "Invalid"}
        };
    }
    
    @Test(dataProvider = "loginData")
    public void verify_login(String username, String password, String expected) {
        driver.get("https://www.saucedemo.com/");
        
        loginPage lp = new loginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clkLogin();
        
        if(expected.equals("Valid")) {
            boolean status = driver.getCurrentUrl().contains("inventory");
            Assert.assertTrue(status, "Valid login failed for: " + username);
        } else {
            String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertTrue(error.contains("Epic sadface"), "Expected error not shown for: " + username);
        }
    }
}