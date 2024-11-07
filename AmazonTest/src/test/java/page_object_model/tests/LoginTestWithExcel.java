package page_object_model.tests;

import org.testng.annotations.Test;
import page_object_model.pages.LoginPage;
import page_object_model.utilities.ExcelReader;
import page_object_model.utilities.Utilities;

public class LoginTestWithExcel extends Utilities {

    @Test
    public void test_completeLoginWithExcelData() {
        // Initialize the login page and load Amazon UAE
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadHomePage(); // Ensures Amazon UAE is loaded

        // Initialize ExcelReader with the path to your Excel file
        ExcelReader excelReader = new ExcelReader("/Users/dushanee/4y/QA/AmazonTest/src/main/resources/credentials.xlsx");

        // Read data from the Excel sheet
        String email = excelReader.getCellData("Sheet1", 1, 0);      // First row, first column for email
        String password = excelReader.getCellData("Sheet1", 1, 1);   // First row, second column for password

        // Perform login steps
        loginPage.clickSignInLink();
        loginPage.enterEmail(email);
        loginPage.clickContinue();
        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        // Close the ExcelReader
        excelReader.close();



        System.out.println("Login test completed with data from Excel.");
    }
}
