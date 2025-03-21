package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.MyFunction;

import java.util.List;

public class _05_FindingByClassName {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");

//        WebElement firstName=driver.findElement(By.className("form-textbox")); // find by classname
//        If findElement finds more than one element in the same locator, it returns the first one
//        firstName.sendKeys("Kerem");

        // Reaching multiple elements according to a certain criterion
        List<WebElement> labels = driver.findElements(By.className("sf-dod-mpQGL"));
        for (WebElement element : labels) {
            System.out.println("element.getText() = " + element.getText());
        }

        // findElement fails to find element                   : no such element
        // What does findElements do if it can't find elements ?  Returns a List with 0 elements and does not give an error
        List<WebElement> labels2 = driver.findElements(By.className("sf-dod-12345"));
        System.out.println("labels2.size() = " + labels2.size());

        MyFunction.wait(5);
        driver.quit();
    }
}
