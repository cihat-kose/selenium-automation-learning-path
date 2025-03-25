package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/**
    Task: Verify Cart Item Total Using XPath

    Scenario:
    1. Go to https://www.saucedemo.com/
    2. Log in using the credentials:
       - Username: standard_user
       - Password: secret_sauce
    3. Click on "Sauce Labs Backpack" and add it to the cart
    4. Click "Back to products"
    5. Click on "Sauce Labs Bolt T-Shirt" and add it to the cart
    6. Go to the cart
    7. Click "Checkout"
    8. Fill in the user information and click "Continue"
    9. Verify with an assertion that the sum of individual product prices
       is equal to the displayed "Item total" at the bottom

    Note: All element selectors should be done using XPath only.
*/

public class _01_SauceDemoCartTotalTest extends BaseDriver {

    @Test
    public void shouldMatchSumOfItemsWithDisplayedItemTotal() {

        // Step 1: Open the website
        driver.get("https://www.saucedemo.com/");
        MyFunction.wait(1);

        // Step 2: Login
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        MyFunction.wait(1);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        MyFunction.wait(1);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        MyFunction.wait(1);

        // Step 3: Add first product to cart
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        MyFunction.wait(1);

        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
        MyFunction.wait(1);

        driver.findElement(By.xpath("//*[@id='back-to-products']")).click();
        MyFunction.wait(1);

        // Step 4: Add second product to cart
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();
        MyFunction.wait(1);

        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        MyFunction.wait(1);

        // Step 5: Go to cart
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        MyFunction.wait(1);

        // Step 6: Proceed to checkout
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        MyFunction.wait(1);

        // Step 7: Fill in user information
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Kerem");
        MyFunction.wait(1);

        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Said");
        MyFunction.wait(1);

        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("323232");
        MyFunction.wait(1);

        driver.findElement(By.xpath("//*[@id='continue']")).click();
        MyFunction.wait(1);

        // Step 8: Collect and sum product prices
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double calculatedTotal = 0;
        for (WebElement price : prices) {
            calculatedTotal += Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
        }
        System.out.println("Calculated total = " + calculatedTotal);

        // Step 9: Get displayed item total and compare
        WebElement itemTotalElement = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        double displayedTotal = Double.parseDouble(itemTotalElement.getText().replaceAll("[^0-9.]", ""));
        System.out.println("Displayed total = " + displayedTotal);

        Assert.assertEquals("Mismatch between calculated and displayed total", calculatedTotal, displayedTotal, 0.0);

        // Step 10: Close the browser
        waitAndClose();
    }
}
