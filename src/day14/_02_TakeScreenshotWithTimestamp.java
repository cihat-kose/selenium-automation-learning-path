package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This class demonstrates two different ways of saving screenshots:
 * 1. Saving to the same file (old one gets overwritten).
 * 2. Saving each screenshot as a unique file using a timestamp.
 * Screenshots are saved inside the target/screenshots/ folder.
 */

public class _02_TakeScreenshotWithTimestamp extends BaseDriver {

    /**
     * This test saves the screenshot with the same file name every time.
     * ⚠️ The previous screenshot will be overwritten.
     * Saved path: target/screenshots/overwrite/screenshot.png
     */
    @Test
    public void overwriteScreenshotWithSameFileNameTest() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys("fakeuser");
        driver.findElement(By.name("password")).sendKeys("fake1234");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[text()='Invalid credentials']"));

        if (!errorMessage.isEmpty()) {
            System.out.println("There was a mistake");

            TakesScreenshot ts = (TakesScreenshot) driver;
            File memoryState = ts.getScreenshotAs(OutputType.FILE);

            // Save to target folder with a static file name
            FileUtils.copyFile(memoryState,
                    new File("target/screenshots/overwrite/screenshot.png"));
        }

//        waitAndClose();
    }

    /**
     * This test saves the screenshot with a timestamp in the file name.
     * ✅ Each screenshot is saved separately.
     * Saved path example: target/screenshots/timestamped/screenshot_20250420_143002.png
     */
    @Test
    public void saveScreenshotWithUniqueTimestampTest() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys("fakeuser");
        driver.findElement(By.name("password")).sendKeys("fake1234");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[text()='Invalid credentials']"));

        if (!errorMessage.isEmpty()) {
            System.out.println("There was a mistake");

            TakesScreenshot ts = (TakesScreenshot) driver;
            File memoryState = ts.getScreenshotAs(OutputType.FILE);

            // Generate a timestamped file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshot_" + timestamp + ".png";

            // Save to target folder with a unique file name
            FileUtils.copyFile(memoryState,
                    new File("target/screenshots/timestamped/" + fileName));
        }

        waitAndClose();
    }
}
