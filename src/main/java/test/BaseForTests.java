package test;

import common.PropertyBase;
import driver.DriverFactory;
import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public abstract class BaseForTests {
    protected WebDriver driver;
    protected PropertyBase propertyBase = new PropertyBase();

    public String homeAddress = propertyBase.getProperty("baseUrl");

    @BeforeClass
    protected void setUp() {
        driver = (new DriverFactory()).getDriver();
        beforeRun();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void beforeRun();

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
