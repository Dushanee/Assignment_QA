package page_object_model.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private ThreadLocal<WebDriver> tlWebDriver = ThreadLocal.withInitial(() -> {
        WebDriver driver;
        String browserType = System.getProperty("browser", "chrome");
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new RuntimeException("Browser type '" + browserType + "' is not supported.");
        }
        driver.manage().window().maximize();
        return driver;
    });

    public WebDriver getDriver() {
        return tlWebDriver.get();
    }

    public void quitDriver() {
        if (tlWebDriver.get() != null) {
            tlWebDriver.get().quit();
            tlWebDriver.remove();
        }
    }
}
