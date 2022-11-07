package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    AndroidDriver driver;
    AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
//        AndroidDriver, IOSDriver
//        Appium Code -> Appium Server -> Mobile

//        For running the appium server automatically
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        serviceBuilder.start();

//        Configure Android emulator
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3a XL API 33 Tiramisu");
        options.setApp("/Users/hafizzeeshan/Downloads/AppiumFirst/src/test/java/resources/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId()
                , "duration", 2000
        ));
    }

    public void scrollToTheEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while ((canScrollMore));
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        serviceBuilder.stop();
    }
}
