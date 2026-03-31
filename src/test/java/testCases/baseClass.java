package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class baseClass {
    public static WebDriver driver; 
    
    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String br) {
        switch(br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser");
                driver = new ChromeDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    
    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
    
    public String captureScreen(String name) {
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String imgName = name + "_" + time + ".png";
        String destPath = System.getProperty("user.dir") + "\\screenShots\\" + imgName;
        
        try {
            File dir = new File(System.getProperty("user.dir") + "\\screenShots");
            if(!dir.exists()) dir.mkdirs();
            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(destPath));
        } catch(IOException e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }
        return destPath; 
    }
}

