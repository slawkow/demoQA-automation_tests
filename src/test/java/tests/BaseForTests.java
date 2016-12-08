package tests;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseForTests {
    protected WebDriver driver;

    String homeAddress = "http://demoqa.com/";

    @BeforeClass
    protected void setUp() {
        driver = (new DriverFactory()).getDriver();
        beforeRun();
    }

    protected abstract void beforeRun();

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
