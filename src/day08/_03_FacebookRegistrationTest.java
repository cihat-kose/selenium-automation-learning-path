package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/**
    Test Case: Facebook Registration Form Automation

    Objective:
    Automate the registration process on Facebook using Selenium WebDriver.

    Steps:
    1. Navigate to https://www.facebook.com/
    2. Click on the "Create New Account" button.
    3. Enter first name, last name, and email address.
    4. Select date of birth using the Select class.
    5. Choose gender.
    6. Close the browser.
*/

public class _03_FacebookRegistrationTest extends BaseDriver {

    @Test
    public void shouldFillOutFacebookRegistrationFormSuccessfully() {

        // Step 1: Go to Facebook
        driver.get("https://www.facebook.com/");
        MyFunction.wait(1);

        // Step 1.1: Close cookie pop-up if it appears (Optional cookies)
        List<WebElement> cookiesDecline = driver.findElements(By.xpath("//*[text()='İsteğe bağlı çerezleri reddet']"));
        if (!cookiesDecline.isEmpty()) {
            cookiesDecline.get(0).click();
        }

        // Step 2: Click on "Create New Account"
        MyFunction.wait(1);
        WebElement createAccount = driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']"));
        createAccount.click();

        // Step 3: Fill in the name, surname and email fields
        MyFunction.wait(1);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Kerem");

        MyFunction.wait(1);
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Said");

        MyFunction.wait(1);
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("keremsaidr@gxmail.com");

        // Step 4: Select birth date using Select class
        WebElement dayDropdown = driver.findElement(By.id("day"));
        WebElement monthDropdown = driver.findElement(By.id("month"));
        WebElement yearDropdown = driver.findElement(By.id("year"));

        Select day = new Select(dayDropdown);
        Select month = new Select(monthDropdown);
        Select year = new Select(yearDropdown);

        day.selectByVisibleText("21");
        month.selectByValue("3"); // April (0-indexed)
        year.selectByVisibleText("1975");

        // Step 5: Select gender as Male
        WebElement maleRadio = driver.findElement(By.xpath("(//input[@id='sex'])[2]"));
        maleRadio.click();

        // Step 6: Close the browser
        waitAndClose();
    }
}
