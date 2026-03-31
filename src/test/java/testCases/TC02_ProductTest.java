package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.loginPage;

public class TC02_ProductTest extends baseClass {

    @Test
    public void product_test() {
        try {
            loginPage lp = new loginPage(driver);
            lp.setUserName("standard_user");
            lp.setPassword("secret_sauce");
            lp.clkLogin();
            
            Thread.sleep(2000);
            
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            Thread.sleep(500);
            
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            Thread.sleep(500);
            
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Thread.sleep(500);
            
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            Thread.sleep(500);
            
            String count = driver.findElement(By.className("shopping_cart_badge")).getText();
            Assert.assertEquals(count, "4");
            
            driver.findElement(By.className("shopping_cart_link")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("first-name")).sendKeys("Upanshu");
            driver.findElement(By.id("last-name")).sendKeys("Gupta");
            driver.findElement(By.id("postal-code")).sendKeys("513121");
            Thread.sleep(500);
            
            driver.findElement(By.id("continue")).click();
            Thread.sleep(1000);
            
            driver.findElement(By.id("finish")).click();
            Thread.sleep(1000);
            
            String successMsg = driver.findElement(By.className("complete-header")).getText();
            Assert.assertEquals(successMsg, "Thank you for your order!");
            
            System.out.println("Test Passed");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}