package day08;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class _01_ElementInStatus extends BaseDriver {

    @Test
    public void verifyCheckBoxStatus() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement tuesday = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));

        System.out.println("tuesday.isDisplayed() = " + tuesday.isDisplayed()); // Does it appear on the web?
        System.out.println("tuesday.isEnabled() = " + tuesday.isEnabled());     // Is it active on the web?
        System.out.println("tuesday.isSelected() = " + tuesday.isSelected());   // Is it in check?

        tuesday.click();
        System.out.println("tuesday.isSelected() = " + tuesday.isSelected());

        WebElement saturday = driver.findElement(By.id("gwt-debug-cwCheckBox-Saturday-input"));
        System.out.println("saturday.isDisplayed() = " + saturday.isDisplayed()); // Does it appear on the web?
        System.out.println("saturday.isEnabled() = " + saturday.isEnabled());     // Is it active on the web?
        System.out.println("saturday.isSelected() = " + saturday.isSelected());   // Is it in check?

        Assert.assertTrue(saturday.isDisplayed());

        waitAndClose();
    }
}
