package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;
import utility.MyFunction;

import java.time.Duration;

public class _09_BasicCalculatorAdditionTest extends BaseDriver {

    /**
        Scenario:
        1- Navigate to https://testsheepnz.github.io/BasicCalculator.html.
        2- Generate two random numbers up to 100.
        3- Perform addition on the calculator.
        4- Verify the results using Assert.
        5- Repeat the above process 5 times.
     */

    @Test
    public void additionTest() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        MyFunction.wait(2);

        // Scroll to the bottom of the page to ensure elements are visible if needed
        WebElement copyright = driver.findElement(By.className("copyright"));
        new Actions(driver).scrollToElement(copyright).build().perform();
        MyFunction.wait(2);

        for (int i = 0; i < 5; i++) {
            int number1 = MyFunction.generateRandomNumber(100);
            int number2 = MyFunction.generateRandomNumber(100);
            int expectedSum = number1 + number2;

            WebElement firstNumberField = driver.findElement(By.id("number1Field"));
            WebElement secondNumberField = driver.findElement(By.id("number2Field"));
            WebElement resultField = driver.findElement(By.id("numberAnswerField"));
            WebElement clearButton = driver.findElement(By.id("clearButton"));

            firstNumberField.sendKeys(String.valueOf(number1));
            secondNumberField.sendKeys(String.valueOf(number2));

            WebElement calculateButton = driver.findElement(By.id("calculateButton"));
            calculateButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(resultField));

            int actualSum = Integer.parseInt(resultField.getAttribute("value"));
            Assert.assertEquals("Incorrect sum calculated", expectedSum, actualSum);

            firstNumberField.clear();
            secondNumberField.clear();
            clearButton.click();
        }
        waitAndClose();
    }
}
