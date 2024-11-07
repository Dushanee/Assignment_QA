package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import page_object_model.utilities.Utilities;

public class AmazonHomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "searchDropdownBox")
    private WebElement categoryDropdown;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement hamburgerMenu;

    @FindBy(id = "glow-ingress-block")
    private WebElement deliverToOption;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void loadHomePage() {
        driver.get(Utilities.BASE_URL); // Using centralized URL
    }

    public void selectCategoryUsingXPath(String categoryValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownFacade = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-dropdown-card")));
        dropdownFacade.click();
        WebElement categoryOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//select[@id='searchDropdownBox']/option[@value='" + categoryValue + "']")));
        categoryOption.click();
    }

    public void typeSearchText(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(searchText);
    }

    public AmazonElectronicsPage clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new AmazonElectronicsPage(driver);
    }

    public void openHamburgerMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }

    public AmazonDeliveryPage selectDeliverToOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deliverToOption)).click();
        return new AmazonDeliveryPage(driver);
    }
}
