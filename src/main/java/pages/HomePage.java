package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void changeBookmark(String tabName) {
        By by = By.linkText(tabName);
        clickBy(by);
    }

    public String getSiteTitle() {
        By by = By.className("entry-title");
        String title = driver.findElement(by).getText();
        return title;
    }
}
