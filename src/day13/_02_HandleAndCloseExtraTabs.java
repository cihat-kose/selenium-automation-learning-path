package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;
import java.util.Set;

public class _02_HandleAndCloseExtraTabs extends BaseDriver {

    /**
     * Scenario:
     * Click on the links that open in a separate tab at https://www.selenium.dev/.
     * Print the title and URL of the pages in all newly opened tabs.
     * Then, close all tabs except the homepage.
     */

    @Test
    public void handleMultipleTabsAndCloseExtrasTest() {
        driver.get("https://www.selenium.dev/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Store the ID of the main (home) page before opening new tabs
        String mainPageWindowId = driver.getWindowHandle();

        // Find all links that are set to open in a new tab
        List<WebElement> links = driver.findElements(By.cssSelector("a[target='_blank']"));

        // Click each link that does NOT contain "mail" in its href
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.contains("mail")) {
                js.executeScript("arguments[0].click();", link);
            }
        }

        // Get all open window/tab IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Switch to each tab, print title and URL, and close if not the homepage
        for (String id : windowIds) {
            driver.switchTo().window(id);
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            if (!id.equals(mainPageWindowId)) {
                driver.close();
            }
        }

        // Return to main window
        driver.switchTo().window(mainPageWindowId);

        waitAndClose();
    }
}
