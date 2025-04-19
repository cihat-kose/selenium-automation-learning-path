package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class _02_ActionClickTest extends BaseDriver {

    @Test
    public void actionClickTest() {
        driver.get("https://demoqa.com/buttons");

//        List<WebElement>consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
//        if (!consent.isEmpty()) {
//            consent.get(0).click();
//        }

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions actions = new Actions(driver);// Web page opened for action.

        //clickButton.click()
        Action action = actions.moveToElement(clickButton).click().build();
        // Go to click on the element, wait there, prepare the action.
        System.out.println("The action is prepared");
        MyFunction.wait(4);
        action.perform(); // The action is happening. process, apply.
        System.out.println("Action has taken place");

        // short form
        // actions.moveToElement(clickButton).click().build().perform();  // for a lot of action

        // even shorter version
        //new Actions(driver).moveToElement(clickButton).click().build().perform(); // for a single action

        // the shortest version
        //new Actions(driver).click(clickButton).build().perform(); // for a single action

        waitAndClose();
    }
}
