package appium.Andriod;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {
    @Test
    public void AppiumTest() {
//       Appium support only these locators:
//       Xpath, id, accessibilityId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Hafiz Zeeshan");

        String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText,"WiFi settings");
        driver.findElement(By.id("android:id/button1")).click();
        driver.quit();
        serviceBuilder.stop();
    }
}
