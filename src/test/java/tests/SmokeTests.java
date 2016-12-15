package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import test.BaseForTests;

import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseForTests {
    HomePage homePage;

    @Override
    protected void beforeRun() {
        homePage = new HomePage(driver);
    }

    @Test
    public void failTestForScreenshotCheck() {
        homePage.goToHomePage();
        assertTrue(driver.getCurrentUrl().equals(homeAddress + "wrongAddress"));
    }

    @Test
    public void checkAboutUsTabRouting() {
        String tabName = "About us";
        homePage.goToHomePage();
        homePage.changeBookmark(tabName);
        assertTrue(homePage.getSiteTitle().contains(tabName));
    }
}
