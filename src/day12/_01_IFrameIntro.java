package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class _01_IFrameIntro extends BaseDriver {

    @Test
    public void testSingleIFrameInteraction() {
        // 1- Navigate to the website
        driver.get("https://demo.automationtesting.in/Frames.html");

        // Step 1.1: Close cookie pop-up if it appears (Optional cookies)
        List<WebElement> cookiesDecline = driver.findElements(By.xpath("//*[text()='Do not consent']"));
        if (!cookiesDecline.isEmpty()) {
            cookiesDecline.get(0).click();
        }

        // 2- Switch into the iframe

        // Method 1: Switch by index (based on iframe order in the page)
        // driver.switchTo().frame(0);

        // Method 2: Switch by name or id attribute
        driver.switchTo().frame("singleframe");

        // Method 3: Switch using WebElement
        // WebElement iframe1 = driver.findElement(By.id("singleframe"));
        // driver.switchTo().frame(iframe1);

        // Note: In terms of performance, switching by index is the fastest.
        // But in real projects, switching by WebElement is the most stable and flexible.
        // Order of performance (generally): index > WebElement > name > id

        // 3- Locate the input box inside the iframe and type text
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("Hello");

        // At this point, the driver is inside the iframe.
        // Any locator used now will only search within the iframe content.

        // 4- Exit the iframe and return to the main page

        // Method 1: Go up one level (only works if there's a single iframe level)
        // driver.switchTo().parentFrame();

        // Method 2: Go back to the top-level document (recommended)
        driver.switchTo().defaultContent();

        waitAndClose();
    }
}
