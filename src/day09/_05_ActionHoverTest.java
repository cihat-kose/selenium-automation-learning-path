package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _05_ActionHoverTest extends BaseDriver {

    @Test
    public void testHoverOverMenu() {
        // Navigate to the website
        driver.get("https://www.hepsiburada.com/");

        // Create an Actions object for performing advanced user interactions
        Actions actions = new Actions(driver);

        // Wait for the page to load completely
        MyFunction.wait(2);

        // Locate the "Moda" menu item
        WebElement modaElement = driver.findElement(By.xpath("//span[text()='Moda']"));

        // Build the hover action
        Action hoverAction = actions.moveToElement(modaElement).build();

        // Perform the hover action
        hoverAction.perform();

        // Close the browser after a short wait
        waitAndClose();
    }
}

