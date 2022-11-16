package appium.IOS;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void basics(){

        // Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    }
}
