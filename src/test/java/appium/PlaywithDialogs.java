package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaywithDialogs extends BaseTest {
    @Test
    public void dialogs() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
        Assert.assertTrue(driver.findElement(By.id("android:id/button1")).isDisplayed());
        driver.findElement(By.id("android:id/button1")).click();


        driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }
}
