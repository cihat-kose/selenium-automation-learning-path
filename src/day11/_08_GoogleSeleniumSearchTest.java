package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

public class _08_GoogleSeleniumSearchTest extends BaseDriver {

    /**
     * Scenario:
     * https://google.com/ search for the word selenium.
     * Click on the first result (Selenium)
     * Print the resulting URL on the screen.
     * Verify that the expected url is https://www.selenium.dev/
     */

    @Test
    public void testGoogleSearchForSelenium() {
        driver.get("https://www.google.com/");
        MyFunction.wait(2);

        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium" + Keys.ENTER); // \n \r  gibi

//        WebElement searchButton=driver.findElement(By.name("btnK"));
//        searchButton.click();

        ////a[@href="https://www.selenium.dev/"]     [href='https://www.selenium.dev/'] css
        WebElement seleniumLink = driver.findElement(By.xpath("//cite[text()='https://www.selenium.dev']"));
        seleniumLink.click();

        wait.until(ExpectedConditions.urlToBe("https://www.selenium.dev/")); // titleContains("Selenium")

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Assert.assertEquals("The page could not be reached.", "https://www.selenium.dev/", driver.getCurrentUrl());  //https://www.selenium.dev/

        waitAndClose();
    }
}
