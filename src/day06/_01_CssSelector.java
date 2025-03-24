package day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class _01_CssSelector extends BaseDriver {

    /**
     * 1- Open https://formsmarts.com/form/yu?mode=h5
     * 2- Checked the Business.
     * 3- Click on discover XYZ and select Online Advertising
     * 4- Choose every day
     * 5- Choose good
     * 6- Click using XYZ and choose option 3
     * Css selector
     * Put MyFunction.wait(2); between each click vs action
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
