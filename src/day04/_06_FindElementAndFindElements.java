package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.MyFunction;

import java.util.List;

public class _06_FindElementAndFindElements {
    public static void main(String[] args) {
        // When you examine in the browser, # for ids and class searches. can be put.

        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353");

        // WebElement element1=driver.findElement(By.id("faultyLocator"));
        // no such element: Element not found

        List<WebElement> elementler = driver.findElements(By.id("faultyLocator"));
        System.out.println("elementler.size() = " + elementler.size());
        // findElements locator sends an empty list that does not give an error if it is incorrect

        MyFunction.wait(3);
        driver.quit();
    }
}
