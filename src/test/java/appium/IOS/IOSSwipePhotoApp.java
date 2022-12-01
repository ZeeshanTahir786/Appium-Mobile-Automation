package appium.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSSwipePhotoApp extends IOSBaseTest {

    @Test
    public void photoApp() {
        Map<String, String> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", params);

        List<WebElement> elem = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(elem.size());
        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();

        for (int i = 0; i < elem.size(); i++) {
            String picName = driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name");
            System.out.println(picName);
            Map<String, Object> params1 = new HashMap<>();
            params1.put("direction", "left");
            driver.executeScript("mobile:swipe", params1);
        }
        driver.navigate().back();
    }
}
