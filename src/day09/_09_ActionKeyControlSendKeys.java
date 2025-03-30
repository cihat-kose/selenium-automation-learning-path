package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

public class _09_ActionKeyControlSendKeys extends BaseDriver {

    @Test
    public void test() {
        driver.get("https://demoqa.com/auto-complete");

//        List<WebElement> consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
//        if (!consent.isEmpty()) {
//            consent.get(0).click();
//        }

        MyFunction.wait(3);
        WebElement textBox = driver.findElement(By.id("autoCompleteMultipleContainer"));

        new Actions(driver)
                .moveToElement(textBox)  // come to the box
                .click()                       // click
                .keyDown(Keys.SHIFT)      // press shift
                .sendKeys("k")          // send letter "k"; due to a shift with a capital K write-in
                .keyUp(Keys.SHIFT)        // let go of shift
                .sendKeys("erem")       // "erem" send remaining name
                .build()                      // prepare the action
                .perform();                   // perform the operation.

        waitAndClose();
    }
}
