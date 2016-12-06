package tests;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class SmokeTests {
    private WebDriver driver;
    HomePage homePage;
    DriverFactory driverFactory;

    String homeAddress = "http://demoqa.com/";

    @BeforeClass
    private void before() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();

        homePage = new HomePage(driver);
    }

    @Test
    private void firstTest() {
        driver.get(homeAddress);
        assertTrue(driver.getCurrentUrl().equals(homeAddress));
    }

    @Test
    private void checkAboutUsTabRouting() {
        String tabName = "About us";
        driver.get(homeAddress);
        homePage.changeBookmark(tabName);
        assertTrue(homePage.getSiteTitle().contains(tabName));
    }

    @AfterClass
    private void after() {
        driver.quit();
    }
}
