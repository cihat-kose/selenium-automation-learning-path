package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

/**
 * This test interacts with a custom web component that resembles Shadow DOM,
 * but does not use native shadowRoot. It's useful for demonstrating the
 * difference between native and non-native Shadow DOM-like structures.
 */

public class _01_B_NonNativeShadowDomExample extends BaseDriver {

    @Test
    public void interactWithCustomComponentWithoutShadowRootTest() {
        driver.get("https://itytest.ccngroup.com.tr/Era/LoginPage?ReturnUrl=%2FEra");

        // Locate the custom input component
        WebElement shadowHost = driver.findElement(By.xpath("(//dxbl-input-editor)[1]"));

        // Try to directly access its internal input field
        WebElement usernameField = shadowHost.findElement(By.xpath("(//dxbl-input-editor)[1]/input"));

        wait.until(ExpectedConditions.elementToBeClickable(usernameField));

        // Enter dummy text
        usernameField.sendKeys("username");

        waitAndClose();
    }
}
