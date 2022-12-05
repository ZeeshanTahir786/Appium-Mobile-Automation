package POM.ios.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {

    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement ele) {
        Map<String, Object> params = new HashMap<>();

        params.put("elementId", ((RemoteWebElement) ele).getId());
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollToWebElement(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");
        driver.executeScript("mobile:scroll", params);
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))")));
    }

    public void swipeAction(WebElement element, String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile:swipe", params);
    }

}
