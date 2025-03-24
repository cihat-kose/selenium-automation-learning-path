package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

/**
    Task: Calculator Functionality Test using CSS Selector

    Goal:
    Test the addition functionality of a simple web calculator using Selenium and CSS selectors.

    Steps:
    1. Navigate to: https://testpages.herokuapp.com/styled/index.html
    2. Click the "Calculator" link.
    3. Enter 6 in the first input field.
    4. Enter 5 in the second input field.
    5. Click the "Calculate" button.
    6. Retrieve and print the result.
    7. Assert that the result is correct (6 + 5 = 11).
    8. Close the browser.
*/

public class _02_CalculatorTestWithCssSelector extends BaseDriver {

    @Test
    public void shouldCalculateSumCorrectly_WhenValidInputsAreGiven() {
        // Step 1: Navigate to the main page
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Step 2: Click the "Calculator" link
        WebElement calculatorLink = driver.findElement(By.cssSelector("[id='calculatetest']"));
        calculatorLink.click();
        MyFunction.wait(1);

        // Step 3: Enter 6 in the first input field
        WebElement input1 = driver.findElement(By.cssSelector("[id='number1']"));
        input1.sendKeys("6");
        MyFunction.wait(1);

        // Step 4: Enter 5 in the second input field
        WebElement input2 = driver.findElement(By.cssSelector("[id='number2']"));
        input2.sendKeys("5");
        MyFunction.wait(1);

        // Step 5: Click the "Calculate" button
        WebElement calculateButton = driver.findElement(By.cssSelector("[id='calculate']"));
        calculateButton.click();
        MyFunction.wait(1);

        // Step 6: Retrieve and print the result
        WebElement resultElement = driver.findElement(By.cssSelector("[id='answer']"));
        String resultText = resultElement.getText();
        System.out.println("Calculation Result = " + resultText);

        // Step 7: Validate the result
        int actualResult = Integer.parseInt(resultText);
        int expectedResult = 11;
        Assert.assertEquals("The calculated result is incorrect!", expectedResult, actualResult);

        // Step 8: Close the browser
        waitAndClose();
    }
}
