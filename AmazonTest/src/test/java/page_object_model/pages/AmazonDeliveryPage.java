package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AmazonDeliveryPage extends BasePage {

    @FindBy(id = "GLUXCityWithDistrictCityInput")
    private WebElement cityInput;

    @FindBy(id = "GLUXCityWithDistrictCityList")
    private WebElement cityList;

    @FindBy(id = "GLUXCityWithDistrict_DistrictInput")
    private WebElement areaInput;

    @FindBy(id = "GLUXCityWithDistrictApplyButton")
    private WebElement applyButton;

    public AmazonDeliveryPage(WebDriver driver) {
        super(driver);
    }

    public void selectCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cityInput)).sendKeys(city);

        wait.until(ExpectedConditions.visibilityOf(cityList));
        List<WebElement> cityOptions = cityList.findElements(By.tagName("li"));

        for (WebElement option : cityOptions) {
            if (option.getText().equalsIgnoreCase(city)) {
                new Actions(driver).moveToElement(option).click().perform();
                break;
            }
        }
    }

    public void enterArea(String area) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(areaInput)).sendKeys(area);
    }

    public void clickApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }
}
