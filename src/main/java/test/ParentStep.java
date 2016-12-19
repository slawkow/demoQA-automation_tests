package test;

import common.PropertyBase;
import cucumber.api.Scenario;
import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class ParentStep {
    protected WebDriver driver;
    protected PropertyBase propertyBase = new PropertyBase();

    public String homeAddress = propertyBase.getProperty("baseUrl");

    public void setUp() {
        driver = (new DriverFactory()).getDriver();
        beforeRun();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void beforeRun();

    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        driver.quit();
    }
}
