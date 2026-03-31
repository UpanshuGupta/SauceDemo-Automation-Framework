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
        String tName = (result.getParameters().length > 0) ? result.getParameters()[0].toString() : result.getName();
        test = extent.createTest(tName);
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        
        try {
            String tName = (result.getParameters().length > 0) ? result.getParameters()[0].toString() : result.getName();
            String imgPath = new baseClass().captureScreen(tName);
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    public void onFinish(ITestContext context) {
        if(extent != null) {
            extent.flush(); 
        }
        
        File reportFile = new File(path);
        try {
            if (Desktop.isDesktopSupported() && reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}