package page_object_model.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_object_model.pages.AmazonHomePage;
import page_object_model.pages.AmazonDeliveryPage;
import page_object_model.utilities.ExcelReader;
import page_object_model.utilities.Utilities;

public class DeliveryTestWithExcel extends Utilities {

    @DataProvider(name = "locationDataProvider")
    public Object[][] locationDataProvider() {
        String excelPath = "/Users/dushanee/4y/QA/AmazonTest/src/main/resources/cities.xlsx";
        ExcelReader excelReader = new ExcelReader(excelPath);

        String sheetName = "Sheet1";
        int rowCount = excelReader.getRowCount(sheetName);
        int colCount = excelReader.getColumnCount(sheetName, 1);

        Object[][] locationData = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            locationData[i - 1][0] = excelReader.getCellData(sheetName, i, 0);
            locationData[i - 1][1] = excelReader.getCellData(sheetName, i, 1);
        }

        excelReader.close();
        return locationData;
    }

    @Test(dataProvider = "locationDataProvider")
    public void test_selectDeliveryLocation(String city, String area) {
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.loadHomePage();

        AmazonDeliveryPage deliveryPage = homePage.selectDeliverToOption();
        deliveryPage.selectCity(city);
        deliveryPage.enterArea(area);
        deliveryPage.clickApplyButton();
    }
}
