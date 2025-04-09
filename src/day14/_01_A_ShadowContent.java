package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/**
 * This test demonstrates interaction with a native Shadow DOM element.
 * It uses getShadowRoot() to access the shadow tree and interact with an element inside.
 */

public class _01_A_ShadowContent extends BaseDriver {

    @Test
    public void clickButtonInsideNativeShadowDomTest() {
        driver.get("https://www.akakce.com/");
        MyFunction.wait(2);

        // Try to locate the shadow host element
        List<WebElement> shadowHosts = driver.findElements(By.className("efilli-layout-tuttur"));

        if (!shadowHosts.isEmpty()) {
            WebElement shadowWebParent = shadowHosts.get(0);

            // Access the native shadow root from the host element
            SearchContext shadowContent = shadowWebParent.getShadowRoot();

            // Locate and click the accept button inside the native shadow DOM
            WebElement acceptButton = shadowContent.findElement(By.cssSelector(".banner__accept-button"));
            System.out.println("acceptButton.getText() = " + acceptButton.getText());
            acceptButton.click();

        } else {
            System.out.println("Shadow host element not found. Shadow interaction skipped.");
        }

        waitAndClose();
    }
}
