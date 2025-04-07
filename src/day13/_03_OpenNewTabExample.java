package day13;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utility.BaseDriver;
import utility.MyFunction;

public class _03_OpenNewTabExample extends BaseDriver {

    @Test
    public void openNewTabWithDifferentUrlTest() {

        // Open the main website in the first tab
        driver.get("https://www.selenium.dev/");
        MyFunction.wait(2);

        // Open a new blank tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB);

        // Since we're already in the new tab, we can load a new URL directly
        driver.get("https://www.facebook.com/");
        MyFunction.wait(2);

        waitAndClose();
    }
}
