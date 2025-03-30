package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.time.Duration;

public class _04_ImplicitlyWait extends BaseDriver {

    @Test
    public void testImplicitWait() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        // To understand this better, disable the implicit wait in BaseDriver and test again.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120)); // Can be set to 5, 10, 120 seconds
        // It doesn't wait for the full duration. It continues immediately once the element is found.
        // For example, Thread.sleep(120000) would wait exactly 120 seconds regardless.

        WebElement button = driver.findElement(By.xpath("//button[@onclick='timedText()']"));
        button.click();

        WebElement message = driver.findElement(By.xpath("//*[text()='WebDriver']"));
        System.out.println("message.getText() = " + message.getText());

        waitAndClose();
    }
}
