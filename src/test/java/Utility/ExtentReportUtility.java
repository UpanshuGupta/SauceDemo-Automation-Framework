package Utility;

import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testCases.baseClass;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtility implements ITestListener {
    ExtentReports extent;
    ExtentTest test;
    String path; 

    public void onStart(ITestContext context) {
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        path = System.getProperty("user.dir") + "\\reports\\Test-Report-" + time + ".html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("SauceDemo Report");
        reporter.config().setReportName("Functional Testing");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public void onTestStart(ITestResult result) {
        String username = result.getParameters()[0].toString();
        test = extent.createTest("Login Test: " + username);
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
        
        String username = result.getParameters()[0].toString();
        
        String imgPath = new baseClass().captureScreen(username);
        
        try {
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            System.out.println("Image attachment failed: " + e.getMessage());
        }
    }

    public void onFinish(ITestContext context) {
        extent.flush(); 
        
       
        File reportFile = new File(path);
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("Desktop is not supported, please open report manually at: " + path);
            }
        } catch (IOException e) {
            System.out.println("Auto-open failed: " + e.getMessage());
        }
    }
}