package day13;

import org.junit.Test;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

/**
 * Interview Question:
 * How do you control browser windows in Selenium?
 * Answer: I can use the Java Robot class to simulate keyboard actions (like opening a new tab).
 */

public class _04_HandleTabsWithRobot extends BaseDriver {

    @Test
    public void openNewTabUsingRobotTest() throws AWTException {
        driver.get("https://www.google.com/");
        MyFunction.wait(2);

        // Java ROBOT class allows you to simulate keyboard/mouse actions
        Robot robot = new Robot();

        // Press CTRL+T to open a new browser tab (like a human would)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        MyFunction.wait(2);

        // Selenium can switch between windows/tabs using window handles
        Set<String> windowIDs = driver.getWindowHandles();
        Iterator<String> iterator = windowIDs.iterator();

        String firstTab = iterator.next();   // This is the original Google tab
        String secondTab = iterator.next();  // This is the new tab opened via Robot

        // Switch to the new tab and navigate to Facebook
        driver.switchTo().window(secondTab);
        driver.get("https://www.facebook.com/");

        waitAndClose();
    }
}
