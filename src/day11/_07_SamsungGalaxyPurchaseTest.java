package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class _07_SamsungGalaxyPurchaseTest extends BaseDriver {

    /**
     * Scenario:
     * 1- Open the site https://www.demoblaze.com/index.html.
     * 2- Click on the Samsung galaxy s6 link.
     * 3- Add to cart.
     * 4- Then click on PRODUCT STORE to return to the main screen.
     * =======================================================================
     * Senaryo:
     * 1- https://www.demoblaze.com/index.html siteyi açınız.
     * 2- Samsung galaxy s6 linkine tıklayınız.
     * 3- Sepete ekleyiniz.
     * 4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönünüz.
     */

    @Test
    public void testAddSamsungToCart() {
        driver.get("https://www.demoblaze.com/index.html");

        WebElement link = driver.findElement(By.linkText("Samsung galaxy s6"));
        link.click();

        WebElement addToCart = driver.findElement(By.linkText("Add to cart"));
        addToCart.click();

        wait.until(ExpectedConditions.alertIsPresent()); // wait until alert appears
        driver.switchTo().alert().accept();

        WebElement homeLink = driver.findElement(By.id("nava"));
        homeLink.click();

        Assert.assertEquals("Homepage url not found", "https://www.demoblaze.com/index.html", driver.getCurrentUrl());

        waitAndClose();
    }
}
