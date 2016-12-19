package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import test.ParentStep;

import static org.testng.Assert.assertTrue;

public class SmokeSteps extends ParentStep {
    HomePage homePage;

    String tabName = "About us";

    @Given("^User is on home page$")
    public void userIsOnHomePage() {
        homePage.goToHomePage();
    }

    @When("^User go to About us$")
    public void userGoToAboutUs() {
        homePage.changeBookmark(tabName);
    }

    @Then("^User is on About us page$")
    public void userIsOnAboutUsPage() {
        assertTrue(homePage.getSiteTitle().contains(tabName));
    }

    @Then("^Expected address is wrong$")
    public void expectedAddressIsWrong() {
        assertTrue(driver.getCurrentUrl().equals(homeAddress + "wrongAddress"));
    }

    @Before
    public void beforeSteps() {
        setUp();
    }

    protected void beforeRun() {
        homePage = new HomePage(driver);
    }

    @After
    public void afterSteps(Scenario scenario) {
        tearDown(scenario);
    }
}
