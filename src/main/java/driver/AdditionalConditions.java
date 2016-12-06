package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AdditionalConditions {

    public static ExpectedCondition<Boolean> jsLoad() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
            }
        };
    }

    public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            }
        };
    }

    public static ExpectedCondition<Boolean> jsAndjQueryLoad() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) && (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
    }
}
