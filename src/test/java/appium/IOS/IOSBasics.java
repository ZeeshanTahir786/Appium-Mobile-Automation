package appium.IOS;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void basics() {

        // Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id
//      driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Alert Views'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther")).sendKeys("Hafiz Zeeshan");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

//        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm / Cancel'"));
//        not for case senstive
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Confirm / Cancel' AND value BEGINSWITH 'Confirm'")).click();
//        for case sensetive simply put [c] on BEGINSWITH
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Confirm'")).click();

        String txt = driver.findElement(AppiumBy.iOSNsPredicateString("label BEGINSWITH 'A message'")).getText();
        System.out.println(txt);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
    }
}
