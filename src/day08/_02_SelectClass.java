package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;

public class _02_SelectClass extends BaseDriver {

    @Test
    public void testSelectClassUsage() {
        driver.get("https://www.amazon.com.tr/");

        WebElement selectMenu = driver.findElement(By.id("searchDropdownBox"));

        Select dropDownMenu = new Select(selectMenu); // Converted the element into a more usable SELECT object.

        // If this element starts with a select tag, you cast it to Selenium's SELECT class and use it like that.

        // dropDownMenu.selectByIndex(4);                                         // You can choose this way : with index
        dropDownMenu.selectByValue("search-alias=computers");             // You can choose this way : with value
        // dropDownMenu.selectByVisibleText("Bilgisayarlar");                    // You can choose this way : with the visible string

        System.out.println("dropDownMenu.getOptions().size() = " + dropDownMenu.getOptions().size());
        // This is how we can see how many options the Select has.

        for (WebElement element : dropDownMenu.getOptions()) {
            System.out.print("element.getText() = " + element.getText());
            System.out.println("- value= " + element.getAttribute("value"));
        }
        waitAndClose();
    }
}