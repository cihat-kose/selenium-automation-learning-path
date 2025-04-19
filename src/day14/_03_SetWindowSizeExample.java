package day14;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import utility.BaseDriver;

/**
 * This test demonstrates how to resize the browser window using Selenium.
 * It prints the initial size and sets a custom window dimension.
 */

public class _03_SetWindowSizeExample extends BaseDriver {

    @Test
    public void resizeBrowserWindowTest() {
        driver.get("https://www.youtube.com/");

        // Maximize window and print current dimensions
        driver.manage().window().maximize();
        Dimension screenDimension = driver.manage().window().getSize();
        System.out.println("Initial screen width  = " + screenDimension.width);
        System.out.println("Initial screen height = " + screenDimension.height);

        // Set custom size (e.g., 516 x 600)
        Dimension newDimension = new Dimension(516, 600);
        driver.manage().window().setSize(newDimension);

        System.out.println("Window resized to: " + newDimension);

        // The test continues with the browser in the new size
        waitAndClose();
    }
}
