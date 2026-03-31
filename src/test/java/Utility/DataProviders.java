package Utility;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
    
    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "\\testData\\Assignment2.xlsx";
        ExcelUtility xl = new ExcelUtility(path);
        
        int rows = xl.getRowCount("Sheet1");
      
        Object[][] data = new Object[rows][3];
        
        for(int i = 1; i <= rows; i++) {
            data[i-1][0] = xl.getCellData("Sheet1", i, 0);
            data[i-1][1] = xl.getCellData("Sheet1", i, 1);
            data[i-1][2] = xl.getCellData("Sheet1", i, 2);
        }
        return data;
    }
}