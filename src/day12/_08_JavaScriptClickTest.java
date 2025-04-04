package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class _08_JavaScriptClickTest extends BaseDriver {

    @Test
    public void clickWithJavaScriptExecutor() {
        driver.get("https://www.copado.com/robotic-testing");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate the target element
        WebElement readStory = driver.findElement(By.xpath("//div[text()='Read Success Story']"));

        // Scroll the element into view (align to bottom of viewport)
        js.executeScript("arguments[0].scrollIntoView(false);", readStory);

        // Normal click may fail due to overlapping sticky header
        // readStory.click();

        // JavaScript click bypasses visual interference
        js.executeScript("arguments[0].click();", readStory);

        waitAndClose();
    }
}
