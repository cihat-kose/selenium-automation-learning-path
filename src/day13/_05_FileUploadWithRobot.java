package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * This test demonstrates how to upload a file using Java Robot class.
 * It simulates keyboard actions like TAB, ENTER, CTRL+V and SPACE
 * to interact with a file upload dialog and form elements.
 */

public class _05_FileUploadWithRobot extends BaseDriver {

    @Test
    public void uploadFileUsingRobotTest() throws AWTException {
        driver.get("http://demo.guru99.com/test/upload/");
        MyFunction.wait(1);

        // Accept cookie/consent popup if it appears
        List<WebElement> acceptAllFrame = driver.findElements(By.id("gdpr-consent-notice"));
        if (!acceptAllFrame.isEmpty()) {
            driver.switchTo().frame(acceptAllFrame.get(0));

            List<WebElement> acceptAll =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Accept All']")));

            if (!acceptAll.isEmpty())
                acceptAll.get(0).click();
        }

        // Simulate file upload using Robot
        Robot robot = new Robot();

        // Navigate to the "Choose File" button using TAB (15 times)
        for (int i = 0; i < 15; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        // Press ENTER to open file dialog
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Set file path to clipboard (students: update this path for your system)
        StringSelection filePath = new StringSelection("C:\\Users\\YourUser\\Desktop\\filePath.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        MyFunction.wait(1);

        // Paste file path with CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        MyFunction.wait(1);

        // Press ENTER to confirm file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Navigate to the checkbox using TAB (2 times)
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        MyFunction.wait(1);

        // Check the terms checkbox with SPACE
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);

        MyFunction.wait(1);

        // Navigate to the submit button using TAB (2 times)
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        MyFunction.wait(1);

        // Submit the form with ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Verify success message appears
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='has been successfully uploaded.']")));

        Assert.assertTrue(message.isDisplayed());

        waitAndClose();
    }
}
