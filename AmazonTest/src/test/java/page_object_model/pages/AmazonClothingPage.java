package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonClothingPage extends BasePage {

    @FindBy(xpath = "//div[text()=\"Women's Fashion\"]")
    private WebElement womensFashionMenu;

    @FindBy(xpath = "//a[text()='All Clothing']")
    private WebElement allClothingLink;

    public AmazonClothingPage(WebDriver driver) {
        super(driver);
    }

    public void selectWomensClothing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(womensFashionMenu)).click();
    }

    public void selectAllClothing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allClothingLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All Clothing']")));
        wait.until(ExpectedConditions.elementToBeClickable(allClothingLink)).click();
    }
}
