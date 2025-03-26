package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;
import utility.MyFunction;

/**
    Test Case: Search Baby Category on eBay

    Objective:
    Verify that selecting the "Baby" category and searching displays correct results.

    Steps:
    1. Navigate to https://www.ebay.co.uk/
    2. Select the "Baby" option from the category dropdown.
    3. Click the search button.
    4. Validate that "Baby Essentials" is displayed in the result page header.
*/

public class _04_EbayCategorySearchTest extends BaseDriver {

    @Test
    public void shouldDisplayCorrectHeader_WhenBabyCategoryIsSearched() {
        // Step 1: Go to eBay UK homepage
        driver.get("https://www.ebay.co.uk/");
        MyFunction.wait(1);

        // Step 2: Select "Baby" category from the dropdown
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropdown);
        select.selectByValue("2984");  // 2984 corresponds to Baby category
        MyFunction.wait(1);

        // Step 3: Click the search button
        WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
        searchButton.click();
        MyFunction.wait(1);

        // Step 4: Verify that "Baby Essentials" is visible in the page header
        WebElement headerText = driver.findElement(By.xpath("//h1[text()='Baby Essentials']"));
        Assert.assertTrue("Expected header text was not found!",
                headerText.getText().contains("Baby Essentials"));

        // Step 5: Close the browser
        waitAndClose();
    }
}
