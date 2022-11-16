package appium.Andriod.eCommerceApp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TestCase2 extends BaseTestEcom {
    @Test
    public void tc02() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Zeeshan");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = list.size();
        Double totalsum = 0.00;
        for (int i = 0; i < count; i++) {
            String price = list.get(i).getText();
//            it will give $160.90
            Double formatedPrice = getFormattedPrice(price);
//            we are making it 160.90 by making substring starting from 1 index.
            totalsum = totalsum + formatedPrice;
        }

        String mobileAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedAmount = getFormattedPrice(mobileAmount);
        Assert.assertEquals(displayFormattedAmount, totalsum);

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        String alertTxt = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(alertTxt, "Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
        Set<String> contexts = driver.getContextHandles();

        for (String contextName : contexts) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("nisum.com");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.context("NATIVE_APP");
    }
}
