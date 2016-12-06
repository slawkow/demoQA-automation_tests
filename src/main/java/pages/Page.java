package pages;

import driver.AdditionalConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    protected void clickBy(By by) {
        wait.until(AdditionalConditions.jsLoad());
        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement element = driver.findElement(by);
        element.click();
    }

    protected void sendKeys(By by, String content) {
        wait.until(AdditionalConditions.jsLoad());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(content);
    }
}
