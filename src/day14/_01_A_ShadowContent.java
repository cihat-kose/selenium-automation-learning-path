package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/**
 * This test demonstrates how to interact with a native Shadow DOM element using Selenium.
 * It accesses the shadow root via getShadowRoot(), then finds and clicks the "Accept All" button inside the Shadow DOM.
 */

public class _01_A_ShadowContent extends BaseDriver {

    @Test
    public void clickButtonInsideNativeShadowDomTest() {
        driver.get("https://www.akakce.com/");
        MyFunction.wait(2); // Give the shadow content time to load

        // Step 1: Locate the shadow host element (Web Component)
        List<WebElement> shadowHosts = driver.findElements(By.className("efilli-layout-tuttur"));

        if (!shadowHosts.isEmpty()) {
            WebElement shadowHost = shadowHosts.get(0);

            // Step 2: Access the native Shadow Root from the host element
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // Step 3: Locate the "Accept All" button using a clear and stable selector
            WebElement acceptButton = shadowRoot.findElement(By.cssSelector("div[data-name='kabul et']"));

            // Optional: Print button text for debugging
            System.out.println("acceptButton.getText() = " + acceptButton.getText());

            // Step 4: Click the button
            acceptButton.click();
        } else {
            System.out.println("Shadow host element not found. Shadow interaction skipped.");
        }

        waitAndClose();
    }
}
