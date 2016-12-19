package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/features/smoke.feature",
        glue = "steps",
        plugin = {
                "pretty",
                "html:target/class-html-report",
        },
        snippets = SnippetType.CAMELCASE
)
public class RunSmokeTests extends AbstractTestNGCucumberTests {
}
