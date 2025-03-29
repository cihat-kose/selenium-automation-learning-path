package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _08_ActionMouseWheel extends BaseDriver {
    @Test
    public void mouseWheelTest1() {
        // scroll to element
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        WebElement iframe = driver.findElement(By.name("nested_scrolling_frame"));
        MyFunction.wait(2);

        // scroll to iframe
        new Actions(driver)
                .scrollToElement(iframe)
                .build()
                .perform();

        waitAndClose();
    }

    @Test
    public void mouseWheelTest2() {
        // scroll a certain amount
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        MyFunction.wait(2);

        new Actions(driver)
                .scrollByAmount(0, 500)
                .build()
                .perform();

        waitAndClose();
    }

    @Test
    public void mouseWheelTest3() {
        // step by step scroll up to a certain element
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        MyFunction.wait(2);

        WebElement iframe = driver.findElement(By.name("nested_scrolling_frame"));
        // TODO: Scroll step by step in the form of 100px 100px until the iframe with 1 second intervals.
        // Hint: you can get the information of how far the element is from the top of the page as element.getRect().y

        for (int i = 0; i < iframe.getRect().y; i += 100) {
            new Actions(driver).scrollByAmount(0, i).build().perform();
            MyFunction.wait(1);
        }

        // TODO: --> Done

        waitAndClose();
    }
}
