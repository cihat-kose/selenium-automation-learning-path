package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.MyFunction;

public class _02_FindingByIdNotFoundException {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353"); // I went to the page

        try {
            WebElement nameBox = driver.findElement(By.id("faultylocator"));
        } catch (Exception exception) {
            System.out.println("Web element not found " + exception.getMessage());
        }

        MyFunction.wait(5);
        driver.quit();
    }
}
