package day12;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utility.BaseDriver;
import utility.MyFunction;

public class _05_ScrollWithJavaScriptTest extends BaseDriver {

    @Test
    public void testScrollUsingJS() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        MyFunction.wait(2);

        // Create a JavaScriptExecutor instance from the driver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll directly to a specific position on the page (x=0, y=500)
        js.executeScript("window.scrollTo(0, 500);");

        MyFunction.wait(2);

        // Scroll 500 pixels more from current position
        js.executeScript("window.scrollBy(0, 500);");

        MyFunction.wait(2);

        // Scroll back 200 pixels from current position
        js.executeScript("window.scrollBy(0, -200);");

        waitAndClose();
    }
}
