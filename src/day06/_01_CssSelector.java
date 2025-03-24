package day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class _01_CssSelector extends BaseDriver {

/**
    Task: Fill and interact with elements on https://formsmarts.com/form/yu?mode=h5 using CSS selectors only.

    Objective:
    Practice selecting and interacting with form elements using CSS selectors.

    Steps:
    1. Navigate to https://formsmarts.com/form/yu?mode=h5
    2. Select "Business"
    3. Click on "How did you discover XYZ?" dropdown and choose "Online Advertising"
    4. Select "Every Day"
    5. Select "Good"
    6. Click on "How long have you been using XYZ?" and select the 3rd option
*/

    @Test
    public void formTest() {
        driver.get("https://formsmarts.com/form/yu?mode=h5");

        MyFunction.wait(2);
        WebElement business = driver.findElement(By.cssSelector("[type='radio'][value='Business']"));
        business.click();

        MyFunction.wait(2);
        WebElement dropDownDiscover = driver.findElement(By.cssSelector("select[id$='_4588']"));
        dropDownDiscover.click();

        MyFunction.wait(2);
        WebElement optionOnlineAdvertising = driver.findElement(By.cssSelector("[id$='_4588'] > :nth-child(4)"));
        optionOnlineAdvertising.click();

        MyFunction.wait(2);
        WebElement everyDayRadio = driver.findElement(By.cssSelector("[type='radio'][value='Every Day']"));
        everyDayRadio.click();

        MyFunction.wait(2);
        WebElement goodRadio = driver.findElement(By.cssSelector("[type='radio'][value='Good']"));
        goodRadio.click();

        MyFunction.wait(2);
        WebElement dropdownHowLong = driver.findElement(By.cssSelector("select[id$='_4597']"));
        dropdownHowLong.click();

//        option[value*='using XYZ for a month or more']
//        option[value$='using XYZ for a month or more']
//        select[id$='_4597']> :nth-child(4)

        MyFunction.wait(2);
        WebElement option3 = driver.findElement(By.cssSelector("select[id$='_4597']> :nth-child(4)"));
        option3.click();

        MyFunction.wait(2);
        goodRadio.click();

        waitAndClose();
    }
}
