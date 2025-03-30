package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class _03_WaitsIntro extends BaseDriver {

    @Test
    public void testWaitWithStaticDelay() {
        driver.get("https://letcode.in/waits");

        WebElement button = driver.findElement(By.id("accept"));
        button.click();

        MyFunction.wait(20); // Only pauses Java code, unaware of the actual web state.
        // Might be insufficient or too long depending on page speed, causing inefficiency

        driver.switchTo().alert().accept();  // Closes the alert
        waitAndClose();
    }
}
