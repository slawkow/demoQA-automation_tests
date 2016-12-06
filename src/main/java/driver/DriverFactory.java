package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private WebDriver driver;

    public DriverFactory() {
    }

    public WebDriver getDriver() {
        // TODO add another browsers
        setChromeDriverPath();
        driver = new ChromeDriver();
        configureDriver();

        return driver;
    }

    private void setChromeDriverPath() {
        String chromeDriverPath = "C:/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    private void configureDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
