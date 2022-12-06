package POM.ios;

import POM.ios.utils.IOSActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class HomePage extends IOSActions {
    IOSDriver driver;

    public HomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //    driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Alert Views'`]")).click();
    By alertViews = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Alert Views'`]");

    public AlertViews selectAlertViews() {
        driver.findElement(alertViews).click();
        return new AlertViews(driver);
    }
}
