package day12;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utility.BaseDriver;
import utility.MyFunction;

public class _06_ScrollToBottomOfThePage extends BaseDriver {

    @Test
    public void scrollToBottomAndTopTest() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        MyFunction.wait(2);

        // Scroll to the very bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        MyFunction.wait(2);

        // Scroll back to the top of the page
        js.executeScript("window.scrollTo(0, 0);");

        waitAndClose();
    }
}
