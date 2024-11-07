package page_object_model.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Utilities {

    protected WebDriver driver;
    protected BrowserFactory browserFactory = new BrowserFactory();
    public static final String BASE_URL = "https://www.amazon.ae"; // Now accessible across all packages

    @BeforeMethod
    public void initializeBrowser() {
        driver = browserFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            browserFactory.quitDriver();
        }
    }
}
