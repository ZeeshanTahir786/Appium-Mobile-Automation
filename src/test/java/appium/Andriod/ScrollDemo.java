package appium.Andriod;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {
    @Test
    public void scrollDemoTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

//      this method is used when scroll is known : it uses the Google engine
        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))")));

//      When scroll is not known : It's appium official method
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while ((canScrollMore));
    }
}
