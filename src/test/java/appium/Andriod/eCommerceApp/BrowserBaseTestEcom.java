package appium.Andriod.eCommerceApp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTestEcom {
    AndroidDriver driver;
    AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void ConfigureBrowserAppium() throws MalformedURLException {
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
        options.setChromedriverExecutable("/Users/hafizzeeshan/Downloads/chromedriver");
        options.setCapability("deviceName", "Pixel 3a XL API 33 Tiramisu");
        options.setCapability("browserName", "Chrome");
        options.setCapability("automationName", "UIAutomator2");
        options.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        serviceBuilder.stop();
    }
}
