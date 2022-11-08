package appium.eCommerceApp;

import appium.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTestEcom {
    @Test
    public void tc1() throws InterruptedException {

//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Zeeshan");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.findElement(By.id("android:id/text1")).click();
//        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Pakistan\"))")));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Pakistan']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);

        String toastMessage =  driver.findElement(By.xpath("//(android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
