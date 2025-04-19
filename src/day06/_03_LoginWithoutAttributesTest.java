package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

/**
 * Task: Login to the E-Commerce Page Without Using Any Attributes
 * <p>
 * Objective:
 * Practice locating elements using only CSS selectors (no attributes like id, class, name, etc.).
 * <p>
 * Steps:
 * 1. Navigate to https://qa-practice.netlify.app/auth_ecommerce
 * 2. Enter "admin@admin.com" into the email field
 * 3. Enter "admin123" into the password field
 * 4. Click the Submit button
 * 5. Verify that "SHOPPING CART" text is visible on the new page using assertion
 */

public class _03_LoginWithoutAttributesTest extends BaseDriver {

    @Test
    public void shouldLoginSuccessfullyUsingPureCssSelectors() {
        // Step 1: Navigate to the page
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");

        // Step 2: Locate the email input field using sibling selector and enter email
        WebElement email = driver.findElement(By.cssSelector("small[id='emailHelp'] ~ input"));
        email.sendKeys("admin@admin.com");

        // Step 3: Locate the password input field using child combinators and enter password
        WebElement password = driver.findElement(By.cssSelector("form[id='login'] > :nth-child(2) > :nth-child(2)"));
        password.sendKeys("admin123");

        // Step 4: Locate and click the submit button using structure-based CSS selector
        WebElement submit = driver.findElement(By.cssSelector("form[id='login'] > :nth-child(3)"));
        submit.click();

        // Step 5: Locate the message and verify it contains "SHOPPING CART"
        WebElement shoppingCartMessage = driver.findElement(By.cssSelector("div[id='prooood'] h2"));
        String actualText = shoppingCartMessage.getText();
        Assert.assertTrue("Expected text 'SHOPPING CART' was not found!", actualText.contains("SHOPPING CART"));

        // Step 6: Close the browser
        waitAndClose();
    }
}
