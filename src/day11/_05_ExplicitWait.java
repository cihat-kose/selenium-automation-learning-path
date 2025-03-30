package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class _05_ExplicitWait extends BaseDriver {

    // ExplicitWait
    @Test
    public void testExplicitWaitForTextVisibility() {
        // Element exists but situations where I have to wait until it is clickable
        // Element exists, but it is not in a position to send text into it
        // Wait for the alert to appear
        // Wait until the URL is what you expect
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='timedText()']"));
        button.click();

        // Wait until the text is "Web Driver"
        // In this case, it is necessary to give special criteria to the element.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Defined once
        // Just like duration, only time and driver were defined.
        // wait.until(ExpectedConditions.textToBe(By.id("demo"), "WebDriver"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
        // visibilityOfElementLocated : WAIT until this locator appears.

        WebElement message = driver.findElement(By.id("demo"));
        System.out.println("message.getText() = " + message.getText());

        waitAndClose();
    }

    /**

     Interview Question: Implicit and Explicit

     Implicit: It is valid for all elements; defined once. (Is there a locator given in HTML?)
     Explicit: It is defined as a criterion specific to a single element and is valid only for the relevant element

     If both are defined, whose duration is used?
     Implicit is used first, with the duration of Explicit added to it
     the total error limit time (delay limit) will appear.

     ===================****************************************======================================

     Mülakat Sorusu : Implicit ve Explicit

     Implicit: Bütün elemanlar için geçerli olup; bir kere tanımlanır. (HTML de verilen locator var mı?)
     Explicit: Tek bir elemana özel kriter olarak tanımlanır ve sadece ilgili elemanda geçerli olur.

     Her ikisi de tanımlı ise hangisinin süresi kullanılır ?
     Önce Implicit kullanılır ve üzerine Explicit'in süresi eklenerek
     toplam hata sınırı süresi (mühlet sınırı) ortaya çıkmış olur.

     */
}
