package appium.Andriod.eCommerceApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrowserTest extends BrowserBaseTestEcom {
    @Test
    public void browserTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("nisum.com");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
}
