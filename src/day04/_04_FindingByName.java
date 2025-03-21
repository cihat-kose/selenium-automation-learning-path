package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.MyFunction;

public class _04_FindingByName {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353");

        // 1)- Find text boxes with name and last name then fill in your first and last name
        // 2)- Find and click the button with name

        WebElement firstName = driver.findElement(By.name("q8_name[first]")); // find by name
        firstName.sendKeys("Kerem");

        WebElement lastName = driver.findElement(By.name("q8_name[last]")); // find by name
        lastName.sendKeys("Said");

        WebElement submitButton = driver.findElement(By.id("input_2"));
        submitButton.click();

        MyFunction.wait(5);
        driver.quit();
    }
}
