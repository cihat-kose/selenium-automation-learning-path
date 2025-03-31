package day11;

import utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _06_WaitsDemoExample extends BaseDriver {

    /**
     * Task: Implementing Explicit Wait and Interacting with Elements
     *
     * 1. Navigate to the website: "https://www.hyrtutorials.com/p/waits-demo.html".
     * 2. Click on the first button with the id "btn1". This button will trigger the appearance of a text box.
     * 3. Use Explicit Wait (WebDriverWait) to wait until the text box with the id "txt1" becomes visible.
     * 4. Once the text box appears, enter your first name (e.g., "Ismet") into the text box.
     * 5. Bonus Step for Fast Finishers:
     *    - Click on the second button to trigger the appearance of another text box.
     *    - Once it appears, enter your last name in the newly visible text box.
     * 6. Close the browser once the task is complete.
     */

    @Test
    public void explicitWaitDemoTest() {
        // Step 1: Navigate to the website
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

        List<WebElement> cookiesDecline = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/button[1]/p"));
        if (!cookiesDecline.isEmpty()) {
            cookiesDecline.get(0).click();
        }

        // Step 2: Click on the first button with id "btn1"
        WebElement firstButton = driver.findElement(By.id("btn1"));
        firstButton.click();

        // Step 3: Wait until the text box with id "txt1" is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));

        // Step 4: Enter first name into the text box after it appears
        WebElement firstNameInput = driver.findElement(By.id("txt1"));
        firstNameInput.sendKeys("Jim");

        // Step 5 (Optional): Click on the second button and enter the last name if desired.
        // Uncomment the following code to enable the bonus step.
        /*
        WebElement secondButton = driver.findElement(By.id("btn2"));
        secondButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));

        WebElement lastNameInput = driver.findElement(By.id("txt2"));
        lastNameInput.sendKeys("Burns");
        */

        // Step 6: Close the browser after the task is completed
        waitAndClose();
    }
}
