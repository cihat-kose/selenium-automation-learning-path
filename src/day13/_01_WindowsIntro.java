package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;
import java.util.Set;

public class _01_WindowsIntro extends BaseDriver {

    // driver.quit();  // Closes all opened windows
    // driver.close(); // Closes only the currently active window

    @Test
    public void handleMultipleWindowsTest() {
        // Each tab in the browser is considered a window in Selenium
        driver.get("https://www.selenium.dev/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Store the window ID of the main page
        String mainPageWindowId = driver.getWindowHandle();

        // Find all links that open in a new tab (target="_blank")
        List<WebElement> links = driver.findElements(By.cssSelector("a[target='_blank']"));

        // Click each link using JavaScriptExecutor
        for (WebElement link : links) {
            js.executeScript("arguments[0].click();", link);
        }

        // Get the IDs of all open windows/tabs
        Set<String> windowIDs = driver.getWindowHandles();

        for (String id : windowIDs) {
            System.out.println("Window ID = " + id);
        }

        // Switch back to the main window
        driver.switchTo().window(mainPageWindowId);

        waitAndClose();
    }
}
