package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _03_ActionDoubleClickTest extends BaseDriver {

    @Test
    public void actionDoubleClickTest() {
        driver.get("https://demoqa.com/buttons");

//        List<WebElement> consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
//        if (!consent.isEmpty()) {
//            consent.get(0).click();
//        }

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        MyFunction.wait(2);

        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(doubleClickButton).doubleClick().build();
        action.perform();

        waitAndClose();

        // short forms
        // --> actions.doubleClick(doubleClickButton).build().perform();
        // --> new Actions(driver).doubleClick(doubleClickButton).build().perform();
    }
}
