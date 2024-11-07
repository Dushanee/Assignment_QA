package page_object_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_object_model.pages.AmazonHomePage;
import page_object_model.pages.AmazonClothingPage;
import page_object_model.pages.AmazonElectronicsPage;
import page_object_model.utilities.Utilities;

public class AmazonTest extends Utilities {

    @Test
    public void test_searchLaptopsWithFreeShipping() {
        AmazonHomePage homePage = PageFactory.initElements(driver, AmazonHomePage.class);
        homePage.loadHomePage();

        homePage.selectCategoryUsingXPath("search-alias=electronics");
        homePage.typeSearchText("Laptops");

        AmazonElectronicsPage electronicsPage = homePage.clickSearchButton();
        electronicsPage.scrollPage(0, 200);
        electronicsPage.selectFreeShippingCheckbox();
    }

    @Test
    public void test_navigateToAllClothing() {
        AmazonHomePage homePage = PageFactory.initElements(driver, AmazonHomePage.class);
        AmazonClothingPage clothingPage = PageFactory.initElements(driver, AmazonClothingPage.class);

        homePage.loadHomePage();
        homePage.openHamburgerMenu();

        clothingPage.selectWomensClothing();
        clothingPage.selectAllClothing();
    }
}
