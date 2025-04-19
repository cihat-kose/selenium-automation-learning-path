package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

public class _11_ActionHoverOverExample extends BaseDriver {

    //    Task:
    //    1) Navigate to https://www.mediamarkt.com.tr/
    //    2) Hover over "All Categories" -> "Home Appliances" -> "Combi Boilers" and click.
    //    3) After the click, verify that the word "kombi" is present in the URL.

    @Test
    public void test() {
        // Step 1: Open the MediaMarkt Turkey website and hover over categories
        Actions actions = new Actions(driver);  // Initialize Actions class for performing hover and click actions

        // Navigate to the MediaMarkt homepage
        driver.get("https://www.mediamarkt.com.tr/");

        // Step 2: If a cookie consent pop-up appears, accept it
        List<WebElement> consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
        if (!consent.isEmpty()) {
            consent.get(0).click();  // Click the "Accept All" button if it's displayed
        }

        // Step 3: Hover over "All Categories" -> "Home Appliances" -> "Combi Boilers"
        WebElement allCategories = driver.findElement(By.xpath("//*[@id='header']/header/div[3]/div[1]/a"));    // "All Categories" link
        WebElement homeAppliances = driver.findElement(By.xpath("//*[@id='header']/header/div[3]/div[1]/ul/li[6]/a")); // "Home Appliances" link
        WebElement combiBoilers = driver.findElement(By.xpath("//*[@id='submenu-cat6']/div/ul[3]/li[5]/a"));  // "Combi Boilers" link

        // Hover over "All Categories" and then "Home Appliances"
        actions.moveToElement(allCategories).build().perform();  // Hover over "All Categories"
        MyFunction.wait(2);  // Wait for the menu to appear
        actions.moveToElement(homeAppliances).build().perform();  // Hover over "Home Appliances"
        MyFunction.wait(2);  // Wait for the sub-menu to appear

        // Step 4: Click on the "Combi Boilers" link
        actions.click(combiBoilers).build().perform();  // Perform a click on "Combi Boilers"
        // Alternatively, you can use combiBoilers.click(); for direct click without using Actions class.

        // Step 5: Verify that the URL contains the word "kombi"
        String currentUrl = driver.getCurrentUrl();  // Get the current URL of the page

        // Assert that the URL contains "kombi"
        Assert.assertTrue("The word 'kombi' is not found in the URL.", currentUrl.contains("kombi"));

        // Step 6: End the test and close the browser
        waitAndClose();  // Wait for 3 seconds and then close the browser
    }
}
