package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import test.BaseForTests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener extends TestListenerAdapter {

    private boolean createFile(File screenshot) throws IOException {
        boolean fileCreated = false;
        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                fileCreated = screenshot.createNewFile();
            }
        }
        return fileCreated;
    }

    private void writeScreenshotToFile(WebDriver driver, File screenshot) throws IOException {
        FileOutputStream screenshotStream = new FileOutputStream(screenshot);
        screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        screenshotStream.close();
    }

    @Override
    public void onTestFailure(ITestResult failingTest) {
        try {
            Object failingTestInstance = failingTest.getInstance();
            WebDriver driver = ((BaseForTests) failingTestInstance).getDriver();
            String date = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
            String screenshotDirectory = ".\\screenshots";
            String screenshotAbsolutePath = screenshotDirectory +
                    File.separator + failingTest.getName() + "_" + date + ".png";
            File screenshot = new File(screenshotAbsolutePath);
            if (createFile(screenshot)) {
                try {
                    writeScreenshotToFile(driver, screenshot);
                } catch (ClassCastException weNeedToAugmentOurDriverObject) {
                    writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
                }
                System.out.println("Written screenshot to " + screenshotAbsolutePath);
            } else {
                System.err.println("Unable to create " + screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            System.err.println("Unable to capture screenshot...");
            ex.printStackTrace();
        }
    }
}