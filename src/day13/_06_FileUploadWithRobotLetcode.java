package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * This test demonstrates file upload automation using the Java Robot class
 * on https://letcode.in/file. The file dialog is handled by simulating
 * keyboard input: TAB, ENTER, CTRL+V, ENTER.
 */

public class _06_FileUploadWithRobotLetcode extends BaseDriver {

    @Test
    public void uploadFileToLetcodeTest() throws AWTException {
        driver.get("https://letcode.in/file");
        MyFunction.wait(1);

        Robot robot = new Robot();

        // Press TAB 6 times to focus the "Choose File" button
        for (int i = 0; i < 6; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        // Press ENTER to open the file dialog
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        MyFunction.wait(1);

        // Copy the file path to clipboard (students: update this path)
        StringSelection filePath = new StringSelection("\"C:\\Users\\cihat\\Desktop\\Desktop\\Sundry\\filePath.txt\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        // Paste the path using CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press ENTER to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Verify the file has been selected
        WebElement fileSelectedMessage = driver.findElement(By.cssSelector("[class='file']+p"));
        Assert.assertTrue("File upload failed", fileSelectedMessage.getText().contains("filePath.txt"));

        waitAndClose();
    }
}
