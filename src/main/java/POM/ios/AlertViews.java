package POM.ios;

import POM.ios.utils.IOSActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class AlertViews extends IOSActions {
    IOSDriver driver;

    public AlertViews(IOSDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By alertViews = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Alert Views'`]");
    By textEntry = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]");
    By enterText = AppiumBy.iOSClassChain("**/XCUIElementTypeOther");
    By ok = AppiumBy.accessibilityId("OK");

    public void selectAlertViews() {
        driver.findElement(alertViews).click();
    }

    public void enterName(String name) {
        driver.findElement(textEntry).sendKeys(name);
    }

    public void clickOk() {
        driver.findElement(ok).click();
    }
}
