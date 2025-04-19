package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _04_ActionRightClickTest extends BaseDriver {

    @Test
    public void test() {
        driver.get("https://demoqa.com/buttons");

//        List<WebElement> consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
//        if (!consent.isEmpty()) {
//            consent.get(0).click();
//        }

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        MyFunction.wait(2);

        Actions actions = new Actions(driver);
        Action action = actions.contextClick(rightClickButton).build();
        action.perform();

        // short forms
        // actions.moveToElement(rightClickButton).contextClick().build().perform();
        // new Actions(driver).contextClick(rightClickButton).build().perform();

        waitAndClose();
    }
}
