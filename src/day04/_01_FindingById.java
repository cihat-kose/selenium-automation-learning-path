package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.MyFunction;

public class _01_FindingById {
    public static void main(String[] args) {
        /**
         Scenario:
         1-  Open the page --> https://form.jotform.com/221934510376353

         2-  Find the first textbox (id=first_8), give it a name eg nameBox
         3-  Send the text "Kerem" in the nameBox

         4-  Find the second textbox, give it a name eg lastNameBox
         5-  Send the text "Said" in the lastNameBox
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://form.jotform.com/221934510376353"); // I went to the page

        WebElement nameBox = driver.findElement(By.id("first_8")); // find element by id
        nameBox.sendKeys("Kerem"); // send text to boxes

        WebElement surnameBox = driver.findElement(By.id("last_8")); // find element by id
        surnameBox.sendKeys("Said"); // send text to boxes

        MyFunction.wait(5); /// For visibility only. Use WebDriverWait in real automation.
        driver.quit();
    }
}

// Pressing ctrl+f in Chrome opens the search box in the inspect section (with the inspect section active).
// If we type first_name it searches in all words
// If we type #first_name, it searches in all ID parameters.