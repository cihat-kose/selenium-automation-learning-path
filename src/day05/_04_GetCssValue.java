package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class _04_GetCssValue extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com/");
        WebElement inputValEnter = driver.findElement(By.id("inputValEnter"));

        // GetAttribute : Parameters and values
        System.out.println("inputValEnter.getAttribute(autocomplete) = " + inputValEnter.getAttribute("autocomplete"));
        System.out.println("inputValEnter.getAttribute(name) = " + inputValEnter.getAttribute("name"));
        System.out.println("inputValEnter.getAttribute(type) = " + inputValEnter.getAttribute("type"));
        System.out.println("inputValEnter.getAttribute(class) = " + inputValEnter.getAttribute("class"));
        System.out.println("inputValEnter.getAttribute(placeholder) = " + inputValEnter.getAttribute("placeholder"));

        // GetCssValue is used to get CSS-Shaping values that correspond to Class
        System.out.println("inputValEnter.getCssValue(color) = " + inputValEnter.getCssValue("color"));
        System.out.println("inputValEnter.getCssValue(font-size) = " + inputValEnter.getCssValue("font-size"));
        System.out.println("inputValEnter.getCssValue(background) = " + inputValEnter.getCssValue("background"));
        System.out.println("inputValEnter.getCssValue(font-family) = " + inputValEnter.getCssValue("font-family"));
        System.out.println("inputValEnter.getCssValue(border) = " + inputValEnter.getCssValue("border"));
        System.out.println("inputValEnter.getCssValue(height) = " + inputValEnter.getCssValue("height"));

        waitAndClose();
    }
}
