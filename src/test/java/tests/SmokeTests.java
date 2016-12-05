package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class SmokeTests {
    private WebDriver driver;
    HomePage homePage;

    @BeforeClass
    private void before() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    private void firstTest() {
        String homeAddress = "http://demoqa.com/";
        driver.get(homeAddress);
        assertTrue(driver.getCurrentUrl().equals(homeAddress));
    }

    @AfterClass
    private void after() {
        driver.quit();
    }
}
