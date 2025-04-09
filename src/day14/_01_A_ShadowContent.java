package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/**
 * This test demonstrates how to interact with Shadow DOM in Selenium.
 * It includes a safety check to prevent errors if the shadow host element is not found.
 */

public class _01_A_ShadowContent extends BaseDriver {

    @Test
    public void test() {
        driver.get("https://www.akakce.com/");
        MyFunction.wait(2);

        // Try to locate the shadow host element
        List<WebElement> shadowHosts = driver.findElements(By.className("efilli-layout-tuttur"));

        if (!shadowHosts.isEmpty()) {
            WebElement shadowWebParent = shadowHosts.get(0);

            // Access the shadow root from the host element
            SearchContext shadowContent = shadowWebParent.getShadowRoot();

            // Locate and click the accept button inside the shadow DOM
            WebElement acceptButton = shadowContent.findElement(By.cssSelector(".banner__accept-button"));
            System.out.println("acceptButton.getText() = " + acceptButton.getText());
            acceptButton.click();

        } else {
            System.out.println("Shadow host element not found. Shadow interaction skipped.");
        }

        waitAndClose();
    }
}
