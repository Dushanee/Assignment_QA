package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class AmazonElectronicsPage extends BasePage {

    @FindBy(xpath = "//li[@id='p_n_free_shipping_eligible/15397661031']//input[@type='checkbox']")
    private WebElement freeShippingCheckbox;

    @FindBy(xpath = "//li[@id='p_n_free_shipping_eligible/15397661031']//a")
    private WebElement freeShippingWrapper;

    public AmazonElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFreeShippingCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOf(freeShippingCheckbox));
            wait.until(ExpectedConditions.elementToBeClickable(freeShippingCheckbox));
            Actions actions = new Actions(driver);
            actions.moveToElement(freeShippingCheckbox).click().perform();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(freeShippingWrapper));
            wait.until(ExpectedConditions.elementToBeClickable(freeShippingWrapper));
            freeShippingWrapper.click();
        }
    }
}
