package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumActions extends BaseTest {
    @Test
    public void ScreenActions() {

//      If you want app to start from specific page then you have to follow these steps:

//      adb devices
//      TO know the package and activity of your app just run this command on your terminal

//      adb shell dumpsys window | grep -E 'mCurrentFocus' => for Mac users
//      adb shell dumpsys window | find "mCurrentFocus" => for Windows users

//      terminal response:  mCurrentFocus=Window{51be4eb u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
//      packageName= io.appium.android.apis , activityName = io.appium.android.apis.preference.PreferenceDependencies

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");

        driver.startActivity(activity);
//      Now no need to write code for initial clicks that take you to the specific page, just use package & activity name and simply land on specific page
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation deviceRotation = new DeviceRotation(0, 0, 90);
        driver.rotate(deviceRotation);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText, "WiFi settings");

//      Copy & paste to clipboard
        driver.setClipboardText("Hafiz Zeeshan");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.findElement(By.id("android:id/button1")).click();
    }
}
