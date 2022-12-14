package POM;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {

    //    AppiumDriver => IOSDriver/AndroidDriver
    AppiumDriver driver;

    public AppiumUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public Double getFormattedPrice(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    public void waitForElementToAppear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }
}
