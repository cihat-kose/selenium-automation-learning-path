package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class _02_NestedIFrameInteractionTest extends BaseDriver {

    /**
        Scenario:
        1. Go to https://demo.automationtesting.in/Frames.html
        2. Click on "Iframe with in an Iframe"
        3. Type your name in the input box inside the nested iframe
        4. Print the text of the element containing "iFrame Demo"
        5. Print the text of the element containing "Nested iFrames"
        6. Print the page title of the main page
     */

    @Test
    public void testNestedIFrames() {
        driver.get("https://demo.automationtesting.in/Frames.html");

        // Handle optional cookie consent
        List<WebElement> consentButton = driver.findElements(By.xpath("//*[text()='Consent']"));
        if (!consentButton.isEmpty()) {
            consentButton.get(0).click();
        }

        // Click on "Iframe with in an Iframe"
        WebElement nestedFrameLink = driver.findElement(By.xpath("//a[@href='#Multiple']"));
        nestedFrameLink.click();

        // Switch to parent iframe
        WebElement parentFrame = driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
        driver.switchTo().frame(parentFrame);

        // Switch to inner iframe inside the parent
        driver.switchTo().frame(0); // now in innermost iframe

        // Interact with the input box
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("Merhaba");

        // Print text from inner iframe
        WebElement innerText = driver.findElement(By.xpath("//*[text()='iFrame Demo']"));
        System.out.println("Inner text: " + innerText.getText());

        // Go one level back to parent iframe
        driver.switchTo().parentFrame();

        // Print text from parent iframe
        WebElement parentText = driver.findElement(By.xpath("//*[text()='Nested iFrames']"));
        System.out.println("Parent text: " + parentText.getText());

        // Return to main content (default page)
        driver.switchTo().defaultContent();
        System.out.println("Page title: " + driver.getTitle());

        waitAndClose();
    }
}
