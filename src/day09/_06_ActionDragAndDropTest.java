package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _06_ActionDragAndDropTest extends BaseDriver {

    @Test
    public void testDragAndDrop() {
        // Navigate to the drag-and-drop demo page
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Create Actions object for performing complex user gestures
        Actions actions = new Actions(driver);

        // Wait for the elements to load
        MyFunction.wait(2);

        // Locate draggable element (Oslo) and droppable target (Norway)
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norway = driver.findElement(By.id("box101"));

        // Method 1: Using dragAndDrop directly
        actions.dragAndDrop(oslo, norway).build().perform();

        // Method 2: Two-step approach - click, move and release
        actions.clickAndHold(oslo).build().perform();               // Click and hold Oslo
        actions.moveToElement(norway).release().build().perform();  // Move to Norway and release

        // Close the browser
        waitAndClose();
    }
}
