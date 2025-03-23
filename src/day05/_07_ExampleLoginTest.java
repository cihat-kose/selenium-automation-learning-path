package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class _07_ExampleLoginTest extends BaseDriver {
    /**
    Scenario:
    1- Open your https://qa-practice.netlify.app/auth_ecommerce page
    2- Type "admin@admin.com" in the email box
    3- Print "admin123" in the Password box
    4- Click on the Submit button
    5- Verify with Assert that the text "SHOPPING CART" appears on the new page that opens.
    */

    @Test
    public void loginDisplaysShoppingCart() {
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin123");

        WebElement submit = driver.findElement(By.id("submitLoginBtn"));
        submit.click();

        WebElement shoppingCartMessage = driver.findElement(By.className("section-header"));

        Assert.assertTrue("The searched message could not be found", shoppingCartMessage.getText().contains("SHOPPING CART"));

        waitAndClose();
    }
}
