package page_object_model.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object_model.pages.LoginPage;
import page_object_model.utilities.ExcelReader;
import page_object_model.utilities.Utilities;

public class LoginTestWithDataProvider extends Utilities {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        String excelPath = "/Users/dushanee/4y/QA/AmazonTest/src/main/resources/credentials.xlsx";
        ExcelReader excelReader = new ExcelReader(excelPath);

        int rowCount = excelReader.getRowCount("Sheet1");
        int colCount = excelReader.getColumnCount("Sheet1", 1);

        Object[][] loginData = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            loginData[i - 1][0] = excelReader.getCellData("Sheet1", i, 0);
            loginData[i - 1][1] = excelReader.getCellData("Sheet1", i, 1);
        }

        excelReader.close();
        return loginData;
    }

    @Test(dataProvider = "loginDataProvider")
    public void test_loginWithMultipleCredentials(String email, String password) {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadHomePage();

        loginPage.clickSignInLink();
        loginPage.enterEmail(email);
        loginPage.clickContinue();
        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        softAssert.assertTrue(loginPage.isAccountLinkVisible(), "Account link should be visible after login.");

        System.out.println("Login test completed with email: " + email);

        softAssert.assertAll();
    }
}
