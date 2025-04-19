package day12;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class _07_ScrollToWebElement extends BaseDriver {

    @Test
    public void test() {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        MyFunction.wait(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement iframe = driver.findElement(By.name("nested_scrolling_frame"));
        js.executeScript("arguments[0].scrollIntoView(true);", iframe); // Scroll to element.

        waitAndClose();
    }
}
