package appium.IOS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSBaseTest {
    public IOSDriver driver;
    public AppiumDriverLocalService serviceBuilder;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        serviceBuilder.start();


        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro");
        options.setApp("/Users/hafizzeeshan/Desktop/UIKitCatalog.app");
        options.setPlatformVersion("16.1");
//      Appium => WebDriver Agent =>  IOS Apps.
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        serviceBuilder.stop();
    }
}
