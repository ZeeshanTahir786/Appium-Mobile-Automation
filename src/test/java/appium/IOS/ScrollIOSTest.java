package appium.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ScrollIOSTest extends IOSBaseTest {
    @Test
    public void scrollDemo() throws InterruptedException {
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();

        params.put("elementId", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");
        driver.executeScript("mobile:scroll", params);
        ele.click();
        Thread.sleep(2000);
//      GO BACK
        driver.findElement(AppiumBy.iOSNsPredicateString("label == \"UIKitCatalog\" AND name == \"UIKitCatalog\" AND type == \"XCUIElementTypeButton\"")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Red color component value'")).sendKeys("80");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Green color component value'")).sendKeys("220");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
        String text = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
        Assert.assertEquals(text,"105");
        Thread.sleep(2000);
    }
}
